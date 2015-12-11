// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.summariesNpriceBlock;

import gu;
import java.io.Serializable;
import java.util.ArrayList;

// Referenced classes of package com.bestbuy.android.api.lib.models.summariesNpriceBlock:
//            PriceBlock, Recommendations

public class Response
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String appointmentId;
    private ArrayList appointmentSlots;
    private boolean bookABlueShirt;
    private ArrayList bookABlueShirtStores;
    private boolean chat;
    private PriceBlock priceBlock;
    private Recommendations recommendations;
    private ArrayList skuList;

    public Response()
    {
    }

    public String getAppointmentId()
    {
        return appointmentId;
    }

    public ArrayList getAppointmentSlots()
    {
        return appointmentSlots;
    }

    public ArrayList getBookABlueShirtStores()
    {
        return bookABlueShirtStores;
    }

    public PriceBlock getPriceBlock()
    {
        return priceBlock;
    }

    public Recommendations getRecommendations()
    {
        return recommendations;
    }

    public ArrayList getSkuList()
    {
        return skuList;
    }

    public boolean isBookABlueShirt()
    {
        return bookABlueShirt;
    }

    public boolean isChat()
    {
        return chat;
    }

    public void setAppointmentId(String s)
    {
        appointmentId = s;
    }

    public void setAppointmentSlots(ArrayList arraylist)
    {
        appointmentSlots = arraylist;
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

    public void setPriceBlock(PriceBlock priceblock)
    {
        priceBlock = priceblock;
    }

    public void setRecommendations(Recommendations recommendations1)
    {
        recommendations = recommendations1;
    }

    public void setSkuList(ArrayList arraylist)
    {
        skuList = arraylist;
    }
}
