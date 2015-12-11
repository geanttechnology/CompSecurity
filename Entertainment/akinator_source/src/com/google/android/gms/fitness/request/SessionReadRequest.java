// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzoh;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzv

public class SessionReadRequest
    implements SafeParcelable
{
    public static class Builder
    {

        private String zzHP;
        private long zzNY;
        private long zzapN;
        private List zzapW;
        private String zzasS;
        private boolean zzasT;
        private List zzasU;
        private List zzasd;
        private boolean zzaso;

        static String zza(Builder builder)
        {
            return builder.zzasS;
        }

        static String zzb(Builder builder)
        {
            return builder.zzHP;
        }

        static long zzc(Builder builder)
        {
            return builder.zzNY;
        }

        static long zzd(Builder builder)
        {
            return builder.zzapN;
        }

        static List zze(Builder builder)
        {
            return builder.zzapW;
        }

        static List zzf(Builder builder)
        {
            return builder.zzasd;
        }

        static boolean zzg(Builder builder)
        {
            return builder.zzasT;
        }

        static boolean zzh(Builder builder)
        {
            return builder.zzaso;
        }

        static List zzi(Builder builder)
        {
            return builder.zzasU;
        }

        public SessionReadRequest build()
        {
            boolean flag;
            if (zzNY > 0L)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "Invalid start time: %s", new Object[] {
                Long.valueOf(zzNY)
            });
            if (zzapN > 0L && zzapN > zzNY)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "Invalid end time: %s", new Object[] {
                Long.valueOf(zzapN)
            });
            return new SessionReadRequest(this);
        }

        public Builder enableServerQueries()
        {
            zzaso = true;
            return this;
        }

        public Builder excludePackage(String s)
        {
            zzx.zzb(s, "Attempting to use a null package name");
            if (!zzasU.contains(s))
            {
                zzasU.add(s);
            }
            return this;
        }

        public Builder read(DataSource datasource)
        {
            zzx.zzb(datasource, "Attempting to add a null data source");
            if (!zzasd.contains(datasource))
            {
                zzasd.add(datasource);
            }
            return this;
        }

        public Builder read(DataType datatype)
        {
            zzx.zzb(datatype, "Attempting to use a null data type");
            if (!zzapW.contains(datatype))
            {
                zzapW.add(datatype);
            }
            return this;
        }

        public Builder readSessionsFromAllApps()
        {
            zzasT = true;
            return this;
        }

        public Builder setSessionId(String s)
        {
            zzHP = s;
            return this;
        }

        public Builder setSessionName(String s)
        {
            zzasS = s;
            return this;
        }

        public Builder setTimeInterval(long l, long l1, TimeUnit timeunit)
        {
            zzNY = timeunit.toMillis(l);
            zzapN = timeunit.toMillis(l1);
            return this;
        }

        public Builder()
        {
            zzNY = 0L;
            zzapN = 0L;
            zzapW = new ArrayList();
            zzasd = new ArrayList();
            zzasT = false;
            zzaso = false;
            zzasU = new ArrayList();
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new zzv();
    private final int mVersionCode;
    private final String zzHP;
    private final long zzNY;
    private final long zzapN;
    private final List zzapW;
    private final String zzasS;
    private boolean zzasT;
    private final List zzasU;
    private final zzoh zzasV;
    private final List zzasd;
    private final boolean zzaso;

    SessionReadRequest(int i, String s, String s1, long l, long l1, 
            List list, List list1, boolean flag, boolean flag1, List list2, IBinder ibinder)
    {
        mVersionCode = i;
        zzasS = s;
        zzHP = s1;
        zzNY = l;
        zzapN = l1;
        zzapW = list;
        zzasd = list1;
        zzasT = flag;
        zzaso = flag1;
        zzasU = list2;
        zzasV = com.google.android.gms.internal.zzoh.zza.zzbH(ibinder);
    }

    private SessionReadRequest(Builder builder)
    {
        this(Builder.zza(builder), Builder.zzb(builder), Builder.zzc(builder), Builder.zzd(builder), Builder.zze(builder), Builder.zzf(builder), Builder.zzg(builder), Builder.zzh(builder), Builder.zzi(builder), null);
    }


    public SessionReadRequest(SessionReadRequest sessionreadrequest, zzoh zzoh1)
    {
        this(sessionreadrequest.zzasS, sessionreadrequest.zzHP, sessionreadrequest.zzNY, sessionreadrequest.zzapN, sessionreadrequest.zzapW, sessionreadrequest.zzasd, sessionreadrequest.zzasT, sessionreadrequest.zzaso, sessionreadrequest.zzasU, zzoh1);
    }

    public SessionReadRequest(String s, String s1, long l, long l1, List list, 
            List list1, boolean flag, boolean flag1, List list2, zzoh zzoh1)
    {
        if (zzoh1 == null)
        {
            zzoh1 = null;
        } else
        {
            zzoh1 = zzoh1.asBinder();
        }
        this(5, s, s1, l, l1, list, list1, flag, flag1, list2, ((IBinder) (zzoh1)));
    }

    private boolean zzb(SessionReadRequest sessionreadrequest)
    {
        return zzw.equal(zzasS, sessionreadrequest.zzasS) && zzHP.equals(sessionreadrequest.zzHP) && zzNY == sessionreadrequest.zzNY && zzapN == sessionreadrequest.zzapN && zzw.equal(zzapW, sessionreadrequest.zzapW) && zzw.equal(zzasd, sessionreadrequest.zzasd) && zzasT == sessionreadrequest.zzasT && zzasU.equals(sessionreadrequest.zzasU) && zzaso == sessionreadrequest.zzaso;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return this == obj || (obj instanceof SessionReadRequest) && zzb((SessionReadRequest)obj);
    }

    public List getDataSources()
    {
        return zzasd;
    }

    public List getDataTypes()
    {
        return zzapW;
    }

    public long getEndTime(TimeUnit timeunit)
    {
        return timeunit.convert(zzapN, TimeUnit.MILLISECONDS);
    }

    public List getExcludedPackages()
    {
        return zzasU;
    }

    public String getSessionId()
    {
        return zzHP;
    }

    public String getSessionName()
    {
        return zzasS;
    }

    public long getStartTime(TimeUnit timeunit)
    {
        return timeunit.convert(zzNY, TimeUnit.MILLISECONDS);
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzasS, zzHP, Long.valueOf(zzNY), Long.valueOf(zzapN)
        });
    }

    public boolean includeSessionsFromAllApps()
    {
        return zzasT;
    }

    public String toString()
    {
        return zzw.zzv(this).zzg("sessionName", zzasS).zzg("sessionId", zzHP).zzg("startTimeMillis", Long.valueOf(zzNY)).zzg("endTimeMillis", Long.valueOf(zzapN)).zzg("dataTypes", zzapW).zzg("dataSources", zzasd).zzg("sessionsFromAllApps", Boolean.valueOf(zzasT)).zzg("excludedPackages", zzasU).zzg("useServer", Boolean.valueOf(zzaso)).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzv.zza(this, parcel, i);
    }

    public long zzkX()
    {
        return zzNY;
    }

    public IBinder zzsO()
    {
        if (zzasV == null)
        {
            return null;
        } else
        {
            return zzasV.asBinder();
        }
    }

    public boolean zzsT()
    {
        return zzaso;
    }

    public long zzsi()
    {
        return zzapN;
    }

    public boolean zzti()
    {
        return zzasT;
    }

}
