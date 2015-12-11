// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.serialization;

import b.a.e;
import com.google.b.l;
import com.google.b.o;
import com.shazam.model.news.FeedCardType;

public class FeedCardTypeSelector
    implements e
{

    public FeedCardTypeSelector()
    {
    }

    public Class getClassForElement(l l1)
    {
        return FeedCardType.fromClassName(l1.g().a("@class").b()).getBeanRepresentationClass();
    }
}
