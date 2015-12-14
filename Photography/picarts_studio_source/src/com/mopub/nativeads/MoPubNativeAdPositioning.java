// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import com.mopub.common.Preconditions;
import java.util.ArrayList;

public final class MoPubNativeAdPositioning
{

    public MoPubNativeAdPositioning()
    {
    }

    public static MoPubClientPositioning clientPositioning()
    {
        return new MoPubClientPositioning();
    }

    static MoPubClientPositioning clone(MoPubClientPositioning mopubclientpositioning)
    {
        Preconditions.checkNotNull(mopubclientpositioning);
        MoPubClientPositioning mopubclientpositioning1 = new MoPubClientPositioning();
        mopubclientpositioning1.mFixedPositions.addAll(mopubclientpositioning.mFixedPositions);
        mopubclientpositioning1.mRepeatInterval = mopubclientpositioning.mRepeatInterval;
        return mopubclientpositioning1;
    }

    public static Builder newBuilder()
    {
        return new Builder();
    }

    public static MoPubServerPositioning serverPositioning()
    {
        return new MoPubServerPositioning();
    }

    private class MoPubClientPositioning
    {

        public static final int NO_REPEAT = 0x7fffffff;
        private final ArrayList mFixedPositions = new ArrayList();
        private int mRepeatInterval;

        public MoPubClientPositioning addFixedPosition(int i)
        {
            boolean flag;
            if (i >= 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            int j;
            if (com.mopub.common.Preconditions.NoThrow.checkArgument(flag))
            {
                if ((j = Collections.binarySearch(mFixedPositions, Integer.valueOf(i))) < 0)
                {
                    mFixedPositions.add(~j, Integer.valueOf(i));
                    return this;
                }
            }
            return this;
        }

        public MoPubClientPositioning enableRepeatingPositions(int i)
        {
            boolean flag = true;
            if (i <= 1)
            {
                flag = false;
            }
            if (!com.mopub.common.Preconditions.NoThrow.checkArgument(flag, "Repeating interval must be greater than 1"))
            {
                mRepeatInterval = 0x7fffffff;
                return this;
            } else
            {
                mRepeatInterval = i;
                return this;
            }
        }

        List getFixedPositions()
        {
            return mFixedPositions;
        }

        int getRepeatingInterval()
        {
            return mRepeatInterval;
        }




/*
        static int access$102(MoPubClientPositioning mopubclientpositioning, int i)
        {
            mopubclientpositioning.mRepeatInterval = i;
            return i;
        }

*/

        public MoPubClientPositioning()
        {
            mRepeatInterval = 0x7fffffff;
        }
    }


    private class Builder extends MoPubClientPositioning
    {

        public final Builder addFixedPosition(int i)
        {
            super.addFixedPosition(i);
            return this;
        }

        public final volatile MoPubClientPositioning addFixedPosition(int i)
        {
            return addFixedPosition(i);
        }

        public final MoPubClientPositioning build()
        {
            return this;
        }

        public final Builder enableRepeatingPositions(int i)
        {
            super.enableRepeatingPositions(i);
            return this;
        }

        public final volatile MoPubClientPositioning enableRepeatingPositions(int i)
        {
            return enableRepeatingPositions(i);
        }

        public Builder()
        {
        }
    }


    private class MoPubServerPositioning
    {

        public MoPubServerPositioning()
        {
        }
    }

}
