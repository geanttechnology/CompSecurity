// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

final class g
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new h();
    private int a[];
    private int b;
    private int c;
    private String d;
    private int e;
    private int f;
    private CharSequence g;
    private int h;
    private CharSequence i;
    private ArrayList j;
    private ArrayList k;

    public g(Parcel parcel)
    {
        a = parcel.createIntArray();
        b = parcel.readInt();
        c = parcel.readInt();
        d = parcel.readString();
        e = parcel.readInt();
        f = parcel.readInt();
        g = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        h = parcel.readInt();
        i = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        j = parcel.createStringArrayList();
        k = parcel.createStringArrayList();
    }

    public g(c c1)
    {
        b b1 = c1.a;
        int l;
        int i1;
        for (l = 0; b1 != null; l = i1)
        {
            i1 = l;
            if (b1.i != null)
            {
                i1 = l + b1.i.size();
            }
            b1 = b1.a;
        }

        a = new int[l + c1.b * 7];
        if (!c1.e)
        {
            throw new IllegalStateException("Not on back stack");
        }
        b1 = c1.a;
        l = 0;
        while (b1 != null) 
        {
            int ai[] = a;
            int j1 = l + 1;
            ai[l] = b1.c;
            ai = a;
            int k1 = j1 + 1;
            if (b1.d != null)
            {
                l = b1.d.i;
            } else
            {
                l = -1;
            }
            ai[j1] = l;
            ai = a;
            l = k1 + 1;
            ai[k1] = b1.e;
            ai = a;
            j1 = l + 1;
            ai[l] = b1.f;
            ai = a;
            l = j1 + 1;
            ai[j1] = b1.g;
            ai = a;
            j1 = l + 1;
            ai[l] = b1.h;
            if (b1.i != null)
            {
                int l1 = b1.i.size();
                int ai1[] = a;
                l = j1 + 1;
                ai1[j1] = l1;
                for (j1 = 0; j1 < l1;)
                {
                    a[l] = ((j)b1.i.get(j1)).i;
                    j1++;
                    l++;
                }

            } else
            {
                int ai2[] = a;
                l = j1 + 1;
                ai2[j1] = 0;
            }
            b1 = b1.a;
        }
        b = c1.c;
        c = c1.d;
        d = c1.f;
        e = c1.g;
        f = c1.h;
        g = c1.i;
        h = c1.j;
        i = c1.k;
        j = c1.l;
        k = c1.m;
    }

    public final c a(t t1)
    {
        c c1 = new c(t1);
        b b1;
label0:
        for (int i1 = 0; i1 < a.length; c1.a(b1))
        {
            b1 = new b();
            int ai[] = a;
            int k1 = i1 + 1;
            b1.c = ai[i1];
            ai = a;
            int l = k1 + 1;
            i1 = ai[k1];
            int l1;
            if (i1 >= 0)
            {
                b1.d = (j)t1.b.get(i1);
            } else
            {
                b1.d = null;
            }
            ai = a;
            i1 = l + 1;
            b1.e = ai[l];
            ai = a;
            l = i1 + 1;
            b1.f = ai[i1];
            ai = a;
            i1 = l + 1;
            b1.g = ai[l];
            ai = a;
            k1 = i1 + 1;
            b1.h = ai[i1];
            ai = a;
            l = k1 + 1;
            l1 = ai[k1];
            i1 = l;
            if (l1 <= 0)
            {
                continue;
            }
            b1.i = new ArrayList(l1);
            k1 = 0;
            do
            {
                i1 = l;
                if (k1 >= l1)
                {
                    continue label0;
                }
                j j1 = (j)t1.b.get(a[l]);
                b1.i.add(j1);
                k1++;
                l++;
            } while (true);
        }

        c1.c = b;
        c1.d = c;
        c1.f = d;
        c1.g = e;
        c1.e = true;
        c1.h = f;
        c1.i = g;
        c1.j = h;
        c1.k = i;
        c1.l = j;
        c1.m = k;
        c1.a(1);
        return c1;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int l)
    {
        parcel.writeIntArray(a);
        parcel.writeInt(b);
        parcel.writeInt(c);
        parcel.writeString(d);
        parcel.writeInt(e);
        parcel.writeInt(f);
        TextUtils.writeToParcel(g, parcel, 0);
        parcel.writeInt(h);
        TextUtils.writeToParcel(i, parcel, 0);
        parcel.writeStringList(j);
        parcel.writeStringList(k);
    }

}
