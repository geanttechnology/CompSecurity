// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.facebook.share.model:
//            ShareModel

public abstract class ShareContent
    implements ShareModel
{
    public static abstract class a
    {

        private Uri a;
        private List b;
        private String c;
        private String d;

        static Uri a(a a1)
        {
            return a1.a;
        }

        static List b(a a1)
        {
            return a1.b;
        }

        static String c(a a1)
        {
            return a1.c;
        }

        static String d(a a1)
        {
            return a1.d;
        }

        public a a(Uri uri)
        {
            a = uri;
            return this;
        }

        public a()
        {
        }
    }


    private final Uri a;
    private final List b;
    private final String c;
    private final String d;

    protected ShareContent(Parcel parcel)
    {
        a = (Uri)parcel.readParcelable(android/net/Uri.getClassLoader());
        b = a(parcel);
        c = parcel.readString();
        d = parcel.readString();
    }

    protected ShareContent(a a1)
    {
        a = a.a(a1);
        b = a.b(a1);
        c = a.c(a1);
        d = a.d(a1);
    }

    private List a(Parcel parcel)
    {
        ArrayList arraylist = new ArrayList();
        parcel.readStringList(arraylist);
        if (arraylist.size() == 0)
        {
            return null;
        } else
        {
            return Collections.unmodifiableList(arraylist);
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public Uri h()
    {
        return a;
    }

    public List i()
    {
        return b;
    }

    public String j()
    {
        return c;
    }

    public String k()
    {
        return d;
    }

    public void writeToParcel(Parcel parcel, int l)
    {
        parcel.writeParcelable(a, 0);
        parcel.writeStringList(b);
        parcel.writeString(c);
        parcel.writeString(d);
    }
}
