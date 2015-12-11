// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.models.api;

import java.io.Serializable;
import java.util.ArrayList;

public class AdCollection
    implements Serializable
{

    private ArrayList adbreak;
    private String build;
    private String error;

    public AdCollection()
    {
        adbreak = null;
        error = null;
        build = "1";
    }

    public ArrayList getAdbreak()
    {
        return adbreak;
    }
}
