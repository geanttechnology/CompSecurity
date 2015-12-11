// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.interfaces;

import android.os.Parcelable;

public interface AccountDetails
    extends Parcelable
{

    public abstract int getCartQuantity();

    public abstract String getEmailAddress();

    public abstract String getFirstName();

    public abstract String getLastName();
}
