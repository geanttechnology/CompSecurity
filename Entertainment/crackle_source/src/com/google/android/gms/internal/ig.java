// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.plus.model.people.Person;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            es, ih, ep, ii, 
//            ij, ik, il, im, 
//            in, io, ip, iq

public final class ig extends es
    implements SafeParcelable, Person
{
    public static final class a extends es
        implements SafeParcelable, com.google.android.gms.plus.model.people.Person.AgeRange
    {

        public static final ii CREATOR = new ii();
        private static final HashMap Ep;
        private final Set Eq;
        private int FJ;
        private int FK;
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
                return Integer.valueOf(FJ);

            case 3: // '\003'
                return Integer.valueOf(FK);
            }
        }

        public HashMap cj()
        {
            return Ep;
        }

        public int describeContents()
        {
            ii ii1 = CREATOR;
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

        public a fD()
        {
            return this;
        }

        Set fa()
        {
            return Eq;
        }

        public Object freeze()
        {
            return fD();
        }

        public int getMax()
        {
            return FJ;
        }

        public int getMin()
        {
            return FK;
        }

        int getVersionCode()
        {
            return kg;
        }

        public boolean hasMax()
        {
            return Eq.contains(Integer.valueOf(2));
        }

        public boolean hasMin()
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
            ii ii1 = CREATOR;
            ii.a(this, parcel, i);
        }

        static 
        {
            Ep = new HashMap();
            Ep.put("max", es.a.d("max", 2));
            Ep.put("min", es.a.d("min", 3));
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
            FJ = j;
            FK = k;
        }
    }

    public static final class b extends es
        implements SafeParcelable, com.google.android.gms.plus.model.people.Person.Cover
    {

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

        a fE()
        {
            return FL;
        }

        b fF()
        {
            return FM;
        }

        public b fG()
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

        public com.google.android.gms.plus.model.people.Person.Cover.CoverInfo getCoverInfo()
        {
            return FL;
        }

        public com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto getCoverPhoto()
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
            ij ij1 = CREATOR;
            ij.a(this, parcel, i);
        }

        static 
        {
            Ep = new HashMap();
            Ep.put("coverInfo", es.a.a("coverInfo", 2, com/google/android/gms/internal/ig$b$a));
            Ep.put("coverPhoto", es.a.a("coverPhoto", 3, com/google/android/gms/internal/ig$b$b));
            Ep.put("layout", es.a.a("layout", 4, (new ep()).c("banner", 0), false));
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

    public static final class b.a extends es
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
                if (!(obj instanceof b.a))
                {
                    return false;
                }
                if (this == obj)
                {
                    return true;
                }
                obj = (b.a)obj;
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
                        if (((b.a) (obj)).a(a1))
                        {
                            if (!b(a1).equals(((b.a) (obj)).b(a1)))
                            {
                                return false;
                            }
                        } else
                        {
                            return false;
                        }
                    }

                    break label0;
                } while (!((b.a) (obj)).a(a1));
                return false;
            }
            return true;
        }

        public b.a fH()
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

        public b.a()
        {
            kg = 1;
            Eq = new HashSet();
        }

        b.a(Set set, int i, int j, int k)
        {
            Eq = set;
            kg = i;
            FO = j;
            FP = k;
        }
    }

    public static final class b.b extends es
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
                if (!(obj instanceof b.b))
                {
                    return false;
                }
                if (this == obj)
                {
                    return true;
                }
                obj = (b.b)obj;
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
                        if (((b.b) (obj)).a(a1))
                        {
                            if (!b(a1).equals(((b.b) (obj)).b(a1)))
                            {
                                return false;
                            }
                        } else
                        {
                            return false;
                        }
                    }

                    break label0;
                } while (!((b.b) (obj)).a(a1));
                return false;
            }
            return true;
        }

        public b.b fI()
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

        public b.b()
        {
            kg = 1;
            Eq = new HashSet();
        }

        b.b(Set set, int i, int j, String s, int k)
        {
            Eq = set;
            kg = i;
            v = j;
            iH = s;
            w = k;
        }
    }

    public static final class c extends es
        implements SafeParcelable, com.google.android.gms.plus.model.people.Person.Image
    {

        public static final im CREATOR = new im();
        private static final HashMap Ep;
        private final Set Eq;
        private String iH;
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
                return iH;
            }
        }

        public HashMap cj()
        {
            return Ep;
        }

        public int describeContents()
        {
            im im1 = CREATOR;
            return 0;
        }

        public boolean equals(Object obj)
        {
label0:
            {
                if (!(obj instanceof c))
                {
                    return false;
                }
                if (this == obj)
                {
                    return true;
                }
                obj = (c)obj;
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
                        if (((c) (obj)).a(a1))
                        {
                            if (!b(a1).equals(((c) (obj)).b(a1)))
                            {
                                return false;
                            }
                        } else
                        {
                            return false;
                        }
                    }

                    break label0;
                } while (!((c) (obj)).a(a1));
                return false;
            }
            return true;
        }

        public c fJ()
        {
            return this;
        }

        Set fa()
        {
            return Eq;
        }

        public Object freeze()
        {
            return fJ();
        }

        public String getUrl()
        {
            return iH;
        }

        int getVersionCode()
        {
            return kg;
        }

        public boolean hasUrl()
        {
            return Eq.contains(Integer.valueOf(2));
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
            im im1 = CREATOR;
            im.a(this, parcel, i);
        }

        static 
        {
            Ep = new HashMap();
            Ep.put("url", es.a.g("url", 2));
        }

        public c()
        {
            kg = 1;
            Eq = new HashSet();
        }

        public c(String s)
        {
            Eq = new HashSet();
            kg = 1;
            iH = s;
            Eq.add(Integer.valueOf(2));
        }

        c(Set set, int i, String s)
        {
            Eq = set;
            kg = i;
            iH = s;
        }
    }

    public static final class d extends es
        implements SafeParcelable, com.google.android.gms.plus.model.people.Person.Name
    {

        public static final in CREATOR = new in();
        private static final HashMap Ep;
        private String EP;
        private String ES;
        private final Set Eq;
        private String FQ;
        private String FR;
        private String FS;
        private String FT;
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
                return EP;

            case 3: // '\003'
                return FQ;

            case 4: // '\004'
                return ES;

            case 5: // '\005'
                return FR;

            case 6: // '\006'
                return FS;

            case 7: // '\007'
                return FT;
            }
        }

        public HashMap cj()
        {
            return Ep;
        }

        public int describeContents()
        {
            in in1 = CREATOR;
            return 0;
        }

        public boolean equals(Object obj)
        {
label0:
            {
                if (!(obj instanceof d))
                {
                    return false;
                }
                if (this == obj)
                {
                    return true;
                }
                obj = (d)obj;
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
                        if (((d) (obj)).a(a1))
                        {
                            if (!b(a1).equals(((d) (obj)).b(a1)))
                            {
                                return false;
                            }
                        } else
                        {
                            return false;
                        }
                    }

                    break label0;
                } while (!((d) (obj)).a(a1));
                return false;
            }
            return true;
        }

        public d fK()
        {
            return this;
        }

        Set fa()
        {
            return Eq;
        }

        public Object freeze()
        {
            return fK();
        }

        public String getFamilyName()
        {
            return EP;
        }

        public String getFormatted()
        {
            return FQ;
        }

        public String getGivenName()
        {
            return ES;
        }

        public String getHonorificPrefix()
        {
            return FR;
        }

        public String getHonorificSuffix()
        {
            return FS;
        }

        public String getMiddleName()
        {
            return FT;
        }

        int getVersionCode()
        {
            return kg;
        }

        public boolean hasFamilyName()
        {
            return Eq.contains(Integer.valueOf(2));
        }

        public boolean hasFormatted()
        {
            return Eq.contains(Integer.valueOf(3));
        }

        public boolean hasGivenName()
        {
            return Eq.contains(Integer.valueOf(4));
        }

        public boolean hasHonorificPrefix()
        {
            return Eq.contains(Integer.valueOf(5));
        }

        public boolean hasHonorificSuffix()
        {
            return Eq.contains(Integer.valueOf(6));
        }

        public boolean hasMiddleName()
        {
            return Eq.contains(Integer.valueOf(7));
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
            in in1 = CREATOR;
            in.a(this, parcel, i);
        }

        static 
        {
            Ep = new HashMap();
            Ep.put("familyName", es.a.g("familyName", 2));
            Ep.put("formatted", es.a.g("formatted", 3));
            Ep.put("givenName", es.a.g("givenName", 4));
            Ep.put("honorificPrefix", es.a.g("honorificPrefix", 5));
            Ep.put("honorificSuffix", es.a.g("honorificSuffix", 6));
            Ep.put("middleName", es.a.g("middleName", 7));
        }

        public d()
        {
            kg = 1;
            Eq = new HashSet();
        }

        d(Set set, int i, String s, String s1, String s2, String s3, String s4, 
                String s5)
        {
            Eq = set;
            kg = i;
            EP = s;
            FQ = s1;
            ES = s2;
            FR = s3;
            FS = s4;
            FT = s5;
        }
    }

    public static class e
    {

        public static int aB(String s)
        {
            if (s.equals("person"))
            {
                return 0;
            }
            if (s.equals("page"))
            {
                return 1;
            } else
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Unknown objectType string: ").append(s).toString());
            }
        }
    }

    public static final class f extends es
        implements SafeParcelable, com.google.android.gms.plus.model.people.Person.Organizations
    {

        public static final io CREATOR = new io();
        private static final HashMap Ep;
        private String EO;
        private final Set Eq;
        private String FU;
        private String FV;
        private boolean FW;
        private String Fe;
        private final int kg;
        private String mName;
        private int os;
        private String qL;
        private String sJ;

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
                return FU;

            case 3: // '\003'
                return sJ;

            case 4: // '\004'
                return EO;

            case 5: // '\005'
                return FV;

            case 6: // '\006'
                return mName;

            case 7: // '\007'
                return Boolean.valueOf(FW);

            case 8: // '\b'
                return Fe;

            case 9: // '\t'
                return qL;

            case 10: // '\n'
                return Integer.valueOf(os);
            }
        }

        public HashMap cj()
        {
            return Ep;
        }

        public int describeContents()
        {
            io io1 = CREATOR;
            return 0;
        }

        public boolean equals(Object obj)
        {
label0:
            {
                if (!(obj instanceof f))
                {
                    return false;
                }
                if (this == obj)
                {
                    return true;
                }
                obj = (f)obj;
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
                        if (((f) (obj)).a(a1))
                        {
                            if (!b(a1).equals(((f) (obj)).b(a1)))
                            {
                                return false;
                            }
                        } else
                        {
                            return false;
                        }
                    }

                    break label0;
                } while (!((f) (obj)).a(a1));
                return false;
            }
            return true;
        }

        public f fL()
        {
            return this;
        }

        Set fa()
        {
            return Eq;
        }

        public Object freeze()
        {
            return fL();
        }

        public String getDepartment()
        {
            return FU;
        }

        public String getDescription()
        {
            return sJ;
        }

        public String getEndDate()
        {
            return EO;
        }

        public String getLocation()
        {
            return FV;
        }

        public String getName()
        {
            return mName;
        }

        public String getStartDate()
        {
            return Fe;
        }

        public String getTitle()
        {
            return qL;
        }

        public int getType()
        {
            return os;
        }

        int getVersionCode()
        {
            return kg;
        }

        public boolean hasDepartment()
        {
            return Eq.contains(Integer.valueOf(2));
        }

        public boolean hasDescription()
        {
            return Eq.contains(Integer.valueOf(3));
        }

        public boolean hasEndDate()
        {
            return Eq.contains(Integer.valueOf(4));
        }

        public boolean hasLocation()
        {
            return Eq.contains(Integer.valueOf(5));
        }

        public boolean hasName()
        {
            return Eq.contains(Integer.valueOf(6));
        }

        public boolean hasPrimary()
        {
            return Eq.contains(Integer.valueOf(7));
        }

        public boolean hasStartDate()
        {
            return Eq.contains(Integer.valueOf(8));
        }

        public boolean hasTitle()
        {
            return Eq.contains(Integer.valueOf(9));
        }

        public boolean hasType()
        {
            return Eq.contains(Integer.valueOf(10));
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

        public boolean isPrimary()
        {
            return FW;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            io io1 = CREATOR;
            io.a(this, parcel, i);
        }

        static 
        {
            Ep = new HashMap();
            Ep.put("department", es.a.g("department", 2));
            Ep.put("description", es.a.g("description", 3));
            Ep.put("endDate", es.a.g("endDate", 4));
            Ep.put("location", es.a.g("location", 5));
            Ep.put("name", es.a.g("name", 6));
            Ep.put("primary", es.a.f("primary", 7));
            Ep.put("startDate", es.a.g("startDate", 8));
            Ep.put("title", es.a.g("title", 9));
            Ep.put("type", es.a.a("type", 10, (new ep()).c("work", 0).c("school", 1), false));
        }

        public f()
        {
            kg = 1;
            Eq = new HashSet();
        }

        f(Set set, int i, String s, String s1, String s2, String s3, String s4, 
                boolean flag, String s5, String s6, int j)
        {
            Eq = set;
            kg = i;
            FU = s;
            sJ = s1;
            EO = s2;
            FV = s3;
            mName = s4;
            FW = flag;
            Fe = s5;
            qL = s6;
            os = j;
        }
    }

    public static final class g extends es
        implements SafeParcelable, com.google.android.gms.plus.model.people.Person.PlacesLived
    {

        public static final ip CREATOR = new ip();
        private static final HashMap Ep;
        private final Set Eq;
        private boolean FW;
        private final int kg;
        private String mValue;

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
                return Boolean.valueOf(FW);

            case 3: // '\003'
                return mValue;
            }
        }

        public HashMap cj()
        {
            return Ep;
        }

        public int describeContents()
        {
            ip ip1 = CREATOR;
            return 0;
        }

        public boolean equals(Object obj)
        {
label0:
            {
                if (!(obj instanceof g))
                {
                    return false;
                }
                if (this == obj)
                {
                    return true;
                }
                obj = (g)obj;
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
                        if (((g) (obj)).a(a1))
                        {
                            if (!b(a1).equals(((g) (obj)).b(a1)))
                            {
                                return false;
                            }
                        } else
                        {
                            return false;
                        }
                    }

                    break label0;
                } while (!((g) (obj)).a(a1));
                return false;
            }
            return true;
        }

        public g fM()
        {
            return this;
        }

        Set fa()
        {
            return Eq;
        }

        public Object freeze()
        {
            return fM();
        }

        public String getValue()
        {
            return mValue;
        }

        int getVersionCode()
        {
            return kg;
        }

        public boolean hasPrimary()
        {
            return Eq.contains(Integer.valueOf(2));
        }

        public boolean hasValue()
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

        public boolean isPrimary()
        {
            return FW;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            ip ip1 = CREATOR;
            ip.a(this, parcel, i);
        }

        static 
        {
            Ep = new HashMap();
            Ep.put("primary", es.a.f("primary", 2));
            Ep.put("value", es.a.g("value", 3));
        }

        public g()
        {
            kg = 1;
            Eq = new HashSet();
        }

        g(Set set, int i, boolean flag, String s)
        {
            Eq = set;
            kg = i;
            FW = flag;
            mValue = s;
        }
    }

    public static final class h extends es
        implements SafeParcelable, com.google.android.gms.plus.model.people.Person.Urls
    {

        public static final iq CREATOR = new iq();
        private static final HashMap Ep;
        private final Set Eq;
        private String FX;
        private final int FY;
        private final int kg;
        private String mValue;
        private int os;

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

            case 5: // '\005'
                return FX;

            case 6: // '\006'
                return Integer.valueOf(os);

            case 4: // '\004'
                return mValue;
            }
        }

        public HashMap cj()
        {
            return Ep;
        }

        public int describeContents()
        {
            iq iq1 = CREATOR;
            return 0;
        }

        public boolean equals(Object obj)
        {
label0:
            {
                if (!(obj instanceof h))
                {
                    return false;
                }
                if (this == obj)
                {
                    return true;
                }
                obj = (h)obj;
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
                        if (((h) (obj)).a(a1))
                        {
                            if (!b(a1).equals(((h) (obj)).b(a1)))
                            {
                                return false;
                            }
                        } else
                        {
                            return false;
                        }
                    }

                    break label0;
                } while (!((h) (obj)).a(a1));
                return false;
            }
            return true;
        }

        public int fN()
        {
            return 4;
        }

        public h fO()
        {
            return this;
        }

        Set fa()
        {
            return Eq;
        }

        public Object freeze()
        {
            return fO();
        }

        public String getLabel()
        {
            return FX;
        }

        public int getType()
        {
            return os;
        }

        public String getValue()
        {
            return mValue;
        }

        int getVersionCode()
        {
            return kg;
        }

        public boolean hasLabel()
        {
            return Eq.contains(Integer.valueOf(5));
        }

        public boolean hasType()
        {
            return Eq.contains(Integer.valueOf(6));
        }

        public boolean hasValue()
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
            iq iq1 = CREATOR;
            iq.a(this, parcel, i);
        }

        static 
        {
            Ep = new HashMap();
            Ep.put("label", es.a.g("label", 5));
            Ep.put("type", es.a.a("type", 6, (new ep()).c("home", 0).c("work", 1).c("blog", 2).c("profile", 3).c("other", 4).c("otherProfile", 5).c("contributor", 6).c("website", 7), false));
            Ep.put("value", es.a.g("value", 4));
        }

        public h()
        {
            FY = 4;
            kg = 2;
            Eq = new HashSet();
        }

        h(Set set, int i, String s, int j, String s1, int k)
        {
            FY = 4;
            Eq = set;
            kg = i;
            FX = s;
            os = j;
            mValue = s1;
        }
    }


    public static final ih CREATOR = new ih();
    private static final HashMap Ep;
    private final Set Eq;
    private String FA;
    private int FB;
    private List FC;
    private List FD;
    private int FE;
    private int FF;
    private String FG;
    private List FH;
    private boolean FI;
    private String Fp;
    private a Fq;
    private String Fr;
    private String Fs;
    private int Ft;
    private b Fu;
    private String Fv;
    private c Fw;
    private boolean Fx;
    private String Fy;
    private d Fz;
    private int eL;
    private String iH;
    private final int kg;
    private String qa;
    private String uS;

    public ig()
    {
        kg = 2;
        Eq = new HashSet();
    }

    public ig(String s, String s1, c c1, int i, String s2)
    {
        kg = 2;
        Eq = new HashSet();
        qa = s;
        Eq.add(Integer.valueOf(9));
        uS = s1;
        Eq.add(Integer.valueOf(14));
        Fw = c1;
        Eq.add(Integer.valueOf(15));
        FB = i;
        Eq.add(Integer.valueOf(21));
        iH = s2;
        Eq.add(Integer.valueOf(27));
    }

    ig(Set set, int i, String s, a a1, String s1, String s2, int j, 
            b b1, String s3, String s4, int k, String s5, c c1, boolean flag, 
            String s6, d d1, String s7, int l, List list, List list1, int i1, 
            int j1, String s8, String s9, List list2, boolean flag1)
    {
        Eq = set;
        kg = i;
        Fp = s;
        Fq = a1;
        Fr = s1;
        Fs = s2;
        Ft = j;
        Fu = b1;
        Fv = s3;
        qa = s4;
        eL = k;
        uS = s5;
        Fw = c1;
        Fx = flag;
        Fy = s6;
        Fz = d1;
        FA = s7;
        FB = l;
        FC = list;
        FD = list1;
        FE = i1;
        FF = j1;
        FG = s8;
        iH = s9;
        FH = list2;
        FI = flag1;
    }

    public static ig g(byte abyte0[])
    {
        Parcel parcel = Parcel.obtain();
        parcel.unmarshall(abyte0, 0, abyte0.length);
        parcel.setDataPosition(0);
        abyte0 = CREATOR.au(parcel);
        parcel.recycle();
        return abyte0;
    }

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
        case 10: // '\n'
        case 11: // '\013'
        case 13: // '\r'
        case 17: // '\021'
        default:
            throw new IllegalStateException((new StringBuilder()).append("Unknown safe parcelable id=").append(a1.cq()).toString());

        case 2: // '\002'
            return Fp;

        case 3: // '\003'
            return Fq;

        case 4: // '\004'
            return Fr;

        case 5: // '\005'
            return Fs;

        case 6: // '\006'
            return Integer.valueOf(Ft);

        case 7: // '\007'
            return Fu;

        case 8: // '\b'
            return Fv;

        case 9: // '\t'
            return qa;

        case 12: // '\f'
            return Integer.valueOf(eL);

        case 14: // '\016'
            return uS;

        case 15: // '\017'
            return Fw;

        case 16: // '\020'
            return Boolean.valueOf(Fx);

        case 18: // '\022'
            return Fy;

        case 19: // '\023'
            return Fz;

        case 20: // '\024'
            return FA;

        case 21: // '\025'
            return Integer.valueOf(FB);

        case 22: // '\026'
            return FC;

        case 23: // '\027'
            return FD;

        case 24: // '\030'
            return Integer.valueOf(FE);

        case 25: // '\031'
            return Integer.valueOf(FF);

        case 26: // '\032'
            return FG;

        case 27: // '\033'
            return iH;

        case 28: // '\034'
            return FH;

        case 29: // '\035'
            return Boolean.valueOf(FI);
        }
    }

    public HashMap cj()
    {
        return Ep;
    }

    public int describeContents()
    {
        ih ih1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
label0:
        {
            if (!(obj instanceof ig))
            {
                return false;
            }
            if (this == obj)
            {
                return true;
            }
            obj = (ig)obj;
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
                    if (((ig) (obj)).a(a1))
                    {
                        if (!b(a1).equals(((ig) (obj)).b(a1)))
                        {
                            return false;
                        }
                    } else
                    {
                        return false;
                    }
                }

                break label0;
            } while (!((ig) (obj)).a(a1));
            return false;
        }
        return true;
    }

    List fA()
    {
        return FD;
    }

    List fB()
    {
        return FH;
    }

    public ig fC()
    {
        return this;
    }

    Set fa()
    {
        return Eq;
    }

    public Object freeze()
    {
        return fC();
    }

    a fv()
    {
        return Fq;
    }

    b fw()
    {
        return Fu;
    }

    c fx()
    {
        return Fw;
    }

    d fy()
    {
        return Fz;
    }

    List fz()
    {
        return FC;
    }

    public String getAboutMe()
    {
        return Fp;
    }

    public com.google.android.gms.plus.model.people.Person.AgeRange getAgeRange()
    {
        return Fq;
    }

    public String getBirthday()
    {
        return Fr;
    }

    public String getBraggingRights()
    {
        return Fs;
    }

    public int getCircledByCount()
    {
        return Ft;
    }

    public com.google.android.gms.plus.model.people.Person.Cover getCover()
    {
        return Fu;
    }

    public String getCurrentLocation()
    {
        return Fv;
    }

    public String getDisplayName()
    {
        return qa;
    }

    public int getGender()
    {
        return eL;
    }

    public String getId()
    {
        return uS;
    }

    public com.google.android.gms.plus.model.people.Person.Image getImage()
    {
        return Fw;
    }

    public String getLanguage()
    {
        return Fy;
    }

    public com.google.android.gms.plus.model.people.Person.Name getName()
    {
        return Fz;
    }

    public String getNickname()
    {
        return FA;
    }

    public int getObjectType()
    {
        return FB;
    }

    public List getOrganizations()
    {
        return (ArrayList)FC;
    }

    public List getPlacesLived()
    {
        return (ArrayList)FD;
    }

    public int getPlusOneCount()
    {
        return FE;
    }

    public int getRelationshipStatus()
    {
        return FF;
    }

    public String getTagline()
    {
        return FG;
    }

    public String getUrl()
    {
        return iH;
    }

    public List getUrls()
    {
        return (ArrayList)FH;
    }

    int getVersionCode()
    {
        return kg;
    }

    public boolean hasAboutMe()
    {
        return Eq.contains(Integer.valueOf(2));
    }

    public boolean hasAgeRange()
    {
        return Eq.contains(Integer.valueOf(3));
    }

    public boolean hasBirthday()
    {
        return Eq.contains(Integer.valueOf(4));
    }

    public boolean hasBraggingRights()
    {
        return Eq.contains(Integer.valueOf(5));
    }

    public boolean hasCircledByCount()
    {
        return Eq.contains(Integer.valueOf(6));
    }

    public boolean hasCover()
    {
        return Eq.contains(Integer.valueOf(7));
    }

    public boolean hasCurrentLocation()
    {
        return Eq.contains(Integer.valueOf(8));
    }

    public boolean hasDisplayName()
    {
        return Eq.contains(Integer.valueOf(9));
    }

    public boolean hasGender()
    {
        return Eq.contains(Integer.valueOf(12));
    }

    public boolean hasId()
    {
        return Eq.contains(Integer.valueOf(14));
    }

    public boolean hasImage()
    {
        return Eq.contains(Integer.valueOf(15));
    }

    public boolean hasIsPlusUser()
    {
        return Eq.contains(Integer.valueOf(16));
    }

    public boolean hasLanguage()
    {
        return Eq.contains(Integer.valueOf(18));
    }

    public boolean hasName()
    {
        return Eq.contains(Integer.valueOf(19));
    }

    public boolean hasNickname()
    {
        return Eq.contains(Integer.valueOf(20));
    }

    public boolean hasObjectType()
    {
        return Eq.contains(Integer.valueOf(21));
    }

    public boolean hasOrganizations()
    {
        return Eq.contains(Integer.valueOf(22));
    }

    public boolean hasPlacesLived()
    {
        return Eq.contains(Integer.valueOf(23));
    }

    public boolean hasPlusOneCount()
    {
        return Eq.contains(Integer.valueOf(24));
    }

    public boolean hasRelationshipStatus()
    {
        return Eq.contains(Integer.valueOf(25));
    }

    public boolean hasTagline()
    {
        return Eq.contains(Integer.valueOf(26));
    }

    public boolean hasUrl()
    {
        return Eq.contains(Integer.valueOf(27));
    }

    public boolean hasUrls()
    {
        return Eq.contains(Integer.valueOf(28));
    }

    public boolean hasVerified()
    {
        return Eq.contains(Integer.valueOf(29));
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

    public boolean isPlusUser()
    {
        return Fx;
    }

    public boolean isVerified()
    {
        return FI;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        ih ih1 = CREATOR;
        ih.a(this, parcel, i);
    }

    static 
    {
        Ep = new HashMap();
        Ep.put("aboutMe", es.a.g("aboutMe", 2));
        Ep.put("ageRange", es.a.a("ageRange", 3, com/google/android/gms/internal/ig$a));
        Ep.put("birthday", es.a.g("birthday", 4));
        Ep.put("braggingRights", es.a.g("braggingRights", 5));
        Ep.put("circledByCount", es.a.d("circledByCount", 6));
        Ep.put("cover", es.a.a("cover", 7, com/google/android/gms/internal/ig$b));
        Ep.put("currentLocation", es.a.g("currentLocation", 8));
        Ep.put("displayName", es.a.g("displayName", 9));
        Ep.put("gender", es.a.a("gender", 12, (new ep()).c("male", 0).c("female", 1).c("other", 2), false));
        Ep.put("id", es.a.g("id", 14));
        Ep.put("image", es.a.a("image", 15, com/google/android/gms/internal/ig$c));
        Ep.put("isPlusUser", es.a.f("isPlusUser", 16));
        Ep.put("language", es.a.g("language", 18));
        Ep.put("name", es.a.a("name", 19, com/google/android/gms/internal/ig$d));
        Ep.put("nickname", es.a.g("nickname", 20));
        Ep.put("objectType", es.a.a("objectType", 21, (new ep()).c("person", 0).c("page", 1), false));
        Ep.put("organizations", es.a.b("organizations", 22, com/google/android/gms/internal/ig$f));
        Ep.put("placesLived", es.a.b("placesLived", 23, com/google/android/gms/internal/ig$g));
        Ep.put("plusOneCount", es.a.d("plusOneCount", 24));
        Ep.put("relationshipStatus", es.a.a("relationshipStatus", 25, (new ep()).c("single", 0).c("in_a_relationship", 1).c("engaged", 2).c("married", 3).c("its_complicated", 4).c("open_relationship", 5).c("widowed", 6).c("in_domestic_partnership", 7).c("in_civil_union", 8), false));
        Ep.put("tagline", es.a.g("tagline", 26));
        Ep.put("url", es.a.g("url", 27));
        Ep.put("urls", es.a.b("urls", 28, com/google/android/gms/internal/ig$h));
        Ep.put("verified", es.a.f("verified", 29));
    }
}
