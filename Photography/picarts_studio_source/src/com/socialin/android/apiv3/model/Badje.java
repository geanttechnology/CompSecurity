// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.model;

import java.util.ArrayList;

// Referenced classes of package com.socialin.android.apiv3.model:
//            Response

public class Badje extends Response
{

    public static String TYPE_BRONZE = "Bronze";
    public static String TYPE_GOLD = "Gold";
    public static String TYPE_PLATINUM = "PLatinum";
    public static String TYPE_SILVER = "Silver";
    public String iconUrl;
    public ArrayList items;
    public ArrayList periods;
    public String type;

    public Badje()
    {
    }

}
