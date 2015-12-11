// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fanhattan.services.remote.api;


public final class RemoteServiceHelper
{
    public static final class Events
    {

        public static final int RAW_CANCEL = 4;
        public static final int RAW_MOTION = 2;
        public static final int RAW_PRESS = 1;
        public static final int RAW_RELEASE = 3;

        private Events()
        {
            throw new IllegalAccessError();
        }
    }


    public static final String INTENT_ACTION = "remote";
    public static final int REMOTE_ID_BLUETOOTH = 0;
    public static final int REMOTE_ID_WIFI = 1;
    public static final String SERVICE_CLASS_NAME = "com.fanhattan.services.FanhattanService";
    public static final String SERVICE_PCK = "com.fanhattan.services";

    private RemoteServiceHelper()
    {
        throw new IllegalAccessError();
    }
}
