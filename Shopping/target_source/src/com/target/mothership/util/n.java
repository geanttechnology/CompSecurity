// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

public class n
{

    public static String a(InputStream inputstream)
        throws IOException
    {
        Object obj;
        char ac[];
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        obj = new StringWriter();
        ac = new char[1024];
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(inputstream, "UTF-8"));
_L1:
        int i = bufferedreader.read(ac);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        ((Writer) (obj)).write(ac, 0, i);
          goto _L1
        obj;
        inputstream.close();
        throw obj;
        inputstream.close();
        return obj.toString();
        return "";
    }
}
