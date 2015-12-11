// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.notifications;


public interface SynchronousBroadcastListener
{

    public abstract void handleSynchronousBroadcastMsg(String s, Object obj);
}
