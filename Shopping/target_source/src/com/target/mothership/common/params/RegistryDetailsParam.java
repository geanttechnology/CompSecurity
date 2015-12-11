// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.params;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.a.a.e;
import com.target.mothership.common.registries.RegistryId;
import com.target.mothership.common.registries.b;
import com.target.mothership.common.registries.c;
import com.target.mothership.common.registries.h;
import com.target.mothership.model.registries.interfaces.Registry;
import com.target.mothership.model.store.interfaces.Store;

// Referenced classes of package com.target.mothership.common.params:
//            a

public class RegistryDetailsParam extends a
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public RegistryDetailsParam a(Parcel parcel)
        {
            return new RegistryDetailsParam(parcel);
        }

        public RegistryDetailsParam[] a(int i)
        {
            return new RegistryDetailsParam[i];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int i)
        {
            return a(i);
        }

    };
    private static final int DEFAULT_LIMIT = 20;
    private static final int DEFAULT_OFFSET = 0;
    private b mChannel;
    private int mCurrentPage;
    private c mEventType;
    private boolean mIncludeItems;
    private int mLimit;
    private int mOffset;
    private Registry mRegistry;
    private RegistryId mRegistryId;
    private Store mStore;
    private h mSubChannel;

    protected RegistryDetailsParam(Parcel parcel)
    {
        Object obj1 = null;
        super();
        mStore = (Store)parcel.readParcelable(com/target/mothership/model/store/interfaces/Store.getClassLoader());
        mRegistry = (Registry)parcel.readParcelable(com/target/mothership/model/registries/interfaces/Registry.getClassLoader());
        mRegistryId = (RegistryId)parcel.readParcelable(com/target/mothership/common/registries/RegistryId.getClassLoader());
        int i = parcel.readInt();
        Object obj;
        boolean flag;
        if (i == -1)
        {
            obj = null;
        } else
        {
            obj = com.target.mothership.common.registries.b.values()[i];
        }
        mChannel = ((b) (obj));
        i = parcel.readInt();
        if (i == -1)
        {
            obj = null;
        } else
        {
            obj = com.target.mothership.common.registries.c.values()[i];
        }
        mEventType = ((c) (obj));
        i = parcel.readInt();
        if (i == -1)
        {
            obj = obj1;
        } else
        {
            obj = com.target.mothership.common.registries.h.values()[i];
        }
        mSubChannel = ((h) (obj));
        mLimit = parcel.readInt();
        mOffset = parcel.readInt();
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIncludeItems = flag;
    }

    public RegistryDetailsParam(RegistryId registryid, Store store)
    {
        mStore = store;
        mRegistryId = registryid;
        h();
    }

    public RegistryDetailsParam(Registry registry, Store store)
    {
        mStore = store;
        mRegistry = registry;
        mRegistryId = registry.b();
        h();
    }

    private void h()
    {
        mChannel = b.MOBILE;
        mSubChannel = h.ANDROID;
        mEventType = c.TARGET_LIST;
        mIncludeItems = false;
        mLimit = 20;
        mOffset = 0;
    }

    public e a()
    {
        return com.google.a.a.e.c(mStore);
    }

    public void a(int i)
    {
        mCurrentPage = i;
        mOffset = mLimit * i;
    }

    public RegistryId b()
    {
        return mRegistryId;
    }

    public final b c()
    {
        return mChannel;
    }

    public final h d()
    {
        return mSubChannel;
    }

    public int describeContents()
    {
        return 0;
    }

    public int e()
    {
        return mLimit;
    }

    public int f()
    {
        return mOffset;
    }

    public String g()
    {
        if (mIncludeItems)
        {
            return "true";
        } else
        {
            return "false";
        }
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        byte byte1 = -1;
        parcel.writeParcelable(mStore, 0);
        parcel.writeParcelable(mRegistry, 0);
        parcel.writeParcelable(mRegistryId, 0);
        byte byte0;
        if (mChannel == null)
        {
            i = -1;
        } else
        {
            i = mChannel.ordinal();
        }
        parcel.writeInt(i);
        if (mEventType == null)
        {
            i = -1;
        } else
        {
            i = mEventType.ordinal();
        }
        parcel.writeInt(i);
        if (mSubChannel == null)
        {
            i = byte1;
        } else
        {
            i = mSubChannel.ordinal();
        }
        parcel.writeInt(i);
        parcel.writeInt(mLimit);
        parcel.writeInt(mOffset);
        if (mIncludeItems)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
    }

}
