// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.attributes;

import android.content.Context;
import android.content.SharedPreferences;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.platform.setting.PlatformSettings;

// Referenced classes of package com.amazon.identity.auth.attributes:
//            CORPFMResponse

public class CorPfmInfo
{

    private static final String TAG = com/amazon/identity/auth/attributes/CorPfmInfo.getName();
    private final Context mContext;

    public CorPfmInfo(Context context)
    {
        mContext = context;
    }

    private String getDefaultValue(String s, String s1)
    {
        String s2 = TAG;
        s2 = getSharedPrefs().getString(s, null);
        if (s2 != null)
        {
            s1 = TAG;
            String.format("Returning Device Default Cor/Pfm from Shared Preference for key: %s and value: %s", new Object[] {
                s, s2
            });
            return s2;
        } else
        {
            String s3 = TAG;
            String.format("Returning Device Default Cor/Pfm from default settings for key: %s and value: %s", new Object[] {
                s, s1
            });
            return s1;
        }
    }

    private SharedPreferences getSharedPrefs()
    {
        return mContext.getSharedPreferences("default_cor_pfm_store", 0);
    }

    public CORPFMResponse getCorPfmDeviceDefaults()
    {
        return new CORPFMResponse(getDeviceDefaultCor(), getDeviceDefaultPfm(), CORPFMResponse.ComputationConfidenceValue.DEVICE_BASED_GUESS);
    }

    public String getDeviceDefaultCor()
    {
        return getDefaultValue("default.cor", PlatformSettings.getInstance(mContext).getSettingString("default.cor", "US"));
    }

    public String getDeviceDefaultPfm()
    {
        return getDefaultValue("default.pfm", PlatformSettings.getInstance(mContext).getSettingString("default.pfm", "ATVPDKIKX0DER"));
    }

    public boolean hasSetDeviceDefaultsForCorPfm()
    {
        SharedPreferences sharedpreferences = getSharedPrefs();
        return sharedpreferences.contains("default.cor") || sharedpreferences.contains("default.pfm");
    }

    public void setDeviceDefaultCorPfm(CORPFMResponse corpfmresponse)
    {
        android.content.SharedPreferences.Editor editor = getSharedPrefs().edit();
        editor.putString("default.cor", corpfmresponse.getCOR());
        editor.putString("default.pfm", corpfmresponse.getPFM());
        if (!editor.commit())
        {
            MAPLog.e(TAG, "Couldn't set device default CoR/PFM");
        }
    }

}
