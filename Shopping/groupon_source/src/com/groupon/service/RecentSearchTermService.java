// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.SharedPreferences;
import com.groupon.models.SearchTermAndCategory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecentSearchTermService
{

    private List recentlySearchedTerms;
    private SharedPreferences sharedPrefs;

    public RecentSearchTermService()
    {
    }

    private void saveRecentlySearchedTermsToPrefs()
    {
        android.content.SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt("recentlySearchedTermsCount", recentlySearchedTerms.size());
        for (int i = 0; i < recentlySearchedTerms.size(); i++)
        {
            editor.remove((new StringBuilder()).append("recentlySearchedTerms_").append(i).toString());
            editor.remove((new StringBuilder()).append("recentlySearchedTermsCategories_").append(i).toString());
            editor.putString((new StringBuilder()).append("recentlySearchedTerms_").append(i).toString(), ((SearchTermAndCategory)recentlySearchedTerms.get(i)).getSearchTerm());
            editor.putString((new StringBuilder()).append("recentlySearchedTermsCategories_").append(i).toString(), ((SearchTermAndCategory)recentlySearchedTerms.get(i)).getSearchCategory());
        }

        editor.apply();
    }

    public ArrayList addRecentlySearchedTerm(String s, String s1)
    {
        s = new SearchTermAndCategory(s, s1);
        if (!recentlySearchedTerms.contains(s))
        {
            recentlySearchedTerms.add(s);
            if (recentlySearchedTerms.size() == 6)
            {
                recentlySearchedTerms.remove(0);
            }
        } else
        {
            int i = recentlySearchedTerms.indexOf(s);
            recentlySearchedTerms.remove(i);
            recentlySearchedTerms.add(s);
        }
        saveRecentlySearchedTermsToPrefs();
        s = new ArrayList(recentlySearchedTerms);
        Collections.reverse(s);
        return s;
    }

    public List getRecentlySearchedTerms(boolean flag)
    {
        ArrayList arraylist = new ArrayList();
        int k = sharedPrefs.getInt("recentlySearchedTermsCount", 0);
        if (k > 0)
        {
            if (flag)
            {
                for (int i = k - 1; i >= 0; i--)
                {
                    arraylist.add(new SearchTermAndCategory(sharedPrefs.getString((new StringBuilder()).append("recentlySearchedTerms_").append(i).toString(), ""), sharedPrefs.getString((new StringBuilder()).append("recentlySearchedTermsCategories_").append(i).toString(), "")));
                }

            } else
            {
                for (int j = 0; j < k; j++)
                {
                    arraylist.add(new SearchTermAndCategory(sharedPrefs.getString((new StringBuilder()).append("recentlySearchedTerms_").append(j).toString(), ""), sharedPrefs.getString((new StringBuilder()).append("recentlySearchedTermsCategories_").append(j).toString(), "")));
                }

            }
        }
        return arraylist;
    }

    public void init()
    {
        ArrayList arraylist;
        if (sharedPrefs.contains("recentlySearchedTermsCount"))
        {
            arraylist = new ArrayList(getRecentlySearchedTerms(false));
        } else
        {
            arraylist = new ArrayList();
        }
        recentlySearchedTerms = arraylist;
    }
}
