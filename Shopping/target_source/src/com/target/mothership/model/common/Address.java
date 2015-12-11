// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.common;

import android.os.Parcelable;
import java.util.List;

public interface Address
    extends Parcelable
{

    public abstract List getAddressLines();

    public abstract String getCity();

    public abstract String getCountry();

    public abstract String getPostalCode();

    public abstract String getStateOrProvince();
}
