// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import android.widget.ImageView;
import com.mopub.common.c.a;

public final class af extends AsyncTask
{

    private final MediaMetadataRetriever a;
    private final ImageView b;
    private int c;
    private Bitmap d;
    private Bitmap e;

    public af(MediaMetadataRetriever mediametadataretriever, ImageView imageview, int i)
    {
        a = mediametadataretriever;
        b = imageview;
        c = i;
    }

    private transient Boolean a(String as[])
    {
        int ai[];
        int i;
        int l;
        int i1;
        if (android.os.Build.VERSION.SDK_INT >= 10)
        {
            if (as == null || as.length == 0 || as[0] == null)
            {
                return Boolean.valueOf(false);
            }
            as = as[0];
            try
            {
                a.setDataSource(as);
                d = a.getFrameAtTime(c * 1000, 3);
                if (d == null)
                {
                    return Boolean.valueOf(false);
                }
                as = d;
                l = as.getWidth();
                i1 = as.getHeight();
                ai = new int[l * i1];
                as.getPixels(ai, 0, l, 0, 0, l, i1);
            }
            // Misplaced declaration of an exception variable
            catch (String as[])
            {
                com.mopub.common.c.a.b("Failed to blur last video frame", as);
                return Boolean.valueOf(false);
            }
            i = 4;
        } else
        {
            return Boolean.valueOf(false);
        }
          goto _L1
_L5:
        i /= 2;
          goto _L1
_L3:
        as.setPixels(ai, 0, l, 0, 0, l, i1);
        e = as;
        return Boolean.valueOf(true);
_L1:
        if (i <= 0) goto _L3; else goto _L2
_L2:
        int j = i;
        while (j < i1 - i) 
        {
            for (int k = i; k < l - i; k++)
            {
                int j1 = ai[((j - i) * l + k) - i];
                int k1 = ai[(j - i) * l + k + i];
                int l1 = ai[(j - i) * l + k];
                int i2 = ai[((j + i) * l + k) - i];
                int j2 = ai[(j + i) * l + k + i];
                int k2 = ai[(j + i) * l + k];
                int l2 = ai[(j * l + k) - i];
                int i3 = ai[j * l + k + i];
                ai[j * l + k] = (j1 & 0xff0000) + (k1 & 0xff0000) + (0xff0000 & l1) + (0xff0000 & i2) + (0xff0000 & j2) + (0xff0000 & k2) + (0xff0000 & l2) + (0xff0000 & i3) >> 3 & 0xff0000 | (0xff000000 | (j1 & 0xff) + (k1 & 0xff) + (l1 & 0xff) + (i2 & 0xff) + (j2 & 0xff) + (k2 & 0xff) + (l2 & 0xff) + (i3 & 0xff) >> 3 & 0xff | (0xff00 & j1) + (0xff00 & k1) + (0xff00 & l1) + (0xff00 & i2) + (0xff00 & j2) + (0xff00 & k2) + (0xff00 & l2) + (0xff00 & i3) >> 3 & 0xff00);
            }

            j++;
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a((String[])aobj);
    }

    protected final void onCancelled()
    {
        com.mopub.common.c.a.b("VastVideoBlurLastVideoFrameTask was cancelled.");
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (Boolean)obj;
        if (isCancelled())
        {
            onCancelled();
        } else
        if (obj != null && ((Boolean) (obj)).booleanValue())
        {
            b.setImageBitmap(e);
            obj = b;
            if (android.os.Build.VERSION.SDK_INT >= 16)
            {
                ((ImageView) (obj)).setImageAlpha(128);
                return;
            } else
            {
                ((ImageView) (obj)).setAlpha(128);
                return;
            }
        }
    }
}
