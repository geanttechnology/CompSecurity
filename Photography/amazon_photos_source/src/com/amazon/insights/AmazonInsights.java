// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights;

import android.content.Context;
import com.amazon.insights.abtest.DefaultABTestClient;
import com.amazon.insights.core.DefaultInsightsContext;
import com.amazon.insights.core.InsightsContext;
import com.amazon.insights.core.crash.CrashReporter;
import com.amazon.insights.core.crash.ers.ERSClient;
import com.amazon.insights.core.crash.ers.ERSCrashAppender;
import com.amazon.insights.core.http.HttpClient;
import com.amazon.insights.core.http.RequestTimingInterceptor;
import com.amazon.insights.core.log.Logger;
import com.amazon.insights.core.system.System;
import com.amazon.insights.core.util.Preconditions;
import com.amazon.insights.core.util.SDKInfo;
import com.amazon.insights.event.DefaultEventClient;
import com.amazon.insights.event.InternalEventClient;
import com.amazon.insights.impl.DefaultInsightsCredentials;
import com.amazon.insights.impl.DefaultInsightsOptions;
import com.amazon.insights.impl.DisabledAmazonInsights;
import com.amazon.insights.impl.InitializationException;
import com.amazon.insights.session.InternalSessionClient;
import com.amazon.insights.session.client.DefaultSessionClient;
import com.amazon.insights.validate.EncodingValidator;
import com.amazon.insights.validate.EncryptionValidator;
import com.amazon.insights.validate.FileManagerValidator;
import com.amazon.insights.validate.PermissionValidator;
import com.amazon.insights.validate.SHA256Validator;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.amazon.insights:
//            InsightsOptions, InsightsCredentials, InsightsCallback, ABTestClient, 
//            EventClient, SessionClient, UserProfile

public abstract class AmazonInsights
{
    static final class DefaultAmazonInsights extends AmazonInsights
    {

        private final ABTestClient abClient;
        private final InsightsContext context;
        private final CrashReporter crashReporter;
        private final InternalEventClient eventClient;
        private final InternalSessionClient sessionClient;

        public ABTestClient getABTestClient()
        {
            return abClient;
        }

        public EventClient getEventClient()
        {
            return eventClient;
        }

        public SessionClient getSessionClient()
        {
            return sessionClient;
        }

        public UserProfile getUserProfile()
        {
            return context.getUserProfile();
        }

        DefaultAmazonInsights(InsightsContext insightscontext, InsightsOptions insightsoptions, InsightsCallback insightscallback)
            throws InitializationException
        {
            Preconditions.checkNotNull(insightscontext, "The InsightsContext provided must not be null");
            try
            {
                Logger.tryInitialize();
                crashReporter = new CrashReporter(com/amazon/insights/AmazonInsights);
                ERSClient ersclient = ERSClient.newInstance(insightscontext);
                crashReporter.attachAppender(new ERSCrashAppender(insightscontext, ersclient));
            }
            // Misplaced declaration of an exception variable
            catch (InsightsContext insightscontext)
            {
                AmazonInsights.logger.deve("Cannot initialize Logging System", insightscontext);
                throw new InitializationException("Cannot initialize Logging System", insightscontext);
            }
            try
            {
                AmazonInsights.encodingValidator.validate();
                AmazonInsights.sha256Validator.validate();
                AmazonInsights.aesEncryptionValidator.validate();
                AmazonInsights.fileManagerValidator.validate(insightscontext);
                context = insightscontext;
            }
            // Misplaced declaration of an exception variable
            catch (InsightsContext insightscontext)
            {
                try
                {
                    crashReporter.report("Failed initialization of Insights client", insightscontext);
                }
                // Misplaced declaration of an exception variable
                catch (InsightsOptions insightsoptions)
                {
                    AmazonInsights.logger.deve("Error occurred while trying to report Initialization Error", insightsoptions);
                }
                AmazonInsights.logger.deve("Cannot initialize Amazon Insights SDK", insightscontext);
                throw new InitializationException("Could not initialize Insights SDK", insightscontext);
            }
            if (insightsoptions == null)
            {
                break MISSING_BLOCK_LABEL_221;
            }
            eventClient = DefaultEventClient.newInstance(insightscontext, insightsoptions.getAllowEventCollection());
_L1:
            sessionClient = DefaultSessionClient.newInstance(insightscontext, eventClient);
            insightscontext.getHttpClient().addInterceptor(new RequestTimingInterceptor(insightscontext.getSystem().getConnectivity(), eventClient));
            abClient = DefaultABTestClient.newInstance(insightscontext, eventClient);
            if (insightscallback == null)
            {
                break MISSING_BLOCK_LABEL_164;
            }
            insightscallback.onComplete(this);
            sessionClient.startSession();
            insightscontext.synchronize();
            AmazonInsights.logger.devi(String.format("Amazon Insights SDK(%s) initialization successfully completed", new Object[] {
                "2.1.26.0"
            }));
            return;
            eventClient = DefaultEventClient.newInstance(insightscontext, newDefaultOptions().getAllowEventCollection());
              goto _L1
        }
    }


    private static final DisabledAmazonInsights DISABLED_AMAZON_INSIGHTS = new DisabledAmazonInsights();
    private static final PermissionValidator accessNetworkStatePermissionValidator = new PermissionValidator("android.permission.ACCESS_NETWORK_STATE");
    private static final EncryptionValidator aesEncryptionValidator = new EncryptionValidator("ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEF", "AES");
    private static final EncodingValidator encodingValidator = new EncodingValidator("UTF-8");
    private static final FileManagerValidator fileManagerValidator = new FileManagerValidator();
    private static final Map instances = new ConcurrentHashMap();
    private static final PermissionValidator internetPermissionValidator = new PermissionValidator("android.permission.INTERNET");
    private static final Logger logger = Logger.getLogger(com/amazon/insights/AmazonInsights);
    private static final SDKInfo sdkInfo = new SDKInfo("AmazonInsightsSDK", "2.1.26.0");
    private static final SHA256Validator sha256Validator = new SHA256Validator();

    protected AmazonInsights()
    {
    }

    public static InsightsCredentials newCredentials(String s, String s1)
    {
        Preconditions.checkNotNull(s, "The application key provided must not be null");
        Preconditions.checkNotNull(s1, "The private key provided must not be null");
        return new DefaultInsightsCredentials(s, s1);
    }

    public static InsightsOptions newDefaultOptions()
    {
        return new DefaultInsightsOptions(true, false);
    }

    public static AmazonInsights newInstance(InsightsCredentials insightscredentials, Context context, InsightsOptions insightsoptions)
        throws NullPointerException
    {
        com/amazon/insights/AmazonInsights;
        JVM INSTR monitorenter ;
        insightscredentials = newInstance(insightscredentials, context, insightsoptions, ((Map) (new HashMap())), null);
        com/amazon/insights/AmazonInsights;
        JVM INSTR monitorexit ;
        return insightscredentials;
        insightscredentials;
        throw insightscredentials;
    }

    static AmazonInsights newInstance(InsightsCredentials insightscredentials, Context context, InsightsOptions insightsoptions, Map map, InsightsCallback insightscallback)
        throws NullPointerException
    {
        com/amazon/insights/AmazonInsights;
        JVM INSTR monitorenter ;
        Preconditions.checkNotNull(insightscredentials, "The credentials provided must not be null");
        Preconditions.checkNotNull(context, "The application context provided must not be null");
        Preconditions.checkNotNull(insightsoptions, "The options provided must not be null");
        if (!instances.containsKey(insightscredentials)) goto _L2; else goto _L1
_L1:
        insightscredentials = (AmazonInsights)instances.get(insightscredentials);
_L4:
        com/amazon/insights/AmazonInsights;
        JVM INSTR monitorexit ;
        return insightscredentials;
_L2:
        Logger.tryInitialize();
        internetPermissionValidator.validate(context);
        accessNetworkStatePermissionValidator.validate(context);
        insightscredentials = DefaultInsightsContext.newInstance(insightscredentials, context, sdkInfo, insightsoptions.getAllowWANDelivery(), map);
        insightscredentials = newInstance(((InsightsContext) (insightscredentials)), insightsoptions, insightscallback);
        continue; /* Loop/switch isn't completed */
        insightscredentials;
        logger.deve("Error occurred while trying to initialize Insights Context", insightscredentials);
        insightscredentials = new DisabledAmazonInsights();
        if (true) goto _L4; else goto _L3
_L3:
        insightscredentials;
        throw insightscredentials;
    }

    static AmazonInsights newInstance(InsightsContext insightscontext, InsightsOptions insightsoptions, InsightsCallback insightscallback)
    {
        com/amazon/insights/AmazonInsights;
        JVM INSTR monitorenter ;
        Preconditions.checkNotNull(insightscontext, "The context provided must not be null");
        if (!instances.containsKey(insightscontext.getCredentials())) goto _L2; else goto _L1
_L1:
        insightscontext = (AmazonInsights)instances.get(insightscontext.getCredentials());
_L5:
        com/amazon/insights/AmazonInsights;
        JVM INSTR monitorexit ;
        return insightscontext;
_L2:
        insightsoptions = new DefaultAmazonInsights(insightscontext, insightsoptions, insightscallback);
_L3:
        instances.put(insightscontext.getCredentials(), insightsoptions);
        insightscontext = insightsoptions;
        continue; /* Loop/switch isn't completed */
        insightsoptions;
        insightsoptions = DISABLED_AMAZON_INSIGHTS;
          goto _L3
        insightscontext;
        throw insightscontext;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static InsightsOptions newOptions(boolean flag, boolean flag1)
    {
        return new DefaultInsightsOptions(flag, flag1);
    }

    public abstract ABTestClient getABTestClient();

    public abstract EventClient getEventClient();

    public abstract SessionClient getSessionClient();

    public abstract UserProfile getUserProfile();






}
