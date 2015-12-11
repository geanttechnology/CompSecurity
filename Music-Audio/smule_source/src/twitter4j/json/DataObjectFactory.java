// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package twitter4j.json;

import java.util.Map;
import twitter4j.AccountTotals;
import twitter4j.Category;
import twitter4j.DirectMessage;
import twitter4j.IDs;
import twitter4j.Location;
import twitter4j.OEmbed;
import twitter4j.Place;
import twitter4j.Relationship;
import twitter4j.SavedSearch;
import twitter4j.Status;
import twitter4j.Trend;
import twitter4j.Trends;
import twitter4j.TwitterObjectFactory;
import twitter4j.User;
import twitter4j.UserList;

public final class DataObjectFactory
{

    private DataObjectFactory()
    {
        throw new AssertionError("not intended to be instantiated.");
    }

    public static AccountTotals createAccountTotals(String s)
    {
        return TwitterObjectFactory.createAccountTotals(s);
    }

    public static Category createCategory(String s)
    {
        return TwitterObjectFactory.createCategory(s);
    }

    public static DirectMessage createDirectMessage(String s)
    {
        return TwitterObjectFactory.createDirectMessage(s);
    }

    public static IDs createIDs(String s)
    {
        return TwitterObjectFactory.createIDs(s);
    }

    public static Location createLocation(String s)
    {
        return TwitterObjectFactory.createLocation(s);
    }

    public static OEmbed createOEmbed(String s)
    {
        return TwitterObjectFactory.createOEmbed(s);
    }

    public static Object createObject(String s)
    {
        return TwitterObjectFactory.createObject(s);
    }

    public static Place createPlace(String s)
    {
        return TwitterObjectFactory.createPlace(s);
    }

    public static Map createRateLimitStatus(String s)
    {
        return TwitterObjectFactory.createRateLimitStatus(s);
    }

    public static Relationship createRelationship(String s)
    {
        return TwitterObjectFactory.createRelationship(s);
    }

    public static SavedSearch createSavedSearch(String s)
    {
        return TwitterObjectFactory.createSavedSearch(s);
    }

    public static Status createStatus(String s)
    {
        return TwitterObjectFactory.createStatus(s);
    }

    public static Trend createTrend(String s)
    {
        return TwitterObjectFactory.createTrend(s);
    }

    public static Trends createTrends(String s)
    {
        return TwitterObjectFactory.createTrends(s);
    }

    public static User createUser(String s)
    {
        return TwitterObjectFactory.createUser(s);
    }

    public static UserList createUserList(String s)
    {
        return TwitterObjectFactory.createUserList(s);
    }

    public static String getRawJSON(Object obj)
    {
        return TwitterObjectFactory.getRawJSON(obj);
    }
}
