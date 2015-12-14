// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.zzmh;
import com.google.android.gms.internal.zznh;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzu

public class SessionInsertRequest
    implements SafeParcelable
{
    public static class Builder
    {

        private Session zzanp;
        private List zzany;
        private List zzaqt;
        private List zzaqu;

        static Session zza(Builder builder)
        {
            return builder.zzanp;
        }

        static List zzb(Builder builder)
        {
            return builder.zzany;
        }

        static List zzc(Builder builder)
        {
            return builder.zzaqt;
        }

        private void zzd(DataPoint datapoint)
        {
            zzf(datapoint);
            zze(datapoint);
        }

        private void zze(DataPoint datapoint)
        {
            long l2 = zzanp.getStartTime(TimeUnit.NANOSECONDS);
            long l3 = zzanp.getEndTime(TimeUnit.NANOSECONDS);
            long l4 = datapoint.getStartTime(TimeUnit.NANOSECONDS);
            long l1 = datapoint.getEndTime(TimeUnit.NANOSECONDS);
            if (l4 != 0L && l1 != 0L)
            {
                TimeUnit timeunit = TimeUnit.MILLISECONDS;
                long l = l1;
                if (l1 > l3)
                {
                    l = zzmh.zza(l1, TimeUnit.NANOSECONDS, timeunit);
                }
                boolean flag;
                if (l4 >= l2 && l <= l3)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                zzx.zza(flag, "Data point %s has start and end times outside session interval [%d, %d]", new Object[] {
                    datapoint, Long.valueOf(l2), Long.valueOf(l3)
                });
                if (l != datapoint.getEndTime(TimeUnit.NANOSECONDS))
                {
                    Log.w("Fitness", String.format("Data point end time [%d] is truncated to [%d] to match the precision [%s] of the session start and end time", new Object[] {
                        Long.valueOf(datapoint.getEndTime(TimeUnit.NANOSECONDS)), Long.valueOf(l), timeunit
                    }));
                    datapoint.setTimeInterval(l4, l, TimeUnit.NANOSECONDS);
                }
            }
        }

        private void zzf(DataPoint datapoint)
        {
label0:
            {
                TimeUnit timeunit;
                long l;
                long l2;
                long l3;
label1:
                {
                    l2 = zzanp.getStartTime(TimeUnit.NANOSECONDS);
                    l3 = zzanp.getEndTime(TimeUnit.NANOSECONDS);
                    long l1 = datapoint.getTimestamp(TimeUnit.NANOSECONDS);
                    if (l1 == 0L)
                    {
                        break label0;
                    }
                    timeunit = TimeUnit.MILLISECONDS;
                    if (l1 >= l2)
                    {
                        l = l1;
                        if (l1 <= l3)
                        {
                            break label1;
                        }
                    }
                    l = zzmh.zza(l1, TimeUnit.NANOSECONDS, timeunit);
                }
                boolean flag;
                if (l >= l2 && l <= l3)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                zzx.zza(flag, "Data point %s has time stamp outside session interval [%d, %d]", new Object[] {
                    datapoint, Long.valueOf(l2), Long.valueOf(l3)
                });
                if (datapoint.getTimestamp(TimeUnit.NANOSECONDS) != l)
                {
                    Log.w("Fitness", String.format("Data point timestamp [%d] is truncated to [%d] to match the precision [%s] of the session start and end time", new Object[] {
                        Long.valueOf(datapoint.getTimestamp(TimeUnit.NANOSECONDS)), Long.valueOf(l), timeunit
                    }));
                    datapoint.setTimestamp(l, TimeUnit.NANOSECONDS);
                }
            }
        }

        private void zzsv()
        {
            for (Iterator iterator = zzany.iterator(); iterator.hasNext();)
            {
                Iterator iterator2 = ((DataSet)iterator.next()).getDataPoints().iterator();
                while (iterator2.hasNext()) 
                {
                    zzd((DataPoint)iterator2.next());
                }
            }

            for (Iterator iterator1 = zzaqt.iterator(); iterator1.hasNext(); zzd((DataPoint)iterator1.next())) { }
        }

        public Builder addAggregateDataPoint(DataPoint datapoint)
        {
            com.google.android.gms.fitness.data.DataSource datasource;
            long l;
            long l1;
            boolean flag;
            if (datapoint != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "Must specify a valid aggregate data point.");
            l = datapoint.getStartTime(TimeUnit.NANOSECONDS);
            l1 = datapoint.getEndTime(TimeUnit.NANOSECONDS);
            if (l > 0L && l1 > l)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "Aggregate data point should have valid start and end times: %s", new Object[] {
                datapoint
            });
            datasource = datapoint.getDataSource();
            if (!zzaqu.contains(datasource))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zza(flag, "Data set/Aggregate data point for this data source %s is already added.", new Object[] {
                datasource
            });
            zzaqu.add(datasource);
            zzaqt.add(datapoint);
            return this;
        }

        public Builder addDataSet(DataSet dataset)
        {
            boolean flag1 = true;
            com.google.android.gms.fitness.data.DataSource datasource;
            boolean flag;
            if (dataset != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "Must specify a valid data set.");
            datasource = dataset.getDataSource();
            if (!zzaqu.contains(datasource))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zza(flag, "Data set for this data source %s is already added.", new Object[] {
                datasource
            });
            if (!dataset.getDataPoints().isEmpty())
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "No data points specified in the input data set.");
            zzaqu.add(datasource);
            zzany.add(dataset);
            return this;
        }

        public SessionInsertRequest build()
        {
            boolean flag1 = true;
            boolean flag;
            if (zzanp != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zza(flag, "Must specify a valid session.");
            if (zzanp.getEndTime(TimeUnit.MILLISECONDS) != 0L)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            zzx.zza(flag, "Must specify a valid end time, cannot insert a continuing session.");
            zzsv();
            return new SessionInsertRequest(this);
        }

        public Builder setSession(Session session)
        {
            zzanp = session;
            return this;
        }

        public Builder()
        {
            zzany = new ArrayList();
            zzaqt = new ArrayList();
            zzaqu = new ArrayList();
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new zzu();
    private final int mVersionCode;
    private final String zzOZ;
    private final Session zzanp;
    private final List zzany;
    private final zznh zzapE;
    private final List zzaqt;

    SessionInsertRequest(int i, Session session, List list, List list1, IBinder ibinder, String s)
    {
        mVersionCode = i;
        zzanp = session;
        zzany = Collections.unmodifiableList(list);
        zzaqt = Collections.unmodifiableList(list1);
        if (ibinder == null)
        {
            session = null;
        } else
        {
            session = com.google.android.gms.internal.zznh.zza.zzbJ(ibinder);
        }
        zzapE = session;
        zzOZ = s;
    }

    public SessionInsertRequest(Session session, List list, List list1, zznh zznh1, String s)
    {
        mVersionCode = 2;
        zzanp = session;
        zzany = Collections.unmodifiableList(list);
        zzaqt = Collections.unmodifiableList(list1);
        zzapE = zznh1;
        zzOZ = s;
    }

    private SessionInsertRequest(Builder builder)
    {
        this(Builder.zza(builder), Builder.zzb(builder), Builder.zzc(builder), null, null);
    }


    public SessionInsertRequest(SessionInsertRequest sessioninsertrequest, zznh zznh1, String s)
    {
        this(sessioninsertrequest.zzanp, sessioninsertrequest.zzany, sessioninsertrequest.zzaqt, zznh1, s);
    }

    private boolean zzb(SessionInsertRequest sessioninsertrequest)
    {
        return zzw.equal(zzanp, sessioninsertrequest.zzanp) && zzw.equal(zzany, sessioninsertrequest.zzany) && zzw.equal(zzaqt, sessioninsertrequest.zzaqt);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return obj == this || (obj instanceof SessionInsertRequest) && zzb((SessionInsertRequest)obj);
    }

    public List getAggregateDataPoints()
    {
        return zzaqt;
    }

    public List getDataSets()
    {
        return zzany;
    }

    public String getPackageName()
    {
        return zzOZ;
    }

    public Session getSession()
    {
        return zzanp;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzanp, zzany, zzaqt
        });
    }

    public String toString()
    {
        return zzw.zzu(this).zzg("session", zzanp).zzg("dataSets", zzany).zzg("aggregateDataPoints", zzaqt).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzu.zza(this, parcel, i);
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

}
