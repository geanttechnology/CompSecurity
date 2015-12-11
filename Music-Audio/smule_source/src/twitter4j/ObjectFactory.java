// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package twitter4j;

import java.io.Serializable;
import java.util.Map;

// Referenced classes of package twitter4j:
//            HttpResponse, UserList, JSONObject, AccountSettings, 
//            AccountTotals, ResponseList, DirectMessage, IDs, 
//            OEmbed, PagableResponseList, Place, Query, 
//            QueryResult, Relationship, SavedSearch, Status, 
//            Trends, TwitterAPIConfiguration, User

interface ObjectFactory
    extends Serializable
{

    public abstract UserList createAUserList(HttpResponse httpresponse);

    public abstract UserList createAUserList(JSONObject jsonobject);

    public abstract AccountSettings createAccountSettings(HttpResponse httpresponse);

    public abstract AccountTotals createAccountTotals(HttpResponse httpresponse);

    public abstract ResponseList createCategoryList(HttpResponse httpresponse);

    public abstract DirectMessage createDirectMessage(HttpResponse httpresponse);

    public abstract ResponseList createDirectMessageList(HttpResponse httpresponse);

    public abstract ResponseList createEmptyResponseList();

    public abstract ResponseList createFriendshipList(HttpResponse httpresponse);

    public abstract IDs createIDs(HttpResponse httpresponse);

    public abstract ResponseList createLanguageList(HttpResponse httpresponse);

    public abstract ResponseList createLocationList(HttpResponse httpresponse);

    public abstract OEmbed createOEmbed(HttpResponse httpresponse);

    public abstract PagableResponseList createPagableUserList(HttpResponse httpresponse);

    public abstract PagableResponseList createPagableUserListList(HttpResponse httpresponse);

    public abstract Place createPlace(HttpResponse httpresponse);

    public abstract ResponseList createPlaceList(HttpResponse httpresponse);

    public abstract QueryResult createQueryResult(HttpResponse httpresponse, Query query);

    public abstract Map createRateLimitStatuses(HttpResponse httpresponse);

    public abstract Relationship createRelationship(HttpResponse httpresponse);

    public abstract SavedSearch createSavedSearch(HttpResponse httpresponse);

    public abstract ResponseList createSavedSearchList(HttpResponse httpresponse);

    public abstract Status createStatus(HttpResponse httpresponse);

    public abstract Status createStatus(JSONObject jsonobject);

    public abstract ResponseList createStatusList(HttpResponse httpresponse);

    public abstract Trends createTrends(HttpResponse httpresponse);

    public abstract TwitterAPIConfiguration createTwitterAPIConfiguration(HttpResponse httpresponse);

    public abstract User createUser(HttpResponse httpresponse);

    public abstract User createUser(JSONObject jsonobject);

    public abstract ResponseList createUserList(HttpResponse httpresponse);

    public abstract ResponseList createUserListFromJSONArray(HttpResponse httpresponse);

    public abstract ResponseList createUserListFromJSONArray_Users(HttpResponse httpresponse);

    public abstract ResponseList createUserListList(HttpResponse httpresponse);
}
