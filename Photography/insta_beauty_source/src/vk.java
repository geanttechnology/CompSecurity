// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.fotoable.beautyui.newui.MNewSofterFragment;

class vk
    implements Runnable
{

    final vj a;

    vk(vj vj1)
    {
        a = vj1;
        super();
    }

    public void run()
    {
        MNewSofterFragment.m(a.a);
        Bitmap bitmap = MNewSofterFragment.d(a.a).copy(MNewSofterFragment.d(a.a).getConfig(), true);
        MNewSofterFragment.n(a.a).a(bitmap);
        MNewSofterFragment.a(a.a, bitmap);
        MNewSofterFragment.a(a.a).setImageBitmap(bitmap);
        MNewSofterFragment.k(a.a);
    }
}
