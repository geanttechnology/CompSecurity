// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

// Referenced classes of package android.support.v4.app:
//            e, Fragment, j

final class BackStackState
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public BackStackState a(Parcel parcel)
        {
            return new BackStackState(parcel);
        }

        public BackStackState[] a(int l)
        {
            return new BackStackState[l];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int l)
        {
            return a(l);
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

    public BackStackState(j j1, e e1)
    {
        j1 = e1.c;
        int l;
        int i1;
        for (l = 0; j1 != null; l = i1)
        {
            i1 = l;
            if (((e.a) (j1)).i != null)
            {
                i1 = l + ((e.a) (j1)).i.size();
            }
            j1 = ((e.a) (j1)).a;
        }

        a = new int[l + e1.e * 7];
        if (!e1.l)
        {
            throw new IllegalStateException("Not on back stack");
        }
        j1 = e1.c;
        l = 0;
        while (j1 != null) 
        {
            int ai[] = a;
            int k1 = l + 1;
            ai[l] = ((e.a) (j1)).c;
            ai = a;
            int l1 = k1 + 1;
            if (((e.a) (j1)).d != null)
            {
                l = ((e.a) (j1)).d.p;
            } else
            {
                l = -1;
            }
            ai[k1] = l;
            ai = a;
            l = l1 + 1;
            ai[l1] = ((e.a) (j1)).e;
            ai = a;
            k1 = l + 1;
            ai[l] = ((e.a) (j1)).f;
            ai = a;
            l = k1 + 1;
            ai[k1] = ((e.a) (j1)).g;
            ai = a;
            k1 = l + 1;
            ai[l] = ((e.a) (j1)).h;
            if (((e.a) (j1)).i != null)
            {
                int i2 = ((e.a) (j1)).i.size();
                int ai1[] = a;
                l = k1 + 1;
                ai1[k1] = i2;
                for (k1 = 0; k1 < i2;)
                {
                    a[l] = ((Fragment)((e.a) (j1)).i.get(k1)).p;
                    k1++;
                    l++;
                }

            } else
            {
                int ai2[] = a;
                l = k1 + 1;
                ai2[k1] = 0;
            }
            j1 = ((e.a) (j1)).a;
        }
        b = e1.j;
        c = e1.k;
        d = e1.n;
        e = e1.p;
        f = e1.q;
        g = e1.r;
        h = e1.s;
        i = e1.t;
        j = e1.u;
        k = e1.v;
    }

    public e a(j j1)
    {
        e e1 = new e(j1);
        int k1 = 0;
        for (int l = 0; l < a.length;)
        {
            e.a a1 = new e.a();
            int ai[] = a;
            int i1 = l + 1;
            a1.c = ai[l];
            if (j.a)
            {
                Log.v("FragmentManager", (new StringBuilder()).append("Instantiate ").append(e1).append(" op #").append(k1).append(" base fragment #").append(a[i1]).toString());
            }
            ai = a;
            l = i1 + 1;
            i1 = ai[i1];
            int i2;
            if (i1 >= 0)
            {
                a1.d = (Fragment)j1.f.get(i1);
            } else
            {
                a1.d = null;
            }
            ai = a;
            i1 = l + 1;
            a1.e = ai[l];
            ai = a;
            l = i1 + 1;
            a1.f = ai[i1];
            ai = a;
            i1 = l + 1;
            a1.g = ai[l];
            ai = a;
            l = i1 + 1;
            a1.h = ai[i1];
            ai = a;
            i1 = l + 1;
            i2 = ai[l];
            l = i1;
            if (i2 > 0)
            {
                a1.i = new ArrayList(i2);
                int l1 = 0;
                do
                {
                    l = i1;
                    if (l1 >= i2)
                    {
                        break;
                    }
                    if (j.a)
                    {
                        Log.v("FragmentManager", (new StringBuilder()).append("Instantiate ").append(e1).append(" set remove fragment #").append(a[i1]).toString());
                    }
                    Fragment fragment = (Fragment)j1.f.get(a[i1]);
                    a1.i.add(fragment);
                    l1++;
                    i1++;
                } while (true);
            }
            e1.a(a1);
            k1++;
        }

        e1.j = b;
        e1.k = c;
        e1.n = d;
        e1.p = e;
        e1.l = true;
        e1.q = f;
        e1.r = g;
        e1.s = h;
        e1.t = i;
        e1.u = j;
        e1.v = k;
        e1.a(1);
        return e1;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int l)
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
