// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.beacon;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package org.altbeacon.beacon:
//            Identifier, Beacon

public class Region
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    private static final String TAG = "Region";
    protected final List mIdentifiers;
    protected final String mUniqueId;

    protected Region(Parcel parcel)
    {
        mUniqueId = parcel.readString();
        int j = parcel.readInt();
        mIdentifiers = new ArrayList(j);
        int i = 0;
        while (i < j) 
        {
            Object obj = parcel.readString();
            if (obj == null)
            {
                mIdentifiers.add(null);
            } else
            {
                obj = Identifier.parse(((String) (obj)));
                mIdentifiers.add(obj);
            }
            i++;
        }
    }

    public Region(String s, List list)
    {
        mIdentifiers = new ArrayList(list);
        mUniqueId = s;
        if (s == null)
        {
            throw new NullPointerException("uniqueId may not be null");
        } else
        {
            return;
        }
    }

    public Region(String s, Identifier identifier, Identifier identifier1, Identifier identifier2)
    {
        mIdentifiers = new ArrayList(3);
        mIdentifiers.add(identifier);
        mIdentifiers.add(identifier1);
        mIdentifiers.add(identifier2);
        mUniqueId = s;
        if (s == null)
        {
            throw new NullPointerException("uniqueId may not be null");
        } else
        {
            return;
        }
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public Region clone()
    {
        return new Region(mUniqueId, mIdentifiers);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof Region)
        {
            return ((Region)obj).mUniqueId.equals(mUniqueId);
        } else
        {
            return false;
        }
    }

    public Identifier getId1()
    {
        return getIdentifier(0);
    }

    public Identifier getId2()
    {
        return getIdentifier(1);
    }

    public Identifier getId3()
    {
        return getIdentifier(2);
    }

    public Identifier getIdentifier(int i)
    {
        if (mIdentifiers.size() > i)
        {
            return (Identifier)mIdentifiers.get(i);
        } else
        {
            return null;
        }
    }

    public String getUniqueId()
    {
        return mUniqueId;
    }

    public int hashCode()
    {
        return mUniqueId.hashCode();
    }

    public boolean matchesBeacon(Beacon beacon)
    {
        int i = 0;
_L3:
        if (i >= mIdentifiers.size())
        {
            break; /* Loop/switch isn't completed */
        }
          goto _L1
_L5:
        i++;
        if (true) goto _L3; else goto _L2
_L1:
        if (beacon.getIdentifiers().size() <= i && mIdentifiers.get(i) == null || mIdentifiers.get(i) == null || ((Identifier)mIdentifiers.get(i)).equals(beacon.mIdentifiers.get(i))) goto _L5; else goto _L4
_L4:
        return false;
_L2:
        return true;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        int i = 1;
        Iterator iterator = mIdentifiers.iterator();
        while (iterator.hasNext()) 
        {
            Object obj = (Identifier)iterator.next();
            if (i > 1)
            {
                stringbuilder.append(" ");
            }
            stringbuilder.append("id");
            stringbuilder.append(i);
            stringbuilder.append(": ");
            if (obj == null)
            {
                obj = "null";
            } else
            {
                obj = ((Identifier) (obj)).toString();
            }
            stringbuilder.append(((String) (obj)));
            i++;
        }
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mUniqueId);
        parcel.writeInt(mIdentifiers.size());
        for (Iterator iterator = mIdentifiers.iterator(); iterator.hasNext();)
        {
            Identifier identifier = (Identifier)iterator.next();
            if (identifier != null)
            {
                parcel.writeString(identifier.toString());
            } else
            {
                parcel.writeString(null);
            }
        }

    }


    /* member class not found */
    class _cls1 {}

}
