// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.zznj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.fitness.request:
//            SessionInsertRequest

public static class zzasR
{

    private Session zzapP;
    private List zzapY;
    private List zzasQ;
    private List zzasR;

    static Session zza(zzasR zzasr)
    {
        return zzasr.zzapP;
    }

    static List zzb(zzapP zzapp)
    {
        return zzapp.zzapY;
    }

    static List zzc(zzapY zzapy)
    {
        return zzapy.zzasQ;
    }

    private void zzd(DataPoint datapoint)
    {
        zzf(datapoint);
        zze(datapoint);
    }

    private void zze(DataPoint datapoint)
    {
        long l2 = zzapP.getStartTime(TimeUnit.NANOSECONDS);
        long l3 = zzapP.getEndTime(TimeUnit.NANOSECONDS);
        long l4 = datapoint.getStartTime(TimeUnit.NANOSECONDS);
        long l1 = datapoint.getEndTime(TimeUnit.NANOSECONDS);
        if (l4 != 0L && l1 != 0L)
        {
            TimeUnit timeunit = TimeUnit.MILLISECONDS;
            long l = l1;
            if (l1 > l3)
            {
                l = zznj.zza(l1, TimeUnit.NANOSECONDS, timeunit);
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
                l2 = zzapP.getStartTime(TimeUnit.NANOSECONDS);
                l3 = zzapP.getEndTime(TimeUnit.NANOSECONDS);
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
                l = zznj.zza(l1, TimeUnit.NANOSECONDS, timeunit);
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

    private void zzth()
    {
        for (Iterator iterator = zzapY.iterator(); iterator.hasNext();)
        {
            Iterator iterator2 = ((DataSet)iterator.next()).getDataPoints().iterator();
            while (iterator2.hasNext()) 
            {
                zzd((DataPoint)iterator2.next());
            }
        }

        for (Iterator iterator1 = zzasQ.iterator(); iterator1.hasNext(); zzd((DataPoint)iterator1.next())) { }
    }

    public zzd addAggregateDataPoint(DataPoint datapoint)
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
        if (!zzasR.contains(datasource))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Data set/Aggregate data point for this data source %s is already added.", new Object[] {
            datasource
        });
        zzasR.add(datasource);
        zzasQ.add(datapoint);
        return this;
    }

    public zzasQ addDataSet(DataSet dataset)
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
        if (!zzasR.contains(datasource))
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
        zzasR.add(datasource);
        zzapY.add(dataset);
        return this;
    }

    public SessionInsertRequest build()
    {
        boolean flag1 = true;
        boolean flag;
        if (zzapP != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Must specify a valid session.");
        if (zzapP.getEndTime(TimeUnit.MILLISECONDS) != 0L)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Must specify a valid end time, cannot insert a continuing session.");
        zzth();
        return new SessionInsertRequest(this, null);
    }

    public zzth setSession(Session session)
    {
        zzapP = session;
        return this;
    }

    public I()
    {
        zzapY = new ArrayList();
        zzasQ = new ArrayList();
        zzasR = new ArrayList();
    }
}
