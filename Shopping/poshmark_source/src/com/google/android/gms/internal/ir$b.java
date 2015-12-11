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
//            fb, ir, iu, ey, 
//            iv, iw

public static final class Ti extends fb
    implements SafeParcelable, com.google.android.gms.plus.model.people.n.Cover
{
    public static final class a extends fb
        implements SafeParcelable, com.google.android.gms.plus.model.people.Person.Cover.CoverInfo
    {

        public static final iv CREATOR = new iv();
        private static final HashMap RL;
        private final Set RM;
        private int Tj;
        private int Tk;
        private final int wj;

        protected boolean a(fb.a a1)
        {
            return RM.contains(Integer.valueOf(a1.eu()));
        }

        protected Object ak(String s)
        {
            return null;
        }

        protected boolean al(String s)
        {
            return false;
        }

        protected Object b(fb.a a1)
        {
            switch (a1.eu())
            {
            default:
                throw new IllegalStateException((new StringBuilder()).append("Unknown safe parcelable id=").append(a1.eu()).toString());

            case 2: // '\002'
                return Integer.valueOf(Tj);

            case 3: // '\003'
                return Integer.valueOf(Tk);
            }
        }

        public int describeContents()
        {
            iv iv1 = CREATOR;
            return 0;
        }

        public HashMap en()
        {
            return RL;
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
                fb.a a1;
label1:
                do
                {
                    for (Iterator iterator = RL.values().iterator(); iterator.hasNext();)
                    {
                        a1 = (fb.a)iterator.next();
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

        public Object freeze()
        {
            return ii();
        }

        public int getLeftImageOffset()
        {
            return Tj;
        }

        public int getTopImageOffset()
        {
            return Tk;
        }

        int getVersionCode()
        {
            return wj;
        }

        Set hB()
        {
            return RM;
        }

        public boolean hasLeftImageOffset()
        {
            return RM.contains(Integer.valueOf(2));
        }

        public boolean hasTopImageOffset()
        {
            return RM.contains(Integer.valueOf(3));
        }

        public int hashCode()
        {
            Iterator iterator = RL.values().iterator();
            int i = 0;
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                fb.a a1 = (fb.a)iterator.next();
                if (a(a1))
                {
                    int j = a1.eu();
                    i = b(a1).hashCode() + (i + j);
                }
            } while (true);
            return i;
        }

        public a ii()
        {
            return this;
        }

        public boolean isDataValid()
        {
            return true;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            iv iv1 = CREATOR;
            iv.a(this, parcel, i);
        }

        static 
        {
            RL = new HashMap();
            RL.put("leftImageOffset", fb.a.g("leftImageOffset", 2));
            RL.put("topImageOffset", fb.a.g("topImageOffset", 3));
        }

        public a()
        {
            wj = 1;
            RM = new HashSet();
        }

        a(Set set, int i, int j, int k)
        {
            RM = set;
            wj = i;
            Tj = j;
            Tk = k;
        }
    }

    public static final class b extends fb
        implements SafeParcelable, com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto
    {

        public static final iw CREATOR = new iw();
        private static final HashMap RL;
        private final Set RM;
        private String pS;
        private int v;
        private int w;
        private final int wj;

        protected boolean a(fb.a a1)
        {
            return RM.contains(Integer.valueOf(a1.eu()));
        }

        protected Object ak(String s)
        {
            return null;
        }

        protected boolean al(String s)
        {
            return false;
        }

        protected Object b(fb.a a1)
        {
            switch (a1.eu())
            {
            default:
                throw new IllegalStateException((new StringBuilder()).append("Unknown safe parcelable id=").append(a1.eu()).toString());

            case 2: // '\002'
                return Integer.valueOf(v);

            case 3: // '\003'
                return pS;

            case 4: // '\004'
                return Integer.valueOf(w);
            }
        }

        public int describeContents()
        {
            iw iw1 = CREATOR;
            return 0;
        }

        public HashMap en()
        {
            return RL;
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
                fb.a a1;
label1:
                do
                {
                    for (Iterator iterator = RL.values().iterator(); iterator.hasNext();)
                    {
                        a1 = (fb.a)iterator.next();
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

        public Object freeze()
        {
            return ij();
        }

        public int getHeight()
        {
            return v;
        }

        public String getUrl()
        {
            return pS;
        }

        int getVersionCode()
        {
            return wj;
        }

        public int getWidth()
        {
            return w;
        }

        Set hB()
        {
            return RM;
        }

        public boolean hasHeight()
        {
            return RM.contains(Integer.valueOf(2));
        }

        public boolean hasUrl()
        {
            return RM.contains(Integer.valueOf(3));
        }

        public boolean hasWidth()
        {
            return RM.contains(Integer.valueOf(4));
        }

        public int hashCode()
        {
            Iterator iterator = RL.values().iterator();
            int i = 0;
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                fb.a a1 = (fb.a)iterator.next();
                if (a(a1))
                {
                    int j = a1.eu();
                    i = b(a1).hashCode() + (i + j);
                }
            } while (true);
            return i;
        }

        public b ij()
        {
            return this;
        }

        public boolean isDataValid()
        {
            return true;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            iw iw1 = CREATOR;
            iw.a(this, parcel, i);
        }

        static 
        {
            RL = new HashMap();
            RL.put("height", fb.a.g("height", 2));
            RL.put("url", fb.a.j("url", 3));
            RL.put("width", fb.a.g("width", 4));
        }

        public b()
        {
            wj = 1;
            RM = new HashSet();
        }

        b(Set set, int i, int j, String s, int k)
        {
            RM = set;
            wj = i;
            v = j;
            pS = s;
            w = k;
        }
    }


    public static final iu CREATOR = new iu();
    private static final HashMap RL;
    private final Set RM;
    private a Tg;
    private b Th;
    private int Ti;
    private final int wj;

    protected boolean a(nit> nit>)
    {
        return RM.contains(Integer.valueOf(nit>.eu()));
    }

    protected Object ak(String s)
    {
        return null;
    }

    protected boolean al(String s)
    {
        return false;
    }

    protected Object b(eu eu)
    {
        switch (eu.eu())
        {
        default:
            throw new IllegalStateException((new StringBuilder()).append("Unknown safe parcelable id=").append(eu.eu()).toString());

        case 2: // '\002'
            return Tg;

        case 3: // '\003'
            return Th;

        case 4: // '\004'
            return Integer.valueOf(Ti);
        }
    }

    public int describeContents()
    {
        iu iu1 = CREATOR;
        return 0;
    }

    public HashMap en()
    {
        return RL;
    }

    public boolean equals(Object obj)
    {
label0:
        {
            if (!(obj instanceof RL))
            {
                return false;
            }
            if (this == obj)
            {
                return true;
            }
            obj = (RL)obj;
            RL rl;
label1:
            do
            {
                for (Iterator iterator = RL.values().iterator(); iterator.hasNext();)
                {
                    rl = (RL)iterator.next();
                    if (!a(rl))
                    {
                        continue label1;
                    }
                    if (((a) (obj)).a(rl))
                    {
                        if (!b(rl).equals(((b) (obj)).b(rl)))
                        {
                            return false;
                        }
                    } else
                    {
                        return false;
                    }
                }

                break label0;
            } while (!((b) (obj)).a(rl));
            return false;
        }
        return true;
    }

    public Object freeze()
    {
        return ih();
    }

    public com.google.android.gms.plus.model.people.n.Cover.CoverInfo getCoverInfo()
    {
        return Tg;
    }

    public com.google.android.gms.plus.model.people.n.Cover.CoverPhoto getCoverPhoto()
    {
        return Th;
    }

    public int getLayout()
    {
        return Ti;
    }

    int getVersionCode()
    {
        return wj;
    }

    Set hB()
    {
        return RM;
    }

    public boolean hasCoverInfo()
    {
        return RM.contains(Integer.valueOf(2));
    }

    public boolean hasCoverPhoto()
    {
        return RM.contains(Integer.valueOf(3));
    }

    public boolean hasLayout()
    {
        return RM.contains(Integer.valueOf(4));
    }

    public int hashCode()
    {
        Iterator iterator = RL.values().iterator();
        int i = 0;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            RM rm = (RL)iterator.next();
            if (a(rm))
            {
                int j = rm.eu();
                i = b(rm).hashCode() + (i + j);
            }
        } while (true);
        return i;
    }

    a _mthif()
    {
        return Tg;
    }

    b ig()
    {
        return Th;
    }

    public Th ih()
    {
        return this;
    }

    public boolean isDataValid()
    {
        return true;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        iu iu1 = CREATOR;
        iu.a(this, parcel, i);
    }

    static 
    {
        RL = new HashMap();
        RL.put("coverInfo", a("coverInfo", 2, com/google/android/gms/internal/ir$b$a));
        RL.put("coverPhoto", a("coverPhoto", 3, com/google/android/gms/internal/ir$b$b));
        RL.put("layout", a("layout", 4, (new ey()).f("banner", 0), false));
    }

    public b()
    {
        wj = 1;
        RM = new HashSet();
    }

    b(Set set, int i, a a1, b b1, int j)
    {
        RM = set;
        wj = i;
        Tg = a1;
        Th = b1;
        Ti = j;
    }
}
