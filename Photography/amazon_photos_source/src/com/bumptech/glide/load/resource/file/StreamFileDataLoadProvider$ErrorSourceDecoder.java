// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.file;

import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.bumptech.glide.load.resource.file:
//            StreamFileDataLoadProvider

private static class <init>
    implements ResourceDecoder
{

    public Resource decode(InputStream inputstream, int i, int j)
    {
        throw new Error("You cannot decode a File from an InputStream by default, try either #diskCacheStratey(DiskCacheStrategy.SOURCE) to avoid this call or #decoder(ResourceDecoder) to replace this Decoder");
    }

    public volatile Resource decode(Object obj, int i, int j)
        throws IOException
    {
        return decode((InputStream)obj, i, j);
    }

    public String getId()
    {
        return "";
    }

    private Y()
    {
    }

    Y(Y y)
    {
        this();
    }
}
