// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.photomanager;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.ebay.app.DialogFragmentCallback;
import com.ebay.mobile.activities.BaseActivity;
import com.ebay.mobile.photomanager.net.UploadPhotoNetLoader;
import com.ebay.mobile.photomanager.net.UploadSiteHostedPicturesResponse;
import com.ebay.nautilus.shell.app.FwLoaderManager;
import com.ebay.nautilus.shell.content.FwLoader;
import java.net.URL;

// Referenced classes of package com.ebay.mobile.photomanager:
//            PhotoManagerFragment, SiteHostedPictureDetails, PhotoManagerViewAdapter

public class PhotoManagerActivity extends BaseActivity
    implements DialogFragmentCallback, PhotoManagerFragment.PhotoManagerHost
{

    private static final String FRAGMENT_TAG = "tag";
    private static final int UPLOADPHOTO_LOADER_ID = 0;
    private PhotoManagerViewAdapter configChangeBackup;
    private boolean isPaused;
    private String urlForUploadedPhoto;

    public PhotoManagerActivity()
    {
        configChangeBackup = null;
        urlForUploadedPhoto = null;
        isPaused = false;
    }

    public PhotoManagerViewAdapter getConfigChangeBackupAdapter()
    {
        PhotoManagerViewAdapter photomanagerviewadapter = configChangeBackup;
        configChangeBackup = null;
        return photomanagerviewadapter;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        if (isPaused)
        {
            return;
        } else
        {
            configuration = getFragmentManager().findFragmentByTag("tag");
            configChangeBackup = ((PhotoManagerFragment)configuration).removeAdapter();
            getFragmentManager().beginTransaction().remove(configuration).commitAllowingStateLoss();
            getFragmentManager().beginTransaction().replace(0x7f1004c1, new PhotoManagerFragment(), "tag").commitAllowingStateLoss();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0301a1);
        ((TextView)findViewById(0x7f1003a5)).setText(0x7f070588);
        findViewById(0x7f1003ab).setVisibility(8);
        View view = findViewById(0x7f1003aa);
        view.setVisibility(0);
        view.setOnClickListener(new android.view.View.OnClickListener() {

            final PhotoManagerActivity this$0;

            public void onClick(View view1)
            {
                finish();
            }

            
            {
                this$0 = PhotoManagerActivity.this;
                super();
            }
        });
        if (bundle == null)
        {
            getFragmentManager().beginTransaction().replace(0x7f1004c1, new PhotoManagerFragment(), "tag").commit();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        return false;
    }

    public void onDialogFragmentResult(DialogFragment dialogfragment, int i, int j)
    {
        if (i == 100 && j == 3)
        {
            getFwLoaderManager().cancelLoader(0, true);
            dialogfragment = (PhotoManagerFragment)getFragmentManager().findFragmentById(0x7f1004c1);
            if (dialogfragment != null)
            {
                dialogfragment.onUploadCanceled();
            }
        }
    }

    public void onPause()
    {
        super.onPause();
        isPaused = true;
    }

    public void onResume()
    {
        super.onResume();
        isPaused = false;
    }

    protected void onTaskComplete(int i, FwLoader fwloader)
    {
label0:
        {
            if (i == 0)
            {
                PhotoManagerFragment.hideProgress(this);
                fwloader = (UploadPhotoNetLoader)fwloader;
                if (fwloader.isError() || fwloader.getResponse() == null)
                {
                    break label0;
                }
                urlForUploadedPhoto = ((UploadSiteHostedPicturesResponse)fwloader.getResponse()).image.fullUrl.toString();
                fwloader = (PhotoManagerFragment)getFragmentManager().findFragmentById(0x7f1004c1);
                if (fwloader != null)
                {
                    fwloader.onUploadComplete();
                }
            }
            return;
        }
        Toast.makeText(this, getString(0x7f07078d), 1).show();
    }

    public void uploadPhoto(UploadPhotoNetLoader uploadphotonetloader)
    {
        getFwLoaderManager().start(0, uploadphotonetloader, true);
    }

    public String urlForUploadedPhoto()
    {
        String s = urlForUploadedPhoto;
        urlForUploadedPhoto = null;
        return s;
    }
}
