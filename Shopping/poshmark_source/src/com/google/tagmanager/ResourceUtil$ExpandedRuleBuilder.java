// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import java.util.ArrayList;
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

    public  addAddMacro( )
    {
        mAddMacros.add();
        return this;
    }

    public mAddMacros addAddMacroRuleName(String s)
    {
        mAddMacroRuleNames.add(s);
        return this;
    }

    public  addAddTag( )
    {
        mAddTags.add();
        return this;
    }

    public mAddTags addAddTagRuleName(String s)
    {
        mAddTagRuleNames.add(s);
        return this;
    }

    public  addNegativePredicate( )
    {
        mNegativePredicates.add();
        return this;
    }

    public  addPositivePredicate( )
    {
        mPositivePredicates.add();
        return this;
    }

    public  addRemoveMacro( )
    {
        mRemoveMacros.add();
        return this;
    }

    public mRemoveMacros addRemoveMacroRuleName(String s)
    {
        mRemoveMacroRuleNames.add(s);
        return this;
    }

    public  addRemoveTag( )
    {
        mRemoveTags.add();
        return this;
    }

    public mRemoveTags addRemoveTagRuleName(String s)
    {
        mRemoveTagRuleNames.add(s);
        return this;
    }

    public mRemoveTagRuleNames build()
    {
        return new mRemoveTagRuleNames(mPositivePredicates, mNegativePredicates, mAddTags, mRemoveTags, mAddMacros, mRemoveMacros, mAddMacroRuleNames, mRemoveMacroRuleNames, mAddTagRuleNames, mRemoveTagRuleNames, null);
    }

    private ()
    {
        mPositivePredicates = new ArrayList();
        mNegativePredicates = new ArrayList();
        mAddTags = new ArrayList();
        mRemoveTags = new ArrayList();
        mAddMacros = new ArrayList();
        mRemoveMacros = new ArrayList();
        mAddMacroRuleNames = new ArrayList();
        mRemoveMacroRuleNames = new ArrayList();
        mAddTagRuleNames = new ArrayList();
        mRemoveTagRuleNames = new ArrayList();
    }

    mRemoveTagRuleNames(mRemoveTagRuleNames mremovetagrulenames)
    {
        this();
    }
}
