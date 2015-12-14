// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.packetzoom.speed;


final class m extends Enum
{

    public static final m a_com_packetzoom_speed_m_static_fld;
    private static final m a_com_packetzoom_speed_m_array1d_static_fld[];
    public static final m b;
    public static final m c;

    private m(String s, int i)
    {
        super(s, i);
    }

    public static m valueOf(String s)
    {
        return (m)Enum.valueOf(com/packetzoom/speed/m, s);
    }

    public static m[] values()
    {
        return (m[])a_com_packetzoom_speed_m_array1d_static_fld.clone();
    }

    static 
    {
        a_com_packetzoom_speed_m_static_fld = new m("BOTH", 0);
        b = new m("PZ", 1);
        c = new m("NONPZ", 2);
        a_com_packetzoom_speed_m_array1d_static_fld = (new m[] {
            a_com_packetzoom_speed_m_static_fld, b, c
        });
    }
}
