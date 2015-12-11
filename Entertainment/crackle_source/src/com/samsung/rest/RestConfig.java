// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.samsung.rest;


public class RestConfig
{

    public static final String BASE_URL = "http://IP_ADDRESS:PORT/ws/app";
    public static final int BUNDLE_ACTION_CLEAR_CANVAS = 7002;
    public static final int BUNDLE_ACTION_CONNECT = 7000;
    public static final int BUNDLE_ACTION_DISCONNECT = 7003;
    public static final int BUNDLE_ACTION_DRAW_LINE = 7001;
    public static final String INTENTACTION_START_APP = "START_APP";
    public static final String INTENTACTION_UPDATE_DEVICE_LIST = "UPDATE_DEVICE_LIST";
    public static final int INTENTCOMMAND_START_APP = 2001;
    public static final String INTENTDATA_DEVICE_LIST = "DEVICE_LIST";
    public static final int MSG_CLEAR_CANVAS = 6001;
    public static final int MSG_DISCONNECT = 6002;
    public static final int MSG_DRAW_LINE = 6000;
    public static final String REST_HEADER_CONNECTION_MODE = "BLUEBIRD_CONNECTION_MODE";
    public static final String REST_HEADER_DEVICE_ID = "SLDeviceID";
    public static final String REST_HEADER_DEVICE_NAME = "DeviceName";
    public static final String REST_HEADER_PRODUCT_ID = "ProductID";
    public static final String REST_HEADER_USER_AGENT = "User-Agent";
    public static final String REST_HEADER_VENDOR_ID = "VendorID";
    public static final int REST_REQUEST_ACTION_CONNECT = 9001;
    public static final int REST_REQUEST_ACTION_DISCONNECT = 9004;
    public static final int REST_REQUEST_ACTION_GET_DATA = 9003;
    public static final int REST_REQUEST_ACTION_GET_INFO = 9005;
    public static final int REST_REQUEST_ACTION_LAUNCH_APP = 9006;
    public static final int REST_REQUEST_ACTION_POST_DATA = 9002;
    public static final String REST_URL_CONNECT = "http://IP_ADDRESS:PORT/ws/app/WIDGET_ID/connect";
    public static final String REST_URL_DISCONNECT = "http://IP_ADDRESS:PORT/ws/app/WIDGET_ID/disconnect";
    public static final String REST_URL_GET = "http://IP_ADDRESS:PORT/ws/app/WIDGET_ID/queue/device/DEVICE_ID";
    public static final String REST_URL_INFO = "http://IP_ADDRESS:PORT/ws/app/WIDGET_ID/info";
    public static final String REST_URL_LAUNCH_APP = "http://IP_ADDRESS:PORT/ws/app/WIDGET_ID";
    public static final String REST_URL_POST = "http://IP_ADDRESS:PORT/ws/app/WIDGET_ID/queue";
    public static final String REST_WIDGET_ID = "interactivity_Button_label";
    public static final int RESULT_CODE_UPDATE_DEVICE_LIST = 1001;
    public static final int WHAT_DEVICE_CONNECTED = 2003;
    public static final int WHAT_DEVICE_DISCONNECTED = 2004;
    public static final int WHAT_UPDATE_DEVICE_LIST = 2002;

    public RestConfig()
    {
    }
}
