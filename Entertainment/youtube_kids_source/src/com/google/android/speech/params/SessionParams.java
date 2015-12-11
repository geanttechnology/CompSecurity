// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.params;

import android.location.Location;
import com.google.android.speech.SpeechSettings;
import com.google.android.speech.embedded.Greco3Grammar;
import com.google.android.speech.embedded.Greco3Mode;
import egf;
import euu;
import eyc;
import eyg;
import eyi;
import eyl;
import eyw;
import eyy;
import f;

// Referenced classes of package com.google.android.speech.params:
//            AudioInputParams

public class SessionParams
{

    private static final int EMBEDDED_FALLBACK_TIMEOUT_DISABLED = -1;
    public static final int MODE_DICTATION = 3;
    public static final int MODE_HANDS_FREE_COMMANDS = 5;
    public static final int MODE_HANDS_FREE_CONTACTS = 4;
    public static final int MODE_HOTWORD = 6;
    public static final int MODE_INTENT_API = 0;
    public static final int MODE_INVALID = -1;
    private static final int MODE_MAX = 9;
    public static final int MODE_MICRO_HOTWORD = 9;
    private static final int MODE_MIN = 0;
    public static final int MODE_SERVICE_API = 1;
    public static final int MODE_SOUND_SEARCH_MUSIC = 7;
    public static final int MODE_SOUND_SEARCH_TV = 8;
    public static final int MODE_VOICE_ACTIONS = 2;
    private static final int TIMEOUT_NO_SPEECH_DETECTED_MSEC = 20000;
    private final boolean mAlternatesEnabled;
    private final String mApplicationId;
    private final AudioInputParams mAudioInputParams;
    private final Greco3Grammar mGreco3Grammar;
    private final Greco3Mode mGreco3Mode;
    private final Location mLocationOverride;
    private final int mMaxNbest;
    private final int mMode;
    private final boolean mNoSpeechDetectedEnabled;
    private final boolean mPartialResultsEnabled;
    private final boolean mProfanityFilterEnabled;
    private final euu mRecognitionContext;
    private final egf mRequestIdSupplier;
    private final boolean mResendingAudio;
    private final boolean mServerEndpointingEnabled;
    private final String mService;
    private final boolean mSoundSearchTtsEnabled;
    private final String mSpokenBcp47Locale;
    private final boolean mStopOnEndOfSpeech;
    private final boolean mSuggestionsEnabled;
    private final String mTriggerApplication;
    private final boolean mUseMusicHotworder;

    private SessionParams(int i, AudioInputParams audioinputparams, boolean flag, boolean flag1, boolean flag2, String s, String s1, 
            Greco3Grammar greco3grammar, Greco3Mode greco3mode, boolean flag3, boolean flag4, boolean flag5, boolean flag6, boolean flag7, 
            int j, Location location, euu euu, String s2, egf egf1, String s3, boolean flag8, 
            boolean flag9)
    {
        mMode = i;
        mAudioInputParams = audioinputparams;
        mAlternatesEnabled = flag;
        mResendingAudio = flag1;
        mStopOnEndOfSpeech = flag2;
        mSpokenBcp47Locale = s;
        mTriggerApplication = s1;
        mGreco3Grammar = greco3grammar;
        mGreco3Mode = greco3mode;
        mUseMusicHotworder = flag3;
        mNoSpeechDetectedEnabled = flag4;
        mPartialResultsEnabled = flag5;
        mProfanityFilterEnabled = flag6;
        mSuggestionsEnabled = flag7;
        mMaxNbest = j;
        mLocationOverride = location;
        mRecognitionContext = euu;
        mApplicationId = s2;
        mRequestIdSupplier = egf1;
        mService = s3;
        mSoundSearchTtsEnabled = flag8;
        mServerEndpointingEnabled = flag9;
    }

    SessionParams(int i, AudioInputParams audioinputparams, boolean flag, boolean flag1, boolean flag2, String s, String s1, 
            Greco3Grammar greco3grammar, Greco3Mode greco3mode, boolean flag3, boolean flag4, boolean flag5, boolean flag6, boolean flag7, 
            int j, Location location, euu euu, String s2, egf egf1, String s3, boolean flag8, 
            boolean flag9, _cls1 _pcls1)
    {
        this(i, audioinputparams, flag, flag1, flag2, s, s1, greco3grammar, greco3mode, flag3, flag4, flag5, flag6, flag7, j, location, euu, s2, egf1, s3, flag8, flag9);
    }

    public static boolean isSoundSearch(int i)
    {
label0:
        {
            boolean flag1 = false;
            boolean flag;
            if (i >= 0 && i <= 9)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            f.a(flag, "Unsupported mode");
            if (i != 7)
            {
                flag = flag1;
                if (i != 8)
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
    }

    public static boolean isVoiceDialerSearch(int i)
    {
label0:
        {
            boolean flag1 = false;
            boolean flag;
            if (i >= 0 && i <= 9)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            f.a(flag, "Unsupported mode");
            if (i != 4)
            {
                flag = flag1;
                if (i != 5)
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
    }

    public String getApplicationId()
    {
        return mApplicationId;
    }

    public AudioInputParams getAudioInputParams()
    {
        return mAudioInputParams;
    }

    public int getEmbeddedFallbackTimeout(SpeechSettings speechsettings)
    {
        if (mGreco3Mode == Greco3Mode.DICTATION)
        {
            return speechsettings.getConfiguration().d.d;
        }
        if (mGreco3Mode == Greco3Mode.GRAMMAR)
        {
            return speechsettings.getConfiguration().e.b;
        } else
        {
            return -1;
        }
    }

    public eyi getEndpointerParams(SpeechSettings speechsettings)
    {
        mMode;
        JVM INSTR tableswitch 0 3: default 36
    //                   0 82
    //                   1 98
    //                   2 137
    //                   3 66;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        speechsettings = speechsettings.getConfiguration().e.a;
_L7:
        if (!mNoSpeechDetectedEnabled)
        {
            speechsettings.a(20000);
        }
        return speechsettings;
_L5:
        speechsettings = speechsettings.getConfiguration().d.c;
        continue; /* Loop/switch isn't completed */
_L2:
        speechsettings = speechsettings.getConfiguration().c.a;
        continue; /* Loop/switch isn't completed */
_L3:
        if (mStopOnEndOfSpeech)
        {
            speechsettings = speechsettings.getConfiguration().f.a;
        } else
        {
            speechsettings = speechsettings.getConfiguration().d.c;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        speechsettings = speechsettings.getConfiguration().e.a;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public Greco3Grammar getGreco3Grammar()
    {
        return mGreco3Grammar;
    }

    public Greco3Mode getGreco3Mode()
    {
        return mGreco3Mode;
    }

    public Location getLocationOverride()
    {
        return mLocationOverride;
    }

    public int getMaxNbest()
    {
        return mMaxNbest;
    }

    public int getMode()
    {
        return mMode;
    }

    public euu getRecognitionContext()
    {
        return mRecognitionContext;
    }

    public String getRequestId()
    {
        return (String)mRequestIdSupplier.get();
    }

    public String getService()
    {
        return mService;
    }

    public String getSpokenBcp47Locale()
    {
        return mSpokenBcp47Locale;
    }

    public String getTriggerApplication()
    {
        return mTriggerApplication;
    }

    public boolean isAlternatesEnabled()
    {
        return mAlternatesEnabled;
    }

    public boolean isCombinedNbestEnabled()
    {
        return mMode == 2 || mMode == 1 || mMode == 0;
    }

    public boolean isPartialResultsEnabled()
    {
        return mPartialResultsEnabled;
    }

    public boolean isProfanityFilterEnabled()
    {
        return mProfanityFilterEnabled;
    }

    public boolean isResendingAudio()
    {
        return mResendingAudio;
    }

    public boolean isServerEndpointingEnabled()
    {
        return mServerEndpointingEnabled;
    }

    public boolean isSoundSearchTtsEnabled()
    {
        return mSoundSearchTtsEnabled;
    }

    public boolean isSuggestionsEnabled()
    {
        return mSuggestionsEnabled;
    }

    public boolean shouldUseMusicHotworder()
    {
        return mUseMusicHotworder;
    }

    public boolean stopOnEndOfSpeech()
    {
        return mStopOnEndOfSpeech;
    }
}
