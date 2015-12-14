// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import com.crashlytics.android.Crashlytics;
import com.fotoable.ad.FotoAdFactory;
import com.pipcamera.activity.NewPhotoShareActivity;
import com.pipcamera.activity.pip.PipRealTimeCameraActivity;
import com.pipcamera.activity.pip.PipStyleBaseActivity;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.imagelib.filter.TImageFilterInfo;
import com.wantu.imagelib.filter.TImageFilterManager;
import com.wantu.imagelib.filter.TPipFilterManger;
import com.wantu.imagerender.ImageGLSurfaceView;
import com.wantu.model.res.pip.TDFSceneInfo;
import com.wantu.service.pip.EFilterSelectedMode;
import com.wantu.view.TFilterListScrollView;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kf;
import pb;
import rd;
import sx;
import wantu.sephiroth.android.library.imagezoom.MaskScrollImageViewTouch;
import ys;

public class PipProcessFragment extends Fragment
    implements android.view.SurfaceHolder.Callback, ys
{

    ImageView a;
    private int b;
    private TFilterListScrollView c;
    private String d;
    private TImageFilterManager e;
    private ImageGLSurfaceView f;
    private ToggleButton g;
    private ToggleButton h;
    private ToggleButton i;
    private Button j;
    private Button k;
    private MaskScrollImageViewTouch l;
    private ImageView m;
    private TDFSceneInfo n;
    private EFilterSelectedMode o;
    private EFilterSelectedMode p;
    private List q;
    private String r;
    private RelativeLayout s;
    private PipStyleBaseActivity t;

    public PipProcessFragment()
    {
        b = 1024;
        q = new ArrayList();
        r = null;
    }

    public static PipStyleBaseActivity a(PipProcessFragment pipprocessfragment)
    {
        return pipprocessfragment.t;
    }

    private void a(View view)
    {
        Object obj = (TextView)view.findViewById(0x7f0c002d);
        ((TextView) (obj)).setText(t.getResources().getString(0x7f0600df));
        ((TextView) (obj)).setTextColor(-1);
        j = (Button)view.findViewById(0x7f0c0080);
        j.setText(t.getResources().getString(0x7f0601c7));
        k = (Button)view.findViewById(0x7f0c007f);
        j.setOnClickListener(new android.view.View.OnClickListener() {

            final PipProcessFragment a;

            public void onClick(View view1)
            {
                a.nextBtnClicked(view1);
            }

            
            {
                a = PipProcessFragment.this;
                super();
            }
        });
        k.setOnClickListener(new android.view.View.OnClickListener() {

            final PipProcessFragment a;

            public void onClick(View view1)
            {
                a.backBtnClicked(view1);
            }

            
            {
                a = PipProcessFragment.this;
                super();
            }
        });
        g = (ToggleButton)view.findViewById(0x7f0c021b);
        h = (ToggleButton)view.findViewById(0x7f0c021c);
        i = (ToggleButton)view.findViewById(0x7f0c021d);
        g.setOnClickListener(new android.view.View.OnClickListener() {

            final PipProcessFragment a;

            public void onClick(View view1)
            {
                a.onPipModelAllbtnClicked(view1);
            }

            
            {
                a = PipProcessFragment.this;
                super();
            }
        });
        h.setOnClickListener(new android.view.View.OnClickListener() {

            final PipProcessFragment a;

            public void onClick(View view1)
            {
                a.onPipModelForebtnClicked(view1);
            }

            
            {
                a = PipProcessFragment.this;
                super();
            }
        });
        i.setOnClickListener(new android.view.View.OnClickListener() {

            final PipProcessFragment a;

            public void onClick(View view1)
            {
                a.onPipModelBackbtnClicked(view1);
            }

            
            {
                a = PipProcessFragment.this;
                super();
            }
        });
        l = (MaskScrollImageViewTouch)view.findViewById(0x7f0c014b);
        m = (ImageView)view.findViewById(0x7f0c01ef);
        obj = getResources().getDisplayMetrics();
        float f1 = ((DisplayMetrics) (obj)).widthPixels;
        if ((getResources().getConfiguration().screenLayout & 0xf) == 1)
        {
            f1 = pb.a(getActivity(), 270F);
        }
        f1 /= n.sceneSize.x;
        FrameLayout framelayout = (FrameLayout)view.findViewById(0x7f0c01ee);
        android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)framelayout.getLayoutParams();
        layoutparams.width = ((DisplayMetrics) (obj)).widthPixels;
        layoutparams.height = ((DisplayMetrics) (obj)).widthPixels;
        framelayout.setLayoutParams(layoutparams);
        obj = n.frameRect;
        int i1 = (int)((float)((Rect) (obj)).left * f1);
        int j1 = (int)((float)((Rect) (obj)).top * f1);
        obj = new android.widget.FrameLayout.LayoutParams((int)((float)(((Rect) (obj)).right - ((Rect) (obj)).left) * f1), (int)((float)(((Rect) (obj)).bottom - ((Rect) (obj)).top) * f1));
        ((android.widget.FrameLayout.LayoutParams) (obj)).setMargins(i1, j1, 0, 0);
        obj.gravity = 51;
        l.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        l.resetDisplayMatrix();
        c = (TFilterListScrollView)view.findViewById(0x7f0c01ec);
        a = (ImageView)view.findViewById(0x7f0c0219);
        a();
    }

    private void a(Boolean boolean1, ToggleButton togglebutton)
    {
        if (boolean1.booleanValue())
        {
            togglebutton.setChecked(true);
            return;
        } else
        {
            togglebutton.setChecked(false);
            return;
        }
    }

    private TImageFilterManager b()
    {
        if (e == null)
        {
            e = new TPipFilterManger();
        }
        return e;
    }

    public static MaskScrollImageViewTouch b(PipProcessFragment pipprocessfragment)
    {
        return pipprocessfragment.l;
    }

    private void b(View view)
    {
        f = (ImageGLSurfaceView)view.findViewById(0x7f0c0147);
        f.getHolder().addCallback(this);
    }

    public static String c(PipProcessFragment pipprocessfragment)
    {
        return pipprocessfragment.d;
    }

    private void c()
    {
label0:
        {
            if (c != null && c.getItemCount() == 0)
            {
                Map map = b().getmFilterDict();
                TImageFilterInfo timagefilterinfo;
                for (Iterator iterator = b().getmKeyOderArray().iterator(); iterator.hasNext(); c.addFilterItem(timagefilterinfo.iconUrl, timagefilterinfo.filterName))
                {
                    timagefilterinfo = (TImageFilterInfo)map.get((String)iterator.next());
                }

                c.setCallback(this);
                if (d == null)
                {
                    break label0;
                }
                c.setItemSelectedWithNoActionByFilterName(d);
            }
            return;
        }
        c.setItemSelected(0, Boolean.valueOf(true));
    }

    public static String d(PipProcessFragment pipprocessfragment)
    {
        return pipprocessfragment.r;
    }

    public static ImageGLSurfaceView e(PipProcessFragment pipprocessfragment)
    {
        return pipprocessfragment.f;
    }

    public static ImageView f(PipProcessFragment pipprocessfragment)
    {
        return pipprocessfragment.m;
    }

    public static void g(PipProcessFragment pipprocessfragment)
    {
        pipprocessfragment.c();
    }

    public Bitmap a(Bitmap bitmap)
    {
        Bitmap bitmap1;
        int i1 = kf.c().f();
        float f1 = (float)i1 / (float)n.sceneSize.x;
        Canvas canvas;
        Paint paint;
        android.widget.FrameLayout.LayoutParams layoutparams;
        try
        {
            bitmap1 = Bitmap.createBitmap(i1, i1, android.graphics.Bitmap.Config.ARGB_8888);
            canvas = new Canvas(bitmap1);
            paint = new Paint();
            paint.setFilterBitmap(true);
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            bitmap.printStackTrace();
            Crashlytics.logException(bitmap);
            return null;
        }
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_109;
        }
        if (!bitmap.isRecycled())
        {
            canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new Rect(0, 0, i1, i1), paint);
        }
        bitmap = l.getDispalyImage((int)((float)n.frameRect.width() * f1), (int)((float)n.frameRect.height() * f1));
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_194;
        }
        if (!bitmap.isRecycled())
        {
            canvas.drawBitmap(bitmap, (float)n.frameRect.left * f1, (float)n.frameRect.top * f1, paint);
            bitmap.recycle();
        }
        bitmap = t.l();
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_251;
        }
        if (!bitmap.isRecycled())
        {
            canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new Rect(0, 0, i1, i1), paint);
        }
        bitmap = (BitmapDrawable)PIPCameraApplication.a.getResources().getDrawable(0x7f020194);
        bitmap = ((BitmapDrawable)(BitmapDrawable)a.getBackground()).getBitmap();
        layoutparams = (android.widget.FrameLayout.LayoutParams)a.getLayoutParams();
        if (a(n.resId))
        {
            a.setVisibility(4);
            break MISSING_BLOCK_LABEL_425;
        }
        canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new Rect(i1 - (int)((float)layoutparams.width + 20F * f1), i1 - (int)((float)layoutparams.height + 12F * f1), i1 - (int)(20F * f1), i1 - (int)(f1 * 12F)), paint);
        a.setVisibility(0);
        return bitmap1;
    }

    public String a(EFilterSelectedMode efilterselectedmode)
    {
        return (String)q.get(efilterselectedmode.ordinal());
    }

    public void a()
    {
        if (a(n.resId))
        {
            a.setVisibility(4);
            return;
        } else
        {
            a.setVisibility(0);
            return;
        }
    }

    public void a(ToggleButton togglebutton)
    {
        String s1 = a(o);
        p = o;
        if (togglebutton == h)
        {
            o = EFilterSelectedMode.FORGROUND;
        } else
        if (togglebutton == i)
        {
            o = EFilterSelectedMode.BACKGROUND;
        } else
        {
            o = EFilterSelectedMode.BOTH;
        }
        togglebutton = a(o);
        if (o == EFilterSelectedMode.BOTH)
        {
            b(s1);
            c(s1);
        } else
        if (o == EFilterSelectedMode.FORGROUND || o == EFilterSelectedMode.BACKGROUND)
        {
            a(((String) (togglebutton)));
            c(togglebutton);
            return;
        }
    }

    public void a(String s1)
    {
        if (c.getVisibility() == 4)
        {
            c.cancelSelected();
        }
        if (o == EFilterSelectedMode.BOTH) goto _L2; else goto _L1
_L1:
        a(s1, o);
        if (o != EFilterSelectedMode.FORGROUND) goto _L4; else goto _L3
_L3:
        if (s1.equalsIgnoreCase(r))
        {
            l.setImageBitmap(t.e(), false);
        } else
        {
            if (t.e() == null)
            {
                Log.v("OpenGl_error", "source image is null");
                return;
            }
            Log.v("filer name", s1);
            t.a();
            f.fastProcessImage(t.e(), s1, new Handler() {

                final PipProcessFragment a;

                public void handleMessage(Message message)
                {
                    PipProcessFragment.a(a).b();
                    if (message != null)
                    {
                        message = (Bitmap)message.obj;
                        PipProcessFragment.b(a).setImageBitmap(message, false);
                    }
                }

            
            {
                a = PipProcessFragment.this;
                super();
            }
            });
        }
_L6:
        d = s1;
        return;
_L4:
        if (o == EFilterSelectedMode.BACKGROUND)
        {
            if (s1.equalsIgnoreCase(r))
            {
                f.setFilterName(r);
            } else
            {
                f.setFilterName(s1);
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        b(s1);
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void a(String s1, EFilterSelectedMode efilterselectedmode)
    {
        q.set(efilterselectedmode.ordinal(), s1);
    }

    public boolean a(int i1)
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
                    if (n.resId != ai[i1])
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

    public void b(String s1)
    {
        a(s1, EFilterSelectedMode.BOTH);
        if (s1.equalsIgnoreCase(r))
        {
            f.setFilterName(r);
            l.setImageBitmap(t.e(), false);
            return;
        } else
        {
            t.a();
            f.setFilterName(s1);
            f.processImage(t.e(), s1, new Handler() {

                final PipProcessFragment a;

                public void handleMessage(Message message)
                {
                    PipProcessFragment.a(a).b();
                    if (message != null)
                    {
                        message = (Bitmap)message.obj;
                        PipProcessFragment.b(a).setImageBitmap(message, false);
                    }
                }

            
            {
                a = PipProcessFragment.this;
                super();
            }
            });
            return;
        }
    }

    public void backBtnClicked(View view)
    {
        if (t != null)
        {
            l.setImageBitmap(null);
            l.setMask(null);
            m.setImageBitmap(null);
            f.setVisibility(8);
            System.gc();
            t.c();
        }
    }

    public void c(String s1)
    {
        c.setItemSelectedWithNoActionByFilterName(s1);
    }

    public void nextBtnClicked(View view)
    {
        t.a();
        view = r;
        if (o == EFilterSelectedMode.BOTH)
        {
            view = d;
        } else
        if (p == EFilterSelectedMode.BOTH)
        {
            view = a(p);
        } else
        {
            view = a(EFilterSelectedMode.BACKGROUND);
        }
        if (n != null)
        {
            kf.a(n.resId);
        }
        f.processImage(t.f(), view, new Handler() {

            final PipProcessFragment a;

            public void handleMessage(Message message)
            {
                if (message == null)
                {
                    break MISSING_BLOCK_LABEL_254;
                }
                Bitmap bitmap = (Bitmap)message.obj;
                message = a.a(bitmap);
                bitmap.recycle();
                Object obj;
                if (message == null)
                {
                    try
                    {
                        Log.e("PipProcessFragment", "Can't make result image");
                        Toast.makeText(PipProcessFragment.a(a), 0x7f060152, 1).show();
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Message message)
                    {
                        message.printStackTrace();
                    }
                    break MISSING_BLOCK_LABEL_97;
                }
                if (PipProcessFragment.a(a) == null)
                {
                    break MISSING_BLOCK_LABEL_254;
                }
                obj = rd.a(message);
                if (obj != null)
                {
                    break MISSING_BLOCK_LABEL_112;
                }
                PipProcessFragment.a(a).runOnUiThread(new Runnable(this) {

                    final _cls8 a;

                    public void run()
                    {
                        Toast.makeText(PipProcessFragment.a(a.a), PipProcessFragment.a(a.a).getResources().getString(0x7f060196), 0).show();
                    }

            
            {
                a = _pcls8;
                super();
            }
                });
                return;
                Crashlytics.logException(message);
                PipProcessFragment.a(a).b();
                return;
                rd.a(((File) (obj)).getAbsolutePath(), PipProcessFragment.a(a));
                obj = Uri.fromFile(((File) (obj)));
                if (message == null)
                {
                    break MISSING_BLOCK_LABEL_146;
                }
                if (!message.isRecycled())
                {
                    message.recycle();
                }
                if (obj == null)
                {
                    break MISSING_BLOCK_LABEL_254;
                }
                Intent intent;
                message = PipProcessFragment.a(a).i();
                intent = new Intent(PipProcessFragment.a(a), com/pipcamera/activity/NewPhotoShareActivity);
                intent.putExtra("PhotoShareActivity_ToShareImageUri", ((Uri) (obj)).toString());
                if (message == null)
                {
                    break MISSING_BLOCK_LABEL_233;
                }
                if (message.getShareTag() != null)
                {
                    long l1 = message.getExpireTime();
                    if ((new Date()).getTime() <= l1)
                    {
                        intent.putExtra("share_tag", message.getShareTag());
                    }
                }
                a.startActivity(intent);
                PipProcessFragment.a(a).overridePendingTransition(0x7f040007, 0);
            }

            
            {
                a = PipProcessFragment.this;
                super();
            }
        });
        a();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getActivity();
        t = (PipStyleBaseActivity)getActivity();
        r = t.getResources().getString(0x7f060181);
        q.add(r);
        q.add(r);
        q.add(r);
        d = r;
        o = EFilterSelectedMode.BOTH;
        p = EFilterSelectedMode.BOTH;
        n = t.i();
    }

    public void onCreateContextMenu(ContextMenu contextmenu, View view, android.view.ContextMenu.ContextMenuInfo contextmenuinfo)
    {
        super.onCreateContextMenu(contextmenu, view, contextmenuinfo);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030074, viewgroup, false);
        s = (RelativeLayout)layoutinflater.findViewById(0x7f0c021e);
        s.setTag("bannerRelative");
        a(layoutinflater);
        b(layoutinflater);
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        l.setImageBitmap(null);
        m.setImageBitmap(null);
        if (t instanceof PipRealTimeCameraActivity)
        {
            t.q();
            t.r();
        }
        System.gc();
    }

    public void onPause()
    {
        if (f != null && f.getRender() != null)
        {
            f.onPause();
        }
        super.onPause();
    }

    public void onPipModelAllbtnClicked(View view)
    {
        view = (ToggleButton)view;
        if (!view.isChecked())
        {
            view.setChecked(true);
            return;
        } else
        {
            a(Boolean.valueOf(false), i);
            a(Boolean.valueOf(false), h);
            a(Boolean.valueOf(true), g);
            a(view);
            return;
        }
    }

    public void onPipModelBackbtnClicked(View view)
    {
        view = (ToggleButton)view;
        if (!view.isChecked())
        {
            view.setChecked(true);
            return;
        } else
        {
            a(Boolean.valueOf(false), h);
            a(Boolean.valueOf(false), g);
            a(Boolean.valueOf(true), i);
            a(view);
            return;
        }
    }

    public void onPipModelForebtnClicked(View view)
    {
        view = (ToggleButton)view;
        if (!view.isChecked())
        {
            view.setChecked(true);
            return;
        } else
        {
            a(Boolean.valueOf(false), g);
            a(Boolean.valueOf(false), i);
            a(Boolean.valueOf(true), h);
            a(view);
            return;
        }
    }

    public void onResume()
    {
        if (f != null && f.getRender() != null)
        {
            f.onResume();
        }
        FotoAdFactory.createAdBanner(getActivity(), s);
        if (t.f() != null)
        {
            String s1 = r;
            if (o == EFilterSelectedMode.BOTH)
            {
                s1 = d;
            } else
            if (p == EFilterSelectedMode.BOTH)
            {
                s1 = a(p);
            } else
            {
                s1 = a(EFilterSelectedMode.BACKGROUND);
            }
            f.setFilterName(s1);
        }
        super.onResume();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("selectedfilterName", d);
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i1, int j1, int k1)
    {
        Log.v("surfaceChanged", (new StringBuilder()).append("surfaceChanged").append(j1).append(":").append(k1).toString());
        if (t.f() != null)
        {
            (new sx(this)).execute(new TDFSceneInfo[] {
                n
            });
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
        Log.v("surfaceCreated", "surfaceCreated");
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
    }
}
