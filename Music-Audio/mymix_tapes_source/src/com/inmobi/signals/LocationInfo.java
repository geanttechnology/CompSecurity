// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.signals;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import com.inmobi.commons.a.a;
import com.inmobi.commons.core.c.e;
import com.inmobi.commons.core.utilities.Logger;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

// Referenced classes of package com.inmobi.signals:
//            h

public class LocationInfo
{
    public static final class LocationConsentStatus extends Enum
    {

        private static final LocationConsentStatus $VALUES[];
        public static final LocationConsentStatus AUTHORISED;
        public static final LocationConsentStatus DENIED;
        public static final LocationConsentStatus UNDETERMINED;

        public static LocationConsentStatus valueOf(String s)
        {
            return (LocationConsentStatus)Enum.valueOf(com/inmobi/signals/LocationInfo$LocationConsentStatus, s);
        }

        public static LocationConsentStatus[] values()
        {
            return (LocationConsentStatus[])$VALUES.clone();
        }

        static 
        {
            AUTHORISED = new LocationConsentStatus("AUTHORISED", 0);
            DENIED = new LocationConsentStatus("DENIED", 1);
            UNDETERMINED = new LocationConsentStatus("UNDETERMINED", 2);
            $VALUES = (new LocationConsentStatus[] {
                AUTHORISED, DENIED, UNDETERMINED
            });
        }

        private LocationConsentStatus(String s, int l)
        {
            super(s, l);
        }
    }

    private static class a
        implements InvocationHandler
    {

        public void a(int l)
        {
            LocationInfo.b(false);
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, LocationInfo.f(), "Google API client connection suspended");
        }

        public void a(Bundle bundle)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, LocationInfo.f(), "Successfully connected to Google API client.");
            LocationInfo.b(true);
        }

        public Object invoke(Object obj, Method method, Object aobj[])
            throws Throwable
        {
            if (aobj != null)
            {
                if (method.getName().equals("onConnected"))
                {
                    a((Bundle)aobj[0]);
                    return null;
                }
                if (method.getName().equals("onConnectionSuspended"))
                {
                    a(((Integer)aobj[0]).intValue());
                    return null;
                }
            }
            return method.invoke(this, aobj);
        }

        private a()
        {
        }

    }


    private static final String a = com/inmobi/signals/LocationInfo.getSimpleName();
    private static LocationInfo b;
    private static Object c = new Object();
    private static boolean d = false;
    private static LocationManager e;
    private static Object f = null;
    private static boolean g = false;

    private LocationInfo()
    {
        e = (LocationManager)com.inmobi.commons.a.a.b().getSystemService("location");
    }

    public static LocationInfo a()
    {
        Object obj;
        obj = b;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        Object obj1 = c;
        obj1;
        JVM INSTR monitorenter ;
        LocationInfo locationinfo = b;
        obj = locationinfo;
        if (locationinfo != null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        b = new LocationInfo();
        obj = b;
        obj1;
        JVM INSTR monitorexit ;
        return ((LocationInfo) (obj));
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        return ((LocationInfo) (obj));
    }

    private String a(Location location)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(location.getLatitude());
        stringbuilder.append(",");
        stringbuilder.append(location.getLongitude());
        stringbuilder.append(",");
        stringbuilder.append((int)location.getAccuracy());
        return stringbuilder.toString();
    }

    private HashMap a(Location location, boolean flag)
    {
        boolean flag1 = true;
        HashMap hashmap = new HashMap();
        int l;
        if (location != null)
        {
            if (location.getTime() > 0L)
            {
                hashmap.put("u-ll-ts", Long.valueOf(location.getTime()));
            }
            hashmap.put("u-latlong-accu", a(location));
            if (flag)
            {
                l = 1;
            } else
            {
                l = 0;
            }
            hashmap.put("sdk-collected", Integer.valueOf(l));
        }
        if (d)
        {
            if (h())
            {
                l = ((flag1) ? 1 : 0);
            } else
            {
                l = 0;
            }
            hashmap.put("loc-allowed", Integer.valueOf(l));
        }
        return hashmap;
    }

    private void a(Context context)
    {
        if (f == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Connecting Google API client for location.");
            f = com.inmobi.signals.h.a(context, new a(), new a(), "com.google.android.gms.location.LocationServices");
            com.inmobi.signals.h.a(f);
        }
    }

    static boolean b(boolean flag)
    {
        g = flag;
        return flag;
    }

    static String f()
    {
        return a;
    }

    private LocationConsentStatus g()
    {
        Context context = com.inmobi.commons.a.a.b();
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 || context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0)
        {
            if (h())
            {
                return LocationConsentStatus.AUTHORISED;
            } else
            {
                return LocationConsentStatus.DENIED;
            }
        } else
        {
            return LocationConsentStatus.DENIED;
        }
    }

    private boolean h()
    {
        Object obj = com.inmobi.commons.a.a.b();
        if (android.os.Build.VERSION.SDK_INT < 19) goto _L2; else goto _L1
_L1:
        int l;
        try
        {
            l = android.provider.Settings.Secure.getInt(((Context) (obj)).getContentResolver(), "location_mode");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((android.provider.Settings.SettingNotFoundException) (obj)).printStackTrace();
            l = 0;
        }
        if (l == 0) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if (e == null)
        {
            break; /* Loop/switch isn't completed */
        }
        boolean flag;
        boolean flag1;
        if (((Context) (obj)).checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0)
        {
            flag = e.isProviderEnabled("gps");
            flag1 = false;
        } else
        if (((Context) (obj)).checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0)
        {
            flag1 = e.isProviderEnabled("network");
            flag = false;
        } else
        {
            flag = false;
            flag1 = false;
        }
        if (flag1 || flag) goto _L3; else goto _L5
_L5:
        return false;
    }

    private Location i()
    {
        boolean flag1 = true;
        Object obj3 = com.inmobi.commons.a.a.b();
        Object obj2 = null;
        Object obj = null;
        Object obj1 = obj2;
        if (d)
        {
            obj1 = obj2;
            if (h())
            {
                boolean flag;
                if (g)
                {
                    obj = j();
                    obj1 = com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL;
                    String s = a;
                    StringBuilder stringbuilder = (new StringBuilder()).append("Location info provided by Google Api client:");
                    if (obj != null)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    Logger.a(((com.inmobi.commons.core.utilities.Logger.InternalLogLevel) (obj1)), s, stringbuilder.append(flag).toString());
                }
                obj1 = obj;
                if (obj == null)
                {
                    obj1 = obj;
                    if (e != null)
                    {
                        obj1 = new Criteria();
                        if (((Context) (obj3)).checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0)
                        {
                            ((Criteria) (obj1)).setAccuracy(1);
                        } else
                        if (((Context) (obj3)).checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0)
                        {
                            ((Criteria) (obj1)).setAccuracy(2);
                        }
                        ((Criteria) (obj1)).setCostAllowed(false);
                        obj1 = e.getBestProvider(((Criteria) (obj1)), true);
                        if (obj1 != null)
                        {
                            obj1 = e.getLastKnownLocation(((String) (obj1)));
                            obj = obj1;
                            if (obj1 == null)
                            {
                                obj = k();
                            }
                        }
                        obj1 = com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL;
                        s = a;
                        obj3 = (new StringBuilder()).append("Location info provided by Location manager:");
                        if (obj != null)
                        {
                            flag = flag1;
                        } else
                        {
                            flag = false;
                        }
                        Logger.a(((com.inmobi.commons.core.utilities.Logger.InternalLogLevel) (obj1)), s, ((StringBuilder) (obj3)).append(flag).toString());
                        obj1 = obj;
                    }
                }
            }
        }
        if (obj1 == null)
        {
            com.inmobi.commons.core.c.a.a().a(new e("signals", "LocationFixFailed"));
        }
        return ((Location) (obj1));
    }

    private Location j()
    {
        Object obj;
        try
        {
            obj = Class.forName("com.google.android.gms.location.LocationServices").getDeclaredField("FusedLocationApi");
            Class class1 = Class.forName("com.google.android.gms.common.api.GoogleApiClient");
            obj = (Location)Class.forName("com.google.android.gms.location.FusedLocationProviderApi").getMethod("getLastLocation", new Class[] {
                class1
            }).invoke(((Field) (obj)).get(null), new Object[] {
                f
            });
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Unable to request activity updates from ActivityRecognition client", invocationtargetexception);
            return null;
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Unable to request activity updates from ActivityRecognition client", classnotfoundexception);
            return null;
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Unable to request activity updates from ActivityRecognition client", illegalaccessexception);
            return null;
        }
        catch (NoSuchMethodException nosuchmethodexception)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Unable to request activity updates from ActivityRecognition client", nosuchmethodexception);
            return null;
        }
        catch (NoSuchFieldException nosuchfieldexception)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Unable to request activity updates from ActivityRecognition client", nosuchfieldexception);
            return null;
        }
        return ((Location) (obj));
    }

    private Location k()
    {
        Object obj1 = null;
        if (e == null) goto _L2; else goto _L1
_L1:
        Object obj;
        List list;
        int l;
        list = e.getProviders(true);
        l = list.size() - 1;
        obj = null;
_L5:
        if (l < 0) goto _L4; else goto _L3
_L3:
        obj1 = (String)list.get(l);
        if (!e.isProviderEnabled(((String) (obj1))))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj1 = e.getLastKnownLocation(((String) (obj1)));
        obj = obj1;
        if (obj1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
_L2:
        return ((Location) (obj1));
        l--;
          goto _L5
_L4:
        return ((Location) (obj));
    }

    public void a(boolean flag)
    {
        d = flag;
    }

    void b()
    {
        if (d && com.inmobi.signals.h.a())
        {
            a(com.inmobi.commons.a.a.b());
        }
    }

    public HashMap c()
    {
        this;
        JVM INSTR monitorenter ;
        HashMap hashmap = a(i(), true);
        this;
        JVM INSTR monitorexit ;
        return hashmap;
        Exception exception;
        exception;
        throw exception;
    }

    public HashMap d()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("loc-consent-status", g().toString().toLowerCase(Locale.ENGLISH));
        return hashmap;
    }

    public HashMap e()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        HashMap hashmap;
        hashmap = new HashMap();
        obj = i();
        if (obj == null) goto _L2; else goto _L1
_L1:
        obj = a(((Location) (obj)), true);
_L4:
        java.util.Map.Entry entry;
        for (obj = ((HashMap) (obj)).entrySet().iterator(); ((Iterator) (obj)).hasNext(); hashmap.put(entry.getKey(), entry.getValue().toString()))
        {
            entry = (java.util.Map.Entry)((Iterator) (obj)).next();
        }

        break MISSING_BLOCK_LABEL_95;
        obj;
        throw obj;
_L2:
        obj = a(com.inmobi.commons.core.utilities.info.e.f(), false);
        if (true) goto _L4; else goto _L3
_L3:
        this;
        JVM INSTR monitorexit ;
        return hashmap;
    }

}
