// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip.fragment;

import aeu;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.fotoable.ad.FotoAdFactory;
import com.fotoable.ad.NativeAdWrapper;
import com.fotoable.comlib.util.ImageCache;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.pipcamera.activity.pip.PipRealTimeCameraActivity;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.ResourceOnlineLibrary.Manage.OnlineGridViewAdapter;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMagComposeManager;
import com.wantu.imagerender.ImageGLSurfaceView;
import com.wantu.model.res.EResType;
import com.wantu.model.res.TResInfo;
import com.wantu.model.res.pip.TDFSceneInfo;
import com.wantu.piprender.ESceneCatalog;
import com.wantu.piprender.ESceneMode;
import com.wantu.service.pip.AsynPIPCropImageTask;
import com.wantu.view.TPipStyleListScrollView;
import ev;
import ew;
import fo;
import fq;
import gr;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import jp.co.cyberagent.android.gpuimage.camera.PipCameraGLSurfaceView;
import jw;
import kb;
import kf;
import org.apache.http.Header;
import org.json.JSONObject;
import pb;
import sd;
import se;
import sf;
import sg;
import so;
import sp;
import sw;
import tf;
import tl;
import ts;
import tu;
import tv;
import tw;
import ty;
import tz;
import ua;
import ub;
import uc;
import uj;
import uk;
import uv;
import uw;
import ye;
import yf;
import yy;

public class PipCameraFragment extends Fragment
    implements aeu, android.view.SurfaceHolder.Callback, sp, tf, tw, ye, yy
{

    private Handler A;
    private OnlineGridViewAdapter B;
    private GestureDetector C;
    private boolean D;
    private boolean E;
    private fq F;
    private ArrayList G;
    private LinkedHashMap H;
    private TResInfo I;
    private View J;
    private int K;
    private int L;
    private int M;
    private android.view.View.OnClickListener N;
    private android.view.View.OnClickListener O;
    private android.view.View.OnClickListener P;
    private android.view.View.OnClickListener Q;
    private SensorManager R;
    private Sensor S;
    private float T;
    sw a;
    public boolean b;
    ExecutorService c;
    SensorEventListener d;
    private String e;
    private ImageGLSurfaceView f;
    private PipCameraGLSurfaceView g;
    private Button h;
    private Button i;
    private ImageView j;
    private ImageView k;
    private ImageView l;
    private TDFSceneInfo m;
    private String n;
    private String o;
    private TPipStyleListScrollView p;
    private PipRealTimeCameraActivity q;
    private int r;
    private int s;
    private Button t;
    private RelativeLayout u;
    private BroadcastReceiver v;
    private tv w;
    private View x;
    private ListView y;
    private int z;

    public PipCameraFragment()
    {
        e = "ACACHE_NEWPIP_ONLINELIB_JSON_TAG";
        n = null;
        o = null;
        s = 612;
        v = null;
        b = false;
        B = null;
        D = true;
        E = false;
        G = new ArrayList();
        H = new LinkedHashMap();
        M = 0;
        N = new android.view.View.OnClickListener() {

            final PipCameraFragment a;

            public void onClick(View view)
            {
                if (PipCameraFragment.q(a).getFlashLightList().size() == 0)
                {
                    return;
                } else
                {
                    PipCameraFragment.r(a);
                    PipCameraFragment.d(a, PipCameraFragment.p(a) % PipCameraFragment.q(a).getFlashLightList().size());
                    PipCameraFragment.c(a, PipCameraFragment.p(a));
                    FlurryAgent.logEvent("ActivityCamera_BtnFlash");
                    return;
                }
            }

            
            {
                a = PipCameraFragment.this;
                super();
            }
        };
        O = new android.view.View.OnClickListener() {

            final PipCameraFragment a;

            public void onClick(View view)
            {
                a.c();
            }

            
            {
                a = PipCameraFragment.this;
                super();
            }
        };
        P = new android.view.View.OnClickListener() {

            final PipCameraFragment a;

            public void onClick(View view)
            {
                FlurryAgent.logEvent("ActivityCamera_BtnSwitch");
                PipCameraFragment.q(a).switchCamera();
                PipCameraFragment.b(a, PipCameraFragment.d(a).i());
                if (PipCameraFragment.s(a) != null && PipCameraFragment.s(a).getName() != null)
                {
                    PipCameraFragment.c(a, PipCameraFragment.s(a));
                }
                PipCameraFragment.q(a).setIsTakingPhoto(false);
            }

            
            {
                a = PipCameraFragment.this;
                super();
            }
        };
        Q = new android.view.View.OnClickListener() {

            final PipCameraFragment a;

            public void onClick(View view)
            {
                PipCameraFragment.q(a).takePhoto();
            }

            
            {
                a = PipCameraFragment.this;
                super();
            }
        };
        c = Executors.newSingleThreadExecutor();
    }

    static float a(PipCameraFragment pipcamerafragment, float f1)
    {
        pipcamerafragment.T = f1;
        return f1;
    }

    private int a(int i1, int j1)
    {
        if (i1 == 1)
        {
            if (j1 < 300)
            {
                return 300;
            }
            return j1 >= 600 ? 640 : 640;
        }
        if (j1 < 900)
        {
            return 800;
        }
        return j1 >= 1200 ? 1280 : 960;
    }

    public static PipCameraFragment a()
    {
        return new PipCameraFragment();
    }

    static OnlineGridViewAdapter a(PipCameraFragment pipcamerafragment, OnlineGridViewAdapter onlinegridviewadapter)
    {
        pipcamerafragment.B = onlinegridviewadapter;
        return onlinegridviewadapter;
    }

    private void a(View view)
    {
        h = (Button)view.findViewById(0x7f0c01f7);
        j = (ImageView)view.findViewById(0x7f0c01f8);
        k = (ImageView)view.findViewById(0x7f0c0205);
        l = (ImageView)view.findViewById(0x7f0c01f9);
        h.setOnClickListener(new android.view.View.OnClickListener() {

            final PipCameraFragment a;

            public void onClick(View view1)
            {
                a.backBtnClicked(view1);
            }

            
            {
                a = PipCameraFragment.this;
                super();
            }
        });
        j.setOnClickListener(N);
        l.setOnClickListener(P);
        k.setOnClickListener(Q);
        p = (TPipStyleListScrollView)view.findViewById(0x7f0c0203);
        p.setVisibility(0);
        J = view.findViewById(0x7f0c01fe);
        J.setVisibility(4);
        Object obj1 = (new uw(getActivity())).a();
        Object obj = new ArrayList();
        obj1 = ((List) (obj1)).iterator();
        int i1 = 0;
        while (((Iterator) (obj1)).hasNext()) 
        {
            uv uv1 = (uv)((Iterator) (obj1)).next();
            TDFSceneInfo tdfsceneinfo1 = TDFSceneInfo.sceneByInfo(uv1.a(), uv1.c(), ESceneMode.SCENE_MODE1, EResType.ONLINE);
            int j1 = q.h().b(tdfsceneinfo1, ESceneCatalog.SCENE_RECTANGLE_SHAPE, ESceneMode.SCENE_MODE1);
            if (j1 >= 0)
            {
                tdfsceneinfo1 = q.h().a(j1, ESceneCatalog.SCENE_RECTANGLE_SHAPE, ESceneMode.SCENE_MODE1);
                q.h().a(j1, i1, ESceneCatalog.SCENE_RECTANGLE_SHAPE, ESceneMode.SCENE_MODE1);
                p.addPipItem(tdfsceneinfo1);
                i1++;
            } else
            {
                p.addPipItem(tdfsceneinfo1);
            }
            ((List) (obj)).add(uv1.a());
        }
        obj1 = q.h().a(ESceneCatalog.SCENE_RECTANGLE_SHAPE, ESceneMode.SCENE_MODE1);
        ((List) (obj1)).iterator();
        obj1 = ((List) (obj1)).iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break;
            }
            TDFSceneInfo tdfsceneinfo = (TDFSceneInfo)((Iterator) (obj1)).next();
            if (!((List) (obj)).contains(tdfsceneinfo.getName()))
            {
                p.addPipItem(tdfsceneinfo);
            }
        } while (true);
        p.setCallback(this);
        i();
        if (q.l() == null)
        {
            q.c(q.b(m));
        }
        q.a(m);
        obj = getResources().getDisplayMetrics();
        float f1 = ((DisplayMetrics) (obj)).widthPixels;
        if ((getResources().getConfiguration().screenLayout & 0xf) == 1)
        {
            f1 = pb.a(getActivity(), 282F);
        }
        f1 /= m.sceneSize.x;
        view = (FrameLayout)view.findViewById(0x7f0c01fb);
        obj1 = (android.widget.RelativeLayout.LayoutParams)view.getLayoutParams();
        obj1.width = ((DisplayMetrics) (obj)).widthPixels;
        obj1.height = ((DisplayMetrics) (obj)).widthPixels;
        if (g != null && g.getRender() != null)
        {
            g.setSurfaceContainerSize(((DisplayMetrics) (obj)).widthPixels, ((DisplayMetrics) (obj)).widthPixels);
        }
        view.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        view = m.frameRect;
        i1 = (int)((float)((Rect) (view)).left * f1);
        int k1 = (int)((float)((Rect) (view)).top * f1);
        view = new android.widget.FrameLayout.LayoutParams((int)((float)(((Rect) (view)).right - ((Rect) (view)).left) * f1), (int)((float)(((Rect) (view)).bottom - ((Rect) (view)).top) * f1));
        view.setMargins(i1, k1, 0, 0);
        view.gravity = 51;
    }

    static void a(PipCameraFragment pipcamerafragment, int i1)
    {
        pipcamerafragment.c(i1);
    }

    static void a(PipCameraFragment pipcamerafragment, View view)
    {
        pipcamerafragment.c(view);
    }

    static void a(PipCameraFragment pipcamerafragment, TDFSceneInfo tdfsceneinfo)
    {
        pipcamerafragment.e(tdfsceneinfo);
    }

    static boolean a(PipCameraFragment pipcamerafragment)
    {
        return pipcamerafragment.D;
    }

    static boolean a(PipCameraFragment pipcamerafragment, JSONObject jsonobject)
    {
        return pipcamerafragment.a(jsonobject);
    }

    static boolean a(PipCameraFragment pipcamerafragment, boolean flag)
    {
        pipcamerafragment.D = flag;
        return flag;
    }

    private boolean a(JSONObject jsonobject)
    {
        if (jsonobject == null || jsonobject.length() == 0)
        {
            return false;
        }
        if (jsonobject == null) goto _L2; else goto _L1
_L1:
        yf yf1;
        yf1 = q.h();
        jsonobject = ty.a(jsonobject, G);
        if (jsonobject == null) goto _L2; else goto _L3
_L3:
        if (jsonobject.size() <= 0) goto _L2; else goto _L4
_L4:
        int i1 = 0;
_L15:
        if (i1 >= jsonobject.size()) goto _L2; else goto _L5
_L5:
        ArrayList arraylist = ((uk)jsonobject.get(i1)).c;
        if (arraylist == null) goto _L7; else goto _L6
_L6:
        if (arraylist.size() <= 0) goto _L7; else goto _L8
_L8:
        int j1 = 0;
_L14:
        if (j1 >= arraylist.size()) goto _L7; else goto _L9
_L9:
        Object obj = (uj)arraylist.get(j1);
        if (((uj) (obj)).d != EOnlineResType.PIP_SCENE) goto _L11; else goto _L10
_L10:
        String s1;
        s1 = ((uj) (obj)).b;
        obj = ((uj) (obj)).g;
        if (obj == null) goto _L11; else goto _L12
_L12:
        if (((ArrayList) (obj)).size() <= 0) goto _L11; else goto _L13
_L13:
        ArrayList arraylist1 = new ArrayList();
        int k1 = 0;
_L16:
        if (k1 < ((ArrayList) (obj)).size())
        {
            TResInfo tresinfo = (TResInfo)((ArrayList) (obj)).get(k1);
            if (!yf1.a(tresinfo.resId, ESceneMode.SCENE_MODE1))
            {
                arraylist1.add(tresinfo);
            }
            break MISSING_BLOCK_LABEL_269;
        }
        if (arraylist1.size() > 0)
        {
            H.put(s1, arraylist1);
        }
_L11:
        j1++;
          goto _L14
_L7:
        i1++;
          goto _L15
        jsonobject;
_L2:
        if (H.size() == 0)
        {
            return false;
        }
        if (NativeAdWrapper.needFBNative(getActivity()))
        {
            p();
        }
        return true;
        k1++;
          goto _L16
    }

    static int b(PipCameraFragment pipcamerafragment, int i1)
    {
        pipcamerafragment.z = i1;
        return i1;
    }

    static Button b(PipCameraFragment pipcamerafragment)
    {
        return pipcamerafragment.t;
    }

    static TDFSceneInfo b(PipCameraFragment pipcamerafragment, TDFSceneInfo tdfsceneinfo)
    {
        pipcamerafragment.m = tdfsceneinfo;
        return tdfsceneinfo;
    }

    private void b(View view)
    {
        g = (PipCameraGLSurfaceView)view.findViewById(0x7f0c01fd);
        g.setCameraCallBack(this);
        g.initCameraPara(K, L, jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_TAKE_PHOTO, jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumPreviewRatio.Ratio_none);
        f = (ImageGLSurfaceView)view.findViewById(0x7f0c01fc);
        f.getHolder().addCallback(this);
    }

    private void b(TResInfo tresinfo)
    {
        if (tresinfo != null && q != null)
        {
            if (!uc.a(getActivity()))
            {
                Toast.makeText(getActivity(), getActivity().getResources().getString(0x7f060041), 1).show();
                return;
            }
            I = tresinfo;
            if (!(new ub(q, I)).a() && I != null)
            {
                c(tresinfo);
                return;
            }
        }
    }

    static TPipStyleListScrollView c(PipCameraFragment pipcamerafragment)
    {
        return pipcamerafragment.p;
    }

    private void c(int i1)
    {
        while (E || p == null) 
        {
            return;
        }
        p.removeAllItems();
        q.a(null);
        Object obj = q.h().a(ESceneCatalog.SCENE_RECTANGLE_SHAPE, ESceneMode.SCENE_MODE1);
        ((List) (obj)).iterator();
        TDFSceneInfo tdfsceneinfo;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); p.addPipItem(tdfsceneinfo))
        {
            tdfsceneinfo = (TDFSceneInfo)((Iterator) (obj)).next();
        }

        p.setCallback(this);
        if (i1 < 0)
        {
            obj = q.h().a(0, ESceneCatalog.SCENE_RECTANGLE_SHAPE, ESceneMode.SCENE_MODE1);
            if (obj != null && ((TDFSceneInfo) (obj)).getName() != null)
            {
                p.setItemSelected(((TDFSceneInfo) (obj)).resId, Boolean.valueOf(true));
            }
            a(((TDFSceneInfo) (obj)));
            return;
        }
        obj = new TDFSceneInfo();
        obj.resId = i1;
        int k1 = q.h().b(((TDFSceneInfo) (obj)), ESceneCatalog.SCENE_RECTANGLE_SHAPE, ESceneMode.SCENE_MODE1);
        int j1 = k1;
        if (k1 < 0)
        {
            j1 = 0;
        }
        obj = q.h().a(j1, ESceneCatalog.SCENE_RECTANGLE_SHAPE, ESceneMode.SCENE_MODE1);
        if (obj != null);
        p.setItemSelected(i1, Boolean.valueOf(true));
        q.a(j1);
        a(((TDFSceneInfo) (obj)));
    }

    private void c(View view)
    {
        if (q != null)
        {
            if (!ew.l(q))
            {
                view = new android.app.AlertDialog.Builder(q);
                view.setTitle(getResources().getString(0x7f060277));
                view.setMessage(getResources().getString(0x7f060169));
                view.setPositiveButton(getResources().getString(0x7f06002f), new android.content.DialogInterface.OnClickListener() {

                    final PipCameraFragment a;

                    public void onClick(DialogInterface dialoginterface, int i1)
                    {
                    }

            
            {
                a = PipCameraFragment.this;
                super();
            }
                });
                view.show();
                return;
            }
            t.setBackgroundResource(0x7f0200b3);
            b = true;
            if (x == null)
            {
                if (PIPCameraApplication.a.getResources().getDisplayMetrics().densityDpi <= 160)
                {
                    x = LayoutInflater.from(q).inflate(0x7f030065, null);
                } else
                {
                    x = LayoutInflater.from(q).inflate(0x7f030064, null);
                }
                view = new android.widget.FrameLayout.LayoutParams(-1, -1);
                view.gravity = 17;
                q.addContentView(x, view);
                a(true);
                q.m();
                A.postDelayed(new Runnable() {

                    final PipCameraFragment a;

                    public void run()
                    {
                        PipCameraFragment.f(a);
                    }

            
            {
                a = PipCameraFragment.this;
                super();
            }
                }, 550L);
                ((FrameLayout)x.findViewById(0x7f0c004a)).setOnClickListener(new android.view.View.OnClickListener() {

                    final PipCameraFragment a;

                    public void onClick(View view1)
                    {
                        if (a.b)
                        {
                            a.b = false;
                            a.a(false);
                            if (PIPCameraApplication.a(a.getActivity()))
                            {
                                a.d();
                                return;
                            }
                        }
                    }

            
            {
                a = PipCameraFragment.this;
                super();
            }
                });
                y = (ListView)x.findViewById(0x7f0c0156);
                y.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

                    final PipCameraFragment a;

                    public void onGlobalLayout()
                    {
                        PipCameraFragment.g(a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
                        PipCameraFragment.b(a, PipCameraFragment.h(a));
                        PipCameraFragment.a(a, new OnlineGridViewAdapter(a.getActivity(), PipCameraFragment.i(a), PipCameraFragment.g(a).getWidth(), PipCameraFragment.g(a).getHeight(), PipCameraFragment.j(a), PipCameraFragment.k(a)));
                        PipCameraFragment.l(a).setItemListener(a);
                        PipCameraFragment.g(a).setAdapter(PipCameraFragment.l(a));
                        PipCameraFragment.g(a).setDividerHeight(PipCameraFragment.l(a).gapBetweenChildrenInRow());
                    }

            
            {
                a = PipCameraFragment.this;
                super();
            }
                });
                y.setOnScrollListener(new android.widget.AbsListView.OnScrollListener() {

                    final PipCameraFragment a;

                    public void onScroll(AbsListView abslistview, int i1, int j1, int k1)
                    {
                        if (i1 == 0)
                        {
                            PipCameraFragment.a(a, true);
                            Log.i("log", "\u6ED1\u5230\u9876\u90E8");
                            return;
                        } else
                        {
                            PipCameraFragment.a(a, false);
                            return;
                        }
                    }

                    public void onScrollStateChanged(AbsListView abslistview, int i1)
                    {
                    }

            
            {
                a = PipCameraFragment.this;
                super();
            }
                });
                y.setOnTouchListener(new android.view.View.OnTouchListener() {

                    final PipCameraFragment a;

                    public boolean onTouch(View view1, MotionEvent motionevent)
                    {
                        PipCameraFragment.m(a).onTouchEvent(motionevent);
                        return false;
                    }

            
            {
                a = PipCameraFragment.this;
                super();
            }
                });
            } else
            {
                a(true);
            }
            x.findViewById(0x7f0c01db);
            if (!PIPCameraApplication.b().a(q))
            {
                e();
                return;
            }
        }
    }

    static void c(PipCameraFragment pipcamerafragment, int i1)
    {
        pipcamerafragment.d(i1);
    }

    static void c(PipCameraFragment pipcamerafragment, TDFSceneInfo tdfsceneinfo)
    {
        pipcamerafragment.d(tdfsceneinfo);
    }

    private void c(TResInfo tresinfo)
    {
        if (tresinfo == null)
        {
            return;
        } else
        {
            tz.a().a(tresinfo, new ua() {

                final PipCameraFragment a;

                public void a(TResInfo tresinfo1)
                {
                    if (tresinfo1 != null && PipCameraFragment.d(a) != null)
                    {
                        PipCameraFragment.d(a).o();
                    }
                }

                public void a(TResInfo tresinfo1, float f1)
                {
                }

                public void a(TDFSceneInfo tdfsceneinfo)
                {
                    if (PipCameraFragment.d(a) != null)
                    {
                        PipCameraFragment.d(a).p();
                    }
                    tdfsceneinfo.mode = ESceneMode.SCENE_MODE1;
                    kf.c().d().a(tdfsceneinfo);
                    PipCameraFragment.a(a, tdfsceneinfo);
                }

                public void b(TResInfo tresinfo1)
                {
                    if (PipCameraFragment.d(a) != null)
                    {
                        PipCameraFragment.d(a).p();
                        Toast.makeText(PipCameraFragment.d(a), PipCameraFragment.d(a).getResources().getString(0x7f0600d7), 0).show();
                    }
                }

            
            {
                a = PipCameraFragment.this;
                super();
            }
            });
            return;
        }
    }

    static int d(PipCameraFragment pipcamerafragment, int i1)
    {
        pipcamerafragment.M = i1;
        return i1;
    }

    static PipRealTimeCameraActivity d(PipCameraFragment pipcamerafragment)
    {
        return pipcamerafragment.q;
    }

    private void d(int i1)
    {
        ArrayList arraylist = g.getFlashLightList();
        if (arraylist.size() == 0)
        {
            j.setVisibility(4);
        } else
        if (i1 < arraylist.size())
        {
            j.setVisibility(0);
            if (((String)arraylist.get(i1)).equals("auto"))
            {
                j.setImageResource(0x7f020074);
                g.setCameraFlashlight("auto");
            }
            if (((String)arraylist.get(i1)).equals("off"))
            {
                j.setImageResource(0x7f020075);
                g.setCameraFlashlight("off");
            }
            if (((String)arraylist.get(i1)).equals("on"))
            {
                j.setImageResource(0x7f020076);
                g.setCameraFlashlight("on");
            }
            if (((String)arraylist.get(i1)).equals("torch"))
            {
                j.setImageResource(0x7f020076);
                g.setCameraFlashlight("torch");
                return;
            }
        }
    }

    private void d(TDFSceneInfo tdfsceneinfo)
    {
        if (tdfsceneinfo == null || g == null)
        {
            return;
        } else
        {
            g.setPipForeBitmap(tdfsceneinfo.getPipCoverBitmap(q));
            g.setPipMaskBitmapInfo(tdfsceneinfo.getGPUPipMaskBitmap(q), tdfsceneinfo.getFrameRect());
            g.setPipBackGroundSize(tdfsceneinfo.getSceneSize().x, tdfsceneinfo.getSceneSize().y);
            return;
        }
    }

    static int e(PipCameraFragment pipcamerafragment, int i1)
    {
        pipcamerafragment.s = i1;
        return i1;
    }

    static ImageGLSurfaceView e(PipCameraFragment pipcamerafragment)
    {
        return pipcamerafragment.f;
    }

    private void e(TDFSceneInfo tdfsceneinfo)
    {
        while (E || tdfsceneinfo == null || q == null || p == null) 
        {
            return;
        }
        c(tdfsceneinfo.resId);
        if (x != null && B != null)
        {
            a(tdfsceneinfo);
        }
        (new Handler()).postDelayed(new Runnable() {

            final PipCameraFragment a;

            public void run()
            {
                a.b = false;
                a.a(false);
            }

            
            {
                a = PipCameraFragment.this;
                super();
            }
        }, 10L);
        c(tdfsceneinfo);
    }

    static void f(PipCameraFragment pipcamerafragment)
    {
        pipcamerafragment.o();
    }

    static ListView g(PipCameraFragment pipcamerafragment)
    {
        return pipcamerafragment.y;
    }

    static int h(PipCameraFragment pipcamerafragment)
    {
        return pipcamerafragment.m();
    }

    private void h()
    {
        if (C == null)
        {
            C = new GestureDetector(q, new android.view.GestureDetector.OnGestureListener() {

                final PipCameraFragment a;

                public boolean onDown(MotionEvent motionevent)
                {
                    System.out.println("onDown");
                    return true;
                }

                public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f1, float f2)
                {
                    System.out.println("onFling");
                    MotionEvent motionevent2 = motionevent;
                    if (motionevent == null)
                    {
                        motionevent2 = motionevent1;
                    }
                    Log.i("PipCameraFragment", (new StringBuilder()).append("onFling,e1,x:").append(motionevent1.getX() - motionevent2.getX()).append("  y:").append(motionevent1.getY() - motionevent2.getY()).append("  distanceX").append(f1).append("  distanceY").append(f2).toString());
                    if (motionevent1.getY() - motionevent2.getY() > 50F && Math.abs(f2) > 100F && PipCameraFragment.a(a))
                    {
                        a.b = false;
                        a.a(false);
                    }
                    return false;
                }

                public void onLongPress(MotionEvent motionevent)
                {
                    System.out.println("onLongPress");
                }

                public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f1, float f2)
                {
                    return false;
                }

                public void onShowPress(MotionEvent motionevent)
                {
                    System.out.println("onShowPress");
                }

                public boolean onSingleTapUp(MotionEvent motionevent)
                {
                    System.out.println("onSingleTapUp");
                    return false;
                }

            
            {
                a = PipCameraFragment.this;
                super();
            }
            });
        }
    }

    static LinkedHashMap i(PipCameraFragment pipcamerafragment)
    {
        return pipcamerafragment.H;
    }

    private void i()
    {
        m = q.i();
        if (m != null && m.getName() != null)
        {
            p.setItemSelected(m.resId, Boolean.valueOf(true));
            d(m);
        } else
        {
            TDFSceneInfo tdfsceneinfo = q.h().a(0, ESceneCatalog.SCENE_RECTANGLE_SHAPE, ESceneMode.SCENE_MODE1);
            if (tdfsceneinfo != null && tdfsceneinfo.getName() != null)
            {
                p.setItemSelected(tdfsceneinfo.resId, Boolean.valueOf(true));
                d(tdfsceneinfo);
                return;
            }
        }
    }

    static int j(PipCameraFragment pipcamerafragment)
    {
        return pipcamerafragment.z;
    }

    private void j()
    {
        Display display = q.getWindowManager().getDefaultDisplay();
        K = display.getWidth();
        L = display.getHeight();
    }

    private int k()
    {
        char c1 = '\u0264';
        DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        float f1 = displaymetrics.density;
        int i1 = displaymetrics.densityDpi;
        float f2 = displaymetrics.xdpi;
        float f3 = displaymetrics.ydpi;
        float f4 = displaymetrics.widthPixels;
        float f5 = displaymetrics.heightPixels;
        Log.e("PipCameraFragment  DisplayMetrics", (new StringBuilder()).append("xdpi=").append(f2).append("; ydpi=").append(f3).toString());
        Log.e("PipCameraFragment  DisplayMetrics", (new StringBuilder()).append("density=").append(f1).append("; densityDPI=").append(i1).toString());
        Log.v("PipCameraFragment  screenWidth ", String.format("%f", new Object[] {
            Float.valueOf(f4)
        }));
        Log.v("PipCameraFragment  screenHeight ", String.format("%f", new Object[] {
            Float.valueOf(f5)
        }));
        if (f2 < 160F || f4 < 400F)
        {
            c1 = '\u01AC';
        }
        return c1;
    }

    static fq k(PipCameraFragment pipcamerafragment)
    {
        return pipcamerafragment.n();
    }

    static OnlineGridViewAdapter l(PipCameraFragment pipcamerafragment)
    {
        return pipcamerafragment.B;
    }

    private void l()
    {
        (new Date()).getTime();
        if (t != null)
        {
            t.setBackgroundResource(0x7f0200b3);
        }
    }

    private int m()
    {
        return getActivity().getResources().getDimensionPixelSize(0x7f080049);
    }

    static GestureDetector m(PipCameraFragment pipcamerafragment)
    {
        return pipcamerafragment.C;
    }

    private fq n()
    {
        if (F == null)
        {
            fo fo1 = new fo(getActivity().getApplicationContext(), ImageCache.b);
            fo1.g = true;
            fo1.d = android.graphics.Bitmap.CompressFormat.PNG;
            fo1.a(0.05F);
            F = new tl(getActivity(), m());
            F.a(getActivity().getSupportFragmentManager(), fo1);
        }
        return F;
    }

    static String n(PipCameraFragment pipcamerafragment)
    {
        return pipcamerafragment.e;
    }

    private void o()
    {
        if (q != null)
        {
            if (!ew.l(q))
            {
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(q);
                builder.setTitle(getResources().getString(0x7f060277));
                builder.setMessage(getResources().getString(0x7f060169));
                builder.setPositiveButton(getResources().getString(0x7f06002f), new android.content.DialogInterface.OnClickListener() {

                    final PipCameraFragment a;

                    public void onClick(DialogInterface dialoginterface, int i1)
                    {
                    }

            
            {
                a = PipCameraFragment.this;
                super();
            }
                });
                builder.show();
                return;
            }
            boolean flag = false;
            Object obj = q.j().b(e);
            if (obj != null)
            {
                Log.v("PipCameraFragment", "PipCameraFragmentget data from Cache");
                AsyncHttpClient asynchttpclient;
                if (a(((JSONObject) (obj))))
                {
                    q();
                } else
                {
                    flag = true;
                }
            } else
            {
                flag = true;
            }
            if (flag)
            {
                Log.v("PipCameraFragment", "PipCameraFragmentget data from server");
                obj = kb.a();
                Log.v("PipCameraFragment", (new StringBuilder()).append("PipCameraFragmentrequestURL").append(((String) (obj))).toString());
                asynchttpclient = new AsyncHttpClient();
                asynchttpclient.setConnectTimeout(20000);
                asynchttpclient.setTimeout(20000);
                asynchttpclient.get(((String) (obj)), null, new JsonHttpResponseHandler() {

                    final PipCameraFragment a;

                    public void onFailure(int i1, Header aheader[], Throwable throwable, JSONObject jsonobject)
                    {
                        Log.v("PipCameraFragment", (new StringBuilder()).append("PipCameraFragmentonFailure statusCode:").append(i1).toString());
                        if (jsonobject != null)
                        {
                            Log.v("PipCameraFragment", (new StringBuilder()).append("PipCameraFragmentonFailure errorResponse:").append(jsonobject.toString()).toString());
                        }
                        if (PipCameraFragment.d(a) != null)
                        {
                            PipCameraFragment.d(a).n();
                        }
                    }

                    public void onSuccess(int i1, Header aheader[], JSONObject jsonobject)
                    {
                        if (i1 == 200 && jsonobject != null)
                        {
                            if (PipCameraFragment.d(a) != null)
                            {
                                PipCameraFragment.d(a).n();
                            }
                            if (PipCameraFragment.a(a, jsonobject))
                            {
                                PipCameraFragment.d(a).j().c(PipCameraFragment.n(a));
                                PipCameraFragment.d(a).j().a(PipCameraFragment.n(a), jsonobject, 300);
                                PipCameraFragment.o(a);
                            }
                        }
                    }

            
            {
                a = PipCameraFragment.this;
                super();
            }
                });
                return;
            }
        }
    }

    static void o(PipCameraFragment pipcamerafragment)
    {
        pipcamerafragment.q();
    }

    static int p(PipCameraFragment pipcamerafragment)
    {
        return pipcamerafragment.M;
    }

    private void p()
    {
        int i1;
        i1 = 0;
        if (H == null)
        {
            break MISSING_BLOCK_LABEL_184;
        }
        Iterator iterator;
        Log.e("PipCameraFragment", (new StringBuilder()).append("PipCameraFragmentinfos ").append(H.keySet().size()).toString());
        iterator = H.keySet().iterator();
_L1:
        String s1;
        TResInfo tresinfo;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_184;
            }
            s1 = (String)iterator.next();
            tresinfo = new TResInfo();
            tresinfo.resId = TPhotoMagComposeManager.KFBNATIVEID + i1;
            tresinfo.icon = "";
            tresinfo.zipUrl = "";
            tresinfo.name = (new StringBuilder()).append("nativeAd_").append(TPhotoMagComposeManager.KFBNATIVEID).append(i1).toString();
        } while (H.get(s1) == null);
        ((ArrayList)H.get(s1)).add(0, tresinfo);
        i1++;
          goto _L1
        Exception exception;
        exception;
        Crashlytics.logException(exception);
    }

    static PipCameraGLSurfaceView q(PipCameraFragment pipcamerafragment)
    {
        return pipcamerafragment.g;
    }

    private void q()
    {
        if (!E)
        {
            l();
            if (q != null)
            {
                q.runOnUiThread(new Runnable() {

                    final PipCameraFragment a;

                    public void run()
                    {
                        PipCameraFragment.d(a).n();
                        if (PipCameraFragment.l(a) != null)
                        {
                            PipCameraFragment.l(a).notifyDataSetChanged();
                        }
                    }

            
            {
                a = PipCameraFragment.this;
                super();
            }
                });
                return;
            }
        }
    }

    static int r(PipCameraFragment pipcamerafragment)
    {
        int i1 = pipcamerafragment.M;
        pipcamerafragment.M = i1 + 1;
        return i1;
    }

    private void r()
    {
        PipRealTimeCameraActivity piprealtimecameraactivity = q;
        PipRealTimeCameraActivity piprealtimecameraactivity1 = q;
        R = (SensorManager)piprealtimecameraactivity.getSystemService("sensor");
        R.getSensorList(-1);
        S = R.getDefaultSensor(5);
        if (S == null)
        {
            return;
        } else
        {
            float f1 = S.getMaximumRange();
            Log.e("PipCameraFragment", (new StringBuilder()).append("light sensor maximum = ").append(f1).toString());
            d = new SensorEventListener() {

                final PipCameraFragment a;

                public void onAccuracyChanged(Sensor sensor, int i1)
                {
                    Log.e("PipCameraFragment", (new StringBuilder()).append("accuracy = ").append(i1).toString());
                }

                public void onSensorChanged(SensorEvent sensorevent)
                {
                    PipCameraFragment.a(a, sensorevent.values[0]);
                }

            
            {
                a = PipCameraFragment.this;
                super();
            }
            };
            R.registerListener(d, S, 2);
            return;
        }
    }

    static TDFSceneInfo s(PipCameraFragment pipcamerafragment)
    {
        return pipcamerafragment.m;
    }

    private void s()
    {
        if (d != null && S != null)
        {
            R.unregisterListener(d, S);
        }
    }

    static View t(PipCameraFragment pipcamerafragment)
    {
        return pipcamerafragment.J;
    }

    static int u(PipCameraFragment pipcamerafragment)
    {
        return pipcamerafragment.k();
    }

    static int v(PipCameraFragment pipcamerafragment)
    {
        return pipcamerafragment.s;
    }

    public void a(int i1)
    {
        q.a();
    }

    public void a(Bitmap bitmap, int i1)
    {
        if (bitmap == null)
        {
            Log.v("cropImagefail", "cropImagefail");
        }
        if (bitmap != null)
        {
            f.setSourceBitmap(bitmap);
            f.processImage(bitmap, n, new Handler(i1) {

                final int a;
                final PipCameraFragment b;

                public void handleMessage(Message message)
                {
                    if (message != null && message.obj != null)
                    {
                        message = (Bitmap)message.obj;
                        PipCameraFragment.d(b).b(message);
                        if (a == 2000)
                        {
                            if (PipCameraFragment.d(b) != null)
                            {
                                PipCameraFragment.d(b).d();
                                PipCameraFragment.e(b).setVisibility(8);
                            }
                        } else
                        if (a == 3000)
                        {
                            PipCameraFragment.d(b).b();
                            if (PipCameraFragment.d(b) != null)
                            {
                                PipCameraFragment.d(b).d();
                                PipCameraFragment.e(b).setVisibility(8);
                                return;
                            }
                        }
                    }
                }

            
            {
                b = PipCameraFragment.this;
                a = i1;
                super();
            }
            });
        }
    }

    public void a(TResInfo tresinfo)
    {
        if (!E && tresinfo != null && tresinfo.name != null && H != null)
        {
            Object obj = H.keySet();
            if (obj != null)
            {
                obj = ((Set) (obj)).iterator();
                while (((Iterator) (obj)).hasNext()) 
                {
                    String s1 = (String)((Iterator) (obj)).next();
                    ArrayList arraylist = (ArrayList)H.get(s1);
                    if (arraylist != null)
                    {
                        int i1 = 0;
                        while (i1 < arraylist.size()) 
                        {
                            TResInfo tresinfo1 = (TResInfo)arraylist.get(i1);
                            Log.v("PipCameraFragment", (new StringBuilder()).append("PipCameraFragmentitem name:").append(tresinfo1.name).append(" info name:").append(tresinfo.name).toString());
                            if (tresinfo1.resId == tresinfo.resId)
                            {
                                arraylist.remove(tresinfo1);
                                if (arraylist.size() == 0)
                                {
                                    H.remove(s1);
                                }
                                Log.v("PipCameraFragment", "PipCameraFragment refreshGridViewDataWhenDownloadFinished remove success");
                                B.notifyDataSetChanged();
                                return;
                            }
                            i1++;
                        }
                    }
                }
            }
        }
    }

    public void a(TResInfo tresinfo, String s1, int i1)
    {
        if (!b)
        {
            return;
        }
        Log.v("PipCameraFragment", (new StringBuilder()).append("PipCameraFragmentonGridItemClicked info name:").append(tresinfo.getName()).toString());
        if (!uc.a(getActivity()))
        {
            Toast.makeText(getActivity(), getActivity().getResources().getString(0x7f060169), 1).show();
            return;
        } else
        {
            b(tresinfo);
            return;
        }
    }

    public void a(TDFSceneInfo tdfsceneinfo)
    {
        Log.e("TDFSceneInfo", (new StringBuilder()).append("pipItemSelected ").append(tdfsceneinfo.resId).toString());
        if (tdfsceneinfo.getResType() == EResType.ONLINE)
        {
            Log.v("PipCameraFragment", "on line resource");
            uj uj1 = new uj();
            uj1.d = EOnlineResType.PIP_SCENE;
            a = new sw((PipRealTimeCameraActivity)getActivity());
            tu tu1 = ts.a(uj1.d);
            tu1.setMaterialType(uj1);
            tu1.setoperationDelegate(a);
            tu1.update();
            ((PipRealTimeCameraActivity)getActivity()).a();
            tu1.downloadRes(tdfsceneinfo);
            return;
        } else
        {
            b(tdfsceneinfo);
            return;
        }
    }

    public void a(Exception exception)
    {
        Log.v("PipCameraFragment", "PipCameraFragment onCropFailed");
        if (q != null)
        {
            q.b();
        }
    }

    public void a(String s1, Exception exception)
    {
    }

    public void a(ArrayList arraylist, int i1)
    {
        Log.v("CropImageDidProcessed", "CropImageDidProcessed");
        if (arraylist.size() <= 0) goto _L2; else goto _L1
_L1:
        if (1000 != i1) goto _L4; else goto _L3
_L3:
        arraylist = (Bitmap)arraylist.get(0);
        q.a(arraylist);
        if (q.f() == null && arraylist != null)
        {
            arraylist = new AsynPIPCropImageTask(arraylist);
            arraylist.a(this);
            arraylist.execute(new Context[] {
                getActivity()
            });
        }
_L2:
        return;
_L4:
        if (2000 != i1)
        {
            continue; /* Loop/switch isn't completed */
        }
        arraylist = (Bitmap)arraylist.get(0);
        q.a(arraylist);
        if (q.f() == null && arraylist != null)
        {
            arraylist = new AsynPIPCropImageTask(arraylist);
            arraylist.a(this);
            arraylist.a(2000);
            arraylist.execute(new Context[] {
                getActivity()
            });
            return;
        }
        continue; /* Loop/switch isn't completed */
        if (3000 != i1) goto _L2; else goto _L5
_L5:
        arraylist = (Bitmap)arraylist.get(0);
        q.a(arraylist);
        if (q.f() == null && arraylist != null)
        {
            arraylist = new AsynPIPCropImageTask(arraylist);
            arraylist.a(this);
            arraylist.a(3000);
            arraylist.execute(new Context[] {
                getActivity()
            });
            return;
        }
        if (true) goto _L2; else goto _L6
_L6:
    }

    public void a(HashMap hashmap)
    {
_L2:
        return;
        if (t == null || !isAdded()) goto _L2; else goto _L1
_L1:
        if (hashmap != null)
        {
            break; /* Loop/switch isn't completed */
        }
        Log.v("OnlineChecker ", "OnlineCheck dict is null");
        if (getActivity() != null)
        {
            t.setBackgroundResource(0x7f0200b3);
            return;
        }
        if (true) goto _L2; else goto _L3
_L3:
        Boolean boolean1 = Boolean.valueOf(false);
        if (tv.a(EOnlineResType.PIP_SCENE, hashmap).booleanValue())
        {
            boolean1 = Boolean.valueOf(true);
        }
        if (!boolean1.booleanValue())
        {
            break; /* Loop/switch isn't completed */
        }
        Log.v("OnlineChecker ", "has new online materials");
        if (getActivity() != null)
        {
            t.setBackgroundResource(0x7f0200b4);
            return;
        }
        if (true) goto _L2; else goto _L4
_L4:
        Log.v("OnlineChecker ", "has no online materials");
        if (getActivity() != null)
        {
            t.setBackgroundResource(0x7f0200b3);
            return;
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public void a(boolean flag)
    {
        if (E)
        {
            return;
        }
        if (flag)
        {
            android.view.animation.Animation animation = AnimationUtils.loadAnimation(getActivity(), 0x7f04001a);
            x.startAnimation(animation);
            x.setVisibility(0);
            return;
        } else
        {
            android.view.animation.Animation animation1 = AnimationUtils.loadAnimation(getActivity(), 0x7f04001b);
            x.startAnimation(animation1);
            x.setVisibility(4);
            return;
        }
    }

    public void a(byte abyte0[])
    {
        q.runOnUiThread(new Runnable() {

            final PipCameraFragment a;

            public void run()
            {
                PipCameraFragment.t(a).setVisibility(4);
            }

            
            {
                a = PipCameraFragment.this;
                super();
            }
        });
        int i1 = a(gr.a(), gr.b());
        Object obj;
        try
        {
            obj = sd.a(true, q);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((IOException) (obj)).printStackTrace();
            obj = null;
        }
        if (obj == null)
        {
            Toast.makeText(q.getApplicationContext(), "no sdcard!", 0).show();
            g.startPreview();
            g.setIsTakingPhoto(false);
            return;
        } else
        {
            String s1 = ((File) (obj)).getAbsolutePath();
            obj = Uri.fromFile(((File) (obj)));
            q.a();
            c.execute(new Runnable(abyte0, i1, s1, ((Uri) (obj))) {

                final byte a[];
                final int b;
                final String c;
                final Uri d;
                final PipCameraFragment e;

                public void run()
                {
                    Bitmap bitmap = ev.a(a, a, b, b);
                    Matrix matrix = new Matrix();
                    matrix.postRotate(se.a(PipCameraFragment.d(e), PipCameraFragment.q(e).isFrontFacing()));
                    if (PipCameraFragment.q(e).isFrontFacing())
                    {
                        matrix.postScale(-1F, 1.0F);
                    }
                    bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                    PipCameraFragment.d(e).a(bitmap);
                    sf.a().a(bitmap, c, PipCameraFragment.d(e), new sg(this) {

                        final _cls17 a;

                        public void a()
                        {
                            PipCameraFragment.d(a.e).runOnUiThread(new Runnable(this) {

                                final _cls1 a;

                                public void run()
                                {
                                    PipCameraFragment.d(a.a.e).runOnUiThread(new Runnable(this) {

                                        final _cls1 a;

                                        public void run()
                                        {
                                            so so1 = new so();
                                            ArrayList arraylist = new ArrayList();
                                            arraylist.add(a.a.a.d);
                                            so1.a(arraylist);
                                            PipCameraFragment.e(a.a.a.e, PipCameraFragment.u(a.a.a.e));
                                            so1.b(PipCameraFragment.v(a.a.a.e));
                                            so1.a(a.a.a.e);
                                            so1.a(3000);
                                            so1.c(new ArrayList[0]);
                                        }

            
            {
                a = _pcls1;
                super();
            }
                                    });
                                }

            
            {
                a = _pcls1;
                super();
            }
                            });
                        }

                        public void b()
                        {
                        }

            
            {
                a = _pcls17;
                super();
            }
                    });
                }

            
            {
                e = PipCameraFragment.this;
                a = abyte0;
                b = i1;
                c = s1;
                d = uri;
                super();
            }
            });
            return;
        }
    }

    public void a_(int i1)
    {
    }

    protected void b()
    {
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("ACTION_MATERIAL_ADDED");
        intentfilter.addAction("ACTION_MATERIAL_REMOVE");
        q.registerReceiver(v, intentfilter);
    }

    public void b(int i1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("FPS Count", (new StringBuilder()).append("").append(i1).toString());
        FlurryAgent.logEvent("camera_fps_count", hashmap);
    }

    public void b(TDFSceneInfo tdfsceneinfo)
    {
        if (E)
        {
            return;
        }
        q.c(null);
        Object obj = q.b(tdfsceneinfo);
        q.c(((Bitmap) (obj)));
        m = tdfsceneinfo;
        q.a(m);
        float f1 = PIPCameraApplication.a.getResources().getDisplayMetrics().widthPixels;
        if ((getResources().getConfiguration().screenLayout & 0xf) == 1)
        {
            f1 = pb.a(getActivity(), 282F);
        }
        f1 /= m.sceneSize.x;
        obj = m.frameRect;
        int i1 = (int)((float)((Rect) (obj)).left * f1);
        int j1 = (int)((float)((Rect) (obj)).top * f1);
        obj = new android.widget.FrameLayout.LayoutParams((int)((float)(((Rect) (obj)).right - ((Rect) (obj)).left) * f1), (int)(f1 * (float)(((Rect) (obj)).bottom - ((Rect) (obj)).top)));
        ((android.widget.FrameLayout.LayoutParams) (obj)).setMargins(i1, j1, 0, 0);
        obj.gravity = 51;
        r = q.h().b(tdfsceneinfo, ESceneCatalog.SCENE_RECTANGLE_SHAPE, ESceneMode.SCENE_MODE1);
        Log.v("mindex", String.format("%d", new Object[] {
            Integer.valueOf(r)
        }));
        q.a(r);
        d(tdfsceneinfo);
    }

    public void b(boolean flag)
    {
        if (flag)
        {
            float f1 = T;
            PipCameraGLSurfaceView pipcameraglsurfaceview = g;
            if (f1 < 10F)
            {
                q.runOnUiThread(new Runnable() {

                    final PipCameraFragment a;

                    public void run()
                    {
                        PipCameraFragment.t(a).setVisibility(0);
                    }

            
            {
                a = PipCameraFragment.this;
                super();
            }
                });
                return;
            }
        }
    }

    public void backBtnClicked(View view)
    {
        if (q != null)
        {
            q.c();
        }
    }

    protected void c()
    {
        try
        {
            PipRealTimeCameraActivity piprealtimecameraactivity = q;
            startActivityForResult(PipRealTimeCameraActivity.k(), 3021);
            return;
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            Toast.makeText(getActivity(), 0x7f060188, 1).show();
            Crashlytics.logException(activitynotfoundexception);
            return;
        }
    }

    public void c(TDFSceneInfo tdfsceneinfo)
    {
        if (E)
        {
            return;
        }
        if (tdfsceneinfo != null)
        {
            if (q != null)
            {
                q.c(tdfsceneinfo);
            }
            m = tdfsceneinfo;
        }
        q.c(null);
        tdfsceneinfo = q.b(tdfsceneinfo);
        q.c(tdfsceneinfo);
        q.a(m);
        tdfsceneinfo = getResources().getDisplayMetrics();
        float f1 = (float)((DisplayMetrics) (tdfsceneinfo)).widthPixels - ((DisplayMetrics) (tdfsceneinfo)).density * 10F;
        if (PIPCameraApplication.d())
        {
            f1 = (float)ew.a(getActivity(), 290F) - ((DisplayMetrics) (tdfsceneinfo)).density * 10F;
        }
        f1 /= m.sceneSize.x;
        tdfsceneinfo = m.frameRect;
        int i1 = (int)((float)((Rect) (tdfsceneinfo)).left * f1);
        int j1 = (int)((float)((Rect) (tdfsceneinfo)).top * f1);
        tdfsceneinfo = new android.widget.FrameLayout.LayoutParams((int)((float)(((Rect) (tdfsceneinfo)).right - ((Rect) (tdfsceneinfo)).left) * f1), (int)(f1 * (float)(((Rect) (tdfsceneinfo)).bottom - ((Rect) (tdfsceneinfo)).top)));
        tdfsceneinfo.setMargins(i1, j1, 0, 0);
        tdfsceneinfo.gravity = 51;
    }

    protected void d()
    {
        try
        {
            FotoAdFactory.createAdBanner(q, getView());
            return;
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
        }
    }

    protected void e()
    {
        try
        {
            FotoAdFactory.createAdBanner(q, x.findViewById(0x7f0c0055));
            return;
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
        }
    }

    public void f()
    {
        q.runOnUiThread(new Runnable() {

            final PipCameraFragment a;

            public void run()
            {
                PipCameraFragment.c(a, PipCameraFragment.p(a));
            }

            
            {
                a = PipCameraFragment.this;
                super();
            }
        });
    }

    public void g()
    {
        g.setIsSwitchCamera(false);
    }

    public void nextBtnClicked(View view)
    {
        if (q != null)
        {
            q.d();
        }
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        if (j1 != -1)
        {
            return;
        }
        Log.v("resultCode", String.valueOf(j1));
        Log.v("requestCode", String.valueOf(i1));
        switch (i1)
        {
        default:
            return;

        case 3021: 
            intent = intent.getData();
            break;
        }
        Log.v("url", intent.toString());
        q.a();
        so so1 = new so();
        ArrayList arraylist = new ArrayList();
        arraylist.add(intent);
        so1.a(arraylist);
        so1.a(this);
        so1.b(s);
        so1.a(2000);
        so1.c(new ArrayList[0]);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Log.v("PipStyleFragment onCreate", "PipStyleFragment onCreate");
        q = (PipRealTimeCameraActivity)getActivity();
        G.add(EOnlineResType.PIP_SCENE);
        A = new Handler();
        if (getArguments() == null)
        {
            Log.e("PipCameraFragment", "getArguments() is null");
        }
        v = new BroadcastReceiver() {

            final PipCameraFragment a;

            public void onReceive(Context context, Intent intent)
            {
                context = intent.getAction();
                Log.v("PipCameraFragment", "PipCameraFragmentBroadcastReceiver on receiver");
                if (context != null && intent.getStringExtra("TYPE_MATERIAL") != null)
                {
                    context = intent.getStringExtra("TYPE_MATERIAL");
                    int i1 = intent.getIntExtra("RESID_MATERIAL", 0);
                    if (context.equalsIgnoreCase(tu.getStringByResType(EOnlineResType.PIP_SCENE)))
                    {
                        PipCameraFragment.a(a, i1);
                    }
                }
            }

            
            {
                a = PipCameraFragment.this;
                super();
            }
        };
        b();
        w = new tv();
        w.a(this);
        h();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        Log.v("PipStyleFragment onCreateView", "PipStyleFragment onCreateView");
        layoutinflater = layoutinflater.inflate(0x7f030071, viewgroup, false);
        o = getResources().getString(0x7f060181);
        n = getResources().getString(0x7f0600fe);
        i = (Button)layoutinflater.findViewById(0x7f0c0206);
        t = (Button)layoutinflater.findViewById(0x7f0c0202);
        t.setOnClickListener(new android.view.View.OnClickListener() {

            final PipCameraFragment a;

            public void onClick(View view)
            {
                PipCameraFragment.a(a, view);
            }

            
            {
                a = PipCameraFragment.this;
                super();
            }
        });
        i.setOnClickListener(O);
        u = (RelativeLayout)layoutinflater.findViewById(0x7f0c0220);
        j();
        b(layoutinflater);
        a(layoutinflater);
        t.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

            final PipCameraFragment a;

            public void onGlobalLayout()
            {
                PipCameraFragment.b(a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
                if (PipCameraFragment.b(a) != null)
                {
                    android.view.ViewGroup.LayoutParams layoutparams = PipCameraFragment.b(a).getLayoutParams();
                    if (layoutparams != null)
                    {
                        Log.v("height:", (new StringBuilder()).append("PipCameraFragment:").append(PipCameraFragment.c(a).getLayoutParams().height).append("").toString());
                        layoutparams.height = PipCameraFragment.c(a).getHeight() - pb.a(PipCameraFragment.d(a), 29F);
                        layoutparams.width = PipCameraFragment.c(a).getHeight() - pb.a(PipCameraFragment.d(a), 29F);
                        PipCameraFragment.b(a).setLayoutParams(layoutparams);
                    }
                }
            }

            
            {
                a = PipCameraFragment.this;
                super();
            }
        });
        viewgroup = new ArrayList(1);
        viewgroup.add(tu.getStringByResType(EOnlineResType.PIP_SCENE));
        w.a(viewgroup);
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        E = true;
        System.gc();
        q.unregisterReceiver(v);
    }

    public void onPause()
    {
        if (g != null && g.getRender() != null)
        {
            g.pauseAll();
            Log.e("PipCameraFragment", (new StringBuilder()).append("mCameraSurfaceView.isFrontFacing()=").append(g.isFrontFacing()).toString());
        }
        if (f != null && f.getRender() != null)
        {
            f.onPause();
        }
        super.onPause();
        s();
        Log.e("PipCameraFragment", "PipStyleFragment onPause");
    }

    public void onResume()
    {
        super.onResume();
        if (g != null && g.getRender() != null)
        {
            g.resumeAll();
            m = q.i();
            if (m != null && m.getName() != null)
            {
                d(m);
            }
        }
        r();
        J.setVisibility(4);
        if (f != null && f.getRender() != null)
        {
            f.onResume();
        }
        g.setIsTakingPhoto(false);
        Log.e("PipCameraFragment", "PipStyleFragment onResume");
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i1, int j1, int k1)
    {
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
    }
}
