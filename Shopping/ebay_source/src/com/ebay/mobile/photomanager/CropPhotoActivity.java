// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.photomanager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.ebay.mobile.activities.CoreActivity;
import com.ebay.mobile.photomanager.android.CropImageView;
import com.ebay.nautilus.kernel.util.FwLog;
import com.ebay.nautilus.shell.app.FwLoaderManager;
import com.ebay.nautilus.shell.content.FwLoader;

// Referenced classes of package com.ebay.mobile.photomanager:
//            SaveImageLoader, TemporaryFileManager, LoadImageLoader

public class CropPhotoActivity extends CoreActivity
    implements android.view.View.OnClickListener
{

    private static final int LOAD_IMAGE_LOADER_ID = 1;
    private static final int SAVE_IMAGE_LOADER_ID = 2;
    private static final String STATE_PHOTO_URI = "uri";
    private static final String STATE_TEMP_FILES = "temp_files";
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo log = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("cropper", 3, "Log photo cropper");
    String TAG;
    private CropImageView cropImageView;
    private boolean cropImageViewInitialized;
    private Runnable enableClick;
    private final Handler enableClickHandler = new Handler();
    private boolean shouldHandleClick;
    Uri uri;

    public CropPhotoActivity()
    {
        cropImageViewInitialized = false;
        shouldHandleClick = true;
        enableClick = new Runnable() {

            final CropPhotoActivity this$0;

            public void run()
            {
                shouldHandleClick = true;
            }

            
            {
                this$0 = CropPhotoActivity.this;
                super();
            }
        };
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR lookupswitch 3: default 40
    //                   2131755947: 122
    //                   2131756217: 104
    //                   2131756218: 41;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L4:
        if (shouldHandleClick)
        {
            shouldHandleClick = false;
            enableClickHandler.postDelayed(enableClick, 1000L);
            if (cropImageViewInitialized)
            {
                cropImageView.cropForSave();
                getFwLoaderManager().start(2, new SaveImageLoader(this, cropImageView), true);
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (cropImageViewInitialized)
        {
            cropImageView.rotate(com.ebay.mobile.photomanager.android.CropImageView.Direction.RIGHT);
            return;
        }
        if (true) goto _L1; else goto _L2
_L2:
        finish();
        return;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        TAG = getClass().getSimpleName();
        if (bundle != null)
        {
            Log.w(TAG, "Activity was restarted");
            uri = Uri.parse(bundle.getString("uri"));
            TemporaryFileManager.instance.init(bundle.getStringArrayList("temp_files"));
        } else
        {
            uri = getIntent().getData();
        }
        setTitle(null);
        setContentView(0x7f03019f);
        cropImageView = (CropImageView)findViewById(0x7f1004bb);
        cropImageView.setVisibility(0);
        bundle = new LoadImageLoader(this, getContentResolver(), uri, cropImageView.latch);
        getFwLoaderManager().start(1, bundle, true);
        findViewById(0x7f1004ba).setOnClickListener(this);
        findViewById(0x7f1004b9).setOnClickListener(this);
        findViewById(0x7f1003ab).setOnClickListener(this);
    }

    public void onDestroy()
    {
        super.onDestroy();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        bundle.putString("uri", uri.toString());
        bundle.putStringArrayList("temp_files", TemporaryFileManager.instance.clear());
        super.onSaveInstanceState(bundle);
    }

    protected void onTaskComplete(int i, FwLoader fwloader)
    {
        if (!isFinishing())
        {
            switch (i)
            {
            default:
                return;

            case 1: // '\001'
                fwloader = (LoadImageLoader)fwloader;
                if (fwloader.isError())
                {
                    Toast.makeText(this, getString(((LoadImageLoader) (fwloader)).errorResId), 1).show();
                    finish();
                    return;
                }
                fwloader = fwloader.getLoadedImage();
                if (log.isLoggable)
                {
                    FwLog.println(log, (new StringBuilder()).append("Image loaded for cropping, width:").append(fwloader.getWidth()).append(" height:").append(fwloader.getHeight()).toString());
                }
                cropImageView.initImage(fwloader, true);
                cropImageViewInitialized = true;
                return;

            case 2: // '\002'
                fwloader = ((SaveImageLoader)fwloader).getSavedImage();
                break;
            }
            if (fwloader != null)
            {
                Intent intent = new Intent();
                intent.setData(fwloader);
                setResult(-1, intent);
                finish();
                return;
            }
        }
    }



/*
    static boolean access$002(CropPhotoActivity cropphotoactivity, boolean flag)
    {
        cropphotoactivity.shouldHandleClick = flag;
        return flag;
    }

*/
}
