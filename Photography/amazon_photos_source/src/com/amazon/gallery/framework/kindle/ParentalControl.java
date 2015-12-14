// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle;

import android.app.Activity;

public interface ParentalControl
{

    public abstract boolean isBlocked(Activity activity);

    public abstract boolean isMessagingBlocked(Activity activity);

    public abstract boolean isSocialNetworkingBlocked(Activity activity);

    public abstract void promptAndFinish(Activity activity);

    public abstract void promptMessagingBlocked(Activity activity);

    public abstract void promptSocialNetworkingBlocked(Activity activity);
}
