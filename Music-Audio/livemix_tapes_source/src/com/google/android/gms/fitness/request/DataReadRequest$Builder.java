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

public static class zzapT
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

    static List zza(zzapT zzapt)
    {
        return zzapt.zzanw;
    }

    static List zzb(zzanw zzanw1)
    {
        return zzanw1.zzapG;
    }

    static long zzc(zzapG zzapg)
    {
        return zzapg.zzMS;
    }

    static long zzd(zzMS zzms)
    {
        return zzms.zzann;
    }

    static List zze(zzann zzann1)
    {
        return zzann1.zzapL;
    }

    static List zzf(zzapL zzapl)
    {
        return zzapl.zzapM;
    }

    static int zzg(zzapM zzapm)
    {
        return zzapm.zzanz;
    }

    static long zzh(zzanz zzanz1)
    {
        return zzanz1.zzapN;
    }

    static DataSource zzi(zzapN zzapn)
    {
        return zzapn.zzapO;
    }

    static int zzj(zzapO zzapo)
    {
        return zzapo.zzapP;
    }

    static boolean zzk(zzapP zzapp)
    {
        return zzapp.zzapQ;
    }

    static boolean zzl(zzapQ zzapq)
    {
        return zzapq.zzapR;
    }

    static List zzm(zzapR zzapr)
    {
        return zzapr.zzapT;
    }

    public zzapT aggregate(DataSource datasource, DataType datatype)
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

    public zzapM aggregate(DataType datatype, DataType datatype1)
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

    public zzapL bucketByActivitySegment(int i, TimeUnit timeunit)
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

    public zzapN bucketByActivitySegment(int i, TimeUnit timeunit, DataSource datasource)
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

    public zzapN bucketByActivityType(int i, TimeUnit timeunit)
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

    public zzapN bucketByActivityType(int i, TimeUnit timeunit, DataSource datasource)
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

    public zzapN bucketBySession(int i, TimeUnit timeunit)
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

    public zzapN bucketByTime(int i, TimeUnit timeunit)
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
        return new DataReadRequest(this, null);
    }

    public zzanz enableServerQueries()
    {
        zzapR = true;
        return this;
    }

    public zzapR read(DataSource datasource)
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

    public zzapG read(DataType datatype)
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

    public zzanw setLimit(int i)
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

    public zzapP setTimeRange(long l, long l1, TimeUnit timeunit)
    {
        zzMS = timeunit.toMillis(l);
        zzann = timeunit.toMillis(l1);
        return this;
    }

    public ()
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
