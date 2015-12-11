// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;

import java.util.List;

public interface Suggestion
{

    public abstract int getConfidence();

    public abstract List getDepartments();

    public abstract List getSource();

    public abstract int getSpellCorrected();

    public abstract String getSuggestion();

    public abstract void setConfidence(int i);

    public abstract void setDepartments(List list);

    public abstract void setSource(List list);

    public abstract void setSpellCorrected(int i);

    public abstract void setSuggestion(String s);
}
