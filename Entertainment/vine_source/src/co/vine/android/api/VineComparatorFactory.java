// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;

import co.vine.android.util.Util;
import java.util.Comparator;

// Referenced classes of package co.vine.android.api:
//            VinePost, VineUser, VineRepost

public class VineComparatorFactory
{
    private static class DefaultComparator
        implements VineComparator
    {

        public int compare(VinePost vinepost, VinePost vinepost1)
        {
            return Long.valueOf(getOrderId(vinepost1)).compareTo(Long.valueOf(getOrderId(vinepost)));
        }

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((VinePost)obj, (VinePost)obj1);
        }

        public long getOrderId(VinePost vinepost)
        {
            return vinepost.postId;
        }

        public volatile long getOrderId(Object obj)
        {
            return getOrderId((VinePost)obj);
        }

        private DefaultComparator()
        {
        }

    }

    private static class HomeTimelineComparator
        implements VineComparator
    {

        public int compare(VinePost vinepost, VinePost vinepost1)
        {
            return Long.valueOf(getOrderId(vinepost1)).compareTo(Long.valueOf(getOrderId(vinepost)));
        }

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((VinePost)obj, (VinePost)obj1);
        }

        public long getOrderId(VinePost vinepost)
        {
            if (vinepost.user != null && vinepost.user.isFollowing())
            {
                return vinepost.postId;
            }
            if (vinepost.repost != null)
            {
                return vinepost.repost.repostId;
            } else
            {
                return vinepost.postId;
            }
        }

        public volatile long getOrderId(Object obj)
        {
            return getOrderId((VinePost)obj);
        }

        private HomeTimelineComparator()
        {
        }

    }

    private static class ProfileTimelineComparator
        implements VineComparator
    {

        public int compare(VinePost vinepost, VinePost vinepost1)
        {
            return Long.valueOf(getOrderId(vinepost1)).compareTo(Long.valueOf(getOrderId(vinepost)));
        }

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((VinePost)obj, (VinePost)obj1);
        }

        public long getOrderId(VinePost vinepost)
        {
            if (vinepost.repost != null)
            {
                return vinepost.repost.repostId;
            } else
            {
                return vinepost.postId;
            }
        }

        public volatile long getOrderId(Object obj)
        {
            return getOrderId((VinePost)obj);
        }

        private ProfileTimelineComparator()
        {
        }

    }

    public static interface VineComparator
        extends Comparator
    {

        public abstract long getOrderId(Object obj);
    }

    private static class VinePopularComparator
        implements VineComparator
    {

        public int compare(VinePost vinepost, VinePost vinepost1)
        {
            return Long.valueOf(getOrderId(vinepost)).compareTo(Long.valueOf(getOrderId(vinepost1)));
        }

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((VinePost)obj, (VinePost)obj1);
        }

        public long getOrderId(VinePost vinepost)
        {
            return Long.valueOf(vinepost.orderId).longValue();
        }

        public volatile long getOrderId(Object obj)
        {
            return getOrderId((VinePost)obj);
        }

        private VinePopularComparator()
        {
        }

    }


    public VineComparatorFactory()
    {
    }

    public static VineComparator get(int i)
    {
        if (Util.isPopularTimeline(i))
        {
            return new VinePopularComparator();
        }
        switch (i)
        {
        default:
            return new DefaultComparator();

        case 1: // '\001'
            return new HomeTimelineComparator();

        case 2: // '\002'
            return new ProfileTimelineComparator();
        }
    }
}
