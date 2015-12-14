// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip.fragment;

import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ContextMenu;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.crashlytics.android.Crashlytics;
import com.fotoable.ad.FotoAdFactory;
import com.fotoable.ad.NativeAdWrapper;
import com.fotoable.comlib.util.ImageCache;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.pipcamera.activity.pip.PipStyleActivity;
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
import ew;
import fo;
import fq;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import jw;
import kb;
import kf;
import org.apache.http.Header;
import org.json.JSONObject;
import pb;
import so;
import sp;
import sy;
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
import wantu.sephiroth.android.library.imagezoom.MaskScrollImageViewTouch;
import ye;
import yf;
import yy;

public class PipStyleFragment extends Fragment
    implements android.view.SurfaceHolder.Callback, sp, tf, tw, ye, yy
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
    sy a;
    public boolean b;
    ImageView c;
    private String d;
    private ImageGLSurfaceView e;
    private Button f;
    private Button g;
    private Button h;
    private MaskScrollImageViewTouch i;
    private ImageView j;
    private TDFSceneInfo k;
    private boolean l;
    private String m;
    private String n;
    private TPipStyleListScrollView o;
    private PipStyleActivity p;
    private int q;
    private int r;
    private Uri s;
    private Button t;
    private RelativeLayout u;
    private BroadcastReceiver v;
    private tv w;
    private View x;
    private ListView y;
    private int z;

    public PipStyleFragment()
    {
        d = "ACACHE_NEWPIP_ONLINELIB_JSON_TAG";
        m = null;
        n = null;
        r = 612;
        v = null;
        b = false;
        B = null;
        D = true;
        E = false;
        G = new ArrayList();
        H = new LinkedHashMap();
    }

    public static PipStyleFragment a(String s1)
    {
        PipStyleFragment pipstylefragment = new PipStyleFragment();
        Bundle bundle = new Bundle();
        bundle.putString("SelectedImageUri", s1);
        pipstylefragment.setArguments(bundle);
        return pipstylefragment;
    }

    static OnlineGridViewAdapter a(PipStyleFragment pipstylefragment, OnlineGridViewAdapter onlinegridviewadapter)
    {
        pipstylefragment.B = onlinegridviewadapter;
        return onlinegridviewadapter;
    }

    private void a(Bitmap bitmap)
    {
        if (l)
        {
            bitmap = new AsynPIPCropImageTask(bitmap);
            bitmap.a(this);
            bitmap.execute(new Context[] {
                getActivity()
            });
        } else
        {
            p.a(bitmap);
            Log.v("willreplaceForeImage", "willreplaceForeImage");
            if (i != null)
            {
                i.setImageBitmap(bitmap, true);
                return;
            }
        }
    }

    private void a(View view)
    {
        Object obj = (TextView)view.findViewById(0x7f0c002d);
        ((TextView) (obj)).setText(getResources().getString(0x7f06019e));
        ((TextView) (obj)).setTextColor(-1);
        f = (Button)view.findViewById(0x7f0c0080);
        g = (Button)view.findViewById(0x7f0c007f);
        f.setOnClickListener(new android.view.View.OnClickListener() {

            final PipStyleFragment a;

            public void onClick(View view1)
            {
                a.nextBtnClicked(view1);
            }

            
            {
                a = PipStyleFragment.this;
                super();
            }
        });
        g.setOnClickListener(new android.view.View.OnClickListener() {

            final PipStyleFragment a;

            public void onClick(View view1)
            {
                a.backBtnClicked(view1);
            }

            
            {
                a = PipStyleFragment.this;
                super();
            }
        });
        o = (TPipStyleListScrollView)view.findViewById(0x7f0c01ec);
        o.setVisibility(0);
        Object obj2 = (new uw(getActivity())).a();
        obj = new ArrayList();
        obj2 = ((List) (obj2)).iterator();
        int i1 = 0;
        while (((Iterator) (obj2)).hasNext()) 
        {
            uv uv1 = (uv)((Iterator) (obj2)).next();
            TDFSceneInfo tdfsceneinfo2 = TDFSceneInfo.sceneByInfo(uv1.a(), uv1.c(), ESceneMode.SCENE_MODE1, EResType.ONLINE);
            int k1 = p.h().b(tdfsceneinfo2, ESceneCatalog.SCENE_RECTANGLE_SHAPE, ESceneMode.SCENE_MODE1);
            if (k1 >= 0)
            {
                tdfsceneinfo2 = p.h().a(k1, ESceneCatalog.SCENE_RECTANGLE_SHAPE, ESceneMode.SCENE_MODE1);
                p.h().a(k1, i1, ESceneCatalog.SCENE_RECTANGLE_SHAPE, ESceneMode.SCENE_MODE1);
                o.addPipItem(tdfsceneinfo2);
                i1++;
            } else
            {
                o.addPipItem(tdfsceneinfo2);
            }
            ((List) (obj)).add(uv1.a());
        }
        obj2 = p.h().a(ESceneCatalog.SCENE_RECTANGLE_SHAPE, ESceneMode.SCENE_MODE1);
        ((List) (obj2)).iterator();
        obj2 = ((List) (obj2)).iterator();
        do
        {
            if (!((Iterator) (obj2)).hasNext())
            {
                break;
            }
            TDFSceneInfo tdfsceneinfo1 = (TDFSceneInfo)((Iterator) (obj2)).next();
            if (!((List) (obj)).contains(tdfsceneinfo1.getName()))
            {
                o.addPipItem(tdfsceneinfo1);
            }
        } while (true);
        o.setCallback(this);
        k = p.i();
        if (k == null || k.getName() == null) goto _L2; else goto _L1
_L1:
        o.setItemSelected(k.resId, Boolean.valueOf(true));
_L4:
        i = (MaskScrollImageViewTouch)view.findViewById(0x7f0c014b);
        j = (ImageView)view.findViewById(0x7f0c01ef);
        if (p.l() == null)
        {
            p.c(p.b(k));
        }
        j.setImageBitmap(p.l());
        Object obj1 = p.a(k);
        if (obj1 != null)
        {
            i.setMask(((Bitmap) (obj1)));
        }
        obj1 = getResources().getDisplayMetrics();
        float f1 = ((DisplayMetrics) (obj1)).widthPixels;
        if ((getResources().getConfiguration().screenLayout & 0xf) == 1)
        {
            f1 = pb.a(getActivity(), 282F);
        }
        f1 /= k.sceneSize.x;
        FrameLayout framelayout = (FrameLayout)view.findViewById(0x7f0c01ee);
        android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)framelayout.getLayoutParams();
        layoutparams.width = ((DisplayMetrics) (obj1)).widthPixels;
        layoutparams.height = ((DisplayMetrics) (obj1)).widthPixels;
        framelayout.setLayoutParams(layoutparams);
        obj1 = k.frameRect;
        int j1 = (int)((float)((Rect) (obj1)).left * f1);
        int l1 = (int)((float)((Rect) (obj1)).top * f1);
        obj1 = new android.widget.FrameLayout.LayoutParams((int)((float)(((Rect) (obj1)).right - ((Rect) (obj1)).left) * f1), (int)((float)(((Rect) (obj1)).bottom - ((Rect) (obj1)).top) * f1));
        ((android.widget.FrameLayout.LayoutParams) (obj1)).setMargins(j1, l1, 0, 0);
        obj1.gravity = 51;
        i.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        i.resetDisplayMatrix();
        if (p.e() != null)
        {
            i.setImageBitmap(p.e(), true);
        }
        c = (ImageView)view.findViewById(0x7f0c0219);
        b();
        return;
_L2:
        TDFSceneInfo tdfsceneinfo = p.h().a(0, ESceneCatalog.SCENE_RECTANGLE_SHAPE, ESceneMode.SCENE_MODE1);
        if (tdfsceneinfo != null && tdfsceneinfo.getName() != null)
        {
            o.setItemSelected(tdfsceneinfo.resId, Boolean.valueOf(true));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static void a(PipStyleFragment pipstylefragment, int i1)
    {
        pipstylefragment.c(i1);
    }

    static void a(PipStyleFragment pipstylefragment, View view)
    {
        pipstylefragment.c(view);
    }

    static void a(PipStyleFragment pipstylefragment, TDFSceneInfo tdfsceneinfo)
    {
        pipstylefragment.d(tdfsceneinfo);
    }

    static boolean a(PipStyleFragment pipstylefragment)
    {
        return pipstylefragment.D;
    }

    static boolean a(PipStyleFragment pipstylefragment, JSONObject jsonobject)
    {
        return pipstylefragment.a(jsonobject);
    }

    static boolean a(PipStyleFragment pipstylefragment, boolean flag)
    {
        pipstylefragment.D = flag;
        return flag;
    }

    private boolean a(JSONObject jsonobject)
    {
        if (jsonobject != null && jsonobject.length() != 0) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L18:
        return flag;
_L2:
        if (jsonobject == null) goto _L4; else goto _L3
_L3:
        yf yf1;
        yf1 = p.h();
        jsonobject = ty.a(jsonobject, G);
        if (jsonobject == null) goto _L4; else goto _L5
_L5:
        if (jsonobject.size() <= 0) goto _L4; else goto _L6
_L6:
        int i1 = 0;
_L17:
        if (i1 >= jsonobject.size()) goto _L4; else goto _L7
_L7:
        ArrayList arraylist = ((uk)jsonobject.get(i1)).c;
        if (arraylist == null) goto _L9; else goto _L8
_L8:
        if (arraylist.size() <= 0) goto _L9; else goto _L10
_L10:
        int j1 = 0;
_L16:
        if (j1 >= arraylist.size()) goto _L9; else goto _L11
_L11:
        Object obj = (uj)arraylist.get(j1);
        if (((uj) (obj)).d != EOnlineResType.PIP_SCENE) goto _L13; else goto _L12
_L12:
        String s1;
        s1 = ((uj) (obj)).b;
        obj = ((uj) (obj)).g;
        if (obj == null) goto _L13; else goto _L14
_L14:
        if (((ArrayList) (obj)).size() <= 0) goto _L13; else goto _L15
_L15:
        ArrayList arraylist1 = new ArrayList();
        int k1 = 0;
_L19:
        if (k1 < ((ArrayList) (obj)).size())
        {
            TResInfo tresinfo = (TResInfo)((ArrayList) (obj)).get(k1);
            if (!yf1.a(tresinfo.resId, ESceneMode.SCENE_MODE1))
            {
                arraylist1.add(tresinfo);
            }
            break MISSING_BLOCK_LABEL_276;
        }
        if (arraylist1.size() > 0)
        {
            H.put(s1, arraylist1);
        }
_L13:
        j1++;
          goto _L16
_L9:
        i1++;
          goto _L17
        jsonobject;
_L4:
        if (H.size() == 0)
        {
            return false;
        }
        flag = true;
        if (NativeAdWrapper.needFBNative(getActivity()))
        {
            l();
            return true;
        }
          goto _L18
        k1++;
          goto _L19
    }

    static int b(PipStyleFragment pipstylefragment, int i1)
    {
        pipstylefragment.z = i1;
        return i1;
    }

    static Button b(PipStyleFragment pipstylefragment)
    {
        return pipstylefragment.t;
    }

    private void b(View view)
    {
        e = (ImageGLSurfaceView)view.findViewById(0x7f0c0147);
        e.getHolder().addCallback(this);
    }

    private void b(TResInfo tresinfo)
    {
        if (tresinfo != null && p != null)
        {
            if (!uc.a(getActivity()))
            {
                Toast.makeText(getActivity(), getActivity().getResources().getString(0x7f060041), 1).show();
                return;
            }
            I = tresinfo;
            if (!(new ub(p, I)).a() && I != null)
            {
                c(tresinfo);
                return;
            }
        }
    }

    static TPipStyleListScrollView c(PipStyleFragment pipstylefragment)
    {
        return pipstylefragment.o;
    }

    private void c(int i1)
    {
        while (E || o == null) 
        {
            return;
        }
        o.removeAllItems();
        p.a(null);
        Object obj = p.h().a(ESceneCatalog.SCENE_RECTANGLE_SHAPE, ESceneMode.SCENE_MODE1);
        ((List) (obj)).iterator();
        TDFSceneInfo tdfsceneinfo;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); o.addPipItem(tdfsceneinfo))
        {
            tdfsceneinfo = (TDFSceneInfo)((Iterator) (obj)).next();
        }

        o.setCallback(this);
        if (i1 < 0)
        {
            obj = p.h().a(0, ESceneCatalog.SCENE_RECTANGLE_SHAPE, ESceneMode.SCENE_MODE1);
            if (obj != null && ((TDFSceneInfo) (obj)).getName() != null)
            {
                o.setItemSelected(((TDFSceneInfo) (obj)).resId, Boolean.valueOf(true));
            }
            a(((TDFSceneInfo) (obj)));
            return;
        }
        obj = new TDFSceneInfo();
        obj.resId = i1;
        int k1 = p.h().b(((TDFSceneInfo) (obj)), ESceneCatalog.SCENE_RECTANGLE_SHAPE, ESceneMode.SCENE_MODE1);
        int j1 = k1;
        if (k1 < 0)
        {
            j1 = 0;
        }
        obj = p.h().a(j1, ESceneCatalog.SCENE_RECTANGLE_SHAPE, ESceneMode.SCENE_MODE1);
        if (obj != null);
        o.setItemSelected(i1, Boolean.valueOf(true));
        p.a(j1);
        a(((TDFSceneInfo) (obj)));
    }

    private void c(View view)
    {
        if (p != null)
        {
            if (!ew.l(p))
            {
                view = new android.app.AlertDialog.Builder(p);
                view.setTitle(getResources().getString(0x7f060277));
                view.setMessage(getResources().getString(0x7f060169));
                view.setPositiveButton(getResources().getString(0x7f06002f), new android.content.DialogInterface.OnClickListener() {

                    final PipStyleFragment a;

                    public void onClick(DialogInterface dialoginterface, int i1)
                    {
                    }

            
            {
                a = PipStyleFragment.this;
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
                    x = LayoutInflater.from(p).inflate(0x7f030065, null);
                } else
                {
                    x = LayoutInflater.from(p).inflate(0x7f030064, null);
                }
                view = new android.widget.FrameLayout.LayoutParams(-1, -1);
                view.gravity = 17;
                p.addContentView(x, view);
                a(true);
                p.m();
                A.postDelayed(new Runnable() {

                    final PipStyleFragment a;

                    public void run()
                    {
                        PipStyleFragment.g(a);
                    }

            
            {
                a = PipStyleFragment.this;
                super();
            }
                }, 550L);
                ((FrameLayout)x.findViewById(0x7f0c004a)).setOnClickListener(new android.view.View.OnClickListener() {

                    final PipStyleFragment a;

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
                a = PipStyleFragment.this;
                super();
            }
                });
                y = (ListView)x.findViewById(0x7f0c0156);
                y.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

                    final PipStyleFragment a;

                    public void onGlobalLayout()
                    {
                        PipStyleFragment.h(a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
                        PipStyleFragment.b(a, PipStyleFragment.i(a));
                        PipStyleFragment.a(a, new OnlineGridViewAdapter(a.getActivity(), PipStyleFragment.j(a), PipStyleFragment.h(a).getWidth(), PipStyleFragment.h(a).getHeight(), PipStyleFragment.k(a), PipStyleFragment.l(a)));
                        PipStyleFragment.m(a).setItemListener(a);
                        PipStyleFragment.h(a).setAdapter(PipStyleFragment.m(a));
                        PipStyleFragment.h(a).setDividerHeight(PipStyleFragment.m(a).gapBetweenChildrenInRow());
                    }

            
            {
                a = PipStyleFragment.this;
                super();
            }
                });
                y.setOnScrollListener(new android.widget.AbsListView.OnScrollListener() {

                    final PipStyleFragment a;

                    public void onScroll(AbsListView abslistview, int i1, int j1, int k1)
                    {
                        if (i1 == 0)
                        {
                            PipStyleFragment.a(a, true);
                            Log.i("log", "\u6ED1\u5230\u9876\u90E8");
                            return;
                        } else
                        {
                            PipStyleFragment.a(a, false);
                            return;
                        }
                    }

                    public void onScrollStateChanged(AbsListView abslistview, int i1)
                    {
                    }

            
            {
                a = PipStyleFragment.this;
                super();
            }
                });
                y.setOnTouchListener(new android.view.View.OnTouchListener() {

                    final PipStyleFragment a;

                    public boolean onTouch(View view1, MotionEvent motionevent)
                    {
                        PipStyleFragment.n(a).onTouchEvent(motionevent);
                        return false;
                    }

            
            {
                a = PipStyleFragment.this;
                super();
            }
                });
            } else
            {
                a(true);
            }
            x.findViewById(0x7f0c01db);
            if (!PIPCameraApplication.b().a(p))
            {
                e();
                return;
            }
        }
    }

    private void c(TResInfo tresinfo)
    {
        if (tresinfo == null)
        {
            return;
        } else
        {
            tz.a().a(tresinfo, new ua() {

                final PipStyleFragment a;

                public void a(TResInfo tresinfo1)
                {
                    if (tresinfo1 != null && PipStyleFragment.d(a) != null)
                    {
                        PipStyleFragment.d(a).o();
                    }
                }

                public void a(TResInfo tresinfo1, float f1)
                {
                }

                public void a(TDFSceneInfo tdfsceneinfo)
                {
                    if (PipStyleFragment.d(a) != null)
                    {
                        PipStyleFragment.d(a).p();
                    }
                    tdfsceneinfo.mode = ESceneMode.SCENE_MODE1;
                    kf.c().d().a(tdfsceneinfo);
                    PipStyleFragment.a(a, tdfsceneinfo);
                }

                public void b(TResInfo tresinfo1)
                {
                    if (PipStyleFragment.d(a) != null)
                    {
                        PipStyleFragment.d(a).p();
                        Toast.makeText(PipStyleFragment.d(a), PipStyleFragment.d(a).getResources().getString(0x7f0600d7), 0).show();
                    }
                }

            
            {
                a = PipStyleFragment.this;
                super();
            }
            });
            return;
        }
    }

    static PipStyleActivity d(PipStyleFragment pipstylefragment)
    {
        return pipstylefragment.p;
    }

    private void d(TDFSceneInfo tdfsceneinfo)
    {
        while (E || tdfsceneinfo == null || p == null || o == null) 
        {
            return;
        }
        c(tdfsceneinfo.resId);
        if (x != null && B != null)
        {
            a(tdfsceneinfo);
        }
        (new Handler()).postDelayed(new Runnable() {

            final PipStyleFragment a;

            public void run()
            {
                a.b = false;
                a.a(false);
            }

            
            {
                a = PipStyleFragment.this;
                super();
            }
        }, 10L);
        c(tdfsceneinfo);
    }

    static String e(PipStyleFragment pipstylefragment)
    {
        return pipstylefragment.n;
    }

    static ImageGLSurfaceView f(PipStyleFragment pipstylefragment)
    {
        return pipstylefragment.e;
    }

    private void f()
    {
        if (C == null)
        {
            C = new GestureDetector(p, new android.view.GestureDetector.OnGestureListener() {

                final PipStyleFragment a;

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
                    Log.i("PipStyleFragment", (new StringBuilder()).append("onFling,e1,x:").append(motionevent1.getX() - motionevent2.getX()).append("  y:").append(motionevent1.getY() - motionevent2.getY()).append("  distanceX").append(f1).append("  distanceY").append(f2).toString());
                    if (motionevent1.getY() - motionevent2.getY() > 50F && Math.abs(f2) > 100F && PipStyleFragment.a(a))
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
                a = PipStyleFragment.this;
                super();
            }
            });
        }
    }

    private int g()
    {
        char c1 = '\u0264';
        DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        float f1 = displaymetrics.density;
        int i1 = displaymetrics.densityDpi;
        float f2 = displaymetrics.xdpi;
        float f3 = displaymetrics.ydpi;
        float f4 = displaymetrics.widthPixels;
        float f5 = displaymetrics.heightPixels;
        Log.e("PipStyleFragment  DisplayMetrics", (new StringBuilder()).append("xdpi=").append(f2).append("; ydpi=").append(f3).toString());
        Log.e("PipStyleFragment  DisplayMetrics", (new StringBuilder()).append("density=").append(f1).append("; densityDPI=").append(i1).toString());
        Log.v("PipStyleFragment  screenWidth ", String.format("%f", new Object[] {
            Float.valueOf(f4)
        }));
        Log.v("PipStyleFragment  screenHeight ", String.format("%f", new Object[] {
            Float.valueOf(f5)
        }));
        if (f2 < 160F || f4 < 400F)
        {
            c1 = '\u01AC';
        }
        return c1;
    }

    static void g(PipStyleFragment pipstylefragment)
    {
        pipstylefragment.k();
    }

    static ListView h(PipStyleFragment pipstylefragment)
    {
        return pipstylefragment.y;
    }

    private void h()
    {
        (new Date()).getTime();
        if (t != null)
        {
            t.setBackgroundResource(0x7f0200b3);
        }
    }

    private int i()
    {
        return getActivity().getResources().getDimensionPixelSize(0x7f080049);
    }

    static int i(PipStyleFragment pipstylefragment)
    {
        return pipstylefragment.i();
    }

    private fq j()
    {
        if (F == null)
        {
            fo fo1 = new fo(getActivity().getApplicationContext(), ImageCache.b);
            fo1.g = true;
            fo1.d = android.graphics.Bitmap.CompressFormat.PNG;
            fo1.a(0.05F);
            F = new tl(getActivity(), i());
            F.a(getActivity().getSupportFragmentManager(), fo1);
        }
        return F;
    }

    static LinkedHashMap j(PipStyleFragment pipstylefragment)
    {
        return pipstylefragment.H;
    }

    static int k(PipStyleFragment pipstylefragment)
    {
        return pipstylefragment.z;
    }

    private void k()
    {
        if (p != null)
        {
            if (!ew.l(p))
            {
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(p);
                builder.setTitle(getResources().getString(0x7f060277));
                builder.setMessage(getResources().getString(0x7f060169));
                builder.setPositiveButton(getResources().getString(0x7f06002f), new android.content.DialogInterface.OnClickListener() {

                    final PipStyleFragment a;

                    public void onClick(DialogInterface dialoginterface, int i1)
                    {
                    }

            
            {
                a = PipStyleFragment.this;
                super();
            }
                });
                builder.show();
                return;
            }
            boolean flag = false;
            Object obj = p.j().b(d);
            if (obj != null)
            {
                Log.v("PipStyleFragment", "PipStyleFragmentget data from Cache");
                AsyncHttpClient asynchttpclient;
                if (a(((JSONObject) (obj))))
                {
                    m();
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
                Log.v("PipStyleFragment", "PipStyleFragmentget data from server");
                obj = kb.a();
                Log.v("PipStyleFragment", (new StringBuilder()).append("PipStyleFragmentrequestURL").append(((String) (obj))).toString());
                asynchttpclient = new AsyncHttpClient();
                asynchttpclient.setConnectTimeout(20000);
                asynchttpclient.setTimeout(20000);
                asynchttpclient.get(((String) (obj)), null, new JsonHttpResponseHandler() {

                    final PipStyleFragment a;

                    public void onFailure(int i1, Header aheader[], Throwable throwable, JSONObject jsonobject)
                    {
                        Log.v("PipStyleFragment", (new StringBuilder()).append("PipStyleFragmentonFailure statusCode:").append(i1).toString());
                        if (jsonobject != null)
                        {
                            Log.v("PipStyleFragment", (new StringBuilder()).append("PipStyleFragmentonFailure errorResponse:").append(jsonobject.toString()).toString());
                        }
                        if (PipStyleFragment.d(a) != null)
                        {
                            PipStyleFragment.d(a).n();
                        }
                    }

                    public void onSuccess(int i1, Header aheader[], JSONObject jsonobject)
                    {
                        if (i1 == 200 && jsonobject != null)
                        {
                            if (PipStyleFragment.d(a) != null)
                            {
                                PipStyleFragment.d(a).n();
                            }
                            if (PipStyleFragment.a(a, jsonobject))
                            {
                                PipStyleFragment.d(a).j().c(PipStyleFragment.o(a));
                                PipStyleFragment.d(a).j().a(PipStyleFragment.o(a), jsonobject, 300);
                                PipStyleFragment.p(a);
                            }
                        }
                    }

            
            {
                a = PipStyleFragment.this;
                super();
            }
                });
                return;
            }
        }
    }

    static fq l(PipStyleFragment pipstylefragment)
    {
        return pipstylefragment.j();
    }

    private void l()
    {
        if (H != null)
        {
            Log.e("PipStyleFragment", (new StringBuilder()).append("PipStyleFragmentinfos ").append(H.keySet().size()).toString());
            Iterator iterator = H.keySet().iterator();
            int i1 = 0;
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s1 = (String)iterator.next();
                TResInfo tresinfo = new TResInfo();
                tresinfo.resId = TPhotoMagComposeManager.KFBNATIVEID + i1;
                tresinfo.icon = "";
                tresinfo.zipUrl = "";
                tresinfo.name = (new StringBuilder()).append("nativeAd_").append(TPhotoMagComposeManager.KFBNATIVEID).append(i1).toString();
                if (H.get(s1) != null)
                {
                    ((ArrayList)H.get(s1)).add(0, tresinfo);
                    i1++;
                }
            } while (true);
        }
    }

    static OnlineGridViewAdapter m(PipStyleFragment pipstylefragment)
    {
        return pipstylefragment.B;
    }

    private void m()
    {
        if (!E)
        {
            h();
            if (p != null)
            {
                p.runOnUiThread(new Runnable() {

                    final PipStyleFragment a;

                    public void run()
                    {
                        PipStyleFragment.d(a).n();
                        if (PipStyleFragment.m(a) != null)
                        {
                            PipStyleFragment.m(a).notifyDataSetChanged();
                        }
                    }

            
            {
                a = PipStyleFragment.this;
                super();
            }
                });
                return;
            }
        }
    }

    static GestureDetector n(PipStyleFragment pipstylefragment)
    {
        return pipstylefragment.C;
    }

    static String o(PipStyleFragment pipstylefragment)
    {
        return pipstylefragment.d;
    }

    static void p(PipStyleFragment pipstylefragment)
    {
        pipstylefragment.m();
    }

    protected void a()
    {
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("ACTION_MATERIAL_ADDED");
        intentfilter.addAction("ACTION_MATERIAL_REMOVE");
        p.registerReceiver(v, intentfilter);
    }

    public void a(int i1)
    {
        p.a();
    }

    public void a(Bitmap bitmap, int i1)
    {
        if (bitmap == null)
        {
            Log.v("cropImagefail", "cropImagefail");
        }
        if (bitmap != null)
        {
            e.processImage(bitmap, m, new Handler() {

                final PipStyleFragment a;

                public void handleMessage(Message message)
                {
                    if (message != null && message.obj != null)
                    {
                        message = (Bitmap)message.obj;
                        PipStyleFragment.d(a).b(message);
                        PipStyleFragment.f(a).setFilterName(PipStyleFragment.e(a));
                        PipStyleFragment.f(a).setSourceBitmap(message);
                    }
                }

            
            {
                a = PipStyleFragment.this;
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
                            Log.v("PipStyleFragment", (new StringBuilder()).append("PipStyleFragmentitem name:").append(tresinfo1.name).append(" info name:").append(tresinfo.name).toString());
                            if (tresinfo1.resId == tresinfo.resId)
                            {
                                arraylist.remove(tresinfo1);
                                if (arraylist.size() == 0)
                                {
                                    H.remove(s1);
                                }
                                Log.v("PipStyleFragment", "PipStyleFragment refreshGridViewDataWhenDownloadFinished remove success");
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
        Log.v("PipStyleFragment", (new StringBuilder()).append("PipStyleFragmentonGridItemClicked info name:").append(tresinfo.getName()).toString());
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
            Log.v("PipStyleFragment", "on line resource");
            uj uj1 = new uj();
            uj1.d = EOnlineResType.PIP_SCENE;
            a = new sy((PipStyleActivity)getActivity());
            tu tu1 = ts.a(uj1.d);
            tu1.setMaterialType(uj1);
            tu1.setoperationDelegate(a);
            tu1.update();
            ((PipStyleActivity)getActivity()).a();
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
        Log.v("PipStyleFragment", "PipStyleFragment onCropFailed");
        if (p != null)
        {
            p.b();
        }
    }

    public void a(ArrayList arraylist, int i1)
    {
        Log.v("CropImageDidProcessed", "CropImageDidProcessed");
        p.b();
        if (arraylist.size() > 0)
        {
            if (1000 == i1)
            {
                arraylist = (Bitmap)arraylist.get(0);
                p.a(arraylist);
                if (p.f() == null && arraylist != null)
                {
                    AsynPIPCropImageTask asynpipcropimagetask = new AsynPIPCropImageTask(arraylist);
                    asynpipcropimagetask.a(this);
                    asynpipcropimagetask.execute(new Context[] {
                        getActivity()
                    });
                }
                if (i != null)
                {
                    i.setImageBitmap(arraylist, true);
                }
            } else
            if (2000 == i1)
            {
                a((Bitmap)arraylist.get(0));
                return;
            }
        }
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

    public void a_(int i1)
    {
    }

    public void b()
    {
        if (b(k.resId))
        {
            c.setVisibility(4);
            return;
        } else
        {
            c.setVisibility(0);
            return;
        }
    }

    public void b(TDFSceneInfo tdfsceneinfo)
    {
        if (E)
        {
            return;
        }
        j.setImageBitmap(null);
        p.c(null);
        Object obj = p.b(tdfsceneinfo);
        p.c(((Bitmap) (obj)));
        j.setImageBitmap(((Bitmap) (obj)));
        k = tdfsceneinfo;
        obj = p.a(k);
        i.setMask(((Bitmap) (obj)));
        float f1 = PIPCameraApplication.a.getResources().getDisplayMetrics().widthPixels;
        if ((getResources().getConfiguration().screenLayout & 0xf) == 1)
        {
            f1 = pb.a(getActivity(), 282F);
        }
        f1 /= k.sceneSize.x;
        obj = k.frameRect;
        int i1 = (int)((float)((Rect) (obj)).left * f1);
        int j1 = (int)((float)((Rect) (obj)).top * f1);
        obj = new android.widget.FrameLayout.LayoutParams((int)((float)(((Rect) (obj)).right - ((Rect) (obj)).left) * f1), (int)(f1 * (float)(((Rect) (obj)).bottom - ((Rect) (obj)).top)));
        ((android.widget.FrameLayout.LayoutParams) (obj)).setMargins(i1, j1, 0, 0);
        obj.gravity = 51;
        i.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        i.resetDisplayMatrix();
        b();
        q = p.h().b(tdfsceneinfo, ESceneCatalog.SCENE_RECTANGLE_SHAPE, ESceneMode.SCENE_MODE1);
        Log.v("mindex", String.format("%d", new Object[] {
            Integer.valueOf(q)
        }));
        p.a(q);
    }

    public boolean b(int i1)
    {
        boolean flag1 = false;
        int ai[] = new int[23];
        int[] _tmp = ai;
        ai[0] = 531;
        ai[1] = 557;
        ai[2] = 63;
        ai[3] = 608;
        ai[4] = 614;
        ai[5] = 619;
        ai[6] = 429;
        ai[7] = 536;
        ai[8] = 545;
        ai[9] = 597;
        ai[10] = 601;
        ai[11] = 268;
        ai[12] = 435;
        ai[13] = 506;
        ai[14] = 277;
        ai[15] = 533;
        ai[16] = 279;
        ai[17] = 559;
        ai[18] = 318;
        ai[19] = 442;
        ai[20] = 464;
        ai[21] = 809;
        ai[22] = 811;
        int j1 = ai.length;
        i1 = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i1 < j1)
                {
                    if (k.resId != ai[i1])
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i1++;
        } while (true);
    }

    public void backBtnClicked(View view)
    {
        if (p != null)
        {
            p.c();
        }
    }

    protected void c()
    {
        try
        {
            PipStyleActivity pipstyleactivity = p;
            startActivityForResult(PipStyleActivity.k(), 3021);
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
            if (p != null)
            {
                p.c(tdfsceneinfo);
            }
            k = tdfsceneinfo;
        }
        j.setImageBitmap(null);
        p.c(null);
        tdfsceneinfo = p.b(tdfsceneinfo);
        p.c(tdfsceneinfo);
        j.setImageBitmap(tdfsceneinfo);
        tdfsceneinfo = p.a(k);
        i.setMask(tdfsceneinfo);
        tdfsceneinfo = getResources().getDisplayMetrics();
        float f1 = (float)((DisplayMetrics) (tdfsceneinfo)).widthPixels - ((DisplayMetrics) (tdfsceneinfo)).density * 10F;
        if (PIPCameraApplication.d())
        {
            f1 = (float)ew.a(getActivity(), 290F) - ((DisplayMetrics) (tdfsceneinfo)).density * 10F;
        }
        f1 /= k.sceneSize.x;
        tdfsceneinfo = k.frameRect;
        int i1 = (int)((float)((Rect) (tdfsceneinfo)).left * f1);
        int j1 = (int)((float)((Rect) (tdfsceneinfo)).top * f1);
        tdfsceneinfo = new android.widget.FrameLayout.LayoutParams((int)((float)(((Rect) (tdfsceneinfo)).right - ((Rect) (tdfsceneinfo)).left) * f1), (int)(f1 * (float)(((Rect) (tdfsceneinfo)).bottom - ((Rect) (tdfsceneinfo)).top)));
        tdfsceneinfo.setMargins(i1, j1, 0, 0);
        tdfsceneinfo.gravity = 51;
        i.setLayoutParams(tdfsceneinfo);
        i.resetDisplayMatrix();
        if (p.e() != null)
        {
            tdfsceneinfo = i.getImageCenterPointF();
            i.setImageCenterPoint(tdfsceneinfo, p.e().getWidth(), p.e().getHeight());
        }
        b();
    }

    protected void d()
    {
        try
        {
            FotoAdFactory.createAdBanner(p, getView());
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
            FotoAdFactory.createAdBanner(p, x.findViewById(0x7f0c0055));
            return;
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
        }
    }

    public void nextBtnClicked(View view)
    {
        if (p != null)
        {
            p.a(i.getDisplayMatrix());
            p.d();
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
        p.a();
        so so1 = new so();
        ArrayList arraylist = new ArrayList();
        arraylist.add(intent);
        so1.a(arraylist);
        so1.a(this);
        so1.b(r);
        so1.a(2000);
        so1.c(new ArrayList[0]);
    }

    public boolean onContextItemSelected(MenuItem menuitem)
    {
        String s1;
        String s2;
        boolean flag;
        flag = false;
        s1 = getResources().getString(0x7f0601bd);
        s2 = getResources().getString(0x7f0601bc);
        l = false;
        if (!menuitem.getTitle().toString().equalsIgnoreCase(s1)) goto _L2; else goto _L1
_L1:
        Log.v("menuitemselected", "item1");
        c();
_L6:
        flag = true;
_L4:
        return flag;
_L2:
        if (!menuitem.getTitle().toString().equalsIgnoreCase(s2)) goto _L4; else goto _L3
_L3:
        l = true;
        Log.v("menuitemselected", "item2");
        c();
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Log.v("PipStyleFragment onCreate", "PipStyleFragment onCreate");
        p = (PipStyleActivity)getActivity();
        G.add(EOnlineResType.PIP_SCENE);
        A = new Handler();
        if (getArguments() == null)
        {
            Log.e("PipStyleFragment", "getArguments() is null");
        }
        s = Uri.parse(getArguments().getString("SelectedImageUri"));
        v = new BroadcastReceiver() {

            final PipStyleFragment a;

            public void onReceive(Context context, Intent intent)
            {
                context = intent.getAction();
                Log.v("PipStyleFragment", "PipStyleFragmentBroadcastReceiver on receiver");
                if (context != null && intent.getStringExtra("TYPE_MATERIAL") != null)
                {
                    context = intent.getStringExtra("TYPE_MATERIAL");
                    int i1 = intent.getIntExtra("RESID_MATERIAL", 0);
                    if (context.equalsIgnoreCase(tu.getStringByResType(EOnlineResType.PIP_SCENE)))
                    {
                        PipStyleFragment.a(a, i1);
                    }
                }
            }

            
            {
                a = PipStyleFragment.this;
                super();
            }
        };
        a();
        w = new tv();
        w.a(this);
        f();
    }

    public void onCreateContextMenu(ContextMenu contextmenu, View view, android.view.ContextMenu.ContextMenuInfo contextmenuinfo)
    {
        super.onCreateContextMenu(contextmenu, view, contextmenuinfo);
        contextmenu.setHeaderTitle(getResources().getString(0x7f0601e0));
        contextmenu.add(0, view.getId(), 0, getResources().getString(0x7f0601bd));
        contextmenu.add(0, view.getId(), 0, getResources().getString(0x7f0601bc));
        contextmenu.add(0, view.getId(), 0, getResources().getString(0x7f060033));
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        Log.v("PipStyleFragment onCreateView", "PipStyleFragment onCreateView");
        layoutinflater = layoutinflater.inflate(0x7f030075, viewgroup, false);
        n = getResources().getString(0x7f060181);
        m = getResources().getString(0x7f0600fe);
        h = (Button)layoutinflater.findViewById(0x7f0c021f);
        t = (Button)layoutinflater.findViewById(0x7f0c01f4);
        t.setOnClickListener(new android.view.View.OnClickListener() {

            final PipStyleFragment a;

            public void onClick(View view)
            {
                PipStyleFragment.a(a, view);
            }

            
            {
                a = PipStyleFragment.this;
                super();
            }
        });
        registerForContextMenu(h);
        u = (RelativeLayout)layoutinflater.findViewById(0x7f0c0220);
        a(layoutinflater);
        b(layoutinflater);
        if (p.e() == null)
        {
            viewgroup = new so();
            bundle = new ArrayList();
            bundle.add(s);
            viewgroup.a(bundle);
            r = g();
            viewgroup.b(r);
            viewgroup.a(this);
            viewgroup.a(1000);
            viewgroup.c(new ArrayList[0]);
        }
        t.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

            final PipStyleFragment a;

            public void onGlobalLayout()
            {
                PipStyleFragment.b(a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
                if (PipStyleFragment.b(a) != null)
                {
                    android.view.ViewGroup.LayoutParams layoutparams = PipStyleFragment.b(a).getLayoutParams();
                    if (layoutparams != null)
                    {
                        Log.v("height:", (new StringBuilder()).append("PipStyleFragment:").append(PipStyleFragment.c(a).getLayoutParams().height).append("").toString());
                        layoutparams.height = PipStyleFragment.c(a).getHeight() - pb.a(PipStyleFragment.d(a), 29F);
                        layoutparams.width = PipStyleFragment.c(a).getHeight() - pb.a(PipStyleFragment.d(a), 29F);
                        PipStyleFragment.b(a).setLayoutParams(layoutparams);
                    }
                }
            }

            
            {
                a = PipStyleFragment.this;
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
        if (j != null)
        {
            j.setImageBitmap(null);
        }
        if (i != null)
        {
            i.setImageBitmap(null);
        }
        System.gc();
        p.unregisterReceiver(v);
    }

    public void onPause()
    {
        if (e != null && e.getRender() != null)
        {
            e.onPause();
        }
        super.onPause();
        Log.v("PipStyleFragment onPause", "PipStyleFragment onPause");
    }

    public void onResume()
    {
        if (e != null && e.getRender() != null)
        {
            e.onResume();
        }
        if (u != null)
        {
            u.setTag("bannerRelative");
            FotoAdFactory.createAdBanner(getActivity(), u);
        }
        super.onResume();
        Log.v("PipStyleFragment onResume", "PipStyleFragment onResume");
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i1, int j1, int k1)
    {
        Log.v("surfaceChanged", "surfaceChanged");
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
        Log.v("surfaceCreated", "surfaceCreated");
        if (p.f() != null)
        {
            e.setSourceBitmap(p.f());
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
    }
}
