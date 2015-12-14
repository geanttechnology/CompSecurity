// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.ResourceOnlineLibrary.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.fotoable.ad.FotoAdFactory;
import com.pipcamera.activity.FullscreenActivity;
import com.pipcamera.activity.pip.Pip2FragmentActivity;
import com.pipcamera.activity.pip.PipFreeStyleActivity;
import com.pipcamera.activity.pip.PipStyleActivity;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.ResourceOnlineLibrary.Manage.ManageOnlineFragement;
import com.wantu.ResourceOnlineLibrary.Types.MaterialTypeFragement;
import com.wantu.model.res.TResInfo;
import com.wantu.model.res.pip.TDFSceneInfo;
import com.wantu.piprender.ESceneMode;
import java.util.ArrayList;
import pb;
import ts;
import tu;
import tz;
import uj;
import un;

// Referenced classes of package com.wantu.ResourceOnlineLibrary.activity:
//            MaterialDownloadFragment, MaterialListFragement

public class MainResourceActivity extends FullscreenActivity
{

    public static int a = 1;
    public static int b = 2;
    public static int e = 1558;
    static int f = 1559;
    RelativeLayout c;
    un d;
    private Button g;
    private ProgressDialog h;
    private ArrayList i;
    private ProgressBar j;

    public MainResourceActivity()
    {
        i = null;
    }

    private void a(Uri uri)
    {
        Object obj = d.a();
        if (obj == ESceneMode.SCENE_MODE1)
        {
            FlurryAgent.logEvent("pipmodel1BtnClicked");
            obj = new Intent(this, com/pipcamera/activity/pip/PipStyleActivity);
            ((Intent) (obj)).putExtra("SelectedImageUri", uri.toString());
            ((Intent) (obj)).putExtra("defaultIndex", 0);
            startActivity(((Intent) (obj)));
            finish();
        } else
        {
            if (obj == ESceneMode.SCENE_MODE2)
            {
                FlurryAgent.logEvent("pipmodel2BtnClicked");
                obj = new Intent(this, com/pipcamera/activity/pip/Pip2FragmentActivity);
                ((Intent) (obj)).putExtra("SelectedImageUri", uri.toString());
                ((Intent) (obj)).putExtra("defaultIndex", 0);
                startActivity(((Intent) (obj)));
                finish();
                return;
            }
            if (obj == ESceneMode.SCENE_MODE3)
            {
                FlurryAgent.logEvent("pipmodel3BtnClicked");
                Intent intent = new Intent(this, com/pipcamera/activity/pip/PipFreeStyleActivity);
                intent.putExtra("SelectedImageUri", uri.toString());
                startActivity(intent);
                return;
            }
        }
    }

    protected void a()
    {
        try
        {
            FotoAdFactory.createAdBanner(this, findViewById(0x1020002));
            return;
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
        }
    }

    public void a(TResInfo tresinfo, EOnlineResType eonlinerestype)
    {
        uj uj1 = new uj();
        uj1.d = eonlinerestype;
        d = new un(this);
        eonlinerestype = ts.a(uj1.d);
        eonlinerestype.setMaterialType(uj1);
        eonlinerestype.setoperationDelegate(d);
        eonlinerestype.update();
        if (getSupportFragmentManager().getBackStackEntryCount() > 0)
        {
            FragmentTransaction fragmenttransaction = getSupportFragmentManager().beginTransaction();
            tresinfo = MaterialDownloadFragment.a(eonlinerestype, tresinfo);
            fragmenttransaction.setCustomAnimations(0x7f040014, 0x7f040015, 0x7f040016, 0x7f040017);
            fragmenttransaction.replace(0x7f0c007b, tresinfo);
            fragmenttransaction.addToBackStack(null);
            fragmenttransaction.commitAllowingStateLoss();
            return;
        } else
        {
            tresinfo = MaterialDownloadFragment.a(eonlinerestype, tresinfo);
            getSupportFragmentManager().beginTransaction().add(0x7f0c007b, tresinfo).commit();
            return;
        }
    }

    public void a(Boolean boolean1)
    {
        Button button = g;
        int k;
        if (boolean1.booleanValue())
        {
            k = 0;
        } else
        {
            k = 4;
        }
        button.setVisibility(k);
    }

    public void a(String s, int k)
    {
        if (k != e) goto _L2; else goto _L1
_L1:
        if (h != null) goto _L4; else goto _L3
_L3:
        h = ProgressDialog.show(this, "", s);
        h.setCancelable(true);
        h.setCanceledOnTouchOutside(true);
        h.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final MainResourceActivity a;

            public void onCancel(DialogInterface dialoginterface)
            {
                a.f();
            }

            
            {
                a = MainResourceActivity.this;
                super();
            }
        });
_L6:
        return;
_L4:
        h.show();
        return;
_L2:
        if (j != null)
        {
            j.setVisibility(0);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void a(uj uj1)
    {
        if (getSupportFragmentManager().getBackStackEntryCount() < 1)
        {
            FragmentTransaction fragmenttransaction = getSupportFragmentManager().beginTransaction();
            uj1 = MaterialListFragement.a(uj1);
            fragmenttransaction.setCustomAnimations(0x7f040014, 0x7f040015, 0x7f040016, 0x7f040017);
            fragmenttransaction.replace(0x7f0c007b, uj1);
            fragmenttransaction.addToBackStack(null);
            fragmenttransaction.commitAllowingStateLoss();
            a(Boolean.valueOf(false));
        }
    }

    public ArrayList b()
    {
        if (i == null)
        {
            i = new ArrayList(2);
            i.add("PIP_SCENE");
            i.add("PIP_SCENE2");
        }
        return i;
    }

    public void backBtnClicked(View view)
    {
        c();
    }

    public void c()
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
            overridePendingTransition(0x10a0002, 0x10a0003);
            super.onBackPressed();
            System.gc();
            return;
        }
    }

    public void d()
    {
        if (getSupportFragmentManager().getBackStackEntryCount() < 1)
        {
            FragmentTransaction fragmenttransaction = getSupportFragmentManager().beginTransaction();
            ManageOnlineFragement manageonlinefragement = new ManageOnlineFragement();
            fragmenttransaction.setCustomAnimations(0x7f040014, 0x7f040015, 0x7f040016, 0x7f040017);
            fragmenttransaction.replace(0x7f0c007b, manageonlinefragement);
            fragmenttransaction.addToBackStack(null);
            fragmenttransaction.commitAllowingStateLoss();
            a(Boolean.valueOf(false));
        }
    }

    public void e()
    {
        if (h != null)
        {
            h.hide();
        }
        if (j != null)
        {
            j.setVisibility(4);
        }
    }

    protected void f()
    {
        tz.a().b();
    }

    public void g()
    {
    }

    protected void onActivityResult(int k, int l, Intent intent)
    {
        Object obj;
        if (l != -1)
        {
            return;
        }
        Log.v("resultCode", String.valueOf(l));
        Log.v("requestCode", String.valueOf(k));
        obj = null;
        k;
        JVM INSTR tableswitch 3021 3021: default 52
    //                   3021 61;
           goto _L1 _L2
_L1:
        intent = obj;
_L4:
        a(intent);
        return;
_L2:
        if (intent == null)
        {
            Toast.makeText(this, "Load photo from gallery failed", 1).show();
            return;
        }
        intent = intent.getData();
        Log.v("url", intent.toString());
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(0x7f03001c);
        j = (ProgressBar)findViewById(0x7f0c007c);
        Object obj = getIntent();
        bundle = ((Intent) (obj)).getStringExtra("name");
        int k = ((Intent) (obj)).getIntExtra("scene_mode", 0);
        String s = ((Intent) (obj)).getStringExtra("previewUrl");
        g = (Button)findViewById(0x7f0c0080);
        if (!pb.a())
        {
            g.setTextSize(14F);
        }
        if (bundle != null && s != null)
        {
            g.setVisibility(4);
            obj = new TDFSceneInfo();
            ((TDFSceneInfo) (obj)).setName(bundle);
            bundle = EOnlineResType.PIP_SCENE;
            if (k == a)
            {
                ((TDFSceneInfo) (obj)).setMode(ESceneMode.SCENE_MODE1);
            } else
            if (k == b)
            {
                ((TDFSceneInfo) (obj)).setMode(ESceneMode.SCENE_MODE2);
                bundle = EOnlineResType.PIP_SCENE2;
            }
            obj.previewUrl = s;
            a(((TResInfo) (obj)), bundle);
        } else
        {
            if (obj != null)
            {
                i = ((Intent) (obj)).getStringArrayListExtra("MainResourceActivity_MaterialTypes");
            }
            bundle = new MaterialTypeFragement();
            getSupportFragmentManager().beginTransaction().add(0x7f0c007b, bundle).commit();
            g.setText(getResources().getString(0x7f060153));
            g.setOnClickListener(new android.view.View.OnClickListener() {

                final MainResourceActivity a;

                public void onClick(View view)
                {
                    a.d();
                }

            
            {
                a = MainResourceActivity.this;
                super();
            }
            });
        }
        c = (RelativeLayout)findViewById(0x7f0c0079);
        a();
    }

    protected void onDestroy()
    {
        if (h != null)
        {
            h.dismiss();
            h = null;
        }
        super.onDestroy();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
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
