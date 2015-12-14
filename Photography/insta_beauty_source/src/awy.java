// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.sketch.view.TTieZhiCollectionPageView;

class awy
    implements android.view.View.OnClickListener
{

    final TTieZhiCollectionPageView a;
    final awx b;

    awy(awx awx1, TTieZhiCollectionPageView ttiezhicollectionpageview)
    {
        b = awx1;
        a = ttiezhicollectionpageview;
        super();
    }

    public void onClick(View view)
    {
        TTieZhiCollectionPageView.access$000(b.j, b.e, (awx)view);
        awx.a(b);
    }
}
