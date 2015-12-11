// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appsflyer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class g
{
    public static class a
    {

        private String a;
        private long b;

        public a(String s)
        {
            a = s;
            b = (new Date()).getTime();
        }
    }


    private static g b = new g();
    List a;

    private g()
    {
        a = new ArrayList();
    }

    public static g a()
    {
        return b;
    }

    public void a(String s)
    {
        a.add(new a(s));
    }

}
