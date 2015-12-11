// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.cart;


public interface CartStateListener
{

    public abstract void onQuantityUpdated(int i);

    public abstract void onStateChange(int i);
}
