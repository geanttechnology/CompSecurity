// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework.security;

import com.amazon.identity.auth.device.utils.MAPLog;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

final class CertificatePinnedKeyStore
{

    private static final String TAG = com/amazon/identity/auth/device/framework/security/CertificatePinnedKeyStore.getName();
    private static KeyStore sTheOnlyInstance;

    private CertificatePinnedKeyStore()
    {
    }

    static KeyStore getInstance()
        throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException
    {
        com/amazon/identity/auth/device/framework/security/CertificatePinnedKeyStore;
        JVM INSTR monitorenter ;
        KeyStore keystore;
        if (sTheOnlyInstance == null)
        {
            sTheOnlyInstance = loadKeyStoreFromFile$24430370("default_client_truststore.bks", "BKS");
        }
        keystore = sTheOnlyInstance;
        com/amazon/identity/auth/device/framework/security/CertificatePinnedKeyStore;
        JVM INSTR monitorexit ;
        return keystore;
        Exception exception;
        exception;
        throw exception;
    }

    private static KeyStore loadKeyStoreFromFile$24430370(String s, String s1)
        throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException
    {
        InputStream inputstream;
        Object obj;
        obj = null;
        inputstream = null;
        InputStream inputstream1 = com/amazon/identity/auth/device/framework/security/CertificatePinnedKeyStore.getResourceAsStream(s);
        if (inputstream1 != null) goto _L2; else goto _L1
_L1:
        inputstream = inputstream1;
        MAPLog.e(TAG, (new StringBuilder("Can not find the trusted store file: ")).append(s).toString());
        s = obj;
        if (inputstream1 != null)
        {
            try
            {
                inputstream1.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                MAPLog.w(TAG, "Got IOException when trying to close the trusted store stream", s);
                return null;
            }
            s = obj;
        }
_L4:
        return s;
_L2:
        inputstream = inputstream1;
        s1 = KeyStore.getInstance(s1);
        inputstream = inputstream1;
        s1.load(inputstream1, null);
        s = s1;
        if (inputstream1 == null) goto _L4; else goto _L3
_L3:
        try
        {
            inputstream1.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.w(TAG, "Got IOException when trying to close the trusted store stream", s);
            return s1;
        }
        return s1;
        s;
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                MAPLog.w(TAG, "Got IOException when trying to close the trusted store stream", s1);
            }
        }
        throw s;
    }

}
