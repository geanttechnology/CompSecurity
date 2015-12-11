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
//            x, r, v, Fragment, 
//            ai

final class BackStackState
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new x();
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

    public BackStackState(r r1)
    {
        v v1 = r1.b;
        int l;
        int i1;
        for (l = 0; v1 != null; l = i1)
        {
            i1 = l;
            if (v1.i != null)
            {
                i1 = l + v1.i.size();
            }
            v1 = v1.a;
        }

        a = new int[l + r1.d * 7];
        if (!r1.k)
        {
            throw new IllegalStateException("Not on back stack");
        }
        v1 = r1.b;
        l = 0;
        while (v1 != null) 
        {
            int ai1[] = a;
            int j1 = l + 1;
            ai1[l] = v1.c;
            ai1 = a;
            int k1 = j1 + 1;
            if (v1.d != null)
            {
                l = v1.d.mIndex;
            } else
            {
                l = -1;
            }
            ai1[j1] = l;
            ai1 = a;
            l = k1 + 1;
            ai1[k1] = v1.e;
            ai1 = a;
            j1 = l + 1;
            ai1[l] = v1.f;
            ai1 = a;
            l = j1 + 1;
            ai1[j1] = v1.g;
            ai1 = a;
            j1 = l + 1;
            ai1[l] = v1.h;
            if (v1.i != null)
            {
                int l1 = v1.i.size();
                int ai2[] = a;
                l = j1 + 1;
                ai2[j1] = l1;
                for (j1 = 0; j1 < l1;)
                {
                    a[l] = ((Fragment)v1.i.get(j1)).mIndex;
                    j1++;
                    l++;
                }

            } else
            {
                int ai3[] = a;
                l = j1 + 1;
                ai3[j1] = 0;
            }
            v1 = v1.a;
        }
        b = r1.i;
        c = r1.j;
        d = r1.m;
        e = r1.o;
        f = r1.p;
        g = r1.q;
        h = r1.r;
        i = r1.s;
        j = r1.t;
        k = r1.u;
    }

    public final r a(ai ai1)
    {
        r r1 = new r(ai1);
        int j1 = 0;
        for (int l = 0; l < a.length;)
        {
            v v1 = new v();
            int ai2[] = a;
            int i1 = l + 1;
            v1.c = ai2[l];
            if (ai.a)
            {
                Log.v("FragmentManager", (new StringBuilder("Instantiate ")).append(r1).append(" op #").append(j1).append(" base fragment #").append(a[i1]).toString());
            }
            ai2 = a;
            l = i1 + 1;
            i1 = ai2[i1];
            int l1;
            if (i1 >= 0)
            {
                v1.d = (Fragment)ai1.f.get(i1);
            } else
            {
                v1.d = null;
            }
            ai2 = a;
            i1 = l + 1;
            v1.e = ai2[l];
            ai2 = a;
            l = i1 + 1;
            v1.f = ai2[i1];
            ai2 = a;
            i1 = l + 1;
            v1.g = ai2[l];
            ai2 = a;
            l = i1 + 1;
            v1.h = ai2[i1];
            ai2 = a;
            i1 = l + 1;
            l1 = ai2[l];
            l = i1;
            if (l1 > 0)
            {
                v1.i = new ArrayList(l1);
                int k1 = 0;
                do
                {
                    l = i1;
                    if (k1 >= l1)
                    {
                        break;
                    }
                    if (ai.a)
                    {
                        Log.v("FragmentManager", (new StringBuilder("Instantiate ")).append(r1).append(" set remove fragment #").append(a[i1]).toString());
                    }
                    Fragment fragment = (Fragment)ai1.f.get(a[i1]);
                    v1.i.add(fragment);
                    k1++;
                    i1++;
                } while (true);
            }
            r1.a(v1);
            j1++;
        }

        r1.i = b;
        r1.j = c;
        r1.m = d;
        r1.o = e;
        r1.k = true;
        r1.p = f;
        r1.q = g;
        r1.r = h;
        r1.s = i;
        r1.t = j;
        r1.u = k;
        r1.a(1);
        return r1;
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
