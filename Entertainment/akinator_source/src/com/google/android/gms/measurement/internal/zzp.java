// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.measurement.zza;

// Referenced classes of package com.google.android.gms.measurement.internal:
//            zzy, zzc, zzv, zzu, 
//            zzs, zzn, zzab, zzag

public class zzp extends zzy
{
    public class zza
    {

        private final int mPriority;
        final zzp zzaMV;
        private final boolean zzaMW;
        private final boolean zzaMX;

        public void zzd(String s, Object obj, Object obj1, Object obj2)
        {
            zzaMV.zza(mPriority, zzaMW, zzaMX, s, obj, obj1, obj2);
        }

        public void zze(String s, Object obj, Object obj1)
        {
            zzaMV.zza(mPriority, zzaMW, zzaMX, s, obj, obj1, null);
        }

        public void zzec(String s)
        {
            zzaMV.zza(mPriority, zzaMW, zzaMX, s, null, null, null);
        }

        public void zzj(String s, Object obj)
        {
            zzaMV.zza(mPriority, zzaMW, zzaMX, s, obj, null, null);
        }

        zza(int i, boolean flag, boolean flag1)
        {
            zzaMV = zzp.this;
            super();
            mPriority = i;
            zzaMW = flag;
            zzaMX = flag1;
        }
    }


    private final char zzaMJ;
    private final long zzaMK = zzzt().zzzb();
    private final zza zzaML = new zza(6, false, false);
    private final zza zzaMM = new zza(6, true, false);
    private final zza zzaMN = new zza(6, false, true);
    private final zza zzaMO = new zza(5, false, false);
    private final zza zzaMP = new zza(5, true, false);
    private final zza zzaMQ = new zza(5, false, true);
    private final zza zzaMR = new zza(4, false, false);
    private final zza zzaMS = new zza(3, false, false);
    private final zza zzaMT = new zza(2, false, false);
    private final String zzagm = zzzt().zzyS();

    zzp(zzv zzv1)
    {
        super(zzv1);
        if (zzzt().zzjB())
        {
            char c;
            if (zzzt().zzjA())
            {
                c = 'P';
            } else
            {
                c = 'C';
            }
            zzaMJ = c;
        } else
        {
            char c1;
            if (zzzt().zzjA())
            {
                c1 = 'p';
            } else
            {
                c1 = 'c';
            }
            zzaMJ = c1;
        }
    }

    static String zza(boolean flag, String s, Object obj, Object obj1, Object obj2)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        String s2 = zzc(flag, obj);
        obj1 = zzc(flag, obj1);
        obj2 = zzc(flag, obj2);
        StringBuilder stringbuilder = new StringBuilder();
        s = "";
        if (!TextUtils.isEmpty(s1))
        {
            stringbuilder.append(s1);
            s = ": ";
        }
        obj = s;
        if (!TextUtils.isEmpty(s2))
        {
            stringbuilder.append(s);
            stringbuilder.append(s2);
            obj = ", ";
        }
        s = ((String) (obj));
        if (!TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            stringbuilder.append(((String) (obj)));
            stringbuilder.append(((String) (obj1)));
            s = ", ";
        }
        if (!TextUtils.isEmpty(((CharSequence) (obj2))))
        {
            stringbuilder.append(s);
            stringbuilder.append(((String) (obj2)));
        }
        return stringbuilder.toString();
    }

    static String zzc(boolean flag, Object obj)
    {
        String s1;
        String s2;
        StackTraceElement astacktraceelement[];
        int i;
        int j;
        if (obj == null)
        {
            return "";
        }
        if (obj instanceof Integer)
        {
            obj = Long.valueOf(((Integer)obj).intValue());
        }
        if (obj instanceof Long)
        {
            if (!flag)
            {
                return String.valueOf(obj);
            }
            if (Math.abs(((Long)obj).longValue()) < 100L)
            {
                return String.valueOf(obj);
            }
            String s;
            StringBuilder stringbuilder;
            if (String.valueOf(obj).charAt(0) == '-')
            {
                s = "-";
            } else
            {
                s = "";
            }
            obj = String.valueOf(Math.abs(((Long)obj).longValue()));
            stringbuilder = new StringBuilder();
            stringbuilder.append(s);
            stringbuilder.append(Math.round(Math.pow(10D, ((String) (obj)).length() - 1)));
            stringbuilder.append("...");
            stringbuilder.append(s);
            stringbuilder.append(Math.round(Math.pow(10D, ((String) (obj)).length()) - 1.0D));
            return stringbuilder.toString();
        }
        if (obj instanceof Boolean)
        {
            return String.valueOf(obj);
        }
        if (!(obj instanceof Throwable))
        {
            break MISSING_BLOCK_LABEL_332;
        }
        Throwable throwable = (Throwable)obj;
        obj = new StringBuilder(throwable.toString());
        s1 = zzeb(com/google/android/gms/measurement/zza.getCanonicalName());
        s2 = zzeb(com/google/android/gms/measurement/internal/zzv.getCanonicalName());
        astacktraceelement = throwable.getStackTrace();
        j = astacktraceelement.length;
        i = 0;
_L2:
        StackTraceElement stacktraceelement;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_327;
        }
        stacktraceelement = astacktraceelement[i];
        if (!stacktraceelement.isNativeMethod())
        {
            break; /* Loop/switch isn't completed */
        }
_L4:
        i++;
        String s3;
        if (true) goto _L2; else goto _L1
_L1:
        if ((s3 = stacktraceelement.getClassName()) == null || !(s3 = zzeb(s3)).equals(s1) && !s3.equals(s2)) goto _L4; else goto _L3
_L3:
        ((StringBuilder) (obj)).append(": ");
        ((StringBuilder) (obj)).append(stacktraceelement);
        return ((StringBuilder) (obj)).toString();
        if (flag)
        {
            return "-";
        } else
        {
            return String.valueOf(obj);
        }
    }

    private static String zzeb(String s)
    {
        String s1;
        if (TextUtils.isEmpty(s))
        {
            s1 = "";
        } else
        {
            int i = s.lastIndexOf('.');
            s1 = s;
            if (i != -1)
            {
                return s.substring(0, i);
            }
        }
        return s1;
    }

    public volatile Context getContext()
    {
        return super.getContext();
    }

    protected boolean zzN(int i)
    {
        return Log.isLoggable(zzagm, i);
    }

    protected void zza(int i, boolean flag, boolean flag1, String s, Object obj, Object obj1, Object obj2)
    {
        if (!flag && zzN(i))
        {
            zzl(i, zza(false, s, obj, obj1, obj2));
        }
        if (!flag1 && i >= 5)
        {
            zzb(i, s, obj, obj1, obj2);
        }
    }

    public void zzb(int i, String s, Object obj, Object obj1, Object obj2)
    {
        zzx.zzw(s);
        zzu zzu1 = zzaKG.zzAb();
        if (zzu1 == null || !zzu1.isInitialized() || zzu1.zzAp())
        {
            zzl(6, "Scheduler not initialized or shutdown. Not logging error/warn.");
            return;
        }
        int j = i;
        if (i < 0)
        {
            j = 0;
        }
        i = j;
        if (j >= "01VDIWEA?".length())
        {
            i = "01VDIWEA?".length() - 1;
        }
        obj = (new StringBuilder()).append("1").append("01VDIWEA?".charAt(i)).append(zzaMJ).append(zzaMK).append(":").append(zza(true, s, obj, obj1, obj2)).toString();
        if (((String) (obj)).length() > 1024)
        {
            s = s.substring(0, 1024);
        } else
        {
            s = ((String) (obj));
        }
        zzu1.zzh(new Runnable(s) {

            final String zzaMU;
            final zzp zzaMV;

            public void run()
            {
                zzs zzs1 = zzaMV.zzaKG.zzzs();
                if (!zzs1.isInitialized() || zzs1.zzAp())
                {
                    zzaMV.zzl(6, "Persisted config not initialized . Not logging error/warn.");
                    return;
                } else
                {
                    zzs1.zzaNh.zzbn(zzaMU);
                    return;
                }
            }

            
            {
                zzaMV = zzp.this;
                zzaMU = s;
                super();
            }
        });
    }

    protected void zzhR()
    {
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

    protected void zzl(int i, String s)
    {
        Log.println(i, zzagm, s);
    }

    public volatile zzp zzyd()
    {
        return super.zzyd();
    }

    public zza zzzK()
    {
        return zzaML;
    }

    public zza zzzL()
    {
        return zzaMO;
    }

    public zza zzzM()
    {
        return zzaMP;
    }

    public zza zzzN()
    {
        return zzaMQ;
    }

    public zza zzzO()
    {
        return zzaMR;
    }

    public zza zzzP()
    {
        return zzaMS;
    }

    public zza zzzQ()
    {
        return zzaMT;
    }

    public String zzzR()
    {
        Pair pair = zzzs().zzaNh.zzkW();
        if (pair == null)
        {
            return null;
        } else
        {
            return (new StringBuilder()).append(String.valueOf(pair.second)).append(":").append((String)pair.first).toString();
        }
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
