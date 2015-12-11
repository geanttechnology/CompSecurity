// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.tagmanager:
//            ResolvedRuleBuilder, DebugValueBuilder, DebugResolvedFunctionCallBuilder, ResolvedFunctionCallTranslatorList, 
//            ResolvedFunctionCallBuilder

class DebugResolvedRuleBuilder
    implements ResolvedRuleBuilder
{
    class DebugResolvedFunctionCallListTranslator
        implements ResolvedFunctionCallTranslatorList
    {

        final DebugResolvedRuleBuilder this$0;
        List toBuild;

        public void translateAndAddAll(List list, List list1)
        {
            int i = 0;
            while (i < list.size()) 
            {
                toBuild.add(DebugResolvedRuleBuilder.translateExpandedFunctionCall((ResourceUtil.ExpandedFunctionCall)list.get(i)));
                if (i < list1.size())
                {
                    ((com.google.analytics.containertag.proto.MutableDebug.ResolvedFunctionCall)toBuild.get(i)).setAssociatedRuleName((String)list1.get(i));
                } else
                {
                    ((com.google.analytics.containertag.proto.MutableDebug.ResolvedFunctionCall)toBuild.get(i)).setAssociatedRuleName("Unknown");
                }
                i++;
            }
        }

        DebugResolvedFunctionCallListTranslator(List list)
        {
            this$0 = DebugResolvedRuleBuilder.this;
            super();
            toBuild = list;
        }
    }


    ResolvedFunctionCallTranslatorList addMacrosHolder;
    ResolvedFunctionCallTranslatorList addTagsHolder;
    ResolvedFunctionCallTranslatorList removeMacrosHolder;
    ResolvedFunctionCallTranslatorList removeTagsHolder;
    com.google.analytics.containertag.proto.MutableDebug.ResolvedRule resolvedRule;

    public DebugResolvedRuleBuilder(com.google.analytics.containertag.proto.MutableDebug.ResolvedRule resolvedrule)
    {
        resolvedRule = resolvedrule;
        addMacrosHolder = new DebugResolvedFunctionCallListTranslator(resolvedRule.getMutableAddMacrosList());
        removeMacrosHolder = new DebugResolvedFunctionCallListTranslator(resolvedRule.getMutableRemoveMacrosList());
        addTagsHolder = new DebugResolvedFunctionCallListTranslator(resolvedRule.getMutableAddTagsList());
        removeTagsHolder = new DebugResolvedFunctionCallListTranslator(resolvedRule.getMutableRemoveTagsList());
    }

    public static com.google.analytics.containertag.proto.MutableDebug.ResolvedFunctionCall translateExpandedFunctionCall(ResourceUtil.ExpandedFunctionCall expandedfunctioncall)
    {
        com.google.analytics.containertag.proto.MutableDebug.ResolvedFunctionCall resolvedfunctioncall = com.google.analytics.containertag.proto.MutableDebug.ResolvedFunctionCall.newMessage();
        com.google.analytics.containertag.proto.MutableDebug.ResolvedProperty resolvedproperty;
        for (expandedfunctioncall = expandedfunctioncall.getProperties().entrySet().iterator(); expandedfunctioncall.hasNext(); resolvedfunctioncall.addProperties(resolvedproperty))
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)expandedfunctioncall.next();
            resolvedproperty = com.google.analytics.containertag.proto.MutableDebug.ResolvedProperty.newMessage();
            resolvedproperty.setKey((String)entry.getKey());
            resolvedproperty.setValue(DebugValueBuilder.copyImmutableValue((com.google.analytics.midtier.proto.containertag.TypeSystem.Value)entry.getValue()));
        }

        return resolvedfunctioncall;
    }

    public ResolvedFunctionCallBuilder createNegativePredicate()
    {
        return new DebugResolvedFunctionCallBuilder(resolvedRule.addNegativePredicates());
    }

    public ResolvedFunctionCallBuilder createPositivePredicate()
    {
        return new DebugResolvedFunctionCallBuilder(resolvedRule.addPositivePredicates());
    }

    public ResolvedFunctionCallTranslatorList getAddedMacroFunctions()
    {
        return addMacrosHolder;
    }

    public ResolvedFunctionCallTranslatorList getAddedTagFunctions()
    {
        return addTagsHolder;
    }

    public ResolvedFunctionCallTranslatorList getRemovedMacroFunctions()
    {
        return removeMacrosHolder;
    }

    public ResolvedFunctionCallTranslatorList getRemovedTagFunctions()
    {
        return removeTagsHolder;
    }

    public void setValue(com.google.analytics.midtier.proto.containertag.TypeSystem.Value value)
    {
        resolvedRule.setResult(DebugValueBuilder.copyImmutableValue(value));
    }
}
