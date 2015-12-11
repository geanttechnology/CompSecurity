// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.api.models;

import java.util.List;
import java.util.Map;

public abstract class ApiModel
{

    public String key;
    public List loadedFields;
    public boolean loadedWithDefaults;
    public String name;
    public Map nestedFieldsInfo;
    public String type;

    public ApiModel()
    {
    }
}
