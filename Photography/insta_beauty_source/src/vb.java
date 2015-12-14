// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.fotoable.beautyui.newui.MNewSofterFragment;

public class vb
    implements android.view.ViewTreeObserver.OnGlobalLayoutListener
{

    final MNewSofterFragment a;

    public vb(MNewSofterFragment mnewsofterfragment)
    {
        a = mnewsofterfragment;
        super();
    }

    public void onGlobalLayout()
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            MNewSofterFragment.a(a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
        } else
        {
            MNewSofterFragment.a(a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
        MNewSofterFragment.a(a, MNewSofterFragment.b(a), yp.a(a.getActivity(), 90F), 0, 300L, true);
    }
}
