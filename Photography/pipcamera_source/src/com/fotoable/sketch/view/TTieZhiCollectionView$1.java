// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.sketch.view;

import com.fotoable.sketch.info.TTieZhiInfo;
import om;
import oo;
import oy;

// Referenced classes of package com.fotoable.sketch.view:
//            TTieZhiCollectionView

class a
    implements om
{

    final TTieZhiCollectionView a;

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
            oo.a().b(ttiezhiinfo);
            a.reloadData();
            if (TTieZhiCollectionView.access$000(a) != null)
            {
                oo.a().a(ttiezhiinfo.resId);
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

    (TTieZhiCollectionView ttiezhicollectionview)
    {
        a = ttiezhicollectionview;
        super();
    }
}
