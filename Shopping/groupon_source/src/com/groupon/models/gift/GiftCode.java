// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.gift;

import com.groupon.models.GenericAmount;
import java.io.Serializable;

public class GiftCode
    implements Serializable
{

    public String id;
    public GenericAmount minimum_point;
    public String name;
    public GenericAmount point;
    public String type;

    public GiftCode()
    {
    }
}
