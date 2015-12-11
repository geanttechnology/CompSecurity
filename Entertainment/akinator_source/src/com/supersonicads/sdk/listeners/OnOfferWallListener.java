// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.listeners;


public interface OnOfferWallListener
{

    public abstract void onGetOWCreditsFailed(String s);

    public abstract void onOWAdClosed();

    public abstract boolean onOWAdCredited(int i, int j, boolean flag);

    public abstract void onOWGeneric(String s, String s1);

    public abstract void onOWShowFail(String s);

    public abstract void onOWShowSuccess();
}
