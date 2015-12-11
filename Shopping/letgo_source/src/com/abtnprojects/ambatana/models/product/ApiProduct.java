// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models.product;

import com.abtnprojects.ambatana.models.user.User;
import java.util.List;

// Referenced classes of package com.abtnprojects.ambatana.models.product:
//            Geo, Thumb

public class ApiProduct
{

    private final int categoryId;
    private final String createdAt;
    private final String currency;
    private final String description;
    private final Geo geo;
    private final String id;
    private final List images;
    private final boolean isFavorited;
    private final boolean isReported;
    private final String languageCode;
    private final String name;
    private final User owner;
    private final Double price;
    private final int status;
    private final Thumb thumb;
    private final String updatedAt;

    public ApiProduct(String s, String s1, int i, String s2, String s3, Double double1, String s4, 
            int j, Geo geo1, List list, Thumb thumb1, String s5, String s6, boolean flag, 
            boolean flag1, User user)
    {
        id = s;
        name = s1;
        categoryId = i;
        languageCode = s2;
        description = s3;
        price = double1;
        currency = s4;
        status = j;
        geo = geo1;
        images = list;
        thumb = thumb1;
        createdAt = s5;
        updatedAt = s6;
        isReported = flag;
        isFavorited = flag1;
        owner = user;
    }

    public int getCategoryId()
    {
        return categoryId;
    }

    public String getCreatedAt()
    {
        return createdAt;
    }

    public String getCurrency()
    {
        return currency;
    }

    public String getDescription()
    {
        return description;
    }

    public Geo getGeo()
    {
        return geo;
    }

    public String getId()
    {
        return id;
    }

    public List getImages()
    {
        return images;
    }

    public String getLanguageCode()
    {
        return languageCode;
    }

    public String getName()
    {
        return name;
    }

    public User getOwner()
    {
        return owner;
    }

    public Double getPrice()
    {
        return price;
    }

    public int getStatus()
    {
        return status;
    }

    public Thumb getThumb()
    {
        return thumb;
    }

    public String getUpdatedAt()
    {
        return updatedAt;
    }

    public boolean isFavorited()
    {
        return isFavorited;
    }

    public boolean isReported()
    {
        return isReported;
    }

    public String toString()
    {
        return (new StringBuilder()).append("ApiProduct{id='").append(id).append('\'').append(", name='").append(name).append('\'').append(", categoryId=").append(categoryId).append(", languageCode='").append(languageCode).append('\'').append(", description='").append(description).append('\'').append(", price='").append(price).append('\'').append(", currency='").append(currency).append('\'').append(", status=").append(status).append(", geo=").append(geo).append(", images=").append(images).append(", thumb=").append(thumb).append(", createdAt='").append(createdAt).append('\'').append(", updatedAt='").append(updatedAt).append('\'').append(", isReported=").append(isReported).append(", isFavorited=").append(isFavorited).append(", owner=").append(owner).append('}').toString();
    }
}
