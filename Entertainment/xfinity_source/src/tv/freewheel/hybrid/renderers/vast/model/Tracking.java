// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.renderers.vast.model;

import org.w3c.dom.Element;

// Referenced classes of package tv.freewheel.hybrid.renderers.vast.model:
//            AbstractPager

public class Tracking extends AbstractPager
{

    public String event;

    public Tracking()
    {
    }

    public volatile boolean isValid()
    {
        return super.isValid();
    }

    public void parse(Element element)
    {
        super.parse(element);
        event = element.getAttribute("event");
    }

    public String toString()
    {
        return String.format("[Tracking %s event=%s]", new Object[] {
            super.toString(), event
        });
    }
}
