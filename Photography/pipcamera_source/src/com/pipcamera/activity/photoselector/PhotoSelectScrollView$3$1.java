// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.photoselector;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import ew;
import nr;
import sr;

// Referenced classes of package com.pipcamera.activity.photoselector:
//            PhotoSelectScrollView

class a
    implements Runnable
{

    final Bitmap a;
    final olToLast b;

    public void run()
    {
        if (a != null)
        {
            b.b.setImageBitmap(a);
        } else
        {
            Log.v("hedong_icon", "no bimap");
        }
        if (PhotoSelectScrollView.access$000(b.b) != null)
        {
            PhotoSelectScrollView.access$000(b.b).a();
        }
        PhotoSelectScrollView.access$100(b.b).addView(b.b);
        (new Handler()).postDelayed(new Runnable() {

            final PhotoSelectScrollView._cls3._cls1 a;

            public void run()
            {
                a.b.d.scroolToLast();
            }

            
            {
                a = PhotoSelectScrollView._cls3._cls1.this;
                super();
            }
        }, 300L);
    }

    _cls1.a(_cls1.a a1, Bitmap bitmap)
    {
        b = a1;
        a = bitmap;
        super();
    }

    // Unreferenced inner class com/pipcamera/activity/photoselector/PhotoSelectScrollView$3

/* anonymous class */
    class PhotoSelectScrollView._cls3
        implements Runnable
    {

        final nr a;
        final ImageButton b;
        final View c;
        final PhotoSelectScrollView d;

        public void run()
        {
            Bitmap bitmap = a.a(d.getContext(), ew.a(d.getContext(), 62F), ew.a(d.getContext(), 62F));
            (new Handler(d.getContext().getMainLooper())).post(new PhotoSelectScrollView._cls3._cls1(this, bitmap));
        }

            
            {
                d = photoselectscrollview;
                a = nr1;
                b = imagebutton;
                c = view;
                super();
            }
    }

}
