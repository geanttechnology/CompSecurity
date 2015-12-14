// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.utility.r;
import com.edmodo.cropper.CropImageView;
import com.nostra13.universalimageloader.core.f;
import com.perfectcorp.utility.h;
import java.util.ArrayList;
import java.util.Locale;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            CropImageActivity

class a extends AsyncTask
{

    final CropImageActivity a;

    protected transient Bitmap a(Void avoid[])
    {
        String s = h.a(a.getBaseContext(), (Uri)com.cyberlink.beautycircle.controller.activity.CropImageActivity.h(a).get(CropImageActivity.g(a)));
        Object obj = null;
        avoid = obj;
        if (s != null)
        {
            avoid = obj;
            if (!s.isEmpty())
            {
                avoid = (new StringBuilder()).append("file://").append(s).toString();
                Bitmap bitmap = f.b().a(avoid, CropImageActivity.i(a));
                avoid = bitmap;
                if (com.cyberlink.beautycircle.controller.activity.CropImageActivity.f(a).faceDetection)
                {
                    avoid = bitmap;
                    if (bitmap != null)
                    {
                        CropImageActivity.a(a, r.a(bitmap));
                        avoid = bitmap;
                    }
                }
            }
        }
        return avoid;
    }

    protected void a(Bitmap bitmap)
    {
        a.l();
        if (bitmap != null) goto _L2; else goto _L1
_L1:
        CropImageActivity.a(a, a.getResources().getString(m.bc_crop_no_bitmap));
_L4:
        if (bitmap != null && bitmap.isRecycled())
        {
            bitmap.recycle();
            System.gc();
        }
        return;
_L2:
        if (bitmap.getWidth() < 160 || bitmap.getHeight() < 160)
        {
            String s = a.getResources().getString(m.bc_crop_size_limit);
            s = String.format(Locale.getDefault(), s, new Object[] {
                Integer.valueOf(160)
            });
            CropImageActivity.a(a, s);
        } else
        {
            CropImageActivity.c(a).a(bitmap, 0);
            CropImageActivity.c(a).a(com.cyberlink.beautycircle.controller.activity.CropImageActivity.f(a).aspectRatio.x, com.cyberlink.beautycircle.controller.activity.CropImageActivity.f(a).aspectRatio.y);
            CropImageActivity.c(a).setCircleBackground(com.cyberlink.beautycircle.controller.activity.CropImageActivity.f(a).useCircle);
            CropImageActivity.c(a).setFixedAspectRatio(true);
            if (com.cyberlink.beautycircle.controller.activity.CropImageActivity.f(a).faceDetection)
            {
                CropImageActivity.c(a).setEyeMidPoint(CropImageActivity.j(a));
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Bitmap)obj);
    }

    (CropImageActivity cropimageactivity)
    {
        a = cropimageactivity;
        super();
    }
}
