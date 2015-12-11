// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.alt;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public abstract class PlayerDefaultTalkListHelper
{

    protected final Context context;
    protected int lastListItemIndex;
    protected boolean moreOrLess;
    protected List results;

    public PlayerDefaultTalkListHelper(Context context1)
    {
        lastListItemIndex = 0;
        moreOrLess = true;
        results = new ArrayList();
        context = context1;
        results.clear();
    }

    public PlayerDefaultTalkListHelper(List list, Context context1)
    {
        lastListItemIndex = 0;
        moreOrLess = true;
        results = new ArrayList();
        context = context1;
        results = list;
    }

    private int offsetIndexValue(int i)
    {
        i = (lastListItemIndex * 5 + i) - 1;
        if (i < results.size())
        {
            return i;
        } else
        {
            return -1;
        }
    }

    public void buildSpeechResponse(StringBuilder stringbuilder)
    {
        if (results == null)
        {
            getResultAreNull(stringbuilder);
            return;
        }
        if (results.size() > 0)
        {
            if (lastListItemIndex == 0)
            {
                getReturnedSomeResultsAtBeginning(stringbuilder);
            } else
            {
                getReturnedSomeResultsAfterBeginning(stringbuilder);
            }
            getResultRowDescriptions(stringbuilder);
            return;
        } else
        {
            getReturnedNoResults(stringbuilder);
            return;
        }
    }

    protected abstract String getItemTypeQuantity(int i);

    public String getLessResults()
    {
        if (results == null)
        {
            return "";
        }
        if (offsetIndexValue(-4) < 0)
        {
            return context.getString(com.xfinity.playerlib.R.string.speech_list_at_beginning);
        } else
        {
            moreOrLess = false;
            lastListItemIndex = lastListItemIndex - 1;
            return speakResults();
        }
    }

    public String getMoreResults()
    {
        if (results == null)
        {
            return "";
        }
        if (offsetIndexValue(6) == -1)
        {
            return context.getString(com.xfinity.playerlib.R.string.speech_list_at_end);
        } else
        {
            moreOrLess = true;
            lastListItemIndex = lastListItemIndex + 1;
            return speakResults();
        }
    }

    protected void getResultAreNull(StringBuilder stringbuilder)
    {
        stringbuilder.delete(0, stringbuilder.length());
        stringbuilder.append(context.getString(com.xfinity.playerlib.R.string.speech_list_helper_default_null_results, new Object[] {
            getItemTypeQuantity(2)
        }));
    }

    protected abstract void getResultRowDescriptions(StringBuilder stringbuilder);

    protected void getReturnedNoResults(StringBuilder stringbuilder)
    {
        stringbuilder.append(context.getString(com.xfinity.playerlib.R.string.speech_list_helper_returned_no_x, new Object[] {
            getItemTypeQuantity(2)
        }));
    }

    protected void getReturnedSomeResultsAfterBeginning(StringBuilder stringbuilder)
    {
        if (results.size() - lastListItemIndex * 5 == 1)
        {
            stringbuilder.append(context.getString(com.xfinity.playerlib.R.string.speech_list_one_item_left));
            return;
        }
        if (results.size() - (lastListItemIndex * 5 + 1) < 4)
        {
            stringbuilder.append(context.getString(com.xfinity.playerlib.R.string.speech_list_last_results, new Object[] {
                Integer.valueOf(results.size() - lastListItemIndex * 5), getItemTypeQuantity(2)
            }));
            return;
        }
        Context context1 = context;
        int i = com.xfinity.playerlib.R.string.speech_list_some_results_after_beginning;
        String s;
        if (moreOrLess)
        {
            s = context.getString(com.xfinity.playerlib.R.string.speech_next);
        } else
        {
            s = context.getString(com.xfinity.playerlib.R.string.speech_previous);
        }
        stringbuilder.append(context1.getString(i, new Object[] {
            s, Integer.valueOf(5), getItemTypeQuantity(2)
        }));
    }

    protected void getReturnedSomeResultsAtBeginning(StringBuilder stringbuilder)
    {
        stringbuilder.append(context.getString(com.xfinity.playerlib.R.string.speech_list_helper_returned_some_x, new Object[] {
            Integer.valueOf(results.size()), getItemTypeQuantity(results.size())
        }));
        if (results.size() >= 5)
        {
            stringbuilder.append(context.getString(com.xfinity.playerlib.R.string.speech_list_helper_start_count, new Object[] {
                Integer.valueOf(5), getItemTypeQuantity(2)
            }));
        }
    }

    public abstract String speakResults();
}
