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
//            hy, kv, hv

public final class adN extends hy
    implements SafeParcelable, com.google.android.gms.plus.model.people.n.Cover
{

    public static final kv CREATOR = new kv();
    private static final HashMap acr;
    private final Set acs;
    private a adL;
    private b adM;
    private int adN;
    private final int xM;

    protected boolean a(ple.n.Cover cover)
    {
        return acs.contains(Integer.valueOf(cover.fN()));
    }

    protected Object aF(String s)
    {
        return null;
    }

    protected boolean aG(String s)
    {
        return false;
    }

    protected Object b(fN fn)
    {
        switch (fn.fN())
        {
        default:
            throw new IllegalStateException((new StringBuilder()).append("Unknown safe parcelable id=").append(fn.fN()).toString());

        case 2: // '\002'
            return adL;

        case 3: // '\003'
            return adM;

        case 4: // '\004'
            return Integer.valueOf(adN);
        }
    }

    public int describeContents()
    {
        kv kv1 = CREATOR;
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
                for (Iterator iterator = acr.values().iterator(); iterator.hasNext();)
                {
                    creator = (acr)iterator.next();
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

    public HashMap fG()
    {
        return acr;
    }

    public Object freeze()
    {
        return kQ();
    }

    public com.google.android.gms.plus.model.people.n.Cover.CoverInfo getCoverInfo()
    {
        return adL;
    }

    public com.google.android.gms.plus.model.people.n.Cover.CoverPhoto getCoverPhoto()
    {
        return adM;
    }

    public int getLayout()
    {
        return adN;
    }

    int getVersionCode()
    {
        return xM;
    }

    public boolean hasCoverInfo()
    {
        return acs.contains(Integer.valueOf(2));
    }

    public boolean hasCoverPhoto()
    {
        return acs.contains(Integer.valueOf(3));
    }

    public boolean hasLayout()
    {
        return acs.contains(Integer.valueOf(4));
    }

    public int hashCode()
    {
        Iterator iterator = acr.values().iterator();
        int i = 0;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            acs acs1 = (acr)iterator.next();
            if (a(acs1))
            {
                int j = acs1.fN();
                i = b(acs1).hashCode() + (i + j);
            }
        } while (true);
        return i;
    }

    public boolean isDataValid()
    {
        return true;
    }

    a kO()
    {
        return adL;
    }

    b kP()
    {
        return adM;
    }

    public adM kQ()
    {
        return this;
    }

    Set kk()
    {
        return acs;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        kv kv1 = CREATOR;
        kv.a(this, parcel, i);
    }

    static 
    {
        acr = new HashMap();
        acr.put("coverInfo", a("coverInfo", 2, com/google/android/gms/internal/ks$b$a));
        acr.put("coverPhoto", a("coverPhoto", 3, com/google/android/gms/internal/ks$b$b));
        acr.put("layout", a("layout", 4, (new hv()).f("banner", 0), false));
    }

    public b()
    {
        xM = 1;
        acs = new HashSet();
    }

    b(Set set, int i, a a1, b b1, int j)
    {
        acs = set;
        xM = i;
        adL = a1;
        adM = b1;
        adN = j;
    }
}
