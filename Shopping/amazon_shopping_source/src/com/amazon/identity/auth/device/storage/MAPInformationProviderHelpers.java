// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.net.Uri;
import java.util.Arrays;
import java.util.List;

public final class MAPInformationProviderHelpers
{

    public static final String ACCOUNTS_PATH = "/accounts";
    public static final String ALL_DATA_PATH = "/all_data";
    public static final String ALL_DELETED_DATA_PATH = "/all_deleted_data";
    public static final String BULK_DATA_PATH = "/bulk_data";
    public static final String COLUMN_QUERY_VALUE = "value";
    public static final String DEVICE_DATA_PATH = "/device_data";
    public static final String GENERATE_COMMON_INFO_PATH = "/generate_common_info";
    public static final String KEY_BULK_DATA = "bulk_data";
    public static final String KEY_CURRENT_DEVICE_TYPE = "current_device_type";
    public static final String KEY_DELETED = "deleted_key";
    public static final String KEY_DEVICE_DATA_KEY = "device_data_key";
    public static final String KEY_DEVICE_DATA_VALUE = "device_data_value";
    public static final String KEY_DIRECTED_ID = "directedId";
    public static final String KEY_DIRTY = "dirty_key";
    public static final String KEY_DISPLAY_NAME = "display_name";
    public static final String KEY_DSN_OVERRIDE = "dsn_override";
    public static final String KEY_KEY = "key";
    public static final String KEY_MAP_BRAZIL_VERSION = "map_brazil_version";
    public static final String KEY_MAP_INIT_VERSION = "map_init_version";
    public static final String KEY_MAP_MAJOR_VERSION = "map_major_version";
    public static final String KEY_MAP_MINOR_VERSION = "map_minor_version";
    public static final String KEY_MAP_SW_VERSION = "map_sw_version";
    public static final String KEY_NAMESPACE = "namespace";
    public static final String KEY_TIMESTAMP = "timestamp_key";
    public static final String KEY_TOKEN_ACCOUNT = "token_account";
    public static final String KEY_TOKEN_KEY = "token_key";
    public static final String KEY_TOKEN_VALUE = "token_value";
    public static final String KEY_USER_DATA_ACCOUNT = "userdata_account";
    public static final String KEY_USER_DATA_BUNDLE = "userdata_bundle_key";
    public static final String KEY_USER_DATA_KEY = "userdata_key";
    public static final String KEY_USER_DATA_VALUE = "userdata_value";
    public static final String KEY_VALUE = "value";
    public static final String MAP_INFO_PATH = "/map_info";
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
        "map_major_version", "map_minor_version", "current_device_type", "dsn_override", "map_sw_version", "map_init_version"
    });
    public static final String TOKENS_PATH = "/tokens";
    public static final String USER_DATA_PATH = "/userdata";

    private MAPInformationProviderHelpers()
    {
    }

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
