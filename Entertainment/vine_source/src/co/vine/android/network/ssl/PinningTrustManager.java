// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.network.ssl;

import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

// Referenced classes of package co.vine.android.network.ssl:
//            CertificateChainCleaner, SystemKeyStore

public class PinningTrustManager
    implements X509TrustManager
{

    private static final long PIN_FRESHNESS_DURATION_MILLIS = 0x39ef8b000L;
    private final Set mCache = Collections.synchronizedSet(new HashSet());
    private final List mPins = new LinkedList();
    private final SystemKeyStore mSystemKeyStore;
    private final TrustManager mSystemTrustManagers[];

    public PinningTrustManager(SystemKeyStore systemkeystore, String as[])
    {
        mSystemTrustManagers = initializeSystemTrustManagers(systemkeystore);
        mSystemKeyStore = systemkeystore;
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            systemkeystore = as[i];
            mPins.add(hexStringToByteArray(systemkeystore));
        }

    }

    private void checkPinTrust(X509Certificate ax509certificate[])
        throws CertificateException
    {
        ax509certificate = CertificateChainCleaner.getCleanChain(ax509certificate, mSystemKeyStore);
        int j = ax509certificate.length;
        for (int i = 0; i < j; i++)
        {
            if (isValidPin(ax509certificate[i]))
            {
                return;
            }
        }

        throw new CertificateException("No valid pins found in chain!");
    }

    private void checkSystemTrust(X509Certificate ax509certificate[], String s)
        throws CertificateException
    {
        TrustManager atrustmanager[] = mSystemTrustManagers;
        int j = atrustmanager.length;
        for (int i = 0; i < j; i++)
        {
            ((X509TrustManager)atrustmanager[i]).checkServerTrusted(ax509certificate, s);
        }

    }

    private byte[] hexStringToByteArray(String s)
    {
        int j = s.length();
        byte abyte0[] = new byte[j / 2];
        for (int i = 0; i < j; i += 2)
        {
            abyte0[i / 2] = (byte)((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
        }

        return abyte0;
    }

    private TrustManager[] initializeSystemTrustManagers(SystemKeyStore systemkeystore)
    {
        try
        {
            TrustManagerFactory trustmanagerfactory = TrustManagerFactory.getInstance("X509");
            trustmanagerfactory.init(systemkeystore.mTrustStore);
            systemkeystore = trustmanagerfactory.getTrustManagers();
        }
        // Misplaced declaration of an exception variable
        catch (SystemKeyStore systemkeystore)
        {
            throw new AssertionError(systemkeystore);
        }
        // Misplaced declaration of an exception variable
        catch (SystemKeyStore systemkeystore)
        {
            throw new AssertionError(systemkeystore);
        }
        return systemkeystore;
    }

    private boolean isValidPin(X509Certificate x509certificate)
        throws CertificateException
    {
        Iterator iterator;
        x509certificate = MessageDigest.getInstance("SHA1").digest(x509certificate.getPublicKey().getEncoded());
        iterator = mPins.iterator();
_L1:
        boolean flag;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_57;
        }
        flag = Arrays.equals((byte[])iterator.next(), x509certificate);
        if (flag)
        {
            return true;
        }
          goto _L1
        return false;
        x509certificate;
        throw new CertificateException(x509certificate);
    }

    public void checkClientTrusted(X509Certificate ax509certificate[], String s)
        throws CertificateException
    {
        throw new CertificateException("Client certificates not supported!");
    }

    public void checkServerTrusted(X509Certificate ax509certificate[], String s)
        throws CertificateException
    {
        if (mCache.contains(ax509certificate[0]))
        {
            return;
        } else
        {
            checkSystemTrust(ax509certificate, s);
            checkPinTrust(ax509certificate);
            mCache.add(ax509certificate[0]);
            return;
        }
    }

    public X509Certificate[] getAcceptedIssuers()
    {
        return null;
    }
}
