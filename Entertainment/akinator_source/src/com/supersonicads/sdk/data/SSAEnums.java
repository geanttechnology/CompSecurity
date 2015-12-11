// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.data;


public class SSAEnums
{
    public static final class BackButtonState extends Enum
    {

        private static final BackButtonState $VALUES[];
        public static final BackButtonState Controller;
        public static final BackButtonState Device;
        public static final BackButtonState None;

        public static BackButtonState valueOf(String s)
        {
            return (BackButtonState)Enum.valueOf(com/supersonicads/sdk/data/SSAEnums$BackButtonState, s);
        }

        public static BackButtonState[] values()
        {
            return (BackButtonState[])$VALUES.clone();
        }

        static 
        {
            None = new BackButtonState("None", 0);
            Device = new BackButtonState("Device", 1);
            Controller = new BackButtonState("Controller", 2);
            $VALUES = (new BackButtonState[] {
                None, Device, Controller
            });
        }

        private BackButtonState(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class ControllerState extends Enum
    {

        private static final ControllerState $VALUES[];
        public static final ControllerState Failed;
        public static final ControllerState FailedToDownload;
        public static final ControllerState FailedToLoad;
        public static final ControllerState Loaded;
        public static final ControllerState None;
        public static final ControllerState Ready;

        public static ControllerState valueOf(String s)
        {
            return (ControllerState)Enum.valueOf(com/supersonicads/sdk/data/SSAEnums$ControllerState, s);
        }

        public static ControllerState[] values()
        {
            return (ControllerState[])$VALUES.clone();
        }

        static 
        {
            None = new ControllerState("None", 0);
            FailedToDownload = new ControllerState("FailedToDownload", 1);
            FailedToLoad = new ControllerState("FailedToLoad", 2);
            Loaded = new ControllerState("Loaded", 3);
            Ready = new ControllerState("Ready", 4);
            Failed = new ControllerState("Failed", 5);
            $VALUES = (new ControllerState[] {
                None, FailedToDownload, FailedToLoad, Loaded, Ready, Failed
            });
        }

        private ControllerState(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class DebugMode extends Enum
    {

        private static final DebugMode $VALUES[];
        public static final DebugMode MODE_0;
        public static final DebugMode MODE_1;
        public static final DebugMode MODE_2;
        public static final DebugMode MODE_3;
        private int value;

        public static DebugMode valueOf(String s)
        {
            return (DebugMode)Enum.valueOf(com/supersonicads/sdk/data/SSAEnums$DebugMode, s);
        }

        public static DebugMode[] values()
        {
            return (DebugMode[])$VALUES.clone();
        }

        public int getValue()
        {
            return value;
        }

        static 
        {
            MODE_0 = new DebugMode("MODE_0", 0, 0);
            MODE_1 = new DebugMode("MODE_1", 1, 1);
            MODE_2 = new DebugMode("MODE_2", 2, 2);
            MODE_3 = new DebugMode("MODE_3", 3, 3);
            $VALUES = (new DebugMode[] {
                MODE_0, MODE_1, MODE_2, MODE_3
            });
        }

        private DebugMode(String s, int i, int j)
        {
            super(s, i);
            value = j;
        }
    }

    public static final class ProductType extends Enum
    {

        private static final ProductType $VALUES[];
        public static final ProductType BrandConnect;
        public static final ProductType Interstitial;
        public static final ProductType OfferWall;
        public static final ProductType OfferWallCredits;

        public static ProductType valueOf(String s)
        {
            return (ProductType)Enum.valueOf(com/supersonicads/sdk/data/SSAEnums$ProductType, s);
        }

        public static ProductType[] values()
        {
            return (ProductType[])$VALUES.clone();
        }

        static 
        {
            BrandConnect = new ProductType("BrandConnect", 0);
            OfferWall = new ProductType("OfferWall", 1);
            Interstitial = new ProductType("Interstitial", 2);
            OfferWallCredits = new ProductType("OfferWallCredits", 3);
            $VALUES = (new ProductType[] {
                BrandConnect, OfferWall, Interstitial, OfferWallCredits
            });
        }

        private ProductType(String s, int i)
        {
            super(s, i);
        }
    }


    public SSAEnums()
    {
    }
}
