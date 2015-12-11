// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms;

import android.content.Context;
import com.digimarc.dms.camerasettings.DMSCameraSettingsKB;
import com.digimarc.dms.camerasettings.DMSKBDownload;
import com.digimarc.dms.camerasettings.DMSKBScheduler;
import com.digimarc.dms.resolver.AppMetricsWatcher;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.digimarc.dms:
//            DMSIBase, DMSManagerOptions, DMSImageReaderMgr, DMSIImageReader, 
//            DMSAudioReaderMgr, DMSAudioReader, DMSReaderWatermark, DMSReaderBarcode, 
//            DMSIImageSource, DMSIAudioSource, DMSIListener, DMSPayload

public class DMSManager extends DMSIBase
{

    private static DMSManager gInstance = null;
    private final String TAG = "DMSManager";
    private JSONArray mAudioReadersJson;
    private JSONArray mImageReadersJson;
    private JSONObject mJsonConfig;
    private DMSKBScheduler mKBScheduler;
    AppMetricsWatcher mMetricsListener;
    private DMSManagerOptions mOptions;

    public DMSManager()
    {
        mMetricsListener = null;
        mOptions = new DMSManagerOptions();
        mKBScheduler = null;
    }

    private boolean checkVersion()
    {
        mJsonConfig = mJsonConfig.getJSONObject("DMSReadersConfig_V2");
        return mJsonConfig != null;
    }

    private void createReaders()
    {
        boolean flag = false;
        if (mImageReadersJson == null) goto _L2; else goto _L1
_L1:
        int i = 0;
_L3:
        if (i >= mImageReadersJson.length())
        {
            break; /* Loop/switch isn't completed */
        }
        DMSIImageReader dmsiimagereader;
        try
        {
            dmsiimagereader = readerImageFactory((JSONObject)mImageReadersJson.get(i));
        }
        catch (JSONException jsonexception)
        {
            super.updateDMSStatus(203);
            throw jsonexception;
        }
        if (dmsiimagereader == null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        mImageReaderMgr.registerReader(dmsiimagereader);
        (new StringBuilder("Registered ")).append(dmsiimagereader.name);
        i++;
        if (true) goto _L3; else goto _L2
_L2:
        if (mAudioReadersJson == null) goto _L5; else goto _L4
_L4:
        i = ((flag) ? 1 : 0);
_L6:
        if (i >= mAudioReadersJson.length())
        {
            break; /* Loop/switch isn't completed */
        }
        DMSAudioReader dmsaudioreader;
        try
        {
            dmsaudioreader = readerAudioFactory((JSONObject)mAudioReadersJson.get(i));
        }
        catch (JSONException jsonexception1)
        {
            super.updateDMSStatus(203);
            throw jsonexception1;
        }
        if (dmsaudioreader == null)
        {
            break MISSING_BLOCK_LABEL_149;
        }
        mAudioReaderMgr.registerReader(dmsaudioreader);
        (new StringBuilder("Registered ")).append(dmsaudioreader.name);
        i++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private JSONArray getAudioReaders()
    {
        try
        {
            mAudioReadersJson = mJsonConfig.getJSONArray("AudioReaders");
        }
        catch (JSONException jsonexception)
        {
            return null;
        }
        return mAudioReadersJson;
    }

    private JSONArray getImageReaders()
    {
        try
        {
            mImageReadersJson = mJsonConfig.getJSONArray("ImageReaders");
        }
        catch (JSONException jsonexception)
        {
            return null;
        }
        return mImageReadersJson;
    }

    public static DMSManager getInstance()
    {
        com/digimarc/dms/DMSManager;
        JVM INSTR monitorenter ;
        if (gInstance == null) goto _L2; else goto _L1
_L1:
        DMSManager dmsmanager = gInstance;
_L4:
        com/digimarc/dms/DMSManager;
        JVM INSTR monitorexit ;
        return dmsmanager;
_L2:
        dmsmanager = new DMSManager();
        gInstance = dmsmanager;
        dmsmanager.initialize();
        dmsmanager = gInstance;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private String readFileAsString(String s)
    {
        BufferedReader bufferedreader = new BufferedReader(new FileReader(s));
        s = "";
        do
        {
            String s1 = bufferedreader.readLine();
            if (s1 != null)
            {
                s = (new StringBuilder()).append(s).append(s1).toString();
            } else
            {
                bufferedreader.close();
                return s;
            }
        } while (true);
    }

    private DMSAudioReader readerAudioFactory(JSONObject jsonobject)
    {
        String s = jsonobject.getString("name");
        boolean flag;
        if (jsonobject.getString("masterEnable").compareTo("1") == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (s.compareTo("AudioWatermark") == 0 && flag)
        {
            DMSAudioReader dmsaudioreader;
            try
            {
                dmsaudioreader = new DMSAudioReader();
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                return null;
            }
            try
            {
                dmsaudioreader.initWithJSONDictionary(jsonobject);
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                return dmsaudioreader;
            }
            return dmsaudioreader;
        } else
        {
            return null;
        }
    }

    private DMSIImageReader readerImageFactory(JSONObject jsonobject)
    {
        Object obj = jsonobject.getString("name");
        boolean flag;
        if (jsonobject.getString("masterEnable").compareTo("1") == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (((String) (obj)).compareTo("ImageWatermark") != 0)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        obj = new DMSReaderWatermark(((String) (obj)));
        ((DMSIImageReader) (obj)).initWithJSONDictionary(jsonobject);
        return ((DMSIImageReader) (obj));
        if (((String) (obj)).compareTo("ImageBarcode") != 0 || !flag)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        obj = new DMSReaderBarcode(((String) (obj)));
        ((DMSIImageReader) (obj)).initWithJSONDictionary(jsonobject);
        return ((DMSIImageReader) (obj));
        jsonobject;
        jsonobject.printStackTrace();
        return null;
    }

    private void reportOneTimeAppMetrics()
    {
        mMetricsListener = new AppMetricsWatcher(mAppContext);
        mMetricsListener.start();
    }

    public void clearAudioPayloadCache()
    {
        this;
        JVM INSTR monitorenter ;
        super.setAudioPayloadCacheMaxDepth(super.mAudioPayloadCacheMaxDepth);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void clearImagePayloadCache()
    {
        this;
        JVM INSTR monitorenter ;
        super.setImagePayloadCacheMaxDepth(super.mImagePayloadCacheMaxDepth);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void closeSession()
    {
        if (mImageSource != null)
        {
            mImageSource.detachFromDMS();
        }
        if (mAudioSource != null)
        {
            mAudioSource.detachFromDMS();
        }
        removeListeners();
        mImageReaderMgr.stop();
        mAudioReaderMgr.stop();
        if (mMetricsListener != null)
        {
            mMetricsListener.stop();
        }
        if (mKBScheduler != null)
        {
            mKBScheduler.stop();
        }
        super.updateDMSStatus(200);
    }

    public int getAudioPayloadCacheMaxDepth()
    {
        return super.mAudioPayloadCacheMaxDepth;
    }

    public DMSIBase.DMS_PROFILES getAudioReadingProfile()
    {
        return mAudioReaderMgr.getAudioProfile();
    }

    public DMSIAudioSource getAudioSource()
    {
        return super.mAudioSource;
    }

    public String getCameraSettingsKBCurrentRuleName()
    {
        return DMSCameraSettingsKB.getInstance(mAppContext, mOptions.getCameraKbJson()).getKBRuleName();
    }

    public String getCameraSettingsKBVersion()
    {
        return DMSCameraSettingsKB.getInstance(mAppContext, mOptions.getCameraKbJson()).getKBVersion();
    }

    public int getCurrentAudioStatus()
    {
        return DMSIBase.mCurrentAudioStatus;
    }

    public int getCurrentDMSStatus()
    {
        return DMSIBase.mCurrentDMSStatus;
    }

    public int getCurrentImageStatus()
    {
        return DMSIBase.mCurrentImageStatus;
    }

    public int getImagePayloadCacheMaxDepth()
    {
        return mImagePayloadCacheMaxDepth;
    }

    public DMSIBase.DMS_PROFILES getImageReadingProfile()
    {
        return mImageReaderMgr.getImageProfile();
    }

    public DMSIImageSource getImageSource()
    {
        return super.mImageSource;
    }

    public android.hardware.Camera.Parameters getRecommendedCameraSettings(android.hardware.Camera.Parameters parameters)
    {
        if (!mOptions.isCameraKbLocal() && !DMSKBDownload.getInstance(mAppContext).isLastDownloadSuccesful())
        {
            mKBScheduler.reset();
        }
        mImageReaderMgr.mAppContext = mAppContext;
        return mImageReaderMgr.getBestCameraParameters(parameters);
    }

    public String getVersion()
    {
        return "1.8.0.20150408143830";
    }

    public void incomingAudioBuffer(byte abyte0[], int i)
    {
        if (mAudioSource != null)
        {
            mAudioReaderMgr.queueAudioBuffer(abyte0, i);
        }
    }

    public void incomingAudioBufferBytes(byte abyte0[], int i)
    {
        if (mAudioSource != null)
        {
            mAudioReaderMgr.queueAudioBufferBytes(abyte0, i);
        }
    }

    public void incomingImageBuffer(byte abyte0[], int i, int j)
    {
        if (mImageSource != null)
        {
            mImageReaderMgr.queueImageData(abyte0, i, j, true);
        }
    }

    public boolean loadReadersConfigFromJSONData(JSONObject jsonobject)
    {
        boolean flag1;
        flag1 = false;
        mImageReaderMgr.removeAllReaders();
        mAudioReaderMgr.removeAllReaders();
        boolean flag2;
        if (checkVersion())
        {
            boolean flag;
            if (getImageReaders() != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            try
            {
                jsonobject = getAudioReaders();
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                super.updateDMSStatus(203);
                return false;
            }
            flag2 = flag;
            if (jsonobject != null)
            {
                flag1 = true;
                flag2 = flag;
            }
        } else
        {
            flag2 = false;
        }
        if (!flag2)
        {
            if (!flag1);
        }
        return true;
    }

    public boolean loadReadersConfigFromJSONFile(String s)
    {
        boolean flag;
        try
        {
            flag = loadReadersConfigFromJSONString(readFileAsString(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            super.updateDMSStatus(203);
            return false;
        }
        return flag;
    }

    public boolean loadReadersConfigFromJSONString(String s)
    {
        mJsonConfig = new JSONObject(s);
        if (loadReadersConfigFromJSONData(mJsonConfig))
        {
            break MISSING_BLOCK_LABEL_32;
        }
        super.updateDMSStatus(203);
        return false;
        try
        {
            createReaders();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            super.updateDMSStatus(203);
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            (new StringBuilder("Missing Library: ")).append(s.getMessage());
            super.updateDMSStatus(202);
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            (new StringBuilder("Missing Library: ")).append(s.getMessage());
            super.updateDMSStatus(202);
            return false;
        }
        return true;
    }

    public boolean openSession(Context context, DMSIListener dmsilistener, DMSIImageSource dmsiimagesource, DMSIAudioSource dmsiaudiosource)
    {
        try
        {
            mAppContext = context;
            addListener(dmsilistener);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            (new StringBuilder("OpenSession failed: ")).append(context.getMessage());
            return false;
        }
        if (dmsiimagesource == null)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        if (dmsiimagesource.attachToDMS())
        {
            break MISSING_BLOCK_LABEL_31;
        }
        DMS_Notify_Status(502, null);
        return false;
        dmsiimagesource.setAppContext(context);
        setImageSource(dmsiimagesource);
        setImagePayloadCacheMaxDepth(mImagePayloadCacheMaxDepth);
        if (dmsiaudiosource == null)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        if (dmsiaudiosource.attachToDMS())
        {
            break MISSING_BLOCK_LABEL_93;
        }
        DMS_Notify_Status(503, null);
        return false;
        dmsiaudiosource.setAppContext(context);
        setAudioSource(dmsiaudiosource);
        setAudioPayloadCacheMaxDepth(mAudioPayloadCacheMaxDepth);
        if (!mOptions.isDisableCheckin())
        {
            reportOneTimeAppMetrics();
        }
        DMSCameraSettingsKB.getInstance(context, mOptions.getCameraKbJson());
        if (!mOptions.isCameraKbLocal())
        {
            mKBScheduler = new DMSKBScheduler(context);
            mKBScheduler.start();
        }
        mImageReaderMgr.start();
        mAudioReaderMgr.start();
        super.updateDMSStatus(201);
        return true;
    }

    public void reportNewDetectionsOnly(boolean flag)
    {
        DMSIBase.mReportNewDetectionsOnly = flag;
    }

    public void reportReaderInfoDiagnostics(boolean flag)
    {
        DMSIBase.mReportReaderInfoDiagnostics = flag;
    }

    public void setAudioPayloadCacheMaxDepth(int i)
    {
        this;
        JVM INSTR monitorenter ;
        super.setAudioPayloadCacheMaxDepth(i);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setAudioProfile(DMSIBase.DMS_PROFILES dms_profiles)
    {
        this;
        JVM INSTR monitorenter ;
        if (mAudioReaderMgr != null)
        {
            mAudioReaderMgr.setCurrentProfile(dms_profiles);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        dms_profiles;
        throw dms_profiles;
    }

    public void setImagePayloadCacheMaxDepth(int i)
    {
        this;
        JVM INSTR monitorenter ;
        super.setImagePayloadCacheMaxDepth(i);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setImageProfile(DMSIBase.DMS_PROFILES dms_profiles)
    {
        if (mImageReaderMgr != null)
        {
            mImageReaderMgr.setImageProfile(dms_profiles);
        }
    }

    public void setOptions(Map map)
    {
        mOptions.parseOptions(map);
    }

    public boolean startAudioSource()
    {
        if (mAudioSource != null)
        {
            mAudioSource.start();
            super.updateAudioStatus(300);
            return true;
        } else
        {
            return false;
        }
    }

    public boolean startImageSource()
    {
        if (mImageSource != null)
        {
            mImageSource.start();
            super.updateImageStatus(400);
            return true;
        } else
        {
            return false;
        }
    }

    public void stopAudioSource()
    {
        if (mAudioSource != null)
        {
            mAudioSource.stop();
            super.updateAudioStatus(301);
        }
    }

    public void stopImageSource()
    {
        if (mImageSource != null)
        {
            mImageSource.stop();
            super.updateImageStatus(401);
        }
    }

    public DMSPayload testImageBuffer(byte abyte0[], int i, int j)
    {
        return mImageReaderMgr.queueImageData(abyte0, i, j, false);
    }

}
