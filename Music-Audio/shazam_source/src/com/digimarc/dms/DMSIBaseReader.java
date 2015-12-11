// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms;

import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.digimarc.dms:
//            DMSIBase, DMSProfile, DMSIImageReader, DMSOptionsBarCode, 
//            DMSAudioReader, DMSOptionsAudio

public abstract class DMSIBaseReader extends DMSIBase
{

    private static final String TAG = "DMSIBaseReader";
    protected int accumulatedSamples;
    protected DMSProfile beforePausedProfile;
    protected DMSProfile currentProfile;
    protected DMSProfile highProfile;
    protected DMSProfile idleProfile;
    protected boolean isOpen;
    protected Date lastRead;
    protected String lastSuccessfulPayload;
    protected Date lastSuccessfulRead;
    protected String library;
    protected DMSProfile lowProfile;
    protected boolean masterEnable;
    protected DMSProfile mediumProfile;
    protected final int minSamplesToTriggerARead = 2000;
    public String name;
    protected JSONObject options;
    protected DMSOptionsAudio optionsAudio;
    protected DMSOptionsBarCode optionsBarCode;
    protected JSONObject profiles;
    protected double sessionCount;

    public DMSIBaseReader()
    {
        highProfile = null;
        mediumProfile = null;
        lowProfile = null;
        idleProfile = new DMSProfile();
        optionsBarCode = null;
        optionsAudio = null;
        currentProfile = new DMSProfile();
        accumulatedSamples = 0;
    }

    private JSONObject getJsonItem(String s, JSONObject jsonobject)
    {
        try
        {
            s = jsonobject.getJSONObject(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    private void parseOptions(JSONObject jsonobject, String s)
    {
        if (this instanceof DMSIImageReader)
        {
            optionsBarCode = new DMSOptionsBarCode();
            optionsBarCode.initWithJSONDictionary(jsonobject);
            return;
        }
        if (this instanceof DMSAudioReader)
        {
            optionsAudio = new DMSOptionsAudio();
            optionsAudio.initWithJSONDictionary(jsonobject);
            return;
        } else
        {
            DMS_Notify_Status(600, null);
            return;
        }
    }

    private DMSProfile parseProfile(JSONObject jsonobject, String s)
    {
        DMSProfile dmsprofile = new DMSProfile();
        try
        {
            jsonobject = jsonobject.getJSONObject(s);
            dmsprofile.setInterval(jsonobject.getDouble("interval"));
            dmsprofile.setOffset(jsonobject.getDouble("offset"));
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            jsonobject.printStackTrace();
            return null;
        }
        return dmsprofile;
    }

    protected int calcIncrement(int i)
    {
        boolean flag = false;
        accumulatedSamples = accumulatedSamples + i;
        i = ((flag) ? 1 : 0);
        if (accumulatedSamples >= 2000)
        {
            i = accumulatedSamples / 2000;
            accumulatedSamples = accumulatedSamples % 2000;
        }
        return i;
    }

    protected DMSOptionsAudio getAudioOptions()
    {
        return optionsAudio;
    }

    protected DMSProfile getProfile(DMSIBase.DMS_PROFILES dms_profiles)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$digimarc$dms$DMSIBase$DMS_PROFILES[];

            static 
            {
                $SwitchMap$com$digimarc$dms$DMSIBase$DMS_PROFILES = new int[DMSIBase.DMS_PROFILES.values().length];
                try
                {
                    $SwitchMap$com$digimarc$dms$DMSIBase$DMS_PROFILES[DMSIBase.DMS_PROFILES.LOW.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$digimarc$dms$DMSIBase$DMS_PROFILES[DMSIBase.DMS_PROFILES.MEDIUM.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$digimarc$dms$DMSIBase$DMS_PROFILES[DMSIBase.DMS_PROFILES.HIGH.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$digimarc$dms$DMSIBase$DMS_PROFILES[DMSIBase.DMS_PROFILES.IDLE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.digimarc.dms.DMSIBase.DMS_PROFILES[dms_profiles.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return getProfileLow();

        case 2: // '\002'
            return getProfileMedium();

        case 3: // '\003'
            return getProfileHigh();

        case 4: // '\004'
            return getProfileIdle();
        }
    }

    protected DMSProfile getProfileHigh()
    {
        return highProfile;
    }

    protected DMSProfile getProfileIdle()
    {
        return idleProfile;
    }

    protected DMSProfile getProfileLow()
    {
        return lowProfile;
    }

    protected DMSProfile getProfileMedium()
    {
        return mediumProfile;
    }

    protected double getSessionCount()
    {
        return sessionCount;
    }

    protected void incrementSessionCount(int i)
    {
        sessionCount = sessionCount + (double)i;
    }

    protected void initWithJSONDictionary(JSONObject jsonobject)
    {
        boolean flag = true;
        name = jsonobject.getString("name");
        library = jsonobject.getString("library");
        if (jsonobject.getInt("masterEnable") != 1)
        {
            flag = false;
        }
        masterEnable = flag;
        options = getJsonItem("options", jsonobject);
        if (options != null)
        {
            parseOptions(options, name);
        }
        profiles = getJsonItem("profiles", jsonobject);
        if (profiles != null)
        {
            highProfile = parseProfile(profiles, "high");
            mediumProfile = parseProfile(profiles, "medium");
            lowProfile = parseProfile(profiles, "low");
        }
        (new StringBuilder("Contructed Reader: ")).append(name).append(", library: ").append(name);
        return;
        jsonobject;
        jsonobject.printStackTrace();
        return;
    }

    protected boolean readyToRunAtSessionCounter(DMSIBase.DMS_PROFILES dms_profiles)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (masterEnable)
        {
            dms_profiles = getProfile(dms_profiles);
            double d = dms_profiles.getInterval();
            double d1 = dms_profiles.getOffset();
            flag = flag1;
            if (sessionCount > 0.0D)
            {
                flag = flag1;
                if (d > 0.0D)
                {
                    flag = flag1;
                    if (0.0D == (d1 + sessionCount) % d)
                    {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    protected void restoreProfile()
    {
        this;
        JVM INSTR monitorenter ;
        currentProfile = beforePausedProfile;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected void saveProfile()
    {
        this;
        JVM INSTR monitorenter ;
        beforePausedProfile = currentProfile;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void start()
    {
    }

    public void stop()
    {
    }
}
