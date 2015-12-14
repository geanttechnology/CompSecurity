// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;

// Referenced classes of package com.bumptech.glide.gifdecoder:
//            GifDecoder

public static interface 
{

    public abstract Bitmap obtain(int i, int j, android.graphics.tmapProvider tmapprovider);

    public abstract void release(Bitmap bitmap);
}
