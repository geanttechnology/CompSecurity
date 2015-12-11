// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.event;

import java.util.List;

public interface IEventFactory
{

    public abstract Object fromJson(String s);

    public abstract void setDatabaseIds(Object obj, List list);
}
