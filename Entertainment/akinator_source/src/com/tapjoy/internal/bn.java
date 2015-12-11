// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

// Referenced classes of package com.tapjoy.internal:
//            ar, dd, de

public final class bn
{

    public static String a(File file)
    {
        try
        {
            file = a(file, ar.c);
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            return null;
        }
        return file;
    }

    public static String a(File file, Charset charset)
    {
        file = new FileInputStream(file);
        charset = dd.a(new InputStreamReader(file, charset));
        de.a(file);
        return charset;
        charset;
        de.a(file);
        throw charset;
    }

    public static void a(File file, String s)
    {
        file = new FileOutputStream(file);
        a(((OutputStream) (file)), s);
        de.a(file);
        return;
        s;
        de.a(file);
        throw s;
    }

    public static void a(OutputStream outputstream, String s)
    {
        outputstream = new OutputStreamWriter(outputstream, ar.c);
        outputstream.write(s);
        outputstream.flush();
    }
}
