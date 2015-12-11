// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.debug;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.amazon.mShop.util.AttributionUtils;
import java.io.ByteArrayInputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;

public class DebugSettings
{

    private static final X500Principal DEBUG_DN = new X500Principal("CN=Android Debug,O=Android,C=US");
    private static boolean sDebugEnabled = false;
    private static boolean sDebugSigned = false;

    public DebugSettings()
    {
    }

    public static boolean isDebugEnabled()
    {
        return sDebugEnabled;
    }

    public static void setDebugEnabled(Context context)
    {
        sDebugEnabled = "true".equals(AttributionUtils.readStringFromRawResourceFile(context, com.amazon.mShop.android.lib.R.raw.debug));
        CertificateFactory certificatefactory;
        int i;
        boolean flag;
        try
        {
            context = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
            certificatefactory = CertificateFactory.getInstance("X.509");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
        if (context == null) goto _L2; else goto _L1
_L1:
        i = 0;
_L6:
        if (i >= context.length) goto _L2; else goto _L3
_L3:
        sDebugSigned = ((X509Certificate)certificatefactory.generateCertificate(new ByteArrayInputStream(context[i].toByteArray()))).getSubjectX500Principal().equals(DEBUG_DN);
        flag = sDebugSigned;
        if (!flag) goto _L4; else goto _L2
_L2:
        return;
_L4:
        i++;
        if (true) goto _L6; else goto _L5
_L5:
    }

}
