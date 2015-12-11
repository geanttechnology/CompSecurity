// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.annotation.analytics;

import com.shazam.model.analytics.event.DefinedEventParameterKey;
import java.lang.annotation.Annotation;

public interface WithAnalyticsInfo
    extends Annotation
{

    public abstract DefinedEventParameterKey[] additionalKeys();
}
