// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.database.impl.provider;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Date;

// Referenced classes of package com.penthera.virtuososdk.database.impl.provider:
//            RegistryInstance

public class SettingsInstance extends RegistryInstance
{

    private static final String LOG_TAG = com/penthera/virtuososdk/database/impl/provider/SettingsInstance.getName();
    private final double DEFAULT_BT = 1.0D;
    private final long DEFAULT_CELL = 0L;
    private final String DEFAULT_DP = "/";
    private final int DEFAULT_FRAGMENT_NOTIFICATION_RATE = 10;
    private final long DEFAULT_HEADROOM = 0x6400000L;
    private final long DEFAULT_MAX_STORAGE = 0x6400000L;
    private final long SEVEN_DAYS = 0x93a80L;
    private int iFragmentNotificationRate;

    public SettingsInstance(ContentResolver contentresolver, String s)
    {
        super(contentresolver, s);
        iFragmentNotificationRate = 10;
        if (get("registration_status") == null)
        {
            set("registration_status", "1");
        }
        if (get("last_authentication") == null)
        {
            set("last_authentication", "-1");
        }
        if (get("last_sync") == null)
        {
            if (get("battery_threshold") == null)
            {
                set("battery_threshold", "1.0");
            }
            if (get("cell_data_quota") == null)
            {
                set("cell_data_quota", "0");
            }
            if (get("headroom") == null)
            {
                set("headroom", "104857600");
            }
            if (get("max_storage") == null)
            {
                set("max_storage", "104857600");
            }
            if (get("destination_path") == null)
            {
                set("destination_path", "/");
            }
            if (get("client_configuration_conn_to") == null)
            {
                set("client_configuration_conn_to", (new StringBuilder()).append(-1).toString());
            }
            if (get("client_configuration_socket_to") == null)
            {
                set("client_configuration_socket_to", (new StringBuilder()).append(-1).toString());
            }
        }
        if (get("default_configuration_fragment_rate") == null)
        {
            set("default_configuration_fragment_rate", "10");
        }
        if (get("client_configuration_fragment_rate") != null)
        {
            iFragmentNotificationRate = Integer.parseInt(get("client_configuration_fragment_rate"));
        }
        if (get("cell_quota_start_date") == null)
        {
            set("cell_quota_start_date", (new StringBuilder()).append((new Date()).getTime() / 1000L).toString());
        }
        if (get("cell_quota_used") == null)
        {
            set("cell_quota_used", "0");
        }
        if (get("downloader_init_state") == null)
        {
            set("downloader_init_state", (new StringBuilder()).append(com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Idle.ordinal()).toString());
        }
    }

    public String get(String s, boolean flag)
    {
        Object obj = null;
        String s1 = obj;
        if (flag)
        {
            if ("battery_threshold".equals(s))
            {
                s1 = get("battery_threshold_override");
            } else
            if ("cell_data_quota".equals(s))
            {
                s1 = get("cell_data_quota_override");
            } else
            if ("destination_path".equals(s))
            {
                s1 = get("destination_path_override");
            } else
            if ("headroom".equals(s))
            {
                s1 = get("headroom_override");
            } else
            if ("max_storage".equals(s))
            {
                s1 = get("max_storage_override");
            } else
            {
                s1 = obj;
                if ("default_configuration_fragment_rate".equals(s))
                {
                    s1 = get("client_configuration_fragment_rate");
                }
            }
        }
        if (!TextUtils.isEmpty(s1))
        {
            return s1;
        } else
        {
            return get(s);
        }
    }

    public Bundle getBundle()
    {
        Cursor cursor;
        Cursor cursor1;
        Object obj;
        Bundle bundle;
        obj = Registry.RegistryColumns.CONTENT_URI(iAuthority);
        cursor1 = null;
        cursor = null;
        bundle = new Bundle();
        obj = resolver.query(((android.net.Uri) (obj)), new String[] {
            "name", "value"
        }, "name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=?", new String[] {
            "client_configuration_socket_to", "client_configuration_fragment_rate", "default_configuration_fragment_rate", "client_configuration_conn_to", "root_destination_path", "client_configuration_headers", "destination_path", "max_storage", "headroom", "cell_data_quota", 
            "battery_threshold", "headroom_override", "max_storage_override", "cell_data_quota_override", "battery_threshold_override", "destination_path_override", "registration_status", "last_authentication", "downloader_init_state", "cell_quota_used", 
            "cell_quota_start_date"
        }, null);
        if (obj == null) goto _L2; else goto _L1
_L1:
        cursor = ((Cursor) (obj));
        cursor1 = ((Cursor) (obj));
        ((Cursor) (obj)).moveToFirst();
_L7:
        cursor = ((Cursor) (obj));
        cursor1 = ((Cursor) (obj));
        boolean flag = ((Cursor) (obj)).isAfterLast();
        if (!flag) goto _L3; else goto _L2
_L2:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
_L5:
        return bundle;
_L3:
        cursor = ((Cursor) (obj));
        cursor1 = ((Cursor) (obj));
        bundle.putString(((Cursor) (obj)).getString(0), ((Cursor) (obj)).getString(1));
        cursor = ((Cursor) (obj));
        cursor1 = ((Cursor) (obj));
        ((Cursor) (obj)).moveToNext();
        continue; /* Loop/switch isn't completed */
        Exception exception1;
        exception1;
        cursor1 = cursor;
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, "Registry getBundle exception: ", exception1);
        if (cursor == null) goto _L5; else goto _L4
_L4:
        cursor.close();
        return bundle;
        Exception exception;
        exception;
        if (cursor1 != null)
        {
            cursor1.close();
        }
        throw exception;
        if (true) goto _L7; else goto _L6
_L6:
    }

}
