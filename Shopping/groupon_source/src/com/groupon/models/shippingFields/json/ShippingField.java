// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.shippingFields.json;

import java.util.HashMap;
import java.util.List;

public class ShippingField
{
    public static class List
    {

        public java.util.List shippingFields;

        public List()
        {
        }
    }


    public HashMap dynamicSelectValues;
    public String label;
    public String name;
    public String parentField;
    public boolean required;
    public java.util.List selectValues;
    public String type;

    public ShippingField()
    {
    }
}
