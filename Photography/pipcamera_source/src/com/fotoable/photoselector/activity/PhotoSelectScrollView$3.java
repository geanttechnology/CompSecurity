// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import ew;
import nf;
import nr;

// Referenced classes of package com.fotoable.photoselector.activity:
//            PhotoSelectScrollView

class c
    implements Runnable
{

    final nr a;
    final ImageButton b;
    final View c;
    final PhotoSelectScrollView d;

    public void run()
    {
        Bitmap bitmap = a.a(d.getContext(), ew.a(d.getContext(), 62F), ew.a(d.getContext(), 62F));
        (new Handler(d.getContext().getMainLooper())).post(new Runnable(bitmap) {

            final Bitmap a;
            final PhotoSelectScrollView._cls3 b;

            public void run()
            {
                if (a != null)
                {
                    b.b.setImageBitmap(a);
                } else
                {
                    Log.v("hedong_icon", "no bimap");
                }
                if (PhotoSelectScrollView.access$000(b.d) != null)
                {
                    PhotoSelectScrollView.access$000(b.d).a();
                }
                PhotoSelectScrollView.access$100(b.d).addView(b.c);
            }

            
            {
                b = PhotoSelectScrollView._cls3.this;
                a = bitmap;
                super();
            }
        });
    }

    _cls1.a(PhotoSelectScrollView photoselectscrollview, nr nr1, ImageButton imagebutton, View view)
    {
        d = photoselectscrollview;
        a = nr1;
        b = imagebutton;
        c = view;
        super();
    }
}
