// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;

// Referenced classes of package com.target.ui.view:
//            BadgeView

public class DepartmentBadgeView extends BadgeView
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a ACCESSORIES;
        public static final a ACTIVE_WEAR;
        public static final a APPAREL;
        public static final a APPLE;
        public static final a AUTO;
        public static final a BABY;
        public static final a BAKERY;
        public static final a BATH;
        public static final a BEAUTY;
        public static final a BEDROOM;
        public static final a BEER_AND_WINE;
        public static final a BIKE;
        public static final a BOYS;
        public static final a C9;
        public static final a CAFE;
        public static final a CAFE_PIZZA;
        public static final a CARDS_AND_PARTY;
        public static final a CHRISTMAS;
        public static final a CLEANING_CLOSET;
        public static final a CLEARANCE;
        public static final a CLINIC;
        public static final a DECOR;
        public static final a DELI;
        public static final a ELECTRONICS;
        public static final a ENTERTAINMENT;
        public static final a FLU_SHOT;
        public static final a FURNISHINGS;
        public static final a GIFT_FINDER;
        public static final a GIRLS;
        public static final a GROCERY;
        public static final a HALLOWEEN;
        public static final a HEALTH_CARE;
        public static final a HOME;
        public static final a HOME_IMPROVEMENT;
        public static final a HOSIERY;
        public static final a HOUSEHOLD;
        public static final a INTIMATES;
        public static final a JEWELRY;
        public static final a KIDS;
        public static final a KIDS_ROOM;
        public static final a KITCHEN;
        public static final a MATERNITY;
        public static final a MEAT_AND_SEAFOOD;
        public static final a MENS;
        public static final a MOBILE;
        public static final a OPTICAL;
        public static final a PATIO_OUTDOOR;
        public static final a PERSONAL_CARE;
        public static final a PETS;
        public static final a PHARMACY;
        public static final a PHOTO_LAB;
        public static final a PORTRAIT_STUDIO;
        public static final a SCHOOL_AND_OFFICE;
        public static final a SCHOOL_UNIFORMS;
        public static final a SHOES;
        public static final a SNACKS;
        public static final a SPORTING_GOODS;
        public static final a SPORTING_GOODS_CANADA;
        public static final a STARBUCKS;
        public static final a STORAGE;
        public static final a TECH;
        public static final a TOYS_AND_GAMES;
        public static final a TRAVEL;
        public static final a UNKNOWN;
        public static final a WIC;
        public static final a WINE;
        public static final a WOMENS;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/ui/view/DepartmentBadgeView$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            ACCESSORIES = new a("ACCESSORIES", 0);
            ACTIVE_WEAR = new a("ACTIVE_WEAR", 1);
            APPAREL = new a("APPAREL", 2);
            APPLE = new a("APPLE", 3);
            AUTO = new a("AUTO", 4);
            BABY = new a("BABY", 5);
            BAKERY = new a("BAKERY", 6);
            BATH = new a("BATH", 7);
            BEAUTY = new a("BEAUTY", 8);
            BEDROOM = new a("BEDROOM", 9);
            BEER_AND_WINE = new a("BEER_AND_WINE", 10);
            BIKE = new a("BIKE", 11);
            BOYS = new a("BOYS", 12);
            C9 = new a("C9", 13);
            CAFE = new a("CAFE", 14);
            CAFE_PIZZA = new a("CAFE_PIZZA", 15);
            CARDS_AND_PARTY = new a("CARDS_AND_PARTY", 16);
            CHRISTMAS = new a("CHRISTMAS", 17);
            CLEANING_CLOSET = new a("CLEANING_CLOSET", 18);
            CLEARANCE = new a("CLEARANCE", 19);
            CLINIC = new a("CLINIC", 20);
            DECOR = new a("DECOR", 21);
            DELI = new a("DELI", 22);
            ELECTRONICS = new a("ELECTRONICS", 23);
            ENTERTAINMENT = new a("ENTERTAINMENT", 24);
            FLU_SHOT = new a("FLU_SHOT", 25);
            FURNISHINGS = new a("FURNISHINGS", 26);
            GIFT_FINDER = new a("GIFT_FINDER", 27);
            GIRLS = new a("GIRLS", 28);
            GROCERY = new a("GROCERY", 29);
            HALLOWEEN = new a("HALLOWEEN", 30);
            HEALTH_CARE = new a("HEALTH_CARE", 31);
            HOME = new a("HOME", 32);
            HOME_IMPROVEMENT = new a("HOME_IMPROVEMENT", 33);
            HOSIERY = new a("HOSIERY", 34);
            HOUSEHOLD = new a("HOUSEHOLD", 35);
            INTIMATES = new a("INTIMATES", 36);
            JEWELRY = new a("JEWELRY", 37);
            KIDS = new a("KIDS", 38);
            KIDS_ROOM = new a("KIDS_ROOM", 39);
            KITCHEN = new a("KITCHEN", 40);
            MATERNITY = new a("MATERNITY", 41);
            MEAT_AND_SEAFOOD = new a("MEAT_AND_SEAFOOD", 42);
            MENS = new a("MENS", 43);
            MOBILE = new a("MOBILE", 44);
            OPTICAL = new a("OPTICAL", 45);
            PATIO_OUTDOOR = new a("PATIO_OUTDOOR", 46);
            PERSONAL_CARE = new a("PERSONAL_CARE", 47);
            PETS = new a("PETS", 48);
            PHARMACY = new a("PHARMACY", 49);
            PHOTO_LAB = new a("PHOTO_LAB", 50);
            PORTRAIT_STUDIO = new a("PORTRAIT_STUDIO", 51);
            SCHOOL_AND_OFFICE = new a("SCHOOL_AND_OFFICE", 52);
            SCHOOL_UNIFORMS = new a("SCHOOL_UNIFORMS", 53);
            SHOES = new a("SHOES", 54);
            SNACKS = new a("SNACKS", 55);
            SPORTING_GOODS = new a("SPORTING_GOODS", 56);
            SPORTING_GOODS_CANADA = new a("SPORTING_GOODS_CANADA", 57);
            STARBUCKS = new a("STARBUCKS", 58);
            STORAGE = new a("STORAGE", 59);
            TECH = new a("TECH", 60);
            TOYS_AND_GAMES = new a("TOYS_AND_GAMES", 61);
            TRAVEL = new a("TRAVEL", 62);
            WIC = new a("WIC", 63);
            WINE = new a("WINE", 64);
            WOMENS = new a("WOMENS", 65);
            UNKNOWN = new a("UNKNOWN", 66);
            $VALUES = (new a[] {
                ACCESSORIES, ACTIVE_WEAR, APPAREL, APPLE, AUTO, BABY, BAKERY, BATH, BEAUTY, BEDROOM, 
                BEER_AND_WINE, BIKE, BOYS, C9, CAFE, CAFE_PIZZA, CARDS_AND_PARTY, CHRISTMAS, CLEANING_CLOSET, CLEARANCE, 
                CLINIC, DECOR, DELI, ELECTRONICS, ENTERTAINMENT, FLU_SHOT, FURNISHINGS, GIFT_FINDER, GIRLS, GROCERY, 
                HALLOWEEN, HEALTH_CARE, HOME, HOME_IMPROVEMENT, HOSIERY, HOUSEHOLD, INTIMATES, JEWELRY, KIDS, KIDS_ROOM, 
                KITCHEN, MATERNITY, MEAT_AND_SEAFOOD, MENS, MOBILE, OPTICAL, PATIO_OUTDOOR, PERSONAL_CARE, PETS, PHARMACY, 
                PHOTO_LAB, PORTRAIT_STUDIO, SCHOOL_AND_OFFICE, SCHOOL_UNIFORMS, SHOES, SNACKS, SPORTING_GOODS, SPORTING_GOODS_CANADA, STARBUCKS, STORAGE, 
                TECH, TOYS_AND_GAMES, TRAVEL, WIC, WINE, WOMENS, UNKNOWN
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    private a mDepartment;

    public DepartmentBadgeView(Context context)
    {
        super(context);
    }

    public DepartmentBadgeView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public DepartmentBadgeView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public static int a(a a1)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[];

            static 
            {
                $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department = new int[a.values().length];
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.ACCESSORIES.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror66) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.ACTIVE_WEAR.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror65) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.APPAREL.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror64) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.APPLE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror63) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.AUTO.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror62) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.BABY.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror61) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.BAKERY.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror60) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.BATH.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror59) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.BEAUTY.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror58) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.BEDROOM.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror57) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.BEER_AND_WINE.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror56) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.BIKE.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror55) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.BOYS.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror54) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.C9.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror53) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.CAFE.ordinal()] = 15;
                }
                catch (NoSuchFieldError nosuchfielderror52) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.CAFE_PIZZA.ordinal()] = 16;
                }
                catch (NoSuchFieldError nosuchfielderror51) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.CARDS_AND_PARTY.ordinal()] = 17;
                }
                catch (NoSuchFieldError nosuchfielderror50) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.CHRISTMAS.ordinal()] = 18;
                }
                catch (NoSuchFieldError nosuchfielderror49) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.CLEANING_CLOSET.ordinal()] = 19;
                }
                catch (NoSuchFieldError nosuchfielderror48) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.CLEARANCE.ordinal()] = 20;
                }
                catch (NoSuchFieldError nosuchfielderror47) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.CLINIC.ordinal()] = 21;
                }
                catch (NoSuchFieldError nosuchfielderror46) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.DECOR.ordinal()] = 22;
                }
                catch (NoSuchFieldError nosuchfielderror45) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.DELI.ordinal()] = 23;
                }
                catch (NoSuchFieldError nosuchfielderror44) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.ELECTRONICS.ordinal()] = 24;
                }
                catch (NoSuchFieldError nosuchfielderror43) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.ENTERTAINMENT.ordinal()] = 25;
                }
                catch (NoSuchFieldError nosuchfielderror42) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.FURNISHINGS.ordinal()] = 26;
                }
                catch (NoSuchFieldError nosuchfielderror41) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.FLU_SHOT.ordinal()] = 27;
                }
                catch (NoSuchFieldError nosuchfielderror40) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.GIFT_FINDER.ordinal()] = 28;
                }
                catch (NoSuchFieldError nosuchfielderror39) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.GIRLS.ordinal()] = 29;
                }
                catch (NoSuchFieldError nosuchfielderror38) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.GROCERY.ordinal()] = 30;
                }
                catch (NoSuchFieldError nosuchfielderror37) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.HALLOWEEN.ordinal()] = 31;
                }
                catch (NoSuchFieldError nosuchfielderror36) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.HEALTH_CARE.ordinal()] = 32;
                }
                catch (NoSuchFieldError nosuchfielderror35) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.HOME.ordinal()] = 33;
                }
                catch (NoSuchFieldError nosuchfielderror34) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.HOME_IMPROVEMENT.ordinal()] = 34;
                }
                catch (NoSuchFieldError nosuchfielderror33) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.HOSIERY.ordinal()] = 35;
                }
                catch (NoSuchFieldError nosuchfielderror32) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.HOUSEHOLD.ordinal()] = 36;
                }
                catch (NoSuchFieldError nosuchfielderror31) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.INTIMATES.ordinal()] = 37;
                }
                catch (NoSuchFieldError nosuchfielderror30) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.JEWELRY.ordinal()] = 38;
                }
                catch (NoSuchFieldError nosuchfielderror29) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.KIDS.ordinal()] = 39;
                }
                catch (NoSuchFieldError nosuchfielderror28) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.KIDS_ROOM.ordinal()] = 40;
                }
                catch (NoSuchFieldError nosuchfielderror27) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.KITCHEN.ordinal()] = 41;
                }
                catch (NoSuchFieldError nosuchfielderror26) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.MATERNITY.ordinal()] = 42;
                }
                catch (NoSuchFieldError nosuchfielderror25) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.MEAT_AND_SEAFOOD.ordinal()] = 43;
                }
                catch (NoSuchFieldError nosuchfielderror24) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.MENS.ordinal()] = 44;
                }
                catch (NoSuchFieldError nosuchfielderror23) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.MOBILE.ordinal()] = 45;
                }
                catch (NoSuchFieldError nosuchfielderror22) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.OPTICAL.ordinal()] = 46;
                }
                catch (NoSuchFieldError nosuchfielderror21) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.PATIO_OUTDOOR.ordinal()] = 47;
                }
                catch (NoSuchFieldError nosuchfielderror20) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.PERSONAL_CARE.ordinal()] = 48;
                }
                catch (NoSuchFieldError nosuchfielderror19) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.PHOTO_LAB.ordinal()] = 49;
                }
                catch (NoSuchFieldError nosuchfielderror18) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.PETS.ordinal()] = 50;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.PHARMACY.ordinal()] = 51;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.PORTRAIT_STUDIO.ordinal()] = 52;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.SCHOOL_AND_OFFICE.ordinal()] = 53;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.SCHOOL_UNIFORMS.ordinal()] = 54;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.SHOES.ordinal()] = 55;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.SNACKS.ordinal()] = 56;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.SPORTING_GOODS.ordinal()] = 57;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.SPORTING_GOODS_CANADA.ordinal()] = 58;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.STARBUCKS.ordinal()] = 59;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.STORAGE.ordinal()] = 60;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.TECH.ordinal()] = 61;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.TOYS_AND_GAMES.ordinal()] = 62;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.TRAVEL.ordinal()] = 63;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.UNKNOWN.ordinal()] = 64;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.WIC.ordinal()] = 65;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.WINE.ordinal()] = 66;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$view$DepartmentBadgeView$Department[a.WOMENS.ordinal()] = 67;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.ui.view.DepartmentBadgeView.Department[a1.ordinal()])
        {
        case 64: // '@'
        default:
            return -1;

        case 1: // '\001'
            return 0x7f020091;

        case 2: // '\002'
            return 0x7f020093;

        case 3: // '\003'
            return 0x7f020095;

        case 4: // '\004'
            return 0x7f020096;

        case 5: // '\005'
            return 0x7f020098;

        case 6: // '\006'
            return 0x7f02009a;

        case 7: // '\007'
            return 0x7f02009c;

        case 8: // '\b'
            return 0x7f02009e;

        case 9: // '\t'
            return 0x7f0200a0;

        case 10: // '\n'
            return 0x7f0200a2;

        case 11: // '\013'
            return 0x7f0200a4;

        case 12: // '\f'
            return 0x7f0200a6;

        case 13: // '\r'
            return 0x7f0200a8;

        case 14: // '\016'
            return 0x7f0200a9;

        case 15: // '\017'
            return 0x7f0200ab;

        case 16: // '\020'
            return 0x7f0200ac;

        case 17: // '\021'
            return 0x7f0200ae;

        case 18: // '\022'
            return 0x7f0200b0;

        case 19: // '\023'
            return 0x7f0200b2;

        case 20: // '\024'
            return 0x7f0200b4;

        case 21: // '\025'
            return 0x7f0200b6;

        case 22: // '\026'
            return 0x7f0200b8;

        case 23: // '\027'
            return 0x7f0200ba;

        case 24: // '\030'
            return 0x7f0200bc;

        case 25: // '\031'
            return 0x7f0200be;

        case 27: // '\033'
            return 0x7f0200c0;

        case 26: // '\032'
            return 0x7f0200c2;

        case 28: // '\034'
            return 0x7f0200c4;

        case 29: // '\035'
            return 0x7f0200c6;

        case 30: // '\036'
            return 0x7f0200c8;

        case 31: // '\037'
            return 0x7f0200ca;

        case 32: // ' '
            return 0x7f0200cc;

        case 33: // '!'
            return 0x7f0200ce;

        case 34: // '"'
            return 0x7f0200d0;

        case 35: // '#'
            return 0x7f0200d2;

        case 36: // '$'
            return 0x7f0200d4;

        case 37: // '%'
            return 0x7f0200d6;

        case 38: // '&'
            return 0x7f0200d8;

        case 39: // '\''
            return 0x7f0200da;

        case 40: // '('
            return 0x7f0200dc;

        case 41: // ')'
            return 0x7f0200de;

        case 42: // '*'
            return 0x7f0200e0;

        case 43: // '+'
            return 0x7f0200e2;

        case 44: // ','
            return 0x7f0200e4;

        case 45: // '-'
            return 0x7f0200e6;

        case 46: // '.'
            return 0x7f0200e8;

        case 47: // '/'
            return 0x7f0200ea;

        case 48: // '0'
            return 0x7f0200ec;

        case 50: // '2'
            return 0x7f0200ee;

        case 51: // '3'
            return 0x7f0200f0;

        case 49: // '1'
            return 0x7f0200f2;

        case 52: // '4'
            return 0x7f0200f4;

        case 53: // '5'
            return 0x7f0200f8;

        case 54: // '6'
            return 0x7f0200f6;

        case 55: // '7'
            return 0x7f0200fa;

        case 56: // '8'
            return 0x7f0200fc;

        case 57: // '9'
            return 0x7f0200fe;

        case 58: // ':'
            return 0x7f020100;

        case 59: // ';'
            return 0x7f020101;

        case 60: // '<'
            return 0x7f020103;

        case 61: // '='
            return 0x7f020105;

        case 62: // '>'
            return 0x7f020107;

        case 63: // '?'
            return 0x7f020109;

        case 65: // 'A'
            return 0x7f02010b;

        case 66: // 'B'
            return 0x7f02010d;

        case 67: // 'C'
            return 0x7f02010f;
        }
    }

    public static int b(a a1)
    {
        switch (_cls1..SwitchMap.com.target.ui.view.DepartmentBadgeView.Department[a1.ordinal()])
        {
        case 64: // '@'
        default:
            return -1;

        case 1: // '\001'
            return 0x7f020090;

        case 2: // '\002'
            return 0x7f020092;

        case 3: // '\003'
            return 0x7f020094;

        case 4: // '\004'
            return 0x7f020096;

        case 5: // '\005'
            return 0x7f020097;

        case 6: // '\006'
            return 0x7f020099;

        case 7: // '\007'
            return 0x7f02009b;

        case 8: // '\b'
            return 0x7f02009d;

        case 9: // '\t'
            return 0x7f02009f;

        case 10: // '\n'
            return 0x7f0200a1;

        case 11: // '\013'
            return 0x7f0200a3;

        case 12: // '\f'
            return 0x7f0200a5;

        case 13: // '\r'
            return 0x7f0200a7;

        case 14: // '\016'
            return 0x7f0200a9;

        case 15: // '\017'
            return 0x7f0200aa;

        case 16: // '\020'
            return 0x7f0200ac;

        case 17: // '\021'
            return 0x7f0200ad;

        case 18: // '\022'
            return 0x7f0200af;

        case 19: // '\023'
            return 0x7f0200b1;

        case 20: // '\024'
            return 0x7f0200b3;

        case 21: // '\025'
            return 0x7f0200b5;

        case 22: // '\026'
            return 0x7f0200b7;

        case 23: // '\027'
            return 0x7f0200b9;

        case 24: // '\030'
            return 0x7f0200bb;

        case 25: // '\031'
            return 0x7f0200bd;

        case 27: // '\033'
            return 0x7f0200bf;

        case 26: // '\032'
            return 0x7f0200c1;

        case 28: // '\034'
            return 0x7f0200c3;

        case 29: // '\035'
            return 0x7f0200c5;

        case 30: // '\036'
            return 0x7f0200c7;

        case 31: // '\037'
            return 0x7f0200c9;

        case 32: // ' '
            return 0x7f0200cb;

        case 33: // '!'
            return 0x7f0200cd;

        case 34: // '"'
            return 0x7f0200cf;

        case 35: // '#'
            return 0x7f0200d1;

        case 36: // '$'
            return 0x7f0200d3;

        case 37: // '%'
            return 0x7f0200d5;

        case 38: // '&'
            return 0x7f0200d7;

        case 39: // '\''
            return 0x7f0200d9;

        case 40: // '('
            return 0x7f0200db;

        case 41: // ')'
            return 0x7f0200dd;

        case 42: // '*'
            return 0x7f0200df;

        case 43: // '+'
            return 0x7f0200e1;

        case 44: // ','
            return 0x7f0200e3;

        case 45: // '-'
            return 0x7f0200e5;

        case 46: // '.'
            return 0x7f0200e7;

        case 47: // '/'
            return 0x7f0200e9;

        case 48: // '0'
            return 0x7f0200eb;

        case 50: // '2'
            return 0x7f0200ed;

        case 51: // '3'
            return 0x7f0200ef;

        case 49: // '1'
            return 0x7f0200f1;

        case 52: // '4'
            return 0x7f0200f3;

        case 53: // '5'
            return 0x7f0200f7;

        case 54: // '6'
            return 0x7f0200f5;

        case 55: // '7'
            return 0x7f0200f9;

        case 56: // '8'
            return 0x7f0200fb;

        case 57: // '9'
            return 0x7f0200fd;

        case 58: // ':'
            return 0x7f0200ff;

        case 59: // ';'
            return 0x7f020101;

        case 60: // '<'
            return 0x7f020102;

        case 61: // '='
            return 0x7f020104;

        case 62: // '>'
            return 0x7f020106;

        case 63: // '?'
            return 0x7f020108;

        case 65: // 'A'
            return 0x7f02010a;

        case 66: // 'B'
            return 0x7f02010c;

        case 67: // 'C'
            return 0x7f02010e;
        }
    }

    public String getBadgeContentDescription()
    {
        int i;
        if (mDepartment == null)
        {
            return null;
        }
        i = -1;
        _cls1..SwitchMap.com.target.ui.view.DepartmentBadgeView.Department[mDepartment.ordinal()];
        JVM INSTR tableswitch 1 67: default 304
    //                   1 329
    //                   2 335
    //                   3 341
    //                   4 347
    //                   5 353
    //                   6 359
    //                   7 365
    //                   8 371
    //                   9 377
    //                   10 383
    //                   11 389
    //                   12 395
    //                   13 401
    //                   14 407
    //                   15 413
    //                   16 419
    //                   17 425
    //                   18 431
    //                   19 437
    //                   20 443
    //                   21 449
    //                   22 455
    //                   23 461
    //                   24 467
    //                   25 473
    //                   26 479
    //                   27 485
    //                   28 491
    //                   29 497
    //                   30 503
    //                   31 509
    //                   32 515
    //                   33 521
    //                   34 527
    //                   35 533
    //                   36 539
    //                   37 545
    //                   38 551
    //                   39 557
    //                   40 563
    //                   41 569
    //                   42 575
    //                   43 581
    //                   44 587
    //                   45 593
    //                   46 599
    //                   47 605
    //                   48 611
    //                   49 617
    //                   50 623
    //                   51 629
    //                   52 635
    //                   53 641
    //                   54 647
    //                   55 653
    //                   56 659
    //                   57 665
    //                   58 671
    //                   59 677
    //                   60 683
    //                   61 689
    //                   62 695
    //                   63 701
    //                   64 707
    //                   65 713
    //                   66 719
    //                   67 725;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33 _L34 _L35 _L36 _L37 _L38 _L39 _L40 _L41 _L42 _L43 _L44 _L45 _L46 _L47 _L48 _L49 _L50 _L51 _L52 _L53 _L54 _L55 _L56 _L57 _L58 _L59 _L60 _L61 _L62 _L63 _L64 _L65 _L66 _L67 _L68
_L1:
        return getResources().getString(0x7f090166, new Object[] {
            getResources().getString(i)
        });
_L2:
        i = 0x7f090143;
        continue; /* Loop/switch isn't completed */
_L3:
        i = 0x7f090145;
        continue; /* Loop/switch isn't completed */
_L4:
        i = 0x7f090147;
        continue; /* Loop/switch isn't completed */
_L5:
        i = 0x7f090148;
        continue; /* Loop/switch isn't completed */
_L6:
        i = 0x7f09014a;
        continue; /* Loop/switch isn't completed */
_L7:
        i = 0x7f09014b;
        continue; /* Loop/switch isn't completed */
_L8:
        i = 0x7f09014c;
        continue; /* Loop/switch isn't completed */
_L9:
        i = 0x7f09014d;
        continue; /* Loop/switch isn't completed */
_L10:
        i = 0x7f09014e;
        continue; /* Loop/switch isn't completed */
_L11:
        i = 0x7f09014f;
        continue; /* Loop/switch isn't completed */
_L12:
        i = 0x7f090150;
        continue; /* Loop/switch isn't completed */
_L13:
        i = 0x7f090151;
        continue; /* Loop/switch isn't completed */
_L14:
        i = 0x7f090152;
        continue; /* Loop/switch isn't completed */
_L15:
        i = 0x7f090153;
        continue; /* Loop/switch isn't completed */
_L16:
        i = 0x7f090154;
        continue; /* Loop/switch isn't completed */
_L17:
        i = 0x7f090155;
        continue; /* Loop/switch isn't completed */
_L18:
        i = 0x7f090158;
        continue; /* Loop/switch isn't completed */
_L19:
        i = 0x7f090159;
        continue; /* Loop/switch isn't completed */
_L20:
        i = 0x7f09015a;
        continue; /* Loop/switch isn't completed */
_L21:
        i = 0x7f09015b;
        continue; /* Loop/switch isn't completed */
_L22:
        i = 0x7f09015c;
        continue; /* Loop/switch isn't completed */
_L23:
        i = 0x7f090163;
        continue; /* Loop/switch isn't completed */
_L24:
        i = 0x7f090165;
        continue; /* Loop/switch isn't completed */
_L25:
        i = 0x7f090168;
        continue; /* Loop/switch isn't completed */
_L26:
        i = 0x7f09016c;
        continue; /* Loop/switch isn't completed */
_L27:
        i = 0x7f090171;
        continue; /* Loop/switch isn't completed */
_L28:
        i = 0x7f090170;
        continue; /* Loop/switch isn't completed */
_L29:
        i = 0x7f090174;
        continue; /* Loop/switch isn't completed */
_L30:
        i = 0x7f090175;
        continue; /* Loop/switch isn't completed */
_L31:
        i = 0x7f090176;
        continue; /* Loop/switch isn't completed */
_L32:
        i = 0x7f090177;
        continue; /* Loop/switch isn't completed */
_L33:
        i = 0x7f090178;
        continue; /* Loop/switch isn't completed */
_L34:
        i = 0x7f09017b;
        continue; /* Loop/switch isn't completed */
_L35:
        i = 0x7f09017c;
        continue; /* Loop/switch isn't completed */
_L36:
        i = 0x7f09017d;
        continue; /* Loop/switch isn't completed */
_L37:
        i = 0x7f09017e;
        continue; /* Loop/switch isn't completed */
_L38:
        i = 0x7f09017f;
        continue; /* Loop/switch isn't completed */
_L39:
        i = 0x7f090180;
        continue; /* Loop/switch isn't completed */
_L40:
        i = 0x7f090181;
        continue; /* Loop/switch isn't completed */
_L41:
        i = 0x7f090182;
        continue; /* Loop/switch isn't completed */
_L42:
        i = 0x7f090183;
        continue; /* Loop/switch isn't completed */
_L43:
        i = 0x7f090185;
        continue; /* Loop/switch isn't completed */
_L44:
        i = 0x7f090186;
        continue; /* Loop/switch isn't completed */
_L45:
        i = 0x7f090187;
        continue; /* Loop/switch isn't completed */
_L46:
        i = 0x7f090188;
        continue; /* Loop/switch isn't completed */
_L47:
        i = 0x7f09018c;
        continue; /* Loop/switch isn't completed */
_L48:
        i = 0x7f09018e;
        continue; /* Loop/switch isn't completed */
_L49:
        i = 0x7f090190;
        continue; /* Loop/switch isn't completed */
_L50:
        i = 0x7f090194;
        continue; /* Loop/switch isn't completed */
_L51:
        i = 0x7f090191;
        continue; /* Loop/switch isn't completed */
_L52:
        i = 0x7f090192;
        continue; /* Loop/switch isn't completed */
_L53:
        i = 0x7f090197;
        continue; /* Loop/switch isn't completed */
_L54:
        i = 0x7f09019d;
        continue; /* Loop/switch isn't completed */
_L55:
        i = 0x7f09019e;
        continue; /* Loop/switch isn't completed */
_L56:
        i = 0x7f0901a5;
        continue; /* Loop/switch isn't completed */
_L57:
        i = 0x7f0901a9;
        continue; /* Loop/switch isn't completed */
_L58:
        i = 0x7f0901aa;
        continue; /* Loop/switch isn't completed */
_L59:
        i = 0x7f0901ab;
        continue; /* Loop/switch isn't completed */
_L60:
        i = 0x7f0901ac;
        continue; /* Loop/switch isn't completed */
_L61:
        i = 0x7f0901ad;
        continue; /* Loop/switch isn't completed */
_L62:
        i = 0x7f0901ae;
        continue; /* Loop/switch isn't completed */
_L63:
        i = 0x7f0901b0;
        continue; /* Loop/switch isn't completed */
_L64:
        i = 0x7f0901b1;
        continue; /* Loop/switch isn't completed */
_L65:
        i = 0x7f0901b2;
        continue; /* Loop/switch isn't completed */
_L66:
        i = 0x7f0901b3;
        continue; /* Loop/switch isn't completed */
_L67:
        i = 0x7f0901b4;
        continue; /* Loop/switch isn't completed */
_L68:
        i = 0x7f0901b5;
        if (true) goto _L1; else goto _L69
_L69:
    }

    public a getDepartment()
    {
        return mDepartment;
    }

    public int getForegroundDrawable()
    {
        if (mDepartment == null)
        {
            return -1;
        }
        if (getBadgeType() == BadgeView.b.ACTIVE)
        {
            return a(mDepartment);
        } else
        {
            return b(mDepartment);
        }
    }

    public String getTextOverlay()
    {
        return null;
    }

    public void setBadgeInformation(a a1)
    {
        mDepartment = a1;
        super.b();
    }

    public void setDepartment(a a1)
    {
        setBadgeInformation(a1);
    }
}
