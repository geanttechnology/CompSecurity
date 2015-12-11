// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.preference;

import android.os.Parcel;
import java.util.ArrayList;

// Referenced classes of package com.ebay.mobile.preference:
//            DcsOverridePreferenceFragment

static final class Q
    implements android.os.ainCollection._cls1
{

    public Q createFromParcel(Parcel parcel)
    {
        int j = parcel.readInt();
        ArrayList arraylist = new ArrayList(j);
        int i = 0;
        do
        {
            if (i >= j)
            {
                break;
            }
            Class class1 = (Class)parcel.readSerializable();
            try
            {
                arraylist.add(class1.newInstance());
            }
            // Misplaced declaration of an exception variable
            catch (Parcel parcel)
            {
                parcel.printStackTrace();
                throw new RuntimeException(parcel);
            }
            i++;
        } while (true);
        return new nit>(arraylist);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public createFromParcel[] newArray(int i)
    {
        return new createFromParcel[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    Q()
    {
    }
}
