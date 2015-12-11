// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication.connection;


// Referenced classes of package amazon.communication.connection:
//            Purpose, CompressionOption, Priority, KeepAlive, 
//            ConnectionPolicy

public final class Policy
{
    public static final class Builder
    {

        private boolean mBuilt;
        private CompressionOption mCompressionOption;
        private boolean mIsAnonymousCredentialsAllowed;
        private boolean mIsClearText;
        private boolean mIsDedicated;
        private boolean mIsLowLatencyNecessary;
        private boolean mIsRequestResponseOnly;
        private boolean mIsWiFiNecessary;
        private KeepAlive mKeepAlive;
        private Priority mPriority;
        private Purpose mPurpose;
        private boolean mReconnectOnFailure;

        private void enforceSingleBuild()
        {
            if (mBuilt)
            {
                throw new IllegalStateException("Each builder can only be used once. Create a new builder");
            } else
            {
                return;
            }
        }

        public Policy build()
        {
            enforceSingleBuild();
            mBuilt = true;
            if (mIsDedicated && Purpose.REGULAR.equals(mPurpose))
            {
                throw new IllegalArgumentException("purpose must be set for dedicated connection");
            } else
            {
                return new Policy(mCompressionOption, mPriority, mIsLowLatencyNecessary, mIsRequestResponseOnly, mIsClearText, mIsWiFiNecessary, mIsAnonymousCredentialsAllowed, mIsDedicated, mPurpose, mReconnectOnFailure, mKeepAlive);
            }
        }

        public Policy fromConnectionPolicy(ConnectionPolicy connectionpolicy)
        {
            if (connectionpolicy == null)
            {
                throw new IllegalArgumentException("compatibility must not be null");
            } else
            {
                enforceSingleBuild();
                setCompressionOption(CompressionOption.values()[connectionpolicy.getCompressionOption().ordinal()]);
                setPriority(connectionpolicy.getPriority());
                setIsLowLatencyNecessary(connectionpolicy.isLowLatencyNecessary());
                setIsRequestResponseOnly(connectionpolicy.isRequestResponseOnly());
                setIsClearText(connectionpolicy.isClearText());
                setIsWiFiNecessary(connectionpolicy.isWiFiNecessary());
                setIsAnonymousCredentialsAllowed(connectionpolicy.isAnonymousCredentialsAllowed());
                return build();
            }
        }

        public Builder setCompressionOption(CompressionOption compressionoption)
        {
            enforceSingleBuild();
            mCompressionOption = compressionoption;
            return this;
        }

        public Builder setIsAnonymousCredentialsAllowed(boolean flag)
        {
            enforceSingleBuild();
            mIsAnonymousCredentialsAllowed = flag;
            return this;
        }

        public Builder setIsClearText(boolean flag)
        {
            enforceSingleBuild();
            mIsClearText = flag;
            return this;
        }

        public Builder setIsDedicated(boolean flag)
        {
            enforceSingleBuild();
            mIsDedicated = flag;
            return this;
        }

        public Builder setIsLowLatencyNecessary(boolean flag)
        {
            enforceSingleBuild();
            mIsLowLatencyNecessary = flag;
            return this;
        }

        public Builder setIsRequestResponseOnly(boolean flag)
        {
            enforceSingleBuild();
            mIsRequestResponseOnly = flag;
            return this;
        }

        public Builder setIsWiFiNecessary(boolean flag)
        {
            enforceSingleBuild();
            mIsWiFiNecessary = flag;
            return this;
        }

        public Builder setKeepAlive(KeepAlive keepalive)
        {
            enforceSingleBuild();
            mKeepAlive = keepalive;
            return this;
        }

        public Builder setPriority(Priority priority)
        {
            enforceSingleBuild();
            mPriority = priority;
            return this;
        }

        public Builder setPurpose(Purpose purpose)
        {
            enforceSingleBuild();
            mPurpose = purpose;
            return this;
        }

        public Builder setReconnectOnFailure(boolean flag)
        {
            enforceSingleBuild();
            mReconnectOnFailure = flag;
            return this;
        }

        public Builder()
        {
            mCompressionOption = CompressionOption.ALLOWED;
            mPriority = Priority.PRIORITY_NORMAL;
            mIsLowLatencyNecessary = false;
            mIsRequestResponseOnly = false;
            mIsClearText = false;
            mIsWiFiNecessary = false;
            mIsAnonymousCredentialsAllowed = false;
            mIsDedicated = false;
            mPurpose = null;
            mReconnectOnFailure = false;
            mKeepAlive = KeepAlive.NONE;
            mBuilt = false;
        }
    }


    public static final Policy FAST_BIDI = (new Builder()).setIsLowLatencyNecessary(true).build();
    public static final Policy ONE_SHOT = (new Builder()).setIsRequestResponseOnly(true).setIsClearText(true).build();
    public static final Policy SHARED_BIDI = (new Builder()).setIsLowLatencyNecessary(true).build();
    private final CompressionOption mCompressionOption;
    private final boolean mIsAnonymousCredentialsAllowed;
    private final boolean mIsClearText;
    private final boolean mIsDedicated;
    private final boolean mIsLowLatencyNecessary;
    private final boolean mIsRequestResponseOnly;
    private final boolean mIsWiFiNecessary;
    private final KeepAlive mKeepAlive;
    private final Priority mPriority;
    private final Purpose mPurpose;
    private final boolean mReconnectOnFailure;

    private Policy(CompressionOption compressionoption, Priority priority, boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4, 
            boolean flag5, Purpose purpose, boolean flag6, KeepAlive keepalive)
    {
        mCompressionOption = compressionoption;
        mPriority = priority;
        mIsLowLatencyNecessary = flag;
        mIsRequestResponseOnly = flag1;
        mIsClearText = flag2;
        mIsWiFiNecessary = flag3;
        mIsAnonymousCredentialsAllowed = flag4;
        mIsDedicated = flag5;
        mPurpose = purpose;
        mReconnectOnFailure = flag6;
        mKeepAlive = keepalive;
    }


    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (Policy)obj;
            if (mCompressionOption != ((Policy) (obj)).mCompressionOption || mPriority != ((Policy) (obj)).mPriority || mIsLowLatencyNecessary != ((Policy) (obj)).mIsLowLatencyNecessary || mIsRequestResponseOnly != ((Policy) (obj)).mIsRequestResponseOnly || mIsClearText != ((Policy) (obj)).mIsClearText || mIsWiFiNecessary != ((Policy) (obj)).mIsWiFiNecessary || mIsAnonymousCredentialsAllowed != ((Policy) (obj)).mIsAnonymousCredentialsAllowed || mIsDedicated != ((Policy) (obj)).mIsDedicated || mPurpose != ((Policy) (obj)).mPurpose && (mPurpose == null || !mPurpose.equals(((Policy) (obj)).mPurpose)) || mReconnectOnFailure != ((Policy) (obj)).mReconnectOnFailure || mKeepAlive != ((Policy) (obj)).mKeepAlive)
            {
                return false;
            }
        }
        return true;
    }

    public CompressionOption getCompressionOption()
    {
        return mCompressionOption;
    }

    public KeepAlive getKeepAlive()
    {
        return mKeepAlive;
    }

    public Priority getPriority()
    {
        return mPriority;
    }

    public Purpose getPurpose()
    {
        return mPurpose;
    }

    public boolean getReconnectOnFailure()
    {
        return mReconnectOnFailure;
    }

    public int hashCode()
    {
        int k1 = 1;
        int l1 = mCompressionOption.hashCode();
        int i2 = mPriority.hashCode();
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int j2;
        if (mIsLowLatencyNecessary)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (mIsRequestResponseOnly)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        if (mIsClearText)
        {
            k = 1;
        } else
        {
            k = 0;
        }
        if (mIsWiFiNecessary)
        {
            l = 1;
        } else
        {
            l = 0;
        }
        if (mIsAnonymousCredentialsAllowed)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (mIsDedicated)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        j2 = mPurpose.hashCode();
        if (!mReconnectOnFailure)
        {
            k1 = 0;
        }
        return ((((((((((l1 + 217) * 31 + i2) * 31 + i) * 31 + j) * 31 + k) * 31 + l) * 31 + i1) * 31 + j1) * 31 + j2) * 31 + k1) * 31 + mKeepAlive.hashCode();
    }

    public boolean isAnonymousCredentialsAllowed()
    {
        return mIsAnonymousCredentialsAllowed;
    }

    public boolean isClearText()
    {
        return mIsClearText;
    }

    public boolean isDedicated()
    {
        return mIsDedicated;
    }

    public boolean isLowLatencyNecessary()
    {
        return mIsLowLatencyNecessary;
    }

    public boolean isRequestResponseOnly()
    {
        return mIsRequestResponseOnly;
    }

    public boolean isWiFiNecessary()
    {
        return mIsWiFiNecessary;
    }

    public String toString()
    {
        return (new StringBuilder("{ ")).append(", CompressionOption: ").append(mCompressionOption).append(", Priority: ").append(mPriority).append(", LowLatency: ").append(mIsLowLatencyNecessary).append(", RequestResponseOnly: ").append(mIsRequestResponseOnly).append(", IsClearText: ").append(mIsClearText).append(", IsWiFiNecessary: ").append(mIsWiFiNecessary).append(", IsAnonymousCredentialsAllowed: ").append(mIsAnonymousCredentialsAllowed).append(", mIsDedicated: ").append(mIsDedicated).append(", mPurpose: ").append(mPurpose).append(", mReconnectOnFailure: ").append(mReconnectOnFailure).append(", mKeepAlive: ").append(mKeepAlive).append(" }").toString();
    }

}
