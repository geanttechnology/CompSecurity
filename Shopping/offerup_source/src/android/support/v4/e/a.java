// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.e;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.Address;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Trace;
import com.b.a.a.g;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.offerup.android.dto.ItemListsResponse;
import com.offerup.android.dto.geocode.GoogleMapsGeocodeAddressComponent;
import com.offerup.android.dto.geocode.GoogleMapsGeocodeGeometry;
import com.offerup.android.dto.geocode.GoogleMapsGeocodeLocation;
import com.offerup.android.dto.geocode.GoogleMapsGeocodeResponse;
import com.offerup.android.dto.geocode.GoogleMapsGeocodeResult;
import com.offerup.android.network.AlertService;
import com.offerup.android.network.CategoryService;
import com.offerup.android.network.ItemService;
import com.offerup.android.network.RatingService;
import com.offerup.android.network.SearchService;
import com.offerup.android.network.o;
import com.urbanairship.push.PushMessage;
import e.b.h;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import retrofit.Callback;
import retrofit.RetrofitError;

// Referenced classes of package android.support.v4.e:
//            d, b, c

public class a
{

    public static GoogleAnalytics a;
    private static boolean d;
    private static boolean e;
    private static boolean f;
    private static Tracker g;
    private final Object b[] = new Object[30];
    private int c;

    public a(int i1)
    {
    }

    public static int a(int i1)
    {
        if (i1 < 200 || i1 > 299)
        {
            if (i1 >= 300 && i1 <= 399)
            {
                return 1;
            }
            if (i1 < 400 || i1 > 499)
            {
                return i1 < 500 ? 1 : 1;
            }
        }
        return 0;
    }

    public static int a(int i1, int j1)
    {
        int k1 = Color.alpha(j1);
        int l1 = Color.alpha(i1);
        int i2 = 255 - ((255 - k1) * (255 - l1)) / 255;
        return Color.argb(i2, a(Color.red(i1), l1, Color.red(j1), k1, i2), a(Color.green(i1), l1, Color.green(j1), k1, i2), a(Color.blue(i1), l1, Color.blue(j1), k1, i2));
    }

    private static int a(int i1, int j1, int k1, int l1, int i2)
    {
        if (i2 == 0)
        {
            return 0;
        } else
        {
            return (i1 * 255 * j1 + k1 * l1 * (255 - j1)) / (i2 * 255);
        }
    }

    public static int a(PushMessage pushmessage)
    {
        pushmessage = pushmessage.getPushBundle();
        if (pushmessage != null && pushmessage.size() > 0)
        {
            if (pushmessage.containsKey("lp_version"))
            {
                return 5;
            }
            if (pushmessage.containsKey("action_path"))
            {
                return 7;
            }
            if (pushmessage.containsKey("goto_url"))
            {
                return 3;
            }
            if (pushmessage.containsKey("follower_id"))
            {
                return 2;
            }
            if (pushmessage.containsKey("order_id"))
            {
                return 1;
            }
            if (pushmessage.containsKey("thread_id"))
            {
                return 0;
            }
            if (pushmessage.containsKey("item_rating_id"))
            {
                return 6;
            }
        }
        return 4;
    }

    public static long a(AtomicLong atomiclong, long l1)
    {
        long l2;
        long l4;
        do
        {
            l4 = atomiclong.get();
            long l3 = l4 + l1;
            l2 = l3;
            if (l3 < 0L)
            {
                l2 = 0x7fffffffffffffffL;
            }
        } while (!atomiclong.compareAndSet(l4, l2));
        return l4;
    }

    public static long a(AtomicLongFieldUpdater atomiclongfieldupdater, Object obj, long l1)
    {
        long l2;
        long l4;
        do
        {
            l4 = atomiclongfieldupdater.get(obj);
            long l3 = l4 + l1;
            l2 = l3;
            if (l3 < 0L)
            {
                l2 = 0x7fffffffffffffffL;
            }
        } while (!atomiclongfieldupdater.compareAndSet(obj, l4, l2));
        return l4;
    }

    private static Address a(GoogleMapsGeocodeResponse googlemapsgeocoderesponse)
    {
        googlemapsgeocoderesponse = address;
_L2:
        return googlemapsgeocoderesponse;
        Address address;
        if (googlemapsgeocoderesponse != null)
        {
            try
            {
                if (googlemapsgeocoderesponse.getGeocodeResults() != null && googlemapsgeocoderesponse.getGeocodeResults().size() > 0)
                {
                    address = new Address(Locale.getDefault());
                    googlemapsgeocoderesponse = (GoogleMapsGeocodeResult)googlemapsgeocoderesponse.getGeocodeResults().get(0);
                    address.setLatitude(googlemapsgeocoderesponse.getGeometry().getLocation().getLat().floatValue());
                    address.setLongitude(googlemapsgeocoderesponse.getGeometry().getLocation().getLng().floatValue());
                    for (googlemapsgeocoderesponse = googlemapsgeocoderesponse.getAddressComponents().iterator(); googlemapsgeocoderesponse.hasNext();)
                    {
                        GoogleMapsGeocodeAddressComponent googlemapsgeocodeaddresscomponent = (GoogleMapsGeocodeAddressComponent)googlemapsgeocoderesponse.next();
                        Iterator iterator = googlemapsgeocodeaddresscomponent.getTypes().iterator();
                        while (iterator.hasNext()) 
                        {
                            String s = (String)iterator.next();
                            if ("postal_code".equals(s))
                            {
                                address.setPostalCode(googlemapsgeocodeaddresscomponent.getShortName());
                            }
                            if ("administrative_area_level_1".equals(s))
                            {
                                address.setAdminArea(googlemapsgeocodeaddresscomponent.getShortName());
                            }
                            if ("locality".equals(s))
                            {
                                address.setLocality(googlemapsgeocodeaddresscomponent.getShortName());
                            }
                        }
                    }

                    break MISSING_BLOCK_LABEL_209;
                }
            }
            // Misplaced declaration of an exception variable
            catch (GoogleMapsGeocodeResponse googlemapsgeocoderesponse)
            {
                com.b.a.a.g.a("GeoCodingClient", googlemapsgeocoderesponse);
                return null;
            }
        }
        googlemapsgeocoderesponse = null;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static Address a(Double double1, Double double2)
    {
        if (double1.doubleValue() != 0.0D || double2.doubleValue() != 0.0D)
        {
            if ((double1 = com.offerup.android.network.a.a(double1.doubleValue(), double2.doubleValue())) != null && "OK".equalsIgnoreCase(double1.getStatus()))
            {
                return a(((GoogleMapsGeocodeResponse) (double1)));
            }
        }
        return null;
    }

    public static transient AsyncTask a(AsyncTask asynctask, Object aobj[])
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            asynctask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, aobj);
            return asynctask;
        } else
        {
            asynctask.execute(aobj);
            return asynctask;
        }
    }

    public static Bundle a(Intent intent)
    {
        intent = intent.getBundleExtra("al_applink_data");
        if (intent == null)
        {
            return null;
        } else
        {
            return intent.getBundle("extras");
        }
    }

    public static android.os.Parcelable.Creator a(c c1)
    {
        if (android.os.Build.VERSION.SDK_INT >= 13)
        {
            return new d(c1);
        } else
        {
            return new b(c1);
        }
    }

    public static Tracker a(Context context)
    {
        android/support/v4/e/a;
        JVM INSTR monitorenter ;
        if (g == null)
        {
            g = GoogleAnalytics.getInstance(context).newTracker(0x7f070000);
        }
_L1:
        context = g;
        android/support/v4/e/a;
        JVM INSTR monitorexit ;
        return context;
        Exception exception;
        exception;
        com.b.a.a.g.a(context.getClass().getSimpleName(), exception);
          goto _L1
        context;
        throw context;
    }

    public static String a(String s)
    {
        StringBuffer stringbuffer;
        s = MessageDigest.getInstance("SHA256").digest(s.getBytes("UTF-8"));
        stringbuffer = new StringBuffer();
        int i1 = 0;
_L2:
        if (i1 >= s.length)
        {
            break; /* Loop/switch isn't completed */
        }
        stringbuffer.append(Integer.toHexString(s[i1] & 0xff | 0x100).substring(1, 3));
        i1++;
        if (true) goto _L2; else goto _L1
_L1:
        s = stringbuffer.toString();
        return s;
        s;
_L4:
        return null;
        s;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static String a(Map map)
    {
        if (map.size() > 0)
        {
            StringBuffer stringbuffer = new StringBuffer();
            stringbuffer.append("{");
            Iterator iterator = map.keySet().iterator();
            boolean flag = true;
            while (iterator.hasNext()) 
            {
                String s = (String)iterator.next();
                if (!flag)
                {
                    stringbuffer.append(", ");
                } else
                {
                    flag = false;
                }
                stringbuffer.append((new StringBuilder("\"")).append(s).append("\":\"").append((String)map.get(s)).append("\"").toString());
            }
            stringbuffer.append("}");
            return stringbuffer.toString();
        } else
        {
            return null;
        }
    }

    private static void a(long l1, int i1, Callback callback)
    {
        o.l(o.a(Executors.newSingleThreadExecutor())).updateItem(l1, i1, callback);
    }

    public static void a(long l1, long l2, int i1, Callback callback)
    {
        o.h(o.c(Executors.newCachedThreadPool())).submitRating(l1, l2, i1, callback);
    }

    public static void a(long l1, Callback callback)
    {
        o.l(o.c(Executors.newSingleThreadExecutor())).getItem(l1, callback);
    }

    public static void a(Application application)
    {
        try
        {
            GoogleAnalytics googleanalytics = GoogleAnalytics.getInstance(application);
            a = googleanalytics;
            g = googleanalytics.newTracker(0x7f070000);
            return;
        }
        catch (Exception exception)
        {
            com.b.a.a.g.a(application, exception);
        }
    }

    public static void a(Object obj, StringBuilder stringbuilder)
    {
        String s;
label0:
        {
            if (obj == null)
            {
                stringbuilder.append("null");
                return;
            }
            String s1 = obj.getClass().getSimpleName();
            if (s1 != null)
            {
                s = s1;
                if (s1.length() > 0)
                {
                    break label0;
                }
            }
            s1 = obj.getClass().getName();
            int i1 = s1.lastIndexOf('.');
            s = s1;
            if (i1 > 0)
            {
                s = s1.substring(i1 + 1);
            }
        }
        stringbuilder.append(s);
        stringbuilder.append('{');
        stringbuilder.append(Integer.toHexString(System.identityHashCode(obj)));
    }

    public static void a(Throwable throwable)
    {
        if (throwable instanceof h)
        {
            throw (h)throwable;
        }
        if (throwable instanceof e.b.g)
        {
            Throwable throwable1 = throwable.getCause();
            if (throwable1 instanceof RuntimeException)
            {
                throw (RuntimeException)throwable1;
            } else
            {
                throw (e.b.g)throwable;
            }
        }
        if (throwable instanceof StackOverflowError)
        {
            throw (StackOverflowError)throwable;
        }
        if (throwable instanceof VirtualMachineError)
        {
            throw (VirtualMachineError)throwable;
        }
        if (throwable instanceof ThreadDeath)
        {
            throw (ThreadDeath)throwable;
        }
        if (throwable instanceof LinkageError)
        {
            throw (LinkageError)throwable;
        } else
        {
            return;
        }
    }

    public static void a(Throwable throwable, Throwable throwable1)
    {
        HashSet hashset = new HashSet();
        int i1 = 0;
        Throwable throwable2;
        do
        {
            throwable2 = throwable;
            if (throwable.getCause() == null)
            {
                break;
            }
            if (i1 >= 25)
            {
                return;
            }
            throwable = throwable.getCause();
            throwable2 = throwable;
            if (hashset.contains(throwable.getCause()))
            {
                break;
            }
            hashset.add(throwable.getCause());
            i1++;
        } while (true);
        try
        {
            throwable2.initCause(throwable1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Throwable throwable)
        {
            return;
        }
    }

    public static void a(List list)
    {
        if (list != null && !list.isEmpty())
        {
            if (list.size() == 1)
            {
                list = (Throwable)list.get(0);
                if (list instanceof RuntimeException)
                {
                    throw (RuntimeException)list;
                }
                if (list instanceof Error)
                {
                    throw (Error)list;
                } else
                {
                    throw new RuntimeException(list);
                }
            } else
            {
                throw new e.b.a(list);
            }
        } else
        {
            return;
        }
    }

    public static void a(Callback callback)
    {
        o.m(o.a(Executors.newSingleThreadExecutor())).getNotifications(callback);
    }

    public static int b(int i1)
    {
        return 1 << 32 - Integer.numberOfLeadingZeros(i1 - 1);
    }

    public static int b(int i1, int j1)
    {
        if (j1 < 0 || j1 > 255)
        {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        } else
        {
            return 0xffffff & i1 | j1 << 24;
        }
    }

    public static Address b(String s)
    {
        s = com.offerup.android.network.a.a(s);
        if (s != null && "OK".equalsIgnoreCase(s.getStatus()))
        {
            return a(s);
        } else
        {
            return null;
        }
    }

    public static ItemListsResponse b()
    {
        Object obj = o.a(o.a(Executors.newSingleThreadExecutor()));
        try
        {
            obj = ((SearchService) (obj)).getItemLists();
        }
        catch (RetrofitError retrofiterror)
        {
            com.b.a.a.g.a(com/offerup/android/dto/ItemListsResponse, retrofiterror);
            return null;
        }
        return ((ItemListsResponse) (obj));
    }

    public static void b(long l1, Callback callback)
    {
        a(l1, 2, callback);
    }

    public static void b(Callback callback)
    {
        ((CategoryService)o.a(com/offerup/android/network/CategoryService, o.a(Executors.newSingleThreadExecutor()))).get(callback);
    }

    public static boolean b(Context context)
    {
        context = (ConnectivityManager)context.getSystemService("connectivity");
        NetworkInfo networkinfo = context.getNetworkInfo(1);
        if (networkinfo != null && networkinfo.isConnected())
        {
            return true;
        }
        networkinfo = context.getNetworkInfo(0);
        if (networkinfo != null && networkinfo.isConnected())
        {
            return true;
        }
        context = context.getActiveNetworkInfo();
        return context != null && context.isConnected();
    }

    public static void c(long l1, Callback callback)
    {
        a(l1, 3, callback);
    }

    public static void c(String s)
    {
        if (android.os.Build.VERSION.SDK_INT >= 18)
        {
            Trace.beginSection(s);
        }
    }

    public static boolean c()
    {
        return d;
    }

    public static boolean d()
    {
        return e;
    }

    public static boolean e()
    {
        return f;
    }

    public static void f()
    {
        d = false;
    }

    public static void g()
    {
        e = false;
    }

    public static void h()
    {
        f = false;
    }

    public static void i()
    {
        d = true;
    }

    public static void j()
    {
        e = true;
    }

    public static void k()
    {
        f = true;
    }

    public static void l()
    {
        if (android.os.Build.VERSION.SDK_INT >= 18)
        {
            Trace.endSection();
        }
    }

    public Object a()
    {
        if (c > 0)
        {
            int i1 = c - 1;
            Object obj = b[i1];
            b[i1] = null;
            c = c - 1;
            return obj;
        } else
        {
            return null;
        }
    }

    public boolean a(Object obj)
    {
        int i1;
        boolean flag;
        flag = false;
        i1 = 0;
_L8:
        if (i1 >= c) goto _L2; else goto _L1
_L1:
        if (b[i1] != obj) goto _L4; else goto _L3
_L3:
        i1 = 1;
_L6:
        if (i1 != 0)
        {
            throw new IllegalStateException("Already in the pool!");
        }
        break; /* Loop/switch isn't completed */
_L4:
        i1++;
        continue; /* Loop/switch isn't completed */
_L2:
        i1 = 0;
        if (true) goto _L6; else goto _L5
_L5:
        if (c < b.length)
        {
            b[c] = obj;
            c = c + 1;
            flag = true;
        }
        return flag;
        if (true) goto _L8; else goto _L7
_L7:
    }
}
