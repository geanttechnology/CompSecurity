// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.HorizontalScrollView;
import com.fotoable.sketch.view.TTieZhiCollectionView;

public class axb
    implements Runnable
{

    final int a;
    final TTieZhiCollectionView b;

    public axb(TTieZhiCollectionView ttiezhicollectionview, int i)
    {
        b = ttiezhicollectionview;
        a = i;
        super();
    }

    public void run()
    {
        TTieZhiCollectionView.access$100(b).scrollTo(a, 0);
    }
}
