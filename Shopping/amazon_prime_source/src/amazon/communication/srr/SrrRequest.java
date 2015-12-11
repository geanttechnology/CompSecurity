// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication.srr;

import amazon.communication.authentication.RequestContext;
import amazon.communication.connection.CompressionOption;
import amazon.communication.identity.EndpointIdentity;
import com.amazon.client.metrics.MetricEvent;
import com.amazon.client.metrics.NullMetricEvent;
import org.apache.http.client.methods.HttpRequestBase;

public class SrrRequest
{
    public static class Builder
    {

        private static final MetricEvent sBuilderNullMetricEvent = new NullMetricEvent("Srr", "SrrRequest");
        private CompressionOption mBuilderCompressionOption;
        private EndpointIdentity mBuilderEndpointIdentity;
        private boolean mBuilderIsClearTextAllowed;
        private boolean mBuilderIsWiFiNecessary;
        private MetricEvent mBuilderMetricEvent;
        private HttpRequestBase mBuilderRequest;
        private RequestContext mBuilderRequestContext;
        private int mBuilderTimeoutInMillis;
        private boolean mIsLocked;

        public SrrRequest build()
            throws IllegalAccessException
        {
            if (mIsLocked)
            {
                throw new IllegalAccessException("Instance already locked");
            }
            mIsLocked = true;
            if (mBuilderRequest == null)
            {
                throw new IllegalArgumentException("Request cannot be null");
            }
            if (mBuilderEndpointIdentity == null)
            {
                throw new IllegalArgumentException("EndpointIdentity cannot be null");
            } else
            {
                return new SrrRequest(this);
            }
        }

        public Builder setCompressionOption(CompressionOption compressionoption)
            throws IllegalAccessException
        {
            if (mIsLocked)
            {
                throw new IllegalAccessException("Instance already locked");
            }
            if (compressionoption != null)
            {
                mBuilderCompressionOption = compressionoption;
            }
            return this;
        }

        public Builder setEndpointIdentity(EndpointIdentity endpointidentity)
            throws IllegalAccessException
        {
            if (mIsLocked)
            {
                throw new IllegalAccessException("Instance already locked");
            } else
            {
                mBuilderEndpointIdentity = endpointidentity;
                return this;
            }
        }

        public Builder setMetricEvent(MetricEvent metricevent)
            throws IllegalAccessException
        {
            if (mIsLocked)
            {
                throw new IllegalAccessException("Instance already locked");
            }
            if (metricevent != null)
            {
                mBuilderMetricEvent = metricevent;
            }
            return this;
        }

        public Builder setRequest(HttpRequestBase httprequestbase)
            throws IllegalAccessException
        {
            if (mIsLocked)
            {
                throw new IllegalAccessException("Instance already locked");
            } else
            {
                mBuilderRequest = httprequestbase;
                return this;
            }
        }

        public Builder setRequestContext(RequestContext requestcontext)
            throws IllegalAccessException
        {
            if (mIsLocked)
            {
                throw new IllegalAccessException("Instance already locked");
            } else
            {
                mBuilderRequestContext = requestcontext;
                return this;
            }
        }

        public Builder setTimeout(int i)
            throws IllegalAccessException
        {
            if (mIsLocked)
            {
                throw new IllegalAccessException("Instance already locked");
            }
            if (i < 0)
            {
                throw new IllegalArgumentException("Timeout must not be negative!");
            } else
            {
                mBuilderTimeoutInMillis = i;
                return this;
            }
        }










        public Builder()
        {
            mBuilderMetricEvent = sBuilderNullMetricEvent;
            mBuilderTimeoutInMillis = 0;
            mBuilderCompressionOption = CompressionOption.ALLOWED;
            mBuilderIsWiFiNecessary = false;
            mBuilderIsClearTextAllowed = false;
            mBuilderRequestContext = null;
            mIsLocked = false;
        }
    }


    private final CompressionOption mCompressionOption;
    private final EndpointIdentity mEndpointIdentity;
    private final boolean mIsClearTextAllowed;
    private final boolean mIsWiFiNecessary;
    private final MetricEvent mMetricEvent;
    private final HttpRequestBase mRequest;
    private final RequestContext mRequestContext;
    private final int mTimeoutInMillis;

    private SrrRequest(Builder builder)
    {
        mEndpointIdentity = builder.mBuilderEndpointIdentity;
        mTimeoutInMillis = builder.mBuilderTimeoutInMillis;
        mRequest = builder.mBuilderRequest;
        mMetricEvent = builder.mBuilderMetricEvent;
        mCompressionOption = builder.mBuilderCompressionOption;
        mIsWiFiNecessary = builder.mBuilderIsWiFiNecessary;
        mIsClearTextAllowed = builder.mBuilderIsClearTextAllowed;
        mRequestContext = builder.mBuilderRequestContext;
    }


    public CompressionOption getCompressionOption()
    {
        return mCompressionOption;
    }

    public EndpointIdentity getEndpointIdentity()
    {
        return mEndpointIdentity;
    }

    public MetricEvent getMetricEvent()
    {
        return mMetricEvent;
    }

    public HttpRequestBase getRequest()
    {
        return mRequest;
    }

    public RequestContext getRequestContext()
    {
        return mRequestContext;
    }

    public int getTimeout()
    {
        return mTimeoutInMillis;
    }

    public boolean isClearTextAllowed()
    {
        return mIsClearTextAllowed;
    }

    public boolean isWiFiNecessary()
    {
        return mIsWiFiNecessary;
    }
}
