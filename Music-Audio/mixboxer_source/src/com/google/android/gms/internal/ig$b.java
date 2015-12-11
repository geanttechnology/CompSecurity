// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            es, ig, ij, ep, 
//            ik, il

public static final class FN extends es
    implements SafeParcelable, com.google.android.gms.plus.model.people.n.Cover
{
    public static final class a extends es
        implements SafeParcelable, com.google.android.gms.plus.model.people.Person.Cover.CoverInfo
    {

        public static final ik CREATOR = new ik();
        private static final HashMap Ep;
        private final Set Eq;
        private int FO;
        private int FP;
        private final int kg;

        protected Object V(String s)
        {
            return null;
        }

        protected boolean W(String s)
        {
            return false;
        }

        protected boolean a(es.a a1)
        {
            return Eq.contains(Integer.valueOf(a1.cq()));
        }

        protected Object b(es.a a1)
        {
            switch (a1.cq())
            {
            default:
                throw new IllegalStateException((new StringBuilder()).append("Unknown safe parcelable id=").append(a1.cq()).toString());

            case 2: // '\002'
                return Integer.valueOf(FO);

            case 3: // '\003'
                return Integer.valueOf(FP);
            }
        }

        public HashMap cj()
        {
            return Ep;
        }

        public int describeContents()
        {
            ik ik1 = CREATOR;
            return 0;
        }

        public boolean equals(Object obj)
        {
label0:
            {
                if (!(obj instanceof a))
                {
                    return false;
                }
                if (this == obj)
                {
                    return true;
                }
                obj = (a)obj;
                es.a a1;
label1:
                do
                {
                    for (Iterator iterator = Ep.values().iterator(); iterator.hasNext();)
                    {
                        a1 = (es.a)iterator.next();
                        if (!a(a1))
                        {
                            continue label1;
                        }
                        if (((a) (obj)).a(a1))
                        {
                            if (!b(a1).equals(((a) (obj)).b(a1)))
                            {
                                return false;
                            }
                        } else
                        {
                            return false;
                        }
                    }

                    break label0;
                } while (!((a) (obj)).a(a1));
                return false;
            }
            return true;
        }

        public a fH()
        {
            return this;
        }

        Set fa()
        {
            return Eq;
        }

        public Object freeze()
        {
            return fH();
        }

        public int getLeftImageOffset()
        {
            return FO;
        }

        public int getTopImageOffset()
        {
            return FP;
        }

        int getVersionCode()
        {
            return kg;
        }

        public boolean hasLeftImageOffset()
        {
            return Eq.contains(Integer.valueOf(2));
        }

        public boolean hasTopImageOffset()
        {
            return Eq.contains(Integer.valueOf(3));
        }

        public int hashCode()
        {
            Iterator iterator = Ep.values().iterator();
            int i = 0;
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                es.a a1 = (es.a)iterator.next();
                if (a(a1))
                {
                    int j = a1.cq();
                    i = b(a1).hashCode() + (i + j);
                }
            } while (true);
            return i;
        }

        public boolean isDataValid()
        {
            return true;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            ik ik1 = CREATOR;
            ik.a(this, parcel, i);
        }

        static 
        {
            Ep = new HashMap();
            Ep.put("leftImageOffset", es.a.d("leftImageOffset", 2));
            Ep.put("topImageOffset", es.a.d("topImageOffset", 3));
        }

        public a()
        {
            kg = 1;
            Eq = new HashSet();
        }

        a(Set set, int i, int j, int k)
        {
            Eq = set;
            kg = i;
            FO = j;
            FP = k;
        }
    }

    public static final class b extends es
        implements SafeParcelable, com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto
    {

        public static final il CREATOR = new il();
        private static final HashMap Ep;
        private final Set Eq;
        private String iH;
        private final int kg;
        private int v;
        private int w;

        protected Object V(String s)
        {
            return null;
        }

        protected boolean W(String s)
        {
            return false;
        }

        protected boolean a(es.a a1)
        {
            return Eq.contains(Integer.valueOf(a1.cq()));
        }

        protected Object b(es.a a1)
        {
            switch (a1.cq())
            {
            default:
                throw new IllegalStateException((new StringBuilder()).append("Unknown safe parcelable id=").append(a1.cq()).toString());

            case 2: // '\002'
                return Integer.valueOf(v);

            case 3: // '\003'
                return iH;

            case 4: // '\004'
                return Integer.valueOf(w);
            }
        }

        public HashMap cj()
        {
            return Ep;
        }

        public int describeContents()
        {
            il il1 = CREATOR;
            return 0;
        }

        public boolean equals(Object obj)
        {
label0:
            {
                if (!(obj instanceof b))
                {
                    return false;
                }
                if (this == obj)
                {
                    return true;
                }
                obj = (b)obj;
                es.a a1;
label1:
                do
                {
                    for (Iterator iterator = Ep.values().iterator(); iterator.hasNext();)
                    {
                        a1 = (es.a)iterator.next();
                        if (!a(a1))
                        {
                            continue label1;
                        }
                        if (((b) (obj)).a(a1))
                        {
                            if (!b(a1).equals(((b) (obj)).b(a1)))
                            {
                                return false;
                            }
                        } else
                        {
                            return false;
                        }
                    }

                    break label0;
                } while (!((b) (obj)).a(a1));
                return false;
            }
            return true;
        }

        public b fI()
        {
            return this;
        }

        Set fa()
        {
            return Eq;
        }

        public Object freeze()
        {
            return fI();
        }

        public int getHeight()
        {
            return v;
        }

        public String getUrl()
        {
            return iH;
        }

        int getVersionCode()
        {
            return kg;
        }

        public int getWidth()
        {
            return w;
        }

        public boolean hasHeight()
        {
            return Eq.contains(Integer.valueOf(2));
        }

        public boolean hasUrl()
        {
            return Eq.contains(Integer.valueOf(3));
        }

        public boolean hasWidth()
        {
            return Eq.contains(Integer.valueOf(4));
        }

        public int hashCode()
        {
            Iterator iterator = Ep.values().iterator();
            int i = 0;
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                es.a a1 = (es.a)iterator.next();
                if (a(a1))
                {
                    int j = a1.cq();
                    i = b(a1).hashCode() + (i + j);
                }
            } while (true);
            return i;
        }

        public boolean isDataValid()
        {
            return true;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            il il1 = CREATOR;
            il.a(this, parcel, i);
        }

        static 
        {
            Ep = new HashMap();
            Ep.put("height", es.a.d("height", 2));
            Ep.put("url", es.a.g("url", 3));
            Ep.put("width", es.a.d("width", 4));
        }

        public b()
        {
            kg = 1;
            Eq = new HashSet();
        }

        b(Set set, int i, int j, String s, int k)
        {
            Eq = set;
            kg = i;
            v = j;
            iH = s;
            w = k;
        }
    }


    public static final ij CREATOR = new ij();
    private static final HashMap Ep;
    private final Set Eq;
    private a FL;
    private b FM;
    private int FN;
    private final int kg;

    protected Object V(String s)
    {
        return null;
    }

    protected boolean W(String s)
    {
        return false;
    }

    protected boolean a(nit> nit>)
    {
        return Eq.contains(Integer.valueOf(nit>.cq()));
    }

    protected Object b(cq cq)
    {
        switch (cq.cq())
        {
        default:
            throw new IllegalStateException((new StringBuilder()).append("Unknown safe parcelable id=").append(cq.cq()).toString());

        case 2: // '\002'
            return FL;

        case 3: // '\003'
            return FM;

        case 4: // '\004'
            return Integer.valueOf(FN);
        }
    }

    public HashMap cj()
    {
        return Ep;
    }

    public int describeContents()
    {
        ij ij1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
label0:
        {
            if (!(obj instanceof CREATOR))
            {
                return false;
            }
            if (this == obj)
            {
                return true;
            }
            obj = (CREATOR)obj;
            CREATOR creator;
label1:
            do
            {
                for (Iterator iterator = Ep.values().iterator(); iterator.hasNext();)
                {
                    creator = (Ep)iterator.next();
                    if (!a(creator))
                    {
                        continue label1;
                    }
                    if (((a) (obj)).a(creator))
                    {
                        if (!b(creator).equals(((b) (obj)).b(creator)))
                        {
                            return false;
                        }
                    } else
                    {
                        return false;
                    }
                }

                break label0;
            } while (!((b) (obj)).a(creator));
            return false;
        }
        return true;
    }

    a fE()
    {
        return FL;
    }

    b fF()
    {
        return FM;
    }

    public FM fG()
    {
        return this;
    }

    Set fa()
    {
        return Eq;
    }

    public Object freeze()
    {
        return fG();
    }

    public com.google.android.gms.plus.model.people.n.Cover.CoverInfo getCoverInfo()
    {
        return FL;
    }

    public com.google.android.gms.plus.model.people.n.Cover.CoverPhoto getCoverPhoto()
    {
        return FM;
    }

    public int getLayout()
    {
        return FN;
    }

    int getVersionCode()
    {
        return kg;
    }

    public boolean hasCoverInfo()
    {
        return Eq.contains(Integer.valueOf(2));
    }

    public boolean hasCoverPhoto()
    {
        return Eq.contains(Integer.valueOf(3));
    }

    public boolean hasLayout()
    {
        return Eq.contains(Integer.valueOf(4));
    }

    public int hashCode()
    {
        Iterator iterator = Ep.values().iterator();
        int i = 0;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Eq eq = (Ep)iterator.next();
            if (a(eq))
            {
                int j = eq.cq();
                i = b(eq).hashCode() + (i + j);
            }
        } while (true);
        return i;
    }

    public boolean isDataValid()
    {
        return true;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        ij ij1 = CREATOR;
        ij.a(this, parcel, i);
    }

    static 
    {
        Ep = new HashMap();
        Ep.put("coverInfo", a("coverInfo", 2, com/google/android/gms/internal/ig$b$a));
        Ep.put("coverPhoto", a("coverPhoto", 3, com/google/android/gms/internal/ig$b$b));
        Ep.put("layout", a("layout", 4, (new ep()).c("banner", 0), false));
    }

    public b()
    {
        kg = 1;
        Eq = new HashSet();
    }

    b(Set set, int i, a a1, b b1, int j)
    {
        Eq = set;
        kg = i;
        FL = a1;
        FM = b1;
        FN = j;
    }
}
