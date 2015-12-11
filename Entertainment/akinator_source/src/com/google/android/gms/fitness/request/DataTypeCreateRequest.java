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
import com.google.android.gms.internal.zznw;
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
        private List zzaqw;

        static String zza(Builder builder)
        {
            return builder.mName;
        }

        static List zzb(Builder builder)
        {
            return builder.zzaqw;
        }

        public Builder addField(Field field)
        {
            if (!zzaqw.contains(field))
            {
                zzaqw.add(field);
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
            if (!zzaqw.isEmpty())
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
            zzaqw = new ArrayList();
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new zzi();
    private final String mName;
    private final int mVersionCode;
    private final List zzaqw;
    private final zznw zzasy;

    DataTypeCreateRequest(int i, String s, List list, IBinder ibinder)
    {
        mVersionCode = i;
        mName = s;
        zzaqw = Collections.unmodifiableList(list);
        zzasy = com.google.android.gms.internal.zznw.zza.zzbw(ibinder);
    }

    private DataTypeCreateRequest(Builder builder)
    {
        this(Builder.zza(builder), Builder.zzb(builder), null);
    }


    public DataTypeCreateRequest(DataTypeCreateRequest datatypecreaterequest, zznw zznw1)
    {
        this(datatypecreaterequest.mName, datatypecreaterequest.zzaqw, zznw1);
    }

    public DataTypeCreateRequest(String s, List list, zznw zznw1)
    {
        mVersionCode = 3;
        mName = s;
        zzaqw = Collections.unmodifiableList(list);
        zzasy = zznw1;
    }

    private boolean zzb(DataTypeCreateRequest datatypecreaterequest)
    {
        return zzw.equal(mName, datatypecreaterequest.mName) && zzw.equal(zzaqw, datatypecreaterequest.zzaqw);
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
        return zzaqw;
    }

    public String getName()
    {
        return mName;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            mName, zzaqw
        });
    }

    public String toString()
    {
        return zzw.zzv(this).zzg("name", mName).zzg("fields", zzaqw).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzi.zza(this, parcel, i);
    }

    public IBinder zzsO()
    {
        if (zzasy == null)
        {
            return null;
        } else
        {
            return zzasy.asBinder();
        }
    }

}
