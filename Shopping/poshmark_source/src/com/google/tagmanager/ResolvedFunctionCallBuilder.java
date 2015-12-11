// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;


// Referenced classes of package com.google.tagmanager:
//            ResolvedPropertyBuilder

interface ResolvedFunctionCallBuilder
{

    public abstract ResolvedPropertyBuilder createResolvedPropertyBuilder(String s);

    public abstract void setFunctionResult(com.google.analytics.midtier.proto.containertag.TypeSystem.Value value);
}
