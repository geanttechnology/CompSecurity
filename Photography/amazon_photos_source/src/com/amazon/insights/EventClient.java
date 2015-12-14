// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights;


// Referenced classes of package com.amazon.insights:
//            Event

public interface EventClient
{

    public abstract void addGlobalAttribute(String s, String s1);

    public abstract Event createEvent(String s);

    public abstract void recordEvent(Event event);

    public abstract void removeGlobalAttribute(String s);

    public abstract void submitEvents();
}
