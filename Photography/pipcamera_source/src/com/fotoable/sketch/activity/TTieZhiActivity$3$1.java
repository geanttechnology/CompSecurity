// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.sketch.activity;

import android.os.Handler;
import android.widget.HorizontalScrollView;
import com.fotoable.sketch.info.TTieZhiInfo;
import com.fotoable.sketch.view.TTieZhiComposeView;
import com.fotoable.sketch.view.TTieZhiMainLibraryView;
import java.util.List;
import oj;
import oo;
import oy;

// Referenced classes of package com.fotoable.sketch.activity:
//            TTieZhiActivity

class a
    implements Runnable
{

    final TTieZhiInfo a;
    final a b;

    public void run()
    {
        b.b.m.addTieZhiWithInfo(a, true);
    }

    ( , TTieZhiInfo ttiezhiinfo)
    {
        b = ;
        a = ttiezhiinfo;
        super();
    }

    // Unreferenced inner class com/fotoable/sketch/activity/TTieZhiActivity$3

/* anonymous class */
    class TTieZhiActivity._cls3
        implements oy
    {

        final TTieZhiActivity a;

        public TTieZhiInfo a(int i)
        {
            return TTieZhiActivity.a(a, i);
        }

        public void a()
        {
            TTieZhiActivity.a(a, true, "");
        }

        public void a(TTieZhiInfo ttiezhiinfo, boolean flag)
        {
            TTieZhiActivity.a(a, false, "");
            if (ttiezhiinfo != null)
            {
                if (flag)
                {
                    TTieZhiActivity.b(a, true);
                    if (a.m != null)
                    {
                        a.m.addTieZhiWithInfo(ttiezhiinfo, true);
                        return;
                    }
                } else
                if (a.B != null)
                {
                    int i = a.B.a();
                    int j = a.r.getScrollX();
                    TTieZhiActivity.a(a, a.B, 0, -(i - j), 300L, true);
                    (new Handler()).postDelayed(new TTieZhiActivity._cls3._cls1(this, ttiezhiinfo), 300L);
                    return;
                } else
                {
                    a.m.changeCurTieZhiWithInfo(oo.a().c(ttiezhiinfo.resId));
                    return;
                }
            }
        }

        public void a(List list)
        {
            TTieZhiActivity.a(a, false, "");
            TTieZhiActivity.b(a, true);
            if (a.m != null)
            {
                for (int i = 0; i < list.size() - 1; i++)
                {
                    TTieZhiInfo ttiezhiinfo = (TTieZhiInfo)list.get(i);
                    a.m.addTieZhiWithInfo(oo.a().c(ttiezhiinfo.resId), false);
                }

                if (list.size() > 1)
                {
                    list = (TTieZhiInfo)list.get(list.size() - 1);
                    a.m.addTieZhiWithInfo(oo.a().c(((TTieZhiInfo) (list)).resId), true);
                }
            }
        }

        public void a(boolean flag)
        {
            if (flag)
            {
                if (a.t)
                {
                    TTieZhiActivity.f(a);
                }
                return;
            } else
            {
                a.o.reload();
                return;
            }
        }

        public void b()
        {
            TTieZhiActivity.b(a, true);
            if (TTieZhiActivity.g(a) <= 0 && TTieZhiActivity.h(a) != null && TTieZhiActivity.h(a).size() > 0)
            {
                TTieZhiActivity.a(a, TTieZhiActivity.h(a), false);
            }
        }

        public void b(boolean flag)
        {
            TTieZhiActivity.a(a, false, "");
        }

            
            {
                a = ttiezhiactivity;
                super();
            }
    }

}
