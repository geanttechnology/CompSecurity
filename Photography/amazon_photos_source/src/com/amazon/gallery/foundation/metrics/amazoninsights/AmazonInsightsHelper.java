// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.metrics.amazoninsights;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.insights.ABTestClient;
import com.amazon.insights.AmazonInsights;
import com.amazon.insights.EventClient;
import com.amazon.insights.InsightsCallback;
import com.amazon.insights.InsightsHandler;
import com.amazon.insights.SessionClient;
import com.amazon.insights.UserProfile;
import com.amazon.insights.Variation;
import com.amazon.insights.VariationSet;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class AmazonInsightsHelper
{
    public static interface LaunchAndTextLoadedListener
    {

        public abstract void onLoaded(boolean flag, String s);
    }

    public static interface LaunchLoadedListener
    {

        public abstract void onLaunchLoaded(boolean flag);
    }

    public static final class LocaleType extends Enum
    {

        private static final LocaleType $VALUES[];
        public static final LocaleType LANGUAGE_ONLY;
        public static final LocaleType LOCALE;

        public static LocaleType valueOf(String s)
        {
            return (LocaleType)Enum.valueOf(com/amazon/gallery/foundation/metrics/amazoninsights/AmazonInsightsHelper$LocaleType, s);
        }

        public static LocaleType[] values()
        {
            return (LocaleType[])$VALUES.clone();
        }

        static 
        {
            LANGUAGE_ONLY = new LocaleType("LANGUAGE_ONLY", 0);
            LOCALE = new LocaleType("LOCALE", 1);
            $VALUES = (new LocaleType[] {
                LANGUAGE_ONLY, LOCALE
            });
        }

        private LocaleType(String s, int i)
        {
            super(s, i);
        }
    }

    public static interface TextLoadedListener
    {

        public abstract void onTextLoaded(String s);
    }


    private static final String TAG = com/amazon/gallery/foundation/metrics/amazoninsights/AmazonInsightsHelper.getName();
    private AmazonInsights amazonInsights;
    private Context appContext;
    private Set recordedEvents;

    public AmazonInsightsHelper(Context context)
    {
        recordedEvents = new HashSet();
        appContext = context;
    }

    private AmazonInsights getAmazonInsights()
    {
        this;
        JVM INSTR monitorenter ;
        if (amazonInsights == null) goto _L2; else goto _L1
_L1:
        Object obj = amazonInsights;
_L4:
        this;
        JVM INSTR monitorexit ;
        return ((AmazonInsights) (obj));
_L2:
        GLogger.d(TAG, "Initializing AmazonInsights", new Object[0]);
        obj = AmazonInsights.newCredentials("f7fc6e9c3f004fc5a2e2c2ce1a34f17d", "/VyVBA15vbQlcYrNa1wYj1gSQMfTYJSre1qNoLQLELQ=");
        com.amazon.insights.InsightsOptions insightsoptions = AmazonInsights.newOptions(true, false);
        amazonInsights = AmazonInsights.newInstance(((com.amazon.insights.InsightsCredentials) (obj)), appContext, insightsoptions);
        amazonInsights.getUserProfile().addDimensionAsString("device", Build.DEVICE);
        obj = amazonInsights;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public static String getLocalizedLanguageVariant(LocaleType localetype, Context context, String s)
    {
        context = context.getResources().getConfiguration().locale;
        if (context == null) goto _L2; else goto _L1
_L1:
        static class _cls5
        {

            static final int $SwitchMap$com$amazon$gallery$foundation$metrics$amazoninsights$AmazonInsightsHelper$LocaleType[];

            static 
            {
                $SwitchMap$com$amazon$gallery$foundation$metrics$amazoninsights$AmazonInsightsHelper$LocaleType = new int[LocaleType.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$foundation$metrics$amazoninsights$AmazonInsightsHelper$LocaleType[LocaleType.LANGUAGE_ONLY.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$foundation$metrics$amazoninsights$AmazonInsightsHelper$LocaleType[LocaleType.LOCALE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls5..SwitchMap.com.amazon.gallery.foundation.metrics.amazoninsights.AmazonInsightsHelper.LocaleType[localetype.ordinal()];
        JVM INSTR tableswitch 1 2: default 44
    //                   1 46
    //                   2 89;
           goto _L2 _L3 _L4
_L2:
        return s;
_L3:
        if (!context.getLanguage().equals(Locale.ENGLISH.getLanguage()))
        {
            return (new StringBuilder()).append(s).append("-").append(context.getLanguage()).toString();
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (!context.equals(Locale.US))
        {
            return (new StringBuilder()).append(s).append("-").append(context.toString()).toString();
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public void init()
    {
        getAmazonInsights();
    }

    public void loadABText(final Context context, final String projectName, final String showText, final String textPrefix, final TextLoadedListener textLoadedListener)
    {
        getAmazonInsights().getABTestClient().getVariations(new String[] {
            projectName
        }).setCallback(new InsightsCallback() {

            final AmazonInsightsHelper this$0;
            final Context val$context;
            final String val$projectName;
            final String val$showText;
            final TextLoadedListener val$textLoadedListener;
            final String val$textPrefix;

            public void onComplete(VariationSet variationset)
            {
                Variation variation = variationset.getVariation(projectName);
                if (variation.getVariableAsBoolean(showText, false))
                {
                    String s = variation.getVariableAsString(AmazonInsightsHelper.getLocalizedLanguageVariant(LocaleType.LOCALE, context, textPrefix), null);
                    variationset = s;
                    if (s == null)
                    {
                        variationset = variation.getVariableAsString(AmazonInsightsHelper.getLocalizedLanguageVariant(LocaleType.LANGUAGE_ONLY, context, textPrefix), null);
                    }
                    if (variationset != null)
                    {
                        textLoadedListener.onTextLoaded(variationset);
                    }
                }
            }

            public volatile void onComplete(Object obj)
            {
                onComplete((VariationSet)obj);
            }

            
            {
                this$0 = AmazonInsightsHelper.this;
                projectName = s;
                showText = s1;
                context = context1;
                textPrefix = s2;
                textLoadedListener = textloadedlistener;
                super();
            }
        });
    }

    public void loadABText(final String projectName, final String textVariable, final TextLoadedListener textLoadedListener)
    {
        getAmazonInsights().getABTestClient().getVariations(new String[] {
            projectName
        }).setCallback(new InsightsCallback() {

            final AmazonInsightsHelper this$0;
            final String val$projectName;
            final TextLoadedListener val$textLoadedListener;
            final String val$textVariable;

            public void onComplete(VariationSet variationset)
            {
                variationset = variationset.getVariation(projectName).getVariableAsString(textVariable, null);
                textLoadedListener.onTextLoaded(variationset);
            }

            public volatile void onComplete(Object obj)
            {
                onComplete((VariationSet)obj);
            }

            
            {
                this$0 = AmazonInsightsHelper.this;
                projectName = s;
                textVariable = s1;
                textLoadedListener = textloadedlistener;
                super();
            }
        });
    }

    public void loadLaunch(final String projectName, final String variable, final LaunchLoadedListener launchLoadedListener)
    {
        getAmazonInsights().getABTestClient().getVariations(new String[] {
            projectName
        }).setCallback(new InsightsCallback() {

            final AmazonInsightsHelper this$0;
            final LaunchLoadedListener val$launchLoadedListener;
            final String val$projectName;
            final String val$variable;

            public void onComplete(VariationSet variationset)
            {
                boolean flag = variationset.getVariation(projectName).getVariableAsBoolean(variable, false);
                launchLoadedListener.onLaunchLoaded(flag);
            }

            public volatile void onComplete(Object obj)
            {
                onComplete((VariationSet)obj);
            }

            
            {
                this$0 = AmazonInsightsHelper.this;
                projectName = s;
                variable = s1;
                launchLoadedListener = launchloadedlistener;
                super();
            }
        });
    }

    public void loadLaunch(final String projectName, final String launchVariable, final String textVariable, final LaunchAndTextLoadedListener launchLoadedListener)
    {
        getAmazonInsights().getABTestClient().getVariations(new String[] {
            projectName
        }).setCallback(new InsightsCallback() {

            final AmazonInsightsHelper this$0;
            final LaunchAndTextLoadedListener val$launchLoadedListener;
            final String val$launchVariable;
            final String val$projectName;
            final String val$textVariable;

            public void onComplete(VariationSet variationset)
            {
                variationset = variationset.getVariation(projectName);
                boolean flag = variationset.getVariableAsBoolean(launchVariable, false);
                variationset = variationset.getVariableAsString(textVariable, null);
                launchLoadedListener.onLoaded(flag, variationset);
            }

            public volatile void onComplete(Object obj)
            {
                onComplete((VariationSet)obj);
            }

            
            {
                this$0 = AmazonInsightsHelper.this;
                projectName = s;
                launchVariable = s1;
                textVariable = s2;
                launchLoadedListener = launchandtextloadedlistener;
                super();
            }
        });
    }

    public void pauseSession()
    {
        getAmazonInsights().getSessionClient().pauseSession();
    }

    public void recordEvent(Enum enum)
    {
        recordEvent(enum.toString());
    }

    public void recordEvent(String s)
    {
        com.amazon.insights.Event event = getAmazonInsights().getEventClient().createEvent(s);
        getAmazonInsights().getEventClient().recordEvent(event);
        recordedEvents.add(s);
    }

    public void recordEventWithPrecondition(Enum enum, Enum enum1)
    {
        if (recordedEvents.contains(enum1.toString()))
        {
            recordEvent(enum.toString());
            return;
        } else
        {
            GLogger.d(TAG, "Skipping event %s, precondition %s not satisfied", new Object[] {
                enum, enum1
            });
            return;
        }
    }

    public void resumeSession()
    {
        getAmazonInsights().getSessionClient().resumeSession();
    }

    public void submitEvents()
    {
        getAmazonInsights().getEventClient().submitEvents();
    }

}
