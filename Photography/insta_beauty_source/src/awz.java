// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.ImageView;
import com.fotoable.sketch.info.TTieZhiInfo;
import com.fotoable.sketch.view.TTieZhiCollectionPageView;
import java.util.List;
import java.util.concurrent.Semaphore;

class awz
    implements awe
{

    final awx a;

    awz(awx awx1)
    {
        a = awx1;
        super();
    }

    public void a(TTieZhiInfo ttiezhiinfo)
    {
        if (TTieZhiCollectionPageView.access$300(a.j) != null)
        {
            TTieZhiCollectionPageView.access$300(a.j).a();
        }
    }

    public void a(TTieZhiInfo ttiezhiinfo, float f)
    {
    }

    public void b(TTieZhiInfo ttiezhiinfo)
    {
label0:
        {
            a.d.setVisibility(4);
            if (ttiezhiinfo != null)
            {
                awg.a().b(ttiezhiinfo);
                if (!a.e.isGroupEnable)
                {
                    break label0;
                }
                try
                {
                    TTieZhiCollectionPageView.access$400().acquire();
                    ttiezhiinfo = a;
                    ttiezhiinfo.i = ((awx) (ttiezhiinfo)).i + 1;
                    TTieZhiCollectionPageView.access$400().release();
                }
                // Misplaced declaration of an exception variable
                catch (TTieZhiInfo ttiezhiinfo)
                {
                    ttiezhiinfo.printStackTrace();
                }
                if (a.i >= a.h)
                {
                    awg.a().b(a.e);
                    if (TTieZhiCollectionPageView.access$300(a.j) != null)
                    {
                        for (int i = 0; i < a.e.groupIds.size(); i++)
                        {
                            int j = ((Integer)a.e.groupIds.get(i)).intValue();
                            awg.a().a(j);
                        }

                        awg.a().a(a.e.resId);
                        TTieZhiCollectionPageView.access$300(a.j).a(a.f);
                        TTieZhiCollectionPageView.access$300(a.j).a(false);
                    }
                }
            }
            return;
        }
        if (TTieZhiCollectionPageView.access$300(a.j) != null)
        {
            TTieZhiCollectionPageView.access$300(a.j).a(false);
        }
        awx.a(a, ttiezhiinfo);
    }

    public void c(TTieZhiInfo ttiezhiinfo)
    {
        if (TTieZhiCollectionPageView.access$300(a.j) != null)
        {
            TTieZhiCollectionPageView.access$300(a.j).b(false);
        }
    }
}
