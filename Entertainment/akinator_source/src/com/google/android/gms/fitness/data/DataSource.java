// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.data;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.fitness.data:
//            zzf, DataType, Application, Device

public class DataSource
    implements SafeParcelable
{
    public static final class Builder
    {

        private String mName;
        private int zzWJ;
        private DataType zzapL;
        private Device zzaqj;
        private Application zzaqk;
        private String zzaql;

        static DataType zza(Builder builder)
        {
            return builder.zzapL;
        }

        static int zzb(Builder builder)
        {
            return builder.zzWJ;
        }

        static String zzc(Builder builder)
        {
            return builder.mName;
        }

        static Device zzd(Builder builder)
        {
            return builder.zzaqj;
        }

        static Application zze(Builder builder)
        {
            return builder.zzaqk;
        }

        static String zzf(Builder builder)
        {
            return builder.zzaql;
        }

        public DataSource build()
        {
            boolean flag1 = true;
            boolean flag;
            if (zzapL != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zza(flag, "Must set data type");
            if (zzWJ >= 0)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            zzx.zza(flag, "Must set data source type");
            return new DataSource(this);
        }

        public Builder setAppPackageName(Context context)
        {
            return setAppPackageName(context.getPackageName());
        }

        public Builder setAppPackageName(String s)
        {
            zzaqk = Application.zzcP(s);
            return this;
        }

        public Builder setDataType(DataType datatype)
        {
            zzapL = datatype;
            return this;
        }

        public Builder setDevice(Device device)
        {
            zzaqj = device;
            return this;
        }

        public Builder setName(String s)
        {
            mName = s;
            return this;
        }

        public Builder setStreamName(String s)
        {
            boolean flag;
            if (s != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "Must specify a valid stream name");
            zzaql = s;
            return this;
        }

        public Builder setType(int i)
        {
            zzWJ = i;
            return this;
        }

        public Builder()
        {
            zzWJ = -1;
            zzaql = "";
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new zzf();
    public static final String EXTRA_DATA_SOURCE = "vnd.google.fitness.data_source";
    public static final int TYPE_DERIVED = 1;
    public static final int TYPE_RAW = 0;
    private final String mName;
    private final int mVersionCode;
    private final int zzWJ;
    private final DataType zzapL;
    private final Device zzaqj;
    private final Application zzaqk;
    private final String zzaql;
    private final String zzaqm;

    DataSource(int i, DataType datatype, String s, int j, Device device, Application application, String s1)
    {
        mVersionCode = i;
        zzapL = datatype;
        zzWJ = j;
        mName = s;
        zzaqj = device;
        zzaqk = application;
        zzaql = s1;
        zzaqm = zzss();
    }

    private DataSource(Builder builder)
    {
        mVersionCode = 3;
        zzapL = Builder.zza(builder);
        zzWJ = Builder.zzb(builder);
        mName = com.google.android.gms.fitness.data.Builder.zzc(builder);
        zzaqj = Builder.zzd(builder);
        zzaqk = Builder.zze(builder);
        zzaql = Builder.zzf(builder);
        zzaqm = zzss();
    }


    public static DataSource extract(Intent intent)
    {
        if (intent == null)
        {
            return null;
        } else
        {
            return (DataSource)zzc.zza(intent, "vnd.google.fitness.data_source", CREATOR);
        }
    }

    private String getTypeString()
    {
        switch (zzWJ)
        {
        default:
            throw new IllegalArgumentException("invalid type value");

        case 0: // '\0'
            return "raw";

        case 1: // '\001'
            return "derived";
        }
    }

    private boolean zza(DataSource datasource)
    {
        return zzaqm.equals(datasource.zzaqm);
    }

    private String zzss()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(getTypeString());
        stringbuilder.append(":").append(zzapL.getName());
        if (zzaqk != null)
        {
            stringbuilder.append(":").append(zzaqk.getPackageName());
        }
        if (zzaqj != null)
        {
            stringbuilder.append(":").append(zzaqj.getStreamIdentifier());
        }
        if (zzaql != null)
        {
            stringbuilder.append(":").append(zzaql);
        }
        return stringbuilder.toString();
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return this == obj || (obj instanceof DataSource) && zza((DataSource)obj);
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

    public DataType getDataType()
    {
        return zzapL;
    }

    public Device getDevice()
    {
        return zzaqj;
    }

    public String getName()
    {
        return mName;
    }

    public String getStreamIdentifier()
    {
        return zzaqm;
    }

    public String getStreamName()
    {
        return zzaql;
    }

    public int getType()
    {
        return zzWJ;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzaqm.hashCode();
    }

    public String toDebugString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        String s;
        if (zzWJ == 0)
        {
            s = "r";
        } else
        {
            s = "d";
        }
        stringbuilder = stringbuilder.append(s).append(":").append(zzapL.zzst());
        if (zzaqk == null)
        {
            s = "";
        } else
        if (zzaqk.equals(Application.zzapS))
        {
            s = ":gms";
        } else
        {
            s = (new StringBuilder()).append(":").append(zzaqk.getPackageName()).toString();
        }
        stringbuilder = stringbuilder.append(s);
        if (zzaqj != null)
        {
            s = (new StringBuilder()).append(":").append(zzaqj.getModel()).append(":").append(zzaqj.getUid()).toString();
        } else
        {
            s = "";
        }
        stringbuilder = stringbuilder.append(s);
        if (zzaql != null)
        {
            s = (new StringBuilder()).append(":").append(zzaql).toString();
        } else
        {
            s = "";
        }
        return stringbuilder.append(s).toString();
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("DataSource{");
        stringbuilder.append(getTypeString());
        if (mName != null)
        {
            stringbuilder.append(":").append(mName);
        }
        if (zzaqk != null)
        {
            stringbuilder.append(":").append(zzaqk);
        }
        if (zzaqj != null)
        {
            stringbuilder.append(":").append(zzaqj);
        }
        if (zzaql != null)
        {
            stringbuilder.append(":").append(zzaql);
        }
        stringbuilder.append(":").append(zzapL);
        return stringbuilder.append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzf.zza(this, parcel, i);
    }

    public Application zzsr()
    {
        return zzaqk;
    }

}
