// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.ImageView;
import com.fotoable.sketch.info.TTieZhiInfo;
import com.fotoable.sketch.view.TTieZhiViewCell;
import java.util.List;
import java.util.concurrent.Semaphore;

public class axs
    implements awe
{

    final TTieZhiViewCell a;

    public axs(TTieZhiViewCell ttiezhiviewcell)
    {
        a = ttiezhiviewcell;
        super();
    }

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
                awg.a().b(ttiezhiinfo);
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
                    awg.a().b(TTieZhiViewCell.access$100(a));
                    if (TTieZhiViewCell.access$600(a) != null)
                    {
                        for (int i = 0; i < TTieZhiViewCell.access$100(a).groupIds.size(); i++)
                        {
                            int j = ((Integer)TTieZhiViewCell.access$100(a).groupIds.get(i)).intValue();
                            awg.a().a(j);
                        }

                        awg.a().a(TTieZhiViewCell.access$100(a).resId);
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
}
