// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.c;

import android.app.Activity;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.cyberlink.clgpuimage.CLMakeupLiveFilter;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.CameraActivity;
import com.cyberlink.youcammakeup.activity.ExtraDownloadCategoryActivity;
import com.cyberlink.youcammakeup.activity.MoreMakeupActivity;
import com.cyberlink.youcammakeup.camera.CameraCtrl;
import com.cyberlink.youcammakeup.camera.y;
import com.cyberlink.youcammakeup.clflurry.YMKLiveCamEvent;
import com.cyberlink.youcammakeup.clflurry.YMKLooksStoreEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata;
import com.cyberlink.youcammakeup.database.more.types.CategoryType;
import com.cyberlink.youcammakeup.h;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierManager;
import com.cyberlink.youcammakeup.kernelctrl.LiveDemoConfigHelper;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.j;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.pages.moreview.af;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.DownloadUseUtils;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.ao;
import com.cyberlink.youcammakeup.utility.as;
import com.cyberlink.youcammakeup.utility.at;
import com.cyberlink.youcammakeup.utility.bn;
import com.cyberlink.youcammakeup.utility.bo;
import com.cyberlink.youcammakeup.utility.cc;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.ICameraPanel;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.AdapterView;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.HorizontalGridView;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.p;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.q;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.cyberlink.youcammakeup.widgetpool.common.e;
import com.cyberlink.youcammakeup.widgetpool.dialogs.an;
import com.cyberlink.youcammakeup.widgetpool.panel.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.c:
//            u, r, y, p, 
//            g, d, e, b, 
//            c, h, i, a

public class x extends Fragment
    implements ICameraPanel, a
{

    HandlerThread a;
    p b;
    private View c;
    private HorizontalGridView d;
    private r e;
    private CameraCtrl f;
    private View g;
    private Handler h;
    private com.cyberlink.youcammakeup.widgetpool.panel.c.y i;
    private final com.cyberlink.youcammakeup.e j = new com.cyberlink.youcammakeup.e() {

        final x a;

        public volatile void a(Object obj)
        {
            a((List)obj);
        }

        public void a(List list)
        {
            Log.d("LookEffectPanel", "getTemplateMetadata complete");
            if (list == null)
            {
                return;
            } else
            {
                Globals.d(new Runnable(this, list) {

                    final List a;
                    final _cls8 b;

                    public void run()
                    {
                        com.cyberlink.youcammakeup.widgetpool.panel.c.x.a(b.a).c();
                        com.cyberlink.youcammakeup.widgetpool.panel.c.x.a(b.a).a(a);
                        x.c(b.a).run();
                    }

            
            {
                b = _pcls8;
                a = list;
                super();
            }
                });
                return;
            }
        }

        public void b(Object obj)
        {
            Log.e("LookEffectPanel", "getTemplateMetadata error");
            Globals.d(x.c(a));
        }

        public void c(Object obj)
        {
            Log.e("LookEffectPanel", "getTemplateMetadata cancel");
            Globals.d(x.c(a));
        }

            
            {
                a = x.this;
                super();
            }
    };
    private final Runnable k = new Runnable() {

        final x a;

        public void run()
        {
            if (x.d(a) != null)
            {
                int i1 = com.cyberlink.youcammakeup.widgetpool.panel.c.x.a(a).a(x.d(a).b);
                if (x.d(a).a)
                {
                    Log.d("LookEffectPanel", (new StringBuilder()).append("[onFinishPromotionQuery] move ").append(x.d(a).b).append(" to first").toString());
                    i1 = 2;
                    com.cyberlink.youcammakeup.widgetpool.panel.c.x.a(a).a(2, x.d(a).b);
                }
                com.cyberlink.youcammakeup.widgetpool.panel.c.x.a(a, i1, true);
                com.cyberlink.youcammakeup.widgetpool.panel.c.x.a(a, null);
            }
        }

            
            {
                a = x.this;
                super();
            }
    };
    private final Runnable l = new Runnable() {

        final x a;

        public void run()
        {
            Globals.d().i().b(a.getActivity());
        }

            
            {
                a = x.this;
                super();
            }
    };
    private final Runnable m = new Runnable() {

        final x a;

        public void run()
        {
            Globals.d().i().h(a.getActivity());
        }

            
            {
                a = x.this;
                super();
            }
    };
    private final android.content.DialogInterface.OnDismissListener n = new android.content.DialogInterface.OnDismissListener() {

        final x a;

        public void onDismiss(DialogInterface dialoginterface)
        {
            if (com.cyberlink.youcammakeup.widgetpool.panel.c.x.e(a) != null && (!Globals.d().i().a() || Globals.d().i().b()))
            {
                com.cyberlink.youcammakeup.widgetpool.panel.c.x.e(a).setChoiceMode(1);
                com.cyberlink.youcammakeup.widgetpool.panel.c.x.e(a).a(com.cyberlink.youcammakeup.widgetpool.panel.c.x.a(a).a(), true);
                com.cyberlink.youcammakeup.widgetpool.panel.c.x.a(a).a(false);
            }
        }

            
            {
                a = x.this;
                super();
            }
    };
    private final android.view.View.OnClickListener o = new android.view.View.OnClickListener() {

        final x a;

        public void onClick(View view)
        {
            int j1 = ((Integer)((e)view).getTag()).intValue();
            int i1 = com.cyberlink.youcammakeup.widgetpool.panel.c.x.a(a).a();
            Log.d("LookEffectPanel", (new StringBuilder()).append("Delete position:").append(j1).append(", selected position:").append(i1).toString());
            view = com.cyberlink.youcammakeup.widgetpool.panel.c.x.a(a).b(j1);
            if (i1 == j1)
            {
                i1 = 1;
            } else
            if (i1 > j1 && !view.i())
            {
                i1--;
            } else
            {
                i1 = -1;
            }
            if (i1 != -1)
            {
                com.cyberlink.youcammakeup.widgetpool.panel.c.x.a(a, i1, true);
            }
            com.cyberlink.youcammakeup.widgetpool.panel.c.x.a(a).d(j1);
        }

            
            {
                a = x.this;
                super();
            }
    };

    public x(CameraCtrl cameractrl)
    {
        g = null;
        h = null;
        a = new HandlerThread("camera live makeup demo");
        b = new p() {

            final x a;

            public void a(AdapterView adapterview, View view, int i1, long l1)
            {
                Log.d("LookEffectPanel", (new StringBuilder()).append("onGridItemClick, position:").append(i1).toString());
                if (com.cyberlink.youcammakeup.widgetpool.panel.c.x.a(a).d())
                {
                    com.cyberlink.youcammakeup.utility.o.c();
                } else
                {
                    if (i1 == 0)
                    {
                        com.cyberlink.youcammakeup.clflurry.b.a(new YMKLiveCamEvent(true, 0L, 0L, com.cyberlink.youcammakeup.clflurry.YMKLiveCamEvent.Operation.l, false, false));
                        com.cyberlink.youcammakeup.widgetpool.panel.c.x.e(a).a(com.cyberlink.youcammakeup.widgetpool.panel.c.x.a(a).a(), true);
                        Globals.d().w().K().b(MoreMakeupActivity.a, 0x15ab1bL);
                        z.a("HAS_SET_SEEN_LIVE_LOOK_RED_ICON", Boolean.valueOf(true), Globals.d());
                        com.cyberlink.youcammakeup.widgetpool.panel.c.x.a(a).notifyDataSetChanged();
                        YMKLooksStoreEvent.b(com.cyberlink.youcammakeup.clflurry.YMKLooksStoreEvent.Source.b.a());
                        adapterview = new Intent(view.getContext(), com/cyberlink/youcammakeup/activity/ExtraDownloadCategoryActivity);
                        view = CategoryType.b;
                        adapterview.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_ID", CategoryType.a(view));
                        adapterview.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_NAME", a.getString(0x7f070502));
                        adapterview.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_TYPE", view);
                        adapterview.putExtra("KEY_EXTRA_DOWNLOAD_DISPLAY_TYPE", com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType.c.ordinal());
                        adapterview.putExtra(a.getResources().getString(0x7f070729), com/cyberlink/youcammakeup/activity/CameraActivity);
                        DownloadUseUtils.a(adapterview, true);
                        a.startActivity(adapterview);
                        return;
                    }
                    if (i1 != com.cyberlink.youcammakeup.widgetpool.panel.c.x.a(a).a())
                    {
                        adapterview = (e)view;
                        view = com.cyberlink.youcammakeup.widgetpool.panel.c.x.a(a).b(i1);
                        if (view.e())
                        {
                            YMKLiveCamEvent.c(com.cyberlink.youcammakeup.widgetpool.panel.c.x.a(a).b(i1).g().c());
                            com.cyberlink.youcammakeup.clflurry.b.a(new YMKLiveCamEvent(true, 0L, 0L, com.cyberlink.youcammakeup.clflurry.YMKLiveCamEvent.Operation.b, true, false));
                            com.cyberlink.youcammakeup.widgetpool.panel.c.x.a(a).a(i1);
                            com.cyberlink.youcammakeup.widgetpool.panel.c.x.e(a).a(i1, true);
                            if (com.cyberlink.youcammakeup.widgetpool.panel.c.x.e(a).getChildAt(i1 - com.cyberlink.youcammakeup.widgetpool.panel.c.x.e(a).getFirstVisiblePosition()) != null)
                            {
                                com.cyberlink.youcammakeup.widgetpool.panel.c.x.e(a).d(i1, 200);
                            } else
                            {
                                com.cyberlink.youcammakeup.widgetpool.panel.c.x.e(a).c(i1);
                            }
                            com.cyberlink.youcammakeup.widgetpool.panel.c.x.a(a, i1, false);
                            return;
                        }
                        if (view.h())
                        {
                            com.cyberlink.youcammakeup.widgetpool.panel.c.x.a(a, i1, view, adapterview);
                            return;
                        } else
                        {
                            adapterview = view.b();
                            Globals.d().a(adapterview);
                            com.cyberlink.youcammakeup.utility.o.a(a.getActivity(), an.a(adapterview), "ShareToUnlockDialog");
                            return;
                        }
                    }
                }
            }

            
            {
                a = x.this;
                super();
            }
        };
        f = cameractrl;
        h = new Handler();
    }

    static r a(x x1)
    {
        return x1.e;
    }

    static com.cyberlink.youcammakeup.widgetpool.panel.c.y a(x x1, com.cyberlink.youcammakeup.widgetpool.panel.c.y y1)
    {
        x1.i = y1;
        return y1;
    }

    private void a(int i1, u u1, e e1)
    {
        Log.d("LookEffectPanel", (new StringBuilder()).append("[downloadAndApplyPosition] position:").append(i1).append(" name:").append(u1.c()).toString());
        Activity activity = getActivity();
        if (e1.b())
        {
            e1.a();
            bn.a(u1.b());
            return;
        } else
        {
            e1.a();
            bn.a(CategoryType.a(CategoryType.a), u1.b(), new j(i1, e1, activity) {

                final int a;
                final e b;
                final Activity c;
                final x d;

                public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.a a1)
                {
                    int j1 = Math.min(100, af.a(a1));
                    if (a == ((Integer)b.getTag()).intValue())
                    {
                        c.runOnUiThread(new Runnable(this, j1) {

                            final int a;
                            final _cls7 b;

                            public void run()
                            {
                                b.b.setProgress(a);
                            }

            
            {
                b = _pcls7;
                a = i1;
                super();
            }
                        });
                    }
                }

                public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn bn1)
                {
                    if (a == ((Integer)b.getTag()).intValue())
                    {
                        c.runOnUiThread(new Runnable(this) {

                            final _cls7 a;

                            public void run()
                            {
                                a.b.a(true, false);
                                String s = a.c.getString(0x7f070534);
                                Globals.d().i().a(a.c, null, new android.view.View.OnClickListener(this) {

                                    final _cls2 a;

                                    public void onClick(View view)
                                    {
                                        com.cyberlink.youcammakeup.widgetpool.panel.c.x.e(a.a.d).a(a.a.b, a.a.a, a.a.b.getId());
                                    }

            
            {
                a = _pcls2;
                super();
            }
                                }, null, s);
                            }

            
            {
                a = _pcls7;
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
                    if (a == ((Integer)b.getTag()).intValue())
                    {
                        c.runOnUiThread(new Runnable(this) {

                            final _cls7 a;

                            public void run()
                            {
                                a.b.a(true, true);
                                com.cyberlink.youcammakeup.widgetpool.panel.c.x.a(a.d, a.a, false);
                            }

            
            {
                a = _pcls7;
                super();
            }
                        });
                    }
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
                d = x.this;
                a = i1;
                b = e1;
                c = activity;
                super();
            }
            });
            return;
        }
    }

    private void a(int i1, boolean flag)
    {
        Log.d("LookEffectPanel", (new StringBuilder()).append("[applyPosition] position:").append(i1).toString());
        if (h == null)
        {
            return;
        } else
        {
            Runnable runnable = new Runnable(flag, i1) {

                final boolean a;
                final int b;
                final x c;

                public void run()
                {
                    if (x.g(c) == null)
                    {
                        return;
                    }
                    if (!com.cyberlink.youcammakeup.widgetpool.panel.c.x.b(c).k().l())
                    {
                        x.g(c).postDelayed(this, 200L);
                        return;
                    }
                    if (a)
                    {
                        com.cyberlink.youcammakeup.widgetpool.panel.c.x.e(c).c(b);
                    }
                    com.cyberlink.youcammakeup.widgetpool.panel.c.x.a(c).a(b);
                    com.cyberlink.youcammakeup.widgetpool.panel.c.x.e(c).a(b, true);
                    com.cyberlink.youcammakeup.widgetpool.panel.c.x.a(c).a(b, false);
                    com.cyberlink.youcammakeup.widgetpool.panel.c.x.a(c, com.cyberlink.youcammakeup.widgetpool.panel.c.x.a(c).b(b).g());
                }

            
            {
                c = x.this;
                a = flag;
                b = i1;
                super();
            }
            };
            h.post(runnable);
            return;
        }
    }

    private void a(as as1)
    {
        (new AsyncTask(as1) {

            final as a;
            final x b;

            protected transient Void a(Void avoid[])
            {
                BeautifierManager beautifiermanager;
                Log.d("LookEffectPanel", (new StringBuilder()).append("[applyEffect] GUID:").append(a.a()).toString());
                avoid = com.cyberlink.youcammakeup.widgetpool.panel.c.x.b(b).j();
                beautifiermanager = com.cyberlink.youcammakeup.widgetpool.panel.c.x.b(b).k().j();
                if (!(avoid instanceof CLMakeupLiveFilter)) goto _L2; else goto _L1
_L1:
                CLMakeupLiveFilter clmakeuplivefilter;
                List list;
                android.hardware.Camera.Size size;
                Iterator iterator;
                boolean flag;
                boolean flag1;
                boolean flag2;
                boolean flag3;
                boolean flag4;
                clmakeuplivefilter = (CLMakeupLiveFilter)avoid;
                com.cyberlink.youcammakeup.clflurry.p.l(a.a());
                list = a.m();
                avoid = new android.graphics.BitmapFactory.Options();
                avoid.inSampleSize = 2;
                avoid.inJustDecodeBounds = false;
                size = com.cyberlink.youcammakeup.widgetpool.panel.c.x.b(b).k().k();
                if (size == null)
                {
                    return null;
                }
                avoid = com.cyberlink.youcammakeup.widgetpool.panel.c.p.a();
                avoid.a(BeautyMode.n, null);
                avoid.a(BeautyMode.m, null);
                avoid.a(BeautyMode.l, null);
                avoid.a(BeautyMode.a, null);
                avoid.a(BeautyMode.v, null);
                avoid.a(BeautyMode.r, null);
                avoid.a(a.f());
                iterator = list.iterator();
                flag4 = false;
                flag3 = false;
                flag2 = false;
                flag1 = false;
                flag = false;
_L10:
                if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
                int ai[] = (ao)iterator.next();
                if (ai.a() != BeautyMode.n) goto _L6; else goto _L5
_L5:
                int ai1[];
                int ai2[];
                int ai3[];
                byte abyte4[][];
                byte abyte5[];
                byte abyte6[];
                byte abyte7[];
                int j1;
                int l1;
                int l2;
                int k3;
                int l3;
                List list1 = ai.f();
                MotionControlHelper.e().b(list1);
                avoid = com.cyberlink.youcammakeup.widgetpool.panel.c.p.a();
                avoid.a(BeautyMode.n, ai.b());
                avoid.a(new g(ai.c(), list1, false));
                avoid = com.cyberlink.youcammakeup.widgetpool.panel.c.d.a(ai.b());
                abyte4 = ((com.cyberlink.youcammakeup.widgetpool.panel.c.e) (avoid)).a;
                l2 = abyte4.length;
                ai = new int[((com.cyberlink.youcammakeup.widgetpool.panel.c.e) (avoid)).d * ((com.cyberlink.youcammakeup.widgetpool.panel.c.e) (avoid)).e];
                ai1 = new int[list1.size()];
                ai2 = new int[list1.size()];
                for (int i1 = 0; i1 < list1.size(); i1++)
                {
                    ai1[i1] = ((at)list1.get(i1)).e();
                    ai2[i1] = ((at)list1.get(i1)).d();
                }

                k3 = Math.min(size.height, size.width) / 2;
                l3 = (k3 * 2) / 3;
                ai3 = new int[l2];
                j1 = 0;
                while (j1 < l2) 
                {
                    if (j1 >= list1.size())
                    {
                        ai3[j1] = 0;
                    } else
                    {
                        int k1;
                        if (((at)list1.get(j1)).k())
                        {
                            k1 = ((at)list1.get(j1)).j();
                        } else
                        {
                            k1 = 0;
                        }
                        ai3[j1] = k1;
                    }
                    j1++;
                }
                l1 = 0;
                for (j1 = 0; j1 < 2; j1++)
                {
                    l1 += (k3 >> j1) * (l3 >> j1);
                }

                abyte5 = new byte[l1];
                abyte6 = new byte[l1];
                Bitmap bitmap = com.cyberlink.youcammakeup.widgetpool.panel.c.x.b(b).k().a("makeup/eyeshadow/bright.png");
                j1 = bitmap.getWidth();
                l1 = bitmap.getHeight();
                abyte7 = com.cyberlink.youcammakeup.widgetpool.panel.c.x.b(b).k().a(bitmap);
                if (beautifiermanager == null)
                {
                    break MISSING_BLOCK_LABEL_692;
                }
                beautifiermanager;
                JVM INSTR monitorenter ;
                beautifiermanager.a(ai, abyte4, ai1, ai2, l2, ((com.cyberlink.youcammakeup.widgetpool.panel.c.e) (avoid)).d, ((com.cyberlink.youcammakeup.widgetpool.panel.c.e) (avoid)).e, k3, l3, ai3, 2, j1, l1, abyte7, abyte5, abyte6);
                beautifiermanager;
                JVM INSTR monitorexit ;
                clmakeuplivefilter.a(true, ai, abyte5, abyte6);
                if (!((com.cyberlink.youcammakeup.widgetpool.panel.c.e) (avoid)).c) goto _L8; else goto _L7
_L7:
                abyte4 = ((com.cyberlink.youcammakeup.widgetpool.panel.c.e) (avoid)).b;
                l2 = abyte4.length;
                if (beautifiermanager == null) goto _L8; else goto _L9
_L9:
                beautifiermanager;
                JVM INSTR monitorenter ;
                beautifiermanager.a(ai, abyte4, ai1, ai2, l2, ((com.cyberlink.youcammakeup.widgetpool.panel.c.e) (avoid)).d, ((com.cyberlink.youcammakeup.widgetpool.panel.c.e) (avoid)).e, k3, l3, ai3, 2, j1, l1, abyte7, abyte5, abyte6);
                beautifiermanager;
                JVM INSTR monitorexit ;
_L8:
                clmakeuplivefilter.a(false, ai, abyte5, abyte6);
                boolean flag5 = flag4;
                flag1 = flag3;
                flag3 = true;
                flag4 = flag;
                flag = flag5;
_L11:
                boolean flag6 = flag1;
                flag1 = flag3;
                boolean flag10 = flag4;
                flag4 = flag;
                flag3 = flag6;
                flag = flag10;
                  goto _L10
                avoid;
                beautifiermanager;
                JVM INSTR monitorexit ;
                throw avoid;
                avoid;
                beautifiermanager;
                JVM INSTR monitorexit ;
                throw avoid;
_L6:
                if (ai.a() != BeautyMode.l)
                {
                    break MISSING_BLOCK_LABEL_1107;
                }
                Globals.d().e((new StringBuilder()).append("LiveMakeup LookEffectPanel eyeline patternID = ").append(String.valueOf(ai.b())).toString());
                avoid = com.cyberlink.youcammakeup.widgetpool.panel.c.b.a(ai.b());
                byte abyte0[][] = ((c) (avoid)).a;
                int i3 = abyte0.length;
                j1 = ((c) (avoid)).b;
                byte abyte2[] = new byte[((c) (avoid)).c * j1];
                com.cyberlink.youcammakeup.widgetpool.panel.c.p p3;
                int i2;
                boolean flag7;
                if (!ai.f().isEmpty())
                {
                    avoid = (at)ai.f().get(0);
                } else
                {
                    avoid = null;
                }
                j1 = 0;
                i2 = 0;
                if (avoid != null)
                {
                    j1 = ((at)ai.f().get(0)).e();
                    i2 = ((at)ai.f().get(0)).d();
                }
                p3 = com.cyberlink.youcammakeup.widgetpool.panel.c.p.a();
                p3.a(BeautyMode.l, ai.b());
                p3.b(BeautyMode.l, ai.c());
                p3.a(BeautyMode.l, avoid);
                if (beautifiermanager == null)
                {
                    break MISSING_BLOCK_LABEL_1071;
                }
                beautifiermanager;
                JVM INSTR monitorenter ;
                beautifiermanager.a(abyte2, abyte0, j1, i2, i3, 450, 300);
                beautifiermanager;
                JVM INSTR monitorexit ;
                clmakeuplivefilter.b(true, abyte2, j1);
                clmakeuplivefilter.b(false, abyte2, j1);
                flag = flag4;
                flag4 = flag1;
                flag7 = true;
                flag1 = flag3;
                flag3 = flag4;
                flag4 = flag7;
                  goto _L11
                avoid;
                beautifiermanager;
                JVM INSTR monitorexit ;
                throw avoid;
                if (ai.a() != BeautyMode.m)
                {
                    break MISSING_BLOCK_LABEL_1360;
                }
                avoid = com.cyberlink.youcammakeup.widgetpool.panel.c.h.a(ai.b());
                byte abyte1[][] = ((i) (avoid)).a;
                int j3 = abyte1.length;
                j1 = ((i) (avoid)).b;
                byte abyte3[] = new byte[((i) (avoid)).c * j1];
                com.cyberlink.youcammakeup.widgetpool.panel.c.p p4;
                int j2;
                boolean flag8;
                boolean flag11;
                if (!ai.f().isEmpty())
                {
                    avoid = (at)ai.f().get(0);
                } else
                {
                    avoid = null;
                }
                j1 = 0;
                j2 = 0;
                if (avoid != null)
                {
                    j1 = ((at)ai.f().get(0)).e();
                    j2 = ((at)ai.f().get(0)).d();
                }
                p4 = com.cyberlink.youcammakeup.widgetpool.panel.c.p.a();
                p4.a(BeautyMode.m, ai.b());
                p4.b(BeautyMode.m, ai.c());
                p4.a(BeautyMode.m, avoid);
                if (beautifiermanager == null)
                {
                    break MISSING_BLOCK_LABEL_1320;
                }
                beautifiermanager;
                JVM INSTR monitorenter ;
                beautifiermanager.b(abyte3, abyte1, j1, j2, j3, 450, 300);
                beautifiermanager;
                JVM INSTR monitorexit ;
                clmakeuplivefilter.a(true, abyte3, j1);
                clmakeuplivefilter.a(false, abyte3, j1);
                flag11 = true;
                flag4 = flag1;
                flag8 = flag;
                flag = flag11;
                flag1 = flag3;
                flag3 = flag4;
                flag4 = flag8;
                  goto _L11
                avoid;
                beautifiermanager;
                JVM INSTR monitorexit ;
                throw avoid;
                if (ai.a() != BeautyMode.v) goto _L13; else goto _L12
_L12:
                Object aobj[] = new int[3];
                com.cyberlink.youcammakeup.widgetpool.panel.c.p p1;
                com.cyberlink.youcammakeup.widgetpool.panel.c.p p2;
                int k2;
                boolean flag9;
                boolean flag12;
                if (!ai.f().isEmpty())
                {
                    avoid = (at)ai.f().get(0);
                } else
                {
                    avoid = null;
                }
                k2 = 0;
                if (avoid != null)
                {
                    k2 = avoid.d();
                    aobj[0] = avoid.f();
                    aobj[1] = avoid.g();
                    aobj[2] = avoid.e();
                }
                p2 = com.cyberlink.youcammakeup.widgetpool.panel.c.p.a();
                p2.a(BeautyMode.v, ai.b());
                p2.b(BeautyMode.v, ai.c());
                p2.a(BeautyMode.v, avoid);
                avoid = PanelDataCenter.a().b(BeautyMode.v, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a);
                j1 = 0;
_L16:
                if (j1 < avoid.size())
                {
                    if (!((String)avoid.get(j1)).equals(ai.b()))
                    {
                        break MISSING_BLOCK_LABEL_1971;
                    }
                } else
                {
                    j1 = 0;
                }
                clmakeuplivefilter.a(aobj[2]);
                avoid = new com.cyberlink.clgpuimage.CLMakeupLiveLipStickFilter.LipStickProfile(com.cyberlink.clgpuimage.CLMakeupLiveLipStickFilter.BlendMode.values()[j1], aobj[2], aobj[0], aobj[1]);
                if (beautifiermanager == null) goto _L15; else goto _L14
_L14:
                beautifiermanager;
                JVM INSTR monitorenter ;
                beautifiermanager.a(avoid);
                beautifiermanager.a(k2);
                beautifiermanager;
                JVM INSTR monitorexit ;
                  goto _L15
                avoid;
                beautifiermanager;
                JVM INSTR monitorexit ;
                throw avoid;
_L13:
                if (ai.a() == BeautyMode.a)
                {
                    aobj = com.cyberlink.youcammakeup.widgetpool.panel.c.a.a(ai.b());
                    if (!ai.f().isEmpty())
                    {
                        avoid = (at)ai.f().get(0);
                    } else
                    {
                        avoid = null;
                    }
                    k2 = 0;
                    j1 = 0;
                    if (avoid != null)
                    {
                        k2 = avoid.d();
                        j1 = avoid.e();
                    }
                    p2 = com.cyberlink.youcammakeup.widgetpool.panel.c.p.a();
                    p2.a(BeautyMode.a, ai.b());
                    p2.b(BeautyMode.a, ai.c());
                    p2.a(BeautyMode.a, avoid);
                    clmakeuplivefilter.a(((Bitmap []) (aobj)));
                    clmakeuplivefilter.a(k2);
                    clmakeuplivefilter.b(j1);
                    flag9 = flag4;
                    flag12 = true;
                    flag3 = flag1;
                    flag4 = flag;
                    flag = flag9;
                    flag1 = flag12;
                } else
                {
                    if (ai.a() == BeautyMode.r)
                    {
                        if (!ai.f().isEmpty())
                        {
                            avoid = (at)ai.f().get(0);
                        } else
                        {
                            avoid = null;
                        }
                        p1 = com.cyberlink.youcammakeup.widgetpool.panel.c.p.a();
                        p1.a(BeautyMode.r, ai.b());
                        p1.a(BeautyMode.r, avoid);
                        p1.a(ai.h());
                    }
                    flag9 = flag1;
                    flag12 = flag;
                    flag = flag4;
                    flag1 = flag3;
                    flag3 = flag9;
                    flag4 = flag12;
                }
                  goto _L11
_L4:
                if (list.isEmpty())
                {
                    com.cyberlink.youcammakeup.widgetpool.panel.c.p.a().b();
                }
                clmakeuplivefilter.a(com.cyberlink.clgpuimage.CLMakeupLiveFilter.MakeupLiveFeatures.a, flag);
                clmakeuplivefilter.a(com.cyberlink.clgpuimage.CLMakeupLiveFilter.MakeupLiveFeatures.b, flag1);
                clmakeuplivefilter.a(com.cyberlink.clgpuimage.CLMakeupLiveFilter.MakeupLiveFeatures.c, flag2);
                clmakeuplivefilter.a(com.cyberlink.clgpuimage.CLMakeupLiveFilter.MakeupLiveFeatures.e, flag3);
                clmakeuplivefilter.a(com.cyberlink.clgpuimage.CLMakeupLiveFilter.MakeupLiveFeatures.f, flag4);
_L2:
                return null;
_L15:
                flag2 = flag4;
                flag9 = flag3;
                flag12 = true;
                flag3 = flag1;
                flag4 = flag;
                flag = flag2;
                flag1 = flag9;
                flag2 = flag12;
                  goto _L11
                j1++;
                  goto _L16
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            
            {
                b = x.this;
                a = as1;
                super();
            }
        }).execute(new Void[0]);
    }

    static void a(x x1, int i1, u u1, e e1)
    {
        x1.a(i1, u1, e1);
    }

    static void a(x x1, int i1, boolean flag)
    {
        x1.a(i1, flag);
    }

    static void a(x x1, as as1)
    {
        x1.a(as1);
    }

    private void a(String s)
    {
        Log.d("LookEffectPanel", (new StringBuilder()).append("[downloadAndApply] guid:").append(s).toString());
        ArrayList arraylist = new ArrayList();
        arraylist.add(s);
        Globals.d(l);
        bn.b(arraylist, new com.cyberlink.youcammakeup.e(s) {

            final String a;
            final x b;

            public volatile void a(Object obj)
            {
                a((List)obj);
            }

            public void a(List list)
            {
                list = list.iterator();
                boolean flag = false;
                do
                {
                    if (!list.hasNext())
                    {
                        break;
                    }
                    MakeupItemMetadata makeupitemmetadata = (MakeupItemMetadata)list.next();
                    Log.e("LookEffectPanel", "[downloadTemplate] complete: ");
                    if (makeupitemmetadata.m().equals(a))
                    {
                        flag = true;
                        bn.a(CategoryType.a(CategoryType.a), makeupitemmetadata, new j(this, makeupitemmetadata) {

                            final MakeupItemMetadata a;
                            final _cls6 b;

                            public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.a a1)
                            {
                            }

                            public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn bn1)
                            {
                                Log.e("LookEffectPanel", (new StringBuilder()).append("[downloadTemplate] error: ").append(bn1).toString());
                                Globals.d(com.cyberlink.youcammakeup.widgetpool.panel.c.x.h(b.b));
                            }

                            public volatile void a(Object obj)
                            {
                                a((Void)obj);
                            }

                            public void a(Void void1)
                            {
                                Globals.c(new Runnable(this) {

                                    final _cls1 a;

                                    public void run()
                                    {
                                        int i1 = 2;
                                        int j1 = com.cyberlink.youcammakeup.widgetpool.panel.c.x.a(a.b.b).a(a.a.b());
                                        if (j1 == -1)
                                        {
                                            com.cyberlink.youcammakeup.widgetpool.panel.c.x.a(a.b.b).a(2, a.a.b());
                                        } else
                                        {
                                            i1 = j1;
                                        }
                                        com.cyberlink.youcammakeup.widgetpool.panel.c.x.a(a.b.b, i1, true);
                                    }

            
            {
                a = _pcls1;
                super();
            }
                                });
                                Globals.d(com.cyberlink.youcammakeup.widgetpool.panel.c.x.h(b.b));
                            }

                            public void b(Object obj)
                            {
                                a((com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn)obj);
                            }

                            public void b(Void void1)
                            {
                                Log.e("LookEffectPanel", (new StringBuilder()).append("[downloadTemplate] cancel: ").append(void1).toString());
                                Globals.d(com.cyberlink.youcammakeup.widgetpool.panel.c.x.h(b.b));
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
                b = _pcls6;
                a = makeupitemmetadata;
                super();
            }
                        });
                    }
                } while (true);
                if (!flag)
                {
                    Globals.d(com.cyberlink.youcammakeup.widgetpool.panel.c.x.h(b));
                }
            }

            public void b(Object obj)
            {
                Log.e("LookEffectPanel", (new StringBuilder()).append("[getTemplateMetadata] error: ").append(obj).toString());
                Globals.d(com.cyberlink.youcammakeup.widgetpool.panel.c.x.h(b));
            }

            public void c(Object obj)
            {
                Log.d("LookEffectPanel", (new StringBuilder()).append("[getTemplateMetadata] cancel: ").append(obj).toString());
                Globals.d(com.cyberlink.youcammakeup.widgetpool.panel.c.x.h(b));
            }

            
            {
                b = x.this;
                a = s;
                super();
            }
        });
    }

    private boolean a(Intent intent)
    {
        Log.d("LookEffectPanel", "[handleFromIntentUseTemplate]");
        Object obj = (com.cyberlink.youcammakeup.utility.DownloadUseUtils.UseTemplate)intent.getSerializableExtra("EXTRA_KEY_DOWNLOADED_TEMPLATE");
        if (obj == null)
        {
            return false;
        }
        int i1 = e.a(((com.cyberlink.youcammakeup.utility.DownloadUseUtils.UseTemplate) (obj)).typeGUID);
        obj = ((com.cyberlink.youcammakeup.utility.DownloadUseUtils.UseTemplate) (obj)).typeGUID;
        boolean flag;
        if (i1 == -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i = new com.cyberlink.youcammakeup.widgetpool.panel.c.y(((String) (obj)), flag);
        Log.d("LookEffectPanel", (new StringBuilder()).append("[handleFromIntentUseTemplate] target:").append(i.b).append(" ,to first:").append(i.a).toString());
        intent.removeExtra("EXTRA_KEY_DOWNLOADED_TEMPLATE");
        return true;
    }

    static CameraCtrl b(x x1)
    {
        return x1.f;
    }

    private void b(String s)
    {
        if (getActivity() instanceof CameraActivity)
        {
            ((CameraActivity)getActivity()).a(s);
        }
    }

    private boolean b(Intent intent)
    {
        Log.d("LookEffectPanel", "[handleFromIntentPromoLooks");
        Object obj = intent.getStringArrayListExtra("PromoLookIds");
        if (obj == null || ((ArrayList) (obj)).size() <= 0)
        {
            return false;
        }
        MakeupItemMetadata makeupitemmetadata = com.cyberlink.youcammakeup.h.v().a((String)((ArrayList) (obj)).get(0));
        if (makeupitemmetadata != null && makeupitemmetadata.x() && bo.h(makeupitemmetadata.b()))
        {
            int i1 = e.a(makeupitemmetadata.b());
            obj = makeupitemmetadata.b();
            boolean flag;
            if (i1 == -1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            i = new com.cyberlink.youcammakeup.widgetpool.panel.c.y(((String) (obj)), flag);
            Log.d("LookEffectPanel", (new StringBuilder()).append("[handleFromIntentPromoLooks] target:").append(i.b).append(" ,to first:").append(i.a).toString());
        } else
        {
            a((String)((ArrayList) (obj)).get(0));
        }
        intent.removeExtra("PromoLookIds");
        return true;
    }

    static Runnable c(x x1)
    {
        return x1.k;
    }

    static com.cyberlink.youcammakeup.widgetpool.panel.c.y d(x x1)
    {
        return x1.i;
    }

    static HorizontalGridView e(x x1)
    {
        return x1.d;
    }

    static android.content.DialogInterface.OnDismissListener f(x x1)
    {
        return x1.n;
    }

    private void f()
    {
        Intent intent = getActivity().getIntent();
        if (intent != null && !a(intent))
        {
            b(intent);
        }
    }

    static Handler g(x x1)
    {
        return x1.h;
    }

    private void g()
    {
        a.start();
        Handler handler = new Handler(a.getLooper());
        handler.postDelayed(new Runnable(handler) {

            int a;
            int b;
            int c;
            final Handler d;
            final x e;

            public void run()
            {
                if (c == 0)
                {
                    int i1 = c;
                    int j1 = a % b;
                    a = a + 1;
                    Runnable runnable = new Runnable(this, i1, j1) {

                        final int a;
                        final int b;
                        final _cls1 c;

                        public void run()
                        {
                            com.cyberlink.youcammakeup.widgetpool.panel.c.x.b(c.e).a(LiveDemoConfigHelper.h().i());
                            com.cyberlink.youcammakeup.widgetpool.panel.c.x.b(c.e).b(a);
                            String s = com.cyberlink.youcammakeup.widgetpool.panel.c.x.a(c.e).c(b);
                            com.cyberlink.youcammakeup.widgetpool.panel.c.x.b(c.e).b(s);
                        }

            
            {
                c = _pcls1;
                a = i1;
                b = j1;
                super();
            }
                    };
                    com.cyberlink.youcammakeup.widgetpool.panel.c.x.a(e, com.cyberlink.youcammakeup.widgetpool.panel.c.x.a(e).b(j1).g());
                    Globals.d(runnable);
                    c = c + 1;
                } else
                {
                    Globals.d(new Runnable(this, c) {

                        final int a;
                        final _cls1 b;

                        public void run()
                        {
                            com.cyberlink.youcammakeup.widgetpool.panel.c.x.b(b.e).a(LiveDemoConfigHelper.h().i());
                            com.cyberlink.youcammakeup.widgetpool.panel.c.x.b(b.e).b(a);
                        }

            
            {
                b = _pcls1;
                a = i1;
                super();
            }
                    });
                    c = c + 1;
                }
                c = c % LiveDemoConfigHelper.h().i();
                d.postDelayed(this, 1000L);
            }

            
            {
                e = x.this;
                d = handler;
                super();
                a = 0;
                b = com.cyberlink.youcammakeup.widgetpool.panel.c.x.a(e).getCount();
                c = 0;
            }
        }, 1000L);
    }

    static Runnable h(x x1)
    {
        return x1.m;
    }

    private void h()
    {
        d = (HorizontalGridView)c.findViewById(0x7f0c06a2);
        d.setChoiceMode(1);
        if (e == null)
        {
            e = new r(d.getContext(), o);
            e.a(1);
            f();
        }
        if (e.a() == 0 && com.cyberlink.youcammakeup.widgetpool.panel.c.p.a().d())
        {
            e.a(-1);
        }
        if (k())
        {
            e.a(-1);
        }
        d.post(new Runnable() {

            final x a;

            public void run()
            {
                com.cyberlink.youcammakeup.widgetpool.panel.c.x.e(a).a(com.cyberlink.youcammakeup.widgetpool.panel.c.x.a(a).a(), true);
            }

            
            {
                a = x.this;
                super();
            }
        });
        if (getActivity() == null)
        {
            Globals.d();
        }
        d.setAdapter(e);
        g = c.findViewById(0x7f0c0697);
    }

    private void i()
    {
        d.setOnItemClickListener(b);
        if (g != null)
        {
            g.setOnTouchListener(new android.view.View.OnTouchListener() {

                final x a;

                public boolean onTouch(View view, MotionEvent motionevent)
                {
                    boolean flag = com.cyberlink.youcammakeup.widgetpool.panel.c.x.e(a).dispatchTouchEvent(motionevent);
                    if (com.cyberlink.youcammakeup.widgetpool.panel.c.x.b(a) != null)
                    {
                        if (motionevent.getAction() == 0 || motionevent.getAction() == 5)
                        {
                            if (!flag);
                        } else
                        if (motionevent.getAction() != 1 && motionevent.getAction() == 6)
                        {
                            return true;
                        }
                    }
                    return true;
                }

            
            {
                a = x.this;
                super();
            }
            });
        }
        d.setOnItemLongClickListener(new q() {

            final x a;

            public boolean a(AdapterView adapterview, View view, int i1, long l1)
            {
                adapterview = com.cyberlink.youcammakeup.widgetpool.panel.c.x.a(a).b(i1);
                if (com.cyberlink.youcammakeup.widgetpool.panel.c.x.a(a).d())
                {
                    com.cyberlink.youcammakeup.widgetpool.panel.c.x.e(a).setChoiceMode(1);
                    com.cyberlink.youcammakeup.widgetpool.panel.c.x.e(a).a(com.cyberlink.youcammakeup.widgetpool.panel.c.x.a(a).a(), true);
                    com.cyberlink.youcammakeup.widgetpool.panel.c.x.a(a).a(false);
                    com.cyberlink.youcammakeup.utility.o.c();
                    return true;
                }
                if (adapterview != null && adapterview.a())
                {
                    com.cyberlink.youcammakeup.widgetpool.panel.c.x.e(a).setChoiceMode(0);
                    com.cyberlink.youcammakeup.utility.o.b(a.getFragmentManager(), com.cyberlink.youcammakeup.widgetpool.panel.c.x.e(a), x.f(a));
                    com.cyberlink.youcammakeup.widgetpool.panel.c.x.a(a).a(true);
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                a = x.this;
                super();
            }
        });
    }

    private void j()
    {
        if (g != null)
        {
            g.setOnTouchListener(null);
        }
        h = null;
    }

    private boolean k()
    {
label0:
        {
            if (e == null || e.a() <= 0 || !com.cyberlink.youcammakeup.widgetpool.panel.c.p.a().d())
            {
                break label0;
            }
            Object obj = e.b(e.a());
            if (obj == null || ((u) (obj)).g() == null)
            {
                break label0;
            }
            obj = ((u) (obj)).g().m();
            if (obj != null && ((List) (obj)).isEmpty())
            {
                return true;
            }
            obj = ((List) (obj)).iterator();
            ao ao1;
            BeautyMode beautymode;
            do
            {
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break label0;
                    }
                    ao1 = (ao)((Iterator) (obj)).next();
                    beautymode = ao1.a();
                } while (beautymode != BeautyMode.l && beautymode != BeautyMode.m && beautymode != BeautyMode.n && beautymode != BeautyMode.a && beautymode != BeautyMode.v);
                if (ao1.b() != null && !ao1.b().equalsIgnoreCase(com.cyberlink.youcammakeup.widgetpool.panel.c.p.a().a(beautymode)))
                {
                    return true;
                }
                if (beautymode == BeautyMode.n && com.cyberlink.youcammakeup.widgetpool.panel.c.p.a().c() != null && ao1.c() != null && !ao1.c().equalsIgnoreCase(com.cyberlink.youcammakeup.widgetpool.panel.c.p.a().c().a))
                {
                    return true;
                }
            } while (beautymode == BeautyMode.n || ao1.f() == null || ao1.f().isEmpty() || ao1.f().get(0) == null || ((at)ao1.f().get(0)).equals(com.cyberlink.youcammakeup.widgetpool.panel.c.p.a().c(beautymode)));
            return true;
        }
        return false;
    }

    public void a()
    {
        if (getActivity() != null)
        {
            f();
        }
    }

    public void a(Fragment fragment)
    {
    }

    public void a(com.cyberlink.youcammakeup.widgetpool.ICameraPanel.FlingDirection flingdirection)
    {
        if (e != null && !CameraActivity.k()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int j1 = e.a();
        if (flingdirection != com.cyberlink.youcammakeup.widgetpool.ICameraPanel.FlingDirection.a) goto _L4; else goto _L3
_L3:
        int i1 = j1 + 1;
_L5:
        j1 = i1;
        if (i1 < 1)
        {
            j1 = e.getCount() - 1;
        }
        if (j1 >= e.getCount())
        {
            i1 = 1;
        } else
        {
            i1 = j1;
        }
        if (i1 != e.a())
        {
            e.a(i1);
            d.a(i1, true);
            if (d.getChildAt(i1 - d.getFirstVisiblePosition()) != null)
            {
                d.d(i1, 200);
            } else
            {
                d.c(i1);
            }
            YMKLiveCamEvent.c(e.b(i1).g().c());
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKLiveCamEvent(true, 0L, 0L, com.cyberlink.youcammakeup.clflurry.YMKLiveCamEvent.Operation.c, true, false));
            a(e.b(i1).g());
            flingdirection = e.b(i1);
            if (flingdirection != null && flingdirection.e())
            {
                b(flingdirection.g().b());
            }
            flingdirection.a(false);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
        if (flingdirection == com.cyberlink.youcammakeup.widgetpool.ICameraPanel.FlingDirection.b)
        {
            i1 = j1 - 1;
        } else
        {
            i1 = j1;
            if (flingdirection == com.cyberlink.youcammakeup.widgetpool.ICameraPanel.FlingDirection.c)
            {
                i1 = j1;
            }
        }
          goto _L5
    }

    public void a(Long long1, boolean flag)
    {
    }

    public void b()
    {
    }

    public void c()
    {
        getActivity().finish();
    }

    public Long d()
    {
        return null;
    }

    public void e()
    {
        if (e != null && e.d())
        {
            com.cyberlink.youcammakeup.utility.o.c();
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        h();
        i();
        if (LiveDemoConfigHelper.h().d())
        {
            d.setVisibility(4);
            g();
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        c = layoutinflater.inflate(0x7f030183, viewgroup, false);
        if (h == null)
        {
            h = new Handler();
        }
        return c;
    }

    public void onDestroyView()
    {
        j();
        if (LiveDemoConfigHelper.h().d())
        {
            a.quit();
        }
        super.onDestroyView();
    }

    public void onResume()
    {
        super.onResume();
        String s = cc.a();
        if (cc.d(s))
        {
            s = cc.e(s);
            cc.b();
            com.cyberlink.youcammakeup.utility.o.a(getActivity(), new com.cyberlink.youcammakeup.widgetpool.dialogs.e(s), "CongratulationUnlockDialog");
        }
        if (e != null)
        {
            e.notifyDataSetChanged();
        }
    }

    public void onStart()
    {
        super.onStart();
        if (e.b())
        {
            if (i == null)
            {
                int i1 = e.a();
                if (i1 >= 2)
                {
                    i = new com.cyberlink.youcammakeup.widgetpool.panel.c.y(e.b(i1).g().a(), false);
                }
            }
            e.c();
        }
        Globals.d(k);
    }
}
