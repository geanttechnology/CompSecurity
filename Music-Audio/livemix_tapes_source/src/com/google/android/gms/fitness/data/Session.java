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
        private long zzMS;
        private Application zzanK;
        private long zzann;
        private int zzanx;
        private String zzaoA;
        private String zzaoB;
        private Long zzaoC;

        static long zza(Builder builder)
        {
            return builder.zzMS;
        }

        static long zzb(Builder builder)
        {
            return builder.zzann;
        }

        static String zzc(Builder builder)
        {
            return builder.mName;
        }

        static String zzd(Builder builder)
        {
            return builder.zzaoA;
        }

        static String zze(Builder builder)
        {
            return builder.zzaoB;
        }

        static int zzf(Builder builder)
        {
            return builder.zzanx;
        }

        static Application zzg(Builder builder)
        {
            return builder.zzanK;
        }

        static Long zzh(Builder builder)
        {
            return builder.zzaoC;
        }

        public Session build()
        {
label0:
            {
                boolean flag1 = false;
                StringBuilder stringbuilder;
                boolean flag;
                if (zzMS > 0L)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                zzx.zza(flag, "Start time should be specified.");
                if (zzann != 0L)
                {
                    flag = flag1;
                    if (zzann <= zzMS)
                    {
                        break label0;
                    }
                }
                flag = true;
            }
            zzx.zza(flag, "End time should be later than start time.");
            if (zzaoA == null)
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
                zzaoA = stringbuilder.append(s).append(zzMS).toString();
            }
            return new Session(this);
        }

        public Builder setActiveTime(long l, TimeUnit timeunit)
        {
            zzaoC = Long.valueOf(timeunit.toMillis(l));
            return this;
        }

        public Builder setActivity(String s)
        {
            return zzey(FitnessActivities.zzcP(s));
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
            zzaoB = s;
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
            zzann = timeunit.toMillis(l);
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
            zzx.zzZ(flag);
            zzaoA = s;
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
            zzMS = timeunit.toMillis(l);
            return this;
        }

        public Builder zzey(int i)
        {
            zzanx = i;
            return this;
        }

        public Builder()
        {
            zzMS = 0L;
            zzann = 0L;
            mName = null;
            zzanx = 4;
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new zzp();
    public static final String EXTRA_SESSION = "vnd.google.fitness.session";
    public static final String MIME_TYPE_PREFIX = "vnd.google.fitness.session/";
    private final String mName;
    private final int mVersionCode;
    private final long zzMS;
    private final Application zzanK;
    private final long zzann;
    private final int zzanx;
    private final String zzaoA;
    private final String zzaoB;
    private final Long zzaoC;

    Session(int i, long l, long l1, String s, String s1, 
            String s2, int j, Application application, Long long1)
    {
        mVersionCode = i;
        zzMS = l;
        zzann = l1;
        mName = s;
        zzaoA = s1;
        zzaoB = s2;
        zzanx = j;
        zzanK = application;
        zzaoC = long1;
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
        return zzMS == session.zzMS && zzann == session.zzann && zzw.equal(mName, session.mName) && zzw.equal(zzaoA, session.zzaoA) && zzw.equal(zzaoB, session.zzaoB) && zzw.equal(zzanK, session.zzanK) && zzanx == session.zzanx;
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
        if (zzaoC != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Active time is not set");
        return timeunit.convert(zzaoC.longValue(), TimeUnit.MILLISECONDS);
    }

    public String getActivity()
    {
        return FitnessActivities.getName(zzanx);
    }

    public String getAppPackageName()
    {
        if (zzanK == null)
        {
            return null;
        } else
        {
            return zzanK.getPackageName();
        }
    }

    public String getDescription()
    {
        return zzaoB;
    }

    public long getEndTime(TimeUnit timeunit)
    {
        return timeunit.convert(zzann, TimeUnit.MILLISECONDS);
    }

    public String getIdentifier()
    {
        return zzaoA;
    }

    public String getName()
    {
        return mName;
    }

    public long getStartTime(TimeUnit timeunit)
    {
        return timeunit.convert(zzMS, TimeUnit.MILLISECONDS);
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public boolean hasActiveTime()
    {
        return zzaoC != null;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Long.valueOf(zzMS), Long.valueOf(zzann), zzaoA
        });
    }

    public boolean isOngoing()
    {
        return zzann == 0L;
    }

    public String toString()
    {
        return zzw.zzu(this).zzg("startTime", Long.valueOf(zzMS)).zzg("endTime", Long.valueOf(zzann)).zzg("name", mName).zzg("identifier", zzaoA).zzg("description", zzaoB).zzg("activity", Integer.valueOf(zzanx)).zzg("application", zzanK).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzp.zza(this, parcel, i);
    }

    public long zzkH()
    {
        return zzMS;
    }

    public Application zzrF()
    {
        return zzanK;
    }

    public Long zzrN()
    {
        return zzaoC;
    }

    public int zzru()
    {
        return zzanx;
    }

    public long zzrw()
    {
        return zzann;
    }

}
