// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.sketch.info.TTieZhiInfo;
import com.fotoable.sketch.view.TTieZhiCollectionView;

public class axa
    implements awe
{

    final TTieZhiCollectionView a;

    public axa(TTieZhiCollectionView ttiezhicollectionview)
    {
        a = ttiezhicollectionview;
        super();
    }

    public void a(TTieZhiInfo ttiezhiinfo)
    {
        if (TTieZhiCollectionView.access$000(a) != null)
        {
            TTieZhiCollectionView.access$000(a).a();
        }
    }

    public void a(TTieZhiInfo ttiezhiinfo, float f)
    {
    }

    public void b(TTieZhiInfo ttiezhiinfo)
    {
        if (ttiezhiinfo != null)
        {
            awg.a().b(ttiezhiinfo);
            a.reloadData();
            if (TTieZhiCollectionView.access$000(a) != null)
            {
                awg.a().a(ttiezhiinfo.resId);
                TTieZhiCollectionView.access$000(a).a(ttiezhiinfo, false);
            }
        }
    }

    public void c(TTieZhiInfo ttiezhiinfo)
    {
        if (TTieZhiCollectionView.access$000(a) != null)
        {
            TTieZhiCollectionView.access$000(a).b(false);
        }
    }
}
