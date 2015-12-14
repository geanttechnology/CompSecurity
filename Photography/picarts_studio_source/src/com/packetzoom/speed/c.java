// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.packetzoom.speed;


final class c extends Enum
{

    public static final c a_com_packetzoom_speed_c_static_fld;
    private static final c a_com_packetzoom_speed_c_array1d_static_fld[];
    public static final c b;
    public static final c c;
    public static final c d;
    public static final c e;
    public static final c f;

    private c(String s, int i)
    {
        super(s, i);
    }

    public static c valueOf(String s)
    {
        return (c)Enum.valueOf(com/packetzoom/speed/c, s);
    }

    public static c[] values()
    {
        return (c[])a_com_packetzoom_speed_c_array1d_static_fld.clone();
    }

    static 
    {
        a_com_packetzoom_speed_c_static_fld = new c("kPZEnded", 0);
        b = new c("kPZTimedOut", 1);
        c = new c("kPZRemoved", 2);
        d = new c("kPZCanceled", 3);
        e = new c("kPZFailed", 4);
        f = new c("kPZAbandoned", 5);
        a_com_packetzoom_speed_c_array1d_static_fld = (new c[] {
            a_com_packetzoom_speed_c_static_fld, b, c, d, e, f
        });
    }
}
