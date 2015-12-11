// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.FrameLayout;

final class afb
    implements Runnable
{

    private BitmapDrawable a;
    private afa b;

    afb(afa afa1, BitmapDrawable bitmapdrawable)
    {
        b = afa1;
        a = bitmapdrawable;
        super();
    }

    public final void run()
    {
        try
        {
            b.b();
            aew.c(b.a).setBackground(a);
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            a.getBitmap().recycle();
        }
    }
}
