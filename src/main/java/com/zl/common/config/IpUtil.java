package com.zl.common.config;


import java.net.*;
import java.util.Enumeration;

/**
 * @author ZL @朱林</a>
 * @Version 1.0
 * @Description TODO
 * @date 2019/09/02  11:04
 */
public class IpUtil {
    public static String getLinuxLocalIpString() {
        try {
            Enumeration allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = (NetworkInterface)allNetInterfaces.nextElement();
                System.out.println(netInterface.getName());
                Enumeration addresses = netInterface.getInetAddresses();

                while (addresses.hasMoreElements()) {
                    ip = (InetAddress)addresses.nextElement();
                    System.out.println(ip.toString());
                    if (ip != null && ip instanceof Inet4Address) {
                        return ip.getHostAddress();
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getWindowsLocalIpString() {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            return ip.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getLocalIpString() {
        if (SystemUtil.getOSName().contains("Windows")) {
            return getWindowsLocalIpString();
        } else {
            return getLinuxLocalIpString();

        }
    }

    public static void main(String[] args) {
        String ip = getLocalIpString();
        System.out.println("local ip is:" + ip);
    }
}
