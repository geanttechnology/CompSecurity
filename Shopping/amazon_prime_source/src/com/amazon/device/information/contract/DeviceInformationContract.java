// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.information.contract;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DeviceInformationContract
{
    public static final class DeviceInfo
        implements DeviceInfoColumns
    {

        public static final List COLUMN_LIST;
        public static final String CONTENT_DIRECTORY = "device_info";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.com.amazon.device.information.provider.device_info";
        public static final Uri CONTENT_URI;

        static 
        {
            CONTENT_URI = Uri.withAppendedPath(DeviceInformationContract.AUTHORITY_URI, "device_info");
            ArrayList arraylist = new ArrayList();
            arraylist.add("device_type");
            arraylist.add("dsn");
            COLUMN_LIST = Collections.unmodifiableList(arraylist);
        }

        private DeviceInfo()
        {
        }
    }

    public static interface DeviceInfoColumns
    {

        public static final String DEVICE_TYPE = "device_type";
        public static final String DSN = "dsn";
    }


    public static final String AUTHORITY = "com.amazon.device.information.provider";
    public static final Uri AUTHORITY_URI = Uri.parse("content://com.amazon.device.information.provider");
    public static final String PACKAGE_NAME = "com.amazon.device.information.provider";

    private DeviceInformationContract()
    {
    }

}
