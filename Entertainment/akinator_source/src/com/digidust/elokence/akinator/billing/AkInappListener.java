// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.billing;


public interface AkInappListener
{

    public abstract void itemPurchased(String s);

    public abstract void onAllPurchasesRestored();

    public abstract void onInitialization(boolean flag);

    public abstract void skuDetailsUpdated();
}
