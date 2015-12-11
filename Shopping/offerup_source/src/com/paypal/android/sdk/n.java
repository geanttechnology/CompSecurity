// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import java.io.ByteArrayInputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;

public class n
{

    public n()
    {
    }

    protected static boolean a(Context context, boolean flag, String s, String s1, String s2)
    {
        boolean flag3;
        flag3 = false;
        context = context.getPackageManager();
        context.getApplicationInfo(s, 4224);
label0:
        {
            boolean flag1;
            boolean flag2;
            if (context.checkPermission("android.permission.GET_ACCOUNTS", s) == 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            flag2 = flag3;
            if (!flag1)
            {
                break label0;
            }
            if (flag)
            {
                try
                {
                    flag = a(((PackageManager) (context)), s, s1, s2, 0x2096f5c);
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    (new StringBuilder()).append(s).append(" not found.");
                    return false;
                }
                flag2 = flag3;
                if (!flag)
                {
                    break label0;
                }
            }
            flag2 = true;
        }
        return flag2;
    }

    private static boolean a(PackageManager packagemanager, String s, String s1, String s2, int i)
    {
        int j;
        packagemanager = packagemanager.getPackageInfo(s, 64).signatures;
        j = packagemanager.length;
        i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        s = new ByteArrayInputStream(packagemanager[i].toByteArray());
        int k;
        boolean flag;
        s = (X509Certificate)CertificateFactory.getInstance("X509").generateCertificate(s);
        String s3 = s.getSubjectX500Principal().getName();
        String s4 = s.getIssuerX500Principal().getName();
        k = s.getPublicKey().hashCode();
        if (!s1.equals(s3))
        {
            break MISSING_BLOCK_LABEL_111;
        }
        flag = s2.equals(s4);
        if (flag && 0x2096f5c == k)
        {
            return true;
        }
        return false;
        s;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        return false;
    }

    static 
    {
        com/paypal/android/sdk/n.getSimpleName();
    }
}
