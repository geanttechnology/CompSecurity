// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.b.c;
import com.facebook.b.m;
import com.facebook.b.o;
import com.facebook.b.s;
import com.facebook.b.t;
import com.facebook.b.u;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook:
//            q, h, k, o, 
//            p, b, AccessToken, c, 
//            n, s, v, w, 
//            y

public class GraphRequest
{
    public static class ParcelableResourceWithMimeType
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public final Object createFromParcel(Parcel parcel)
            {
                return new ParcelableResourceWithMimeType(parcel, (byte)0);
            }

            public final volatile Object[] newArray(int i1)
            {
                return new ParcelableResourceWithMimeType[i1];
            }

        };
        final String a;
        final Parcelable b;

        public int describeContents()
        {
            return 1;
        }

        public void writeToParcel(Parcel parcel, int i1)
        {
            parcel.writeString(a);
            parcel.writeParcelable(b, i1);
        }


        private ParcelableResourceWithMimeType(Parcel parcel)
        {
            a = parcel.readString();
            b = parcel.readParcelable(com.facebook.k.g().getClassLoader());
        }

        ParcelableResourceWithMimeType(Parcel parcel, byte byte0)
        {
            this(parcel);
        }
    }

    private static final class a
    {

        final GraphRequest a;
        final Object b;

        public a(GraphRequest graphrequest, Object obj)
        {
            a = graphrequest;
            b = obj;
        }
    }

    public static interface b
    {

        public abstract void a(p p1);
    }

    private static interface c
    {

        public abstract void a(String s1, String s2);
    }

    public static interface d
        extends b
    {
    }

    private static final class e
        implements c
    {

        private final OutputStream a;
        private final o b;
        private boolean c;
        private boolean d;

        private static RuntimeException a()
        {
            return new IllegalArgumentException("value is not a supported type.");
        }

        private void a(String s1, Uri uri, String s2)
        {
            String s3 = s2;
            if (s2 == null)
            {
                s3 = "content/unknown";
            }
            a(s1, s1, s3);
            s2 = com.facebook.k.g().getContentResolver().openInputStream(uri);
            int i1;
            if (a instanceof v)
            {
                long l1 = t.a(uri);
                ((v)a).a(l1);
                i1 = 0;
            } else
            {
                i1 = t.a(s2, a) + 0;
            }
            b("", new Object[0]);
            b();
            if (b != null)
            {
                b.a((new StringBuilder("    ")).append(s1).toString(), String.format(Locale.ROOT, "<Data: %d>", new Object[] {
                    Integer.valueOf(i1)
                }));
            }
        }

        private void a(String s1, ParcelFileDescriptor parcelfiledescriptor, String s2)
        {
            String s3 = s2;
            if (s2 == null)
            {
                s3 = "content/unknown";
            }
            a(s1, s1, s3);
            int i1;
            if (a instanceof v)
            {
                ((v)a).a(parcelfiledescriptor.getStatSize());
                i1 = 0;
            } else
            {
                i1 = t.a(new android.os.ParcelFileDescriptor.AutoCloseInputStream(parcelfiledescriptor), a) + 0;
            }
            b("", new Object[0]);
            b();
            if (b != null)
            {
                b.a((new StringBuilder("    ")).append(s1).toString(), String.format(Locale.ROOT, "<Data: %d>", new Object[] {
                    Integer.valueOf(i1)
                }));
            }
        }

        private void a(String s1, String s2, String s3)
        {
            if (!d)
            {
                a("Content-Disposition: form-data; name=\"%s\"", new Object[] {
                    s1
                });
                if (s2 != null)
                {
                    a("; filename=\"%s\"", new Object[] {
                        s2
                    });
                }
                b("", new Object[0]);
                if (s3 != null)
                {
                    b("%s: %s", new Object[] {
                        "Content-Type", s3
                    });
                }
                b("", new Object[0]);
                return;
            } else
            {
                a.write(String.format("%s=", new Object[] {
                    s1
                }).getBytes());
                return;
            }
        }

        private transient void a(String s1, Object aobj[])
        {
            if (!d)
            {
                if (c)
                {
                    a.write("--".getBytes());
                    a.write("3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f".getBytes());
                    a.write("\r\n".getBytes());
                    c = false;
                }
                a.write(String.format(s1, aobj).getBytes());
                return;
            } else
            {
                a.write(URLEncoder.encode(String.format(Locale.US, s1, aobj), "UTF-8").getBytes());
                return;
            }
        }

        private void b()
        {
            if (!d)
            {
                b("--%s", new Object[] {
                    "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f"
                });
                return;
            } else
            {
                a.write("&".getBytes());
                return;
            }
        }

        private transient void b(String s1, Object aobj[])
        {
            a(s1, aobj);
            if (!d)
            {
                a("\r\n", new Object[0]);
            }
        }

        public final void a(String s1, Object obj, GraphRequest graphrequest)
        {
            if (a instanceof y)
            {
                ((y)a).a(graphrequest);
            }
            if (!GraphRequest.a(obj)) goto _L2; else goto _L1
_L1:
            a(s1, GraphRequest.b(obj));
_L4:
            return;
_L2:
            if (!(obj instanceof Bitmap))
            {
                break; /* Loop/switch isn't completed */
            }
            obj = (Bitmap)obj;
            a(s1, s1, "image/png");
            ((Bitmap) (obj)).compress(android.graphics.Bitmap.CompressFormat.PNG, 100, a);
            b("", new Object[0]);
            b();
            if (b != null)
            {
                b.a((new StringBuilder("    ")).append(s1).toString(), "<Image>");
                return;
            }
            if (true) goto _L4; else goto _L3
_L3:
            if (obj instanceof byte[])
            {
                obj = (byte[])(byte[])obj;
                a(s1, s1, "content/unknown");
                a.write(((byte []) (obj)));
                b("", new Object[0]);
                b();
                if (b != null)
                {
                    b.a((new StringBuilder("    ")).append(s1).toString(), String.format(Locale.ROOT, "<Data: %d>", new Object[] {
                        Integer.valueOf(obj.length)
                    }));
                    return;
                }
            } else
            {
                if (obj instanceof Uri)
                {
                    a(s1, (Uri)obj, ((String) (null)));
                    return;
                }
                if (obj instanceof ParcelFileDescriptor)
                {
                    a(s1, (ParcelFileDescriptor)obj, ((String) (null)));
                    return;
                }
                if (obj instanceof ParcelableResourceWithMimeType)
                {
                    graphrequest = (ParcelableResourceWithMimeType)obj;
                    obj = ((ParcelableResourceWithMimeType) (graphrequest)).b;
                    graphrequest = ((ParcelableResourceWithMimeType) (graphrequest)).a;
                    if (obj instanceof ParcelFileDescriptor)
                    {
                        a(s1, (ParcelFileDescriptor)obj, ((String) (graphrequest)));
                        return;
                    }
                    if (obj instanceof Uri)
                    {
                        a(s1, (Uri)obj, ((String) (graphrequest)));
                        return;
                    } else
                    {
                        throw a();
                    }
                } else
                {
                    throw a();
                }
            }
            if (true) goto _L4; else goto _L5
_L5:
        }

        public final void a(String s1, String s2)
        {
            a(s1, ((String) (null)), ((String) (null)));
            b("%s", new Object[] {
                s2
            });
            b();
            if (b != null)
            {
                b.a((new StringBuilder("    ")).append(s1).toString(), s2);
            }
        }

        public final void a(String s1, JSONArray jsonarray, Collection collection)
        {
            if (!(a instanceof y))
            {
                a(s1, jsonarray.toString());
            } else
            {
                y y1 = (y)a;
                a(s1, ((String) (null)), ((String) (null)));
                a("[", new Object[0]);
                collection = collection.iterator();
                int i1 = 0;
                while (collection.hasNext()) 
                {
                    GraphRequest graphrequest = (GraphRequest)collection.next();
                    JSONObject jsonobject = jsonarray.getJSONObject(i1);
                    y1.a(graphrequest);
                    if (i1 > 0)
                    {
                        a(",%s", new Object[] {
                            jsonobject.toString()
                        });
                    } else
                    {
                        a("%s", new Object[] {
                            jsonobject.toString()
                        });
                    }
                    i1++;
                }
                a("]", new Object[0]);
                if (b != null)
                {
                    b.a((new StringBuilder("    ")).append(s1).toString(), jsonarray.toString());
                    return;
                }
            }
        }

        public e(OutputStream outputstream, o o1, boolean flag)
        {
            c = true;
            d = false;
            a = outputstream;
            b = o1;
            d = flag;
        }
    }


    public static final String a = com/facebook/GraphRequest.getSimpleName();
    private static String h;
    private static Pattern i = Pattern.compile("^/?v\\d+\\.\\d+/(.*)");
    private static volatile String q;
    AccessToken b;
    public JSONObject c;
    public Bundle d;
    b e;
    public Object f;
    public boolean g;
    private q j;
    private String k;
    private String l;
    private String m;
    private boolean n;
    private String o;
    private String p;

    public GraphRequest()
    {
        this(null, null, null, null, null);
    }

    public GraphRequest(AccessToken accesstoken, String s1, Bundle bundle, q q1, b b1)
    {
        this(accesstoken, s1, bundle, q1, b1, (byte)0);
    }

    private GraphRequest(AccessToken accesstoken, String s1, Bundle bundle, q q1, b b1, byte byte0)
    {
        n = true;
        g = false;
        b = accesstoken;
        k = s1;
        p = null;
        a(b1);
        if (o != null && q1 != q.a)
        {
            throw new h("Can't change HTTP method on request with overridden URL.");
        }
        if (q1 == null)
        {
            q1 = q.a;
        }
        j = q1;
        if (bundle != null)
        {
            d = new Bundle(bundle);
        } else
        {
            d = new Bundle();
        }
        if (p == null)
        {
            p = s.d();
        }
    }

    public static GraphRequest a(Context context, b b1)
    {
        String s1 = t.a(context);
        if (s1 == null)
        {
            throw new h("Facebook App ID cannot be determined");
        }
        String s2 = (new StringBuilder()).append(s1).append("/custom_audience_third_party_id").toString();
        com.facebook.b.c c1 = com.facebook.b.c.a(context);
        Bundle bundle = new Bundle();
        if (c1.a != null)
        {
            s1 = c1.a;
        } else
        {
            s1 = c1.b;
        }
        if (c1.a != null)
        {
            bundle.putString("udid", s1);
        }
        if (com.facebook.k.b(context) || c1.d)
        {
            bundle.putString("limit_event_usage", "1");
        }
        return new GraphRequest(null, s2, bundle, q.a, b1);
    }

    public static GraphRequest a(String s1)
    {
        return new GraphRequest(null, s1, null, null, null);
    }

    public static GraphRequest a(String s1, JSONObject jsonobject)
    {
        s1 = new GraphRequest(null, s1, null, q.b, null);
        s1.c = jsonobject;
        return s1;
    }

    public static List a(com.facebook.o o1)
    {
        u.a(o1, "requests");
        HttpURLConnection httpurlconnection;
        try
        {
            httpurlconnection = c(o1);
        }
        catch (Exception exception)
        {
            List list = com.facebook.p.a(o1.b, null, new h(exception));
            a(o1, list);
            return list;
        }
        return a(httpurlconnection, o1);
    }

    public static List a(HttpURLConnection httpurlconnection, com.facebook.o o1)
    {
        List list;
        boolean flag;
        flag = true;
        list = com.facebook.p.a(httpurlconnection, o1);
        t.a(httpurlconnection);
        int i1 = o1.size();
        if (i1 != list.size())
        {
            throw new h(String.format(Locale.US, "Received %d responses while expecting %d", new Object[] {
                Integer.valueOf(list.size()), Integer.valueOf(i1)
            }));
        }
        a(o1, list);
        httpurlconnection = com.facebook.b.a();
        if (((com.facebook.b) (httpurlconnection)).b == null) goto _L2; else goto _L1
_L1:
        o1 = Long.valueOf((new Date()).getTime());
        if (!((com.facebook.b) (httpurlconnection)).b.e.h || o1.longValue() - ((com.facebook.b) (httpurlconnection)).c.getTime() <= 0x36ee80L || o1.longValue() - ((com.facebook.b) (httpurlconnection)).b.f.getTime() <= 0x5265c00L) goto _L2; else goto _L3
_L3:
        if (flag)
        {
            httpurlconnection.b();
        }
        return list;
_L2:
        flag = false;
        if (true) goto _L3; else goto _L4
_L4:
    }

    private static void a(Bundle bundle, e e1, GraphRequest graphrequest)
    {
        Iterator iterator = bundle.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s1 = (String)iterator.next();
            Object obj = bundle.get(s1);
            if (d(obj))
            {
                e1.a(s1, obj, graphrequest);
            }
        } while (true);
    }

    private static void a(e e1, Collection collection, Map map)
    {
        JSONArray jsonarray = new JSONArray();
        for (Iterator iterator = collection.iterator(); iterator.hasNext(); ((GraphRequest)iterator.next()).a(jsonarray, map)) { }
        e1.a("batch", jsonarray, collection);
    }

    private static void a(com.facebook.o o1, o o2, int i1, URL url, OutputStream outputstream, boolean flag)
    {
        outputstream = new e(outputstream, o2, flag);
        if (i1 == 1)
        {
            o1 = o1.a(0);
            HashMap hashmap = new HashMap();
            Iterator iterator = ((GraphRequest) (o1)).d.keySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s1 = (String)iterator.next();
                Object obj = ((GraphRequest) (o1)).d.get(s1);
                if (c(obj))
                {
                    hashmap.put(s1, new a(o1, obj));
                }
            } while (true);
            if (o2 != null)
            {
                o2.b("  Parameters:\n");
            }
            a(((GraphRequest) (o1)).d, ((e) (outputstream)), ((GraphRequest) (o1)));
            if (o2 != null)
            {
                o2.b("  Attachments:\n");
            }
            a(((Map) (hashmap)), ((e) (outputstream)));
            if (((GraphRequest) (o1)).c != null)
            {
                a(((GraphRequest) (o1)).c, url.getPath(), ((c) (outputstream)));
            }
            return;
        }
        url = f(o1);
        if (t.a(url))
        {
            throw new h("App ID was not specified at the request or Settings.");
        }
        outputstream.a("batch_app_id", url);
        url = new HashMap();
        a(((e) (outputstream)), ((Collection) (o1)), ((Map) (url)));
        if (o2 != null)
        {
            o2.b("  Attachments:\n");
        }
        a(((Map) (url)), ((e) (outputstream)));
    }

    private static void a(com.facebook.o o1, List list)
    {
label0:
        {
            int j1 = o1.size();
            ArrayList arraylist = new ArrayList();
            for (int i1 = 0; i1 < j1; i1++)
            {
                GraphRequest graphrequest = o1.a(i1);
                if (graphrequest.e != null)
                {
                    arraylist.add(new Pair(graphrequest.e, list.get(i1)));
                }
            }

            if (arraylist.size() > 0)
            {
                list = new Runnable(arraylist, o1) {

                    final ArrayList a;
                    final com.facebook.o b;

                    public final void run()
                    {
                        Pair pair;
                        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((b)pair.first).a((p)pair.second))
                        {
                            pair = (Pair)iterator.next();
                        }

                        for (Iterator iterator1 = b.e.iterator(); iterator1.hasNext(); ((o.a)iterator1.next()).a()) { }
                    }

            
            {
                a = arraylist;
                b = o1;
                super();
            }
                };
                o1 = o1.a;
                if (o1 != null)
                {
                    break label0;
                }
                list.run();
            }
            return;
        }
        o1.post(list);
    }

    private static void a(String s1, Object obj, c c1, boolean flag)
    {
label0:
        {
            Object obj1;
            do
            {
                obj1 = obj.getClass();
                if (!org/json/JSONObject.isAssignableFrom(((Class) (obj1))))
                {
                    break;
                }
                obj = (JSONObject)obj;
                if (flag)
                {
                    String s2;
                    for (obj1 = ((JSONObject) (obj)).keys(); ((Iterator) (obj1)).hasNext(); a(String.format("%s[%s]", new Object[] {
    s1, s2
}), ((JSONObject) (obj)).opt(s2), c1, flag))
                    {
                        s2 = (String)((Iterator) (obj1)).next();
                    }

                    break label0;
                }
                if (((JSONObject) (obj)).has("id"))
                {
                    obj = ((JSONObject) (obj)).optString("id");
                } else
                if (((JSONObject) (obj)).has("url"))
                {
                    obj = ((JSONObject) (obj)).optString("url");
                } else
                {
                    if (!((JSONObject) (obj)).has("fbsdk:create_object"))
                    {
                        break label0;
                    }
                    obj = ((JSONObject) (obj)).toString();
                }
            } while (true);
            if (org/json/JSONArray.isAssignableFrom(((Class) (obj1))))
            {
                obj = (JSONArray)obj;
                int j1 = ((JSONArray) (obj)).length();
                for (int i1 = 0; i1 < j1; i1++)
                {
                    a(String.format(Locale.ROOT, "%s[%d]", new Object[] {
                        s1, Integer.valueOf(i1)
                    }), ((JSONArray) (obj)).opt(i1), c1, flag);
                }

            } else
            if (java/lang/String.isAssignableFrom(((Class) (obj1))) || java/lang/Number.isAssignableFrom(((Class) (obj1))) || java/lang/Boolean.isAssignableFrom(((Class) (obj1))))
            {
                c1.a(s1, obj.toString());
            } else
            if (java/util/Date.isAssignableFrom(((Class) (obj1))))
            {
                obj = (Date)obj;
                c1.a(s1, (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US)).format(((Date) (obj))));
                return;
            }
        }
    }

    private static void a(Map map, e e1)
    {
        Iterator iterator = map.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s1 = (String)iterator.next();
            a a1 = (a)map.get(s1);
            if (c(a1.b))
            {
                e1.a(s1, a1.b, a1.a);
            }
        } while (true);
    }

    private void a(JSONArray jsonarray, Map map)
    {
        JSONObject jsonobject = new JSONObject();
        if (l != null)
        {
            jsonobject.put("name", l);
            jsonobject.put("omit_response_on_success", n);
        }
        if (m != null)
        {
            jsonobject.put("depends_on", m);
        }
        String s1 = c();
        jsonobject.put("relative_url", s1);
        jsonobject.put("method", j);
        if (b != null)
        {
            com.facebook.b.o.a(b.d);
        }
        ArrayList arraylist = new ArrayList();
        Iterator iterator = d.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (String)iterator.next();
            obj = d.get(((String) (obj)));
            if (c(obj))
            {
                String s2 = String.format(Locale.ROOT, "%s%d", new Object[] {
                    "file", Integer.valueOf(map.size())
                });
                arraylist.add(s2);
                map.put(s2, new a(this, obj));
            }
        } while (true);
        if (!arraylist.isEmpty())
        {
            jsonobject.put("attached_files", TextUtils.join(",", arraylist));
        }
        if (c != null)
        {
            map = new ArrayList();
            a(c, s1, new c(map) {

                final ArrayList a;
                final GraphRequest b;

                public final void a(String s3, String s4)
                {
                    a.add(String.format(Locale.US, "%s=%s", new Object[] {
                        s3, URLEncoder.encode(s4, "UTF-8")
                    }));
                }

            
            {
                b = GraphRequest.this;
                a = arraylist;
                super();
            }
            });
            jsonobject.put("body", TextUtils.join("&", map));
        }
        jsonarray.put(jsonobject);
    }

    private static void a(JSONObject jsonobject, String s1, c c1)
    {
        Object obj = i.matcher(s1);
        int i1;
        if (((Matcher) (obj)).matches())
        {
            obj = ((Matcher) (obj)).group(1);
        } else
        {
            obj = s1;
        }
        if (((String) (obj)).startsWith("me/") || ((String) (obj)).startsWith("/me/"))
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (i1 != 0)
        {
            i1 = s1.indexOf(":");
            int j1 = s1.indexOf("?");
            Object obj1;
            if (i1 > 3 && (j1 == -1 || i1 < j1))
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
        } else
        {
            i1 = 0;
        }
        s1 = jsonobject.keys();
        while (s1.hasNext()) 
        {
            obj = (String)s1.next();
            obj1 = jsonobject.opt(((String) (obj)));
            boolean flag;
            if (i1 != 0 && ((String) (obj)).equalsIgnoreCase("image"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            a(((String) (obj)), obj1, c1, flag);
        }
    }

    static boolean a(Object obj)
    {
        return d(obj);
    }

    public static n b(com.facebook.o o1)
    {
        u.a(o1, "requests");
        o1 = new n(o1);
        o1.executeOnExecutor(com.facebook.k.e(), null);
        return o1;
    }

    static String b(Object obj)
    {
        return e(obj);
    }

    private String b(String s1)
    {
        android.net.Uri.Builder builder;
label0:
        {
            builder = (new android.net.Uri.Builder()).encodedPath(s1);
label1:
            do
            {
                String s2;
                for (Iterator iterator = d.keySet().iterator(); iterator.hasNext(); builder.appendQueryParameter(s2, e(s1).toString()))
                {
                    s2 = (String)iterator.next();
                    Object obj = d.get(s2);
                    s1 = ((String) (obj));
                    if (obj == null)
                    {
                        s1 = "";
                    }
                    if (!d(s1))
                    {
                        continue label1;
                    }
                }

                break label0;
            } while (j != q.a);
            throw new IllegalArgumentException(String.format(Locale.US, "Unsupported parameter type for GET request: %s", new Object[] {
                s1.getClass().getSimpleName()
            }));
        }
        return builder.toString();
    }

    private void b()
    {
        if (b == null) goto _L2; else goto _L1
_L1:
        if (!d.containsKey("access_token"))
        {
            String s1 = b.d;
            com.facebook.b.o.a(s1);
            d.putString("access_token", s1);
        }
_L8:
        d.putString("sdk", "android");
        d.putString("format", "json");
        if (!com.facebook.k.a(s.h)) goto _L4; else goto _L3
_L3:
        d.putString("debug", "info");
_L6:
        return;
_L2:
        if (!g && !d.containsKey("access_token"))
        {
            String s2 = com.facebook.k.j();
            String s3 = com.facebook.k.l();
            if (!t.a(s2) && !t.a(s3))
            {
                s2 = (new StringBuilder()).append(s2).append("|").append(s3).toString();
                d.putString("access_token", s2);
            }
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (!com.facebook.k.a(s.g)) goto _L6; else goto _L5
_L5:
        d.putString("debug", "warning");
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private String c()
    {
        if (o != null)
        {
            throw new h("Can't override URL for a batch request");
        } else
        {
            String s1 = d();
            b();
            return b(s1);
        }
    }

    private static HttpURLConnection c(com.facebook.o o1)
    {
        Iterator iterator = o1.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            GraphRequest graphrequest = (GraphRequest)iterator.next();
            if (q.a.equals(graphrequest.j))
            {
                String s2 = graphrequest.p;
                boolean flag;
                if (t.a(s2))
                {
                    flag = true;
                } else
                {
                    String s1 = s2;
                    if (s2.startsWith("v"))
                    {
                        s1 = s2.substring(1);
                    }
                    String as[] = s1.split("\\.");
                    if (as.length >= 2 && Integer.parseInt(as[0]) > 2 || Integer.parseInt(as[0]) >= 2 && Integer.parseInt(as[1]) >= 4)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                }
                if (flag)
                {
                    Bundle bundle = graphrequest.d;
                    if (!bundle.containsKey("fields") || t.a(bundle.getString("fields")))
                    {
                        com.facebook.b.o.b(s.f, "Request", "starting with Graph API v2.4, GET requests for /%s should contain an explicit \"fields\" parameter.", new Object[] {
                            graphrequest.k
                        });
                    }
                }
            }
        } while (true);
        if (o1.size() != 1) goto _L2; else goto _L1
_L1:
        Object obj1 = o1.a(0);
        if (((GraphRequest) (obj1)).o == null) goto _L4; else goto _L3
_L3:
        Object obj = ((GraphRequest) (obj1)).o.toString();
_L20:
        obj = new URL(((String) (obj)));
_L14:
        Object obj2;
        HttpURLConnection httpurlconnection;
        o o2;
        URL url;
        boolean flag1;
        int i1;
        int j1;
        boolean flag2;
        try
        {
            httpurlconnection = (HttpURLConnection)((URL) (obj)).openConnection();
            if (q == null)
            {
                q = String.format("%s.%s", new Object[] {
                    "FBAndroidSDK", "4.7.0"
                });
                obj = m.a;
                if (!t.a(((String) (obj))))
                {
                    q = String.format(Locale.ROOT, "%s/%s", new Object[] {
                        q, obj
                    });
                }
            }
            httpurlconnection.setRequestProperty("User-Agent", q);
            httpurlconnection.setRequestProperty("Accept-Language", Locale.getDefault().toString());
            httpurlconnection.setChunkedStreamingMode(0);
            o2 = new o(s.a, "Request");
            j1 = o1.size();
            flag2 = e(o1);
        }
        // Misplaced declaration of an exception variable
        catch (com.facebook.o o1)
        {
            throw new h("could not construct request body", o1);
        }
        // Misplaced declaration of an exception variable
        catch (com.facebook.o o1)
        {
            throw new h("could not construct request body", o1);
        }
        if (j1 != 1) goto _L6; else goto _L5
_L5:
        obj = o1.a(0).j;
_L15:
        httpurlconnection.setRequestMethod(((q) (obj)).name());
        if (!flag2) goto _L8; else goto _L7
_L7:
        httpurlconnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpurlconnection.setRequestProperty("Content-Encoding", "gzip");
_L16:
        url = httpurlconnection.getURL();
        o2.b("Request:\n");
        o2.a("Id", o1.d);
        o2.a("URL", url);
        o2.a("Method", httpurlconnection.getRequestMethod());
        o2.a("User-Agent", httpurlconnection.getRequestProperty("User-Agent"));
        o2.a("Content-Type", httpurlconnection.getRequestProperty("Content-Type"));
        httpurlconnection.setConnectTimeout(o1.c);
        httpurlconnection.setReadTimeout(o1.c);
        if (obj == q.b)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1) goto _L10; else goto _L9
_L9:
        o2.a();
        return httpurlconnection;
_L4:
        if (((GraphRequest) (obj1)).j != q.b || ((GraphRequest) (obj1)).k == null || !((GraphRequest) (obj1)).k.endsWith("/videos")) goto _L12; else goto _L11
_L11:
        obj = s.c();
_L13:
        obj = String.format("%s/%s", new Object[] {
            obj, ((GraphRequest) (obj1)).d()
        });
        ((GraphRequest) (obj1)).b();
        obj = ((GraphRequest) (obj1)).b(((String) (obj)));
        continue; /* Loop/switch isn't completed */
_L12:
        try
        {
            obj = s.b();
        }
        // Misplaced declaration of an exception variable
        catch (com.facebook.o o1)
        {
            throw new h("could not construct URL for request", o1);
        }
        if (true) goto _L13; else goto _L2
_L2:
        obj = new URL(s.b());
          goto _L14
_L6:
        obj = q.b;
          goto _L15
_L8:
        httpurlconnection.setRequestProperty("Content-Type", String.format("multipart/form-data; boundary=%s", new Object[] {
            "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f"
        }));
          goto _L16
_L10:
        httpurlconnection.setDoOutput(true);
        obj2 = new BufferedOutputStream(httpurlconnection.getOutputStream());
        obj = obj2;
        if (!flag2)
        {
            break MISSING_BLOCK_LABEL_730;
        }
        obj1 = obj2;
        obj = new GZIPOutputStream(((OutputStream) (obj2)));
        obj1 = obj;
        if (!d(o1))
        {
            break MISSING_BLOCK_LABEL_794;
        }
        obj1 = obj;
        obj2 = new v(o1.a);
        obj1 = obj;
        a(o1, null, j1, url, ((OutputStream) (obj2)), flag2);
        obj1 = obj;
        i1 = ((v) (obj2)).b;
        obj1 = obj;
        obj = new w(((OutputStream) (obj)), o1, ((v) (obj2)).a, i1);
        a(o1, o2, j1, url, ((OutputStream) (obj)), flag2);
        ((OutputStream) (obj)).close();
        o2.a();
        return httpurlconnection;
        o1;
        obj1 = null;
_L18:
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_843;
        }
        ((OutputStream) (obj1)).close();
        throw o1;
        o1;
        continue; /* Loop/switch isn't completed */
        o1;
        obj1 = obj;
        if (true) goto _L18; else goto _L17
_L17:
        if (true) goto _L20; else goto _L19
_L19:
    }

    private static boolean c(Object obj)
    {
        return (obj instanceof Bitmap) || (obj instanceof byte[]) || (obj instanceof Uri) || (obj instanceof ParcelFileDescriptor) || (obj instanceof ParcelableResourceWithMimeType);
    }

    private String d()
    {
        if (i.matcher(k).matches())
        {
            return k;
        } else
        {
            return String.format("%s/%s", new Object[] {
                p, k
            });
        }
    }

    private static boolean d(com.facebook.o o1)
    {
        for (Iterator iterator = o1.e.iterator(); iterator.hasNext();)
        {
            if ((o.a)iterator.next() instanceof o.b)
            {
                return true;
            }
        }

        for (o1 = o1.iterator(); o1.hasNext();)
        {
            if (((GraphRequest)o1.next()).e instanceof d)
            {
                return true;
            }
        }

        return false;
    }

    private static boolean d(Object obj)
    {
        return (obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Number) || (obj instanceof Date);
    }

    private static String e(Object obj)
    {
        if (obj instanceof String)
        {
            return (String)obj;
        }
        if ((obj instanceof Boolean) || (obj instanceof Number))
        {
            return obj.toString();
        }
        if (obj instanceof Date)
        {
            return (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US)).format(obj);
        } else
        {
            throw new IllegalArgumentException("Unsupported parameter type.");
        }
    }

    private static boolean e(com.facebook.o o1)
    {
        o1 = o1.iterator();
label0:
        do
        {
            if (o1.hasNext())
            {
                GraphRequest graphrequest = (GraphRequest)o1.next();
                Iterator iterator = graphrequest.d.keySet().iterator();
                String s1;
                do
                {
                    if (!iterator.hasNext())
                    {
                        continue label0;
                    }
                    s1 = (String)iterator.next();
                } while (!c(graphrequest.d.get(s1)));
                break;
            } else
            {
                return true;
            }
        } while (true);
        return false;
    }

    private static String f(com.facebook.o o1)
    {
        if (!t.a(o1.f))
        {
            return o1.f;
        }
        for (o1 = o1.iterator(); o1.hasNext();)
        {
            Object obj = ((GraphRequest)o1.next()).b;
            if (obj != null)
            {
                obj = ((AccessToken) (obj)).g;
                if (obj != null)
                {
                    return ((String) (obj));
                }
            }
        }

        if (!t.a(h))
        {
            return h;
        } else
        {
            return com.facebook.k.j();
        }
    }

    public final p a()
    {
        GraphRequest agraphrequest[] = new GraphRequest[1];
        agraphrequest[0] = this;
        u.a(agraphrequest, "requests");
        List list = a(new com.facebook.o(Arrays.asList(agraphrequest)));
        if (list == null || list.size() != 1)
        {
            throw new h("invalid state: expected a single response");
        } else
        {
            return (p)list.get(0);
        }
    }

    public final void a(b b1)
    {
        if (com.facebook.k.a(s.h) || com.facebook.k.a(s.g))
        {
            e = new b(b1) {

                final b a;
                final GraphRequest b;

                public final void a(p p1)
                {
                    Object obj = p1.a;
                    JSONArray jsonarray;
                    if (obj != null)
                    {
                        obj = ((JSONObject) (obj)).optJSONObject("__debug__");
                    } else
                    {
                        obj = null;
                    }
                    if (obj != null)
                    {
                        jsonarray = ((JSONObject) (obj)).optJSONArray("messages");
                    } else
                    {
                        jsonarray = null;
                    }
                    if (jsonarray != null)
                    {
                        int i1 = 0;
                        while (i1 < jsonarray.length()) 
                        {
                            Object obj1 = jsonarray.optJSONObject(i1);
                            String s1;
                            com.facebook.s s2;
                            if (obj1 != null)
                            {
                                obj = ((JSONObject) (obj1)).optString("message");
                            } else
                            {
                                obj = null;
                            }
                            if (obj1 != null)
                            {
                                s1 = ((JSONObject) (obj1)).optString("type");
                            } else
                            {
                                s1 = null;
                            }
                            if (obj1 != null)
                            {
                                obj1 = ((JSONObject) (obj1)).optString("link");
                            } else
                            {
                                obj1 = null;
                            }
                            if (obj == null || s1 == null)
                            {
                                continue;
                            }
                            s2 = s.h;
                            if (s1.equals("warning"))
                            {
                                s2 = s.g;
                            }
                            s1 = ((String) (obj));
                            if (!t.a(((String) (obj1))))
                            {
                                s1 = (new StringBuilder()).append(((String) (obj))).append(" Link: ").append(((String) (obj1))).toString();
                            }
                            com.facebook.b.o.a(s2, GraphRequest.a, s1);
                            i1++;
                        }
                    }
                    if (a != null)
                    {
                        a.a(p1);
                    }
                }

            
            {
                b = GraphRequest.this;
                a = b1;
                super();
            }
            };
            return;
        } else
        {
            e = b1;
            return;
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("{Request:  accessToken: ");
        Object obj;
        if (b == null)
        {
            obj = "null";
        } else
        {
            obj = b;
        }
        return stringbuilder.append(obj).append(", graphPath: ").append(k).append(", graphObject: ").append(c).append(", httpMethod: ").append(j).append(", parameters: ").append(d).append("}").toString();
    }

}
