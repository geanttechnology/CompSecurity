// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;


// Referenced classes of package com.google.tagmanager:
//            ResolvedFunctionCallBuilder, ResolvedFunctionCallTranslatorList

interface ResolvedRuleBuilder
{

    public abstract ResolvedFunctionCallBuilder createNegativePredicate();

    public abstract ResolvedFunctionCallBuilder createPositivePredicate();

    public abstract ResolvedFunctionCallTranslatorList getAddedMacroFunctions();

    public abstract ResolvedFunctionCallTranslatorList getAddedTagFunctions();

    public abstract ResolvedFunctionCallTranslatorList getRemovedMacroFunctions();

    public abstract ResolvedFunctionCallTranslatorList getRemovedTagFunctions();

    public abstract void setValue(com.google.analytics.midtier.proto.containertag.TypeSystem.Value value);
}
