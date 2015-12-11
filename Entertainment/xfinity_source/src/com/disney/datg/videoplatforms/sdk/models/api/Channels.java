// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.models.api;

import java.io.Serializable;
import java.util.ArrayList;

public class Channels
    implements Serializable
{

    private ArrayList channel;
    private String xmlns;

    public Channels()
    {
        xmlns = "http://abc.go.com/vp2/ws/xmlns";
    }

    public ArrayList getChannel()
    {
        return channel;
    }
}
