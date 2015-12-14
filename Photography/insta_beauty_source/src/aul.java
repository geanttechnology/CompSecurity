// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.fotoable.shareinstagram.InstagramPhotoShareActivity;

class aul
    implements Runnable
{

    final Bitmap a;
    final auk b;

    aul(auk auk1, Bitmap bitmap)
    {
        b = auk1;
        a = bitmap;
        super();
    }

    public void run()
    {
        InstagramPhotoShareActivity.a(b.b);
        if (a == null || a.isRecycled())
        {
            b.b.q.setImageBitmap(b.b.f);
            return;
        } else
        {
            b.b.q.setImageBitmap(a);
            return;
        }
    }
}
