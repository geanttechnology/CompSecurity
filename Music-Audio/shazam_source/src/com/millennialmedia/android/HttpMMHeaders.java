// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import org.apache.http.Header;

// Referenced classes of package com.millennialmedia.android:
//            al

class HttpMMHeaders
    implements Parcelable, Serializable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new HttpMMHeaders(parcel);
        }

        public final volatile Object[] newArray(int i)
        {
            return new HttpMMHeaders[i];
        }

    };
    private static final String g = com/millennialmedia/android/HttpMMHeaders.getName();
    boolean a;
    long b;
    String c;
    boolean d;
    boolean e;
    String f;

    public HttpMMHeaders(Parcel parcel)
    {
        try
        {
            boolean aflag[] = new boolean[3];
            parcel.readBooleanArray(aflag);
            a = aflag[0];
            d = aflag[1];
            e = aflag[2];
            c = parcel.readString();
            f = parcel.readString();
            b = parcel.readLong();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Parcel parcel)
        {
            al.a(g, "Header serializing failed", parcel);
        }
    }

    public HttpMMHeaders(Header aheader[])
    {
        int j = aheader.length;
        for (int i = 0; i < j; i++)
        {
            Header header = aheader[i];
            if ("X-MM-TRANSPARENT".equalsIgnoreCase(header.getName()))
            {
                String s = header.getValue();
                if (s != null)
                {
                    a = Boolean.parseBoolean(s);
                }
            }
            if ("X-MM-TRANSITION".equalsIgnoreCase(header.getName()))
            {
                c = header.getValue();
            }
            if ("X-MM-TRANSITION-DURATION".equalsIgnoreCase(header.getName()))
            {
                String s1 = header.getValue();
                if (s1 != null)
                {
                    b = (long)(Float.parseFloat(s1) * 1000F);
                }
            }
            if ("X-MM-USE-CUSTOM-CLOSE".equalsIgnoreCase(header.getName()))
            {
                d = Boolean.parseBoolean(header.getValue());
            }
            if ("X-MM-ENABLE-HARDWARE-ACCELERATION".equalsIgnoreCase(header.getName()))
            {
                e = Boolean.parseBoolean(header.getValue());
            }
            if ("X-MM-ACID".equalsIgnoreCase(header.getName()))
            {
                f = header.getValue();
            }
        }

    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeBooleanArray(new boolean[] {
            a, d, e
        });
        parcel.writeString(c);
        parcel.writeString(f);
        parcel.writeLong(b);
    }

}
