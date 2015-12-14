// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.net;

import java.net.Socket;
import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

public class SSLSocketFactoryEx extends SSLSocketFactory
{

    private static final String TAG = com/sina/weibo/sdk/net/SSLSocketFactoryEx.getName();
    SSLContext sslContext;

    public SSLSocketFactoryEx(KeyStore keystore)
    {
        super(keystore);
        sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new TrustManager[] {
            new KeyStoresTrustManagerEX(new KeyStore[] {
                keystore
            })
        }, null);
    }

    public Socket createSocket()
    {
        return sslContext.getSocketFactory().createSocket();
    }

    public Socket createSocket(Socket socket, String s, int i, boolean flag)
    {
        return sslContext.getSocketFactory().createSocket(socket, s, i, flag);
    }


    private class KeyStoresTrustManagerEX
        implements X509TrustManager
    {

        protected ArrayList x509TrustManagers;

        public void checkClientTrusted(X509Certificate ax509certificate[], String s)
        {
            ((X509TrustManager)x509TrustManagers.get(0)).checkClientTrusted(ax509certificate, s);
        }

        public void checkServerTrusted(X509Certificate ax509certificate[], String s)
        {
            Iterator iterator = x509TrustManagers.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    throw new CertificateException();
                }
                X509TrustManager x509trustmanager = (X509TrustManager)iterator.next();
                try
                {
                    x509trustmanager.checkServerTrusted(ax509certificate, s);
                    return;
                }
                catch (CertificateException certificateexception) { }
            } while (true);
        }

        public X509Certificate[] getAcceptedIssuers()
        {
            ArrayList arraylist = new ArrayList();
            Iterator iterator = x509TrustManagers.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    return (X509Certificate[])arraylist.toArray(new X509Certificate[arraylist.size()]);
                }
                arraylist.addAll(Arrays.asList(((X509TrustManager)iterator.next()).getAcceptedIssuers()));
            } while (true);
        }

        protected transient KeyStoresTrustManagerEX(KeyStore akeystore[])
        {
            x509TrustManagers = new ArrayList();
            ArrayList arraylist = new ArrayList();
            KeyStore keystore;
            TrustManagerFactory trustmanagerfactory1;
            int i;
            int k;
            try
            {
                TrustManagerFactory trustmanagerfactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustmanagerfactory.init(null);
                arraylist.add(trustmanagerfactory);
                k = akeystore.length;
            }
            // Misplaced declaration of an exception variable
            catch (KeyStore akeystore[])
            {
                throw new RuntimeException(akeystore);
            }
            i = 0;
            if (i < k) goto _L2; else goto _L1
_L1:
            akeystore = arraylist.iterator();
_L3:
            TrustManager atrustmanager[];
            TrustManager trustmanager;
            int j;
            int l;
            if (!akeystore.hasNext())
            {
                if (x509TrustManagers.size() == 0)
                {
                    throw new RuntimeException("Couldn't find any X509TrustManagers");
                } else
                {
                    return;
                }
            }
            break MISSING_BLOCK_LABEL_134;
_L2:
            keystore = akeystore[i];
            trustmanagerfactory1 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustmanagerfactory1.init(keystore);
            arraylist.add(trustmanagerfactory1);
            i++;
            break MISSING_BLOCK_LABEL_48;
            atrustmanager = ((TrustManagerFactory)akeystore.next()).getTrustManagers();
            l = atrustmanager.length;
            j = 0;
            while (j < l) 
            {
                trustmanager = atrustmanager[j];
                if (trustmanager instanceof X509TrustManager)
                {
                    x509TrustManagers.add((X509TrustManager)trustmanager);
                }
                j++;
            }
              goto _L3
        }
    }

}
