// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.adms.measurement;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;

// Referenced classes of package com.adobe.adms.measurement:
//            ADMS_ChurnBase, ADMS_Measurement

public final class ADMS_Churn extends ADMS_ChurnBase
{

    private boolean _appRunning;
    private Context context;
    private ADMS_Measurement measurement;

    protected ADMS_Churn(ADMS_Measurement adms_measurement)
    {
        super(adms_measurement);
        measurement = null;
        context = null;
        _appRunning = false;
        measurement = adms_measurement;
    }

    protected String getApplicationName()
    {
        Object obj;
        try
        {
            obj = measurement.context.getPackageManager();
            obj = (String)((PackageManager) (obj)).getApplicationLabel(((PackageManager) (obj)).getApplicationInfo(measurement.context.getPackageName(), 0));
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            namenotfoundexception.printStackTrace();
            return null;
        }
        return ((String) (obj));
    }

    protected String getApplicationVersion()
    {
        String s;
        try
        {
            s = measurement.context.getPackageManager().getPackageInfo(measurement.context.getPackageName(), 0).versionName;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            namenotfoundexception.printStackTrace();
            return "";
        }
        return s;
    }

    protected void handleFBReferrer()
    {
        if (context != null)
        {
            Object obj = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
            obj = context.getContentResolver().query(((Uri) (obj)), new String[] {
                "aid"
            }, null, null, null);
            if (obj != null && ((Cursor) (obj)).moveToFirst())
            {
                setContextDataValue(((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex("aid")), "a.fb.attrib");
                return;
            }
        }
    }

    protected void handleGPReferrer()
    {
        if (!prefsGetBool("ADMS_ReferrerProcessed", false))
        {
            String s = prefsGetString("utm_source", null);
            String s1 = prefsGetString("utm_medium", null);
            String s2 = prefsGetString("utm_term", null);
            String s3 = prefsGetString("utm_content", null);
            String s4 = prefsGetString("utm_campaign", null);
            if (s != null && s1 != null && s4 != null)
            {
                setContextDataValue(s, "a.referrer.campaign.source");
                setContextDataValue(s1, "a.referrer.campaign.medium");
                setContextDataValue(s2, "a.referrer.campaign.term");
                setContextDataValue(s3, "a.referrer.campaign.content");
                setContextDataValue(s4, "a.referrer.campaign.name");
                prefsPutBool("ADMS_ReferrerProcessed", true);
            }
        }
    }

    protected void handleReferrers()
    {
        handleGPReferrer();
    }

    protected boolean prefsContains(String s)
    {
        return ADMS_Measurement.prefs.contains(s);
    }

    protected boolean prefsGetBool(String s, boolean flag)
    {
        return ADMS_Measurement.prefs.getBoolean(s, flag);
    }

    protected int prefsGetInt(String s, int i)
    {
        return ADMS_Measurement.prefs.getInt(s, i);
    }

    protected long prefsGetLong(String s, long l)
    {
        return ADMS_Measurement.prefs.getLong(s, l);
    }

    protected String prefsGetString(String s, String s1)
    {
        return ADMS_Measurement.prefs.getString(s, s1);
    }

    protected void prefsPutBool(String s, boolean flag)
    {
        ADMS_Measurement.editor.putBoolean(s, flag);
        ADMS_Measurement.editor.commit();
    }

    protected void prefsPutInt(String s, int i)
    {
        ADMS_Measurement.editor.putInt(s, i);
        ADMS_Measurement.editor.commit();
    }

    protected void prefsPutLong(String s, long l)
    {
        ADMS_Measurement.editor.putLong(s, l);
        ADMS_Measurement.editor.commit();
    }

    protected void prefsPutString(String s, String s1)
    {
        ADMS_Measurement.editor.putString(s, s1);
        ADMS_Measurement.editor.commit();
    }

    protected void removeObjectFromPrefsWithKey(String s)
    {
        ADMS_Measurement.editor.remove(s);
        ADMS_Measurement.editor.commit();
    }

    protected void setGenericVariables()
    {
        super.setGenericVariables();
        setContextDataValue((new StringBuilder()).append("Android ").append(ADMS_Measurement.getAndroidVersion()).toString(), appEnvironmentEvar);
    }

    protected void startActivity(Context context1)
    {
        context = context1;
        if (!_appRunning)
        {
            context1 = (new StringBuilder()).append(context1.getApplicationInfo().packageName).append("open").toString();
            if (prefsGetBool(context1, false))
            {
                prefsPutBool("ADMS_SuccessfulClose", false);
            }
            prefsPutBool(context1, true);
            startSession();
        }
        _appRunning = true;
    }

    protected void stopActivity(Context context1)
    {
        prefsPutBool((new StringBuilder()).append(context1.getApplicationInfo().packageName).append("open").toString(), false);
        stopSession();
        _appRunning = false;
    }
}
