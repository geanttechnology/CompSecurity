// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import amazon.communication.connection.Priority;
import android.os.Parcel;
import android.os.Parcelable;
import com.dp.utils.FailFast;

// Referenced classes of package com.amazon.communication:
//            SimpleConnectionPolicy

public class ParcelableConnectionPolicy extends SimpleConnectionPolicy
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ParcelableConnectionPolicy createFromParcel(Parcel parcel)
        {
            ParcelableConnectionPolicy parcelableconnectionpolicy = new ParcelableConnectionPolicy();
            int i;
            boolean flag;
            if (parcel.readByte() != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            parcelableconnectionpolicy.setIsRoamingAllowed(flag);
            if (parcel.readByte() != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            parcelableconnectionpolicy.setIsShortLived(flag);
            if (parcel.readByte() != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            parcelableconnectionpolicy.setIsLowLatencyNecessary(flag);
            if (parcel.readByte() != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            parcelableconnectionpolicy.setIsRequestResponseOnly(flag);
            i = parcel.readInt();
            if (i == amazon.communication.connection.ConnectionPolicy.CompressionOption.ALLOWED.ordinal())
            {
                parcelableconnectionpolicy.setCompressionOption(amazon.communication.connection.ConnectionPolicy.CompressionOption.ALLOWED);
            } else
            if (i == amazon.communication.connection.ConnectionPolicy.CompressionOption.NOT_ALLOWED.ordinal())
            {
                parcelableconnectionpolicy.setCompressionOption(amazon.communication.connection.ConnectionPolicy.CompressionOption.NOT_ALLOWED);
            } else
            if (i == amazon.communication.connection.ConnectionPolicy.CompressionOption.REQUIRED.ordinal())
            {
                parcelableconnectionpolicy.setCompressionOption(amazon.communication.connection.ConnectionPolicy.CompressionOption.REQUIRED);
            } else
            {
                FailFast.expectTrue(false, new Object[] {
                    "Unknown ordinal value for CompressionOption ", Integer.valueOf(i)
                });
            }
            if (parcel.readByte() != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            parcelableconnectionpolicy.setIsClearText(flag);
            if (parcel.readByte() != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            parcelableconnectionpolicy.setIsWiFiNecessary(flag);
            if (parcel.readByte() != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            parcelableconnectionpolicy.setIsInstanceLocked(flag);
            i = parcel.readInt();
            if (i == Priority.PRIORITY_HIGH.ordinal())
            {
                parcelableconnectionpolicy.setPriority(Priority.PRIORITY_HIGH);
                return parcelableconnectionpolicy;
            }
            if (i == Priority.PRIORITY_NORMAL.ordinal())
            {
                parcelableconnectionpolicy.setPriority(Priority.PRIORITY_NORMAL);
                return parcelableconnectionpolicy;
            }
            if (i == Priority.PRIORITY_LOW.ordinal())
            {
                parcelableconnectionpolicy.setPriority(Priority.PRIORITY_LOW);
                return parcelableconnectionpolicy;
            } else
            {
                FailFast.expectTrue(false, new Object[] {
                    "Unknown ordinal value for Priority ", Integer.valueOf(i)
                });
                return parcelableconnectionpolicy;
            }
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ParcelableConnectionPolicy[] newArray(int i)
        {
            return new ParcelableConnectionPolicy[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };

    public ParcelableConnectionPolicy()
    {
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        if (mIsRoamingAllowed)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        if (mIsShortLived)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        if (mIsLowLatencyNecessary)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        if (mIsRequestResponseOnly)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        parcel.writeInt(mCompressionOption.ordinal());
        if (mIsClearText)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        if (mIsWiFiNecessary)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        if (mIsInstanceLocked)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        parcel.writeInt(mPriority.ordinal());
    }

}
