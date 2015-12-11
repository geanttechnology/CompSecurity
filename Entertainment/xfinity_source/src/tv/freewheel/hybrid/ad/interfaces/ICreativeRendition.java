// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.ad.interfaces;


// Referenced classes of package tv.freewheel.hybrid.ad.interfaces:
//            ICreativeRenditionAsset

public interface ICreativeRendition
{

    public abstract ICreativeRenditionAsset createCreativeRenditionAssetForTranslation(String s, boolean flag);

    public abstract String getBaseUnit();

    public abstract String getContentType();

    public abstract String getCreativeAPI();

    public abstract double getDuration();

    public abstract int getHeight();

    public abstract ICreativeRenditionAsset getPrimaryCreativRenditionAsset();

    public abstract int getWidth();

    public abstract String getWrapperType();

    public abstract String getWrapperURL();

    public abstract void setContentType(String s);

    public abstract void setCreativeAPI(String s);

    public abstract void setDuration(double d);

    public abstract void setHeight(int i);

    public abstract void setParameter(String s, Object obj);

    public abstract void setWidth(int i);

    public abstract void setWrapperType(String s);

    public abstract void setWrapperURL(String s);
}
