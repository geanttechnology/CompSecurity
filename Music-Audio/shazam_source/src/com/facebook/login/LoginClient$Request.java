// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.facebook.login:
//            LoginClient, c, a

public static class e
    implements Parcelable
{

    public static final android.os.Request.f CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new LoginClient.Request(parcel, (byte)0);
        }

        public final volatile Object[] newArray(int i)
        {
            return new LoginClient.Request[i];
        }

    };
    public final c a;
    public Set b;
    public final a c;
    final String d;
    public final String e;
    public boolean f;

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        Object obj = null;
        String s;
        if (a != null)
        {
            s = a.name();
        } else
        {
            s = null;
        }
        parcel.writeString(s);
        parcel.writeStringList(new ArrayList(b));
        s = obj;
        if (c != null)
        {
            s = c.name();
        }
        parcel.writeString(s);
        parcel.writeString(d);
        parcel.writeString(e);
        if (f)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
    }


    private _cls1(Parcel parcel)
    {
        Object obj1 = null;
        super();
        f = false;
        Object obj = parcel.readString();
        String s;
        boolean flag;
        if (obj != null)
        {
            obj = com.facebook.login.c.valueOf(((String) (obj)));
        } else
        {
            obj = null;
        }
        a = ((c) (obj));
        obj = new ArrayList();
        parcel.readStringList(((java.util.List) (obj)));
        b = new HashSet(((java.util.Collection) (obj)));
        s = parcel.readString();
        obj = obj1;
        if (s != null)
        {
            obj = com.facebook.login.a.valueOf(s);
        }
        c = ((a) (obj));
        d = parcel.readString();
        e = parcel.readString();
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f = flag;
    }

    f(Parcel parcel, byte byte0)
    {
        this(parcel);
    }

    public <init>(c c1, Set set, a a1, String s, String s1)
    {
        f = false;
        a = c1;
        if (set == null)
        {
            set = new HashSet();
        }
        b = set;
        c = a1;
        d = s;
        e = s1;
    }
}
