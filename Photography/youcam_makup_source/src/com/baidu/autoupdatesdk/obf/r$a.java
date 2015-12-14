// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import java.io.InputStream;

class c
{

    public InputStream a;
    public String b;
    public String c;

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

    public (InputStream inputstream, String s, String s1)
    {
        a = inputstream;
        b = s;
        c = s1;
    }
}
