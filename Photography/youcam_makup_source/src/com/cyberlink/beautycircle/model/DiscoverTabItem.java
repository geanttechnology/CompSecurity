// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model;

import com.perfectcorp.model.Model;
import java.util.ArrayList;

public class DiscoverTabItem extends Model
{

    public static final String PREF_KEY = "BeautyOptoinList";
    public static final String TYPE_BEAUTYIST = "BEAUTYIST";
    public static final String TYPE_BRAND = "BRAND";
    public static final String TYPE_CONTEST = "CONTEST";
    public static final String TYPE_EDITORIAL = "EDITORIAL";
    public static final String TYPE_FREESAMPLE = "FREE_SAMPLE";
    public static final String TYPE_MAKEUPTIP = "BEAUTY_TIP";
    public int displayImage;
    public String displayName;
    public ArrayList tabList;
    public String type;

    public DiscoverTabItem()
    {
    }
}
