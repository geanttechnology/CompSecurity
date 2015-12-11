// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.safety;

import org.jsoup.nodes.Element;

// Referenced classes of package org.jsoup.safety:
//            Cleaner

private static class numAttribsDiscarded
{

    Element el;
    int numAttribsDiscarded;

    (Element element, int i)
    {
        el = element;
        numAttribsDiscarded = i;
    }
}
