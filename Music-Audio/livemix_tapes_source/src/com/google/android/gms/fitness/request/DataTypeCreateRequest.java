// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.internal.zzmu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzi

public class DataTypeCreateRequest
    implements SafeParcelable
{
    public static class Builder
    {

        private String mName;
        private List zzanX;

        static String zza(Builder builder)
        {
            return builder.mName;
        }

        static List zzb(Builder builder)
        {
            return builder.zzanX;
        }

        public Builder addField(Field field)
        {
            if (!zzanX.contains(field))
            {
                zzanX.add(field);
            }
            return this;
        }

        public Builder addField(String s, int i)
        {
            boolean flag;
            if (s != null && !s.isEmpty())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "Invalid name specified");
            return addField(Field.zzo(s, i));
        }

        public DataTypeCreateRequest build()
        {
            boolean flag1 = true;
            boolean flag;
            if (mName != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zza(flag, "Must set the name");
            if (!zzanX.isEmpty())
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            zzx.zza(flag, "Must specify the data fields");
            return new DataTypeCreateRequest(this);
        }

        public Builder setName(String s)
        {
            mName = s;
            return this;
        }

        public Builder()
        {
            zzanX = new ArrayList();
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new zzi();
    private final String mName;
    private final int mVersionCode;
    private final String zzOZ;
    private final List zzanX;
    private final zzmu zzaqb;

    DataTypeCreateRequest(int i, String s, List list, IBinder ibinder, String s1)
    {
        mVersionCode = i;
        mName = s;
        zzanX = Collections.unmodifiableList(list);
        if (ibinder == null)
        {
            s = null;
        } else
        {
            s = com.google.android.gms.internal.zzmu.zza.zzbw(ibinder);
        }
        zzaqb = s;
        zzOZ = s1;
    }

    private DataTypeCreateRequest(Builder builder)
    {
        this(Builder.zza(builder), Builder.zzb(builder), null, null);
    }


    public DataTypeCreateRequest(DataTypeCreateRequest datatypecreaterequest, zzmu zzmu1, String s)
    {
        this(datatypecreaterequest.mName, datatypecreaterequest.zzanX, zzmu1, s);
    }

    public DataTypeCreateRequest(String s, List list, zzmu zzmu1, String s1)
    {
        mVersionCode = 2;
        mName = s;
        zzanX = Collections.unmodifiableList(list);
        zzaqb = zzmu1;
        zzOZ = s1;
    }

    private boolean zzb(DataTypeCreateRequest datatypecreaterequest)
    {
        return zzw.equal(mName, datatypecreaterequest.mName) && zzw.equal(zzanX, datatypecreaterequest.zzanX);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return obj == this || (obj instanceof DataTypeCreateRequest) && zzb((DataTypeCreateRequest)obj);
    }

    public List getFields()
    {
        return zzanX;
    }

    public String getName()
    {
        return mName;
    }

    public String getPackageName()
    {
        return zzOZ;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            mName, zzanX
        });
    }

    public String toString()
    {
        return zzw.zzu(this).zzg("name", mName).zzg("fields", zzanX).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzi.zza(this, parcel, i);
    }

    public IBinder zzsc()
    {
        if (zzaqb == null)
        {
            return null;
        } else
        {
            return zzaqb.asBinder();
        }
    }

}
