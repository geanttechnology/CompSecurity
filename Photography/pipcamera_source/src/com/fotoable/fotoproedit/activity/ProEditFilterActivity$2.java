// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import android.view.SurfaceHolder;
import android.widget.FrameLayout;
import com.wantu.imagerender.ImageGLSurfaceView;
import fn;
import gm;

// Referenced classes of package com.fotoable.fotoproedit.activity:
//            ProEditFilterActivity

class a
    implements android.view.lLayoutListener
{

    final ProEditFilterActivity a;

    public void onGlobalLayout()
    {
        Bitmap bitmap;
        Object obj;
label0:
        {
            if (ProEditFilterActivity.a(a) == null)
            {
                obj = new Rect(0, 0, ProEditFilterActivity.b(a).getWidth(), ProEditFilterActivity.b(a).getHeight());
                ((Rect) (obj)).inset(ProEditFilterActivity.c(a), ProEditFilterActivity.c(a));
                bitmap = gm.c().k();
                if (bitmap != null)
                {
                    break label0;
                }
                Log.e("ProEditFilterActivity", "process bitmap is null");
                a.c();
                a.finish();
            }
            return;
        }
        obj = fn.a(((Rect) (obj)), new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()));
        ProEditFilterActivity.a(a, new ImageGLSurfaceView(a));
        obj = new android.widget.(((Rect) (obj)).width(), ((Rect) (obj)).height(), 17);
        ProEditFilterActivity.a(a).setSourceBitmap(bitmap);
        ProEditFilterActivity.a(a).getHolder().addCallback(a);
        ProEditFilterActivity.a(a, ProEditFilterActivity.a(a).getRender());
        ProEditFilterActivity.b(a).bringChildToFront(ProEditFilterActivity.d(a));
        ProEditFilterActivity.b(a).requestLayout();
        ProEditFilterActivity.b(a).invalidate();
        ProEditFilterActivity.b(a).addView(ProEditFilterActivity.a(a), 0, ((android.view.EditFilterActivity._cls2.a) (obj)));
    }

    (ProEditFilterActivity proeditfilteractivity)
    {
        a = proeditfilteractivity;
        super();
    }
}
