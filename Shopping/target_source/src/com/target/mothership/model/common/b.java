// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.common;

import com.target.mothership.services.aa;

public class b
    implements aa
{

    private static final String EMAIL = "E-MAIL";
    private static final String EXPRESS = "Express";
    private static final String INSIDE_THE_DOOR = "Inside the door";
    private static final String MAIL = "MAIL";
    private static final String MOBILE = "MOBILE";
    private static final String PICK_UP_IN_STORE = "PickupInStore";
    private static final String PICK_UP_IN_STORE_WITH_SPACE = "Pickup In Store";
    private static final String PREMIUM = "Premium";
    private static final String ROOM_OF_CHOICE = "Room of choice";
    private static final String RUSH = "Rush Delivery";
    private static final String SEASONAL = "Seasonal";
    private static final String SEASONAL_SHIPPING = "Seasonal Shipping";
    private static final String SHIP_TO_STORE = "ShipToStore";
    private static final String SHIP_TO_STORE_WITH_SPACE = "Ship To Store";
    private static final String STANDARD = "Standard";
    private static final String TO_THE_DOOR = "To The Door";
    private static final String WHITE_GLOVE = "White glove";
    private static final String WHITE_GLOVE_ASSEMBLY = "White glove assembly";

    public b()
    {
    }

    private com.target.mothership.common.a.b b(String s)
    {
        if (s == null)
        {
            return com.target.mothership.common.a.b.None;
        }
        if (s.equalsIgnoreCase("Standard"))
        {
            return com.target.mothership.common.a.b.Standard;
        }
        if (s.equalsIgnoreCase("Premium"))
        {
            return com.target.mothership.common.a.b.Premium;
        }
        if (s.equalsIgnoreCase("Express"))
        {
            return com.target.mothership.common.a.b.Express;
        }
        if (s.equalsIgnoreCase("Rush Delivery"))
        {
            return com.target.mothership.common.a.b.Rush;
        }
        if (s.equalsIgnoreCase("Seasonal") || s.equalsIgnoreCase("Seasonal Shipping"))
        {
            return com.target.mothership.common.a.b.Seasonal;
        }
        if (s.equalsIgnoreCase("To The Door"))
        {
            return com.target.mothership.common.a.b.ToTheDoor;
        }
        if (s.equalsIgnoreCase("Inside the door"))
        {
            return com.target.mothership.common.a.b.InsideTheDoor;
        }
        if (s.equalsIgnoreCase("Room of choice"))
        {
            return com.target.mothership.common.a.b.RoomOfChoice;
        }
        if (s.equalsIgnoreCase("White glove"))
        {
            return com.target.mothership.common.a.b.WhiteGlove;
        }
        if (s.equalsIgnoreCase("White glove assembly"))
        {
            return com.target.mothership.common.a.b.WhiteGloveAssembly;
        }
        if (s.equalsIgnoreCase("PickupInStore") || s.equalsIgnoreCase("Pickup In Store"))
        {
            return com.target.mothership.common.a.b.PickupInStore;
        }
        if (s.equalsIgnoreCase("ShipToStore") || s.equalsIgnoreCase("Ship To Store"))
        {
            return com.target.mothership.common.a.b.ShipToStore;
        }
        if (s.equalsIgnoreCase("E-MAIL"))
        {
            return com.target.mothership.common.a.b.Email;
        }
        if (s.equalsIgnoreCase("MOBILE"))
        {
            return com.target.mothership.common.a.b.Mobile;
        }
        if (s.equalsIgnoreCase("MAIL"))
        {
            return com.target.mothership.common.a.b.Mail;
        } else
        {
            return com.target.mothership.common.a.b.None;
        }
    }

    public com.target.mothership.common.a.b a(String s)
    {
        return b(s);
    }

    public volatile Object a(Object obj)
    {
        return a((String)obj);
    }
}
