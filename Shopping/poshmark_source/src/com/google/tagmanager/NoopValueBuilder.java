// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;


// Referenced classes of package com.google.tagmanager:
//            ValueBuilder, NoopMacroEvaluationInfoBuilder, MacroEvaluationInfoBuilder

class NoopValueBuilder
    implements ValueBuilder
{

    NoopValueBuilder()
    {
    }

    public MacroEvaluationInfoBuilder createValueMacroEvaluationInfoExtension()
    {
        return new NoopMacroEvaluationInfoBuilder();
    }

    public ValueBuilder getListItem(int i)
    {
        return new NoopValueBuilder();
    }

    public ValueBuilder getMapKey(int i)
    {
        return new NoopValueBuilder();
    }

    public ValueBuilder getMapValue(int i)
    {
        return new NoopValueBuilder();
    }

    public ValueBuilder getTemplateToken(int i)
    {
        return new NoopValueBuilder();
    }
}
