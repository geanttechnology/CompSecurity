// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.consumable;

import com.xfinity.playerlib.model.consumable.hal.HalNetworkProvider;
import java.util.List;

public interface SortableVideo
{

    public abstract List getLanguageCodes();

    public abstract HalNetworkProvider getNetworkInfo();

    public abstract String getProviderCode();

    public abstract long getVideoId();
}
