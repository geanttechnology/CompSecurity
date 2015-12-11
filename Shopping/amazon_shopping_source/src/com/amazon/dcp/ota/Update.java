// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.ota;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.amazon.dcp.framework.Checks;
import com.amazon.dcp.framework.StringUtils;

// Referenced classes of package com.amazon.dcp.ota:
//            NetworkType, UpdateState, OTAFailure, UpdateType

public final class Update
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Update createFromParcel(Parcel parcel)
        {
            return Update.fromParcel(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Update[] newArray(int i)
        {
            return new Update[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private OTAFailure mFailure;
    private boolean mForceInstall;
    private Integer mInstallOrder;
    private long mInstallSchedulerStartTimeMillis;
    private Uri mLocalUri;
    private NetworkType mNetworkType;
    private String mPackageName;
    private Integer mPackageVersionCode;
    private String mPackageVersionName;
    private long mRemoteFileSize;
    private Uri mRemoteUri;
    private UpdateState mState;
    private final UpdateType mType;

    public Update(UpdateType updatetype)
    {
        mForceInstall = false;
        mNetworkType = NetworkType.LAN;
        mState = UpdateState.Pending;
        mFailure = OTAFailure.None;
        mLocalUri = null;
        mRemoteFileSize = 0L;
        mInstallSchedulerStartTimeMillis = -1L;
        Checks.checkNotEquals(UpdateType.Unknown, updatetype, java/lang/IllegalArgumentException, "Unknown is not an acceptable update type", new Object[0]);
        mType = updatetype;
    }

    private static Update fromParcel(Parcel parcel)
    {
        int i = parcel.readInt();
        Checks.checkEquals(Integer.valueOf(4), Integer.valueOf(i), java/lang/UnsupportedOperationException, String.format("Expected parcel v%d, but received v%d.", new Object[] {
            Integer.valueOf(4), Integer.valueOf(i)
        }), new Object[0]);
        Update update = new Update((UpdateType)parcel.readParcelable(com/amazon/dcp/ota/UpdateType.getClassLoader()));
        update.setState((UpdateState)parcel.readParcelable(com/amazon/dcp/ota/UpdateState.getClassLoader()));
        update.setFailureReason((OTAFailure)parcel.readParcelable(com/amazon/dcp/ota/OTAFailure.getClassLoader()));
        update.setInstallOrder(parcel.readInt());
        update.setPackageName(parcel.readString());
        update.setPackageVersionCode(parcel.readInt());
        update.setPackageVersionName(parcel.readString());
        update.setRemoteUri((Uri)parcel.readParcelable(android/net/Uri.getClassLoader()));
        update.setRemoteFileSize(parcel.readLong());
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        update.setForceInstall(flag);
        update.setNetworkType((NetworkType)parcel.readParcelable(com/amazon/dcp/ota/NetworkType.getClassLoader()));
        update.setInstallSchedulerStartTime(parcel.readLong());
        return update;
    }

    private transient boolean isAnyObjectNull(Object aobj[])
    {
        int j = aobj.length;
        for (int i = 0; i < j; i++)
        {
            if (aobj[i] == null)
            {
                return true;
            }
        }

        return false;
    }

    public int describeContents()
    {
        return 4;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof Update))
            {
                return false;
            }
            if (hashCode() != obj.hashCode())
            {
                return false;
            }
            obj = (Update)obj;
            if (getUpdateType() != ((Update) (obj)).getUpdateType() || getInstallOrder() != ((Update) (obj)).getInstallOrder() || !getPackageName().equals(((Update) (obj)).getPackageName()) || getPackageVersionCode() != ((Update) (obj)).getPackageVersionCode() || !getPackageVersionName().equals(((Update) (obj)).getPackageVersionName()) || !getRemoteUri().equals(((Update) (obj)).getRemoteUri()) || getForceInstall() != ((Update) (obj)).getForceInstall() || getNetworkType() != ((Update) (obj)).getNetworkType())
            {
                return false;
            }
        }
        return true;
    }

    public OTAFailure getFailureReason()
    {
        return mFailure;
    }

    public boolean getForceInstall()
    {
        return mForceInstall;
    }

    public int getInstallOrder()
    {
        Checks.checkNotNull(mInstallOrder, java/lang/IllegalStateException, "The install order has not been set", new Object[0]);
        return mInstallOrder.intValue();
    }

    public long getInstallSchedulerStartTime()
    {
        return mInstallSchedulerStartTimeMillis;
    }

    public NetworkType getNetworkType()
    {
        return mNetworkType;
    }

    public String getPackageName()
    {
        Checks.checkNotNull(mPackageName, java/lang/IllegalStateException, "The package name has not been set", new Object[0]);
        return mPackageName;
    }

    public int getPackageVersionCode()
    {
        Checks.checkNotNull(mPackageVersionCode, java/lang/IllegalStateException, "The version code has not been set", new Object[0]);
        return mPackageVersionCode.intValue();
    }

    public String getPackageVersionName()
    {
        Checks.checkNotNull(mPackageVersionName, java/lang/IllegalStateException, "The version code has not been set", new Object[0]);
        return mPackageVersionName;
    }

    public long getRemoteFileSize()
    {
        return mRemoteFileSize;
    }

    public Uri getRemoteUri()
    {
        Checks.checkNotNull(mRemoteUri, java/lang/IllegalStateException, "The remote uri has not been set", new Object[0]);
        return mRemoteUri;
    }

    public UpdateState getState()
    {
        return mState;
    }

    public UpdateType getUpdateType()
    {
        return mType;
    }

    public int hashCode()
    {
        if (!isValid())
        {
            return super.hashCode();
        } else
        {
            return (((((((getUpdateType().hashCode() + 943) * 41 + getInstallOrder()) * 41 + getPackageName().hashCode()) * 41 + getPackageVersionCode()) * 41 + getPackageVersionName().hashCode()) * 41 + getRemoteUri().hashCode()) * 41 + Boolean.valueOf(getForceInstall()).hashCode()) * 41 + getNetworkType().hashCode();
        }
    }

    public boolean isValid()
    {
        return !isAnyObjectNull(new Object[] {
            mType, mInstallOrder, mPackageName, mPackageVersionCode, mPackageVersionName, mRemoteUri
        });
    }

    public void setFailureReason(OTAFailure otafailure)
    {
        mFailure = otafailure;
    }

    public void setForceInstall(boolean flag)
    {
        mForceInstall = flag;
    }

    public void setInstallOrder(int i)
    {
        boolean flag;
        if (i < 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Checks.checkFalse(flag, java/lang/IllegalArgumentException, "The install order must be a positive integer", new Object[0]);
        mInstallOrder = Integer.valueOf(i);
    }

    public void setInstallSchedulerStartTime(long l)
    {
        mInstallSchedulerStartTimeMillis = l;
    }

    public void setLocalUri(Uri uri)
    {
        mLocalUri = uri;
    }

    public void setNetworkType(NetworkType networktype)
    {
        Checks.checkNotNull(networktype, java/lang/IllegalArgumentException, "The networkType may not be null", new Object[0]);
        Checks.checkNotEquals(NetworkType.Unknown, networktype, java/lang/IllegalArgumentException, "The networkType may not be Unknown", new Object[0]);
        mNetworkType = networktype;
    }

    public void setPackageName(String s)
    {
        Checks.checkNotNull(s, java/lang/IllegalArgumentException, "The package name may not be null", new Object[0]);
        Checks.checkNotEmpty(s, java/lang/IllegalArgumentException, "The package name may not empty", new Object[0]);
        mPackageName = s;
    }

    public void setPackageVersionCode(int i)
    {
        boolean flag;
        if (i < 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Checks.checkFalse(flag, java/lang/IllegalArgumentException, "The version code must be a positive integer", new Object[0]);
        mPackageVersionCode = Integer.valueOf(i);
    }

    public void setPackageVersionName(String s)
    {
        Checks.checkNotNull(s, java/lang/IllegalArgumentException, "The version name may not be null", new Object[0]);
        Checks.checkNotEmpty(s, java/lang/IllegalArgumentException, "The version name may not empty", new Object[0]);
        mPackageVersionName = s;
    }

    public void setRemoteFileSize(long l)
    {
        boolean flag;
        if (l >= 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Checks.checkTrue(flag, java/lang/IllegalArgumentException, "The size must be greater than or equal to zero", new Object[0]);
        mRemoteFileSize = l;
    }

    public void setRemoteUri(Uri uri)
    {
        Checks.checkNotNull(uri, java/lang/IllegalArgumentException, "The remote uri may not be null", new Object[0]);
        Checks.checkTrue(StringUtils.equalsAny(uri.getScheme(), new String[] {
            "file", "http", "https"
        }), java/lang/IllegalArgumentException, "The remote uri must use a file, http or https scheme, not %s", new Object[] {
            uri.getScheme()
        });
        mRemoteUri = uri;
        if ("file".equals(uri.getScheme()))
        {
            setLocalUri(mRemoteUri);
            setState(UpdateState.Downloaded);
        }
    }

    public void setState(UpdateState updatestate)
    {
        mState = updatestate;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        Checks.checkTrue(isValid(), java/lang/IllegalStateException, "Can not parcel an invalid update", new Object[0]);
        parcel.writeInt(4);
        parcel.writeParcelable(getUpdateType(), 0);
        parcel.writeParcelable(getState(), 0);
        parcel.writeParcelable(getFailureReason(), 0);
        parcel.writeInt(getInstallOrder());
        parcel.writeString(getPackageName());
        parcel.writeInt(getPackageVersionCode());
        parcel.writeString(getPackageVersionName());
        parcel.writeParcelable(getRemoteUri(), 0);
        parcel.writeLong(getRemoteFileSize());
        if (getForceInstall())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeParcelable(getNetworkType(), 0);
        parcel.writeLong(getInstallSchedulerStartTime());
    }


}
