// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.file;

import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.File;
import java.io.IOException;

// Referenced classes of package com.bumptech.glide.load.resource.file:
//            FileResource

public class FileDecoder
    implements ResourceDecoder
{

    public FileDecoder()
    {
    }

    public Resource decode(File file, int i, int j)
    {
        return new FileResource(file);
    }

    public volatile Resource decode(Object obj, int i, int j)
        throws IOException
    {
        return decode((File)obj, i, j);
    }

    public String getId()
    {
        return "";
    }
}
