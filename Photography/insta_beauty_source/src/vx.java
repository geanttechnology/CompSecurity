// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.fotoable.beautyui.newui.MOneKeyFragment;

class vx
    implements Runnable
{

    final vw a;

    vx(vw vw1)
    {
        a = vw1;
        super();
    }

    public void run()
    {
        Bitmap bitmap = MOneKeyFragment.d(a.a).copy(MOneKeyFragment.d(a.a).getConfig(), true);
        MOneKeyFragment.j(a.a).a(bitmap);
        MOneKeyFragment.a(a.a, bitmap);
        MOneKeyFragment.k(a.a).setImageBitmap(MOneKeyFragment.d(a.a));
        MOneKeyFragment.a(a.a, MOneKeyFragment.d(a.a), MOneKeyFragment.l(a.a));
    }
}
