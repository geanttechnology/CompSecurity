// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.fotoable.beautyui.NewFilterContainer;
import com.fotoable.beautyui.newui.MOneKeyFragment;

class wg
    implements Runnable
{

    final MOneKeyFragment a;
    final Bitmap b;
    final wf c;

    wg(wf wf1, MOneKeyFragment monekeyfragment, Bitmap bitmap)
    {
        c = wf1;
        a = monekeyfragment;
        b = bitmap;
        super();
    }

    public void run()
    {
        if (c.a.getActivity() == null)
        {
            return;
        } else
        {
            MOneKeyFragment.a(a).setImageBitmap(b);
            MOneKeyFragment.a(a, MOneKeyFragment.a(a), MOneKeyFragment.p(c.a));
            MOneKeyFragment.e(a).setFilterValue(MOneKeyFragment.p(c.a));
            MOneKeyFragment.n(a);
            MOneKeyFragment.e(a).needScrollView();
            return;
        }
    }
}
