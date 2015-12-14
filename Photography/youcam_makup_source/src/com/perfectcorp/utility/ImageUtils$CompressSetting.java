// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.perfectcorp.utility;

import com.perfectcorp.model.Model;

public class quality extends Model
{

    public static final quality Avatar = new <init>(540, 540, 70);
    public static final <init> FeedbackSnapshot = new <init>(1920, 1080, 70);
    public static final <init> PostCover = new <init>(1920, 1080, 70);
    public static final <init> PostPhoto = new <init>(1920, 1080, 70);
    public static final <init> ProfileCover = new <init>(540, 540, 70);
    public int maxLong;
    public int maxShort;
    public int quality;


    public ()
    {
    }

    public (int i, int j, int k)
    {
        maxLong = i;
        maxShort = j;
        quality = k;
    }
}
