// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.template;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

// Referenced classes of package com.socialin.android.photo.template:
//            TemplateImage

public class Template
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new Template(parcel);
        }

        public final volatile Object[] newArray(int i1)
        {
            return new Template[i1];
        }

    };
    int e;
    public ArrayList f;
    public String g;
    public String h;
    public String i;
    String j;
    double k;
    double l;
    int m;
    int n;
    public boolean o;
    public String p;

    public Template()
    {
        e = 1;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = 0.0D;
        l = 0.0D;
        m = 0;
        n = 0;
        o = false;
        p = null;
    }

    public Template(Parcel parcel)
    {
        boolean flag = true;
        super();
        e = 1;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = 0.0D;
        l = 0.0D;
        m = 0;
        n = 0;
        o = false;
        p = null;
        f = new ArrayList();
        parcel.readTypedList(f, TemplateImage.CREATOR);
        h = parcel.readString();
        i = parcel.readString();
        k = parcel.readDouble();
        l = parcel.readDouble();
        m = parcel.readInt();
        n = parcel.readInt();
        g = parcel.readString();
        if (parcel.readInt() != 1)
        {
            flag = false;
        }
        o = flag;
        e = parcel.readInt();
        p = parcel.readString();
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        parcel.writeTypedList(f);
        parcel.writeString(h);
        parcel.writeString(i);
        parcel.writeDouble(k);
        parcel.writeDouble(l);
        parcel.writeInt(m);
        parcel.writeInt(n);
        parcel.writeString(g);
        if (o)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        parcel.writeInt(i1);
        parcel.writeInt(e);
        parcel.writeString(p);
    }

}
