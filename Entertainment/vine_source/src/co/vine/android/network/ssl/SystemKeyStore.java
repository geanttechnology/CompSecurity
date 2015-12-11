// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.network.ssl;

import android.content.Context;
import android.content.res.Resources;
import co.vine.android.util.Util;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.HashMap;
import javax.security.auth.x500.X500Principal;

public class SystemKeyStore
{

    private static final int CACERTS_FILE_SIZE = 0x23000;
    private static SystemKeyStore sInstance;
    private final HashMap mTrustRoots;
    final KeyStore mTrustStore;

    private SystemKeyStore(Context context)
    {
        context = getTrustStore(context);
        mTrustRoots = initializeTrustedRoots(context);
        mTrustStore = context;
    }

    public static SystemKeyStore getInstance(Context context)
    {
        co/vine/android/network/ssl/SystemKeyStore;
        JVM INSTR monitorenter ;
        if (sInstance == null)
        {
            sInstance = new SystemKeyStore(context);
        }
        context = sInstance;
        co/vine/android/network/ssl/SystemKeyStore;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    private KeyStore getTrustStore(Context context)
    {
        KeyStore keystore;
        Exception exception;
        try
        {
            keystore = KeyStore.getInstance("BKS");
            context = new BufferedInputStream(context.getResources().openRawResource(0x7f060000), 0x23000);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new AssertionError(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new AssertionError(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new AssertionError(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new AssertionError(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new AssertionError(context);
        }
        keystore.load(context, "changeit".toCharArray());
        Util.closeSilently(context);
        return keystore;
        exception;
        Util.closeSilently(context);
        throw exception;
    }

    private HashMap initializeTrustedRoots(KeyStore keystore)
    {
        HashMap hashmap;
        Enumeration enumeration;
        hashmap = new HashMap();
        enumeration = keystore.aliases();
_L1:
        X509Certificate x509certificate;
        if (!enumeration.hasMoreElements())
        {
            break MISSING_BLOCK_LABEL_70;
        }
        x509certificate = (X509Certificate)keystore.getCertificate((String)enumeration.nextElement());
        if (x509certificate != null)
        {
            try
            {
                hashmap.put(x509certificate.getSubjectX500Principal(), x509certificate);
            }
            // Misplaced declaration of an exception variable
            catch (KeyStore keystore)
            {
                throw new AssertionError(keystore);
            }
        }
          goto _L1
        return hashmap;
    }

    public X509Certificate getTrustRootFor(X509Certificate x509certificate)
    {
        X509Certificate x509certificate1 = (X509Certificate)mTrustRoots.get(x509certificate.getIssuerX500Principal());
        if (x509certificate1 == null)
        {
            return null;
        }
        if (x509certificate1.getSubjectX500Principal().equals(x509certificate.getSubjectX500Principal()))
        {
            return null;
        }
        try
        {
            x509certificate.verify(x509certificate1.getPublicKey());
        }
        // Misplaced declaration of an exception variable
        catch (X509Certificate x509certificate)
        {
            return null;
        }
        return x509certificate1;
    }

    public boolean isTrustRoot(X509Certificate x509certificate)
    {
        X509Certificate x509certificate1 = (X509Certificate)mTrustRoots.get(x509certificate.getSubjectX500Principal());
        return x509certificate1 != null && x509certificate1.getPublicKey().equals(x509certificate.getPublicKey());
    }
}
