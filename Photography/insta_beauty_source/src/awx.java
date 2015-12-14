// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.fotoable.sketch.info.TTieZhiInfo;
import com.fotoable.sketch.view.TTieZhiCollectionPageView;
import com.fotoable.sketch.view.TTieZhiSafeImageView;
import java.util.ArrayList;
import java.util.List;

public class awx extends FrameLayout
{

    int a;
    TTieZhiSafeImageView b;
    View c;
    ImageView d;
    TTieZhiInfo e;
    List f;
    boolean g;
    int h;
    int i;
    final TTieZhiCollectionPageView j;

    public awx(TTieZhiCollectionPageView ttiezhicollectionpageview, Context context)
    {
        j = ttiezhicollectionpageview;
        super(context);
        f = new ArrayList();
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300d0, this, true);
        b = (TTieZhiSafeImageView)findViewById(0x7f0d01cd);
        d = (ImageView)findViewById(0x7f0d02a1);
        c = findViewById(0x7f0d033f);
        c.setBackgroundResource(0x7f0202f0);
        b.setBackgroundColor(0);
        setOnClickListener(new awy(this, ttiezhicollectionpageview));
    }

    static void a(awx awx1)
    {
        awx1.b();
    }

    static void a(awx awx1, TTieZhiInfo ttiezhiinfo)
    {
        awx1.a(ttiezhiinfo);
    }

    private void a(TTieZhiInfo ttiezhiinfo)
    {
        if (TTieZhiCollectionPageView.access$300(j) != null)
        {
            awg.a().a(e.resId);
            TTieZhiCollectionPageView.access$300(j).a(awg.a().c(e.resId), false);
        }
    }

    private void b()
    {
        if (e != null)
        {
            if (!e.isGroupEnable)
            {
                if (awg.a().b(e.resId))
                {
                    a(e);
                    return;
                }
                if (TTieZhiCollectionPageView.access$200(j) == null || !(new awm(TTieZhiCollectionPageView.access$200(j), e)).a())
                {
                    b(e);
                    return;
                }
            } else
            {
                c();
                return;
            }
        }
    }

    private void b(TTieZhiInfo ttiezhiinfo)
    {
        if (ttiezhiinfo == null)
        {
            return;
        } else
        {
            awc.a().a(ttiezhiinfo, new awz(this));
            return;
        }
    }

    private void c()
    {
        boolean flag;
        flag = false;
        e.version = "0.0";
        g = true;
        if (TTieZhiCollectionPageView.access$300(j) == null) goto _L2; else goto _L1
_L1:
        int k;
        h = 0;
        k = 0;
_L13:
        if (k >= e.groupIds.size()) goto _L4; else goto _L3
_L3:
        int j1 = ((Integer)e.groupIds.get(k)).intValue();
        if (awg.a().b(j1)) goto _L6; else goto _L5
_L5:
        TTieZhiInfo ttiezhiinfo = TTieZhiCollectionPageView.access$300(j).a(j1);
        if (ttiezhiinfo != null) goto _L7; else goto _L2
_L2:
        return;
_L7:
        if (ttiezhiinfo.version != null)
        {
            e.version = bgx.b(e.version, ttiezhiinfo.version);
        }
        h = h + 1;
        g = false;
_L9:
        f.add(ttiezhiinfo);
        k++;
        continue; /* Loop/switch isn't completed */
_L6:
        TTieZhiInfo ttiezhiinfo1;
        ttiezhiinfo1 = awg.a().c(j1);
        ttiezhiinfo = ttiezhiinfo1;
        if (ttiezhiinfo1 != null) goto _L9; else goto _L8
_L8:
        return;
_L4:
        if (!g)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (f.size() <= 0) goto _L2; else goto _L10
_L10:
        int l = ((flag) ? 1 : 0);
        if (!awg.a().b(e.resId))
        {
            awg.a().b(e);
            l = ((flag) ? 1 : 0);
        }
        for (; l < e.groupIds.size(); l++)
        {
            int i1 = ((Integer)e.groupIds.get(l)).intValue();
            awg.a().a(i1);
        }

        awg.a().a(e.resId);
        TTieZhiCollectionPageView.access$300(j).a(f);
        return;
        if (TTieZhiCollectionPageView.access$200(j) != null && (new awm(TTieZhiCollectionPageView.access$200(j), e)).a()) goto _L2; else goto _L11
_L11:
        d();
        return;
        if (true) goto _L13; else goto _L12
_L12:
    }

    private void d()
    {
        if (f.size() > 0)
        {
            for (int k = 0; k < f.size(); k++)
            {
                TTieZhiInfo ttiezhiinfo = (TTieZhiInfo)f.get(k);
                if (ttiezhiinfo != null && !awg.a().b(ttiezhiinfo.resId))
                {
                    b(ttiezhiinfo);
                }
            }

        }
    }

    public int a()
    {
        return a;
    }

    public void a(TTieZhiInfo ttiezhiinfo, int k)
    {
        e = ttiezhiinfo;
        a = k;
        f.clear();
        i = 0;
        TTieZhiCollectionPageView.access$600(j, d, ttiezhiinfo);
        if (TTieZhiCollectionPageView.access$700(j) != null)
        {
            TTieZhiCollectionPageView.access$700(j).a(ttiezhiinfo, b);
        }
    }

    public void setSelected(boolean flag)
    {
        super.setSelected(flag);
        if (flag)
        {
            c.setBackgroundResource(0x7f0202f1);
            b.setBackgroundResource(0x7f0202f0);
            return;
        } else
        {
            c.setBackgroundResource(0x7f0202f0);
            b.setBackgroundColor(0);
            return;
        }
    }
}
