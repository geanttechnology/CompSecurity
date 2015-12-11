// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.util.Base64;
import com.amazon.identity.auth.device.utils.MAPLog;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.ECGenParameterSpec;

public final class KeyPairGenHelper
{

    public static final String ALGO_EC = "EC";
    public static final String ALGO_RSA = "RSA";
    private static final String TAG = com/amazon/identity/auth/device/framework/KeyPairGenHelper.getName();

    private KeyPairGenHelper()
    {
    }

    public static String encodeECPrivateKey(PrivateKey privatekey)
    {
        if (privatekey == null || !privatekey.getAlgorithm().equalsIgnoreCase("EC"))
        {
            return null;
        } else
        {
            privatekey = Base64.encodeToString(privatekey.getEncoded(), 0);
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("-----BEGIN EC PRIVATE KEY-----");
            stringbuilder.append("\n");
            stringbuilder.append(privatekey);
            stringbuilder.append("\n");
            stringbuilder.append("-----END EC PRIVATE KEY-----");
            return stringbuilder.toString();
        }
    }

    public static String encodePublicKey(PublicKey publickey)
    {
        if (publickey == null)
        {
            return null;
        } else
        {
            return Base64.encodeToString(publickey.getEncoded(), 0);
        }
    }

    public static String encodeRSAPrivateKey(PrivateKey privatekey)
    {
        if (privatekey == null || !privatekey.getAlgorithm().equalsIgnoreCase("RSA"))
        {
            return null;
        } else
        {
            privatekey = Base64.encodeToString(privatekey.getEncoded(), 0);
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("-----BEGIN RSA PRIVATE KEY-----");
            stringbuilder.append("\n");
            stringbuilder.append(privatekey);
            stringbuilder.append("\n");
            stringbuilder.append("-----END RSA PRIVATE KEY-----");
            return stringbuilder.toString();
        }
    }

    public static KeyPair getECKeyPair()
    {
        KeyPair keypair;
        Object obj;
        try
        {
            ECGenParameterSpec ecgenparameterspec = new ECGenParameterSpec("prime239v1");
            obj = KeyPairGenerator.getInstance("EC", "BC");
            ((KeyPairGenerator) (obj)).initialize(ecgenparameterspec);
            obj = ((KeyPairGenerator) (obj)).genKeyPair();
            if (!((KeyPair) (obj)).getPublic().getFormat().equalsIgnoreCase("X.509") || !((KeyPair) (obj)).getPrivate().getFormat().equalsIgnoreCase("PKCS#8") || !((KeyPair) (obj)).getPublic().getAlgorithm().equalsIgnoreCase("EC"))
            {
                break MISSING_BLOCK_LABEL_98;
            }
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            MAPLog.e(TAG, (new StringBuilder("getECKeyPair: failed because of NoSuchAlgorithmException: ")).append(nosuchalgorithmexception.getMessage()).toString());
            return null;
        }
        catch (NoSuchProviderException nosuchproviderexception)
        {
            MAPLog.e(TAG, (new StringBuilder("getECKeyPair: failed because of NoSuchProviderException: ")).append(nosuchproviderexception.getMessage()).toString());
            return null;
        }
        catch (Exception exception)
        {
            MAPLog.e(TAG, (new StringBuilder("getECKeyPair: failed because of UnkownException: ")).append(exception.getMessage()).toString());
            return null;
        }
        keypair = ((KeyPair) (obj));
        if (((KeyPair) (obj)).getPrivate().getAlgorithm().equalsIgnoreCase("EC"))
        {
            break MISSING_BLOCK_LABEL_181;
        }
        MAPLog.e(TAG, (new StringBuilder("getECKeyPair: failed because of unsupported format or algorithm: ")).append(((KeyPair) (obj)).getPublic().getFormat()).append(",").append(((KeyPair) (obj)).getPrivate().getFormat()).append(",").append(((KeyPair) (obj)).getPublic().getAlgorithm()).append(",").append(((KeyPair) (obj)).getPrivate().getAlgorithm()).toString());
        keypair = null;
        return keypair;
    }

    public static KeyPair getRSAKeyPair()
    {
        KeyPair keypair;
        KeyPair keypair1;
        try
        {
            KeyPairGenerator keypairgenerator = KeyPairGenerator.getInstance("RSA", "BC");
            keypairgenerator.initialize(2048);
            keypair1 = keypairgenerator.genKeyPair();
            if (!keypair1.getPublic().getFormat().equalsIgnoreCase("X.509") || !keypair1.getPrivate().getFormat().equalsIgnoreCase("PKCS#8") || !keypair1.getPublic().getAlgorithm().equalsIgnoreCase("RSA"))
            {
                break MISSING_BLOCK_LABEL_90;
            }
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            MAPLog.e(TAG, (new StringBuilder("getRSAKeyPair: failed because of NoSuchAlgorithmException: ")).append(nosuchalgorithmexception.getMessage()).toString());
            return null;
        }
        catch (NoSuchProviderException nosuchproviderexception)
        {
            MAPLog.e(TAG, (new StringBuilder("getRSAKeyPair: failed because of NoSuchProviderException: ")).append(nosuchproviderexception.getMessage()).toString());
            return null;
        }
        catch (Exception exception)
        {
            MAPLog.e(TAG, (new StringBuilder("getRSAKeyPair: failed because of UnkownException: ")).append(exception.getMessage()).toString());
            return null;
        }
        keypair = keypair1;
        if (keypair1.getPrivate().getAlgorithm().equalsIgnoreCase("RSA"))
        {
            break MISSING_BLOCK_LABEL_173;
        }
        MAPLog.e(TAG, (new StringBuilder("getRSAKeyPair: failed because of unsupported format or algorithm: ")).append(keypair1.getPublic().getFormat()).append(",").append(keypair1.getPrivate().getFormat()).append(",").append(keypair1.getPublic().getAlgorithm()).append(",").append(keypair1.getPrivate().getAlgorithm()).toString());
        keypair = null;
        return keypair;
    }

}
