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
import com.google.android.gms.internal.zzms;
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

        private long zzMS;
        private long zzann;
        private List zzanw;
        private int zzanz;
        private List zzapG;
        private List zzapL;
        private List zzapM;
        private long zzapN;
        private DataSource zzapO;
        private int zzapP;
        private boolean zzapQ;
        private boolean zzapR;
        private List zzapT;

        static List zza(Builder builder)
        {
            return builder.zzanw;
        }

        static List zzb(Builder builder)
        {
            return builder.zzapG;
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
            return builder.zzapL;
        }

        static List zzf(Builder builder)
        {
            return builder.zzapM;
        }

        static int zzg(Builder builder)
        {
            return builder.zzanz;
        }

        static long zzh(Builder builder)
        {
            return builder.zzapN;
        }

        static DataSource zzi(Builder builder)
        {
            return builder.zzapO;
        }

        static int zzj(Builder builder)
        {
            return builder.zzapP;
        }

        static boolean zzk(Builder builder)
        {
            return builder.zzapQ;
        }

        static boolean zzl(Builder builder)
        {
            return builder.zzapR;
        }

        static List zzm(Builder builder)
        {
            return builder.zzapT;
        }

        public Builder aggregate(DataSource datasource, DataType datatype)
        {
            zzx.zzb(datasource, "Attempting to add a null data source");
            DataType datatype1;
            boolean flag;
            if (!zzapG.contains(datasource))
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
            if (!zzapM.contains(datasource))
            {
                zzapM.add(datasource);
            }
            return this;
        }

        public Builder aggregate(DataType datatype, DataType datatype1)
        {
            zzx.zzb(datatype, "Attempting to use a null data type");
            boolean flag;
            if (!zzanw.contains(datatype))
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
            if (!zzapL.contains(datatype))
            {
                zzapL.add(datatype);
            }
            return this;
        }

        public Builder bucketByActivitySegment(int i, TimeUnit timeunit)
        {
            boolean flag;
            if (zzanz == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "Bucketing strategy already set to %s", new Object[] {
                Integer.valueOf(zzanz)
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
            zzanz = 4;
            zzapN = timeunit.toMillis(i);
            return this;
        }

        public Builder bucketByActivitySegment(int i, TimeUnit timeunit, DataSource datasource)
        {
            boolean flag;
            if (zzanz == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "Bucketing strategy already set to %s", new Object[] {
                Integer.valueOf(zzanz)
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
            zzapO = datasource;
            zzanz = 4;
            zzapN = timeunit.toMillis(i);
            return this;
        }

        public Builder bucketByActivityType(int i, TimeUnit timeunit)
        {
            boolean flag;
            if (zzanz == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "Bucketing strategy already set to %s", new Object[] {
                Integer.valueOf(zzanz)
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
            zzanz = 3;
            zzapN = timeunit.toMillis(i);
            return this;
        }

        public Builder bucketByActivityType(int i, TimeUnit timeunit, DataSource datasource)
        {
            boolean flag;
            if (zzanz == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "Bucketing strategy already set to %s", new Object[] {
                Integer.valueOf(zzanz)
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
            zzapO = datasource;
            zzanz = 3;
            zzapN = timeunit.toMillis(i);
            return this;
        }

        public Builder bucketBySession(int i, TimeUnit timeunit)
        {
            boolean flag;
            if (zzanz == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "Bucketing strategy already set to %s", new Object[] {
                Integer.valueOf(zzanz)
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
            zzanz = 2;
            zzapN = timeunit.toMillis(i);
            return this;
        }

        public Builder bucketByTime(int i, TimeUnit timeunit)
        {
            boolean flag;
            if (zzanz == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "Bucketing strategy already set to %s", new Object[] {
                Integer.valueOf(zzanz)
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
            zzanz = 1;
            zzapN = timeunit.toMillis(i);
            return this;
        }

        public DataReadRequest build()
        {
label0:
            {
                boolean flag2 = true;
                boolean flag;
                boolean flag1;
                if (!zzapG.isEmpty() || !zzanw.isEmpty() || !zzapM.isEmpty() || !zzapL.isEmpty())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                zzx.zza(flag1, "Must add at least one data source (aggregated or detailed)");
                if (zzMS > 0L)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                zzx.zza(flag1, "Invalid start time: %s", new Object[] {
                    Long.valueOf(zzMS)
                });
                if (zzann > 0L && zzann > zzMS)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                zzx.zza(flag1, "Invalid end time: %s", new Object[] {
                    Long.valueOf(zzann)
                });
                if (zzapM.isEmpty() && zzapL.isEmpty())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    flag1 = flag2;
                    if (zzanz == 0)
                    {
                        break label0;
                    }
                }
                if (!flag && zzanz != 0)
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
            zzapR = true;
            return this;
        }

        public Builder read(DataSource datasource)
        {
            zzx.zzb(datasource, "Attempting to add a null data source");
            boolean flag;
            if (!zzapM.contains(datasource))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "Cannot add the same data source as aggregated and detailed");
            if (!zzapG.contains(datasource))
            {
                zzapG.add(datasource);
            }
            return this;
        }

        public Builder read(DataType datatype)
        {
            zzx.zzb(datatype, "Attempting to use a null data type");
            boolean flag;
            if (!zzapL.contains(datatype))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zza(flag, "Cannot add the same data type as aggregated and detailed");
            if (!zzanw.contains(datatype))
            {
                zzanw.add(datatype);
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
            zzapP = i;
            return this;
        }

        public Builder setTimeRange(long l, long l1, TimeUnit timeunit)
        {
            zzMS = timeunit.toMillis(l);
            zzann = timeunit.toMillis(l1);
            return this;
        }

        public Builder()
        {
            zzanw = new ArrayList();
            zzapG = new ArrayList();
            zzapL = new ArrayList();
            zzapM = new ArrayList();
            zzanz = 0;
            zzapN = 0L;
            zzapP = 0;
            zzapQ = false;
            zzapR = false;
            zzapT = new ArrayList();
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new zzf();
    public static final int NO_LIMIT = 0;
    private final int mVersionCode;
    private final long zzMS;
    private final String zzOZ;
    private final long zzann;
    private final List zzanw;
    private final int zzanz;
    private final List zzapG;
    private final List zzapL;
    private final List zzapM;
    private final long zzapN;
    private final DataSource zzapO;
    private final int zzapP;
    private final boolean zzapQ;
    private final boolean zzapR;
    private final zzms zzapS;
    private final List zzapT;

    DataReadRequest(int i, List list, List list1, long l, long l1, 
            List list2, List list3, int j, long l2, DataSource datasource, int k, 
            boolean flag, boolean flag1, IBinder ibinder, String s, List list4)
    {
        mVersionCode = i;
        zzanw = Collections.unmodifiableList(list);
        zzapG = Collections.unmodifiableList(list1);
        zzMS = l;
        zzann = l1;
        zzapL = Collections.unmodifiableList(list2);
        zzapM = Collections.unmodifiableList(list3);
        zzanz = j;
        zzapN = l2;
        zzapO = datasource;
        zzapP = k;
        zzapQ = flag;
        zzapR = flag1;
        if (ibinder == null)
        {
            list = null;
        } else
        {
            list = com.google.android.gms.internal.zzms.zza.zzbu(ibinder);
        }
        zzapS = list;
        zzOZ = s;
        list = list4;
        if (list4 == null)
        {
            list = Collections.EMPTY_LIST;
        }
        zzapT = list;
    }

    private DataReadRequest(Builder builder)
    {
        this(Builder.zza(builder), Builder.zzb(builder), Builder.zzc(builder), Builder.zzd(builder), Builder.zze(builder), Builder.zzf(builder), Builder.zzg(builder), Builder.zzh(builder), Builder.zzi(builder), Builder.zzj(builder), Builder.zzk(builder), Builder.zzl(builder), null, null, Builder.zzm(builder));
    }


    public DataReadRequest(DataReadRequest datareadrequest, zzms zzms1, String s)
    {
        this(datareadrequest.zzanw, datareadrequest.zzapG, datareadrequest.zzMS, datareadrequest.zzann, datareadrequest.zzapL, datareadrequest.zzapM, datareadrequest.zzanz, datareadrequest.zzapN, datareadrequest.zzapO, datareadrequest.zzapP, datareadrequest.zzapQ, datareadrequest.zzapR, zzms1, s, datareadrequest.zzapT);
    }

    public DataReadRequest(List list, List list1, long l, long l1, List list2, 
            List list3, int i, long l2, DataSource datasource, int j, boolean flag, 
            boolean flag1, zzms zzms1, String s, List list4)
    {
        mVersionCode = 4;
        zzanw = Collections.unmodifiableList(list);
        zzapG = Collections.unmodifiableList(list1);
        zzMS = l;
        zzann = l1;
        zzapL = Collections.unmodifiableList(list2);
        zzapM = Collections.unmodifiableList(list3);
        zzanz = i;
        zzapN = l2;
        zzapO = datasource;
        zzapP = j;
        zzapQ = flag;
        zzapR = flag1;
        zzapS = zzms1;
        zzOZ = s;
        zzapT = list4;
    }

    private boolean zzb(DataReadRequest datareadrequest)
    {
        return zzanw.equals(datareadrequest.zzanw) && zzapG.equals(datareadrequest.zzapG) && zzMS == datareadrequest.zzMS && zzann == datareadrequest.zzann && zzanz == datareadrequest.zzanz && zzapM.equals(datareadrequest.zzapM) && zzapL.equals(datareadrequest.zzapL) && zzw.equal(zzapO, datareadrequest.zzapO) && zzapN == datareadrequest.zzapN && zzapR == datareadrequest.zzapR;
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
        return zzapO;
    }

    public List getAggregatedDataSources()
    {
        return zzapM;
    }

    public List getAggregatedDataTypes()
    {
        return zzapL;
    }

    public long getBucketDuration(TimeUnit timeunit)
    {
        return timeunit.convert(zzapN, TimeUnit.MILLISECONDS);
    }

    public int getBucketType()
    {
        return zzanz;
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

    public int getLimit()
    {
        return zzapP;
    }

    public String getPackageName()
    {
        return zzOZ;
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
            Integer.valueOf(zzanz), Long.valueOf(zzMS), Long.valueOf(zzann)
        });
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("DataReadRequest{");
        if (!zzanw.isEmpty())
        {
            for (Iterator iterator = zzanw.iterator(); iterator.hasNext(); stringbuilder.append(((DataType)iterator.next()).zzrH()).append(" ")) { }
        }
        if (!zzapG.isEmpty())
        {
            for (Iterator iterator1 = zzapG.iterator(); iterator1.hasNext(); stringbuilder.append(((DataSource)iterator1.next()).toDebugString()).append(" ")) { }
        }
        if (zzanz != 0)
        {
            stringbuilder.append("bucket by ").append(Bucket.zzel(zzanz));
            if (zzapN > 0L)
            {
                stringbuilder.append(" >").append(zzapN).append("ms");
            }
            stringbuilder.append(": ");
        }
        if (!zzapL.isEmpty())
        {
            for (Iterator iterator2 = zzapL.iterator(); iterator2.hasNext(); stringbuilder.append(((DataType)iterator2.next()).zzrH()).append(" ")) { }
        }
        if (!zzapM.isEmpty())
        {
            for (Iterator iterator3 = zzapM.iterator(); iterator3.hasNext(); stringbuilder.append(((DataSource)iterator3.next()).toDebugString()).append(" ")) { }
        }
        stringbuilder.append(String.format("(%tF %tT - %tF %tT)", new Object[] {
            Long.valueOf(zzMS), Long.valueOf(zzMS), Long.valueOf(zzann), Long.valueOf(zzann)
        }));
        if (zzapO != null)
        {
            stringbuilder.append("activities: ").append(zzapO.toDebugString());
        }
        if (zzapR)
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
        if (zzapS == null)
        {
            return null;
        } else
        {
            return zzapS.asBinder();
        }
    }

    public boolean zzsh()
    {
        return zzapR;
    }

    public boolean zzsi()
    {
        return zzapQ;
    }

    public long zzsj()
    {
        return zzapN;
    }

    public List zzsk()
    {
        return zzapT;
    }

}
