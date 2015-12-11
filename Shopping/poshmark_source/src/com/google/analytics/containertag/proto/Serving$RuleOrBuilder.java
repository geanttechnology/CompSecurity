// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.containertag.proto;

import com.google.tagmanager.protobuf.MessageLiteOrBuilder;
import java.util.List;

// Referenced classes of package com.google.analytics.containertag.proto:
//            Serving

public static interface 
    extends MessageLiteOrBuilder
{

    public abstract int getAddMacro(int i);

    public abstract int getAddMacroCount();

    public abstract List getAddMacroList();

    public abstract int getAddMacroRuleName(int i);

    public abstract int getAddMacroRuleNameCount();

    public abstract List getAddMacroRuleNameList();

    public abstract int getAddTag(int i);

    public abstract int getAddTagCount();

    public abstract List getAddTagList();

    public abstract int getAddTagRuleName(int i);

    public abstract int getAddTagRuleNameCount();

    public abstract List getAddTagRuleNameList();

    public abstract int getNegativePredicate(int i);

    public abstract int getNegativePredicateCount();

    public abstract List getNegativePredicateList();

    public abstract int getPositivePredicate(int i);

    public abstract int getPositivePredicateCount();

    public abstract List getPositivePredicateList();

    public abstract int getRemoveMacro(int i);

    public abstract int getRemoveMacroCount();

    public abstract List getRemoveMacroList();

    public abstract int getRemoveMacroRuleName(int i);

    public abstract int getRemoveMacroRuleNameCount();

    public abstract List getRemoveMacroRuleNameList();

    public abstract int getRemoveTag(int i);

    public abstract int getRemoveTagCount();

    public abstract List getRemoveTagList();

    public abstract int getRemoveTagRuleName(int i);

    public abstract int getRemoveTagRuleNameCount();

    public abstract List getRemoveTagRuleNameList();
}
