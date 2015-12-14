// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.sketch.view.TTieZhiCollectionView;

class axd
    implements android.view.View.OnClickListener
{

    final TTieZhiCollectionView a;
    final axc b;

    axd(axc axc1, TTieZhiCollectionView ttiezhicollectionview)
    {
        b = axc1;
        a = ttiezhicollectionview;
        super();
    }

    public void onClick(View view)
    {
        TTieZhiCollectionView.access$200(b.f, b.e, (axc)view);
    }
}
