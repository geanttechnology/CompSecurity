// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package twitter4j;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package twitter4j:
//            JSONException, AccountTotalsJSONImpl, JSONObject, TwitterException, 
//            CategoryJSONImpl, DirectMessageJSONImpl, IDsJSONImpl, LocationJSONImpl, 
//            OEmbedJSONImpl, JSONObjectType, StatusJSONImpl, StatusDeletionNoticeImpl, 
//            PlaceJSONImpl, RateLimitStatusJSONImpl, RelationshipJSONImpl, SavedSearchJSONImpl, 
//            TrendJSONImpl, TrendsJSONImpl, UserJSONImpl, UserListJSONImpl, 
//            AccountTotals, Category, DirectMessage, IDs, 
//            Location, OEmbed, Place, Relationship, 
//            SavedSearch, Status, Trend, Trends, 
//            User, UserList

public final class TwitterObjectFactory
{

    private static final ThreadLocal rawJsonMap = new ThreadLocal() {

        protected volatile Object initialValue()
        {
            return initialValue();
        }

        protected Map initialValue()
        {
            return new HashMap();
        }

    };
    private static boolean registeredAtleastOnce = false;

    private TwitterObjectFactory()
    {
        throw new AssertionError("not intended to be instantiated.");
    }

    static void clearThreadLocalMap()
    {
        ((Map)rawJsonMap.get()).clear();
    }

    public static AccountTotals createAccountTotals(String s)
    {
        try
        {
            s = new AccountTotalsJSONImpl(new JSONObject(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new TwitterException(s);
        }
        return s;
    }

    public static Category createCategory(String s)
    {
        try
        {
            s = new CategoryJSONImpl(new JSONObject(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new TwitterException(s);
        }
        return s;
    }

    public static DirectMessage createDirectMessage(String s)
    {
        try
        {
            s = new DirectMessageJSONImpl(new JSONObject(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new TwitterException(s);
        }
        return s;
    }

    public static IDs createIDs(String s)
    {
        return new IDsJSONImpl(s);
    }

    public static Location createLocation(String s)
    {
        try
        {
            s = new LocationJSONImpl(new JSONObject(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new TwitterException(s);
        }
        return s;
    }

    public static OEmbed createOEmbed(String s)
    {
        try
        {
            s = new OEmbedJSONImpl(new JSONObject(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new TwitterException(s);
        }
        return s;
    }

    public static Object createObject(String s)
    {
        JSONObjectType.Type type;
        s = new JSONObject(s);
        type = JSONObjectType.determine(s);
        class _cls2
        {

            static final int $SwitchMap$twitter4j$JSONObjectType$Type[];

            static 
            {
                $SwitchMap$twitter4j$JSONObjectType$Type = new int[JSONObjectType.Type.values().length];
                try
                {
                    $SwitchMap$twitter4j$JSONObjectType$Type[JSONObjectType.Type.SENDER.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$twitter4j$JSONObjectType$Type[JSONObjectType.Type.STATUS.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$twitter4j$JSONObjectType$Type[JSONObjectType.Type.DIRECT_MESSAGE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$twitter4j$JSONObjectType$Type[JSONObjectType.Type.DELETE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$twitter4j$JSONObjectType$Type[JSONObjectType.Type.LIMIT.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$twitter4j$JSONObjectType$Type[JSONObjectType.Type.SCRUB_GEO.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls2..SwitchMap.twitter4j.JSONObjectType.Type[type.ordinal()];
        JVM INSTR tableswitch 1 6: default 144
    //                   1 60
    //                   2 78
    //                   3 91
    //                   4 109
    //                   5 144
    //                   6 144;
           goto _L1 _L2 _L3 _L4 _L5 _L1 _L1
_L2:
        return registerJSONObject(new DirectMessageJSONImpl(s.getJSONObject("direct_message")), s);
_L3:
        return registerJSONObject(new StatusJSONImpl(s), s);
_L4:
        return registerJSONObject(new DirectMessageJSONImpl(s.getJSONObject("direct_message")), s);
_L5:
        s = ((String) (registerJSONObject(new StatusDeletionNoticeImpl(s.getJSONObject("delete").getJSONObject("status")), s)));
        return s;
        s;
        throw new TwitterException(s);
_L1:
        return s;
    }

    public static Place createPlace(String s)
    {
        try
        {
            s = new PlaceJSONImpl(new JSONObject(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new TwitterException(s);
        }
        return s;
    }

    public static Map createRateLimitStatus(String s)
    {
        try
        {
            s = RateLimitStatusJSONImpl.createRateLimitStatuses(new JSONObject(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new TwitterException(s);
        }
        return s;
    }

    public static Relationship createRelationship(String s)
    {
        try
        {
            s = new RelationshipJSONImpl(new JSONObject(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new TwitterException(s);
        }
        return s;
    }

    public static SavedSearch createSavedSearch(String s)
    {
        try
        {
            s = new SavedSearchJSONImpl(new JSONObject(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new TwitterException(s);
        }
        return s;
    }

    public static Status createStatus(String s)
    {
        try
        {
            s = new StatusJSONImpl(new JSONObject(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new TwitterException(s);
        }
        return s;
    }

    public static Trend createTrend(String s)
    {
        try
        {
            s = new TrendJSONImpl(new JSONObject(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new TwitterException(s);
        }
        return s;
    }

    public static Trends createTrends(String s)
    {
        return new TrendsJSONImpl(s);
    }

    public static User createUser(String s)
    {
        try
        {
            s = new UserJSONImpl(new JSONObject(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new TwitterException(s);
        }
        return s;
    }

    public static UserList createUserList(String s)
    {
        try
        {
            s = new UserListJSONImpl(new JSONObject(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new TwitterException(s);
        }
        return s;
    }

    public static String getRawJSON(Object obj)
    {
        if (!registeredAtleastOnce)
        {
            throw new IllegalStateException("Apparently jsonStoreEnabled is not set to true.");
        }
        obj = ((Map)rawJsonMap.get()).get(obj);
        if (obj instanceof String)
        {
            return (String)obj;
        }
        if (obj != null)
        {
            return obj.toString();
        } else
        {
            return null;
        }
    }

    static Object registerJSONObject(Object obj, Object obj1)
    {
        registeredAtleastOnce = true;
        ((Map)rawJsonMap.get()).put(obj, obj1);
        return obj;
    }

}
