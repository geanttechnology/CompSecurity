// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.camerasettings;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.Log;
import com.digimarc.dms.DMSVersionCompare;
import com.google.b.b.d;
import com.google.b.f;
import com.google.b.g;
import com.google.b.u;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.digimarc.dms.camerasettings:
//            Rules, DMSFilterStrings, CameraSettingsKB, MatchBase, 
//            DMSActionsApplied, DMSKBDownload

public class DMSCameraSettingsKB
{

    protected static final String DMS_CAMERA_KB_FILENAME = "CameraSettingsKB_Android.json";
    protected static final String DMS_CAMERA_KB_SERVER = "https://livemadrasplatform.blob.core.windows.net/camerakb";
    private static final String TAG = com/digimarc/dms/camerasettings/DMSCameraSettingsKB.getName();
    private static DMSCameraSettingsKB _instance = null;
    protected static CameraSettingsKB mCameraKB = null;
    private static String mCameraSettingsURL = "https://livemadrasplatform.blob.core.windows.net/camerakb/CameraSettingsKB_Android.json";
    private final String ZERO_VERSION;
    private final String deviceBrand;
    private final DMSVersionCompare deviceDMSDKVersion;
    private final String deviceHardware;
    private final String deviceManufacturer;
    private final DMSVersionCompare deviceOsVersion;
    protected DMSActionsApplied mActionsApplied;
    private String mCameraKbJson;
    protected Context mContext;
    CameraSettingsKB mFromDMSDK;

    private DMSCameraSettingsKB(Context context)
    {
        mFromDMSDK = null;
        mActionsApplied = null;
        ZERO_VERSION = "0.0.0.0";
        deviceDMSDKVersion = new DMSVersionCompare("1.8.0.20150408143830");
        deviceOsVersion = new DMSVersionCompare(Integer.toString(android.os.Build.VERSION.SDK_INT));
        deviceBrand = Build.BRAND;
        deviceManufacturer = Build.MANUFACTURER;
        deviceHardware = Build.HARDWARE;
        if (context != null)
        {
            mContext = context;
            mCameraKB = loadAndPickKB();
        }
    }

    private DMSCameraSettingsKB(Context context, String s)
    {
        mFromDMSDK = null;
        mActionsApplied = null;
        ZERO_VERSION = "0.0.0.0";
        deviceDMSDKVersion = new DMSVersionCompare("1.8.0.20150408143830");
        deviceOsVersion = new DMSVersionCompare(Integer.toString(android.os.Build.VERSION.SDK_INT));
        deviceBrand = Build.BRAND;
        deviceManufacturer = Build.MANUFACTURER;
        deviceHardware = Build.HARDWARE;
        if (context != null)
        {
            mContext = context;
            mCameraKbJson = s;
            mCameraKB = loadAndPickKB();
        }
    }

    private boolean challengeHeaders(Rules rules)
    {
        Object obj = rules.getMaxDMSDKVersion();
        if (obj == null || ((String) (obj)).isEmpty()) goto _L2; else goto _L1
_L1:
        obj = new DMSVersionCompare(((String) (obj)));
        if (((DMSVersionCompare) (obj)).isEmpty() || deviceDMSDKVersion.compareTo(((DMSVersionCompare) (obj))) <= 0) goto _L2; else goto _L3
_L3:
        return false;
_L2:
        obj = rules.getMinDMSDKVersion();
        if (obj == null || ((String) (obj)).isEmpty())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = new DMSVersionCompare(((String) (obj)));
        if (!((DMSVersionCompare) (obj)).isEmpty() && deviceDMSDKVersion.compareTo(((DMSVersionCompare) (obj))) < 0) goto _L3; else goto _L4
_L4:
        obj = rules.getMaxOSVersion();
        if (obj == null || ((String) (obj)).isEmpty())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = new DMSVersionCompare(((String) (obj)));
        if (!((DMSVersionCompare) (obj)).isEmpty() && deviceOsVersion.compareTo(((DMSVersionCompare) (obj))) > 0) goto _L3; else goto _L5
_L5:
        obj = rules.getMinOSVersion();
        if (obj == null || ((String) (obj)).isEmpty())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = new DMSVersionCompare(((String) (obj)));
        if (!((DMSVersionCompare) (obj)).isEmpty() && deviceOsVersion.compareTo(((DMSVersionCompare) (obj))) < 0) goto _L3; else goto _L6
_L6:
        if (rules.getBrand() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = new DMSFilterStrings(deviceBrand);
        if (!searchWithPattern(rules.getBrand(), ((DMSFilterStrings) (obj)))) goto _L3; else goto _L7
_L7:
        if (rules.getHardware() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = new DMSFilterStrings(deviceHardware);
        if (!searchWithPattern(rules.getHardware(), ((DMSFilterStrings) (obj)))) goto _L3; else goto _L8
_L8:
        if (rules.getManufacturer() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = new DMSFilterStrings(deviceManufacturer);
        if (!searchWithPattern(rules.getManufacturer(), ((DMSFilterStrings) (obj)))) goto _L3; else goto _L9
_L9:
        return true;
    }

    private Rules findRule(String s)
    {
        Rules rules1;
label0:
        {
            Rules rules2 = null;
            Rules rules = null;
            rules1 = rules2;
            if (mCameraKB == null)
            {
                break label0;
            }
            Object obj = mCameraKB.getRules();
            rules1 = rules2;
            if (obj == null)
            {
                break label0;
            }
            obj = ((List) (obj)).iterator();
            ModelName modelname;
            do
            {
                do
                {
                    do
                    {
                        rules1 = rules;
                        if (!((Iterator) (obj)).hasNext())
                        {
                            break label0;
                        }
                        rules2 = (Rules)((Iterator) (obj)).next();
                        rules1 = rules;
                        if (rules == null)
                        {
                            rules1 = rules;
                            if (rules2.getRuleName() != null)
                            {
                                rules1 = rules;
                                if (rules2.getRuleName().compareTo("Default") == 0)
                                {
                                    rules1 = rules2;
                                }
                            }
                        }
                        rules = rules1;
                    } while (!challengeHeaders(rules2));
                    modelname = rules2.getModelName();
                    rules = rules1;
                } while (modelname == null);
                rules = rules1;
            } while (!searchWithPattern(modelname, new DMSFilterStrings(s)));
            return rules2;
        }
        return rules1;
    }

    public static DMSCameraSettingsKB getInstance(Context context, String s)
    {
        if (_instance == null)
        {
            if (s == null)
            {
                _instance = new DMSCameraSettingsKB(context);
            } else
            {
                _instance = new DMSCameraSettingsKB(context, s);
            }
            if (mCameraKB != null)
            {
                (new StringBuilder("DMSCameraSettingsKB kb version: ")).append(mCameraKB.getKbVersion());
            }
        }
        return _instance;
    }

    private boolean isLocalKb()
    {
        return mCameraKbJson != null && !mCameraKbJson.isEmpty();
    }

    public static String loadKBfromDMSDK()
    {
        Object obj;
        InputStreamReader inputstreamreader;
        BufferedReader bufferedreader;
        StringBuffer stringbuffer;
        obj = com/digimarc/dms/camerasettings/DMSCameraSettingsKB.getResourceAsStream("CameraSettingsKB_Android.json");
        inputstreamreader = new InputStreamReader(((InputStream) (obj)), "UTF-8");
        bufferedreader = new BufferedReader(inputstreamreader);
        stringbuffer = new StringBuffer();
_L1:
        String s = bufferedreader.readLine();
label0:
        {
            if (s == null)
            {
                break label0;
            }
            try
            {
                stringbuffer.append(s);
            }
            catch (Exception exception)
            {
                return null;
            }
        }
          goto _L1
        bufferedreader.close();
        inputstreamreader.close();
        ((InputStream) (obj)).close();
        obj = stringbuffer.toString();
        return ((String) (obj));
    }

    private boolean searchWithPattern(MatchBase matchbase, DMSFilterStrings dmsfilterstrings)
    {
label0:
        {
label1:
            {
                if (matchbase == null)
                {
                    break label0;
                }
                if (matchbase.getMatches() == null)
                {
                    break label1;
                }
                Iterator iterator = matchbase.getMatches().iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break label1;
                    }
                } while (!dmsfilterstrings.exactMatch((String)iterator.next()));
                return true;
            }
label2:
            {
                if (matchbase.getStartsWith() == null)
                {
                    break label2;
                }
                Iterator iterator1 = matchbase.getStartsWith().iterator();
                do
                {
                    if (!iterator1.hasNext())
                    {
                        break label2;
                    }
                } while (!dmsfilterstrings.startsWith((String)iterator1.next()));
                return true;
            }
            if (matchbase.getContains() == null)
            {
                break label0;
            }
            matchbase = matchbase.getContains().iterator();
            do
            {
                if (!matchbase.hasNext())
                {
                    break label0;
                }
            } while (!dmsfilterstrings.contains((String)matchbase.next()));
            return true;
        }
        return false;
    }

    public static void setCameraKB(CameraSettingsKB camerasettingskb)
    {
        mCameraKB = camerasettingskb;
    }

    protected static boolean validateKB(CameraSettingsKB camerasettingskb)
    {
        boolean flag;
label0:
        {
            flag = true;
            if (camerasettingskb != null)
            {
                if (camerasettingskb.getPlatform().compareTo("Android") == 0)
                {
                    break label0;
                }
                Log.e(TAG, (new StringBuilder("Camera KB is for ")).append(camerasettingskb.getPlatform()).toString());
            }
            flag = false;
        }
        return flag;
    }

    public String[] getCameraParams()
    {
        return mActionsApplied.getCameraParameters();
    }

    public Context getContext()
    {
        return mContext;
    }

    public String getKBRuleName()
    {
        if (mCameraKB != null && mCameraKB.getRuleUsed() != null)
        {
            return mCameraKB.getRuleUsed().getRuleName();
        } else
        {
            return "Unknown";
        }
    }

    public String getKBUrl()
    {
        return mCameraSettingsURL;
    }

    public String getKBVersion()
    {
        if (mCameraKB != null)
        {
            return mCameraKB.getKbVersion();
        } else
        {
            return "0.0.0.0";
        }
    }

    public Point getRecommendedResolution(String s)
    {
        if (mContext != null)
        {
            mCameraKB = loadAndPickKB();
        }
        if (mCameraKB != null)
        {
            (new StringBuilder("Recommended Camera Settings KB version: ")).append(mCameraKB.getKbVersion());
            s = findRule(s);
            if (s != null)
            {
                mCameraKB.setRuleUsed(s);
                (new StringBuilder(" applied Rule: ")).append(s.getRuleName());
                mActionsApplied = new DMSActionsApplied(s);
                int i = mActionsApplied.getResolution().x;
                int j = mActionsApplied.getResolution().y;
                (new StringBuilder(" device Resolution applied: ")).append(i).append("x").append(j);
                return new Point(i, j);
            }
        }
        Log.e(TAG, "No Camera Settings KB rule applied");
        return null;
    }

    public boolean isLimitedFocus()
    {
        return mActionsApplied.isLimitedFocus();
    }

    protected CameraSettingsKB loadAndPickKB()
    {
        this;
        JVM INSTR monitorenter ;
        if (!isLocalKb()) goto _L2; else goto _L1
_L1:
        CameraSettingsKB camerasettingskb = loadAndPickKBNoDownload();
_L4:
        this;
        JVM INSTR monitorexit ;
        return camerasettingskb;
_L2:
        camerasettingskb = loadAndPickKBDownload();
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    protected CameraSettingsKB loadAndPickKBDownload()
    {
        this;
        JVM INSTR monitorenter ;
        CameraSettingsKB camerasettingskb1;
        camerasettingskb1 = parseKB(DMSKBDownload.getInstance(mContext).getDownloadedKBContents());
        if (mFromDMSDK == null)
        {
            mFromDMSDK = parseKB(loadKBfromDMSDK());
        }
        CameraSettingsKB camerasettingskb = camerasettingskb1;
        if (mFromDMSDK == null) goto _L2; else goto _L1
_L1:
        if (camerasettingskb1 == null) goto _L4; else goto _L3
_L3:
        int i = (new DMSVersionCompare(camerasettingskb1.getKbVersion())).compareTo(new DMSVersionCompare(mFromDMSDK.getKbVersion()));
        if (i == 0) goto _L4; else goto _L5
_L5:
        camerasettingskb = camerasettingskb1;
_L2:
        this;
        JVM INSTR monitorexit ;
        return camerasettingskb;
_L4:
        camerasettingskb = mFromDMSDK;
        if (true) goto _L2; else goto _L6
_L6:
        Exception exception;
        exception;
        throw exception;
    }

    protected CameraSettingsKB loadAndPickKBNoDownload()
    {
        this;
        JVM INSTR monitorenter ;
        CameraSettingsKB camerasettingskb1;
        camerasettingskb1 = parseKB(mCameraKbJson);
        if (mFromDMSDK == null)
        {
            mFromDMSDK = parseKB(loadKBfromDMSDK());
        }
        CameraSettingsKB camerasettingskb = camerasettingskb1;
        if (mFromDMSDK == null) goto _L2; else goto _L1
_L1:
        if (camerasettingskb1 == null) goto _L4; else goto _L3
_L3:
        int i = (new DMSVersionCompare(camerasettingskb1.getKbVersion())).compareTo(new DMSVersionCompare(mFromDMSDK.getKbVersion()));
        if (i == 0) goto _L4; else goto _L5
_L5:
        camerasettingskb = camerasettingskb1;
_L2:
        this;
        JVM INSTR monitorexit ;
        return camerasettingskb;
_L4:
        camerasettingskb = mFromDMSDK;
        if (true) goto _L2; else goto _L6
_L6:
        Exception exception;
        exception;
        throw exception;
    }

    protected CameraSettingsKB loadKBfromString(String s)
    {
        return parseKB(s);
    }

    public boolean needsCameraCorrections()
    {
        return mActionsApplied.isCameraCorrection();
    }

    public CameraSettingsKB parseKB(String s)
    {
        try
        {
            g g1 = new g();
            g1.c = false;
            d d1 = g1.a.a();
            d1.e = true;
            g1.a = d1;
            s = (CameraSettingsKB)g1.a().a(s, com/digimarc/dms/camerasettings/CameraSettingsKB);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e(TAG, (new StringBuilder("CameraSettingsKB JSON syntax error: ")).append(s.getMessage()).toString());
            s = null;
        }
        if (!validateKB(s))
        {
            return null;
        } else
        {
            return s;
        }
    }

    public void setKBUrl(String s)
    {
        if (s != null)
        {
            mCameraSettingsURL = s;
        }
    }

}
