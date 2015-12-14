// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector.activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import com.fotoable.photoselector.MediaStorePhotosDB;
import com.fotoable.photoselector.MediaStoreScannerService;
import com.fotoable.photoselector.ui.PhotoColletionListFragment;
import java.io.PrintStream;
import java.util.ArrayList;
import mv;
import mz;
import nd;
import ne;
import ng;
import nk;
import nl;
import nr;
import nt;

// Referenced classes of package com.fotoable.photoselector.activity:
//            PhotoSelectorGridFragment, PhotoSelectScrollFragment, CommonActionBarView

public class PhotoSelectorActivity extends FragmentActivity
    implements mz, nd, ne, ng, nk
{

    public ArrayList a;
    PhotoSelectScrollFragment b;
    CommonActionBarView c;
    private MediaStoreScannerService d;
    private boolean e;
    private ProgressDialog f;
    private int g;
    private int h;
    private String i;
    private CurFragment j;
    private nt k;
    private ServiceConnection l;
    private long m;
    private boolean n;
    private long o;
    private boolean p;

    public PhotoSelectorActivity()
    {
        e = false;
        g = 1;
        h = 5;
        i = null;
        j = CurFragment.folder;
        a = new ArrayList(10);
        l = new ServiceConnection() {

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
        m = 2000L;
        n = false;
        p = true;
    }

    static MediaStoreScannerService a(PhotoSelectorActivity photoselectoractivity, MediaStoreScannerService mediastorescannerservice)
    {
        photoselectoractivity.d = mediastorescannerservice;
        return mediastorescannerservice;
    }

    static CurFragment a(PhotoSelectorActivity photoselectoractivity, CurFragment curfragment)
    {
        photoselectoractivity.j = curfragment;
        return curfragment;
    }

    static void a(PhotoSelectorActivity photoselectoractivity)
    {
        photoselectoractivity.k();
    }

    static MediaStoreScannerService b(PhotoSelectorActivity photoselectoractivity)
    {
        return photoselectoractivity.d;
    }

    static void c(PhotoSelectorActivity photoselectoractivity)
    {
        photoselectoractivity.l();
    }

    private void k()
    {
        showDialog(1);
    }

    private void l()
    {
        f = null;
        removeDialog(1);
    }

    public ArrayList a(String s)
    {
        return k.i();
    }

    public void a()
    {
    }

    public void a(int i1)
    {
        g = i1;
    }

    public void a(Object obj)
    {
        obj = (Integer)obj;
        if (((Integer) (obj)).intValue() < a.size())
        {
            a.remove(((Integer) (obj)).intValue());
            return;
        } else
        {
            Log.v("PhotoSelectorActivity", "delete failed");
            return;
        }
    }

    public void a(String s, Object obj)
    {
        if (obj instanceof nt)
        {
            k = (nt)obj;
            getSupportFragmentManager().findFragmentByTag("collection");
            getSupportFragmentManager().beginTransaction().hide(getSupportFragmentManager().findFragmentByTag("collection")).commitAllowingStateLoss();
            s = getSupportFragmentManager().beginTransaction();
            obj = (PhotoSelectorGridFragment)getSupportFragmentManager().findFragmentByTag("files");
            if (obj == null)
            {
                obj = PhotoSelectorGridFragment.a("files");
                s.add(com.fotoable.fotophotoselector.R.id.encryptActivityContent, ((android.support.v4.app.Fragment) (obj)), "files");
            } else
            {
                ((PhotoSelectorGridFragment) (obj)).a(k.i());
                s.show(((android.support.v4.app.Fragment) (obj)));
            }
            s.setTransition(4097);
            s.commitAllowingStateLoss();
            j = CurFragment.files;
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

    public void a(String s, nl nl)
    {
        if (!(nl instanceof nr)) goto _L2; else goto _L1
_L1:
        if (a.size() < h) goto _L4; else goto _L3
_L3:
        if (i != null)
        {
            Toast.makeText(this, i, 0).show();
        }
_L2:
        return;
_L4:
        if (!n)
        {
            break; /* Loop/switch isn't completed */
        }
        if (p)
        {
            o = System.currentTimeMillis();
            p = false;
            return;
        }
        if (!p && System.currentTimeMillis() - o < m)
        {
            continue; /* Loop/switch isn't completed */
        }
        p = true;
        break; /* Loop/switch isn't completed */
        if (true) goto _L2; else goto _L5
_L5:
        n = true;
        a.add((nr)nl);
        b.a((nr)nl);
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
                        if (a && !b.b.isFinishing())
                        {
                            PhotoColletionListFragment photocolletionlistfragment = PhotoColletionListFragment.a("collection");
                            FragmentTransaction fragmenttransaction = b.b.getSupportFragmentManager().beginTransaction();
                            fragmenttransaction.add(com.fotoable.fotophotoselector.R.id.encryptActivityContent, photocolletionlistfragment, "collection");
                            PhotoSelectorActivity.a(b.b, CurFragment.folder);
                            fragmenttransaction.commitAllowingStateLoss();
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

    public ArrayList b(String s)
    {
        return MediaStorePhotosDB.a().b();
    }

    public void b()
    {
        backBtnClicked(null);
    }

    public void b(int i1)
    {
        h = i1;
    }

    public void backBtnClicked(View view)
    {
        onBackPressed();
    }

    public ArrayList c()
    {
        return a;
    }

    public void c(String s)
    {
        if (b != null)
        {
            b.a(s);
        }
    }

    public void d()
    {
    }

    public void d(String s)
    {
        i = s;
    }

    public void e()
    {
        n = false;
        p = true;
    }

    void f()
    {
        ComponentName componentname = new ComponentName(this, com/fotoable/photoselector/MediaStoreScannerService);
        Intent intent = new Intent();
        intent.setComponent(componentname);
        bindService(intent, l, 1);
        e = true;
    }

    protected void finalize()
    {
        super.finalize();
    }

    void g()
    {
        if (e)
        {
            unbindService(l);
            e = false;
        }
    }

    public ArrayList h()
    {
        ArrayList arraylist = new ArrayList(a.size());
        for (int i1 = 0; i1 < a.size(); i1++)
        {
            arraylist.add(((nr)a.get(i1)).i());
        }

        return arraylist;
    }

    public int i()
    {
        return g;
    }

    public int j()
    {
        return h;
    }

    public void nextBtnClicked(View view)
    {
        System.out.println("test");
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
        setContentView(com.fotoable.fotophotoselector.R.layout.activity_photoselector_mine);
        c = (CommonActionBarView)findViewById(com.fotoable.fotophotoselector.R.id.actionBarView);
        c.setActionBarTitle(getResources().getString(com.fotoable.fotophotoselector.R.string.album_choose));
        c.setIsNextButtonShow(false);
        c.setOnAcceptListener(this);
        b = (PhotoSelectScrollFragment)getSupportFragmentManager().findFragmentById(com.fotoable.fotophotoselector.R.id.photo_fragment);
        f();
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
        progressdialog.setMessage("Loading...");
        progressdialog.setIndeterminate(true);
        progressdialog.setCancelable(false);
        f = progressdialog;
        return progressdialog;
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        return super.onCreateOptionsMenu(menu);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        g();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        return super.onOptionsItemSelected(menuitem);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
    }

    public void onStop()
    {
        super.onStop();
    }

    private class CurFragment extends Enum
    {

        private static final CurFragment $VALUES[];
        public static final CurFragment files;
        public static final CurFragment folder;

        public static CurFragment valueOf(String s)
        {
            return (CurFragment)Enum.valueOf(com/fotoable/photoselector/activity/PhotoSelectorActivity$CurFragment, s);
        }

        public static CurFragment[] values()
        {
            return (CurFragment[])$VALUES.clone();
        }

        static 
        {
            folder = new CurFragment("folder", 0);
            files = new CurFragment("files", 1);
            $VALUES = (new CurFragment[] {
                folder, files
            });
        }

        private CurFragment(String s, int i1)
        {
            super(s, i1);
        }
    }

}
