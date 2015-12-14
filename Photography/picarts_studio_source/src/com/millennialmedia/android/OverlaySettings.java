// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

// Referenced classes of package com.millennialmedia.android:
//            HttpMMHeaders, MMLog

class OverlaySettings
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final OverlaySettings createFromParcel(Parcel parcel)
        {
            return new OverlaySettings(parcel);
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final OverlaySettings[] newArray(int i1)
        {
            return new OverlaySettings[i1];
        }

        public final volatile Object[] newArray(int i1)
        {
            return newArray(i1);
        }

    };
    boolean a;
    boolean b;
    long c;
    int d;
    String e;
    String f;
    String g;
    int h;
    int i;
    boolean j;
    boolean k;
    String l;
    String m;
    HttpMMHeaders n;
    boolean o;
    boolean p;
    long q;
    private boolean r;

    OverlaySettings()
    {
        e = "";
        f = "";
        g = "";
        k = true;
        l = "";
        m = "";
        o = false;
    }

    OverlaySettings(Parcel parcel)
    {
        long l1;
        l1 = 0L;
        super();
        e = "";
        f = "";
        g = "";
        k = true;
        l = "";
        m = "";
        o = false;
        boolean aflag[] = new boolean[6];
        parcel.readBooleanArray(aflag);
        r = aflag[0];
        b = aflag[1];
        a = aflag[2];
        j = aflag[3];
        p = aflag[4];
        k = aflag[5];
        d = parcel.readInt();
        e = parcel.readString();
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
                MMLog.a("OverlaySettings", "Exception Overlaysettings creationg from parcel: ", parcel);
                return;
            }
        }
        c = l1;
        f = parcel.readString();
        q = parcel.readLong();
        g = parcel.readString();
        h = parcel.readInt();
        i = parcel.readInt();
        l = parcel.readString();
        m = parcel.readString();
        n = (HttpMMHeaders)parcel.readParcelable(com/millennialmedia/android/HttpMMHeaders.getClassLoader());
        return;
    }

    final boolean a()
    {
        return !p && q != 0L;
    }

    final boolean b()
    {
        return g != null && !g.equals("");
    }

    final String c()
    {
        if (!TextUtils.isEmpty(e))
        {
            return e;
        }
        if (n != null && !TextUtils.isEmpty(n.transition))
        {
            return n.transition;
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
            Integer.valueOf(h), Integer.valueOf(i), Boolean.valueOf(j), g, Long.valueOf(q), Integer.valueOf(d), Long.valueOf(c), e, Boolean.valueOf(b), Boolean.valueOf(a), 
            f
        });
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        parcel.writeBooleanArray(new boolean[] {
            r, b, a, j, p, k
        });
        parcel.writeInt(d);
        parcel.writeString(e);
        parcel.writeLong(c);
        parcel.writeString(f);
        parcel.writeLong(q);
        parcel.writeString(g);
        parcel.writeInt(h);
        parcel.writeInt(i);
        parcel.writeString(l);
        parcel.writeString(m);
        parcel.writeParcelable(n, i1);
    }

}
