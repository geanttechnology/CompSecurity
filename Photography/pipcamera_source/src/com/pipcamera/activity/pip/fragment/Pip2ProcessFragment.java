// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.crashlytics.android.Crashlytics;
import com.fotoable.ad.FotoAdFactory;
import com.pipcamera.activity.NewPhotoShareActivity;
import com.pipcamera.activity.pip.Pip2FragmentActivity;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.imagelib.filter.TImageFilterInfo;
import com.wantu.imagelib.filter.TImageFilterManager;
import com.wantu.imagelib.filter.TPipFilterManger;
import com.wantu.imagerender.ImageGLSurfaceView;
import com.wantu.model.res.pip.TDFSceneInfo;
import com.wantu.service.pip.AsynPIPCropImageTask;
import com.wantu.view.TFilterListScrollView;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kf;
import rd;
import sv;
import wantu.sephiroth.android.library.imagezoom.MaskScrollImageViewTouch;
import ye;
import ys;

public class Pip2ProcessFragment extends Fragment
    implements android.view.SurfaceHolder.Callback, ye, ys
{

    private TFilterListScrollView a;
    private TImageFilterManager b;
    private ImageGLSurfaceView c;
    private MaskScrollImageViewTouch d;
    private ImageView e;
    private TDFSceneInfo f;
    private Boolean g;
    private Button h;
    private Button i;
    private String j;
    private Pip2FragmentActivity k;
    private View l;
    private RelativeLayout m;

    public Pip2ProcessFragment()
    {
        g = Boolean.valueOf(false);
        j = null;
    }

    public static Pip2FragmentActivity a(Pip2ProcessFragment pip2processfragment)
    {
        return pip2processfragment.k;
    }

    private void a(Bitmap bitmap)
    {
        if (bitmap != null)
        {
            float f1 = (float)bitmap.getWidth() / 612F;
            Object obj = f.frameRect;
            int j1 = (int)((float)(((Rect) (obj)).right - ((Rect) (obj)).left) * f1);
            int i1;
            int k1;
            int l1;
            if (j1 % 2 != 0)
            {
                j1--;
            }
            i1 = (int)((float)(((Rect) (obj)).bottom - ((Rect) (obj)).top) * f1);
            if (i1 % 2 != 0)
            {
                i1--;
            }
            k1 = (int)((float)((Rect) (obj)).left * f1);
            l1 = (int)(f1 * (float)((Rect) (obj)).top);
            if (k1 + j1 > 612)
            {
                j1 = 612 - k1;
            }
            if (l1 + i1 > 612)
            {
                i1 = 612 - l1;
            }
            obj = new AsynPIPCropImageTask(bitmap);
            ((AsynPIPCropImageTask) (obj)).a(1000, com.wantu.service.pip.AsynPIPCropImageTask.AsynPIPCropType.NORMALCROP, k1, l1, j1, i1);
            ((AsynPIPCropImageTask) (obj)).a(new ye(bitmap) {

                final Bitmap a;
                final Pip2ProcessFragment b;

                public void a(Bitmap bitmap1, int i2)
                {
                    Pip2ProcessFragment.a(b).b();
                    if (a != null && !a.isRecycled())
                    {
                        a.recycle();
                    }
                    Pip2ProcessFragment.b(b).setImageBitmap(bitmap1);
                }

                public void a(Exception exception)
                {
                    Pip2ProcessFragment.a(b).b();
                }

                public void a_(int i2)
                {
                }

            
            {
                b = Pip2ProcessFragment.this;
                a = bitmap;
                super();
            }
            });
            ((AsynPIPCropImageTask) (obj)).execute(new Context[] {
                k
            });
        }
    }

    private void a(View view)
    {
        h = (Button)view.findViewById(0x7f0c0080);
        h.setText(k.getResources().getString(0x7f0601c7));
        i = (Button)view.findViewById(0x7f0c007f);
        h.setOnClickListener(new android.view.View.OnClickListener() {

            final Pip2ProcessFragment a;

            public void onClick(View view1)
            {
                a.nextBtnClicked(view1);
            }

            
            {
                a = Pip2ProcessFragment.this;
                super();
            }
        });
        i.setOnClickListener(new android.view.View.OnClickListener() {

            final Pip2ProcessFragment a;

            public void onClick(View view1)
            {
                a.backBtnClicked(view1);
            }

            
            {
                a = Pip2ProcessFragment.this;
                super();
            }
        });
        d = (MaskScrollImageViewTouch)view.findViewById(0x7f0c014b);
        e = (ImageView)view.findViewById(0x7f0c01ef);
        Object obj = getResources().getDisplayMetrics();
        float f1 = (float)((DisplayMetrics) (obj)).widthPixels / 612F;
        FrameLayout framelayout = (FrameLayout)view.findViewById(0x7f0c01ee);
        android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)framelayout.getLayoutParams();
        layoutparams.width = ((DisplayMetrics) (obj)).widthPixels;
        layoutparams.height = ((DisplayMetrics) (obj)).widthPixels;
        framelayout.setLayoutParams(layoutparams);
        obj = f.frameRect;
        int i1 = (int)((float)((Rect) (obj)).left * f1);
        int j1 = (int)((float)((Rect) (obj)).top * f1);
        obj = new android.widget.FrameLayout.LayoutParams((int)((float)(((Rect) (obj)).right - ((Rect) (obj)).left) * f1), (int)((float)(((Rect) (obj)).bottom - ((Rect) (obj)).top) * f1));
        ((android.widget.FrameLayout.LayoutParams) (obj)).setMargins(i1, j1, 0, 0);
        obj.gravity = 51;
        d.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        d.setScrollEnabled(false);
        d.setScaleEnabled(false);
        d.setDoubleTapToZoomEnabled(false);
        d.resetDisplayMatrix();
        a = (TFilterListScrollView)view.findViewById(0x7f0c01ec);
    }

    static void a(Pip2ProcessFragment pip2processfragment, Bitmap bitmap)
    {
        pip2processfragment.a(bitmap);
    }

    private TImageFilterManager b()
    {
        if (b == null)
        {
            b = new TPipFilterManger();
        }
        return b;
    }

    public static MaskScrollImageViewTouch b(Pip2ProcessFragment pip2processfragment)
    {
        return pip2processfragment.d;
    }

    private void b(Bitmap bitmap)
    {
        if (bitmap != null)
        {
            float f1 = (float)bitmap.getWidth() / 612F;
            Rect rect = f.frameRect;
            int j1 = (int)((float)(rect.right - rect.left) * f1);
            int i1;
            int k1;
            int l1;
            if (j1 % 2 != 0)
            {
                j1--;
            }
            i1 = (int)((float)(rect.bottom - rect.top) * f1);
            if (i1 % 2 != 0)
            {
                i1--;
            }
            k1 = (int)((float)rect.left * f1);
            l1 = (int)(f1 * (float)rect.top);
            if (k1 + j1 > 612)
            {
                j1 = 612 - k1;
            }
            if (l1 + i1 > 612)
            {
                i1 = 612 - l1;
            }
            Log.v("Pip2ProcessFragment", (new StringBuilder()).append("Pip2ProcessFragment left:").append(rect.left).toString());
            Log.v("Pip2ProcessFragment", (new StringBuilder()).append("Pip2ProcessFragment right:").append(rect.right).toString());
            Log.v("Pip2ProcessFragment", (new StringBuilder()).append("Pip2ProcessFragment bottom:").append(rect.bottom).toString());
            Log.v("Pip2ProcessFragment", (new StringBuilder()).append("Pip2ProcessFragment top:").append(rect.top).toString());
            Log.v("Pip2ProcessFragment", (new StringBuilder()).append("Pip2ProcessFragment width:").append(j1).toString());
            Log.v("Pip2ProcessFragment", (new StringBuilder()).append("Pip2ProcessFragment height:").append(i1).toString());
            Log.v("Pip2ProcessFragment", (new StringBuilder()).append("Pip2ProcessFragment pointx:").append(k1).toString());
            Log.v("Pip2ProcessFragment", (new StringBuilder()).append("Pip2ProcessFragment pointy:").append(l1).toString());
            bitmap = new AsynPIPCropImageTask(bitmap);
            bitmap.a(this);
            bitmap.a(1000, com.wantu.service.pip.AsynPIPCropImageTask.AsynPIPCropType.NORMALCROP, k1, l1, j1, i1);
            bitmap.execute(new Context[] {
                k
            });
        }
    }

    private void b(View view)
    {
        c = (ImageGLSurfaceView)view.findViewById(0x7f0c0147);
        c.getHolder().addCallback(this);
    }

    public static void b(Pip2ProcessFragment pip2processfragment, Bitmap bitmap)
    {
        pip2processfragment.b(bitmap);
    }

    public static ImageGLSurfaceView c(Pip2ProcessFragment pip2processfragment)
    {
        return pip2processfragment.c;
    }

    private void c()
    {
        if (a != null && a.getItemCount() == 0)
        {
            Map map = b().getmFilterDict();
            List list = b().filterNamesByCatalogeName("default-filter");
            TImageFilterInfo timagefilterinfo;
            for (Iterator iterator = list.iterator(); iterator.hasNext(); a.addFilterItem(timagefilterinfo.iconUrl, timagefilterinfo.filterName))
            {
                timagefilterinfo = (TImageFilterInfo)map.get((String)iterator.next());
            }

            j = (String)list.get(0);
            a.setCallback(this);
            a.setItemSelected(0, Boolean.valueOf(true));
        }
    }

    public static ImageView d(Pip2ProcessFragment pip2processfragment)
    {
        return pip2processfragment.e;
    }

    public static void e(Pip2ProcessFragment pip2processfragment)
    {
        pip2processfragment.c();
    }

    public static Boolean f(Pip2ProcessFragment pip2processfragment)
    {
        return pip2processfragment.g;
    }

    public Bitmap a()
    {
        int i1 = kf.c().f();
        float f1 = (float)i1 / (float)f.sceneSize.x;
        Bitmap bitmap;
        Canvas canvas;
        Paint paint;
        Bitmap bitmap1;
        try
        {
            bitmap = Bitmap.createBitmap(i1, i1, android.graphics.Bitmap.Config.ARGB_8888);
            canvas = new Canvas(bitmap);
            paint = new Paint();
            paint.setFilterBitmap(true);
            bitmap1 = k.g();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            Crashlytics.logException(exception);
            return null;
        }
        if (bitmap1 == null)
        {
            break MISSING_BLOCK_LABEL_121;
        }
        if (!bitmap1.isRecycled())
        {
            canvas.drawBitmap(bitmap1, new Rect(0, 0, bitmap1.getWidth(), bitmap1.getHeight()), new Rect(0, 0, i1, i1), paint);
        }
        bitmap1 = d.getDispalyImage((int)((float)f.frameRect.width() * f1), (int)((float)f.frameRect.height() * f1));
        if (bitmap1 == null)
        {
            break MISSING_BLOCK_LABEL_210;
        }
        if (!bitmap1.isRecycled())
        {
            canvas.drawBitmap(bitmap1, (float)f.frameRect.left * f1, f1 * (float)f.frameRect.top, paint);
            bitmap1.recycle();
        }
        bitmap1 = k.i();
        if (bitmap1 == null)
        {
            break MISSING_BLOCK_LABEL_272;
        }
        if (!bitmap1.isRecycled())
        {
            canvas.drawBitmap(bitmap1, new Rect(0, 0, bitmap1.getWidth(), bitmap1.getHeight()), new Rect(0, 0, i1, i1), paint);
        }
        return bitmap;
    }

    public void a(Bitmap bitmap, int i1)
    {
        Log.v("Pip2ProcessFragment", "Pip2ProcessFragmentonCropComplete");
        g = Boolean.valueOf(true);
        if (bitmap != null)
        {
            k.a(bitmap);
            d.setImageBitmap(bitmap);
            if (k != null)
            {
                k.b();
            }
        } else
        if (k != null)
        {
            k.b();
            return;
        }
    }

    public void a(Exception exception)
    {
        Log.v("Pip2ProcessFragment", "Pip2ProcessFragment onCropFailed");
        if (k != null)
        {
            k.b();
        }
    }

    public void a(String s)
    {
label0:
        {
            if (k.f() != null)
            {
                k.a();
                if (!PIPCameraApplication.a(PIPCameraApplication.a))
                {
                    break label0;
                }
                c.fastProcessImage(k.g(), s, new Handler() {

                    final Pip2ProcessFragment a;

                    public void handleMessage(Message message)
                    {
                        if (message != null)
                        {
                            message = (Bitmap)message.obj;
                            Pip2ProcessFragment.a(a, message);
                            return;
                        } else
                        {
                            Pip2ProcessFragment.a(a).b();
                            return;
                        }
                    }

            
            {
                a = Pip2ProcessFragment.this;
                super();
            }
                });
            }
            return;
        }
        c.fastProcessImage(k.f(), s, new Handler() {

            final Pip2ProcessFragment a;

            public void handleMessage(Message message)
            {
                Pip2ProcessFragment.a(a).b();
                if (message != null)
                {
                    message = (Bitmap)message.obj;
                    Pip2ProcessFragment.b(a).setImageBitmap(message);
                }
            }

            
            {
                a = Pip2ProcessFragment.this;
                super();
            }
        });
    }

    public void a_(int i1)
    {
        Log.v("Pip2ProcessFragment", "Pip2ProcessFragment onCropStart");
        if (k != null && k.c() != null && !k.c().isShowing())
        {
            k.a();
        }
    }

    public void backBtnClicked(View view)
    {
        if (k != null)
        {
            k.d();
        }
    }

    public void nextBtnClicked(View view)
    {
        k.a();
        view = a();
        if (view == null)
        {
            k.b();
            Log.e("Pip2ProcessFragment", "Can't make result image");
            Toast.makeText(k, 0x7f060152, 1).show();
            return;
        }
        if (f != null)
        {
            kf.a(f.name);
        }
        (new Thread(new Runnable(view) {

            final Bitmap a;
            final Pip2ProcessFragment b;

            public void run()
            {
                if (Pip2ProcessFragment.a(b) == null)
                {
                    return;
                }
                Object obj = rd.a(a);
                if (obj == null)
                {
                    Pip2ProcessFragment.a(b).b();
                    Pip2ProcessFragment.a(b).runOnUiThread(new Runnable(this) {

                        final _cls6 a;

                        public void run()
                        {
                            Toast.makeText(Pip2ProcessFragment.a(a.b), Pip2ProcessFragment.a(a.b).getResources().getString(0x7f060196), 0).show();
                        }

            
            {
                a = _pcls6;
                super();
            }
                    });
                    return;
                } else
                {
                    rd.a(((File) (obj)).getAbsolutePath(), Pip2ProcessFragment.a(b));
                    obj = Uri.fromFile(((File) (obj)));
                    Pip2ProcessFragment.a(b).runOnUiThread(new Runnable(this, ((Uri) (obj))) {

                        final Uri a;
                        final _cls6 b;

                        public void run()
                        {
                            if (Pip2ProcessFragment.a(b.b) != null)
                            {
                                Pip2ProcessFragment.a(b.b).b();
                                Log.v("Pip2ProcessFragment", "Pip2ProcessFragmentwrite ResultImage end");
                                if (b.a != null && !b.a.isRecycled())
                                {
                                    b.a.recycle();
                                }
                                if (a != null)
                                {
                                    Intent intent = new Intent(b.b.getActivity(), com/pipcamera/activity/NewPhotoShareActivity);
                                    intent.putExtra("PhotoShareActivity_ToShareImageUri", a.toString());
                                    b.b.startActivity(intent);
                                    Pip2ProcessFragment.a(b.b).overridePendingTransition(0x7f040007, 0);
                                    return;
                                }
                            }
                        }

            
            {
                b = _pcls6;
                a = uri;
                super();
            }
                    });
                    return;
                }
            }

            
            {
                b = Pip2ProcessFragment.this;
                a = bitmap;
                super();
            }
        })).start();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        k = (Pip2FragmentActivity)getActivity();
        if (getArguments() == null)
        {
            Log.e("Pip2ProcessFragment", "getArguments() is null");
        }
        f = k.k();
        Log.e("Pip2ProcessFragment onCreate", "Pip2ProcessFragment onCreate");
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        l = layoutinflater.inflate(0x7f03006d, viewgroup, false);
        m = (RelativeLayout)l.findViewById(0x7f0c01f0);
        m.setTag("bannerRelative");
        a(l);
        b(l);
        return l;
    }

    public void onDestroy()
    {
        super.onDestroy();
        d.setImageBitmap(null);
        e.setImageBitmap(null);
    }

    public void onPause()
    {
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        if (a != null)
        {
            a.setItemSelected(0, Boolean.valueOf(true));
        }
        FotoAdFactory.createAdBanner(getActivity(), m);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i1, int j1, int k1)
    {
        Log.v("surfaceChanged", "surfaceChanged");
        (new sv(this)).execute(new TDFSceneInfo[] {
            f
        });
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
        Log.v("surfaceCreated", "surfaceCreated");
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
    }
}
