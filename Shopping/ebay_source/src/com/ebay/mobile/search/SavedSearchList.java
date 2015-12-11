// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import android.content.Context;
import android.text.TextUtils;
import com.ebay.common.Preferences;
import com.ebay.common.model.search.EbayCategorySummary;
import com.ebay.common.model.search.SavedSearch;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.notifications.NotificationPreferenceManager;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SavedSearchList
{

    static final boolean $assertionsDisabled;
    public static final DateFormat DATE_FORMATTER = DateFormat.getDateTimeInstance(3, 3);
    private static Object lock = new Object();
    private List searchList;

    public SavedSearchList()
    {
        searchList = new ArrayList();
    }

    private final int getNameMatchesKeywordsCount(String s)
    {
        if (!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        int j = 0;
_L4:
        return j;
_L2:
        int i = 0;
        Iterator iterator = searchList.iterator();
        do
        {
            j = i;
            if (!iterator.hasNext())
            {
                continue;
            }
            String s1 = ((SavedSearch)iterator.next()).name;
            if (!TextUtils.isEmpty(s1) && s1.equals(s))
            {
                i++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private NotificationPreferenceManager getNotifPrefs(Context context)
    {
        return new NotificationPreferenceManager(context);
    }

    private Preferences getPrefs()
    {
        return MyApp.getPrefs();
    }

    private final int getSellerIdDupCount(String s)
    {
        int i = 0;
        Iterator iterator = searchList.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s1 = ((SavedSearch)iterator.next()).searchParameters.sellerId;
            if (!TextUtils.isEmpty(s1) && s1.equals(s))
            {
                i++;
            }
        } while (true);
        return i;
    }

    private String suggestFromCateoryName(String s)
    {
        Object obj = getPositions(s);
        if (((List) (obj)).size() == 0)
        {
            return s;
        }
        int i = ((List) (obj)).size();
        obj = (new StringBuilder()).append(s).append(' ').append(i + 1).toString();
        if (!contains(((String) (obj))))
        {
            return ((String) (obj));
        } else
        {
            return (new StringBuilder()).append(s).append(' ').append(suggestFromTimestamp()).toString();
        }
    }

    private String suggestFromKeywords(String s)
    {
        String s1;
        if (TextUtils.isEmpty(s))
        {
            s1 = suggestFromTimestamp();
        } else
        {
            s1 = s;
            if (contains(s))
            {
                int i = getNameMatchesKeywordsCount(s);
                int j = 0;
                for (i++; j < 5; i++)
                {
                    String s2 = (new StringBuilder()).append(s).append(' ').append(i).toString();
                    if (!contains(s2))
                    {
                        return s2;
                    }
                    j++;
                }

                return (new StringBuilder()).append(s).append(' ').append(suggestFromTimestamp()).toString();
            }
        }
        return s1;
    }

    private String suggestFromSellerId(String s, String s1)
    {
        String s2 = (new StringBuilder()).append(s1).append(s).toString();
        if (!contains(s2))
        {
            return s2;
        }
        int i = getSellerIdDupCount(s);
        int j = 0;
        for (i++; j < 5; i++)
        {
            String s3 = (new StringBuilder()).append(s2).append(' ').append(i).toString();
            if (!contains(s3))
            {
                return s3;
            }
            j++;
        }

        return (new StringBuilder()).append(s1).append(s).append(' ').append(suggestFromTimestamp()).toString();
    }

    private final String suggestFromTimestamp()
    {
        return DATE_FORMATTER.format(new Date());
    }

    private String suggestUniqueName(String s, String s1, String s2, String s3)
    {
        if (!TextUtils.isEmpty(s2))
        {
            return suggestFromSellerId(s2, s3);
        }
        if (!TextUtils.isEmpty(s1) && TextUtils.isEmpty(s))
        {
            return suggestFromCateoryName(s1);
        } else
        {
            return suggestFromKeywords(s);
        }
    }

    public int add(SavedSearch savedsearch)
    {
        searchList.add(0, savedsearch);
        return 0;
    }

    public final boolean contains(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return true;
        }
        for (Iterator iterator = searchList.iterator(); iterator.hasNext();)
        {
            if (s.equals(((SavedSearch)iterator.next()).name))
            {
                return true;
            }
        }

        return false;
    }

    public SavedSearch get(int i)
    {
        if (i < 0 || i >= searchList.size())
        {
            return null;
        } else
        {
            return (SavedSearch)searchList.get(i);
        }
    }

    public SavedSearch getById(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            int j = searchList.size();
            int i = 0;
            while (i < j) 
            {
                SavedSearch savedsearch = (SavedSearch)searchList.get(i);
                if (savedsearch.id != null && savedsearch.id.equals(s))
                {
                    return (SavedSearch)searchList.get(i);
                }
                i++;
            }
        }
        return null;
    }

    public final List getPositions(String s)
    {
        ArrayList arraylist = new ArrayList();
        if (!TextUtils.isEmpty(s))
        {
            int i = searchList.size() - 1;
            while (i >= 0) 
            {
                if (((SavedSearch)searchList.get(i)).name.equals(s))
                {
                    arraylist.add(Integer.valueOf(i));
                }
                i--;
            }
        }
        return arraylist;
    }

    public final List getSearchList()
    {
        return searchList;
    }

    public final void remove(Context context, int i)
    {
        this;
        JVM INSTR monitorenter ;
        if (i >= 0)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        if (i >= searchList.size())
        {
            break MISSING_BLOCK_LABEL_61;
        }
        getNotifPrefs(context).removeNotifyEnabledSavedSearchId(getPrefs().getCurrentUser(), ((SavedSearch)searchList.get(i)).id);
        searchList.remove(i);
        this;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    public final void removeById(Context context, String s)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = TextUtils.isEmpty(s);
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        int j = searchList.size();
        int i = 0;
_L4:
        if (i >= j) goto _L1; else goto _L3
_L3:
        SavedSearch savedsearch = (SavedSearch)searchList.get(i);
        if (savedsearch.id == null || !savedsearch.id.equals(s))
        {
            break MISSING_BLOCK_LABEL_106;
        }
        searchList.remove(i);
        getNotifPrefs(context).removeNotifyEnabledSavedSearchId(getPrefs().getCurrentUser(), s);
          goto _L1
        context;
        throw context;
        i++;
          goto _L4
    }

    public void reset()
    {
        searchList.clear();
    }

    public void setSearchList(List list)
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        if (list.isEmpty())
        {
            break MISSING_BLOCK_LABEL_42;
        }
        searchList.clear();
        searchList.addAll(list);
_L2:
        obj;
        JVM INSTR monitorexit ;
        return;
        reset();
        if (true) goto _L2; else goto _L1
_L1:
        list;
        obj;
        JVM INSTR monitorexit ;
        throw list;
    }

    public int size()
    {
        return searchList.size();
    }

    public String suggestUniqueName(SearchParameters searchparameters, String s)
    {
        if (!$assertionsDisabled && searchparameters == null)
        {
            throw new AssertionError();
        }
        String s1 = null;
        if (searchparameters.category != null)
        {
            s1 = searchparameters.category.name;
        }
        return suggestUniqueName(searchparameters.keywords, s1, searchparameters.sellerId, s);
    }

    static 
    {
        boolean flag;
        if (!com/ebay/mobile/search/SavedSearchList.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }
}
