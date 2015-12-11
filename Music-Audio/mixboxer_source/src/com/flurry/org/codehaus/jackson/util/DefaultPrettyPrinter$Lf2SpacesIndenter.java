// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.util;

import com.flurry.org.codehaus.jackson.JsonGenerationException;
import com.flurry.org.codehaus.jackson.JsonGenerator;
import com.flurry.org.codehaus.jackson.impl.Indenter;
import java.io.IOException;
import java.util.Arrays;

// Referenced classes of package com.flurry.org.codehaus.jackson.util:
//            DefaultPrettyPrinter

public static class Q
    implements Indenter
{

    static final char SPACES[];
    static final int SPACE_COUNT = 64;
    static final String SYSTEM_LINE_SEPARATOR;

    public boolean isInline()
    {
        return false;
    }

    public void writeIndentation(JsonGenerator jsongenerator, int i)
        throws IOException, JsonGenerationException
    {
        jsongenerator.writeRaw(SYSTEM_LINE_SEPARATOR);
        for (i += i; i > 64; i -= SPACES.length)
        {
            jsongenerator.writeRaw(SPACES, 0, 64);
        }

        jsongenerator.writeRaw(SPACES, 0, i);
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
        SYSTEM_LINE_SEPARATOR = s2;
        SPACES = new char[64];
        Arrays.fill(SPACES, ' ');
        return;
        Throwable throwable;
        throwable;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public Q()
    {
    }
}
