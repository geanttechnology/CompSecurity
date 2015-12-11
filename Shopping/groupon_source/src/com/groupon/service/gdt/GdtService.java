// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.gdt;

import android.app.Application;
import android.content.SharedPreferences;
import com.groupon.models.gdt.GdtMerchantDataContainer;
import com.groupon.models.gdt.GdtOrderDataContainer;
import com.groupon.models.gdt.GdtUserOrdersDataContainer;
import com.groupon.service.LoginService;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.ReturningFunction1;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.groupon.service.gdt:
//            GdtServiceBase

public class GdtService
{

    protected static final String GDT_ORDER_URL = "/gdt/v1/groupons/%s/order";
    protected static final String GDT_QUERY_FOR_CONSUMER_ID = "forConsumerId";
    protected static final String GDT_QUERY_PAGE_SIZE = "pageSize";
    protected static final String GDT_QUERY_PARAM_INCLUDE = "include";
    protected static final String GDT_QUERY_VALUE_DETAILS = "details";
    protected static final String GDT_QUERY_VALUE_STATE = "state";
    protected static final String GDT_USER_ORDERS_URL = "/gdt/v1/orders";
    protected static final String GTG_ENTRY_URL = "/togo";
    protected static final String GTG_USER_ORDERS_URL = "/users/%s/delivery-takeout";
    protected static final String MERCHANT_GDT_LOCATIONS_URL = "/gdt/v1/merchants/%s/gdt/services";
    protected Application application;
    protected GdtServiceBase getGdtMerchantDataService;
    protected GdtServiceBase getGdtOrderDataService;
    protected GdtServiceBase getGdtUserOrdersDataService;
    protected LoginService loginService;
    protected SharedPreferences prefs;

    public GdtService()
    {
    }

    private void init()
    {
        getGdtMerchantDataService = new GdtServiceBase(application, com/groupon/models/gdt/GdtMerchantDataContainer);
        getGdtOrderDataService = new GdtServiceBase(application, com/groupon/models/gdt/GdtOrderDataContainer);
        getGdtUserOrdersDataService = new GdtServiceBase(application, com/groupon/models/gdt/GdtUserOrdersDataContainer);
    }

    public String getCurrentBaseUrl()
    {
        return prefs.getString("base_url_gdt", application.getString(0x7f0804c2));
    }

    public void getGdtOrder(String s, Function1 function1, ReturningFunction1 returningfunction1, Function0 function0)
    {
        ArrayList arraylist = new ArrayList(2);
        arraylist.addAll(Arrays.asList(new String[] {
            "include", "state"
        }));
        getGdtOrderDataService.execute(function1, returningfunction1, function0, null, String.format("/gdt/v1/groupons/%s/order", new Object[] {
            s
        }), "GET", arraylist);
    }

    public void getGdtUserOrdersData(String s, Function1 function1, ReturningFunction1 returningfunction1, Function0 function0)
    {
        ArrayList arraylist = new ArrayList(6);
        arraylist.addAll(Arrays.asList(new String[] {
            "include", "details"
        }));
        arraylist.addAll(Arrays.asList(new String[] {
            "forConsumerId", s
        }));
        arraylist.addAll(Arrays.asList(new Serializable[] {
            "pageSize", Integer.valueOf(10)
        }));
        getGdtUserOrdersDataService.execute(function1, returningfunction1, function0, null, "/gdt/v1/orders", "GET", arraylist);
    }

    public String getGtgEntryUrl()
    {
        return (new StringBuilder()).append(prefs.getString("web_base_url_gdt", application.getString(0x7f080533))).append("/togo").toString();
    }

    public String getGtgUserOrdersUrl()
    {
        if (loginService.isLoggedIn())
        {
            return (new StringBuilder()).append(prefs.getString("web_base_url_gdt", application.getString(0x7f080533))).append(String.format("/users/%s/delivery-takeout", new Object[] {
                loginService.getUserId()
            })).toString();
        } else
        {
            return "";
        }
    }

    public void getMerchantGdtLocations(String s, Function1 function1, ReturningFunction1 returningfunction1, Function0 function0)
    {
        getGdtMerchantDataService.setAuthorizationRequired(false).execute(function1, returningfunction1, function0, null, String.format("/gdt/v1/merchants/%s/gdt/services", new Object[] {
            s
        }), "GET", null);
    }
}
