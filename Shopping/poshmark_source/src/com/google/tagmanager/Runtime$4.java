// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import java.util.Set;

// Referenced classes of package com.google.tagmanager:
//            Runtime, ResolvedRuleBuilder, ResolvedFunctionCallTranslatorList

class this._cls0
    implements dRemoveSetPopulator
{

    final Runtime this$0;

    public void rulePassed(il.ExpandedRule expandedrule, Set set, Set set1, ResolvedRuleBuilder resolvedrulebuilder)
    {
        set.addAll(expandedrule.getAddTags());
        set1.addAll(expandedrule.getRemoveTags());
        resolvedrulebuilder.getAddedTagFunctions().translateAndAddAll(expandedrule.getAddTags(), expandedrule.getAddTagRuleNames());
        resolvedrulebuilder.getRemovedTagFunctions().translateAndAddAll(expandedrule.getRemoveTags(), expandedrule.getRemoveTagRuleNames());
    }

    leBuilder()
    {
        this$0 = Runtime.this;
        super();
    }
}
