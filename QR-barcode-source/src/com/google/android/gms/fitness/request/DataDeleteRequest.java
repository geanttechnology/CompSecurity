// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.Parcel;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.o;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.fitness.request:
//            d

public class DataDeleteRequest
    implements SafeParcelable
{
    public static class Builder
    {

        private long KS;
        private List SB;
        private long Sr;
        private List Uk;
        private List Ul;
        private boolean Um;
        private boolean Un;

        static long a(Builder builder)
        {
            return builder.KS;
        }

        static long b(Builder builder)
        {
            return builder.Sr;
        }

        static List c(Builder builder)
        {
            return builder.Uk;
        }

        static List d(Builder builder)
        {
            return builder.SB;
        }

        static List e(Builder builder)
        {
            return builder.Ul;
        }

        static boolean f(Builder builder)
        {
            return builder.Um;
        }

        static boolean g(Builder builder)
        {
            return builder.Un;
        }

        private void ji()
        {
            if (!Ul.isEmpty())
            {
                Iterator iterator = Ul.iterator();
                while (iterator.hasNext()) 
                {
                    Session session = (Session)iterator.next();
                    boolean flag;
                    if (session.getStartTime(TimeUnit.MILLISECONDS) >= KS && session.getEndTime(TimeUnit.MILLISECONDS) <= Sr)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    o.a(flag, "Session %s is outside the time interval [%d, %d]", new Object[] {
                        session, Long.valueOf(KS), Long.valueOf(Sr)
                    });
                }
            }
        }

        public Builder addDataSource(DataSource datasource)
        {
            boolean flag1 = true;
            boolean flag;
            if (!Um)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            o.b(flag, "All data is already marked for deletion");
            if (datasource != null)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            o.b(flag, "Must specify a valid data source");
            if (!Uk.contains(datasource))
            {
                Uk.add(datasource);
            }
            return this;
        }

        public Builder addDataType(DataType datatype)
        {
            boolean flag1 = true;
            boolean flag;
            if (!Um)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            o.b(flag, "All data is already marked for deletion");
            if (datatype != null)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            o.b(flag, "Must specify a valid data type");
            if (!SB.contains(datatype))
            {
                SB.add(datatype);
            }
            return this;
        }

        public Builder addSession(Session session)
        {
            boolean flag1 = true;
            boolean flag;
            if (!Un)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            o.b(flag, "All sessions already marked for deletion");
            if (session != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            o.b(flag, "Must specify a valid session");
            if (session.getEndTime(TimeUnit.MILLISECONDS) > 0L)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            o.b(flag, "Must specify a session that has already ended");
            Ul.add(session);
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
                if (KS > 0L && Sr > KS)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                o.a(flag2, "Must specify a valid time interval");
                if (Um || !Uk.isEmpty() || !SB.isEmpty())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (Un || !Ul.isEmpty())
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
            o.a(flag2, "No data or session marked for deletion");
            ji();
            return new DataDeleteRequest(this);
        }

        public Builder deleteAllData()
        {
            boolean flag;
            if (SB.isEmpty() && Uk.isEmpty())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            o.b(flag, "Specific data source/type already specified for deletion. DataSources: %s DataTypes: %s", new Object[] {
                Uk, SB
            });
            Um = true;
            return this;
        }

        public Builder deleteAllSessions()
        {
            o.b(Ul.isEmpty(), "Specific sessions already added for deletion: %s", new Object[] {
                Ul
            });
            Un = true;
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
            o.b(flag, "Invalid start time :%d", new Object[] {
                Long.valueOf(l)
            });
            if (l1 > l)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            o.b(flag, "Invalid end time :%d", new Object[] {
                Long.valueOf(l1)
            });
            KS = timeunit.toMillis(l);
            Sr = timeunit.toMillis(l1);
            return this;
        }

        public Builder()
        {
            Uk = new ArrayList();
            SB = new ArrayList();
            Ul = new ArrayList();
            Um = false;
            Un = false;
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new d();
    private final int BR;
    private final long KS;
    private final List SB;
    private final long Sr;
    private final List Uk;
    private final List Ul;
    private final boolean Um;
    private final boolean Un;

    DataDeleteRequest(int i, long l, long l1, List list, List list1, 
            List list2, boolean flag, boolean flag1)
    {
        BR = i;
        KS = l;
        Sr = l1;
        Uk = Collections.unmodifiableList(list);
        SB = Collections.unmodifiableList(list1);
        Ul = list2;
        Um = flag;
        Un = flag1;
    }

    private DataDeleteRequest(Builder builder)
    {
        BR = 1;
        KS = Builder.a(builder);
        Sr = Builder.b(builder);
        Uk = Collections.unmodifiableList(Builder.c(builder));
        SB = Collections.unmodifiableList(Builder.d(builder));
        Ul = Collections.unmodifiableList(Builder.e(builder));
        Um = Builder.f(builder);
        Un = Builder.g(builder);
    }


    private boolean a(DataDeleteRequest datadeleterequest)
    {
        return KS == datadeleterequest.KS && Sr == datadeleterequest.Sr && n.equal(Uk, datadeleterequest.Uk) && n.equal(SB, datadeleterequest.SB) && n.equal(Ul, datadeleterequest.Ul) && Um == datadeleterequest.Um && Un == datadeleterequest.Un;
    }

    public boolean deleteAllData()
    {
        return Um;
    }

    public boolean deleteAllSessions()
    {
        return Un;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return obj == this || (obj instanceof DataDeleteRequest) && a((DataDeleteRequest)obj);
    }

    public List getDataSources()
    {
        return Uk;
    }

    public List getDataTypes()
    {
        return SB;
    }

    public long getEndTime(TimeUnit timeunit)
    {
        return timeunit.convert(Sr, TimeUnit.MILLISECONDS);
    }

    public List getSessions()
    {
        return Ul;
    }

    public long getStartTime(TimeUnit timeunit)
    {
        return timeunit.convert(KS, TimeUnit.MILLISECONDS);
    }

    int getVersionCode()
    {
        return BR;
    }

    public int hashCode()
    {
        return n.hashCode(new Object[] {
            Long.valueOf(KS), Long.valueOf(Sr)
        });
    }

    public long iD()
    {
        return KS;
    }

    public long iE()
    {
        return Sr;
    }

    public boolean jg()
    {
        return Um;
    }

    public boolean jh()
    {
        return Un;
    }

    public String toString()
    {
        return n.h(this).a("startTimeMillis", Long.valueOf(KS)).a("endTimeMillis", Long.valueOf(Sr)).a("dataSources", Uk).a("dateTypes", SB).a("sessions", Ul).a("deleteAllData", Boolean.valueOf(Um)).a("deleteAllSessions", Boolean.valueOf(Un)).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        d.a(this, parcel, i);
    }

}
