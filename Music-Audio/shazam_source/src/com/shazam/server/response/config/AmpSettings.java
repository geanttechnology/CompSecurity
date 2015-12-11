// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.config;

import java.io.Serializable;

// Referenced classes of package com.shazam.server.response.config:
//            AmpSetting, GimbalAmpSetting, GoogleNowAmpSetting, AmpSettingImaging, 
//            LastTagReminderAmpSetting, QuizFallbackAmpSetting

public class AmpSettings
    implements Serializable
{
    public static class Builder
    {

        private AmpSetting agof;
        private GimbalAmpSetting gimbal;
        private GoogleNowAmpSetting googleNow;
        private AmpSettingImaging imaging;
        private LastTagReminderAmpSetting lastTagReminder;
        private AmpSetting onboarding;
        private QuizFallbackAmpSetting quizFallback;
        private AmpSetting searchEducationOverlay;
        private AmpSetting watermarking;

        public static Builder ampSettings()
        {
            return new Builder();
        }

        public AmpSettings build()
        {
            return new AmpSettings(this, null);
        }

        public Builder withAgof(AmpSetting ampsetting)
        {
            agof = ampsetting;
            return this;
        }

        public Builder withGimbal(GimbalAmpSetting gimbalampsetting)
        {
            gimbal = gimbalampsetting;
            return this;
        }

        public Builder withGoogleNow(GoogleNowAmpSetting googlenowampsetting)
        {
            googleNow = googlenowampsetting;
            return this;
        }

        public Builder withImaging(AmpSettingImaging ampsettingimaging)
        {
            imaging = ampsettingimaging;
            return this;
        }

        public Builder withLastTagReminder(LastTagReminderAmpSetting lasttagreminderampsetting)
        {
            lastTagReminder = lasttagreminderampsetting;
            return this;
        }

        public Builder withOnboarding(AmpSetting ampsetting)
        {
            onboarding = ampsetting;
            return this;
        }

        public Builder withQuizFallback(QuizFallbackAmpSetting quizfallbackampsetting)
        {
            quizFallback = quizfallbackampsetting;
            return this;
        }

        public Builder withSearchEducationOverlay(AmpSetting ampsetting)
        {
            searchEducationOverlay = ampsetting;
            return this;
        }

        public Builder withWatermarking(AmpSetting ampsetting)
        {
            watermarking = ampsetting;
            return this;
        }










        public Builder()
        {
        }
    }


    private AmpSetting agof;
    private GimbalAmpSetting gimbal;
    private GoogleNowAmpSetting googleNow;
    private AmpSettingImaging imaging;
    private LastTagReminderAmpSetting lastTagReminder;
    private AmpSetting onboarding;
    private QuizFallbackAmpSetting quizFallback;
    private AmpSetting searchEducationOverlay;
    private AmpSetting watermarking;

    private AmpSettings()
    {
    }

    private AmpSettings(Builder builder)
    {
        watermarking = builder.watermarking;
        agof = builder.agof;
        imaging = builder.imaging;
        onboarding = builder.onboarding;
        lastTagReminder = builder.lastTagReminder;
        gimbal = builder.gimbal;
        quizFallback = builder.quizFallback;
        searchEducationOverlay = builder.searchEducationOverlay;
        googleNow = builder.googleNow;
    }

    AmpSettings(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public AmpSetting getAgof()
    {
        if (agof != null)
        {
            return agof;
        } else
        {
            return AmpSetting.Builder.ampSetting().build();
        }
    }

    public GimbalAmpSetting getGimbal()
    {
        if (gimbal != null)
        {
            return gimbal;
        } else
        {
            return GimbalAmpSetting.Builder.gimbalAmpSetting().build();
        }
    }

    public GoogleNowAmpSetting getGoogleNow()
    {
        if (googleNow != null)
        {
            return googleNow;
        } else
        {
            return GoogleNowAmpSetting.Builder.googleNowAmpSetting().build();
        }
    }

    public AmpSettingImaging getImaging()
    {
        if (imaging != null)
        {
            return imaging;
        } else
        {
            return AmpSettingImaging.Builder.ampSettingImaging().build();
        }
    }

    public LastTagReminderAmpSetting getLastTagReminder()
    {
        if (lastTagReminder != null)
        {
            return lastTagReminder;
        } else
        {
            return LastTagReminderAmpSetting.Builder.lastTagReminderAmpSetting().build();
        }
    }

    public AmpSetting getOnboarding()
    {
        if (onboarding != null)
        {
            return onboarding;
        } else
        {
            return AmpSetting.Builder.ampSetting().build();
        }
    }

    public QuizFallbackAmpSetting getQuizFallback()
    {
        if (quizFallback != null)
        {
            return quizFallback;
        } else
        {
            return QuizFallbackAmpSetting.Builder.quizFallback().build();
        }
    }

    public AmpSetting getSearchEducationOverlay()
    {
        if (searchEducationOverlay != null)
        {
            return searchEducationOverlay;
        } else
        {
            return AmpSetting.Builder.ampSetting().build();
        }
    }

    public AmpSetting getWatermarking()
    {
        if (watermarking != null)
        {
            return watermarking;
        } else
        {
            return AmpSetting.Builder.ampSetting().build();
        }
    }
}
