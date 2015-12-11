// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.c.a.a.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            es, jq

public final class ib extends es
    implements a, SafeParcelable
{

    public static final jq CREATOR = new jq();
    private static final HashMap ae;
    String A;
    String B;
    String C;
    ib D;
    String E;
    String F;
    String G;
    String H;
    ib I;
    double J;
    ib K;
    double L;
    String M;
    ib N;
    List O;
    String P;
    String Q;
    String R;
    String S;
    ib T;
    String U;
    String V;
    String W;
    ib X;
    String Y;
    String Z;
    final Set a;
    String aa;
    String ab;
    String ac;
    String ad;
    final int b;
    ib c;
    List d;
    ib e;
    String f;
    String g;
    String h;
    List i;
    int j;
    List k;
    ib l;
    List m;
    String n;
    String o;
    ib p;
    String q;
    String r;
    String s;
    List t;
    String u;
    String v;
    String w;
    String x;
    String y;
    String z;

    public ib()
    {
        b = 1;
        a = new HashSet();
    }

    ib(Set set, int i1, ib ib1, List list, ib ib2, String s1, String s2, 
            String s3, List list1, int j1, List list2, ib ib3, List list3, String s4, 
            String s5, ib ib4, String s6, String s7, String s8, List list4, String s9, 
            String s10, String s11, String s12, String s13, String s14, String s15, String s16, 
            String s17, ib ib5, String s18, String s19, String s20, String s21, ib ib6, 
            double d1, ib ib7, double d2, String s22, ib ib8, 
            List list5, String s23, String s24, String s25, String s26, ib ib9, String s27, 
            String s28, String s29, ib ib10, String s30, String s31, String s32, String s33, 
            String s34, String s35)
    {
        a = set;
        b = i1;
        c = ib1;
        d = list;
        e = ib2;
        f = s1;
        g = s2;
        h = s3;
        i = list1;
        j = j1;
        k = list2;
        l = ib3;
        m = list3;
        n = s4;
        o = s5;
        p = ib4;
        q = s6;
        r = s7;
        s = s8;
        t = list4;
        u = s9;
        v = s10;
        w = s11;
        x = s12;
        y = s13;
        z = s14;
        A = s15;
        B = s16;
        C = s17;
        D = ib5;
        E = s18;
        F = s19;
        G = s20;
        H = s21;
        I = ib6;
        J = d1;
        K = ib7;
        L = d2;
        M = s22;
        N = ib8;
        O = list5;
        P = s23;
        Q = s24;
        R = s25;
        S = s26;
        T = ib9;
        U = s27;
        V = s28;
        W = s29;
        X = ib10;
        Y = s30;
        Z = s31;
        aa = s32;
        ab = s33;
        ac = s34;
        ad = s35;
    }

    public final Object a()
    {
        return this;
    }

    protected final boolean a(es.a a1)
    {
        return a.contains(Integer.valueOf(a1.f()));
    }

    protected final Object b(es.a a1)
    {
        switch (a1.f())
        {
        case 35: // '#'
        default:
            throw new IllegalStateException((new StringBuilder("Unknown safe parcelable id=")).append(a1.f()).toString());

        case 2: // '\002'
            return c;

        case 3: // '\003'
            return d;

        case 4: // '\004'
            return e;

        case 5: // '\005'
            return f;

        case 6: // '\006'
            return g;

        case 7: // '\007'
            return h;

        case 8: // '\b'
            return i;

        case 9: // '\t'
            return Integer.valueOf(j);

        case 10: // '\n'
            return k;

        case 11: // '\013'
            return l;

        case 12: // '\f'
            return m;

        case 13: // '\r'
            return n;

        case 14: // '\016'
            return o;

        case 15: // '\017'
            return p;

        case 16: // '\020'
            return q;

        case 17: // '\021'
            return r;

        case 18: // '\022'
            return s;

        case 19: // '\023'
            return t;

        case 20: // '\024'
            return u;

        case 21: // '\025'
            return v;

        case 22: // '\026'
            return w;

        case 23: // '\027'
            return x;

        case 24: // '\030'
            return y;

        case 25: // '\031'
            return z;

        case 26: // '\032'
            return A;

        case 27: // '\033'
            return B;

        case 28: // '\034'
            return C;

        case 29: // '\035'
            return D;

        case 30: // '\036'
            return E;

        case 31: // '\037'
            return F;

        case 32: // ' '
            return G;

        case 33: // '!'
            return H;

        case 34: // '"'
            return I;

        case 36: // '$'
            return Double.valueOf(J);

        case 37: // '%'
            return K;

        case 38: // '&'
            return Double.valueOf(L);

        case 39: // '\''
            return M;

        case 40: // '('
            return N;

        case 41: // ')'
            return O;

        case 42: // '*'
            return P;

        case 43: // '+'
            return Q;

        case 44: // ','
            return R;

        case 45: // '-'
            return S;

        case 46: // '.'
            return T;

        case 47: // '/'
            return U;

        case 48: // '0'
            return V;

        case 49: // '1'
            return W;

        case 50: // '2'
            return X;

        case 51: // '3'
            return Y;

        case 52: // '4'
            return Z;

        case 53: // '5'
            return aa;

        case 54: // '6'
            return ab;

        case 55: // '7'
            return ac;

        case 56: // '8'
            return ad;
        }
    }

    public final HashMap b()
    {
        return ae;
    }

    protected final Object c()
    {
        return null;
    }

    protected final boolean d()
    {
        return false;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
label0:
        {
            if (!(obj instanceof ib))
            {
                return false;
            }
            if (this == obj)
            {
                return true;
            }
            obj = (ib)obj;
            es.a a1;
label1:
            do
            {
                for (Iterator iterator = ae.values().iterator(); iterator.hasNext();)
                {
                    a1 = (es.a)iterator.next();
                    if (!a(a1))
                    {
                        continue label1;
                    }
                    if (((ib) (obj)).a(a1))
                    {
                        if (!b(a1).equals(((ib) (obj)).b(a1)))
                        {
                            return false;
                        }
                    } else
                    {
                        return false;
                    }
                }

                break label0;
            } while (!((ib) (obj)).a(a1));
            return false;
        }
        return true;
    }

    public final int hashCode()
    {
        Iterator iterator = ae.values().iterator();
        int i1 = 0;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            es.a a1 = (es.a)iterator.next();
            if (a(a1))
            {
                int j1 = a1.f();
                i1 = b(a1).hashCode() + (i1 + j1);
            }
        } while (true);
        return i1;
    }

    public final void writeToParcel(Parcel parcel, int i1)
    {
        com.google.android.gms.internal.jq.a(this, parcel, i1);
    }

    static 
    {
        HashMap hashmap = new HashMap();
        ae = hashmap;
        hashmap.put("about", com.google.android.gms.internal.es.a.a("about", 2, com/google/android/gms/internal/ib));
        ae.put("additionalName", com.google.android.gms.internal.es.a.a("additionalName"));
        ae.put("address", com.google.android.gms.internal.es.a.a("address", 4, com/google/android/gms/internal/ib));
        ae.put("addressCountry", es.a.d("addressCountry", 5));
        ae.put("addressLocality", es.a.d("addressLocality", 6));
        ae.put("addressRegion", es.a.d("addressRegion", 7));
        ae.put("associated_media", es.a.b("associated_media", 8, com/google/android/gms/internal/ib));
        ae.put("attendeeCount", com.google.android.gms.internal.es.a.a("attendeeCount", 9));
        ae.put("attendees", es.a.b("attendees", 10, com/google/android/gms/internal/ib));
        ae.put("audio", com.google.android.gms.internal.es.a.a("audio", 11, com/google/android/gms/internal/ib));
        ae.put("author", es.a.b("author", 12, com/google/android/gms/internal/ib));
        ae.put("bestRating", es.a.d("bestRating", 13));
        ae.put("birthDate", es.a.d("birthDate", 14));
        ae.put("byArtist", com.google.android.gms.internal.es.a.a("byArtist", 15, com/google/android/gms/internal/ib));
        ae.put("caption", es.a.d("caption", 16));
        ae.put("contentSize", es.a.d("contentSize", 17));
        ae.put("contentUrl", es.a.d("contentUrl", 18));
        ae.put("contributor", es.a.b("contributor", 19, com/google/android/gms/internal/ib));
        ae.put("dateCreated", es.a.d("dateCreated", 20));
        ae.put("dateModified", es.a.d("dateModified", 21));
        ae.put("datePublished", es.a.d("datePublished", 22));
        ae.put("description", es.a.d("description", 23));
        ae.put("duration", es.a.d("duration", 24));
        ae.put("embedUrl", es.a.d("embedUrl", 25));
        ae.put("endDate", es.a.d("endDate", 26));
        ae.put("familyName", es.a.d("familyName", 27));
        ae.put("gender", es.a.d("gender", 28));
        ae.put("geo", com.google.android.gms.internal.es.a.a("geo", 29, com/google/android/gms/internal/ib));
        ae.put("givenName", es.a.d("givenName", 30));
        ae.put("height", es.a.d("height", 31));
        ae.put("id", es.a.d("id", 32));
        ae.put("image", es.a.d("image", 33));
        ae.put("inAlbum", com.google.android.gms.internal.es.a.a("inAlbum", 34, com/google/android/gms/internal/ib));
        ae.put("latitude", es.a.b("latitude", 36));
        ae.put("location", com.google.android.gms.internal.es.a.a("location", 37, com/google/android/gms/internal/ib));
        ae.put("longitude", es.a.b("longitude", 38));
        ae.put("name", es.a.d("name", 39));
        ae.put("partOfTVSeries", com.google.android.gms.internal.es.a.a("partOfTVSeries", 40, com/google/android/gms/internal/ib));
        ae.put("performers", es.a.b("performers", 41, com/google/android/gms/internal/ib));
        ae.put("playerType", es.a.d("playerType", 42));
        ae.put("postOfficeBoxNumber", es.a.d("postOfficeBoxNumber", 43));
        ae.put("postalCode", es.a.d("postalCode", 44));
        ae.put("ratingValue", es.a.d("ratingValue", 45));
        ae.put("reviewRating", com.google.android.gms.internal.es.a.a("reviewRating", 46, com/google/android/gms/internal/ib));
        ae.put("startDate", es.a.d("startDate", 47));
        ae.put("streetAddress", es.a.d("streetAddress", 48));
        ae.put("text", es.a.d("text", 49));
        ae.put("thumbnail", com.google.android.gms.internal.es.a.a("thumbnail", 50, com/google/android/gms/internal/ib));
        ae.put("thumbnailUrl", es.a.d("thumbnailUrl", 51));
        ae.put("tickerSymbol", es.a.d("tickerSymbol", 52));
        ae.put("type", es.a.d("type", 53));
        ae.put("url", es.a.d("url", 54));
        ae.put("width", es.a.d("width", 55));
        ae.put("worstRating", es.a.d("worstRating", 56));
    }
}
