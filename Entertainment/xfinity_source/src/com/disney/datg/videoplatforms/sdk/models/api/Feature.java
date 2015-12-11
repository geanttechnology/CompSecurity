// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.models.api;

import java.io.Serializable;
import java.util.ArrayList;

public class Feature
    implements Serializable
{

    private String id;
    private ArrayList param;

    public Feature()
    {
    }

    public String getId()
    {
        return id;
    }

    public ArrayList getParam()
    {
        return param;
    }
}
