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

public static class zzasg
{

    private long zzNY;
    private long zzapN;
    private List zzapW;
    private List zzasd;
    private List zzase;
    private boolean zzasf;
    private boolean zzasg;

    static long zza(zzasg zzasg1)
    {
        return zzasg1.zzNY;
    }

    static long zzb(zzNY zzny)
    {
        return zzny.zzapN;
    }

    static List zzc(zzapN zzapn)
    {
        return zzapn.zzasd;
    }

    static List zzd(zzasd zzasd1)
    {
        return zzasd1.zzapW;
    }

    static List zze(zzapW zzapw)
    {
        return zzapw.zzase;
    }

    static boolean zzf(zzase zzase1)
    {
        return zzase1.zzasf;
    }

    static boolean zzg(zzasf zzasf1)
    {
        return zzasf1.zzasg;
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

    public zzapN addDataSource(DataSource datasource)
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

    public zzasd addDataType(DataType datatype)
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

    public zzapW addSession(Session session)
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
        return new DataDeleteRequest(this, null);
    }

    public zzsR deleteAllData()
    {
        zzx.zzb(zzapW.isEmpty(), "Specific data type already added for deletion. deleteAllData() will delete all data types and cannot be combined with addDataType()");
        zzx.zzb(zzasd.isEmpty(), "Specific data source already added for deletion. deleteAllData() will delete all data sources and cannot be combined with addDataSource()");
        zzasf = true;
        return this;
    }

    public zzasf deleteAllSessions()
    {
        zzx.zzb(zzase.isEmpty(), "Specific session already added for deletion. deleteAllData() will delete all sessions and cannot be combined with addSession()");
        zzasg = true;
        return this;
    }

    public zzasg setTimeInterval(long l, long l1, TimeUnit timeunit)
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

    public ()
    {
        zzasd = new ArrayList();
        zzapW = new ArrayList();
        zzase = new ArrayList();
        zzasf = false;
        zzasg = false;
    }
}
