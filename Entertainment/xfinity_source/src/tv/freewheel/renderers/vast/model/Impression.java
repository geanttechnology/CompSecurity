// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.vast.model;

import org.w3c.dom.Element;

// Referenced classes of package tv.freewheel.renderers.vast.model:
//            AbstractPager

public class Impression extends AbstractPager
{

    public Impression()
    {
    }

    public volatile boolean isValid()
    {
        return super.isValid();
    }

    public volatile void parse(Element element)
    {
        super.parse(element);
    }

    public String toString()
    {
        return String.format("[Impression %s]", new Object[] {
            super.toString()
        });
    }
}
