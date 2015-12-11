// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;


public final class q extends Enum
{

    private static final q $VALUES[];
    public static final q AccountSessionAction;
    public static final q AddToCartSuccess;
    public static final q BarcodeScan;
    public static final q ErrorReceived;
    public static final q ExitLink;
    public static final q ExternalDeepLink;
    public static final q GeofenceChange;
    public static final q Launch;
    public static final q RefineSort;
    public static final q SaveGiftCardToAccount;
    public static final q ShareProduct;
    public static final q TargetWidget;
    public static final q VlcPositionUpdate;

    private q(String s, int i)
    {
        super(s, i);
    }

    public static q valueOf(String s)
    {
        return (q)Enum.valueOf(com/target/ui/analytics/a/q, s);
    }

    public static q[] values()
    {
        return (q[])$VALUES.clone();
    }

    static 
    {
        AddToCartSuccess = new q("AddToCartSuccess", 0);
        AccountSessionAction = new q("AccountSessionAction", 1);
        BarcodeScan = new q("BarcodeScan", 2);
        ErrorReceived = new q("ErrorReceived", 3);
        ExitLink = new q("ExitLink", 4);
        ExternalDeepLink = new q("ExternalDeepLink", 5);
        GeofenceChange = new q("GeofenceChange", 6);
        Launch = new q("Launch", 7);
        RefineSort = new q("RefineSort", 8);
        ShareProduct = new q("ShareProduct", 9);
        TargetWidget = new q("TargetWidget", 10);
        SaveGiftCardToAccount = new q("SaveGiftCardToAccount", 11);
        VlcPositionUpdate = new q("VlcPositionUpdate", 12);
        $VALUES = (new q[] {
            AddToCartSuccess, AccountSessionAction, BarcodeScan, ErrorReceived, ExitLink, ExternalDeepLink, GeofenceChange, Launch, RefineSort, ShareProduct, 
            TargetWidget, SaveGiftCardToAccount, VlcPositionUpdate
        });
    }
}
