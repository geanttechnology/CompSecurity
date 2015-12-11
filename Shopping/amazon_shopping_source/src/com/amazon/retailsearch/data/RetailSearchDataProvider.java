// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data;

import android.graphics.Bitmap;
import android.text.Html;
import android.text.TextUtils;
import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;
import com.amazon.retailsearch.data.assets.AssetFetchType;
import com.amazon.retailsearch.data.assets.AssetsLoader;
import com.amazon.retailsearch.data.assets.SRDSAssetsLoader;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.util.UrlUtils;
import com.amazon.searchapp.retailsearch.client.SearchConfiguration;
import com.amazon.searchapp.retailsearch.client.SearchRealm;
import com.amazon.searchapp.retailsearch.entity.PersonalizedSuggestionsEntity;
import com.amazon.searchapp.retailsearch.model.PersonalizedSuggestions;
import com.amazon.searchapp.retailsearch.model.SearchSuggestions;
import com.amazon.searchapp.retailsearch.model.SearchedText;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.amazon.retailsearch.data:
//            IRetailSearchDataProvider, PersonalizedSuggestionLoader, SearchSuggestionLoader

public class RetailSearchDataProvider
    implements IRetailSearchDataProvider
{

    private static final String ALIAS_APS = "aps";
    public static final String WORD_MATCHING_PATTERN = "(^|(?:\\s))";
    private final AssetsLoader assetsLoader = new SRDSAssetsLoader();
    FeatureConfiguration featureConfig;
    private PersonalizedSuggestions personalizedSuggestions;
    private Map searchSuggestionsMap;

    public RetailSearchDataProvider()
    {
        searchSuggestionsMap = new HashMap();
        personalizedSuggestions = null;
        RetailSearchDaggerGraphController.inject(this);
    }

    private boolean isKeywordsMatchQuery(String s, String s1, Pattern pattern)
    {
        if (TextUtils.isEmpty(s) || TextUtils.isEmpty(s1))
        {
            return false;
        }
        String s2 = SearchConfiguration.getConfiguration().getRealm().getLocale();
        if (Locale.CHINA.toString().equals(s2) || Locale.JAPAN.toString().equals(s2))
        {
            return s.toLowerCase().contains(s1.toLowerCase());
        } else
        {
            return pattern.matcher(s.toLowerCase()).find();
        }
    }

    public void clearAssets()
    {
        assetsLoader.clear();
    }

    public void clearSuggestions()
    {
        searchSuggestionsMap.clear();
        personalizedSuggestions = null;
    }

    public PersonalizedSuggestions deletePersonalizedSuggestions(String s, String s1)
    {
        Object obj1 = null;
        this;
        JVM INSTR monitorenter ;
        Object obj = obj1;
        if (TextUtils.isEmpty(s1)) goto _L2; else goto _L1
_L1:
        boolean flag = TextUtils.isEmpty(s);
        if (!flag) goto _L4; else goto _L3
_L3:
        obj = obj1;
_L2:
        this;
        JVM INSTR monitorexit ;
        return ((PersonalizedSuggestions) (obj));
_L4:
        String s2;
        s2 = UrlUtils.getParameterValue(s1, "r");
        s1 = UrlUtils.getParameterValue(s1, "k");
        obj = obj1;
        if (TextUtils.isEmpty(s2)) goto _L2; else goto _L5
_L5:
        obj = obj1;
        if (TextUtils.isEmpty(s1)) goto _L2; else goto _L6
_L6:
        if (personalizedSuggestions != null && personalizedSuggestions.getSearchedText() != null)
        {
            obj = personalizedSuggestions.getSearchedText().iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                if (s.equals(((SearchedText)((Iterator) (obj)).next()).getId()))
                {
                    ((Iterator) (obj)).remove();
                }
            } while (true);
        }
        break MISSING_BLOCK_LABEL_147;
        s;
        throw s;
        obj = (new PersonalizedSuggestionLoader()).deletePersonalizedSuggestions(s2, s1);
          goto _L2
    }

    public void fetchAssets(AssetFetchType assetfetchtype)
    {
        assetsLoader.load(assetfetchtype);
    }

    public Bitmap getBadge(String s)
    {
        Map map = assetsLoader.getBadges();
        if (map != null)
        {
            return (Bitmap)map.get(s);
        } else
        {
            return null;
        }
    }

    public PersonalizedSuggestions getPersonalizedSuggestions(String s)
    {
        return getPersonalizedSuggestions(s, false);
    }

    public PersonalizedSuggestions getPersonalizedSuggestions(String s, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_186;
        }
        Object obj1;
        personalizedSuggestions = (new PersonalizedSuggestionLoader()).getPersonalizedSuggestions();
        if (personalizedSuggestions == null || personalizedSuggestions.getSearchedText() == null)
        {
            break MISSING_BLOCK_LABEL_186;
        }
        HashMap hashmap = new HashMap();
        obj1 = new ArrayList();
        Iterator iterator = personalizedSuggestions.getSearchedText().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            SearchedText searchedtext = (SearchedText)iterator.next();
            String s1 = searchedtext.getKeywords();
            if (!TextUtils.isEmpty(s1) && !hashmap.containsKey(s1))
            {
                searchedtext.setAlias("aps");
                searchedtext.setKeywords(Html.fromHtml(s1).toString());
                ((List) (obj1)).add(searchedtext);
                hashmap.put(s1, s1);
            }
        } while (true);
        break MISSING_BLOCK_LABEL_175;
        s;
        throw s;
        personalizedSuggestions.setSearchedText(((List) (obj1)));
        if (personalizedSuggestions != null && !TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        Object obj = personalizedSuggestions;
_L4:
        this;
        JVM INSTR monitorexit ;
        return ((PersonalizedSuggestions) (obj));
_L2:
        obj1 = new PersonalizedSuggestionsEntity();
        obj = obj1;
        ArrayList arraylist;
        if (personalizedSuggestions.getSearchedText() == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = Pattern.compile((new StringBuilder()).append("(^|(?:\\s))").append(Pattern.quote(s.toLowerCase())).toString());
        arraylist = new ArrayList();
        Iterator iterator1 = personalizedSuggestions.getSearchedText().iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            SearchedText searchedtext1 = (SearchedText)iterator1.next();
            if (isKeywordsMatchQuery(searchedtext1.getKeywords(), s, ((Pattern) (obj))))
            {
                arraylist.add(searchedtext1);
            }
        } while (true);
        ((PersonalizedSuggestions) (obj1)).setSearchedText(arraylist);
        obj = obj1;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public SearchSuggestions getSearchSuggestions(String s, String s1, String s2)
    {
        Object obj = null;
        this;
        JVM INSTR monitorenter ;
        boolean flag = TextUtils.isEmpty(s2);
        if (!flag) goto _L2; else goto _L1
_L1:
        s = obj;
_L4:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        StringBuilder stringbuilder = new StringBuilder();
        String s3;
        if (TextUtils.isEmpty(s1))
        {
            s3 = "aps";
        } else
        {
            s3 = s1;
        }
        s3 = stringbuilder.append(s3).append("-").append(s2).toString();
        if (searchSuggestionsMap.containsKey(s3))
        {
            s = (SearchSuggestions)searchSuggestionsMap.get(s3);
            continue; /* Loop/switch isn't completed */
        }
        s1 = (new SearchSuggestionLoader()).setSearchAlias(s1).setQuery(s2).setClientID(s).getSearchSuggestions();
        s = obj;
        if (s1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        searchSuggestionsMap.put(s3, s1);
        s = s1;
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }
}
