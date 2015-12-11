// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

// Referenced classes of package android.support.v4.app:
//            f, Fragment, l

final class BackStackState
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new BackStackState(parcel);
        }

        public final volatile Object[] newArray(int i1)
        {
            return new BackStackState[i1];
        }

    };
    final int a[];
    final int b;
    final int c;
    final String d;
    final int e;
    final int f;
    final CharSequence g;
    final int h;
    final CharSequence i;
    final ArrayList j;
    final ArrayList k;

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

    public BackStackState(f f1)
    {
        f.a a1 = f1.c;
        int i1;
        int j1;
        for (i1 = 0; a1 != null; i1 = j1)
        {
            j1 = i1;
            if (a1.i != null)
            {
                j1 = i1 + a1.i.size();
            }
            a1 = a1.a;
        }

        a = new int[i1 + f1.e * 7];
        if (!f1.l)
        {
            throw new IllegalStateException("Not on back stack");
        }
        a1 = f1.c;
        i1 = 0;
        while (a1 != null) 
        {
            int ai[] = a;
            int k1 = i1 + 1;
            ai[i1] = a1.c;
            ai = a;
            int l1 = k1 + 1;
            if (a1.d != null)
            {
                i1 = a1.d.p;
            } else
            {
                i1 = -1;
            }
            ai[k1] = i1;
            ai = a;
            i1 = l1 + 1;
            ai[l1] = a1.e;
            ai = a;
            k1 = i1 + 1;
            ai[i1] = a1.f;
            ai = a;
            i1 = k1 + 1;
            ai[k1] = a1.g;
            ai = a;
            k1 = i1 + 1;
            ai[i1] = a1.h;
            if (a1.i != null)
            {
                int i2 = a1.i.size();
                int ai1[] = a;
                i1 = k1 + 1;
                ai1[k1] = i2;
                for (k1 = 0; k1 < i2;)
                {
                    a[i1] = ((Fragment)a1.i.get(k1)).p;
                    k1++;
                    i1++;
                }

            } else
            {
                int ai2[] = a;
                i1 = k1 + 1;
                ai2[k1] = 0;
            }
            a1 = a1.a;
        }
        b = f1.j;
        c = f1.k;
        d = f1.n;
        e = f1.p;
        f = f1.q;
        g = f1.r;
        h = f1.s;
        i = f1.t;
        j = f1.u;
        k = f1.v;
    }

    public final f a(l l1)
    {
        f f1 = new f(l1);
        int k1 = 0;
        for (int i1 = 0; i1 < a.length;)
        {
            f.a a1 = new f.a();
            int ai[] = a;
            int j1 = i1 + 1;
            a1.c = ai[i1];
            if (l.a)
            {
                (new StringBuilder("Instantiate ")).append(f1).append(" op #").append(k1).append(" base fragment #").append(a[j1]);
            }
            ai = a;
            i1 = j1 + 1;
            j1 = ai[j1];
            int j2;
            if (j1 >= 0)
            {
                a1.d = (Fragment)l1.f.get(j1);
            } else
            {
                a1.d = null;
            }
            ai = a;
            j1 = i1 + 1;
            a1.e = ai[i1];
            ai = a;
            i1 = j1 + 1;
            a1.f = ai[j1];
            ai = a;
            j1 = i1 + 1;
            a1.g = ai[i1];
            ai = a;
            i1 = j1 + 1;
            a1.h = ai[j1];
            ai = a;
            j1 = i1 + 1;
            j2 = ai[i1];
            i1 = j1;
            if (j2 > 0)
            {
                a1.i = new ArrayList(j2);
                int i2 = 0;
                do
                {
                    i1 = j1;
                    if (i2 >= j2)
                    {
                        break;
                    }
                    if (l.a)
                    {
                        (new StringBuilder("Instantiate ")).append(f1).append(" set remove fragment #").append(a[j1]);
                    }
                    Fragment fragment = (Fragment)l1.f.get(a[j1]);
                    a1.i.add(fragment);
                    i2++;
                    j1++;
                } while (true);
            }
            f1.a(a1);
            k1++;
        }

        f1.j = b;
        f1.k = c;
        f1.n = d;
        f1.p = e;
        f1.l = true;
        f1.q = f;
        f1.r = g;
        f1.s = h;
        f1.t = i;
        f1.u = j;
        f1.v = k;
        f1.a(1);
        return f1;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i1)
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
