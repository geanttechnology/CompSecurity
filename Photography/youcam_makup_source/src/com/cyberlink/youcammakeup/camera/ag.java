// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.a;
import com.cyberlink.youcammakeup.activity.CameraActivity;
import com.cyberlink.youcammakeup.activity.LauncherActivity;
import com.cyberlink.youcammakeup.c;
import com.cyberlink.youcammakeup.clflurry.YMKLiveCamEvent;
import com.cyberlink.youcammakeup.clflurry.YMKResultPageEvent;
import com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent;
import com.cyberlink.youcammakeup.clflurry.YMKShareToEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.database.n;
import com.cyberlink.youcammakeup.database.o;
import com.cyberlink.youcammakeup.database.p;
import com.cyberlink.youcammakeup.flurry.PhotoSavePageClickEvent;
import com.cyberlink.youcammakeup.g;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.DevelopSetting;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.e;
import com.cyberlink.youcammakeup.kernelctrl.status.SessionState;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.d;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.pages.moreview.af;
import com.cyberlink.youcammakeup.pages.shareview.ShareItemAdapter;
import com.cyberlink.youcammakeup.utility.al;
import com.cyberlink.youcammakeup.utility.bd;
import com.cyberlink.youcammakeup.widgetpool.dialogs.ad;
import com.cyberlink.youcammakeup.widgetpool.dialogs.ae;
import com.cyberlink.youcammakeup.widgetpool.dialogs.ai;
import java.util.ArrayList;
import java.util.UUID;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            o

public class ag extends a
{

    public static final UUID a = UUID.randomUUID();
    private FrameLayout A;
    private View B;
    private long C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private com.cyberlink.youcammakeup.a.a H;
    private android.view.View.OnClickListener I;
    private android.view.View.OnClickListener J;
    private android.view.View.OnClickListener K;
    private android.view.View.OnClickListener L;
    private ShareItemAdapter b;
    private View c;
    private TextView d;
    private TextView e;
    private boolean f;
    private View g;
    private View h;
    private View i;
    private View j;
    private ImageView k;
    private View l;
    private TextView m;
    private TextView n;
    private View o;
    private TextView p;
    private View q;
    private TextView r;
    private TextView s;
    private View t;
    private View u;
    private TextView v;
    private View w;
    private View x;
    private View y;
    private View z;

    public ag()
    {
        f = true;
        C = 0L;
        D = false;
        E = false;
        F = false;
        G = false;
        H = null;
        I = new android.view.View.OnClickListener() {

            final ag a;

            public void onClick(View view)
            {
                if (!com.cyberlink.youcammakeup.camera.ag.a(a))
                {
                    return;
                }
                com.cyberlink.youcammakeup.camera.ag.a(a, false);
                com.cyberlink.youcammakeup.flurry.a.a(new PhotoSavePageClickEvent(com.cyberlink.youcammakeup.flurry.PhotoSavePageClickEvent.ButtonName.f));
                view = a.b();
                if (view != null)
                {
                    ArrayList arraylist = new ArrayList();
                    arraylist.add(view);
                    com.cyberlink.youcammakeup.camera.ag.d(a).a(com.cyberlink.youcammakeup.kernelctrl.ShareActionProvider.ShareActionType.b, arraylist);
                }
                com.cyberlink.youcammakeup.camera.ag.a(a, true);
            }

            
            {
                a = ag.this;
                super();
            }
        };
        J = new android.view.View.OnClickListener() {

            final ag a;

            public void onClick(View view)
            {
                if (!com.cyberlink.youcammakeup.camera.ag.a(a))
                {
                    return;
                }
                com.cyberlink.youcammakeup.camera.ag.a(a, false);
                if (al.a("com.perfectcorp.ycn"))
                {
                    com.cyberlink.youcammakeup.clflurry.b.a(new YMKResultPageEvent(com.cyberlink.youcammakeup.clflurry.YMKResultPageEvent.Operation.h, YMKResultPageEvent.b, System.currentTimeMillis()));
                    al.a(a.getActivity(), "com.perfectcorp.ycn");
                } else
                {
                    com.cyberlink.youcammakeup.clflurry.b.a(new YMKResultPageEvent(com.cyberlink.youcammakeup.clflurry.YMKResultPageEvent.Operation.i, YMKResultPageEvent.b, System.currentTimeMillis()));
                    bd.a(a.getActivity(), "com.perfectcorp.ycn", "ymk", "sharepagedialog");
                }
                com.cyberlink.youcammakeup.camera.ag.a(a, true);
            }

            
            {
                a = ag.this;
                super();
            }
        };
        K = new android.view.View.OnClickListener() {

            final ag a;

            public void onClick(View view)
            {
                if (!com.cyberlink.youcammakeup.camera.ag.a(a))
                {
                    return;
                } else
                {
                    com.cyberlink.youcammakeup.camera.ag.a(a, false);
                    view.setEnabled(false);
                    com.cyberlink.youcammakeup.flurry.a.a(new PhotoSavePageClickEvent(com.cyberlink.youcammakeup.flurry.PhotoSavePageClickEvent.ButtonName.e));
                    com.cyberlink.youcammakeup.clflurry.b.a(new YMKResultPageEvent(com.cyberlink.youcammakeup.clflurry.YMKResultPageEvent.Operation.g, YMKResultPageEvent.b, System.currentTimeMillis()));
                    ae ae1 = new ae(null);
                    ae1.a(new android.content.DialogInterface.OnDismissListener(this, view) {

                        final View a;
                        final _cls8 b;

                        public void onDismiss(DialogInterface dialoginterface)
                        {
                            YMKResultPageEvent.b = System.currentTimeMillis();
                            a.setEnabled(true);
                            com.cyberlink.youcammakeup.camera.ag.a(b.a, true);
                        }

            
            {
                b = _pcls8;
                a = view;
                super();
            }
                    });
                    com.cyberlink.youcammakeup.utility.o.a(a.getFragmentManager(), ae1, "SaveMyLookCollageShareDialog");
                    return;
                }
            }

            
            {
                a = ag.this;
                super();
            }
        };
        L = new android.view.View.OnClickListener() {

            final ag a;

            public void onClick(View view)
            {
                a.dismiss();
            }

            
            {
                a = ag.this;
                super();
            }
        };
    }

    static boolean a(ag ag1)
    {
        return ag1.f;
    }

    static boolean a(ag ag1, boolean flag)
    {
        ag1.f = flag;
        return flag;
    }

    static void b(ag ag1)
    {
        ag1.f();
    }

    static long c(ag ag1)
    {
        return ag1.C;
    }

    static ShareItemAdapter d(ag ag1)
    {
        return ag1.b;
    }

    private void d()
    {
        if (H != null)
        {
            H.e();
            H.b();
        }
    }

    private void e()
    {
        G = false;
        y.setVisibility(8);
        z.setVisibility(0);
        F = true;
        o.setClickable(F);
        t.setClickable(F);
        x.setClickable(F);
        j.setClickable(F);
    }

    private void f()
    {
        com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.e.a().a(StatusManager.j().l());
    }

    private void g()
    {
        boolean flag = false;
        if (Globals.d().c().c())
        {
            return;
        }
        boolean flag1 = com.cyberlink.youcammakeup.kernelctrl.z.a(af.a, Globals.d());
        int j1 = com.cyberlink.youcammakeup.kernelctrl.z.c(af.b, Globals.d()) + 1;
        int i1 = ((flag) ? 1 : 0);
        if (!flag1)
        {
            if (j1 >= 3)
            {
                (new ad(getActivity(), true)).show();
                com.cyberlink.youcammakeup.kernelctrl.z.a(af.a, Boolean.valueOf(true), Globals.d());
                i1 = ((flag) ? 1 : 0);
            } else
            {
                i1 = j1;
            }
        }
        com.cyberlink.youcammakeup.kernelctrl.z.a(af.b, i1, Globals.d());
    }

    public void a(long l1)
    {
        C = l1;
        if (D)
        {
            e();
        }
    }

    public Uri b()
    {
        long l1 = com.cyberlink.youcammakeup.c.f().a(C).longValue();
        Object obj = com.cyberlink.youcammakeup.c.e().b(l1);
        if (obj == null)
        {
            obj = getResources().getString(0x7f070060);
            Toast.makeText(getActivity(), ((CharSequence) (obj)), 1).show();
            return null;
        } else
        {
            return Uri.parse((new StringBuilder()).append("file://").append(((o) (obj)).b()).toString());
        }
    }

    public void c()
    {
        G = true;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        YMKResultPageEvent.b = System.currentTimeMillis();
        b = new ShareItemAdapter(getActivity());
        k = (ImageView)c.findViewById(0x7f0c06fa);
        k.setOnClickListener(L);
        c.findViewById(0x7f0c06fd).setOnClickListener(L);
        long l1 = StatusManager.j().l();
        bundle = StatusManager.j().c(l1);
        ImageBufferWrapper imagebufferwrapper = bundle.g().b();
        if (imagebufferwrapper != null)
        {
            Bitmap bitmap1 = Bitmap.createBitmap((int)imagebufferwrapper.b(), (int)imagebufferwrapper.c(), android.graphics.Bitmap.Config.ARGB_8888);
            imagebufferwrapper.c(bitmap1);
            imagebufferwrapper.m();
            ((ImageView)c.findViewById(0x7f0c0713)).setImageBitmap(bitmap1);
        }
        if (StatusManager.j().z())
        {
            bundle = bundle.d().b();
        } else
        {
            bundle = ViewEngine.a().a(l1, 1.0D, DevelopSetting.a(), null);
        }
        if (bundle != null)
        {
            Bitmap bitmap = Bitmap.createBitmap((int)bundle.b(), (int)bundle.c(), android.graphics.Bitmap.Config.ARGB_8888);
            ViewEngine.a().a(-11L, bundle);
            bundle.c(bitmap);
            bundle.m();
            ((ImageView)c.findViewById(0x7f0c0712)).setImageBitmap(bitmap);
            k.setImageBitmap(bitmap);
        }
        A = (FrameLayout)c.findViewById(0x7f0c0719);
        B = c.findViewById(0x7f0c0718);
        if (StatusManager.j().P())
        {
            c.findViewById(0x7f0c06f5).setVisibility(4);
        } else
        {
            c.findViewById(0x7f0c06f4).setVisibility(4);
        }
        H = new com.cyberlink.youcammakeup.a.a();
        H.a(getActivity(), com.cyberlink.youcammakeup.flurry.ClickAdsEvent.SourceName.d);
        H.a(A, B, getActivity());
        H.a(A);
        H.b(B);
        c.setOnTouchListener(new android.view.View.OnTouchListener() {

            final ag a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                return true;
            }

            
            {
                a = ag.this;
                super();
            }
        });
        g = c.findViewById(0x7f0c06f3);
        e = (TextView)c.findViewById(0x7f0c06fc);
        d = (TextView)c.findViewById(0x7f0c06fb);
        g.setOnClickListener(new android.view.View.OnClickListener() {

            final ag a;

            public void onClick(View view)
            {
                if (!com.cyberlink.youcammakeup.camera.ag.a(a))
                {
                    return;
                } else
                {
                    com.cyberlink.youcammakeup.camera.ag.a(a, false);
                    com.cyberlink.youcammakeup.flurry.a.a(new PhotoSavePageClickEvent(com.cyberlink.youcammakeup.flurry.PhotoSavePageClickEvent.ButtonName.b));
                    com.cyberlink.youcammakeup.clflurry.b.a(new YMKResultPageEvent(com.cyberlink.youcammakeup.clflurry.YMKResultPageEvent.Operation.b, YMKResultPageEvent.b, System.currentTimeMillis()));
                    com.cyberlink.youcammakeup.camera.ag.b(a);
                    view = (new Intent(a.getActivity(), com/cyberlink/youcammakeup/activity/LauncherActivity)).setFlags(0x4000000);
                    a.getActivity().startActivity(view);
                    Globals.d().H();
                    com.cyberlink.youcammakeup.camera.ag.a(a, true);
                    return;
                }
            }

            
            {
                a = ag.this;
                super();
            }
        });
        i = c.findViewById(0x7f0c06f4);
        h = c.findViewById(0x7f0c06f5);
        l = c.findViewById(0x7f0c06fe);
        m = (TextView)c.findViewById(0x7f0c0700);
        n = (TextView)c.findViewById(0x7f0c0702);
        o = c.findViewById(0x7f0c0704);
        p = (TextView)c.findViewById(0x7f0c0705);
        q = c.findViewById(0x7f0c0706);
        r = (TextView)c.findViewById(0x7f0c070a);
        s = (TextView)c.findViewById(0x7f0c070b);
        v = (TextView)c.findViewById(0x7f0c070e);
        t = c.findViewById(0x7f0c070d);
        u = c.findViewById(0x7f0c0709);
        w = c.findViewById(0x7f0c070f);
        x = c.findViewById(0x7f0c0716);
        j = c.findViewById(0x7f0c06f6);
        i.setOnClickListener(new android.view.View.OnClickListener() {

            final ag a;

            public void onClick(View view)
            {
                if (!com.cyberlink.youcammakeup.camera.ag.a(a))
                {
                    return;
                }
                com.cyberlink.youcammakeup.camera.ag.a(a, false);
                com.cyberlink.youcammakeup.flurry.a.a(new PhotoSavePageClickEvent(com.cyberlink.youcammakeup.flurry.PhotoSavePageClickEvent.ButtonName.c));
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKResultPageEvent(com.cyberlink.youcammakeup.clflurry.YMKResultPageEvent.Operation.d, YMKResultPageEvent.b, System.currentTimeMillis()));
                YMKLiveCamEvent.b(com.cyberlink.youcammakeup.clflurry.YMKLiveCamEvent.Source.b.a());
                com.cyberlink.youcammakeup.camera.ag.b(a);
                if (!com.cyberlink.youcammakeup.camera.o.a())
                {
                    Toast.makeText(a.getActivity(), 0x7f070062, 0).show();
                    return;
                } else
                {
                    Globals.d().a(false);
                    view = new Intent(a.getActivity().getApplicationContext(), com/cyberlink/youcammakeup/activity/CameraActivity);
                    a.startActivity(view);
                    a.getActivity().finish();
                    com.cyberlink.youcammakeup.camera.ag.a(a, true);
                    return;
                }
            }

            
            {
                a = ag.this;
                super();
            }
        });
        h.setOnClickListener(new android.view.View.OnClickListener() {

            final ag a;

            public void onClick(View view)
            {
                if (!com.cyberlink.youcammakeup.camera.ag.a(a))
                {
                    return;
                } else
                {
                    com.cyberlink.youcammakeup.camera.ag.a(a, false);
                    YMKSavingPageEvent.b(com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.Source.e.a());
                    com.cyberlink.youcammakeup.clflurry.b.a(new YMKResultPageEvent(com.cyberlink.youcammakeup.clflurry.YMKResultPageEvent.Operation.d, YMKResultPageEvent.b, System.currentTimeMillis()));
                    com.cyberlink.youcammakeup.flurry.a.a(new PhotoSavePageClickEvent(com.cyberlink.youcammakeup.flurry.PhotoSavePageClickEvent.ButtonName.d));
                    StatusManager.j().b(-1L);
                    StatusManager.j().a(null, com.cyberlink.youcammakeup.camera.ag.a);
                    Globals.d().a(false);
                    view = new com.cyberlink.youcammakeup.activity.LibraryPickerActivity.State("editView");
                    com.cyberlink.youcammakeup.g.a(a.getActivity(), view, null, null, null, null);
                    a.getActivity().finish();
                    com.cyberlink.youcammakeup.camera.ag.a(a, false);
                    return;
                }
            }

            
            {
                a = ag.this;
                super();
            }
        });
        l.setOnClickListener(I);
        o.setOnClickListener(I);
        q.setOnClickListener(J);
        t.setOnClickListener(J);
        w.setOnClickListener(K);
        x.setOnClickListener(K);
        j.setOnClickListener(new android.view.View.OnClickListener() {

            final ag a;

            public void onClick(View view)
            {
                if (com.cyberlink.youcammakeup.camera.ag.a(a))
                {
                    com.cyberlink.youcammakeup.camera.ag.a(a, false);
                    view.setEnabled(false);
                    YMKShareToEvent.a(com.cyberlink.youcammakeup.clflurry.YMKShareToEvent.Source.b);
                    com.cyberlink.youcammakeup.flurry.a.a(new PhotoSavePageClickEvent(com.cyberlink.youcammakeup.flurry.PhotoSavePageClickEvent.ButtonName.p));
                    com.cyberlink.youcammakeup.clflurry.b.a(new YMKResultPageEvent(com.cyberlink.youcammakeup.clflurry.YMKResultPageEvent.Operation.c, YMKResultPageEvent.b, System.currentTimeMillis()));
                    Uri uri = a.b();
                    if (uri != null)
                    {
                        Globals.d().a(com.cyberlink.youcammakeup.camera.ag.c(a));
                        Object obj = a.getArguments();
                        Bundle bundle1 = ((Bundle) (obj));
                        if (obj == null)
                        {
                            bundle1 = new Bundle();
                        }
                        bundle1.putString("BUNDLE_KEY_TITLE", com.cyberlink.youcammakeup.widgetpool.dialogs.al.a);
                        bundle1.putString("BUNDLE_KEY_MESSAGE", null);
                        bundle1.putParcelable("BUNDLE_KEY_URI", uri);
                        obj = new ai(com.cyberlink.youcammakeup.camera.ag.d(a));
                        ((ai) (obj)).setArguments(bundle1);
                        ((ai) (obj)).a(new android.content.DialogInterface.OnDismissListener(this, view) {

                            final View a;
                            final _cls5 b;

                            public void onDismiss(DialogInterface dialoginterface)
                            {
                                YMKResultPageEvent.b = System.currentTimeMillis();
                                a.setEnabled(true);
                                com.cyberlink.youcammakeup.camera.ag.a(b.a, true);
                            }

            
            {
                b = _pcls5;
                a = view;
                super();
            }
                        });
                        com.cyberlink.youcammakeup.utility.o.a(a.getFragmentManager(), ((android.app.DialogFragment) (obj)), "ShareDialog");
                        return;
                    }
                }
            }

            
            {
                a = ag.this;
                super();
            }
        });
        bundle = getResources().getString(0x7f07037a);
        bundle = (new StringBuilder()).append(String.format(bundle, new Object[] {
            "YouCam Makeup"
        })).append(" ").append(getResources().getString(0x7f0703a7)).toString();
        e.setText(bundle);
        y = c.findViewById(0x7f0c071a);
        z = c.findViewById(0x7f0c06f8);
        z.setVisibility(4);
        o.setClickable(F);
        t.setClickable(F);
        x.setClickable(F);
        j.setClickable(F);
        if (G)
        {
            y.setVisibility(0);
        }
        if (!F)
        {
            z.setVisibility(4);
        }
        if (C != 0L)
        {
            e();
        }
        D = true;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        c = layoutinflater.inflate(0x7f030194, viewgroup);
        return c;
    }

    public void onDestroyView()
    {
        if (H != null)
        {
            H.c(A);
            H.d(B);
        }
        super.onDestroyView();
    }

    public void onPause()
    {
        if (H != null)
        {
            H.c();
        }
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        d();
        if (!E)
        {
            g();
            E = true;
        }
        com.cyberlink.youcammakeup.clflurry.b.a(new YMKResultPageEvent(com.cyberlink.youcammakeup.clflurry.YMKResultPageEvent.Operation.a, 0L, 0L));
        if (al.a("com.cyberlink.youperfect"))
        {
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKResultPageEvent(com.cyberlink.youcammakeup.clflurry.YMKResultPageEvent.Operation.e));
            m.setText(0x7f0706a9);
            n.setText(0x7f0706a5);
            p.setText(0x7f070679);
        } else
        {
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKResultPageEvent(com.cyberlink.youcammakeup.clflurry.YMKResultPageEvent.Operation.f));
            m.setText(0x7f0706a8);
            n.setText(0x7f0706a4);
            p.setText(0x7f070681);
        }
        if (al.a("com.perfectcorp.ycn"))
        {
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKResultPageEvent(com.cyberlink.youcammakeup.clflurry.YMKResultPageEvent.Operation.h));
            r.setText(0x7f0706a2);
            s.setText(0x7f0706a0);
            v.setText(0x7f070679);
            u.setVisibility(8);
        } else
        {
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKResultPageEvent(com.cyberlink.youcammakeup.clflurry.YMKResultPageEvent.Operation.i));
            r.setText(0x7f0706a1);
            s.setText(0x7f07069f);
            v.setText(0x7f070681);
            u.setVisibility(0);
        }
        com.cyberlink.youcammakeup.clflurry.b.a(new YMKResultPageEvent(com.cyberlink.youcammakeup.clflurry.YMKResultPageEvent.Operation.g));
    }

}
