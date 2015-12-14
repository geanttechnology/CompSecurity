// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.e;

import bo.app.el;
import bo.app.ez;
import com.appboy.Constants;
import com.appboy.enums.CardCategory;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import myobfuscated.g.c;

public final class a
{

    private static final String c;
    public final boolean a;
    public final long b;
    private final List d;
    private final String e;

    public a(List list, String s, boolean flag, long l)
    {
        e = s;
        a = flag;
        d = (List)ez.a(list);
        b = l;
    }

    public final List a(EnumSet enumset)
    {
        EnumSet enumset2 = enumset;
        if (d != null)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        enumset2 = enumset;
        myobfuscated.i.a.a(c, "There are no cards targeted to this user in the Appboy News Feed, you can call Appboy.requestFeedRefresh(),and try to call getFeedCards(categories) again when you receive a new feed updated event, or check your Appboy dashboard and make sure there are cards in the segment.");
        EnumSet enumset1;
        enumset2 = enumset;
        try
        {
            return new ArrayList();
        }
        // Misplaced declaration of an exception variable
        catch (EnumSet enumset)
        {
            myobfuscated.i.a.b(c, String.format("Unable to get cards with categories[%s]. Ignoring.", new Object[] {
                enumset2
            }), enumset);
        }
        break MISSING_BLOCK_LABEL_107;
        enumset1 = enumset;
        if (enumset != null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        enumset2 = enumset;
        myobfuscated.i.a.a(c, "The categories passed to getFeedCards are null, FeedUpdatedEvent is going to return all the cards in cache.");
        enumset2 = enumset;
        enumset1 = CardCategory.ALL_CATEGORIES;
        enumset2 = enumset1;
        if (!enumset1.isEmpty())
        {
            break MISSING_BLOCK_LABEL_109;
        }
        enumset2 = enumset1;
        myobfuscated.i.a.b(c, "The parameter passed into categories is not valid, Appboy is returning an empty card list.Please pass in a non-empty EnumSet of CardCategory for getFeedCards().");
        enumset2 = enumset1;
        enumset = new ArrayList();
        return enumset;
        return null;
        enumset2 = enumset1;
        enumset = new ArrayList();
        enumset2 = enumset1;
        Iterator iterator = d.iterator();
_L8:
        enumset2 = enumset1;
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        enumset2 = enumset1;
        c c1 = (c)iterator.next();
        enumset2 = enumset1;
        if (!c1.a(enumset1))
        {
            continue; /* Loop/switch isn't completed */
        }
        enumset2 = enumset1;
        if (c1.l == -1L) goto _L4; else goto _L3
_L3:
        enumset2 = enumset1;
        if (c1.l > el.a()) goto _L4; else goto _L5
_L5:
        boolean flag = true;
_L6:
        if (flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        enumset2 = enumset1;
        enumset.add(c1);
        continue; /* Loop/switch isn't completed */
_L4:
        flag = false;
        if (true) goto _L6; else goto _L2
_L2:
        return enumset;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public final int b(EnumSet enumset)
    {
        if (enumset == null)
        {
            myobfuscated.i.a.a(c, "The categories passed into getCardCount are null, FeedUpdatedEvent is going to return the count of all the cards in cache.");
            return d.size();
        }
        if (enumset.isEmpty())
        {
            myobfuscated.i.a.b(c, "The parameters passed into categories are not valid, Appboy is returning 0 in getCardCount().Please pass in a non-empty EnumSet of CardCategory.");
            return 0;
        } else
        {
            return a(enumset).size();
        }
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("FeedUpdatedEvent{");
        stringbuilder.append("mFeedCards=").append(d);
        stringbuilder.append(", mUserId='").append(e).append('\'');
        stringbuilder.append(", mFromOfflineStorage=").append(a);
        stringbuilder.append(", mTimestamp=").append(b);
        stringbuilder.append('}');
        return stringbuilder.toString();
    }

    static 
    {
        c = String.format("%s.%s", new Object[] {
            Constants.APPBOY_LOG_TAG_PREFIX, myobfuscated/e/a.getName()
        });
    }
}
