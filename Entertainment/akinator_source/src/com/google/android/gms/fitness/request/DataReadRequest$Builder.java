// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.fitness.request:
//            DataReadRequest

public static class zzasq
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

    static List zza(zzasq zzasq1)
    {
        return zzasq1.zzapW;
    }

    static List zzb(zzapW zzapw)
    {
        return zzapw.zzasd;
    }

    static long zzc(zzasd zzasd1)
    {
        return zzasd1.zzNY;
    }

    static long zzd(zzNY zzny)
    {
        return zzny.zzapN;
    }

    static List zze(zzapN zzapn)
    {
        return zzapn.zzasi;
    }

    static List zzf(zzasi zzasi1)
    {
        return zzasi1.zzasj;
    }

    static int zzg(zzasj zzasj1)
    {
        return zzasj1.zzapZ;
    }

    static long zzh(zzapZ zzapz)
    {
        return zzapz.zzask;
    }

    static DataSource zzi(zzask zzask1)
    {
        return zzask1.zzasl;
    }

    static int zzj(zzasl zzasl1)
    {
        return zzasl1.zzasm;
    }

    static boolean zzk(zzasm zzasm1)
    {
        return zzasm1.zzasn;
    }

    static boolean zzl(zzasn zzasn1)
    {
        return zzasn1.zzaso;
    }

    static List zzm(zzaso zzaso1)
    {
        return zzaso1.zzasq;
    }

    public zzasq aggregate(DataSource datasource, DataType datatype)
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

    public zzasj aggregate(DataType datatype, DataType datatype1)
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

    public zzasi bucketByActivitySegment(int i, TimeUnit timeunit)
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

    public zzask bucketByActivitySegment(int i, TimeUnit timeunit, DataSource datasource)
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

    public zzask bucketByActivityType(int i, TimeUnit timeunit)
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

    public zzask bucketByActivityType(int i, TimeUnit timeunit, DataSource datasource)
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

    public zzask bucketBySession(int i, TimeUnit timeunit)
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

    public zzask bucketByTime(int i, TimeUnit timeunit)
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
        return new DataReadRequest(this, null);
    }

    public zzapZ enableServerQueries()
    {
        zzaso = true;
        return this;
    }

    public zzaso read(DataSource datasource)
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

    public zzasd read(DataType datatype)
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

    public zzapW setLimit(int i)
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

    public zzasm setTimeRange(long l, long l1, TimeUnit timeunit)
    {
        zzNY = timeunit.toMillis(l);
        zzapN = timeunit.toMillis(l1);
        return this;
    }

    public ()
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
