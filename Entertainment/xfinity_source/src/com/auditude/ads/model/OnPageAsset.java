// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.auditude.ads.model;


// Referenced classes of package com.auditude.ads.model:
//            Asset, IOnPageAsset, Click, BaseElement

public class OnPageAsset extends Asset
    implements IOnPageAsset
{

    private String altText;
    private String source;
    private IOnPageAsset staticAsset;

    public OnPageAsset(BaseElement baseelement)
    {
        super(baseelement);
        setFormat("onpage");
    }

    public void CopyTo(Asset asset)
    {
        super.CopyTo(asset);
        if (asset.getClick() != null && getClick() != null)
        {
            IClick iclick = getClick();
            Click click = (Click)asset.getClick();
            if (iclick instanceof Click)
            {
                asset = iclick;
            } else
            {
                asset = null;
            }
            click.setBaseTrackingClick((Click)asset);
        }
    }

    public OnPageAsset clone()
    {
        OnPageAsset onpageasset = new OnPageAsset(getParent());
        onpageasset.setState(getState());
        onpageasset.setID(getID());
        onpageasset.setTrackingEvents(getTrackingEvents());
        onpageasset.setTitle(getTitle());
        onpageasset.setDescription(getDescription());
        onpageasset.setFormat(getFormat());
        onpageasset.setResourceType(getResourceType());
        onpageasset.setCreativeType(getCreativeType());
        onpageasset.setApiFramework(getApiFramework());
        onpageasset.setAdParameters(getAdParameters());
        onpageasset.setCustomData(getCustomData());
        onpageasset.setAuditudeParams(getAuditudeParams());
        onpageasset.setDurationInMillis(getDurationInMillis());
        onpageasset.setLeadTimeInMillis(getLeadTimeInMillis());
        onpageasset.setClick(getClick());
        onpageasset.setMediaFiles(getMediaFiles());
        onpageasset.setAltText(getAltText());
        onpageasset.source = source;
        return onpageasset;
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public final String getAltText()
    {
        return altText;
    }

    public String getResourceType()
    {
        return super.getResourceType();
    }

    public String getType()
    {
        return "companion";
    }

    public final void setAltText(String s)
    {
        altText = s;
    }

    public void setResourceType(String s)
    {
        super.setResourceType(s);
    }

    public final void setStaticAsset(IOnPageAsset ionpageasset)
    {
        staticAsset = ionpageasset;
    }
}
