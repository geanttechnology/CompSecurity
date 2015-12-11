// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.persistance;

import com.gimbal.proguard.Keep;

public class ApplicationConfiguration
    implements Keep
{

    private Boolean allowKitKat;
    private Integer smoothingWindow;

    public ApplicationConfiguration()
    {
    }

    public Integer getSmoothingWindow()
    {
        return smoothingWindow;
    }

    public Boolean isAllowKitKat()
    {
        return allowKitKat;
    }

    public void setAllowKitKat(Boolean boolean1)
    {
        allowKitKat = boolean1;
    }

    public void setSmoothingWindow(Integer integer)
    {
        smoothingWindow = integer;
    }
}
