// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a;

import java.io.InputStream;

class l
{

    public InputStream a;
    public String b;
    public String c;

    public l(InputStream inputstream, String s, String s1)
    {
        a = inputstream;
        b = s;
        c = s1;
    }

    public String a()
    {
        if (b != null)
        {
            return b;
        } else
        {
            return "nofilename";
        }
    }
}
