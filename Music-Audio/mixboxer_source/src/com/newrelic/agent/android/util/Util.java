// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Util
{

    public Util()
    {
    }

    public static String slurp(InputStream inputstream)
        throws IOException
    {
        char ac[] = new char[8192];
        StringBuilder stringbuilder = new StringBuilder();
        inputstream = new BufferedReader(new InputStreamReader(inputstream));
        do
        {
            int i = inputstream.read(ac);
            if (i < 0)
            {
                return stringbuilder.toString();
            }
            stringbuilder.append(ac, 0, i);
        } while (true);
    }
}
