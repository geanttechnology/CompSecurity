// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.contextlogic.wish.ui.components.text.standalonecreditcard;


public interface StandaloneCreditCardFieldsDelegate
{

    public abstract void onCardTypeChanged(com.contextlogic.wish.util.CreditCardUtil.CardType cardtype);

    public abstract void onEntryComplete();
}
