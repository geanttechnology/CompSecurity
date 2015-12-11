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
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.zzoj;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzd

public class DataDeleteRequest
    implements SafeParcelable
{
    public static class Builder
    {

        private long zzNY;
        private long zzapN;
        private List zzapW;
        private List zzasd;
        private List zzase;
        private boolean zzasf;
        private boolean zzasg;

        static long zza(Builder builder)
        {
            return builder.zzNY;
        }

        static long zzb(Builder builder)
        {
            return builder.zzapN;
        }

        static List zzc(Builder builder)
        {
            return builder.zzasd;
        }

        static List zzd(Builder builder)
        {
            return builder.zzapW;
        }

        static List zze(Builder builder)
        {
            return builder.zzase;
        }

        static boolean zzf(Builder builder)
        {
            return builder.zzasf;
        }

        static boolean zzg(Builder builder)
        {
            return builder.zzasg;
        }

        private void zzsR()
        {
            if (!zzase.isEmpty())
            {
                Iterator iterator = zzase.iterator();
                while (iterator.hasNext()) 
                {
                    Session session = (Session)iterator.next();
                    boolean flag;
                    if (session.getStartTime(TimeUnit.MILLISECONDS) >= zzNY && session.getEndTime(TimeUnit.MILLISECONDS) <= zzapN)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    zzx.zza(flag, "Session %s is outside the time interval [%d, %d]", new Object[] {
                        session, Long.valueOf(zzNY), Long.valueOf(zzapN)
                    });
                }
            }
        }

        public Builder addDataSource(DataSource datasource)
        {
            boolean flag1 = true;
            boolean flag;
            if (!zzasf)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "All data is already marked for deletion.  addDataSource() cannot be combined with deleteAllData()");
            if (datasource != null)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "Must specify a valid data source");
            if (!zzasd.contains(datasource))
            {
                zzasd.add(datasource);
            }
            return this;
        }

        public Builder addDataType(DataType datatype)
        {
            boolean flag1 = true;
            boolean flag;
            if (!zzasf)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "All data is already marked for deletion.  addDataType() cannot be combined with deleteAllData()");
            if (datatype != null)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "Must specify a valid data type");
            if (!zzapW.contains(datatype))
            {
                zzapW.add(datatype);
            }
            return this;
        }

        public Builder addSession(Session session)
        {
            boolean flag1 = true;
            boolean flag;
            if (!zzasg)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "All sessions already marked for deletion.  addSession() cannot be combined with deleteAllSessions()");
            if (session != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "Must specify a valid session");
            if (session.getEndTime(TimeUnit.MILLISECONDS) > 0L)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "Cannot delete an ongoing session. Please stop the session prior to deleting it");
            zzase.add(session);
            return this;
        }

        public DataDeleteRequest build()
        {
label0:
            {
                boolean flag3 = false;
                boolean flag;
                boolean flag1;
                boolean flag2;
                if (zzNY > 0L && zzapN > zzNY)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                zzx.zza(flag2, "Must specify a valid time interval");
                if (zzasf || !zzasd.isEmpty() || !zzapW.isEmpty())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (zzasg || !zzase.isEmpty())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (!flag)
                {
                    flag2 = flag3;
                    if (!flag1)
                    {
                        break label0;
                    }
                }
                flag2 = true;
            }
            zzx.zza(flag2, "No data or session marked for deletion");
            zzsR();
            return new DataDeleteRequest(this);
        }

        public Builder deleteAllData()
        {
            zzx.zzb(zzapW.isEmpty(), "Specific data type already added for deletion. deleteAllData() will delete all data types and cannot be combined with addDataType()");
            zzx.zzb(zzasd.isEmpty(), "Specific data source already added for deletion. deleteAllData() will delete all data sources and cannot be combined with addDataSource()");
            zzasf = true;
            return this;
        }

        public Builder deleteAllSessions()
        {
            zzx.zzb(zzase.isEmpty(), "Specific session already added for deletion. deleteAllData() will delete all sessions and cannot be combined with addSession()");
            zzasg = true;
            return this;
        }

        public Builder setTimeInterval(long l, long l1, TimeUnit timeunit)
        {
            boolean flag;
            if (l > 0L)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "Invalid start time :%d", new Object[] {
                Long.valueOf(l)
            });
            if (l1 > l)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "Invalid end time :%d", new Object[] {
                Long.valueOf(l1)
            });
            zzNY = timeunit.toMillis(l);
            zzapN = timeunit.toMillis(l1);
            return this;
        }

        public Builder()
        {
            zzasd = new ArrayList();
            zzapW = new ArrayList();
            zzase = new ArrayList();
            zzasf = false;
            zzasg = false;
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new zzd();
    private final int mVersionCode;
    private final long zzNY;
    private final long zzapN;
    private final List zzapW;
    private final zzoj zzasb;
    private final List zzasd;
    private final List zzase;
    private final boolean zzasf;
    private final boolean zzasg;

    DataDeleteRequest(int i, long l, long l1, List list, List list1, 
            List list2, boolean flag, boolean flag1, IBinder ibinder)
    {
        mVersionCode = i;
        zzNY = l;
        zzapN = l1;
        zzasd = Collections.unmodifiableList(list);
        zzapW = Collections.unmodifiableList(list1);
        zzase = list2;
        zzasf = flag;
        zzasg = flag1;
        zzasb = com.google.android.gms.internal.zzoj.zza.zzbJ(ibinder);
    }

    public DataDeleteRequest(long l, long l1, List list, List list1, List list2, 
            boolean flag, boolean flag1, zzoj zzoj1)
    {
        mVersionCode = 3;
        zzNY = l;
        zzapN = l1;
        zzasd = Collections.unmodifiableList(list);
        zzapW = Collections.unmodifiableList(list1);
        zzase = list2;
        zzasf = flag;
        zzasg = flag1;
        zzasb = zzoj1;
    }

    private DataDeleteRequest(Builder builder)
    {
        this(Builder.zza(builder), Builder.zzb(builder), Builder.zzc(builder), Builder.zzd(builder), Builder.zze(builder), Builder.zzf(builder), Builder.zzg(builder), null);
    }


    public DataDeleteRequest(DataDeleteRequest datadeleterequest, zzoj zzoj1)
    {
        this(datadeleterequest.zzNY, datadeleterequest.zzapN, datadeleterequest.zzasd, datadeleterequest.zzapW, datadeleterequest.zzase, datadeleterequest.zzasf, datadeleterequest.zzasg, zzoj1);
    }

    private boolean zzb(DataDeleteRequest datadeleterequest)
    {
        return zzNY == datadeleterequest.zzNY && zzapN == datadeleterequest.zzapN && zzw.equal(zzasd, datadeleterequest.zzasd) && zzw.equal(zzapW, datadeleterequest.zzapW) && zzw.equal(zzase, datadeleterequest.zzase) && zzasf == datadeleterequest.zzasf && zzasg == datadeleterequest.zzasg;
    }

    public boolean deleteAllData()
    {
        return zzasf;
    }

    public boolean deleteAllSessions()
    {
        return zzasg;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return obj == this || (obj instanceof DataDeleteRequest) && zzb((DataDeleteRequest)obj);
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

    public List getSessions()
    {
        return zzase;
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
            Long.valueOf(zzNY), Long.valueOf(zzapN)
        });
    }

    public String toString()
    {
        return zzw.zzv(this).zzg("startTimeMillis", Long.valueOf(zzNY)).zzg("endTimeMillis", Long.valueOf(zzapN)).zzg("dataSources", zzasd).zzg("dateTypes", zzapW).zzg("sessions", zzase).zzg("deleteAllData", Boolean.valueOf(zzasf)).zzg("deleteAllSessions", Boolean.valueOf(zzasg)).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzd.zza(this, parcel, i);
    }

    public long zzkX()
    {
        return zzNY;
    }

    public IBinder zzsO()
    {
        if (zzasb == null)
        {
            return null;
        } else
        {
            return zzasb.asBinder();
        }
    }

    public boolean zzsP()
    {
        return zzasf;
    }

    public boolean zzsQ()
    {
        return zzasg;
    }

    public long zzsi()
    {
        return zzapN;
    }

}
