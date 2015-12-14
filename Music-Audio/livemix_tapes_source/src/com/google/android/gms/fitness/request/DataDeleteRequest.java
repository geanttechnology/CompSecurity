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
import com.google.android.gms.internal.zznh;
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

        private long zzMS;
        private long zzann;
        private List zzanw;
        private List zzapG;
        private List zzapH;
        private boolean zzapI;
        private boolean zzapJ;

        static long zza(Builder builder)
        {
            return builder.zzMS;
        }

        static long zzb(Builder builder)
        {
            return builder.zzann;
        }

        static List zzc(Builder builder)
        {
            return builder.zzapG;
        }

        static List zzd(Builder builder)
        {
            return builder.zzanw;
        }

        static List zze(Builder builder)
        {
            return builder.zzapH;
        }

        static boolean zzf(Builder builder)
        {
            return builder.zzapI;
        }

        static boolean zzg(Builder builder)
        {
            return builder.zzapJ;
        }

        private void zzsf()
        {
            if (!zzapH.isEmpty())
            {
                Iterator iterator = zzapH.iterator();
                while (iterator.hasNext()) 
                {
                    Session session = (Session)iterator.next();
                    boolean flag;
                    if (session.getStartTime(TimeUnit.MILLISECONDS) >= zzMS && session.getEndTime(TimeUnit.MILLISECONDS) <= zzann)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    zzx.zza(flag, "Session %s is outside the time interval [%d, %d]", new Object[] {
                        session, Long.valueOf(zzMS), Long.valueOf(zzann)
                    });
                }
            }
        }

        public Builder addDataSource(DataSource datasource)
        {
            boolean flag1 = true;
            boolean flag;
            if (!zzapI)
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
            if (!zzapG.contains(datasource))
            {
                zzapG.add(datasource);
            }
            return this;
        }

        public Builder addDataType(DataType datatype)
        {
            boolean flag1 = true;
            boolean flag;
            if (!zzapI)
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
            if (!zzanw.contains(datatype))
            {
                zzanw.add(datatype);
            }
            return this;
        }

        public Builder addSession(Session session)
        {
            boolean flag1 = true;
            boolean flag;
            if (!zzapJ)
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
            zzapH.add(session);
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
                if (zzMS > 0L && zzann > zzMS)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                zzx.zza(flag2, "Must specify a valid time interval");
                if (zzapI || !zzapG.isEmpty() || !zzanw.isEmpty())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (zzapJ || !zzapH.isEmpty())
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
            zzsf();
            return new DataDeleteRequest(this);
        }

        public Builder deleteAllData()
        {
            zzx.zzb(zzanw.isEmpty(), "Specific data type already added for deletion. deleteAllData() will delete all data types and cannot be combined with addDataType()");
            zzx.zzb(zzapG.isEmpty(), "Specific data source already added for deletion. deleteAllData() will delete all data sources and cannot be combined with addDataSource()");
            zzapI = true;
            return this;
        }

        public Builder deleteAllSessions()
        {
            zzx.zzb(zzapH.isEmpty(), "Specific session already added for deletion. deleteAllData() will delete all sessions and cannot be combined with addSession()");
            zzapJ = true;
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
            zzMS = timeunit.toMillis(l);
            zzann = timeunit.toMillis(l1);
            return this;
        }

        public Builder()
        {
            zzapG = new ArrayList();
            zzanw = new ArrayList();
            zzapH = new ArrayList();
            zzapI = false;
            zzapJ = false;
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new zzd();
    private final int mVersionCode;
    private final long zzMS;
    private final String zzOZ;
    private final long zzann;
    private final List zzanw;
    private final zznh zzapE;
    private final List zzapG;
    private final List zzapH;
    private final boolean zzapI;
    private final boolean zzapJ;

    DataDeleteRequest(int i, long l, long l1, List list, List list1, 
            List list2, boolean flag, boolean flag1, IBinder ibinder, String s)
    {
        mVersionCode = i;
        zzMS = l;
        zzann = l1;
        zzapG = Collections.unmodifiableList(list);
        zzanw = Collections.unmodifiableList(list1);
        zzapH = list2;
        zzapI = flag;
        zzapJ = flag1;
        if (ibinder == null)
        {
            list = null;
        } else
        {
            list = com.google.android.gms.internal.zznh.zza.zzbJ(ibinder);
        }
        zzapE = list;
        zzOZ = s;
    }

    public DataDeleteRequest(long l, long l1, List list, List list1, List list2, 
            boolean flag, boolean flag1, zznh zznh1, String s)
    {
        mVersionCode = 2;
        zzMS = l;
        zzann = l1;
        zzapG = Collections.unmodifiableList(list);
        zzanw = Collections.unmodifiableList(list1);
        zzapH = list2;
        zzapI = flag;
        zzapJ = flag1;
        zzapE = zznh1;
        zzOZ = s;
    }

    private DataDeleteRequest(Builder builder)
    {
        this(Builder.zza(builder), Builder.zzb(builder), Builder.zzc(builder), Builder.zzd(builder), Builder.zze(builder), Builder.zzf(builder), Builder.zzg(builder), null, null);
    }


    public DataDeleteRequest(DataDeleteRequest datadeleterequest, zznh zznh1, String s)
    {
        this(datadeleterequest.zzMS, datadeleterequest.zzann, datadeleterequest.zzapG, datadeleterequest.zzanw, datadeleterequest.zzapH, datadeleterequest.zzapI, datadeleterequest.zzapJ, zznh1, s);
    }

    private boolean zzb(DataDeleteRequest datadeleterequest)
    {
        return zzMS == datadeleterequest.zzMS && zzann == datadeleterequest.zzann && zzw.equal(zzapG, datadeleterequest.zzapG) && zzw.equal(zzanw, datadeleterequest.zzanw) && zzw.equal(zzapH, datadeleterequest.zzapH) && zzapI == datadeleterequest.zzapI && zzapJ == datadeleterequest.zzapJ;
    }

    public boolean deleteAllData()
    {
        return zzapI;
    }

    public boolean deleteAllSessions()
    {
        return zzapJ;
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

    public String getPackageName()
    {
        return zzOZ;
    }

    public List getSessions()
    {
        return zzapH;
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
            Long.valueOf(zzMS), Long.valueOf(zzann)
        });
    }

    public String toString()
    {
        return zzw.zzu(this).zzg("startTimeMillis", Long.valueOf(zzMS)).zzg("endTimeMillis", Long.valueOf(zzann)).zzg("dataSources", zzapG).zzg("dateTypes", zzanw).zzg("sessions", zzapH).zzg("deleteAllData", Boolean.valueOf(zzapI)).zzg("deleteAllSessions", Boolean.valueOf(zzapJ)).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzd.zza(this, parcel, i);
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
        if (zzapE == null)
        {
            return null;
        } else
        {
            return zzapE.asBinder();
        }
    }

    public boolean zzsd()
    {
        return zzapI;
    }

    public boolean zzse()
    {
        return zzapJ;
    }

}
