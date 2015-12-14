// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.activity.photoselector;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.Toast;
import arj;
import asn;
import aso;
import asx;
import asz;
import bjr;
import bjs;
import bjt;
import bjv;
import com.flurry.android.FlurryAgent;
import com.fotoable.ad.ApplicationState;
import com.fotoable.ad.FotoAdFactory;
import com.fotoable.photoselector.MediaStorePhotosDB;
import com.fotoable.photoselector.MediaStoreScannerService;
import java.io.File;
import java.util.ArrayList;
import yp;

// Referenced classes of package com.wantu.activity.photoselector:
//            PhotoSelectorGridFragment

public class SinglePhotoSelectorActivity extends FragmentActivity
    implements arj, asn, bjr
{

    private static final File f = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/DCIM/Camera").toString());
    private MediaStoreScannerService a;
    private boolean b;
    private ProgressDialog c;
    private CurFragment d;
    private asz e;
    private File g;
    private Intent h;
    private ServiceConnection i;

    public SinglePhotoSelectorActivity()
    {
        b = false;
        d = CurFragment.folder;
        h = null;
        i = new bjs(this);
    }

    public static MediaStoreScannerService a(SinglePhotoSelectorActivity singlephotoselectoractivity, MediaStoreScannerService mediastorescannerservice)
    {
        singlephotoselectoractivity.a = mediastorescannerservice;
        return mediastorescannerservice;
    }

    public static CurFragment a(SinglePhotoSelectorActivity singlephotoselectoractivity, CurFragment curfragment)
    {
        singlephotoselectoractivity.d = curfragment;
        return curfragment;
    }

    public static void a(SinglePhotoSelectorActivity singlephotoselectoractivity)
    {
        singlephotoselectoractivity.d();
    }

    public static MediaStoreScannerService b(SinglePhotoSelectorActivity singlephotoselectoractivity)
    {
        return singlephotoselectoractivity.a;
    }

    public static void c(SinglePhotoSelectorActivity singlephotoselectoractivity)
    {
        singlephotoselectoractivity.e();
    }

    private void d()
    {
        showDialog(1);
    }

    private void e()
    {
        c = null;
        removeDialog(1);
    }

    public void CameraBtnClicked(View view)
    {
        c();
    }

    public ArrayList a(String s)
    {
        return e.i();
    }

    void a()
    {
        ComponentName componentname = new ComponentName(this, com/fotoable/photoselector/MediaStoreScannerService);
        Intent intent = new Intent();
        intent.setComponent(componentname);
        bindService(intent, i, 1);
        b = true;
    }

    protected void a(int j, int k, Intent intent)
    {
        Intent intent1;
        try
        {
            intent = Uri.fromFile(new File((new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/.tmp/capture.jpg").toString()));
            Log.v("url", intent.toString());
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            setResult(0, null);
            finish();
            return;
        }
        if (intent == null)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        intent1 = new Intent();
        intent1.setData(intent);
        setResult(-1, intent1);
        finish();
        return;
    }

    public void a(String s, aso aso)
    {
        if (aso instanceof asx)
        {
            s = ((asx)aso).i();
            aso = new Intent();
            aso.setData(s);
            setResult(-1, aso);
            finish();
        }
    }

    public void a(String s, Object obj)
    {
        if (obj instanceof asz)
        {
            e = (asz)obj;
            getSupportFragmentManager().findFragmentByTag("collection");
            getSupportFragmentManager().beginTransaction().hide(getSupportFragmentManager().findFragmentByTag("collection")).commitAllowingStateLoss();
            s = getSupportFragmentManager().beginTransaction();
            obj = (PhotoSelectorGridFragment)getSupportFragmentManager().findFragmentByTag("files");
            if (obj == null)
            {
                s.add(0x7f0d010d, PhotoSelectorGridFragment.a("files"), "files");
            } else
            {
                ((PhotoSelectorGridFragment) (obj)).a(e.i());
                s.show(((android.support.v4.app.Fragment) (obj)));
            }
            s.setTransition(4097);
            s.commitAllowingStateLoss();
            d = CurFragment.files;
            (new Handler()).post(new bjv(this));
        }
    }

    public void a(boolean flag)
    {
        runOnUiThread(new bjt(this, flag));
    }

    public ArrayList b(String s)
    {
        return MediaStorePhotosDB.a().b();
    }

    void b()
    {
        if (b)
        {
            unbindService(i);
            b = false;
        }
    }

    public void backBtnClicked(View view)
    {
        onBackPressed();
    }

    protected void c()
    {
        if ("mounted".equals(Environment.getExternalStorageState()))
        {
            Object obj = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/.tmp/").toString());
            ((File) (obj)).mkdirs();
            g = new File(((File) (obj)), "capture.jpg");
            obj = Uri.fromFile(g);
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            intent.putExtra("output", ((android.os.Parcelable) (obj)));
            intent.putExtra("output", ((android.os.Parcelable) (obj)));
            startActivityForResult(intent, 3023);
            return;
        }
        try
        {
            (new android.app.AlertDialog.Builder(this)).setMessage(getResources().getString(0x7f060195)).setCancelable(true).create().show();
            return;
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            Toast.makeText(this, 0x7f0601a9, 1).show();
        }
        return;
    }

    protected void finalize()
    {
        super.finalize();
    }

    protected void onActivityResult(int j, int k, Intent intent)
    {
        if (k == -1)
        {
            switch (j)
            {
            default:
                return;

            case 3023: 
                a(j, k, intent);
                break;
            }
            return;
        } else
        {
            Log.v("SinglePhotoSelectorActivity", "camera failed");
            return;
        }
    }

    public void onBackPressed()
    {
        FragmentManager fragmentmanager = getSupportFragmentManager();
        if (d == CurFragment.files)
        {
            FragmentTransaction fragmenttransaction = getSupportFragmentManager().beginTransaction();
            fragmenttransaction.show(fragmentmanager.findFragmentByTag("collection"));
            fragmenttransaction.setTransition(4097);
            fragmenttransaction.commitAllowingStateLoss();
            getSupportFragmentManager().beginTransaction().hide(getSupportFragmentManager().findFragmentByTag("files")).commitAllowingStateLoss();
            d = CurFragment.folder;
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
        setContentView(0x7f03003d);
        a();
    }

    protected Dialog onCreateDialog(int j)
    {
        ProgressDialog progressdialog;
        switch (j)
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
        c = progressdialog;
        return progressdialog;
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        return super.onCreateOptionsMenu(menu);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        b();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        return super.onOptionsItemSelected(menuitem);
    }

    public void onResume()
    {
        super.onResume();
        FlurryAgent.onPageView();
        Log.v("SinglePhotoSelectorActivity", "onResume");
        if (!yp.m(this))
        {
            RelativeLayout relativelayout = (RelativeLayout)findViewById(0x7f0d00b0);
            relativelayout.setVisibility(0);
            FotoAdFactory.createAdBanner(this, relativelayout);
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
    }

    protected void onStart()
    {
        super.onStart();
        FlurryAgent.onStartSession(this, "J3DP5Q6Y48C3GPJXV4X3");
        ApplicationState.checkAppStateAfterOnStart();
    }

    public void onStop()
    {
        super.onStop();
        FlurryAgent.onEndSession(this);
        ApplicationState.checkAppStateAfterOnStop();
    }


    private class CurFragment extends Enum
    {

        private static final CurFragment $VALUES[];
        public static final CurFragment files;
        public static final CurFragment folder;

        public static CurFragment valueOf(String s)
        {
            return (CurFragment)Enum.valueOf(com/wantu/activity/photoselector/SinglePhotoSelectorActivity$CurFragment, s);
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

        private CurFragment(String s, int j)
        {
            super(s, j);
        }
    }

}
