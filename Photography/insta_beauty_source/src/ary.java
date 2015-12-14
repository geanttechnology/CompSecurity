// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.fotoable.photoselector.activity.PhotoSelectScrollView;

class ary
    implements Runnable
{

    final Bitmap a;
    final arx b;

    ary(arx arx1, Bitmap bitmap)
    {
        b = arx1;
        a = bitmap;
        super();
    }

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
}
