// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia:
//            f

class a
{

    final int a;
    final f b;

    public Bitmap a(byte abyte0[])
    {
        android.graphics.apFactory.Options options = new android.graphics.apFactory.Options();
        options.inScaled = false;
        options.inDensity = 0;
        options.inSampleSize = a;
        options.inPurgeable = true;
        options.inInputShareable = true;
        abyte0 = BitmapFactory.decodeByteArray(abyte0, 0, abyte0.length, options);
        abyte0.setDensity(0);
        return abyte0;
    }

    (f f1, int i)
    {
        b = f1;
        a = i;
        super();
    }
}
