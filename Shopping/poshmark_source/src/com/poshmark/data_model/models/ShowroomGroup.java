// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShowroomGroup
{

    List collections;
    String display_name;
    String tag;

    public ShowroomGroup()
    {
        collections = Collections.synchronizedList(new ArrayList());
    }

    public List getCollections()
    {
        return collections;
    }

    public String getDisplayName()
    {
        return display_name;
    }

    public String getTag()
    {
        return tag;
    }
}
