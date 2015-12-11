// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.b;


public final class a extends Enum
{

    public static final a a;
    public static final a b;
    public static final a c;
    public static final a d;
    private static a f;
    private static final a h[];
    final String e;
    private final int g;

    private a(String s, int i, int j, String s1)
    {
        super(s, i);
        g = j;
        e = s1;
    }

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/gimbal/internal/proximity/core/b/a, s);
    }

    public static a[] values()
    {
        return (a[])h.clone();
    }

    public final String toString()
    {
        return (new StringBuilder()).append(g).append(": ").append(e).toString();
    }

    static 
    {
        f = new a("PROXIMITY_INTERNAL_UNKNOWN_TYPE", 0, 0, "Internal Unknown Type.");
        a = new a("PROXIMITY_INTERNAL_JSONIFY_ERROR", 1, 3000, "Unable to convert object to JSON");
        b = new a("PROXIMITY_INTERNAL_JSON_PARSE_ERROR", 2, 3001, "Unable to parse object from JSON");
        c = new a("PROXIMITY_INTERNAL_BLE_ADV_INVALID", 3, 5001, "Scan Record is not valid Advertisement Data");
        d = new a("PROXIMITY_INTERNAL_BLE_ADV_NON_QC", 4, 5002, "Advertisement Data is not from Proximity Beacon");
        h = (new a[] {
            f, a, b, c, d
        });
    }
}
