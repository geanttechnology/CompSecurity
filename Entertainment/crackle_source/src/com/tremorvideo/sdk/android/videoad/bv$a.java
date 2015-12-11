// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.io.File;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            bv, ad

class 
{

    public Bitmap a(File file)
    {
        ((WindowManager)ad.v().getSystemService("window")).getDefaultDisplay().getMetrics(new DisplayMetrics());
        Object obj = new android.graphics.pFactory.Options();
        obj.inScaled = false;
        obj.inPurgeable = true;
        obj = BitmapFactory.decodeFile(file.getAbsolutePath(), ((android.graphics.pFactory.Options) (obj)));
        file = ((File) (obj));
        if (ad.J() < 1.0F)
        {
            file = Bitmap.createScaledBitmap(((Bitmap) (obj)), Math.max(1, Math.round((float)((Bitmap) (obj)).getWidth() * ad.J())), Math.max(1, Math.round((float)((Bitmap) (obj)).getHeight() * ad.J())), true);
        }
        return file;
    }

    ()
    {
    }
}
