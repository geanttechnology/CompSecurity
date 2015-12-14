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
import com.google.android.gms.internal.zznf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzv

public class SessionReadRequest
    implements SafeParcelable
{
    public static class Builder
    {

        private String zzGY;
        private long zzMS;
        private long zzann;
        private List zzanw;
        private List zzapG;
        private boolean zzapR;
        private String zzaqv;
        private boolean zzaqw;
        private List zzaqx;

        static String zza(Builder builder)
        {
            return builder.zzaqv;
        }

        static String zzb(Builder builder)
        {
            return builder.zzGY;
        }

        static long zzc(Builder builder)
        {
            return builder.zzMS;
        }

        static long zzd(Builder builder)
        {
            return builder.zzann;
        }

        static List zze(Builder builder)
        {
            return builder.zzanw;
        }

        static List zzf(Builder builder)
        {
            return builder.zzapG;
        }

        static boolean zzg(Builder builder)
        {
            return builder.zzaqw;
        }

        static boolean zzh(Builder builder)
        {
            return builder.zzapR;
        }

        static List zzi(Builder builder)
        {
            return builder.zzaqx;
        }

        public SessionReadRequest build()
        {
            boolean flag;
            if (zzMS > 0L)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "Invalid start time: %s", new Object[] {
                Long.valueOf(zzMS)
            });
            if (zzann > 0L && zzann > zzMS)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "Invalid end time: %s", new Object[] {
                Long.valueOf(zzann)
            });
            return new SessionReadRequest(this);
        }

        public Builder enableServerQueries()
        {
            zzapR = true;
            return this;
        }

        public Builder excludePackage(String s)
        {
            zzx.zzb(s, "Attempting to use a null package name");
            if (!zzaqx.contains(s))
            {
                zzaqx.add(s);
            }
            return this;
        }

        public Builder read(DataSource datasource)
        {
            zzx.zzb(datasource, "Attempting to add a null data source");
            if (!zzapG.contains(datasource))
            {
                zzapG.add(datasource);
            }
            return this;
        }

        public Builder read(DataType datatype)
        {
            zzx.zzb(datatype, "Attempting to use a null data type");
            if (!zzanw.contains(datatype))
            {
                zzanw.add(datatype);
            }
            return this;
        }

        public Builder readSessionsFromAllApps()
        {
            zzaqw = true;
            return this;
        }

        public Builder setSessionId(String s)
        {
            zzGY = s;
            return this;
        }

        public Builder setSessionName(String s)
        {
            zzaqv = s;
            return this;
        }

        public Builder setTimeInterval(long l, long l1, TimeUnit timeunit)
        {
            zzMS = timeunit.toMillis(l);
            zzann = timeunit.toMillis(l1);
            return this;
        }

        public Builder()
        {
            zzMS = 0L;
            zzann = 0L;
            zzanw = new ArrayList();
            zzapG = new ArrayList();
            zzaqw = false;
            zzapR = false;
            zzaqx = new ArrayList();
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new zzv();
    private final int mVersionCode;
    private final String zzGY;
    private final long zzMS;
    private final String zzOZ;
    private final long zzann;
    private final List zzanw;
    private final List zzapG;
    private final boolean zzapR;
    private final String zzaqv;
    private boolean zzaqw;
    private final List zzaqx;
    private final zznf zzaqy;

    SessionReadRequest(int i, String s, String s1, long l, long l1, 
            List list, List list1, boolean flag, boolean flag1, List list2, IBinder ibinder, String s2)
    {
        mVersionCode = i;
        zzaqv = s;
        zzGY = s1;
        zzMS = l;
        zzann = l1;
        zzanw = Collections.unmodifiableList(list);
        zzapG = Collections.unmodifiableList(list1);
        zzaqw = flag;
        zzapR = flag1;
        zzaqx = list2;
        if (ibinder == null)
        {
            s = null;
        } else
        {
            s = com.google.android.gms.internal.zznf.zza.zzbH(ibinder);
        }
        zzaqy = s;
        zzOZ = s2;
    }

    private SessionReadRequest(Builder builder)
    {
        this(Builder.zza(builder), Builder.zzb(builder), Builder.zzc(builder), Builder.zzd(builder), Builder.zze(builder), Builder.zzf(builder), Builder.zzg(builder), Builder.zzh(builder), Builder.zzi(builder), null, null);
    }


    public SessionReadRequest(SessionReadRequest sessionreadrequest, zznf zznf1, String s)
    {
        this(sessionreadrequest.zzaqv, sessionreadrequest.zzGY, sessionreadrequest.zzMS, sessionreadrequest.zzann, sessionreadrequest.zzanw, sessionreadrequest.zzapG, sessionreadrequest.zzaqw, sessionreadrequest.zzapR, sessionreadrequest.zzaqx, zznf1, s);
    }

    public SessionReadRequest(String s, String s1, long l, long l1, List list, 
            List list1, boolean flag, boolean flag1, List list2, zznf zznf1, String s2)
    {
        mVersionCode = 4;
        zzaqv = s;
        zzGY = s1;
        zzMS = l;
        zzann = l1;
        zzanw = Collections.unmodifiableList(list);
        zzapG = Collections.unmodifiableList(list1);
        zzaqw = flag;
        zzapR = flag1;
        zzaqx = list2;
        zzaqy = zznf1;
        zzOZ = s2;
    }

    private boolean zzb(SessionReadRequest sessionreadrequest)
    {
        return zzw.equal(zzaqv, sessionreadrequest.zzaqv) && zzGY.equals(sessionreadrequest.zzGY) && zzMS == sessionreadrequest.zzMS && zzann == sessionreadrequest.zzann && zzw.equal(zzanw, sessionreadrequest.zzanw) && zzw.equal(zzapG, sessionreadrequest.zzapG) && zzaqw == sessionreadrequest.zzaqw && zzaqx.equals(sessionreadrequest.zzaqx) && zzapR == sessionreadrequest.zzapR;
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
        return zzapG;
    }

    public List getDataTypes()
    {
        return zzanw;
    }

    public long getEndTime(TimeUnit timeunit)
    {
        return timeunit.convert(zzann, TimeUnit.MILLISECONDS);
    }

    public List getExcludedPackages()
    {
        return zzaqx;
    }

    public String getPackageName()
    {
        return zzOZ;
    }

    public String getSessionId()
    {
        return zzGY;
    }

    public String getSessionName()
    {
        return zzaqv;
    }

    public long getStartTime(TimeUnit timeunit)
    {
        return timeunit.convert(zzMS, TimeUnit.MILLISECONDS);
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzaqv, zzGY, Long.valueOf(zzMS), Long.valueOf(zzann)
        });
    }

    public boolean includeSessionsFromAllApps()
    {
        return zzaqw;
    }

    public String toString()
    {
        return zzw.zzu(this).zzg("sessionName", zzaqv).zzg("sessionId", zzGY).zzg("startTimeMillis", Long.valueOf(zzMS)).zzg("endTimeMillis", Long.valueOf(zzann)).zzg("dataTypes", zzanw).zzg("dataSources", zzapG).zzg("sessionsFromAllApps", Boolean.valueOf(zzaqw)).zzg("excludedPackages", zzaqx).zzg("useServer", Boolean.valueOf(zzapR)).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzv.zza(this, parcel, i);
    }

    public long zzkH()
    {
        return zzMS;
    }

    public long zzrw()
    {
        return zzann;
    }

    public IBinder zzsc()
    {
        if (zzaqy == null)
        {
            return null;
        } else
        {
            return zzaqy.asBinder();
        }
    }

    public boolean zzsh()
    {
        return zzapR;
    }

    public boolean zzsw()
    {
        return zzaqw;
    }

}
