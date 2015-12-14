// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import com.fotoable.photoselector.activity.PhotoSelectScrollView;

public class arx
    implements Runnable
{

    final asx a;
    final ImageButton b;
    final View c;
    final PhotoSelectScrollView d;

    public arx(PhotoSelectScrollView photoselectscrollview, asx asx1, ImageButton imagebutton, View view)
    {
        d = photoselectscrollview;
        a = asx1;
        b = imagebutton;
        c = view;
        super();
    }

    public void run()
    {
        android.graphics.Bitmap bitmap = a.a(d.getContext(), yp.a(d.getContext(), 62F), yp.a(d.getContext(), 62F));
        (new Handler(d.getContext().getMainLooper())).post(new ary(this, bitmap));
    }
}
