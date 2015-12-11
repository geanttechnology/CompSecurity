// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

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

// Referenced classes of package android.support.v7:
//            aon, alt, amc, aoh, 
//            aop

class aoo
    implements X509TrustManager
{

    private final TrustManager a[];
    private final aop b;
    private final long c;
    private final List d = new LinkedList();
    private final Set e = Collections.synchronizedSet(new HashSet());

    public aoo(aop aop1, aon aon1)
    {
        a = a(aop1);
        b = aop1;
        c = aon1.getPinCreationTimeInMillis();
        aop1 = aon1.getPins();
        int j = aop1.length;
        for (int i = 0; i < j; i++)
        {
            aon1 = aop1[i];
            d.add(a(aon1));
        }

    }

    private void a(X509Certificate ax509certificate[])
        throws CertificateException
    {
        if (c == -1L || System.currentTimeMillis() - c <= 0x39ef8b000L) goto _L2; else goto _L1
_L1:
        alt.h().d("Fabric", (new StringBuilder()).append("Certificate pins are stale, (").append(System.currentTimeMillis() - c).append(" millis vs ").append(0x39ef8b000L).append(" millis) ").append("falling back to system trust.").toString());
_L4:
        return;
_L2:
        ax509certificate = aoh.a(ax509certificate, b);
        int j = ax509certificate.length;
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i >= j)
                {
                    break label1;
                }
                if (a(ax509certificate[i]))
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        throw new CertificateException("No valid pins found in chain!");
    }

    private void a(X509Certificate ax509certificate[], String s)
        throws CertificateException
    {
        TrustManager atrustmanager[] = a;
        int j = atrustmanager.length;
        for (int i = 0; i < j; i++)
        {
            ((X509TrustManager)atrustmanager[i]).checkServerTrusted(ax509certificate, s);
        }

    }

    private boolean a(X509Certificate x509certificate)
        throws CertificateException
    {
        Iterator iterator;
        x509certificate = MessageDigest.getInstance("SHA1").digest(x509certificate.getPublicKey().getEncoded());
        iterator = d.iterator();
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

    private byte[] a(String s)
    {
        int j = s.length();
        byte abyte0[] = new byte[j / 2];
        for (int i = 0; i < j; i += 2)
        {
            abyte0[i / 2] = (byte)((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
        }

        return abyte0;
    }

    private TrustManager[] a(aop aop1)
    {
        try
        {
            TrustManagerFactory trustmanagerfactory = TrustManagerFactory.getInstance("X509");
            trustmanagerfactory.init(aop1.a);
            aop1 = trustmanagerfactory.getTrustManagers();
        }
        // Misplaced declaration of an exception variable
        catch (aop aop1)
        {
            throw new AssertionError(aop1);
        }
        // Misplaced declaration of an exception variable
        catch (aop aop1)
        {
            throw new AssertionError(aop1);
        }
        return aop1;
    }

    public void checkClientTrusted(X509Certificate ax509certificate[], String s)
        throws CertificateException
    {
        throw new CertificateException("Client certificates not supported!");
    }

    public void checkServerTrusted(X509Certificate ax509certificate[], String s)
        throws CertificateException
    {
        if (e.contains(ax509certificate[0]))
        {
            return;
        } else
        {
            a(ax509certificate, s);
            a(ax509certificate);
            e.add(ax509certificate[0]);
            return;
        }
    }

    public X509Certificate[] getAcceptedIssuers()
    {
        return null;
    }
}
