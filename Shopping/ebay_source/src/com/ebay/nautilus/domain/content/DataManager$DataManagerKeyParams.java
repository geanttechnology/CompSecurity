// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content;

import android.os.Parcel;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.nautilus.domain.content:
//            DataManager

public static abstract class 
{

    public static final int PRIME = 31;

    public abstract DataManager createManager(EbayContext ebaycontext);

    public int describeContents()
    {
        return 0;
    }

    public int hashCode()
    {
        return getClass().getName().hashCode();
    }

    public String toString()
    {
        return "";
    }

    public void writeToParcel(Parcel parcel, int i)
    {
    }

    public ()
    {
    }
}
