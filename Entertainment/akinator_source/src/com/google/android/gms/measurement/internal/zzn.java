// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;

// Referenced classes of package com.google.android.gms.measurement.internal:
//            zzy, zzp, AppMetadata, zzc, 
//            zzl, zzv, zzab, zzag, 
//            zzu, zzs

public class zzn extends zzy
{

    private static final X500Principal zzaMG = new X500Principal("CN=Android Debug,O=Android,C=US");
    private String zzOZ;
    private String zzPa;
    private String zzaLL;
    private String zzaLl;
    private String zzaMH;
    private long zzaMI;

    zzn(zzv zzv)
    {
        super(zzv);
    }

    static long zzo(byte abyte0[])
    {
        int j = 0;
        zzx.zzw(abyte0);
        long l;
        boolean flag;
        if (abyte0.length > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzZ(flag);
        l = 0L;
        for (int i = abyte0.length - 1; i >= 0 && i >= abyte0.length - 8; i--)
        {
            l += ((long)abyte0[i] & 255L) << j;
            j += 8;
        }

        return l;
    }

    public volatile Context getContext()
    {
        return super.getContext();
    }

    protected void zzhR()
    {
        Object obj;
        Object obj2;
        String s1;
        long l;
        long l1;
        s1 = "Unknown";
        String s = "Unknown";
        PackageManager packagemanager = getContext().getPackageManager();
        String s2 = getContext().getPackageName();
        obj = packagemanager.getInstallerPackageName(s2);
        Object obj1;
        PackageInfo packageinfo;
        CharSequence charsequence;
        if (obj == null)
        {
            obj1 = "manual_install";
        } else
        {
            obj1 = obj;
            if ("com.android.vending".equals(obj))
            {
                obj1 = "";
            }
        }
        obj2 = s;
        packageinfo = packagemanager.getPackageInfo(getContext().getPackageName(), 0);
        obj = s;
        obj2 = s1;
        if (packageinfo == null)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        obj2 = s;
        charsequence = packagemanager.getApplicationLabel(packageinfo.applicationInfo);
        obj = s;
        obj2 = s;
        if (TextUtils.isEmpty(charsequence))
        {
            break MISSING_BLOCK_LABEL_108;
        }
        obj2 = s;
        obj = charsequence.toString();
        obj2 = obj;
        s = packageinfo.versionName;
        obj2 = s;
_L2:
        zzaLl = s2;
        zzaMH = ((String) (obj1));
        zzPa = ((String) (obj2));
        zzOZ = ((String) (obj));
        l1 = 0L;
        obj = MessageDigest.getInstance("MD5");
        l = l1;
        if (zzzJ())
        {
            break MISSING_BLOCK_LABEL_226;
        }
        obj1 = packagemanager.getPackageInfo(getContext().getPackageName(), 64);
        l = l1;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_226;
        }
        l = l1;
        if (((PackageInfo) (obj1)).signatures != null)
        {
            l = l1;
            android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
            try
            {
                if (((PackageInfo) (obj1)).signatures.length > 0)
                {
                    l = zzo(((MessageDigest) (obj)).digest(((PackageInfo) (obj1)).signatures[0].toByteArray()));
                }
            }
            catch (NoSuchAlgorithmException nosuchalgorithmexception)
            {
                zzyd().zzzK().zzj("Could not get MD5 instance", nosuchalgorithmexception);
                l = l1;
            }
            catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception1)
            {
                zzyd().zzzK().zzj("Package name not found", namenotfoundexception1);
                l = l1;
            }
        }
        zzaMI = l;
        return;
        namenotfoundexception;
        zzyd().zzzK().zzj("Error retrieving package info: appName", obj2);
        namenotfoundexception = ((android.content.pm.PackageManager.NameNotFoundException) (obj2));
        obj2 = s1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public volatile void zzir()
    {
        super.zzir();
    }

    public volatile void zzis()
    {
        super.zzis();
    }

    public volatile zzmn zzit()
    {
        return super.zzit();
    }

    public volatile zzp zzyd()
    {
        return super.zzyd();
    }

    AppMetadata zzzG()
    {
        return new AppMetadata(zzaLl, zzzH(), zzPa, zzaMH, zzzt().zzzb(), zzzI());
    }

    String zzzH()
    {
        zziE();
        if (zzzt().zzjA())
        {
            return "";
        }
        if (zzaLL != null) goto _L2; else goto _L1
_L1:
        Object obj = zzl.zzaK(getContext());
        if (obj == null || !((Status) (obj)).isSuccess()) goto _L4; else goto _L3
_L3:
        if (!zzl.zzzE()) goto _L6; else goto _L5
_L5:
        String s = zzl.zzzC();
        obj = s;
        if (TextUtils.isEmpty(s))
        {
            obj = "";
        }
        try
        {
            zzaLL = ((String) (obj));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            zzaLL = "";
            zzyd().zzzK().zzj("getGoogleAppId or isMeasurementEnabled failed with exception", obj);
        }
_L2:
        return zzaLL;
_L6:
        zzaLL = "";
        continue; /* Loop/switch isn't completed */
_L4:
        zzaLL = "";
        zzp.zza zza = zzyd().zzzK();
        int i;
        if (obj == null)
        {
            i = 0;
        } else
        {
            i = ((Status) (obj)).getStatusCode();
        }
        zza.zzj("getGoogleAppId failed with status", Integer.valueOf(i));
        if (obj != null && ((Status) (obj)).getStatusMessage() != null)
        {
            zzyd().zzzP().zzec(((Status) (obj)).getStatusMessage());
        }
        if (true) goto _L2; else goto _L7
_L7:
    }

    long zzzI()
    {
        zziE();
        return zzaMI;
    }

    boolean zzzJ()
    {
        Object obj = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 64);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        boolean flag;
        if (((PackageInfo) (obj)).signatures == null || ((PackageInfo) (obj)).signatures.length <= 0)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        obj = ((PackageInfo) (obj)).signatures[0];
        flag = ((X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(((Signature) (obj)).toByteArray()))).getSubjectX500Principal().equals(zzaMG);
        return flag;
        Object obj1;
        obj1;
        zzyd().zzzK().zzj("Error obtaining certificate", obj1);
_L2:
        return true;
        obj1;
        zzyd().zzzK().zzj("Package name not found", obj1);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public volatile void zzzn()
    {
        super.zzzn();
    }

    public volatile zzn zzzo()
    {
        return super.zzzo();
    }

    public volatile zzab zzzp()
    {
        return super.zzzp();
    }

    public volatile zzag zzzq()
    {
        return super.zzzq();
    }

    public volatile zzu zzzr()
    {
        return super.zzzr();
    }

    public volatile zzs zzzs()
    {
        return super.zzzs();
    }

    public volatile zzc zzzt()
    {
        return super.zzzt();
    }

}
