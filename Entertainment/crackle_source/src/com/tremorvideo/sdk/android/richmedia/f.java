// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Display;
import android.view.WindowManager;
import com.tremorvideo.sdk.android.videoad.ad;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia:
//            i

public class f
    implements i
{
    class a
    {

        final int a;
        final f b;

        public Bitmap a(byte abyte0[])
        {
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inScaled = false;
            options.inDensity = 0;
            options.inSampleSize = a;
            options.inPurgeable = true;
            options.inInputShareable = true;
            abyte0 = BitmapFactory.decodeByteArray(abyte0, 0, abyte0.length, options);
            abyte0.setDensity(0);
            return abyte0;
        }

        a(int j)
        {
            b = f.this;
            a = j;
            super();
        }
    }


    Context a;

    public f(Context context)
    {
        a = context;
    }

    public int a(int j, int k)
    {
        Display display = ((WindowManager)a.getSystemService("window")).getDefaultDisplay();
        int l = display.getWidth();
        int i1 = display.getHeight();
        return (int)Math.min(3F, Math.max(1.0F, Math.min((float)j / (float)l, (float)k / (float)i1)));
    }

    public Bitmap a(byte abyte0[], int j)
    {
        if (abyte0 == null)
        {
            return null;
        }
        if (ad.q() < 4)
        {
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inSampleSize = j;
            return BitmapFactory.decodeByteArray(abyte0, 0, abyte0.length, options);
        } else
        {
            return (new a(j)).a(abyte0);
        }
    }
}
