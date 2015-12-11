// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream.a;

import android.content.Context;
import android.graphics.Bitmap;
import com.google.c.b.b;
import com.google.c.c;
import com.google.c.e;
import com.google.c.h;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.EnumMap;
import java.util.Map;

public class a
{

    private static final int BLACK = 0xff000000;
    private static final String TAG = "CachingBarcodeFactory";
    private static final int WHITE = -1;
    private static boolean mWasCleaned = false;
    private static final Map sEncodeHints;
    private final com.google.c.a mBarcodeFormat;
    private final android.graphics.Bitmap.CompressFormat mCompressFormat;
    private final int mEncodeQuality;
    private final int mHeightPx;
    private final File mParentDir;
    private final int mWidthPx;

    public a(com.target.a.a.a a1, com.google.c.a a2, int i, int j, android.graphics.Bitmap.CompressFormat compressformat, int k)
    {
        mParentDir = new File(a1.a().getCacheDir(), "barcodes");
        mBarcodeFormat = a2;
        mWidthPx = i;
        mHeightPx = j;
        mCompressFormat = compressformat;
        mEncodeQuality = k;
    }

    private void a()
    {
        if (!mWasCleaned)
        {
            mWasCleaned = true;
            if (!mParentDir.exists())
            {
                mParentDir.mkdir();
            }
            File afile[] = mParentDir.listFiles();
            int j = afile.length;
            int i = 0;
            while (i < j) 
            {
                afile[i].delete();
                i++;
            }
        }
    }

    private boolean a(Bitmap bitmap, File file)
    {
        try
        {
            file = new FileOutputStream(file);
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            return false;
        }
        return bitmap.compress(mCompressFormat, mEncodeQuality, file);
    }

    private Bitmap b(String s)
        throws h
    {
        Object obj = (new e()).a(s, mBarcodeFormat, mWidthPx, mHeightPx, sEncodeHints);
        int l = ((b) (obj)).b();
        int i1 = ((b) (obj)).c();
        s = new int[l * i1];
        for (int i = 0; i < i1; i++)
        {
            int j = 0;
            while (j < l) 
            {
                int k;
                if (((b) (obj)).a(j, i))
                {
                    k = 0xff000000;
                } else
                {
                    k = -1;
                }
                s[i * l + j] = k;
                j++;
            }
        }

        obj = Bitmap.createBitmap(l, i1, android.graphics.Bitmap.Config.RGB_565);
        ((Bitmap) (obj)).setPixels(s, 0, l, 0, 0, l, i1);
        return ((Bitmap) (obj));
    }

    public com.google.a.a.e a(String s)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj1;
        a();
        String s1 = String.format("barcode_%s_%s.png", new Object[] {
            mBarcodeFormat, s
        });
        obj1 = new File(mParentDir, s1);
        if (!((File) (obj1)).exists()) goto _L2; else goto _L1
_L1:
        Object obj = com.google.a.a.e.b(obj1);
_L6:
        this;
        JVM INSTR monitorexit ;
        return ((com.google.a.a.e) (obj));
_L2:
        s = b(s);
        obj = s;
        if (!a(((Bitmap) (s)), ((File) (obj1)))) goto _L4; else goto _L3
_L3:
        obj = s;
        obj1 = com.google.a.a.e.c(obj1);
_L7:
        obj = obj1;
        if (s == null) goto _L6; else goto _L5
_L5:
        s.recycle();
        obj = obj1;
          goto _L6
        s;
        throw s;
_L4:
        obj = s;
        obj1 = com.google.a.a.e.e();
          goto _L7
        s;
        s = null;
_L10:
        obj = s;
        com.target.a.a.b.a("CachingBarcodeFactory", "Error writing ");
        obj = s;
        obj1 = com.google.a.a.e.e();
        obj = obj1;
        if (s == null) goto _L6; else goto _L8
_L8:
        s.recycle();
        obj = obj1;
          goto _L6
_L9:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_150;
        }
        ((Bitmap) (obj)).recycle();
        throw s;
        s;
          goto _L9
        obj;
          goto _L10
        s;
        obj = null;
          goto _L9
    }

    static 
    {
        sEncodeHints = new EnumMap(com/google/c/c);
        sEncodeHints.put(c.b, "UTF-8");
    }
}
