// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.news;

import com.shazam.b.b;

public interface CardDismisser
{

    public static final CardDismisser NO_OP = (CardDismisser)com.shazam.b.b.a(com/shazam/model/news/CardDismisser);

    public abstract void a(String s);

    public abstract boolean b(String s);

}
