// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.gpuimage.sample.activity;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import apq;
import atq;
import bei;
import com.Test118.NativeView;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.fotoable.fotobeauty.FullscreenActivity;
import com.fotoable.fotobeauty.WantuActivity;
import com.instabeauty.application.InstaBeautyApplication;
import com.instamag.activity.compose.MagComposeActivity;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMagComposeManager;
import com.wantu.imagerender.ImageGLSurfaceView;
import ik;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import pu;
import qn;
import qv;
import ri;
import rj;
import rk;
import rl;
import rm;
import rn;
import ro;
import rp;
import rq;
import rr;
import rs;
import rt;
import ru;
import rv;
import rw;
import rx;
import ry;
import sb;
import sc;
import sm;

// Referenced classes of package com.fotoable.beautyui.gpuimage.sample.activity:
//            ContinuousPhotoViewPager, contiCapEditItem, PhotoViewerPagerAdapter, ActivityContinousPhotoViewer, 
//            CustomShareUtil

public class contiCapturePhotoEditActivity1 extends FullscreenActivity
    implements android.view.View.OnClickListener, qv
{

    public static String A = "photo_info_list";
    public static String B = "photo_has_filter";
    public static String C = "photo_h2w";
    private final String D = "ContinueViewerRecentShare";
    private GridView E;
    private qn F;
    private Button G;
    private RelativeLayout H;
    private ImageView I;
    private TextView J;
    private Button K;
    private ImageView L;
    private bei M;
    private FrameLayout N;
    private boolean O;
    private float P;
    private ArrayList Q;
    private ImageGLSurfaceView R;
    private boolean S;
    private CustomShareUtil.EnumRecentShare T;
    private boolean U;
    private boolean V;
    private ContinuousPhotoViewPager W;
    private PhotoViewerPagerAdapter X;
    private sb Y;
    private sc Z;
    public FrameLayout a;
    private int aa;
    public FrameLayout b;
    public FrameLayout c;
    public FrameLayout d;
    ImageView e;
    ImageView f;
    ImageView g;
    ImageView h;
    ImageView i;
    ImageView j;
    TextView k;
    ImageView l;
    ImageView m;
    ImageView n;
    ImageView o;
    ImageView p;
    ImageView q;
    ImageView r;
    ImageView s;
    LinearLayout t;
    LinearLayout u;
    LinearLayout v;
    LinearLayout w;
    LinearLayout x;
    LinearLayout y;
    LinearLayout z;

    public contiCapturePhotoEditActivity1()
    {
        M = null;
        O = false;
        P = 1.0F;
        Q = new ArrayList();
        S = false;
        U = false;
        V = false;
        aa = 100;
    }

    private void A()
    {
        Object obj = ((contiCapEditItem)Q.get(W.getCurrentItem())).urlStr;
        ArrayList arraylist = new ArrayList();
        arraylist.add(obj);
        obj = a(arraylist.size());
        if (obj != null)
        {
            Intent intent = new Intent(this, com/instamag/activity/compose/MagComposeActivity);
            intent.putExtra("SelectedComposeInfoResId", ((TPhotoComposeInfo) (obj)).resId);
            intent.putStringArrayListExtra("SelectedImageUriStrings", arraylist);
            intent.putExtra("use_for_flurry_mag", 13);
            startActivity(intent);
        }
        FlurryAgent.logEvent("continutake_photoedit_instamag_clicked");
    }

    private void B()
    {
        showDialog(1);
    }

    private void C()
    {
        removeDialog(1);
    }

    public static ContinuousPhotoViewPager a(contiCapturePhotoEditActivity1 conticapturephotoeditactivity1)
    {
        return conticapturephotoeditactivity1.W;
    }

    private TPhotoComposeInfo a(int i1)
    {
        Object obj = null;
        List list = apq.c().d().getInfosByImageCount(i1);
        TPhotoComposeInfo tphotocomposeinfo = obj;
        if (list != null)
        {
            tphotocomposeinfo = obj;
            if (list.size() > 0)
            {
                tphotocomposeinfo = (TPhotoComposeInfo)list.get((int)(Math.random() * (double)list.size()));
            }
        }
        return tphotocomposeinfo;
    }

    private String a(Bitmap bitmap)
    {
        File file = pu.b(this);
        if (!file.exists() && !file.mkdirs())
        {
            return null;
        }
        String s1 = (new StringBuilder()).append("IMG_").append(String.valueOf(System.currentTimeMillis())).append("_").append(aa).toString();
        aa = aa + 1;
        file = new File((new StringBuilder()).append(file.getPath()).append(File.separator).append(s1).append(".jpg").toString());
        try
        {
            NativeView.a(bitmap, file.getAbsolutePath(), 100);
            sm.a(file.getAbsolutePath(), InstaBeautyApplication.a);
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            bitmap.printStackTrace();
        }
        return Uri.fromFile(file).toString();
    }

    public static String a(contiCapturePhotoEditActivity1 conticapturephotoeditactivity1, Bitmap bitmap)
    {
        return conticapturephotoeditactivity1.a(bitmap);
    }

    private void a(CustomShareUtil.EnumRecentShare enumrecentshare)
    {
        rq.a[enumrecentshare.ordinal()];
        JVM INSTR tableswitch 1 7: default 52
    //                   1 60
    //                   2 78
    //                   3 96
    //                   4 114
    //                   5 132
    //                   6 150
    //                   7 168;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        b.invalidate();
        return;
_L2:
        f.setBackgroundResource(0x7f020141);
        T = enumrecentshare;
        continue; /* Loop/switch isn't completed */
_L3:
        f.setBackgroundResource(0x7f020142);
        T = enumrecentshare;
        continue; /* Loop/switch isn't completed */
_L4:
        f.setBackgroundResource(0x7f0200ae);
        T = enumrecentshare;
        continue; /* Loop/switch isn't completed */
_L5:
        f.setBackgroundResource(0x7f0200b4);
        T = enumrecentshare;
        continue; /* Loop/switch isn't completed */
_L6:
        f.setBackgroundResource(0x7f0200b5);
        T = enumrecentshare;
        continue; /* Loop/switch isn't completed */
_L7:
        f.setBackgroundResource(0x7f020146);
        T = enumrecentshare;
        continue; /* Loop/switch isn't completed */
_L8:
        f.setBackgroundResource(0x7f0200ac);
        T = enumrecentshare;
        if (true) goto _L1; else goto _L9
_L9:
    }

    public static void a(contiCapturePhotoEditActivity1 conticapturephotoeditactivity1, int i1)
    {
        conticapturephotoeditactivity1.c(i1);
    }

    private void a(ArrayList arraylist)
    {
        F.a(arraylist);
        F.notifyDataSetChanged();
    }

    public static boolean a(contiCapturePhotoEditActivity1 conticapturephotoeditactivity1, boolean flag)
    {
        conticapturephotoeditactivity1.V = flag;
        return flag;
    }

    private String b(int i1)
    {
        switch (i1)
        {
        default:
            return "";

        case 2131099722: 
            return getResources().getString(0x7f06004a);

        case 2131099723: 
            return getResources().getString(0x7f06004b);

        case 2131099724: 
            return getResources().getString(0x7f06004c);

        case 2131099725: 
            return getResources().getString(0x7f06004d);

        case 2131099714: 
            return getResources().getString(0x7f060042);

        case 2131099717: 
            return getResources().getString(0x7f060045);

        case 2131099960: 
            return getResources().getString(0x7f060138);

        case 2131100289: 
            return getResources().getString(0x7f060281);

        case 2131099751: 
            return getResources().getString(0x7f060067);

        case 2131099699: 
            return getResources().getString(0x7f06009e);

        case 2131100097: 
            return getResources().getString(0x7f06027c);

        case 2131099708: 
            return getResources().getString(0x7f06003c);

        case 2131099852: 
            return getResources().getString(0x7f0600cc);

        case 2131099750: 
            return getResources().getString(0x7f06027d);

        case 2131100030: 
            return getResources().getString(0x7f06017e);

        case 2131099743: 
        case 2131100172: 
            return getResources().getString(0x7f06005f);
        }
    }

    public static String b(contiCapturePhotoEditActivity1 conticapturephotoeditactivity1, int i1)
    {
        return conticapturephotoeditactivity1.b(i1);
    }

    public static void b(contiCapturePhotoEditActivity1 conticapturephotoeditactivity1)
    {
        conticapturephotoeditactivity1.c();
    }

    private void b(String s1)
    {
        if (Q != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Iterator iterator = Q.iterator();
        contiCapEditItem conticapedititem;
        do
        {
            if (!iterator.hasNext())
            {
                break; /* Loop/switch isn't completed */
            }
            conticapedititem = (contiCapEditItem)iterator.next();
        } while (conticapedititem.urlStr.compareTo(s1) != 0);
        s1 = conticapedititem;
_L4:
        if (s1 != null)
        {
            Q.remove(s1);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        s1 = null;
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    private void b(ArrayList arraylist)
    {
        X.a(arraylist);
        X.notifyDataSetChanged();
    }

    private void c()
    {
        if (V)
        {
            N.setVisibility(0);
            return;
        } else
        {
            N.setVisibility(8);
            return;
        }
    }

    private void c(int i1)
    {
        k.setText((new StringBuilder()).append("(").append(i1).append("/").append(String.valueOf(Q.size())).append(")").toString());
    }

    private void c(ArrayList arraylist)
    {
        Iterator iterator = arraylist.iterator();
        int i1 = 0;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (((contiCapEditItem)iterator.next()).isChecked)
            {
                i1++;
            }
        } while (true);
        J.setText((new StringBuilder()).append(getResources().getString(0x7f060206)).append("(").append(i1).append("/").append(String.valueOf(arraylist.size())).append(")").toString());
        if (i1 == 0)
        {
            K.setEnabled(false);
            G.setEnabled(false);
        } else
        {
            K.setEnabled(true);
            G.setEnabled(true);
        }
        F.a(arraylist);
        F.notifyDataSetChanged();
    }

    public static boolean c(contiCapturePhotoEditActivity1 conticapturephotoeditactivity1)
    {
        return conticapturephotoeditactivity1.S;
    }

    private boolean c(String s1)
    {
        if (Q == null)
        {
            return false;
        }
        for (Iterator iterator = Q.iterator(); iterator.hasNext();)
        {
            if (((contiCapEditItem)iterator.next()).urlStr.compareTo(s1) == 0)
            {
                return true;
            }
        }

        return false;
    }

    private Bitmap d(String s1)
    {
        Object obj = Uri.parse(s1);
        s1 = null;
        try
        {
            obj = getContentResolver().openInputStream(((Uri) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            s1.printStackTrace();
            return null;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        s1 = BitmapFactory.decodeStream(((java.io.InputStream) (obj)));
        return s1;
    }

    public static Button d(contiCapturePhotoEditActivity1 conticapturephotoeditactivity1)
    {
        return conticapturephotoeditactivity1.K;
    }

    private void d()
    {
        N = (FrameLayout)findViewById(0x7f0d0086);
        a = (FrameLayout)findViewById(0x7f0d008c);
        b = (FrameLayout)findViewById(0x7f0d0091);
        c = (FrameLayout)findViewById(0x7f0d0089);
        d = (FrameLayout)findViewById(0x7f0d0087);
        e = (ImageView)findViewById(0x7f0d008d);
        f = (ImageView)findViewById(0x7f0d008e);
        h = (ImageView)findViewById(0x7f0d0090);
        i = (ImageView)findViewById(0x7f0d00a0);
        g = (ImageView)findViewById(0x7f0d008f);
        j = (ImageView)findViewById(0x7f0d008a);
        k = (TextView)findViewById(0x7f0d008b);
        q = (ImageView)findViewById(0x7f0d009b);
        p = (ImageView)findViewById(0x7f0d009d);
        m = (ImageView)findViewById(0x7f0d0099);
        n = (ImageView)findViewById(0x7f0d0097);
        o = (ImageView)findViewById(0x7f0d0095);
        r = (ImageView)findViewById(0x7f0d009f);
        l = (ImageView)findViewById(0x7f0d0093);
        s = (ImageView)findViewById(0x7f0d00a1);
        x = (LinearLayout)findViewById(0x7f0d009a);
        y = (LinearLayout)findViewById(0x7f0d009c);
        v = (LinearLayout)findViewById(0x7f0d0098);
        w = (LinearLayout)findViewById(0x7f0d0096);
        u = (LinearLayout)findViewById(0x7f0d0094);
        z = (LinearLayout)findViewById(0x7f0d009e);
        t = (LinearLayout)findViewById(0x7f0d0092);
        W = (ContinuousPhotoViewPager)findViewById(0x7f0d0088);
        b.setVisibility(4);
        E = (GridView)findViewById(0x7f0d00a8);
        H = (RelativeLayout)findViewById(0x7f0d00a2);
        G = (Button)findViewById(0x7f0d00aa);
        K = (Button)findViewById(0x7f0d00ab);
        I = (ImageView)findViewById(0x7f0d00a5);
        L = (ImageView)findViewById(0x7f0d00a7);
        J = (TextView)findViewById(0x7f0d00a6);
        K.setEnabled(false);
        G.setEnabled(false);
        h.setEnabled(false);
        f.setEnabled(false);
        e.setEnabled(false);
        i.setEnabled(false);
        N.getViewTreeObserver().addOnGlobalLayoutListener(new rr(this));
        c();
    }

    private void d(int i1)
    {
        AnimationSet animationset = new AnimationSet(true);
        b.setVisibility(0);
        TranslateAnimation translateanimation;
        if (U)
        {
            translateanimation = new TranslateAnimation(0.0F, 0.0F, b.getHeight(), 0.0F);
            b.setClickable(true);
            b.setFocusable(true);
        } else
        {
            translateanimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, b.getHeight());
            b.setClickable(false);
            b.setFocusable(false);
        }
        translateanimation.setFillAfter(true);
        translateanimation.setDuration(i1);
        translateanimation.setAnimationListener(new rp(this));
        animationset.addAnimation(translateanimation);
        b.startAnimation(animationset);
    }

    public static Button e(contiCapturePhotoEditActivity1 conticapturephotoeditactivity1)
    {
        return conticapturephotoeditactivity1.G;
    }

    private void e()
    {
        g.setOnClickListener(this);
        h.setOnClickListener(this);
        e.setOnClickListener(this);
        f.setOnClickListener(this);
        i.setOnClickListener(this);
        j.setOnClickListener(this);
        q.setOnClickListener(this);
        p.setOnClickListener(this);
        m.setOnClickListener(this);
        n.setOnClickListener(this);
        o.setOnClickListener(this);
        r.setOnClickListener(this);
        l.setOnClickListener(this);
        s.setOnClickListener(this);
        G.setOnClickListener(this);
        K.setOnClickListener(this);
        I.setOnClickListener(this);
        L.setOnClickListener(this);
        W.setOnPageChangeListener(new rs(this));
    }

    public static ArrayList f(contiCapturePhotoEditActivity1 conticapturephotoeditactivity1)
    {
        return conticapturephotoeditactivity1.Q;
    }

    private void f()
    {
        R.getViewTreeObserver().addOnGlobalLayoutListener(new ru(this));
    }

    public static TextView g(contiCapturePhotoEditActivity1 conticapturephotoeditactivity1)
    {
        return conticapturephotoeditactivity1.J;
    }

    private void g()
    {
        S = true;
        Iterator iterator = Q.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (!((contiCapEditItem)iterator.next()).isChecked)
            {
                continue;
            }
            K.setEnabled(true);
            G.setEnabled(true);
            break;
        } while (true);
        h.setEnabled(true);
        f.setEnabled(true);
        e.setEnabled(true);
        i.setEnabled(true);
    }

    private void h()
    {
        i();
        if (Locale.getDefault().getLanguage().compareTo("zh") == 0)
        {
            v.setVisibility(0);
            w.setVisibility(0);
            u.setVisibility(0);
            return;
        } else
        {
            x.setVisibility(0);
            y.setVisibility(0);
            z.setVisibility(0);
            return;
        }
    }

    public static void h(contiCapturePhotoEditActivity1 conticapturephotoeditactivity1)
    {
        conticapturephotoeditactivity1.h();
    }

    public static float i(contiCapturePhotoEditActivity1 conticapturephotoeditactivity1)
    {
        return conticapturephotoeditactivity1.P;
    }

    private void i()
    {
        x.setVisibility(8);
        y.setVisibility(8);
        v.setVisibility(8);
        w.setVisibility(8);
        u.setVisibility(8);
        z.setVisibility(8);
    }

    public static FrameLayout j(contiCapturePhotoEditActivity1 conticapturephotoeditactivity1)
    {
        return conticapturephotoeditactivity1.N;
    }

    private void j()
    {
        Intent intent = new Intent(this, com/fotoable/fotobeauty/WantuActivity);
        intent.setFlags(0x4000000);
        startActivity(intent);
        FlurryAgent.logEvent("continutake_photoedit_home_clicked");
        finish();
    }

    public static ImageGLSurfaceView k(contiCapturePhotoEditActivity1 conticapturephotoeditactivity1)
    {
        return conticapturephotoeditactivity1.R;
    }

    private void k()
    {
        FlurryAgent.logEvent("continutake_photoedit_cancel_clicked");
        finish();
    }

    public static sb l(contiCapturePhotoEditActivity1 conticapturephotoeditactivity1)
    {
        return conticapturephotoeditactivity1.Y;
    }

    private void l()
    {
        Object obj = F.a();
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = ((ArrayList) (obj)).iterator(); iterator.hasNext(); arraylist.add(((contiCapEditItem)iterator.next()).urlStr)) { }
        obj = a(((ArrayList) (obj)).size());
        if (obj != null)
        {
            Intent intent = new Intent(this, com/instamag/activity/compose/MagComposeActivity);
            intent.putExtra("SelectedComposeInfoResId", ((TPhotoComposeInfo) (obj)).resId);
            intent.putStringArrayListExtra("SelectedImageUriStrings", arraylist);
            intent.putExtra("use_for_flurry_mag", 13);
            startActivity(intent);
        }
        FlurryAgent.logEvent("continutake_photoedit_instamag_clicked");
    }

    private void m()
    {
        ArrayList arraylist = F.a();
        int i1 = 0;
        do
        {
            while (i1 < arraylist.size()) 
            {
                if (Q.contains(arraylist.get(i1)))
                {
                    Object obj = Uri.parse(((contiCapEditItem)arraylist.get(i1)).urlStr);
                    try
                    {
                        Object obj1 = new File(ik.a(this, ((Uri) (obj))));
                        if (((File) (obj1)).exists())
                        {
                            ((File) (obj1)).delete();
                        }
                        obj = getApplicationContext();
                        obj1 = ((File) (obj1)).getPath();
                        rw rw1 = new rw(this);
                        MediaScannerConnection.scanFile(((android.content.Context) (obj)), new String[] {
                            obj1
                        }, null, rw1);
                    }
                    catch (Exception exception)
                    {
                        Crashlytics.logException(exception);
                        exception.printStackTrace();
                    }
                    Q.remove(arraylist.get(i1));
                }
                i1++;
            }
            F.b();
            c(Q);
            b(Q);
            if (Q != null && Q.size() == 0)
            {
                finish();
            }
            FlurryAgent.logEvent("continutake_photoedit_delete_clicked");
            return;
        } while (true);
    }

    public static void m(contiCapturePhotoEditActivity1 conticapturephotoeditactivity1)
    {
        conticapturephotoeditactivity1.g();
    }

    private void n()
    {
        if (U)
        {
            U = false;
            d(500);
        }
    }

    public static void n(contiCapturePhotoEditActivity1 conticapturephotoeditactivity1)
    {
        conticapturephotoeditactivity1.C();
    }

    private void o()
    {
        V = false;
        c();
    }

    public static boolean o(contiCapturePhotoEditActivity1 conticapturephotoeditactivity1)
    {
        return conticapturephotoeditactivity1.U;
    }

    private void p()
    {
        if (!U)
        {
            U = true;
            d(500);
        }
    }

    private void q()
    {
        Uri uri = Uri.parse(((contiCapEditItem)Q.get(W.getCurrentItem())).urlStr);
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("image/*");
        intent.putExtra("android.intent.extra.SUBJECT", "Share");
        intent.putExtra("android.intent.extra.STREAM", uri);
        intent.setFlags(0x10000000);
        startActivity(Intent.createChooser(intent, getTitle()));
    }

    private void r()
    {
        if (W.getCurrentItem() <= Q.size() - 1)
        {
            Object obj = Uri.parse(((contiCapEditItem)Q.get(W.getCurrentItem())).urlStr);
            try
            {
                Object obj1 = new File(ik.a(this, ((Uri) (obj))));
                if (((File) (obj1)).exists())
                {
                    ((File) (obj1)).delete();
                }
                obj = getApplicationContext();
                obj1 = ((File) (obj1)).getPath();
                rx rx1 = new rx(this);
                MediaScannerConnection.scanFile(((android.content.Context) (obj)), new String[] {
                    obj1
                }, null, rx1);
            }
            catch (Exception exception)
            {
                Crashlytics.logException(exception);
                exception.printStackTrace();
            }
            Q.remove(W.getCurrentItem());
            b(Q);
            c(W.getCurrentItem() + 1);
            c(Q);
            if (Q.size() == 0)
            {
                h.setEnabled(false);
                f.setEnabled(false);
                e.setEnabled(false);
                i.setEnabled(false);
                finish();
                return;
            }
        }
    }

    private void s()
    {
        switch (rq.a[T.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            z();
            return;

        case 2: // '\002'
            y();
            return;

        case 3: // '\003'
            x();
            return;

        case 6: // '\006'
            w();
            return;

        case 7: // '\007'
            v();
            return;

        case 4: // '\004'
            u();
            return;

        case 5: // '\005'
            t();
            return;
        }
    }

    private boolean t()
    {
        Bitmap bitmap = d(((contiCapEditItem)Q.get(W.getCurrentItem())).urlStr);
        B();
        FlurryAgent.logEvent("PhotoSharebytwitter");
        return atq.b(this, bitmap, "sync_twitter", null, new ry(this));
    }

    private boolean u()
    {
        B();
        FlurryAgent.logEvent("PhotoSharebySinaweibo");
        return atq.b(this, Uri.parse(((contiCapEditItem)Q.get(W.getCurrentItem())).urlStr), "sync_sina", null, getResources().getString(0x7f060077), new rj(this));
    }

    private boolean v()
    {
        Bitmap bitmap = d(((contiCapEditItem)Q.get(W.getCurrentItem())).urlStr);
        B();
        FlurryAgent.logEvent("PhotoSharebyMonent");
        return atq.f(this, bitmap, "sync_moment", null, new rk(this));
    }

    private boolean w()
    {
        Bitmap bitmap = d(((contiCapEditItem)Q.get(W.getCurrentItem())).urlStr);
        B();
        FlurryAgent.logEvent("PhotoSharebyWechat");
        return atq.e(this, bitmap, "sync_wechat", null, new rl(this));
    }

    private boolean x()
    {
        B();
        FlurryAgent.logEvent("PhotoSharebyQQZone");
        return atq.e(this, Uri.parse(((contiCapEditItem)Q.get(W.getCurrentItem())).urlStr), "sync_qqzone", null, new rm(this));
    }

    private boolean y()
    {
        Bitmap bitmap = d(((contiCapEditItem)Q.get(W.getCurrentItem())).urlStr);
        B();
        FlurryAgent.logEvent("PhotoSharebyInstagram");
        return atq.c(this, bitmap, "sync_instagram", null, new rn(this));
    }

    private boolean z()
    {
        Bitmap bitmap = d(((contiCapEditItem)Q.get(W.getCurrentItem())).urlStr);
        B();
        FlurryAgent.logEvent("PhotoSharebyFacebook");
        return atq.a(this, bitmap, "sync_facebook", null, new ro(this));
    }

    public void a()
    {
        if (U)
        {
            U = false;
            d(500);
        }
    }

    public void a(String s1)
    {
        int i1;
        if (s1 != null)
        {
            if ((i1 = Z.a()) >= 0 && i1 <= Q.size() - 1)
            {
                Log.e("contiCapturePhotoEditActivity1", (new StringBuilder()).append("2222222, onSaveSoftImageFinished, photoIndex=").append(i1).toString());
                ((contiCapEditItem)Q.get(i1)).urlStr = s1;
                ((contiCapEditItem)Q.get(i1)).hasBeautyed = true;
                ((contiCapEditItem)Q.get(i1)).needCache = true;
                ((contiCapEditItem)Q.get(i1)).needCacheBig = true;
                if (!Z.c())
                {
                    Z.b();
                }
                a(Q);
                b(Q);
                return;
            }
        }
    }

    protected ImageGLSurfaceView b()
    {
        if (R == null)
        {
            R = (ImageGLSurfaceView)findViewById(0x7f0d00ac);
            R.setVisibility(0);
            R.getHolder().addCallback(new rv(this));
        }
        return R;
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        if (i1 == ActivityContinousPhotoViewer.a && j1 == ActivityContinousPhotoViewer.b)
        {
            intent = (ArrayList)intent.getSerializableExtra("DelPhotoList");
            break MISSING_BLOCK_LABEL_32;
        }
_L1:
        return;
        if (intent != null && intent.size() != 0)
        {
            i1 = 0;
            while (i1 < intent.size()) 
            {
                if (c((String)intent.get(i1)))
                {
                    try
                    {
                        Object obj = new File((String)intent.get(i1));
                        if (((File) (obj)).exists())
                        {
                            ((File) (obj)).delete();
                        }
                        android.content.Context context = getApplicationContext();
                        obj = ((File) (obj)).getPath();
                        rt rt1 = new rt(this);
                        MediaScannerConnection.scanFile(context, new String[] {
                            obj
                        }, null, rt1);
                    }
                    catch (Exception exception)
                    {
                        Crashlytics.logException(exception);
                        exception.printStackTrace();
                    }
                    b((String)intent.get(i1));
                }
                i1++;
            }
            F.b();
            if (Q != null && Q.size() == 0)
            {
                finish();
                return;
            }
        }
          goto _L1
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR tableswitch 2131558538 2131558571: default 156
    //                   2131558538 182
    //                   2131558539 156
    //                   2131558540 156
    //                   2131558541 157
    //                   2131558542 162
    //                   2131558543 177
    //                   2131558544 167
    //                   2131558545 156
    //                   2131558546 156
    //                   2131558547 374
    //                   2131558548 156
    //                   2131558549 239
    //                   2131558550 156
    //                   2131558551 266
    //                   2131558552 156
    //                   2131558553 320
    //                   2131558554 156
    //                   2131558555 212
    //                   2131558556 156
    //                   2131558557 293
    //                   2131558558 156
    //                   2131558559 347
    //                   2131558560 172
    //                   2131558561 187
    //                   2131558562 156
    //                   2131558563 156
    //                   2131558564 156
    //                   2131558565 202
    //                   2131558566 156
    //                   2131558567 207
    //                   2131558568 156
    //                   2131558569 156
    //                   2131558570 192
    //                   2131558571 197;
           goto _L1 _L2 _L1 _L1 _L3 _L4 _L5 _L6 _L1 _L1 _L7 _L1 _L8 _L1 _L9 _L1 _L10 _L1 _L11 _L1 _L12 _L1 _L13 _L14 _L15 _L1 _L1 _L1 _L16 _L1 _L17 _L1 _L1 _L18 _L19
_L1:
        return;
_L3:
        A();
        return;
_L4:
        s();
        return;
_L6:
        r();
        return;
_L14:
        q();
        return;
_L5:
        p();
        return;
_L2:
        o();
        return;
_L15:
        n();
        return;
_L18:
        m();
        return;
_L19:
        l();
        return;
_L16:
        k();
        return;
_L17:
        j();
        return;
_L11:
        if (z())
        {
            T = CustomShareUtil.EnumRecentShare.SHARE_WECHAT;
            CustomShareUtil.a().a(T, "ContinueViewerRecentShare");
            return;
        }
        continue; /* Loop/switch isn't completed */
_L8:
        if (u())
        {
            T = CustomShareUtil.EnumRecentShare.SHARE_SINA;
            CustomShareUtil.a().a(T, "ContinueViewerRecentShare");
            return;
        }
        continue; /* Loop/switch isn't completed */
_L9:
        if (x())
        {
            T = CustomShareUtil.EnumRecentShare.SHARE_QQZONE;
            CustomShareUtil.a().a(T, "ContinueViewerRecentShare");
            return;
        }
        continue; /* Loop/switch isn't completed */
_L12:
        if (y())
        {
            T = CustomShareUtil.EnumRecentShare.SHARE_INSTAGRAM;
            CustomShareUtil.a().a(T, "ContinueViewerRecentShare");
            return;
        }
        continue; /* Loop/switch isn't completed */
_L10:
        if (v())
        {
            T = CustomShareUtil.EnumRecentShare.SHARE_MOMENT;
            CustomShareUtil.a().a(T, "ContinueViewerRecentShare");
            return;
        }
        continue; /* Loop/switch isn't completed */
_L13:
        if (t())
        {
            T = CustomShareUtil.EnumRecentShare.SHARE_TWITTER;
            CustomShareUtil.a().a(T, "ContinueViewerRecentShare");
            return;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        if (w())
        {
            T = CustomShareUtil.EnumRecentShare.SHARE_WECHAT;
            CustomShareUtil.a().a(T, "ContinueViewerRecentShare");
            return;
        }
        if (true) goto _L1; else goto _L20
_L20:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(0x7f030022);
        CustomShareUtil.a().a(getApplicationContext());
        T = CustomShareUtil.a().a("ContinueViewerRecentShare");
        Z = new sc(this, this);
        d();
        e();
        b();
        O = getIntent().getBooleanExtra(B, false);
        P = getIntent().getFloatExtra(C, 1.0F);
        Q = (ArrayList)getIntent().getSerializableExtra(A);
        J.setText((new StringBuilder()).append(getResources().getString(0x7f060206)).append("(").append(0).append("/").append(String.valueOf(Q.size())).append(")").toString());
        c(1);
        X = new PhotoViewerPagerAdapter();
        X.a(this, Q, this);
        W.setAdapter(X);
        W.setCurrentItem(0);
        Y = new sb(this);
        F = new qn(this, Q, new ri(this));
        E.setAdapter(F);
        f();
    }

    protected void onDestroy()
    {
        super.onDestroy();
        try
        {
            F.c();
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        catch (Error error)
        {
            return;
        }
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4 && V)
        {
            V = false;
            c();
            return true;
        } else
        {
            return super.onKeyDown(i1, keyevent);
        }
    }

    protected void onPause()
    {
        super.onPause();
        if (R != null && R.getRender() != null)
        {
            R.onPause();
        }
        Log.e("contiCapturePhotoEditActivity1", "onPause");
        if (Z != null)
        {
            Z.d();
        }
    }

    protected void onResume()
    {
        a(T);
        super.onResume();
        android.view.WindowManager.LayoutParams layoutparams = getWindow().getAttributes();
        layoutparams.screenBrightness = 0.7F;
        getWindow().setAttributes(layoutparams);
        FlurryAgent.onPageView();
        if (R != null && R.getRender() != null)
        {
            R.onResume();
        }
        if (Z != null)
        {
            sc.b(Z);
        }
    }

    protected void onStart()
    {
        super.onStart();
    }

    protected void onStop()
    {
        super.onStop();
    }

    static 
    {
        System.loadLibrary("fotobeautyengine");
    }
}
