// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.igexin.sdk;

import android.os.Environment;

public class Consts
{
    public static final class ActionPrepareState extends Enum
    {

        private static final ActionPrepareState $VALUES[];
        public static final ActionPrepareState stop;
        public static final ActionPrepareState success;
        public static final ActionPrepareState wait;

        public static ActionPrepareState valueOf(String s)
        {
            return (ActionPrepareState)Enum.valueOf(com/igexin/sdk/Consts$ActionPrepareState, s);
        }

        public static ActionPrepareState[] values()
        {
            return (ActionPrepareState[])$VALUES.clone();
        }

        static 
        {
            success = new ActionPrepareState("success", 0);
            wait = new ActionPrepareState("wait", 1);
            stop = new ActionPrepareState("stop", 2);
            $VALUES = (new ActionPrepareState[] {
                success, wait, stop
            });
        }

        private ActionPrepareState(String s, int i)
        {
            super(s, i);
        }
    }


    public static String DB_NAME = "slavesdk.db";
    public static int DB_VERSION = 1;
    public static final String IMGPATHDIR = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/Sdk/ImgCache/").toString();
    public static int MESSAGE_RECEIVER_INTERNAL = 0;
    public static String PS_SUB_URL;
    public static String PS_URL;
    public static String VPUSH_APPID = "";
    public static String VPUSH_APPKEY = "";
    public static String VPUSH_APPSECRET = "";

    public Consts()
    {
    }

    static 
    {
        PS_SUB_URL = "/api.php?format=json";
        PS_URL = (new StringBuilder()).append("http://sdk.slave.phone.igexin.com").append(PS_SUB_URL).toString();
    }
}
