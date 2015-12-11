// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.acf;


public interface ComponentRegistry
{

    public abstract Object getComponent(String s);

    public abstract void onDestroy();

    public abstract Object registerComponent(String s, Object obj);
}
