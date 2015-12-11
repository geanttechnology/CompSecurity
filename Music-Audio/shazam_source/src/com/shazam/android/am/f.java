// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.am;

import com.google.api.services.now.model.Card;
import com.google.api.services.now.model.Context;
import java.util.concurrent.TimeUnit;

public interface f
{

    public abstract Context a(TimeUnit timeunit);

    public abstract String a();

    public abstract void a(Card card);
}
