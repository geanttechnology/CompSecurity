// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package twitter4j.conf;

import java.util.Properties;

// Referenced classes of package twitter4j.conf:
//            PropertyConfiguration, ConfigurationBase, Configuration

public final class ConfigurationBuilder
{

    private ConfigurationBase configurationBean;

    public ConfigurationBuilder()
    {
        configurationBean = new PropertyConfiguration();
    }

    private void checkNotBuilt()
    {
        if (configurationBean == null)
        {
            throw new IllegalStateException("Cannot use this builder any longer, build() has already been called");
        } else
        {
            return;
        }
    }

    public Configuration build()
    {
        checkNotBuilt();
        configurationBean.cacheInstance();
        ConfigurationBase configurationbase = configurationBean;
        configurationBean = null;
        return configurationbase;
        Exception exception;
        exception;
        configurationBean = null;
        throw exception;
    }

    public ConfigurationBuilder setAsyncNumThreads(int i)
    {
        checkNotBuilt();
        configurationBean.setAsyncNumThreads(i);
        return this;
    }

    public ConfigurationBuilder setClientURL(String s)
    {
        checkNotBuilt();
        configurationBean.setClientURL(s);
        return this;
    }

    public ConfigurationBuilder setClientVersion(String s)
    {
        checkNotBuilt();
        configurationBean.setClientVersion(s);
        return this;
    }

    public ConfigurationBuilder setContributingTo(long l)
    {
        checkNotBuilt();
        configurationBean.setContributingTo(l);
        return this;
    }

    public ConfigurationBuilder setDebugEnabled(boolean flag)
    {
        checkNotBuilt();
        configurationBean.setDebug(flag);
        return this;
    }

    public ConfigurationBuilder setDispatcherImpl(String s)
    {
        checkNotBuilt();
        configurationBean.setDispatcherImpl(s);
        return this;
    }

    public ConfigurationBuilder setGZIPEnabled(boolean flag)
    {
        checkNotBuilt();
        configurationBean.setGZIPEnabled(flag);
        return this;
    }

    public ConfigurationBuilder setHttpConnectionTimeout(int i)
    {
        checkNotBuilt();
        configurationBean.setHttpConnectionTimeout(i);
        return this;
    }

    public ConfigurationBuilder setHttpDefaultMaxPerRoute(int i)
    {
        checkNotBuilt();
        configurationBean.setHttpDefaultMaxPerRoute(i);
        return this;
    }

    public ConfigurationBuilder setHttpMaxTotalConnections(int i)
    {
        checkNotBuilt();
        configurationBean.setHttpMaxTotalConnections(i);
        return this;
    }

    public ConfigurationBuilder setHttpProxyHost(String s)
    {
        checkNotBuilt();
        configurationBean.setHttpProxyHost(s);
        return this;
    }

    public ConfigurationBuilder setHttpProxyPassword(String s)
    {
        checkNotBuilt();
        configurationBean.setHttpProxyPassword(s);
        return this;
    }

    public ConfigurationBuilder setHttpProxyPort(int i)
    {
        checkNotBuilt();
        configurationBean.setHttpProxyPort(i);
        return this;
    }

    public ConfigurationBuilder setHttpProxyUser(String s)
    {
        checkNotBuilt();
        configurationBean.setHttpProxyUser(s);
        return this;
    }

    public ConfigurationBuilder setHttpReadTimeout(int i)
    {
        checkNotBuilt();
        configurationBean.setHttpReadTimeout(i);
        return this;
    }

    public ConfigurationBuilder setHttpRetryCount(int i)
    {
        checkNotBuilt();
        configurationBean.setHttpRetryCount(i);
        return this;
    }

    public ConfigurationBuilder setHttpRetryIntervalSeconds(int i)
    {
        checkNotBuilt();
        configurationBean.setHttpRetryIntervalSeconds(i);
        return this;
    }

    public ConfigurationBuilder setHttpStreamingReadTimeout(int i)
    {
        checkNotBuilt();
        configurationBean.setHttpStreamingReadTimeout(i);
        return this;
    }

    public ConfigurationBuilder setIncludeEntitiesEnabled(boolean flag)
    {
        checkNotBuilt();
        configurationBean.setIncludeEntitiesEnbled(flag);
        return this;
    }

    public ConfigurationBuilder setIncludeMyRetweetEnabled(boolean flag)
    {
        checkNotBuilt();
        configurationBean.setIncludeMyRetweetEnabled(flag);
        return this;
    }

    public ConfigurationBuilder setIncludeRTsEnabled(boolean flag)
    {
        checkNotBuilt();
        configurationBean.setIncludeRTsEnbled(flag);
        return this;
    }

    public ConfigurationBuilder setJSONStoreEnabled(boolean flag)
    {
        checkNotBuilt();
        configurationBean.setJSONStoreEnabled(flag);
        return this;
    }

    public ConfigurationBuilder setLoggerImpl(String s)
    {
        checkNotBuilt();
        configurationBean.setLoggerFactory(s);
        return this;
    }

    public ConfigurationBuilder setMBeanEnabled(boolean flag)
    {
        checkNotBuilt();
        configurationBean.setMBeanEnabled(flag);
        return this;
    }

    public ConfigurationBuilder setMediaProvider(String s)
    {
        checkNotBuilt();
        configurationBean.setMediaProvider(s);
        return this;
    }

    public ConfigurationBuilder setMediaProviderAPIKey(String s)
    {
        checkNotBuilt();
        configurationBean.setMediaProviderAPIKey(s);
        return this;
    }

    public ConfigurationBuilder setMediaProviderParameters(Properties properties)
    {
        checkNotBuilt();
        configurationBean.setMediaProviderParameters(properties);
        return this;
    }

    public ConfigurationBuilder setOAuthAccessToken(String s)
    {
        checkNotBuilt();
        configurationBean.setOAuthAccessToken(s);
        return this;
    }

    public ConfigurationBuilder setOAuthAccessTokenSecret(String s)
    {
        checkNotBuilt();
        configurationBean.setOAuthAccessTokenSecret(s);
        return this;
    }

    public ConfigurationBuilder setOAuthAccessTokenURL(String s)
    {
        checkNotBuilt();
        configurationBean.setOAuthAccessTokenURL(s);
        return this;
    }

    public ConfigurationBuilder setOAuthAuthenticationURL(String s)
    {
        checkNotBuilt();
        configurationBean.setOAuthAuthenticationURL(s);
        return this;
    }

    public ConfigurationBuilder setOAuthAuthorizationURL(String s)
    {
        checkNotBuilt();
        configurationBean.setOAuthAuthorizationURL(s);
        return this;
    }

    public ConfigurationBuilder setOAuthConsumerKey(String s)
    {
        checkNotBuilt();
        configurationBean.setOAuthConsumerKey(s);
        return this;
    }

    public ConfigurationBuilder setOAuthConsumerSecret(String s)
    {
        checkNotBuilt();
        configurationBean.setOAuthConsumerSecret(s);
        return this;
    }

    public ConfigurationBuilder setOAuthRequestTokenURL(String s)
    {
        checkNotBuilt();
        configurationBean.setOAuthRequestTokenURL(s);
        return this;
    }

    public ConfigurationBuilder setPassword(String s)
    {
        checkNotBuilt();
        configurationBean.setPassword(s);
        return this;
    }

    public ConfigurationBuilder setPrettyDebugEnabled(boolean flag)
    {
        checkNotBuilt();
        configurationBean.setPrettyDebugEnabled(flag);
        return this;
    }

    public ConfigurationBuilder setRestBaseURL(String s)
    {
        checkNotBuilt();
        configurationBean.setRestBaseURL(s);
        return this;
    }

    public ConfigurationBuilder setSiteStreamBaseURL(String s)
    {
        checkNotBuilt();
        configurationBean.setSiteStreamBaseURL(s);
        return this;
    }

    public ConfigurationBuilder setStreamBaseURL(String s)
    {
        checkNotBuilt();
        configurationBean.setStreamBaseURL(s);
        return this;
    }

    public ConfigurationBuilder setUseSSL(boolean flag)
    {
        checkNotBuilt();
        configurationBean.setUseSSL(flag);
        return this;
    }

    public ConfigurationBuilder setUser(String s)
    {
        checkNotBuilt();
        configurationBean.setUser(s);
        return this;
    }

    public ConfigurationBuilder setUserStreamBaseURL(String s)
    {
        checkNotBuilt();
        configurationBean.setUserStreamBaseURL(s);
        return this;
    }

    public ConfigurationBuilder setUserStreamRepliesAllEnabled(boolean flag)
    {
        checkNotBuilt();
        configurationBean.setUserStreamRepliesAllEnabled(flag);
        return this;
    }
}
