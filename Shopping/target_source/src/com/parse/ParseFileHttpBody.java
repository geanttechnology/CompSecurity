// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import com.parse.http.ParseHttpBody;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.parse:
//            ParseIOUtils

class ParseFileHttpBody extends ParseHttpBody
{

    final File file;

    public ParseFileHttpBody(File file1)
    {
        this(file1, null);
    }

    public ParseFileHttpBody(File file1, String s)
    {
        super(s, file1.length());
        file = file1;
    }

    public InputStream getContent()
        throws IOException
    {
        return new FileInputStream(file);
    }

    public void writeTo(OutputStream outputstream)
        throws IOException
    {
        FileInputStream fileinputstream;
        if (outputstream == null)
        {
            throw new IllegalArgumentException("Output stream can not be null");
        }
        fileinputstream = new FileInputStream(file);
        ParseIOUtils.copy(fileinputstream, outputstream);
        ParseIOUtils.closeQuietly(fileinputstream);
        return;
        outputstream;
        ParseIOUtils.closeQuietly(fileinputstream);
        throw outputstream;
    }
}
