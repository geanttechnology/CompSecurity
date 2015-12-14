// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.gifbitmap;

import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.InputStream;

// Referenced classes of package com.bumptech.glide.load.resource.gifbitmap:
//            GifBitmapWrapperResourceDecoder

static class 
{

    public InputStream build(InputStream inputstream, byte abyte0[])
    {
        return new RecyclableBufferedInputStream(inputstream, abyte0);
    }

    ()
    {
    }
}
