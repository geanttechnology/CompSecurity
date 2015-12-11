// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.file;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

// Referenced classes of package com.flurry.org.apache.avro.file:
//            SeekableInput

public class SeekableFileInput extends FileInputStream
    implements SeekableInput
{

    public SeekableFileInput(File file)
        throws IOException
    {
        super(file);
    }

    public SeekableFileInput(FileDescriptor filedescriptor)
        throws IOException
    {
        super(filedescriptor);
    }

    public long length()
        throws IOException
    {
        return getChannel().size();
    }

    public void seek(long l)
        throws IOException
    {
        getChannel().position(l);
    }

    public long tell()
        throws IOException
    {
        return getChannel().position();
    }
}
