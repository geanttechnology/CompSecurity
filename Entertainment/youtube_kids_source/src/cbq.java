// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import org.xml.sax.Attributes;

final class cbq extends bnt
{

    cbq()
    {
    }

    public final void a(bmz bmz1, Attributes attributes)
    {
        bmz1 = (ceb)bmz1.peek();
        bmz1.x = Long.parseLong(attributes.getValue("viewCount"));
        bmz1.y = Long.parseLong(attributes.getValue("totalUploadViews"));
        bmz1.z = Integer.parseInt(attributes.getValue("subscriberCount"));
    }
}
