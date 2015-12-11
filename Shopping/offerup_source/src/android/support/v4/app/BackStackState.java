// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

// Referenced classes of package android.support.v4.app:
//            m, g, k, Fragment, 
//            ab

final class BackStackState
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new m();
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

    public BackStackState(Parcel parcel)
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

    public BackStackState(g g1)
    {
        k k1 = g1.a;
        int l;
        int i1;
        for (l = 0; k1 != null; l = i1)
        {
            i1 = l;
            if (k1.i != null)
            {
                i1 = l + k1.i.size();
            }
            k1 = k1.a;
        }

        a = new int[l + g1.b * 7];
        if (!g1.e)
        {
            throw new IllegalStateException("Not on back stack");
        }
        k1 = g1.a;
        l = 0;
        while (k1 != null) 
        {
            int ai[] = a;
            int j1 = l + 1;
            ai[l] = k1.c;
            ai = a;
            int l1 = j1 + 1;
            if (k1.d != null)
            {
                l = k1.d.mIndex;
            } else
            {
                l = -1;
            }
            ai[j1] = l;
            ai = a;
            l = l1 + 1;
            ai[l1] = k1.e;
            ai = a;
            j1 = l + 1;
            ai[l] = k1.f;
            ai = a;
            l = j1 + 1;
            ai[j1] = k1.g;
            ai = a;
            j1 = l + 1;
            ai[l] = k1.h;
            if (k1.i != null)
            {
                int i2 = k1.i.size();
                int ai1[] = a;
                l = j1 + 1;
                ai1[j1] = i2;
                for (j1 = 0; j1 < i2;)
                {
                    a[l] = ((Fragment)k1.i.get(j1)).mIndex;
                    j1++;
                    l++;
                }

            } else
            {
                int ai2[] = a;
                l = j1 + 1;
                ai2[j1] = 0;
            }
            k1 = k1.a;
        }
        b = g1.c;
        c = g1.d;
        d = g1.f;
        e = g1.g;
        f = g1.h;
        g = g1.i;
        h = g1.j;
        i = g1.k;
        j = g1.l;
        k = g1.m;
    }

    public final g a(ab ab1)
    {
        g g1 = new g(ab1);
        k k1;
label0:
        for (int i1 = 0; i1 < a.length; g1.a(k1))
        {
            k1 = new k();
            int ai[] = a;
            int j1 = i1 + 1;
            k1.c = ai[i1];
            boolean flag = ab.a;
            ai = a;
            int l = j1 + 1;
            i1 = ai[j1];
            int l1;
            if (i1 >= 0)
            {
                k1.d = (Fragment)ab1.b.get(i1);
            } else
            {
                k1.d = null;
            }
            ai = a;
            i1 = l + 1;
            k1.e = ai[l];
            ai = a;
            l = i1 + 1;
            k1.f = ai[i1];
            ai = a;
            i1 = l + 1;
            k1.g = ai[l];
            ai = a;
            j1 = i1 + 1;
            k1.h = ai[i1];
            ai = a;
            l = j1 + 1;
            l1 = ai[j1];
            i1 = l;
            if (l1 <= 0)
            {
                continue;
            }
            k1.i = new ArrayList(l1);
            j1 = 0;
            do
            {
                i1 = l;
                if (j1 >= l1)
                {
                    continue label0;
                }
                boolean flag1 = ab.a;
                Fragment fragment = (Fragment)ab1.b.get(a[l]);
                k1.i.add(fragment);
                j1++;
                l++;
            } while (true);
        }

        g1.c = b;
        g1.d = c;
        g1.f = d;
        g1.g = e;
        g1.e = true;
        g1.h = f;
        g1.i = g;
        g1.j = h;
        g1.k = i;
        g1.l = j;
        g1.m = k;
        g1.a(1);
        return g1;
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
