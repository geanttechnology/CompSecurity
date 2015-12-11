// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;

import android.text.TextUtils;
import com.ebay.common.model.followinterest.FollowDescriptor;
import com.ebay.common.model.followinterest.FollowType;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.DatedContent;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.ebay.common.content.dm:
//            FollowedEntityDataManager

public static class site
{

    public DatedContent followedCollectionsContent;
    public DatedContent followedInterestsContent;
    public DatedContent followedUsersContent;
    public final String iafToken;
    public ResultStatus resultStatus;
    public final EbaySite site;

    public void addFollow(FollowType followtype, FollowDescriptor followdescriptor)
    {
        if (followdescriptor != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        NautilusKernel.verifyMain();
        switch (p.com.ebay.common.model.followinterest.FollowType[followtype.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (followdescriptor.interest != null)
            {
                removeFollow(followtype, followdescriptor.getInterestId());
                if (followedInterestsContent == null)
                {
                    followedInterestsContent = new DatedContent(new LinkedHashMap(), ResultStatus.SUCCESS);
                }
                ((Map)followedInterestsContent.getData()).put(followdescriptor, followdescriptor.interest);
                return;
            }
            break;

        case 2: // '\002'
            removeFollow(followtype, followdescriptor.collectionId);
            if (followedCollectionsContent == null)
            {
                followedCollectionsContent = new DatedContent(new ArrayList(), ResultStatus.SUCCESS);
            }
            ((List)followedCollectionsContent.getData()).add(followdescriptor);
            return;

        case 3: // '\003'
            removeFollow(followtype, followdescriptor.username);
            if (followedUsersContent == null)
            {
                followedUsersContent = new DatedContent(new ArrayList(), ResultStatus.SUCCESS);
            }
            ((List)followedUsersContent.getData()).add(followdescriptor);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public FollowDescriptor getFollowById(FollowType followtype, String s)
    {
        p.com.ebay.common.model.followinterest.FollowType[followtype.ordinal()];
        JVM INSTR tableswitch 1 3: default 36
    //                   1 40
    //                   2 101
    //                   3 165;
           goto _L1 _L2 _L3 _L4
_L1:
        followtype = null;
_L6:
        return followtype;
_L2:
        followtype = ((Map)followedInterestsContent.getData()).entrySet().iterator();
        FollowDescriptor followdescriptor;
        do
        {
            if (!followtype.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            followdescriptor = (FollowDescriptor)((java.util.iptor)followtype.next()).iptor();
        } while (!s.equals(followdescriptor.getInterestId()));
        return followdescriptor;
_L3:
        Iterator iterator = ((List)followedCollectionsContent.getData()).iterator();
_L8:
        FollowDescriptor followdescriptor1;
        if (!iterator.hasNext())
        {
            continue; /* Loop/switch isn't completed */
        }
        followdescriptor1 = (FollowDescriptor)iterator.next();
        followtype = followdescriptor1;
        if (s.equals(followdescriptor1.id)) goto _L6; else goto _L5
_L5:
        if (!s.equals(followdescriptor1.collectionId)) goto _L8; else goto _L7
_L7:
        return followdescriptor1;
_L4:
        iterator = ((List)followedUsersContent.getData()).iterator();
_L11:
        if (!iterator.hasNext())
        {
            continue; /* Loop/switch isn't completed */
        }
        followdescriptor1 = (FollowDescriptor)iterator.next();
        followtype = followdescriptor1;
        if (s.equals(followdescriptor1.id)) goto _L6; else goto _L9
_L9:
        if (!s.equals(followdescriptor1.username)) goto _L11; else goto _L10
_L10:
        return followdescriptor1;
        if (true) goto _L1; else goto _L12
_L12:
    }

    public FollowDescriptor getFollowByInterestId(String s)
    {
        for (Iterator iterator = ((Map)followedInterestsContent.getData()).entrySet().iterator(); iterator.hasNext();)
        {
            FollowDescriptor followdescriptor = (FollowDescriptor)((java.util.iptor)iterator.next()).iptor();
            if (followdescriptor.getInterestId().equals(s))
            {
                return followdescriptor;
            }
        }

        return null;
    }

    public List getFollowedInterestsByName(String s)
    {
        LinkedList linkedlist = new LinkedList();
        Iterator iterator = ((Map)followedInterestsContent.getData()).entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            FollowDescriptor followdescriptor = (FollowDescriptor)((java.util.iptor)iterator.next()).iptor();
            if (followdescriptor.getInterestTitle().equals(s))
            {
                linkedlist.add(followdescriptor);
            }
        } while (true);
        return linkedlist;
    }

    public boolean isApplicable(String s, EbaySite ebaysite)
    {
        return iafToken.equals(s) && site.equals(ebaysite);
    }

    public void removeFollow(FollowType followtype, String s)
    {
        NautilusKernel.verifyMain();
        if (!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        FollowDescriptor followdescriptor;
        switch (p.com.ebay.common.model.followinterest.FollowType[followtype.ordinal()])
        {
        default:
            return;

        case 3: // '\003'
            continue; /* Loop/switch isn't completed */

        case 1: // '\001'
            if (followedInterestsContent == null)
            {
                continue; /* Loop/switch isn't completed */
            }
            followtype = ((Map)followedInterestsContent.getData()).entrySet().iterator();
            do
            {
                if (!followtype.hasNext())
                {
                    continue; /* Loop/switch isn't completed */
                }
                followdescriptor = (FollowDescriptor)((java.util.iptor)followtype.next()).iptor();
            } while (!s.equals(followdescriptor.getInterestId()));
            break; /* Loop/switch isn't completed */

        case 2: // '\002'
            if (followedCollectionsContent == null)
            {
                continue; /* Loop/switch isn't completed */
            }
            followtype = ((List)followedCollectionsContent.getData()).iterator();
            do
            {
                if (!followtype.hasNext())
                {
                    continue; /* Loop/switch isn't completed */
                }
                followdescriptor = (FollowDescriptor)followtype.next();
            } while (!s.equals(followdescriptor.id) && !s.equals(followdescriptor.collectionId));
            break; /* Loop/switch isn't completed */
        }
        if (true) goto _L1; else goto _L3
_L3:
        ((Map)followedInterestsContent.getData()).remove(followdescriptor);
        return;
        if (true) goto _L1; else goto _L4
_L4:
        ((List)followedCollectionsContent.getData()).remove(followdescriptor);
        return;
        if (followedUsersContent == null) goto _L1; else goto _L5
_L5:
        followtype = ((List)followedUsersContent.getData()).iterator();
        do
        {
            if (!followtype.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            followdescriptor = (FollowDescriptor)followtype.next();
        } while (!s.equals(followdescriptor.id) && !s.equals(followdescriptor.username));
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L6
_L6:
        ((List)followedUsersContent.getData()).remove(followdescriptor);
        return;
    }

    public (String s, EbaySite ebaysite)
    {
        iafToken = s;
        site = ebaysite;
    }
}
