// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.transport;

import amazon.communication.MissingCredentialsException;
import amazon.communication.RequestFailedException;
import amazon.communication.TimeoutException;
import amazon.communication.authentication.AccountRequestContext;
import amazon.communication.authentication.RequestSigner;
import amazon.communication.identity.EndpointIdentity;
import amazon.communication.srr.HttpClientSrrManager;
import amazon.communication.srr.SrrManager;
import android.content.Context;
import com.amazon.client.metrics.MetricEvent;
import com.amazon.client.metrics.configuration.CodecConfiguration;
import com.amazon.client.metrics.configuration.CodecType;
import com.amazon.client.metrics.configuration.MetricsConfiguration;
import com.amazon.client.metrics.configuration.NetworkConfiguration;
import com.amazon.client.metrics.configuration.NetworkType;
import com.amazon.communication.authentication.DcpRequestSigner;
import com.amazon.device.utils.DeviceUtil;
import com.amazon.device.utils.NetworkManager;
import com.amazon.dp.logger.DPLogger;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.ByteArrayEntity;

// Referenced classes of package com.amazon.client.metrics.transport:
//            MetricsTransport, TransportStateNotifier, StaticCredentialRequestSigner, HttpClientFactory, 
//            MetricsHttpRequestSigner

public class HTTPMetricsTransport
    implements MetricsTransport, TransportStateNotifier
{

    protected static final DPLogger log = new DPLogger("HTTPMetricsTransport");
    private RequestSigner mConfiguredRequestSigner;
    private Context mContext;
    private HttpClient mHttpClient;
    private MetricsConfiguration mMetricsConfiguration;
    private MetricsHttpRequestSigner mMetricsHttpRequestSigner;
    protected SrrManager mSrrManager;
    private RequestSigner mStaticCredentialRequestSigner;

    public HTTPMetricsTransport(Context context, MetricsConfiguration metricsconfiguration, DeviceUtil deviceutil, RequestSigner requestsigner)
        throws IllegalStateException
    {
        mHttpClient = null;
        if (context == null)
        {
            throw new IllegalArgumentException("context cannot be null");
        }
        if (metricsconfiguration == null)
        {
            throw new IllegalArgumentException("metricsConfiguration cannot be null");
        }
        if (deviceutil == null)
        {
            throw new IllegalArgumentException("deviceUtil cannot be null");
        }
        if (requestsigner == null)
        {
            throw new IllegalArgumentException("requestSigner cannot be null");
        }
        try
        {
            mContext = context;
            mMetricsConfiguration = metricsconfiguration;
            mConfiguredRequestSigner = requestsigner;
            mStaticCredentialRequestSigner = new StaticCredentialRequestSigner(deviceutil);
            mMetricsHttpRequestSigner = createMetricsHttpRequestSigner(metricsconfiguration, requestsigner);
            mHttpClient = HttpClientFactory.getSecureHttpClient("DeviceMetricsService");
            mSrrManager = new HttpClientSrrManager(mHttpClient, mMetricsHttpRequestSigner);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            log.error("HTTPMetricsTransport", "Failed to create HttpClient from HttpClientFactory: ", new Object[] {
                context
            });
            throw new RuntimeException(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            log.error("HTTPMetricsTransport", "Failed to create HttpClient from HttpClientFactory: ", new Object[] {
                context
            });
            throw new RuntimeException(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            log.error("HTTPMetricsTransport", "Failed to create HttpClient from HttpClientFactory: ", new Object[] {
                context
            });
            throw new RuntimeException(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            log.error("HTTPMetricsTransport", "Failed to create HttpClient from HttpClientFactory: ", new Object[] {
                context
            });
            throw new RuntimeException(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            log.error("HTTPMetricsTransport", "Failed to create HttpClient from HttpClientFactory: ", new Object[] {
                context
            });
        }
        throw new RuntimeException(context);
    }

    private int attemptToTransmit(byte abyte0[], MetricEvent metricevent, EndpointIdentity endpointidentity, boolean flag)
    {
        android.os.PowerManager.WakeLock wakelock;
        android.net.wifi.WifiManager.WifiLock wifilock;
        android.net.wifi.WifiManager.WifiLock wifilock1;
        android.os.PowerManager.WakeLock wakelock2;
        android.net.wifi.WifiManager.WifiLock wifilock2;
        android.os.PowerManager.WakeLock wakelock3;
        android.net.wifi.WifiManager.WifiLock wifilock3;
        android.os.PowerManager.WakeLock wakelock4;
        android.net.wifi.WifiManager.WifiLock wifilock4;
        android.os.PowerManager.WakeLock wakelock5;
        android.net.wifi.WifiManager.WifiLock wifilock5;
        android.os.PowerManager.WakeLock wakelock6;
        android.net.wifi.WifiManager.WifiLock wifilock6;
        android.os.PowerManager.WakeLock wakelock7;
        android.net.wifi.WifiManager.WifiLock wifilock7;
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        wakelock3 = null;
        wakelock4 = null;
        wakelock5 = null;
        wakelock6 = null;
        wakelock7 = null;
        wakelock = null;
        wakelock2 = null;
        obj = null;
        obj1 = null;
        obj2 = null;
        obj3 = null;
        obj4 = null;
        obj5 = null;
        wifilock1 = null;
        wifilock2 = wifilock1;
        wifilock3 = obj;
        wifilock4 = obj1;
        wifilock5 = obj2;
        wifilock6 = obj3;
        wifilock7 = obj4;
        wifilock = obj5;
        android.os.PowerManager.WakeLock wakelock1 = NetworkManager.instance(mContext).createWakeLock("HTTPMetricsTransportWakeLock");
        wakelock2 = wakelock1;
        wifilock2 = wifilock1;
        wakelock3 = wakelock1;
        wifilock3 = obj;
        wakelock4 = wakelock1;
        wifilock4 = obj1;
        wakelock5 = wakelock1;
        wifilock5 = obj2;
        wakelock6 = wakelock1;
        wifilock6 = obj3;
        wakelock7 = wakelock1;
        wifilock7 = obj4;
        wakelock = wakelock1;
        wifilock = obj5;
        NetworkManager.instance(mContext).acquireWakeLock(wakelock1);
        wakelock2 = wakelock1;
        wifilock2 = wifilock1;
        wakelock3 = wakelock1;
        wifilock3 = obj;
        wakelock4 = wakelock1;
        wifilock4 = obj1;
        wakelock5 = wakelock1;
        wifilock5 = obj2;
        wakelock6 = wakelock1;
        wifilock6 = obj3;
        wakelock7 = wakelock1;
        wifilock7 = obj4;
        wakelock = wakelock1;
        wifilock = obj5;
        wifilock1 = NetworkManager.instance(mContext).createWifiLock("HTTPMetricsTransport");
        if (wifilock1 == null)
        {
            break MISSING_BLOCK_LABEL_295;
        }
        wakelock2 = wakelock1;
        wifilock2 = wifilock1;
        wakelock3 = wakelock1;
        wifilock3 = wifilock1;
        wakelock4 = wakelock1;
        wifilock4 = wifilock1;
        wakelock5 = wakelock1;
        wifilock5 = wifilock1;
        wakelock6 = wakelock1;
        wifilock6 = wifilock1;
        wakelock7 = wakelock1;
        wifilock7 = wifilock1;
        wakelock = wakelock1;
        wifilock = wifilock1;
        NetworkManager.instance(mContext).acquireWifiLock(wifilock1);
        wakelock2 = wakelock1;
        wifilock2 = wifilock1;
        wakelock3 = wakelock1;
        wifilock3 = wifilock1;
        wakelock4 = wakelock1;
        wifilock4 = wifilock1;
        wakelock5 = wakelock1;
        wifilock5 = wifilock1;
        wakelock6 = wakelock1;
        wifilock6 = wifilock1;
        wakelock7 = wakelock1;
        wifilock7 = wifilock1;
        wakelock = wakelock1;
        wifilock = wifilock1;
        int i = makeRequest(abyte0, metricevent, endpointidentity);
        mMetricsHttpRequestSigner.setNextRequestSigner(mConfiguredRequestSigner);
        NetworkManager.instance(mContext).releaseWifiLock(wifilock1);
        NetworkManager.instance(mContext).releaseWakeLock(wakelock1);
        return i;
        endpointidentity;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_485;
        }
        wakelock = wakelock2;
        wifilock = wifilock2;
        mMetricsHttpRequestSigner.setNextRequestSigner(mStaticCredentialRequestSigner);
        wakelock = wakelock2;
        wifilock = wifilock2;
        i = attemptToTransmit(abyte0, metricevent, mMetricsConfiguration.getStaticCredentialEndpointIdentity(), false);
        mMetricsHttpRequestSigner.setNextRequestSigner(mConfiguredRequestSigner);
        NetworkManager.instance(mContext).releaseWifiLock(wifilock2);
        NetworkManager.instance(mContext).releaseWakeLock(wakelock2);
        return i;
        wakelock = wakelock2;
        wifilock = wifilock2;
        log.error("transmit", "MissingCredentialsException while transmitting", new Object[] {
            endpointidentity
        });
        mMetricsHttpRequestSigner.setNextRequestSigner(mConfiguredRequestSigner);
        NetworkManager.instance(mContext).releaseWifiLock(wifilock2);
        NetworkManager.instance(mContext).releaseWakeLock(wakelock2);
        return 5;
        abyte0;
        wakelock = wakelock3;
        wifilock = wifilock3;
        log.error("transmit", "RequestFailedException while transmitting", new Object[] {
            abyte0
        });
        mMetricsHttpRequestSigner.setNextRequestSigner(mConfiguredRequestSigner);
        NetworkManager.instance(mContext).releaseWifiLock(wifilock3);
        NetworkManager.instance(mContext).releaseWakeLock(wakelock3);
        return 9;
        abyte0;
        wakelock = wakelock4;
        wifilock = wifilock4;
        log.error("transmit", "IOException while getting response content after transmitting", new Object[] {
            abyte0
        });
        mMetricsHttpRequestSigner.setNextRequestSigner(mConfiguredRequestSigner);
        NetworkManager.instance(mContext).releaseWifiLock(wifilock4);
        NetworkManager.instance(mContext).releaseWakeLock(wakelock4);
        return 10;
        abyte0;
        wakelock = wakelock5;
        wifilock = wifilock5;
        log.error("transmit", "IllegalAccessException while transmitting", new Object[] {
            abyte0
        });
        mMetricsHttpRequestSigner.setNextRequestSigner(mConfiguredRequestSigner);
        NetworkManager.instance(mContext).releaseWifiLock(wifilock5);
        NetworkManager.instance(mContext).releaseWakeLock(wakelock5);
        return 11;
        abyte0;
        wakelock = wakelock6;
        wifilock = wifilock6;
        log.error("transmit", "TimeoutException while transmitting", new Object[] {
            abyte0
        });
        mMetricsHttpRequestSigner.setNextRequestSigner(mConfiguredRequestSigner);
        NetworkManager.instance(mContext).releaseWifiLock(wifilock6);
        NetworkManager.instance(mContext).releaseWakeLock(wakelock6);
        return 2;
        abyte0;
        wakelock = wakelock7;
        wifilock = wifilock7;
        log.error("transmit", "Exception while transmitting", new Object[] {
            abyte0
        });
        mMetricsHttpRequestSigner.setNextRequestSigner(mConfiguredRequestSigner);
        NetworkManager.instance(mContext).releaseWifiLock(wifilock7);
        NetworkManager.instance(mContext).releaseWakeLock(wakelock7);
        return 6;
        abyte0;
        mMetricsHttpRequestSigner.setNextRequestSigner(mConfiguredRequestSigner);
        NetworkManager.instance(mContext).releaseWifiLock(wifilock);
        NetworkManager.instance(mContext).releaseWakeLock(wakelock);
        throw abyte0;
    }

    private MetricsHttpRequestSigner createMetricsHttpRequestSigner(MetricsConfiguration metricsconfiguration, RequestSigner requestsigner)
    {
        HashMap hashmap = null;
        if (metricsconfiguration.getCodecConfiguration().getCodecType() == CodecType.PROTOCOL_BUFFERS)
        {
            hashmap = new HashMap();
            hashmap.put("x-codec-format", metricsconfiguration.getCodecConfiguration().getCodecType().getName());
            hashmap.put("x-codec-version", metricsconfiguration.getCodecConfiguration().getCodecVersion());
        }
        return new MetricsHttpRequestSigner(hashmap, requestsigner);
    }

    private int makeRequest(byte abyte0[], MetricEvent metricevent, EndpointIdentity endpointidentity)
        throws MissingCredentialsException, RequestFailedException, IOException, IllegalAccessException, TimeoutException
    {
        HttpPost httppost = new HttpPost("/metricsBatch");
        httppost.setEntity(new ByteArrayEntity(abyte0));
        metricevent = (new amazon.communication.srr.SrrRequest.Builder()).setRequest(httppost).setEndpointIdentity(endpointidentity).setTimeout(0).setMetricEvent(metricevent);
        if (mMetricsHttpRequestSigner.getNextRequestSigner() instanceof DcpRequestSigner)
        {
            abyte0 = AccountRequestContext.EMPTY_ACCOUNT;
        } else
        {
            abyte0 = null;
        }
        abyte0 = metricevent.setRequestContext(abyte0).build();
        abyte0 = mSrrManager.makeRequestSync(abyte0);
        if (abyte0 != null)
        {
            metricevent = abyte0.getStatusLine();
            log.debug("transmit", (new StringBuilder()).append("HttpResponse status code:").append(metricevent.getStatusCode()).toString(), new Object[0]);
            abyte0 = abyte0.getEntity();
            if (abyte0 == null)
            {
                abyte0 = null;
            } else
            {
                abyte0 = abyte0.getContent();
            }
            if (abyte0 != null)
            {
                abyte0.close();
            }
            if (metricevent != null)
            {
                if (metricevent.getStatusCode() >= 200 && metricevent.getStatusCode() < 300)
                {
                    log.debug("transmit", "Succesfully transmitted Metric", new Object[0]);
                    return 1;
                }
                if (metricevent.getStatusCode() >= 400 && metricevent.getStatusCode() < 500)
                {
                    return 3;
                }
                if (metricevent.getStatusCode() >= 500)
                {
                    return 4;
                }
            }
        }
        return 12;
    }

    public void close()
    {
        mHttpClient.getConnectionManager().closeIdleConnections(0L, TimeUnit.MILLISECONDS);
        mHttpClient.getConnectionManager().closeExpiredConnections();
    }

    protected boolean isEthernetAvailable()
        throws IllegalStateException
    {
        return mMetricsConfiguration.getNetworkConfiguration().getNetworkTypes().contains(NetworkType.ETHERNET) && NetworkManager.instance(mContext).isEthernetConnected();
    }

    protected boolean isWanAvailable()
        throws IllegalStateException
    {
        return mMetricsConfiguration.getNetworkConfiguration().getNetworkTypes().contains(NetworkType.WAN) && NetworkManager.instance(mContext).isWanConnected();
    }

    protected boolean isWifiAvailable()
        throws IllegalStateException
    {
        return mMetricsConfiguration.getNetworkConfiguration().getNetworkTypes().contains(NetworkType.WIFI) && NetworkManager.instance(mContext).isWifiConnected();
    }

    public void listenForTransportWarmed(TransportStateNotifier.TransportWarmedListener transportwarmedlistener)
    {
    }

    public int transmit(byte abyte0[], MetricEvent metricevent)
    {
        if (abyte0 == null || abyte0.length == 0)
        {
            log.error("transmit", "Transmitted metricBatch cannot be null", new Object[0]);
            return 8;
        }
        if (!isWifiAvailable() && !isEthernetAvailable() && !isWanAvailable())
        {
            log.warn("transmit", "Aborting metrics transmission because there is no usable connection.", new Object[0]);
            return 7;
        } else
        {
            return attemptToTransmit(abyte0, metricevent, mMetricsConfiguration.getEndpointIdentity(), true);
        }
    }

}
