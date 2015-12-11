// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;


// Referenced classes of package co.vine.android.api:
//            VineComparatorFactory, VinePost, VineUser, VineRepost

private static class <init>
    implements <init>
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

    private ()
    {
    }

    ( )
    {
        this();
    }
}
