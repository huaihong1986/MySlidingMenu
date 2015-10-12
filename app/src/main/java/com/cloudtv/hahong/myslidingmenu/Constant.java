package com.cloudtv.hahong.myslidingmenu;

public class Constant {
    public final static String OFFLINE_SERVICE_PATH = "com.ngblab.tvathandphone.tvifirbranch.XMPPService.OffLineService";
    public final static String PACKAGE_NAME = "com.ngblab.tvathandphone.tvifirbranch";
    public static final String Tvportal_URL = "http://tvportal.cloudtv.ocn.net.cn/scsp/interface";// "http://10.27.69.107/scsp/interface";
    public static String HOST_NAME = "epgdata.cloudtv.ocn.net.cn";// "10.27.69.111";
//	public static final String CloudTviCategory_URL = "http://211.144.83.147:9000/column";
//	public static final String TELEPLAY_SERIES_URL = "http://211.144.83.147:9000/tvseries:";
//	public static final String CloudTviADNUM_URL = "http://211.144.83.147:9000/adnum";
//	public static  String CloudTviCategory_URL = "http://211.144.83.147:9000/column";
//	public static  String TELEPLAY_SERIES_URL = "http://211.144.83.147:9000/tvseries:";
//	public static  String CloudTviADNUM_URL = "http://211.144.83.147:9000/adnum";

    public static String BASE_IP = "27.115.50.133:8082";
    public static String CloudTviCategory_URL = "http://" + BASE_IP + "/simple/info/column.json";//"/column";
    public static String TELEPLAY_SERIES_URL = "http://" + BASE_IP + "/simple/info/tvseries:";//"/tvseries:";
    public static String CloudTviADNUM_URL = "http://" + BASE_IP +"/simple/info/adnum.json"; //"/adnum";


    public static void setBase_Ip(String ip) {
        BASE_IP = ip;
        CloudTviCategory_URL = "http://" + BASE_IP + "/simple/info/column.json";//"/column";
        TELEPLAY_SERIES_URL = "http://" + BASE_IP + "/simple/info/tvseries:";//"/tvseries:";
        CloudTviADNUM_URL = "http://" + BASE_IP +"/simple/info/adnum.json";
    }

    public void setCloudTviCategory_URL(String url) {
        CloudTviCategory_URL = url;
    }

    public void setTELEPLAY_SERIES_URL(String url) {
        TELEPLAY_SERIES_URL = url;
    }

    public void setCloudTviADNUM_URL(String url) {
        CloudTviADNUM_URL = url;
    }
}