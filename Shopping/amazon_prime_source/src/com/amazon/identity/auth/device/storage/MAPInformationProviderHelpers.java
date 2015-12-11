// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.net.Uri;
import java.util.Arrays;
import java.util.List;

public final class MAPInformationProviderHelpers
{

    public static final List QUERY_BULK_DATA_COLUMNS = Arrays.asList(new String[] {
        "directedId", "namespace", "userdata_account", "token_account", "display_name", "userdata_key", "userdata_value", "token_key", "token_value", "device_data_key", 
        "device_data_value", "timestamp_key", "deleted_key", "dirty_key"
    });
    public static final String QUERY_COLUMNS[] = {
        "value"
    };
    public static final String QUERY_COMMON_INFO_COLUMNS[] = {
        "key", "value", "namespace"
    };
    public static final List QUERY_MAP_INFO_COLUMNS = Arrays.asList(new String[] {
        "map_major_version", "map_minor_version", "current_device_type", "dsn_override", "map_sw_version", "map_init_version", "map_brazil_version"
    });

    public static Uri generateCommonInfoUri(String s)
    {
        return getUri(s, "/generate_common_info");
    }

    public static Uri getAccountUri(String s)
    {
        return getUri(s, "/accounts");
    }

    public static Uri getAllDataUri(String s)
    {
        return getUri(s, "/all_data");
    }

    public static Uri getAllDeletedDataUri(String s)
    {
        return getUri(s, "/all_deleted_data");
    }

    public static Uri getBulkDataUri(String s)
    {
        return getUri(s, "/bulk_data");
    }

    public static Uri getDeviceDataUri(String s)
    {
        return getUri(s, "/device_data");
    }

    public static Uri getMapVersionInfoUri(String s)
    {
        return getUri(s, "/map_info");
    }

    public static Uri getTokensUri(String s)
    {
        return getUri(s, "/tokens");
    }

    private static Uri getUri(String s, String s1)
    {
        return Uri.parse(String.format("content://%s%s", new Object[] {
            s, s1
        }));
    }

    public static Uri getUserdataUri(String s)
    {
        return getUri(s, "/userdata");
    }

}
