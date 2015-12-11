// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.module;

import com.shazam.b.b;
import com.shazam.model.module.ModuleCommonData;
import java.util.Map;

public interface ModuleImpression
{

    public static final ModuleImpression NO_OP = (ModuleImpression)b.a(com/shazam/android/analytics/module/ModuleImpression);

    public abstract void onImpressionFinished(ModuleCommonData modulecommondata, Map map);

    public abstract void onImpressionPaused();

    public abstract void onImpressionStarted(String s);

}
