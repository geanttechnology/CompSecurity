// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.ab;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.UUID;

class ABFilePreference extends ABSettingsFactory.ABSettingsManager
{

    final String uuid;

    ABFilePreference(Context context)
        throws IOException
    {
        uuid = generate(context);
    }

    private String createFile(File file)
        throws IOException
    {
        String s = generateNew().toString();
        file.createNewFile();
        file = new FileOutputStream(file);
        file.write(s.getBytes());
        file.flush();
        file.close();
        return s;
    }

    private String generate(Context context)
        throws IOException
    {
        context = new File(context.getFilesDir(), "ab");
        if (!context.exists())
        {
            context.mkdir();
        }
        context = new File(context, ".alpha-beta");
        if (!context.exists())
        {
            return createFile(context);
        } else
        {
            return readFile(context);
        }
    }

    private String readFile(File file)
        throws IOException
    {
        file = new FileInputStream(file);
        String s = readStream(file);
        file.close();
        return s;
    }

    private String readStream(InputStream inputstream)
        throws IOException
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (inputstream = new Scanner(inputstream); inputstream.hasNextLine(); stringbuilder.append(inputstream.nextLine())) { }
        return stringbuilder.toString();
    }

    public String getUUID()
    {
        return uuid;
    }
}
