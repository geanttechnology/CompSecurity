// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.conn.ssl;

import java.net.Socket;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.X509KeyManager;

// Referenced classes of package cz.msebera.android.httpclient.conn.ssl:
//            SSLContextBuilder, PrivateKeyDetails, PrivateKeyStrategy

static class aliasStrategy
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

    Q(X509KeyManager x509keymanager, PrivateKeyStrategy privatekeystrategy)
    {
        keyManager = x509keymanager;
        aliasStrategy = privatekeystrategy;
    }
}
