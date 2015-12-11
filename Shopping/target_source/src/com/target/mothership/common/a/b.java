// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.a;


// Referenced classes of package com.target.mothership.common.a:
//            f

public final class b extends Enum
{

    private static final b $VALUES[];
    public static final b Email;
    public static final b Express;
    public static final b InsideTheDoor;
    public static final b Mail;
    public static final b Mobile;
    public static final b None;
    public static final b PickupInStore;
    public static final b Premium;
    public static final b RoomOfChoice;
    public static final b Rush;
    public static final b Seasonal;
    public static final b ShipToStore;
    public static final b Standard;
    public static final b ToTheDoor;
    public static final b WhiteGlove;
    public static final b WhiteGloveAssembly;

    private b(String s, int i)
    {
        super(s, i);
    }

    public static b valueOf(String s)
    {
        return (b)Enum.valueOf(com/target/mothership/common/a/b, s);
    }

    public static b[] values()
    {
        return (b[])$VALUES.clone();
    }

    public f a()
    {
        static class _cls1
        {

            static final int $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[];

            static 
            {
                $SwitchMap$com$target$mothership$common$cart$DeliveryMethod = new int[b.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.Standard.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.Premium.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.Express.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.Rush.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.Seasonal.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.Mail.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.ToTheDoor.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.InsideTheDoor.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.RoomOfChoice.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.WhiteGlove.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.WhiteGloveAssembly.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.PickupInStore.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.ShipToStore.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.Email.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.Mobile.ordinal()] = 15;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.None.ordinal()] = 16;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.mothership.common.cart.DeliveryMethod[ordinal()])
        {
        default:
            return f.NONE_SELECTED;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
            return f.ShipToHome;

        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
        case 11: // '\013'
            return f.Special;

        case 12: // '\f'
            return f.StorePickup;

        case 13: // '\r'
            return f.ShipToStore;

        case 14: // '\016'
        case 15: // '\017'
            return f.Electronic;
        }
    }

    static 
    {
        Standard = new b("Standard", 0);
        Premium = new b("Premium", 1);
        Express = new b("Express", 2);
        Rush = new b("Rush", 3);
        Seasonal = new b("Seasonal", 4);
        ToTheDoor = new b("ToTheDoor", 5);
        InsideTheDoor = new b("InsideTheDoor", 6);
        RoomOfChoice = new b("RoomOfChoice", 7);
        WhiteGlove = new b("WhiteGlove", 8);
        WhiteGloveAssembly = new b("WhiteGloveAssembly", 9);
        PickupInStore = new b("PickupInStore", 10);
        ShipToStore = new b("ShipToStore", 11);
        Email = new b("Email", 12);
        Mobile = new b("Mobile", 13);
        Mail = new b("Mail", 14);
        None = new b("None", 15);
        $VALUES = (new b[] {
            Standard, Premium, Express, Rush, Seasonal, ToTheDoor, InsideTheDoor, RoomOfChoice, WhiteGlove, WhiteGloveAssembly, 
            PickupInStore, ShipToStore, Email, Mobile, Mail, None
        });
    }
}
