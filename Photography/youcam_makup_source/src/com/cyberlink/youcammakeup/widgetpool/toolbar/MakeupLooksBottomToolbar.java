// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import android.animation.Animator;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import com.cyberlink.youcammakeup.BaseActivity;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.activity.ExtraDownloadCategoryActivity;
import com.cyberlink.youcammakeup.activity.i;
import com.cyberlink.youcammakeup.activity.k;
import com.cyberlink.youcammakeup.clflurry.YMKApplyEvent;
import com.cyberlink.youcammakeup.clflurry.YMKFeatureRoomLookEvent;
import com.cyberlink.youcammakeup.clflurry.YMKLooksStoreEvent;
import com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.clflurry.n;
import com.cyberlink.youcammakeup.database.more.types.CategoryType;
import com.cyberlink.youcammakeup.flurry.PopularityOfLookEvent;
import com.cyberlink.youcammakeup.jniproxy.bi;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierTaskInfo;
import com.cyberlink.youcammakeup.kernelctrl.VenusHelper;
import com.cyberlink.youcammakeup.kernelctrl.ar;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.o;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.q;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.r;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.s;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.u;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.v;
import com.cyberlink.youcammakeup.kernelctrl.j;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.g;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageViewer;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.f;
import com.cyberlink.youcammakeup.kernelctrl.status.ImageStateChangedEvent;
import com.cyberlink.youcammakeup.kernelctrl.status.SessionState;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.a;
import com.cyberlink.youcammakeup.kernelctrl.status.d;
import com.cyberlink.youcammakeup.kernelctrl.status.m;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.c;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.pages.editview.savemylook.LookItemPopupMenu;
import com.cyberlink.youcammakeup.pages.moreview.af;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.DownloadUseUtils;
import com.cyberlink.youcammakeup.utility.IntroDialogUtils;
import com.cyberlink.youcammakeup.utility.MakeupMode;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.SoftInputUtils;
import com.cyberlink.youcammakeup.utility.ao;
import com.cyberlink.youcammakeup.utility.as;
import com.cyberlink.youcammakeup.utility.at;
import com.cyberlink.youcammakeup.utility.av;
import com.cyberlink.youcammakeup.utility.bl;
import com.cyberlink.youcammakeup.utility.bn;
import com.cyberlink.youcammakeup.utility.bo;
import com.cyberlink.youcammakeup.utility.cc;
import com.cyberlink.youcammakeup.utility.ch;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.AdapterView;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.HorizontalGridView;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.p;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.cyberlink.youcammakeup.widgetpool.common.VerticalSeekBar;
import com.cyberlink.youcammakeup.widgetpool.dialogs.ah;
import com.cyberlink.youcammakeup.widgetpool.dialogs.an;
import com.cyberlink.youcammakeup.widgetpool.dialogs.e;
import com.cyberlink.youcammakeup.widgetpool.panel.lookspanel.LooksGridItem;
import com.cyberlink.youcammakeup.widgetpool.panel.lookspanel.LooksImageAdapter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            a, c, f, TopToolBar, 
//            g, l, b

public class MakeupLooksBottomToolbar extends com.cyberlink.youcammakeup.widgetpool.toolbar.a
    implements i, k, g, m
{

    private static int e = 0;
    private com.cyberlink.youcammakeup.widgetpool.toolbar.f A;
    private boolean B;
    private boolean C;
    private int D;
    private Runnable E;
    private final p F = new p() {

        final MakeupLooksBottomToolbar a;

        public void a(AdapterView adapterview, View view, int i1)
        {
            com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i j1;
            com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a, i1);
            view.setActivated(true);
            j1 = StatusManager.j().d();
            if (com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a).a(i1) != null) goto _L2; else goto _L1
_L1:
            return;
_L2:
            String s1;
            s1 = com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a).a(i1).a();
            adapterview = com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a).a(i1).c();
            if (j1 == null || !s1.equals(j1.v()))
            {
                break; /* Loop/switch isn't completed */
            }
            if (com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a).a(i1).n() != null && i1 != 0 && i1 != 1)
            {
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKFeatureRoomLookEvent(com.cyberlink.youcammakeup.clflurry.YMKFeatureRoomLookEvent.Operation.i, 0L, 0L, null, YMKFeatureRoomLookEvent.e(), null));
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKSavingPageEvent(0L, 0L, com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.Operation.o, false, false));
                com.cyberlink.youcammakeup.g.a(a.getActivity(), com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a).a(i1).n());
                return;
            }
            if (!com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.m(a)) goto _L1; else goto _L3
_L3:
            if (!StatusManager.j().E().booleanValue()) goto _L1; else goto _L4
_L4:
            com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.e(a, false);
            StatusManager.j().a(Boolean.valueOf(false));
            com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a).g(i1);
            a.a(com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.n(a));
            a.c(false);
            a.a("Apply", Boolean.valueOf(true));
            PopularityOfLookEvent.a(s1);
            PopularityOfLookEvent.b(adapterview);
            YMKApplyEvent.j(s1);
            YMKApplyEvent.k(adapterview);
            as as1 = PanelDataCenter.a().o(s1);
            if (as1.f() == com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.c)
            {
                adapterview = "customize";
            }
            if ("original".equalsIgnoreCase(adapterview))
            {
                adapterview = "original";
            }
            YMKSavingPageEvent.c(adapterview);
            if (as1.f() != com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.c && !com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.o(a))
            {
                com.cyberlink.youcammakeup.clflurry.at at1 = new com.cyberlink.youcammakeup.clflurry.at(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.a);
                at1.f(as1.a());
                com.cyberlink.youcammakeup.clflurry.b.a(at1.e());
            }
            view = (LooksGridItem)view;
            as as2 = com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a).a(i1);
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
            YMKSavingPageEvent.a(com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.n(a));
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKFeatureRoomLookEvent(com.cyberlink.youcammakeup.clflurry.YMKFeatureRoomLookEvent.Operation.h, 0L, 0L, as1.c(), YMKFeatureRoomLookEvent.e(), null));
            com.cyberlink.youcammakeup.clflurry.b.a((new YMKSavingPageEvent(0L, 0L, com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.Operation.n, false, false)).d(adapterview));
            if (as2.h().booleanValue() && !as2.i().booleanValue())
            {
                if (as2.j().booleanValue())
                {
                    com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.a(a, Integer.valueOf(i1), as2, view);
                } else
                {
                    adapterview = as2.k();
                    Globals.d().a(adapterview);
                    com.cyberlink.youcammakeup.utility.o.a(a.getActivity(), an.a(adapterview), "ShareToUnlockDialog");
                }
                StatusManager.j().a(Boolean.valueOf(true));
                return;
            }
            com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a).a(i1, false);
            com.pf.common.utility.m.b("MakeupLooksBottomToolbar", (new StringBuilder()).append("onGridViewItemClick mFirstIntentFromBCHowToCount = ").append(MakeupLooksBottomToolbar.t()).append(" position = ").append(i1).toString());
            if (MakeupLooksBottomToolbar.t() > 0)
            {
                com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.u();
            } else
            {
                Globals.d().b(false);
                com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a);
                LooksImageAdapter.c(-1);
            }
            com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.a(a, s1, true);
            com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a).notifyDataSetChanged();
            return;
        }

        public void a(AdapterView adapterview, View view, int i1, long l1)
        {
            if (com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a) != null && com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a).c())
            {
                com.cyberlink.youcammakeup.utility.o.c();
                com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a).notifyDataSetChanged();
                return;
            }
            if (i1 != 0) goto _L2; else goto _L1
_L1:
            com.cyberlink.youcammakeup.kernelctrl.z.a("HAS_SET_SEEN_MAKEUP_LOOK_RED_ICON", Boolean.valueOf(true), Globals.d());
            a.c(true);
            view = new Intent(view.getContext(), com/cyberlink/youcammakeup/activity/ExtraDownloadCategoryActivity);
            if (com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a).i() == com.cyberlink.youcammakeup.utility.PanelDataCenter.LookType.a)
            {
                adapterview = CategoryType.b;
            } else
            {
                adapterview = CategoryType.c;
            }
            if (adapterview != CategoryType.b) goto _L4; else goto _L3
_L3:
            YMKLooksStoreEvent.b(com.cyberlink.youcammakeup.clflurry.YMKLooksStoreEvent.Source.b.a());
_L5:
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKFeatureRoomLookEvent(com.cyberlink.youcammakeup.clflurry.YMKFeatureRoomLookEvent.Operation.j, 0L, 0L, null, YMKFeatureRoomLookEvent.e(), null));
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKSavingPageEvent(0L, 0L, com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.Operation.p, false, false));
            view.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_ID", CategoryType.a(adapterview));
            view.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_NAME", a.getString(0x7f070502));
            view.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_TYPE", adapterview);
            view.putExtra("KEY_EXTRA_DOWNLOAD_DISPLAY_TYPE", com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType.b.ordinal());
            view.putExtra("KEY_EXTRA_DOWNLOAD_BACK_TO_MAIN", false);
            DownloadUseUtils.a(view, true);
            a.startActivity(view);
            return;
_L4:
            if (adapterview == CategoryType.c)
            {
                YMKLooksStoreEvent.b(com.cyberlink.youcammakeup.clflurry.YMKLooksStoreEvent.Source.c.a());
            }
            if (true) goto _L5; else goto _L2
_L2:
            if (com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.i(a) && !com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.j(a))
            {
                com.cyberlink.youcammakeup.widgetpool.dialogs.c c1 = new com.cyberlink.youcammakeup.widgetpool.dialogs.c(a.getActivity(), true);
                c1.a(new com.cyberlink.youcammakeup.widgetpool.dialogs.d(this, adapterview, view, i1) {

                    final AdapterView a;
                    final View b;
                    final int c;
                    final _cls14 d;

                    public void a()
                    {
                        Activity activity = d.a.getActivity();
                        if (activity != null && (activity instanceof EditViewActivity))
                        {
                            ((EditViewActivity)activity).b(com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.k(d.a));
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
                d = _pcls14;
                a = adapterview;
                b = view;
                c = i1;
                super();
            }
                });
                c1.show();
                return;
            } else
            {
                a(adapterview, view, i1);
                return;
            }
        }

            
            {
                a = MakeupLooksBottomToolbar.this;
                super();
            }
    };
    private final com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.q G = new com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.q() {

        final MakeupLooksBottomToolbar a;
        private final android.content.DialogInterface.OnDismissListener b = new _cls1(this);
        private final com.cyberlink.youcammakeup.pages.editview.savemylook.a c = new _cls2(this);

        public boolean a(AdapterView adapterview, View view, int i1, long l1)
        {
            boolean flag = false;
            if (com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a) != null && !com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a).c() && !com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a).d() && i1 != 0 && i1 != 1)
            {
                if (!(adapterview = com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a).a(i1)).h().booleanValue() || adapterview.i().booleanValue())
                {
                    com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a).c(true);
                    adapterview = new LookItemPopupMenu();
                    adapterview.a(view);
                    adapterview.a(com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a).f(i1));
                    if (!com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a).e(i1))
                    {
                        flag = true;
                    }
                    adapterview.b(flag);
                    adapterview.a(b);
                    adapterview.a(c);
                    com.cyberlink.youcammakeup.utility.o.a(a.getFragmentManager(), adapterview, "LookItemPopupMenu");
                    return true;
                }
            }
            return false;
        }

            
            {
                a = MakeupLooksBottomToolbar.this;
                super();
            }
    };
    private com.cyberlink.youcammakeup.activity.c H;
    private final android.view.View.OnClickListener I = new android.view.View.OnClickListener() {

        final MakeupLooksBottomToolbar a;

        public void onClick(View view)
        {
            if (com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a).c() || com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a).d()) goto _L2; else goto _L1
_L1:
            return;
_L2:
            if (!((view = ((View) (view.getTag()))) instanceof com.cyberlink.youcammakeup.widgetpool.panel.lookspanel.f)) goto _L1; else goto _L3
_L3:
            int i1;
            int j1;
            view = (com.cyberlink.youcammakeup.widgetpool.panel.lookspanel.f)view;
            PanelDataCenter.a().c(((com.cyberlink.youcammakeup.widgetpool.panel.lookspanel.f) (view)).a, false);
            i1 = com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a).f();
            j1 = com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.a(a, ((com.cyberlink.youcammakeup.widgetpool.panel.lookspanel.f) (view)).a);
            com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a).b();
            if (i1 != j1) goto _L5; else goto _L4
_L4:
            com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.a(a, "default_original_looks", true);
            a.a("Apply", Boolean.valueOf(false));
            com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a).g(1);
            view = a.getActivity();
            if (view != null && (view instanceof EditViewActivity))
            {
                EditViewActivity editviewactivity = (EditViewActivity)view;
                boolean flag;
                if (a.r() && ((EditViewActivity)view).ab())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                editviewactivity.u(flag);
            }
_L7:
            if (com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a).c() && !com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a).e())
            {
                com.cyberlink.youcammakeup.utility.o.c();
                com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a).b(false);
            }
            com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a).notifyDataSetChanged();
            return;
_L5:
            if (i1 > j1)
            {
                com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a).g(i1 - 1);
            }
            if (true) goto _L7; else goto _L6
_L6:
        }

            
            {
                a = MakeupLooksBottomToolbar.this;
                super();
            }
    };
    public android.widget.SeekBar.OnSeekBarChangeListener d;
    private HorizontalGridView f;
    private LooksImageAdapter g;
    private a h;
    private String i;
    private com.cyberlink.youcammakeup.widgetpool.toolbar.g j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private VerticalSeekBar p;
    private View q;
    private int r;
    private int s;
    private boolean t;
    private boolean u;
    private com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i v;
    private int w;
    private LinearLayout x;
    private View y;
    private View z;

    public MakeupLooksBottomToolbar()
    {
        m = false;
        n = false;
        o = false;
        p = null;
        q = null;
        r = 80;
        s = 0;
        t = true;
        u = true;
        v = null;
        w = 0;
        A = null;
        B = true;
        C = false;
        D = -1;
        d = new android.widget.SeekBar.OnSeekBarChangeListener() {

            final MakeupLooksBottomToolbar a;

            public void onProgressChanged(SeekBar seekbar, int i1, boolean flag)
            {
                YMKFeatureRoomLookEvent.d();
                YMKSavingPageEvent.c(true);
                YMKSavingPageEvent.a(i1);
                EditViewActivity editviewactivity = Globals.d().t();
                if (editviewactivity == null)
                {
                    return;
                }
                if (com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.d(a) && !MotionControlHelper.e().aC())
                {
                    a.a(seekbar.getProgress(), false);
                    com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.a(a, false);
                }
                editviewactivity.b(Integer.toString(i1));
            }

            public void onStartTrackingTouch(SeekBar seekbar)
            {
                seekbar = Globals.d().t();
                if (seekbar == null)
                {
                    return;
                }
                com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a, false);
                seekbar.v(true);
                TopToolBar toptoolbar = a.e();
                if (toptoolbar != null)
                {
                    toptoolbar.a(Boolean.valueOf(true));
                    toptoolbar.a(true);
                }
                seekbar.a(Boolean.valueOf(false));
                seekbar.f(true);
                com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.c(a).setEnabled(false);
            }

            public void onStopTrackingTouch(SeekBar seekbar)
            {
                EditViewActivity editviewactivity = Globals.d().t();
                if (editviewactivity == null)
                {
                    return;
                }
                com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a, true);
                com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.a(a, seekbar.getProgress());
                com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.e(a);
                editviewactivity.v(false);
                editviewactivity.f(false);
                editviewactivity.a(Boolean.valueOf(true));
                seekbar = a.e();
                if (seekbar != null)
                {
                    seekbar.a(false);
                    seekbar.a(Boolean.valueOf(false));
                }
                com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.c(a).setEnabled(true);
            }

            
            {
                a = MakeupLooksBottomToolbar.this;
                super();
            }
        };
        E = new Runnable() {

            final MakeupLooksBottomToolbar a;

            public void run()
            {
                if (!com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.d(a) || MotionControlHelper.e().aC())
                {
                    Globals.a(com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.f(a), 300L);
                } else
                if (!a.a(com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.g(a), true) && (a.getActivity() instanceof BaseActivity))
                {
                    ((BaseActivity)a.getActivity()).i();
                    return;
                }
            }

            
            {
                a = MakeupLooksBottomToolbar.this;
                super();
            }
        };
        H = new com.cyberlink.youcammakeup.activity.c() {

            final MakeupLooksBottomToolbar a;

            public void a()
            {
                Object obj = a.getActivity();
                if (!(obj instanceof EditViewActivity))
                {
                    return;
                } else
                {
                    obj = (EditViewActivity)obj;
                    ((EditViewActivity) (obj)).b(this);
                    ((EditViewActivity) (obj)).b(false, false);
                    a.c(true);
                    return;
                }
            }

            
            {
                a = MakeupLooksBottomToolbar.this;
                super();
            }
        };
    }

    private boolean A()
    {
        long l1 = StatusManager.j().l();
        Object obj = StatusManager.j().c(l1);
        boolean flag2 = ((d) (obj)).h();
        boolean flag;
        boolean flag1;
        if (flag2)
        {
            a a1 = ((d) (obj)).e();
            if (((d) (obj)).f() != null)
            {
                obj = ((d) (obj)).f();
            } else
            if (((d) (obj)).g() != null)
            {
                obj = ((d) (obj)).g().a();
            } else
            {
                obj = null;
            }
            flag1 = a(((a) (obj)), a1);
            if (a1 != null && a1.f() != null && a1.f().g() != null)
            {
                flag = a1.f().g().x();
            } else
            {
                flag = true;
            }
        } else
        {
            flag = true;
            flag1 = false;
        }
        return flag2 && !flag1 && !flag;
    }

    private void B()
    {
        Object obj = StatusManager.j().d().v();
        if (obj != null)
        {
            com.cyberlink.youcammakeup.utility.PanelDataCenter.LookType looktype = com.cyberlink.youcammakeup.utility.PanelDataCenter.LookType.a(PanelDataCenter.a().n(((String) (obj))));
            if (looktype != g.i())
            {
                c(looktype);
            }
        }
        int i1 = c(((String) (obj)));
        g.g(i1);
        if (i1 > -1)
        {
            f.c(i1);
            a("Apply", Boolean.valueOf(true));
        } else
        {
            a("Apply", Boolean.valueOf(false));
        }
        obj = getActivity();
        if (obj != null && (obj instanceof EditViewActivity))
        {
            EditViewActivity editviewactivity = (EditViewActivity)obj;
            boolean flag;
            if (r() && ((EditViewActivity)obj).ab())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            editviewactivity.u(flag);
        }
    }

    static int a(MakeupLooksBottomToolbar makeuplooksbottomtoolbar, int i1)
    {
        makeuplooksbottomtoolbar.w = i1;
        return i1;
    }

    static int a(MakeupLooksBottomToolbar makeuplooksbottomtoolbar, String s1)
    {
        return makeuplooksbottomtoolbar.c(s1);
    }

    static com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i a(MakeupLooksBottomToolbar makeuplooksbottomtoolbar, com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i i1)
    {
        makeuplooksbottomtoolbar.v = i1;
        return i1;
    }

    private o a(List list)
    {
        o o1 = new o();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) 
        {
            ao ao1 = (ao)iterator.next();
            list = ao1.f();
            if (list.size() > 0)
            {
                list = (at)list.get(0);
            } else
            {
                list = null;
            }
            o1.a(ao1.b(), list);
        }
        return o1;
    }

    private u a(ao ao1, u u1)
    {
        boolean flag = false;
        List list = a(ao1);
        String s1 = ao1.b();
        String s2 = ao1.c();
        float f1;
        bi bi1;
        if (list != null && list.size() > 0)
        {
            f1 = ((at)list.get(0)).d();
        } else
        {
            f1 = 50F;
        }
        if (u1 != null && u1.b().equals(ao1.b()))
        {
            ao1 = u1.a();
        } else
        {
            ao1 = (new StringBuilder()).append(MotionControlHelper.c).append("/").append(UUID.randomUUID().toString()).toString();
        }
        if (u1 != null && !u1.b().equals("default_original_wig") && u1.h() != null)
        {
            bi1 = new bi(u1.h());
        } else
        {
            bi1 = null;
        }
        if (u1 != null)
        {
            flag = u1.j();
        }
        return new u(s1, s2, list, f1, ao1, bi1, flag);
    }

    static ImageViewer a(MakeupLooksBottomToolbar makeuplooksbottomtoolbar)
    {
        return makeuplooksbottomtoolbar.v();
    }

    public static at a(ao ao1, int i1)
    {
        Object obj = null;
        at at1 = obj;
        if (ao1 != null)
        {
            ao1 = ao1.f();
            at1 = obj;
            if (ao1 != null)
            {
                at1 = obj;
                if (i1 >= 0)
                {
                    at1 = obj;
                    if (i1 < ao1.size())
                    {
                        at1 = (at)ao1.get(i1);
                    }
                }
            }
        }
        ao1 = at1;
        if (at1 == null)
        {
            ao1 = new at(0);
            String s1 = Arrays.toString(Thread.currentThread().getStackTrace());
            com.pf.common.utility.m.c("getEffectMakeupColor", (new StringBuilder()).append("Create a default color.\n").append(s1).toString());
        }
        return ao1;
    }

    static com.cyberlink.youcammakeup.widgetpool.toolbar.f a(MakeupLooksBottomToolbar makeuplooksbottomtoolbar, com.cyberlink.youcammakeup.widgetpool.toolbar.f f1)
    {
        makeuplooksbottomtoolbar.A = f1;
        return f1;
    }

    public static List a(ao ao1)
    {
        if (ao1 != null && ao1.e() > 0)
        {
            return ao1.f();
        } else
        {
            ao1 = new ArrayList();
            ao1.add(new at(0));
            String s1 = Arrays.toString(Thread.currentThread().getStackTrace());
            com.pf.common.utility.m.c("getEffectMakeupColor", (new StringBuilder()).append("Create a default color.\n").append(s1).toString());
            return ao1;
        }
    }

    private void a(ImageViewer imageviewer)
    {
        if (imageviewer == null)
        {
            return;
        } else
        {
            (new f()).a = true;
            imageviewer.b(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.a, new f());
            imageviewer.b(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.b, new f());
            return;
        }
    }

    private void a(ImageViewer imageviewer, boolean flag)
    {
        if (imageviewer == null)
        {
            return;
        } else
        {
            f f1 = new f();
            f1.a = true;
            f1.c = new c(com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine.TaskRole.d);
            f1.c.f = Boolean.valueOf(flag);
            imageviewer.b(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c, f1);
            return;
        }
    }

    private void a(com.cyberlink.youcammakeup.utility.DownloadUseUtils.UseTemplate usetemplate)
    {
        if (usetemplate != null && g != null && !com.cyberlink.youcammakeup.widgetpool.toolbar.c.a(getActivity()))
        {
            int i1 = c(usetemplate.typeGUID);
            if (i1 >= 0)
            {
                DownloadUseUtils.a(true);
                DownloadUseUtils.b(getActivity());
                f.a(g.getView(i1, null, f), i1, -1L);
                f.c(i1);
                usetemplate = g;
                LooksImageAdapter.c(i1);
                return;
            }
        }
    }

    private void a(com.cyberlink.youcammakeup.utility.PanelDataCenter.LookType looktype)
    {
        o = true;
        D = -1;
        long l1 = StatusManager.j().l();
        k = false;
        A = new com.cyberlink.youcammakeup.widgetpool.toolbar.f(this, false);
        if (getActivity() instanceof BaseActivity)
        {
            ((BaseActivity)getActivity()).h();
        }
        g = new LooksImageAdapter(getActivity(), looktype, I);
        StatusManager.j().a(A);
        f = (HorizontalGridView)getView().findViewById(0x7f0c050c);
        f.setAdapter(g);
        f.setOnItemClickListener(F);
        f.setOnItemLongClickListener(G);
        t = true;
        v = null;
        x = (LinearLayout)getView().findViewById(0x7f0c0507);
        y = getView().findViewById(0x7f0c0508);
        y.setOnClickListener(new android.view.View.OnClickListener() {

            final MakeupLooksBottomToolbar a;

            public void onClick(View view)
            {
                com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.a(a, com.cyberlink.youcammakeup.utility.PanelDataCenter.LookType.a);
            }

            
            {
                a = MakeupLooksBottomToolbar.this;
                super();
            }
        });
        z = getView().findViewById(0x7f0c0509);
        z.setOnClickListener(new android.view.View.OnClickListener() {

            final MakeupLooksBottomToolbar a;

            public void onClick(View view)
            {
                com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.a(a, com.cyberlink.youcammakeup.utility.PanelDataCenter.LookType.b);
            }

            
            {
                a = MakeupLooksBottomToolbar.this;
                super();
            }
        });
        c(looktype);
        if (Globals.d().W())
        {
            e = 1;
        }
        MotionControlHelper.e().n();
        boolean flag;
        if (i == null)
        {
            MotionControlHelper motioncontrolhelper = MotionControlHelper.e();
            if (h == null)
            {
                looktype = StatusManager.j().f(l1);
            } else
            {
                looktype = h;
            }
            motioncontrolhelper.b(looktype);
        }
        com.cyberlink.youcammakeup.kernelctrl.j.a().a(false);
        looktype = Globals.d().t();
        flag = IntroDialogUtils.b(getFragmentManager(), null, null);
        if (looktype != null)
        {
            if (!flag)
            {
                looktype.a(false, null);
            }
            looktype.a(this);
            q = getActivity().findViewById(0x7f0c00e3);
            p = (VerticalSeekBar)q.findViewById(0x7f0c00e4);
            if (p != null)
            {
                p.setOnSeekBarChangeListener(d);
            }
            looktype.a(Boolean.valueOf(true));
        }
        if (looktype != null)
        {
            flag = looktype.A();
            looktype.a(this);
        } else
        {
            flag = false;
        }
        if (flag)
        {
            looktype = StatusManager.j().j(StatusManager.j().l());
        } else
        {
            looktype = StatusManager.j().c(StatusManager.j().l());
        }
        if (looktype != null)
        {
            looktype = looktype.e();
            if (looktype != null && looktype.f() != null)
            {
                looktype.f().a(MotionControlHelper.e().f());
            }
        }
        d(true);
        StatusManager.j().a(this);
        looktype = e();
        if (looktype != null)
        {
            looktype.a(Boolean.valueOf(false));
        }
    }

    static void a(MakeupLooksBottomToolbar makeuplooksbottomtoolbar, ImageViewer imageviewer)
    {
        makeuplooksbottomtoolbar.a(imageviewer);
    }

    static void a(MakeupLooksBottomToolbar makeuplooksbottomtoolbar, ImageViewer imageviewer, boolean flag)
    {
        makeuplooksbottomtoolbar.a(imageviewer, flag);
    }

    static void a(MakeupLooksBottomToolbar makeuplooksbottomtoolbar, com.cyberlink.youcammakeup.utility.DownloadUseUtils.UseTemplate usetemplate)
    {
        makeuplooksbottomtoolbar.a(usetemplate);
    }

    static void a(MakeupLooksBottomToolbar makeuplooksbottomtoolbar, com.cyberlink.youcammakeup.utility.PanelDataCenter.LookType looktype)
    {
        makeuplooksbottomtoolbar.c(looktype);
    }

    static void a(MakeupLooksBottomToolbar makeuplooksbottomtoolbar, Integer integer, as as1, LooksGridItem looksgriditem)
    {
        makeuplooksbottomtoolbar.a(integer, as1, looksgriditem);
    }

    static void a(MakeupLooksBottomToolbar makeuplooksbottomtoolbar, String s1, boolean flag)
    {
        makeuplooksbottomtoolbar.a(s1, flag);
    }

    private void a(Integer integer, as as1, LooksGridItem looksgriditem)
    {
        Activity activity = getActivity();
        if (looksgriditem.c())
        {
            bn.a(as1.k());
            return;
        } else
        {
            looksgriditem.b();
            bn.a(CategoryType.a(CategoryType.a), as1.k(), new com.cyberlink.youcammakeup.kernelctrl.networkmanager.j(activity, as1, looksgriditem, integer) {

                final Activity a;
                final as b;
                final LooksGridItem c;
                final Integer d;
                final MakeupLooksBottomToolbar e;

                public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.a a1)
                {
                    int i1 = Math.min(100, af.a(a1));
                    a.runOnUiThread(new Runnable(this, i1) {

                        final int a;
                        final _cls2 b;

                        public void run()
                        {
                            b.c.setProgress(a);
                        }

            
            {
                b = _pcls2;
                a = i1;
                super();
            }
                    });
                }

                public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn bn1)
                {
                    if (d == (Integer)c.getTag())
                    {
                        a.runOnUiThread(new Runnable(this) {

                            final _cls2 a;

                            public void run()
                            {
                                a.c.a(true, false);
                                String s1 = a.a.getString(0x7f070534);
                                Globals.d().i().a(a.a, null, new android.view.View.OnClickListener(this) {

                                    final _cls2 a;

                                    public void onClick(View view)
                                    {
                                        com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.c(a.a.e).a(a.a.c, a.a.d.intValue(), a.a.c.getId());
                                    }

            
            {
                a = _pcls2;
                super();
            }
                                }, null, s1);
                            }

            
            {
                a = _pcls2;
                super();
            }
                        });
                    }
                }

                public volatile void a(Object obj)
                {
                    a((Void)obj);
                }

                public void a(Void void1)
                {
                    a.runOnUiThread(new Runnable(this) {

                        final _cls2 a;

                        public void run()
                        {
                            a.b.a(Boolean.valueOf(true));
                            a.c.a(true, true);
                            com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.c(a.e, a.d.intValue());
                        }

            
            {
                a = _pcls2;
                super();
            }
                    });
                }

                public void b(Object obj)
                {
                    a((com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn)obj);
                }

                public void b(Void void1)
                {
                }

                public void c(Object obj)
                {
                    b((Void)obj);
                }

                public void d(Object obj)
                {
                    a((com.cyberlink.youcammakeup.kernelctrl.networkmanager.a)obj);
                }

            
            {
                e = MakeupLooksBottomToolbar.this;
                a = activity;
                b = as1;
                c = looksgriditem;
                d = integer;
                super();
            }
            });
            return;
        }
    }

    private void a(String s1, boolean flag)
    {
        s1 = d(s1);
        MotionControlHelper.e().s(true);
        com.cyberlink.youcammakeup.jniproxy.az az = VenusHelper.a().a(s1);
        az = VenusHelper.a().a(az, r);
        s1 = VenusHelper.a().a(s1, az);
        if (MotionControlHelper.e().a(s1, new BeautifierTaskInfo(flag)))
        {
            if (getActivity() instanceof BaseActivity)
            {
                ((BaseActivity)getActivity()).a(0L);
            }
            s1.a(r);
            v = new com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i(s1);
            StatusManager.j().a(s1);
        } else
        {
            MotionControlHelper.e().s(false);
            if (MotionControlHelper.e().az() == com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.ConfigErrorCode.b)
            {
                MotionControlHelper.e().s();
                MotionControlHelper.e().n();
                if (MotionControlHelper.e().a(s1, new BeautifierTaskInfo(flag)))
                {
                    if (getActivity() instanceof BaseActivity)
                    {
                        ((BaseActivity)getActivity()).a(0L);
                    }
                    StatusManager.j().a(s1);
                } else
                {
                    StatusManager.j().a(Boolean.valueOf(true));
                }
            } else
            {
                StatusManager.j().a(Boolean.valueOf(true));
            }
        }
        com.cyberlink.youcammakeup.kernelctrl.j.a().f();
    }

    private boolean a(com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i i1, com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i j1)
    {
        while (i1 != null && i1.v() == null && j1 != null && j1.v() == null || i1 != null && i1.v() != null && j1 != null && j1.v() != null && i1.v().equals(j1.v())) 
        {
            return false;
        }
        return true;
    }

    private boolean a(a a1, a a2)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (a1 != null)
        {
            flag = flag1;
            if (a2 != null)
            {
                flag = flag1;
                if (a1.e != a2.e)
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    static boolean a(MakeupLooksBottomToolbar makeuplooksbottomtoolbar, boolean flag)
    {
        makeuplooksbottomtoolbar.t = flag;
        return flag;
    }

    static int b(MakeupLooksBottomToolbar makeuplooksbottomtoolbar, int i1)
    {
        makeuplooksbottomtoolbar.D = i1;
        return i1;
    }

    private View b(int i1)
    {
        if (i1 < f.getFirstVisiblePosition() || i1 > f.getLastVisiblePosition())
        {
            return null;
        } else
        {
            return f.getChildAt(i1 - f.getFirstVisiblePosition());
        }
    }

    static com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i b(MakeupLooksBottomToolbar makeuplooksbottomtoolbar, String s1)
    {
        return makeuplooksbottomtoolbar.d(s1);
    }

    private r b(ao ao1)
    {
        List list = a(ao1);
        MotionControlHelper.e().b(list);
        return new r(ao1.b(), ao1.c(), null, list, a(ao1, 0).d());
    }

    static LooksImageAdapter b(MakeupLooksBottomToolbar makeuplooksbottomtoolbar)
    {
        return makeuplooksbottomtoolbar.g;
    }

    private void b(com.cyberlink.youcammakeup.utility.PanelDataCenter.LookType looktype)
    {
        TopToolBar toptoolbar = e();
        if (toptoolbar != null)
        {
            j = new com.cyberlink.youcammakeup.widgetpool.toolbar.g(this);
            toptoolbar.a(j);
            l l1 = new l();
            l1.a = false;
            int i1;
            if (looktype == com.cyberlink.youcammakeup.utility.PanelDataCenter.LookType.a)
            {
                i1 = 0x7f070502;
            } else
            {
                i1 = 0x7f0703e1;
            }
            l1.c = Globals.d().getString(i1);
            if (StatusManager.j().s() == BeautyMode.D && StatusManager.j().r() == MakeupMode.g)
            {
                l1.b = true;
            }
            toptoolbar.a(l1);
            a("Apply", Boolean.valueOf(false));
        }
    }

    static boolean b(MakeupLooksBottomToolbar makeuplooksbottomtoolbar, boolean flag)
    {
        makeuplooksbottomtoolbar.u = flag;
        return flag;
    }

    private int c(String s1)
    {
        if (s1 != null && !s1.equals("")) goto _L2; else goto _L1
_L1:
        int j1 = -1;
_L4:
        return j1;
_L2:
        int i1 = 0;
label0:
        do
        {
label1:
            {
                if (i1 >= g.getCount())
                {
                    break label1;
                }
                j1 = i1;
                if (s1.equals(g.a(i1).a()))
                {
                    break label0;
                }
                i1++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        return -1;
    }

    private r c(ao ao1)
    {
        at at1 = a(ao1, 0);
        return new r(ao1.b(), at1, at1.d());
    }

    static HorizontalGridView c(MakeupLooksBottomToolbar makeuplooksbottomtoolbar)
    {
        return makeuplooksbottomtoolbar.f;
    }

    private void c(int i1)
    {
        Globals.d(new Runnable(i1) {

            final int a;
            final MakeupLooksBottomToolbar b;

            public void run()
            {
                if (com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(b) != null)
                {
                    com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(b).a(a, false);
                    com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(b).g(a);
                    com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.a(b, com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(b).a(a).a(), true);
                }
            }

            
            {
                b = MakeupLooksBottomToolbar.this;
                a = i1;
                super();
            }
        });
    }

    private void c(ImageStateChangedEvent imagestatechangedevent)
    {
        a a1;
        com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i i1;
        com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i j1;
        if (imagestatechangedevent != null && imagestatechangedevent.c() != null && imagestatechangedevent.c().a() != null && imagestatechangedevent.c().a().f() != null)
        {
            i1 = imagestatechangedevent.c().a().f().g();
            a1 = imagestatechangedevent.c().a();
        } else
        {
            a1 = null;
            i1 = null;
        }
        if (imagestatechangedevent != null && imagestatechangedevent.b() != null && imagestatechangedevent.b().a() != null && imagestatechangedevent.b().a().f() != null)
        {
            j1 = imagestatechangedevent.b().a().f().g();
            imagestatechangedevent = imagestatechangedevent.b().a();
        } else
        {
            imagestatechangedevent = null;
            j1 = null;
        }
        if (a1 != null && imagestatechangedevent != null && a(a1, imagestatechangedevent))
        {
            MotionControlHelper.e().b(imagestatechangedevent);
            if (imagestatechangedevent.f() != null && imagestatechangedevent.f().h() != null)
            {
                MotionControlHelper.e().a(imagestatechangedevent.f().h(), false);
            } else
            if (imagestatechangedevent.d() != null && ((a) (imagestatechangedevent)).e >= 0 && ((a) (imagestatechangedevent)).e < imagestatechangedevent.d().size())
            {
                MotionControlHelper.e().a(Boolean.valueOf(((ar)imagestatechangedevent.d().get(((a) (imagestatechangedevent)).e)).f), false);
            } else
            {
                MotionControlHelper.e().a(null, false);
            }
            if (g != null)
            {
                g.j();
            }
        }
        if (i1 != null && i1.v() != null && j1 != null && j1.v() != null && i1.v().equals(j1.v()) && i1.w() == j1.w())
        {
            return;
        }
        if (a(i1, j1))
        {
            B();
            v = d(j1.v());
        }
        a(j1.w());
        c(false);
    }

    private void c(com.cyberlink.youcammakeup.utility.PanelDataCenter.LookType looktype)
    {
        for (int i1 = 0; i1 < x.getChildCount(); i1++)
        {
            x.getChildAt(i1).setSelected(false);
        }

        Object obj;
        if (looktype == com.cyberlink.youcammakeup.utility.PanelDataCenter.LookType.b)
        {
            z.setSelected(true);
            obj = com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.Operation.j;
        } else
        {
            y.setSelected(true);
            obj = com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.Operation.i;
        }
        if (looktype == g.i())
        {
            return;
        }
        com.cyberlink.youcammakeup.clflurry.b.a(new YMKSavingPageEvent(0L, 0L, ((com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.Operation) (obj)), false, false));
        e(false);
        c(true);
        if (A != null)
        {
            StatusManager.j().b(A);
            A = null;
        }
        if (getActivity() instanceof BaseActivity)
        {
            ((BaseActivity)getActivity()).a(MakeupMode.g);
        }
        A = new com.cyberlink.youcammakeup.widgetpool.toolbar.f(this, true);
        StatusManager.j().a(A);
        g.a(looktype);
        obj = e();
        Globals globals = Globals.d();
        int j1;
        if (looktype == com.cyberlink.youcammakeup.utility.PanelDataCenter.LookType.a)
        {
            j1 = 0x7f070502;
        } else
        {
            j1 = 0x7f0703e1;
        }
        ((TopToolBar) (obj)).a(globals.getString(j1));
    }

    static void c(MakeupLooksBottomToolbar makeuplooksbottomtoolbar, int i1)
    {
        makeuplooksbottomtoolbar.c(i1);
    }

    static boolean c(MakeupLooksBottomToolbar makeuplooksbottomtoolbar, boolean flag)
    {
        makeuplooksbottomtoolbar.m = flag;
        return flag;
    }

    private com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i d(String s1)
    {
        List list = bo.z(s1).m();
        com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i i1 = new com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i();
        i1.a(s1);
        i1.a(true);
        com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i j1 = StatusManager.j().d();
        long l1 = StatusManager.j().l();
        s1 = StatusManager.j().f(l1);
        ArrayList arraylist;
        ArrayList arraylist1;
        Iterator iterator;
        boolean flag;
        if (s1.f() == null)
        {
            s1 = null;
        } else
        {
            s1 = s1.f().g();
        }
        arraylist = new ArrayList();
        arraylist1 = new ArrayList();
        iterator = list.iterator();
        flag = false;
        do
        {
            if (iterator.hasNext())
            {
                ao ao1 = (ao)iterator.next();
                class _cls7
                {

                    static final int a[];

                    static 
                    {
                        a = new int[BeautyMode.values().length];
                        try
                        {
                            a[BeautyMode.n.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror13) { }
                        try
                        {
                            a[BeautyMode.l.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError nosuchfielderror12) { }
                        try
                        {
                            a[BeautyMode.m.ordinal()] = 3;
                        }
                        catch (NoSuchFieldError nosuchfielderror11) { }
                        try
                        {
                            a[BeautyMode.b.ordinal()] = 4;
                        }
                        catch (NoSuchFieldError nosuchfielderror10) { }
                        try
                        {
                            a[BeautyMode.a.ordinal()] = 5;
                        }
                        catch (NoSuchFieldError nosuchfielderror9) { }
                        try
                        {
                            a[BeautyMode.v.ordinal()] = 6;
                        }
                        catch (NoSuchFieldError nosuchfielderror8) { }
                        try
                        {
                            a[BeautyMode.r.ordinal()] = 7;
                        }
                        catch (NoSuchFieldError nosuchfielderror7) { }
                        try
                        {
                            a[BeautyMode.s.ordinal()] = 8;
                        }
                        catch (NoSuchFieldError nosuchfielderror6) { }
                        try
                        {
                            a[BeautyMode.x.ordinal()] = 9;
                        }
                        catch (NoSuchFieldError nosuchfielderror5) { }
                        try
                        {
                            a[BeautyMode.t.ordinal()] = 10;
                        }
                        catch (NoSuchFieldError nosuchfielderror4) { }
                        try
                        {
                            a[BeautyMode.y.ordinal()] = 11;
                        }
                        catch (NoSuchFieldError nosuchfielderror3) { }
                        try
                        {
                            a[BeautyMode.j.ordinal()] = 12;
                        }
                        catch (NoSuchFieldError nosuchfielderror2) { }
                        try
                        {
                            a[BeautyMode.k.ordinal()] = 13;
                        }
                        catch (NoSuchFieldError nosuchfielderror1) { }
                        try
                        {
                            a[BeautyMode.d.ordinal()] = 14;
                        }
                        catch (NoSuchFieldError nosuchfielderror)
                        {
                            return;
                        }
                    }
                }

                switch (com.cyberlink.youcammakeup.widgetpool.toolbar._cls7.a[ao1.a().ordinal()])
                {
                case 1: // '\001'
                    i1.a(b(ao1));
                    break;

                case 2: // '\002'
                    i1.b(d(ao1));
                    break;

                case 3: // '\003'
                    i1.c(e(ao1));
                    break;

                case 4: // '\004'
                    i1.f(c(ao1));
                    break;

                case 5: // '\005'
                    i1.d(f(ao1));
                    break;

                case 6: // '\006'
                    i1.e(g(ao1));
                    break;

                case 7: // '\007'
                    i1.a(h(ao1));
                    break;

                case 8: // '\b'
                    i1.a(i(ao1));
                    break;

                case 9: // '\t'
                    u u1;
                    if (s1 != null)
                    {
                        u1 = s1.u();
                    } else
                    {
                        u1 = null;
                    }
                    i1.a(a(ao1, u1));
                    break;

                case 10: // '\n'
                    i1.a(j(ao1));
                    break;

                case 11: // '\013'
                    i1.a(k(ao1));
                    break;

                case 12: // '\f'
                    arraylist.add(ao1);
                    break;

                case 13: // '\r'
                    arraylist1.add(ao1);
                    break;

                case 14: // '\016'
                    i1.d(ao1.g());
                    flag = true;
                    break;
                }
            } else
            {
                if (arraylist.size() > 0)
                {
                    i1.a(a(arraylist));
                }
                if (arraylist1.size() > 0)
                {
                    i1.b(a(arraylist1));
                }
                if (j1 != null && !flag && j1.m() > 0.0F)
                {
                    i1.d(j1.m());
                }
                i1.h(45F);
                return i1;
            }
        } while (true);
    }

    private r d(ao ao1)
    {
        List list = a(ao1);
        return new r(ao1.b(), ao1.c(), ao1.i(), list, ((at)list.get(0)).d());
    }

    private void d(boolean flag)
    {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof EditViewActivity))
        {
            ((EditViewActivity)activity).b(flag);
        }
    }

    static boolean d(MakeupLooksBottomToolbar makeuplooksbottomtoolbar)
    {
        return makeuplooksbottomtoolbar.t;
    }

    static boolean d(MakeupLooksBottomToolbar makeuplooksbottomtoolbar, boolean flag)
    {
        makeuplooksbottomtoolbar.C = flag;
        return flag;
    }

    private r e(ao ao1)
    {
        List list = a(ao1);
        return new r(ao1.b(), ao1.c(), ao1.i(), list, ((at)list.get(0)).d());
    }

    static void e(MakeupLooksBottomToolbar makeuplooksbottomtoolbar)
    {
        makeuplooksbottomtoolbar.x();
    }

    private void e(boolean flag)
    {
        for (int i1 = 0; i1 < x.getChildCount(); i1++)
        {
            x.getChildAt(i1).setEnabled(flag);
        }

    }

    static boolean e(MakeupLooksBottomToolbar makeuplooksbottomtoolbar, boolean flag)
    {
        makeuplooksbottomtoolbar.n = flag;
        return flag;
    }

    private boolean e(String s1)
    {
        com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i i1 = StatusManager.j().d();
        if (i1 != null && i1.u() != null)
        {
            return true;
        }
        s1 = bo.z(s1).m().iterator();
_L4:
        if (!s1.hasNext()) goto _L2; else goto _L1
_L1:
        if (((ao)s1.next()).a() != BeautyMode.x) goto _L4; else goto _L3
_L3:
        boolean flag = true;
_L6:
        return flag;
_L2:
        flag = false;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private r f(ao ao1)
    {
        List list = a(ao1);
        return new r(ao1.b(), ao1.c(), ao1.i(), list, ((at)list.get(0)).d());
    }

    static Runnable f(MakeupLooksBottomToolbar makeuplooksbottomtoolbar)
    {
        return makeuplooksbottomtoolbar.E;
    }

    static void f(MakeupLooksBottomToolbar makeuplooksbottomtoolbar, boolean flag)
    {
        makeuplooksbottomtoolbar.e(flag);
    }

    private void f(boolean flag)
    {
        if (q != null)
        {
            View view = q;
            int i1;
            if (flag)
            {
                i1 = 0;
            } else
            {
                i1 = 8;
            }
            view.setVisibility(i1);
        }
    }

    static int g(MakeupLooksBottomToolbar makeuplooksbottomtoolbar)
    {
        return makeuplooksbottomtoolbar.w;
    }

    private r g(ao ao1)
    {
        List list = a(ao1);
        return new r(ao1.b(), ao1.c(), ao1.i(), list, ((at)list.get(0)).d());
    }

    static boolean g(MakeupLooksBottomToolbar makeuplooksbottomtoolbar, boolean flag)
    {
        makeuplooksbottomtoolbar.B = flag;
        return flag;
    }

    private s h(ao ao1)
    {
        List list = a(ao1);
        String s1 = ao1.b();
        String s2 = ao1.c();
        float f1;
        if (((at)list.get(0)).d() != 0)
        {
            f1 = ((at)list.get(0)).d();
        } else
        {
            f1 = 50F;
        }
        return new s(s1, s2, list, f1, ao1.h());
    }

    static boolean h(MakeupLooksBottomToolbar makeuplooksbottomtoolbar)
    {
        return makeuplooksbottomtoolbar.m;
    }

    private com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.m i(ao ao1)
    {
        List list = a(ao1);
        String s1 = ao1.b();
        String s2 = ao1.c();
        float f1;
        if (list != null && list.size() > 0)
        {
            f1 = ((at)list.get(0)).d();
        } else
        {
            f1 = 40F;
        }
        return new com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.m(s1, s2, list, f1, ao1.h());
    }

    static boolean i(MakeupLooksBottomToolbar makeuplooksbottomtoolbar)
    {
        return makeuplooksbottomtoolbar.A();
    }

    private com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.k j(ao ao1)
    {
        at at1 = a(ao1, 0);
        return new com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.k(ao1.b(), at1.d(), at1);
    }

    static boolean j(MakeupLooksBottomToolbar makeuplooksbottomtoolbar)
    {
        return makeuplooksbottomtoolbar.C;
    }

    static com.cyberlink.youcammakeup.activity.c k(MakeupLooksBottomToolbar makeuplooksbottomtoolbar)
    {
        return makeuplooksbottomtoolbar.H;
    }

    private q k(ao ao1)
    {
        List list = a(ao1);
        return new q(new r(ao1.b(), ao1.c(), ao1.i(), list, ((at)list.get(0)).d()), ao1.h());
    }

    static int l(MakeupLooksBottomToolbar makeuplooksbottomtoolbar)
    {
        return makeuplooksbottomtoolbar.D;
    }

    static boolean m(MakeupLooksBottomToolbar makeuplooksbottomtoolbar)
    {
        return makeuplooksbottomtoolbar.n;
    }

    static int n(MakeupLooksBottomToolbar makeuplooksbottomtoolbar)
    {
        return makeuplooksbottomtoolbar.r;
    }

    static boolean o(MakeupLooksBottomToolbar makeuplooksbottomtoolbar)
    {
        return makeuplooksbottomtoolbar.k;
    }

    static android.view.View.OnClickListener p(MakeupLooksBottomToolbar makeuplooksbottomtoolbar)
    {
        return makeuplooksbottomtoolbar.I;
    }

    static void q(MakeupLooksBottomToolbar makeuplooksbottomtoolbar)
    {
        makeuplooksbottomtoolbar.z();
    }

    static String r(MakeupLooksBottomToolbar makeuplooksbottomtoolbar)
    {
        return makeuplooksbottomtoolbar.i;
    }

    static boolean s(MakeupLooksBottomToolbar makeuplooksbottomtoolbar)
    {
        return makeuplooksbottomtoolbar.w();
    }

    static int t()
    {
        return e;
    }

    static com.cyberlink.youcammakeup.widgetpool.toolbar.f t(MakeupLooksBottomToolbar makeuplooksbottomtoolbar)
    {
        return makeuplooksbottomtoolbar.A;
    }

    static int u()
    {
        int i1 = e;
        e = i1 - 1;
        return i1;
    }

    private ImageViewer v()
    {
label0:
        {
            Object obj = ((com.cyberlink.youcammakeup.kernelctrl.c.a)Globals.d().i.b().get()).a();
            if (obj == null)
            {
                break label0;
            }
            obj = ((ArrayList) (obj)).iterator();
            com.cyberlink.youcammakeup.kernelctrl.c.b b1;
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
                b1 = (com.cyberlink.youcammakeup.kernelctrl.c.b)((WeakReference)((Iterator) (obj)).next()).get();
            } while (!(b1 instanceof ImageViewer));
            return (ImageViewer)b1;
        }
        return null;
    }

    private boolean w()
    {
        for (long l1 = StatusManager.j().l(); l1 == -7L || l1 == -9L || !B;)
        {
            return false;
        }

        return true;
    }

    private void x()
    {
        if (getActivity() instanceof BaseActivity)
        {
            ((BaseActivity)getActivity()).h();
        }
        E.run();
    }

    private void y()
    {
        TopToolBar toptoolbar = e();
        j = null;
        if (toptoolbar != null)
        {
            toptoolbar.a(null);
            l l1 = new l();
            l1.a = false;
            l1.c = Globals.d().getString(0x7f0703b5);
            if (StatusManager.j().s() == BeautyMode.D && StatusManager.j().r() != MakeupMode.a)
            {
                l1.b = true;
            }
            toptoolbar.a(l1);
        }
    }

    private void z()
    {
        if (DownloadUseUtils.a(getActivity()) == null) goto _L2; else goto _L1
_L1:
        Object obj = DownloadUseUtils.a(getActivity());
        obj = PanelDataCenter.a().n(((com.cyberlink.youcammakeup.utility.DownloadUseUtils.UseTemplate) (obj)).typeGUID);
        if (obj == null)
        {
            obj = com.cyberlink.youcammakeup.utility.PanelDataCenter.LookType.b;
        } else
        {
            obj = com.cyberlink.youcammakeup.utility.PanelDataCenter.LookType.a(((String) (obj)));
        }
        if (obj == g.i()) goto _L2; else goto _L3
_L3:
        c(((com.cyberlink.youcammakeup.utility.PanelDataCenter.LookType) (obj)));
_L5:
        return;
_L2:
        Object obj1;
        int i1;
        if (g.f() > -1)
        {
            obj1 = g.b(g.f());
        } else
        {
            obj1 = null;
        }
        i1 = g.getCount();
        g.b();
        if (i1 != g.getCount())
        {
            int j1 = g.a(((String) (obj1)));
            g.g(j1);
            MotionControlHelper motioncontrolhelper = MotionControlHelper.e();
            if (motioncontrolhelper.j())
            {
                long l1 = StatusManager.j().l();
                motioncontrolhelper.i();
                if (h == null)
                {
                    obj1 = StatusManager.j().f(l1);
                } else
                {
                    obj1 = h;
                }
                motioncontrolhelper.b(((a) (obj1)));
                return;
            }
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    protected int a()
    {
        return 0x7f0c050b;
    }

    public void a(float f1)
    {
        if (p == null)
        {
            return;
        } else
        {
            p.setOnSeekBarChangeListener(null);
            p.setProgressAndThumb((int)f1);
            p.setOnSeekBarChangeListener(d);
            return;
        }
    }

    public void a(int i1)
    {
        getView().setVisibility(i1);
    }

    public void a(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName buffername, Long long1)
    {
label0:
        {
            if (buffername == com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c)
            {
                t = true;
                if (u || MotionControlHelper.e().aC())
                {
                    break label0;
                }
                if (p != null && p.getProgress() != s)
                {
                    a(p.getProgress(), false);
                    t = false;
                }
            }
            return;
        }
        s = p.getProgress();
    }

    public void a(ImageStateChangedEvent imagestatechangedevent)
    {
        c(imagestatechangedevent);
    }

    public void a(a a1)
    {
        a a2 = a1;
        if (a1 == null)
        {
            long l1 = StatusManager.j().l();
            a2 = StatusManager.j().f(l1);
        }
        MotionControlHelper.e().b(a2);
        if (g != null)
        {
            g.j();
        }
    }

    protected void a(MakeupMode makeupmode)
    {
        boolean flag2 = true;
        boolean flag;
        if (makeupmode == MakeupMode.a)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            makeupmode = DownloadUseUtils.a(getActivity());
            Object obj;
            EditViewActivity editviewactivity;
            int i1;
            long l1;
            boolean flag1;
            if (makeupmode != null)
            {
                makeupmode = ((com.cyberlink.youcammakeup.utility.DownloadUseUtils.UseTemplate) (makeupmode)).typeGUID;
            } else
            {
                makeupmode = i;
            }
            if (makeupmode != null)
            {
                makeupmode = PanelDataCenter.a().n(makeupmode);
            } else
            {
                makeupmode = "Natural";
            }
            if (makeupmode == null)
            {
                makeupmode = com.cyberlink.youcammakeup.utility.PanelDataCenter.LookType.a;
            } else
            {
                makeupmode = com.cyberlink.youcammakeup.utility.PanelDataCenter.LookType.a(makeupmode);
            }
            obj = StatusManager.j();
            l1 = ((StatusManager) (obj)).l();
            editviewactivity = (EditViewActivity)getActivity();
            if (editviewactivity != null)
            {
                flag1 = editviewactivity.A();
            } else
            {
                flag1 = false;
            }
            if (flag1)
            {
                obj = ((StatusManager) (obj)).j(l1);
            } else
            {
                obj = ((StatusManager) (obj)).c(l1);
            }
            b(makeupmode);
            a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.LookType) (makeupmode)));
            b(((ch) (null)));
            n = true;
            makeupmode = ((d) (obj)).e();
            if (makeupmode != null && makeupmode.d().size() > 1)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            makeupmode = StatusManager.j();
            if (i1 != 0)
            {
                i1 = 0;
            } else
            {
                i1 = -1;
            }
            makeupmode.a(-1, i1, -1, -1, -1, -1, 4, -1);
        } else
        if (makeupmode != MakeupMode.b)
        {
            j();
            y();
        }
        if (!flag)
        {
            flag1 = flag2;
        } else
        {
            flag1 = false;
        }
        a(flag1);
        StatusManager.j().y();
    }

    protected void a(com.cyberlink.youcammakeup.widgetpool.toolbar.b b1)
    {
        com.cyberlink.youcammakeup.clflurry.b.a(new YMKFeatureRoomLookEvent(com.cyberlink.youcammakeup.clflurry.YMKFeatureRoomLookEvent.Operation.b, YMKFeatureRoomLookEvent.f(), System.currentTimeMillis(), null, YMKFeatureRoomLookEvent.e(), null));
        if (b1 != null)
        {
            b1.a();
        }
    }

    public void a(String s1)
    {
        i = s1;
    }

    public void a(String s1, Boolean boolean1)
    {
        TopToolBar toptoolbar = e();
        if (toptoolbar != null)
        {
            toptoolbar.a(s1, boolean1);
        }
    }

    public boolean a(int i1, boolean flag)
    {
        boolean flag1 = true;
        if (g == null || g.i() != com.cyberlink.youcammakeup.utility.PanelDataCenter.LookType.a) goto _L2; else goto _L1
_L1:
        if (v != null) goto _L4; else goto _L3
_L3:
        if (i == null) goto _L6; else goto _L5
_L5:
        v = d(i);
_L4:
        com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i j1;
        j1 = v;
        if (j1 == null || j1.v() == null || g == null || g.g() == null || !j1.v().equalsIgnoreCase(g.g().a()))
        {
            return false;
        }
        break; /* Loop/switch isn't completed */
_L6:
        v = StatusManager.j().d();
        if (v.v() != null)
        {
            v = d(v.v());
        }
        if (true) goto _L4; else goto _L7
_L7:
        MotionControlHelper.e().s(true);
        com.cyberlink.youcammakeup.jniproxy.az az = VenusHelper.a().a(j1);
        az = VenusHelper.a().a(az, i1);
        j1 = VenusHelper.a().a(j1, az);
        if (!MotionControlHelper.e().a(j1, new BeautifierTaskInfo(flag))) goto _L9; else goto _L8
_L8:
        j1.a(i1);
        StatusManager.j().a(j1);
        flag = flag1;
_L11:
        return flag;
_L9:
        MotionControlHelper.e().s(false);
_L2:
        flag = false;
        if (true) goto _L11; else goto _L10
_L10:
    }

    protected int b()
    {
        return 0x7f0c050d;
    }

    public void b(ImageStateChangedEvent imagestatechangedevent)
    {
        c(imagestatechangedevent);
    }

    public void b(a a1)
    {
        if (a1 != null && a1.f() != null && a1.f().g() != null)
        {
            com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i i1 = new com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i(a1.f().g());
            i1.a(true);
            i1.a(r);
            a1.f().a(i1);
        }
        h = a1;
    }

    protected void b(com.cyberlink.youcammakeup.widgetpool.toolbar.b b1)
    {
        if (StatusManager.j().d().v() != null)
        {
            com.cyberlink.youcammakeup.kernelctrl.j.a().h();
            Activity activity = getActivity();
            if ((activity instanceof EditViewActivity) && k)
            {
                h = ((EditViewActivity)activity).l(false);
            }
            if (activity instanceof BaseActivity)
            {
                ((BaseActivity)activity).h();
            }
            as as1 = PanelDataCenter.a().o(StatusManager.j().d().v());
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKFeatureRoomLookEvent(com.cyberlink.youcammakeup.clflurry.YMKFeatureRoomLookEvent.Operation.c, YMKFeatureRoomLookEvent.f(), System.currentTimeMillis(), as1.c(), YMKFeatureRoomLookEvent.e(), String.valueOf(p.getProgress())));
            if (as1.f() != com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.c && !k)
            {
                com.cyberlink.youcammakeup.flurry.a.a(new PopularityOfLookEvent());
                com.cyberlink.youcammakeup.clflurry.b.a(new n(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.a));
                YMKApplyEvent ymkapplyevent = new YMKApplyEvent(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.a);
                ymkapplyevent.f(as1.a());
                com.cyberlink.youcammakeup.clflurry.b.a(ymkapplyevent.e());
            }
            (new AsyncTask(activity, b1) {

                final Activity a;
                final com.cyberlink.youcammakeup.widgetpool.toolbar.b b;
                final MakeupLooksBottomToolbar c;

                protected transient Void a(Void avoid[])
                {
                    MotionControlHelper.e().p();
                    MotionControlHelper.e().t();
                    MotionControlHelper.e().s();
                    MotionControlHelper.e().a(BeautyMode.j, true);
                    MotionControlHelper.e().a(BeautyMode.k, true);
                    return null;
                }

                protected void a(Void void1)
                {
                    long l1 = StatusManager.j().l();
                    void1 = StatusManager.j().f(l1);
                    if (void1 != null && void1.f() != null && void1.f().g() != null && void1.f().g().a() != null && MotionControlHelper.e().a(((a) (void1)).e))
                    {
                        BeautifierEditCenter.a().a(false);
                        MotionControlHelper.e().b(((a) (void1)).e, false);
                    }
                    if (a instanceof BaseActivity)
                    {
                        ((BaseActivity)a).i();
                    }
                    MotionControlHelper.e().c(Boolean.valueOf(true));
                    void1 = com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.a(c);
                    if (void1 != null)
                    {
                        com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.a(c, void1, true);
                        com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.a(c, void1);
                    }
                    if (b != null)
                    {
                        b.b();
                    }
                }

                protected Object doInBackground(Object aobj[])
                {
                    return a((Void[])aobj);
                }

                protected void onPostExecute(Object obj)
                {
                    a((Void)obj);
                }

            
            {
                c = MakeupLooksBottomToolbar.this;
                a = activity;
                b = b1;
                super();
            }
            }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            if (activity instanceof EditViewActivity)
            {
                ((EditViewActivity)activity).V();
            }
            b1 = (ImageViewer)getActivity().findViewById(0x7f0c0720);
            if (b1 != null)
            {
                b1.q();
                return;
            }
        }
    }

    public void b(String s1)
    {
        int i1;
label0:
        {
            if (g != null)
            {
                i1 = c(s1);
                if (i1 != -1)
                {
                    break label0;
                }
                g.b();
                i1 = c(s1);
                f.c(i1);
                g.g(i1);
                v = d(s1);
                c(false);
            }
            return;
        }
        Object obj = PanelDataCenter.a().o(s1);
        g.a(i1, ((as) (obj)));
        obj = b(i1);
        if (obj != null)
        {
            ((View) (obj)).setTag(null);
            g.notifyDataSetChanged();
        }
        g.g(i1);
        v = d(s1);
        c(false);
    }

    public void b(boolean flag)
    {
        l = flag;
    }

    public void c(long l1)
    {
        getActivity().runOnUiThread(new Runnable() {

            final MakeupLooksBottomToolbar a;

            public void run()
            {
                if (com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a) != null)
                {
                    com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.q(a);
                }
            }

            
            {
                a = MakeupLooksBottomToolbar.this;
                super();
            }
        });
    }

    public void c(boolean flag)
    {
        boolean flag1 = false;
        if (flag)
        {
            f(false);
        } else
        if (g != null && p != null)
        {
            flag = flag1;
            if (g.i() == com.cyberlink.youcammakeup.utility.PanelDataCenter.LookType.a)
            {
                flag = flag1;
                if (g.f() >= 0)
                {
                    flag = flag1;
                    if (g.g() != null)
                    {
                        flag = flag1;
                        if (g.g().a() != null)
                        {
                            flag = flag1;
                            if (!g.g().a().equalsIgnoreCase("default_original_looks"))
                            {
                                flag = true;
                            }
                        }
                    }
                }
            }
            f(flag);
            return;
        }
    }

    protected int f()
    {
        return 0x7f0300e3;
    }

    public void j()
    {
        int j1;
        C = false;
        o = false;
        if (f != null)
        {
            f.setOnItemClickListener(null);
            f.setOnItemLongClickListener(null);
            f.setAdapter(null);
            f = null;
        }
        if (A != null)
        {
            StatusManager.j().b(A);
            A = null;
        }
        if (g != null)
        {
            g.a();
            g = null;
        }
        i = null;
        h = null;
        v = null;
        MotionControlHelper.e().i();
        StatusManager.j().b(null);
        Object obj;
        int i1;
        if (ah.b())
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        obj = StatusManager.j().f(StatusManager.j().l());
        if (obj == null) goto _L2; else goto _L1
_L1:
        obj = ((a) (obj)).d();
        if (obj == null || ((List) (obj)).size() <= 1) goto _L2; else goto _L3
_L3:
        j1 = 0;
_L5:
        StatusManager.j().a(0, j1, 8, 0, 0, 4, i1, 8);
        obj = Globals.d().t();
        if (obj != null)
        {
            ((EditViewActivity) (obj)).b(this);
            ((EditViewActivity) (obj)).b(this);
            ((EditViewActivity) (obj)).a(Boolean.valueOf(true));
            ((EditViewActivity) (obj)).b(H);
        }
        c(true);
        if (p != null)
        {
            p.setOnSeekBarChangeListener(null);
            p = null;
        }
        StatusManager.j().b(this);
        obj = e();
        if (obj != null)
        {
            ((TopToolBar) (obj)).a(Boolean.valueOf(false));
        }
        return;
_L2:
        j1 = 4;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public String k()
    {
        Object obj = StatusManager.j().d();
        if (obj != null)
        {
            obj = ((com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i) (obj)).v();
        } else
        {
            obj = "";
        }
        if (bo.h(((String) (obj))))
        {
            return ((String) (obj));
        } else
        {
            return null;
        }
    }

    public a l()
    {
        return h;
    }

    public boolean m()
    {
        return k;
    }

    public boolean n()
    {
        return l;
    }

    public void o()
    {
        g.a(false);
        k = true;
        b(((com.cyberlink.youcammakeup.widgetpool.toolbar.b) (null)));
        c(new ch() {

            final MakeupLooksBottomToolbar a;

            public void onAnimationEnd(Animator animator)
            {
                StatusManager.j().a(MakeupMode.g, false);
            }

            
            {
                a = MakeupLooksBottomToolbar.this;
                super();
            }
        });
    }

    public void onPause()
    {
        super.onPause();
        NetworkManager networkmanager = Globals.d().w();
        if (networkmanager != null)
        {
            networkmanager.b(this);
        }
    }

    public void onResume()
    {
        super.onResume();
        com.cyberlink.youcammakeup.clflurry.b.a(new YMKFeatureRoomLookEvent(com.cyberlink.youcammakeup.clflurry.YMKFeatureRoomLookEvent.Operation.a, 0L, 0L, null, null, null));
        YMKFeatureRoomLookEvent.a(System.currentTimeMillis());
        Object obj = cc.a();
        if (cc.d(((String) (obj))))
        {
            obj = cc.e(((String) (obj)));
            cc.b();
            g.notifyDataSetChanged();
            com.cyberlink.youcammakeup.utility.o.a(getActivity(), new e(((String) (obj))), "CongratulationUnlockDialog");
        }
        if (g != null)
        {
            g.notifyDataSetChanged();
        }
        obj = Globals.d().w();
        if (obj != null)
        {
            ((NetworkManager) (obj)).a(this);
        }
    }

    public void onStart()
    {
        super.onStart();
        MakeupMode makeupmode = StatusManager.j().r();
        if (g != null && makeupmode == MakeupMode.a)
        {
            z();
            a(DownloadUseUtils.a(getActivity()));
        }
        d(true);
    }

    public void p()
    {
        if (g != null)
        {
            g.g(-1);
            g.notifyDataSetChanged();
        }
    }

    public void q()
    {
        String s1 = k();
        if (s1 == null)
        {
            return;
        } else
        {
            a(s1, false);
            return;
        }
    }

    public boolean r()
    {
        Object obj = StatusManager.j().d();
        if (obj != null)
        {
            if ((obj = ((com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i) (obj)).v()) != null)
            {
                boolean flag;
                try
                {
                    flag = e(((String) (obj)));
                }
                catch (Exception exception)
                {
                    com.pf.common.utility.m.b("MakeupLooksBottomToolbar", "isLookContainsWig", exception);
                    return false;
                }
                return flag;
            }
        }
        return false;
    }

    public boolean s()
    {
        return o;
    }


    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/toolbar/MakeupLooksBottomToolbar$3$1

/* anonymous class */
    class _cls1
        implements android.content.DialogInterface.OnDismissListener
    {

        final _cls3 a;

        public void onDismiss(DialogInterface dialoginterface)
        {
            com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a.a).b(false);
            com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a.a).c(false);
        }

            
            {
                a = _pcls3;
                super();
            }
    }


    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/toolbar/MakeupLooksBottomToolbar$3$2

/* anonymous class */
    class _cls2
        implements com.cyberlink.youcammakeup.pages.editview.savemylook.a
    {

        final _cls3 a;

        public void a(View view, com.cyberlink.youcammakeup.pages.editview.savemylook.LookItemPopupMenu.Action action)
        {
            LooksGridItem looksgriditem = (LooksGridItem)view;
            String s1 = ((com.cyberlink.youcammakeup.widgetpool.panel.lookspanel.f)looksgriditem.getTag()).a;
            int i1 = com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.a(a.a, s1);
            List list = PanelDataCenter.a().a(com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.c);
            list.remove(com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a.a).a(i1).b());
            if (action == com.cyberlink.youcammakeup.pages.editview.savemylook.LookItemPopupMenu.Action.a)
            {
                action = com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a.a).a(i1);
                if (action.h().booleanValue())
                {
                    action.a(Boolean.valueOf(false));
                    looksgriditem.d(true);
                }
                com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.p(a.a).onClick(view);
                a.a.c(true);
            } else
            {
                if (action == com.cyberlink.youcammakeup.pages.editview.savemylook.LookItemPopupMenu.Action.b)
                {
                    action = com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a.a).a(i1);
                    view.post(new Runnable(this, action, new bl(this, s1, action, looksgriditem, list) {

                        final String a;
                        final as b;
                        final LooksGridItem c;
                        final List d;
                        final _cls2 e;

                        public com.cyberlink.youcammakeup.utility.SoftInputUtils.CheckResult a(String s1)
                        {
                            if (s1.equals(""))
                            {
                                return com.cyberlink.youcammakeup.utility.SoftInputUtils.CheckResult.a;
                            }
                            if (d != null && d.contains(s1))
                            {
                                return com.cyberlink.youcammakeup.utility.SoftInputUtils.CheckResult.b;
                            } else
                            {
                                return com.cyberlink.youcammakeup.utility.SoftInputUtils.CheckResult.c;
                            }
                        }

                        public String a()
                        {
    class _cls2
        implements com.cyberlink.youcammakeup.pages.editview.savemylook.a
    {
                            return e.a.a.getString(0x7f070601);
                        }

                        public void a(Exception exception)
                        {
                            com.pf.common.utility.m.e("MakeupLooksBottomToolbar", exception.toString());
                        }

                        public void a(Object obj)
                        {
                            b((String)obj);
                        }

                        public String b()
                        {
                            return e.a.a.getString(0x7f0705fe);
                        }

                        public void b(String s1)
                        {
                            PanelDataCenter.a().a(a, s1);
                            av av1 = new av();
                            av1.b(s1);
                            b.a(av1);
                            c.setName(s1);
                        }

                        public String c()
                        {
                            return null;
                        }

            
            {
                e = _pcls2;
                a = s1;
                b = as1;
                c = looksgriditem;
                d = list;
                super();
            }
                    }) {

                        final as a;
                        final bl b;
                        final _cls2 c;

                        public void run()
                        {
                            SoftInputUtils.b(null, c.a.a.getFragmentManager(), a.b(), b);
                        }

            
            {
                c = _pcls2;
                a = as1;
                b = bl;
                super();
            }
                    });
                    return;
                }
                if (action == com.cyberlink.youcammakeup.pages.editview.savemylook.LookItemPopupMenu.Action.c)
                {
                    view = a.a.getActivity();
                    if (view instanceof EditViewActivity)
                    {
                        view = (EditViewActivity)view;
                        if (com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a.a).f() == i1)
                        {
                            (new Handler()).post(new Runnable(this, view) {

                                final EditViewActivity a;
                                final _cls2 b;

                                public void run()
                                {
                                    a.b(false, false);
                                    b.a.a.c(true);
                                }

            
            {
                b = _pcls2;
                a = editviewactivity;
                super();
            }
                            });
                            return;
                        } else
                        {
                            view.a(com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.k(a.a));
                            com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.c(a.a).a(com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.b(a.a).getView(i1, null, com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.c(a.a)), i1, -1L);
                            return;
                        }
                    }
                }
            }
        }

            
            {
                a = _pcls3;
                super();
            }
    }

}
