// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.github.ignition.support.cache;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

// Referenced classes of package com.github.ignition.support.cache:
//            AbstractImageCache

public class DecodedImageCache extends AbstractImageCache
{

    private final android.graphics.BitmapFactory.Options bitmapOptions = new android.graphics.BitmapFactory.Options();

    public DecodedImageCache(int i, int j, long l, int k)
    {
        super("DecodedImageCache", i, j, l, k);
        initBitmapOptions();
    }

    private void initBitmapOptions()
    {
        bitmapOptions.inPurgeable = true;
        bitmapOptions.inInputShareable = true;
        bitmapOptions.inPreferredConfig = android.graphics.Bitmap.Config.RGB_565;
    }

    public Bitmap decodeToBitmap(Bitmap bitmap)
    {
        return bitmap;
    }

    public volatile Bitmap decodeToBitmap(Object obj)
    {
        return decodeToBitmap((Bitmap)obj);
    }

    public Bitmap getBitmap(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        obj = (Bitmap)super.get(obj);
        this;
        JVM INSTR monitorexit ;
        return ((Bitmap) (obj));
        obj;
        throw obj;
    }

    public Bitmap getBitmapFromMemory(String s)
    {
        this;
        JVM INSTR monitorenter ;
        s = (Bitmap)super.getFromMemory(s);
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    protected Bitmap parse(byte abyte0[])
    {
        if (abyte0 == null)
        {
            return null;
        } else
        {
            return BitmapFactory.decodeByteArray(abyte0, 0, abyte0.length, bitmapOptions);
        }
    }

    protected volatile Object parse(Object obj)
    {
        return parse((byte[])obj);
    }
}
