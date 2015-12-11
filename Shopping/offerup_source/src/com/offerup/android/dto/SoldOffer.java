// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;


// Referenced classes of package com.offerup.android.dto:
//            Person, Item

public class SoldOffer
{

    private Person buyer;
    private int id;
    private Item item;
    private String offer;
    private String paymentStatus;
    private String requestDate;
    private String requestStatus;
    private String reviewDate;
    private Person seller;
    private String soldDate;

    public SoldOffer()
    {
    }

    public Person getBuyer()
    {
        return buyer;
    }

    public int getId()
    {
        return id;
    }

    public Item getItem()
    {
        return item;
    }

    public String getOffer()
    {
        return offer;
    }

    public String getPaymentStatus()
    {
        return paymentStatus;
    }

    public String getRequestDate()
    {
        return requestDate;
    }

    public String getRequestStatus()
    {
        return requestStatus;
    }

    public String getReviewDate()
    {
        return reviewDate;
    }

    public Person getSeller()
    {
        return seller;
    }

    public String getSoldDate()
    {
        return soldDate;
    }

    public void setBuyer(Person person)
    {
        buyer = person;
    }

    public void setId(int i)
    {
        id = i;
    }

    public void setItem(Item item1)
    {
        item = item1;
    }

    public void setOffer(String s)
    {
        offer = s;
    }

    public void setPaymentStatus(String s)
    {
        paymentStatus = s;
    }

    public void setRequestDate(String s)
    {
        requestDate = s;
    }

    public void setRequestStatus(String s)
    {
        requestStatus = s;
    }

    public void setReviewDate(String s)
    {
        reviewDate = s;
    }

    public void setSeller(Person person)
    {
        seller = person;
    }

    public void setSoldDate(String s)
    {
        soldDate = s;
    }

    public String toString()
    {
        return (new StringBuilder("SoldOffer [soldDate=")).append(soldDate).append(", reviewDate=").append(reviewDate).append(", requestDate=").append(requestDate).append(", offer=").append(offer).append(", paymentStatus=").append(paymentStatus).append(", item=").append(item).append(", requestStatus=").append(requestStatus).append(", buyer=").append(buyer).append(", seller=").append(seller).append(", id=").append(id).append("]").toString();
    }
}
