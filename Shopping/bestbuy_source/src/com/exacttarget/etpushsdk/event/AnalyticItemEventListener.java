// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.event;


// Referenced classes of package com.exacttarget.etpushsdk.event:
//            AnalyticItemEvent, AnalyticPiItemEvent

public interface AnalyticItemEventListener
{

    public abstract void onEvent(AnalyticItemEvent analyticitemevent);

    public abstract void onEvent(AnalyticPiItemEvent analyticpiitemevent);
}
