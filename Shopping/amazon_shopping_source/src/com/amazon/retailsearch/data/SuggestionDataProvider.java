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

    private static final int MAX_AUX_SUGGESTIONS_ON_SEARCH = 2;
    private static final int MAX_SUGGESTIONS = 6;
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
label0:
        do
        {
            SuggestionDataItem suggestiondataitem;
            String s1;
            do
            {
                if (!list1.hasNext())
                {
                    break label0;
                }
                suggestiondataitem = (SuggestionDataItem)list1.next();
                s1 = suggestiondataitem.getDisplayText();
            } while (hashset.contains(s1));
            arraylist.add(suggestiondataitem);
            hashset.add(s1);
        } while (arraylist.size() != 2);
        list = list.iterator();
label1:
        do
        {
            String s;
            do
            {
                if (!list.hasNext())
                {
                    break label1;
                }
                list1 = (SuggestionDataItem)list.next();
                s = list1.getDisplayText();
                if (!hashset.contains(s))
                {
                    break;
                }
                updateMergedSuggestions(s, arraylist, list1);
            } while (true);
            arraylist.add(list1);
            hashset.add(s);
        } while (arraylist.size() != 6);
        return arraylist;
    }

    private void updateMergedSuggestions(String s, List list, SuggestionDataItem suggestiondataitem)
    {
        if (!TextUtils.isEmpty(s) && list != null && suggestiondataitem != null)
        {
            int i = 0;
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) 
            {
                SuggestionDataItem suggestiondataitem1 = (SuggestionDataItem)iterator.next();
                if (s.equals(suggestiondataitem1.getDisplayText()))
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

    public List getPastSearches(String s, boolean flag)
    {
        ArrayList arraylist = new ArrayList();
        s = searchDataProvider.getPersonalizedSuggestions(s, flag);
        if (s != null && s.getSearchedText() != null)
        {
            s = s.getSearchedText().iterator();
            while (s.hasNext()) 
            {
                SearchedText searchedtext = (SearchedText)s.next();
                SuggestionDataItem suggestiondataitem = new SuggestionDataItem();
                suggestiondataitem.setId(searchedtext.getId());
                suggestiondataitem.setSuggestion(searchedtext.getKeywords());
                suggestiondataitem.setDisplayText(searchedtext.getKeywords());
                suggestiondataitem.setSearchAlias(searchedtext.getAlias());
                suggestiondataitem.setDepartmentName(searchedtext.getDisplayAlias());
                suggestiondataitem.setDeleteURL(searchedtext.getDeleteUrl());
                suggestiondataitem.setType(SuggestionDataItem.SuggestionType.PAST_SEARCHES);
                arraylist.add(suggestiondataitem);
            }
        }
        return arraylist;
    }

    public List getSearchSuggestions(String s, String s1)
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
                    boolean flag;
                    boolean flag1;
label0:
                    {
                        suggestion = (Suggestion)s.next();
                        Object obj;
                        Object obj1;
                        boolean flag2;
                        if (suggestion.getSpellCorrected() == 1)
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        flag2 = false;
                        flag1 = flag2;
                        if (suggestion.getSource() == null)
                        {
                            break label0;
                        }
                        obj = suggestion.getSource().iterator();
                        do
                        {
                            flag1 = flag2;
                            if (!((Iterator) (obj)).hasNext())
                            {
                                break label0;
                            }
                        } while (!"fb".equals((String)((Iterator) (obj)).next()));
                        flag1 = true;
                    }
                    obj = new SuggestionDataItem();
                    ((SuggestionDataItem) (obj)).setSuggestion(suggestion.getSuggestion());
                    ((SuggestionDataItem) (obj)).setDisplayText(suggestion.getSuggestion());
                    ((SuggestionDataItem) (obj)).setType(SuggestionDataItem.SuggestionType.A9_SUGGESTION);
                    ((SuggestionDataItem) (obj)).setQuery(s1);
                    ((SuggestionDataItem) (obj)).setPos(i);
                    ((SuggestionDataItem) (obj)).setSpellCorrected(flag);
                    ((SuggestionDataItem) (obj)).setXcat(false);
                    ((SuggestionDataItem) (obj)).setFallback(flag1);
                    arraylist.add(obj);
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
                                suggestiondataitem.setSuggestion(suggestion.getSuggestion());
                                suggestiondataitem.setDisplayText((new StringBuilder()).append(suggestion.getSuggestion()).append(" ").append(stringIn).append(" ").append(suggestiondepartment.getName()).toString());
                                suggestiondataitem.setDepartmentName(suggestiondepartment.getName());
                                suggestiondataitem.setSearchAlias(suggestiondepartment.getAlias());
                                suggestiondataitem.setType(SuggestionDataItem.SuggestionType.A9_SUGGESTION);
                                suggestiondataitem.setPos(i);
                                suggestiondataitem.setXcatPos(j);
                                suggestiondataitem.setSpellCorrected(flag);
                                suggestiondataitem.setXcat(true);
                                suggestiondataitem.setFallback(flag1);
                                arraylist.add(suggestiondataitem);
                            }
                            j++;
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
        List list1 = getPastSearches(s1, flag);
        List list = list1;
        if (!TextUtils.isEmpty(s1))
        {
            list = mergeSuggestions(getSearchSuggestions(s, s1), list1);
        }
        return list;
    }

    public List getSuggestions(String s, boolean flag)
    {
        return getSuggestions(null, s, false);
    }
}
