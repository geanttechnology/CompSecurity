// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zznu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzf

public class DataReadRequest
    implements SafeParcelable
{
    public static class Builder
    {

        private long zzNY;
        private long zzapN;
        private List zzapW;
        private int zzapZ;
        private List zzasd;
        private List zzasi;
        private List zzasj;
        private long zzask;
        private DataSource zzasl;
        private int zzasm;
        private boolean zzasn;
        private boolean zzaso;
        private List zzasq;

        static List zza(Builder builder)
        {
            return builder.zzapW;
        }

        static List zzb(Builder builder)
        {
            return builder.zzasd;
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
            return builder.zzasi;
        }

        static List zzf(Builder builder)
        {
            return builder.zzasj;
        }

        static int zzg(Builder builder)
        {
            return builder.zzapZ;
        }

        static long zzh(Builder builder)
        {
            return builder.zzask;
        }

        static DataSource zzi(Builder builder)
        {
            return builder.zzasl;
        }

        static int zzj(Builder builder)
        {
            return builder.zzasm;
        }

        static boolean zzk(Builder builder)
        {
            return builder.zzasn;
        }

        static boolean zzl(Builder builder)
        {
            return builder.zzaso;
        }

        static List zzm(Builder builder)
        {
            return builder.zzasq;
        }

        public Builder aggregate(DataSource datasource, DataType datatype)
        {
            zzx.zzb(datasource, "Attempting to add a null data source");
            DataType datatype1;
            boolean flag;
            if (!zzasd.contains(datasource))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zza(flag, "Cannot add the same data source for aggregated and detailed");
            datatype1 = datasource.getDataType();
            zzx.zzb(DataType.AGGREGATE_INPUT_TYPES.contains(datatype1), "Unsupported input data type specified for aggregation: %s", new Object[] {
                datatype1
            });
            zzx.zzb(DataType.getAggregatesForInput(datatype1).contains(datatype), "Invalid output aggregate data type specified: %s -> %s", new Object[] {
                datatype1, datatype
            });
            if (!zzasj.contains(datasource))
            {
                zzasj.add(datasource);
            }
            return this;
        }

        public Builder aggregate(DataType datatype, DataType datatype1)
        {
            zzx.zzb(datatype, "Attempting to use a null data type");
            boolean flag;
            if (!zzapW.contains(datatype))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zza(flag, "Cannot add the same data type as aggregated and detailed");
            zzx.zzb(DataType.AGGREGATE_INPUT_TYPES.contains(datatype), "Unsupported input data type specified for aggregation: %s", new Object[] {
                datatype
            });
            zzx.zzb(DataType.getAggregatesForInput(datatype).contains(datatype1), "Invalid output aggregate data type specified: %s -> %s", new Object[] {
                datatype, datatype1
            });
            if (!zzasi.contains(datatype))
            {
                zzasi.add(datatype);
            }
            return this;
        }

        public Builder bucketByActivitySegment(int i, TimeUnit timeunit)
        {
            boolean flag;
            if (zzapZ == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "Bucketing strategy already set to %s", new Object[] {
                Integer.valueOf(zzapZ)
            });
            if (i > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "Must specify a valid minimum duration for an activity segment: %d", new Object[] {
                Integer.valueOf(i)
            });
            zzapZ = 4;
            zzask = timeunit.toMillis(i);
            return this;
        }

        public Builder bucketByActivitySegment(int i, TimeUnit timeunit, DataSource datasource)
        {
            boolean flag;
            if (zzapZ == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "Bucketing strategy already set to %s", new Object[] {
                Integer.valueOf(zzapZ)
            });
            if (i > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "Must specify a valid minimum duration for an activity segment: %d", new Object[] {
                Integer.valueOf(i)
            });
            if (datasource != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "Invalid activity data source specified");
            zzx.zzb(datasource.getDataType().equals(DataType.TYPE_ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", new Object[] {
                datasource
            });
            zzasl = datasource;
            zzapZ = 4;
            zzask = timeunit.toMillis(i);
            return this;
        }

        public Builder bucketByActivityType(int i, TimeUnit timeunit)
        {
            boolean flag;
            if (zzapZ == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "Bucketing strategy already set to %s", new Object[] {
                Integer.valueOf(zzapZ)
            });
            if (i > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "Must specify a valid minimum duration for an activity segment: %d", new Object[] {
                Integer.valueOf(i)
            });
            zzapZ = 3;
            zzask = timeunit.toMillis(i);
            return this;
        }

        public Builder bucketByActivityType(int i, TimeUnit timeunit, DataSource datasource)
        {
            boolean flag;
            if (zzapZ == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "Bucketing strategy already set to %s", new Object[] {
                Integer.valueOf(zzapZ)
            });
            if (i > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "Must specify a valid minimum duration for an activity segment: %d", new Object[] {
                Integer.valueOf(i)
            });
            if (datasource != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "Invalid activity data source specified");
            zzx.zzb(datasource.getDataType().equals(DataType.TYPE_ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", new Object[] {
                datasource
            });
            zzasl = datasource;
            zzapZ = 3;
            zzask = timeunit.toMillis(i);
            return this;
        }

        public Builder bucketBySession(int i, TimeUnit timeunit)
        {
            boolean flag;
            if (zzapZ == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "Bucketing strategy already set to %s", new Object[] {
                Integer.valueOf(zzapZ)
            });
            if (i > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "Must specify a valid minimum duration for an activity segment: %d", new Object[] {
                Integer.valueOf(i)
            });
            zzapZ = 2;
            zzask = timeunit.toMillis(i);
            return this;
        }

        public Builder bucketByTime(int i, TimeUnit timeunit)
        {
            boolean flag;
            if (zzapZ == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "Bucketing strategy already set to %s", new Object[] {
                Integer.valueOf(zzapZ)
            });
            if (i > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "Must specify a valid minimum duration for an activity segment: %d", new Object[] {
                Integer.valueOf(i)
            });
            zzapZ = 1;
            zzask = timeunit.toMillis(i);
            return this;
        }

        public DataReadRequest build()
        {
label0:
            {
                boolean flag2 = true;
                boolean flag;
                boolean flag1;
                if (!zzasd.isEmpty() || !zzapW.isEmpty() || !zzasj.isEmpty() || !zzasi.isEmpty())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                zzx.zza(flag1, "Must add at least one data source (aggregated or detailed)");
                if (zzNY > 0L)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                zzx.zza(flag1, "Invalid start time: %s", new Object[] {
                    Long.valueOf(zzNY)
                });
                if (zzapN > 0L && zzapN > zzNY)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                zzx.zza(flag1, "Invalid end time: %s", new Object[] {
                    Long.valueOf(zzapN)
                });
                if (zzasj.isEmpty() && zzasi.isEmpty())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    flag1 = flag2;
                    if (zzapZ == 0)
                    {
                        break label0;
                    }
                }
                if (!flag && zzapZ != 0)
                {
                    flag1 = flag2;
                } else
                {
                    flag1 = false;
                }
            }
            zzx.zza(flag1, "Must specify a valid bucketing strategy while requesting aggregation");
            return new DataReadRequest(this);
        }

        public Builder enableServerQueries()
        {
            zzaso = true;
            return this;
        }

        public Builder read(DataSource datasource)
        {
            zzx.zzb(datasource, "Attempting to add a null data source");
            boolean flag;
            if (!zzasj.contains(datasource))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "Cannot add the same data source as aggregated and detailed");
            if (!zzasd.contains(datasource))
            {
                zzasd.add(datasource);
            }
            return this;
        }

        public Builder read(DataType datatype)
        {
            zzx.zzb(datatype, "Attempting to use a null data type");
            boolean flag;
            if (!zzasi.contains(datatype))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zza(flag, "Cannot add the same data type as aggregated and detailed");
            if (!zzapW.contains(datatype))
            {
                zzapW.add(datatype);
            }
            return this;
        }

        public Builder setLimit(int i)
        {
            boolean flag;
            if (i > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "Invalid limit %d is specified", new Object[] {
                Integer.valueOf(i)
            });
            zzasm = i;
            return this;
        }

        public Builder setTimeRange(long l, long l1, TimeUnit timeunit)
        {
            zzNY = timeunit.toMillis(l);
            zzapN = timeunit.toMillis(l1);
            return this;
        }

        public Builder()
        {
            zzapW = new ArrayList();
            zzasd = new ArrayList();
            zzasi = new ArrayList();
            zzasj = new ArrayList();
            zzapZ = 0;
            zzask = 0L;
            zzasm = 0;
            zzasn = false;
            zzaso = false;
            zzasq = new ArrayList();
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new zzf();
    public static final int NO_LIMIT = 0;
    private final int mVersionCode;
    private final long zzNY;
    private final long zzapN;
    private final List zzapW;
    private final int zzapZ;
    private final List zzasd;
    private final List zzasi;
    private final List zzasj;
    private final long zzask;
    private final DataSource zzasl;
    private final int zzasm;
    private final boolean zzasn;
    private final boolean zzaso;
    private final zznu zzasp;
    private final List zzasq;

    DataReadRequest(int i, List list, List list1, long l, long l1, 
            List list2, List list3, int j, long l2, DataSource datasource, int k, 
            boolean flag, boolean flag1, IBinder ibinder, List list4)
    {
        mVersionCode = i;
        zzapW = list;
        zzasd = list1;
        zzNY = l;
        zzapN = l1;
        zzasi = list2;
        zzasj = list3;
        zzapZ = j;
        zzask = l2;
        zzasl = datasource;
        zzasm = k;
        zzasn = flag;
        zzaso = flag1;
        if (ibinder == null)
        {
            list = null;
        } else
        {
            list = com.google.android.gms.internal.zznu.zza.zzbu(ibinder);
        }
        zzasp = list;
        list = list4;
        if (list4 == null)
        {
            list = Collections.EMPTY_LIST;
        }
        zzasq = list;
    }

    private DataReadRequest(Builder builder)
    {
        this(Builder.zza(builder), Builder.zzb(builder), Builder.zzc(builder), Builder.zzd(builder), Builder.zze(builder), Builder.zzf(builder), Builder.zzg(builder), Builder.zzh(builder), Builder.zzi(builder), Builder.zzj(builder), Builder.zzk(builder), Builder.zzl(builder), null, Builder.zzm(builder));
    }


    public DataReadRequest(DataReadRequest datareadrequest, zznu zznu1)
    {
        this(datareadrequest.zzapW, datareadrequest.zzasd, datareadrequest.zzNY, datareadrequest.zzapN, datareadrequest.zzasi, datareadrequest.zzasj, datareadrequest.zzapZ, datareadrequest.zzask, datareadrequest.zzasl, datareadrequest.zzasm, datareadrequest.zzasn, datareadrequest.zzaso, zznu1, datareadrequest.zzasq);
    }

    public DataReadRequest(List list, List list1, long l, long l1, List list2, 
            List list3, int i, long l2, DataSource datasource, int j, boolean flag, 
            boolean flag1, zznu zznu1, List list4)
    {
        if (zznu1 == null)
        {
            zznu1 = null;
        } else
        {
            zznu1 = zznu1.asBinder();
        }
        this(5, list, list1, l, l1, list2, list3, i, l2, datasource, j, flag, flag1, ((IBinder) (zznu1)), list4);
    }

    private boolean zzb(DataReadRequest datareadrequest)
    {
        return zzapW.equals(datareadrequest.zzapW) && zzasd.equals(datareadrequest.zzasd) && zzNY == datareadrequest.zzNY && zzapN == datareadrequest.zzapN && zzapZ == datareadrequest.zzapZ && zzasj.equals(datareadrequest.zzasj) && zzasi.equals(datareadrequest.zzasi) && zzw.equal(zzasl, datareadrequest.zzasl) && zzask == datareadrequest.zzask && zzaso == datareadrequest.zzaso;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return this == obj || (obj instanceof DataReadRequest) && zzb((DataReadRequest)obj);
    }

    public DataSource getActivityDataSource()
    {
        return zzasl;
    }

    public List getAggregatedDataSources()
    {
        return zzasj;
    }

    public List getAggregatedDataTypes()
    {
        return zzasi;
    }

    public long getBucketDuration(TimeUnit timeunit)
    {
        return timeunit.convert(zzask, TimeUnit.MILLISECONDS);
    }

    public int getBucketType()
    {
        return zzapZ;
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

    public int getLimit()
    {
        return zzasm;
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
            Integer.valueOf(zzapZ), Long.valueOf(zzNY), Long.valueOf(zzapN)
        });
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("DataReadRequest{");
        if (!zzapW.isEmpty())
        {
            for (Iterator iterator = zzapW.iterator(); iterator.hasNext(); stringbuilder.append(((DataType)iterator.next()).zzst()).append(" ")) { }
        }
        if (!zzasd.isEmpty())
        {
            for (Iterator iterator1 = zzasd.iterator(); iterator1.hasNext(); stringbuilder.append(((DataSource)iterator1.next()).toDebugString()).append(" ")) { }
        }
        if (zzapZ != 0)
        {
            stringbuilder.append("bucket by ").append(Bucket.zzeu(zzapZ));
            if (zzask > 0L)
            {
                stringbuilder.append(" >").append(zzask).append("ms");
            }
            stringbuilder.append(": ");
        }
        if (!zzasi.isEmpty())
        {
            for (Iterator iterator2 = zzasi.iterator(); iterator2.hasNext(); stringbuilder.append(((DataType)iterator2.next()).zzst()).append(" ")) { }
        }
        if (!zzasj.isEmpty())
        {
            for (Iterator iterator3 = zzasj.iterator(); iterator3.hasNext(); stringbuilder.append(((DataSource)iterator3.next()).toDebugString()).append(" ")) { }
        }
        stringbuilder.append(String.format("(%tF %tT - %tF %tT)", new Object[] {
            Long.valueOf(zzNY), Long.valueOf(zzNY), Long.valueOf(zzapN), Long.valueOf(zzapN)
        }));
        if (zzasl != null)
        {
            stringbuilder.append("activities: ").append(zzasl.toDebugString());
        }
        if (zzaso)
        {
            stringbuilder.append(" +server");
        }
        stringbuilder.append("}");
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzf.zza(this, parcel, i);
    }

    public long zzkX()
    {
        return zzNY;
    }

    public IBinder zzsO()
    {
        if (zzasp == null)
        {
            return null;
        } else
        {
            return zzasp.asBinder();
        }
    }

    public boolean zzsT()
    {
        return zzaso;
    }

    public boolean zzsU()
    {
        return zzasn;
    }

    public long zzsV()
    {
        return zzask;
    }

    public List zzsW()
    {
        return zzasq;
    }

    public long zzsi()
    {
        return zzapN;
    }

}
