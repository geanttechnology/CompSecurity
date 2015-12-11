// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Window;
import android.widget.FrameLayout;
import com.a9.cameralibrary.A9CameraPreview;
import com.a9.cameralibrary.CameraErrorReason;
import com.a9.cameralibrary.CameraFrameListener;
import com.a9.cameralibrary.NewCameraPreview;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.net.RefMarkerObserver;
import com.flow.android.engine.library.FlowStateEngine;
import com.flow.android.engine.library.FlowStateEngineInterface;
import com.flow.android.engine.models.FlowStateEngineIO;
import java.util.Set;
import java.util.UUID;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            CameraBgHelper, ViewItAccelerometerManager, ViewItPhotoCaptureView

public abstract class FSECameraActivity extends AmazonActivity
    implements CameraFrameListener, NewCameraPreview, FlowStateEngineInterface
{
    protected class FSECredentials
    {

        private String mApplicationKey;
        private String mSecret;
        private String mUser;
        final FSECameraActivity this$0;

        public String getApplicationKey()
        {
            return mApplicationKey;
        }

        public String getSecret()
        {
            return mSecret;
        }

        public String getUser()
        {
            return mUser;
        }

        public FSECredentials(String s, String s1, String s2)
        {
            this$0 = FSECameraActivity.this;
            super();
            mUser = s;
            mSecret = s1;
            mApplicationKey = s2;
        }
    }


    private static float mMaxFPS;
    private static FlowStateEngine sEngine;
    private CameraBgHelper mCameraBgHelper;
    private A9CameraPreview mCameraPreview;
    private FSECredentials mCredentials;
    private float mDeltaFPS;
    private String mDeviceId;
    protected boolean mIsBarcodeScanOnly;
    private boolean mIsEnginePaused;
    private boolean mIsEngineStopped;
    private int mMaxHeight;
    private int mMinHeight;
    private Set mModules;
    private double mNextTimeAllowed;
    private String mPlatformVersionString;
    private ViewItAccelerometerManager mSensorManager;
    private String mSessionId;

    public FSECameraActivity()
    {
        mIsEngineStopped = true;
        mIsEnginePaused = true;
        mIsBarcodeScanOnly = false;
    }

    private int getMaxImageHeightFromEngine()
    {
        if (sEngine != null)
        {
            return sEngine.getMaxImageHeight();
        } else
        {
            return 0;
        }
    }

    private int getMinImageHeightFromEngine()
    {
        if (sEngine != null)
        {
            return sEngine.getMinImageHeight();
        } else
        {
            return 0;
        }
    }

    private void initDeviceParams()
    {
        Object obj = getPreferences(0);
        mDeviceId = ((SharedPreferences) (obj)).getString("DEVICE_ID", null);
        if (mDeviceId == null)
        {
            mDeviceId = UUID.randomUUID().toString();
            obj = ((SharedPreferences) (obj)).edit();
            ((android.content.SharedPreferences.Editor) (obj)).putString("DEVICE_ID", mDeviceId);
            ((android.content.SharedPreferences.Editor) (obj)).commit();
        }
        mSessionId = UUID.randomUUID().toString();
        try
        {
            mPlatformVersionString = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            return;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            mPlatformVersionString = "1.0";
        }
    }

    public static final void sendEngineMetrics()
    {
        if (sEngine != null)
        {
            sEngine.sendFSEMetrics();
        }
    }

    private void startEngine()
    {
        if (sEngine == null)
        {
            try
            {
                FlowStateEngineIO flowstateengineio = new FlowStateEngineIO();
                flowstateengineio.setSecret(mCredentials.getSecret());
                flowstateengineio.setApplication(mCredentials.getApplicationKey());
                mDeviceId = getDeviceId();
                flowstateengineio.setClientDeviceID(mDeviceId);
                flowstateengineio.setClientVersion(getPlatformVersionString());
                flowstateengineio.setClientSessionID(getSessionId());
                flowstateengineio.setImgServer(getImageMatchServer());
                flowstateengineio.setTextServer(getTextMatchServer());
                flowstateengineio.setErrorReportingServer(getErrorReportingServer());
                flowstateengineio.setDataCollectionDisabled(false);
                flowstateengineio.setPrintToScreen(false);
                flowstateengineio.setUseLogFile(false);
                flowstateengineio.setUsername(mCredentials.getUser());
                sEngine = new FlowStateEngine(this, this, flowstateengineio);
            }
            catch (UnsatisfiedLinkError unsatisfiedlinkerror)
            {
                sEngine = null;
            }
        }
        if (sEngine != null)
        {
            if (mModules.contains(com.flow.android.engine.library.FlowStateEngine.FlowObjectModule.BARCODE))
            {
                sEngine.addFlowObjectModule(com.flow.android.engine.library.FlowStateEngine.FlowObjectModule.BARCODE);
            }
            if (mModules.contains(com.flow.android.engine.library.FlowStateEngine.FlowObjectModule.QRCODE))
            {
                sEngine.addFlowObjectModule(com.flow.android.engine.library.FlowStateEngine.FlowObjectModule.QRCODE);
            }
            if (mModules.contains(com.flow.android.engine.library.FlowStateEngine.FlowObjectModule.IMAGEMATCH))
            {
                sEngine.addFlowObjectModule(com.flow.android.engine.library.FlowStateEngine.FlowObjectModule.IMAGEMATCH);
            }
            if (mModules.contains(com.flow.android.engine.library.FlowStateEngine.FlowObjectModule.TEXT))
            {
                sEngine.addFlowObjectModule(com.flow.android.engine.library.FlowStateEngine.FlowObjectModule.TEXT);
            }
            sEngine.start(this);
            mIsEngineStopped = false;
            mIsEnginePaused = false;
            mNextTimeAllowed = 0.0D;
        }
    }

    private void stopEngine()
    {
        if (sEngine != null && !mIsEngineStopped)
        {
            sEngine.stop();
            mIsEngineStopped = true;
            mIsEnginePaused = true;
        }
    }

    public void cameraError(CameraErrorReason cameraerrorreason, String s)
    {
        handleCameraError(cameraerrorreason, s);
    }

    public void didReceiveFrame(byte abyte0[], int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, long l2)
    {
        while (!shouldProcess(l2) || sEngine == null || mIsEngineStopped) 
        {
            return;
        }
        sEngine.process(abyte0, i, j, k, l, i1, j1, k1, l1, CameraBgHelper.getOrientation(this), false, l2);
    }

    public CameraBgHelper getCameraBgHelper()
    {
        return mCameraBgHelper;
    }

    protected abstract FrameLayout getCameraFrameLayout();

    protected abstract FSECredentials getCredentials();

    protected String getDeviceId()
    {
        if (mDeviceId == null)
        {
            initDeviceParams();
        }
        return mDeviceId;
    }

    protected String getErrorReportingServer()
    {
        return "http://ters.amazon.com/errorreport";
    }

    protected String getImageMatchServer()
    {
        return "https://match-visualsearch.amazon.com/vsearch";
    }

    protected abstract Set getModuleSet();

    protected abstract ViewItPhotoCaptureView getPhotoCaptureView();

    protected String getPlatformVersionString()
    {
        if (mPlatformVersionString == null)
        {
            initDeviceParams();
        }
        return mPlatformVersionString;
    }

    protected String getSessionId()
    {
        if (mSessionId == null)
        {
            initDeviceParams();
        }
        return mSessionId;
    }

    protected String getTextMatchServer()
    {
        return "https://match-visualsearch.amazon.com/textmatch";
    }

    protected abstract void handleCameraError(CameraErrorReason cameraerrorreason, String s);

    protected abstract void handleEngineError();

    protected void initFPS()
    {
        float f;
        if (Runtime.getRuntime().availableProcessors() > 1)
        {
            f = 30F;
        } else
        {
            f = 25F;
        }
        setMaxFPS(f);
    }

    protected abstract void initLayout();

    protected void initScreen()
    {
        Window window = getWindow();
        if (mIsBarcodeScanOnly)
        {
            RefMarkerObserver.logRefMarker("scan_session");
            int i = CameraBgHelper.getActivityOrientation(this);
            if (i == 1 || i == 9)
            {
                RefMarkerObserver.logRefMarker("scan_open_port");
            } else
            {
                RefMarkerObserver.logRefMarker("scan_open_land");
            }
            setRequestedOrientation(i);
            window.addFlags(1024);
        } else
        {
            setRequestedOrientation(1);
        }
        window.addFlags(128);
        window.requestFeature(1);
        window.setSoftInputMode(3);
    }

    protected boolean isEnginePaused()
    {
        return mIsEnginePaused;
    }

    protected boolean isEngineStopped()
    {
        return mIsEngineStopped;
    }

    public A9CameraPreview newCameraPreview()
    {
        mCameraPreview = new A9CameraPreview(this, this);
        return mCameraPreview;
    }

    protected void onCreate(Bundle bundle)
    {
        boolean flag = false;
        super.onCreate(bundle);
        if (!getIntent().getBooleanExtra("MODULE_TYPE_IS_IMAGE_SEARCH", false))
        {
            flag = true;
        }
        mIsBarcodeScanOnly = flag;
        initScreen();
        initLayout();
        mCredentials = getCredentials();
        mModules = getModuleSet();
        mSensorManager = new ViewItAccelerometerManager(this);
        mCameraBgHelper = new CameraBgHelper(this);
        initFPS();
    }

    protected void onNewIntent(Intent intent)
    {
        boolean flag = false;
        setIntent(intent);
        super.onNewIntent(intent);
        if (!intent.getBooleanExtra("MODULE_TYPE_IS_IMAGE_SEARCH", false))
        {
            flag = true;
        }
        mIsBarcodeScanOnly = flag;
    }

    protected void pauseEngine()
    {
        if (sEngine != null)
        {
            sEngine.pause();
        }
        mIsEnginePaused = true;
        if (mCameraBgHelper != null)
        {
            mCameraBgHelper.pause();
        }
    }

    protected final void setMaxFPS(float f)
    {
        mMaxFPS = f;
        mDeltaFPS = 1.0F / mMaxFPS;
    }

    protected boolean shouldProcess(double d)
    {
        if (mMaxFPS == 30F)
        {
            return true;
        }
        if (mNextTimeAllowed == 0.0D)
        {
            mNextTimeAllowed = (double)mDeltaFPS + d;
            return true;
        }
        if (d > mNextTimeAllowed)
        {
            mNextTimeAllowed = mNextTimeAllowed + (double)mDeltaFPS;
            return true;
        } else
        {
            return false;
        }
    }

    public void start()
    {
        if (mIsBarcodeScanOnly)
        {
            mSensorManager.start();
        }
        startEngine();
        if (sEngine != null && sEngine.didLibrariesLoad())
        {
            if (mCameraBgHelper != null)
            {
                if (mMinHeight == 0 || mMaxHeight == 0)
                {
                    mMinHeight = getMinImageHeightFromEngine();
                    mMaxHeight = getMaxImageHeightFromEngine();
                }
                mCameraBgHelper.start(mMinHeight, mMaxHeight);
            }
            return;
        } else
        {
            handleEngineError();
            return;
        }
    }

    public void stop()
    {
        if (mIsBarcodeScanOnly)
        {
            mSensorManager.stop();
        }
        stopEngine();
        if (mCameraBgHelper != null)
        {
            mCameraBgHelper.stop();
        }
    }

    protected void unpauseEngine()
    {
        if (sEngine != null)
        {
            sEngine.resume();
        }
        mIsEnginePaused = false;
        mNextTimeAllowed = 0.0D;
        if (mCameraBgHelper != null)
        {
            mCameraBgHelper.unpause();
        }
    }
}
