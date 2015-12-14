// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.packetzoom.speed;


final class d extends Enum
{

    public static final d a_com_packetzoom_speed_d_static_fld;
    private static final d a_com_packetzoom_speed_d_array1d_static_fld[];
    public static final d b;

    private d(String s, int i)
    {
        super(s, i);
    }

    public static d valueOf(String s)
    {
        return (d)Enum.valueOf(com/packetzoom/speed/d, s);
    }

    public static d[] values()
    {
        return (d[])a_com_packetzoom_speed_d_array1d_static_fld.clone();
    }

    static 
    {
        a_com_packetzoom_speed_d_static_fld = new d("READY", 0);
        b = new d("COMPLETE", 1);
        a_com_packetzoom_speed_d_array1d_static_fld = (new d[] {
            a_com_packetzoom_speed_d_static_fld, b
        });
    }
}
