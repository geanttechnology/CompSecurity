// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import android.view.View;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            ef

public final class dt
{
    public static final class a
        implements SafeParcelable
    {

        public static final ef CREATOR = new ef();
        private final String jG;
        private final int kg;
        private final int nt;
        private final String nv;
        private final List oY;

        public String bF()
        {
            if (jG != null)
            {
                return jG;
            } else
            {
                return "<<default account>>";
            }
        }

        public int bG()
        {
            return nt;
        }

        public List bH()
        {
            return new ArrayList(oY);
        }

        public String bJ()
        {
            return nv;
        }

        public int describeContents()
        {
            return 0;
        }

        public String getAccountName()
        {
            return jG;
        }

        public int getVersionCode()
        {
            return kg;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            ef.a(this, parcel, i);
        }


        a(int i, String s, List list, int j, String s1)
        {
            oY = new ArrayList();
            kg = i;
            jG = s;
            oY.addAll(list);
            nt = j;
            nv = s1;
        }

        public a(String s, Collection collection, int i, String s1)
        {
            this(3, s, ((List) (new ArrayList(collection))), i, s1);
        }
    }


    private final View nu;
    private final a oX;

    public dt(String s, Collection collection, int i, View view, String s1)
    {
        oX = new a(s, collection, i, s1);
        nu = view;
    }

    public String bF()
    {
        return oX.bF();
    }

    public int bG()
    {
        return oX.bG();
    }

    public List bH()
    {
        return oX.bH();
    }

    public String[] bI()
    {
        return (String[])oX.bH().toArray(new String[0]);
    }

    public String bJ()
    {
        return oX.bJ();
    }

    public View bK()
    {
        return nu;
    }

    public String getAccountName()
    {
        return oX.getAccountName();
    }
}
