// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flow.android.engine.library.constants;


public final class ConnectionType extends Enum
{

    private static final ConnectionType $VALUES[];
    public static final ConnectionType CELL_25G;
    public static final ConnectionType CELL_2G;
    public static final ConnectionType CELL_3G;
    public static final ConnectionType CELL_4G;
    public static final ConnectionType UNKNOWN;
    public static final ConnectionType WIFI;
    private final String networkName;
    private final int networkSubTypeGroup[];
    private final String networkType;

    private ConnectionType(String s, int i, String s1, String s2, int ai[])
    {
        super(s, i);
        networkSubTypeGroup = ai;
        networkName = s1;
        networkType = s2;
    }

    public static ConnectionType findGroupByTypeSubtypeId(int i, int j)
    {
        if (i != 1) goto _L2; else goto _L1
_L1:
        ConnectionType connectiontype = WIFI;
        ConnectionType connectiontype1;
        ConnectionType aconnectiontype[];
        int ai[];
        int k;
        int l;
        int i1;
        return connectiontype;
        continue; /* Loop/switch isn't completed */
        i++;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static ConnectionType valueOf(String s)
    {
        return (ConnectionType)Enum.valueOf(com/flow/android/engine/library/constants/ConnectionType, s);
    }

    public static ConnectionType[] values()
    {
        return (ConnectionType[])$VALUES.clone();
    }

    public String getNetworkName()
    {
        return networkName;
    }

    public String getNetworkType()
    {
        return networkType;
    }

    static 
    {
        UNKNOWN = new ConnectionType("UNKNOWN", 0, "Unknown", null, null);
        WIFI = new ConnectionType("WIFI", 1, "wifi", null, null);
        CELL_2G = new ConnectionType("CELL_2G", 2, "cellular", "2G", new int[] {
            1, 4, 7
        });
        CELL_25G = new ConnectionType("CELL_25G", 3, "cellular", "2.5G", new int[] {
            2
        });
        CELL_3G = new ConnectionType("CELL_3G", 4, "cellular", "3G", new int[] {
            14, 8, 9, 3, 5, 6, 12
        });
        CELL_4G = new ConnectionType("CELL_4G", 5, "cellular", "4G", new int[] {
            13
        });
        $VALUES = (new ConnectionType[] {
            UNKNOWN, WIFI, CELL_2G, CELL_25G, CELL_3G, CELL_4G
        });
    }
}
