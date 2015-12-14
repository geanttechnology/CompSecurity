// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;
import com.cyberlink.youcammakeup.BaseActivity;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.a;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.activity.EditViewActivityForIntent;
import com.cyberlink.youcammakeup.activity.LauncherActivity;
import com.cyberlink.youcammakeup.clflurry.YMKClicksSaveMyLookEvent;
import com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierManager;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierTaskInfo;
import com.cyberlink.youcammakeup.kernelctrl.ar;
import com.cyberlink.youcammakeup.kernelctrl.collageComposer.CollageLayout;
import com.cyberlink.youcammakeup.kernelctrl.collageComposer.e;
import com.cyberlink.youcammakeup.kernelctrl.collageComposer.v;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.k;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.m;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.o;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.u;
import com.cyberlink.youcammakeup.kernelctrl.f;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.status.SessionState;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.d;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.pages.editview.savemylook.b;
import com.cyberlink.youcammakeup.pages.editview.savemylook.c;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.MakeupMode;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.SoftInputUtils;
import com.cyberlink.youcammakeup.utility.aa;
import com.cyberlink.youcammakeup.utility.aq;
import com.cyberlink.youcammakeup.utility.as;
import com.cyberlink.youcammakeup.utility.bl;
import com.cyberlink.youcammakeup.utility.bo;
import com.cyberlink.youcammakeup.widgetpool.collageBasicView.CollageTemplateSource;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.cyberlink.youcammakeup.widgetpool.touchview.TouchImageView;
import com.idunnololz.widgets.AnimatedExpandableListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            ae, af, w, aa, 
//            ab

public class ah extends a
    implements f
{

    public static final UUID a = UUID.randomUUID();
    public static boolean b = false;
    public static boolean c;
    private boolean A;
    private android.widget.ExpandableListView.OnGroupClickListener B;
    private android.view.View.OnClickListener C;
    private android.view.View.OnClickListener D;
    private android.view.View.OnClickListener E;
    private android.view.View.OnClickListener F;
    private android.content.DialogInterface.OnKeyListener G;
    private View d;
    private View e;
    private View f;
    private View g;
    private Bitmap h;
    private Bitmap i;
    private TouchImageView j;
    private TouchImageView k;
    private AnimatedExpandableListView l;
    private b m;
    private String n;
    private String o;
    private TextView p;
    private CollageLayout q;
    private View r;
    private View s;
    private View t;
    private List u;
    private ae v;
    private BitmapDrawable w;
    private boolean x;
    private com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.v y;
    private boolean z;

    public ah()
    {
        B = new android.widget.ExpandableListView.OnGroupClickListener() {

            final ah a;

            public boolean onGroupClick(ExpandableListView expandablelistview, View view, int i1, long l1)
            {
                if (!ah.g(a))
                {
                    return true;
                }
                a.dismiss();
                com.cyberlink.youcammakeup.widgetpool.dialogs.ah.a(a, false);
                expandablelistview = (c)view.getTag();
                view = a.getActivity();
                if (view instanceof EditViewActivity)
                {
                    ((EditViewActivity)view).c(true);
                    ((EditViewActivity)view).a(BeautyMode.c(((c) (expandablelistview)).a), ((c) (expandablelistview)).a, ((c) (expandablelistview)).b);
                }
                com.cyberlink.youcammakeup.widgetpool.dialogs.ah.b = true;
                return true;
            }

            
            {
                a = ah.this;
                super();
            }
        };
        C = new android.view.View.OnClickListener() {

            final ah a;

            private void a()
            {
                if (com.cyberlink.youcammakeup.widgetpool.dialogs.ah.d(a) == null)
                {
                    long l1 = StatusManager.j().l();
                    MotionControlHelper.e().b(StatusManager.j().f(l1));
                }
                a.dismissAllowingStateLoss();
                byte byte0;
                if (StatusManager.j().r() == MakeupMode.a)
                {
                    byte byte1 = 8;
                    Activity activity = a.getActivity();
                    byte0 = byte1;
                    if (activity instanceof EditViewActivity)
                    {
                        if (com.cyberlink.youcammakeup.widgetpool.dialogs.ah.d(a) != null)
                        {
                            ah.h(a);
                            ((EditViewActivity)activity).a(MakeupMode.a, BeautyMode.D, com.cyberlink.youcammakeup.widgetpool.dialogs.ah.d(a));
                        } else
                        if (com.cyberlink.youcammakeup.widgetpool.dialogs.ah.e(a).isEnabled())
                        {
                            ((EditViewActivity)activity).n();
                        }
                        ((EditViewActivity)activity).c(false);
                        byte0 = byte1;
                    }
                } else
                {
                    byte0 = 0;
                }
                StatusManager.j().a(-1, -1, -1, -1, -1, -1, byte0, -1);
            }

            static void a(_cls12 _pcls12)
            {
                _pcls12.a();
            }

            public void onClick(View view)
            {
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKClicksSaveMyLookEvent(com.cyberlink.youcammakeup.clflurry.YMKClicksSaveMyLookEvent.ButtonName.a));
                if (com.cyberlink.youcammakeup.widgetpool.dialogs.ah.e(a).getVisibility() != 0 || !com.cyberlink.youcammakeup.widgetpool.dialogs.ah.e(a).isEnabled())
                {
                    a();
                    return;
                } else
                {
                    Globals.d().i().a(a.getActivity(), 0x7f0705fc, new w(this) {

                        final _cls12 a;

                        public void a(boolean flag)
                        {
                            com.cyberlink.youcammakeup.widgetpool.dialogs._cls12.a(a);
                        }

                        public void b(boolean flag)
                        {
                        }

            
            {
                a = _pcls12;
                super();
            }
                    });
                    return;
                }
            }

            
            {
                a = ah.this;
                super();
            }
        };
        D = new android.view.View.OnClickListener() {

            final ah a;

            public void onClick(View view)
            {
                view = (new Intent(a.getActivity(), com/cyberlink/youcammakeup/activity/LauncherActivity)).setFlags(0x4000000);
                a.startActivity(view);
                a.getActivity().finish();
            }

            
            {
                a = ah.this;
                super();
            }
        };
        E = new android.view.View.OnClickListener() {

            final ah a;

            public void onClick(View view)
            {
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKClicksSaveMyLookEvent(com.cyberlink.youcammakeup.clflurry.YMKClicksSaveMyLookEvent.ButtonName.d));
                view = new Runnable(this) {

                    final _cls2 a;

                    public void run()
                    {
                        Activity activity = a.a.getActivity();
                        if (activity instanceof EditViewActivity)
                        {
                            ah.h(a.a);
                            ((EditViewActivity)activity).a(MakeupMode.a, BeautyMode.D, com.cyberlink.youcammakeup.widgetpool.dialogs.ah.d(a.a));
                        }
                        a.a.dismiss();
                    }

            
            {
                a = _pcls2;
                super();
            }
                };
                com.cyberlink.youcammakeup.widgetpool.dialogs.ah.i(a).post(view);
                StatusManager.j().a(-1, -1, -1, -1, -1, -1, 8, -1);
            }

            
            {
                a = ah.this;
                super();
            }
        };
        F = new android.view.View.OnClickListener() {

            final ah a;

            public void onClick(View view)
            {
                Object obj = null;
                if (!ah.g(a))
                {
                    return;
                }
                com.cyberlink.youcammakeup.widgetpool.dialogs.ah.a(a, false);
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKClicksSaveMyLookEvent(com.cyberlink.youcammakeup.clflurry.YMKClicksSaveMyLookEvent.ButtonName.b));
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKSavingPageEvent(0L, 0L, com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.Operation.d, false, false));
                int i1 = com.cyberlink.youcammakeup.kernelctrl.z.b("KEY_SAVE_COUNT", 1, a.getActivity());
                as as1;
                if (ah.j(a) != null)
                {
                    as1 = PanelDataCenter.a().o(ah.j(a));
                } else
                {
                    as1 = null;
                }
                if (as1 == null || as1.f() != com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.c)
                {
                    com.cyberlink.youcammakeup.widgetpool.dialogs.ah.a(a, null);
                    obj = PanelDataCenter.a().a(com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.c);
                    do
                    {
                        int j1;
                        if (i1 < 10)
                        {
                            view = (new StringBuilder()).append('0').append(String.valueOf(i1)).toString();
                        } else
                        {
                            view = String.valueOf(i1);
                        }
                        j1 = i1 + 1;
                        i1 = j1;
                    } while (((List) (obj)).contains(view));
                    i1 = j1;
                } else
                {
                    view = null;
                }
                obj = new bl(this, i1, new aq(this) {

                    final _cls3 a;

                    public void a(Exception exception)
                    {
                        com.pf.common.utility.m.e("SaveMyLookDialog", exception.toString());
                    }

                    public volatile void a(Object obj)
                    {
                        a((String)obj);
                    }

                    public void a(String s1)
                    {
                        com.cyberlink.youcammakeup.widgetpool.dialogs.ah.b(a.a, s1);
                        a.a.getActivity().runOnUiThread(new Runnable(this) {

                            final _cls1 a;

                            public void run()
                            {
                                com.cyberlink.youcammakeup.widgetpool.dialogs.ah.i(a.a.a).setEnabled(true);
                                com.cyberlink.youcammakeup.widgetpool.dialogs.ah.i(a.a.a).setVisibility(0);
                                com.cyberlink.youcammakeup.widgetpool.dialogs.ah.e(a.a.a).setVisibility(8);
                                com.cyberlink.youcammakeup.widgetpool.dialogs.ah.a(a.a.a, true);
                            }

            
            {
                a = _pcls1;
                super();
            }
                        });
                    }

            
            {
                a = _pcls3;
                super();
            }
                }, ((List) (obj))) {

                    final int a;
                    final aq b;
                    final List c;
                    final _cls3 d;

                    public com.cyberlink.youcammakeup.utility.SoftInputUtils.CheckResult a(String s1)
                    {
                        if (s1.equals(""))
                        {
                            return com.cyberlink.youcammakeup.utility.SoftInputUtils.CheckResult.a;
                        }
                        if (c != null && c.contains(s1))
                        {
                            return com.cyberlink.youcammakeup.utility.SoftInputUtils.CheckResult.b;
                        } else
                        {
                            return com.cyberlink.youcammakeup.utility.SoftInputUtils.CheckResult.c;
                        }
                    }

                    public String a()
                    {
                        return d.a.getString(0x7f070601);
                    }

                    public void a(Exception exception)
                    {
                        com.pf.common.utility.m.e("SaveMyLookDialog", exception.toString());
                        com.cyberlink.youcammakeup.widgetpool.dialogs.ah.a(d.a, true);
                    }

                    public void a(Object obj)
                    {
                        b((String)obj);
                    }

                    public String b()
                    {
                        return d.a.getString(0x7f0705fe);
                    }

                    public void b(String s1)
                    {
                        com.cyberlink.youcammakeup.widgetpool.dialogs.ah.e(d.a).setEnabled(false);
                        com.cyberlink.youcammakeup.kernelctrl.z.a("KEY_SAVE_COUNT", a, d.a.getActivity());
                        i i1 = com.cyberlink.youcammakeup.widgetpool.dialogs.ah.k(d.a).a();
                        PanelDataCenter.a().a(ah.j(d.a), s1, ah.l(d.a), i1, b);
                        s1 = StatusManager.j().d();
                        if (s1 != null)
                        {
                            s1.a(new com.cyberlink.youcammakeup.clflurry.as());
                        }
                    }

                    public String c()
                    {
                        return null;
                    }

            
            {
                d = _pcls3;
                a = i1;
                b = aq;
                c = list;
                super();
            }
                };
                if (as1 == null || as1.f() != com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.c)
                {
                    SoftInputUtils.a(a.getActivity(), a.getFragmentManager(), view, ((bl) (obj)));
                    return;
                } else
                {
                    PanelDataCenter.a().c(ah.j(a), false);
                    ((bl) (obj)).a(as1.b());
                    Toast.makeText(Globals.d(), a.getString(0x7f070601), 0).show();
                    return;
                }
            }

            
            {
                a = ah.this;
                super();
            }
        };
        G = new android.content.DialogInterface.OnKeyListener() {

            final ah a;

            public boolean onKey(DialogInterface dialoginterface, int i1, KeyEvent keyevent)
            {
                if (!com.cyberlink.youcammakeup.widgetpool.dialogs.ah.m(a).isEnabled())
                {
                    return true;
                }
                if (i1 == 4 && keyevent.getAction() == 1)
                {
                    com.cyberlink.youcammakeup.widgetpool.dialogs.ah.m(a).performClick();
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                a = ah.this;
                super();
            }
        };
    }

    static ae a(ah ah1)
    {
        return ah1.v;
    }

    static String a(ah ah1, String s1)
    {
        ah1.o = s1;
        return s1;
    }

    private void a(Bitmap bitmap)
    {
        if (bitmap == null)
        {
            bitmap = null;
            s.setVisibility(4);
            r.setEnabled(false);
        } else
        {
            bitmap = new BitmapDrawable(Globals.d().getResources(), bitmap);
            if (android.os.Build.VERSION.SDK_INT >= 16)
            {
                t.setBackground(bitmap);
            } else
            {
                t.setBackgroundDrawable(bitmap);
            }
            s.setVisibility(0);
            r.setEnabled(true);
        }
        w = bitmap;
        if (A && (getActivity() instanceof BaseActivity))
        {
            A = false;
            ((BaseActivity)getActivity()).i();
        }
    }

    static void a(ah ah1, Bitmap bitmap)
    {
        ah1.a(bitmap);
    }

    static void a(ah ah1, boolean flag)
    {
        ah1.a(flag);
    }

    private void a(boolean flag)
    {
        d.setClickable(flag);
        e.setClickable(flag);
        f.setClickable(flag);
        g.setClickable(flag);
    }

    static TouchImageView b(ah ah1)
    {
        return ah1.j;
    }

    static String b(ah ah1, String s1)
    {
        ah1.n = s1;
        return s1;
    }

    private void b(BeautifierTaskInfo beautifiertaskinfo)
    {
        long l1 = StatusManager.j().l();
        Object obj = StatusManager.j().c(l1);
        com.cyberlink.youcammakeup.kernelctrl.status.a a1 = ((d) (obj)).e();
        ar ar1 = (ar)a1.d().get(a1.e);
        obj = ((d) (obj)).g().b();
        if (obj == null || beautifiertaskinfo == null)
        {
            dismiss();
            return;
        }
        beautifiertaskinfo = beautifiertaskinfo.g();
        if (beautifiertaskinfo == null)
        {
            dismiss();
            return;
        } else
        {
            Bitmap bitmap = Bitmap.createBitmap((int)((ImageBufferWrapper) (obj)).b(), (int)((ImageBufferWrapper) (obj)).c(), android.graphics.Bitmap.Config.ARGB_8888);
            ((ImageBufferWrapper) (obj)).c(bitmap);
            ((ImageBufferWrapper) (obj)).m();
            h = aa.a(bitmap, ar1, a1.d, true);
            bitmap.recycle();
            obj = Bitmap.createBitmap((int)beautifiertaskinfo.b(), (int)beautifiertaskinfo.c(), android.graphics.Bitmap.Config.ARGB_8888);
            beautifiertaskinfo.c(((Bitmap) (obj)));
            beautifiertaskinfo.m();
            i = aa.a(((Bitmap) (obj)), ar1, a1.d, true);
            ((Bitmap) (obj)).recycle();
            j.setImageBitmap(h);
            k.setImageBitmap(i);
            j.setOnTouchListener(new android.view.View.OnTouchListener() {

                final ah a;

                public boolean onTouch(View view, MotionEvent motionevent)
                {
                    if (com.cyberlink.youcammakeup.widgetpool.dialogs.ah.b(a).a())
                    {
                        com.cyberlink.youcammakeup.widgetpool.dialogs.ah.c(a).a(motionevent, false);
                    }
                    return true;
                }

            
            {
                a = ah.this;
                super();
            }
            });
            k.setOnTouchListener(new android.view.View.OnTouchListener() {

                final ah a;

                public boolean onTouch(View view, MotionEvent motionevent)
                {
                    if (com.cyberlink.youcammakeup.widgetpool.dialogs.ah.c(a).a())
                    {
                        com.cyberlink.youcammakeup.widgetpool.dialogs.ah.b(a).a(motionevent, false);
                    }
                    return true;
                }

            
            {
                a = ah.this;
                super();
            }
            });
            return;
        }
    }

    public static boolean b()
    {
        i i1 = StatusManager.j().d();
        if (i1 == null)
        {
            return false;
        }
        if (i1.b() != null)
        {
            return true;
        }
        if (i1.a() != null)
        {
            return true;
        }
        if (i1.e() != null)
        {
            return true;
        }
        if (i1.f() != null)
        {
            return true;
        }
        if (i1.h() != null)
        {
            return true;
        }
        if (i1.g() != null)
        {
            return true;
        }
        if (i1.i() != null)
        {
            return true;
        }
        if (i1.c() != null && !"default_original_eye_contact".equals(i1.c().b()))
        {
            return true;
        }
        if (i1.u() != null && !"default_original_wig".equals(i1.u().b()))
        {
            return true;
        }
        if (i1.d() != null && !"default_original_double_eyelid".equalsIgnoreCase(i1.d().a()))
        {
            return true;
        }
        return i1.D() != null && i1.D().a().size() > 0 && !"default_original_face_art".equalsIgnoreCase((String)i1.D().a().get(0));
    }

    static TouchImageView c(ah ah1)
    {
        return ah1.k;
    }

    private void c()
    {
        i i1;
        long l1;
        l1 = StatusManager.j().l();
        i1 = StatusManager.j().d();
        x = true;
        BeautifierManager.a().a(this);
        y = MotionControlHelper.e().M();
        if (m == null) goto _L2; else goto _L1
_L1:
        i1 = m.a();
_L4:
        MotionControlHelper motioncontrolhelper = MotionControlHelper.e();
        motioncontrolhelper.n();
        if (!motioncontrolhelper.j())
        {
            motioncontrolhelper.b(StatusManager.j().f(l1));
        }
        BeautifierTaskInfo beautifiertaskinfo = new BeautifierTaskInfo(false, false, false, true);
        beautifiertaskinfo.a("SaveMyLookDialog", com.cyberlink.youcammakeup.kernelctrl.BeautifierTaskInfo.ResultBufferType.a);
        motioncontrolhelper.a(i1, beautifiertaskinfo);
        return;
_L2:
        i j1 = new i(i1);
        j1.a(null);
        j1.a(null);
        j1.a(null);
        j1.a(null);
        j1.a(null);
        i1 = j1;
        if (j1.d() != null)
        {
            i1 = j1;
            if (j1.d().a() != null)
            {
                i1 = j1;
                if (j1.d().a().equalsIgnoreCase("default_original_double_eyelid"))
                {
                    j1.a(null);
                    i1 = j1;
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static String d(ah ah1)
    {
        return ah1.n;
    }

    private void d()
    {
        if (aa.b(h))
        {
            ImageBufferWrapper imagebufferwrapper = new ImageBufferWrapper();
            imagebufferwrapper.a(h);
            ViewEngine.a().a(-10L, imagebufferwrapper);
            imagebufferwrapper.m();
        }
        if (aa.b(i))
        {
            ImageBufferWrapper imagebufferwrapper1 = new ImageBufferWrapper();
            imagebufferwrapper1.a(i);
            ViewEngine.a().a(-11L, imagebufferwrapper1);
            imagebufferwrapper1.m();
        }
        ArrayList arraylist = new ArrayList();
        arraylist.add(Long.valueOf(-10L));
        arraylist.add(Long.valueOf(-11L));
        StatusManager.j().a(arraylist, a);
    }

    static View e(ah ah1)
    {
        return ah1.f;
    }

    private void e()
    {
        if (u == null || u.size() <= 0)
        {
            return;
        }
        Object obj = (com.cyberlink.youcammakeup.widgetpool.collageBasicView.a)u.get(0);
        obj = (new v(getActivity())).a(((com.cyberlink.youcammakeup.widgetpool.collageBasicView.a) (obj)).a, ((com.cyberlink.youcammakeup.widgetpool.collageBasicView.a) (obj)).b);
        if (obj == null)
        {
            a(((Bitmap) (null)));
            return;
        }
        try
        {
            q.a(((com.cyberlink.youcammakeup.kernelctrl.collageComposer.o) (obj)), false);
        }
        catch (OutOfMemoryError outofmemoryerror)
        {
            outofmemoryerror.printStackTrace();
            if (getActivity() != null)
            {
                getActivity().runOnUiThread(new Runnable() {

                    final ah a;

                    public void run()
                    {
                        com.cyberlink.youcammakeup.utility.o.a(a.getActivity());
                        com.cyberlink.youcammakeup.widgetpool.dialogs.aa aa1 = new com.cyberlink.youcammakeup.widgetpool.dialogs.aa(a.getActivity());
                        aa1.a(new ab(this) {

                            final _cls9 a;

                            public void a()
                            {
                                Object obj;
                                byte byte0;
                                if (com.cyberlink.youcammakeup.widgetpool.dialogs.ah.d(a.a) == null)
                                {
                                    long l1 = StatusManager.j().l();
                                    MotionControlHelper.e().b(StatusManager.j().f(l1));
                                }
                                a.a.dismissAllowingStateLoss();
                                obj = StatusManager.j().r();
                                byte0 = 0;
                                if (obj != MakeupMode.a) goto _L2; else goto _L1
_L1:
                                byte byte1;
                                byte1 = 8;
                                obj = a.a.getActivity();
                                byte0 = byte1;
                                if (!(obj instanceof EditViewActivity)) goto _L2; else goto _L3
_L3:
                                if (com.cyberlink.youcammakeup.widgetpool.dialogs.ah.d(a.a) == null) goto _L5; else goto _L4
_L4:
                                ((EditViewActivity)obj).a(MakeupMode.a, BeautyMode.D, com.cyberlink.youcammakeup.widgetpool.dialogs.ah.d(a.a));
                                byte0 = byte1;
_L2:
                                StatusManager.j().a(-1, -1, -1, -1, -1, -1, byte0, -1);
                                return;
_L5:
                                byte0 = byte1;
                                if (com.cyberlink.youcammakeup.widgetpool.dialogs.ah.e(a.a).isEnabled())
                                {
                                    ((EditViewActivity)obj).n();
                                    byte0 = byte1;
                                }
                                if (true) goto _L2; else goto _L6
_L6:
                            }

            
            {
                a = _pcls9;
                super();
            }
                        });
                        aa1.show();
                    }

            
            {
                a = ah.this;
                super();
            }
                });
                return;
            }
        }
        q.e();
        (new AsyncTask() {

            final ah a;

            protected transient Boolean a(Void avoid[])
            {
                float f2 = 1.0F;
                avoid = Globals.d().e();
                float f1 = f2;
                if (avoid != null)
                {
                    f1 = f2;
                    if (avoid.intValue() < 0xc3500)
                    {
                        f1 = 0.66F;
                        avoid = com.cyberlink.youcammakeup.widgetpool.dialogs.ah.f(a).getTemplate();
                        if (avoid != null)
                        {
                            f1 = 1024F / (float)((com.cyberlink.youcammakeup.kernelctrl.collageComposer.o) (avoid)).i;
                            float f3 = 1024F / (float)((com.cyberlink.youcammakeup.kernelctrl.collageComposer.o) (avoid)).j;
                            class a
                                implements com.cyberlink.youcammakeup.kernelctrl.collageComposer.i
                            {

                                final _cls10 a;

                                public void a()
                                {
                                    com.pf.common.utility.m.e("rendering", "onCancel");
                                    com.cyberlink.youcammakeup.widgetpool.dialogs.ah.f(a.a).a();
                                    com.cyberlink.youcammakeup.widgetpool.dialogs.ah.a(a.a, null);
                                }

                                public void a(Bitmap bitmap)
                                {
                                    com.cyberlink.youcammakeup.widgetpool.dialogs.ah.f(a.a).a();
                                    com.cyberlink.youcammakeup.widgetpool.dialogs.ah.a(a.a, bitmap);
                                }

                                public void a(String s1)
                                {
                                    com.pf.common.utility.m.e("rendering", (new StringBuilder()).append("onError: ").append(s1).toString());
                                    com.cyberlink.youcammakeup.widgetpool.dialogs.ah.f(a.a).a();
                                    com.cyberlink.youcammakeup.widgetpool.dialogs.ah.a(a.a, null);
                                }

            a(_cls10 _pcls10)
            {
                a = _pcls10;
                super();
            }
                            }

                            if (f1 >= f3)
                            {
                                f1 = f3;
                            }
                        }
                    }
                }
                try
                {
                    com.cyberlink.youcammakeup.kernelctrl.collageComposer.e.a().a(a.getActivity(), com.cyberlink.youcammakeup.widgetpool.dialogs.ah.f(a), f1, new a(this));
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    com.pf.common.utility.m.b("SaveMyLookDialog", "generateCollageThumb", avoid);
                    return Boolean.valueOf(false);
                }
                return Boolean.valueOf(true);
            }

            protected void a(Boolean boolean1)
            {
                if (!boolean1.booleanValue())
                {
                    com.cyberlink.youcammakeup.widgetpool.dialogs.ah.f(a).a();
                    com.cyberlink.youcammakeup.widgetpool.dialogs.ah.a(a, null);
                }
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            protected void onPostExecute(Object obj1)
            {
                a((Boolean)obj1);
            }

            
            {
                a = ah.this;
                super();
            }
        }).execute(new Void[0]);
    }

    static CollageLayout f(ah ah1)
    {
        return ah1.q;
    }

    private void f()
    {
        StatusManager.j().a(null, a);
        ViewEngine.a().b(-10L, false);
        ViewEngine.a().b(-11L, false);
    }

    private void g()
    {
        Activity activity;
        com.cyberlink.youcammakeup.kernelctrl.status.a a1;
        if (n != null)
        {
            if ((activity = getActivity()) != null && (activity instanceof EditViewActivity) && ((a1 = ((EditViewActivity)activity).r()) != null && a1.f() != null && a1.f().g() != null))
            {
                ((EditViewActivity)activity).a(false, a1);
                return;
            }
        }
    }

    static boolean g(ah ah1)
    {
        return ah1.h();
    }

    static void h(ah ah1)
    {
        ah1.g();
    }

    private boolean h()
    {
        return d.isClickable() && e.isClickable() && f.isClickable() && g.isClickable();
    }

    static View i(ah ah1)
    {
        return ah1.g;
    }

    private void i()
    {
        BeautifierManager.a().b(this);
        StatusManager.j().a(Boolean.valueOf(true));
        if (y != null)
        {
            BeautifierEditCenter.a().a(y.f(), true);
        }
        (new AsyncTask() {

            final ah a;

            protected transient Void a(Void avoid[])
            {
                avoid = a.getActivity();
                if (avoid == null || !(avoid instanceof EditViewActivity) || !((EditViewActivity)avoid).q())
                {
                    MotionControlHelper.e().t();
                    MotionControlHelper.e().s();
                    MotionControlHelper.e().a(BeautyMode.j, true);
                    MotionControlHelper.e().a(BeautyMode.k, true);
                }
                return null;
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            
            {
                a = ah.this;
                super();
            }
        }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        x = false;
    }

    static String j(ah ah1)
    {
        return ah1.o;
    }

    static b k(ah ah1)
    {
        return ah1.m;
    }

    static Bitmap l(ah ah1)
    {
        return ah1.i;
    }

    static View m(ah ah1)
    {
        return ah1.d;
    }

    public void a(BeautifierTaskInfo beautifiertaskinfo)
    {
        if (beautifiertaskinfo == null || beautifiertaskinfo.e() == null || !beautifiertaskinfo.e().equalsIgnoreCase("SaveMyLookDialog"))
        {
            return;
        } else
        {
            i();
            b(beautifiertaskinfo);
            d();
            e();
            return;
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        z = true;
        bundle = getView();
        d = bundle.findViewById(0x7f0c06d2);
        e = bundle.findViewById(0x7f0c06d3);
        f = bundle.findViewById(0x7f0c06da);
        g = bundle.findViewById(0x7f0c06d9);
        j = (TouchImageView)bundle.findViewById(0x7f0c06d6);
        k = (TouchImageView)bundle.findViewById(0x7f0c06d7);
        l = (AnimatedExpandableListView)bundle.findViewById(0x7f0c06d8);
        p = (TextView)bundle.findViewById(0x7f0c06d4);
        q = new CollageLayout(getActivity());
        s = bundle.findViewById(0x7f0c06dc);
        t = bundle.findViewById(0x7f0c06dd);
        d.setOnClickListener(C);
        f.setOnClickListener(F);
        g.setOnClickListener(E);
        e.setOnClickListener(D);
        Object obj = f;
        boolean flag;
        if (getArguments() == null)
        {
            flag = false;
        } else
        {
            flag = getArguments().getBoolean("BUNDLE_KEY_ENABLE_SAVE_BUTTON", false);
        }
        ((View) (obj)).setEnabled(flag);
        g.setEnabled(false);
        g.setVisibility(8);
        r = bundle.findViewById(0x7f0c06db);
        if (com.cyberlink.youcammakeup.kernelctrl.z.a("BEFORE_AFTER_COLLAGE_DOWNLOADED", false, Globals.d().getApplicationContext()))
        {
            CollageTemplateSource.a().b();
            u = (List)((HashMap)CollageTemplateSource.a().b.get(com.cyberlink.youcammakeup.widgetpool.collageBasicView.CollageTemplateSource.ItemType.b)).get(Integer.valueOf(2));
            u.addAll((Collection)((HashMap)CollageTemplateSource.a().a.get(com.cyberlink.youcammakeup.widgetpool.collageBasicView.CollageTemplateSource.ItemType.a)).get(Integer.valueOf(2)));
        } else
        {
            if (NetworkManager.e())
            {
                CollageTemplateSource.a().b();
                u = (List)((HashMap)CollageTemplateSource.a().b.get(com.cyberlink.youcammakeup.widgetpool.collageBasicView.CollageTemplateSource.ItemType.b)).get(Integer.valueOf(2));
            }
            u = (List)((HashMap)CollageTemplateSource.a().a.get(com.cyberlink.youcammakeup.widgetpool.collageBasicView.CollageTemplateSource.ItemType.a)).get(Integer.valueOf(2));
        }
        v = new ae(u);
        v.a(false);
        v.a(new af() {

            final ah a;

            public void a(Bitmap bitmap)
            {
                com.cyberlink.youcammakeup.widgetpool.dialogs.ah.a(a, bitmap);
            }

            
            {
                a = ah.this;
                super();
            }
        });
        bundle = new android.view.View.OnClickListener() {

            final ah a;
            private boolean b;

            static boolean a(_cls6 _pcls6, boolean flag1)
            {
                _pcls6.b = flag1;
                return flag1;
            }

            public void onClick(View view)
            {
                if (!b)
                {
                    return;
                } else
                {
                    b = false;
                    com.cyberlink.youcammakeup.clflurry.b.a(new YMKClicksSaveMyLookEvent(com.cyberlink.youcammakeup.clflurry.YMKClicksSaveMyLookEvent.ButtonName.c));
                    com.cyberlink.youcammakeup.widgetpool.dialogs.ah.a(a).a(new android.content.DialogInterface.OnDismissListener(this) {

                        final _cls6 a;

                        public void onDismiss(DialogInterface dialoginterface)
                        {
                            com.cyberlink.youcammakeup.widgetpool.dialogs._cls6.a(a, true);
                        }

            
            {
                a = _pcls6;
                super();
            }
                    });
                    com.cyberlink.youcammakeup.utility.o.a(a.getFragmentManager(), com.cyberlink.youcammakeup.widgetpool.dialogs.ah.a(a), "SaveMyLookCollageShareDialog");
                    return;
                }
            }

            
            {
                a = ah.this;
                super();
                b = true;
            }
        };
        r.setOnClickListener(bundle);
        r.setEnabled(false);
        s.setOnClickListener(bundle);
        s.setVisibility(4);
        if (getActivity() instanceof EditViewActivityForIntent)
        {
            e.setVisibility(8);
        }
        getDialog().setOnKeyListener(G);
        getDialog().getWindow().setSoftInputMode(48);
        m = new b(StatusManager.j().d());
        l.setOnGroupClickListener(B);
        l.setAdapter(m);
        if (getArguments() == null)
        {
            bundle = null;
        } else
        {
            bundle = getArguments().getString("BUNDLE_KEY_LOOK_GUID");
        }
        o = bundle;
        c = f.isEnabled();
        b = false;
        obj = p;
        if (o == null)
        {
            bundle = getString(0x7f0705f9);
        } else
        {
            bundle = bo.z(o).b();
        }
        ((TextView) (obj)).setText(bundle);
        c();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f03018f, viewgroup);
    }

    public void onDestroyView()
    {
        u = null;
        q.a();
        if (v != null)
        {
            v.b();
        }
        f();
        if (h != null)
        {
            h.recycle();
            h = null;
        }
        if (i != null)
        {
            i.recycle();
            i = null;
        }
        if (w != null)
        {
            aa.a(w);
        }
        if (x)
        {
            i();
        }
        if (A && (getActivity() instanceof BaseActivity))
        {
            A = false;
            ((BaseActivity)getActivity()).i();
        }
        super.onDestroyView();
    }

    public void onResume()
    {
        super.onResume();
    }

    public void onStart()
    {
        super.onStart();
        if (z && (getActivity() instanceof BaseActivity))
        {
            z = false;
            A = true;
            ((BaseActivity)getActivity()).a(0L, MakeupMode.g);
        }
    }

}
