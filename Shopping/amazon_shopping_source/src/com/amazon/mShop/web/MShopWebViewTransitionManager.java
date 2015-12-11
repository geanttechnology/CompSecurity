// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;


public interface MShopWebViewTransitionManager
{

    public abstract void beginBackwardTransition(String s);

    public abstract void beginForwardTransition(String s);

    public abstract void doTransitionAnimation();

    public abstract boolean isBackTransitionPending();
}
