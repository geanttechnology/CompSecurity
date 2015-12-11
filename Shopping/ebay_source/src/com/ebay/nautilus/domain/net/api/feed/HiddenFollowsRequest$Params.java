// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.feed;

import com.ebay.nautilus.domain.data.FollowingContent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.net.api.feed:
//            HiddenFollowsRequest

public static class collectionId
{
    private static final class HiddenCollection
    {

        private String collectionId;


        public HiddenCollection(String s)
        {
            collectionId = s;
        }
    }

    private static final class HiddenInterest
    {

        private String interestId;


        public HiddenInterest(String s)
        {
            interestId = s;
        }
    }

    private static final class HiddenUser
    {

        private String username;


        public HiddenUser(String s)
        {
            username = s;
        }
    }


    private final List hiddenCollections = new ArrayList();
    private final List hiddenInterests = new ArrayList();
    private final List hiddenUsers = new ArrayList();

    public void setFollowedEntityIsHidden(com.ebay.nautilus.domain.data.ity ity, boolean flag)
    {
        if (!(ity instanceof com.ebay.nautilus.domain.data.erest)) goto _L2; else goto _L1
_L1:
        ity = (com.ebay.nautilus.domain.data.erest)ity;
        if (!flag) goto _L4; else goto _L3
_L3:
        hiddenInterests.add(new HiddenInterest(((com.ebay.nautilus.domain.data.erest) (ity)).interestId));
_L6:
        return;
_L4:
        Object obj;
        Iterator iterator = hiddenInterests.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            obj = (HiddenInterest)iterator.next();
        } while (!((com.ebay.nautilus.domain.data.erest) (ity)).interestId.equals(((HiddenInterest) (obj)).interestId));
        break; /* Loop/switch isn't completed */
        if (true) goto _L6; else goto _L5
_L5:
        hiddenInterests.remove(obj);
        return;
_L2:
        if (!(ity instanceof com.ebay.nautilus.domain.data.r))
        {
            continue; /* Loop/switch isn't completed */
        }
        ity = (com.ebay.nautilus.domain.data.r)ity;
        if (flag)
        {
            hiddenUsers.add(new HiddenUser(((com.ebay.nautilus.domain.data.r) (ity)).username));
            return;
        }
        Iterator iterator1 = hiddenUsers.iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            obj = (HiddenUser)iterator1.next();
        } while (!((com.ebay.nautilus.domain.data.r) (ity)).username.equals(((HiddenUser) (obj)).username));
        break; /* Loop/switch isn't completed */
        if (true) goto _L6; else goto _L7
_L7:
        hiddenUsers.remove(obj);
        return;
        if (!(ity instanceof com.ebay.nautilus.domain.data.lection)) goto _L6; else goto _L8
_L8:
        ity = (com.ebay.nautilus.domain.data.lection)ity;
        if (flag)
        {
            hiddenCollections.add(new HiddenCollection(((com.ebay.nautilus.domain.data.lection) (ity)).collectionId));
            return;
        }
        Iterator iterator2 = hiddenCollections.iterator();
        do
        {
            if (!iterator2.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            obj = (HiddenCollection)iterator2.next();
        } while (!((com.ebay.nautilus.domain.data.lection) (ity)).collectionId.equals(((HiddenCollection) (obj)).collectionId));
        break; /* Loop/switch isn't completed */
        if (true) goto _L6; else goto _L9
_L9:
        hiddenCollections.remove(obj);
        return;
    }

    public HiddenUser.username(FollowingContent followingcontent)
    {
        if (followingcontent != null && followingcontent.followedEntities != null)
        {
            if (followingcontent.followedEntities.interests != null)
            {
                Iterator iterator = followingcontent.followedEntities.interests.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    com.ebay.nautilus.domain.data.erest erest = (com.ebay.nautilus.domain.data.erest)iterator.next();
                    if (erest.hiddenFeedEvents)
                    {
                        hiddenInterests.add(new HiddenInterest(erest.interestId));
                    }
                } while (true);
            }
            if (followingcontent.followedEntities.users != null)
            {
                Iterator iterator1 = followingcontent.followedEntities.users.iterator();
                do
                {
                    if (!iterator1.hasNext())
                    {
                        break;
                    }
                    com.ebay.nautilus.domain.data.r r = (com.ebay.nautilus.domain.data.r)iterator1.next();
                    if (r.hiddenFeedEvents)
                    {
                        hiddenUsers.add(new HiddenUser(r.username));
                    }
                } while (true);
            }
            if (followingcontent.followedEntities.collections != null)
            {
                followingcontent = followingcontent.followedEntities.collections.iterator();
                do
                {
                    if (!followingcontent.hasNext())
                    {
                        break;
                    }
                    com.ebay.nautilus.domain.data.lection lection = (com.ebay.nautilus.domain.data.lection)followingcontent.next();
                    if (lection.hiddenFeedEvents)
                    {
                        hiddenCollections.add(new HiddenCollection(lection.collectionId));
                    }
                } while (true);
            }
        }
    }
}
