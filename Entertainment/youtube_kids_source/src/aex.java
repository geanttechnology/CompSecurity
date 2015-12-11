// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.widget.ImageView;
import java.util.concurrent.ExecutorService;

final class aex extends blo
{

    private aew a;

    aex(aew aew1)
    {
        a = aew1;
        super();
    }

    public final void a(ImageView imageview, Bitmap bitmap)
    {
        imageview.setImageBitmap(bitmap);
        aew.a(a, new afa(a, bitmap));
        aew.b(a).submit(aew.a(a));
    }
}
