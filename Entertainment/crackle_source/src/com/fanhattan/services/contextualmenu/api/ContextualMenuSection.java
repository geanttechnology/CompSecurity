// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fanhattan.services.contextualmenu.api;

import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

// Referenced classes of package com.fanhattan.services.contextualmenu.api:
//            IContextualMenuElement, ContextualMenuItem

public class ContextualMenuSection
    implements IContextualMenuElement, Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ContextualMenuSection createFromParcel(Parcel parcel)
        {
            return new ContextualMenuSection(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ContextualMenuSection[] newArray(int i)
        {
            return new ContextualMenuSection[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private static final int PARCEL_CURRENT_VERSION = 1;
    private static final int PARCEL_VERSION_1 = 1;
    private final Set items;
    private final int mOrder;
    private final String mSubTitle;
    private final String mTitle;

    public ContextualMenuSection(Parcel parcel)
    {
        items = new TreeSet(IContextualMenuElement.sIncreasingOrder);
        if (parcel.readInt() == 1)
        {
            mTitle = parcel.readString();
            mSubTitle = parcel.readString();
            mOrder = parcel.readInt();
            int j = parcel.readInt();
            for (int i = 0; i < j; i++)
            {
                ContextualMenuItem contextualmenuitem = (ContextualMenuItem)parcel.readParcelable(com/fanhattan/services/contextualmenu/api/ContextualMenuItem.getClassLoader());
                if (contextualmenuitem != null)
                {
                    items.add(contextualmenuitem);
                }
            }

        } else
        {
            throw new ParcelFormatException();
        }
    }

    public ContextualMenuSection(String s)
    {
        this(s, null, -1);
    }

    public ContextualMenuSection(String s, String s1)
    {
        this(s, s1, -1);
    }

    public ContextualMenuSection(String s, String s1, int i)
    {
        items = new TreeSet(IContextualMenuElement.sIncreasingOrder);
        mTitle = s;
        mSubTitle = s1;
        mOrder = i;
    }

    public void add(ContextualMenuItem contextualmenuitem)
    {
        items.add(contextualmenuitem);
    }

    public int describeContents()
    {
        return 0;
    }

    public int getOrder()
    {
        return mOrder;
    }

    public String getSubtitle()
    {
        return mSubTitle;
    }

    public String getTitle()
    {
        return mTitle;
    }

    public Iterator iterator()
    {
        return items.iterator();
    }

    public void remove(ContextualMenuItem contextualmenuitem)
    {
        items.remove(contextualmenuitem);
    }

    public int size()
    {
        return items.size();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(1);
        parcel.writeString(mTitle);
        parcel.writeString(mSubTitle);
        parcel.writeInt(mOrder);
        parcel.writeInt(items.size());
        for (Iterator iterator1 = items.iterator(); iterator1.hasNext(); parcel.writeParcelable((ContextualMenuItem)iterator1.next(), i)) { }
    }

}
