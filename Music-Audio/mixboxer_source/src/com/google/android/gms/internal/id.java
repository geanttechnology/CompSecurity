// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            es, ie, ib

public final class id extends es
    implements SafeParcelable, Moment
{

    public static final ie CREATOR = new ie();
    private static final HashMap Ep;
    private String AI;
    private final Set Eq;
    private String Fe;
    private ib Fm;
    private ib Fn;
    private final int kg;
    private String uS;

    public id()
    {
        kg = 1;
        Eq = new HashSet();
    }

    id(Set set, int i, String s, ib ib1, String s1, ib ib2, String s2)
    {
        Eq = set;
        kg = i;
        uS = s;
        Fm = ib1;
        Fe = s1;
        Fn = ib2;
        AI = s2;
    }

    public id(Set set, String s, ib ib1, String s1, ib ib2, String s2)
    {
        Eq = set;
        kg = 1;
        uS = s;
        Fm = ib1;
        Fe = s1;
        Fn = ib2;
        AI = s2;
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
        case 3: // '\003'
        default:
            throw new IllegalStateException((new StringBuilder()).append("Unknown safe parcelable id=").append(a1.cq()).toString());

        case 2: // '\002'
            return uS;

        case 4: // '\004'
            return Fm;

        case 5: // '\005'
            return Fe;

        case 6: // '\006'
            return Fn;

        case 7: // '\007'
            return AI;
        }
    }

    public HashMap cj()
    {
        return Ep;
    }

    public int describeContents()
    {
        ie ie1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
label0:
        {
            if (!(obj instanceof id))
            {
                return false;
            }
            if (this == obj)
            {
                return true;
            }
            obj = (id)obj;
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
                    if (((id) (obj)).a(a1))
                    {
                        if (!b(a1).equals(((id) (obj)).b(a1)))
                        {
                            return false;
                        }
                    } else
                    {
                        return false;
                    }
                }

                break label0;
            } while (!((id) (obj)).a(a1));
            return false;
        }
        return true;
    }

    Set fa()
    {
        return Eq;
    }

    ib fr()
    {
        return Fm;
    }

    public Object freeze()
    {
        return ft();
    }

    ib fs()
    {
        return Fn;
    }

    public id ft()
    {
        return this;
    }

    public String getId()
    {
        return uS;
    }

    public ItemScope getResult()
    {
        return Fm;
    }

    public String getStartDate()
    {
        return Fe;
    }

    public ItemScope getTarget()
    {
        return Fn;
    }

    public String getType()
    {
        return AI;
    }

    int getVersionCode()
    {
        return kg;
    }

    public boolean hasId()
    {
        return Eq.contains(Integer.valueOf(2));
    }

    public boolean hasResult()
    {
        return Eq.contains(Integer.valueOf(4));
    }

    public boolean hasStartDate()
    {
        return Eq.contains(Integer.valueOf(5));
    }

    public boolean hasTarget()
    {
        return Eq.contains(Integer.valueOf(6));
    }

    public boolean hasType()
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
        ie ie1 = CREATOR;
        ie.a(this, parcel, i);
    }

    static 
    {
        Ep = new HashMap();
        Ep.put("id", es.a.g("id", 2));
        Ep.put("result", es.a.a("result", 4, com/google/android/gms/internal/ib));
        Ep.put("startDate", es.a.g("startDate", 5));
        Ep.put("target", es.a.a("target", 6, com/google/android/gms/internal/ib));
        Ep.put("type", es.a.g("type", 7));
    }
}
