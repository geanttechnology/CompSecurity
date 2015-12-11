// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.Suggestion;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class SuggestionEntity extends RetailSearchEntity
    implements Suggestion
{

    private int confidence;
    private List departments;
    private List source;
    private int spellCorrected;
    private String suggestion;

    public SuggestionEntity()
    {
    }

    public int getConfidence()
    {
        return confidence;
    }

    public List getDepartments()
    {
        return departments;
    }

    public List getSource()
    {
        return source;
    }

    public int getSpellCorrected()
    {
        return spellCorrected;
    }

    public String getSuggestion()
    {
        return suggestion;
    }

    public void setConfidence(int i)
    {
        confidence = i;
    }

    public void setDepartments(List list)
    {
        departments = list;
    }

    public void setSource(List list)
    {
        source = list;
    }

    public void setSpellCorrected(int i)
    {
        spellCorrected = i;
    }

    public void setSuggestion(String s)
    {
        suggestion = s;
    }
}
