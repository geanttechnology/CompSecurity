// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip.fragment;

import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.ConfigurationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.Toast;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.pipcamera.activity.NewPhotoShareActivity;
import com.pipcamera.activity.pip.PipFreeStyleActivity;
import com.pipcamera.activity.pip.view.PaintView;
import com.wantu.imagelib.filter.TImageFilterInfo;
import com.wantu.imagelib.filter.TImageFilterManager;
import com.wantu.imagelib.filter.TPipFilterManger;
import com.wantu.piprender.PipFreeStyleImageGLSurfaceView;
import com.wantu.view.TFilterListScrollView;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rd;
import so;
import sp;
import sz;
import vk;
import wantu.sephiroth.android.library.imagezoom.MaskScrollImageViewTouch;
import ys;

public class PipFreeStyleFragment extends Fragment
    implements android.view.SurfaceHolder.Callback, sp, sz, ys
{

    private PipFreeStyleImageGLSurfaceView a;
    private vk b;
    private Button c;
    private Button d;
    private MaskScrollImageViewTouch e;
    private PaintView f;
    private Boolean g;
    private String h;
    private String i;
    private String j;
    private TFilterListScrollView k;
    private TImageFilterManager l;
    private PipFreeStyleActivity m;
    private int n;
    private Uri o;
    private Button p;
    private Button q;
    private Button r;
    private View s;
    private SeekBar t;
    private boolean u;
    private Button v;

    public PipFreeStyleFragment()
    {
        h = null;
        i = null;
        j = null;
        n = 612;
    }

    private float a(Uri uri)
    {
        android.graphics.BitmapFactory.Options options;
        try
        {
            uri = getActivity().getContentResolver().openInputStream(uri);
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            uri.printStackTrace();
            Crashlytics.logException(uri);
            return 0.0F;
        }
        options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(uri, null, options);
        return (float)options.outWidth / (float)options.outHeight;
    }

    static Bitmap a(PipFreeStyleFragment pipfreestylefragment, Bitmap bitmap)
    {
        return pipfreestylefragment.b(bitmap);
    }

    static Button a(PipFreeStyleFragment pipfreestylefragment)
    {
        return pipfreestylefragment.p;
    }

    private void a(Bitmap bitmap)
    {
        if (g.booleanValue())
        {
            return;
        }
        if (e != null && e != null)
        {
            e.setImageBitmap(null);
            e.setMask(null);
            m.c(null);
        }
        c(bitmap);
    }

    private void a(View view)
    {
        f = (PaintView)view.findViewById(0x7f0c020a);
        f.setPaintDelegate(this);
        c = (Button)view.findViewById(0x7f0c0080);
        d = (Button)view.findViewById(0x7f0c007f);
        v = (Button)view.findViewById(0x7f0c020f);
        c.setOnClickListener(new android.view.View.OnClickListener() {

            final PipFreeStyleFragment a;

            public void onClick(View view1)
            {
                a.nextBtnClicked(view1);
            }

            
            {
                a = PipFreeStyleFragment.this;
                super();
            }
        });
        d.setOnClickListener(new android.view.View.OnClickListener() {

            final PipFreeStyleFragment a;

            public void onClick(View view1)
            {
                a.backBtnClicked(view1);
            }

            
            {
                a = PipFreeStyleFragment.this;
                super();
            }
        });
        v.setOnClickListener(new android.view.View.OnClickListener() {

            final PipFreeStyleFragment a;

            public void onClick(View view1)
            {
                a.getActivity().openContextMenu(view1);
            }

            
            {
                a = PipFreeStyleFragment.this;
                super();
            }
        });
        q = (Button)view.findViewById(0x7f0c020c);
        q.setOnClickListener(new android.view.View.OnClickListener() {

            final PipFreeStyleFragment a;

            public void onClick(View view1)
            {
                PipFreeStyleFragment.a(a).setEnabled(false);
                PipFreeStyleFragment.b(a).setBlurRadius(0.0F);
                PipFreeStyleFragment.b(a).setMaskImage(null);
                PipFreeStyleFragment.c(a).clear();
                PipFreeStyleFragment.c(a).setVisibility(0);
                PipFreeStyleFragment.d(a);
                PipFreeStyleFragment.a(a).setVisibility(0);
                PipFreeStyleFragment.e(a).setVisibility(4);
                PipFreeStyleFragment.f(a).setVisibility(4);
                PipFreeStyleFragment.g(a).setVisibility(4);
                PipFreeStyleFragment.h(a);
            }

            
            {
                a = PipFreeStyleFragment.this;
                super();
            }
        });
        p = (Button)view.findViewById(0x7f0c020d);
        Object obj = p;
        float f1;
        boolean flag;
        if (f.hasDrawing())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((Button) (obj)).setEnabled(flag);
        p.setOnClickListener(new android.view.View.OnClickListener() {

            final PipFreeStyleFragment a;

            public void onClick(View view1)
            {
                if (PipFreeStyleFragment.c(a).hasDrawing())
                {
                    PipFreeStyleFragment.i(a).a();
                    Bitmap bitmap = PipFreeStyleFragment.c(a).getMaskBitmap();
                    PipFreeStyleFragment.c(a).setVisibility(4);
                    PipFreeStyleFragment.j(a);
                    if (bitmap != null)
                    {
                        PipFreeStyleFragment.b(a).processImage(bitmap, "gaussian_12", new Handler(this) {

                            final _cls6 a;

                            public void handleMessage(Message message)
                            {
                                if (message != null)
                                {
                                    PipFreeStyleFragment.e(a.a).setVisibility(0);
                                    PipFreeStyleFragment.f(a.a).setVisibility(0);
                                    message = (Bitmap)message.obj;
                                    Bitmap bitmap = PipFreeStyleFragment.a(a.a, message);
                                    PipFreeStyleFragment.i(a.a).b(bitmap);
                                    PipFreeStyleFragment.b(a.a).setMaskImage(message);
                                    PipFreeStyleFragment.b(a.a).setFilterName(PipFreeStyleFragment.k(a.a));
                                    PipFreeStyleFragment.l(a.a).getProgress();
                                    PipFreeStyleFragment.b(a.a).setBlurRadius(PipFreeStyleFragment.l(a.a).getProgress() / 5);
                                }
                                if (PipFreeStyleFragment.i(a.a) != null)
                                {
                                    PipFreeStyleFragment.i(a.a).b();
                                }
                            }

            
            {
                a = _pcls6;
                super();
            }
                        });
                        view1.setVisibility(4);
                        return;
                    }
                }
            }

            
            {
                a = PipFreeStyleFragment.this;
                super();
            }
        });
        f1 = a(o);
        Log.v("PipFreeStyleFragment", (new StringBuilder()).append("PipFreeStyleFragmentratio:").append(f1).toString());
        if (f1 != 0.0F);
        obj = (FrameLayout)view.findViewById(0x7f0c0208);
        ((FrameLayout) (obj)).getViewTreeObserver().addOnPreDrawListener(new android.view.ViewTreeObserver.OnPreDrawListener(((FrameLayout) (obj)), f1) {

            final FrameLayout a;
            final float b;
            final PipFreeStyleFragment c;

            public boolean onPreDraw()
            {
                int i1 = a.getWidth();
                int j1 = a.getHeight();
                float f2 = (float)i1 / (float)j1;
                Log.v("PipFreeStyleFragment", (new StringBuilder()).append("PipFreeStyleFragmentframeRatio:").append(f2).toString());
                if (f2 == b)
                {
                    return true;
                }
                android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)a.getLayoutParams();
                if (f2 > b)
                {
                    layoutparams.width = (int)(b * (float)j1);
                } else
                {
                    layoutparams.height = (int)((float)i1 / b);
                }
                a.setLayoutParams(layoutparams);
                (new Handler()).post(new Runnable(this, this) {

                    final android.view.ViewTreeObserver.OnPreDrawListener a;
                    final _cls7 b;

                    public void run()
                    {
                        b.a.getViewTreeObserver().removeOnPreDrawListener(a);
                    }

            
            {
                b = _pcls7;
                a = onpredrawlistener;
                super();
            }
                });
                return true;
            }

            
            {
                c = PipFreeStyleFragment.this;
                a = framelayout;
                b = f1;
                super();
            }
        });
        c(view);
        s = view.findViewById(0x7f0c0210);
        t = (SeekBar)view.findViewById(0x7f0c0211);
        t.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

            final PipFreeStyleFragment a;

            public void onProgressChanged(SeekBar seekbar, int i1, boolean flag1)
            {
            }

            public void onStartTrackingTouch(SeekBar seekbar)
            {
            }

            public void onStopTrackingTouch(SeekBar seekbar)
            {
                int i1 = seekbar.getProgress() / 5;
                PipFreeStyleFragment.b(a).setBlurRadius(i1);
            }

            
            {
                a = PipFreeStyleFragment.this;
                super();
            }
        });
        r = (Button)view.findViewById(0x7f0c020e);
        r.setOnClickListener(new android.view.View.OnClickListener() {

            final PipFreeStyleFragment a;

            public void onClick(View view1)
            {
                view1 = PipFreeStyleFragment.f(a);
                byte byte0;
                if (PipFreeStyleFragment.f(a).getVisibility() == 0)
                {
                    byte0 = 4;
                } else
                {
                    byte0 = 0;
                }
                view1.setVisibility(byte0);
            }

            
            {
                a = PipFreeStyleFragment.this;
                super();
            }
        });
    }

    private int b()
    {
        char c1 = '\u0264';
        DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        float f1 = displaymetrics.density;
        int i1 = displaymetrics.densityDpi;
        float f2 = displaymetrics.xdpi;
        float f3 = displaymetrics.ydpi;
        float f4 = displaymetrics.widthPixels;
        float f5 = displaymetrics.heightPixels;
        Log.e("PipFreeStyleFragment  DisplayMetrics", (new StringBuilder()).append("xdpi=").append(f2).append("; ydpi=").append(f3).toString());
        Log.e("PipFreeStyleFragment  DisplayMetrics", (new StringBuilder()).append("density=").append(f1).append("; densityDPI=").append(i1).toString());
        Log.v("PipFreeStyleFragment  screenWidth ", String.format("%f", new Object[] {
            Float.valueOf(f4)
        }));
        Log.v("PipFreeStyleFragment  screenHeight ", String.format("%f", new Object[] {
            Float.valueOf(f5)
        }));
        if (f2 < 160F || f4 < 400F)
        {
            c1 = '\u01AC';
        }
        return c1;
    }

    private Bitmap b(Bitmap bitmap)
    {
        Object obj = null;
        if (bitmap != null)
        {
            obj = f();
            obj = Bitmap.createBitmap(bitmap, Math.round(((RectF) (obj)).left), Math.round(((RectF) (obj)).top), Math.round(((RectF) (obj)).width()), Math.round(((RectF) (obj)).height()), null, true).extractAlpha();
        }
        return ((Bitmap) (obj));
    }

    static Bitmap b(PipFreeStyleFragment pipfreestylefragment, Bitmap bitmap)
    {
        return pipfreestylefragment.d(bitmap);
    }

    public static PipFreeStyleFragment b(String s1)
    {
        PipFreeStyleFragment pipfreestylefragment = new PipFreeStyleFragment();
        Bundle bundle = new Bundle();
        bundle.putString("SelectedImageUri", s1);
        pipfreestylefragment.setArguments(bundle);
        return pipfreestylefragment;
    }

    static PipFreeStyleImageGLSurfaceView b(PipFreeStyleFragment pipfreestylefragment)
    {
        return pipfreestylefragment.a;
    }

    private void b(View view)
    {
        a = (PipFreeStyleImageGLSurfaceView)view.findViewById(0x7f0c0209);
        boolean flag;
        if (((ActivityManager)m.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion >= 0x20000)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            a.setEGLContextClientVersion(2);
            a.setEGLConfigChooser(8, 8, 8, 8, 0, 0);
            view = new DisplayMetrics();
            m.getWindowManager().getDefaultDisplay().getMetrics(view);
            b = new vk(getActivity());
            a.getHolder().setFormat(1);
            a.getHolder().addCallback(this);
            a.setRenderer(b, ((DisplayMetrics) (view)).density);
            return;
        } else
        {
            FlurryAgent.logEvent("ErrorOpenglNotSupport");
            return;
        }
    }

    static PaintView c(PipFreeStyleFragment pipfreestylefragment)
    {
        return pipfreestylefragment.f;
    }

    private TImageFilterManager c()
    {
        if (l == null)
        {
            l = new TPipFilterManger();
        }
        return l;
    }

    private void c(Bitmap bitmap)
    {
        u = true;
        RectF rectf = f();
        if (e == null)
        {
            e = new MaskScrollImageViewTouch(getActivity());
            ((FrameLayout)getView().findViewById(0x7f0c0208)).addView(e);
        }
        e.setImageBitmap(bitmap, true);
        e.setMask(m.e());
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(Math.round(rectf.width()), Math.round(rectf.height()));
        layoutparams.setMargins(Math.round(rectf.left), Math.round(rectf.top), 0, 0);
        layoutparams.gravity = 51;
        e.setLayoutParams(layoutparams);
        e.resetDisplayMatrix();
        e.setVisibility(0);
        m.c(bitmap);
        k.setItemSelected(1, Boolean.valueOf(true));
    }

    private void c(View view)
    {
        k = (TFilterListScrollView)view.findViewById(0x7f0c01ec);
        view = c().getmFilterDict();
        List list = c().filterNamesByCatalogeName("default-filter");
        TImageFilterInfo timagefilterinfo;
        for (Iterator iterator = list.iterator(); iterator.hasNext(); k.addFilterItem(timagefilterinfo.iconUrl, timagefilterinfo.filterName))
        {
            timagefilterinfo = (TImageFilterInfo)view.get((String)iterator.next());
        }

        i = (String)list.get(0);
        k.setCallback(this);
        k.setItemSelected(0, Boolean.valueOf(true));
        k.setVisibility(4);
        c.setVisibility(4);
    }

    private Bitmap d(Bitmap bitmap)
    {
        Bitmap bitmap1;
label0:
        {
            bitmap1 = null;
            if (e != null)
            {
                android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)e.getLayoutParams();
                Bitmap bitmap2 = e.getDispalyImage(layoutparams.width, layoutparams.height);
                bitmap1 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap1);
                Paint paint = new Paint();
                paint.setFilterBitmap(true);
                if (bitmap != null && !bitmap.isRecycled())
                {
                    canvas.drawBitmap(bitmap, 0.0F, 0.0F, paint);
                }
                if (bitmap2 == null || bitmap2.isRecycled())
                {
                    break label0;
                }
                canvas.drawBitmap(bitmap2, layoutparams.leftMargin, layoutparams.topMargin, paint);
                bitmap2.recycle();
            }
            return bitmap1;
        }
        return bitmap1;
    }

    private void d()
    {
        if (k.getVisibility() == 4)
        {
            android.view.animation.Animation animation = AnimationUtils.loadAnimation(getActivity(), 0x7f04001f);
            k.startAnimation(animation);
            k.setVisibility(0);
            c.setVisibility(0);
        }
    }

    static void d(PipFreeStyleFragment pipfreestylefragment)
    {
        pipfreestylefragment.e();
    }

    static Button e(PipFreeStyleFragment pipfreestylefragment)
    {
        return pipfreestylefragment.r;
    }

    private void e()
    {
        if (k.getVisibility() == 0)
        {
            android.view.animation.Animation animation = AnimationUtils.loadAnimation(getActivity(), 0x7f040023);
            k.startAnimation(animation);
            k.setVisibility(4);
            c.setVisibility(4);
        }
    }

    private RectF f()
    {
        RectF rectf = f.getDrawingBoundingBox();
        rectf.inset(-12F, -12F);
        rectf.intersect(new RectF(0.0F, 0.0F, f.getWidth(), f.getHeight()));
        return rectf;
    }

    static View f(PipFreeStyleFragment pipfreestylefragment)
    {
        return pipfreestylefragment.s;
    }

    static Button g(PipFreeStyleFragment pipfreestylefragment)
    {
        return pipfreestylefragment.v;
    }

    private void g()
    {
        if (e != null)
        {
            e.setImageBitmap(null);
            e.setMask(null);
            e.setVisibility(4);
        }
        m.b(null);
        u = false;
        m.c(null);
    }

    static void h(PipFreeStyleFragment pipfreestylefragment)
    {
        pipfreestylefragment.g();
    }

    static PipFreeStyleActivity i(PipFreeStyleFragment pipfreestylefragment)
    {
        return pipfreestylefragment.m;
    }

    static void j(PipFreeStyleFragment pipfreestylefragment)
    {
        pipfreestylefragment.d();
    }

    static String k(PipFreeStyleFragment pipfreestylefragment)
    {
        return pipfreestylefragment.j;
    }

    static SeekBar l(PipFreeStyleFragment pipfreestylefragment)
    {
        return pipfreestylefragment.t;
    }

    static boolean m(PipFreeStyleFragment pipfreestylefragment)
    {
        return pipfreestylefragment.u;
    }

    static MaskScrollImageViewTouch n(PipFreeStyleFragment pipfreestylefragment)
    {
        return pipfreestylefragment.e;
    }

    protected void a()
    {
        try
        {
            PipFreeStyleActivity pipfreestyleactivity = m;
            startActivityForResult(PipFreeStyleActivity.g(), 3021);
            return;
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            Toast.makeText(getActivity(), 0x7f060188, 1).show();
            Crashlytics.logException(activitynotfoundexception);
            return;
        }
    }

    public void a(int i1)
    {
        m.a();
    }

    public void a(MotionEvent motionevent)
    {
        switch (motionevent.getAction())
        {
        default:
            return;

        case 0: // '\0'
            Log.d("PipFreeStyleFragment", "dispatchTouchEvent action:ACTION_DOWN");
            return;

        case 2: // '\002'
            Log.d("PipFreeStyleFragment", "dispatchTouchEvent action:ACTION_MOVE");
            return;

        case 1: // '\001'
            Log.d("PipFreeStyleFragment", "dispatchTouchEvent action:ACTION_UP");
            if (f.hasDrawing())
            {
                p.setEnabled(true);
                return;
            } else
            {
                p.setEnabled(false);
                return;
            }

        case 3: // '\003'
            Log.d("PipFreeStyleFragment", "dispatchTouchEvent action:ACTION_CANCEL");
            return;
        }
    }

    public void a(String s1)
    {
        j = s1;
        if (u)
        {
            m.a();
            a.fastProcessImage(m.f(), s1, new Handler() {

                final PipFreeStyleFragment a;

                public void handleMessage(Message message)
                {
                    PipFreeStyleFragment.i(a).b();
                    if (message != null)
                    {
                        message = (Bitmap)message.obj;
                        PipFreeStyleFragment.n(a).setImageBitmap(message, false);
                    }
                }

            
            {
                a = PipFreeStyleFragment.this;
                super();
            }
            });
        } else
        if (m.d() != null)
        {
            a.setFilterName(s1);
            return;
        }
    }

    public void a(ArrayList arraylist, int i1)
    {
        Log.v("CropImageDidProcessed", "CropImageDidProcessed");
        m.b();
        if (arraylist.size() > 0)
        {
            if (1000 == i1)
            {
                arraylist = (Bitmap)arraylist.get(0);
                m.a(arraylist);
                a.setFilterName(i);
                a.setSourceBitmap(arraylist);
            } else
            if (2000 == i1)
            {
                a((Bitmap)arraylist.get(0));
                return;
            }
        }
    }

    public void backBtnClicked(View view)
    {
        if (m != null)
        {
            m.c();
        }
    }

    public void nextBtnClicked(View view)
    {
        m.a();
        a.takeScreenShot(new Handler() {

            final PipFreeStyleFragment a;

            public void handleMessage(Message message)
            {
                Object obj = (Bitmap)message.obj;
                if (obj == null)
                {
                    try
                    {
                        PipFreeStyleFragment.i(a).b();
                        Log.e("PipFreeStyleFragment", "Can't make result image");
                        Toast.makeText(PipFreeStyleFragment.i(a), 0x7f060152, 1).show();
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Message message)
                    {
                        message.printStackTrace();
                    }
                    break MISSING_BLOCK_LABEL_105;
                }
                message = ((Message) (obj));
                if (PipFreeStyleFragment.m(a))
                {
                    message = PipFreeStyleFragment.b(a, ((Bitmap) (obj)));
                    ((Bitmap) (obj)).recycle();
                }
                obj = rd.a(message);
                if (obj != null)
                {
                    break MISSING_BLOCK_LABEL_120;
                }
                PipFreeStyleFragment.i(a).runOnUiThread(new Runnable(this) {

                    final _cls10 a;

                    public void run()
                    {
                        Toast.makeText(PipFreeStyleFragment.i(a.a), PipFreeStyleFragment.i(a.a).getResources().getString(0x7f060196), 0).show();
                    }

            
            {
                a = _pcls10;
                super();
            }
                });
                return;
                Crashlytics.logException(message);
                PipFreeStyleFragment.i(a).b();
                return;
                rd.a(((File) (obj)).getAbsolutePath(), PipFreeStyleFragment.i(a));
                obj = Uri.fromFile(((File) (obj)));
                PipFreeStyleFragment.i(a).runOnUiThread(new Runnable(this, message, ((Uri) (obj))) {

                    final Bitmap a;
                    final Uri b;
                    final _cls10 c;

                    public void run()
                    {
                        if (PipFreeStyleFragment.i(c.a) != null)
                        {
                            PipFreeStyleFragment.i(c.a).b();
                            Log.v("PipFreeStyleFragment", "PipFreeStyleFragmentwrite ResultImage end");
                            if (a != null && !a.isRecycled())
                            {
                                a.recycle();
                            }
                            if (b != null)
                            {
                                Intent intent = new Intent(PipFreeStyleFragment.i(c.a), com/pipcamera/activity/NewPhotoShareActivity);
                                intent.putExtra("PhotoShareActivity_ToShareImageUri", b.toString());
                                c.a.startActivity(intent);
                                PipFreeStyleFragment.i(c.a).overridePendingTransition(0x7f040007, 0);
                                return;
                            }
                        }
                    }

            
            {
                c = _pcls10;
                a = bitmap;
                b = uri;
                super();
            }
                });
                return;
            }

            
            {
                a = PipFreeStyleFragment.this;
                super();
            }
        });
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
        m.a();
        so so1 = new so();
        ArrayList arraylist = new ArrayList();
        arraylist.add(intent);
        so1.a(arraylist);
        so1.a(this);
        so1.b(n);
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
        g = Boolean.valueOf(false);
        if (!menuitem.getTitle().toString().equalsIgnoreCase(s1)) goto _L2; else goto _L1
_L1:
        Log.v("menuitemselected", "item1");
        a();
_L6:
        flag = true;
_L4:
        return flag;
_L2:
        if (!menuitem.getTitle().toString().equalsIgnoreCase(s2)) goto _L4; else goto _L3
_L3:
        g = Boolean.valueOf(true);
        Log.v("menuitemselected", "item2");
        a();
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Log.v("PipStyleFragment onCreate", "PipStyleFragment onCreate");
        m = (PipFreeStyleActivity)getActivity();
        if (getArguments() == null)
        {
            Log.e("PipFreeStyleFragment", "getArguments() is null");
        }
        o = Uri.parse(getArguments().getString("SelectedImageUri"));
        bundle = new so();
        ArrayList arraylist = new ArrayList();
        arraylist.add(o);
        bundle.a(arraylist);
        n = b();
        bundle.b(n);
        bundle.a(this);
        bundle.a(1000);
        bundle.c(new ArrayList[0]);
    }

    public void onCreateContextMenu(ContextMenu contextmenu, View view, android.view.ContextMenu.ContextMenuInfo contextmenuinfo)
    {
        super.onCreateContextMenu(contextmenu, view, contextmenuinfo);
        contextmenu.setHeaderTitle(getResources().getString(0x7f0601e0));
        contextmenu.add(0, view.getId(), 0, getResources().getString(0x7f0601bd));
        contextmenu.add(0, view.getId(), 0, getResources().getString(0x7f060033));
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        Log.v("PipStyleFragment onCreateView", "PipStyleFragment onCreateView");
        layoutinflater = layoutinflater.inflate(0x7f030072, viewgroup, false);
        i = getResources().getString(0x7f06022b);
        j = i;
        h = getResources().getString(0x7f0600fe);
        a(layoutinflater);
        b(layoutinflater);
        registerForContextMenu(v);
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
    }

    public void onPause()
    {
        if (a != null && a.getRender() != null)
        {
            a.onPause();
        }
        super.onPause();
    }

    public void onResume()
    {
        Log.v("onResume", "onResume");
        if (a != null && a.getRender() != null)
        {
            a.onResume();
            if (m.d() != null && f != null)
            {
                a.setFilterName(j);
                if (k.getVisibility() == 4)
                {
                    f.clear();
                    c.setVisibility(4);
                }
            }
        }
        super.onResume();
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
        if (m.d() != null && f != null)
        {
            a.setSourceBitmap(m.d());
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
    }
}
