// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.alt;

import android.content.Context;
import android.content.res.Resources;
import com.comcast.cim.cmasl.utils.CommonUtils;
import com.comcast.cim.cmasl.utils.container.Tuple;
import com.comcast.cim.cmasl.utils.provider.Provider;
import com.xfinity.playerlib.view.search.SearchQuery;
import com.xfinity.playerlib.view.search.SearchResultsFragment;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.alt:
//            PlayerDefaultTalkListHelper

public class PlayerSearchTalkListHelper extends PlayerDefaultTalkListHelper
{

    private final Provider searchQueryProvider;
    private final SearchResultsFragment searchResultsFragment;

    public PlayerSearchTalkListHelper(Context context)
    {
        super(context);
        searchResultsFragment = null;
        searchQueryProvider = null;
    }

    public PlayerSearchTalkListHelper(SearchResultsFragment searchresultsfragment, Provider provider, List list)
    {
        super(list, searchresultsfragment.getActivity());
        searchResultsFragment = searchresultsfragment;
        searchQueryProvider = provider;
    }

    protected String getItemTypeQuantity(int i)
    {
        return context.getResources().getQuantityString(com.xfinity.playerlib.R.plurals.speech_result, i);
    }

    protected void getResultRowDescriptions(StringBuilder stringbuilder)
    {
        int i = lastListItemIndex * 5;
        do
        {
label0:
            {
                if (i < results.size())
                {
                    Tuple tuple = (Tuple)CommonUtils.uncheckedCast(results.get(i));
                    stringbuilder.append(searchResultsFragment.getVideoContentDescription(tuple, i, results.size()));
                    if (i != lastListItemIndex * 5 + 4)
                    {
                        break label0;
                    }
                }
                return;
            }
            i++;
        } while (true);
    }

    public String speakResults()
    {
        String s = ((SearchQuery)searchQueryProvider.get()).getTitleFilter();
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(context.getString(com.xfinity.playerlib.R.string.speech_search_terms));
        stringbuilder.append(s);
        stringbuilder.append(". ");
        buildSpeechResponse(stringbuilder);
        return stringbuilder.toString();
    }
}
