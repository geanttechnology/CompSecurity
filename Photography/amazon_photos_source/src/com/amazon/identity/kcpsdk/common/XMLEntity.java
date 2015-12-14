// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.common;

import org.w3c.dom.Element;

public abstract class XMLEntity
{

    public XMLEntity()
    {
    }

    abstract void toXML(Element element);
}
