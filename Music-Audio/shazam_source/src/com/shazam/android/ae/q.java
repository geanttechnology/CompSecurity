// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ae;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

final class q
{

    static String a(String s, Throwable throwable)
    {
        StringBuilder stringbuilder = new StringBuilder();
        boolean flag;
        if (s == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            s = "";
        }
        stringbuilder = stringbuilder.append(s);
        if (throwable instanceof UnknownHostException)
        {
            s = new StringBuilder("\n");
            StringWriter stringwriter = new StringWriter();
            throwable.printStackTrace(new PrintWriter(stringwriter));
            s = s.append(stringwriter.toString()).toString();
        } else
        {
            s = "";
        }
        return stringbuilder.append(s).toString();
    }
}
