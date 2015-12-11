// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.http;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.StringReader;
import org.cybergarage.util.Debug;

public class HTTPHeader
{

    private static int MAX_LENGTH = 1024;
    private String name;
    private String value;

    public HTTPHeader(String s)
    {
        setName("");
        setValue("");
        int i;
        if (s != null)
        {
            if ((i = s.indexOf(':')) >= 0)
            {
                String s1 = new String(s.getBytes(), 0, i);
                s = new String(s.getBytes(), i + 1, s.length() - i - 1);
                setName(s1.trim());
                setValue(s.trim());
                return;
            }
        }
    }

    public HTTPHeader(String s, String s1)
    {
        setName(s);
        setValue(s1);
    }

    public static final int getIntegerValue(String s, String s1)
    {
        int i;
        try
        {
            i = Integer.parseInt(getValue(s, s1));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return 0;
        }
        return i;
    }

    public static final int getIntegerValue(byte abyte0[], String s)
    {
        int i;
        try
        {
            i = Integer.parseInt(getValue(abyte0, s));
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            return 0;
        }
        return i;
    }

    public static final String getValue(LineNumberReader linenumberreader, String s)
    {
        String s1 = s.toUpperCase();
        int i;
        try
        {
            s = linenumberreader.readLine();
        }
        // Misplaced declaration of an exception variable
        catch (LineNumberReader linenumberreader)
        {
            Debug.warning(linenumberreader);
            return "";
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        i = s.length();
        if (i > 0)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        return "";
label0:
        {
            s = new HTTPHeader(s);
            if (s.hasName())
            {
                break label0;
            }
            s = linenumberreader.readLine();
        }
        break MISSING_BLOCK_LABEL_10;
label1:
        {
            if (s.getName().toUpperCase().equals(s1))
            {
                break label1;
            }
            s = linenumberreader.readLine();
        }
        break MISSING_BLOCK_LABEL_10;
        linenumberreader = s.getValue();
        return linenumberreader;
    }

    public static final String getValue(String s, String s1)
    {
        return getValue(new LineNumberReader(new StringReader(s), Math.min(s.length(), MAX_LENGTH)), s1);
    }

    public static final String getValue(byte abyte0[], String s)
    {
        return getValue(new String(abyte0), s);
    }

    public String getName()
    {
        return name;
    }

    public String getValue()
    {
        return value;
    }

    public boolean hasName()
    {
        return name != null && name.length() > 0;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setValue(String s)
    {
        value = s;
    }

}
