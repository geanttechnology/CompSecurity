// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.AirstreamProduct;
import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.RgbaColor;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class AirstreamProductEntity extends RetailSearchEntity
    implements AirstreamProduct
{

    private String brand;
    private int cropHeight;
    private int cropWidth;
    private String croppedImageUrl;
    private String cursor;
    private Link detailLink;
    private String displayImageUrl;
    private String displayPrice;
    private int horizontalCropPosition;
    private String itemId;
    private String itemType;
    private String price;
    private RgbaColor primaryHue;
    private String productGroup;
    private String productLine;
    private boolean saved;
    private RgbaColor secondaryHue;
    private boolean shouldCrop;
    private int sourceImageHeight;
    private String sourceImageUrl;
    private int sourceImageWidth;
    private boolean sponsored;
    private String title;
    private int verticalCropPosition;

    public AirstreamProductEntity()
    {
    }

    public String getBrand()
    {
        return brand;
    }

    public int getCropHeight()
    {
        return cropHeight;
    }

    public int getCropWidth()
    {
        return cropWidth;
    }

    public String getCroppedImageUrl()
    {
        return croppedImageUrl;
    }

    public String getCursor()
    {
        return cursor;
    }

    public Link getDetailLink()
    {
        return detailLink;
    }

    public String getDisplayImageUrl()
    {
        return displayImageUrl;
    }

    public String getDisplayPrice()
    {
        return displayPrice;
    }

    public int getHorizontalCropPosition()
    {
        return horizontalCropPosition;
    }

    public String getItemId()
    {
        return itemId;
    }

    public String getItemType()
    {
        return itemType;
    }

    public String getPrice()
    {
        return price;
    }

    public RgbaColor getPrimaryHue()
    {
        return primaryHue;
    }

    public String getProductGroup()
    {
        return productGroup;
    }

    public String getProductLine()
    {
        return productLine;
    }

    public boolean getSaved()
    {
        return saved;
    }

    public RgbaColor getSecondaryHue()
    {
        return secondaryHue;
    }

    public boolean getShouldCrop()
    {
        return shouldCrop;
    }

    public int getSourceImageHeight()
    {
        return sourceImageHeight;
    }

    public String getSourceImageUrl()
    {
        return sourceImageUrl;
    }

    public int getSourceImageWidth()
    {
        return sourceImageWidth;
    }

    public boolean getSponsored()
    {
        return sponsored;
    }

    public String getTitle()
    {
        return title;
    }

    public int getVerticalCropPosition()
    {
        return verticalCropPosition;
    }

    public void setBrand(String s)
    {
        brand = s;
    }

    public void setCropHeight(int i)
    {
        cropHeight = i;
    }

    public void setCropWidth(int i)
    {
        cropWidth = i;
    }

    public void setCroppedImageUrl(String s)
    {
        croppedImageUrl = s;
    }

    public void setCursor(String s)
    {
        cursor = s;
    }

    public void setDetailLink(Link link)
    {
        detailLink = link;
    }

    public void setDisplayImageUrl(String s)
    {
        displayImageUrl = s;
    }

    public void setDisplayPrice(String s)
    {
        displayPrice = s;
    }

    public void setHorizontalCropPosition(int i)
    {
        horizontalCropPosition = i;
    }

    public void setItemId(String s)
    {
        itemId = s;
    }

    public void setItemType(String s)
    {
        itemType = s;
    }

    public void setPrice(String s)
    {
        price = s;
    }

    public void setPrimaryHue(RgbaColor rgbacolor)
    {
        primaryHue = rgbacolor;
    }

    public void setProductGroup(String s)
    {
        productGroup = s;
    }

    public void setProductLine(String s)
    {
        productLine = s;
    }

    public void setSaved(boolean flag)
    {
        saved = flag;
    }

    public void setSecondaryHue(RgbaColor rgbacolor)
    {
        secondaryHue = rgbacolor;
    }

    public void setShouldCrop(boolean flag)
    {
        shouldCrop = flag;
    }

    public void setSourceImageHeight(int i)
    {
        sourceImageHeight = i;
    }

    public void setSourceImageUrl(String s)
    {
        sourceImageUrl = s;
    }

    public void setSourceImageWidth(int i)
    {
        sourceImageWidth = i;
    }

    public void setSponsored(boolean flag)
    {
        sponsored = flag;
    }

    public void setTitle(String s)
    {
        title = s;
    }

    public void setVerticalCropPosition(int i)
    {
        verticalCropPosition = i;
    }
}
