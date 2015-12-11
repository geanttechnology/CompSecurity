// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.tagmanager:
//            ResourceUtil

public static class <init>
{

    private final List mAddMacroRuleNames;
    private final List mAddMacros;
    private final List mAddTagRuleNames;
    private final List mAddTags;
    private final List mNegativePredicates;
    private final List mPositivePredicates;
    private final List mRemoveMacroRuleNames;
    private final List mRemoveMacros;
    private final List mRemoveTagRuleNames;
    private final List mRemoveTags;

    public static uilder newBuilder()
    {
        return new uilder(null);
    }

    public List getAddMacroRuleNames()
    {
        return mAddMacroRuleNames;
    }

    public List getAddMacros()
    {
        return mAddMacros;
    }

    public List getAddTagRuleNames()
    {
        return mAddTagRuleNames;
    }

    public List getAddTags()
    {
        return mAddTags;
    }

    public List getNegativePredicates()
    {
        return mNegativePredicates;
    }

    public List getPositivePredicates()
    {
        return mPositivePredicates;
    }

    public List getRemoveMacroRuleNames()
    {
        return mRemoveMacroRuleNames;
    }

    public List getRemoveMacros()
    {
        return mRemoveMacros;
    }

    public List getRemoveTagRuleNames()
    {
        return mRemoveTagRuleNames;
    }

    public List getRemoveTags()
    {
        return mRemoveTags;
    }

    public String toString()
    {
        return (new StringBuilder()).append("Positive predicates: ").append(getPositivePredicates()).append("  Negative predicates: ").append(getNegativePredicates()).append("  Add tags: ").append(getAddTags()).append("  Remove tags: ").append(getRemoveTags()).append("  Add macros: ").append(getAddMacros()).append("  Remove macros: ").append(getRemoveMacros()).toString();
    }

    private uilder(List list, List list1, List list2, List list3, List list4, List list5, List list6, 
            List list7, List list8, List list9)
    {
        mPositivePredicates = Collections.unmodifiableList(list);
        mNegativePredicates = Collections.unmodifiableList(list1);
        mAddTags = Collections.unmodifiableList(list2);
        mRemoveTags = Collections.unmodifiableList(list3);
        mAddMacros = Collections.unmodifiableList(list4);
        mRemoveMacros = Collections.unmodifiableList(list5);
        mAddMacroRuleNames = Collections.unmodifiableList(list6);
        mRemoveMacroRuleNames = Collections.unmodifiableList(list7);
        mAddTagRuleNames = Collections.unmodifiableList(list8);
        mRemoveTagRuleNames = Collections.unmodifiableList(list9);
    }

    mRemoveTagRuleNames(List list, List list1, List list2, List list3, List list4, List list5, List list6, 
            List list7, List list8, List list9, mRemoveTagRuleNames mremovetagrulenames)
    {
        this(list, list1, list2, list3, list4, list5, list6, list7, list8, list9);
    }
}
