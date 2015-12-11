// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad.interfaces;

import java.util.ArrayList;

// Referenced classes of package tv.freewheel.ad.interfaces:
//            ICreativeRendition, ISlot

public interface IAdInstance
{

    public abstract void addEventCallbackURLs(String s, String s1, ArrayList arraylist);

    public abstract ICreativeRendition createCreativeRenditionForTranslation();

    public abstract ICreativeRendition getActiveCreativeRendition();

    public abstract int getAdId();

    public abstract double getDuration();

    public abstract ArrayList getEventCallbackURLs(String s, String s1);

    public abstract ArrayList getRenderableCreativeRenditions();

    public abstract ISlot getSlot();

    public abstract void setActiveCreativeRendition(ICreativeRendition icreativerendition);

    public abstract void setClickThroughURL(String s, String s1);
}
