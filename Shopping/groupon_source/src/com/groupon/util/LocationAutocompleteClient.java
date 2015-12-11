// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.location.Location;
import java.util.List;

public interface LocationAutocompleteClient
{

    public abstract boolean isAutocomplete();

    public abstract boolean isTextEmpty();

    public abstract void locationReadyCallback(Location location);

    public abstract void locationSearchReady(List list);
}
