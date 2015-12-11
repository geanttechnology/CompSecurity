// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.acf;


public interface ComponentLifecycle
{

    public abstract void onComponentRegistered(String s);

    public abstract void onComponentUnregistered(String s);
}
