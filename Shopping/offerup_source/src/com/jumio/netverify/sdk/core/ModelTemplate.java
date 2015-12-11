// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.netverify.sdk.core;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.jumio.commons.camera.ImageData;
import com.jumio.mobile.sdk.enums.JumioDataCenter;
import com.jumio.netverify.barcode.JumioBarcodeScannerInterface;
import com.jumio.netverify.barcode.enums.BarcodeFormat;
import com.jumio.netverify.sdk.NetverifyDocumentData;
import com.jumio.netverify.sdk.core.vo.Country;
import com.jumio.netverify.sdk.core.vo.DocumentType;
import com.jumio.netverify.sdk.enums.NVDocumentType;
import com.jumio.netverify.sdk.enums.NVDocumentVariant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jumiomobile.hh;
import jumiomobile.hq;
import jumiomobile.hu;

public abstract class ModelTemplate
    implements Parcelable
{

    public String A;
    public String B;
    public String C;
    public String D;
    public String E;
    public boolean F;
    public boolean G;
    public boolean H;
    public NetverifyDocumentData I;
    public hq J;
    public BarcodeFormat K;
    public boolean L;
    public boolean M;
    public boolean N;
    public JumioDataCenter O;
    public JumioBarcodeScannerInterface P;
    private List Q;
    private List R;
    public Activity a;
    public hh b;
    public hu c;
    public boolean d;
    public boolean e;
    public boolean f;
    public String g;
    public String h;
    public String i;
    public String j;
    public Country k;
    public String l;
    public NVDocumentType m;
    public List n;
    public NVDocumentVariant o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public SparseArray u;
    public DocumentType v;
    public int w;
    public String x;
    public String y;
    public String z;

    protected ModelTemplate()
    {
        d = false;
        e = false;
        f = false;
        i = "";
        w = -1;
        x = "";
        y = "";
        z = "";
        A = "";
        B = "";
        C = null;
        D = null;
        E = null;
        F = false;
        G = false;
        H = false;
        I = new NetverifyDocumentData();
        J = null;
        K = null;
        L = true;
        M = false;
        N = false;
        P = null;
    }

    public static void a(ModelTemplate modeltemplate, Parcel parcel)
    {
        Object obj1 = null;
        boolean flag1 = true;
        Object obj;
        int j1;
        boolean flag;
        if (parcel.readByte() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        modeltemplate.d = flag;
        if (parcel.readByte() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        modeltemplate.e = flag;
        if (parcel.readByte() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        modeltemplate.f = flag;
        modeltemplate.g = parcel.readString();
        modeltemplate.h = parcel.readString();
        obj = parcel.readString();
        if (((String) (obj)).length() != 0)
        {
            obj = JumioDataCenter.valueOf(((String) (obj)));
        } else
        {
            obj = null;
        }
        modeltemplate.O = ((JumioDataCenter) (obj));
        modeltemplate.i = parcel.readString();
        modeltemplate.j = parcel.readString();
        modeltemplate.Q = new ArrayList();
        parcel.readList(modeltemplate.Q, com/jumio/netverify/sdk/core/vo/Country.getClassLoader());
        modeltemplate.k = (Country)parcel.readParcelable(com/jumio/netverify/sdk/core/vo/Country.getClassLoader());
        modeltemplate.l = parcel.readString();
        obj = parcel.readString();
        if (((String) (obj)).length() != 0)
        {
            obj = NVDocumentType.valueOf(((String) (obj)));
        } else
        {
            obj = null;
        }
        modeltemplate.m = ((NVDocumentType) (obj));
        modeltemplate.n = new ArrayList();
        parcel.readList(modeltemplate.n, com/jumio/netverify/sdk/enums/NVDocumentType.getClassLoader());
        obj = parcel.readString();
        if (((String) (obj)).length() != 0)
        {
            obj = NVDocumentVariant.valueOf(((String) (obj)));
        } else
        {
            obj = null;
        }
        modeltemplate.o = ((NVDocumentVariant) (obj));
        if (parcel.readByte() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        modeltemplate.p = flag;
        if (parcel.readByte() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        modeltemplate.q = flag;
        if (parcel.readByte() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        modeltemplate.r = flag;
        if (parcel.readByte() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        modeltemplate.s = flag;
        if (parcel.readByte() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        modeltemplate.t = flag;
        j1 = parcel.readInt();
        if (j1 != 0)
        {
            modeltemplate.u = new SparseArray();
            for (int i1 = 0; i1 < j1; i1++)
            {
                modeltemplate.u.append(parcel.readInt(), (ImageData)parcel.readParcelable(com/jumio/commons/camera/ImageData.getClassLoader()));
            }

        }
        modeltemplate.v = (DocumentType)parcel.readParcelable(com/jumio/netverify/sdk/core/vo/DocumentType.getClassLoader());
        modeltemplate.w = parcel.readInt();
        modeltemplate.x = parcel.readString();
        modeltemplate.y = parcel.readString();
        obj = parcel.readString();
        String s1;
        if (((String) (obj)).length() != 0)
        {
            obj = hu.valueOf(((String) (obj)));
        } else
        {
            obj = null;
        }
        modeltemplate.c = ((hu) (obj));
        modeltemplate.z = parcel.readString();
        modeltemplate.A = parcel.readString();
        modeltemplate.B = parcel.readString();
        modeltemplate.C = parcel.readString();
        modeltemplate.D = parcel.readString();
        if (parcel.readByte() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        modeltemplate.F = flag;
        if (parcel.readByte() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        modeltemplate.G = flag;
        if (parcel.readByte() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        modeltemplate.H = flag;
        modeltemplate.I = (NetverifyDocumentData)parcel.readParcelable(com/jumio/netverify/sdk/NetverifyDocumentData.getClassLoader());
        s1 = parcel.readString();
        obj = obj1;
        if (s1.length() != 0)
        {
            obj = hq.valueOf(s1);
        }
        modeltemplate.J = ((hq) (obj));
        obj = parcel.readString();
        if (!"".equals(obj))
        {
            modeltemplate.K = BarcodeFormat.valueOf(((String) (obj)));
        }
        if (parcel.readByte() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        modeltemplate.L = flag;
        if (parcel.readByte() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        modeltemplate.M = flag;
        if (parcel.readByte() == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        modeltemplate.N = flag;
    }

    public void a(List list)
    {
        Q = list;
    }

    public void c()
    {
        j = null;
        l = null;
        m = null;
        n = null;
        o = null;
        p = false;
        q = false;
        r = false;
        s = false;
        t = false;
        v = null;
        w = -1;
        u = null;
        f = false;
        F = false;
        I = new NetverifyDocumentData();
        x = "";
        y = "";
        z = "";
        A = "";
        B = "";
        c = hu.a;
        J = hq.i;
        K = null;
        L = true;
        M = false;
        N = false;
        R = null;
    }

    public List d()
    {
        if (R == null || R.size() == 0)
        {
            R = new ArrayList();
            if (Q == null)
            {
                return R;
            }
            Iterator iterator = Q.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Country country = ((Country)iterator.next()).a(F, N, n);
                if (m == null || m != null && country.b(m) != null)
                {
                    if (F)
                    {
                        if (country.f())
                        {
                            R.add(country);
                        }
                    } else
                    if (country.g())
                    {
                        R.add(country);
                    }
                }
            } while (true);
        }
        return R;
    }

    public int describeContents()
    {
        return 0;
    }

    public Country e()
    {
        Country country = f();
        if (R == null || I == null || I.getIssuingCountry() == null)
        {
            return country;
        }
        for (Iterator iterator = d().iterator(); iterator.hasNext();)
        {
            Country country1 = (Country)iterator.next();
            if (country1.b().equals(I.getIssuingCountry()))
            {
                return country1;
            }
        }

        return country;
    }

    public Country f()
    {
        List list = d();
        if (list == null || w == -1 || list.size() < w)
        {
            return null;
        } else
        {
            return (Country)list.get(w);
        }
    }

    public boolean g()
    {
        for (int i1 = 0; i1 < u.size(); i1++)
        {
            if (u.valueAt(i1) == null || !((ImageData)u.valueAt(i1)).g())
            {
                return false;
            }
        }

        return true;
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        boolean flag = true;
        String s1;
        int j1;
        if (d)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        parcel.writeByte((byte)j1);
        if (e)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        parcel.writeByte((byte)j1);
        if (f)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        parcel.writeByte((byte)j1);
        parcel.writeString(g);
        parcel.writeString(h);
        if (O == null)
        {
            s1 = "";
        } else
        {
            s1 = O.name();
        }
        parcel.writeString(s1);
        parcel.writeString(i);
        parcel.writeString(j);
        parcel.writeList(Q);
        parcel.writeParcelable(k, i1);
        parcel.writeString(l);
        if (m == null)
        {
            s1 = "";
        } else
        {
            s1 = m.name();
        }
        parcel.writeString(s1);
        parcel.writeList(n);
        if (o == null)
        {
            s1 = "";
        } else
        {
            s1 = o.name();
        }
        parcel.writeString(s1);
        if (p)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        parcel.writeByte((byte)j1);
        if (q)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        parcel.writeByte((byte)j1);
        if (r)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        parcel.writeByte((byte)j1);
        if (s)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        parcel.writeByte((byte)j1);
        if (t)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        parcel.writeByte((byte)j1);
        if (u != null)
        {
            j1 = u.size();
        } else
        {
            j1 = 0;
        }
        parcel.writeInt(j1);
        for (int k1 = 0; k1 < j1; k1++)
        {
            parcel.writeInt(u.keyAt(k1));
            parcel.writeParcelable((Parcelable)u.valueAt(k1), i1);
        }

        parcel.writeParcelable(v, i1);
        parcel.writeInt(w);
        parcel.writeString(x);
        parcel.writeString(y);
        if (c == null)
        {
            s1 = "";
        } else
        {
            s1 = c.name();
        }
        parcel.writeString(s1);
        parcel.writeString(z);
        parcel.writeString(A);
        parcel.writeString(B);
        parcel.writeString(C);
        parcel.writeString(D);
        if (F)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        parcel.writeByte((byte)j1);
        if (G)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        parcel.writeByte((byte)j1);
        if (H)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        parcel.writeByte((byte)j1);
        parcel.writeParcelable(I, i1);
        if (J == null)
        {
            s1 = "";
        } else
        {
            s1 = J.name();
        }
        parcel.writeString(s1);
        if (K == null)
        {
            s1 = "";
        } else
        {
            s1 = K.name();
        }
        parcel.writeString(s1);
        if (L)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        parcel.writeByte((byte)i1);
        if (M)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        parcel.writeByte((byte)i1);
        if (N)
        {
            i1 = ((flag) ? 1 : 0);
        } else
        {
            i1 = 0;
        }
        parcel.writeByte((byte)i1);
    }
}
