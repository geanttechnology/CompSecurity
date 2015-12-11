// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.interfaces;

import android.os.Parcelable;

public interface GuestBase
    extends Parcelable
{

    public static final String LOCAL_ANONYMOUS_GUEST_ID = "none";

    public abstract String getGuestId();

    public abstract boolean isAnonymous();
}
