// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;


// Referenced classes of package com.google.tagmanager:
//            EventInfoBuilder

interface EventInfoDistributor
{

    public abstract EventInfoBuilder createDataLayerEventEvaluationEventInfo(String s);

    public abstract EventInfoBuilder createMacroEvalutionEventInfo(String s);

    public abstract boolean debugMode();
}
