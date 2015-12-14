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
import java.util.concurrent.Semaphore;

public class ot extends FrameLayout
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

    public ot(TTieZhiCollectionPageView ttiezhicollectionpageview, Context context)
    {
        j = ttiezhicollectionpageview;
        super(context);
        f = new ArrayList();
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f030091, this, true);
        b = (TTieZhiSafeImageView)findViewById(0x7f0c010f);
        d = (ImageView)findViewById(0x7f0c0049);
        c = findViewById(0x7f0c0252);
        c.setBackgroundResource(0x7f0201b7);
        b.setBackgroundColor(0);
        setOnClickListener(new android.view.View.OnClickListener(ttiezhicollectionpageview) {

            final TTieZhiCollectionPageView a;
            final ot b;

            public void onClick(View view)
            {
                TTieZhiCollectionPageView.access$000(b.j, b.e, (ot)view);
                ot.a(b);
            }

            
            {
                b = ot.this;
                a = ttiezhicollectionpageview;
                super();
            }
        });
    }

    private void a(TTieZhiInfo ttiezhiinfo)
    {
        if (TTieZhiCollectionPageView.access$300(j) != null)
        {
            oo.a().a(e.resId);
            TTieZhiCollectionPageView.access$300(j).a(oo.a().c(e.resId), false);
        }
    }

    static void a(ot ot1)
    {
        ot1.b();
    }

    static void a(ot ot1, TTieZhiInfo ttiezhiinfo)
    {
        ot1.a(ttiezhiinfo);
    }

    private void b()
    {
        if (e != null)
        {
            if (!e.isGroupEnable)
            {
                if (oo.a().b(e.resId))
                {
                    a(e);
                    return;
                }
                if (TTieZhiCollectionPageView.access$200(j) == null || !(new ub(TTieZhiCollectionPageView.access$200(j), e)).a())
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
            ol.a().a(ttiezhiinfo, new om() {

                final ot a;

                public void a(TTieZhiInfo ttiezhiinfo1)
                {
                    if (TTieZhiCollectionPageView.access$300(a.j) != null)
                    {
                        TTieZhiCollectionPageView.access$300(a.j).a();
                    }
                }

                public void a(TTieZhiInfo ttiezhiinfo1, float f1)
                {
                }

                public void b(TTieZhiInfo ttiezhiinfo1)
                {
label0:
                    {
                        a.d.setVisibility(4);
                        if (ttiezhiinfo1 != null)
                        {
                            oo.a().b(ttiezhiinfo1);
                            if (!a.e.isGroupEnable)
                            {
                                break label0;
                            }
                            try
                            {
                                TTieZhiCollectionPageView.access$400().acquire();
                                ttiezhiinfo1 = a;
                                ttiezhiinfo1.i = ((ot) (ttiezhiinfo1)).i + 1;
                                TTieZhiCollectionPageView.access$400().release();
                            }
                            // Misplaced declaration of an exception variable
                            catch (TTieZhiInfo ttiezhiinfo1)
                            {
                                ttiezhiinfo1.printStackTrace();
                            }
                            if (a.i >= a.h)
                            {
                                oo.a().b(a.e);
                                if (TTieZhiCollectionPageView.access$300(a.j) != null)
                                {
                                    for (int k = 0; k < a.e.groupIds.size(); k++)
                                    {
                                        int l = ((Integer)a.e.groupIds.get(k)).intValue();
                                        oo.a().a(l);
                                    }

                                    oo.a().a(a.e.resId);
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
                    ot.a(a, ttiezhiinfo1);
                }

                public void c(TTieZhiInfo ttiezhiinfo1)
                {
                    if (TTieZhiCollectionPageView.access$300(a.j) != null)
                    {
                        TTieZhiCollectionPageView.access$300(a.j).b(false);
                    }
                }

            
            {
                a = ot.this;
                super();
            }
            });
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
        if (oo.a().b(j1)) goto _L6; else goto _L5
_L5:
        TTieZhiInfo ttiezhiinfo = TTieZhiCollectionPageView.access$300(j).a(j1);
        if (ttiezhiinfo != null) goto _L7; else goto _L2
_L2:
        return;
_L7:
        if (ttiezhiinfo.version != null)
        {
            e.version = uc.a(e.version, ttiezhiinfo.version);
        }
        h = h + 1;
        g = false;
_L9:
        f.add(ttiezhiinfo);
        k++;
        continue; /* Loop/switch isn't completed */
_L6:
        TTieZhiInfo ttiezhiinfo1;
        ttiezhiinfo1 = oo.a().c(j1);
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
        if (!oo.a().b(e.resId))
        {
            oo.a().b(e);
            l = ((flag) ? 1 : 0);
        }
        for (; l < e.groupIds.size(); l++)
        {
            int i1 = ((Integer)e.groupIds.get(l)).intValue();
            oo.a().a(i1);
        }

        oo.a().a(e.resId);
        TTieZhiCollectionPageView.access$300(j).a(f);
        return;
        if (TTieZhiCollectionPageView.access$200(j) != null && (new ub(TTieZhiCollectionPageView.access$200(j), e)).a()) goto _L2; else goto _L11
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
                if (ttiezhiinfo != null && !oo.a().b(ttiezhiinfo.resId))
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
            c.setBackgroundResource(0x7f0201b8);
            b.setBackgroundResource(0x7f0201b7);
            return;
        } else
        {
            c.setBackgroundResource(0x7f0201b7);
            b.setBackgroundColor(0);
            return;
        }
    }
}
