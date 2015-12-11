// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class buz
    implements Parcelable, bn
{

    public static final android.os.Parcelable.Creator CREATOR = new bva();
    public static final buz a = new buz();
    public final List A;
    public final List B;
    public final List C;
    public final List D;
    public final List E;
    public final List F;
    public final Uri G;
    public final Uri H;
    public final boolean I;
    public final long J;
    public final boolean K;
    public final bry L;
    public final Uri M;
    public final boolean N;
    public final buz O;
    public final buz P;
    public final String Q;
    public final String R;
    public final String S;
    public final boolean T;
    public final List U;
    public final bup V;
    public final List W;
    private final String X;
    private final byte Y[];
    private final String Z;
    private final String aa;
    private final String ab;
    private final Uri ac;
    private final String ad;
    private final List ae;
    private final List af;
    private final List ag;
    private final int ah;
    private final boolean ai;
    private dtl aj;
    private final long ak;
    private final boolean al;
    private final List am;
    public final List b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final bvc i;
    public final String j;
    public final int k;
    public final bww l;
    public final bst m;
    public final bwp n;
    public final bsv o;
    public final Uri p;
    public final List q;
    public final List r;
    public final List s;
    public final List t;
    public final List u;
    public final List v;
    public final List w;
    public final List x;
    public final List y;
    public final List z;

    private buz()
    {
        b = Collections.emptyList();
        c = null;
        d = null;
        e = null;
        X = null;
        f = null;
        Y = null;
        Z = null;
        g = null;
        aa = null;
        ab = null;
        ac = null;
        ad = null;
        h = null;
        i = bvc.d;
        j = null;
        k = 0;
        l = null;
        m = new bst();
        n = new bwp();
        o = null;
        p = null;
        q = Collections.emptyList();
        r = Collections.emptyList();
        s = Collections.emptyList();
        t = Collections.emptyList();
        u = Collections.emptyList();
        v = Collections.emptyList();
        w = Collections.emptyList();
        x = Collections.emptyList();
        y = Collections.emptyList();
        z = Collections.emptyList();
        A = Collections.emptyList();
        B = Collections.emptyList();
        ae = Collections.emptyList();
        C = Collections.emptyList();
        D = Collections.emptyList();
        E = Collections.emptyList();
        af = Collections.emptyList();
        F = Collections.emptyList();
        ag = Collections.emptyList();
        G = null;
        H = null;
        I = true;
        J = 0L;
        ah = -1;
        K = false;
        ai = false;
        aj = null;
        L = null;
        ak = 0L;
        al = false;
        T = false;
        M = null;
        N = false;
        O = null;
        P = null;
        S = k();
        Q = j();
        R = i();
        U = null;
        am = null;
        V = null;
        W = Collections.emptyList();
    }

    public buz(Parcel parcel)
    {
        List list = a(parcel);
        String s1 = parcel.readString();
        String s2 = parcel.readString();
        String s3 = parcel.readString();
        String s4 = parcel.readString();
        String s5 = parcel.readString();
        byte abyte0[] = parcel.createByteArray();
        String s6 = parcel.readString();
        String s7 = parcel.readString();
        String s8 = parcel.readString();
        String s9 = parcel.readString();
        Uri uri = (Uri)parcel.readParcelable(android/net/Uri.getClassLoader());
        String s10 = parcel.readString();
        String s11 = parcel.readString();
        bvc bvc1 = (bvc)Enum.valueOf(bvc, parcel.readString());
        String s12 = parcel.readString();
        int i1 = parcel.readInt();
        bww bww1 = (bww)parcel.readParcelable(bww.getClassLoader());
        bst bst1 = (bst)parcel.readParcelable(bst.getClassLoader());
        bwp bwp1 = (bwp)parcel.readParcelable(bwp.getClassLoader());
        bsv bsv1 = (bsv)parcel.readParcelable(bsv.getClassLoader());
        Uri uri1 = (Uri)parcel.readParcelable(android/net/Uri.getClassLoader());
        List list1 = a(parcel);
        List list2 = a(parcel);
        List list3 = a(parcel);
        List list4 = a(parcel);
        Object obj = new ArrayList();
        parcel.readTypedList(((List) (obj)), bvg.CREATOR);
        obj = Collections.unmodifiableList(((List) (obj)));
        List list5 = a(parcel);
        List list6 = a(parcel);
        List list7 = a(parcel);
        List list8 = a(parcel);
        List list9 = a(parcel);
        List list10 = a(parcel);
        List list11 = a(parcel);
        List list12 = a(parcel);
        List list13 = a(parcel);
        List list14 = a(parcel);
        List list15 = a(parcel);
        List list16 = a(parcel);
        List list17 = a(parcel);
        List list18 = a(parcel);
        Uri uri2 = (Uri)parcel.readParcelable(android/net/Uri.getClassLoader());
        Uri uri3 = (Uri)parcel.readParcelable(android/net/Uri.getClassLoader());
        dtl dtl1;
        bry bry1;
        Uri uri4;
        buz buz1;
        buz buz2;
        List list19;
        ArrayList arraylist;
        int j1;
        long l1;
        long l2;
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        l1 = parcel.readLong();
        j1 = parcel.readInt();
        if (parcel.readInt() == 1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (parcel.readInt() == 1)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        dtl1 = (dtl)a.b(parcel, new dtl());
        bry1 = (bry)parcel.readParcelable(bry.getClassLoader());
        l2 = parcel.readLong();
        if (parcel.readInt() == 1)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        if (parcel.readInt() == 1)
        {
            flag4 = true;
        } else
        {
            flag4 = false;
        }
        uri4 = (Uri)parcel.readParcelable(android/net/Uri.getClassLoader());
        buz1 = (buz)parcel.readParcelable(buz.getClassLoader());
        buz2 = (buz)parcel.readParcelable(buz.getClassLoader());
        list19 = b(parcel);
        arraylist = new ArrayList();
        parcel.readTypedList(arraylist, bvj.CREATOR);
        this(list, s1, s2, s3, s4, s5, abyte0, s6, s7, s8, s9, uri, s10, s11, bvc1, s12, i1, bww1, bst1, bwp1, bsv1, uri1, list1, list2, list3, list4, ((List) (obj)), list5, list6, list7, list8, list9, list10, list11, list12, list13, list14, list15, list16, list17, list18, uri2, uri3, flag, l1, j1, flag1, flag2, dtl1, bry1, l2, flag3, flag4, uri4, buz1, buz2, list19, Collections.unmodifiableList(arraylist), (bup)parcel.readParcelable(bup.getClassLoader()), a(parcel));
    }

    public buz(List list, String s1, String s2, String s3, String s4, String s5, byte abyte0[], 
            String s6, String s7, String s8, String s9, Uri uri, String s10, String s11, 
            bvc bvc1, String s12, int i1, bww bww1, bst bst1, bwp bwp1, bsv bsv1, 
            Uri uri1, List list1, List list2, List list3, List list4, List list5, List list6, 
            List list7, List list8, List list9, List list10, List list11, List list12, List list13, 
            List list14, List list15, List list16, List list17, List list18, List list19, Uri uri2, 
            Uri uri3, boolean flag, long l1, int j1, boolean flag1, boolean flag2, 
            dtl dtl1, bry bry1, long l2, boolean flag3, boolean flag4, Uri uri4, 
            buz buz1, buz buz2, List list20, List list21, bup bup1, List list22)
    {
        b = a.a(list);
        c = s1;
        d = s2;
        if (s3 == null)
        {
            if (buz2 != null)
            {
                s3 = buz2.e;
            } else
            {
                s3 = null;
            }
        }
        e = s3;
        if (s4 == null)
        {
            if (buz2 != null)
            {
                s4 = buz2.X;
            } else
            {
                s4 = null;
            }
        }
        X = s4;
        if (s5 == null)
        {
            if (buz2 != null)
            {
                s5 = buz2.f;
            } else
            {
                s5 = null;
            }
        }
        f = s5;
        Y = abyte0;
        Z = s6;
        g = s7;
        aa = s8;
        ab = s9;
        ac = uri;
        ad = s10;
        h = s11;
        i = bvc1;
        j = s12;
        k = i1;
        l = bww1;
        m = (bst)b.a(bst1);
        n = (bwp)b.a(bwp1);
        o = bsv1;
        p = uri1;
        q = a.a(list1);
        r = a.a(list2);
        s = a.a(list3);
        t = a.a(list4);
        u = a.a(list5);
        v = a.a(list6);
        w = a.a(list7);
        x = a.a(list8);
        y = a.a(list9);
        z = a.a(list10);
        A = a.a(list11);
        B = a.a(list12);
        ae = a.a(list13);
        C = a.a(list14);
        D = a.a(list15);
        E = a.a(list16);
        af = a.a(list17);
        F = a.a(list18);
        ag = a.a(list19);
        G = uri2;
        H = uri3;
        I = flag;
        J = l1;
        ah = j1;
        K = flag1;
        ai = flag2;
        aj = dtl1;
        L = bry1;
        ak = l2;
        al = flag3;
        T = flag4;
        M = uri4;
        if (uri4 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        N = flag;
        O = buz1;
        P = buz2;
        S = k();
        Q = j();
        R = i();
        U = a.a(list20);
        am = a.a(list21);
        V = bup1;
        W = a.a(list22);
    }

    private static List a(Parcel parcel)
    {
        ArrayList arraylist = new ArrayList();
        parcel.readTypedList(arraylist, Uri.CREATOR);
        return Collections.unmodifiableList(arraylist);
    }

    public static boolean a(Uri uri)
    {
        return uri != null && (b.a(uri.getScheme(), "http") || b.a(uri.getScheme(), "https")) && uri.getHost() != null && uri.getHost().startsWith("www.youtube");
    }

    private static List b(Parcel parcel)
    {
        Object obj = new ArrayList();
        parcel.readStringList(((List) (obj)));
        parcel = new ArrayList();
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); parcel.add(Enum.valueOf(bvf, (String)((Iterator) (obj)).next()))) { }
        return Collections.unmodifiableList(parcel);
    }

    private String i()
    {
        bmz bmz1 = new bmz();
        buz buz1 = this;
        while (buz1 != null) 
        {
            String s1;
            if (buz1.ad == null)
            {
                s1 = "";
            } else
            {
                s1 = buz1.ad;
            }
            bmz1.offer(s1);
            buz1 = buz1.P;
        }
        return TextUtils.join(",", bmz1);
    }

    private String j()
    {
        bmz bmz1 = new bmz();
        buz buz1 = this;
        while (buz1 != null) 
        {
            String s1;
            if (buz1.h == null)
            {
                s1 = "";
            } else
            {
                s1 = buz1.h;
            }
            bmz1.offer(s1);
            buz1 = buz1.P;
        }
        return TextUtils.join(",", bmz1);
    }

    private String k()
    {
        bmz bmz1 = new bmz();
        for (buz buz1 = this; buz1 != null; buz1 = buz1.P)
        {
            bmz1.offer(Long.valueOf(buz1.ak));
        }

        return TextUtils.join(",", bmz1);
    }

    public final bvd a()
    {
        bvd bvd1 = new bvd();
        bvd1.b = new ArrayList(b);
        bvd1.j = c;
        bvd1.c = d;
        bvd1.d = e;
        bvd1.e = X;
        bvd1.f = f;
        bvd1.g = Y;
        bvd1.h = Z;
        bvd1.i = g;
        bvd1.k = aa;
        bvd1.l = ab;
        bvd1.m = ac;
        bvd1.n = ad;
        bvd1.o = h;
        bvd1.p = i;
        bvd1.q = j;
        bvd1.r = k;
        bvd1.s = l;
        bvd1.t = m;
        bvd1.v = o;
        bvd1.u = n;
        bvd1.w = p;
        bvd1.x = q;
        bvd1.y = r;
        bvd1.z = s;
        bvd1.A = t;
        bvd1.B = u;
        bvd1.C = v;
        bvd1.D = w;
        bvd1.E = x;
        bvd1.F = y;
        bvd1.G = z;
        bvd1.H = A;
        bvd1.I = B;
        bvd1.J = ae;
        bvd1.K = C;
        bvd1.L = D;
        bvd1.M = E;
        bvd1.N = af;
        bvd1.O = F;
        bvd1.P = ag;
        bvd1.Q = G;
        bvd1.R = H;
        bvd1.U = I;
        bvd1.S = J;
        bvd1.T = ah;
        bvd1.V = K;
        bvd1.W = ai;
        bvd1.X = aj;
        bvd1.Y = L;
        bvd1.Z = ak;
        bvd1.aa = al;
        bvd1.ab = T;
        bvd1.ac = M;
        bvd1.ad = O;
        bvd1.ae = P;
        bvd1.af = U;
        bvd1.ah = am;
        bvd1.ai = V;
        bvd1.ak = W;
        return bvd1;
    }

    public final boolean a(bmi bmi1)
    {
        return bmi1.a() >= J;
    }

    public final String b()
    {
        if (K)
        {
            return ab;
        } else
        {
            return null;
        }
    }

    public final boolean b(bmi bmi1)
    {
        return !d() && !a(bmi1);
    }

    public final boolean d()
    {
        return l == null && !N && V == null;
    }

    public int describeContents()
    {
        return 0;
    }

    public final boolean e()
    {
        return b.isEmpty();
    }

    public boolean equals(Object obj)
    {
        if (obj != null && getClass().equals(obj.getClass()))
        {
            obj = (buz)obj;
            if (b.a(c, ((buz) (obj)).c) && b.a(d, ((buz) (obj)).d) && b.a(e, ((buz) (obj)).e) && b.a(X, ((buz) (obj)).X) && b.a(f, ((buz) (obj)).f) && Arrays.equals(Y, ((buz) (obj)).Y) && b.a(Z, ((buz) (obj)).Z) && b.a(g, ((buz) (obj)).g) && b.a(aa, ((buz) (obj)).aa) && b.a(ab, ((buz) (obj)).ab) && b.a(ac, ((buz) (obj)).ac) && b.a(ad, ((buz) (obj)).ad) && b.a(h, ((buz) (obj)).h) && b.a(i, ((buz) (obj)).i) && b.a(j, ((buz) (obj)).j) && b.a(l, ((buz) (obj)).l) && b.a(m, ((buz) (obj)).m) && b.a(n, ((buz) (obj)).n) && b.a(p, ((buz) (obj)).p) && k == ((buz) (obj)).k && I == ((buz) (obj)).I && J == ((buz) (obj)).J && ah == ((buz) (obj)).ah && b.a(b, ((buz) (obj)).b) && b.a(q, ((buz) (obj)).q) && b.a(r, ((buz) (obj)).r) && b.a(s, ((buz) (obj)).s) && b.a(t, ((buz) (obj)).t) && b.a(u, ((buz) (obj)).u) && b.a(v, ((buz) (obj)).v) && b.a(w, ((buz) (obj)).w) && b.a(x, ((buz) (obj)).x) && b.a(y, ((buz) (obj)).y) && b.a(z, ((buz) (obj)).z) && b.a(A, ((buz) (obj)).A) && b.a(B, ((buz) (obj)).B) && b.a(ae, ((buz) (obj)).ae) && b.a(C, ((buz) (obj)).C) && b.a(D, ((buz) (obj)).D) && b.a(E, ((buz) (obj)).E) && b.a(af, ((buz) (obj)).af) && b.a(F, ((buz) (obj)).F) && b.a(ag, ((buz) (obj)).ag) && b.a(G, ((buz) (obj)).G) && b.a(H, ((buz) (obj)).H) && b.a(M, ((buz) (obj)).M) && b.a(O, ((buz) (obj)).O) && b.a(P, ((buz) (obj)).P) && ai == ((buz) (obj)).ai && al == ((buz) (obj)).al && T == ((buz) (obj)).T && al == ((buz) (obj)).al && b.a(U, ((buz) (obj)).U) && b.a(am, ((buz) (obj)).am) && b.a(V, ((buz) (obj)).V) && b.a(o, ((buz) (obj)).o) && b.a(W, ((buz) (obj)).W))
            {
                return true;
            }
        }
        return false;
    }

    public final boolean f()
    {
        return !v.isEmpty();
    }

    public final Uri g()
    {
        List list;
        if (l != null)
        {
            if ((list = l.a) != null)
            {
                return ((bwb)list.get(0)).b();
            }
        }
        return null;
    }

    public final int h()
    {
        int i1 = 0;
        for (buz buz1 = P; buz1 != null; buz1 = buz1.P)
        {
            i1++;
        }

        return i1;
    }

    public int hashCode()
    {
        b.b(false);
        return 0;
    }

    public String toString()
    {
        if (N)
        {
            String s1 = String.valueOf(M);
            return (new StringBuilder(String.valueOf(s1).length() + 29)).append("VastAd Wrapper: [wrapperUri=").append(s1).append("]").toString();
        } else
        {
            String s2 = ad;
            String s3 = c;
            String s4 = aa;
            String s5 = h;
            return (new StringBuilder(String.valueOf(s2).length() + 61 + String.valueOf(s3).length() + String.valueOf(s4).length() + String.valueOf(s5).length())).append("VastAd: [vastAdId=").append(s2).append(", adVideoId=").append(s3).append(",videoTitle= ").append(s4).append(", vastAdSystem = ").append(s5).append("]").toString();
        }
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        boolean flag = true;
        parcel.writeTypedList(b);
        parcel.writeString(c);
        parcel.writeString(d);
        parcel.writeString(e);
        parcel.writeString(X);
        parcel.writeString(f);
        parcel.writeByteArray(Y);
        parcel.writeString(Z);
        parcel.writeString(g);
        parcel.writeString(aa);
        parcel.writeString(ab);
        parcel.writeParcelable(ac, 0);
        parcel.writeString(ad);
        parcel.writeString(h);
        parcel.writeString(i.toString());
        parcel.writeString(j);
        parcel.writeInt(k);
        parcel.writeParcelable(l, 0);
        parcel.writeParcelable(m, 0);
        parcel.writeParcelable(n, 0);
        parcel.writeParcelable(o, 0);
        parcel.writeParcelable(p, 0);
        parcel.writeTypedList(q);
        parcel.writeTypedList(r);
        parcel.writeTypedList(s);
        parcel.writeTypedList(t);
        parcel.writeTypedList(u);
        parcel.writeTypedList(v);
        parcel.writeTypedList(w);
        parcel.writeTypedList(x);
        parcel.writeTypedList(y);
        parcel.writeTypedList(z);
        parcel.writeTypedList(A);
        parcel.writeTypedList(B);
        parcel.writeTypedList(ae);
        parcel.writeTypedList(C);
        parcel.writeTypedList(D);
        parcel.writeTypedList(E);
        parcel.writeTypedList(af);
        parcel.writeTypedList(F);
        parcel.writeTypedList(ag);
        parcel.writeParcelable(G, 0);
        parcel.writeParcelable(H, 0);
        ArrayList arraylist;
        Object obj;
        if (I)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        parcel.writeInt(i1);
        parcel.writeLong(J);
        parcel.writeInt(ah);
        if (K)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        parcel.writeInt(i1);
        if (ai)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        parcel.writeInt(i1);
        a.a(parcel, aj);
        parcel.writeParcelable(L, 0);
        parcel.writeLong(ak);
        if (al)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        parcel.writeInt(i1);
        if (T)
        {
            i1 = ((flag) ? 1 : 0);
        } else
        {
            i1 = 0;
        }
        parcel.writeInt(i1);
        parcel.writeParcelable(M, 0);
        parcel.writeParcelable(O, 0);
        parcel.writeParcelable(P, 0);
        obj = U;
        arraylist = new ArrayList();
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(((bvf)((Iterator) (obj)).next()).name())) { }
        parcel.writeStringList(arraylist);
        parcel.writeTypedList(am);
        parcel.writeParcelable(V, 0);
        parcel.writeTypedList(W);
    }

    static 
    {
        new bve();
    }
}
