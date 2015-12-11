// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.ota;

import android.os.Parcel;
import android.os.Parcelable;
import com.amazon.dcp.framework.Checks;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.dcp.ota:
//            Update

public final class UpdateManifest
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public UpdateManifest createFromParcel(Parcel parcel)
        {
            return UpdateManifest.fromParcel(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public UpdateManifest[] newArray(int i)
        {
            return new UpdateManifest[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private final String mIdentifier;
    private int mPriority;
    private final List mUpdates;

    public UpdateManifest()
    {
        mUpdates = new ArrayList();
        mPriority = 0x7fffffff;
        mIdentifier = null;
    }

    public UpdateManifest(String s)
    {
        mUpdates = new ArrayList();
        mPriority = 0x7fffffff;
        Checks.checkNotNull(s, java/lang/IllegalArgumentException, "identifier may not be null", new Object[0]);
        Checks.checkNotEmpty(s, java/lang/IllegalArgumentException, "identifier may not be empty", new Object[0]);
        mIdentifier = s;
    }

    private static UpdateManifest fromParcel(Parcel parcel)
    {
        int i = parcel.readInt();
        Checks.checkEquals(Integer.valueOf(2), Integer.valueOf(i), java/lang/UnsupportedOperationException, String.format("Expected parcel v%d, but received v%d.", new Object[] {
            Integer.valueOf(2), Integer.valueOf(i)
        }), new Object[0]);
        UpdateManifest updatemanifest = new UpdateManifest(parcel.readString());
        int k = parcel.readInt();
        for (int j = 0; j < k; j++)
        {
            updatemanifest.addUpdate((Update)parcel.readParcelable(com/amazon/dcp/ota/Update.getClassLoader()));
        }

        updatemanifest.setPriority(parcel.readInt());
        return updatemanifest;
    }

    public void addUpdate(Update update)
    {
        Checks.checkTrue(update.isValid(), java/lang/IllegalArgumentException, "Unable to insert invalid update", new Object[0]);
        mUpdates.add(update);
    }

    public int describeContents()
    {
        return 2;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof UpdateManifest))
            {
                return false;
            }
            if (hashCode() != obj.hashCode())
            {
                return false;
            }
            obj = (UpdateManifest)obj;
            if (getPriority() != ((UpdateManifest) (obj)).getPriority() || !getUpdates().equals(((UpdateManifest) (obj)).getUpdates()))
            {
                return false;
            }
        }
        return true;
    }

    public String getIdentifier()
    {
        if (mIdentifier == null)
        {
            return String.valueOf(hashCode());
        } else
        {
            return mIdentifier;
        }
    }

    public int getPriority()
    {
        return mPriority;
    }

    public List getUpdates()
    {
        return Collections.unmodifiableList(mUpdates);
    }

    public int hashCode()
    {
        return (getPriority() + 629) * 37 + getUpdates().hashCode();
    }

    public boolean isValid()
    {
        for (Iterator iterator = mUpdates.iterator(); iterator.hasNext();)
        {
            if (!((Update)iterator.next()).isValid())
            {
                return false;
            }
        }

        return true;
    }

    public void setPriority(int i)
    {
        mPriority = i;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        Checks.checkTrue(isValid(), java/lang/IllegalStateException, "Can not parcel an invalid manifest", new Object[0]);
        parcel.writeInt(2);
        parcel.writeString(getIdentifier());
        Object obj = getUpdates();
        parcel.writeInt(((List) (obj)).size());
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); parcel.writeParcelable((Update)((Iterator) (obj)).next(), 0)) { }
        parcel.writeInt(mPriority);
    }


}
