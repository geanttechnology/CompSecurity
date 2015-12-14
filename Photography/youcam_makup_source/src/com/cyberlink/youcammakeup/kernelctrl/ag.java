// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.n;
import com.pf.common.utility.m;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ag extends n
{

    private static String a = "ThumbnailWorker";
    private Context b;

    public ag(Context context)
    {
        super(context);
        b = context;
    }

    protected Bitmap a(Object obj, boolean flag)
    {
        obj = String.valueOf(obj);
        if (((String) (obj)).indexOf("assets://") != 0)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        obj = b.getAssets().open(((String) (obj)).substring("assets://".length()));
_L1:
        Bitmap bitmap;
        obj = new BufferedInputStream(((java.io.InputStream) (obj)));
        bitmap = BitmapFactory.decodeStream(((java.io.InputStream) (obj)));
        ((BufferedInputStream) (obj)).close();
        return bitmap;
        obj = new FileInputStream(((String) (obj)));
          goto _L1
        obj;
        ((IOException) (obj)).printStackTrace();
_L3:
        return null;
        obj;
        m.d(a, "processBitmap(), error.");
        if (true) goto _L3; else goto _L2
_L2:
    }

    public void a(Object obj, ImageView imageview, Object obj1)
    {
        super.a(obj, imageview, obj1);
    }

    public void a(String s, ImageView imageview)
    {
        a(s, imageview, Boolean.valueOf(false));
    }

}
