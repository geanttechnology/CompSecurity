// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.zeroes.intentservice;

import org.json.JSONObject;

public interface ZeroesPurchaseRequestDecorator
{

    public abstract JSONObject decorateZeroesPurchaseRequest(JSONObject jsonobject);
}
