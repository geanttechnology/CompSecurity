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
        private int zzUS;
        private Device zzanJ;
        private Application zzanK;
        private String zzanL;
        private DataType zzanl;

        static DataType zza(Builder builder)
        {
            return builder.zzanl;
        }

        static int zzb(Builder builder)
        {
            return builder.zzUS;
        }

        static String zzc(Builder builder)
        {
            return builder.mName;
        }

        static Device zzd(Builder builder)
        {
            return builder.zzanJ;
        }

        static Application zze(Builder builder)
        {
            return builder.zzanK;
        }

        static String zzf(Builder builder)
        {
            return builder.zzanL;
        }

        public DataSource build()
        {
            boolean flag1 = true;
            boolean flag;
            if (zzanl != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zza(flag, "Must set data type");
            if (zzUS >= 0)
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
            zzanK = Application.zzcQ(s);
            return this;
        }

        public Builder setDataType(DataType datatype)
        {
            zzanl = datatype;
            return this;
        }

        public Builder setDevice(Device device)
        {
            zzanJ = device;
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
            zzanL = s;
            return this;
        }

        public Builder setType(int i)
        {
            zzUS = i;
            return this;
        }

        public Builder()
        {
            zzUS = -1;
            zzanL = "";
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new zzf();
    public static final String EXTRA_DATA_SOURCE = "vnd.google.fitness.data_source";
    public static final int TYPE_DERIVED = 1;
    public static final int TYPE_RAW = 0;
    private final String mName;
    private final int mVersionCode;
    private final int zzUS;
    private final Device zzanJ;
    private final Application zzanK;
    private final String zzanL;
    private final String zzanM;
    private final DataType zzanl;

    DataSource(int i, DataType datatype, String s, int j, Device device, Application application, String s1)
    {
        mVersionCode = i;
        zzanl = datatype;
        zzUS = j;
        mName = s;
        zzanJ = device;
        zzanK = application;
        zzanL = s1;
        zzanM = zzrG();
    }

    private DataSource(Builder builder)
    {
        mVersionCode = 3;
        zzanl = Builder.zza(builder);
        zzUS = Builder.zzb(builder);
        mName = com.google.android.gms.fitness.data.Builder.zzc(builder);
        zzanJ = Builder.zzd(builder);
        zzanK = Builder.zze(builder);
        zzanL = Builder.zzf(builder);
        zzanM = zzrG();
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
        switch (zzUS)
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
        return zzanM.equals(datasource.zzanM);
    }

    private String zzrG()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(getTypeString());
        stringbuilder.append(":").append(zzanl.getName());
        if (zzanK != null)
        {
            stringbuilder.append(":").append(zzanK.getPackageName());
        }
        if (zzanJ != null)
        {
            stringbuilder.append(":").append(zzanJ.getStreamIdentifier());
        }
        if (zzanL != null)
        {
            stringbuilder.append(":").append(zzanL);
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
        if (zzanK == null)
        {
            return null;
        } else
        {
            return zzanK.getPackageName();
        }
    }

    public DataType getDataType()
    {
        return zzanl;
    }

    public Device getDevice()
    {
        return zzanJ;
    }

    public String getName()
    {
        return mName;
    }

    public String getStreamIdentifier()
    {
        return zzanM;
    }

    public String getStreamName()
    {
        return zzanL;
    }

    public int getType()
    {
        return zzUS;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzanM.hashCode();
    }

    public String toDebugString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        String s;
        if (zzUS == 0)
        {
            s = "r";
        } else
        {
            s = "d";
        }
        stringbuilder = stringbuilder.append(s).append(":").append(zzanl.zzrH());
        if (zzanK == null)
        {
            s = "";
        } else
        if (zzanK.equals(Application.zzans))
        {
            s = ":gms";
        } else
        {
            s = (new StringBuilder()).append(":").append(zzanK.getPackageName()).toString();
        }
        stringbuilder = stringbuilder.append(s);
        if (zzanJ != null)
        {
            s = (new StringBuilder()).append(":").append(zzanJ.getModel()).append(":").append(zzanJ.getUid()).toString();
        } else
        {
            s = "";
        }
        stringbuilder = stringbuilder.append(s);
        if (zzanL != null)
        {
            s = (new StringBuilder()).append(":").append(zzanL).toString();
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
        if (zzanK != null)
        {
            stringbuilder.append(":").append(zzanK);
        }
        if (zzanJ != null)
        {
            stringbuilder.append(":").append(zzanJ);
        }
        if (zzanL != null)
        {
            stringbuilder.append(":").append(zzanL);
        }
        stringbuilder.append(":").append(zzanl);
        return stringbuilder.append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzf.zza(this, parcel, i);
    }

    public Application zzrF()
    {
        return zzanK;
    }

}
