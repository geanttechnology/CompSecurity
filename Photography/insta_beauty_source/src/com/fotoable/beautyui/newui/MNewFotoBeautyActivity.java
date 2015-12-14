// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.newui;

import adp;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Debug;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import azn;
import bjd;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.fotoable.beautyui.BeautyAdjutItemView;
import com.fotoable.beautyui.NewTouchImageView;
import com.fotoable.beautyui.ProEidtActionBarView;
import com.fotoable.beautyui.TBeautyAdjustScrollView;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;
import com.fotoable.fotobeauty.FullscreenActivity;
import com.fotoable.fotoproedit.activity.ProEditAdjustActivity;
import com.fotoable.fotoproedit.activity.ProEditCropActivity;
import com.fotoable.fotoproedit.activity.ProEditFontActivity;
import com.fotoable.fotoproedit.activity.ProEditMosaicActivity;
import com.fotoable.fotoproedit.activity.ProEditNewStretchActivity;
import com.fotoable.fotoproedit.activity.ProEditSlimBodyActivity;
import com.fotoable.sketch.activity.TTieZhiActivity;
import ig;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import sx;
import ty;
import tz;
import ua;
import ub;
import ud;
import ug;
import uh;
import ui;
import ul;
import um;
import uo;
import up;
import uq;
import ur;
import us;
import uu;
import uv;
import xb;
import yo;
import yp;

// Referenced classes of package com.fotoable.beautyui.newui:
//            MOneKeyFragment, MNewSofterFragment, MSlimBodyFragment, MNewFindFaceFragment, 
//            MNewProEditScrollView, MNewBeautyMainFragment

public class MNewFotoBeautyActivity extends FullscreenActivity
{

    public static String a = "sorce_from_where";
    public static String b = "FotoBeautyActivity_SelectedImageUri";
    public static String c = "FotoBeautyActivity_NeedReturnUri";
    public static String d = "FotoBeautyActivity_ReturnImageUri";
    public static String e = "preset_filter_select";
    public static String f = "preset_soft_select";
    public static String g = "use_for_flurry";
    public static String h = "save_three_success";
    public static String i = "activitycamera_threeuri";
    private ExecutorService A;
    private ProEidtActionBarView B;
    private NewTouchImageView C;
    private TBeautyAdjustScrollView D;
    private MNewProEditScrollView E;
    private FrameLayout F;
    private BeautyAdjutItemView G;
    private ImageView H;
    private Button I;
    private Button J;
    private FrameLayout K;
    private xb L;
    private ty M;
    private AlertDialog N;
    public boolean j;
    public boolean k;
    private final String l = "MNewFotoBeautyActivity";
    private final String m = "basicbeauty";
    private final String n = "mainfrag";
    private boolean o;
    private String p;
    private boolean q;
    private int r;
    private boolean s;
    private Bitmap t;
    private Bitmap u;
    private ig v;
    private int w;
    private float x;
    private boolean y;
    private boolean z;

    public MNewFotoBeautyActivity()
    {
        o = false;
        q = false;
        s = false;
        v = null;
        w = 0;
        x = 0.0F;
        y = false;
        z = false;
        A = Executors.newSingleThreadExecutor();
        j = true;
        k = false;
        L = new uu(this);
        M = new ua(this);
    }

    protected static int a(Context context, Uri uri)
    {
        context = context.getContentResolver().query(uri, new String[] {
            "orientation"
        }, null, null, null);
        if (context != null) goto _L2; else goto _L1
_L1:
        int i1;
        if (context != null)
        {
            context.close();
        }
        i1 = -1;
_L4:
        return i1;
_L2:
        int j1;
        if (!context.moveToFirst())
        {
            break; /* Loop/switch isn't completed */
        }
        j1 = context.getInt(0);
        i1 = j1;
        if (context != null)
        {
            context.close();
            return j1;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (context != null)
        {
            context.close();
        }
        return -1;
        uri;
        context = null;
_L6:
        if (context != null)
        {
            context.close();
        }
        throw uri;
        uri;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static AlertDialog a(MNewFotoBeautyActivity mnewfotobeautyactivity, AlertDialog alertdialog)
    {
        mnewfotobeautyactivity.N = alertdialog;
        return alertdialog;
    }

    private Bitmap a(Uri uri, int i1)
    {
label0:
        {
            Object obj = uri.getScheme();
            int j1;
            int k1;
            int l1;
            int i2;
            if (((String) (obj)).equalsIgnoreCase("file"))
            {
                j1 = (int)bjd.c((new ExifInterface(uri.getPath())).getAttributeInt("Orientation", 1));
            } else
            if (((String) (obj)).equalsIgnoreCase("content"))
            {
                j1 = a(((Context) (this)), uri);
            } else
            {
                j1 = -1;
            }
            obj = yo.b(getContentResolver().openInputStream(uri), getContentResolver().openInputStream(uri), i1, i1);
            uri = ((Uri) (obj));
            if (j1 != -1)
            {
                uri = ((Uri) (obj));
                if (j1 != 0)
                {
                    uri = new Matrix();
                    uri.setRotate(j1, ((Bitmap) (obj)).getWidth(), ((Bitmap) (obj)).getHeight());
                    uri = Bitmap.createBitmap(((Bitmap) (obj)), 0, 0, ((Bitmap) (obj)).getWidth(), ((Bitmap) (obj)).getHeight(), uri, true);
                    if (obj == uri);
                }
            }
            l1 = uri.getWidth();
            i2 = uri.getHeight();
            j1 = l1;
            k1 = i2;
            if (uri != null)
            {
                j1 = l1;
                k1 = i2;
                if (Math.max(uri.getWidth(), uri.getHeight()) > i1)
                {
                    float f1 = (float)uri.getWidth() / (float)uri.getHeight();
                    if (f1 > 1.0F)
                    {
                        if (l1 <= i1)
                        {
                            i1 = l1;
                        }
                        k1 = (int)((float)i1 / f1);
                        j1 = i1;
                    } else
                    {
                        if (i2 <= i1)
                        {
                            i1 = i2;
                        }
                        j1 = (int)((float)i1 * f1);
                        k1 = i1;
                    }
                }
            }
            if (j1 % 2 == 0)
            {
                l1 = j1;
                i2 = k1;
                if (k1 % 2 == 0)
                {
                    break label0;
                }
            }
            i1 = j1;
            if (j1 % 2 != 0)
            {
                i1 = j1 - 1;
            }
            l1 = i1;
            i2 = k1;
            if (k1 % 2 != 0)
            {
                i2 = k1 - 1;
                l1 = i1;
            }
        }
        obj = Bitmap.createScaledBitmap(uri, l1, i2, true);
        if (obj == uri);
        return ((Bitmap) (obj));
    }

    public static Bitmap a(MNewFotoBeautyActivity mnewfotobeautyactivity, Bitmap bitmap)
    {
        mnewfotobeautyactivity.u = bitmap;
        return bitmap;
    }

    public static Button a(MNewFotoBeautyActivity mnewfotobeautyactivity)
    {
        return mnewfotobeautyactivity.I;
    }

    private void a(com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState maintoolstate)
    {
        sx.a("BeautyMainFunc_Click", (new StringBuilder()).append("Tool_").append(maintoolstate.toString()).toString());
        if (maintoolstate != com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.ClearEye && maintoolstate != com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.EnhanceNose) goto _L2; else goto _L1
_L1:
        if (v == null || v.a() <= 0) goto _L4; else goto _L3
_L3:
        c(maintoolstate);
_L6:
        return;
_L4:
        b();
        return;
_L2:
        if (maintoolstate == com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.Soften)
        {
            b(maintoolstate);
            return;
        }
        if (maintoolstate == com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.OneKey)
        {
            a(maintoolstate, getString(0x7f0600d4), 0.3F, false);
            return;
        }
        if (maintoolstate != com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.Crop)
        {
            c(maintoolstate);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void a(com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState maintoolstate, String s1, float f1, boolean flag)
    {
        Object obj = getSupportFragmentManager();
        if (((FragmentManager) (obj)).getBackStackEntryCount() < 1)
        {
            obj = ((FragmentManager) (obj)).beginTransaction();
            maintoolstate = MOneKeyFragment.a(maintoolstate, s1, f1, flag);
            ((MOneKeyFragment)maintoolstate).a(L);
            ((FragmentTransaction) (obj)).add(0x7f0d00c5, maintoolstate, "basicbeauty");
            ((FragmentTransaction) (obj)).addToBackStack(null);
            ((FragmentTransaction) (obj)).commitAllowingStateLoss();
        }
    }

    public static void a(MNewFotoBeautyActivity mnewfotobeautyactivity, com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState maintoolstate)
    {
        mnewfotobeautyactivity.a(maintoolstate);
    }

    public static boolean a(MNewFotoBeautyActivity mnewfotobeautyactivity, boolean flag)
    {
        mnewfotobeautyactivity.z = flag;
        return flag;
    }

    public static Button b(MNewFotoBeautyActivity mnewfotobeautyactivity)
    {
        return mnewfotobeautyactivity.J;
    }

    private void b(com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState maintoolstate)
    {
        Object obj = getSupportFragmentManager();
        if (((FragmentManager) (obj)).getBackStackEntryCount() < 1)
        {
            obj = ((FragmentManager) (obj)).beginTransaction();
            maintoolstate = MNewSofterFragment.a(maintoolstate);
            ((MNewSofterFragment)maintoolstate).a(L);
            ((FragmentTransaction) (obj)).setCustomAnimations(0, 0x7f04001e, 0, 0x7f04001e);
            ((FragmentTransaction) (obj)).add(0x7f0d00c5, maintoolstate, "basicbeauty");
            ((FragmentTransaction) (obj)).addToBackStack(null);
            ((FragmentTransaction) (obj)).commitAllowingStateLoss();
        }
    }

    public static FrameLayout c(MNewFotoBeautyActivity mnewfotobeautyactivity)
    {
        return mnewfotobeautyactivity.K;
    }

    private void c()
    {
        startActivityForResult(new Intent(this, com/fotoable/fotoproedit/activity/ProEditCropActivity), 1);
        overridePendingTransition(0, 0);
    }

    private void c(com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState maintoolstate)
    {
        Object obj = getSupportFragmentManager();
        if (((FragmentManager) (obj)).getBackStackEntryCount() < 1)
        {
            obj = ((FragmentManager) (obj)).beginTransaction();
            maintoolstate = MSlimBodyFragment.a(maintoolstate);
            ((MSlimBodyFragment)maintoolstate).a(L);
            ((FragmentTransaction) (obj)).setCustomAnimations(0, 0x7f04001e, 0, 0x7f04001e);
            ((FragmentTransaction) (obj)).add(0x7f0d00c5, maintoolstate, "basicbeauty");
            ((FragmentTransaction) (obj)).addToBackStack(null);
            ((FragmentTransaction) (obj)).commitAllowingStateLoss();
        }
    }

    public static MNewProEditScrollView d(MNewFotoBeautyActivity mnewfotobeautyactivity)
    {
        return mnewfotobeautyactivity.E;
    }

    private void d()
    {
        Log.v("MNewFotoBeautyActivity", "onStretchClick");
        startActivityForResult(new Intent(this, com/fotoable/fotoproedit/activity/ProEditNewStretchActivity), 10);
        overridePendingTransition(0, 0);
    }

    public static NewTouchImageView e(MNewFotoBeautyActivity mnewfotobeautyactivity)
    {
        return mnewfotobeautyactivity.C;
    }

    private void e()
    {
        Log.v("MNewFotoBeautyActivity", "onFontClick");
        startActivityForResult(new Intent(this, com/fotoable/fotoproedit/activity/ProEditFontActivity), 9);
        overridePendingTransition(0, 0);
    }

    public static Bitmap f(MNewFotoBeautyActivity mnewfotobeautyactivity)
    {
        return mnewfotobeautyactivity.u;
    }

    private void f()
    {
        Log.v("MNewFotoBeautyActivity", "onSketchClick");
        Intent intent = new Intent(this, com/fotoable/sketch/activity/TTieZhiActivity);
        intent.putExtra("KISDERECTEDTOSAVE_STRING", false);
        startActivityForResult(intent, 8);
        overridePendingTransition(0, 0);
    }

    private void g()
    {
        Log.v("MNewFotoBeautyActivity", "onMosaicClick");
        Intent intent = new Intent(this, com/fotoable/fotoproedit/activity/ProEditMosaicActivity);
        intent.putExtra(ProEditMosaicActivity.a, true);
        startActivityForResult(intent, 11);
        overridePendingTransition(0, 0);
    }

    public static void g(MNewFotoBeautyActivity mnewfotobeautyactivity)
    {
        mnewfotobeautyactivity.j();
    }

    private void h()
    {
        Log.v("MNewFotoBeautyActivity", "onSlimBodyClick");
        startActivityForResult(new Intent(this, com/fotoable/fotoproedit/activity/ProEditSlimBodyActivity), 11);
        overridePendingTransition(0, 0);
    }

    public static void h(MNewFotoBeautyActivity mnewfotobeautyactivity)
    {
        mnewfotobeautyactivity.p();
    }

    public static ProEidtActionBarView i(MNewFotoBeautyActivity mnewfotobeautyactivity)
    {
        return mnewfotobeautyactivity.B;
    }

    private void i()
    {
        Log.v("MNewFotoBeautyActivity", "onAdjustClick");
        startActivityForResult(new Intent(this, com/fotoable/fotoproedit/activity/ProEditAdjustActivity), 11);
        overridePendingTransition(0, 0);
    }

    private void j()
    {
        F.setVisibility(0);
    }

    public static void j(MNewFotoBeautyActivity mnewfotobeautyactivity)
    {
        mnewfotobeautyactivity.g();
    }

    private void k()
    {
        F.setVisibility(8);
    }

    public static void k(MNewFotoBeautyActivity mnewfotobeautyactivity)
    {
        mnewfotobeautyactivity.c();
    }

    private void l()
    {
        android.content.SharedPreferences.Editor editor;
        Object obj;
        int i1;
        obj = getSharedPreferences("setting", 0);
        editor = ((SharedPreferences) (obj)).edit();
        i1 = ((SharedPreferences) (obj)).getInt("checkcount", 0);
        if (i1 >= 100)
        {
            return;
        }
        long l1;
        if (((SharedPreferences) (obj)).getBoolean("isfastphone", false))
        {
            break MISSING_BLOCK_LABEL_217;
        }
        obj = Bitmap.createBitmap(200, 200, android.graphics.Bitmap.Config.ARGB_8888);
        (new Canvas(((Bitmap) (obj)))).drawColor(0xff888888);
        ig ig1 = new ig();
        ig1.a(getAssets(), ((Bitmap) (obj)));
        ig1.a(true);
        l1 = Debug.threadCpuTimeNanos();
        ig1.a(adp.c, null);
        ig1.b();
        l1 = (Debug.threadCpuTimeNanos() - l1) / 0xf4240L;
        if (l1 >= 105L)
        {
            break MISSING_BLOCK_LABEL_153;
        }
        editor.putBoolean("isfastphone", true);
        editor.apply();
        editor.putInt("checkcount", i1);
        editor.commit();
        Log.e("MNewFotoBeautyActivity", (new StringBuilder()).append(l1).append("ms").toString());
        return;
        Exception exception;
        exception;
        exception.printStackTrace();
        Crashlytics.logException(exception);
        v.a(false);
    }

    public static void l(MNewFotoBeautyActivity mnewfotobeautyactivity)
    {
        mnewfotobeautyactivity.e();
    }

    private void m()
    {
        j();
        A.execute(new us(this));
    }

    public static void m(MNewFotoBeautyActivity mnewfotobeautyactivity)
    {
        mnewfotobeautyactivity.f();
    }

    private void n()
    {
        FragmentTransaction fragmenttransaction = getSupportFragmentManager().beginTransaction();
        MNewFindFaceFragment mnewfindfacefragment = MNewFindFaceFragment.a();
        ((MNewFindFaceFragment)mnewfindfacefragment).a(M);
        fragmenttransaction.setCustomAnimations(0, 0x7f04001e, 0, 0x7f04001e);
        fragmenttransaction.add(0x7f0d00c5, mnewfindfacefragment, "basicbeauty");
        fragmenttransaction.addToBackStack(null);
        fragmenttransaction.commitAllowingStateLoss();
    }

    public static void n(MNewFotoBeautyActivity mnewfotobeautyactivity)
    {
        mnewfotobeautyactivity.i();
    }

    private Fragment o()
    {
        Object obj = getSupportFragmentManager();
        if (obj != null)
        {
            if ((obj = ((FragmentManager) (obj)).getFragments()) != null && ((List) (obj)).size() > 0)
            {
                return (Fragment)((List) (obj)).get(((List) (obj)).size() - 1);
            }
        }
        return null;
    }

    public static void o(MNewFotoBeautyActivity mnewfotobeautyactivity)
    {
        mnewfotobeautyactivity.d();
    }

    private void p()
    {
        FlurryAgent.logEvent("fotobeauty_accept_clicked");
        if (p != null)
        {
            (new Thread(new ub(this, Uri.parse(p)))).start();
            return;
        } else
        {
            (new Thread(new ud(this))).start();
            return;
        }
    }

    public static void p(MNewFotoBeautyActivity mnewfotobeautyactivity)
    {
        mnewfotobeautyactivity.h();
    }

    public static Bitmap q(MNewFotoBeautyActivity mnewfotobeautyactivity)
    {
        return mnewfotobeautyactivity.t;
    }

    public static ig r(MNewFotoBeautyActivity mnewfotobeautyactivity)
    {
        return mnewfotobeautyactivity.v;
    }

    public static void s(MNewFotoBeautyActivity mnewfotobeautyactivity)
    {
        mnewfotobeautyactivity.k();
    }

    public static void t(MNewFotoBeautyActivity mnewfotobeautyactivity)
    {
        mnewfotobeautyactivity.n();
    }

    public static boolean u(MNewFotoBeautyActivity mnewfotobeautyactivity)
    {
        return mnewfotobeautyactivity.z;
    }

    public static boolean v(MNewFotoBeautyActivity mnewfotobeautyactivity)
    {
        return mnewfotobeautyactivity.o;
    }

    public static boolean w(MNewFotoBeautyActivity mnewfotobeautyactivity)
    {
        return mnewfotobeautyactivity.q;
    }

    public static int x(MNewFotoBeautyActivity mnewfotobeautyactivity)
    {
        return mnewfotobeautyactivity.r;
    }

    public static AlertDialog y(MNewFotoBeautyActivity mnewfotobeautyactivity)
    {
        return mnewfotobeautyactivity.N;
    }

    public Bitmap a(Uri uri)
    {
        int i1 = azn.d();
        try
        {
            uri = a(uri, i1);
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            uri.printStackTrace();
            return null;
        }
        return uri;
    }

    public void a()
    {
        FragmentManager fragmentmanager = getSupportFragmentManager();
        if (fragmentmanager.getBackStackEntryCount() > 0)
        {
            FragmentTransaction fragmenttransaction = getSupportFragmentManager().beginTransaction();
            fragmentmanager.popBackStack(fragmentmanager.getBackStackEntryAt(fragmentmanager.getBackStackEntryCount() - 1).getId(), 1);
            fragmenttransaction.commitAllowingStateLoss();
            return;
        } else
        {
            finish();
            return;
        }
    }

    public void b()
    {
        N = (new android.app.AlertDialog.Builder(this)).create();
        N.getWindow().clearFlags(2);
        N.setCanceledOnTouchOutside(true);
        N.show();
        View view = LayoutInflater.from(this).inflate(0x7f030059, null);
        android.view.ViewGroup.LayoutParams layoutparams = new android.view.ViewGroup.LayoutParams(getResources().getDisplayMetrics().widthPixels - 200, -1);
        ((Button)view.findViewById(0x7f0d01f2)).setOnClickListener(new ug(this));
        ((Button)view.findViewById(0x7f0d01f3)).setOnClickListener(new uh(this));
        N.setContentView(view, layoutparams);
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        if (j1 == -1)
        {
            switch (i1)
            {
            case 2: // '\002'
            case 3: // '\003'
            case 5: // '\005'
            case 6: // '\006'
            case 7: // '\007'
            default:
                return;

            case 1: // '\001'
            case 10: // '\n'
                u = uv.c().i();
                C.setImageBitmap(u);
                j();
                A.execute(new ui(this));
                B.updateBackState(uv.c().e(), uv.c().f());
                return;

            case 4: // '\004'
            case 8: // '\b'
            case 9: // '\t'
            case 11: // '\013'
                u = uv.c().i();
                break;
            }
            C.setImageBitmap(u);
            B.updateBackState(uv.c().e(), uv.c().f());
            return;
        } else
        {
            super.onActivityResult(i1, j1, intent);
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        Object obj;
        String s2;
        String s3;
        super.onCreate(bundle);
        l();
        setContentView(0x7f030027);
        D = (TBeautyAdjustScrollView)findViewById(0x7f0d00be);
        B = (ProEidtActionBarView)findViewById(0x7f0d00ba);
        C = (NewTouchImageView)findViewById(0x7f0d00bc);
        F = (FrameLayout)findViewById(0x7f0d0060);
        G = (BeautyAdjutItemView)findViewById(0x7f0d00bf);
        H = (ImageView)findViewById(0x7f0d00c4);
        K = (FrameLayout)findViewById(0x7f0d00bd);
        E = (MNewProEditScrollView)findViewById(0x7f0d00c1);
        I = (Button)findViewById(0x7f0d00c2);
        J = (Button)findViewById(0x7f0d00c3);
        F.setVisibility(8);
        B.updateBackState(uv.c().e(), uv.c().f());
        I.setOnClickListener(new tz(this));
        J.setOnClickListener(new ul(this));
        H.setOnTouchListener(new um(this));
        G.setResourceID(0x7f060085, 0x7f02007f, getResources().getColor(0x7f0c009d), getResources().getColor(0x7f0c002d));
        if (yp.a() || yp.b())
        {
            G.setTxtSize(10);
        } else
        {
            G.setTxtSize(9);
        }
        G.setOnClickListener(new uo(this));
        B.setOnAcceptListener(new up(this));
        D.setCallback(new uq(this));
        E.setCallback(new ur(this));
        if (t != null) goto _L2; else goto _L1
_L1:
        s = false;
        if (s) goto _L4; else goto _L3
_L3:
        obj = getIntent().getExtras();
        s2 = getIntent().getAction();
        s3 = getIntent().getType();
        if (obj != null) goto _L6; else goto _L5
_L5:
        finish();
_L10:
        return;
_L6:
        x = ((Bundle) (obj)).getFloat(f, 0.0F);
        w = ((Bundle) (obj)).getInt(e, 0);
        p = ((Bundle) (obj)).getString(i);
        q = ((Bundle) (obj)).getBoolean(ActivityCameraNew.c);
        r = ((Bundle) (obj)).getInt(g, 0);
        int i1 = ((Bundle) (obj)).getInt(a, 0);
        if (i1 == 1)
        {
            t = uv.c().j();
        } else
        if (i1 == 2)
        {
            t = a(Uri.parse(((Bundle) (obj)).getString(b)));
        } else
        {
            String s1 = ((Bundle) (obj)).getString(b);
            if (((Bundle) (obj)).getString(c) != null)
            {
                o = true;
            }
            obj = s1;
            if ("android.intent.action.SEND".equals(s2))
            {
                obj = s1;
                if (s3 != null)
                {
                    obj = s1;
                    if (s3.startsWith("image/"))
                    {
                        obj = (Uri)getIntent().getParcelableExtra("android.intent.extra.STREAM");
                        if (obj == null)
                        {
                            finish();
                            return;
                        }
                        obj = ((Uri) (obj)).toString();
                    }
                }
            }
            if (obj == null)
            {
                finish();
                return;
            }
            t = a(Uri.parse(((String) (obj))));
        }
_L8:
        if (t == null)
        {
            finish();
            return;
        }
        break; /* Loop/switch isn't completed */
_L4:
        t = BitmapFactory.decodeResource(getResources(), 0x7f02028b);
        if (true) goto _L8; else goto _L7
_L7:
        u = t;
        uv.c().a(t, null, false, null);
        C.setImageBitmap(u);
_L2:
        v = new ig();
        m();
        if (bundle == null && w != 0)
        {
            y = true;
            k = true;
            a(com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.OneKey, getString(w), x, true);
            return;
        }
        if (true) goto _L10; else goto _L9
_L9:
    }

    protected void onDestroy()
    {
        super.onDestroy();
        uv.c().d();
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        Fragment fragment = o();
        if (N != null)
        {
            N.dismiss();
            N = null;
            return false;
        }
        if (fragment == null)
        {
            return super.onKeyDown(i1, keyevent);
        }
        if (fragment instanceof MSlimBodyFragment)
        {
            ((MSlimBodyFragment)fragment).a(i1, keyevent);
            return false;
        }
        if (fragment instanceof MOneKeyFragment)
        {
            ((MOneKeyFragment)fragment).a(i1, keyevent);
            return false;
        }
        if (fragment instanceof MNewSofterFragment)
        {
            ((MNewSofterFragment)fragment).a(i1, keyevent);
            return false;
        }
        if (fragment instanceof MNewBeautyMainFragment)
        {
            FlurryAgent.logEvent("fotobeauty_back_clicked");
            finish();
            return false;
        } else
        {
            return super.onKeyDown(i1, keyevent);
        }
    }

    protected void onPause()
    {
        if (N != null)
        {
            N.dismiss();
            N = null;
        }
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        android.view.WindowManager.LayoutParams layoutparams = getWindow().getAttributes();
        layoutparams.screenBrightness = 0.7F;
        getWindow().setAttributes(layoutparams);
        FlurryAgent.onPageView();
    }

    static 
    {
        new ig();
    }
}
