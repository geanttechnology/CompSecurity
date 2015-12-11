// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.callbacks;

import android.view.View;

public interface OnCompanyInfoEventListener
{

    public abstract void onAddressClick(View view, String s);

    public abstract void onMapViewClick(View view, double d, double d1, String s);

    public abstract void onMultipleLocationsClick(View view);

    public abstract void onPhoneClick(View view, String s);

    public abstract void onWebsiteClick(View view);
}
