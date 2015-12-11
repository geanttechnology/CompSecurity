// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.annotation.analytics;

import com.shazam.android.analytics.session.SessionStrategyType;
import java.lang.annotation.Annotation;

public interface WithPageView
    extends Annotation
{

    public abstract boolean cancelable();

    public abstract SessionStrategyType lifeCycle();

    public abstract Class page();
}
