// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.flurry.sdk:
//            gx

public class ck
    implements gx
{

    public ck()
    {
    }

    public Bitmap a(InputStream inputstream)
    {
        if (inputstream == null)
        {
            return null;
        } else
        {
            return BitmapFactory.decodeStream(inputstream);
        }
    }

    public void a(OutputStream outputstream, Bitmap bitmap)
    {
        if (outputstream == null || bitmap == null)
        {
            return;
        } else
        {
            throw new UnsupportedOperationException("Serialization for bitmaps is not yet implemented");
        }
    }

    public volatile void a(OutputStream outputstream, Object obj)
    {
        a(outputstream, (Bitmap)obj);
    }

    public Object b(InputStream inputstream)
    {
        return a(inputstream);
    }
}
