// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

// Referenced classes of package org.cybergarage.util:
//            StringUtil, Debug

public final class FileUtil
{

    public FileUtil()
    {
    }

    public static final boolean isXMLFileName(String s)
    {
        if (!StringUtil.hasData(s))
        {
            return false;
        } else
        {
            return s.toLowerCase().endsWith("xml");
        }
    }

    public static final byte[] load(File file)
    {
        try
        {
            file = load(new FileInputStream(file));
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            Debug.warning(file);
            return new byte[0];
        }
        return file;
    }

    public static final byte[] load(FileInputStream fileinputstream)
    {
        byte abyte0[] = new byte[0x80000];
        ByteArrayOutputStream bytearrayoutputstream;
        int i;
        try
        {
            bytearrayoutputstream = new ByteArrayOutputStream();
            i = fileinputstream.read(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (FileInputStream fileinputstream)
        {
            Debug.warning(fileinputstream);
            return new byte[0];
        }
        if (i > 0)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        fileinputstream.close();
        return bytearrayoutputstream.toByteArray();
        bytearrayoutputstream.write(abyte0, 0, i);
        i = fileinputstream.read(abyte0);
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_19;
        }
    }

    public static final byte[] load(String s)
    {
        try
        {
            s = load(new FileInputStream(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Debug.warning(s);
            return new byte[0];
        }
        return s;
    }
}
