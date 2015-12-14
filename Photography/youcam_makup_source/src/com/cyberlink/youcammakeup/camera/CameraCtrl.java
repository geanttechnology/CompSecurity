// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.util.TypedValue;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.camera.exif.c;
import com.cyberlink.clgpuimage.CLMakeupLiveFilter;
import com.cyberlink.clgpuimage.ab;
import com.cyberlink.clgpuimage.u;
import com.cyberlink.youcammakeup.BaseActivity;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.CameraActivity;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.activity.LibraryPickerActivity;
import com.cyberlink.youcammakeup.clflurry.YMKFeatureRoomLookEvent;
import com.cyberlink.youcammakeup.clflurry.YMKLiveCamEvent;
import com.cyberlink.youcammakeup.clflurry.YMKMakeupStayTimeEvent;
import com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.flurry.a;
import com.cyberlink.youcammakeup.jniproxy.an;
import com.cyberlink.youcammakeup.jniproxy.ba;
import com.cyberlink.youcammakeup.kernelctrl.LiveDemoConfigHelper;
import com.cyberlink.youcammakeup.kernelctrl.b.d;
import com.cyberlink.youcammakeup.kernelctrl.gpuimage.camera.GPUImageCameraView;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.cyberlink.youcammakeup.kernelctrl.y;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.masteraccess.Exporter;
import com.cyberlink.youcammakeup.utility.IntroDialogUtils;
import com.cyberlink.youcammakeup.utility.aa;
import com.cyberlink.youcammakeup.utility.ae;
import com.cyberlink.youcammakeup.utility.al;
import com.cyberlink.youcammakeup.utility.ca;
import com.cyberlink.youcammakeup.utility.ch;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.ICameraPanel;
import com.cyberlink.youcammakeup.widgetpool.common.IndicatorView;
import com.cyberlink.youcammakeup.widgetpool.dialogs.w;
import com.cyberlink.youcammakeup.widgetpool.dialogs.x;
import com.cyberlink.youcammakeup.widgetpool.panel.c.p;
import com.nostra13.universalimageloader.core.f;
import com.perfectcorp.utility.ImageUtils;
import com.perfectcorp.utility.j;
import com.pf.common.utility.m;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            c, y, LiveCategoryCtrl, d, 
//            m, CameraSettingDialog, ah, b, 
//            e, FocusAreaView, CameraZoomView, CameraFlashModeDialog, 
//            ae, o, u, v, 
//            a, af, s, g, 
//            n, z, t, f, 
//            h

public class CameraCtrl
    implements android.view.SurfaceHolder.Callback
{

    public static final UUID a = UUID.randomUUID();
    private static AtomicBoolean ar = new AtomicBoolean(false);
    private static AtomicBoolean as = new AtomicBoolean(true);
    private static final float b[] = {
        1.3F, 1.5F, 1.0F
    };
    private static final float c[] = {
        0.0F, 1.0F
    };
    private AtomicBoolean A;
    private AtomicBoolean B;
    private AtomicBoolean C;
    private com.cyberlink.youcammakeup.camera.d D;
    private Camera E;
    private com.cyberlink.youcammakeup.camera.m F;
    private int G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;
    private boolean O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private android.hardware.Camera.PictureCallback T;
    private e U;
    private com.cyberlink.youcammakeup.camera.ae V;
    private af W;
    private ah X;
    private com.cyberlink.youcammakeup.camera.a Y;
    private Runnable Z;
    private Fragment aa;
    private int ab;
    private PanelDisplayStatus ac;
    private View ad;
    private d ae;
    private Handler af;
    private Activity ag;
    private View ah;
    private GPUImageCameraView ai;
    private com.cyberlink.youcammakeup.camera.b aj;
    private ae ak;
    private com.cyberlink.youcammakeup.camera.y al;
    private LiveCategoryCtrl.LiveCategory am;
    private LiveCategoryCtrl an;
    private boolean ao;
    private boolean ap;
    private final Handler aq = new Handler();
    private long at;
    private long au;
    private long av;
    private android.content.DialogInterface.OnDismissListener aw;
    private final Runnable ax = new Runnable() {

        final CameraCtrl a;

        public void run()
        {
            if (!CameraCtrl.R(a))
            {
                CameraCtrl.g(a, true);
            }
        }

            
            {
                a = CameraCtrl.this;
                super();
            }
    };
    private android.view.View.OnClickListener ay;
    private View d;
    private FocusAreaView e;
    private ImageView f;
    private CameraZoomView g;
    private View h;
    private TextView i;
    private View j;
    private TextView k;
    private View l;
    private View m;
    private View n;
    private View o;
    private View p;
    private View q;
    private View r;
    private ImageView s;
    private IndicatorView t;
    private ImageView u;
    private FragmentManager v;
    private CameraFlashModeDialog w;
    private CameraSettingDialog x;
    private Display y;
    private BroadcastReceiver z;

    public CameraCtrl(Activity activity, View view, GPUImageCameraView gpuimagecameraview, com.cyberlink.youcammakeup.camera.b b1)
    {
        A = new AtomicBoolean(false);
        B = new AtomicBoolean(false);
        C = new AtomicBoolean(false);
        H = false;
        I = false;
        J = false;
        K = false;
        L = false;
        M = true;
        N = true;
        O = true;
        P = y.b;
        Q = false;
        R = false;
        S = true;
        ab = 0x7f0c009c;
        ae = null;
        ao = false;
        ap = false;
        at = -1L;
        au = -1L;
        aw = new android.content.DialogInterface.OnDismissListener() {

            final CameraCtrl a;

            public void onDismiss(DialogInterface dialoginterface)
            {
            }

            
            {
                a = CameraCtrl.this;
                super();
            }
        };
        ay = new android.view.View.OnClickListener() {

            final CameraCtrl a;

            public void onClick(View view1)
            {
                if (com.cyberlink.youcammakeup.camera.CameraCtrl.u(a) != null)
                {
                    YMKFeatureRoomLookEvent.b(com.cyberlink.youcammakeup.clflurry.YMKFeatureRoomLookEvent.Source.b.a());
                    StatusManager.j().b(CameraCtrl.V(a));
                    StatusManager.j().a(CameraCtrl.W(a), com.cyberlink.youcammakeup.camera.CameraCtrl.a);
                    view1 = new com.cyberlink.youcammakeup.activity.LibraryPickerActivity.State("editView");
                    Intent intent = new Intent(com.cyberlink.youcammakeup.camera.CameraCtrl.u(a), com/cyberlink/youcammakeup/activity/LibraryPickerActivity);
                    intent.putExtra("LibraryPickerActivity_STATE", view1);
                    intent.putExtra("ShowZooView", true);
                    intent.putExtra(com.cyberlink.youcammakeup.camera.CameraCtrl.u(a).getResources().getString(0x7f070729), com/cyberlink/youcammakeup/activity/CameraActivity);
                    com.cyberlink.youcammakeup.camera.CameraCtrl.u(a).startActivity(intent);
                    com.cyberlink.youcammakeup.camera.CameraCtrl.u(a).finish();
                }
            }

            
            {
                a = CameraCtrl.this;
                super();
            }
        };
        ag = activity;
        ah = view;
        ai = gpuimagecameraview;
        aj = b1;
        af = new Handler(new com.cyberlink.youcammakeup.camera.c(this));
        ak = new ae(activity, null);
        al = new com.cyberlink.youcammakeup.camera.y(activity, gpuimagecameraview, view);
        an = new LiveCategoryCtrl(activity.findViewById(0x7f0c009a));
        D = new com.cyberlink.youcammakeup.camera.d(this);
    }

    private void A()
    {
        ag.runOnUiThread(new Runnable() {

            final CameraCtrl a;

            public void run()
            {
                CameraCtrl.A(a);
                CameraCtrl.B(a);
                CameraCtrl.C(a).setCamera(CameraCtrl.q(a));
                if (LiveDemoConfigHelper.h().d())
                {
                    CameraCtrl.C(a).setZoomLevel(LiveDemoConfigHelper.h().q());
                }
                CameraCtrl.e(a, true);
                com.cyberlink.youcammakeup.camera.CameraCtrl.a(a, true);
                if (!com.cyberlink.youcammakeup.camera.CameraCtrl.p(a))
                {
                    break MISSING_BLOCK_LABEL_104;
                }
                com.cyberlink.youcammakeup.camera.CameraCtrl.w(a).setVisibility(0);
_L1:
                com.cyberlink.youcammakeup.camera.CameraCtrl.d(a).a();
                return;
                try
                {
                    com.cyberlink.youcammakeup.camera.CameraCtrl.w(a).setVisibility(4);
                }
                catch (Exception exception)
                {
                    com.pf.common.utility.m.b("CameraCtrl", "setupCameraParameters", exception);
                    return;
                }
                  goto _L1
            }

            
            {
                a = CameraCtrl.this;
                super();
            }
        });
    }

    static void A(CameraCtrl cameractrl)
    {
        cameractrl.B();
    }

    private void B()
    {
        if (E == null)
        {
            return;
        }
        android.hardware.Camera.Size size = E.getParameters().getPreviewSize();
        int i2 = d.getWidth();
        int l1 = d.getHeight();
        int i1 = size.width;
        int k1 = size.height;
        float f1;
        float f2;
        float f3;
        int j1;
        if (i1 < k1)
        {
            j1 = k1;
        } else
        {
            j1 = i1;
            i1 = k1;
        }
        if (ag.getResources().getConfiguration().orientation == 1)
        {
            k1 = 1;
        } else
        {
            k1 = 0;
        }
        if (k1 != 0)
        {
            f1 = l1;
        } else
        {
            f1 = i2;
        }
        f2 = f1 / (float)j1;
        if (k1 != 0)
        {
            f1 = i2;
        } else
        {
            f1 = l1;
        }
        f1 /= i1;
        if (f2 < f1)
        {
            f1 = f2 / f1;
            f2 = 1.0F;
        } else
        if (f2 > f1)
        {
            f2 = f1 / f2;
            f1 = 1.0F;
        } else
        {
            f2 = 1.0F;
            f1 = 1.0F;
        }
        if (k1 == 0)
        {
            f3 = f2;
            f2 = f1;
        } else
        {
            f3 = f1;
        }
        com.pf.common.utility.m.e("Scale", String.format("%f, %f", new Object[] {
            Float.valueOf(f3), Float.valueOf(f2)
        }));
        i1 = (int)(f3 * (float)i2);
        j1 = (int)(f2 * (float)l1);
        a(g, i1, j1);
        a(e, i1, j1);
    }

    static void B(CameraCtrl cameractrl)
    {
        cameractrl.C();
    }

    static CameraZoomView C(CameraCtrl cameractrl)
    {
        return cameractrl.g;
    }

    private void C()
    {
        F.a(E);
        F.a(I);
        F.b(J);
    }

    private void D()
    {
        com.pf.common.utility.m.b("PICTURE_TAKEN", (new StringBuilder()).append("[CameraCtrl] - capture with isPhotoFlipOn: ").append(S).toString());
        al.a(new com.cyberlink.youcammakeup.camera.z() {

            final CameraCtrl a;

            public void a()
            {
                com.cyberlink.youcammakeup.camera.CameraCtrl.a(a).post(new Runnable(this) {

                    final _cls28 a;

                    public void run()
                    {
                        com.cyberlink.youcammakeup.camera.CameraCtrl.o(a.a);
                    }

            
            {
                a = _pcls28;
                super();
            }
                });
            }

            public void a(ImageBufferWrapper imagebufferwrapper, List list)
            {
                com.pf.common.utility.m.b("PICTURE_TAKEN", "[CameraCtrl] - onImageSaved");
                ViewEngine.a().a(-7L, imagebufferwrapper);
                StatusManager.j().a(-7L, com.cyberlink.youcammakeup.camera.CameraCtrl.a);
                StatusManager.j().g(true);
                StatusManager.j().c(list);
                com.cyberlink.youcammakeup.widgetpool.panel.c.p.a().a(CameraCtrl.D(a));
                com.cyberlink.youcammakeup.camera.CameraCtrl.a(a).post(new Runnable(this) {

                    final _cls28 a;

                    public void run()
                    {
                        android.location.Location location = CameraCtrl.E(a.a).a();
                        Object obj = location;
                        if (location == null)
                        {
                            com.pf.common.utility.m.b("CameraCtrl", "Can't get current loaction immediately. Try to get last know location.");
                            obj = com.cyberlink.youcammakeup.utility.y.a().a(Globals.d());
                        }
                        com.cyberlink.youcammakeup.utility.y.a().a(((android.location.Location) (obj)));
                        com.pf.common.utility.m.e("onImageSaved", "startActivity");
                        obj = new Intent(com.cyberlink.youcammakeup.camera.CameraCtrl.u(a.a).getApplicationContext(), com/cyberlink/youcammakeup/activity/EditViewActivity);
                        com.cyberlink.youcammakeup.camera.CameraCtrl.u(a.a).startActivity(((Intent) (obj)));
                    }

            
            {
                a = _pcls28;
                super();
            }
                });
            }

            public void b()
            {
                com.pf.common.utility.m.b("PICTURE_TAKEN", "[CameraCtrl] - onImageReady");
                com.cyberlink.youcammakeup.camera.CameraCtrl.d(a).d();
            }

            public void c()
            {
                com.cyberlink.youcammakeup.camera.CameraCtrl.a(a).post(new Runnable(this) {

                    final _cls28 a;

                    public void run()
                    {
                        Globals.d().i().a(com.cyberlink.youcammakeup.camera.CameraCtrl.u(a.a), true, false, false, new w(this) {

                            final _cls3 a;

                            public void a(boolean flag)
                            {
                                Globals.d().i().h(com.cyberlink.youcammakeup.camera.CameraCtrl.u(a.a.a));
                                com.cyberlink.youcammakeup.camera.CameraCtrl.a(false);
                                com.cyberlink.youcammakeup.camera.CameraCtrl.a(a.a.a, false);
                                com.cyberlink.youcammakeup.camera.CameraCtrl.b(a.a.a, true);
                                com.cyberlink.youcammakeup.camera.CameraCtrl.d(a.a.a).c();
                                ca.b().a();
                            }

                            public void b(boolean flag)
                            {
                                ca.b().a();
                            }

            
            {
                a = _pcls3;
                super();
            }
                        });
                    }

            
            {
                a = _pcls28;
                super();
            }
                });
            }

            
            {
                a = CameraCtrl.this;
                super();
            }
        }, I, S);
    }

    static boolean D(CameraCtrl cameractrl)
    {
        return cameractrl.M;
    }

    static ae E(CameraCtrl cameractrl)
    {
        return cameractrl.ak;
    }

    private void E()
    {
        o o1 = Globals.d().i();
        o1.c(ag);
        o1.a(new com.cyberlink.youcammakeup.widgetpool.dialogs.y(true, false, true, false, Globals.d().getResources().getString(0x7f0703fd), null));
        o1.b(x.a, Globals.d().getResources().getString(0x7f070386));
        o1.a(new w(o1) {

            final o a;
            final CameraCtrl b;

            public void a(boolean flag)
            {
                a.i(com.cyberlink.youcammakeup.camera.CameraCtrl.u(b));
                com.cyberlink.youcammakeup.camera.CameraCtrl.a(false);
                com.cyberlink.youcammakeup.camera.CameraCtrl.a(b, false);
                com.cyberlink.youcammakeup.camera.CameraCtrl.b(b, true);
                com.cyberlink.youcammakeup.camera.CameraCtrl.d(b).c();
            }

            public void b(boolean flag)
            {
            }

            
            {
                b = CameraCtrl.this;
                a = o1;
                super();
            }
        });
    }

    static ImageView F(CameraCtrl cameractrl)
    {
        return cameractrl.f;
    }

    private void F()
    {
        au = -1L;
        (new j() {

            final CameraCtrl a;

            protected Bitmap a(Void void1)
            {
                String s1;
                s1 = Exporter.a();
                void1 = new File(s1);
                if (void1.exists()) goto _L2; else goto _L1
_L1:
                void1.mkdirs();
_L4:
                return null;
_L2:
                if (com.cyberlink.youcammakeup.camera.CameraCtrl.u(a) == null) goto _L4; else goto _L3
_L3:
                Object obj;
                Cursor cursor;
                void1 = com.cyberlink.youcammakeup.camera.CameraCtrl.u(a).getContentResolver();
                obj = (new StringBuilder()).append(s1).append("%").toString();
                cursor = void1.query(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] {
                    "_id", "bucket_id", "_id", "_data"
                }, "_data LIKE ?", new String[] {
                    obj
                }, "date_added DESC");
                if (cursor == null)
                {
                    break MISSING_BLOCK_LABEL_357;
                }
                obj = null;
_L6:
                void1 = ((Void) (obj));
                if (!cursor.moveToNext())
                {
                    break MISSING_BLOCK_LABEL_342;
                }
                void1 = ((Void) (obj));
                String s2 = cursor.getString(cursor.getColumnIndex("_data"));
                void1 = ((Void) (obj));
                File file = new File(s2);
                void1 = ((Void) (obj));
                Object obj1 = file.getParent();
                if (obj1 == null) goto _L6; else goto _L5
_L5:
                void1 = ((Void) (obj));
                if (!((String) (obj1)).equals(s1)) goto _L6; else goto _L7
_L7:
                void1 = ((Void) (obj));
                long l1 = cursor.getLong(cursor.getColumnIndex("_id"));
                void1 = ((Void) (obj));
                com.cyberlink.youcammakeup.camera.CameraCtrl.a(a, cursor.getLong(cursor.getColumnIndex("bucket_id")));
                void1 = ((Void) (obj));
                obj1 = com.cyberlink.youcammakeup.c.f();
                void1 = ((Void) (obj));
                com.cyberlink.youcammakeup.camera.CameraCtrl.b(a, ((com.cyberlink.youcammakeup.database.p) (obj1)).f(l1));
                void1 = ((Void) (obj));
                s2 = (new StringBuilder()).append(s2).append("_preview").toString();
                void1 = ((Void) (obj));
                obj = com.nostra13.universalimageloader.core.f.b().c().a(s2);
                void1 = ((Void) (obj));
                if (obj != null)
                {
                    break MISSING_BLOCK_LABEL_342;
                }
                void1 = ((Void) (obj));
                obj = ImageUtils.a(Globals.d().getApplicationContext(), Uri.fromFile(file));
                void1 = ((Void) (obj));
                com.nostra13.universalimageloader.core.f.b().c().a(s2, ((Bitmap) (obj)));
                void1 = ((Void) (obj));
_L8:
                cursor.close();
                return void1;
                Exception exception;
                exception;
                exception = void1;
                  goto _L6
                void1 = null;
                  goto _L8
            }

            protected volatile Object a(Object obj)
            {
                return a((Void)obj);
            }

            
            {
                a = CameraCtrl.this;
                super();
            }
        }).d(null).a(new com.perfectcorp.utility.m() {

            final CameraCtrl a;

            protected void a(Bitmap bitmap)
            {
                if (CameraCtrl.X(a) != null)
                {
                    CameraCtrl.X(a).setImageBitmap(bitmap);
                }
            }

            protected void b(Object obj)
            {
                a((Bitmap)obj);
            }

            
            {
                a = CameraCtrl.this;
                super();
            }
        });
    }

    static ah G(CameraCtrl cameractrl)
    {
        return cameractrl.X;
    }

    static com.cyberlink.youcammakeup.camera.m H(CameraCtrl cameractrl)
    {
        return cameractrl.F;
    }

    static View I(CameraCtrl cameractrl)
    {
        return cameractrl.o;
    }

    static void J(CameraCtrl cameractrl)
    {
        cameractrl.D();
    }

    static int K(CameraCtrl cameractrl)
    {
        return cameractrl.ab;
    }

    static View L(CameraCtrl cameractrl)
    {
        return cameractrl.r;
    }

    static com.cyberlink.youcammakeup.camera.y M(CameraCtrl cameractrl)
    {
        return cameractrl.al;
    }

    static boolean N(CameraCtrl cameractrl)
    {
        return cameractrl.N;
    }

    static GPUImageCameraView O(CameraCtrl cameractrl)
    {
        return cameractrl.ai;
    }

    static void P(CameraCtrl cameractrl)
    {
        cameractrl.E();
    }

    static TextView Q(CameraCtrl cameractrl)
    {
        return cameractrl.k;
    }

    static boolean R(CameraCtrl cameractrl)
    {
        return cameractrl.ap;
    }

    static void S(CameraCtrl cameractrl)
    {
        cameractrl.z();
    }

    static void T(CameraCtrl cameractrl)
    {
        cameractrl.w();
    }

    static void U(CameraCtrl cameractrl)
    {
        cameractrl.x();
    }

    static long V(CameraCtrl cameractrl)
    {
        return cameractrl.at;
    }

    static long W(CameraCtrl cameractrl)
    {
        return cameractrl.au;
    }

    static ImageView X(CameraCtrl cameractrl)
    {
        return cameractrl.u;
    }

    static long a(CameraCtrl cameractrl, long l1)
    {
        cameractrl.at = l1;
        return l1;
    }

    static Fragment a(CameraCtrl cameractrl, Fragment fragment)
    {
        cameractrl.aa = fragment;
        return fragment;
    }

    static Camera a(CameraCtrl cameractrl, Camera camera)
    {
        cameractrl.E = camera;
        return camera;
    }

    static Handler a(CameraCtrl cameractrl)
    {
        return cameractrl.af;
    }

    private void a(Fragment fragment, boolean flag)
    {
        BaseActivity baseactivity = (BaseActivity)ag;
        if (baseactivity.b())
        {
            return;
        }
        fragment = new Runnable(fragment, flag) {

            final Fragment a;
            final boolean b;
            final CameraCtrl c;

            public void run()
            {
                com.cyberlink.youcammakeup.camera.CameraCtrl.a(c, a);
                FragmentTransaction fragmenttransaction = com.cyberlink.youcammakeup.camera.CameraCtrl.u(c).getFragmentManager().beginTransaction();
                if (b)
                {
                    fragmenttransaction.setCustomAnimations(0x7f04001f, 0);
                }
                Globals.d(new Runnable(this, fragmenttransaction) {

                    final FragmentTransaction a;
                    final _cls29 b;

                    public void run()
                    {
                        while (com.cyberlink.youcammakeup.camera.CameraCtrl.u(b.c) == null || ((BaseActivity)com.cyberlink.youcammakeup.camera.CameraCtrl.u(b.c)).b()) 
                        {
                            return;
                        }
                        a.replace(CameraCtrl.K(b.c), b.a);
                        a.commitAllowingStateLoss();
                    }

            
            {
                b = _pcls29;
                a = fragmenttransaction;
                super();
            }
                });
            }

            
            {
                c = CameraCtrl.this;
                a = fragment;
                b = flag;
                super();
            }
        };
        if (baseactivity.c())
        {
            baseactivity.a(fragment);
            return;
        } else
        {
            fragment.run();
            return;
        }
    }

    private void a(android.hardware.Camera.Parameters parameters, CameraFlashModeDialog.FlashMode flashmode)
    {
        class _cls39
        {

            static final int a[];
            static final int b[];

            static 
            {
                b = new int[CameraSettingDialog.Setting.values().length];
                try
                {
                    b[com.cyberlink.youcammakeup.camera.CameraSettingDialog.Setting.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    b[com.cyberlink.youcammakeup.camera.CameraSettingDialog.Setting.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    b[com.cyberlink.youcammakeup.camera.CameraSettingDialog.Setting.c.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    b[com.cyberlink.youcammakeup.camera.CameraSettingDialog.Setting.d.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    b[CameraSettingDialog.Setting.e.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    b[com.cyberlink.youcammakeup.camera.CameraSettingDialog.Setting.f.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    b[CameraSettingDialog.Setting.h.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    b[CameraSettingDialog.Setting.g.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                a = new int[CameraFlashModeDialog.FlashMode.values().length];
                try
                {
                    a[com.cyberlink.youcammakeup.camera.CameraFlashModeDialog.FlashMode.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[com.cyberlink.youcammakeup.camera.CameraFlashModeDialog.FlashMode.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.cyberlink.youcammakeup.camera.CameraFlashModeDialog.FlashMode.c.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (com.cyberlink.youcammakeup.camera._cls39.a[flashmode.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            parameters.setFlashMode("auto");
            m.setBackgroundResource(0x7f020788);
            return;

        case 2: // '\002'
            parameters.setFlashMode("off");
            m.setBackgroundResource(0x7f02078c);
            return;

        case 3: // '\003'
            parameters.setFlashMode("on");
            break;
        }
        m.setBackgroundResource(0x7f02078d);
    }

    private void a(View view, int i1, int j1)
    {
        android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
        layoutparams.width = i1;
        layoutparams.height = j1;
        view.setLayoutParams(layoutparams);
    }

    private void a(PanelDisplayStatus paneldisplaystatus)
    {
        r.setClickable(false);
        Fragment fragment = ag.getFragmentManager().findFragmentById(ab);
        if (paneldisplaystatus == com.cyberlink.youcammakeup.camera.PanelDisplayStatus.c)
        {
            ac = com.cyberlink.youcammakeup.camera.PanelDisplayStatus.c;
            com.cyberlink.youcammakeup.kernelctrl.z.a("PANEL_DISPLAY_STATUS_KEY", ac.name(), Globals.d());
            r.setClickable(true);
            return;
        }
        if (ac == paneldisplaystatus)
        {
            if (paneldisplaystatus == com.cyberlink.youcammakeup.camera.PanelDisplayStatus.a)
            {
                r.setSelected(true);
                if (!LiveDemoConfigHelper.h().d())
                {
                    f(true);
                }
            } else
            {
                r.setSelected(false);
                f(false);
            }
            r.setClickable(true);
            return;
        }
        if (paneldisplaystatus == com.cyberlink.youcammakeup.camera.PanelDisplayStatus.a)
        {
            ch ch = new ch() {

                final CameraCtrl a;

                public void onAnimationEnd(Animator animator)
                {
                    CameraCtrl.k(a).requestLayout();
                    CameraCtrl.L(a).setClickable(true);
                }

                public void onAnimationStart(Animator animator)
                {
                    CameraCtrl.L(a).setSelected(true);
                }

            
            {
                a = CameraCtrl.this;
                super();
            }
            };
            f(true);
            ac = com.cyberlink.youcammakeup.camera.PanelDisplayStatus.a;
            paneldisplaystatus = (AnimatorSet)AnimatorInflater.loadAnimator(ag, 0x7f04001f);
            paneldisplaystatus.addListener(ch);
        } else
        {
            ch ch1 = new ch() {

                final CameraCtrl a;

                public void onAnimationEnd(Animator animator)
                {
                    com.cyberlink.youcammakeup.clflurry.b.a(new YMKLiveCamEvent(true, 0L, 0L, com.cyberlink.youcammakeup.clflurry.YMKLiveCamEvent.Operation.j, false, false));
                    animator.removeListener(this);
                    CameraCtrl.L(a).setSelected(false);
                    CameraCtrl.L(a).setClickable(true);
                }

                public void onAnimationStart(Animator animator)
                {
                }

            
            {
                a = CameraCtrl.this;
                super();
            }
            };
            ac = com.cyberlink.youcammakeup.camera.PanelDisplayStatus.b;
            paneldisplaystatus = (AnimatorSet)AnimatorInflater.loadAnimator(ag, 0x7f040020);
            paneldisplaystatus.addListener(ch1);
        }
        com.cyberlink.youcammakeup.kernelctrl.z.a("PANEL_DISPLAY_STATUS_KEY", ac.name(), Globals.d());
        if (fragment != null)
        {
            paneldisplaystatus.setTarget(fragment.getView());
            paneldisplaystatus.start();
            return;
        } else
        {
            r.setClickable(true);
            return;
        }
    }

    static void a(CameraCtrl cameractrl, android.hardware.Camera.Parameters parameters, CameraFlashModeDialog.FlashMode flashmode)
    {
        cameractrl.a(parameters, flashmode);
    }

    static void a(CameraCtrl cameractrl, PanelDisplayStatus paneldisplaystatus)
    {
        cameractrl.a(paneldisplaystatus);
    }

    static void a(CameraCtrl cameractrl, CameraSettingDialog.Setting setting, boolean flag)
    {
        cameractrl.a(setting, flag);
    }

    static void a(CameraCtrl cameractrl, LiveCategoryCtrl.LiveCategory livecategory)
    {
        cameractrl.a(livecategory);
    }

    static void a(CameraCtrl cameractrl, boolean flag)
    {
        cameractrl.c(flag);
    }

    private void a(CameraSettingDialog.Setting setting, boolean flag)
    {
        com.cyberlink.youcammakeup.camera._cls39.b[setting.ordinal()];
        JVM INSTR tableswitch 1 8: default 56
    //                   1 57
    //                   2 90
    //                   3 123
    //                   4 156
    //                   5 179
    //                   6 206
    //                   7 229
    //                   8 252;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
        return;
_L2:
        K = x.c();
        J = false;
        L = false;
        F.b(J);
        return;
_L3:
        K = x.c();
        J = true;
        L = false;
        F.b(J);
        return;
_L4:
        K = x.c();
        J = false;
        L = true;
        F.b(J);
        return;
_L5:
        K = x.c();
        F.c(K);
        return;
_L6:
        M = x.d();
        if (flag)
        {
            al.a(M);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        O = x.e();
        X.a(O);
        return;
_L8:
        P = x.f();
        if (flag)
        {
            D.c();
            return;
        }
        if (true) goto _L1; else goto _L9
_L9:
        N = x.g();
        if (flag)
        {
            al.b(N);
            return;
        }
        if (true) goto _L1; else goto _L10
_L10:
    }

    private void a(LiveCategoryCtrl.LiveCategory livecategory)
    {
        if (livecategory != am)
        {
            am = livecategory;
            an.a();
            a(an.a(am, this), true);
            ac = com.cyberlink.youcammakeup.camera.PanelDisplayStatus.a;
            Globals.d(new Runnable() {

                final CameraCtrl a;

                public void run()
                {
                    com.cyberlink.youcammakeup.camera.CameraCtrl.a(a, com.cyberlink.youcammakeup.camera.CameraCtrl.j(a));
                }

            
            {
                a = CameraCtrl.this;
                super();
            }
            });
            if (am == com.cyberlink.youcammakeup.camera.LiveCategoryCtrl.LiveCategory.d)
            {
                Globals.a(new Runnable() {

                    final CameraCtrl a;

                    public void run()
                    {
                        if (CameraCtrl.k(a) != null)
                        {
                            CameraCtrl.k(a).invalidate();
                        }
                    }

            
            {
                a = CameraCtrl.this;
                super();
            }
                }, 550L);
                return;
            }
        }
    }

    public static void a(boolean flag)
    {
        CameraActivity.b(flag);
    }

    public static boolean a(boolean flag, boolean flag1)
    {
        return CameraActivity.a(flag, flag1);
    }

    static long b(CameraCtrl cameractrl, long l1)
    {
        cameractrl.au = l1;
        return l1;
    }

    static void b(CameraCtrl cameractrl)
    {
        cameractrl.v();
    }

    static void b(CameraCtrl cameractrl, boolean flag)
    {
        cameractrl.d(flag);
    }

    private void b(boolean flag)
    {
        if (flag)
        {
            ai.setAlpha(1.0F);
            a(((com.cyberlink.youcammakeup.kernelctrl.b.b) (null)));
            return;
        } else
        {
            ai.setAlpha(0.0F);
            return;
        }
    }

    static AtomicBoolean c(CameraCtrl cameractrl)
    {
        return cameractrl.C;
    }

    static void c(CameraCtrl cameractrl, boolean flag)
    {
        cameractrl.e(flag);
    }

    private void c(boolean flag)
    {
        if (!flag)
        {
            o.setPressed(false);
            p.setPressed(false);
            n.setPressed(false);
            q.setPressed(false);
            l.setPressed(false);
            r.setPressed(false);
        }
        o.setClickable(flag);
        p.setClickable(flag);
        n.setClickable(flag);
        q.setClickable(flag);
        l.setClickable(flag);
        r.setClickable(flag);
    }

    static com.cyberlink.youcammakeup.camera.d d(CameraCtrl cameractrl)
    {
        return cameractrl.D;
    }

    private void d(boolean flag)
    {
        if (flag)
        {
            o.setVisibility(0);
            p.setVisibility(0);
            n.setVisibility(0);
            q.setVisibility(0);
            r.setVisibility(0);
        } else
        {
            o.setVisibility(4);
            p.setVisibility(4);
            n.setVisibility(4);
            q.setVisibility(4);
            r.setVisibility(4);
        }
        if (LiveDemoConfigHelper.h().d())
        {
            o.setVisibility(4);
            p.setVisibility(4);
            if (LiveDemoConfigHelper.h().j())
            {
                n.setVisibility(0);
            } else
            {
                n.setVisibility(4);
            }
            q.setVisibility(4);
            l.setVisibility(4);
            m.setVisibility(4);
            r.setVisibility(4);
        }
    }

    static boolean d(CameraCtrl cameractrl, boolean flag)
    {
        cameractrl.R = flag;
        return flag;
    }

    static void e(CameraCtrl cameractrl, boolean flag)
    {
        cameractrl.b(flag);
    }

    private void e(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (!CameraSettingDialog.h() && !flag) goto _L2; else goto _L1
_L1:
        if (com.cyberlink.youcammakeup.kernelctrl.z.a("HAS_SHOWN_LIVE_MAKEUP_PERFORMANCE_HINT", false, Globals.d())) goto _L2; else goto _L3
_L3:
        flag = ar.getAndSet(true);
        if (!flag) goto _L4; else goto _L2
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        Globals.d().i().a(ag, new w() {

            final CameraCtrl a;

            public void a(boolean flag1)
            {
                if (flag1)
                {
                    com.cyberlink.youcammakeup.kernelctrl.z.a("HAS_SHOWN_LIVE_MAKEUP_PERFORMANCE_HINT", Boolean.valueOf(true), Globals.d());
                }
                Globals.d().i().i(com.cyberlink.youcammakeup.camera.CameraCtrl.u(a));
            }

            public void b(boolean flag1)
            {
            }

            
            {
                a = CameraCtrl.this;
                super();
            }
        });
        if (true) goto _L2; else goto _L5
_L5:
        Exception exception;
        exception;
        throw exception;
    }

    static boolean e(CameraCtrl cameractrl)
    {
        return cameractrl.I;
    }

    static com.cyberlink.youcammakeup.camera.a f(CameraCtrl cameractrl)
    {
        return cameractrl.Y;
    }

    private void f(boolean flag)
    {
        if (flag)
        {
            ad.setVisibility(0);
            return;
        } else
        {
            ad.setVisibility(4);
            ad.clearAnimation();
            return;
        }
    }

    static boolean f(CameraCtrl cameractrl, boolean flag)
    {
        cameractrl.I = flag;
        return flag;
    }

    static Fragment g(CameraCtrl cameractrl)
    {
        return cameractrl.aa;
    }

    static void g(CameraCtrl cameractrl, boolean flag)
    {
        cameractrl.g(flag);
    }

    private void g(boolean flag)
    {
        if (ap == flag || ad == null || ad.getVisibility() != 0)
        {
            return;
        }
        ap = flag;
        AlphaAnimation alphaanimation;
        if (flag)
        {
            alphaanimation = new AlphaAnimation(1.0F, 0.2F);
        } else
        {
            alphaanimation = new AlphaAnimation(0.2F, 1.0F);
        }
        alphaanimation.setDuration(400L);
        alphaanimation.setRepeatCount(0);
        alphaanimation.setRepeatMode(2);
        alphaanimation.setFillAfter(true);
        ad.startAnimation(alphaanimation);
    }

    static View h(CameraCtrl cameractrl)
    {
        return cameractrl.h;
    }

    static TextView i(CameraCtrl cameractrl)
    {
        return cameractrl.i;
    }

    public static boolean i()
    {
        return CameraActivity.k();
    }

    static PanelDisplayStatus j(CameraCtrl cameractrl)
    {
        return cameractrl.ac;
    }

    static View k(CameraCtrl cameractrl)
    {
        return cameractrl.ad;
    }

    static AtomicBoolean l()
    {
        return ar;
    }

    static boolean l(CameraCtrl cameractrl)
    {
        return cameractrl.ao;
    }

    static long m(CameraCtrl cameractrl)
    {
        return cameractrl.av;
    }

    static AtomicBoolean m()
    {
        return as;
    }

    private void n()
    {
        String s1 = ca.b().a("%d");
        com.cyberlink.youcammakeup.clflurry.b.a(new YMKMakeupStayTimeEvent(com.cyberlink.youcammakeup.clflurry.YMKMakeupStayTimeEvent.Button.a, s1));
        com.cyberlink.youcammakeup.flurry.a.a(new com.cyberlink.youcammakeup.flurry.YMKMakeupStayTimeEvent(com.cyberlink.youcammakeup.flurry.YMKMakeupStayTimeEvent.Button.a, s1));
        if (aj != null)
        {
            aj.j();
        }
    }

    static void n(CameraCtrl cameractrl)
    {
        cameractrl.u();
    }

    private void o()
    {
        U = new e(this);
        T = new android.hardware.Camera.PictureCallback() {

            final CameraCtrl a;

            static void a(_cls1 _pcls1, byte abyte0[])
            {
                _pcls1.a(abyte0);
            }

            private void a(byte abyte0[])
            {
                ByteArrayOutputStream bytearrayoutputstream;
                c c1;
                c1 = com.cyberlink.youcammakeup.camera.s.a(abyte0);
                c1.a();
                int j1 = com.cyberlink.youcammakeup.camera.s.a(c1);
                int i1 = j1;
                if (j1 == 0)
                {
                    i1 = 1;
                }
                j1 = i1;
                if (!CameraCtrl.e(a))
                {
                    j1 = com.cyberlink.youcammakeup.camera.s.a[i1];
                }
                c1.a(c1.a(c.j, Integer.valueOf(j1)));
                bytearrayoutputstream = new ByteArrayOutputStream();
                c1.a(abyte0, bytearrayoutputstream);
                b(bytearrayoutputstream.toByteArray());
                try
                {
                    bytearrayoutputstream.close();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (byte abyte0[])
                {
                    com.cyberlink.youcammakeup.camera.CameraCtrl.b(a);
                }
                return;
                abyte0;
                com.pf.common.utility.m.e("CameraCtrl", abyte0.toString());
                com.cyberlink.youcammakeup.camera.CameraCtrl.b(a);
                try
                {
                    bytearrayoutputstream.close();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (byte abyte0[])
                {
                    com.cyberlink.youcammakeup.camera.CameraCtrl.b(a);
                }
                return;
                abyte0;
                class DecodeJpegBufferException extends Exception
                {

                    private static final long serialVersionUID = 0xff798ad00ac2b1c9L;
                    final _cls1 this$1;

                        public DecodeJpegBufferException(String s1)
                        {
                            this$1 = _cls1.this;
                            super(s1);
                        }
                }

                com.pf.common.utility.m.e("CameraCtrl", abyte0.toString());
                com.cyberlink.youcammakeup.camera.CameraCtrl.b(a);
                try
                {
                    bytearrayoutputstream.close();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (byte abyte0[])
                {
                    com.cyberlink.youcammakeup.camera.CameraCtrl.b(a);
                }
                return;
                abyte0;
                com.pf.common.utility.m.e("CameraCtrl", abyte0.toString());
                com.cyberlink.youcammakeup.camera.CameraCtrl.b(a);
                try
                {
                    bytearrayoutputstream.close();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (byte abyte0[])
                {
                    com.cyberlink.youcammakeup.camera.CameraCtrl.b(a);
                }
                return;
                abyte0;
                try
                {
                    bytearrayoutputstream.close();
                }
                // Misplaced declaration of an exception variable
                catch (byte abyte0[])
                {
                    com.cyberlink.youcammakeup.camera.CameraCtrl.b(a);
                    return;
                }
                throw abyte0;
            }

            private void b(byte abyte0[])
            {
                Object obj;
                obj = new ba();
                if (!ViewEngine.a().a(abyte0, ((ba) (obj))))
                {
                    throw new DecodeJpegBufferException("Can not decode meta data.");
                }
                Object obj1 = ((ba) (obj)).b();
                int i1 = (int)((an) (obj1)).d();
                int j1 = (int)((an) (obj1)).c();
                if (i1 == 0 || j1 == 0)
                {
                    android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeStream(new ByteArrayInputStream(abyte0), null, options);
                    ((an) (obj1)).b(options.outHeight);
                    ((an) (obj1)).a(options.outWidth);
                }
                StatusManager.j().a(((ba) (obj)));
                obj1 = ViewEngine.a().a(abyte0, ((ba) (obj)), Long.valueOf(-7L));
                obj = obj1;
                if (obj1 != null)
                {
                    break MISSING_BLOCK_LABEL_192;
                }
                com.pf.common.utility.m.e("CameraCtrl", "Can not decode image buffer to ImageBufferWrapper.");
                abyte0 = BitmapFactory.decodeStream(new ByteArrayInputStream(abyte0));
                if (!com.cyberlink.youcammakeup.utility.aa.b(abyte0))
                {
                    throw new DecodeJpegBufferException("Can not decode image buffer to Bitmap.");
                }
                obj = new ImageBufferWrapper();
                ((ImageBufferWrapper) (obj)).a(abyte0);
                com.cyberlink.youcammakeup.utility.aa.a(abyte0);
                ViewEngine.a().a(-7L, ((ImageBufferWrapper) (obj)));
                ((ImageBufferWrapper) (obj)).m();
                StatusManager.j().a(-7L, com.cyberlink.youcammakeup.camera.CameraCtrl.a);
                com.cyberlink.youcammakeup.camera.CameraCtrl.c(a).set(false);
                com.cyberlink.youcammakeup.camera.CameraCtrl.f(a).a();
                return;
                Exception exception1;
                exception1;
                ((ImageBufferWrapper) (obj)).m();
                throw new DecodeJpegBufferException("Can not copy Bitmap buffer to ImageBufferWrapper.");
                Exception exception;
                exception;
                com.cyberlink.youcammakeup.utility.aa.a(abyte0);
                throw exception;
            }

            public void onPictureTaken(byte abyte0[], Camera camera)
            {
                boolean flag;
                if (abyte0 != null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                com.pf.common.utility.m.b("JPG", String.valueOf(flag));
                if (!com.cyberlink.youcammakeup.camera.CameraCtrl.a(a).hasMessages(0x12ce79b9))
                {
                    return;
                }
                com.cyberlink.youcammakeup.camera.CameraCtrl.a(a).removeMessages(0x12ce79b9);
                if (abyte0 == null)
                {
                    com.cyberlink.youcammakeup.camera.CameraCtrl.b(a);
                    return;
                } else
                {
                    (new AsyncTask(this, abyte0) {

                        final byte a[];
                        final _cls1 b;

                        protected transient Void a(Void avoid[])
                        {
                            com.cyberlink.youcammakeup.camera._cls1.a(b, a);
                            return null;
                        }

                        protected void a(Void void1)
                        {
                            com.cyberlink.youcammakeup.camera.CameraCtrl.c(b.a).set(true);
                            com.cyberlink.youcammakeup.camera.CameraCtrl.a(false);
                            com.cyberlink.youcammakeup.camera.CameraCtrl.a(b.a, false);
                            com.cyberlink.youcammakeup.camera.CameraCtrl.b(b.a, true);
                            com.cyberlink.youcammakeup.camera.CameraCtrl.d(b.a).c();
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
                b = _pcls1;
                a = abyte0;
                super();
            }
                    }).execute(new Void[0]);
                    return;
                }
            }

            
            {
                a = CameraCtrl.this;
                super();
            }
        };
        W = new af() {

            final CameraCtrl a;

            public void a(com.cyberlink.youcammakeup.widgetpool.ICameraPanel.FlingDirection flingdirection)
            {
                if (CameraCtrl.g(a) instanceof ICameraPanel)
                {
                    ((ICameraPanel)CameraCtrl.g(a)).a(flingdirection);
                }
            }

            
            {
                a = CameraCtrl.this;
                super();
            }
        };
        Z = new Runnable() {

            final CameraCtrl a;

            public void run()
            {
                CameraCtrl.h(a).setVisibility(4);
                CameraCtrl.i(a).setText("");
            }

            
            {
                a = CameraCtrl.this;
                super();
            }
        };
    }

    static void o(CameraCtrl cameractrl)
    {
        cameractrl.n();
    }

    private void p()
    {
        d = ah.findViewById(0x7f0c008c);
        e = (FocusAreaView)ah.findViewById(0x7f0c008f);
        j = ah.findViewById(0x7f0c0090);
        f = (ImageView)ah.findViewById(0x7f0c00a4);
        g = (CameraZoomView)ah.findViewById(0x7f0c008e);
        h = ah.findViewById(0x7f0c0099);
        i = (TextView)ah.findViewById(0x7f0c009b);
        k = (TextView)ah.findViewById(0x7f0c0093);
        l = ah.findViewById(0x7f0c0096);
        m = ah.findViewById(0x7f0c0097);
        n = ah.findViewById(0x7f0c0098);
        o = ah.findViewById(0x7f0c00a1);
        p = ah.findViewById(0x7f0c0094);
        q = ah.findViewById(0x7f0c0095);
        r = ah.findViewById(0x7f0c00a2);
        u = (ImageView)ah.findViewById(0x7f0c00a0);
        u.setOnClickListener(ay);
        if (LiveDemoConfigHelper.h().d())
        {
            s = (ImageView)ah.findViewById(0x7f0c0132);
            t = (IndicatorView)ah.findViewById(0x7f0c012e);
            if (t != null)
            {
                t.setOrientation(com.cyberlink.youcammakeup.widgetpool.common.IndicatorView.Orientation.b);
            }
        }
        v = ag.getFragmentManager();
        w = new CameraFlashModeDialog();
        x = new CameraSettingDialog();
        F = new com.cyberlink.youcammakeup.camera.m(ag, X, e);
        V = new com.cyberlink.youcammakeup.camera.ae(ag, F, g, W);
        an.a(new t() {

            final CameraCtrl a;

            public void a(LiveCategoryCtrl.LiveCategory livecategory)
            {
                com.cyberlink.youcammakeup.camera.CameraCtrl.a(a, livecategory);
            }

            
            {
                a = CameraCtrl.this;
                super();
            }
        });
        ad = ah.findViewById(0x7f0c009c);
        a(com.cyberlink.youcammakeup.camera.LiveCategoryCtrl.a);
        an.a(com.cyberlink.youcammakeup.camera.LiveCategoryCtrl.a);
    }

    static boolean p(CameraCtrl cameractrl)
    {
        return cameractrl.H;
    }

    static Camera q(CameraCtrl cameractrl)
    {
        return cameractrl.E;
    }

    private void q()
    {
        ai.setKeepScreenOn(true);
        ai.getHolder().addCallback(this);
        ai.setRenderFramerateListener(new ab() {

            final CameraCtrl a;

            public void a(float f1)
            {
                if (NetworkManager.f() || LiveDemoConfigHelper.h().o())
                {
                    android.os.Message message = com.cyberlink.youcammakeup.camera.CameraCtrl.a(a).obtainMessage(0x6f396c3d, String.valueOf(f1));
                    com.cyberlink.youcammakeup.camera.CameraCtrl.a(a).sendMessage(message);
                }
                if (f1 < 10F && CameraCtrl.l(a) && !CameraCtrl.l().get() && !com.cyberlink.youcammakeup.camera.CameraCtrl.m().compareAndSet(true, false))
                {
                    com.cyberlink.youcammakeup.camera.CameraCtrl.c(a, true);
                }
            }

            
            {
                a = CameraCtrl.this;
                super();
            }
        });
        e.setOnTouchListener(V);
        n.setOnClickListener(new android.view.View.OnClickListener() {

            final CameraCtrl a;

            public void onClick(View view)
            {
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKLiveCamEvent(true, 0L, 0L, com.cyberlink.youcammakeup.clflurry.YMKLiveCamEvent.Operation.i, false, false));
                if (com.cyberlink.youcammakeup.camera.CameraCtrl.a(false, true))
                {
                    com.cyberlink.youcammakeup.camera.CameraCtrl.a(a, false);
                    com.cyberlink.youcammakeup.camera.CameraCtrl.d(a).e();
                }
            }

            
            {
                a = CameraCtrl.this;
                super();
            }
        });
        o.setOnClickListener(new android.view.View.OnClickListener() {

            final CameraCtrl a;

            public void onClick(View view)
            {
                long l1 = System.currentTimeMillis();
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKLiveCamEvent(true, com.cyberlink.youcammakeup.camera.CameraCtrl.m(a), l1, com.cyberlink.youcammakeup.clflurry.YMKLiveCamEvent.Operation.f, true, true));
                YMKSavingPageEvent.b(com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.Source.a.a());
                YMKFeatureRoomLookEvent.b(com.cyberlink.youcammakeup.clflurry.YMKFeatureRoomLookEvent.Source.a.a());
                CameraCtrl.n(a);
            }

            
            {
                a = CameraCtrl.this;
                super();
            }
        });
        p.setOnClickListener(new android.view.View.OnClickListener() {

            final CameraCtrl a;

            public void onClick(View view)
            {
                long l1 = System.currentTimeMillis();
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKLiveCamEvent(true, com.cyberlink.youcammakeup.camera.CameraCtrl.m(a), l1, com.cyberlink.youcammakeup.clflurry.YMKLiveCamEvent.Operation.g, false, false));
                if (com.cyberlink.youcammakeup.camera.CameraCtrl.a(false, true))
                {
                    com.cyberlink.youcammakeup.camera.CameraCtrl.o(a);
                }
            }

            
            {
                a = CameraCtrl.this;
                super();
            }
        });
        l.setVisibility(4);
        l.setOnClickListener(new android.view.View.OnClickListener() {

            final CameraCtrl a;

            public void onClick(View view)
            {
                boolean flag;
                flag = true;
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKLiveCamEvent(true, 0L, 0L, com.cyberlink.youcammakeup.clflurry.YMKLiveCamEvent.Operation.k, false, false));
                if (!com.cyberlink.youcammakeup.camera.CameraCtrl.p(a) || !com.cyberlink.youcammakeup.camera.CameraCtrl.a(false, true)) goto _L2; else goto _L1
_L1:
                view = CameraCtrl.q(a).getParameters();
                if (!CameraCtrl.r(a))
                {
                    break MISSING_BLOCK_LABEL_123;
                }
                view.setFlashMode("off");
_L3:
                CameraCtrl.q(a).setParameters(view);
                if (CameraCtrl.r(a))
                {
                    CameraCtrl.s(a).setSelected(false);
                } else
                {
                    CameraCtrl.s(a).setSelected(true);
                }
                view = a;
                if (CameraCtrl.r(a))
                {
                    flag = false;
                }
                com.cyberlink.youcammakeup.camera.CameraCtrl.d(view, flag);
                com.cyberlink.youcammakeup.camera.CameraCtrl.a(false);
_L2:
                return;
                try
                {
                    view.setFlashMode("torch");
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    com.pf.common.utility.m.b("CameraCtrl", "flashModeContainer::Onclick", view);
                    return;
                }
                  goto _L3
            }

            
            {
                a = CameraCtrl.this;
                super();
            }
        });
        r.setOnClickListener(new android.view.View.OnClickListener() {

            final CameraCtrl a;

            public void onClick(View view)
            {
                CameraCtrl cameractrl = a;
                if (com.cyberlink.youcammakeup.camera.CameraCtrl.j(a) != com.cyberlink.youcammakeup.camera.PanelDisplayStatus.a)
                {
                    view = com.cyberlink.youcammakeup.camera.PanelDisplayStatus.a;
                } else
                {
                    view = com.cyberlink.youcammakeup.camera.PanelDisplayStatus.b;
                }
                com.cyberlink.youcammakeup.camera.CameraCtrl.a(cameractrl, view);
            }

            
            {
                a = CameraCtrl.this;
                super();
            }
        });
        q.setOnClickListener(new android.view.View.OnClickListener() {

            final CameraCtrl a;

            public void onClick(View view)
            {
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKLiveCamEvent(true, 0L, 0L, com.cyberlink.youcammakeup.clflurry.YMKLiveCamEvent.Operation.h, false, false));
                if (com.cyberlink.youcammakeup.camera.CameraCtrl.a(false, true))
                {
                    com.cyberlink.youcammakeup.camera.CameraCtrl.a(a, false);
                    CameraCtrl.t(a).setSelected(true);
                    com.cyberlink.youcammakeup.utility.o.a(com.cyberlink.youcammakeup.camera.CameraCtrl.u(a), CameraCtrl.v(a), "CameraSettingDialog");
                }
            }

            
            {
                a = CameraCtrl.this;
                super();
            }
        });
        w.a(new com.cyberlink.youcammakeup.camera.f() {

            final CameraCtrl a;

            public void a(CameraFlashModeDialog.FlashMode flashmode)
            {
                if (CameraCtrl.q(a) != null)
                {
                    android.hardware.Camera.Parameters parameters = CameraCtrl.q(a).getParameters();
                    com.cyberlink.youcammakeup.camera.CameraCtrl.a(a, parameters, flashmode);
                    com.cyberlink.youcammakeup.camera.o.a(CameraCtrl.q(a), parameters);
                }
            }

            
            {
                a = CameraCtrl.this;
                super();
            }
        });
        w.a(new android.content.DialogInterface.OnDismissListener() {

            final CameraCtrl a;

            public void onDismiss(DialogInterface dialoginterface)
            {
                com.cyberlink.youcammakeup.camera.CameraCtrl.w(a).setSelected(false);
                com.cyberlink.youcammakeup.camera.CameraCtrl.a(false);
                com.cyberlink.youcammakeup.camera.CameraCtrl.a(a, true);
            }

            
            {
                a = CameraCtrl.this;
                super();
            }
        });
        x.a(new h() {

            final CameraCtrl a;

            public void a(CameraSettingDialog.Setting setting)
            {
                com.cyberlink.youcammakeup.camera.CameraCtrl.a(a, setting, true);
            }

            
            {
                a = CameraCtrl.this;
                super();
            }
        });
        x.a(new android.content.DialogInterface.OnDismissListener() {

            final CameraCtrl a;

            public void onDismiss(DialogInterface dialoginterface)
            {
                CameraCtrl.t(a).setSelected(false);
                com.cyberlink.youcammakeup.camera.CameraCtrl.a(false);
                com.cyberlink.youcammakeup.camera.CameraCtrl.a(a, true);
            }

            
            {
                a = CameraCtrl.this;
                super();
            }
        });
        x.a(new g() {

            final CameraCtrl a;

            public void a()
            {
                if (CameraCtrl.v(a).b() == com.cyberlink.youcammakeup.camera.CameraSettingDialog.Setting.c)
                {
                    IntroDialogUtils.a(com.cyberlink.youcammakeup.camera.CameraCtrl.x(a), null, null, com.cyberlink.youcammakeup.utility.IntroDialogUtils.IntroDialogType.E, true);
                }
            }

            
            {
                a = CameraCtrl.this;
                super();
            }
        });
        F.a(new n() {

            final CameraCtrl a;

            public void a()
            {
                com.cyberlink.youcammakeup.camera.CameraCtrl.a(false);
                com.cyberlink.youcammakeup.camera.CameraCtrl.y(a).c();
            }

            public void b()
            {
                com.cyberlink.youcammakeup.camera.CameraCtrl.y(a).a(false);
                com.cyberlink.youcammakeup.camera.CameraCtrl.y(a).b();
            }

            public void c()
            {
                com.cyberlink.youcammakeup.camera.CameraCtrl.y(a).a(true);
                com.cyberlink.youcammakeup.camera.CameraCtrl.y(a).b();
            }

            
            {
                a = CameraCtrl.this;
                super();
            }
        });
        j.setOnTouchListener(new android.view.View.OnTouchListener() {

            final CameraCtrl a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                return false;
            }

            
            {
                a = CameraCtrl.this;
                super();
            }
        });
    }

    private void r()
    {
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.intent.action.SCREEN_ON");
        intentfilter.addAction("android.intent.action.SCREEN_OFF");
        intentfilter.addAction("android.intent.action.CAMERA_BUTTON");
        Activity activity = ag;
        BroadcastReceiver broadcastreceiver = new BroadcastReceiver() {

            final CameraCtrl a;

            public void onReceive(Context context, Intent intent)
            {
                if (!intent.getAction().equals("android.intent.action.SCREEN_OFF")) goto _L2; else goto _L1
_L1:
                com.cyberlink.youcammakeup.camera.CameraCtrl.z(a).set(false);
_L4:
                com.pf.common.utility.m.e("isScreenOn", String.valueOf(com.cyberlink.youcammakeup.camera.CameraCtrl.z(a).get()));
                return;
_L2:
                if (intent.getAction().equals("android.intent.action.SCREEN_ON"))
                {
                    com.cyberlink.youcammakeup.camera.CameraCtrl.z(a).set(true);
                    com.cyberlink.youcammakeup.camera.CameraCtrl.c(a).set(true);
                } else
                if (intent.getAction().equals("android.intent.action.CAMERA_BUTTON"))
                {
                    CameraCtrl.n(a);
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                a = CameraCtrl.this;
                super();
            }
        };
        z = broadcastreceiver;
        activity.registerReceiver(broadcastreceiver, intentfilter);
    }

    static boolean r(CameraCtrl cameractrl)
    {
        return cameractrl.R;
    }

    static View s(CameraCtrl cameractrl)
    {
        return cameractrl.m;
    }

    private void s()
    {
        I = x.i();
        a(x.b(), false);
        a(com.cyberlink.youcammakeup.camera.CameraSettingDialog.Setting.d, false);
        a(CameraSettingDialog.Setting.e, false);
        a(com.cyberlink.youcammakeup.camera.CameraSettingDialog.Setting.f, false);
        a(CameraSettingDialog.Setting.h, false);
        a(CameraSettingDialog.Setting.g, false);
        Q = com.cyberlink.youcammakeup.kernelctrl.z.a("CAMERA_SETTING_GPS", false, Globals.d());
        S = com.cyberlink.youcammakeup.kernelctrl.z.a("AUTO_FLIP_PHOTO", true, Globals.d());
    }

    static View t(CameraCtrl cameractrl)
    {
        return cameractrl.q;
    }

    private void t()
    {
        float f1;
        android.view.WindowManager.LayoutParams layoutparams;
        int i1;
        try
        {
            i1 = android.provider.Settings.System.getInt(ag.getContentResolver(), "screen_brightness");
        }
        catch (android.provider.Settings.SettingNotFoundException settingnotfoundexception)
        {
            com.pf.common.utility.m.b("CameraCtrl", "setupScreenBrightness", settingnotfoundexception);
            return;
        }
        f1 = (float)i1 / 255F;
        layoutparams = ag.getWindow().getAttributes();
        layoutparams.screenBrightness = (f1 + 1.0F) / 2.0F;
        ag.getWindow().setAttributes(layoutparams);
    }

    static Activity u(CameraCtrl cameractrl)
    {
        return cameractrl.ag;
    }

    private void u()
    {
label0:
        {
            String s1 = ca.b().a("%d");
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKMakeupStayTimeEvent(com.cyberlink.youcammakeup.clflurry.YMKMakeupStayTimeEvent.Button.b, s1));
            com.cyberlink.youcammakeup.flurry.a.a(new com.cyberlink.youcammakeup.flurry.YMKMakeupStayTimeEvent(com.cyberlink.youcammakeup.flurry.YMKMakeupStayTimeEvent.Button.b, s1));
            if (E != null && a(false, true))
            {
                c(false);
                if (!K)
                {
                    break label0;
                }
                U.b();
            }
            return;
        }
        U.c();
    }

    static CameraSettingDialog v(CameraCtrl cameractrl)
    {
        return cameractrl.x;
    }

    private void v()
    {
        Runnable runnable = new Runnable() {

            final CameraCtrl a;

            public void run()
            {
                Toast.makeText(com.cyberlink.youcammakeup.camera.CameraCtrl.u(a), 0x7f070381, 0).show();
                com.cyberlink.youcammakeup.camera.CameraCtrl.o(a);
            }

            
            {
                a = CameraCtrl.this;
                super();
            }
        };
        ag.runOnUiThread(runnable);
    }

    static View w(CameraCtrl cameractrl)
    {
        return cameractrl.l;
    }

    private void w()
    {
        com.pf.common.utility.m.e("CameraCtrl", "reopenCamera");
        ag.runOnUiThread(new Runnable() {

            final CameraCtrl a;

            public void run()
            {
                CameraCtrl.e(a, false);
            }

            
            {
                a = CameraCtrl.this;
                super();
            }
        });
        h();
        if (al != null)
        {
            al.e();
        }
        z();
    }

    static FragmentManager x(CameraCtrl cameractrl)
    {
        return cameractrl.v;
    }

    private void x()
    {
        com.pf.common.utility.m.e("CameraCtrl", "changeCameraFacing");
        ag.runOnUiThread(new Runnable() {

            final CameraCtrl a;

            public void run()
            {
                CameraCtrl.e(a, false);
            }

            
            {
                a = CameraCtrl.this;
                super();
            }
        });
        h();
        if (al != null)
        {
            al.e();
        }
        Globals.d(new Runnable() {

            final CameraCtrl a;

            public void run()
            {
                CameraCtrl cameractrl = a;
                boolean flag;
                if (!CameraCtrl.e(a))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                com.cyberlink.youcammakeup.camera.CameraCtrl.f(cameractrl, flag);
                com.cyberlink.youcammakeup.camera.CameraCtrl.d(a).b();
                com.cyberlink.youcammakeup.camera.CameraCtrl.a(false);
            }

            
            {
                a = CameraCtrl.this;
                super();
            }
        });
    }

    static e y(CameraCtrl cameractrl)
    {
        return cameractrl.U;
    }

    private void y()
    {
        if (IntroDialogUtils.a(v, aw, new com.cyberlink.youcammakeup.widgetpool.dialogs.o() {

        final CameraCtrl a;

        public void a()
        {
            com.cyberlink.youcammakeup.camera.CameraCtrl.c(a, false);
        }

            
            {
                a = CameraCtrl.this;
                super();
            }
    }, com.cyberlink.youcammakeup.utility.IntroDialogUtils.IntroDialogType.G, true))
        {
            a(com.cyberlink.youcammakeup.camera.PanelDisplayStatus.a);
            return;
        } else
        {
            e(false);
            return;
        }
    }

    static AtomicBoolean z(CameraCtrl cameractrl)
    {
        return cameractrl.A;
    }

    private void z()
    {
        boolean flag = true;
        this;
        JVM INSTR monitorenter ;
        if (E != null || !C.get() || !A.get()) goto _L2; else goto _L1
_L1:
        boolean flag1 = B.get();
        if (flag1) goto _L3; else goto _L2
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L3:
        if (!al.a()) goto _L2; else goto _L4
_L4:
        com.pf.common.utility.m.e("CameraCtrl", "startCamera");
        c(false);
        float f1;
        Object obj;
        int i1;
        if (I)
        {
            i1 = 0;
        } else
        {
            i1 = 1;
        }
        G = com.cyberlink.youcammakeup.camera.o.d(i1);
        E = Camera.open(G);
        al.a(E, G);
        if (com.cyberlink.youcammakeup.camera.o.a(G) != 0)
        {
            flag = false;
        }
        I = flag;
        x.b(I);
        com.pf.common.utility.m.e("FacingBack", String.valueOf(I));
        al.g();
        f1 = com.cyberlink.youcammakeup.kernelctrl.z.e("GPU_BENCHMARK_FPS", Globals.d());
        obj = com.cyberlink.youcammakeup.camera.u.a(E.getParameters().getSupportedPreviewSizes(), d.getWidth(), d.getHeight(), f1);
        if ((((v) (obj)).a.width != 640 || ((v) (obj)).a.height != 480) && ((v) (obj)).b != -1F) goto _L6; else goto _L5
_L5:
        ao = true;
_L14:
        obj = E.getParameters();
        if (!com.cyberlink.youcammakeup.camera.o.a(((android.hardware.Camera.Parameters) (obj)))) goto _L8; else goto _L7
_L7:
        H = true;
        R = false;
_L15:
        if (!LiveDemoConfigHelper.h().k())
        {
            break MISSING_BLOCK_LABEL_534;
        }
        if (!com.cyberlink.youcammakeup.camera.o.b(((android.hardware.Camera.Parameters) (obj)))) goto _L10; else goto _L9
_L9:
        if (!com.cyberlink.youcammakeup.camera.o.a) goto _L12; else goto _L11
_L11:
        ((android.hardware.Camera.Parameters) (obj)).setFocusMode("continuous-picture");
_L10:
        com.cyberlink.youcammakeup.camera.o.a(E, ((android.hardware.Camera.Parameters) (obj)));
        if (com.cyberlink.youcammakeup.camera.o.a && I)
        {
            E.setAutoFocusMoveCallback(new android.hardware.Camera.AutoFocusMoveCallback() {

                final CameraCtrl a;

                public void onAutoFocusMoving(boolean flag2, Camera camera)
                {
                    com.pf.common.utility.m.e("onAutoFocusMoving", String.valueOf(flag2));
                    if (flag2)
                    {
                        CameraActivity.b(true);
                        return;
                    } else
                    {
                        CameraActivity.b(false);
                        return;
                    }
                }

            
            {
                a = CameraCtrl.this;
                super();
            }
            });
        }
_L16:
        A();
          goto _L2
        obj;
        com.pf.common.utility.m.b("CameraCtrl", "startCamera", ((Throwable) (obj)));
        if (E != null)
        {
            E.release();
            E = null;
        }
        ag.runOnUiThread(new Runnable() {

            final CameraCtrl a;

            public void run()
            {
                try
                {
                    Toast.makeText(com.cyberlink.youcammakeup.camera.CameraCtrl.u(a), 0x7f0704eb, 0).show();
                }
                catch (Exception exception1) { }
                com.cyberlink.youcammakeup.camera.CameraCtrl.o(a);
            }

            
            {
                a = CameraCtrl.this;
                super();
            }
        });
          goto _L2
        obj;
        throw obj;
        obj;
        obj = E;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_419;
        }
        try
        {
            E.release();
        }
        catch (Exception exception) { }
        E = null;
        if (!com.cyberlink.youcammakeup.utility.al.a("com.huawei.pmplus") && !com.cyberlink.youcammakeup.utility.al.a("com.lbe.security.miui") && !Build.MANUFACTURER.equalsIgnoreCase("Xiaomi") && !Build.MANUFACTURER.equalsIgnoreCase("HUAWEI"))
        {
            break MISSING_BLOCK_LABEL_489;
        }
        af.post(new Runnable() {

            final CameraCtrl a;

            public void run()
            {
                Toast.makeText(com.cyberlink.youcammakeup.camera.CameraCtrl.u(a), 0x7f07037d, 1).show();
            }

            
            {
                a = CameraCtrl.this;
                super();
            }
        });
_L13:
        n();
          goto _L2
        af.post(new Runnable() {

            final CameraCtrl a;

            public void run()
            {
                Toast.makeText(com.cyberlink.youcammakeup.camera.CameraCtrl.u(a), 0x7f07037d, 1).show();
            }

            
            {
                a = CameraCtrl.this;
                super();
            }
        });
          goto _L13
_L6:
        ao = false;
          goto _L14
_L8:
        H = false;
          goto _L15
_L12:
        ((android.hardware.Camera.Parameters) (obj)).setFocusMode("auto");
          goto _L10
        if (com.cyberlink.youcammakeup.camera.o.b(((android.hardware.Camera.Parameters) (obj))))
        {
            ((android.hardware.Camera.Parameters) (obj)).setFocusMode("auto");
        }
        com.cyberlink.youcammakeup.camera.o.a(E, ((android.hardware.Camera.Parameters) (obj)));
          goto _L16
    }

    public void a()
    {
        if (aa instanceof ICameraPanel)
        {
            ((ICameraPanel)aa).a();
        }
    }

    public void a(int i1)
    {
        IndicatorView indicatorview = t;
        indicatorview.setCount(i1);
        indicatorview.setIndex(0);
        Object obj = ag.getResources().getDisplayMetrics();
        float f1 = TypedValue.applyDimension(1, 8, ((android.util.DisplayMetrics) (obj)));
        indicatorview.a((int)(2.25F * f1), 0);
        obj = ag.getResources().getDrawable(0x7f0208b6);
        android.graphics.drawable.Drawable drawable = ag.getResources().getDrawable(0x7f0208b7);
        indicatorview.a(((android.graphics.drawable.Drawable) (obj)), f1, f1, 0);
        indicatorview.b(drawable, f1, f1, 0);
    }

    public void a(com.cyberlink.youcammakeup.kernelctrl.b.b b1)
    {
        a(new Runnable() {

            final CameraCtrl a;

            public void run()
            {
                com.pf.common.utility.m.b("CameraCtrl", "applyOnPreview");
                CLMakeupLiveFilter clmakeuplivefilter = CameraCtrl.M(a).i();
                if (LiveDemoConfigHelper.h().d())
                {
                    clmakeuplivefilter.a(LiveDemoConfigHelper.h().r());
                }
                CameraCtrl.M(a).h();
                CameraCtrl.M(a).a(CameraCtrl.D(a));
                CameraCtrl.M(a).b(CameraCtrl.N(a));
                if (clmakeuplivefilter != CameraCtrl.O(a).getFilter())
                {
                    CameraCtrl.O(a).setFilter(clmakeuplivefilter);
                }
            }

            
            {
                a = CameraCtrl.this;
                super();
            }
        });
    }

    public void a(Runnable runnable)
    {
        ai.queueEvent(runnable);
    }

    public void a(String s1)
    {
        h.removeCallbacks(Z);
        h.setVisibility(0);
        i.setText(s1);
        h.postDelayed(Z, 1000L);
        s1 = ObjectAnimator.ofFloat(i, "scaleX", b);
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(i, "scaleY", b);
        ObjectAnimator objectanimator1 = ObjectAnimator.ofFloat(i, "alpha", c);
        AnimatorSet animatorset = (new AnimatorSet()).setDuration(333L);
        animatorset.playTogether(new Animator[] {
            s1, objectanimator, objectanimator1
        });
        animatorset.start();
    }

    public boolean a(int i1, KeyEvent keyevent)
    {
        if (i1 == 27 || i1 == 66 || i1 == 24 || i1 == 25)
        {
            u();
            return true;
        } else
        {
            return false;
        }
    }

    public void b()
    {
        com.pf.common.utility.m.e("CameraCtrl", "Create");
        y = ag.getWindowManager().getDefaultDisplay();
        X = new ah(ag);
        Y = new com.cyberlink.youcammakeup.camera.a(this);
        ae = new d();
        o();
        p();
        q();
        r();
        s();
        t();
        StatusManager.j().g(false);
        StatusManager.j().c(null);
        com.cyberlink.youcammakeup.widgetpool.panel.c.p.a().b();
        al.a(com.cyberlink.youcammakeup.kernelctrl.z.e("GPU_BENCHMARK_FPS", Globals.d()));
        al.a(ae);
        y();
    }

    public void b(int i1)
    {
        t.setIndex(i1);
    }

    public void b(String s1)
    {
        try
        {
            Bitmap bitmap = BitmapFactory.decodeStream(ag.getAssets().open(s1.substring("assets://".length())));
            s.setImageBitmap(bitmap);
            return;
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            s1 = BitmapFactory.decodeFile(s1);
            s.setImageBitmap(s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            com.pf.common.utility.m.b("CameraCtrl", "setDemoThumbnail", s1);
        }
    }

    public boolean b(int i1, KeyEvent keyevent)
    {
        if (i1 == 24 || i1 == 25 || i1 == 27 || i1 == 4 && i())
        {
            return true;
        }
        if (i1 == 4)
        {
            n();
            return true;
        } else
        {
            return false;
        }
    }

    public void c()
    {
        com.pf.common.utility.m.e("CameraCtrl", "Start");
        e.a();
    }

    public void d()
    {
        com.pf.common.utility.m.e("CameraCtrl", "Resume");
        av = System.currentTimeMillis();
        com.cyberlink.youcammakeup.clflurry.b.a(new YMKLiveCamEvent(false, 0L, 0L, com.cyberlink.youcammakeup.clflurry.YMKLiveCamEvent.Operation.a, false, false));
        y();
        a(false);
        c(false);
        d(true);
        if (Camera.getNumberOfCameras() == 1)
        {
            n.setVisibility(4);
        }
        A.set(true);
        B.set(true);
        Y.b();
        al.b();
        if (C.get())
        {
            D.b();
        } else
        {
            b(false);
            ai.setVisibility(4);
            ai.setVisibility(0);
        }
        if (Q)
        {
            ak.a(true);
        }
        F();
    }

    public void e()
    {
        com.pf.common.utility.m.e("CameraCtrl", "Pause");
        ak.a(false);
        Globals.d().i().i(ag);
        af.removeMessages(0x12ce79b9);
        D.d();
        A.set(false);
        B.set(false);
        C.set(false);
        o.setSelected(false);
        g.setCamera(null);
        U.a();
        b(false);
        com.cyberlink.youcammakeup.kernelctrl.z.a("PANEL_DISPLAY_STATUS_KEY", ac.name(), Globals.d());
        if (al != null)
        {
            al.e();
        }
        al.c();
    }

    public void f()
    {
        com.pf.common.utility.m.e("CameraCtrl", "Stop");
        e.b();
    }

    public void g()
    {
        com.pf.common.utility.m.e("CameraCtrl", "Destroy");
        D.f();
        ag.unregisterReceiver(z);
        X.a();
        al.d();
        j.setOnTouchListener(null);
    }

    public void h()
    {
        this;
        JVM INSTR monitorenter ;
        Camera camera = E;
        if (camera != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        com.pf.common.utility.m.e("CameraCtrl", "stopCamera");
        F.a(null);
        E.stopPreview();
_L3:
        al.f();
_L4:
        E.release();
_L5:
        E = null;
          goto _L1
        Object obj;
        obj;
        throw obj;
        obj;
        com.pf.common.utility.m.b("CameraCtrl", "stopCamera", ((Throwable) (obj)));
          goto _L3
        obj;
        com.pf.common.utility.m.b("CameraCtrl", "stopCamera", ((Throwable) (obj)));
          goto _L4
        obj;
        com.pf.common.utility.m.b("CameraCtrl", "stopCamera", ((Throwable) (obj)));
          goto _L5
    }

    public u j()
    {
        if (ai != null)
        {
            return ai.getFilter();
        } else
        {
            return null;
        }
    }

    public com.cyberlink.youcammakeup.camera.y k()
    {
        return al;
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i1, int j1, int k1)
    {
        com.pf.common.utility.m.e("CameraCtrl", "surfaceChanged");
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
        com.pf.common.utility.m.e("CameraCtrl", "surfaceCreated");
        if (A.get() && B.get())
        {
            C.set(true);
            D.b();
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
        com.pf.common.utility.m.e("CameraCtrl", "surfaceDestroyed");
        C.set(false);
        D.d();
        b(false);
    }


    private class PanelDisplayStatus extends Enum
    {

        public static final PanelDisplayStatus a;
        public static final PanelDisplayStatus b;
        public static final PanelDisplayStatus c;
        private static final PanelDisplayStatus d[];

        public static PanelDisplayStatus valueOf(String s1)
        {
            return (PanelDisplayStatus)Enum.valueOf(com/cyberlink/youcammakeup/camera/CameraCtrl$PanelDisplayStatus, s1);
        }

        public static PanelDisplayStatus[] values()
        {
            return (PanelDisplayStatus[])d.clone();
        }

        static 
        {
            a = new PanelDisplayStatus("OPEN", 0);
            b = new PanelDisplayStatus("CLOSE", 1);
            c = new PanelDisplayStatus("NONE", 2);
            d = (new PanelDisplayStatus[] {
                a, b, c
            });
        }

        private PanelDisplayStatus(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
