// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.JsonGenerator;
import java.util.Arrays;

public class _lf extends _lf
{

    static final char SPACES[];
    private static final String SYS_LF;
    public static final <init> instance;
    protected final String _lf;

    public boolean isInline()
    {
        return false;
    }

    public void writeIndentation(JsonGenerator jsongenerator, int i)
    {
        jsongenerator.writeRaw(_lf);
        if (i > 0)
        {
            for (i += i; i > 64; i -= SPACES.length)
            {
                jsongenerator.writeRaw(SPACES, 0, 64);
            }

            jsongenerator.writeRaw(SPACES, 0, i);
        }
    }

    static 
    {
        String s = null;
        String s1 = System.getProperty("line.separator");
        s = s1;
_L2:
        String s2 = s;
        if (s == null)
        {
            s2 = "\n";
        }
        SYS_LF = s2;
        SPACES = new char[64];
        Arrays.fill(SPACES, ' ');
        instance = new <init>();
        return;
        Throwable throwable;
        throwable;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public ()
    {
        this(SYS_LF);
    }

    public SYS_LF(String s)
    {
        _lf = s;
    }
}
