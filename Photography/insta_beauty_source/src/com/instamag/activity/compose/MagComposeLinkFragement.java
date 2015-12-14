// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.compose;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import axw;
import bar;
import bas;
import bat;
import bau;
import bav;
import baw;
import bax;
import bay;
import baz;
import bba;
import bbb;
import bbc;
import bbd;
import bbe;
import bbf;
import bbg;
import bim;
import bin;
import bio;
import bip;
import bit;
import bjd;
import bje;
import bnr;
import boy;
import bqn;
import com.crashlytics.android.Crashlytics;
import com.fotoable.ad.FotoAdFactory;
import com.instabeauty.application.InstaBeautyApplication;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMagComposeManager;
import com.wantu.activity.link.model.TMetaInfo;
import com.wantu.activity.link.model.TPhotoLinkComposeInfo;
import com.wantu.activity.link.view.BlackBackGroundView;
import com.wantu.activity.link.view.LinkBaseView;
import com.wantu.activity.link.view.LinkImageView;
import com.wantu.imagelib.filter.TImageFilterInfo;
import com.wantu.imagelib.filter.TImageFilterManager;
import com.wantu.imagerender.ImageGLSurfaceView;
import com.wantu.view.ImagesMovingView;
import com.wantu.view.TMagFilterListScrollView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.instamag.activity.compose:
//            MagComposeActivity

public class MagComposeLinkFragement extends Fragment
    implements android.view.SurfaceHolder.Callback, bit, bje, bqn
{

    private boolean A;
    private LinkImageView B;
    private BlackBackGroundView C;
    private BlackBackGroundView D;
    private int E;
    private TPhotoLinkComposeInfo F;
    private ArrayList G;
    private ArrayList H;
    public MagComposeActivity a;
    ImagesMovingView b;
    Button c;
    public TextView d;
    Bitmap e;
    private String f;
    private int g;
    private Button h;
    private Button i;
    private ImageGLSurfaceView j;
    private ImageView k;
    private FrameLayout l;
    private ScrollView m;
    private FrameLayout n;
    private FrameLayout o;
    private List p;
    private EditText q;
    private RelativeLayout r;
    private boolean s;
    private boolean t;
    private TImageFilterManager u;
    private boolean v;
    private TMagFilterListScrollView w;
    private FrameLayout x;
    private View y;
    private View z;

    public MagComposeLinkFragement()
    {
        f = "LinkComposeFragement";
        g = 612;
        p = new ArrayList();
        s = false;
        t = false;
        v = false;
        A = false;
        B = null;
        e = null;
        E = 0;
        F = null;
        G = new ArrayList();
        H = new ArrayList();
    }

    private Bitmap a(int i1, int j1)
    {
        float f1;
        f1 = getResources().getDisplayMetrics().widthPixels;
        f1 = (float)i1 / f1;
        Bitmap bitmap = Bitmap.createBitmap(i1, j1, android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.scale(f1, f1);
        k.draw(canvas);
        a(canvas);
        return bitmap;
        Object obj;
        obj;
        bitmap = null;
_L4:
        Crashlytics.logException(((Throwable) (obj)));
        return bitmap;
        obj;
        bitmap = null;
_L2:
        Crashlytics.logException(((Throwable) (obj)));
        return bitmap;
        obj;
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private TMetaInfo a(Uri uri)
    {
        if (a == null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        uri = new TMetaInfo(a, uri);
        return uri;
        uri;
        Crashlytics.logException(uri);
        uri.printStackTrace();
        return null;
    }

    private LinkBaseView a(bio bio1)
    {
        if (bio1 == null)
        {
            return null;
        } else
        {
            Log.v(f, (new StringBuilder()).append(f).append(" getLinkView  xib:").append(bio1.a).toString());
            return bip.a(bio1.a, a);
        }
    }

    private LinkBaseView a(LinkImageView linkimageview)
    {
        for (Iterator iterator = p.iterator(); iterator.hasNext();)
        {
            LinkBaseView linkbaseview = (LinkBaseView)iterator.next();
            if (linkbaseview.subImage1() != null && linkbaseview.subImage1() == linkimageview)
            {
                return linkbaseview;
            }
            if (linkbaseview.subImage2() != null && linkbaseview.subImage2() == linkimageview)
            {
                return linkbaseview;
            }
        }

        return null;
    }

    private void a(Canvas canvas)
    {
        for (Iterator iterator = p.iterator(); iterator.hasNext(); canvas.restore())
        {
            LinkBaseView linkbaseview = (LinkBaseView)iterator.next();
            canvas.save();
            android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)linkbaseview.getLayoutParams();
            canvas.translate(layoutparams.leftMargin, layoutparams.topMargin);
            linkbaseview.draw(canvas);
        }

    }

    private void a(View view, int i1)
    {
        if (A)
        {
            g(view);
            return;
        } else
        {
            f(view);
            return;
        }
    }

    public static void a(MagComposeLinkFragement magcomposelinkfragement)
    {
        magcomposelinkfragement.j();
    }

    public static void a(MagComposeLinkFragement magcomposelinkfragement, View view)
    {
        magcomposelinkfragement.d(view);
    }

    public static void a(MagComposeLinkFragement magcomposelinkfragement, View view, int i1)
    {
        magcomposelinkfragement.a(view, i1);
    }

    private void a(LinkImageView linkimageview, LinkImageView linkimageview1)
    {
        int i1 = b(((Integer)linkimageview.getTag()).intValue());
        int j1 = b(((Integer)linkimageview1.getTag()).intValue());
        bin bin1 = (bin)H.get(i1);
        bin bin2 = (bin)H.get(j1);
        H.set(i1, bin2);
        H.set(j1, bin1);
        linkimageview.setImageBitmap(bin2.a);
        linkimageview1.setImageBitmap(bin1.a);
        a(false);
    }

    private int b(int i1)
    {
        if (i1 >= 1000)
        {
            return i1 - 1000;
        } else
        {
            return 0;
        }
    }

    private Bitmap b(int i1, int j1)
    {
        float f1;
        f1 = getResources().getDisplayMetrics().widthPixels;
        f1 = (float)i1 / f1;
        Bitmap bitmap = Bitmap.createBitmap(i1, j1, android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.scale(f1, f1);
        k.draw(canvas);
        b(canvas);
        return bitmap;
        Object obj;
        obj;
        bitmap = null;
_L4:
        Crashlytics.logException(((Throwable) (obj)));
        return bitmap;
        obj;
        bitmap = null;
_L2:
        Crashlytics.logException(((Throwable) (obj)));
        return bitmap;
        obj;
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static FrameLayout b(MagComposeLinkFragement magcomposelinkfragement)
    {
        return magcomposelinkfragement.x;
    }

    private void b(Canvas canvas)
    {
        for (Iterator iterator = p.iterator(); iterator.hasNext(); canvas.restore())
        {
            LinkBaseView linkbaseview = (LinkBaseView)iterator.next();
            canvas.save();
            android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)linkbaseview.getLayoutParams();
            canvas.translate(layoutparams.leftMargin, layoutparams.topMargin);
            linkbaseview.draw(canvas);
        }

    }

    public static void b(MagComposeLinkFragement magcomposelinkfragement, View view)
    {
        magcomposelinkfragement.e(view);
    }

    private int c(int i1)
    {
        return i1 + 1000;
    }

    public static View c(MagComposeLinkFragement magcomposelinkfragement)
    {
        return magcomposelinkfragement.y;
    }

    private void c(View view)
    {
        j = (ImageGLSurfaceView)view.findViewById(0x7f0d0256);
        j.getHolder().addCallback(this);
    }

    public static EditText d(MagComposeLinkFragement magcomposelinkfragement)
    {
        return magcomposelinkfragement.q;
    }

    private void d(View view)
    {
        g();
        if (a != null)
        {
            a.k();
        }
    }

    private void e()
    {
        if (getActivity() != null && !s)
        {
            Object obj = getActivity().getSharedPreferences("config", 0);
            int i1 = ((SharedPreferences) (obj)).getInt("link_change_positonhelp_number", 0);
            if (i1 < 2)
            {
                obj = ((SharedPreferences) (obj)).edit();
                ((android.content.SharedPreferences.Editor) (obj)).putInt("link_change_positonhelp_number", i1 + 1);
                ((android.content.SharedPreferences.Editor) (obj)).commit();
                obj = new android.app.AlertDialog.Builder(getActivity());
                ((android.app.AlertDialog.Builder) (obj)).setTitle(getResources().getString(0x7f0602ae));
                ((android.app.AlertDialog.Builder) (obj)).setMessage(getResources().getString(0x7f06015b));
                ((android.app.AlertDialog.Builder) (obj)).setPositiveButton(getResources().getString(0x7f060055), new bbe(this));
                ((android.app.AlertDialog.Builder) (obj)).show();
                s = true;
            }
        }
    }

    private void e(View view)
    {
        d();
    }

    public static boolean e(MagComposeLinkFragement magcomposelinkfragement)
    {
        return magcomposelinkfragement.A;
    }

    private int f()
    {
        char c1 = '\u0264';
        DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        float f1 = displaymetrics.density;
        int i1 = displaymetrics.densityDpi;
        float f2 = displaymetrics.xdpi;
        float f3 = displaymetrics.ydpi;
        float f4 = displaymetrics.widthPixels;
        float f5 = displaymetrics.heightPixels;
        Log.e((new StringBuilder()).append(f).append("  DisplayMetrics").toString(), (new StringBuilder()).append("xdpi=").append(f2).append("; ydpi=").append(f3).toString());
        Log.e((new StringBuilder()).append(f).append("  DisplayMetrics").toString(), (new StringBuilder()).append("density=").append(f1).append("; densityDPI=").append(i1).toString());
        Log.v((new StringBuilder()).append(f).append("  screenWidth ").toString(), String.format("%f", new Object[] {
            Float.valueOf(f4)
        }));
        Log.v((new StringBuilder()).append(f).append("  screenHeight ").toString(), String.format("%f", new Object[] {
            Float.valueOf(f5)
        }));
        if (f2 < 160F || f4 < 400F)
        {
            c1 = '\u019A';
        }
        return c1;
    }

    public static RelativeLayout f(MagComposeLinkFragement magcomposelinkfragement)
    {
        return magcomposelinkfragement.r;
    }

    private void f(View view)
    {
        if (view != null && (view instanceof LinkImageView))
        {
            view = (LinkImageView)view;
            z = view;
            Object obj = a(view);
            if (obj != null && x != null)
            {
                x.setVisibility(0);
                view = (android.widget.FrameLayout.LayoutParams)w.getLayoutParams();
                obj = (android.widget.FrameLayout.LayoutParams)((LinkBaseView) (obj)).getLayoutParams();
                int i1 = m.getScrollY();
                int j1 = ((android.widget.FrameLayout.LayoutParams) (obj)).leftMargin;
                int k1 = ((android.widget.FrameLayout.LayoutParams) (obj)).width / 2;
                int l1 = ((android.widget.FrameLayout.LayoutParams) (obj)).topMargin;
                int i2 = ((android.widget.FrameLayout.LayoutParams) (obj)).height / 2;
                view.setMargins((j1 + k1) - ((android.widget.FrameLayout.LayoutParams) (view)).width / 2, (i2 + l1) - i1 - ((android.widget.FrameLayout.LayoutParams) (view)).height / 2, 0, 0);
                w.setLayoutParams(view);
            }
        }
    }

    public static String g(MagComposeLinkFragement magcomposelinkfragement)
    {
        return magcomposelinkfragement.f;
    }

    private void g()
    {
        boolean flag = false;
        if (l.getChildCount() > 0 && p != null && p.size() > 0)
        {
            for (int i1 = 0; i1 < p.size(); i1++)
            {
                LinkBaseView linkbaseview = (LinkBaseView)p.get(i1);
                if (linkbaseview.subImage1() != null)
                {
                    linkbaseview.subImage1().setImageBitmap(null);
                }
                if (linkbaseview.subImage2() != null)
                {
                    linkbaseview.subImage2().setImageBitmap(null);
                }
                l.removeView(linkbaseview);
            }

        }
        if (H != null && H.size() > 0)
        {
            for (int j1 = ((flag) ? 1 : 0); j1 < H.size(); j1++)
            {
                bin bin1 = (bin)H.get(j1);
                if (bin1.a != null && !bin1.a.isRecycled())
                {
                    bin1.a.recycle();
                    bin1.a = null;
                }
            }

            H.clear();
        }
        if (p != null && p.size() > 0)
        {
            p.clear();
        }
        if (k != null)
        {
            Drawable drawable = k.getBackground();
            if (drawable != null)
            {
                drawable.setCallback(null);
            }
            k.setBackgroundDrawable(null);
            if (e != null && !e.isRecycled())
            {
                e.recycle();
                e = null;
            }
        }
    }

    private void g(View view)
    {
        if (view == null || !(view instanceof LinkImageView))
        {
            return;
        }
        if (B == view)
        {
            if (C.getParent() != null)
            {
                ((ViewGroup)C.getParent()).removeView(C);
            }
            C.setVisibility(4);
            B = null;
            return;
        }
        if (B == null)
        {
            if (C.getParent() != null)
            {
                ((ViewGroup)C.getParent()).removeView(C);
            }
            B = (LinkImageView)view;
            ((ViewGroup)B.getParent()).addView(C);
            view = B.getLayoutParams();
            C.setLayoutParams(view);
            C.setVisibility(0);
            return;
        }
        if (D.getParent() != null)
        {
            ((ViewGroup)D.getParent()).removeView(D);
        }
        view = (LinkImageView)view;
        ((ViewGroup)view.getParent()).addView(D);
        android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
        D.setLayoutParams(layoutparams);
        D.setVisibility(0);
        a(B, view);
        j();
    }

    public static TPhotoLinkComposeInfo h(MagComposeLinkFragement magcomposelinkfragement)
    {
        return magcomposelinkfragement.F;
    }

    private void h()
    {
        k();
        i.setEnabled(false);
        if (x != null)
        {
            x.setVisibility(4);
        }
        a.a(a.getResources().getString(0x7f0601c6));
        int i1 = 640;
        InstaBeautyApplication.a();
        if (InstaBeautyApplication.c() || android.os.Build.VERSION.SDK_INT < 14)
        {
            i1 = 412;
        }
        int j1 = (int)(((float)l.getHeight() / (float)l.getWidth()) * (float)i1);
        Log.v(f, (new StringBuilder()).append(f).append("makeResultImage before").toString());
        Bitmap bitmap = b(i1, j1);
        if (bitmap == null)
        {
            Log.v(f, (new StringBuilder()).append(f).append("goNextAndClear makeResultImage fail").toString());
            a.b();
        }
        Log.v(f, (new StringBuilder()).append(f).append("makeResultImage end").toString());
        HashMap hashmap = new HashMap(1);
        hashmap.put(bnr.k, bitmap);
        boy.b().a(hashmap, new bax(this, bitmap));
    }

    public static View i(MagComposeLinkFragement magcomposelinkfragement)
    {
        return magcomposelinkfragement.z;
    }

    private TImageFilterManager i()
    {
        if (u == null)
        {
            u = new TImageFilterManager();
        }
        return u;
    }

    private void j()
    {
        boolean flag;
        if (!A)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        A = flag;
        if (A)
        {
            d.setVisibility(0);
            return;
        } else
        {
            d.setVisibility(4);
            k();
            return;
        }
    }

    private void k()
    {
        if (C.getParent() != null)
        {
            ((ViewGroup)C.getParent()).removeView(C);
        }
        if (D.getParent() != null)
        {
            ((ViewGroup)D.getParent()).removeView(D);
        }
        B = null;
    }

    public void DidProcessed(ArrayList arraylist, int i1)
    {
        if (arraylist != null)
        {
            if (1000 == i1 && a != null && (a.f() == null || a.f().size() == 0))
            {
                a.a(arraylist);
            }
            Log.v(f, (new StringBuilder()).append(f).append(" DidProcessed cropBitmaps Size:").append(arraylist.size()).toString());
            if (a != null && isAdded())
            {
                a.b();
            }
            if (arraylist.size() > 0)
            {
                if (1000 == i1)
                {
                    List list = a.e();
                    Log.v(f, (new StringBuilder()).append(f).append(" DidProcessed selectedUriStrings Size:").append(list.size()).toString());
                    if (arraylist.size() == list.size())
                    {
                        for (i1 = 0; i1 < list.size(); i1++)
                        {
                            String s1 = (String)list.get(i1);
                            TMetaInfo tmetainfo = a(Uri.parse(s1));
                            bin bin1 = new bin();
                            bin1.b = tmetainfo;
                            bin1.a = (Bitmap)arraylist.get(i1);
                            F.metaInfo = tmetainfo;
                            H.add(bin1);
                            Log.v(f, (new StringBuilder()).append(f).append(" DidProcessed selectedString :").append(s1).toString());
                            Log.v(f, (new StringBuilder()).append(f).append(" DidProcessed imageArray Size:").append(H.size()).toString());
                        }

                    }
                }
                Log.v(f, (new StringBuilder()).append(f).append(" DidProcessed imageArray Size:").append(H.size()).toString());
                Log.v(f, (new StringBuilder()).append(f).append(" DidProcessed getCropedBitmaps Size:").append(H.size()).toString());
                b();
                a(true);
                e();
                return;
            }
        }
    }

    public void StartProcessing(int i1)
    {
        if (a != null)
        {
            a.a(getResources().getString(0x7f0601c6));
        }
    }

    public void a()
    {
        ArrayList arraylist = new ArrayList();
        if (a != null)
        {
            List list = a.e();
            if (list == null)
            {
                return;
            }
            for (int i1 = 0; i1 < list.size(); i1++)
            {
                arraylist.add(Uri.parse((String)list.get(i1)));
            }

        }
        Log.v(f, (new StringBuilder()).append(f).append("crop item size:").append(arraylist.size()).toString());
        bjd bjd1 = new bjd();
        bjd1.a(arraylist);
        g = f();
        if (InstaBeautyApplication.b && arraylist.size() > 2 || arraylist.size() >= 5)
        {
            g = 410;
        }
        if (!InstaBeautyApplication.b && arraylist.size() == 1)
        {
            g = 980;
        }
        if (InstaBeautyApplication.h >= 64)
        {
            g = (int)Math.floor((double)g * 1.2D);
        }
        Log.v(f, (new StringBuilder()).append(f).append(" KMaxPix :").append(g).toString());
        bjd1.b(g);
        bjd1.a(this);
        bjd1.a(1000);
        bjd1.d(new ArrayList[0]);
    }

    public void a(int i1)
    {
        boolean flag = false;
        if (a.f() != null)
        {
            E = i1;
            F = a.c().getLinkComposeInfoByResId(E);
            if (l.getChildCount() > 0 && p != null && p.size() > 0)
            {
                for (i1 = 0; i1 < p.size(); i1++)
                {
                    LinkBaseView linkbaseview = (LinkBaseView)p.get(i1);
                    if (linkbaseview.subImage1() != null)
                    {
                        linkbaseview.subImage1().setImageBitmap(null);
                    }
                    if (linkbaseview.subImage2() != null)
                    {
                        linkbaseview.subImage2().setImageBitmap(null);
                    }
                    if (linkbaseview.subImage1MaskView() != null)
                    {
                        Object obj = (BitmapDrawable)linkbaseview.subImage1MaskView().getDrawable();
                        if (obj != null)
                        {
                            obj = ((BitmapDrawable) (obj)).getBitmap();
                            if (obj != null && !((Bitmap) (obj)).isRecycled())
                            {
                                Log.e(f, "rceycleBitmap");
                                ((Bitmap) (obj)).recycle();
                            }
                        }
                    }
                    if (linkbaseview.subImage2MaskView() != null)
                    {
                        Object obj1 = (BitmapDrawable)linkbaseview.subImage2MaskView().getDrawable();
                        if (obj1 != null)
                        {
                            obj1 = ((BitmapDrawable) (obj1)).getBitmap();
                            if (obj1 != null && !((Bitmap) (obj1)).isRecycled())
                            {
                                Log.e(f, "rceycleBitmap");
                                ((Bitmap) (obj1)).recycle();
                            }
                        }
                    }
                    if (linkbaseview != null)
                    {
                        l.removeView(linkbaseview);
                        Log.d(f, (new StringBuilder()).append(f).append(" loadLinkViewsByResid:").toString());
                    }
                }

            }
            p.clear();
            if (H != null)
            {
                H.clear();
            }
            if (k != null)
            {
                k.setBackgroundColor(0);
                Drawable drawable = k.getBackground();
                if (drawable != null)
                {
                    drawable.setCallback(null);
                }
                k.setBackgroundDrawable(null);
                if (e != null && !e.isRecycled())
                {
                    e.recycle();
                    e = null;
                }
            }
            ArrayList arraylist = a.f();
            Log.v(f, (new StringBuilder()).append(f).append(" cropBitmaps Size:").append(arraylist.size()).toString());
            if (arraylist.size() > 0)
            {
                List list = a.e();
                Log.v(f, (new StringBuilder()).append(f).append(" DidProcessed selectedUriStrings Size:").append(list.size()).toString());
                if (arraylist.size() == list.size())
                {
                    for (i1 = ((flag) ? 1 : 0); i1 < list.size(); i1++)
                    {
                        String s1 = (String)list.get(i1);
                        TMetaInfo tmetainfo = a(Uri.parse(s1));
                        bin bin1 = new bin();
                        bin1.b = tmetainfo;
                        bin1.a = (Bitmap)arraylist.get(i1);
                        F.metaInfo = tmetainfo;
                        H.add(bin1);
                        Log.v(f, (new StringBuilder()).append(f).append(" DidProcessed selectedString :").append(s1).toString());
                        Log.v(f, (new StringBuilder()).append(f).append(" DidProcessed imageArray Size:").append(H.size()).toString());
                    }

                }
                Log.v(f, (new StringBuilder()).append(f).append(" DidProcessed imageArray Size:").append(H.size()).toString());
                Log.v(f, (new StringBuilder()).append(f).append(" DidProcessed getCropedBitmaps Size:").append(H.size()).toString());
                b();
                a(true);
                return;
            }
        }
    }

    public void a(View view)
    {
        if (view.requestFocus())
        {
            ((InputMethodManager)getActivity().getSystemService("input_method")).showSoftInput(view, 1);
        }
    }

    public void a(View view, LinkBaseView linkbaseview)
    {
        r.setVisibility(0);
        q.setText(((TextView)view).getText());
        y = view;
        c.setVisibility(4);
        d.setVisibility(4);
        if (a != null)
        {
            a.a(false);
        }
        a(((View) (q)));
    }

    public void a(String s1)
    {
        int i1;
label0:
        {
            if (z != null && (z instanceof LinkImageView) && j != null && a != null)
            {
                i1 = b(((Integer)z.getTag()).intValue());
                Log.v(f, (new StringBuilder()).append(f).append("filter Selected  selectIndex:").append(i1).toString());
                if (i1 < H.size())
                {
                    break label0;
                }
            }
            return;
        }
        Log.v(f, (new StringBuilder()).append(f).append("filter Selected  filterName:").append(s1).toString());
        Bitmap bitmap = ((bin)H.get(i1)).a;
        j.fastProcessImage(bitmap, s1, new bay(this));
    }

    public void a(boolean flag)
    {
        if (flag)
        {
            c();
        }
        bim.a();
        bim.a = 0;
        int i2 = getResources().getDisplayMetrics().widthPixels;
        Log.v(f, (new StringBuilder()).append(f).append("loadLinkViews linkInfoList size:").append(G.size()).toString());
        int k1 = 0;
        float f1 = 0.0F;
        int l1 = 0;
        while (k1 < G.size()) 
        {
            Object obj = (bio)G.get(k1);
            float f2;
            LinkBaseView linkbaseview;
            int j1;
            if (flag)
            {
                linkbaseview = a(((bio) (obj)));
                int i1 = linkbaseview.getOriWith();
                int j2 = linkbaseview.getOriHeight();
                android.widget.FrameLayout.LayoutParams layoutparams1 = new android.widget.FrameLayout.LayoutParams(i2, (int)(((float)i2 / (float)i1) * (float)j2));
                layoutparams1.gravity = 51;
                l.addView(linkbaseview, layoutparams1);
                p.add(linkbaseview);
                linkbaseview.setTextClickListener(this);
                linkbaseview.setTag(Integer.valueOf(k1 + 1));
                if (linkbaseview.subImage1() != null)
                {
                    linkbaseview.subImage1().setOnClickListener(new bba(this));
                    linkbaseview.subImage1().setOnLongClickListener(new bbb(this));
                }
                if (linkbaseview.subImage2() != null)
                {
                    linkbaseview.subImage2().setOnClickListener(new bbc(this));
                    linkbaseview.subImage2().setOnLongClickListener(new bbd(this));
                }
            } else
            {
                linkbaseview = (LinkBaseView)l.findViewWithTag(Integer.valueOf(k1 + 1));
            }
            if (((bio) (obj)).b > 0)
            {
                if (((bio) (obj)).b == 1)
                {
                    linkbaseview.handleImage((bin)H.get(l1), null, flag);
                    linkbaseview.handleImageTag(c(l1), 0);
                    j1 = l1 + 1;
                } else
                {
                    j1 = l1;
                    if (((bio) (obj)).b == 2)
                    {
                        linkbaseview.handleImage((bin)H.get(l1), (bin)H.get(l1 + 1), flag);
                        linkbaseview.handleImageTag(c(l1), c(l1 + 1));
                        j1 = l1 + 2;
                    }
                }
            } else
            {
                linkbaseview.handleData(F.metaInfo, null);
                j1 = l1;
            }
            Log.v(f, (new StringBuilder()).append(f).append("loadViews linkY:").append(f1).toString());
            obj = (android.widget.FrameLayout.LayoutParams)linkbaseview.getLayoutParams();
            obj.gravity = 51;
            obj.width = ((android.widget.FrameLayout.LayoutParams) (obj)).width;
            obj.height = ((android.widget.FrameLayout.LayoutParams) (obj)).height;
            obj.topMargin = (int)f1;
            obj.leftMargin = 0;
            linkbaseview.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            f2 = ((android.widget.FrameLayout.LayoutParams) (obj)).height;
            k1++;
            f1 += f2;
            l1 = j1;
        }
        android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)o.getLayoutParams();
        layoutparams.gravity = 51;
        layoutparams.leftMargin = 0;
        layoutparams.topMargin = 0;
        layoutparams.width = i2;
        layoutparams.height = (int)f1;
        o.setLayoutParams(layoutparams);
        k.setBackgroundColor(F.backgroundColor);
        if (F.backgoundImagePath == null || F.backgoundImagePath.length() <= 0)
        {
            break MISSING_BLOCK_LABEL_718;
        }
        e = F.getBitmapByPath(F.backgoundImagePath);
        if (e != null)
        {
            BitmapDrawable bitmapdrawable = new BitmapDrawable(getResources(), e);
            bitmapdrawable.setTileModeXY(android.graphics.Shader.TileMode.REPEAT, android.graphics.Shader.TileMode.REPEAT);
            k.setBackgroundDrawable(bitmapdrawable);
        }
        return;
        Exception exception;
        exception;
        Crashlytics.logException(exception);
        exception.printStackTrace();
        return;
    }

    public void b()
    {
        if (H.size() > 0)
        {
            Collections.sort(H, new bar(this));
            if (F.hasMultiColumns())
            {
                Collections.sort(H, new baz(this));
                return;
            }
        }
    }

    public void b(View view)
    {
        if (view != null)
        {
            ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void c()
    {
        boolean flag = false;
        G.clear();
        int i2 = H.size();
        int i1;
        if (F.headerInfo != null)
        {
            i1 = 0 + F.headerInfo.b;
            bio bio1 = F.headerInfo.a();
            G.add(bio1);
        } else
        {
            i1 = 0;
        }
        if (i1 < i2)
        {
            bio bio3;
            if (F.footerInfo != null && i2 - i1 >= F.footerInfo.b)
            {
                i1 += F.footerInfo.b;
                flag = true;
            } else
            {
                flag = false;
            }
            if (i1 < i2 && F.bodyInfoArray != null && F.bodyInfoArray.size() > 0)
            {
                int k1 = i2 - i1;
                boolean flag1 = false;
                int j1 = i1;
                i1 = ((flag1) ? 1 : 0);
                while (k1 > 0) 
                {
                    bio bio2 = ((bio)F.bodyInfoArray.get(i1)).a();
                    int l1 = i1 + 1;
                    i1 = l1;
                    if (l1 >= F.bodyInfoArray.size())
                    {
                        i1 = 0;
                    }
                    j1 += bio2.b;
                    if (j1 > i2)
                    {
                        j1 -= bio2.b;
                    } else
                    {
                        G.add(bio2);
                        k1 = i2 - j1;
                    }
                }
            }
        }
        if (flag)
        {
            bio3 = F.footerInfo.a();
            G.add(bio3);
        }
    }

    public void d()
    {
        InstaBeautyApplication.a();
        if (InstaBeautyApplication.c() || android.os.Build.VERSION.SDK_INT < 14)
        {
            h();
            return;
        }
        k();
        i.setEnabled(false);
        if (x != null)
        {
            x.setVisibility(4);
        }
        a.a(a.getResources().getString(0x7f0601c6));
        int i1 = (int)(((float)l.getHeight() / (float)l.getWidth()) * (float)640);
        Log.v(f, (new StringBuilder()).append(f).append("makeResultImage before").toString());
        Bitmap bitmap = a(640, i1);
        if (bitmap == null)
        {
            Log.v(f, (new StringBuilder()).append(f).append("goNext makeResultImage fail").toString());
            h();
            return;
        } else
        {
            Log.v(f, (new StringBuilder()).append(f).append("makeResultImage end").toString());
            HashMap hashmap = new HashMap(1);
            hashmap.put(bnr.k, bitmap);
            boy.b().a(hashmap, new baw(this, bitmap));
            return;
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        a = (MagComposeActivity)activity;
        Log.d(f, (new StringBuilder()).append(f).append(": ").append("onAttach").toString());
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (getArguments() == null)
        {
            Log.e(f, "getArguments() is null");
        }
        E = getArguments().getInt("resid", 0);
        F = a.c().getLinkComposeInfoByResId(E);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        Log.v(f, (new StringBuilder()).append(f).append(" onCreateView ").toString());
        layoutinflater = layoutinflater.inflate(0x7f030083, viewgroup, false);
        m = (ScrollView)layoutinflater.findViewById(0x7f0d0280);
        o = (FrameLayout)layoutinflater.findViewById(0x7f0d0281);
        w = (TMagFilterListScrollView)layoutinflater.findViewById(0x7f0d0207);
        x = (FrameLayout)layoutinflater.findViewById(0x7f0d0206);
        x.setOnTouchListener(new bbf(this));
        h = (Button)layoutinflater.findViewById(0x7f0d00ae);
        i = (Button)layoutinflater.findViewById(0x7f0d01ed);
        i.setVisibility(4);
        h.setVisibility(4);
        h.setOnClickListener(new bbg(this));
        h.setOnClickListener(new bas(this));
        i.setOnClickListener(new bat(this));
        c = (Button)layoutinflater.findViewById(0x7f0d0282);
        d = (TextView)layoutinflater.findViewById(0x7f0d0283);
        c.setVisibility(4);
        d.setVisibility(4);
        c.setOnClickListener(new bau(this));
        b = (ImagesMovingView)layoutinflater.findViewById(0x7f0d024a);
        k = (ImageView)layoutinflater.findViewById(0x7f0d0258);
        l = (FrameLayout)layoutinflater.findViewById(0x7f0d0259);
        n = (FrameLayout)layoutinflater.findViewById(0x7f0d0257);
        r = (RelativeLayout)layoutinflater.findViewById(0x7f0d025b);
        q = (EditText)layoutinflater.findViewById(0x7f0d0167);
        getActivity().getWindow().setSoftInputMode(3);
        ((Button)layoutinflater.findViewById(0x7f0d025c)).setOnClickListener(new bav(this));
        TPhotoComposeInfo.scale = (float)getResources().getDisplayMetrics().widthPixels / (float)axw.a(a, 320F);
        if (a.f() == null || a.f().size() == 0)
        {
            a();
        } else
        {
            a(E);
        }
        c(layoutinflater);
        viewgroup = i().getmFilterDict();
        TImageFilterInfo timagefilterinfo;
        for (bundle = i().getmKeyOderArray().iterator(); bundle.hasNext(); w.addFilterItem(timagefilterinfo.iconUrl, timagefilterinfo.filterName))
        {
            timagefilterinfo = (TImageFilterInfo)viewgroup.get((String)bundle.next());
        }

        w.setCallback(this);
        if (F.width >= F.height)
        {
            FotoAdFactory.createAdBanner(getActivity(), layoutinflater);
        }
        C = new BlackBackGroundView(getActivity());
        C.setVisibility(4);
        D = new BlackBackGroundView(getActivity());
        D.setVisibility(4);
        return layoutinflater;
    }

    public void onPause()
    {
        super.onPause();
        if (j != null)
        {
            j.onPause();
        }
    }

    public void onResume()
    {
        super.onResume();
        i.setEnabled(true);
        if (j != null && j.getRender() != null)
        {
            j.onResume();
        }
        Log.d(f, (new StringBuilder()).append(f).append(": ").append("onResume").toString());
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i1, int j1, int k1)
    {
        Log.v(f, (new StringBuilder()).append(f).append("surfaceChanged").toString());
        v = true;
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
        Log.v(f, (new StringBuilder()).append(f).append("surfaceCreated").toString());
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
        v = false;
        Log.v(f, (new StringBuilder()).append(f).append("surfaceDestroyed").toString());
    }
}
