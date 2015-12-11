// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.b.a.a;

import android.util.SparseArray;
import com.target.mothership.services.f.a.b;
import com.target.mothership.services.f.a.c;
import java.util.Map;

// Referenced classes of package com.target.mothership.services.b.a.a:
//            b

public class a extends b
{

    private static final com.target.mothership.services.f.a.b.a ACCESS_KEY = new com.target.mothership.services.f.a.b.a("access_key");
    private static c ADD_ON_DEMAND_COUPONS;
    private static c ASSIGN_OFFERS;
    private static final com.target.mothership.services.f.a.b.a COUPON_CODE = new com.target.mothership.services.f.a.b.a("coupon_code");
    private static final com.target.mothership.services.f.a.b.a DEVICE_TYPE = new com.target.mothership.services.f.a.b.a("device_type");
    private static final com.target.mothership.services.f.a.b.a FIRST_NAME = new com.target.mothership.services.f.a.b.a("first_name");
    private static c GET_ASSIGNED_OFFERS;
    private static c GET_AVAILABLE_COUPONS;
    private static final com.target.mothership.services.f.a.b.a LAST_NAME = new com.target.mothership.services.f.a.b.a("last_name");
    private static final com.target.mothership.services.f.a.b.a PERIOD = new com.target.mothership.services.f.a.b.a("period");
    private static final com.target.mothership.services.f.a.b.a PHONE_NUMBER = new com.target.mothership.services.f.a.b.a("phone_number");
    private static final com.target.mothership.services.f.a.b.a PIN = new com.target.mothership.services.f.a.b.a("pin");
    private static c REGISTER_BY_SMS;
    private static c SIGN_UP;
    private static final com.target.mothership.services.f.a.b.a TIME_ZONE = new com.target.mothership.services.f.a.b.a("time_zone");
    private static c VALIDATE_BY_PIN;
    private static final com.target.mothership.services.f.a.b.a ZIP_CODE = new com.target.mothership.services.f.a.b.a("zip_code");
    private static final SparseArray sDeviceTypesMap;

    public a(com.target.mothership.services.f.b.a a1)
    {
        super(a1);
    }

    private String a()
    {
        return (String)sDeviceTypesMap.get(android.os.Build.VERSION.SDK_INT);
    }

    public com.target.mothership.services.f.a.b.b a(com.target.mothership.services.b.a.a.b b1)
    {
        c c1 = SIGN_UP;
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        a1.put(ACCESS_KEY.b(), b1.a());
        a1.put(FIRST_NAME.b(), b1.b());
        a1.put(LAST_NAME.b(), b1.c());
        a1.put(ZIP_CODE.b(), b1.d());
        a1.put(TIME_ZONE.b(), b1.e());
        a1.put(PERIOD.b(), b1.f());
        a1.put(DEVICE_TYPE.b(), a());
        return b(c1, null, a1, null, null);
    }

    public com.target.mothership.services.f.a.b.b a(String s)
    {
        c c1 = GET_AVAILABLE_COUPONS;
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        a1.put(ACCESS_KEY.b(), s);
        a1.put(DEVICE_TYPE.b(), a());
        return b(c1, null, a1, null, null);
    }

    public com.target.mothership.services.f.a.b.b a(String s, String s1)
    {
        c c1 = VALIDATE_BY_PIN;
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        a1.put(PHONE_NUMBER.b(), s);
        a1.put(PIN.b(), s1);
        a1.put(DEVICE_TYPE.b(), a());
        return b(c1, null, a1, null, null);
    }

    public com.target.mothership.services.f.a.b.b b(String s)
    {
        c c1 = REGISTER_BY_SMS;
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        a1.put(PHONE_NUMBER.b(), s);
        a1.put(DEVICE_TYPE.b(), a());
        return b(c1, null, ((Map) (a1)), null, null);
    }

    public com.target.mothership.services.f.a.b.b b(String s, String s1)
    {
        c c1 = ADD_ON_DEMAND_COUPONS;
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        a1.put(ACCESS_KEY.b(), s);
        a1.put(DEVICE_TYPE.b(), a());
        a1.put(COUPON_CODE.b(), s1);
        return b(c1, null, ((Map) (a1)), null, null);
    }

    public com.target.mothership.services.f.a.b.b c(String s)
    {
        c c1 = ASSIGN_OFFERS;
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        a1.put(ACCESS_KEY.b(), s);
        a1.put(DEVICE_TYPE.b(), a());
        return b(c1, null, a1, null, null);
    }

    public com.target.mothership.services.f.a.b.b d(String s)
    {
        c c1 = GET_ASSIGNED_OFFERS;
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        a1.put(ACCESS_KEY.b(), s);
        a1.put(DEVICE_TYPE.b(), a());
        return b(c1, null, a1, null, null);
    }

    static 
    {
        sDeviceTypesMap = new SparseArray();
        sDeviceTypesMap.put(1, "2056");
        sDeviceTypesMap.put(2, "2057");
        sDeviceTypesMap.put(3, "2060");
        sDeviceTypesMap.put(4, "2062");
        sDeviceTypesMap.put(5, "2065");
        sDeviceTypesMap.put(6, "2066");
        sDeviceTypesMap.put(7, "2067");
        sDeviceTypesMap.put(8, "2078");
        sDeviceTypesMap.put(9, "2079");
        sDeviceTypesMap.put(10, "2080");
        sDeviceTypesMap.put(11, "2091");
        sDeviceTypesMap.put(12, "2092");
        sDeviceTypesMap.put(13, "2093");
        sDeviceTypesMap.put(14, "2104");
        sDeviceTypesMap.put(15, "2105");
        sDeviceTypesMap.put(16, "2110");
        sDeviceTypesMap.put(17, "2112");
        sDeviceTypesMap.put(18, "2115");
        sDeviceTypesMap.put(19, "2120");
        sDeviceTypesMap.put(20, "2121");
        sDeviceTypesMap.put(21, "2128");
        GET_AVAILABLE_COUPONS = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.Codebroker, "/cb/gateway/get/xml/appfcoinfo.jsp?ack={access_key}&device={device_type}&assigned=true&fc=1035-0ED7DF&locale=en_US");
        REGISTER_BY_SMS = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.Codebroker, "/cb/gateway/get/xml/appsmskey.jsp?spn={phone_number}&device={device_type}&locale=en_US");
        VALIDATE_BY_PIN = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.Codebroker, "/cb/gateway/get/xml/appsmsunlock.jsp?pin={pin}&spn={phone_number}&device={device_type}&locale=en_US");
        SIGN_UP = new c(com.target.mothership.services.f.a.d.a.POST, com.target.mothership.services.f.b.a.Codebroker, "/cb/gateway/custom/app/optin1t4.jsp?ack={access_key}&uprefpnfirst={first_name}&uprefpnlast={last_name}&uprefzip={zip_code}&uprefustz={time_zone}&uprefhodx={period}&device={device_type}&locale=en_US");
        ASSIGN_OFFERS = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.Codebroker, "/cb/gateway/get/xml/appfcoadd.jsp?ack={access_key}&device={device_type}&locale=en_US");
        GET_ASSIGNED_OFFERS = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.Codebroker, "/cb/gateway/get/xml/appfcovault.jsp?ack={access_key}&device={device_type}&locale=en_US");
        ADD_ON_DEMAND_COUPONS = new c(com.target.mothership.services.f.a.d.a.POST, com.target.mothership.services.f.b.a.Codebroker, "/cb/gateway/get/xml/appfcoadd.jsp?ack={access_key}&device={device_type}&program={coupon_code}&locale=en_US");
    }
}
