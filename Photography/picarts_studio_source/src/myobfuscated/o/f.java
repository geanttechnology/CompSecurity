// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.o;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

final class f
{

    static final Charset a = Charset.forName("US-ASCII");

    static void a(Closeable closeable)
    {
        try
        {
            closeable.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Closeable closeable)
        {
            throw closeable;
        }
        // Misplaced declaration of an exception variable
        catch (Closeable closeable)
        {
            return;
        }
    }

    static void a(File file)
    {
        File afile[] = file.listFiles();
        if (afile == null)
        {
            throw new IOException((new StringBuilder("not a readable directory: ")).append(file).toString());
        }
        int j = afile.length;
        for (int i = 0; i < j; i++)
        {
            file = afile[i];
            if (file.isDirectory())
            {
                a(file);
            }
            if (!file.delete())
            {
                throw new IOException((new StringBuilder("failed to delete file: ")).append(file).toString());
            }
        }

    }

    static 
    {
        Charset.forName("UTF-8");
    }
}
