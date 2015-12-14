// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.flurry.android.FlurryAgent;
import com.fotoable.ad.FotoAdFactory;
import com.fotoable.ad.FotoCustomReport;
import com.fotoable.photocollage.activity.compose2.ComposePhotoesActivity2;
import com.fotoable.sketch.activity.TTieZhiActivity;
import com.pipcamera.activity.FullscreenActivity;
import com.pipcamera.activity.NewPhotoShareActivity;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.utility.ui.ProcessDialogFragment;
import ew;
import gm;
import gp;
import gq;
import gr;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import ms;
import rd;
import so;
import sp;

// Referenced classes of package com.fotoable.fotoproedit.activity:
//            ProEditCropActivity, ProEditFilterActivity, ProEditNewStretchActivity, ProEditFontActivity, 
//            ProEditMosaicActivity, ProEditAdjustActivity, ProEidtMainActionBarView, TProEditMainScrollView

public class ProEditMainActivity extends FullscreenActivity
    implements gq, ms, sp
{

    TProEditMainScrollView a;
    ImageView b;
    ProcessDialogFragment c;
    ProEidtMainActionBarView d;
    so e;
    boolean f;
    boolean g;
    boolean h;
    boolean i;
    ArrayList j;
    View k;
    private int l;
    private ImageView m;
    private ImageView n;
    private RelativeLayout o;
    private String p;
    private int q;
    private android.view.View.OnClickListener r;
    private android.view.View.OnClickListener s;

    public ProEditMainActivity()
    {
        l = 0;
        f = false;
        g = false;
        h = false;
        i = false;
        r = new android.view.View.OnClickListener() {

            final ProEditMainActivity a;

            public void onClick(View view)
            {
                ProEditMainActivity.a(a);
            }

            
            {
                a = ProEditMainActivity.this;
                super();
            }
        };
        s = new android.view.View.OnClickListener() {

            final ProEditMainActivity a;

            public void onClick(View view)
            {
                ProEditMainActivity.b(a);
            }

            
            {
                a = ProEditMainActivity.this;
                super();
            }
        };
    }

    static void a(ProEditMainActivity proeditmainactivity)
    {
        proeditmainactivity.f();
    }

    static void a(ProEditMainActivity proeditmainactivity, File file)
    {
        proeditmainactivity.a(file);
    }

    static void a(ProEditMainActivity proeditmainactivity, boolean flag)
    {
        proeditmainactivity.b(flag);
    }

    private void a(File file)
    {
        Intent intent;
        if (file == null)
        {
            try
            {
                Toast.makeText(this, getResources().getString(0x7f060196), 0).show();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                return;
            }
        }
        rd.a(file.getAbsolutePath(), this);
        file = Uri.fromFile(file);
        if (file == null) goto _L2; else goto _L1
_L1:
        intent = new Intent(this, com/pipcamera/activity/NewPhotoShareActivity);
        intent.putExtra("PhotoShareActivity_ToShareImageUri", file.toString());
        if (!g) goto _L4; else goto _L3
_L3:
        if (!h) goto _L6; else goto _L5
_L5:
        FlurryAgent.logEvent("PhotoSave_Collage_Grid");
        if (!i) goto _L8; else goto _L7
_L7:
        FlurryAgent.logEvent("PhotoSave_Collage_Grid_Vertical");
_L11:
        FotoCustomReport.addStringToArray(FotoCustomReport.userSavedFunction, "collage");
_L9:
        startActivity(intent);
        overridePendingTransition(0x7f040007, 0);
        return;
_L8:
        FlurryAgent.logEvent("PhotoSave_Collage_Grid_Square");
        continue; /* Loop/switch isn't completed */
_L6:
        if (i)
        {
            FlurryAgent.logEvent("PhotoSave_Collage_Free_Vertical");
            continue; /* Loop/switch isn't completed */
        }
        FlurryAgent.logEvent("PhotoSave_Collage_Free_Square");
        continue; /* Loop/switch isn't completed */
_L4:
        FlurryAgent.logEvent("PhotoSave_ProEdit");
        FotoCustomReport.addStringToArray(FotoCustomReport.userSavedFunction, "proedit");
          goto _L9
_L2:
        return;
        if (true) goto _L11; else goto _L10
_L10:
    }

    private void a(ArrayList arraylist)
    {
        char c1 = '\u03C0';
        a();
        e = new so();
        e.a(this);
        e.a(arraylist);
        if (gr.b() <= 1000) goto _L2; else goto _L1
_L1:
        if (!PIPCameraApplication.b)
        {
            c1 = '\u0500';
        }
        e.b(c1);
_L4:
        e.c(new ArrayList[] {
            arraylist
        });
        return;
_L2:
        if (PIPCameraApplication.b)
        {
            c1 = '\u0280';
        }
        e.b(c1);
        if (true) goto _L4; else goto _L3
_L3:
        arraylist;
        arraylist.printStackTrace();
        return;
    }

    private void a(boolean flag)
    {
        Log.v("ProEditMainActivity", "onCropClick");
        startActivityForResult(new Intent(this, com/fotoable/fotoproedit/activity/ProEditCropActivity), 1);
        if (flag)
        {
            overridePendingTransition(0x7f04001c, 0x7f040018);
            return;
        } else
        {
            overridePendingTransition(0x7f040012, 0x7f040019);
            return;
        }
    }

    static void b(ProEditMainActivity proeditmainactivity)
    {
        proeditmainactivity.e();
    }

    static void b(ProEditMainActivity proeditmainactivity, boolean flag)
    {
        proeditmainactivity.d(flag);
    }

    private void b(boolean flag)
    {
        Log.v("ProEditMainActivity", "onFilterClick");
        startActivityForResult(new Intent(this, com/fotoable/fotoproedit/activity/ProEditFilterActivity), 4);
        if (flag)
        {
            overridePendingTransition(0x7f04001c, 0x7f040018);
            return;
        } else
        {
            overridePendingTransition(0x7f040012, 0x7f040019);
            return;
        }
    }

    static int c(ProEditMainActivity proeditmainactivity)
    {
        return proeditmainactivity.l;
    }

    static void c(ProEditMainActivity proeditmainactivity, boolean flag)
    {
        proeditmainactivity.a(flag);
    }

    private void c(boolean flag)
    {
        Log.v("ProEditMainActivity", "onStretchClick");
        startActivityForResult(new Intent(this, com/fotoable/fotoproedit/activity/ProEditNewStretchActivity), 10);
        if (flag)
        {
            overridePendingTransition(0x7f04001c, 0x7f040018);
            return;
        } else
        {
            overridePendingTransition(0x7f040012, 0x7f040019);
            return;
        }
    }

    static void d(ProEditMainActivity proeditmainactivity, boolean flag)
    {
        proeditmainactivity.e(flag);
    }

    private void d(boolean flag)
    {
        Log.v("ProEditMainActivity", "onFontClick");
        startActivityForResult(new Intent(this, com/fotoable/fotoproedit/activity/ProEditFontActivity), 9);
        if (flag)
        {
            overridePendingTransition(0x7f04001c, 0x7f040018);
            return;
        } else
        {
            overridePendingTransition(0x7f040012, 0x7f040019);
            return;
        }
    }

    private void e()
    {
        Object obj = gm.c();
        obj.c = ((gm) (obj)).c + 1;
        obj = gm.c().k();
        if (obj != null)
        {
            b.setImageBitmap(((Bitmap) (obj)));
        }
        g();
    }

    static void e(ProEditMainActivity proeditmainactivity, boolean flag)
    {
        proeditmainactivity.g(flag);
    }

    private void e(boolean flag)
    {
        Log.v("ProEditMainActivity", "onMosaicClick");
        Intent intent = new Intent(this, com/fotoable/fotoproedit/activity/ProEditMosaicActivity);
        intent.putExtra(ProEditMosaicActivity.a, true);
        startActivityForResult(intent, 11);
        if (flag)
        {
            overridePendingTransition(0x7f04001c, 0x7f040018);
            return;
        } else
        {
            overridePendingTransition(0x7f040012, 0x7f040019);
            return;
        }
    }

    private void f()
    {
        Object obj = gm.c();
        obj.c = ((gm) (obj)).c - 1;
        obj = gm.c().k();
        if (obj != null)
        {
            b.setImageBitmap(((Bitmap) (obj)));
        }
        g();
    }

    static void f(ProEditMainActivity proeditmainactivity, boolean flag)
    {
        proeditmainactivity.c(flag);
    }

    private void f(boolean flag)
    {
        Log.v("ProEditMainActivity", "onDrawClick");
        Intent intent = new Intent(this, com/fotoable/fotoproedit/activity/ProEditMosaicActivity);
        intent.putExtra(ProEditMosaicActivity.a, false);
        startActivityForResult(intent, 11);
        if (flag)
        {
            overridePendingTransition(0x7f04001c, 0x7f040018);
            return;
        } else
        {
            overridePendingTransition(0x7f040012, 0x7f040019);
            return;
        }
    }

    private void g()
    {
        if (gm.c().g())
        {
            n.setEnabled(true);
        } else
        {
            n.setEnabled(false);
        }
        if (gm.c().f())
        {
            m.setEnabled(true);
            return;
        } else
        {
            m.setEnabled(false);
            return;
        }
    }

    static void g(ProEditMainActivity proeditmainactivity, boolean flag)
    {
        proeditmainactivity.f(flag);
    }

    private void g(boolean flag)
    {
        Log.v("ProEditMainActivity", "onAdjustClick");
        startActivityForResult(new Intent(this, com/fotoable/fotoproedit/activity/ProEditAdjustActivity), 11);
        if (flag)
        {
            overridePendingTransition(0x7f04001c, 0x7f040018);
            return;
        } else
        {
            overridePendingTransition(0x7f040012, 0x7f040019);
            return;
        }
    }

    static void h(ProEditMainActivity proeditmainactivity, boolean flag)
    {
        proeditmainactivity.h(flag);
    }

    private void h(boolean flag)
    {
        Log.v("ProEditMainActivity", "onSketchClick");
        Intent intent = new Intent(this, com/fotoable/sketch/activity/TTieZhiActivity);
        intent.putExtra("KISDERECTEDTOSAVE_STRING", false);
        startActivityForResult(intent, 8);
        if (flag)
        {
            overridePendingTransition(0x7f04001c, 0x7f040018);
            return;
        } else
        {
            overridePendingTransition(0x7f040012, 0x7f040019);
            return;
        }
    }

    public void a()
    {
        try
        {
            if (c == null)
            {
                ProcessDialogFragment processdialogfragment = new ProcessDialogFragment();
                Bundle bundle = new Bundle();
                bundle.putString("text", getResources().getString(0x7f0601a4));
                processdialogfragment.setArguments(bundle);
                processdialogfragment.setCancelable(false);
                c = processdialogfragment;
                c.show(getSupportFragmentManager(), "process");
            }
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void a(int i1)
    {
    }

    public void a(String s1, Object obj)
    {
        obj = new HashMap();
        ((Map) (obj)).put("funName", s1);
        FlurryAgent.logEvent("proEditFunctionClicked", ((Map) (obj)));
        if (s1.compareTo("crop") == 0)
        {
            a(true);
        } else
        {
            if (s1.compareTo("filter") == 0)
            {
                b(true);
                return;
            }
            if (s1.compareTo("font") == 0)
            {
                d(true);
                return;
            }
            if (s1.compareTo("stretch") == 0)
            {
                c(true);
                return;
            }
            if (s1.compareTo("mosaic") == 0)
            {
                e(true);
                return;
            }
            if (s1.compareTo("draw") == 0)
            {
                f(true);
                return;
            }
            if (s1.compareTo("adjust") == 0)
            {
                g(true);
                return;
            }
            if (s1.compareTo("sketch") == 0)
            {
                h(true);
                return;
            }
        }
    }

    public void a(ArrayList arraylist, int i1)
    {
label0:
        {
            if (arraylist != null && arraylist.size() > 0)
            {
                arraylist = (Bitmap)arraylist.get(0);
                if (arraylist != null)
                {
                    break label0;
                }
                b();
                finish();
                Toast.makeText(getApplicationContext(), 0x7f0600e4, 0).show();
            }
            return;
        }
        f = true;
        b();
        gm.c().a(arraylist, new gp() {

            final ProEditMainActivity a;

            public void a(String s1)
            {
            }

            
            {
                a = ProEditMainActivity.this;
                super();
            }
        });
        b.setImageBitmap(arraylist);
        (new Handler()).postDelayed(new Runnable() {

            final ProEditMainActivity a;

            public void run()
            {
                if (ProEditMainActivity.c(a) == 2)
                {
                    ProEditMainActivity.a(a, true);
                }
                if (ProEditMainActivity.c(a) == 3)
                {
                    ProEditMainActivity.b(a, true);
                }
                if (ProEditMainActivity.c(a) == 4)
                {
                    ProEditMainActivity.c(a, true);
                }
                if (ProEditMainActivity.c(a) == 8)
                {
                    ProEditMainActivity.d(a, true);
                }
                if (ProEditMainActivity.c(a) == 9)
                {
                    ProEditMainActivity.e(a, true);
                }
                if (ProEditMainActivity.c(a) == 12)
                {
                    ProEditMainActivity.f(a, true);
                }
                if (ProEditMainActivity.c(a) == 14)
                {
                    ProEditMainActivity.g(a, true);
                }
                if (ProEditMainActivity.c(a) == 5)
                {
                    ProEditMainActivity.h(a, true);
                }
            }

            
            {
                a = ProEditMainActivity.this;
                super();
            }
        }, 10L);
    }

    public void b()
    {
        try
        {
            if (c != null)
            {
                c.dismissAllowingStateLoss();
                c = null;
            }
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void c()
    {
        d.isSharButtonEnable(false);
        a();
        (new Handler()).postDelayed(new Runnable() {

            final ProEditMainActivity a;

            public void run()
            {
                try
                {
                    gm.c().a(new gp(this) {

                        final _cls6 a;

                        public void a(String s1)
                        {
                            s1 = rd.a(s1);
                            if (s1 == null || !s1.exists()) goto _L2; else goto _L1
_L1:
                            ProEditMainActivity.a(a.a, s1);
_L4:
                            a.a.b();
                            return;
_L2:
                            s1 = gm.c().k();
                            if (s1 != null)
                            {
                                try
                                {
                                    s1 = rd.a(s1);
                                    ProEditMainActivity.a(a.a, s1);
                                }
                                // Misplaced declaration of an exception variable
                                catch (String s1)
                                {
                                    s1.printStackTrace();
                                }
                            }
                            if (true) goto _L4; else goto _L3
_L3:
                        }

            
            {
                a = _pcls6;
                super();
            }
                    });
                    return;
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
                a.b();
            }

            
            {
                a = ProEditMainActivity.this;
                super();
            }
        }, 150L);
        d.isSharButtonEnable(true);
    }

    public void d()
    {
        if (g)
        {
            a();
            Intent intent = new Intent(this, com/fotoable/photocollage/activity/compose2/ComposePhotoesActivity2);
            intent.putExtra("CollageIds", j);
            startActivity(intent);
            b();
            finish();
            overridePendingTransition(0x7f040016, 0x7f040017);
            return;
        } else
        {
            finish();
            return;
        }
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        if (j1 != -1)
        {
            return;
        }
        intent = gm.c().k();
        if (intent != null)
        {
            b.setImageBitmap(intent);
        }
        g();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        Log.i("test", (new StringBuilder()).append(getResources().getDisplayMetrics().densityDpi).append("").toString());
        setContentView(0x7f030025);
        a = (TProEditMainScrollView)findViewById(0x7f0c0098);
        a.setCallback(this);
        o = (RelativeLayout)findViewById(0x7f0c0055);
        k = findViewById(0x7f0c0096);
        d = (ProEidtMainActionBarView)findViewById(0x7f0c0088);
        d.setActionBarTitle("");
        d.setOnActionBarItemListener(this);
        b = (ImageView)findViewById(0x7f0c00af);
        Log.d("ProEditMainActivity", "proEditMainActivity ...1");
        if (bundle != null) goto _L2; else goto _L1
_L1:
        Object obj;
        Intent intent;
        gm.c().i();
        Log.d("ProEditMainActivity", "proEditMainActivity ...2");
        intent = getIntent();
        l = intent.getIntExtra("ChooseStyleId", 0);
        p = intent.getStringExtra("PROEDIT2LIGHT_INFONAME_STRING");
        q = intent.getIntExtra("PROEDIT2BORDER_INFOID_STRING", -1);
        bundle = intent.getStringExtra("uri");
        obj = intent.getStringExtra("FileName");
        if (bundle == null) goto _L4; else goto _L3
_L3:
        obj = new ArrayList();
        ((ArrayList) (obj)).add(Uri.parse(bundle));
        a(((ArrayList) (obj)));
_L6:
        m = (ImageView)findViewById(0x7f0c00ae);
        m.setOnClickListener(s);
        n = (ImageView)findViewById(0x7f0c00ad);
        n.setOnClickListener(r);
        m.setEnabled(false);
        n.setEnabled(false);
        return;
_L4:
        if (obj != null)
        {
            bundle = intent.getExtras();
            h = bundle.getBoolean("isModule");
            i = bundle.getBoolean("isRect");
            j = bundle.getStringArrayList("CollageIds");
            g = true;
            a();
            (new Thread(new Runnable(((String) (obj))) {

                final String a;
                final ProEditMainActivity b;

                public void run()
                {
                    Bitmap bitmap = BitmapFactory.decodeFile(a);
                    b.runOnUiThread(new Runnable(this, bitmap) {

                        final Bitmap a;
                        final _cls1 b;

                        public void run()
                        {
                            b.b.b();
                            b.b.b.setImageBitmap(a);
                            gm.c().a(a, new gp(this) {

                                final _cls1 a;

                                public void a(String s1)
                                {
                                }

            
            {
                a = _pcls1;
                super();
            }
                            });
                        }

            
            {
                b = _pcls1;
                a = bitmap;
                super();
            }
                    });
                }

            
            {
                b = ProEditMainActivity.this;
                a = s1;
                super();
            }
            })).start();
            f = true;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        bundle = gm.c().k();
        b.setImageBitmap(bundle);
        if (true) goto _L6; else goto _L5
_L5:
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f0d0002, menu);
        return true;
    }

    protected void onDestroy()
    {
        super.onDestroy();
        if (e != null)
        {
            e.a(null);
        }
        b.setImageBitmap(null);
        if (isFinishing())
        {
            gm.c().i();
            gm.c().j();
        }
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4)
        {
            if (g)
            {
                a();
                keyevent = new Intent(this, com/fotoable/photocollage/activity/compose2/ComposePhotoesActivity2);
                keyevent.putExtra("CollageIds", j);
                startActivity(keyevent);
                b();
                finish();
                overridePendingTransition(0x7f040016, 0x7f040017);
            } else
            {
                finish();
            }
        }
        return false;
    }

    protected void onPause()
    {
        super.onPause();
    }

    protected void onResume()
    {
        Bitmap bitmap = gm.c().d();
        if (bitmap == null || bitmap != null && bitmap.isRecycled())
        {
            Log.e("ProEditMainActivity", "onResume getDisplayProcessedBitmap");
        }
        super.onResume();
        if (!ew.n(this))
        {
            FotoAdFactory.createAdBanner(this, o);
            return;
        } else
        {
            o.setVisibility(8);
            android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)k.getLayoutParams();
            layoutparams.topMargin = ew.a(this, 50F);
            k.setLayoutParams(layoutparams);
            return;
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
}
