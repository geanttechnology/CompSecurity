// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.gifbitmap;

import com.bumptech.glide.load.resource.bitmap.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.bumptech.glide.load.resource.gifbitmap:
//            GifBitmapWrapperResourceDecoder

static class 
{

    public com.bumptech.glide.load.resource.bitmap.er parse(InputStream inputstream)
        throws IOException
    {
        return (new ImageHeaderParser(inputstream)).getType();
    }

    ()
    {
    }
}
