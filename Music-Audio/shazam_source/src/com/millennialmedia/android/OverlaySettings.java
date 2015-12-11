// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

// Referenced classes of package com.millennialmedia.android:
//            HttpMMHeaders, al

class OverlaySettings
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new OverlaySettings(parcel);
        }

        public final volatile Object[] newArray(int i1)
        {
            return new OverlaySettings[i1];
        }

    };
    boolean a;
    boolean b;
    long c;
    boolean d;
    int e;
    String f;
    String g;
    String h;
    int i;
    int j;
    boolean k;
    boolean l;
    String m;
    String n;
    HttpMMHeaders o;
    boolean p;
    boolean q;
    long r;

    OverlaySettings()
    {
        f = "";
        g = "";
        h = "";
        l = true;
        m = "";
        n = "";
        p = false;
    }

    OverlaySettings(Parcel parcel)
    {
        long l1;
        l1 = 0L;
        super();
        f = "";
        g = "";
        h = "";
        l = true;
        m = "";
        n = "";
        p = false;
        boolean aflag[] = new boolean[6];
        parcel.readBooleanArray(aflag);
        d = aflag[0];
        b = aflag[1];
        a = aflag[2];
        k = aflag[3];
        q = aflag[4];
        l = aflag[5];
        e = parcel.readInt();
        f = parcel.readString();
        c = parcel.readLong();
        if (c >= 0L)
        {
            try
            {
                l1 = c;
            }
            // Misplaced declaration of an exception variable
            catch (Parcel parcel)
            {
                al.a("OverlaySettings", "Exception Overlaysettings creationg from parcel: ", parcel);
                return;
            }
        }
        c = l1;
        g = parcel.readString();
        r = parcel.readLong();
        h = parcel.readString();
        i = parcel.readInt();
        j = parcel.readInt();
        m = parcel.readString();
        n = parcel.readString();
        o = (HttpMMHeaders)parcel.readParcelable(com/millennialmedia/android/HttpMMHeaders.getClassLoader());
        return;
    }

    final boolean a()
    {
        return !q && r != 0L;
    }

    final boolean b()
    {
        return h != null && !h.equals("");
    }

    final String c()
    {
        if (!TextUtils.isEmpty(f))
        {
            return f;
        }
        if (o != null && !TextUtils.isEmpty(o.c))
        {
            return o.c;
        } else
        {
            return "none";
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public String toString()
    {
        return String.format("height %d width %d modal %b urlToLoad %s creatorAdImplId %s shouldResizeOverlay: %d transitionTime: %d overlayTransition: %s shouldMakeOverlayTransparent: %b shouldShowCustomClose: %b Orientation: %s", new Object[] {
            Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(k), h, Long.valueOf(r), Integer.valueOf(e), Long.valueOf(c), f, Boolean.valueOf(b), Boolean.valueOf(a), 
            g
        });
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        parcel.writeBooleanArray(new boolean[] {
            d, b, a, k, q, l
        });
        parcel.writeInt(e);
        parcel.writeString(f);
        parcel.writeLong(c);
        parcel.writeString(g);
        parcel.writeLong(r);
        parcel.writeString(h);
        parcel.writeInt(i);
        parcel.writeInt(j);
        parcel.writeString(m);
        parcel.writeString(n);
        parcel.writeParcelable(o, i1);
    }

}
