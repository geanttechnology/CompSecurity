// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.session;

import com.shazam.android.analytics.session.page.Page;

public interface SessionConfigurable
{

    public abstract void configureWith(Page page);
}
