// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;


// Referenced classes of package com.amazon.searchapp.retailsearch.model:
//            Link, RgbaColor

public interface AirstreamProduct
{

    public abstract String getBrand();

    public abstract int getCropHeight();

    public abstract int getCropWidth();

    public abstract String getCroppedImageUrl();

    public abstract String getCursor();

    public abstract Link getDetailLink();

    public abstract String getDisplayImageUrl();

    public abstract String getDisplayPrice();

    public abstract int getHorizontalCropPosition();

    public abstract String getItemId();

    public abstract String getItemType();

    public abstract String getPrice();

    public abstract RgbaColor getPrimaryHue();

    public abstract String getProductGroup();

    public abstract String getProductLine();

    public abstract boolean getSaved();

    public abstract RgbaColor getSecondaryHue();

    public abstract boolean getShouldCrop();

    public abstract int getSourceImageHeight();

    public abstract String getSourceImageUrl();

    public abstract int getSourceImageWidth();

    public abstract boolean getSponsored();

    public abstract String getTitle();

    public abstract int getVerticalCropPosition();

    public abstract void setBrand(String s);

    public abstract void setCropHeight(int i);

    public abstract void setCropWidth(int i);

    public abstract void setCroppedImageUrl(String s);

    public abstract void setCursor(String s);

    public abstract void setDetailLink(Link link);

    public abstract void setDisplayImageUrl(String s);

    public abstract void setDisplayPrice(String s);

    public abstract void setHorizontalCropPosition(int i);

    public abstract void setItemId(String s);

    public abstract void setItemType(String s);

    public abstract void setPrice(String s);

    public abstract void setPrimaryHue(RgbaColor rgbacolor);

    public abstract void setProductGroup(String s);

    public abstract void setProductLine(String s);

    public abstract void setSaved(boolean flag);

    public abstract void setSecondaryHue(RgbaColor rgbacolor);

    public abstract void setShouldCrop(boolean flag);

    public abstract void setSourceImageHeight(int i);

    public abstract void setSourceImageUrl(String s);

    public abstract void setSourceImageWidth(int i);

    public abstract void setSponsored(boolean flag);

    public abstract void setTitle(String s);

    public abstract void setVerticalCropPosition(int i);
}
