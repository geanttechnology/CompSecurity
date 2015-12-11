// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.renderers.vast.model;

import org.w3c.dom.Element;

// Referenced classes of package tv.freewheel.hybrid.renderers.vast.model:
//            AbstractPager

public class VideoClick extends AbstractPager
{

    public String type;

    public VideoClick(String s)
    {
        type = s;
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
        return String.format("[VideoClick %s type=%s]", new Object[] {
            super.toString(), type
        });
    }
}
