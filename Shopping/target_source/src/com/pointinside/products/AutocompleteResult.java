// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.products;

import com.pointinside.PIException;
import com.pointinside.json.JSONResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.pointinside.products:
//            AutocompleteSuggestion, AutocompleteURLBuilder

public final class AutocompleteResult extends JSONResponse
{

    List mSuggestionTerms;
    List mSuggestions;
    AutocompleteURLBuilder url;

    public AutocompleteResult()
    {
    }

    public AutocompleteResult getData()
    {
        return this;
    }

    public volatile Object getData()
    {
        return getData();
    }

    public List getSuggestions()
    {
        return Collections.unmodifiableList(mSuggestions);
    }

    public List getTerms()
    {
        if (mSuggestionTerms == null)
        {
            mSuggestionTerms = new ArrayList();
            AutocompleteSuggestion autocompletesuggestion;
            for (Iterator iterator = mSuggestions.iterator(); iterator.hasNext(); mSuggestionTerms.add(autocompletesuggestion.getTerm()))
            {
                autocompletesuggestion = (AutocompleteSuggestion)iterator.next();
            }

        }
        return Collections.unmodifiableList(mSuggestionTerms);
    }

    int originalIndexFromSuggestion(AutocompleteSuggestion autocompletesuggestion)
        throws PIException
    {
        int i = mSuggestions.indexOf(autocompletesuggestion) + 1;
        if (i < 1)
        {
            throw new PIException((new StringBuilder()).append("Suggestion could not be found for ").append(autocompletesuggestion.getTerm()).toString());
        } else
        {
            return i;
        }
    }

    AutocompleteSuggestion originalIndexFromTerm(String s)
    {
        try
        {
            int i = mSuggestionTerms.indexOf(s);
            s = (AutocompleteSuggestion)mSuggestions.get(i);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }
}
