// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import android.content.Intent;
import android.view.View;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.activity.ExtraDownloadCategoryActivity;
import com.cyberlink.youcammakeup.clflurry.YMKApplyEvent;
import com.cyberlink.youcammakeup.clflurry.YMKFeatureRoomLookEvent;
import com.cyberlink.youcammakeup.clflurry.YMKLooksStoreEvent;
import com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent;
import com.cyberlink.youcammakeup.clflurry.at;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.database.more.types.CategoryType;
import com.cyberlink.youcammakeup.flurry.PopularityOfLookEvent;
import com.cyberlink.youcammakeup.g;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.utility.DownloadUseUtils;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.as;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.AdapterView;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.p;
import com.cyberlink.youcammakeup.widgetpool.dialogs.an;
import com.cyberlink.youcammakeup.widgetpool.dialogs.c;
import com.cyberlink.youcammakeup.widgetpool.dialogs.d;
import com.cyberlink.youcammakeup.widgetpool.panel.lookspanel.LooksGridItem;
import com.cyberlink.youcammakeup.widgetpool.panel.lookspanel.LooksImageAdapter;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            MakeupLooksBottomToolbar

class a
    implements p
{

    final MakeupLooksBottomToolbar a;

    public void a(AdapterView adapterview, View view, int j)
    {
        i k;
        com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a, j);
        view.setActivated(true);
        k = StatusManager.j().d();
        if (com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a).a(j) != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s;
        s = com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a).a(j).a();
        adapterview = com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a).a(j).c();
        if (k == null || !s.equals(k.v()))
        {
            break; /* Loop/switch isn't completed */
        }
        if (com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a).a(j).n() != null && j != 0 && j != 1)
        {
            b.a(new YMKFeatureRoomLookEvent(com.cyberlink.youcammakeup.clflurry.ation.i, 0L, 0L, null, YMKFeatureRoomLookEvent.e(), null));
            b.a(new YMKSavingPageEvent(0L, 0L, com.cyberlink.youcammakeup.clflurry..o, false, false));
            g.a(a.getActivity(), com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a).a(j).n());
            return;
        }
        if (!com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.m(a)) goto _L1; else goto _L3
_L3:
        if (!StatusManager.j().E().booleanValue()) goto _L1; else goto _L4
_L4:
        MakeupLooksBottomToolbar.e(a, false);
        StatusManager.j().a(Boolean.valueOf(false));
        com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a).g(j);
        a.a(MakeupLooksBottomToolbar.n(a));
        a.c(false);
        a.a("Apply", Boolean.valueOf(true));
        PopularityOfLookEvent.a(s);
        PopularityOfLookEvent.b(adapterview);
        YMKApplyEvent.j(s);
        YMKApplyEvent.k(adapterview);
        as as1 = PanelDataCenter.a().o(s);
        if (as1.f() == com.cyberlink.youcammakeup.utility.)
        {
            adapterview = "customize";
        }
        if ("original".equalsIgnoreCase(adapterview))
        {
            adapterview = "original";
        }
        YMKSavingPageEvent.c(adapterview);
        if (as1.f() != com.cyberlink.youcammakeup.utility. && !com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.o(a))
        {
            at at1 = new at(com.cyberlink.youcammakeup.clflurry.oolbar._cls14.a);
            at1.f(as1.a());
            b.a(at1.e());
        }
        view = (LooksGridItem)view;
        as as2 = com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a).a(j);
        boolean flag;
        if (as2.n() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.a(Boolean.valueOf(flag));
        YMKSavingPageEvent.c(false);
        YMKSavingPageEvent.a(MakeupLooksBottomToolbar.n(a));
        b.a(new YMKFeatureRoomLookEvent(com.cyberlink.youcammakeup.clflurry.ation.h, 0L, 0L, as1.c(), YMKFeatureRoomLookEvent.e(), null));
        b.a((new YMKSavingPageEvent(0L, 0L, com.cyberlink.youcammakeup.clflurry..n, false, false)).d(adapterview));
        if (as2.h().booleanValue() && !as2.i().booleanValue())
        {
            if (as2.j().booleanValue())
            {
                MakeupLooksBottomToolbar.a(a, Integer.valueOf(j), as2, view);
            } else
            {
                adapterview = as2.k();
                Globals.d().a(adapterview);
                o.a(a.getActivity(), an.a(adapterview), "ShareToUnlockDialog");
            }
            StatusManager.j().a(Boolean.valueOf(true));
            return;
        }
        com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a).a(j, false);
        m.b("MakeupLooksBottomToolbar", (new StringBuilder()).append("onGridViewItemClick mFirstIntentFromBCHowToCount = ").append(MakeupLooksBottomToolbar.t()).append(" position = ").append(j).toString());
        if (MakeupLooksBottomToolbar.t() > 0)
        {
            MakeupLooksBottomToolbar.u();
        } else
        {
            Globals.d().b(false);
            com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a);
            LooksImageAdapter.c(-1);
        }
        MakeupLooksBottomToolbar.a(a, s, true);
        com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a).notifyDataSetChanged();
        return;
    }

    public void a(AdapterView adapterview, View view, int j, long l)
    {
        if (com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a) != null && com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a).c())
        {
            o.c();
            com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a).notifyDataSetChanged();
            return;
        }
        if (j != 0) goto _L2; else goto _L1
_L1:
        z.a("HAS_SET_SEEN_MAKEUP_LOOK_RED_ICON", Boolean.valueOf(true), Globals.d());
        a.c(true);
        view = new Intent(view.getContext(), com/cyberlink/youcammakeup/activity/ExtraDownloadCategoryActivity);
        if (com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a).i() == com.cyberlink.youcammakeup.utility.geAdapter.i)
        {
            adapterview = CategoryType.b;
        } else
        {
            adapterview = CategoryType.c;
        }
        if (adapterview != CategoryType.b) goto _L4; else goto _L3
_L3:
        YMKLooksStoreEvent.b(com.cyberlink.youcammakeup.clflurry.eAdapter.i.i());
_L5:
        b.a(new YMKFeatureRoomLookEvent(com.cyberlink.youcammakeup.clflurry.ation.j, 0L, 0L, null, YMKFeatureRoomLookEvent.e(), null));
        b.a(new YMKSavingPageEvent(0L, 0L, com.cyberlink.youcammakeup.clflurry..p, false, false));
        view.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_ID", CategoryType.a(adapterview));
        view.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_NAME", a.getString(0x7f070502));
        view.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_TYPE", adapterview);
        view.putExtra("KEY_EXTRA_DOWNLOAD_DISPLAY_TYPE", com.cyberlink.youcammakeup.kernelctrl.yMakeupType.b.ordinal());
        view.putExtra("KEY_EXTRA_DOWNLOAD_BACK_TO_MAIN", false);
        DownloadUseUtils.a(view, true);
        a.startActivity(view);
        return;
_L4:
        if (adapterview == CategoryType.c)
        {
            YMKLooksStoreEvent.b(com.cyberlink.youcammakeup.clflurry.oolbar.startActivity.startActivity());
        }
        if (true) goto _L5; else goto _L2
_L2:
        if (com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.i(a) && !MakeupLooksBottomToolbar.j(a))
        {
            c c1 = new c(a.getActivity(), true);
            c1.a(new d(adapterview, view, j) {

                final AdapterView a;
                final View b;
                final int c;
                final MakeupLooksBottomToolbar._cls14 d;

                public void a()
                {
                    android.app.Activity activity = d.a.getActivity();
                    if (activity != null && (activity instanceof EditViewActivity))
                    {
                        ((EditViewActivity)activity).b(MakeupLooksBottomToolbar.k(d.a));
                    }
                    if (com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(d.a).f() == -1)
                    {
                        com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(d.a).g(MakeupLooksBottomToolbar.l(d.a));
                    }
                    com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(d.a).notifyDataSetChanged();
                }

                public void b()
                {
                    com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.d(d.a, true);
                    d.a(a, b, c);
                }

            
            {
                d = MakeupLooksBottomToolbar._cls14.this;
                a = adapterview;
                b = view;
                c = j;
                super();
            }
            });
            c1.show();
            return;
        } else
        {
            a(adapterview, view, j);
            return;
        }
    }

    _cls1.c(MakeupLooksBottomToolbar makeuplooksbottomtoolbar)
    {
        a = makeuplooksbottomtoolbar;
        super();
    }
}
