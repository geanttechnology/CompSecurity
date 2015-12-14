// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import com.fotoable.fotobeauty.PhotoShareToInstagramActivity;

public class aby
    implements Runnable
{

    final Bitmap a;
    final PhotoShareToInstagramActivity b;

    public aby(PhotoShareToInstagramActivity photosharetoinstagramactivity, Bitmap bitmap)
    {
        b = photosharetoinstagramactivity;
        a = bitmap;
        super();
    }

    public void run()
    {
        java.io.File file = sm.a(a);
        b.runOnUiThread(new abz(this, file));
    }
}
