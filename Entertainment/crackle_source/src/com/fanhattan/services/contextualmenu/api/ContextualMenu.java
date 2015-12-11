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
//            IContextualMenuElement, ContextualMenuSection

public class ContextualMenu
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ContextualMenu createFromParcel(Parcel parcel)
        {
            return new ContextualMenu(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ContextualMenu[] newArray(int i)
        {
            return new ContextualMenu[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private static final int PARCEL_CURRENT_VERSION = 1;
    private static final int PARCEL_VERSION_1 = 1;
    private final boolean deactivate;
    private final String packageName;
    private final boolean requestDisableSystemItems;
    private final boolean requestHideSystemItems;
    private final Set sections;

    public ContextualMenu(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        sections = new TreeSet(IContextualMenuElement.sIncreasingOrder);
        if (parcel.readInt() == 1)
        {
            packageName = parcel.readString();
            int j;
            boolean flag;
            if (parcel.readByte() == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            deactivate = flag;
            if (parcel.readByte() == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            requestHideSystemItems = flag;
            if (parcel.readByte() == 1)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            requestDisableSystemItems = flag;
            j = parcel.readInt();
            for (int i = 0; i < j; i++)
            {
                ContextualMenuSection contextualmenusection = (ContextualMenuSection)parcel.readParcelable(com/fanhattan/services/contextualmenu/api/ContextualMenuSection.getClassLoader());
                if (contextualmenusection != null)
                {
                    sections.add(contextualmenusection);
                }
            }

        } else
        {
            throw new ParcelFormatException();
        }
    }

    public ContextualMenu(String s)
    {
        this(s, false, false, false);
    }

    public ContextualMenu(String s, boolean flag, boolean flag1, boolean flag2)
    {
        sections = new TreeSet(IContextualMenuElement.sIncreasingOrder);
        if (s == null)
        {
            throw new NullPointerException();
        } else
        {
            packageName = s;
            requestHideSystemItems = flag1;
            requestDisableSystemItems = flag2;
            deactivate = flag;
            return;
        }
    }

    public void add(ContextualMenuSection contextualmenusection)
    {
        sections.add(contextualmenusection);
    }

    public int describeContents()
    {
        return 0;
    }

    public String getPackageName()
    {
        return packageName;
    }

    public boolean isDeactivateRequested()
    {
        return deactivate;
    }

    public boolean isDisableSystemItemsRequested()
    {
        return requestDisableSystemItems;
    }

    public boolean isHideSystemItemsRequested()
    {
        return requestHideSystemItems;
    }

    public Iterator iterator()
    {
        return sections.iterator();
    }

    public void remove(ContextualMenuSection contextualmenusection)
    {
        sections.remove(contextualmenusection);
    }

    public int size()
    {
        return sections.size();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeInt(1);
        parcel.writeString(packageName);
        int j;
        if (deactivate)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeByte((byte)j);
        if (requestHideSystemItems)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeByte((byte)j);
        if (requestDisableSystemItems)
        {
            j = ((flag) ? 1 : 0);
        } else
        {
            j = 0;
        }
        parcel.writeByte((byte)j);
        parcel.writeInt(sections.size());
        for (Iterator iterator1 = sections.iterator(); iterator1.hasNext(); parcel.writeParcelable((ContextualMenuSection)iterator1.next(), i)) { }
    }

}
