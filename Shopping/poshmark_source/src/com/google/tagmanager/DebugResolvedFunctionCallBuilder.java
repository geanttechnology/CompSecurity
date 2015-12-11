// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;


// Referenced classes of package com.google.tagmanager:
//            ResolvedFunctionCallBuilder, DebugResolvedPropertyBuilder, DebugValueBuilder, ResolvedPropertyBuilder

class DebugResolvedFunctionCallBuilder
    implements ResolvedFunctionCallBuilder
{

    private com.google.analytics.containertag.proto.MutableDebug.ResolvedFunctionCall resolvedFunctionCall;

    public DebugResolvedFunctionCallBuilder(com.google.analytics.containertag.proto.MutableDebug.ResolvedFunctionCall resolvedfunctioncall)
    {
        resolvedFunctionCall = resolvedfunctioncall;
    }

    public ResolvedPropertyBuilder createResolvedPropertyBuilder(String s)
    {
        com.google.analytics.containertag.proto.MutableDebug.ResolvedProperty resolvedproperty = resolvedFunctionCall.addProperties();
        resolvedproperty.setKey(s);
        return new DebugResolvedPropertyBuilder(resolvedproperty);
    }

    public void setFunctionResult(com.google.analytics.midtier.proto.containertag.TypeSystem.Value value)
    {
        resolvedFunctionCall.setResult(DebugValueBuilder.copyImmutableValue(value));
    }
}
