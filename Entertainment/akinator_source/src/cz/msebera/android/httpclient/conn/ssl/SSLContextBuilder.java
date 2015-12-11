// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.conn.ssl;

import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;

// Referenced classes of package cz.msebera.android.httpclient.conn.ssl:
//            PrivateKeyStrategy, TrustStrategy, PrivateKeyDetails

public class SSLContextBuilder
{
    static class KeyManagerDelegate
        implements X509KeyManager
    {

        private final PrivateKeyStrategy aliasStrategy;
        private final X509KeyManager keyManager;

        public String chooseClientAlias(String as[], Principal aprincipal[], Socket socket)
        {
            HashMap hashmap = new HashMap();
            int k = as.length;
            for (int i = 0; i < k; i++)
            {
                String s = as[i];
                String as1[] = keyManager.getClientAliases(s, aprincipal);
                if (as1 == null)
                {
                    continue;
                }
                int l = as1.length;
                for (int j = 0; j < l; j++)
                {
                    String s1 = as1[j];
                    hashmap.put(s1, new PrivateKeyDetails(s, keyManager.getCertificateChain(s1)));
                }

            }

            return aliasStrategy.chooseAlias(hashmap, socket);
        }

        public String chooseServerAlias(String s, Principal aprincipal[], Socket socket)
        {
            HashMap hashmap = new HashMap();
            aprincipal = keyManager.getServerAliases(s, aprincipal);
            if (aprincipal != null)
            {
                int j = aprincipal.length;
                for (int i = 0; i < j; i++)
                {
                    Principal principal = aprincipal[i];
                    hashmap.put(principal, new PrivateKeyDetails(s, keyManager.getCertificateChain(principal)));
                }

            }
            return aliasStrategy.chooseAlias(hashmap, socket);
        }

        public X509Certificate[] getCertificateChain(String s)
        {
            return keyManager.getCertificateChain(s);
        }

        public String[] getClientAliases(String s, Principal aprincipal[])
        {
            return keyManager.getClientAliases(s, aprincipal);
        }

        public PrivateKey getPrivateKey(String s)
        {
            return keyManager.getPrivateKey(s);
        }

        public String[] getServerAliases(String s, Principal aprincipal[])
        {
            return keyManager.getServerAliases(s, aprincipal);
        }

        KeyManagerDelegate(X509KeyManager x509keymanager, PrivateKeyStrategy privatekeystrategy)
        {
            keyManager = x509keymanager;
            aliasStrategy = privatekeystrategy;
        }
    }

    static class TrustManagerDelegate
        implements X509TrustManager
    {

        private final X509TrustManager trustManager;
        private final TrustStrategy trustStrategy;

        public void checkClientTrusted(X509Certificate ax509certificate[], String s)
            throws CertificateException
        {
            trustManager.checkClientTrusted(ax509certificate, s);
        }

        public void checkServerTrusted(X509Certificate ax509certificate[], String s)
            throws CertificateException
        {
            if (!trustStrategy.isTrusted(ax509certificate, s))
            {
                trustManager.checkServerTrusted(ax509certificate, s);
            }
        }

        public X509Certificate[] getAcceptedIssuers()
        {
            return trustManager.getAcceptedIssuers();
        }

        TrustManagerDelegate(X509TrustManager x509trustmanager, TrustStrategy truststrategy)
        {
            trustManager = x509trustmanager;
            trustStrategy = truststrategy;
        }
    }


    static final String SSL = "SSL";
    static final String TLS = "TLS";
    private Set keymanagers;
    private String protocol;
    private SecureRandom secureRandom;
    private Set trustmanagers;

    public SSLContextBuilder()
    {
        keymanagers = new HashSet();
        trustmanagers = new HashSet();
    }

    public SSLContext build()
        throws NoSuchAlgorithmException, KeyManagementException
    {
        Object obj;
        TrustManager atrustmanager[];
        SSLContext sslcontext;
        if (protocol != null)
        {
            obj = protocol;
        } else
        {
            obj = "TLS";
        }
        sslcontext = SSLContext.getInstance(((String) (obj)));
        if (!keymanagers.isEmpty())
        {
            obj = (KeyManager[])keymanagers.toArray(new KeyManager[keymanagers.size()]);
        } else
        {
            obj = null;
        }
        if (!trustmanagers.isEmpty())
        {
            atrustmanager = (TrustManager[])trustmanagers.toArray(new TrustManager[trustmanagers.size()]);
        } else
        {
            atrustmanager = null;
        }
        sslcontext.init(((KeyManager []) (obj)), atrustmanager, secureRandom);
        return sslcontext;
    }

    public SSLContextBuilder loadKeyMaterial(KeyStore keystore, char ac[])
        throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException
    {
        loadKeyMaterial(keystore, ac, null);
        return this;
    }

    public SSLContextBuilder loadKeyMaterial(KeyStore keystore, char ac[], PrivateKeyStrategy privatekeystrategy)
        throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException
    {
        KeyManagerFactory keymanagerfactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keymanagerfactory.init(keystore, ac);
        keystore = keymanagerfactory.getKeyManagers();
        if (keystore != null)
        {
            if (privatekeystrategy != null)
            {
                for (int i = 0; i < keystore.length; i++)
                {
                    ac = keystore[i];
                    if (ac instanceof X509KeyManager)
                    {
                        keystore[i] = new KeyManagerDelegate((X509KeyManager)ac, privatekeystrategy);
                    }
                }

            }
            int k = keystore.length;
            for (int j = 0; j < k; j++)
            {
                ac = keystore[j];
                keymanagers.add(ac);
            }

        }
        return this;
    }

    public SSLContextBuilder loadTrustMaterial(KeyStore keystore)
        throws NoSuchAlgorithmException, KeyStoreException
    {
        return loadTrustMaterial(keystore, null);
    }

    public SSLContextBuilder loadTrustMaterial(KeyStore keystore, TrustStrategy truststrategy)
        throws NoSuchAlgorithmException, KeyStoreException
    {
        TrustManagerFactory trustmanagerfactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustmanagerfactory.init(keystore);
        keystore = trustmanagerfactory.getTrustManagers();
        if (keystore != null)
        {
            if (truststrategy != null)
            {
                for (int i = 0; i < keystore.length; i++)
                {
                    Object obj = keystore[i];
                    if (obj instanceof X509TrustManager)
                    {
                        keystore[i] = new TrustManagerDelegate((X509TrustManager)obj, truststrategy);
                    }
                }

            }
            int k = keystore.length;
            for (int j = 0; j < k; j++)
            {
                truststrategy = keystore[j];
                trustmanagers.add(truststrategy);
            }

        }
        return this;
    }

    public SSLContextBuilder setSecureRandom(SecureRandom securerandom)
    {
        secureRandom = securerandom;
        return this;
    }

    public SSLContextBuilder useProtocol(String s)
    {
        protocol = s;
        return this;
    }

    public SSLContextBuilder useSSL()
    {
        protocol = "SSL";
        return this;
    }

    public SSLContextBuilder useTLS()
    {
        protocol = "TLS";
        return this;
    }
}
