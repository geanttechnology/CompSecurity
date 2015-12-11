// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.amazon.retailsearch.android.util.ResUtils;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.searchapp.retailsearch.model.PersonalizedSuggestions;
import com.amazon.searchapp.retailsearch.model.SearchSuggestions;
import com.amazon.searchapp.retailsearch.model.SearchedText;
import com.amazon.searchapp.retailsearch.model.Suggestion;
import com.amazon.searchapp.retailsearch.model.SuggestionDepartment;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.data:
//            ISuggestionDataProvider, SuggestionDataItem, IRetailSearchDataProvider

public class SuggestionDataProvider
    implements ISuggestionDataProvider
{

    private static final String APS_ALIAS = "aps";
    private static final int MAX_AUX_SUGGESTIONS_ON_SEARCH = 2;
    private final String SPACE;
    private String clientID;
    private Context context;
    IRetailSearchDataProvider searchDataProvider;
    private String stringIn;

    public SuggestionDataProvider()
    {
        stringIn = "in";
        SPACE = " ";
        RetailSearchDaggerGraphController.inject(this);
    }

    public SuggestionDataProvider(Context context1)
    {
        stringIn = "in";
        SPACE = " ";
        context = context1;
        if (context != null)
        {
            stringIn = context1.getResources().getString(com.amazon.retailsearch.R.string.searchbox_in);
            int i = ResUtils.getResourceId(com.amazon.retailsearch.R.string.config_rs_client_id, context1, "strings", "config_rs_client_id");
            clientID = context1.getResources().getString(i);
        }
        RetailSearchDaggerGraphController.inject(this);
    }

    private List mergeSuggestions(List list, List list1)
    {
        ArrayList arraylist = new ArrayList();
        HashSet hashset = new HashSet();
        list1 = list1.iterator();
        do
        {
            if (!list1.hasNext())
            {
                break;
            }
            SuggestionDataItem suggestiondataitem = (SuggestionDataItem)list1.next();
            arraylist.add(suggestiondataitem);
            hashset.add(suggestiondataitem.getKey());
        } while (arraylist.size() != 2);
        for (list = list.iterator(); list.hasNext();)
        {
            list1 = (SuggestionDataItem)list.next();
            SuggestionDataItem.SuggestionKey suggestionkey = list1.getKey();
            if (hashset.contains(suggestionkey))
            {
                updateMergedSuggestions(suggestionkey, arraylist, list1);
            } else
            {
                arraylist.add(list1);
            }
        }

        return arraylist;
    }

    private void updateMergedSuggestions(SuggestionDataItem.SuggestionKey suggestionkey, List list, SuggestionDataItem suggestiondataitem)
    {
        if (suggestionkey == null && list != null && suggestiondataitem != null)
        {
            int i = 0;
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) 
            {
                SuggestionDataItem suggestiondataitem1 = (SuggestionDataItem)iterator.next();
                if (suggestionkey.equals(suggestiondataitem1.getKey()))
                {
                    suggestiondataitem.setType(SuggestionDataItem.SuggestionType.MERGED);
                    suggestiondataitem.setId(suggestiondataitem1.getId());
                    suggestiondataitem.setDeleteURL(suggestiondataitem1.getDeleteURL());
                    list.set(i, suggestiondataitem);
                    return;
                }
                i++;
            }
        }
    }

    public boolean deletePastSearches(String s, String s1)
    {
        if (!TextUtils.isEmpty(s1))
        {
            if ((s = searchDataProvider.deletePersonalizedSuggestions(s, s1)) != null && !TextUtils.isEmpty(s.getRequestId()))
            {
                return true;
            }
        }
        return false;
    }

    public List getPastSearches(String s, String s1, boolean flag)
    {
        ArrayList arraylist = new ArrayList();
        Object obj = searchDataProvider.getPersonalizedSuggestions(s1, flag);
        if (obj != null && ((PersonalizedSuggestions) (obj)).getSearchedText() != null)
        {
            obj = ((PersonalizedSuggestions) (obj)).getSearchedText().iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                SearchedText searchedtext = (SearchedText)((Iterator) (obj)).next();
                String s2 = searchedtext.getAlias();
                if (TextUtils.isEmpty(s) || TextUtils.isEmpty(s2) || TextUtils.equals(s, s2))
                {
                    SuggestionDataItem suggestiondataitem = new SuggestionDataItem();
                    suggestiondataitem.setId(searchedtext.getId());
                    suggestiondataitem.setQuery(s1);
                    suggestiondataitem.setSuggestion(searchedtext.getKeywords());
                    suggestiondataitem.setDisplayText(searchedtext.getKeywords());
                    suggestiondataitem.setSearchAlias(searchedtext.getAlias());
                    suggestiondataitem.setDepartmentName(searchedtext.getDisplayAlias());
                    suggestiondataitem.setDeleteURL(searchedtext.getDeleteUrl());
                    suggestiondataitem.setType(SuggestionDataItem.SuggestionType.PAST_SEARCHES);
                    arraylist.add(suggestiondataitem);
                }
            }
        }
        return arraylist;
    }

    public List getSearchSuggestions(String s, String s1)
    {
        return getSearchSuggestions(s, s1, false);
    }

    public List getSearchSuggestions(String s, String s1, boolean flag)
    {
        ArrayList arraylist = new ArrayList();
        if (!TextUtils.isEmpty(s1))
        {
            if ((s = searchDataProvider.getSearchSuggestions(clientID, s, s1)) != null && s.getSuggestions() != null)
            {
                int i = 1;
                s = s.getSuggestions().iterator();
                while (s.hasNext()) 
                {
                    Suggestion suggestion;
                    boolean flag1;
                    boolean flag2;
label0:
                    {
                        suggestion = (Suggestion)s.next();
                        Object obj;
                        Object obj1;
                        boolean flag3;
                        if (suggestion.getSpellCorrected() == 1)
                        {
                            flag1 = true;
                        } else
                        {
                            flag1 = false;
                        }
                        flag3 = false;
                        flag2 = flag3;
                        if (suggestion.getSource() == null)
                        {
                            break label0;
                        }
                        obj = suggestion.getSource().iterator();
                        do
                        {
                            flag2 = flag3;
                            if (!((Iterator) (obj)).hasNext())
                            {
                                break label0;
                            }
                        } while (!"fb".equals((String)((Iterator) (obj)).next()));
                        flag2 = true;
                    }
                    obj = new SuggestionDataItem();
                    ((SuggestionDataItem) (obj)).setSuggestion(suggestion.getSuggestion());
                    ((SuggestionDataItem) (obj)).setDisplayText(suggestion.getSuggestion());
                    ((SuggestionDataItem) (obj)).setType(SuggestionDataItem.SuggestionType.A9_SUGGESTION);
                    ((SuggestionDataItem) (obj)).setQuery(s1);
                    ((SuggestionDataItem) (obj)).setPos(i);
                    ((SuggestionDataItem) (obj)).setSpellCorrected(flag1);
                    ((SuggestionDataItem) (obj)).setXcat(false);
                    ((SuggestionDataItem) (obj)).setFallback(flag2);
                    arraylist.add(obj);
                    if (!flag)
                    {
                        obj1 = suggestion.getDepartments();
                        if (obj1 != null && ((List) (obj1)).size() > 0)
                        {
                            int j = 1;
                            obj1 = ((List) (obj1)).iterator();
                            while (((Iterator) (obj1)).hasNext()) 
                            {
                                SuggestionDepartment suggestiondepartment = (SuggestionDepartment)((Iterator) (obj1)).next();
                                if ("aps".equals(suggestiondepartment.getAlias()))
                                {
                                    ((SuggestionDataItem) (obj)).setXcatPos(j);
                                } else
                                {
                                    SuggestionDataItem suggestiondataitem = new SuggestionDataItem();
                                    suggestiondataitem.setQuery(s1);
                                    suggestiondataitem.setSuggestion(suggestion.getSuggestion());
                                    suggestiondataitem.setDisplayText((new StringBuilder()).append(suggestion.getSuggestion()).append(" ").append(stringIn).append(" ").append(suggestiondepartment.getName()).toString());
                                    suggestiondataitem.setDepartmentName(suggestiondepartment.getName());
                                    suggestiondataitem.setSearchAlias(suggestiondepartment.getAlias());
                                    suggestiondataitem.setType(SuggestionDataItem.SuggestionType.A9_SUGGESTION);
                                    suggestiondataitem.setPos(i);
                                    suggestiondataitem.setXcatPos(j);
                                    suggestiondataitem.setSpellCorrected(flag1);
                                    suggestiondataitem.setXcat(true);
                                    suggestiondataitem.setFallback(flag2);
                                    arraylist.add(suggestiondataitem);
                                }
                                j++;
                            }
                        }
                    }
                    i++;
                }
            }
        }
_L2:
        return arraylist;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public List getSuggestions(String s)
    {
        return getSuggestions(null, s);
    }

    public List getSuggestions(String s, String s1)
    {
        return getSuggestions(s, s1, false);
    }

    public List getSuggestions(String s, String s1, boolean flag)
    {
        return getSuggestions(s, s1, flag, false);
    }

    public List getSuggestions(String s, String s1, boolean flag, boolean flag1)
    {
        List list1 = getPastSearches(s, s1, flag);
        List list = list1;
        if (!TextUtils.isEmpty(s1))
        {
            list = mergeSuggestions(getSearchSuggestions(s, s1, flag1), list1);
        }
        return list;
    }

    public List getSuggestions(String s, boolean flag)
    {
        return getSuggestions(null, s, flag);
    }
}
