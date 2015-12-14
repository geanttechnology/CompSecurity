// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.model.parsers;

import com.socialin.android.util.e;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

// Referenced classes of package com.socialin.android.apiv3.model.parsers:
//            IStreamParser

public class StringParser
    implements IStreamParser
{

    private static final String defaultEncoding;
    private static StringParser instance;
    private final String encoding;

    private StringParser(String s)
    {
        encoding = s;
    }

    public static StringParser instance()
    {
        com/socialin/android/apiv3/model/parsers/StringParser;
        JVM INSTR monitorenter ;
        StringParser stringparser;
        if (instance == null)
        {
            instance = new StringParser(defaultEncoding);
        }
        stringparser = instance;
        com/socialin/android/apiv3/model/parsers/StringParser;
        JVM INSTR monitorexit ;
        return stringparser;
        Exception exception;
        exception;
        throw exception;
    }

    public volatile Object parse(InputStream inputstream)
    {
        return parse(inputstream);
    }

    public String parse(InputStream inputstream)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        byte abyte0[] = new byte[8192];
        do
        {
            int i = inputstream.read(abyte0, 0, 8192);
            if (i != -1)
            {
                bytearrayoutputstream.write(abyte0, 0, i);
            } else
            {
                return new String(bytearrayoutputstream.toByteArray(), encoding);
            }
        } while (true);
    }

    static 
    {
        defaultEncoding = e.a.name();
    }
}
