// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.d;

import android.text.TextUtils;
import android.util.Log;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

// Referenced classes of package com.smule.android.d:
//            b, a

public class s
{

    public static PublicKey a(String s1)
    {
        try
        {
            s1 = com.smule.android.d.a.a(s1);
            s1 = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(s1));
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            throw new RuntimeException(s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.e("IABUtil/Security", "Invalid key specification.");
            throw new IllegalArgumentException(s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.e("IABUtil/Security", "Base64 decoding failed.");
            throw new IllegalArgumentException(s1);
        }
        return s1;
    }

    public static boolean a(String s1, String s2, String s3)
    {
        if (TextUtils.isEmpty(s2) || TextUtils.isEmpty(s1) || TextUtils.isEmpty(s3))
        {
            Log.e("IABUtil/Security", "Purchase verification failed: missing data.");
            return false;
        } else
        {
            return a(a(s1), s2, s3);
        }
    }

    public static boolean a(PublicKey publickey, String s1, String s2)
    {
label0:
        {
            try
            {
                Signature signature = Signature.getInstance("SHA1withRSA");
                signature.initVerify(publickey);
                signature.update(s1.getBytes());
                if (signature.verify(com.smule.android.d.a.a(s2)))
                {
                    break label0;
                }
                Log.e("IABUtil/Security", "Signature verification failed.");
            }
            // Misplaced declaration of an exception variable
            catch (PublicKey publickey)
            {
                Log.e("IABUtil/Security", "NoSuchAlgorithmException.");
                return false;
            }
            // Misplaced declaration of an exception variable
            catch (PublicKey publickey)
            {
                Log.e("IABUtil/Security", "Invalid key specification.");
                return false;
            }
            // Misplaced declaration of an exception variable
            catch (PublicKey publickey)
            {
                Log.e("IABUtil/Security", "Signature exception.");
                return false;
            }
            // Misplaced declaration of an exception variable
            catch (PublicKey publickey)
            {
                Log.e("IABUtil/Security", "Base64 decoding failed.");
                return false;
            }
            return false;
        }
        return true;
    }
}
