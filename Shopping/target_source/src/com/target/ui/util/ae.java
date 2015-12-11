// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import com.google.a.a.e;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.common.store.a;
import com.target.mothership.model.common.Address;
import com.target.mothership.model.store.handler.TGTStore;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.model.store.interfaces.StoreDetail;
import com.target.mothership.model.store.interfaces.StoreOperatingHours;
import com.target.mothership.model.store.interfaces.StoreSummary;
import com.target.mothership.util.TimeOfDay;
import com.target.mothership.util.o;
import com.target.ui.util.d.c;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.target.ui.util:
//            g

public class ae
{

    private static final String STORE_ADDRESS_SPACER = ", ";

    public static e a(Context context)
    {
        context = PreferenceManager.getDefaultSharedPreferences(context).getString("com.target.ui.service.RelevantStoreService.LAST_STORE_ID", null);
        if (context != null)
        {
            return e.b(a(((String) (context))));
        } else
        {
            return e.e();
        }
    }

    public static Store a(String s)
    {
        return new TGTStore(new StoreIdentifier(s));
    }

    public static String a(RelevantStoreSummary relevantstoresummary, RelevantStoreSummary relevantstoresummary1, boolean flag, Context context)
    {
        ArrayList arraylist = new ArrayList();
        if (!flag) goto _L2; else goto _L1
_L1:
        if (relevantstoresummary.a())
        {
            arraylist.add(context.getResources().getString(0x7f09037d));
        }
        if (relevantstoresummary.c())
        {
            arraylist.add(context.getResources().getString(0x7f09037c));
        }
_L4:
        return o.a(arraylist, ", ");
_L2:
        if (relevantstoresummary.a())
        {
            arraylist.add(context.getResources().getString(0x7f09037d));
        } else
        if (relevantstoresummary1 != null && relevantstoresummary.getStoreId().equals(relevantstoresummary1.getStoreId()))
        {
            arraylist.add(context.getResources().getString(0x7f09037c));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static String a(StoreDetail storedetail, Context context)
    {
        Object obj = b(storedetail);
        storedetail = (new SimpleDateFormat("EEEE", Locale.US)).format(new Date());
        (new GregorianCalendar()).setTime(new Date());
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            StoreOperatingHours storeoperatinghours = (StoreOperatingHours)((Iterator) (obj)).next();
            if (storeoperatinghours.a().equals(storedetail))
            {
                return c.a((TimeOfDay)storeoperatinghours.f().d(), context);
            }
        }

        return null;
    }

    public static String a(StoreSummary storesummary)
    {
        StringBuilder stringbuilder = new StringBuilder();
        storesummary = storesummary.getAddress();
        for (Iterator iterator = storesummary.getAddressLines().iterator(); iterator.hasNext(); stringbuilder.append(", "))
        {
            stringbuilder.append((String)iterator.next());
        }

        stringbuilder.append(storesummary.getCity());
        stringbuilder.append(", ");
        stringbuilder.append(storesummary.getStateOrProvince());
        return stringbuilder.toString();
    }

    public static boolean a(StoreDetail storedetail)
    {
        storedetail = b(storedetail);
        String s = (new SimpleDateFormat("EEEE", Locale.US)).format(new Date());
        for (Iterator iterator = storedetail.iterator(); iterator.hasNext();)
        {
            storedetail = (StoreOperatingHours)iterator.next();
            if (storedetail.a().equals(s))
            {
                TimeOfDay timeofday = (TimeOfDay)storedetail.e().a(TimeOfDay.DAY_START);
                TimeOfDay timeofday1 = (TimeOfDay)storedetail.f().a(TimeOfDay.DAY_END);
                return !storedetail.d() && (storedetail.c() || TimeOfDay.a(timeofday, timeofday1, new Date()));
            }
        }

        return false;
    }

    public static com.target.ui.view.DepartmentBadgeView.a b(String s)
    {
        s = com.target.mothership.common.store.a.a(s);
        if (s == a.OTHER)
        {
            return null;
        }
        static class _cls1
        {

            static final int $SwitchMap$com$target$mothership$common$store$StoreCapabilityType[];

            static 
            {
                $SwitchMap$com$target$mothership$common$store$StoreCapabilityType = new int[com.target.mothership.common.store.a.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$common$store$StoreCapabilityType[a.ACCEPTS_WIC.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$store$StoreCapabilityType[a.APPLE_STORE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$store$StoreCapabilityType[a.BEAUTY_CONCIERGE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$store$StoreCapabilityType[a.CAFE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$store$StoreCapabilityType[a.CAFE_PIZZA.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$store$StoreCapabilityType[a.CLINIC.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$store$StoreCapabilityType[a.FRESH_GROCERY.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$store$StoreCapabilityType[a.FLU_SHOT.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$store$StoreCapabilityType[a.MOBILE_KIOSK.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$store$StoreCapabilityType[a.OPTICAL.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$store$StoreCapabilityType[a.PHARMACY.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$store$StoreCapabilityType[a.PHOTO_LAB.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$store$StoreCapabilityType[a.PORTRAIT.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$store$StoreCapabilityType[a.STARBUCKS.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$store$StoreCapabilityType[a.UNIFORM.ordinal()] = 15;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$store$StoreCapabilityType[a.WINE.ordinal()] = 16;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.mothership.common.store.StoreCapabilityType[s.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return com.target.ui.view.DepartmentBadgeView.a.WIC;

        case 2: // '\002'
            return com.target.ui.view.DepartmentBadgeView.a.APPLE;

        case 3: // '\003'
            return com.target.ui.view.DepartmentBadgeView.a.BEAUTY;

        case 4: // '\004'
            return com.target.ui.view.DepartmentBadgeView.a.CAFE;

        case 5: // '\005'
            return com.target.ui.view.DepartmentBadgeView.a.CAFE_PIZZA;

        case 6: // '\006'
            return com.target.ui.view.DepartmentBadgeView.a.CLINIC;

        case 7: // '\007'
            return com.target.ui.view.DepartmentBadgeView.a.GROCERY;

        case 8: // '\b'
            return com.target.ui.view.DepartmentBadgeView.a.FLU_SHOT;

        case 9: // '\t'
            return com.target.ui.view.DepartmentBadgeView.a.MOBILE;

        case 10: // '\n'
            return com.target.ui.view.DepartmentBadgeView.a.OPTICAL;

        case 11: // '\013'
            return com.target.ui.view.DepartmentBadgeView.a.PHARMACY;

        case 12: // '\f'
            return com.target.ui.view.DepartmentBadgeView.a.PHOTO_LAB;

        case 13: // '\r'
            return com.target.ui.view.DepartmentBadgeView.a.PORTRAIT_STUDIO;

        case 14: // '\016'
            return com.target.ui.view.DepartmentBadgeView.a.STARBUCKS;

        case 15: // '\017'
            return com.target.ui.view.DepartmentBadgeView.a.SCHOOL_UNIFORMS;

        case 16: // '\020'
            return com.target.ui.view.DepartmentBadgeView.a.WINE;
        }
    }

    public static List b(StoreDetail storedetail)
    {
        if (storedetail.e().isEmpty())
        {
            return storedetail.d();
        }
        Date date = new Date();
        for (Iterator iterator = storedetail.e().iterator(); iterator.hasNext();)
        {
            com.target.mothership.model.store.interfaces.a a1 = (com.target.mothership.model.store.interfaces.a)iterator.next();
            if (com.target.ui.util.g.a(date, a1.a(), a1.b()))
            {
                return a1.c();
            }
        }

        return storedetail.d();
    }
}
