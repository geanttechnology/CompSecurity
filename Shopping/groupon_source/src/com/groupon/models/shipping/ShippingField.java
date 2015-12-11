// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.shipping;

import java.util.HashMap;

public class ShippingField
{
    public static class MapContainer
    {

        public HashMap shippingFields;

        public MapContainer()
        {
        }
    }


    public String errorMessageId;
    public String hintId;
    public String httpParam;
    public String httpParamAlt;
    public int inputType;
    public String jsonParam;
    public int lines;

    public ShippingField()
    {
        inputType = 0x20071;
        lines = 1;
    }
}
