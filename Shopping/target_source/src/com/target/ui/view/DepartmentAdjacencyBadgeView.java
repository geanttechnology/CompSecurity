// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import com.target.mothership.model.a.c.a;

// Referenced classes of package com.target.ui.view:
//            BadgeView

public class DepartmentAdjacencyBadgeView extends BadgeView
{

    private a mDepartmentAdjacency;

    public DepartmentAdjacencyBadgeView(Context context)
    {
        super(context);
    }

    public DepartmentAdjacencyBadgeView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public DepartmentAdjacencyBadgeView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    private static int a(a a1)
    {
        if (a1 == null)
        {
            return -1;
        }
        static class _cls1
        {

            static final int $SwitchMap$com$target$mothership$common$department_adjacency$DepartmentAdjacencyType[];

            static 
            {
                $SwitchMap$com$target$mothership$common$department_adjacency$DepartmentAdjacencyType = new int[com.target.mothership.common.b.a.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$common$department_adjacency$DepartmentAdjacencyType[com.target.mothership.common.b.a.BAKERY.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror30) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$department_adjacency$DepartmentAdjacencyType[com.target.mothership.common.b.a.BEAUTY.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror29) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$department_adjacency$DepartmentAdjacencyType[com.target.mothership.common.b.a.BOYS.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror28) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$department_adjacency$DepartmentAdjacencyType[com.target.mothership.common.b.a.DELI.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror27) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$department_adjacency$DepartmentAdjacencyType[com.target.mothership.common.b.a.DOMESTICS.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror26) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$department_adjacency$DepartmentAdjacencyType[com.target.mothership.common.b.a.ELECTRONICS.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror25) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$department_adjacency$DepartmentAdjacencyType[com.target.mothership.common.b.a.FROZEN_FOOD.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror24) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$department_adjacency$DepartmentAdjacencyType[com.target.mothership.common.b.a.FURNITURE.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror23) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$department_adjacency$DepartmentAdjacencyType[com.target.mothership.common.b.a.GIRLS.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror22) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$department_adjacency$DepartmentAdjacencyType[com.target.mothership.common.b.a.GROCERY.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror21) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$department_adjacency$DepartmentAdjacencyType[com.target.mothership.common.b.a.HOUSEHOLD_COMMODITIES.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror20) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$department_adjacency$DepartmentAdjacencyType[com.target.mothership.common.b.a.HOUSEWARES.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror19) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$department_adjacency$DepartmentAdjacencyType[com.target.mothership.common.b.a.INFANT_FURNITURE.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror18) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$department_adjacency$DepartmentAdjacencyType[com.target.mothership.common.b.a.INFANTS.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$department_adjacency$DepartmentAdjacencyType[com.target.mothership.common.b.a.INTIMATES.ordinal()] = 15;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$department_adjacency$DepartmentAdjacencyType[com.target.mothership.common.b.a.JEWELRY.ordinal()] = 16;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$department_adjacency$DepartmentAdjacencyType[com.target.mothership.common.b.a.LUGGAGE.ordinal()] = 17;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$department_adjacency$DepartmentAdjacencyType[com.target.mothership.common.b.a.MEAT.ordinal()] = 18;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$department_adjacency$DepartmentAdjacencyType[com.target.mothership.common.b.a.MENS.ordinal()] = 19;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$department_adjacency$DepartmentAdjacencyType[com.target.mothership.common.b.a.PAPER.ordinal()] = 20;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$department_adjacency$DepartmentAdjacencyType[com.target.mothership.common.b.a.PERSONAL_CARE.ordinal()] = 21;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$department_adjacency$DepartmentAdjacencyType[com.target.mothership.common.b.a.PETS.ordinal()] = 22;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$department_adjacency$DepartmentAdjacencyType[com.target.mothership.common.b.a.PRODUCE.ordinal()] = 23;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$department_adjacency$DepartmentAdjacencyType[com.target.mothership.common.b.a.PROMO_1.ordinal()] = 24;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$department_adjacency$DepartmentAdjacencyType[com.target.mothership.common.b.a.READY_TO_WEAR.ordinal()] = 25;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$department_adjacency$DepartmentAdjacencyType[com.target.mothership.common.b.a.SEASONAL.ordinal()] = 26;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$department_adjacency$DepartmentAdjacencyType[com.target.mothership.common.b.a.SHOES.ordinal()] = 27;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$department_adjacency$DepartmentAdjacencyType[com.target.mothership.common.b.a.SPORTING_GOODS.ordinal()] = 28;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$department_adjacency$DepartmentAdjacencyType[com.target.mothership.common.b.a.STATIONERY.ordinal()] = 29;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$department_adjacency$DepartmentAdjacencyType[com.target.mothership.common.b.a.TOYS.ordinal()] = 30;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$department_adjacency$DepartmentAdjacencyType[com.target.mothership.common.b.a.UNKNOWN.ordinal()] = 31;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        if (a1.c() != null)
        {
            a1 = com.target.mothership.common.b.a.a(a1.c());
        } else
        {
            a1 = com.target.mothership.common.b.a.a(a1.b());
        }
        switch (_cls1..SwitchMap.com.target.mothership.common.department_adjacency.DepartmentAdjacencyType[a1.ordinal()])
        {
        default:
            return -1;

        case 1: // '\001'
            return 0x7f0201f2;

        case 2: // '\002'
            return 0x7f0201f3;

        case 3: // '\003'
            return 0x7f0201f4;

        case 4: // '\004'
            return 0x7f0201f8;

        case 5: // '\005'
            return 0x7f0201f9;

        case 6: // '\006'
            return 0x7f0201fb;

        case 7: // '\007'
            return 0x7f0201fd;

        case 8: // '\b'
            return 0x7f0201f7;

        case 9: // '\t'
            return 0x7f0201ff;

        case 10: // '\n'
            return 0x7f020200;

        case 11: // '\013'
            return 0x7f020203;

        case 12: // '\f'
            return 0x7f020204;

        case 13: // '\r'
        case 14: // '\016'
            return 0x7f020209;

        case 15: // '\017'
            return 0x7f020205;

        case 16: // '\020'
            return 0x7f020206;

        case 17: // '\021'
            return 0x7f020216;

        case 18: // '\022'
            return 0x7f020207;

        case 19: // '\023'
            return 0x7f020208;

        case 20: // '\024'
            return 0x7f02020a;

        case 21: // '\025'
            return 0x7f020201;

        case 22: // '\026'
            return 0x7f02020d;

        case 23: // '\027'
            return 0x7f02020e;

        case 24: // '\030'
            return 0x7f02020f;

        case 25: // '\031'
            return 0x7f0201f9;

        case 26: // '\032'
            return 0x7f020210;

        case 27: // '\033'
            return 0x7f020211;

        case 28: // '\034'
            return 0x7f020213;

        case 29: // '\035'
            return 0x7f020214;

        case 30: // '\036'
            return 0x7f020215;
        }
    }

    public String getBadgeContentDescription()
    {
        return getResources().getString(0x7f0904cd);
    }

    public int getForegroundDrawable()
    {
        return a(mDepartmentAdjacency);
    }

    public String getTextOverlay()
    {
        return null;
    }

    public void setDepartmentAdjacency(a a1)
    {
        mDepartmentAdjacency = a1;
        super.b();
    }
}
