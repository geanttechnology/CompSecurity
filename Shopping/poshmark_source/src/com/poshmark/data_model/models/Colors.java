// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;

import java.util.HashMap;
import java.util.Map;

public class Colors
{

    public static Map colorHash;

    public Colors()
    {
    }

    static 
    {
        colorHash = new HashMap();
        colorHash.put("Red", "#FF3300");
        colorHash.put("Pink", "#FF0066");
        colorHash.put("Orange", "#FF6600");
        colorHash.put("Yellow", "#FFFF00");
        colorHash.put("Green", "#009900");
        colorHash.put("Blue", "#0066FF");
        colorHash.put("Purple", "#9933FF");
        colorHash.put("Gold", "#FFCC00");
        colorHash.put("Silver", "#F0FFFF");
        colorHash.put("Black", "#000000");
        colorHash.put("Gray", "#808080");
        colorHash.put("White", "#FFFFFF");
        colorHash.put("Cream", "#FFFFCC");
        colorHash.put("Brown", "#5E3914");
        colorHash.put("Tan", "#5E3914");
    }
}
