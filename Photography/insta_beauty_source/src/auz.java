// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.widget.HorizontalScrollView;
import com.fotoable.sketch.activity.TTieZhiActivity;
import com.fotoable.sketch.info.TTieZhiInfo;
import com.fotoable.sketch.view.TTieZhiComposeView;
import com.fotoable.sketch.view.TTieZhiMainLibraryView;
import java.util.List;

public class auz
    implements axt
{

    final TTieZhiActivity a;

    public auz(TTieZhiActivity ttiezhiactivity)
    {
        a = ttiezhiactivity;
        super();
    }

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
                if (a.l != null)
                {
                    a.l.addTieZhiWithInfo(ttiezhiinfo, true);
                    return;
                }
            } else
            if (a.B != null)
            {
                int i = a.B.a();
                int j = a.q.getScrollX();
                TTieZhiActivity.a(a, a.B, 0, -(i - j), 300L, true);
                (new Handler()).postDelayed(new ava(this, ttiezhiinfo), 300L);
                return;
            } else
            {
                a.l.changeCurTieZhiWithInfo(awg.a().c(ttiezhiinfo.resId));
                return;
            }
        }
    }

    public void a(List list)
    {
        TTieZhiActivity.a(a, false, "");
        TTieZhiActivity.b(a, true);
        if (a.l != null)
        {
            for (int i = 0; i < list.size() - 1; i++)
            {
                TTieZhiInfo ttiezhiinfo = (TTieZhiInfo)list.get(i);
                a.l.addTieZhiWithInfo(awg.a().c(ttiezhiinfo.resId), false);
            }

            if (list.size() > 1)
            {
                list = (TTieZhiInfo)list.get(list.size() - 1);
                a.l.addTieZhiWithInfo(awg.a().c(((TTieZhiInfo) (list)).resId), true);
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
            a.n.reload();
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
}
