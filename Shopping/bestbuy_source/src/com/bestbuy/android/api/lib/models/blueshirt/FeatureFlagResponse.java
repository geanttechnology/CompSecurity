// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.blueshirt;

import gu;
import java.io.Serializable;
import java.util.ArrayList;

public class FeatureFlagResponse
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private boolean bookABlueShirt;
    private ArrayList bookABlueShirtStores;
    private boolean chat;

    public FeatureFlagResponse()
    {
    }

    public ArrayList getBookABlueShirtStores()
    {
        return bookABlueShirtStores;
    }

    public boolean isBookABlueShirt()
    {
        return bookABlueShirt;
    }

    public boolean isChat()
    {
        return chat;
    }

    public void setBookABlueShirt(boolean flag)
    {
        bookABlueShirt = flag;
    }

    public void setBookABlueShirtStores(ArrayList arraylist)
    {
        bookABlueShirtStores = arraylist;
    }

    public void setChat(boolean flag)
    {
        chat = flag;
    }
}
