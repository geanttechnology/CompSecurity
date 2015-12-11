// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzrx;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

// Referenced classes of package com.google.android.gms.measurement.internal:
//            zzx, zzc, zzp, zzv, 
//            zzn, zzab, zzu, zzs

public class zzag extends com.google.android.gms.measurement.internal.zzx
{

    zzag(zzv zzv)
    {
        super(zzv);
    }

    public static boolean zza(Context context, Class class1)
    {
        context = context.getPackageManager().getServiceInfo(new ComponentName(context, class1), 4);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        boolean flag = ((ServiceInfo) (context)).enabled;
        if (flag)
        {
            return true;
        }
        break MISSING_BLOCK_LABEL_34;
        context;
        return false;
    }

    public static boolean zza(Context context, Class class1, boolean flag)
    {
        context = context.getPackageManager().getReceiverInfo(new ComponentName(context, class1), 2);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        if (!((ActivityInfo) (context)).enabled)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        flag = ((ActivityInfo) (context)).exported;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        return true;
        context;
        return false;
    }

    private Object zzc(int i, Object obj)
    {
        Object obj1;
        if (obj == null)
        {
            obj1 = null;
        } else
        {
            obj1 = obj;
            if (!(obj instanceof Long))
            {
                obj1 = obj;
                if (!(obj instanceof Float))
                {
                    if (obj instanceof Integer)
                    {
                        return Long.valueOf(((Integer)obj).intValue());
                    }
                    if (obj instanceof Byte)
                    {
                        return Long.valueOf(((Byte)obj).byteValue());
                    }
                    if (obj instanceof Short)
                    {
                        return Long.valueOf(((Short)obj).shortValue());
                    }
                    if (obj instanceof Boolean)
                    {
                        long l;
                        if (((Boolean)obj).booleanValue())
                        {
                            l = 1L;
                        } else
                        {
                            l = 0L;
                        }
                        return Long.valueOf(l);
                    }
                    if (obj instanceof Double)
                    {
                        return Float.valueOf((float)((Double)obj).doubleValue());
                    }
                    if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence))
                    {
                        obj = String.valueOf(obj);
                        obj1 = obj;
                        if (((String) (obj)).length() > i)
                        {
                            return null;
                        }
                    } else
                    {
                        return null;
                    }
                }
            }
        }
        return obj1;
    }

    public volatile Context getContext()
    {
        return super.getContext();
    }

    public Object zzC(Object obj)
    {
        return zzc(zzzt().zzyU(), obj);
    }

    public Object zzD(Object obj)
    {
        return zzc(zzzt().zzyV(), obj);
    }

    public void zza(Bundle bundle, String s, Object obj)
    {
        if (obj instanceof Long)
        {
            bundle.putLong(s, ((Long)obj).longValue());
        } else
        {
            if (obj instanceof Float)
            {
                bundle.putFloat(s, ((Float)obj).floatValue());
                return;
            }
            if (obj instanceof String)
            {
                bundle.putString(s, String.valueOf(obj));
                return;
            }
            if (s != null)
            {
                zzyd().zzzN().zze("Not putting event parameter. Invalid value type. name, type", s, obj.getClass().getSimpleName());
                return;
            }
        }
    }

    public void zza(com.google.android.gms.internal.zzpk.zzb zzb, Object obj)
    {
        zzx.zzw(obj);
        zzb.zzagS = null;
        zzb.zzaOH = null;
        zzb.zzaOB = null;
        if (obj instanceof String)
        {
            zzb.zzagS = (String)obj;
            return;
        }
        if (obj instanceof Long)
        {
            zzb.zzaOH = (Long)obj;
            return;
        }
        if (obj instanceof Float)
        {
            zzb.zzaOB = (Float)obj;
            return;
        } else
        {
            zzyd().zzzK().zzj("Ignoring invalid (type) event param value", obj);
            return;
        }
    }

    public void zza(com.google.android.gms.internal.zzpk.zze zze, Object obj)
    {
        zzx.zzw(obj);
        zze.zzagS = null;
        zze.zzaOH = null;
        zze.zzaOB = null;
        if (obj instanceof String)
        {
            zze.zzagS = (String)obj;
            return;
        }
        if (obj instanceof Long)
        {
            zze.zzaOH = (Long)obj;
            return;
        }
        if (obj instanceof Float)
        {
            zze.zzaOB = (Float)obj;
            return;
        } else
        {
            zzyd().zzzK().zzj("Ignoring invalid (type) user attribute value", obj);
            return;
        }
    }

    public byte[] zza(com.google.android.gms.internal.zzpk.zzc zzc1)
    {
        byte abyte0[];
        try
        {
            abyte0 = new byte[zzc1.zzFR()];
            zzrx zzrx1 = zzrx.zzC(abyte0);
            zzc1.zza(zzrx1);
            zzrx1.zzFE();
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.internal.zzpk.zzc zzc1)
        {
            zzyd().zzzK().zzj("Data loss. Failed to serialize batch", zzc1);
            return null;
        }
        return abyte0;
    }

    public boolean zzbh(String s)
    {
        zzis();
        return getContext().checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0;
    }

    void zzc(String s, int i, String s1)
    {
        if (s1 == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append(s).append(" name is required and can't be null").toString());
        }
        if (s1.length() == 0)
        {
            throw new IllegalArgumentException((new StringBuilder()).append(s).append(" name is required and can't be empty").toString());
        }
        char c = s1.charAt(0);
        if (!Character.isLetter(c) && c != '_')
        {
            throw new IllegalArgumentException((new StringBuilder()).append(s).append(" name must start with a letter or _").toString());
        }
        for (int j = 1; j < s1.length(); j++)
        {
            char c1 = s1.charAt(j);
            if (c1 != '_' && !Character.isLetterOrDigit(c1))
            {
                throw new IllegalArgumentException((new StringBuilder()).append(s).append(" name must consist of letters, digits or _ (underscores)").toString());
            }
        }

        if (s1.length() > i)
        {
            throw new IllegalArgumentException((new StringBuilder()).append(s).append(" name is too long. The maximum supported length is ").append(i).toString());
        } else
        {
            return;
        }
    }

    public boolean zzc(long l, long l1)
    {
        while (l == 0L || l1 <= 0L || Math.abs(zzit().currentTimeMillis() - l) > l1) 
        {
            return true;
        }
        return false;
    }

    public void zzef(String s)
    {
        zzc("user attribute", zzzt().zzyT(), s);
    }

    public byte[] zzg(byte abyte0[])
        throws IOException
    {
        try
        {
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            GZIPOutputStream gzipoutputstream = new GZIPOutputStream(bytearrayoutputstream);
            gzipoutputstream.write(abyte0);
            gzipoutputstream.close();
            bytearrayoutputstream.close();
            abyte0 = bytearrayoutputstream.toByteArray();
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            zzyd().zzzK().zzj("Failed to gzip content", abyte0);
            throw abyte0;
        }
        return abyte0;
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

    public byte[] zzp(byte abyte0[])
        throws IOException
    {
        GZIPInputStream gzipinputstream;
        ByteArrayOutputStream bytearrayoutputstream;
        byte abyte1[];
        abyte0 = new ByteArrayInputStream(abyte0);
        gzipinputstream = new GZIPInputStream(abyte0);
        bytearrayoutputstream = new ByteArrayOutputStream();
        abyte1 = new byte[1024];
_L1:
        int i = gzipinputstream.read(abyte1);
        if (i > 0)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        gzipinputstream.close();
        abyte0.close();
        return bytearrayoutputstream.toByteArray();
        bytearrayoutputstream.write(abyte1, 0, i);
          goto _L1
        abyte0;
        zzyd().zzzK().zzj("Failed to ungzip content", abyte0);
        throw abyte0;
    }

    public volatile zzp zzyd()
    {
        return super.zzyd();
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
