// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.FitnessActivities;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.fitness.data:
//            zzp, Application

public class Session
    implements SafeParcelable
{
    public static class Builder
    {

        private String mName;
        private long zzNY;
        private long zzapN;
        private int zzapX;
        private String zzaqY;
        private String zzaqZ;
        private Application zzaqk;
        private Long zzara;

        static long zza(Builder builder)
        {
            return builder.zzNY;
        }

        static long zzb(Builder builder)
        {
            return builder.zzapN;
        }

        static String zzc(Builder builder)
        {
            return builder.mName;
        }

        static String zzd(Builder builder)
        {
            return builder.zzaqY;
        }

        static String zze(Builder builder)
        {
            return builder.zzaqZ;
        }

        static int zzf(Builder builder)
        {
            return builder.zzapX;
        }

        static Application zzg(Builder builder)
        {
            return builder.zzaqk;
        }

        static Long zzh(Builder builder)
        {
            return builder.zzara;
        }

        public Session build()
        {
label0:
            {
                boolean flag1 = false;
                StringBuilder stringbuilder;
                boolean flag;
                if (zzNY > 0L)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                zzx.zza(flag, "Start time should be specified.");
                if (zzapN != 0L)
                {
                    flag = flag1;
                    if (zzapN <= zzNY)
                    {
                        break label0;
                    }
                }
                flag = true;
            }
            zzx.zza(flag, "End time should be later than start time.");
            if (zzaqY == null)
            {
                stringbuilder = new StringBuilder();
                String s;
                if (mName == null)
                {
                    s = "";
                } else
                {
                    s = mName;
                }
                zzaqY = stringbuilder.append(s).append(zzNY).toString();
            }
            return new Session(this);
        }

        public Builder setActiveTime(long l, TimeUnit timeunit)
        {
            zzara = Long.valueOf(timeunit.toMillis(l));
            return this;
        }

        public Builder setActivity(String s)
        {
            return zzeH(FitnessActivities.zzcO(s));
        }

        public Builder setDescription(String s)
        {
            boolean flag;
            if (s.length() <= 1000)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "Session description cannot exceed %d characters", new Object[] {
                Integer.valueOf(1000)
            });
            zzaqZ = s;
            return this;
        }

        public Builder setEndTime(long l, TimeUnit timeunit)
        {
            boolean flag;
            if (l >= 0L)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zza(flag, "End time should be positive.");
            zzapN = timeunit.toMillis(l);
            return this;
        }

        public Builder setIdentifier(String s)
        {
            boolean flag;
            if (s != null && TextUtils.getTrimmedLength(s) > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzaa(flag);
            zzaqY = s;
            return this;
        }

        public Builder setName(String s)
        {
            boolean flag;
            if (s.length() <= 100)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "Session name cannot exceed %d characters", new Object[] {
                Integer.valueOf(100)
            });
            mName = s;
            return this;
        }

        public Builder setStartTime(long l, TimeUnit timeunit)
        {
            boolean flag;
            if (l > 0L)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zza(flag, "Start time should be positive.");
            zzNY = timeunit.toMillis(l);
            return this;
        }

        public Builder zzeH(int i)
        {
            zzapX = i;
            return this;
        }

        public Builder()
        {
            zzNY = 0L;
            zzapN = 0L;
            mName = null;
            zzapX = 4;
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new zzp();
    public static final String EXTRA_SESSION = "vnd.google.fitness.session";
    public static final String MIME_TYPE_PREFIX = "vnd.google.fitness.session/";
    private final String mName;
    private final int mVersionCode;
    private final long zzNY;
    private final long zzapN;
    private final int zzapX;
    private final String zzaqY;
    private final String zzaqZ;
    private final Application zzaqk;
    private final Long zzara;

    Session(int i, long l, long l1, String s, String s1, 
            String s2, int j, Application application, Long long1)
    {
        mVersionCode = i;
        zzNY = l;
        zzapN = l1;
        mName = s;
        zzaqY = s1;
        zzaqZ = s2;
        zzapX = j;
        zzaqk = application;
        zzara = long1;
    }

    public Session(long l, long l1, String s, String s1, String s2, 
            int i, Application application, Long long1)
    {
        this(3, l, l1, s, s1, s2, i, application, long1);
    }

    private Session(Builder builder)
    {
        this(Builder.zza(builder), Builder.zzb(builder), com.google.android.gms.fitness.data.Builder.zzc(builder), Builder.zzd(builder), Builder.zze(builder), Builder.zzf(builder), Builder.zzg(builder), Builder.zzh(builder));
    }


    public static Session extract(Intent intent)
    {
        if (intent == null)
        {
            return null;
        } else
        {
            return (Session)zzc.zza(intent, "vnd.google.fitness.session", CREATOR);
        }
    }

    public static String getMimeType(String s)
    {
        return (new StringBuilder()).append("vnd.google.fitness.session/").append(s).toString();
    }

    private boolean zza(Session session)
    {
        return zzNY == session.zzNY && zzapN == session.zzapN && zzw.equal(mName, session.mName) && zzw.equal(zzaqY, session.zzaqY) && zzw.equal(zzaqZ, session.zzaqZ) && zzw.equal(zzaqk, session.zzaqk) && zzapX == session.zzapX;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return obj == this || (obj instanceof Session) && zza((Session)obj);
    }

    public long getActiveTime(TimeUnit timeunit)
    {
        boolean flag;
        if (zzara != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Active time is not set");
        return timeunit.convert(zzara.longValue(), TimeUnit.MILLISECONDS);
    }

    public String getActivity()
    {
        return FitnessActivities.getName(zzapX);
    }

    public String getAppPackageName()
    {
        if (zzaqk == null)
        {
            return null;
        } else
        {
            return zzaqk.getPackageName();
        }
    }

    public String getDescription()
    {
        return zzaqZ;
    }

    public long getEndTime(TimeUnit timeunit)
    {
        return timeunit.convert(zzapN, TimeUnit.MILLISECONDS);
    }

    public String getIdentifier()
    {
        return zzaqY;
    }

    public String getName()
    {
        return mName;
    }

    public long getStartTime(TimeUnit timeunit)
    {
        return timeunit.convert(zzNY, TimeUnit.MILLISECONDS);
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public boolean hasActiveTime()
    {
        return zzara != null;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Long.valueOf(zzNY), Long.valueOf(zzapN), zzaqY
        });
    }

    public boolean isOngoing()
    {
        return zzapN == 0L;
    }

    public String toString()
    {
        return zzw.zzv(this).zzg("startTime", Long.valueOf(zzNY)).zzg("endTime", Long.valueOf(zzapN)).zzg("name", mName).zzg("identifier", zzaqY).zzg("description", zzaqZ).zzg("activity", Integer.valueOf(zzapX)).zzg("application", zzaqk).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzp.zza(this, parcel, i);
    }

    public long zzkX()
    {
        return zzNY;
    }

    public int zzsg()
    {
        return zzapX;
    }

    public long zzsi()
    {
        return zzapN;
    }

    public Application zzsr()
    {
        return zzaqk;
    }

    public Long zzsz()
    {
        return zzara;
    }

}
