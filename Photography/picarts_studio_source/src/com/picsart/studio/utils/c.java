// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.socialin.android.apiv3.SocialinApiV3;
import com.socialin.android.apiv3.model.Adress;
import com.socialin.android.apiv3.util.Utils;
import com.socialin.android.d;
import com.socialin.android.dialog.e;
import com.socialin.android.dialog.f;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.picsart.studio.utils:
//            d, e

public class c
{

    private static final String a = com/picsart/studio/utils/c.getSimpleName();
    private static LocationManager b;

    public c()
    {
    }

    public static Location a(Context context, LocationListener locationlistener)
    {
label0:
        {
            context = (LocationManager)context.getSystemService("location");
            b = context;
            if (context == null)
            {
                break label0;
            }
            context = b.getProviders(true).iterator();
            Object obj;
            do
            {
                if (!context.hasNext())
                {
                    break label0;
                }
                obj = (String)context.next();
                com.socialin.android.d.a("LocationUtils", (new StringBuilder("request for location with bestProvider= ")).append(((String) (obj))).toString());
                if (locationlistener != null)
                {
                    b.requestLocationUpdates(((String) (obj)), 20000L, 50F, locationlistener);
                }
                obj = b.getLastKnownLocation(((String) (obj)));
            } while (obj == null);
            return ((Location) (obj));
        }
        return null;
    }

    public static Adress a(Intent intent, Context context)
    {
        Object obj = null;
        if (intent != null)
        {
            Place place = PlacePicker.getPlace(intent, context);
            context = "";
            obj = "";
            String as[] = place.getAddress().toString().split(",");
            Adress adress;
            if (as.length >= 3)
            {
                String as1[] = as[1].trim().split(" ");
                intent = ((Intent) (obj));
                if (as1.length > 0)
                {
                    String s = as1[0];
                    intent = ((Intent) (obj));
                    context = s;
                    if (as1.length > 1)
                    {
                        intent = as1[1];
                        context = s;
                    }
                }
                String s1 = as[2].trim();
                obj = context;
                context = intent;
                intent = s1;
            } else
            {
                obj = "";
                context = "";
                intent = "";
            }
            adress = new Adress();
            adress.place = place.getName().toString();
            adress.city = ((String) (obj));
            adress.country = intent;
            adress.zip = context;
            adress.setLatitude((float)place.getLatLng().latitude);
            adress.setLongitude((float)place.getLatLng().longitude);
            adress.venueId = place.getId();
            obj = adress;
        }
        return ((Adress) (obj));
    }

    public static Adress a(Location location, Activity activity)
    {
        double d1;
        double d2;
        Adress adress;
        d1 = location.getLatitude();
        d2 = location.getLongitude();
        adress = new Adress();
        location = new Geocoder(activity);
        Object obj = location.getFromLocation(d1, d2, 4);
        if (obj == null) goto _L2; else goto _L1
_L1:
        int i;
        i = 0;
        location = null;
_L4:
        activity = location;
        if (i >= ((List) (obj)).size())
        {
            break; /* Loop/switch isn't completed */
        }
        location = (Address)((List) (obj)).get(i);
        activity = location;
        if (location != null)
        {
            break; /* Loop/switch isn't completed */
        }
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        if (activity == null) goto _L2; else goto _L5
_L5:
        location = activity.getCountryName();
        obj = activity.getLocality();
        adress.city = ((String) (obj));
        adress.country = location;
        adress.setLatitude((float)d1);
        adress.setLongitude((float)d2);
        if (activity.getSubLocality() == null) goto _L7; else goto _L6
_L6:
        location = activity.getSubLocality();
_L12:
        adress.place = location;
        if (activity.getAdminArea() == null) goto _L9; else goto _L8
_L8:
        location = activity.getAdminArea();
_L10:
        adress.state = location;
        adress.zip = activity.getPostalCode();
        adress.street = activity.getSubLocality();
        return adress;
_L7:
        location = ((Location) (obj));
        if (obj != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (activity.getSubAdminArea() != null)
        {
            location = activity.getSubAdminArea();
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            location = activity.getAdminArea();
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Location location)
        {
            location.printStackTrace();
        }
          goto _L2
_L9:
        location = activity.getSubAdminArea();
          goto _L10
_L2:
        return adress;
        if (true) goto _L12; else goto _L11
_L11:
    }

    public static String a(Context context, Criteria criteria, Boolean boolean1)
    {
        context = (LocationManager)context.getSystemService("location");
        b = context;
        return context.getBestProvider(criteria, boolean1.booleanValue());
    }

    private static String a(File file)
    {
        if (!file.exists() || !file.canRead() && System.currentTimeMillis() - file.lastModified() > 0x240c8400L)
        {
            return null;
        }
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(file))));
        file = "";
        do
        {
            String s = bufferedreader.readLine();
            if (s != null)
            {
                s = s.trim();
                file = (new StringBuilder()).append(file).append(s).toString();
            } else
            {
                bufferedreader.close();
                return file;
            }
        } while (true);
    }

    public static ArrayList a(Context context, double d1, double d2)
    {
        ArrayList arraylist;
        Object obj;
        DecimalFormat decimalformat;
        int i;
        int j;
label0:
        {
label1:
            {
                decimalformat = new DecimalFormat("##.####");
                obj = a(context, "4square", decimalformat.format(d1), decimalformat.format(d2));
                if (obj != null)
                {
                    arraylist = ((ArrayList) (obj));
                    if (((ArrayList) (obj)).size() != 0)
                    {
                        break label1;
                    }
                }
                arraylist = new ArrayList();
                obj = a(d1, d2);
                if (obj != null)
                {
                    break label0;
                }
                arraylist = null;
            }
            return arraylist;
        }
        j = ((JSONArray) (obj)).length();
        if (j == 0)
        {
            return null;
        }
        i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        com.picsart.studio.utils.d d3;
        Object obj1;
        JSONObject jsonobject;
        try
        {
            d3 = new com.picsart.studio.utils.d();
            obj1 = ((JSONArray) (obj)).getJSONObject(i);
            d3.d = null;
            d3.b = ((JSONObject) (obj1)).optString("name");
            d3.g = ((JSONObject) (obj1)).optString("state");
            d3.h = ((JSONObject) (obj1)).optString("id");
            jsonobject = ((JSONObject) (obj1)).optJSONObject("location");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            com.socialin.android.d.b(a, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(context.getMessage()).toString()
            });
            return null;
        }
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_255;
        }
        d3.c = jsonobject.optString("address");
        d3.e = jsonobject.optString("city");
        d3.f = jsonobject.optString("country");
        d3.d = new com.picsart.studio.utils.e((int)(jsonobject.optDouble("lat") * 1000000D), (int)(jsonobject.optDouble("lng") * 1000000D));
        obj1 = ((JSONObject) (obj1)).optJSONArray("categories");
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_298;
        }
        if (((JSONArray) (obj1)).length() > 0)
        {
            d3.a = ((JSONObject)((JSONArray) (obj1)).get(0)).optString("name");
        }
        arraylist.add(d3);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        a("4square", decimalformat.format(d1), decimalformat.format(d2), arraylist, context);
        return arraylist;
    }

    private static ArrayList a(Context context, String s, String s1, String s2)
    {
        File file = Environment.getExternalStorageDirectory();
        context = (new StringBuilder()).append(context.getString(0x7f0808fb)).append("/.cache/map").toString();
        (new File((new StringBuilder()).append(file.getAbsolutePath()).append("/").append(context).toString())).mkdir();
        context = new File((new StringBuilder()).append(file.getAbsolutePath()).append("/").append(context).append("/").append(s).append(String.valueOf(s1)).append(",").append(String.valueOf(s2)).append("_list.txt").toString());
        if (context.exists() && context.canRead()) goto _L2; else goto _L1
_L1:
        context = null;
_L4:
        return context;
_L2:
        s = new ArrayList();
        int i;
        int j;
        try
        {
            s1 = new JSONArray(a(((File) (context))));
            j = s1.length();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return s;
        }
        i = 0;
        context = s;
        if (i >= j) goto _L4; else goto _L3
_L3:
        context = s1.getJSONObject(i);
        s2 = new com.picsart.studio.utils.d();
        s2.b = context.optString("locationName");
        s2.c = context.optString("address");
        s2.e = context.optString("city");
        s2.a = context.optString("categoryName");
        s2.f = context.optString("country");
        s2.d = new com.picsart.studio.utils.e(context.optInt("latitude"), context.optInt("longitude"));
        s2.g = context.optString("state");
        s2.h = context.optString("venue_Id");
        s.add(s2);
        i++;
        break MISSING_BLOCK_LABEL_189;
    }

    public static List a(double d1, double d2, String s)
    {
        ArrayList arraylist;
        arraylist = new ArrayList();
        if (s.isEmpty())
        {
            return arraylist;
        }
        List list = a(new URL((new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=")).append(d1).append(",").append(d2).append("&name=").append(s).append("&name=5000").append("&key=AIzaSyBlJGhKFFqCBXL-nQyBs4IRTFGXJ9DqQII").toString()));
        s = a(new URL((new StringBuilder("https://maps.googleapis.com/maps/api/place/textsearch/json?query=")).append(s).append("&key=AIzaSyBlJGhKFFqCBXL-nQyBs4IRTFGXJ9DqQII").toString()));
        arraylist.addAll(list);
        arraylist.addAll(s);
        return arraylist;
        s;
_L2:
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(s.getMessage()).toString()
        });
        return null;
        s;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static List a(URL url)
    {
        ArrayList arraylist = new ArrayList();
        if (url.toString().isEmpty())
        {
            throw new MalformedURLException("provided URL is null or empty");
        }
        Object obj = url.openConnection();
        url = new StringBuilder();
        obj = new BufferedReader(new InputStreamReader(((URLConnection) (obj)).getInputStream()));
        do
        {
            String s = ((BufferedReader) (obj)).readLine();
            if (s == null)
            {
                break;
            }
            url.append(s);
        } while (true);
        obj = (new JSONObject(url.toString())).getJSONArray("results");
        int j = ((JSONArray) (obj)).length();
        int i = 0;
        while (i < j) 
        {
            url = ((JSONArray) (obj)).getJSONObject(i);
            JSONObject jsonobject = url.getJSONObject("geometry").getJSONObject("location");
            com.picsart.studio.utils.d d1 = new com.picsart.studio.utils.d();
            d1.b = url.optString("name");
            if (url.optString("vicinity") == null || url.optString("vicinity").isEmpty())
            {
                url = url.optString("formatted_address");
            } else
            {
                url = url.optString("vicinity");
            }
            d1.c = url;
            d1.d = new com.picsart.studio.utils.e((int)(jsonobject.optDouble("lat") * 1000000D), (int)(jsonobject.optDouble("lng") * 1000000D));
            arraylist.add(d1);
            i++;
        }
        return arraylist;
    }

    private static JSONArray a(double d1, double d2)
    {
        Object obj;
        Object obj1;
        obj1 = (new URL((new StringBuilder()).append(SocialinApiV3.getInstance().getFourSquareUrl()).append("?ll=").append(d1).append(",").append(d2).toString())).openConnection().getInputStream();
        obj = new StringBuilder();
        obj1 = new BufferedReader(new InputStreamReader(((java.io.InputStream) (obj1))));
_L3:
        String s = ((BufferedReader) (obj1)).readLine();
        if (s == null) goto _L2; else goto _L1
_L1:
        ((StringBuilder) (obj)).append(s);
          goto _L3
        obj;
_L5:
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(((Exception) (obj)).getMessage()).toString()
        });
        return null;
_L2:
        obj = (new JSONObject(((StringBuilder) (obj)).toString())).getJSONObject("response").getJSONArray("venues");
        return ((JSONArray) (obj));
        obj;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static void a(Activity activity, Adress adress)
    {
        com.google.android.gms.location.places.ui.PlacePicker.IntentBuilder intentbuilder;
        intentbuilder = new com.google.android.gms.location.places.ui.PlacePicker.IntentBuilder();
        if (adress == null)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        intentbuilder.setLatLngBounds(new LatLngBounds(new LatLng(adress.getLatitude() - 0.005F, adress.getLongitude() - 0.005F), new LatLng(adress.getLatitude() + 0.005F, adress.getLongitude() + 0.005F)));
        activity.startActivityForResult(intentbuilder.build(activity), 167);
        return;
        adress;
_L2:
        Toast.makeText(activity, 0x7f080036, 0).show();
        return;
        adress;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static void a(Context context, String s)
    {
        context = new File(context.getCacheDir(), "location.txt");
        try
        {
            if (context.exists())
            {
                context.delete();
            }
            context.createNewFile();
            context = new FileWriter(context, true);
            context.append(s);
            context.flush();
            context.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
    }

    public static void a(LocationListener locationlistener)
    {
        if (b != null)
        {
            b.removeUpdates(locationlistener);
            b = null;
        }
    }

    private static void a(String s, String s1, String s2, ArrayList arraylist, Context context)
    {
        File file = Environment.getExternalStorageDirectory();
        context = (new StringBuilder()).append(context.getString(0x7f0808fb)).append("/.cache/map").toString();
        s = new File((new StringBuilder()).append(file.getAbsolutePath()).append("/").append(context).append("/").append(s).append(String.valueOf(s1)).append(",").append(String.valueOf(s2)).append("_list.txt").toString());
        int j;
        s1 = new JSONArray();
        s2 = new FileWriter(s, false);
        j = arraylist.size();
        int i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        s.createNewFile();
        context = new JSONObject();
        context.put("locationName", ((com.picsart.studio.utils.d)arraylist.get(i)).b);
        context.put("city", ((com.picsart.studio.utils.d)arraylist.get(i)).e);
        context.put("country", ((com.picsart.studio.utils.d)arraylist.get(i)).f);
        context.put("latitude", ((com.picsart.studio.utils.d)arraylist.get(i)).d.a);
        context.put("longitude", ((com.picsart.studio.utils.d)arraylist.get(i)).d.b);
        context.put("state", ((com.picsart.studio.utils.d)arraylist.get(i)).g);
        context.put("venue_Id", ((com.picsart.studio.utils.d)arraylist.get(i)).h);
        context.put("address", ((com.picsart.studio.utils.d)arraylist.get(i)).c);
        context.put("categoryName", ((com.picsart.studio.utils.d)arraylist.get(i)).a);
        s1.put(context);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        try
        {
            s2.write(s1.toString());
            s2.flush();
            s2.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(s.getMessage()).toString()
        });
        return;
    }

    public static boolean a(Context context)
    {
        context = (LocationManager)context.getSystemService("location");
        b = context;
        return context.isProviderEnabled("gps");
    }

    public static boolean a(Location location, Location location1)
    {
        if (location1 != null)
        {
            long l = location.getTime() - location1.getTime();
            boolean flag;
            boolean flag1;
            boolean flag2;
            if (l > 0x1d4c0L)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (l < 0xfffffffffffe2b40L)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (l > 0L)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag1)
            {
                if (flag2)
                {
                    return false;
                }
                int i = (int)(location.getAccuracy() - location1.getAccuracy());
                boolean flag3;
                boolean flag4;
                if (i > 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (i < 0)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                if (i > 200)
                {
                    flag3 = true;
                } else
                {
                    flag3 = false;
                }
                location = location.getProvider();
                location1 = location1.getProvider();
                if (location == null)
                {
                    if (location1 == null)
                    {
                        flag4 = true;
                    } else
                    {
                        flag4 = false;
                    }
                } else
                {
                    flag4 = location.equals(location1);
                }
                if (!flag2 && (!flag || flag1) && (!flag || flag3 || !flag4))
                {
                    return false;
                }
            }
        }
        return true;
    }

    public static Dialog b(Context context)
    {
        f f1 = new f(context);
        f1.a = context.getString(0x7f08043f);
        f1.b = context.getString(0x7f080421);
        context = f1.a(context.getString(0x7f08003f), new android.view.View.OnClickListener(context) {

            private Context a;

            public final void onClick(View view)
            {
                view = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
                ((Activity)a).startActivityForResult(view, 11);
            }

            
            {
                a = context;
                super();
            }
        }).a();
        context.setCancelable(true);
        context.setCanceledOnTouchOutside(true);
        return context;
    }

    public static List b(Context context, double d1, double d2)
    {
        context = new Geocoder(context);
        try
        {
            context = context.getFromLocation(d1, d2, 1);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return null;
        }
        return context;
    }

    public static boolean c(Context context)
    {
        return (new File(context.getCacheDir(), "location.txt")).exists();
    }

    public static String d(Context context)
    {
        return Utils.getCountryCode(context);
    }

}
