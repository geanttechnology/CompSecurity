// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.sketch.view;

import android.widget.ImageView;
import com.fotoable.sketch.info.TTieZhiInfo;
import java.util.List;
import java.util.concurrent.Semaphore;
import om;
import oo;
import oy;

// Referenced classes of package com.fotoable.sketch.view:
//            TTieZhiViewCell

public class a
    implements om
{

    final TTieZhiViewCell a;

    public void a(TTieZhiInfo ttiezhiinfo)
    {
        if (TTieZhiViewCell.access$600(a) != null)
        {
            TTieZhiViewCell.access$600(a).a();
        }
    }

    public void a(TTieZhiInfo ttiezhiinfo, float f)
    {
    }

    public void b(TTieZhiInfo ttiezhiinfo)
    {
label0:
        {
            TTieZhiViewCell.access$700(a).setVisibility(4);
            if (ttiezhiinfo != null)
            {
                oo.a().b(ttiezhiinfo);
                if (!TTieZhiViewCell.access$100(a).isGroupEnable)
                {
                    break label0;
                }
                try
                {
                    TTieZhiViewCell.access$800().acquire();
                    ttiezhiinfo = a;
                    ttiezhiinfo.downloadFinishCount = ((TTieZhiViewCell) (ttiezhiinfo)).downloadFinishCount + 1;
                    TTieZhiViewCell.access$800().release();
                }
                // Misplaced declaration of an exception variable
                catch (TTieZhiInfo ttiezhiinfo)
                {
                    ttiezhiinfo.printStackTrace();
                }
                if (a.downloadFinishCount >= a.downloadCount)
                {
                    oo.a().b(TTieZhiViewCell.access$100(a));
                    if (TTieZhiViewCell.access$600(a) != null)
                    {
                        for (int i = 0; i < TTieZhiViewCell.access$100(a).groupIds.size(); i++)
                        {
                            int j = ((Integer)TTieZhiViewCell.access$100(a).groupIds.get(i)).intValue();
                            oo.a().a(j);
                        }

                        oo.a().a(TTieZhiViewCell.access$100(a).resId);
                        TTieZhiViewCell.access$600(a).a(a.groupInfos);
                        TTieZhiViewCell.access$600(a).a(false);
                    }
                }
            }
            return;
        }
        if (TTieZhiViewCell.access$600(a) != null)
        {
            TTieZhiViewCell.access$600(a).a(false);
        }
        TTieZhiViewCell.access$200(a, ttiezhiinfo);
    }

    public void c(TTieZhiInfo ttiezhiinfo)
    {
        if (TTieZhiViewCell.access$600(a) != null)
        {
            TTieZhiViewCell.access$600(a).b(false);
        }
    }

    (TTieZhiViewCell ttiezhiviewcell)
    {
        a = ttiezhiviewcell;
        super();
    }
}
