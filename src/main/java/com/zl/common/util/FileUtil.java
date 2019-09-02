package com.zl.common.util;

import org.apache.commons.io.IOUtils;

import javax.imageio.stream.FileImageOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author zl
 * @Version 1.0
 * @Description TODO
 * @date 2019/01/16  10:08
 */
public class FileUtil {
    public static void writeToFile(String filePath, InputStream inputStream) throws IOException {
        isExist(filePath);
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(IOUtils.toByteArray(inputStream));
        fos.close();
    }

    public static void writeToFileImage(String filePath, byte[] data) throws IOException {
        if (null == data || data.length < 1 || StringUtil.isEmpty(filePath)) { return; }
        isExist(filePath);
        File file = new File(filePath);
        FileImageOutputStream fios = new FileImageOutputStream(file);
        fios.write(data, 0, data.length);
        fios.flush();
        fios.close();
    }

    /**
     * 是否创建目录
     *
     * @param filePath
     * @return
     */
    public static boolean isExist(String filePath) {
        String paths[] = filePath.split(File.separator);
        String dir = paths[0];
        for (int i = 0; i < paths.length - 2; i++) {//注意此处循环的长度
            try {
                dir = dir + "/" + paths[i + 1];
                File dirFile = new File(dir);
                if (!dirFile.exists()) {
                    dirFile.mkdir();
                }
            } catch (Exception err) {
            }
        }
        File fp = new File(filePath);
        if (!fp.exists()) {
            return true; // 文件不存在，执行下载功能
        } else {
            return false; // 文件存在不做处理
        }
    }
}
