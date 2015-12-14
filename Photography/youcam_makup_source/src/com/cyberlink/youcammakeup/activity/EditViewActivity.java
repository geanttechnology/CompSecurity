// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.ActivityManager;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PointF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.cyberlink.youcammakeup.BaseActivity;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.c;
import com.cyberlink.youcammakeup.camera.CameraShotAnimationVeiw;
import com.cyberlink.youcammakeup.camera.y;
import com.cyberlink.youcammakeup.clflurry.YMKEditStayTimeEvent;
import com.cyberlink.youcammakeup.clflurry.YMKFeatureRoomLookEvent;
import com.cyberlink.youcammakeup.clflurry.YMKFeatures;
import com.cyberlink.youcammakeup.clflurry.YMKManualEvent;
import com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent;
import com.cyberlink.youcammakeup.clflurry.am;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.database.g;
import com.cyberlink.youcammakeup.e;
import com.cyberlink.youcammakeup.flurry.FaceDetectionResultEvent;
import com.cyberlink.youcammakeup.flurry.UsageOfAllFeaturesEvent;
import com.cyberlink.youcammakeup.jniproxy.UIImageCodecErrorCode;
import com.cyberlink.youcammakeup.jniproxy.UIImageOrientation;
import com.cyberlink.youcammakeup.jniproxy.ai;
import com.cyberlink.youcammakeup.jniproxy.ax;
import com.cyberlink.youcammakeup.jniproxy.bn;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierManager;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierTaskInfo;
import com.cyberlink.youcammakeup.kernelctrl.VenusHelper;
import com.cyberlink.youcammakeup.kernelctrl.ar;
import com.cyberlink.youcammakeup.kernelctrl.at;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.v;
import com.cyberlink.youcammakeup.kernelctrl.f;
import com.cyberlink.youcammakeup.kernelctrl.featurepoints.samplepanel.FPSampleController;
import com.cyberlink.youcammakeup.kernelctrl.j;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageViewer;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.PanZoomViewer;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;
import com.cyberlink.youcammakeup.kernelctrl.status.ImageStateChangedEvent;
import com.cyberlink.youcammakeup.kernelctrl.status.SessionState;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.a;
import com.cyberlink.youcammakeup.kernelctrl.status.ag;
import com.cyberlink.youcammakeup.kernelctrl.status.ah;
import com.cyberlink.youcammakeup.kernelctrl.status.aj;
import com.cyberlink.youcammakeup.kernelctrl.status.ak;
import com.cyberlink.youcammakeup.kernelctrl.status.al;
import com.cyberlink.youcammakeup.kernelctrl.status.aq;
import com.cyberlink.youcammakeup.kernelctrl.status.d;
import com.cyberlink.youcammakeup.kernelctrl.status.k;
import com.cyberlink.youcammakeup.kernelctrl.status.m;
import com.cyberlink.youcammakeup.kernelctrl.status.n;
import com.cyberlink.youcammakeup.kernelctrl.status.p;
import com.cyberlink.youcammakeup.kernelctrl.status.u;
import com.cyberlink.youcammakeup.kernelctrl.status.w;
import com.cyberlink.youcammakeup.kernelctrl.t;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.masteraccess.Exporter;
import com.cyberlink.youcammakeup.setting.PhotoQuality;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.DownloadUseUtils;
import com.cyberlink.youcammakeup.utility.ImageCacheChannel;
import com.cyberlink.youcammakeup.utility.IntroDialogUtils;
import com.cyberlink.youcammakeup.utility.MakeupMode;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.ViewAnimationUtils;
import com.cyberlink.youcammakeup.utility.aa;
import com.cyberlink.youcammakeup.utility.ac;
import com.cyberlink.youcammakeup.utility.aw;
import com.cyberlink.youcammakeup.utility.be;
import com.cyberlink.youcammakeup.utility.bo;
import com.cyberlink.youcammakeup.utility.ca;
import com.cyberlink.youcammakeup.utility.ch;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.utility.s;
import com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl;
import com.cyberlink.youcammakeup.widgetpool.common.FixedAspectRatioFrameLayout;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.cyberlink.youcammakeup.widgetpool.common.SliderValueText;
import com.cyberlink.youcammakeup.widgetpool.common.VerticalSeekBar;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.r;
import com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel;
import com.cyberlink.youcammakeup.widgetpool.toolbar.FineTuneToolBar;
import com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar;
import com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar;
import com.cyberlink.youcammakeup.widgetpool.toolbar.TopToolBar;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            j, h, LauncherActivity, CameraActivity, 
//            LibraryPickerActivity, e, d, g, 
//            f, c, i, k

public class EditViewActivity extends BaseActivity
    implements f, ag, ah, aj, ak, al, k, m, n, p, u, w
{

    public static final UUID a = UUID.randomUUID();
    private static final String g = com/cyberlink/youcammakeup/kernelctrl/status/StatusManager.getName();
    private static TopToolBar h = null;
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private com.cyberlink.youcammakeup.widgetpool.common.a.d I;
    private com.cyberlink.youcammakeup.widgetpool.panel.a J;
    private ViewGroup K;
    private View L;
    private View M;
    private View N;
    private View O;
    private com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.k P;
    private PalettesPanel Q;
    private int R;
    private int S;
    private boolean T;
    private boolean U;
    private boolean V;
    private ArrayList W;
    private ArrayList X;
    private ArrayList Y;
    private com.cyberlink.youcammakeup.activity.g Z;
    private SliderValueText aA;
    private boolean aB;
    private boolean aC;
    private int aD;
    private ac aE;
    private android.widget.SeekBar.OnSeekBarChangeListener aF;
    private android.view.View.OnTouchListener aG;
    private android.view.View.OnClickListener aH;
    private android.view.View.OnClickListener aI;
    private android.view.View.OnClickListener aJ;
    private android.view.View.OnClickListener aK;
    private android.view.View.OnClickListener aL;
    private android.view.View.OnClickListener aM;
    private android.view.View.OnClickListener aN;
    private android.view.View.OnClickListener aO;
    private android.view.View.OnLayoutChangeListener aP;
    private com.cyberlink.youcammakeup.activity.e aa;
    private boolean ab;
    private com.cyberlink.youcammakeup.activity.h ac;
    private ExecutorService ad;
    private q ae;
    private boolean af;
    private FPSampleController ag;
    private boolean ah;
    private Map ai;
    private Map aj;
    private BeautyMode ak;
    private MakeupMenuBottomToolbar al;
    private MakeupLooksBottomToolbar am;
    private com.cyberlink.youcammakeup.activity.d an;
    private com.cyberlink.youcammakeup.activity.j ao;
    private boolean ap;
    private boolean aq;
    private FineTuneToolBar ar;
    private com.cyberlink.youcammakeup.camera.ah as;
    private CameraShotAnimationVeiw at;
    private boolean au;
    private f av;
    private com.cyberlink.youcammakeup.widgetpool.dialogs.q aw;
    private com.cyberlink.youcammakeup.widgetpool.dialogs.a ax;
    private com.cyberlink.youcammakeup.jniproxy.f ay;
    private boolean az;
    public boolean b;
    public final boolean c = true;
    protected PageID d;
    protected Fragment e;
    public android.view.View.OnClickListener f;
    private View i;
    private View j;
    private View k;
    private View l;
    private View m;
    private View n;
    private View o;
    private View p;
    private View q;
    private View r;
    private View s;
    private View t;
    private View u;
    private int v;
    private SeekBar w;
    private SliderValueText x;
    private Fragment y;
    private int z;

    public EditViewActivity()
    {
        i = null;
        j = null;
        k = null;
        l = null;
        m = null;
        n = null;
        o = null;
        p = null;
        q = null;
        r = null;
        s = null;
        t = null;
        u = null;
        v = 4;
        w = null;
        x = null;
        b = false;
        A = 4;
        B = 4;
        C = 4;
        D = 4;
        E = 4;
        F = 4;
        G = 4;
        H = 4;
        I = null;
        J = null;
        K = null;
        L = null;
        M = null;
        N = null;
        O = null;
        P = null;
        Q = null;
        R = 0;
        S = 0;
        T = false;
        U = true;
        V = true;
        W = new ArrayList();
        X = new ArrayList();
        Y = new ArrayList();
        Z = null;
        ab = true;
        ac = null;
        ad = Executors.newFixedThreadPool(1);
        ae = null;
        af = false;
        ah = false;
        ap = false;
        ar = null;
        au = false;
        aw = null;
        ax = null;
        ay = Globals.d().b();
        az = false;
        aC = true;
        aE = new ac() {

            final EditViewActivity a;

            public void a(com.cyberlink.youcammakeup.utility.IntroDialogUtils.IntroDialogType introdialogtype)
            {
                if (IntroDialogUtils.a(StatusManager.j().r(), StatusManager.j().s()) == introdialogtype && com.cyberlink.youcammakeup.activity.EditViewActivity.a(a) != -1)
                {
                    com.cyberlink.youcammakeup.activity.EditViewActivity.b(a).setVisibility(com.cyberlink.youcammakeup.activity.EditViewActivity.a(a));
                    com.cyberlink.youcammakeup.activity.EditViewActivity.a(a, com.cyberlink.youcammakeup.activity.EditViewActivity.a(a));
                }
            }

            
            {
                a = EditViewActivity.this;
                super();
            }
        };
        d = null;
        e = null;
        aF = new android.widget.SeekBar.OnSeekBarChangeListener() {

            final EditViewActivity a;

            public void onProgressChanged(SeekBar seekbar, int i1, boolean flag)
            {
                if (com.cyberlink.youcammakeup.activity.EditViewActivity.k(a))
                {
                    seekbar = Globals.d().j();
                    if (flag)
                    {
                        flag = false;
                    } else
                    {
                        flag = true;
                    }
                    seekbar.b(Boolean.valueOf(flag));
                    com.cyberlink.youcammakeup.activity.EditViewActivity.b(a, false);
                }
                EditViewActivity.l(a).setText(Integer.toString(i1));
            }

            public void onStartTrackingTouch(SeekBar seekbar)
            {
                com.cyberlink.youcammakeup.activity.EditViewActivity.a(a, false);
                EditViewActivity.ae().a(Boolean.valueOf(true));
                Globals.d().j().y();
                if (com.cyberlink.youcammakeup.activity.EditViewActivity.i(a) != null)
                {
                    ((FixedAspectRatioFrameLayout)com.cyberlink.youcammakeup.activity.EditViewActivity.i(a)).setInterceptTouchEvent(true);
                }
                if (com.cyberlink.youcammakeup.activity.EditViewActivity.j(a) != null)
                {
                    com.cyberlink.youcammakeup.activity.EditViewActivity.j(a).b(true);
                }
            }

            public void onStopTrackingTouch(SeekBar seekbar)
            {
                com.cyberlink.youcammakeup.activity.EditViewActivity.a(a, true);
                EditViewActivity.ae().a(Boolean.valueOf(false));
                if (Globals.d().j().b(Boolean.valueOf(true)))
                {
                    Globals.d().i().b(a);
                }
            }

            
            {
                a = EditViewActivity.this;
                super();
            }
        };
        aG = new android.view.View.OnTouchListener() {

            final EditViewActivity a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                motionevent.getActionMasked();
                JVM INSTR tableswitch 0 6: default 48
            //                           0 50
            //                           1 143
            //                           2 48
            //                           3 143
            //                           4 48
            //                           5 50
            //                           6 143;
                   goto _L1 _L2 _L3 _L1 _L3 _L1 _L2 _L3
_L1:
                return false;
_L2:
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKFeatureRoomLookEvent(com.cyberlink.youcammakeup.clflurry.YMKFeatureRoomLookEvent.Operation.e, 0L, 0L, null, YMKFeatureRoomLookEvent.e(), null));
                if (!a.b)
                {
                    com.cyberlink.youcammakeup.activity.EditViewActivity.b(a, motionevent.getPointerId(motionevent.getActionIndex()));
                    a.K();
                    com.cyberlink.youcammakeup.clflurry.b.a(new YMKSavingPageEvent(0L, 0L, com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.Operation.c, false, false));
                    if (com.cyberlink.youcammakeup.activity.EditViewActivity.w(a))
                    {
                        EditViewActivity.x(a).e();
                        return false;
                    }
                }
                continue; /* Loop/switch isn't completed */
_L3:
                int i1 = motionevent.getPointerId(motionevent.getActionIndex());
                if (a.b && i1 == com.cyberlink.youcammakeup.activity.EditViewActivity.y(a))
                {
                    a.L();
                    if (com.cyberlink.youcammakeup.activity.EditViewActivity.w(a))
                    {
                        EditViewActivity.x(a).f();
                        return false;
                    }
                }
                if (true) goto _L1; else goto _L4
_L4:
            }

            
            {
                a = EditViewActivity.this;
                super();
            }
        };
        f = new android.view.View.OnClickListener() {

            final EditViewActivity a;

            public void onClick(View view)
            {
                StatusManager statusmanager = StatusManager.j();
                long l1 = statusmanager.l();
                int i1 = statusmanager.f(l1).e;
                com.cyberlink.youcammakeup.utility.s.a().a(a, view, new com.cyberlink.youcammakeup.widgetpool.dialogs.j(this, l1, i1) {

                    final long a;
                    final int b;
                    final _cls18 c;

                    public void a(com.cyberlink.youcammakeup.widgetpool.dialogs.FaceSwitcherDialog.DismissType dismisstype, int i1)
                    {
label0:
                        {
label1:
                            {
                                Object obj;
                                ImageViewer imageviewer;
label2:
                                {
                                    if (dismisstype != com.cyberlink.youcammakeup.widgetpool.dialogs.FaceSwitcherDialog.DismissType.b)
                                    {
                                        break label0;
                                    }
                                    Globals.d().i().b(c.a);
                                    obj = StatusManager.j().f(a);
                                    if (b == i1)
                                    {
                                        break label1;
                                    }
                                    com.cyberlink.youcammakeup.activity.EditViewActivity.e(c.a).p();
                                    dismisstype = BeautifierEditCenter.a().d();
                                    obj = (ar)((a) (obj)).e().get(i1);
                                    if (obj != null)
                                    {
                                        BeautifierEditCenter.a().a(null);
                                        BeautifierEditCenter.a().a(((ar) (obj)).b, ((ar) (obj)).c, false, new BeautifierTaskInfo(false));
                                        StatusManager.j().a(null);
                                        MotionControlHelper.e().a(null);
                                        MotionControlHelper.e().l();
                                        MotionControlHelper.e().b(((ar) (obj)).d.b());
                                        MotionControlHelper.e().c(((ar) (obj)).e.b());
                                        MotionControlHelper.e().a(Boolean.valueOf(((ar) (obj)).f), false);
                                        MotionControlHelper.e().a(((ar) (obj)).g.a(), ((ar) (obj)).g.b());
                                        MotionControlHelper.e().r(true);
                                        com.cyberlink.youcammakeup.kernelctrl.j.a().a(false);
                                        bo.B(null);
                                        MotionControlHelper.e().av();
                                        VenusHelper.a().F();
                                        ImageCacheChannel.b(ImageCacheChannel.a);
                                        StatusManager.j().N();
                                        obj = c.a;
                                        class a extends AsyncTask
                                        {

                                            final ImageViewer a;
                                            final ImageBufferWrapper b;
                                            final int c;
                                            final _cls1 d;

                                            protected transient List a(ImageBufferWrapper aimagebufferwrapper[])
                                            {
                                                ImageBufferWrapper imagebufferwrapper1 = aimagebufferwrapper[0];
                                                ImageBufferWrapper imagebufferwrapper = null;
                                                if (aimagebufferwrapper.length == 2)
                                                {
                                                    imagebufferwrapper = aimagebufferwrapper[1];
                                                }
                                                aimagebufferwrapper = new ArrayList(2);
                                                aimagebufferwrapper.add(com.cyberlink.youcammakeup.kernelctrl.t.a(imagebufferwrapper1, StatusManager.j().I()));
                                                if (imagebufferwrapper != null)
                                                {
                                                    File file = new File(StatusManager.j().J());
                                                    if (!file.exists())
                                                    {
                                                        file.mkdir();
                                                    }
                                                    aimagebufferwrapper.add(com.cyberlink.youcammakeup.kernelctrl.t.a(imagebufferwrapper, StatusManager.j().J()));
                                                    imagebufferwrapper.m();
                                                    BeautifierManager.a().h();
                                                }
                                                return aimagebufferwrapper;
                                            }

                                            protected void a(List list)
                                            {
                                                String s1 = (String)list.get(0);
                                                a a1;
                                                List list1;
                                                if (list.size() == 2)
                                                {
                                                    list = (String)list.get(1);
                                                } else
                                                {
                                                    list = "";
                                                }
                                                a1 = StatusManager.j().f(d.a);
                                                list1 = com.cyberlink.youcammakeup.kernelctrl.j.a().g();
                                                if (a1 == null)
                                                {
                                                    a1 = new a(d.a, a.m.b, a.m.c, a.m.d, com.cyberlink.youcammakeup.kernelctrl.j.a(a.m.i), list1, ((ar)list1.get(d.b)).c.b(), ((ar)list1.get(d.b)).c.c(), d.b, s1, new v(BeautyMode.D), list);
                                                }
                                                list = new a(d.a, b.b(), b.c(), a1.d, com.cyberlink.youcammakeup.kernelctrl.j.a(a.m.i), list1, ((ar)list1.get(c)).c.b(), ((ar)list1.get(c)).c.c(), c, s1, new v(BeautyMode.D), list);
                                                StatusManager.j().a(list, b, new com.cyberlink.youcammakeup.d(this) {

                                                    final a b;

                                                    public void a()
                                                    {
                                                        EditViewActivity.B(b.d.c.a);
                                                    }

                                                    public void b()
                                                    {
                                                        EditViewActivity.B(b.d.c.a);
                                                    }

                                                    public void c()
                                                    {
                                                        EditViewActivity.B(b.d.c.a);
                                                    }

            
            {
                b = a1;
                super();
            }
                                                });
                                            }

                                            protected Object doInBackground(Object aobj[])
                                            {
                                                return a((ImageBufferWrapper[])aobj);
                                            }

                                            protected void onPostExecute(Object obj)
                                            {
                                                a((List)obj);
                                            }

            a(_cls1 _pcls1, ImageViewer imageviewer, ImageBufferWrapper imagebufferwrapper, int i1)
            {
                d = _pcls1;
                a = imageviewer;
                b = imagebufferwrapper;
                c = i1;
                super();
            }
                                        }

                                        int j1;
                                        if (com.cyberlink.youcammakeup.widgetpool.dialogs.ah.b())
                                        {
                                            j1 = 0;
                                        } else
                                        {
                                            j1 = 8;
                                        }
                                        ((EditViewActivity) (obj)).a(-1, -1, -1, -1, -1, -1, j1, -1);
                                        obj = ViewEngine.a().a(a, 1.0D, null);
                                        imageviewer = (ImageViewer)c.a.findViewById(0x7f0c0720);
                                        if (imageviewer == null)
                                        {
                                            com.pf.common.utility.m.e("EditViewActivity", "onSwitchFaceBtnClick. PanZoomViewer is null.");
                                        }
                                        if (PhotoQuality.a(a))
                                        {
                                            break label2;
                                        }
                                        (new a(this, imageviewer, ((ImageBufferWrapper) (obj)), i1)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ImageBufferWrapper[] {
                                            obj
                                        });
                                    }
                                    return;
                                }
                                BeautifierManager beautifiermanager = BeautifierManager.a();
                                beautifiermanager.c(new f(this, beautifiermanager, i1, ((ImageBufferWrapper) (obj)), imageviewer) {

                                    final BeautifierManager a;
                                    final int b;
                                    final ImageBufferWrapper c;
                                    final ImageViewer d;
                                    final _cls1 e;

                                    public void a(BeautifierTaskInfo beautifiertaskinfo)
                                    {
                                        a.i();
                                        beautifiertaskinfo = a.g();
                                        (new a(e, d, c, b)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ImageBufferWrapper[] {
                                            c, beautifiertaskinfo
                                        });
                                    }

            
            {
                e = _pcls1;
                a = beautifiermanager;
                b = i1;
                c = imagebufferwrapper;
                d = imageviewer;
                super();
            }
                                });
                                beautifiermanager.a(dismisstype, false, false);
                                return;
                            }
                            Globals.d().i().h(c.a);
                            com.cyberlink.youcammakeup.activity.EditViewActivity.f(c.a, false);
                            return;
                        }
                        com.cyberlink.youcammakeup.activity.EditViewActivity.f(c.a, false);
                    }

            
            {
                c = _pcls18;
                a = l1;
                b = i1;
                super();
            }
                });
            }

            
            {
                a = EditViewActivity.this;
                super();
            }
        };
        aH = new android.view.View.OnClickListener() {

            final EditViewActivity a;
            private android.content.DialogInterface.OnDismissListener b;

            public void onClick(View view)
            {
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKManualEvent(com.cyberlink.youcammakeup.clflurry.YMKManualEvent.HintButton.a, com.cyberlink.youcammakeup.clflurry.YMKManualEvent.Operation.b));
                while (!StatusManager.j().E().booleanValue() || IntroDialogUtils.a(StatusManager.j().s()) == null && StatusManager.j().r() != MakeupMode.a || EditViewActivity.C(a)) 
                {
                    return;
                }
                com.cyberlink.youcammakeup.activity.EditViewActivity.g(a, true);
                com.cyberlink.youcammakeup.activity.EditViewActivity.b(a).setClickable(false);
                a.X();
                if (b == null)
                {
                    b = new android.content.DialogInterface.OnDismissListener(this) {

                        final _cls19 a;

                        public void onDismiss(DialogInterface dialoginterface)
                        {
                            a.a.Y();
                            com.cyberlink.youcammakeup.activity.EditViewActivity.g(a.a, false);
                            com.cyberlink.youcammakeup.activity.EditViewActivity.b(a.a).setClickable(true);
                        }

            
            {
                a = _pcls19;
                super();
            }
                    };
                }
                view = StatusManager.j().s();
                if (EditViewActivity.D(a) != null && view == BeautyMode.v || view == BeautyMode.r || view == BeautyMode.s || view == BeautyMode.b || view == BeautyMode.a || view == BeautyMode.m || view == BeautyMode.l)
                {
                    view = IntroDialogUtils.a(view, ((BeautyToolPanel)EditViewActivity.D(a)).C(), false);
                    IntroDialogUtils.b(a.getFragmentManager(), b, null, view, false);
                } else
                if (EditViewActivity.D(a) != null && view == BeautyMode.y)
                {
                    view = IntroDialogUtils.a(view, false, ((BeautyToolPanel)EditViewActivity.D(a)).Q());
                    IntroDialogUtils.b(a.getFragmentManager(), b, null, view, false);
                } else
                {
                    IntroDialogUtils.a(a.getFragmentManager(), b, null);
                }
                StatusManager.j().R();
            }

            
            {
                a = EditViewActivity.this;
                super();
            }
        };
        aI = new android.view.View.OnClickListener() {

            final EditViewActivity a;

            public void onClick(View view)
            {
                com.cyberlink.youcammakeup.activity.EditViewActivity.e(a).b(true);
                a.N();
                Globals.d().t().u(false);
                a.c(true);
                view = StatusManager.j().e();
                a.a(MakeupMode.b, BeautyMode.x, view);
            }

            
            {
                a = EditViewActivity.this;
                super();
            }
        };
        aJ = new android.view.View.OnClickListener() {

            final EditViewActivity a;

            public void onClick(View view)
            {
                while (!StatusManager.j().E().booleanValue() || EditViewActivity.E(a) != null && EditViewActivity.E(a).a(view)) 
                {
                    return;
                }
                Globals.d().e("EditViewActivity onUndoBtnClick start");
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKFeatureRoomLookEvent(com.cyberlink.youcammakeup.clflurry.YMKFeatureRoomLookEvent.Operation.g, 0L, 0L, null, YMKFeatureRoomLookEvent.e(), null));
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKSavingPageEvent(0L, 0L, com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.Operation.m, false, false));
                StatusManager.j().a(Boolean.valueOf(false));
                long l1 = StatusManager.j().l();
                if (StatusManager.j().z())
                {
                    view = StatusManager.j().c(l1);
                } else
                {
                    view = StatusManager.j().g(l1);
                }
                if (!view.h())
                {
                    StatusManager.j().a(Boolean.valueOf(true));
                    return;
                } else
                {
                    Globals.d().i().b(a);
                    (new aq(view, new e(this, view) {

                        final d a;
                        final _cls22 b;

                        public void a(ImageStateChangedEvent imagestatechangedevent)
                        {
                            Globals.d().e("EditViewActivity UndoTask complete start");
                            if (imagestatechangedevent.c().a().e != imagestatechangedevent.b().a().e)
                            {
                                StatusManager.j().N();
                            }
                            StatusManager.j().y();
                            Object obj = a.e();
                            if (obj != null)
                            {
                                Object obj1 = ((a) (obj)).f();
                                Object obj2;
                                int i1;
                                int k1;
                                if (obj1 != null && ((v) (obj1)).h() != null)
                                {
                                    MotionControlHelper.e().a(((v) (obj1)).h(), false);
                                    b.a.O();
                                } else
                                {
                                    MotionControlHelper.e().a(null, false);
                                }
                            }
                            obj1 = (ImageViewer)b.a.findViewById(0x7f0c0720);
                            if (obj1 != null)
                            {
                                ((ImageViewer) (obj1)).k();
                            }
                            if (obj != null)
                            {
                                obj2 = ((a) (obj)).f();
                                if (obj2 != null && ((v) (obj2)).f() != null)
                                {
                                    BeautifierEditCenter.a().a(((v) (obj2)).f());
                                } else
                                {
                                    BeautifierEditCenter.a().a(null);
                                }
                                obj2 = com.cyberlink.youcammakeup.kernelctrl.j.a().g();
                                if (obj1 != null && ((ImageViewer) (obj1)).m != null && ((ImageViewer) (obj1)).m.i != null && obj2 != null && ((List) (obj2)).get(((ImageViewer) (obj1)).m.j) != null)
                                {
                                    BeautifierEditCenter.a().a(((ar)((ImageViewer) (obj1)).m.i.get(((ImageViewer) (obj1)).m.j)).b, ((ar)((List) (obj2)).get(((ImageViewer) (obj1)).m.j)).c, false, new BeautifierTaskInfo(false));
                                }
                                if (((a) (obj)).f() == null)
                                {
                                    obj = new i();
                                } else
                                {
                                    obj = ((a) (obj)).f().g();
                                }
                                StatusManager.j().a(((i) (obj)));
                            }
                            if (StatusManager.j().s() != BeautyMode.D || StatusManager.j().r() != MakeupMode.g)
                            {
                                obj = (com.cyberlink.youcammakeup.activity.k[])EditViewActivity.F(b.a).toArray(new com.cyberlink.youcammakeup.activity.k[0]);
                                k1 = obj.length;
                                for (i1 = 0; i1 < k1; i1++)
                                {
                                    obj[i1].a(imagestatechangedevent);
                                }

                            }
                            MotionControlHelper.e().l();
                            long l1 = StatusManager.j().l();
                            int j1;
                            if (StatusManager.j().z())
                            {
                                imagestatechangedevent = StatusManager.j().c(l1);
                            } else
                            {
                                imagestatechangedevent = StatusManager.j().g(l1);
                            }
                            com.cyberlink.youcammakeup.kernelctrl.j.a().a(imagestatechangedevent);
                            Globals.d().i().h(b.a);
                            if (StatusManager.j().s() == BeautyMode.D && StatusManager.j().r() != MakeupMode.a)
                            {
                                j1 = 1;
                            } else
                            {
                                j1 = 0;
                            }
                            if (com.cyberlink.youcammakeup.widgetpool.dialogs.ah.b() && j1 != 0)
                            {
                                j1 = 0;
                            } else
                            {
                                j1 = 8;
                            }
                            b.a.a(-1, -1, -1, -1, -1, -1, j1, -1);
                            StatusManager.j().a(Boolean.valueOf(true));
                            Globals.d().e("EditViewActivity UndoTask complete end");
                        }

                        public volatile void a(Object obj)
                        {
                            a((ImageStateChangedEvent)obj);
                        }

                        public void a(Void void1)
                        {
                            StatusManager.j().a(Boolean.valueOf(true));
                            Globals.d().i().h(b.a);
                        }

                        public void b(Object obj)
                        {
                            a((Void)obj);
                        }

                        public void b(Void void1)
                        {
                            StatusManager.j().a(Boolean.valueOf(true));
                            Globals.d().i().h(b.a);
                        }

                        public void c(Object obj)
                        {
                            b((Void)obj);
                        }

            
            {
                b = _pcls22;
                a = d1;
                super();
            }
                    })).executeOnExecutor(view.c(), new Void[0]);
                    return;
                }
            }

            
            {
                a = EditViewActivity.this;
                super();
            }
        };
        aK = new android.view.View.OnClickListener() {

            final EditViewActivity a;

            public void onClick(View view)
            {
                while (!StatusManager.j().E().booleanValue() || EditViewActivity.E(a) != null && EditViewActivity.E(a).b(view)) 
                {
                    return;
                }
                Globals.d().e("EditViewActivity onRedoBtnClick start");
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKFeatureRoomLookEvent(com.cyberlink.youcammakeup.clflurry.YMKFeatureRoomLookEvent.Operation.f, 0L, 0L, null, YMKFeatureRoomLookEvent.e(), null));
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKSavingPageEvent(0L, 0L, com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.Operation.l, false, false));
                StatusManager.j().a(Boolean.valueOf(false));
                long l1 = StatusManager.j().l();
                if (StatusManager.j().z())
                {
                    view = StatusManager.j().c(l1);
                } else
                {
                    view = StatusManager.j().g(l1);
                }
                if (!view.j())
                {
                    StatusManager.j().a(Boolean.valueOf(true));
                    return;
                } else
                {
                    Globals.d().i().b(a);
                    (new com.cyberlink.youcammakeup.kernelctrl.status.b(view, new e(this, view) {

                        final d a;
                        final _cls23 b;

                        public void a(ImageStateChangedEvent imagestatechangedevent)
                        {
                            Globals.d().e("EditViewActivity RedoTask complete start");
                            if (imagestatechangedevent.c().a().e != imagestatechangedevent.b().a().e)
                            {
                                StatusManager.j().N();
                            }
                            StatusManager.j().y();
                            Object obj = a.e();
                            if (obj != null)
                            {
                                Object obj1 = ((a) (obj)).f();
                                Object obj2;
                                int i1;
                                int k1;
                                if (obj1 != null && ((v) (obj1)).h() != null)
                                {
                                    MotionControlHelper.e().a(((v) (obj1)).h(), false);
                                    b.a.O();
                                } else
                                {
                                    MotionControlHelper.e().a(null, false);
                                }
                            }
                            obj1 = (ImageViewer)b.a.findViewById(0x7f0c0720);
                            if (obj1 != null)
                            {
                                ((ImageViewer) (obj1)).k();
                            }
                            if (obj != null)
                            {
                                obj2 = ((a) (obj)).f();
                                if (obj2 != null)
                                {
                                    BeautifierEditCenter.a().a(((v) (obj2)).f());
                                } else
                                {
                                    BeautifierEditCenter.a().a(null);
                                }
                                obj2 = com.cyberlink.youcammakeup.kernelctrl.j.a().g();
                                if (obj1 != null && ((ImageViewer) (obj1)).m != null && ((ImageViewer) (obj1)).m.i != null && obj2 != null && ((List) (obj2)).get(((ImageViewer) (obj1)).m.j) != null)
                                {
                                    BeautifierEditCenter.a().a(((ar)((ImageViewer) (obj1)).m.i.get(((ImageViewer) (obj1)).m.j)).b, ((ar)((List) (obj2)).get(((ImageViewer) (obj1)).m.j)).c, false, new BeautifierTaskInfo(false));
                                }
                                if (((a) (obj)).f() == null)
                                {
                                    obj = new i();
                                } else
                                {
                                    obj = ((a) (obj)).f().g();
                                }
                                StatusManager.j().a(((i) (obj)));
                            }
                            if (StatusManager.j().s() != BeautyMode.D || StatusManager.j().r() != MakeupMode.g)
                            {
                                obj = (com.cyberlink.youcammakeup.activity.k[])EditViewActivity.F(b.a).toArray(new com.cyberlink.youcammakeup.activity.k[0]);
                                k1 = obj.length;
                                for (i1 = 0; i1 < k1; i1++)
                                {
                                    obj[i1].b(imagestatechangedevent);
                                }

                            }
                            MotionControlHelper.e().l();
                            long l1 = StatusManager.j().l();
                            int j1;
                            if (StatusManager.j().z())
                            {
                                imagestatechangedevent = StatusManager.j().c(l1);
                            } else
                            {
                                imagestatechangedevent = StatusManager.j().g(l1);
                            }
                            com.cyberlink.youcammakeup.kernelctrl.j.a().a(imagestatechangedevent);
                            Globals.d().i().h(b.a);
                            if (StatusManager.j().s() == BeautyMode.D && StatusManager.j().r() != MakeupMode.a)
                            {
                                j1 = 1;
                            } else
                            {
                                j1 = 0;
                            }
                            if (com.cyberlink.youcammakeup.widgetpool.dialogs.ah.b() && j1 != 0)
                            {
                                j1 = 0;
                            } else
                            {
                                j1 = 8;
                            }
                            b.a.a(-1, -1, -1, -1, -1, -1, j1, -1);
                            StatusManager.j().a(Boolean.valueOf(true));
                            Globals.d().e("EditViewActivity RedoTask complete end");
                        }

                        public volatile void a(Object obj)
                        {
                            a((ImageStateChangedEvent)obj);
                        }

                        public void a(Void void1)
                        {
                            StatusManager.j().a(Boolean.valueOf(true));
                            Globals.d().i().h(b.a);
                        }

                        public void b(Object obj)
                        {
                            a((Void)obj);
                        }

                        public void b(Void void1)
                        {
                            StatusManager.j().a(Boolean.valueOf(true));
                            Globals.d().i().h(b.a);
                        }

                        public void c(Object obj)
                        {
                            b((Void)obj);
                        }

            
            {
                b = _pcls23;
                a = d1;
                super();
            }
                    })).executeOnExecutor(view.c(), new Void[0]);
                    return;
                }
            }

            
            {
                a = EditViewActivity.this;
                super();
            }
        };
        aL = new android.view.View.OnClickListener() {

            final EditViewActivity a;

            public void onClick(View view)
            {
                while (!StatusManager.j().E().booleanValue() || EditViewActivity.E(a) == null || !EditViewActivity.E(a).c(view)) 
                {
                    return;
                }
            }

            
            {
                a = EditViewActivity.this;
                super();
            }
        };
        aM = new android.view.View.OnClickListener() {

            final EditViewActivity a;

            public void onClick(View view)
            {
                a.b(true, true);
            }

            
            {
                a = EditViewActivity.this;
                super();
            }
        };
        aN = new android.view.View.OnClickListener() {

            final EditViewActivity a;

            public void onClick(View view)
            {
                view = MotionControlHelper.e().f();
                if (view == null)
                {
                    return;
                }
                MotionControlHelper motioncontrolhelper = MotionControlHelper.e();
                boolean flag;
                if (!view.booleanValue())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                motioncontrolhelper.a(Boolean.valueOf(flag), true);
                a.O();
            }

            
            {
                a = EditViewActivity.this;
                super();
            }
        };
        aO = new android.view.View.OnClickListener() {

            final EditViewActivity a;

            public void onClick(View view)
            {
                if (EditViewActivity.G(a) == null)
                {
                    return;
                }
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKFeatureRoomLookEvent(com.cyberlink.youcammakeup.clflurry.YMKFeatureRoomLookEvent.Operation.d, 0L, 0L, null, YMKFeatureRoomLookEvent.e(), null));
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKSavingPageEvent(0L, 0L, com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.Operation.k, false, false));
                ImageViewer imageviewer = (ImageViewer)a.findViewById(0x7f0c0720);
                if (imageviewer != null)
                {
                    long l1 = StatusManager.j().l();
                    if (StatusManager.j().z())
                    {
                        view = StatusManager.j().c(l1);
                    } else
                    {
                        view = StatusManager.j().g(l1);
                    }
                    com.cyberlink.youcammakeup.activity.EditViewActivity.a(a, view.d());
                    a.o(true);
                    imageviewer.setFeaturePtVisibility(true);
                }
                com.cyberlink.youcammakeup.activity.EditViewActivity.d(a, false);
            }

            
            {
                a = EditViewActivity.this;
                super();
            }
        };
        aP = new android.view.View.OnLayoutChangeListener() {

            final EditViewActivity a;

            public void onLayoutChange(View view, int i1, int j1, int k1, int l1, int i2, int j2, 
                    int k2, int l2)
            {
                for (view = StatusManager.j().s(); view == BeautyMode.v || view == BeautyMode.a || view == BeautyMode.b || view == BeautyMode.m || view == BeautyMode.l || view == BeautyMode.r || view == BeautyMode.n || i2 == 0 && j2 == 0 && k2 == 0 && l2 == 0 || i1 == i2 && j1 == j2 && k1 == k2 && l1 == l2;)
                {
                    return;
                }

                view = a.findViewById(0x1020002);
                a.c(view.getHeight() - j1);
            }

            
            {
                a = EditViewActivity.this;
                super();
            }
        };
    }

    static ArrayList A(EditViewActivity editviewactivity)
    {
        return editviewactivity.Y;
    }

    static void B(EditViewActivity editviewactivity)
    {
        editviewactivity.as();
    }

    static boolean C(EditViewActivity editviewactivity)
    {
        return editviewactivity.ap;
    }

    static com.cyberlink.youcammakeup.widgetpool.panel.a D(EditViewActivity editviewactivity)
    {
        return editviewactivity.J;
    }

    static com.cyberlink.youcammakeup.activity.g E(EditViewActivity editviewactivity)
    {
        return editviewactivity.Z;
    }

    static ArrayList F(EditViewActivity editviewactivity)
    {
        return editviewactivity.W;
    }

    static View G(EditViewActivity editviewactivity)
    {
        return editviewactivity.m;
    }

    static int a(EditViewActivity editviewactivity)
    {
        return editviewactivity.aD;
    }

    static int a(EditViewActivity editviewactivity, int i1)
    {
        editviewactivity.A = i1;
        return i1;
    }

    static com.cyberlink.youcammakeup.activity.h a(EditViewActivity editviewactivity, com.cyberlink.youcammakeup.activity.h h1)
    {
        editviewactivity.ac = h1;
        return h1;
    }

    static com.cyberlink.youcammakeup.widgetpool.dialogs.q a(EditViewActivity editviewactivity, com.cyberlink.youcammakeup.widgetpool.dialogs.q q1)
    {
        editviewactivity.aw = q1;
        return q1;
    }

    private void a(View view)
    {
        if (view.isPressed())
        {
            view.setPressed(false);
        }
        view.setClickable(false);
    }

    static void a(EditViewActivity editviewactivity, SessionState sessionstate)
    {
        editviewactivity.a(sessionstate);
    }

    static void a(EditViewActivity editviewactivity, String s1)
    {
        editviewactivity.c(s1);
    }

    private void a(SessionState sessionstate)
    {
        ImageViewer imageviewer = (ImageViewer)findViewById(0x7f0c0720);
        if (imageviewer != null)
        {
            MakeupMode makeupmode = StatusManager.j().r();
            BeautyMode beautymode = StatusManager.j().s();
            FineTuneToolBar finetunetoolbar = ar;
            imageviewer.a(FineTuneToolBar.a(makeupmode, beautymode), sessionstate);
        }
    }

    static boolean a(EditViewActivity editviewactivity, boolean flag)
    {
        editviewactivity.U = flag;
        return flag;
    }

    static TopToolBar ae()
    {
        return h;
    }

    private boolean af()
    {
        ImageViewer imageviewer = (ImageViewer)findViewById(0x7f0c0720);
        return imageviewer != null && imageviewer.b().booleanValue();
    }

    private void ag()
    {
        com.cyberlink.youcammakeup.utility.DownloadUseUtils.UseTemplate usetemplate;
        if (!StatusManager.j().P())
        {
            if ((usetemplate = DownloadUseUtils.a(this)) == null || DownloadUseUtils.c(usetemplate))
            {
                Globals.d(new Runnable() {

                    final EditViewActivity a;

                    public void run()
                    {
                        com.cyberlink.youcammakeup.activity.EditViewActivity.g(a).a();
                        com.cyberlink.youcammakeup.activity.EditViewActivity.h(a).a(true);
                    }

            
            {
                a = EditViewActivity.this;
                super();
            }
                });
                return;
            }
        }
    }

    private boolean ah()
    {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        return "android.intent.action.SEND".equals(intent.getAction()) && bundle.containsKey("android.intent.extra.STREAM");
    }

    private void ai()
    {
        Object obj = getIntent();
        Object obj1 = (ActivityManager)getSystemService("activity");
        if (obj1 != null)
        {
            obj1 = ((ActivityManager) (obj1)).getRecentTasks(10, 0);
            if (obj1 != null && ((List) (obj1)).size() > 1)
            {
                obj1 = ((android.app.ActivityManager.RecentTaskInfo)((List) (obj1)).get(1)).baseIntent.getComponent();
                if (obj1 != null)
                {
                    com.pf.common.utility.m.b("EditViewActivity", (new StringBuilder()).append("packageName=").append(((ComponentName) (obj1)).getPackageName()).toString());
                }
            }
        }
        obj = (Uri)((Intent) (obj)).getParcelableExtra("android.intent.extra.STREAM");
        c((new StringBuilder()).append("intent imageUri path = ").append(((Uri) (obj)).getPath()).toString());
        obj1 = com.cyberlink.youcammakeup.c.e().a(((Uri) (obj)));
        if (obj1 != null)
        {
            long l1;
            if (com.cyberlink.youcammakeup.c.e().b(((Long) (obj1)).longValue()) == null)
            {
                try
                {
                    b(((Uri) (obj)));
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    com.pf.common.utility.m.b("EditViewActivity", "", ((Throwable) (obj)));
                    return;
                }
                l1 = -20L;
            } else
            {
                l1 = com.cyberlink.youcammakeup.c.f().f(((Long) (obj1)).longValue());
            }
            StatusManager.j().a(l1, a);
            D();
            return;
        } else
        {
            Globals.d().r().a(-1L, new File(((Uri) (obj)).getPath()), UIImageCodecErrorCode.a, (ImageBufferWrapper)null, UIImageOrientation.b, null, new com.cyberlink.youcammakeup.masteraccess.c() {

                final EditViewActivity a;

                public void a()
                {
                    com.pf.common.utility.m.e("notifyByInsertFirst", "onCancel");
                }

                public void a(com.cyberlink.youcammakeup.masteraccess.Exporter.Error error)
                {
                    com.pf.common.utility.m.e("notifyByInsertFirst", "onError");
                }

                public void a(com.cyberlink.youcammakeup.masteraccess.b b1)
                {
                    com.pf.common.utility.m.c("notifyByInsertFirst", "onComplete");
                    StatusManager.j().a(b1.a(), com.cyberlink.youcammakeup.activity.EditViewActivity.a);
                    a.runOnUiThread(new Runnable(this) {

                        final _cls4 a;

                        public void run()
                        {
                            a.a.D();
                        }

            
            {
                a = _pcls4;
                super();
            }
                    });
                }

            
            {
                a = EditViewActivity.this;
                super();
            }
            });
            return;
        }
    }

    private void aj()
    {
        Object obj = Globals.d();
        o o1 = ((Globals) (obj)).i();
        o1.a(this, 10000L);
        o1.b(true);
        Object obj1 = StatusManager.j();
        obj1 = ((StatusManager) (obj1)).f(((StatusManager) (obj1)).l());
        float f1 = bo.c();
        if (((a) (obj1)).e == -1)
        {
            obj = getIntent();
            if (obj != null && ((Intent) (obj)).getBooleanExtra("IS_INTENT_FROM_LIBRARY_CAMERA", false))
            {
                ((Intent) (obj)).putExtra("SHOULD_REOPEN_LIBRARY_CAMERA", true);
            }
            x(false);
            return;
        }
        Intent intent = getIntent();
        if (intent != null && intent.getBooleanExtra("IS_INTENT_FROM_LIBRARY_CAMERA", false))
        {
            intent.putExtra("SHOULD_REOPEN_LIBRARY_CAMERA", false);
        }
        o1.b(false);
        if (com.cyberlink.youcammakeup.kernelctrl.z.e("KEY_CONTENT_VERSION_FOR_TEMPLATE_PARSER", this) == f1)
        {
            ((Globals) (obj)).i().h(this);
        }
        MotionControlHelper.e().a(((a) (obj1)).d().size(), false);
        MotionControlHelper.e().a(null);
        obj = (ar)((a) (obj1)).d().get(((a) (obj1)).e);
        if (obj != null)
        {
            BeautifierEditCenter.a().a(((ar) (obj)).b, ((ar) (obj)).c, false, new BeautifierTaskInfo(false));
        }
        com.cyberlink.youcammakeup.kernelctrl.j.a().c();
        com.cyberlink.youcammakeup.kernelctrl.j.a().b();
        bo.B(null);
        MotionControlHelper.e().av();
        VenusHelper.a().F();
        ImageCacheChannel.b(ImageCacheChannel.a);
        if (((a) (obj1)).d().size() > 1)
        {
            a(E, 0, A, B, C, D, G, H);
            f.onClick(k);
            com.cyberlink.youcammakeup.activity.j.a(ao, false);
            return;
        }
        if (((a) (obj1)).e != -1)
        {
            y(true);
            return;
        } else
        {
            com.cyberlink.youcammakeup.activity.j.a(ao, true);
            return;
        }
    }

    private void ak()
    {
        av = new f() {

            final EditViewActivity a;

            public void a(BeautifierTaskInfo beautifiertaskinfo1)
            {
                BeautifierManager.a().b(com.cyberlink.youcammakeup.activity.EditViewActivity.q(a));
                (new AsyncTask(this, beautifiertaskinfo1) {

                    final BeautifierTaskInfo a;
                    final _cls8 b;

                    protected transient Void a(Void avoid[])
                    {
                        MotionControlHelper.e().p();
                        MotionControlHelper.e().t();
                        MotionControlHelper.e().s();
                        return null;
                    }

                    protected void a(Void void1)
                    {
                        com.cyberlink.youcammakeup.activity.EditViewActivity.d(b.a, false);
                        com.cyberlink.youcammakeup.activity.EditViewActivity.r(b.a);
                        if (a.a() && a.c())
                        {
                            b.a.a(false, null);
                        }
                        b.a.j(false);
                        int i1;
                        if (StatusManager.j().r() == MakeupMode.g && com.cyberlink.youcammakeup.widgetpool.dialogs.ah.b())
                        {
                            i1 = 0;
                        } else
                        {
                            i1 = 8;
                        }
                        b.a.a(-1, -1, -1, -1, -1, -1, i1, -1);
                        StatusManager.j().a(Boolean.valueOf(true));
                        Globals.d().i().b(false);
                        Globals.d().i().h(b.a);
                        Globals.d(new Runnable(this) {

                            final _cls1 a;

                            public void run()
                            {
                                if (y.a != null && (a.b.a.e instanceof com.cyberlink.youcammakeup.widgetpool.c.a))
                                {
                                    ((com.cyberlink.youcammakeup.widgetpool.c.a)a.b.a.e).a(null);
                                    com.cyberlink.youcammakeup.utility.aa.a(y.a);
                                    y.a = null;
                                }
                            }

            
            {
                a = _pcls1;
                super();
            }
                        });
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
                b = _pcls8;
                a = beautifiertaskinfo;
                super();
            }
                }).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
            }

            
            {
                a = EditViewActivity.this;
                super();
            }
        };
        Globals.d().i().a(this, 2000L);
        Globals.d().i().b(true);
        BeautifierManager.a().a(av);
        i i1 = com.cyberlink.youcammakeup.widgetpool.panel.c.p.a().e();
        i1.h(45F);
        StatusManager.j().a(i1);
        MotionControlHelper.e().n();
        BeautifierTaskInfo beautifiertaskinfo = new BeautifierTaskInfo(true, true, false, false);
        MotionControlHelper.e().a(i1, beautifiertaskinfo);
    }

    private void al()
    {
        if (as == null)
        {
            as = new com.cyberlink.youcammakeup.camera.ah(this);
        }
        boolean flag = com.cyberlink.youcammakeup.kernelctrl.z.a("CAMERA_SETTING_SOUND", true, Globals.d());
        as.a(flag);
        at = (CameraShotAnimationVeiw)findViewById(0x7f0c00e8);
        at.setOnAnimationStartListener(new com.cyberlink.youcammakeup.camera.i() {

            final EditViewActivity a;

            public void a()
            {
                com.cyberlink.youcammakeup.activity.EditViewActivity.s(a).a(4);
            }

            public void b()
            {
            }

            
            {
                a = EditViewActivity.this;
                super();
            }
        });
        at.a();
        at.setStarRepeatCount(0);
        at.c();
    }

    private void am()
    {
        if (Globals.d().t() == this)
        {
            Globals.d().a(null);
        }
        Globals.d().a(null);
        MotionControlHelper.e().l();
        StatusManager.j().a(null);
        StatusManager.j().G();
        com.cyberlink.youcammakeup.kernelctrl.j.a().a(null);
        long l1 = StatusManager.j().l();
        ViewEngine.a().b(l1);
        StatusManager.j().d(l1);
        BeautifierEditCenter.a().b();
        MotionControlHelper.e().a(null, false);
        MotionControlHelper.e().a(null);
        MotionControlHelper.e().u();
        MotionControlHelper.e().W();
        MotionControlHelper.e().r(true);
        com.cyberlink.youcammakeup.kernelctrl.j.a().c();
        bo.B(null);
        MotionControlHelper.e().av();
        ImageCacheChannel.b(ImageCacheChannel.a);
        VenusHelper.a().F();
        VenusHelper.a().o();
        VenusHelper.a().w();
        VenusHelper.a().s();
        VenusHelper.a().C();
        VenusHelper.a().B();
        DownloadUseUtils.a(false);
    }

    private void an()
    {
        if (w != null)
        {
            w.setOnSeekBarChangeListener(null);
            w = null;
        }
        x = null;
        if (i != null)
        {
            if (y != null)
            {
                ap();
            }
            i.setOnTouchListener(null);
        }
        if (j != null)
        {
            j.setOnClickListener(null);
        }
        if (k != null)
        {
            k.setOnClickListener(null);
        }
        if (l != null)
        {
            l.setOnClickListener(null);
        }
        if (m != null)
        {
            m.setOnClickListener(null);
        }
        if (n != null)
        {
            n.setOnTouchListener(null);
        }
        if (o != null)
        {
            o.setOnTouchListener(null);
        }
        if (p != null)
        {
            p.setOnTouchListener(null);
        }
        if (q != null)
        {
            q.setOnClickListener(null);
        }
        if (s != null)
        {
            s.setOnClickListener(null);
        }
        A = 4;
        B = 4;
        C = 4;
        E = 4;
        F = 4;
        G = 4;
        a(Boolean.valueOf(false), Boolean.valueOf(false));
        if (ac != null)
        {
            ac.cancel(true);
            ac = null;
        }
        ae = null;
        Q = null;
        al = null;
        am = null;
        if (W != null && W.size() > 0)
        {
            W.clear();
        }
        if (X != null && X.size() > 0)
        {
            X.clear();
        }
        if (Y != null && Y.size() > 0)
        {
            Y.clear();
        }
        a(((com.cyberlink.youcammakeup.activity.e) (null)));
        if (as != null)
        {
            as.a();
        }
    }

    private void ao()
    {
        if (au)
        {
            au = false;
            if (al != null)
            {
                al.a();
            }
        }
    }

    private void ap()
    {
        Object obj;
        obj = getFragmentManager();
        if (y == null || obj == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        obj = ((FragmentManager) (obj)).beginTransaction();
        ((FragmentTransaction) (obj)).remove(y);
        ((FragmentTransaction) (obj)).commit();
        y = null;
        return;
        Exception exception;
        exception;
    }

    private void aq()
    {
        Object obj = StatusManager.j().r();
        if (StatusManager.j().r() != null && obj != MakeupMode.g)
        {
            if (obj == MakeupMode.a)
            {
                com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.a));
            } else
            {
                if (obj == MakeupMode.b)
                {
                    com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.x));
                    return;
                }
                obj = StatusManager.j().s();
                if (obj != null && obj != BeautyMode.D)
                {
                    obj = YMKFeatures.a(((BeautyMode) (obj)));
                    if (obj != null)
                    {
                        com.cyberlink.youcammakeup.clflurry.b.a(new am(((com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName) (obj))));
                        return;
                    }
                }
            }
        }
    }

    private void ar()
    {
        BeautifierManager.a().b(this);
        StatusManager.j().b(this);
        StatusManager.j().b(this);
        StatusManager.j().b(this);
        StatusManager.j().b(this);
        StatusManager.j().b(this);
        StatusManager.j().b(this);
        StatusManager.j().b(this);
        StatusManager.j().b(this);
        StatusManager.j().b(this);
    }

    private void as()
    {
        if (StatusManager.j().c(StatusManager.j().l()) != null)
        {
            StatusManager.j().y();
        }
        Globals.d().i().h(this);
        y(false);
    }

    private void at()
    {
        ImageViewer imageviewer = (ImageViewer)findViewById(0x7f0c0720);
        if (imageviewer == null)
        {
            return;
        } else
        {
            (new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.f()).a = true;
            imageviewer.b(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.a, new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.f());
            imageviewer.b(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.b, new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.f());
            return;
        }
    }

    static int b(EditViewActivity editviewactivity, int i1)
    {
        editviewactivity.z = i1;
        return i1;
    }

    static View b(EditViewActivity editviewactivity)
    {
        return editviewactivity.l;
    }

    private void b(Uri uri)
    {
        uri = getContentResolver().openFileDescriptor(uri, "r");
        ViewEngine.a().a(-20L, new ImageBufferWrapper(uri.getFileDescriptor()));
        uri.close();
        return;
        Exception exception;
        exception;
        uri.close();
        throw exception;
    }

    private void b(com.cyberlink.youcammakeup.activity.f f1)
    {
        ax = new com.cyberlink.youcammakeup.widgetpool.dialogs.a(this, true);
        f1 = new com.cyberlink.youcammakeup.widgetpool.dialogs.b(f1) {

            final com.cyberlink.youcammakeup.activity.f a;
            final EditViewActivity b;

            public void a()
            {
                if (a != null)
                {
                    a.a();
                }
            }

            public void b()
            {
                b.J();
            }

            
            {
                b = EditViewActivity.this;
                a = f1;
                super();
            }
        };
        ax.a(f1);
        ax.show();
    }

    private void b(a a1)
    {
        runOnUiThread(new Runnable(a1) {

            final a a;
            final EditViewActivity b;

            public void run()
            {
                for (Iterator iterator = com.cyberlink.youcammakeup.activity.EditViewActivity.z(b).iterator(); iterator.hasNext(); ((com.cyberlink.youcammakeup.activity.i)iterator.next()).a(a)) { }
            }

            
            {
                b = EditViewActivity.this;
                a = a1;
                super();
            }
        });
    }

    static boolean b(EditViewActivity editviewactivity, boolean flag)
    {
        editviewactivity.T = flag;
        return flag;
    }

    private void c(Boolean boolean1)
    {
        while (i == null || k == null || l == null || n == null || o == null || q == null || p == null || this != null) 
        {
            return;
        }
        if (boolean1.booleanValue())
        {
            l.setVisibility(A);
            n.setVisibility(B);
            o.setVisibility(C);
            p.setVisibility(D);
            i.setVisibility(E);
            k.setVisibility(F);
            q.setVisibility(G);
            return;
        } else
        {
            l.setVisibility(4);
            n.setVisibility(4);
            o.setVisibility(4);
            p.setVisibility(4);
            i.setVisibility(4);
            k.setVisibility(4);
            q.setVisibility(4);
            return;
        }
    }

    private void c(String s1)
    {
        com.pf.common.utility.m.b("EditViewActivity", s1);
    }

    static boolean c(EditViewActivity editviewactivity)
    {
        return editviewactivity.af();
    }

    static boolean c(EditViewActivity editviewactivity, boolean flag)
    {
        editviewactivity.aq = flag;
        return flag;
    }

    static com.cyberlink.youcammakeup.activity.h d(EditViewActivity editviewactivity)
    {
        return editviewactivity.ac;
    }

    static void d(EditViewActivity editviewactivity, boolean flag)
    {
        editviewactivity.z(flag);
    }

    static MakeupLooksBottomToolbar e(EditViewActivity editviewactivity)
    {
        return editviewactivity.am;
    }

    static boolean e(EditViewActivity editviewactivity, boolean flag)
    {
        editviewactivity.az = flag;
        return flag;
    }

    static MakeupMenuBottomToolbar f(EditViewActivity editviewactivity)
    {
        return editviewactivity.al;
    }

    static void f(EditViewActivity editviewactivity, boolean flag)
    {
        editviewactivity.y(flag);
    }

    static com.cyberlink.youcammakeup.activity.j g(EditViewActivity editviewactivity)
    {
        return editviewactivity.ao;
    }

    static boolean g(EditViewActivity editviewactivity, boolean flag)
    {
        editviewactivity.ap = flag;
        return flag;
    }

    static com.cyberlink.youcammakeup.activity.d h(EditViewActivity editviewactivity)
    {
        return editviewactivity.an;
    }

    static View i(EditViewActivity editviewactivity)
    {
        return editviewactivity.N;
    }

    static com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.k j(EditViewActivity editviewactivity)
    {
        return editviewactivity.P;
    }

    static boolean k(EditViewActivity editviewactivity)
    {
        return editviewactivity.T;
    }

    static SliderValueText l(EditViewActivity editviewactivity)
    {
        return editviewactivity.x;
    }

    static View m(EditViewActivity editviewactivity)
    {
        return editviewactivity.M;
    }

    static void n(EditViewActivity editviewactivity)
    {
        editviewactivity.aj();
    }

    static void o(EditViewActivity editviewactivity)
    {
        editviewactivity.al();
    }

    static void p(EditViewActivity editviewactivity)
    {
        editviewactivity.ak();
    }

    static f q(EditViewActivity editviewactivity)
    {
        return editviewactivity.av;
    }

    static void r(EditViewActivity editviewactivity)
    {
        editviewactivity.at();
    }

    static com.cyberlink.youcammakeup.camera.ah s(EditViewActivity editviewactivity)
    {
        return editviewactivity.as;
    }

    static com.cyberlink.youcammakeup.widgetpool.dialogs.q t(EditViewActivity editviewactivity)
    {
        return editviewactivity.aw;
    }

    static com.cyberlink.youcammakeup.jniproxy.f u(EditViewActivity editviewactivity)
    {
        return editviewactivity.ay;
    }

    static void v(EditViewActivity editviewactivity)
    {
        editviewactivity.ao();
    }

    static boolean w(EditViewActivity editviewactivity)
    {
        return editviewactivity.ah;
    }

    static FPSampleController x(EditViewActivity editviewactivity)
    {
        return editviewactivity.ag;
    }

    private void x(boolean flag)
    {
        af = true;
        e(flag);
    }

    static int y(EditViewActivity editviewactivity)
    {
        return editviewactivity.z;
    }

    private void y(boolean flag)
    {
        long l1 = StatusManager.j().l();
        b(StatusManager.j().f(l1));
        if (flag)
        {
            com.cyberlink.youcammakeup.activity.j.a(ao, true);
        } else
        if (aC)
        {
            aC = false;
            if (al != null)
            {
                al.a();
                return;
            }
        }
    }

    static ArrayList z(EditViewActivity editviewactivity)
    {
        return editviewactivity.X;
    }

    private void z(boolean flag)
    {
        ImageViewer imageviewer = (ImageViewer)findViewById(0x7f0c0720);
        if (imageviewer == null)
        {
            return;
        } else
        {
            com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.f f1 = new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.f();
            f1.a = true;
            f1.c = new com.cyberlink.youcammakeup.kernelctrl.viewengine.c(com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine.TaskRole.d);
            f1.c.f = Boolean.valueOf(flag);
            imageviewer.b(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c, f1);
            return;
        }
    }

    public boolean A()
    {
        if (ar != null)
        {
            return ar.isVisible();
        } else
        {
            return false;
        }
    }

    public boolean B()
    {
        if (ar != null)
        {
            return ar.o();
        } else
        {
            return false;
        }
    }

    public int C()
    {
        int i1 = 8;
        if (M != null)
        {
            i1 = M.getVisibility();
        }
        return i1;
    }

    public void D()
    {
        Globals globals = Globals.d();
        o o1 = globals.i();
        o1.a(this, 10000L);
        o1.b(true);
        Object obj = StatusManager.j();
        long l1 = ((StatusManager) (obj)).l();
        a a1 = ((StatusManager) (obj)).f(l1);
        if (a1 == null)
        {
            ((StatusManager) (obj)).a(this);
            return;
        }
        if (m() == null || m().getView() == null)
        {
            b(((a) (null)));
            return;
        }
        ViewGroup viewgroup = (ViewGroup)findViewById(0x7f0c00e5);
        if (b)
        {
            L();
        }
        float f1 = bo.c();
        Globals.d().a(null);
        Object obj1 = com.cyberlink.youcammakeup.c.f();
        if (obj1 != null)
        {
            obj1 = ((com.cyberlink.youcammakeup.database.p) (obj1)).c(l1);
            if (obj1 != null && be.d(((com.cyberlink.youcammakeup.database.r) (obj1))))
            {
                obj1 = be.b(((com.cyberlink.youcammakeup.database.r) (obj1)));
                if (obj1 != null)
                {
                    StatusManager.j().a(((ar) (obj1)));
                    a1.d().get(a1.e);
                    BeautifierEditCenter.a().a(((ar) (obj1)).b, ((ar) (obj1)).c, false, new BeautifierTaskInfo(false));
                    com.cyberlink.youcammakeup.kernelctrl.j.a().c();
                    com.cyberlink.youcammakeup.kernelctrl.j.a().b();
                    MotionControlHelper.e().b(((ar) (obj1)).d.b());
                    MotionControlHelper.e().c(((ar) (obj1)).e.b());
                    MotionControlHelper.e().a(Boolean.valueOf(((ar) (obj1)).f), false);
                    MotionControlHelper.e().a(((ar) (obj1)).g.a(), ((ar) (obj1)).g.b());
                    o1.b(false);
                    if (com.cyberlink.youcammakeup.kernelctrl.z.e("KEY_CONTENT_VERSION_FOR_TEMPLATE_PARSER", this) == f1)
                    {
                        globals.i().h(this);
                    }
                    bo.B(null);
                    MotionControlHelper.e().av();
                    VenusHelper.a().F();
                    ImageCacheChannel.b(ImageCacheChannel.a);
                    y(true);
                    MotionControlHelper.e().a(1, false);
                    return;
                }
            }
        }
        if (StatusManager.j().P() || az)
        {
            List list = StatusManager.j().Q();
            if (list.size() == 0)
            {
                obj = ViewEngine.a().a(((StatusManager) (obj)).l(), 1.0D, null);
                ay.a(((ImageBufferWrapper) (obj)).j());
                x(true);
                return;
            } else
            {
                ((StatusManager) (obj)).a(new com.cyberlink.youcammakeup.kernelctrl.aw(list) {

                    final List a;
                    final EditViewActivity b;

                    public void a()
                    {
                        com.cyberlink.youcammakeup.activity.EditViewActivity.n(b);
                        if (a.size() > 0 && StatusManager.j().P())
                        {
                            com.cyberlink.youcammakeup.activity.EditViewActivity.o(b);
                            com.cyberlink.youcammakeup.activity.EditViewActivity.p(b);
                        }
                    }

                    public void a(List list1)
                    {
                        com.cyberlink.youcammakeup.activity.EditViewActivity.n(b);
                        if (list1.size() > 0 && StatusManager.j().P())
                        {
                            com.cyberlink.youcammakeup.activity.EditViewActivity.o(b);
                            com.cyberlink.youcammakeup.activity.EditViewActivity.p(b);
                        }
                        int i1 = 0;
                        if (list1 != null)
                        {
                            i1 = list1.size();
                        }
                        com.cyberlink.youcammakeup.flurry.a.a(new FaceDetectionResultEvent(i1));
                    }

            
            {
                b = EditViewActivity.this;
                a = list;
                super();
            }
                }, list);
                return;
            }
        } else
        {
            YMKSavingPageEvent.b(true);
            o1.a(this, viewgroup, new com.cyberlink.youcammakeup.utility.p() {

                final EditViewActivity a;

                public void a()
                {
                    com.cyberlink.youcammakeup.activity.EditViewActivity.n(a);
                }

            
            {
                a = EditViewActivity.this;
                super();
            }
            });
            ((StatusManager) (obj)).a(new com.cyberlink.youcammakeup.kernelctrl.aw(o1) {

                final o a;
                final EditViewActivity b;

                public void a()
                {
                    a.a(true);
                }

                public void a(List list1)
                {
                    a.a(true);
                    int i1 = 0;
                    if (list1 != null)
                    {
                        i1 = list1.size();
                    }
                    com.cyberlink.youcammakeup.flurry.a.a(new FaceDetectionResultEvent(i1));
                }

            
            {
                b = EditViewActivity.this;
                a = o1;
                super();
            }
            });
            return;
        }
    }

    protected void E()
    {
        Globals.d().c(null);
    }

    protected void F()
    {
        Globals.d().c("editView");
    }

    public boolean G()
    {
        if (Q != null && Q.a() == 0)
        {
            a(0, 4, 4, 0, 0, 4, 4, 0);
            Q.a(8);
            h.a(Boolean.valueOf(false));
            return true;
        } else
        {
            Globals.d().t().u(false);
            return false;
        }
    }

    public void H()
    {
        Q.e();
        Q.a(0);
    }

    public void I()
    {
        if (StatusManager.j().r() == MakeupMode.a)
        {
            a(((com.cyberlink.youcammakeup.activity.f) (null)));
        } else
        {
            if (J != null && (J instanceof BeautyToolPanel) && !((BeautyToolPanel)J).O())
            {
                ((BeautyToolPanel)J).P();
                return;
            }
            if (h == null || !h.b())
            {
                long l1 = StatusManager.j().l();
                if (StatusManager.j().c(l1).h())
                {
                    b(((com.cyberlink.youcammakeup.activity.f) (null)));
                    return;
                } else
                {
                    J();
                    return;
                }
            }
        }
    }

    protected void J()
    {
        String s1 = ca.b().a("%d");
        com.cyberlink.youcammakeup.clflurry.b.a(new YMKEditStayTimeEvent(com.cyberlink.youcammakeup.clflurry.YMKEditStayTimeEvent.Button.a, s1));
        com.cyberlink.youcammakeup.flurry.a.a(new com.cyberlink.youcammakeup.flurry.YMKEditStayTimeEvent(com.cyberlink.youcammakeup.flurry.YMKEditStayTimeEvent.Button.a, s1));
        if (!isTaskRoot()) goto _L2; else goto _L1
_L1:
        if (!StatusManager.j().O()) goto _L4; else goto _L3
_L3:
        Intent intent = new Intent(getApplicationContext(), com/cyberlink/youcammakeup/activity/LauncherActivity);
_L5:
        startActivity(intent);
        finish();
        return;
_L4:
        if (StatusManager.j().P())
        {
            intent = new Intent(getApplicationContext(), com/cyberlink/youcammakeup/activity/CameraActivity);
        } else
        {
            DownloadUseUtils.a(false);
            Intent intent1 = new Intent(getApplicationContext(), com/cyberlink/youcammakeup/activity/LibraryPickerActivity);
            intent1.putExtra("LibraryPickerActivity_STATE", new LibraryPickerActivity.State("editView"));
            intent1.putExtra("EXTRA_KEY_DOWNLOADED_TEMPLATE", DownloadUseUtils.a(this));
            intent1.putExtra("EXTRA_KEY_SKU_TRY_IT_URL", getIntent().getSerializableExtra("EXTRA_KEY_SKU_TRY_IT_URL"));
            Intent intent2 = getIntent();
            intent = intent1;
            if (intent2 != null)
            {
                intent1.putExtra("SHOULD_REOPEN_LIBRARY_CAMERA", intent2.getBooleanExtra("SHOULD_REOPEN_LIBRARY_CAMERA", false));
                intent = intent1;
                if (intent2.getBooleanExtra("ShowZooView", false))
                {
                    intent1.putExtra("ShowZooView", true);
                    intent1.putExtra(getResources().getString(0x7f070729), com/cyberlink/youcammakeup/activity/CameraActivity);
                    intent = intent1;
                }
            }
        }
        if (true) goto _L5; else goto _L2
_L2:
        finish();
        return;
    }

    public Boolean K()
    {
        Object obj = getFragmentManager();
        if (obj == null)
        {
            return Boolean.valueOf(false);
        } else
        {
            obj = ((FragmentManager) (obj)).beginTransaction();
            b = true;
            a(Boolean.valueOf(false));
            v = T();
            m(false);
            y = new com.cyberlink.youcammakeup.widgetpool.b.a();
            ((FragmentTransaction) (obj)).replace(0x7f0c00c1, y);
            ((FragmentTransaction) (obj)).commit();
            return Boolean.valueOf(true);
        }
    }

    public Boolean L()
    {
        Object obj = getFragmentManager();
        if (obj == null)
        {
            return Boolean.valueOf(false);
        }
        b = false;
        if (y == null)
        {
            return Boolean.valueOf(false);
        }
        obj = ((FragmentManager) (obj)).beginTransaction();
        ((com.cyberlink.youcammakeup.widgetpool.b.a)y).a();
        ((FragmentTransaction) (obj)).remove(y);
        boolean flag;
        try
        {
            ((FragmentTransaction) (obj)).commit();
            y = null;
        }
        catch (Exception exception)
        {
            c((new StringBuilder()).append("Compare exception: ").append(exception).toString());
        }
        ((FrameLayout)findViewById(0x7f0c00c1)).removeAllViews();
        if (v == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        m(flag);
        a(Boolean.valueOf(true));
        a(false, true);
        return Boolean.valueOf(true);
    }

    public void M()
    {
        runOnUiThread(new Runnable() {

            final EditViewActivity a;

            public void run()
            {
                for (Iterator iterator = ((ArrayList)EditViewActivity.A(a).clone()).iterator(); iterator.hasNext(); ((com.cyberlink.youcammakeup.activity.c)iterator.next()).a()) { }
            }

            
            {
                a = EditViewActivity.this;
                super();
            }
        });
    }

    public void N()
    {
        if (A() && ar != null)
        {
            ar.l();
        }
    }

    public void O()
    {
        if (s != null)
        {
            Boolean boolean1 = MotionControlHelper.e().f();
            if (boolean1 != null)
            {
                s.setSelected(boolean1.booleanValue());
                if (t != null && (t instanceof TextView))
                {
                    int i1;
                    if (boolean1.booleanValue())
                    {
                        i1 = 0x7f0706c0;
                    } else
                    {
                        i1 = 0x7f0706bf;
                    }
                    ((TextView)t).setText(i1);
                    return;
                }
            }
        }
    }

    public void P()
    {
        StatusManager.j().b(this);
        Globals.d().i().c(this);
        Globals.d().i().e(this);
        Globals.d().i().a(new com.cyberlink.youcammakeup.widgetpool.dialogs.w() {

            final EditViewActivity a;

            public void a(boolean flag)
            {
                a.j();
            }

            public void b(boolean flag)
            {
            }

            
            {
                a = EditViewActivity.this;
                super();
            }
        });
    }

    public void Q()
    {
        StatusManager.j().b(this);
        Globals.d().i().c(this);
        Globals.d().i().f(this);
        Globals.d().i().a(new com.cyberlink.youcammakeup.widgetpool.dialogs.w() {

            final EditViewActivity a;

            public void a(boolean flag)
            {
                a.j();
            }

            public void b(boolean flag)
            {
            }

            
            {
                a = EditViewActivity.this;
                super();
            }
        });
    }

    public void R()
    {
        if (I != null)
        {
            I.d();
        }
    }

    public void S()
    {
        a(4, 4, 4, 4, 4, 4, 4, 4);
        Q.a(0);
    }

    public int T()
    {
        if (s == null)
        {
            return 8;
        } else
        {
            return s.getVisibility();
        }
    }

    public void U()
    {
        ag.a(ah);
    }

    public void V()
    {
        ag.d();
    }

    public void W()
    {
        if (ai != null && ai.size() > 0)
        {
            ai.clear();
        }
        if (aj != null && aj.size() > 0)
        {
            aj.clear();
        }
    }

    public void X()
    {
        if (StatusManager.j().s() != BeautyMode.s) goto _L2; else goto _L1
_L1:
        if (K != null)
        {
            aj.put(K, Integer.valueOf(K.getVisibility()));
            K.setVisibility(0);
        }
        if (J != null && (J instanceof BeautyToolPanel))
        {
            BeautyToolPanel beautytoolpanel = (BeautyToolPanel)J;
            if (beautytoolpanel.v() != null)
            {
                aj.put(beautytoolpanel.v(), Integer.valueOf(beautytoolpanel.v().getVisibility()));
                beautytoolpanel.v().setVisibility(0);
            }
            if (beautytoolpanel.y() != null)
            {
                aj.put(beautytoolpanel.y(), Integer.valueOf(beautytoolpanel.y().getVisibility()));
                beautytoolpanel.y().setVisibility(0);
            }
            if (beautytoolpanel.I() != null)
            {
                aj.put(beautytoolpanel.I(), Integer.valueOf(beautytoolpanel.I().getVisibility()));
                beautytoolpanel.I().setVisibility(0);
            }
        }
_L4:
        return;
_L2:
        if (StatusManager.j().s() != BeautyMode.x)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (J == null || !(J instanceof BeautyToolPanel)) goto _L4; else goto _L3
_L3:
        BeautyToolPanel beautytoolpanel1;
        ViewGroup viewgroup;
        beautytoolpanel1 = (BeautyToolPanel)J;
        viewgroup = beautytoolpanel1.I();
        if (viewgroup == null) goto _L4; else goto _L5
_L5:
        aj.put(viewgroup, Integer.valueOf(beautytoolpanel1.m()));
        beautytoolpanel1.a(0);
        return;
        if (StatusManager.j().s() != BeautyMode.y || J == null || !(J instanceof BeautyToolPanel) || ((BeautyToolPanel)J).Q() || ad() == null) goto _L4; else goto _L6
_L6:
        aj.put(ad(), Integer.valueOf(ad().getVisibility()));
        ad().setVisibility(0);
        return;
    }

    public void Y()
    {
        if (aj != null && aj.size() > 0)
        {
            Iterator iterator = aj.entrySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                if (entry.getKey() != null)
                {
                    ((View)entry.getKey()).setVisibility(((Integer)entry.getValue()).intValue());
                }
            } while (true);
            aj.clear();
        }
    }

    public ViewGroup Z()
    {
        return K;
    }

    public void a(int i1)
    {
        if (w != null)
        {
            w.setOnSeekBarChangeListener(null);
            w.setProgress(i1);
            if (x != null)
            {
                x.setText(Integer.toString(i1));
            }
            w.setOnSeekBarChangeListener(aF);
        }
    }

    public void a(int i1, int j1, int k1, int l1, int i2, int j2, int k2, 
            int l2)
    {
        if (i != null && i1 != -1)
        {
            i.setVisibility(i1);
            E = i1;
        }
        if (k != null && j1 != -1)
        {
            k.setVisibility(j1);
            F = j1;
        }
        if (l != null && k1 != -1)
        {
            View view = l;
            if (IntroDialogUtils.b())
            {
                i1 = 4;
            } else
            {
                i1 = k1;
            }
            view.setVisibility(i1);
            if (IntroDialogUtils.b())
            {
                i1 = 4;
            } else
            {
                i1 = k1;
            }
            A = i1;
            aD = k1;
            if (IntroDialogUtils.b())
            {
                IntroDialogUtils.a(aE);
            }
        }
        if (m != null && l2 != -1)
        {
            m.setVisibility(l2);
            H = l2;
        }
        if (n != null && l1 != -1)
        {
            n.setVisibility(l1);
            B = l1;
        }
        if (o != null && i2 != -1)
        {
            o.setVisibility(i2);
            C = i2;
        }
        if (o.getVisibility() != 0 && n.getVisibility() != 0)
        {
            findViewById(0x7f0c05bf).setVisibility(0);
        } else
        {
            findViewById(0x7f0c05bf).setVisibility(4);
        }
        if (p != null && j2 != -1)
        {
            p.setVisibility(j2);
            D = j2;
        }
        if (q != null && k2 != -1)
        {
            q.setVisibility(k2);
            G = k2;
        }
    }

    public void a(int i1, boolean flag, boolean flag1)
    {
        if (O != null && flag)
        {
            O.setVisibility(i1);
        }
        if (N != null && flag1)
        {
            N.setVisibility(i1);
        }
    }

    public void a(Fragment fragment)
    {
    }

    public void a(android.view.View.OnClickListener onclicklistener, android.view.View.OnClickListener onclicklistener1)
    {
label0:
        {
            if (n != null)
            {
                if (onclicklistener != null)
                {
                    n.setOnClickListener(onclicklistener);
                } else
                {
                    n.setOnClickListener(aJ);
                }
            }
            if (o != null)
            {
                if (onclicklistener1 == null)
                {
                    break label0;
                }
                o.setOnClickListener(onclicklistener1);
            }
            return;
        }
        o.setOnClickListener(aK);
    }

    public void a(PageID pageid)
    {
        c((new StringBuilder()).append("setCurrentPage: ").append(pageid).toString());
        d = pageid;
        if (pageid != null)
        {
            if ((pageid = b(pageid)) != null)
            {
                FragmentTransaction fragmenttransaction = getFragmentManager().beginTransaction();
                fragmenttransaction.replace(0x7f0c00bf, pageid);
                fragmenttransaction.commitAllowingStateLoss();
                e = pageid;
                if (StatusManager.j().P() && (e instanceof com.cyberlink.youcammakeup.widgetpool.c.a))
                {
                    ((com.cyberlink.youcammakeup.widgetpool.c.a)e).a(y.a);
                    return;
                }
            }
        }
    }

    public void a(com.cyberlink.youcammakeup.activity.c c1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!Y.contains(c1))
        {
            Y.add(c1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        c1;
        this;
        JVM INSTR monitorexit ;
        throw c1;
    }

    public void a(com.cyberlink.youcammakeup.activity.e e1)
    {
        aa = e1;
    }

    public void a(com.cyberlink.youcammakeup.activity.f f1)
    {
        long l1 = StatusManager.j().l();
        d d1 = StatusManager.j().c(l1);
        d d2 = StatusManager.j().g(l1);
        if (d1.h() || d2.h())
        {
            b(f1);
            return;
        } else
        {
            J();
            return;
        }
    }

    public void a(com.cyberlink.youcammakeup.activity.g g1)
    {
        Z = g1;
    }

    public void a(com.cyberlink.youcammakeup.activity.i i1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!X.contains(i1))
        {
            X.add(i1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        i1;
        this;
        JVM INSTR monitorexit ;
        throw i1;
    }

    public void a(com.cyberlink.youcammakeup.activity.k k1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!W.contains(k1))
        {
            W.add(k1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        k1;
        this;
        JVM INSTR monitorexit ;
        throw k1;
    }

    public void a(BeautifierTaskInfo beautifiertaskinfo)
    {
        if (beautifiertaskinfo == null || beautifiertaskinfo.e() == null || !beautifiertaskinfo.e().equalsIgnoreCase("LooksImageAdapter") && !beautifiertaskinfo.e().equalsIgnoreCase("SaveMyLookDialog")) goto _L2; else goto _L1
_L1:
        return;
_L2:
        BeautyMode beautymode;
        if (StatusManager.j().r() == MakeupMode.a)
        {
            z(false);
            at();
            if (beautifiertaskinfo != null && beautifiertaskinfo.c())
            {
                a(A(), ((a) (null)));
            }
            StatusManager.j().a(Boolean.valueOf(true));
            M();
            MotionControlHelper.e().s(false);
            i();
            Globals.d().i().h(this);
            return;
        }
        beautymode = StatusManager.j().s();
        Object obj;
        if (beautymode == BeautyMode.r)
        {
            long l1 = StatusManager.j().l();
            if (A())
            {
                obj = StatusManager.j().l(l1);
            } else
            {
                obj = StatusManager.j().i(l1);
            }
            if (obj != null && MotionControlHelper.e().a(((a) (obj)).e))
            {
                int i1 = (int)((float)BeautifierManager.a().e() / 0.5F);
                MotionControlHelper.e().a(i1);
                BeautifierEditCenter.a().a(false);
                MotionControlHelper.e().b(((a) (obj)).e, false);
            }
            obj = StatusManager.j().e();
            if (obj != null && ((String) (obj)).equals("Eyebrow_general"))
            {
                if (J != null && J.d() != null)
                {
                    MotionControlHelper.e().a("Eyebrow_general_sku", MotionControlHelper.e().a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a), MotionControlHelper.e().w());
                } else
                {
                    MotionControlHelper.e().a("Eyebrow_general", MotionControlHelper.e().a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a), MotionControlHelper.e().w());
                }
            } else
            if (J != null && J.d() != null)
            {
                MotionControlHelper.e().a("Eyebrow_others_sku", MotionControlHelper.e().a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a), MotionControlHelper.e().w());
            } else
            {
                MotionControlHelper.e().a("Eyebrow_others", MotionControlHelper.e().a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a), MotionControlHelper.e().w());
            }
        }
        if (beautifiertaskinfo.a())
        {
            obj = StatusManager.j().e();
            if ((beautymode != BeautyMode.x || !beautifiertaskinfo.b() || obj == null || ((String) (obj)).equals("default_original_wig")) && (beautymode != BeautyMode.z || !beautifiertaskinfo.b() || obj == null || ((String) (obj)).equals("default_original_eye_wear")) && (beautymode != BeautyMode.A || !beautifiertaskinfo.b() || obj == null || ((String) (obj)).equals("default_original_hair_band")) && (beautymode != BeautyMode.B || !beautifiertaskinfo.b() || obj == null || ((String) (obj)).equals("default_original_necklace")) && (beautymode != BeautyMode.C || !beautifiertaskinfo.b() || obj == null || ((String) (obj)).equals("default_original_earrings")))
            {
                z(false);
                if (U && V)
                {
                    at();
                }
            }
            M();
        }
        if (beautifiertaskinfo.c())
        {
            boolean flag = A();
            if (ab)
            {
                e(flag, true);
            } else
            {
                d(flag, true);
                if (beautymode != BeautyMode.x && beautymode != BeautyMode.z && beautymode != BeautyMode.A && beautymode != BeautyMode.B && beautymode != BeautyMode.C)
                {
                    ab = true;
                }
            }
            j(false);
            StatusManager.j().a(Boolean.valueOf(true));
            Globals.d().i().b(false);
            Globals.d().i().h(this);
        }
        if (J != null && (J instanceof BeautyToolPanel) && ((BeautyToolPanel)J).R())
        {
            Globals.d().i().b(false);
            Globals.d().i().h(this);
            return;
        }
        break MISSING_BLOCK_LABEL_734;
        if (ar != null && !ar.h() && beautymode != BeautyMode.x && !BeautyMode.d(beautymode) && beautymode != BeautyMode.y)
        {
            Globals.d().i().b(false);
            Globals.d().i().h(this);
            return;
        }
        if (beautymode != BeautyMode.x && (!BeautyMode.d(beautymode) || J == null))
        {
            continue; /* Loop/switch isn't completed */
        }
        BeautyToolPanel beautytoolpanel = (BeautyToolPanel)J;
        if (MotionControlHelper.e().an())
        {
            beautytoolpanel.j();
            return;
        }
        if (!beautifiertaskinfo.b() || beautifiertaskinfo == null || beautifiertaskinfo.e() == null || !beautifiertaskinfo.e().equals(r.r) && !beautifiertaskinfo.e().equals(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.a.a))
        {
            continue; /* Loop/switch isn't completed */
        }
        boolean flag1;
        if (beautymode == BeautyMode.x)
        {
            flag1 = beautytoolpanel.A();
        } else
        {
            flag1 = beautytoolpanel.B();
        }
        j(false);
        StatusManager.j().a(Boolean.valueOf(true));
        if (flag1) goto _L1; else goto _L3
_L3:
        Globals.d().i().b(false);
        Globals.d().i().h(this);
        return;
        if (beautifiertaskinfo.c() || !U || !T) goto _L1; else goto _L4
_L4:
        j(false);
        StatusManager.j().a(Boolean.valueOf(true));
        Globals.d().i().h(this);
        return;
        if (beautymode != BeautyMode.y || !MotionControlHelper.e().ao() || J == null || !(J instanceof BeautyToolPanel)) goto _L1; else goto _L5
_L5:
        ((BeautyToolPanel)J).j();
        return;
    }

    public void a(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName buffername)
    {
        View view = findViewById(0x7f0c0720);
        if (view != null && (view instanceof PanZoomViewer))
        {
            com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.f f1 = new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.f();
            if (buffername == com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c)
            {
                f1.a = true;
            } else
            {
                f1.a = false;
            }
            ((PanZoomViewer)view).c(buffername, f1);
        }
    }

    public void a(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName buffername, Long long1)
    {
        long1 = StatusManager.j().s();
        if (buffername != com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c) goto _L2; else goto _L1
_L1:
        T = true;
        if (U && V) goto _L4; else goto _L3
_L3:
        if (long1 != BeautyMode.n && long1 != BeautyMode.v && long1 != BeautyMode.r && long1 != BeautyMode.l && long1 != BeautyMode.x && long1 != BeautyMode.a && long1 != BeautyMode.b && long1 != BeautyMode.m) goto _L6; else goto _L5
_L5:
        buffername = (BeautyToolPanel)J;
        if (buffername.w() != null && buffername.w().getProgress() != R)
        {
            Globals.d().j().b(Boolean.valueOf(false));
            T = false;
        }
        if (buffername.x() != null && buffername.x().getProgress() != S)
        {
            Globals.d().j().a(Boolean.valueOf(false));
            T = false;
        }
_L2:
        return;
_L6:
        if (long1 != BeautyMode.s)
        {
            continue; /* Loop/switch isn't completed */
        }
        buffername = (BeautyToolPanel)J;
        if (buffername.x() != null && buffername.x().getProgress() != S)
        {
            Globals.d().j().a(Boolean.valueOf(false));
            T = false;
        }
        if (buffername.w() != null && buffername.w().getProgress() != R)
        {
            Globals.d().j().b(Boolean.valueOf(false));
            T = false;
            return;
        }
        continue; /* Loop/switch isn't completed */
        if (w == null || w.getProgress() == R) goto _L2; else goto _L7
_L7:
        Globals.d().j().b(Boolean.valueOf(false));
        T = false;
        return;
_L4:
        if (long1 == BeautyMode.n || long1 == BeautyMode.v || long1 == BeautyMode.r || long1 == BeautyMode.l || long1 == BeautyMode.x || long1 == BeautyMode.a || long1 == BeautyMode.b || long1 == BeautyMode.m)
        {
            buffername = (BeautyToolPanel)J;
            if (J != null && buffername.w() != null)
            {
                R = buffername.w().getProgress();
            }
            if (J != null && buffername.x() != null)
            {
                S = buffername.x().getProgress();
            }
        } else
        if (w != null)
        {
            R = w.getProgress();
        }
        if (long1 == BeautyMode.s)
        {
            buffername = (BeautyToolPanel)J;
            int i1;
            if (buffername.x() != null)
            {
                i1 = buffername.x().getProgress();
            } else
            {
                i1 = S;
            }
            S = i1;
            return;
        }
        if (true) goto _L2; else goto _L8
_L8:
    }

    public void a(q q1)
    {
        ae = q1;
    }

    public void a(ImageStateChangedEvent imagestatechangedevent)
    {
        if (isFinishing())
        {
            StatusManager.j().b(this);
        } else
        if (imagestatechangedevent.d() == com.cyberlink.youcammakeup.kernelctrl.status.ImageStateChangedEvent.ActionDirection.d)
        {
            StatusManager.j().b(this);
            Globals.d().R();
            D();
            return;
        }
    }

    public void a(a a1)
    {
        am.b(a1);
    }

    public void a(MakeupMode makeupmode, BeautyMode beautymode, String s1)
    {
        MakeupMode makeupmode1 = StatusManager.j().r();
        if (makeupmode == MakeupMode.a && s1 != null)
        {
            if (makeupmode1 == MakeupMode.a)
            {
                am.b(s1);
                return;
            }
            am.a(s1);
        }
        if (makeupmode1 == MakeupMode.a)
        {
            am.o();
            u(false);
        }
        if (!al.i() && !am.i())
        {
            al.b(makeupmode, beautymode);
            return;
        }
        if (am.i())
        {
            am.a(new com.cyberlink.youcammakeup.widgetpool.toolbar.d(makeupmode, beautymode) {

                final MakeupMode a;
                final BeautyMode b;
                final EditViewActivity c;

                public void a()
                {
                    com.cyberlink.youcammakeup.activity.EditViewActivity.e(c).b(this);
                    com.cyberlink.youcammakeup.activity.EditViewActivity.f(c).b(a, b);
                }

            
            {
                c = EditViewActivity.this;
                a = makeupmode;
                b = beautymode;
                super();
            }
            });
            return;
        } else
        {
            al.a(new com.cyberlink.youcammakeup.widgetpool.toolbar.d(makeupmode, beautymode) {

                final MakeupMode a;
                final BeautyMode b;
                final EditViewActivity c;

                public void a()
                {
                    com.cyberlink.youcammakeup.activity.EditViewActivity.f(c).b(this);
                    com.cyberlink.youcammakeup.activity.EditViewActivity.f(c).b(a, b);
                }

            
            {
                c = EditViewActivity.this;
                a = makeupmode;
                b = beautymode;
                super();
            }
            });
            return;
        }
    }

    public void a(com.cyberlink.youcammakeup.utility.at at1, boolean flag)
    {
        if (I != null)
        {
            I.a(at1, flag);
        }
    }

    public void a(aw aw1, boolean flag)
    {
        if (I != null && (I instanceof com.cyberlink.youcammakeup.widgetpool.common.a.j))
        {
            ((com.cyberlink.youcammakeup.widgetpool.common.a.j)I).a(aw1, flag);
        }
    }

    public void a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.MotionName motionname, boolean flag)
    {
label0:
        {
            if (motionname == com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.MotionName.a)
            {
                O();
                if (flag)
                {
                    if (StatusManager.j().r() != MakeupMode.a)
                    {
                        break label0;
                    }
                    i i1 = StatusManager.j().d();
                    motionname = i1;
                    if (i1 == null)
                    {
                        motionname = new i();
                    }
                    if (MotionControlHelper.e().a(motionname, new BeautifierTaskInfo(true)))
                    {
                        Globals.d().i().b(this);
                    }
                }
            }
            return;
        }
        if (MotionControlHelper.e().f() != null)
        {
            motionname = new BeautifierTaskInfo(true);
            MotionControlHelper.e().a(motionname);
            MotionControlHelper.e().a(motionname, false);
        }
        Globals.d().i().b(this);
    }

    public void a(com.cyberlink.youcammakeup.widgetpool.common.a.d d1)
    {
        I = d1;
    }

    public void a(com.cyberlink.youcammakeup.widgetpool.panel.a a1)
    {
        J = a1;
    }

    public void a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.k k1)
    {
        if (k1 != null)
        {
            T = true;
            BeautifierManager.a().a(this);
            StatusManager.j().a(this);
        } else
        {
            if (P != null)
            {
                P.f();
            }
            T = false;
            BeautifierManager.a().b(this);
            StatusManager.j().b(this);
        }
        P = k1;
        if (I != null)
        {
            I.a(P);
        }
        U = true;
        V = true;
        R = 0;
        S = 0;
    }

    public void a(com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.DismissType dismisstype, String s1)
    {
        aw aw1;
label0:
        {
            aw1 = PanelDataCenter.a().i(s1);
            if (dismisstype != null)
            {
                G();
            }
            if (P != null && aw1 != null)
            {
                if (aw1.k() != null)
                {
                    dismisstype = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().c(aw1.k());
                } else
                {
                    dismisstype = null;
                }
                if (dismisstype != J.d() && (dismisstype == null || !dismisstype.equals(J.d())))
                {
                    break label0;
                }
                P.a(s1, new Float[0]);
            }
            return;
        }
        J.a(dismisstype, true);
        P.a(aw1.a());
    }

    public void a(Boolean boolean1)
    {
        while (aB || i == null || k == null || l == null || n == null || o == null || p == null) 
        {
            return;
        }
        if (boolean1.booleanValue())
        {
            i.setOnTouchListener(aG);
        } else
        if (!b)
        {
            i.setOnTouchListener(null);
        }
        if (!b)
        {
            i.setClickable(boolean1.booleanValue());
        }
        if (boolean1.booleanValue() && !b)
        {
            k.setClickable(true);
            l.setClickable(true);
            n.setClickable(true);
            o.setClickable(true);
            p.setClickable(true);
            m.setClickable(true);
            return;
        } else
        {
            a(k);
            a(l);
            a(n);
            a(o);
            a(p);
            a(m);
            return;
        }
    }

    public void a(Boolean boolean1, float f1, float f2, float f3)
    {
        if (boolean1.booleanValue() && w != null)
        {
            w.setOnSeekBarChangeListener(aF);
            w.setProgress((int)f1);
            Globals.d().j().a(w);
            v();
            return;
        }
        if (w != null)
        {
            w.setOnSeekBarChangeListener(null);
        }
        Globals.d().j().a(null);
    }

    public void a(Boolean boolean1, Boolean boolean2)
    {
        boolean flag2;
        for (flag2 = true; aq || M == null;)
        {
            return;
        }

        int i1;
        if (boolean1.booleanValue() || boolean2.booleanValue())
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        a(0, boolean1.booleanValue(), boolean2.booleanValue());
        if (i1 == M.getVisibility())
        {
            boolean flag;
            if (!boolean1.booleanValue())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (boolean2.booleanValue())
            {
                flag2 = false;
            }
            a(8, flag, flag2);
            return;
        }
        Globals.d().i().a(this, 10000L);
        if (i1 == 0)
        {
            boolean flag1;
            boolean flag3;
            if (!boolean1.booleanValue())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (!boolean2.booleanValue())
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
            a(8, flag1, flag3);
            boolean1 = new ch() {

                final EditViewActivity a;

                public void onAnimationEnd(Animator animator)
                {
                    com.cyberlink.youcammakeup.activity.EditViewActivity.c(a, false);
                    Globals.d().i().h(a);
                }

            
            {
                a = EditViewActivity.this;
                super();
            }
            };
            M.addOnLayoutChangeListener(new android.view.View.OnLayoutChangeListener(boolean1) {

                final ch a;
                final EditViewActivity b;

                public void onLayoutChange(View view, int j1, int k1, int l1, int i2, int j2, int k2, 
                        int l2, int i3)
                {
                    com.cyberlink.youcammakeup.activity.EditViewActivity.m(b).removeOnLayoutChangeListener(this);
                    com.cyberlink.youcammakeup.activity.EditViewActivity.m(b).setAlpha(0.5F);
                    com.cyberlink.youcammakeup.activity.EditViewActivity.m(b).setY(com.cyberlink.youcammakeup.activity.EditViewActivity.m(b).getHeight());
                    com.cyberlink.youcammakeup.activity.EditViewActivity.m(b).animate().alpha(1.0F).y(0.0F).setDuration(300L).setListener(a);
                }

            
            {
                b = EditViewActivity.this;
                a = ch;
                super();
            }
            });
            aq = true;
            M.setVisibility(0);
            return;
        } else
        {
            boolean1 = new ch(boolean1, boolean2) {

                final Boolean a;
                final Boolean b;
                final EditViewActivity c;

                public void onAnimationEnd(Animator animator)
                {
                    boolean flag5 = true;
                    com.cyberlink.youcammakeup.activity.EditViewActivity.c(c, false);
                    animator = c;
                    boolean flag4;
                    if (!a.booleanValue())
                    {
                        flag4 = true;
                    } else
                    {
                        flag4 = false;
                    }
                    if (b.booleanValue())
                    {
                        flag5 = false;
                    }
                    animator.a(8, flag4, flag5);
                    com.cyberlink.youcammakeup.activity.EditViewActivity.m(c).setVisibility(8);
                    Globals.d().i().h(c);
                }

            
            {
                c = EditViewActivity.this;
                a = boolean1;
                b = boolean2;
                super();
            }
            };
            aq = true;
            M.animate().alphaBy(1.0F).alpha(0.5F).y(M.getHeight()).setDuration(300L).setListener(boolean1);
            return;
        }
    }

    public void a(Boolean boolean1, Boolean boolean2, Boolean boolean3, Boolean boolean4, Boolean boolean5)
    {
        if (StatusManager.j().s() == BeautyMode.D) goto _L2; else goto _L1
_L1:
        if (i != null)
        {
            i.setEnabled(true);
        }
_L4:
        if (n != null && boolean2 != null)
        {
            n.setEnabled(boolean2.booleanValue());
        }
        if (o != null && boolean3 != null)
        {
            o.setEnabled(boolean3.booleanValue());
        }
        if (p != null && boolean4 != null)
        {
            p.setEnabled(boolean4.booleanValue());
        }
        if (q != null && boolean5 != null)
        {
            q.setEnabled(boolean5.booleanValue());
        }
        return;
_L2:
        if (i != null && boolean1 != null)
        {
            i.setEnabled(boolean1.booleanValue());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a(String s1)
    {
        if (P != null)
        {
            P.a(s1);
        }
    }

    public void a(boolean flag, a a1)
    {
        if ((ImageViewer)findViewById(0x7f0c0720) == null)
        {
            com.pf.common.utility.m.e("EditViewActivity", "Can't save global history. PanZoomViewer is null.");
        }
        long l1 = StatusManager.j().l();
        ImageBufferWrapper imagebufferwrapper = ViewEngine.a().a(l1, 1.0D, null);
        a a2 = a1;
        if (a1 == null)
        {
            a2 = l(flag);
        }
        a1 = new com.cyberlink.youcammakeup.d() {

            final EditViewActivity b;

            public void a()
            {
                b.k(true);
            }

            public void b()
            {
                b.k(true);
            }

            public void c()
            {
                b.k(true);
            }

            
            {
                b = EditViewActivity.this;
                super();
            }
        };
        if (flag)
        {
            StatusManager.j().c(a2, imagebufferwrapper, a1);
            return;
        } else
        {
            StatusManager.j().a(a2, imagebufferwrapper, a1);
            return;
        }
    }

    public void a(boolean flag, com.cyberlink.youcammakeup.utility.IntroDialogUtils.IntroDialogType introdialogtype)
    {
        introdialogtype = StatusManager.j().s();
        MakeupMode makeupmode = StatusManager.j().r();
        if (introdialogtype != BeautyMode.D || makeupmode == MakeupMode.a)
        {
            if (!flag)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            b(Boolean.valueOf(flag));
        }
    }

    public void a(boolean flag, boolean flag1)
    {
label0:
        {
            byte byte0;
            if (flag)
            {
                byte0 = 4;
            } else
            {
                byte0 = 0;
            }
            findViewById(0x7f0c00bf).setVisibility(byte0);
            if (aa != null && flag1)
            {
                if (!flag)
                {
                    break label0;
                }
                aa.a();
            }
            return;
        }
        aa.b();
    }

    public boolean aa()
    {
        return T;
    }

    public boolean ab()
    {
        return ah;
    }

    public int ac()
    {
        MakeupMode makeupmode = StatusManager.j().r();
        for (BeautyMode beautymode = StatusManager.j().s(); makeupmode == MakeupMode.a || BeautyMode.e(beautymode) || BeautyMode.f(beautymode) || BeautyMode.g(beautymode) || BeautyMode.h(beautymode) || !BeautyMode.d(beautymode);)
        {
            return 8;
        }

        return 8;
    }

    public View ad()
    {
        return u;
    }

    protected Fragment b(PageID pageid)
    {
        class _cls36
        {

            static final int a[];

            static 
            {
                a = new int[PageID.values().length];
                try
                {
                    a[com.cyberlink.youcammakeup.activity.PageID.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
            }
        }

        switch (com.cyberlink.youcammakeup.activity._cls36.a[pageid.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return new com.cyberlink.youcammakeup.widgetpool.c.a();
        }
    }

    public void b(int i1)
    {
        if (J instanceof BeautyToolPanel)
        {
            ((BeautyToolPanel)J).a(i1);
        } else
        if (J instanceof com.cyberlink.youcammakeup.widgetpool.panel.d.d)
        {
            ((com.cyberlink.youcammakeup.widgetpool.panel.d.d)J).a(i1);
            return;
        }
    }

    public void b(com.cyberlink.youcammakeup.activity.c c1)
    {
        this;
        JVM INSTR monitorenter ;
        if (Y.contains(c1))
        {
            Y.remove(c1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        c1;
        this;
        JVM INSTR monitorexit ;
        throw c1;
    }

    public void b(com.cyberlink.youcammakeup.activity.i i1)
    {
        this;
        JVM INSTR monitorenter ;
        if (X.contains(i1))
        {
            X.remove(i1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        i1;
        this;
        JVM INSTR monitorexit ;
        throw i1;
    }

    public void b(com.cyberlink.youcammakeup.activity.k k1)
    {
        this;
        JVM INSTR monitorenter ;
        if (W.contains(k1))
        {
            W.remove(k1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        k1;
        this;
        JVM INSTR monitorexit ;
        throw k1;
    }

    public void b(MakeupMode makeupmode)
    {
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
            YMKSavingPageEvent.a(com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.PageType.a);
            T = true;
            BeautifierManager.a().a(this);
        } else
        {
            YMKSavingPageEvent.a(com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.PageType.b);
            T = false;
        }
        an.a(flag);
        ai.clear();
    }

    public void b(Boolean boolean1)
    {
        MakeupMode makeupmode;
        int i1;
        int j1;
        j1 = 4;
        boolean1 = StatusManager.j().f(StatusManager.j().l());
        i1 = j1;
        if (boolean1 != null)
        {
            boolean1 = boolean1.d();
            i1 = j1;
            if (boolean1 != null)
            {
                i1 = j1;
                if (boolean1.size() > 1)
                {
                    i1 = 0;
                }
            }
        }
        boolean1 = StatusManager.j().s();
        makeupmode = StatusManager.j().r();
        j1 = 8;
        if (makeupmode != MakeupMode.a) goto _L2; else goto _L1
_L1:
        j1 = 0;
        i1 = 4;
_L4:
        int k1;
        k1 = ac();
        if (BeautyMode.a(boolean1) || BeautyMode.b(boolean1))
        {
            StatusManager.j().a(4, i1, k1, 4, 4, 4, -1, j1);
            return;
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (BeautyMode.e(boolean1))
        {
            if (boolean1 == BeautyMode.e)
            {
                i1 = 8;
            } else
            {
                i1 = 0;
            }
            k1 = 4;
            j1 = i1;
            i1 = k1;
        } else
        if (BeautyMode.f(boolean1))
        {
            j1 = 0;
            i1 = 4;
        } else
        if (BeautyMode.g(boolean1))
        {
            j1 = 0;
            i1 = 4;
        } else
        if (BeautyMode.h(boolean1))
        {
            j1 = 8;
            i1 = 4;
        } else
        if (BeautyMode.d(boolean1))
        {
            j1 = 8;
            i1 = 4;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (boolean1 == BeautyMode.x)
        {
            StatusManager.j().a(0, i1, k1, 0, 0, 0, -1, j1);
            return;
        }
        if (boolean1 == BeautyMode.z || boolean1 == BeautyMode.A || boolean1 == BeautyMode.B || boolean1 == BeautyMode.C || boolean1 == BeautyMode.y)
        {
            StatusManager.j().a(0, i1, k1, 4, 4, 4, -1, j1);
            return;
        } else
        {
            StatusManager.j().a(0, i1, k1, 0, 0, 4, -1, j1);
            return;
        }
    }

    public void b(String s1)
    {
        if (aA != null)
        {
            aA.setText(s1);
        }
    }

    public void b(boolean flag)
    {
        ImageViewer imageviewer = (ImageViewer)findViewById(0x7f0c0720);
        if (imageviewer != null)
        {
            imageviewer.setEnabled(flag);
        }
    }

    public void b(boolean flag, boolean flag1)
    {
        if (!StatusManager.j().E().booleanValue())
        {
            return;
        }
        StatusManager.j().a(Boolean.valueOf(false));
        if (flag)
        {
            com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAllFeaturesEvent(com.cyberlink.youcammakeup.flurry.UsageOfAllFeaturesEvent.FeatureName.y));
        }
        android.content.DialogInterface.OnDismissListener ondismisslistener = new android.content.DialogInterface.OnDismissListener() {

            final EditViewActivity a;

            public void onDismiss(DialogInterface dialoginterface)
            {
                StatusManager.j().a(Boolean.valueOf(true));
            }

            
            {
                a = EditViewActivity.this;
                super();
            }
        };
        Bundle bundle = new Bundle();
        bundle.putString("BUNDLE_KEY_LOOK_GUID", am.k());
        bundle.putBoolean("BUNDLE_KEY_ENABLE_SAVE_BUTTON", flag1);
        com.cyberlink.youcammakeup.widgetpool.dialogs.ah ah1 = new com.cyberlink.youcammakeup.widgetpool.dialogs.ah();
        ah1.a(ondismisslistener);
        ah1.setArguments(bundle);
        com.cyberlink.youcammakeup.utility.o.a(this, ah1, "SaveMyLookDialog");
    }

    public void c(int i1)
    {
        StatusManager.j().r();
        View view = findViewById(0x7f0c00bd);
        view.post(new Runnable(view, i1) {

            final View a;
            final int b;
            final EditViewActivity c;

            public void run()
            {
                int j1 = a.getHeight();
                int k1 = b;
                if (c.d == com.cyberlink.youcammakeup.activity.PageID.a)
                {
                    ((com.cyberlink.youcammakeup.widgetpool.c.a)c.e).a(k1 - j1);
                }
            }

            
            {
                c = EditViewActivity.this;
                a = view;
                b = i1;
                super();
            }
        });
    }

    public void c(boolean flag)
    {
        am.c(flag);
    }

    public void c(boolean flag, boolean flag1)
    {
        if (ar != null)
        {
            ar.b(flag);
            ar.c(flag1);
        }
    }

    public void d(int i1)
    {
        View view = findViewById(0x7f0c00be);
        if (view != null && view.getVisibility() != i1)
        {
            view.setVisibility(i1);
        }
    }

    public void d(boolean flag)
    {
        if (am != null)
        {
            am.b(flag);
        }
    }

    public void d(boolean flag, boolean flag1)
    {
        Object obj;
        StatusManager statusmanager;
        long l1;
        statusmanager = StatusManager.j();
        l1 = statusmanager.l();
        if (flag)
        {
            obj = statusmanager.j(l1);
        } else
        {
            obj = statusmanager.g(l1);
        }
        if (obj != null) goto _L2; else goto _L1
_L1:
        com.pf.common.utility.m.e("EditViewActivity", "Can't resetLocalSession: sessionManager is null.");
_L16:
        return;
_L2:
        Object obj2;
        Object obj3;
        ImageBufferWrapper imagebufferwrapper;
        ImageBufferWrapper imagebufferwrapper1;
        obj = ((d) (obj)).g();
        if (obj == null)
        {
            com.pf.common.utility.m.e("EditViewActivity", "Can't resetLocalSession: compareState is null.");
            return;
        }
        obj = ((SessionState) (obj)).b();
        if (obj == null)
        {
            com.pf.common.utility.m.e("EditViewActivity", "Can't resetLocalSession: compareBufferWrapper is null.");
            return;
        }
        imagebufferwrapper1 = new ImageBufferWrapper();
        imagebufferwrapper1.a(((ImageBufferWrapper) (obj)));
        ((ImageBufferWrapper) (obj)).m();
        boolean flag2;
        if (flag)
        {
            statusmanager.L();
        } else
        {
            statusmanager.K();
        }
        if (flag)
        {
            flag2 = statusmanager.k(l1);
        } else
        {
            flag2 = statusmanager.h(l1);
        }
        if (flag2) goto _L4; else goto _L3
_L3:
        v v1;
        List list;
        imagebufferwrapper = ViewEngine.a().a(l1, 1.0D, null);
        if (imagebufferwrapper == null)
        {
            com.pf.common.utility.m.e("EditViewActivity", "Can't resetLocalSession. newSrcBuffer is null.");
        }
        obj3 = statusmanager.f(l1);
        obj2 = (ImageViewer)findViewById(0x7f0c0720);
        if (obj2 == null)
        {
            com.pf.common.utility.m.e("EditViewActivity", "Can't resetLocalSession. PanZoomViewer is null.");
            return;
        }
        v1 = MotionControlHelper.e().M();
        list = com.cyberlink.youcammakeup.kernelctrl.j.a().g();
        long l2;
        long l3;
        l2 = imagebufferwrapper.b();
        l3 = imagebufferwrapper.c();
        if (obj3 != null) goto _L6; else goto _L5
_L5:
        obj = ((ImageViewer) (obj2)).m.d;
_L17:
        List list1 = com.cyberlink.youcammakeup.kernelctrl.j.a(((ImageViewer) (obj2)).m.i);
        if (obj3 != null) goto _L8; else goto _L7
_L7:
        com.cyberlink.youcammakeup.jniproxy.z z1 = null;
          goto _L9
_L18:
        if (obj3 != null) goto _L11; else goto _L10
_L10:
        int i1 = ((ImageViewer) (obj2)).m.j;
          goto _L12
_L20:
        com.cyberlink.youcammakeup.jniproxy.z z2;
        obj = new a(l1, l2, l3, ((UIImageOrientation) (obj)), list1, list, z1, z2, i1, ((String) (obj2)), v1, ((String) (obj3)));
        if (!flag) goto _L14; else goto _L13
_L13:
        StatusManager.j().b(((a) (obj)), imagebufferwrapper, imagebufferwrapper1);
_L21:
        if (imagebufferwrapper != null)
        {
            imagebufferwrapper.m();
        }
_L4:
        if (!flag1) goto _L16; else goto _L15
_L15:
        statusmanager.y();
        return;
_L6:
        obj = ((a) (obj3)).d;
          goto _L17
_L8:
        z1 = ((a) (obj3)).a();
          goto _L9
_L23:
        z2 = ((a) (obj3)).b();
          goto _L18
_L11:
        i1 = ((a) (obj3)).e;
          goto _L12
_L25:
        obj2 = ((a) (obj3)).c();
          goto _L19
_L27:
        obj3 = ((a) (obj3)).g();
          goto _L20
_L14:
        StatusManager.j().a(((a) (obj)), imagebufferwrapper, imagebufferwrapper1);
          goto _L21
        Object obj1;
        obj1;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_483;
        }
        com.pf.common.utility.m.e("EditViewActivity", (new StringBuilder()).append("exception: ").append(((Exception) (obj1)).getLocalizedMessage()).toString());
        if (imagebufferwrapper != null)
        {
            imagebufferwrapper.m();
        }
          goto _L4
        obj1;
        if (imagebufferwrapper != null)
        {
            imagebufferwrapper.m();
        }
        throw obj1;
_L9:
        if (obj3 != null) goto _L23; else goto _L22
_L22:
        z2 = null;
          goto _L18
_L12:
        if (obj3 != null) goto _L25; else goto _L24
_L24:
        obj2 = null;
_L19:
        if (obj3 != null) goto _L27; else goto _L26
_L26:
        obj3 = "";
          goto _L20
    }

    public void e(boolean flag)
    {
        Globals.d().i().b(false);
        Globals.d().i().h(this);
        Globals.d().i().a(this, false, flag, true, new com.cyberlink.youcammakeup.widgetpool.dialogs.w(flag) {

            final boolean a;
            final EditViewActivity b;

            public void a(boolean flag1)
            {
                YMKSavingPageEvent.a(com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.FacedetectionClick.a);
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKSavingPageEvent(YMKSavingPageEvent.b, System.currentTimeMillis(), com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.Operation.f, false, false));
                (new Handler()).post(new Runnable(this) {

                    final _cls11 a;

                    public void run()
                    {
                        com.cyberlink.youcammakeup.activity.EditViewActivity.a(a.b, new com.cyberlink.youcammakeup.widgetpool.dialogs.q(a.b, true));
                        com.cyberlink.youcammakeup.activity.EditViewActivity.t(a.b).setOnCancelListener(new android.content.DialogInterface.OnCancelListener(this) {

                            final _cls1 a;

                            public void onCancel(DialogInterface dialoginterface)
                            {
                                a.a.b.I();
                            }

            
            {
                a = _pcls1;
                super();
            }
                        });
                        Object obj = new com.cyberlink.youcammakeup.widgetpool.dialogs.r(this) {

                            final _cls1 a;

                            public void a()
                            {
                                com.cyberlink.youcammakeup.activity.EditViewActivity.t(a.a.b).dismiss();
                                a.a.b.I();
                            }

                            public void a(PointF apointf[])
                            {
                                com.cyberlink.youcammakeup.activity.EditViewActivity.t(a.a.b).dismiss();
                                long l1 = StatusManager.j().l();
                                Object obj = ViewEngine.a().a(l1, 1.0D, null);
                                if (obj == null || ((ImageBufferWrapper) (obj)).j() == null)
                                {
                                    return;
                                }
                                Object obj4 = apointf[0];
                                Object obj1 = apointf[1];
                                Object obj2 = apointf[2];
                                apointf = new com.cyberlink.youcammakeup.jniproxy.y();
                                Object obj3 = new com.cyberlink.youcammakeup.jniproxy.ah();
                                ((com.cyberlink.youcammakeup.jniproxy.ah) (obj3)).a(((PointF) (obj4)).x);
                                ((com.cyberlink.youcammakeup.jniproxy.ah) (obj3)).b(((PointF) (obj4)).y);
                                obj4 = new com.cyberlink.youcammakeup.jniproxy.ah();
                                ((com.cyberlink.youcammakeup.jniproxy.ah) (obj4)).a(((PointF) (obj1)).x);
                                ((com.cyberlink.youcammakeup.jniproxy.ah) (obj4)).b(((PointF) (obj1)).y);
                                obj1 = new com.cyberlink.youcammakeup.jniproxy.ah();
                                ((com.cyberlink.youcammakeup.jniproxy.ah) (obj1)).a(((PointF) (obj2)).x);
                                ((com.cyberlink.youcammakeup.jniproxy.ah) (obj1)).b(((PointF) (obj2)).y);
                                int i1 = com.cyberlink.youcammakeup.activity.EditViewActivity.u(a.a.b).a(((ImageBufferWrapper) (obj)).j(), ((com.cyberlink.youcammakeup.jniproxy.ah) (obj3)), ((com.cyberlink.youcammakeup.jniproxy.ah) (obj4)), ((com.cyberlink.youcammakeup.jniproxy.ah) (obj1)), apointf);
                                com.cyberlink.youcammakeup.activity.EditViewActivity.a(a.a.b, (new StringBuilder()).append("[ManualAdjustDialog] uiVenus.ManualGetFaceAlignmentData iRet=").append(i1).toString());
                                if (obj != null)
                                {
                                    ((ImageBufferWrapper) (obj)).m();
                                }
                                obj1 = new ar(0);
                                obj1.c = apointf;
                                obj = new com.cyberlink.youcammakeup.jniproxy.aj();
                                i1 = com.cyberlink.youcammakeup.activity.EditViewActivity.u(a.a.b).a(1, ((com.cyberlink.youcammakeup.jniproxy.aj) (obj)));
                                com.cyberlink.youcammakeup.activity.EditViewActivity.a(a.a.b, (new StringBuilder()).append("[ManualAdjustDialog] uiVenus.GetFaceInfos iRet=").append(i1).toString());
                                if (((com.cyberlink.youcammakeup.jniproxy.aj) (obj)).b() == 0L)
                                {
                                    com.cyberlink.youcammakeup.activity.EditViewActivity.a(a.a.b, "[ManualAdjustDialog] faceRectList.size() == 0");
                                    a.a.b.I();
                                    return;
                                }
                                obj2 = new ai(((com.cyberlink.youcammakeup.jniproxy.aj) (obj)).a(0));
                                obj = new ax();
                                i1 = com.cyberlink.youcammakeup.activity.EditViewActivity.u(a.a.b).a(((ai) (obj2)), ((ax) (obj)));
                                com.cyberlink.youcammakeup.activity.EditViewActivity.a(a.a.b, (new StringBuilder()).append("[ManualAdjustDialog] face : uiVenus.GetIrisRadius iRet=").append(i1).append(" iris radius = ").append(((ax) (obj)).b()).toString());
                                obj3 = new bn();
                                i1 = com.cyberlink.youcammakeup.activity.EditViewActivity.u(a.a.b).a(((ai) (obj2)), ((bn) (obj3)));
                                com.cyberlink.youcammakeup.activity.EditViewActivity.a(a.a.b, (new StringBuilder()).append("[ManualAdjustDialog] face : uiVenus.GetAutoWigLuminanceParameter iRet=").append(i1).append(" wig luminance = ").append(((bn) (obj3)).b()).toString());
                                boolean flag = com.cyberlink.youcammakeup.activity.EditViewActivity.u(a.a.b).a(((ai) (obj2)));
                                com.cyberlink.youcammakeup.activity.EditViewActivity.a(a.a.b, (new StringBuilder()).append("[ManualAdjustDialog] face : uiVenus.DetectOpenMouth boolean = ").append(flag).toString());
                                obj1.b = ((ai) (obj2));
                                obj1.c = apointf;
                                obj1.d = ((ax) (obj));
                                obj1.e = ((bn) (obj3));
                                obj1.f = flag;
                                obj = StatusManager.j().Q();
                                apointf = ((PointF []) (obj));
                                if (obj == null)
                                {
                                    apointf = new ArrayList();
                                }
                                apointf.add(obj1);
                                StatusManager.j().c(apointf);
                                com.cyberlink.youcammakeup.activity.EditViewActivity.e(a.a.b, true);
                                StatusManager.j().f(l1).e = -2;
                                if (((ai) (obj2)).c() == ((ai) (obj2)).e() || ((ai) (obj2)).b() == ((ai) (obj2)).d())
                                {
                                    com.cyberlink.youcammakeup.activity.EditViewActivity.e(a.a.b, false);
                                    a.a.b.I();
                                    return;
                                } else
                                {
                                    a.a.b.D();
                                    return;
                                }
                            }

            
            {
                a = _pcls1;
                super();
            }
                        };
                        com.cyberlink.youcammakeup.activity.EditViewActivity.t(a.b).a(((com.cyberlink.youcammakeup.widgetpool.dialogs.r) (obj)));
                        long l1 = StatusManager.j().l();
                        obj = ViewEngine.a().a(l1, 1.0D, null);
                        com.cyberlink.youcammakeup.activity.EditViewActivity.t(a.b).a(((ImageBufferWrapper) (obj)).i());
                        com.cyberlink.youcammakeup.activity.EditViewActivity.t(a.b).show();
                        if (obj != null)
                        {
                            ((ImageBufferWrapper) (obj)).m();
                        }
                    }

            
            {
                a = _pcls11;
                super();
            }
                });
            }

            public void b(boolean flag1)
            {
                if (a)
                {
                    YMKSavingPageEvent.a(com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.FacedetectionClick.c);
                } else
                {
                    YMKSavingPageEvent.a(com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.FacedetectionClick.b);
                }
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKSavingPageEvent(YMKSavingPageEvent.b, System.currentTimeMillis(), com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.Operation.f, false, false));
                (new Handler()).post(new Runnable(this) {

                    final _cls11 a;

                    public void run()
                    {
                        Globals.d().i().b(false);
                        Globals.d().i().h(a.b);
                        a.b.I();
                    }

            
            {
                a = _pcls11;
                super();
            }
                });
            }

            
            {
                b = EditViewActivity.this;
                a = flag;
                super();
            }
        });
    }

    public void e(boolean flag, boolean flag1)
    {
        ImageViewer imageviewer = (ImageViewer)findViewById(0x7f0c0720);
        if (imageviewer == null || imageviewer.m == null)
        {
            com.pf.common.utility.m.e("EditViewActivity", "Can't save local history. PanZoomViewer is null.");
            return;
        }
        long l1 = StatusManager.j().l();
        a a1;
        Object obj;
        com.cyberlink.youcammakeup.jniproxy.z z1;
        com.cyberlink.youcammakeup.jniproxy.z z2;
        com.cyberlink.youcammakeup.jniproxy.z z3;
        List list;
        ImageBufferWrapper imagebufferwrapper;
        v v1;
        String s1;
        if (flag)
        {
            a1 = StatusManager.j().l(l1);
        } else
        {
            a1 = StatusManager.j().i(l1);
        }
        obj = MotionControlHelper.e().M();
        list = com.cyberlink.youcammakeup.kernelctrl.j.a().g();
        if (a1 == null)
        {
            a1 = new a(l1, imageviewer.m.b, imageviewer.m.c, imageviewer.m.d, com.cyberlink.youcammakeup.kernelctrl.j.a(imageviewer.m.i), list, ((ar)list.get(imageviewer.m.j)).c.b(), ((ar)list.get(imageviewer.m.j)).c.c(), imageviewer.m.j, null, ((v) (obj)), "");
        }
        imagebufferwrapper = ViewEngine.a().a(l1, 1.0D, null);
        v1 = MotionControlHelper.e().M();
        z2 = a1.a();
        z3 = a1.b();
        s1 = StatusManager.j().e();
        z1 = z2;
        obj = z3;
        if (StatusManager.j().s() == BeautyMode.r)
        {
            z1 = z2;
            obj = z3;
            if (s1 != null)
            {
                z1 = z2;
                obj = z3;
                if (s1.equals("Eyebrow_general"))
                {
                    z1 = MotionControlHelper.e().c(s1);
                    obj = MotionControlHelper.e().d(s1);
                    MotionControlHelper.e().g();
                }
            }
        }
        if (imagebufferwrapper == null)
        {
            com.pf.common.utility.m.e("EditViewActivity", "Can't save local history. resultBuffer is null.");
            return;
        }
        a1 = new a(l1, imagebufferwrapper.b(), imagebufferwrapper.c(), a1.d, com.cyberlink.youcammakeup.kernelctrl.j.a(imageviewer.m.i), list, z1, ((com.cyberlink.youcammakeup.jniproxy.z) (obj)), a1.e, a1.c(), v1, a1.g());
        if (flag)
        {
            StatusManager.j().c(a1, imagebufferwrapper, new com.cyberlink.youcammakeup.d(flag1) {

                final boolean b;
                final EditViewActivity c;

                public void a()
                {
                    c.k(b);
                }

                public void b()
                {
                    c.k(b);
                }

                public void c()
                {
                    c.k(b);
                }

            
            {
                c = EditViewActivity.this;
                b = flag;
                super();
            }
            });
            return;
        } else
        {
            StatusManager.j().b(a1, imagebufferwrapper, new com.cyberlink.youcammakeup.d(flag1) {

                final boolean b;
                final EditViewActivity c;

                public void a()
                {
                    c.k(b);
                }

                public void b()
                {
                    c.k(b);
                }

                public void c()
                {
                    c.k(b);
                }

            
            {
                c = EditViewActivity.this;
                b = flag;
                super();
            }
            });
            return;
        }
    }

    public void f(boolean flag)
    {
        aB = flag;
    }

    public void finish()
    {
        an();
        ar();
        am();
        super.finish();
    }

    public void g(boolean flag)
    {
        boolean flag2 = true;
        boolean flag1;
        if (!flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        a(Boolean.valueOf(flag1));
        if (!flag)
        {
            flag = flag2;
        } else
        {
            flag = false;
        }
        c(Boolean.valueOf(flag));
    }

    public void h(boolean flag)
    {
        View view = findViewById(0x7f0c00d1);
        if (view != null)
        {
            byte byte0;
            if (flag)
            {
                byte0 = 4;
            } else
            {
                byte0 = 0;
            }
            view.setVisibility(byte0);
        }
    }

    public void i(boolean flag)
    {
        ab = flag;
    }

    public void j()
    {
        ImageViewer imageviewer = (ImageViewer)findViewById(0x7f0c0720);
        if (imageviewer != null)
        {
            StatusManager.j().b(imageviewer);
        }
        StatusManager.j().b(this);
        StatusManager.j().b(this);
        startActivity(new Intent(getApplicationContext(), com/cyberlink/youcammakeup/activity/LauncherActivity));
        finish();
    }

    public void j(boolean flag)
    {
        if (O != null && N != null)
        {
            ((FixedAspectRatioFrameLayout)O).setInterceptTouchEvent(flag);
            ((FixedAspectRatioFrameLayout)N).setInterceptTouchEvent(flag);
            if (P != null)
            {
                P.b(flag);
            }
            if (J != null)
            {
                if (J instanceof BeautyToolPanel)
                {
                    ((BeautyToolPanel)J).l(flag);
                } else
                if (J instanceof com.cyberlink.youcammakeup.widgetpool.panel.d.d)
                {
                    ((com.cyberlink.youcammakeup.widgetpool.panel.d.d)J).d(flag);
                }
            }
            if (K != null && (K instanceof FixedAspectRatioFrameLayout))
            {
                ((FixedAspectRatioFrameLayout)K).setInterceptTouchEvent(flag);
                return;
            }
        }
    }

    public void k()
    {
        if (this != null && !isFinishing() && Globals.d().v() != "editView")
        {
            ImageViewer imageviewer = (ImageViewer)findViewById(0x7f0c0720);
            if (imageviewer != null && !af())
            {
                Globals.d().i().a(this, 0L);
                Globals.d().i().b(true);
                ae = imageviewer.getCurImageInfo();
                StatusManager.j().b(imageviewer);
                a(com.cyberlink.youcammakeup.activity.PageID.a);
                StatusManager.j().a(this);
                return;
            }
        }
    }

    public void k(boolean flag)
    {
        if (flag)
        {
            StatusManager.j().y();
        }
    }

    public q l()
    {
        return ae;
    }

    public a l(boolean flag)
    {
        ImageViewer imageviewer = (ImageViewer)findViewById(0x7f0c0720);
        if (imageviewer == null)
        {
            com.pf.common.utility.m.e("EditViewActivity", "Can't make global state info. PanZoomViewer is null.");
            return null;
        }
        long l1 = StatusManager.j().l();
        a a1;
        List list;
        v v1;
        if (flag)
        {
            a1 = StatusManager.j().l(l1);
        } else
        {
            a1 = StatusManager.j().f(l1);
        }
        v1 = MotionControlHelper.e().M();
        list = com.cyberlink.youcammakeup.kernelctrl.j.a().g();
        if (a1 == null)
        {
            a1 = new a(l1, imageviewer.m.b, imageviewer.m.c, imageviewer.m.d, com.cyberlink.youcammakeup.kernelctrl.j.a(imageviewer.m.i), list, ((ar)list.get(imageviewer.m.j)).c.b(), ((ar)list.get(imageviewer.m.j)).c.c(), imageviewer.m.j, null, v1, "");
        }
        v1 = MotionControlHelper.e().M();
        v1.a(StatusManager.j().d());
        return new a(l1, a1.b, a1.c, a1.d, com.cyberlink.youcammakeup.kernelctrl.j.a(imageviewer.m.i), list, a1.a(), a1.b(), a1.e, a1.c(), v1, a1.g());
    }

    public Fragment m()
    {
        return e;
    }

    public void m(boolean flag)
    {
        int i1;
        if (flag)
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        if (r != null)
        {
            r.setVisibility(i1);
        }
        if (s != null)
        {
            s.setVisibility(i1);
        }
        if (t != null)
        {
            t.setVisibility(i1);
        }
    }

    public void n()
    {
        am.q();
    }

    public void n(boolean flag)
    {
        StatusManager.j().b(this);
        Globals.d().i().b(false);
        Globals.d().i().h(this);
    }

    public void o()
    {
        if (p())
        {
            am.a(am.k());
            al.b(MakeupMode.a, BeautyMode.D);
            return;
        } else
        {
            onResume();
            return;
        }
    }

    public void o(boolean flag)
    {
        ah = flag;
        if (flag)
        {
            ag.f();
            x();
            if (StatusManager.j().r() == MakeupMode.a)
            {
                u(am.r());
            }
        } else
        {
            ag.e();
            y();
            if (StatusManager.j().r() == MakeupMode.a)
            {
                u(false);
                return;
            }
        }
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
    }

    public void onBackPressed()
    {
        if (J != null && (J instanceof BeautyToolPanel) && !((BeautyToolPanel)J).O())
        {
            ((BeautyToolPanel)J).P();
        } else
        if (getFragmentManager().getBackStackEntryCount() <= 0 && !h.c())
        {
            if (ar.isVisible())
            {
                ar.i();
                return;
            } else
            {
                h.d();
                return;
            }
        }
    }

    protected void onCreate(Bundle bundle)
    {
        YMKSavingPageEvent.b(false);
        YMKSavingPageEvent.d();
        YMKSavingPageEvent.c("original");
        com.cyberlink.youcammakeup.utility.bn.a(null, -1L, com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType.a, new e() {

            final EditViewActivity a;

            public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn bn1)
            {
            }

            public volatile void a(Object obj1)
            {
                a((Void)obj1);
            }

            public void a(Void void1)
            {
            }

            public void b(Object obj1)
            {
                a((com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn)obj1);
            }

            public void c(Object obj1)
            {
            }

            
            {
                a = EditViewActivity.this;
                super();
            }
        });
        BeautifierManager.a();
        Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.o, this);
        if (getIntent().getBooleanExtra("EXTRA_FINISH_ALL_ACTIVITIES", true))
        {
            Globals.d().H();
        }
        StatusManager.j().a(MakeupMode.g, false);
        StatusManager.j().a(BeautyMode.D, false);
        t();
        super.onCreate(null);
        setContentView(0x7f030009);
        StatusManager.j().a("editView");
        StatusManager.j().a(this);
        StatusManager.j().a(this);
        StatusManager.j().a(this);
        StatusManager.j().a(this);
        StatusManager.j().a(this);
        StatusManager.j().a(null);
        StatusManager.j().a(this);
        StatusManager.j().a(this);
        StatusManager.j().a(this);
        Globals.d().a(this);
        if (Globals.d().v() == "editView")
        {
            StatusManager.j().D();
        }
        w = (SeekBar)findViewById(0x7f0c00df);
        x = (SliderValueText)findViewById(0x7f0c00de);
        if (w != null && x != null)
        {
            x.setSlider(w);
            x.setDoubleTapAble(Boolean.valueOf(false));
        }
        i = findViewById(0x7f0c00d5);
        j = findViewById(0x7f0c00d9);
        k = findViewById(0x7f0c00d7);
        l = findViewById(0x7f0c00d6);
        m = findViewById(0x7f0c00d4);
        n = findViewById(0x7f0c074d);
        o = findViewById(0x7f0c074e);
        p = findViewById(0x7f0c00d8);
        q = findViewById(0x7f0c00da);
        r = findViewById(0x7f0c05ab);
        s = findViewById(0x7f0c05ac);
        t = findViewById(0x7f0c05ad);
        u = findViewById(0x7f0c00d3);
        if (i != null)
        {
            i.setOnTouchListener(aG);
        }
        if (j != null)
        {
            j.setOnClickListener(aI);
        }
        if (k != null)
        {
            k.setOnClickListener(f);
        }
        if (l != null)
        {
            l.setOnClickListener(aH);
        }
        if (m != null)
        {
            m.setOnClickListener(aO);
        }
        a(((android.view.View.OnClickListener) (null)), ((android.view.View.OnClickListener) (null)));
        if (p != null)
        {
            p.setOnClickListener(aL);
        }
        if (q != null)
        {
            q.setOnClickListener(aM);
            q.addOnLayoutChangeListener(ViewAnimationUtils.a);
        }
        if (s != null)
        {
            s.setOnClickListener(aN);
        }
        a(0, 8, 0, 0, 0, 8, 8, 0);
        StatusManager.j().a(MakeupMode.g);
        h = (TopToolBar)getFragmentManager().findFragmentById(0x7f0c00be);
        al = (MakeupMenuBottomToolbar)getFragmentManager().findFragmentById(0x7f0c00c6);
        am = (MakeupLooksBottomToolbar)getFragmentManager().findFragmentById(0x7f0c00c7);
        an = new com.cyberlink.youcammakeup.activity.d(this);
        ao = new com.cyberlink.youcammakeup.activity.j(this, h, am, al);
        ag();
        com.cyberlink.youcammakeup.activity.j.a(ao);
        findViewById(0x7f0c00ca).setOnClickListener(new android.view.View.OnClickListener() {

            final EditViewActivity a;

            public void onClick(View view)
            {
                if (!StatusManager.j().E().booleanValue())
                {
                    return;
                } else
                {
                    StatusManager.j().a(Boolean.valueOf(false));
                    view = a.findViewById(0x7f0c00c5);
                    view.animate().translationY(view.getHeight()).setDuration(300L).setListener(new AnimatorListenerAdapter(this, view) {

                        final View a;
                        final _cls37 b;

                        public void onAnimationEnd(Animator animator)
                        {
                            a.animate().setListener(null);
                            StatusManager.j().a(MakeupMode.g);
                            Globals.d(new Runnable(this) {

                                final _cls1 a;

                                public void run()
                                {
                                    a.a.animate().translationY(0.0F).setDuration(300L).setListener(new AnimatorListenerAdapter(this) {

                                        final _cls1 a;

                                        public void onAnimationEnd(Animator animator)
                                        {
                                            a.a.a.animate().setListener(null);
                                        }

            
            {
                a = _pcls1;
                super();
            }
                                    }).start();
                                }

            
            {
                a = _pcls1;
                super();
            }
                            });
                        }

            
            {
                b = _pcls37;
                a = view;
                super();
            }
                    }).start();
                    com.cyberlink.youcammakeup.activity.EditViewActivity.f(a).c();
                    StatusManager.j().a(Boolean.valueOf(true));
                    return;
                }
            }

            
            {
                a = EditViewActivity.this;
                super();
            }
        });
        Q = (PalettesPanel)getFragmentManager().findFragmentById(0x7f0c00e9);
        Q.a(8);
        ar = (FineTuneToolBar)getFragmentManager().findFragmentById(0x7f0c00eb);
        ar.b(4);
        L = findViewById(0x7f0c00db);
        L.addOnLayoutChangeListener(aP);
        M = findViewById(0x7f0c00dc);
        N = findViewById(0x7f0c00e0);
        O = findViewById(0x7f0c00dd);
        K = (ViewGroup)findViewById(0x7f0c00e5);
        U = true;
        V = true;
        ae = null;
        aA = (SliderValueText)findViewById(0x7f0c00c2);
        if (aA != null)
        {
            aA.setDoubleTapAble(Boolean.valueOf(false));
        }
        u();
        Object obj = StatusManager.j();
        if (ah())
        {
            ((StatusManager) (obj)).a(-1L, a);
            ai();
        } else
        {
            obj = ((StatusManager) (obj)).f(((StatusManager) (obj)).l());
            if (bundle != null && bundle.getBoolean("IS_NO_FACE"))
            {
                x(false);
            } else
            if (obj == null || ((a) (obj)).e == -2)
            {
                D();
            } else
            {
                y(true);
            }
        }
        ag = (FPSampleController)findViewById(0x7f0c05ae);
        ai = new HashMap();
        aj = new HashMap();
        a(new com.cyberlink.youcammakeup.activity.e() {

            final EditViewActivity a;

            public void a()
            {
                com.cyberlink.youcammakeup.widgetpool.wigpreviewview.c.h().a(4);
                AccessoryDrawingCtrl.a(4);
            }

            public void b()
            {
                com.cyberlink.youcammakeup.widgetpool.wigpreviewview.c.h().a(0);
                AccessoryDrawingCtrl.a(0);
            }

            
            {
                a = EditViewActivity.this;
                super();
            }
        });
        MotionControlHelper.e().r(true);
        com.cyberlink.youcammakeup.kernelctrl.sku.h.b().d();
    }

    protected void onDestroy()
    {
        an();
        ar();
        Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.o, null);
        super.onDestroy();
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4 && keyevent.getRepeatCount() == 0)
        {
            keyevent.startTracking();
            return true;
        } else
        {
            return super.onKeyDown(i1, keyevent);
        }
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        setIntent(intent);
        if (ah())
        {
            ai();
        }
    }

    protected void onPause()
    {
        com.cyberlink.youcammakeup.clflurry.b.a(new YMKSavingPageEvent(YMKSavingPageEvent.b, System.currentTimeMillis(), com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.Operation.e, false, false));
        F();
        if (ac != null)
        {
            ac.cancel(true);
            ac = null;
        }
        super.onPause();
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        long l1 = StatusManager.j().l();
        if (!com.cyberlink.youcammakeup.database.g.a(l1) && !com.cyberlink.youcammakeup.kernelctrl.viewengine.i.a(l1))
        {
            if ((bundle = (StatusManager)bundle.getSerializable(g)) != null)
            {
                long l2 = bundle.l();
                StatusManager.j().a(l2, a);
                return;
            }
        }
    }

    protected void onResume()
    {
        super.onResume();
        YMKSavingPageEvent.b = System.currentTimeMillis();
        StatusManager.j().r();
        aq();
        if (!b && y != null)
        {
            ap();
        }
        if (ac != null)
        {
            ac.cancel(true);
            ac = null;
        }
        if (d != null) goto _L2; else goto _L1
_L1:
        a(com.cyberlink.youcammakeup.activity.PageID.a);
_L4:
        E();
        StatusManager.j().C();
        findViewById(0x7f0c00bf).setVisibility(0);
        ca.b().a();
        return;
_L2:
        if (!af())
        {
            ac = new com.cyberlink.youcammakeup.activity.h(this);
            ac.executeOnExecutor(ad, new Void[0]);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(g, StatusManager.j());
        bundle.putBoolean("IS_NO_FACE", af);
    }

    protected void onStart()
    {
        super.onStart();
        StatusManager.j().a("editView");
        if (com.cyberlink.youcammakeup.widgetpool.toolbar.c.a(this) && h != null)
        {
            au = true;
            h.d();
            al.a(new com.cyberlink.youcammakeup.widgetpool.toolbar.d() {

                final EditViewActivity a;

                public void a()
                {
                    com.cyberlink.youcammakeup.activity.EditViewActivity.f(a).b(this);
                    com.cyberlink.youcammakeup.activity.EditViewActivity.v(a);
                }

            
            {
                a = EditViewActivity.this;
                super();
            }
            });
        }
    }

    protected void onStop()
    {
        if (at != null)
        {
            at.d();
            at.b();
        }
        super.onStop();
    }

    public void p(boolean flag)
    {
        if (J instanceof BeautyToolPanel)
        {
            ((BeautyToolPanel)J).d(flag);
        } else
        if (J instanceof com.cyberlink.youcammakeup.widgetpool.panel.d.d)
        {
            ((com.cyberlink.youcammakeup.widgetpool.panel.d.d)J).b(flag);
            return;
        }
    }

    public boolean p()
    {
        if (am == null)
        {
            return false;
        } else
        {
            return am.m();
        }
    }

    public void q(boolean flag)
    {
        ImageViewer imageviewer = (ImageViewer)findViewById(0x7f0c0720);
        if (imageviewer != null)
        {
            imageviewer.setEnableWigLocalMode(flag);
        }
    }

    public boolean q()
    {
        if (am == null)
        {
            return false;
        } else
        {
            return am.s();
        }
    }

    public a r()
    {
        return am.l();
    }

    public void r(boolean flag)
    {
        ImageViewer imageviewer = (ImageViewer)findViewById(0x7f0c0720);
        if (imageviewer != null)
        {
            imageviewer.setEnableAccessoryLocalMode(flag);
        }
    }

    public com.cyberlink.youcammakeup.kernelctrl.c.c s()
    {
        if (d == com.cyberlink.youcammakeup.activity.PageID.a)
        {
            return ((com.cyberlink.youcammakeup.widgetpool.c.a)e).b();
        } else
        {
            return null;
        }
    }

    public void s(boolean flag)
    {
        U = flag;
    }

    protected void t()
    {
        com.cyberlink.youcammakeup.widgetpool.wigpreviewview.c.h();
    }

    public void t(boolean flag)
    {
        T = flag;
    }

    protected void u()
    {
        MotionControlHelper.e().l();
    }

    public void u(boolean flag)
    {
        if (j != null && flag)
        {
            j.setVisibility(0);
            return;
        } else
        {
            j.setVisibility(4);
            return;
        }
    }

    public void v()
    {
        View view = findViewById(0x7f0c074b);
        if (view != null)
        {
            view.setEnabled(true);
        }
    }

    public void v(boolean flag)
    {
        if (aA != null)
        {
            SliderValueText slidervaluetext = aA;
            int i1;
            if (flag)
            {
                i1 = 0;
            } else
            {
                i1 = 8;
            }
            slidervaluetext.setVisibility(i1);
        }
    }

    public int w()
    {
        int i1 = 8;
        if (N != null)
        {
            i1 = N.getVisibility();
        }
        return i1;
    }

    public void w(boolean flag)
    {
        if (u != null)
        {
            View view = u;
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

    public void x()
    {
        U();
        ar.m();
        ar.a();
        ar.b();
        getFragmentManager().beginTransaction().show(ar).commit();
        ar.b(0);
        while (!ag.c() || ap && StatusManager.j().s() == BeautyMode.s) 
        {
            return;
        }
        View view = findViewById(0x7f0c065d);
        if (view != null)
        {
            ai.put(view, Integer.valueOf(view.getVisibility()));
            view.setVisibility(4);
        }
        view = findViewById(0x7f0c0654);
        if (view != null)
        {
            ai.put(view, Integer.valueOf(view.getVisibility()));
            view.setVisibility(4);
        }
        view = findViewById(0x7f0c0655);
        if (view != null)
        {
            ai.put(view, Integer.valueOf(view.getVisibility()));
            view.setVisibility(4);
        }
        view = findViewById(0x7f0c0659);
        if (view != null)
        {
            ai.put(view, Integer.valueOf(view.getVisibility()));
            view.setVisibility(4);
        }
        view = findViewById(0x7f0c065a);
        if (view != null)
        {
            ai.put(view, Integer.valueOf(view.getVisibility()));
            view.setVisibility(4);
        }
        view = findViewById(0x7f0c065b);
        if (view != null)
        {
            ai.put(view, Integer.valueOf(view.getVisibility()));
            view.setVisibility(4);
        }
        view = findViewById(0x7f0c065c);
        if (view != null)
        {
            ai.put(view, Integer.valueOf(view.getVisibility()));
            view.setVisibility(4);
        }
        view = findViewById(0x7f0c0656);
        if (view != null)
        {
            ai.put(view, Integer.valueOf(view.getVisibility()));
            view.setVisibility(4);
        }
        view = findViewById(0x7f0c0657);
        if (view != null)
        {
            ai.put(view, Integer.valueOf(view.getVisibility()));
            view.setVisibility(4);
        }
        view = findViewById(0x7f0c0658);
        if (view != null)
        {
            ai.put(view, Integer.valueOf(view.getVisibility()));
            view.setVisibility(4);
        }
        view = findViewById(0x7f0c00c8);
        if (view != null)
        {
            ai.put(view, Integer.valueOf(view.getVisibility()));
            view.setVisibility(4);
        }
        view = findViewById(0x7f0c00d2);
        if (view != null)
        {
            ai.put(view, Integer.valueOf(view.getVisibility()));
            view.setVisibility(4);
        }
        view = findViewById(0x7f0c00c9);
        if (view != null)
        {
            ai.put(view, Integer.valueOf(view.getVisibility()));
            view.setVisibility(4);
        }
        if (l != null)
        {
            ai.put(l, Integer.valueOf(l.getVisibility()));
            l.setVisibility(4);
        }
        if (k != null)
        {
            ai.put(k, Integer.valueOf(k.getVisibility()));
            k.setVisibility(4);
        }
        if (p != null)
        {
            ai.put(p, Integer.valueOf(p.getVisibility()));
            p.setVisibility(4);
        }
        if (q != null)
        {
            ai.put(q, Integer.valueOf(q.getVisibility()));
            q.setVisibility(4);
        }
        if (M != null)
        {
            ai.put(M, Integer.valueOf(M.getVisibility()));
            M.setVisibility(8);
        }
        if (O != null)
        {
            ai.put(O, Integer.valueOf(O.getVisibility()));
            O.setVisibility(8);
        }
        if (N != null)
        {
            ai.put(N, Integer.valueOf(N.getVisibility()));
            N.setVisibility(8);
        }
        if (h != null)
        {
            h.a(4);
        }
        if (StatusManager.j().r() == MakeupMode.a && am != null)
        {
            am.a(4);
            c(true);
        }
        K.setVisibility(8);
        ak = StatusManager.j().s();
    }

    public void y()
    {
        if (ai != null && ai.size() > 0)
        {
            if (ak == StatusManager.j().s())
            {
                java.util.Map.Entry entry;
                for (Iterator iterator = ai.entrySet().iterator(); iterator.hasNext(); ((View)entry.getKey()).setVisibility(((Integer)entry.getValue()).intValue()))
                {
                    entry = (java.util.Map.Entry)iterator.next();
                }

            }
            ai.clear();
        }
        if (K != null)
        {
            K.setVisibility(0);
        }
        if (h != null)
        {
            h.a(0);
        }
        if (StatusManager.j().r() == MakeupMode.a && am != null)
        {
            am.a(0);
            c(false);
        }
        getFragmentManager().beginTransaction().hide(ar).commit();
        ar.n();
        ar.b(4);
        ar.q();
        StatusManager.j().y();
    }

    public void z()
    {
        m.setSelected(false);
        ImageViewer imageviewer = (ImageViewer)findViewById(0x7f0c0720);
        if (imageviewer != null)
        {
            imageviewer.a(false);
            o(false);
            imageviewer.setFeaturePtVisibility(false);
        }
        z(false);
    }


    private class PageID extends Enum
    {

        public static final PageID a;
        private static final PageID b[];

        public static PageID valueOf(String s1)
        {
            return (PageID)Enum.valueOf(com/cyberlink/youcammakeup/activity/EditViewActivity$PageID, s1);
        }

        public static PageID[] values()
        {
            return (PageID[])b.clone();
        }

        static 
        {
            a = new PageID("singleView", 0);
            b = (new PageID[] {
                a
            });
        }

        private PageID(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
