// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.photoselector;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import com.crashlytics.android.Crashlytics;
import com.fotoable.ad.FotoAdFactory;
import com.fotoable.photoselector.MediaStorePhotosDB;
import com.fotoable.photoselector.MediaStoreScannerService;
import com.fotoable.photoselector.ui.PhotoColletionListFragment;
import com.pipcamera.activity.FullscreenActivity;
import com.pipcamera.application.PIPCameraApplication;
import ew;
import java.util.ArrayList;
import mv;
import mz;
import nk;
import nl;
import nr;
import nt;
import ss;
import st;
import su;

// Referenced classes of package com.pipcamera.activity.photoselector:
//            CurFragment, PhotoSelectorGridFragment, PipCommonActionBarView

public class SinglePhotoSelectorActivity extends FullscreenActivity
    implements mz, nk, ss, st
{

    ArrayList a;
    ArrayList b;
    PipCommonActionBarView c;
    private su d;
    private MediaStoreScannerService e;
    private boolean f;
    private ProgressDialog g;
    private CurFragment h;
    private nt i;
    private boolean j;
    private String k;
    private String l;
    private boolean m;
    private ServiceConnection n;

    public SinglePhotoSelectorActivity()
    {
        d = null;
        f = false;
        h = CurFragment.folder;
        j = false;
        a = new ArrayList(9);
        b = new ArrayList();
        k = null;
        l = "";
        m = false;
        n = new ServiceConnection() {

            final SinglePhotoSelectorActivity a;

            public void onServiceConnected(ComponentName componentname, IBinder ibinder)
            {
                SinglePhotoSelectorActivity.a(a, ((mv)ibinder).a());
                SinglePhotoSelectorActivity.a(a);
                SinglePhotoSelectorActivity.b(a).a(a);
            }

            public void onServiceDisconnected(ComponentName componentname)
            {
                SinglePhotoSelectorActivity.a(a, null);
            }

            
            {
                a = SinglePhotoSelectorActivity.this;
                super();
            }
        };
    }

    static MediaStoreScannerService a(SinglePhotoSelectorActivity singlephotoselectoractivity, MediaStoreScannerService mediastorescannerservice)
    {
        singlephotoselectoractivity.e = mediastorescannerservice;
        return mediastorescannerservice;
    }

    static CurFragment a(SinglePhotoSelectorActivity singlephotoselectoractivity, CurFragment curfragment)
    {
        singlephotoselectoractivity.h = curfragment;
        return curfragment;
    }

    static void a(SinglePhotoSelectorActivity singlephotoselectoractivity)
    {
        singlephotoselectoractivity.e();
    }

    static MediaStoreScannerService b(SinglePhotoSelectorActivity singlephotoselectoractivity)
    {
        return singlephotoselectoractivity.e;
    }

    static void c(SinglePhotoSelectorActivity singlephotoselectoractivity)
    {
        singlephotoselectoractivity.f();
    }

    static boolean d(SinglePhotoSelectorActivity singlephotoselectoractivity)
    {
        return singlephotoselectoractivity.m;
    }

    private void e()
    {
        showDialog(1);
    }

    private void f()
    {
        g = null;
        removeDialog(1);
    }

    public ArrayList a(String s)
    {
        return i.i();
    }

    public void a()
    {
        finish();
    }

    public void a(String s, Object obj)
    {
        while (m || !(obj instanceof nt)) 
        {
            return;
        }
        i = (nt)obj;
        getSupportFragmentManager().findFragmentByTag("collection");
        getSupportFragmentManager().beginTransaction().hide(getSupportFragmentManager().findFragmentByTag("collection")).commitAllowingStateLoss();
        s = getSupportFragmentManager().beginTransaction();
        obj = (PhotoSelectorGridFragment)getSupportFragmentManager().findFragmentByTag("files");
        if (obj == null)
        {
            s.add(0x7f0c0084, PhotoSelectorGridFragment.a("files"), "files");
        } else
        {
            ((PhotoSelectorGridFragment) (obj)).a(i.i());
            s.show(((android.support.v4.app.Fragment) (obj)));
        }
        s.setTransition(4097);
        s.commitAllowingStateLoss();
        h = CurFragment.files;
        c.setSaveButtomShow(true);
    }

    public void a(String s, nl nl)
    {
        if (nl instanceof nr)
        {
            s = ((nr)nl).i();
            nl = new Intent();
            nl.setData(s);
            setResult(-1, nl);
            finish();
        }
    }

    public void a_(boolean flag)
    {
        runOnUiThread(new Runnable(flag) {

            final boolean a;
            final SinglePhotoSelectorActivity b;

            public void run()
            {
                boolean flag1 = a;
                (new Handler()).post(new Runnable(this, flag1) {

                    final boolean a;
                    final _cls2 b;

                    public void run()
                    {
                        SinglePhotoSelectorActivity.c(b.b);
                        if (a && !SinglePhotoSelectorActivity.d(b.b))
                        {
                            PhotoColletionListFragment photocolletionlistfragment = PhotoColletionListFragment.a("collection");
                            FragmentTransaction fragmenttransaction = b.b.getSupportFragmentManager().beginTransaction();
                            fragmenttransaction.add(0x7f0c0084, photocolletionlistfragment, "collection");
                            SinglePhotoSelectorActivity.a(b.b, CurFragment.folder);
                            try
                            {
                                fragmenttransaction.commitAllowingStateLoss();
                                return;
                            }
                            catch (Exception exception)
                            {
                                Crashlytics.logException(exception);
                            }
                            return;
                        } else
                        {
                            Log.e("PhotoSelectorActivity", "Load media data failed");
                            return;
                        }
                    }

            
            {
                b = _pcls2;
                a = flag;
                super();
            }
                });
            }

            
            {
                b = SinglePhotoSelectorActivity.this;
                a = flag;
                super();
            }
        });
    }

    public ArrayList b(String s)
    {
        return MediaStorePhotosDB.a().b();
    }

    public void b()
    {
        backBtnClicked(null);
    }

    public void backBtnClicked(View view)
    {
        onBackPressed();
    }

    void c()
    {
        ComponentName componentname = new ComponentName(this, com/fotoable/photoselector/MediaStoreScannerService);
        Intent intent = new Intent();
        intent.setComponent(componentname);
        bindService(intent, n, 1);
        f = true;
    }

    void d()
    {
        if (f)
        {
            unbindService(n);
            f = false;
        }
    }

    protected void finalize()
    {
        super.finalize();
    }

    public void nextBtnClicked(View view)
    {
        finish();
    }

    public void onBackPressed()
    {
        if (m)
        {
            return;
        }
        FragmentManager fragmentmanager = getSupportFragmentManager();
        if (h == CurFragment.files)
        {
            FragmentTransaction fragmenttransaction = getSupportFragmentManager().beginTransaction();
            fragmenttransaction.show(fragmentmanager.findFragmentByTag("collection"));
            fragmenttransaction.setTransition(4097);
            fragmenttransaction.commitAllowingStateLoss();
            getSupportFragmentManager().beginTransaction().hide(getSupportFragmentManager().findFragmentByTag("files")).commitAllowingStateLoss();
            h = CurFragment.folder;
            c.setSaveButtomShow(false);
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(0x7f03002b);
        c = (PipCommonActionBarView)findViewById(0x7f0c0081);
        c.setActionBarTitle(getResources().getString(0x7f060030));
        c.setSaveTitle(getResources().getString(0x7f060033));
        c.setSaveButtomShow(false);
        c.setOnAcceptListener(this);
        c();
    }

    protected Dialog onCreateDialog(int i1)
    {
        ProgressDialog progressdialog;
        switch (i1)
        {
        default:
            return null;

        case 1: // '\001'
            progressdialog = new ProgressDialog(this);
            break;
        }
        progressdialog.setMessage(PIPCameraApplication.a.getString(0x7f0601a4));
        progressdialog.setIndeterminate(true);
        progressdialog.setCancelable(false);
        g = progressdialog;
        return progressdialog;
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        return super.onCreateOptionsMenu(menu);
    }

    protected void onDestroy()
    {
        m = true;
        super.onDestroy();
        a.clear();
        d();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        return super.onOptionsItemSelected(menuitem);
    }

    protected void onResume()
    {
        super.onResume();
        Log.v("PhotoSelectorActivity", "PhotoSelectorActivity onResume");
        if (!ew.n(this))
        {
            RelativeLayout relativelayout = (RelativeLayout)findViewById(0x7f0c0055);
            relativelayout.setVisibility(0);
            FotoAdFactory.createAdBanner(this, relativelayout);
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
    }

    public void onStop()
    {
        super.onStop();
    }
}
