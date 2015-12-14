// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.sketch.view;

import android.widget.HorizontalScrollView;

// Referenced classes of package com.fotoable.sketch.view:
//            TTieZhiCollectionView

class a
    implements Runnable
{

    final int a;
    final TTieZhiCollectionView b;

    public void run()
    {
        TTieZhiCollectionView.access$100(b).scrollTo(a, 0);
    }

    (TTieZhiCollectionView ttiezhicollectionview, int i)
    {
        b = ttiezhicollectionview;
        a = i;
        super();
    }
}
