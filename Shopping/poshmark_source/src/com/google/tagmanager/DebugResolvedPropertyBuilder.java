// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;


// Referenced classes of package com.google.tagmanager:
//            ResolvedPropertyBuilder, DebugValueBuilder, ValueBuilder

class DebugResolvedPropertyBuilder
    implements ResolvedPropertyBuilder
{

    private com.google.analytics.containertag.proto.MutableDebug.ResolvedProperty resolvedProperty;

    public DebugResolvedPropertyBuilder(com.google.analytics.containertag.proto.MutableDebug.ResolvedProperty resolvedproperty)
    {
        resolvedProperty = resolvedproperty;
    }

    public ValueBuilder createPropertyValueBuilder(com.google.analytics.midtier.proto.containertag.TypeSystem.Value value)
    {
        value = DebugValueBuilder.copyImmutableValue(value);
        resolvedProperty.setValue(value);
        return new DebugValueBuilder(value);
    }
}
