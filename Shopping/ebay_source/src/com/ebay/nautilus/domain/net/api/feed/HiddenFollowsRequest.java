// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.feed;

import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.data.FollowingContent;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.CosVersionType;
import com.ebay.nautilus.domain.net.EbayCosRequest;
import com.ebay.nautilus.kernel.net.Response;
import com.google.gson.Gson;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.net.api.feed:
//            HiddenFollowsResponse

public class HiddenFollowsRequest extends EbayCosRequest
{
    public static class Params
    {

        private final List hiddenCollections = new ArrayList();
        private final List hiddenInterests = new ArrayList();
        private final List hiddenUsers = new ArrayList();

        public void setFollowedEntityIsHidden(com.ebay.nautilus.domain.data.FollowingContent.FollowedEntity followedentity, boolean flag)
        {
            if (!(followedentity instanceof com.ebay.nautilus.domain.data.FollowingContent.FollowedInterest)) goto _L2; else goto _L1
_L1:
            followedentity = (com.ebay.nautilus.domain.data.FollowingContent.FollowedInterest)followedentity;
            if (!flag) goto _L4; else goto _L3
_L3:
            hiddenInterests.add(new HiddenInterest(((com.ebay.nautilus.domain.data.FollowingContent.FollowedInterest) (followedentity)).interestId));
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
            } while (!((com.ebay.nautilus.domain.data.FollowingContent.FollowedInterest) (followedentity)).interestId.equals(((HiddenInterest) (obj)).interestId));
            break; /* Loop/switch isn't completed */
            if (true) goto _L6; else goto _L5
_L5:
            hiddenInterests.remove(obj);
            return;
_L2:
            if (!(followedentity instanceof com.ebay.nautilus.domain.data.FollowingContent.FollowedUser))
            {
                continue; /* Loop/switch isn't completed */
            }
            followedentity = (com.ebay.nautilus.domain.data.FollowingContent.FollowedUser)followedentity;
            if (flag)
            {
                hiddenUsers.add(new HiddenUser(((com.ebay.nautilus.domain.data.FollowingContent.FollowedUser) (followedentity)).username));
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
            } while (!((com.ebay.nautilus.domain.data.FollowingContent.FollowedUser) (followedentity)).username.equals(((HiddenUser) (obj)).username));
            break; /* Loop/switch isn't completed */
            if (true) goto _L6; else goto _L7
_L7:
            hiddenUsers.remove(obj);
            return;
            if (!(followedentity instanceof com.ebay.nautilus.domain.data.FollowingContent.FollowedCollection)) goto _L6; else goto _L8
_L8:
            followedentity = (com.ebay.nautilus.domain.data.FollowingContent.FollowedCollection)followedentity;
            if (flag)
            {
                hiddenCollections.add(new HiddenCollection(((com.ebay.nautilus.domain.data.FollowingContent.FollowedCollection) (followedentity)).collectionId));
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
            } while (!((com.ebay.nautilus.domain.data.FollowingContent.FollowedCollection) (followedentity)).collectionId.equals(((HiddenCollection) (obj)).collectionId));
            break; /* Loop/switch isn't completed */
            if (true) goto _L6; else goto _L9
_L9:
            hiddenCollections.remove(obj);
            return;
        }

        public Params(FollowingContent followingcontent)
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
                        com.ebay.nautilus.domain.data.FollowingContent.FollowedInterest followedinterest = (com.ebay.nautilus.domain.data.FollowingContent.FollowedInterest)iterator.next();
                        if (followedinterest.hiddenFeedEvents)
                        {
                            hiddenInterests.add(new HiddenInterest(followedinterest.interestId));
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
                        com.ebay.nautilus.domain.data.FollowingContent.FollowedUser followeduser = (com.ebay.nautilus.domain.data.FollowingContent.FollowedUser)iterator1.next();
                        if (followeduser.hiddenFeedEvents)
                        {
                            hiddenUsers.add(new HiddenUser(followeduser.username));
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
                        com.ebay.nautilus.domain.data.FollowingContent.FollowedCollection followedcollection = (com.ebay.nautilus.domain.data.FollowingContent.FollowedCollection)followingcontent.next();
                        if (followedcollection.hiddenFeedEvents)
                        {
                            hiddenCollections.add(new HiddenCollection(followedcollection.collectionId));
                        }
                    } while (true);
                }
            }
        }
    }

    private static final class Params.HiddenCollection
    {

        private String collectionId;


        public Params.HiddenCollection(String s)
        {
            collectionId = s;
        }
    }

    private static final class Params.HiddenInterest
    {

        private String interestId;


        public Params.HiddenInterest(String s)
        {
            interestId = s;
        }
    }

    private static final class Params.HiddenUser
    {

        private String username;


        public Params.HiddenUser(String s)
        {
            username = s;
        }
    }


    public static final String OPERATION_NAME = "hiddenfollows";
    public static final String SERVICE_NAME = "feed";
    private final Params params;

    public HiddenFollowsRequest(String s, EbayCountry ebaycountry, Params params1)
    {
        super("feed", "hiddenfollows", CosVersionType.V2);
        requestBodyContentType = "application/json";
        responseBodyContentType = "application/json";
        territory = ebaycountry.getCountryCode();
        marketPlaceId = ebaycountry.getSiteGlobalId();
        iafToken = s;
        params = params1;
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        return DataMapperFactory.getDefaultMapper().toJson(params).getBytes();
    }

    public String getHttpMethod()
    {
        return "PUT";
    }

    public URL getRequestUrl()
    {
        return ApiSettings.getUrl(ApiSettings.feedHiddenFollowUrl);
    }

    public HiddenFollowsResponse getResponse()
    {
        return new HiddenFollowsResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
