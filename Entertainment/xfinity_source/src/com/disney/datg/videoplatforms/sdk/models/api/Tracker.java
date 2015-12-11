// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.models.api;

import java.io.Serializable;
import java.util.ArrayList;

public class Tracker
    implements Serializable
{

    private ArrayList click;
    private ArrayList end;
    private ArrayList firstquartile;
    private ArrayList mid;
    private ArrayList start;
    private ArrayList thirdquartile;

    public Tracker()
    {
        start = null;
        end = null;
        click = null;
        firstquartile = null;
        mid = null;
        thirdquartile = null;
    }
}
