// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage;

import java.util.ArrayList;

public class feature_points
{

    public ArrayList feature_points;
    public boolean is_flipped;
    public int rotation;

    public void Copy(feature_points feature_points1)
    {
        feature_points = new ArrayList(feature_points1.feature_points);
        rotation = feature_points1.rotation;
        is_flipped = feature_points1.is_flipped;
    }

    public ()
    {
        feature_points = new ArrayList();
    }
}
