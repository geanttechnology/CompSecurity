// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.instamag.activity.library.view.MaglibItemView;

public class bds
    implements android.view.View.OnClickListener
{

    final MaglibItemView a;

    public bds(MaglibItemView maglibitemview)
    {
        a = maglibitemview;
        super();
    }

    public void onClick(View view)
    {
        if (aqx.e(a.getContext(), "MaglibItemView", "deleteInfoTagTip"))
        {
            MaglibItemView.access$200(a, MaglibItemView.access$100(a));
            return;
        } else
        {
            MaglibItemView.access$300(a);
            return;
        }
    }
}
