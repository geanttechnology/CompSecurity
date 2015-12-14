// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.packetzoom.speed;


public final class i extends Enum
{

    public static final i a_com_packetzoom_speed_i_static_fld;
    private static final i a_com_packetzoom_speed_i_array1d_static_fld[];
    public static final i b;

    private i(String s, int j)
    {
        super(s, j);
    }

    public static i valueOf(String s)
    {
        return (i)Enum.valueOf(com/packetzoom/speed/i, s);
    }

    public static i[] values()
    {
        return (i[])a_com_packetzoom_speed_i_array1d_static_fld.clone();
    }

    static 
    {
        a_com_packetzoom_speed_i_static_fld = new i("background", 0);
        b = new i("foreground", 1);
        a_com_packetzoom_speed_i_array1d_static_fld = (new i[] {
            a_com_packetzoom_speed_i_static_fld, b
        });
    }
}
