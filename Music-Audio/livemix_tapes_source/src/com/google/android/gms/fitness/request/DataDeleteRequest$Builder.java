// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.fitness.request:
//            DataDeleteRequest

public static class zzapJ
{

    private long zzMS;
    private long zzann;
    private List zzanw;
    private List zzapG;
    private List zzapH;
    private boolean zzapI;
    private boolean zzapJ;

    static long zza(zzapJ zzapj)
    {
        return zzapj.zzMS;
    }

    static long zzb(zzMS zzms)
    {
        return zzms.zzann;
    }

    static List zzc(zzann zzann1)
    {
        return zzann1.zzapG;
    }

    static List zzd(zzapG zzapg)
    {
        return zzapg.zzanw;
    }

    static List zze(zzanw zzanw1)
    {
        return zzanw1.zzapH;
    }

    static boolean zzf(zzapH zzaph)
    {
        return zzaph.zzapI;
    }

    static boolean zzg(zzapI zzapi)
    {
        return zzapi.zzapJ;
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

    public zzann addDataSource(DataSource datasource)
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

    public zzapG addDataType(DataType datatype)
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

    public zzanw addSession(Session session)
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
        return new DataDeleteRequest(this, null);
    }

    public zzsf deleteAllData()
    {
        zzx.zzb(zzanw.isEmpty(), "Specific data type already added for deletion. deleteAllData() will delete all data types and cannot be combined with addDataType()");
        zzx.zzb(zzapG.isEmpty(), "Specific data source already added for deletion. deleteAllData() will delete all data sources and cannot be combined with addDataSource()");
        zzapI = true;
        return this;
    }

    public zzapI deleteAllSessions()
    {
        zzx.zzb(zzapH.isEmpty(), "Specific session already added for deletion. deleteAllData() will delete all sessions and cannot be combined with addSession()");
        zzapJ = true;
        return this;
    }

    public zzapJ setTimeInterval(long l, long l1, TimeUnit timeunit)
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

    public ()
    {
        zzapG = new ArrayList();
        zzanw = new ArrayList();
        zzapH = new ArrayList();
        zzapI = false;
        zzapJ = false;
    }
}
