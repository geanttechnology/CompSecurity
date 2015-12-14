// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.packetzoom.speed;


// Referenced classes of package com.packetzoom.speed:
//            d, c

public class b
{

    byte a_byte_fld;
    int a_int_fld;
    long a_long_fld;
    c a_com_packetzoom_speed_c_fld;
    private d a_com_packetzoom_speed_d_fld;
    String a_java_lang_String_fld;
    boolean a_boolean_fld;
    int b_int_fld;
    long b_long_fld;
    String b_java_lang_String_fld;
    long c;

    public b(String s)
    {
        a_java_lang_String_fld = s;
        b_java_lang_String_fld = "GET";
        a_com_packetzoom_speed_d_fld = d.a;
        c = System.currentTimeMillis();
    }

    public void a()
    {
        if (b_long_fld == 0L)
        {
            b_long_fld = System.currentTimeMillis();
        }
    }

    public void a(String s)
    {
        b_java_lang_String_fld = s;
    }

    public boolean a()
    {
        return a_com_packetzoom_speed_d_fld == d.b;
    }

    public void b()
    {
        a_com_packetzoom_speed_c_fld = c.d;
        a_com_packetzoom_speed_d_fld = d.b;
    }

    public boolean b()
    {
        return b_java_lang_String_fld.equalsIgnoreCase("GET");
    }

    public void c()
    {
        a_com_packetzoom_speed_d_fld = d.b;
    }
}
