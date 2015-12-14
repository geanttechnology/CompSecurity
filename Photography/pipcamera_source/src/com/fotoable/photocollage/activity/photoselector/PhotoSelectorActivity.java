// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photocollage.activity.photoselector;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.net.Uri;
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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.crashlytics.android.Crashlytics;
import com.fotoable.ad.FotoAdFactory;
import com.fotoable.photocollage.activity.compose2.ComposePhotoesActivity2;
import com.fotoable.photoselector.MediaStorePhotosDB;
import com.fotoable.photoselector.MediaStoreScannerService;
import com.fotoable.photoselector.ui.PhotoColletionListFragment;
import com.fotoable.view.actionbar.CommonActionBarView;
import com.pipcamera.activity.FullscreenActivity;
import com.pipcamera.activity.photoselector.CurFragment;
import com.pipcamera.application.PIPCameraApplication;
import ew;
import gb;
import java.util.ArrayList;
import kf;
import ll;
import lm;
import ln;
import mv;
import mz;
import nk;
import nl;
import nr;
import nt;
import ph;

// Referenced classes of package com.fotoable.photocollage.activity.photoselector:
//            PhotoSelectorGridFragment, PhotoSelectScrollFragment

public class PhotoSelectorActivity extends FullscreenActivity
    implements ll, ln, mz, nk, ph
{

    public static String a = "proeditAcitivity";
    ArrayList b;
    ArrayList c;
    PhotoSelectScrollFragment d;
    CommonActionBarView e;
    private lm f;
    private MediaStoreScannerService g;
    private boolean h;
    private ProgressDialog i;
    private CurFragment j;
    private nt k;
    private int l;
    private int m;
    private boolean n;
    private String o;
    private String p;
    private ServiceConnection q;
    private long r;
    private boolean s;
    private long t;
    private boolean u;

    public PhotoSelectorActivity()
    {
        f = null;
        h = false;
        j = CurFragment.folder;
        l = 10;
        m = 1;
        n = false;
        b = new ArrayList(9);
        c = new ArrayList();
        o = null;
        p = "";
        q = new ServiceConnection() {

            final PhotoSelectorActivity a;

            public void onServiceConnected(ComponentName componentname, IBinder ibinder)
            {
                PhotoSelectorActivity.a(a, ((mv)ibinder).a());
                PhotoSelectorActivity.a(a);
                PhotoSelectorActivity.b(a).a(a);
            }

            public void onServiceDisconnected(ComponentName componentname)
            {
                PhotoSelectorActivity.a(a, null);
            }

            
            {
                a = PhotoSelectorActivity.this;
                super();
            }
        };
        r = 2000L;
        s = false;
        u = true;
    }

    static MediaStoreScannerService a(PhotoSelectorActivity photoselectoractivity, MediaStoreScannerService mediastorescannerservice)
    {
        photoselectoractivity.g = mediastorescannerservice;
        return mediastorescannerservice;
    }

    static CurFragment a(PhotoSelectorActivity photoselectoractivity, CurFragment curfragment)
    {
        photoselectoractivity.j = curfragment;
        return curfragment;
    }

    private void a(Uri uri)
    {
        if (uri != null);
    }

    static void a(PhotoSelectorActivity photoselectoractivity)
    {
        photoselectoractivity.h();
    }

    static MediaStoreScannerService b(PhotoSelectorActivity photoselectoractivity)
    {
        return photoselectoractivity.g;
    }

    static void c(PhotoSelectorActivity photoselectoractivity)
    {
        photoselectoractivity.i();
    }

    private void h()
    {
        showDialog(1);
    }

    private void i()
    {
        i = null;
        removeDialog(1);
    }

    public ArrayList a()
    {
        return b;
    }

    public ArrayList a(String s1)
    {
        return k.i();
    }

    public void a(int i1)
    {
        l = i1;
    }

    public void a(Object obj)
    {
        obj = (Integer)obj;
        if (((Integer) (obj)).intValue() < b.size())
        {
            b.remove(((Integer) (obj)).intValue());
        } else
        {
            Log.v("PhotoSelectorActivity", "delete failed");
        }
        if (((Integer) (obj)).intValue() < c.size())
        {
            c.remove(((Integer) (obj)).intValue());
        }
    }

    public void a(String s1, Object obj)
    {
        if (obj instanceof nt)
        {
            k = (nt)obj;
            getSupportFragmentManager().findFragmentByTag("collection");
            getSupportFragmentManager().beginTransaction().hide(getSupportFragmentManager().findFragmentByTag("collection")).commitAllowingStateLoss();
            s1 = getSupportFragmentManager().beginTransaction();
            obj = (PhotoSelectorGridFragment)getSupportFragmentManager().findFragmentByTag("files");
            if (obj == null)
            {
                s1.add(0x7f0c0084, PhotoSelectorGridFragment.a("files"), "files");
            } else
            {
                ((PhotoSelectorGridFragment) (obj)).a(k.i());
                s1.show(((android.support.v4.app.Fragment) (obj)));
            }
            s1.setTransition(4097);
            s1.commitAllowingStateLoss();
            j = CurFragment.files;
            e.setSaveButtomShow(true);
            (new Handler()).post(new Runnable() {

                final PhotoSelectorActivity a;

                public void run()
                {
                }

            
            {
                a = PhotoSelectorActivity.this;
                super();
            }
            });
        }
    }

    public void a(String s1, nl nl)
    {
        if (!(nl instanceof nr)) goto _L2; else goto _L1
_L1:
        if (b.size() < l) goto _L4; else goto _L3
_L3:
        if (o != null)
        {
            Toast.makeText(this, o, 0).show();
        }
_L2:
        return;
_L4:
        s1 = (nr)nl;
        if (l != 1 || n)
        {
            break; /* Loop/switch isn't completed */
        }
        if (p.compareTo(a) == 0)
        {
            a(s1.i());
            return;
        }
        if (true) goto _L2; else goto _L5
_L5:
        if (!s)
        {
            break; /* Loop/switch isn't completed */
        }
        if (u)
        {
            t = System.currentTimeMillis();
            u = false;
            return;
        }
        if (!u && System.currentTimeMillis() - t < r)
        {
            continue; /* Loop/switch isn't completed */
        }
        u = true;
        break; /* Loop/switch isn't completed */
        if (true) goto _L2; else goto _L6
_L6:
        s = true;
        b.add((nr)nl);
        d.a((nr)nl);
        return;
    }

    public void a_(boolean flag)
    {
        runOnUiThread(new Runnable(flag) {

            final boolean a;
            final PhotoSelectorActivity b;

            public void run()
            {
                boolean flag1 = a;
                (new Handler()).post(new Runnable(this, flag1) {

                    final boolean a;
                    final _cls2 b;

                    public void run()
                    {
                        PhotoSelectorActivity.c(b.b);
                        if (a)
                        {
                            PhotoColletionListFragment photocolletionlistfragment = PhotoColletionListFragment.a("collection");
                            FragmentTransaction fragmenttransaction = b.b.getSupportFragmentManager().beginTransaction();
                            fragmenttransaction.add(0x7f0c0084, photocolletionlistfragment, "collection");
                            PhotoSelectorActivity.a(b.b, CurFragment.folder);
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
                b = PhotoSelectorActivity.this;
                a = flag;
                super();
            }
        });
    }

    public ArrayList b(String s1)
    {
        return MediaStorePhotosDB.a().b();
    }

    public void b()
    {
        Intent intent = new Intent(this, com/fotoable/photocollage/activity/compose2/ComposePhotoesActivity2);
        Bundle bundle = new Bundle();
        ArrayList arraylist = new ArrayList(b.size());
        for (int i1 = 0; i1 < b.size(); i1++)
        {
            arraylist.add(((nr)b.get(i1)).i().toString());
        }

        kf.c(String.valueOf(arraylist.size()));
        bundle.putStringArrayList("CollageIds", arraylist);
        intent.putExtras(bundle);
        startActivity(intent);
        if (!gb.g() || ew.m(this) <= ew.a)
        {
            finish();
        }
    }

    public void backBtnClicked(View view)
    {
        onBackPressed();
    }

    public void c()
    {
        s = false;
        u = true;
    }

    void d()
    {
        ComponentName componentname = new ComponentName(this, com/fotoable/photoselector/MediaStoreScannerService);
        Intent intent = new Intent();
        intent.setComponent(componentname);
        bindService(intent, q, 1);
        h = true;
    }

    void e()
    {
        if (h)
        {
            unbindService(q);
            h = false;
        }
    }

    public void f()
    {
        finish();
    }

    protected void finalize()
    {
        super.finalize();
    }

    public void g()
    {
        backBtnClicked(null);
    }

    public void nextBtnClicked(View view)
    {
        finish();
    }

    public void onBackPressed()
    {
        FragmentManager fragmentmanager = getSupportFragmentManager();
        if (j == CurFragment.files)
        {
            FragmentTransaction fragmenttransaction = getSupportFragmentManager().beginTransaction();
            fragmenttransaction.show(fragmentmanager.findFragmentByTag("collection"));
            fragmenttransaction.setTransition(4097);
            fragmenttransaction.commitAllowingStateLoss();
            getSupportFragmentManager().beginTransaction().hide(getSupportFragmentManager().findFragmentByTag("files")).commitAllowingStateLoss();
            j = CurFragment.folder;
            e.setSaveButtomShow(false);
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
        setContentView(0x7f03001e);
        if (getIntent() != null)
        {
            a(getIntent().getIntExtra("PhotoMaxCount", l));
            if (getIntent().hasExtra("desActicityName"))
            {
                p = getIntent().getStringExtra("desActicityName");
            }
        }
        e = (CommonActionBarView)findViewById(0x7f0c0081);
        e.setActionBarTitle(getResources().getString(0x7f060030));
        e.setSaveTitle(getResources().getString(0x7f060033));
        e.setSaveButtomShow(false);
        e.setOnAcceptListener(this);
        d = (PhotoSelectScrollFragment)getSupportFragmentManager().findFragmentById(0x7f0c0083);
        d.a(l);
        if (l == 1)
        {
            bundle = (LinearLayout)findViewById(0x7f0c0082);
            if (bundle != null)
            {
                bundle.setVisibility(8);
            }
        }
        d();
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
        i = progressdialog;
        return progressdialog;
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        return super.onCreateOptionsMenu(menu);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        b.clear();
        e();
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
