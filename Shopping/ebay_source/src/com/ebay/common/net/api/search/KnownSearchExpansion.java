// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import android.text.TextUtils;
import com.ebay.common.model.search.EbayCategorySummary;
import com.ebay.common.net.api.search.wiremodel.Rewrite;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchExpansion, SearchParameters

public final class KnownSearchExpansion extends Enum
{

    private static final KnownSearchExpansion $VALUES[];
    public static final KnownSearchExpansion CATCH_ALL;
    public static final KnownSearchExpansion CATEGORY_AUTORUN_NULL;
    public static final KnownSearchExpansion CATEGORY_LOW_RESULT;
    public static final KnownSearchExpansion CROSS_BORDER;
    public static final KnownSearchExpansion KEYWORD_REMOVAL;
    public static final KnownSearchExpansion QUERY_REWRITE;
    public static final KnownSearchExpansion QUERY_SPELL_AUTO_CORRECT;
    public static final KnownSearchExpansion SPELL_CHECK_AUTO;
    public static final KnownSearchExpansion SPELL_CHECK_SUGGESTED;
    public final boolean autoPromoted;
    public final boolean isDisplayedOnTop;
    public final boolean permitExpansionsInRecourse;
    public final String serviceExpansionName;

    private KnownSearchExpansion(String s, int i, String s1, boolean flag, boolean flag1)
    {
        this(s, i, s1, flag, flag1, false);
    }

    private KnownSearchExpansion(String s, int i, String s1, boolean flag, boolean flag1, boolean flag2)
    {
        super(s, i);
        serviceExpansionName = s1;
        autoPromoted = flag;
        isDisplayedOnTop = flag1;
        permitExpansionsInRecourse = flag2;
    }

    public static SearchParameters getCorrectedSearchParameters(SearchParameters searchparameters, SearchExpansion searchexpansion)
    {
        Object obj1 = null;
        if (!SPELL_CHECK_AUTO.serviceExpansionName.equals(searchexpansion.expansionType) && !QUERY_SPELL_AUTO_CORRECT.serviceExpansionName.equals(searchexpansion.expansionType)) goto _L2; else goto _L1
_L1:
        Object obj;
        searchparameters = searchparameters.clone();
        searchexpansion = (String)searchexpansion.expansionResult.metaAttributes.get("correction");
        obj = searchparameters;
        if (!TextUtils.isEmpty(searchexpansion))
        {
            searchparameters.keywords = searchexpansion;
            obj = searchparameters;
        }
_L4:
        return ((SearchParameters) (obj));
_L2:
        if (CATEGORY_AUTORUN_NULL.serviceExpansionName.equals(searchexpansion.expansionType))
        {
            searchparameters = searchparameters.clone();
            searchparameters.category = null;
            searchparameters.category1 = null;
            searchparameters.category2 = null;
            return searchparameters;
        }
        if (!CROSS_BORDER.serviceExpansionName.equals(searchexpansion.expansionType))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = obj1;
        if (!searchparameters.inStorePickupOnly)
        {
            obj = obj1;
            if (!searchparameters.ebnOnly)
            {
                searchparameters = searchparameters.clone();
                searchparameters.searchLocalCountryOnly = false;
                searchparameters.searchOtherCountries = true;
                return searchparameters;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        obj = obj1;
        if (!QUERY_REWRITE.serviceExpansionName.equals(searchexpansion.expansionType))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = obj1;
        if (searchexpansion.expansionResult.uvccCategoryId <= 0L)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = obj1;
        if (searchexpansion.expansionResult.uvccCategories == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = obj1;
        if (searchexpansion.expansionResult.uvccCategories.size() <= 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        Iterator iterator = searchexpansion.expansionResult.uvccCategories.iterator();
        do
        {
            obj = obj1;
            if (!iterator.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            obj = (EbayCategorySummary)iterator.next();
            if (((EbayCategorySummary) (obj)).id == searchexpansion.expansionResult.uvccCategoryId)
            {
                searchparameters = searchparameters.clone();
                searchparameters.category = ((EbayCategorySummary) (obj));
                return searchparameters;
            }
        } while (true);
        if (true) goto _L4; else goto _L5
_L5:
    }

    public static SearchParameters getQueryRewriteSearchParameters(SearchParameters searchparameters, List list)
    {
        Object obj = null;
        Iterator iterator = list.iterator();
        list = obj;
label0:
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj1 = (Rewrite)iterator.next();
            if (!QUERY_REWRITE.serviceExpansionName.equals(((Rewrite) (obj1)).type))
            {
                continue;
            }
            com.ebay.common.net.api.search.wiremodel.Rewrite.RewriteResult rewriteresult = (com.ebay.common.net.api.search.wiremodel.Rewrite.RewriteResult)((Rewrite) (obj1)).rewriteResults.get(0);
            Iterator iterator1 = rewriteresult.rewriteInfo.categoryPaths.iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    continue label0;
                }
                obj1 = (com.ebay.common.net.api.search.wiremodel.Rewrite.RewriteResult.Category)iterator1.next();
            } while (((com.ebay.common.net.api.search.wiremodel.Rewrite.RewriteResult.Category) (obj1)).id != ((Long)rewriteresult.requestDifference.categoryId.add.get(0)).longValue());
            list = searchparameters.clone();
            list.category = new EbayCategorySummary(((com.ebay.common.net.api.search.wiremodel.Rewrite.RewriteResult.Category) (obj1)).id, ((com.ebay.common.net.api.search.wiremodel.Rewrite.RewriteResult.Category) (obj1)).localizedName);
        } while (true);
        return list;
    }

    public static KnownSearchExpansion getTypeForNameAndPromotion(String s, boolean flag)
    {
        if (CROSS_BORDER.serviceExpansionName.equals(s))
        {
            return CROSS_BORDER;
        }
        if (KEYWORD_REMOVAL.serviceExpansionName.equals(s))
        {
            return KEYWORD_REMOVAL;
        }
        if (SPELL_CHECK_AUTO.serviceExpansionName.equals(s))
        {
            if (flag)
            {
                return SPELL_CHECK_AUTO;
            } else
            {
                return SPELL_CHECK_SUGGESTED;
            }
        }
        if (CATEGORY_AUTORUN_NULL.serviceExpansionName.equals(s))
        {
            if (flag)
            {
                return CATEGORY_AUTORUN_NULL;
            } else
            {
                return CATEGORY_LOW_RESULT;
            }
        }
        if (QUERY_REWRITE.serviceExpansionName.equals(s))
        {
            return QUERY_REWRITE;
        }
        if (CATCH_ALL.serviceExpansionName.equals(s))
        {
            return CATCH_ALL;
        } else
        {
            return CATCH_ALL;
        }
    }

    public static KnownSearchExpansion valueOf(String s)
    {
        return (KnownSearchExpansion)Enum.valueOf(com/ebay/common/net/api/search/KnownSearchExpansion, s);
    }

    public static KnownSearchExpansion[] values()
    {
        return (KnownSearchExpansion[])$VALUES.clone();
    }

    static 
    {
        SPELL_CHECK_AUTO = new KnownSearchExpansion("SPELL_CHECK_AUTO", 0, "spell_check", true, true, true);
        SPELL_CHECK_SUGGESTED = new KnownSearchExpansion("SPELL_CHECK_SUGGESTED", 1, "spell_check", false, true);
        CATEGORY_AUTORUN_NULL = new KnownSearchExpansion("CATEGORY_AUTORUN_NULL", 2, "category_constraint", true, true);
        CATEGORY_LOW_RESULT = new KnownSearchExpansion("CATEGORY_LOW_RESULT", 3, "category_constraint", false, false);
        CROSS_BORDER = new KnownSearchExpansion("CROSS_BORDER", 4, "site_constraint", false, false);
        KEYWORD_REMOVAL = new KnownSearchExpansion("KEYWORD_REMOVAL", 5, "keyword_constraint", false, false);
        QUERY_REWRITE = new KnownSearchExpansion("QUERY_REWRITE", 6, "query_rewrite", true, false);
        QUERY_SPELL_AUTO_CORRECT = new KnownSearchExpansion("QUERY_SPELL_AUTO_CORRECT", 7, "spell_auto_correct", true, true);
        CATCH_ALL = new KnownSearchExpansion("CATCH_ALL", 8, "*", true, true);
        $VALUES = (new KnownSearchExpansion[] {
            SPELL_CHECK_AUTO, SPELL_CHECK_SUGGESTED, CATEGORY_AUTORUN_NULL, CATEGORY_LOW_RESULT, CROSS_BORDER, KEYWORD_REMOVAL, QUERY_REWRITE, QUERY_SPELL_AUTO_CORRECT, CATCH_ALL
        });
    }
}
