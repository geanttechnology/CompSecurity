// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class Util
{

    private static final Random random = new Random();

    public Util()
    {
    }

    public static Random getRandom()
    {
        return random;
    }

    public static String sanitizeUrl(String s)
    {
        if (s == null)
        {
            return null;
        }
        StringBuffer stringbuffer;
        try
        {
            s = new URL(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        stringbuffer = new StringBuffer();
        stringbuffer.append(s.getProtocol());
        stringbuffer.append("://");
        stringbuffer.append(s.getHost());
        if (s.getPort() != -1)
        {
            stringbuffer.append(":");
            stringbuffer.append(s.getPort());
        }
        stringbuffer.append(s.getPath());
        return stringbuffer.toString();
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
