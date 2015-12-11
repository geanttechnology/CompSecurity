// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.smule.android.network.models:
//            ResourceV2

public class SoundfontV2
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public SoundfontV2 a(Parcel parcel)
        {
            return new SoundfontV2(parcel);
        }

        public SoundfontV2[] a(int i)
        {
            return new SoundfontV2[i];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int i)
        {
            return a(i);
        }

    };
    public boolean enabled;
    public String info;
    public String name;
    public List resources;
    public String soundfontId;
    public long ts;

    public SoundfontV2()
    {
        resources = new ArrayList();
    }

    public SoundfontV2(Parcel parcel)
    {
        boolean flag = true;
        super();
        resources = new ArrayList();
        soundfontId = parcel.readString();
        ts = parcel.readLong();
        name = parcel.readString();
        info = parcel.readString();
        if (parcel.readByte() != 1)
        {
            flag = false;
        }
        enabled = flag;
        parcel.readTypedList(resources, ResourceV2.CREATOR);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        String s;
        if (soundfontId == null)
        {
            s = "";
        } else
        {
            s = soundfontId;
        }
        parcel.writeString(s);
        parcel.writeLong(ts);
        if (name == null)
        {
            s = "";
        } else
        {
            s = name;
        }
        parcel.writeString(s);
        if (info == null)
        {
            s = "";
        } else
        {
            s = info;
        }
        parcel.writeString(s);
        if (enabled)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        parcel.writeTypedList(resources);
    }

}
