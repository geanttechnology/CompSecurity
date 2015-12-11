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
import android.support.v7.ju;
import android.support.v7.jv;
import android.support.v7.ka;
import android.support.v7.kb;
import android.support.v7.kc;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
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
//            q, h, p, o, 
//            b, s, v, w, 
//            AccessToken, n, k, y

public class GraphRequest
{
    public static class ParcelableResourceWithMimeType
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public ParcelableResourceWithMimeType a(Parcel parcel)
            {
                return new ParcelableResourceWithMimeType(parcel);
            }

            public ParcelableResourceWithMimeType[] a(int i1)
            {
                return new ParcelableResourceWithMimeType[i1];
            }

            public Object createFromParcel(Parcel parcel)
            {
                return a(parcel);
            }

            public Object[] newArray(int i1)
            {
                return a(i1);
            }

        };
        private final String a;
        private final Parcelable b;

        public String a()
        {
            return a;
        }

        public Parcelable b()
        {
            return b;
        }

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
            b = parcel.readParcelable(com.facebook.k.f().getClassLoader());
        }

    }

    private static class a
    {

        private final GraphRequest a;
        private final Object b;

        public GraphRequest a()
        {
            return a;
        }

        public Object b()
        {
            return b;
        }

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

    public static interface c
    {

        public abstract void a(JSONObject jsonobject, p p1);
    }

    private static interface d
    {

        public abstract void a(String s1, String s2)
            throws IOException;
    }

    public static interface e
        extends b
    {

        public abstract void a(long l1, long l2);
    }

    private static class f
        implements d
    {

        private final OutputStream a;
        private final jv b;
        private boolean c;
        private boolean d;

        private RuntimeException b()
        {
            return new IllegalArgumentException("value is not a supported type.");
        }

        public void a()
            throws IOException
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

        public void a(String s1, Bitmap bitmap)
            throws IOException
        {
            a(s1, s1, "image/png");
            bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, a);
            b("", new Object[0]);
            a();
            if (b != null)
            {
                b.a((new StringBuilder()).append("    ").append(s1).toString(), "<Image>");
            }
        }

        public void a(String s1, Uri uri, String s2)
            throws IOException
        {
            String s3 = s2;
            if (s2 == null)
            {
                s3 = "content/unknown";
            }
            a(s1, s1, s3);
            s2 = com.facebook.k.f().getContentResolver().openInputStream(uri);
            int i1;
            if (a instanceof v)
            {
                long l1 = kb.e(uri);
                ((v)a).a(l1);
                i1 = 0;
            } else
            {
                i1 = kb.a(s2, a) + 0;
            }
            b("", new Object[0]);
            a();
            if (b != null)
            {
                b.a((new StringBuilder()).append("    ").append(s1).toString(), String.format(Locale.ROOT, "<Data: %d>", new Object[] {
                    Integer.valueOf(i1)
                }));
            }
        }

        public void a(String s1, ParcelFileDescriptor parcelfiledescriptor, String s2)
            throws IOException
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
                i1 = kb.a(new android.os.ParcelFileDescriptor.AutoCloseInputStream(parcelfiledescriptor), a) + 0;
            }
            b("", new Object[0]);
            a();
            if (b != null)
            {
                b.a((new StringBuilder()).append("    ").append(s1).toString(), String.format(Locale.ROOT, "<Data: %d>", new Object[] {
                    Integer.valueOf(i1)
                }));
            }
        }

        public void a(String s1, Object obj, GraphRequest graphrequest)
            throws IOException
        {
            if (a instanceof y)
            {
                ((y)a).a(graphrequest);
            }
            if (GraphRequest.b(obj))
            {
                a(s1, GraphRequest.c(obj));
                return;
            }
            if (obj instanceof Bitmap)
            {
                a(s1, (Bitmap)obj);
                return;
            }
            if (obj instanceof byte[])
            {
                a(s1, (byte[])(byte[])obj);
                return;
            }
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
                obj = graphrequest.b();
                graphrequest = graphrequest.a();
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
                    throw b();
                }
            } else
            {
                throw b();
            }
        }

        public void a(String s1, String s2)
            throws IOException
        {
            a(s1, ((String) (null)), ((String) (null)));
            b("%s", new Object[] {
                s2
            });
            a();
            if (b != null)
            {
                b.a((new StringBuilder()).append("    ").append(s1).toString(), s2);
            }
        }

        public void a(String s1, String s2, String s3)
            throws IOException
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

        public void a(String s1, JSONArray jsonarray, Collection collection)
            throws IOException, JSONException
        {
            if (!(a instanceof y))
            {
                if (!(jsonarray instanceof JSONArray))
                {
                    jsonarray = jsonarray.toString();
                } else
                {
                    jsonarray = JSONArrayInstrumentation.toString((JSONArray)jsonarray);
                }
                a(s1, ((String) (jsonarray)));
            } else
            {
                y y1 = (y)a;
                a(s1, ((String) (null)), ((String) (null)));
                a("[", new Object[0]);
                Iterator iterator = collection.iterator();
                int i1 = 0;
                while (iterator.hasNext()) 
                {
                    collection = (GraphRequest)iterator.next();
                    JSONObject jsonobject = jsonarray.getJSONObject(i1);
                    y1.a(collection);
                    if (i1 > 0)
                    {
                        if (!(jsonobject instanceof JSONObject))
                        {
                            collection = jsonobject.toString();
                        } else
                        {
                            collection = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
                        }
                        a(",%s", new Object[] {
                            collection
                        });
                    } else
                    {
                        if (!(jsonobject instanceof JSONObject))
                        {
                            collection = jsonobject.toString();
                        } else
                        {
                            collection = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
                        }
                        a("%s", new Object[] {
                            collection
                        });
                    }
                    i1++;
                }
                a("]", new Object[0]);
                if (b != null)
                {
                    collection = b;
                    String s2 = (new StringBuilder()).append("    ").append(s1).toString();
                    if (!(jsonarray instanceof JSONArray))
                    {
                        s1 = jsonarray.toString();
                    } else
                    {
                        s1 = JSONArrayInstrumentation.toString((JSONArray)jsonarray);
                    }
                    collection.a(s2, s1);
                    return;
                }
            }
        }

        public void a(String s1, byte abyte0[])
            throws IOException
        {
            a(s1, s1, "content/unknown");
            a.write(abyte0);
            b("", new Object[0]);
            a();
            if (b != null)
            {
                b.a((new StringBuilder()).append("    ").append(s1).toString(), String.format(Locale.ROOT, "<Data: %d>", new Object[] {
                    Integer.valueOf(abyte0.length)
                }));
            }
        }

        public transient void a(String s1, Object aobj[])
            throws IOException
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

        public transient void b(String s1, Object aobj[])
            throws IOException
        {
            a(s1, aobj);
            if (!d)
            {
                a("\r\n", new Object[0]);
            }
        }

        public f(OutputStream outputstream, jv jv1, boolean flag)
        {
            c = true;
            d = false;
            a = outputstream;
            b = jv1;
            d = flag;
        }
    }


    public static final String a = com/facebook/GraphRequest.getSimpleName();
    private static String b;
    private static Pattern c = Pattern.compile("^/?v\\d+\\.\\d+/(.*)");
    private static volatile String q;
    private AccessToken d;
    private q e;
    private String f;
    private JSONObject g;
    private String h;
    private String i;
    private boolean j;
    private Bundle k;
    private b l;
    private String m;
    private Object n;
    private String o;
    private boolean p;

    public GraphRequest()
    {
        this(null, null, null, null, null);
    }

    public GraphRequest(AccessToken accesstoken, String s1, Bundle bundle, q q1, b b1)
    {
        this(accesstoken, s1, bundle, q1, b1, null);
    }

    public GraphRequest(AccessToken accesstoken, String s1, Bundle bundle, q q1, b b1, String s2)
    {
        j = true;
        p = false;
        d = accesstoken;
        f = s1;
        o = s2;
        a(b1);
        a(q1);
        if (bundle != null)
        {
            k = new Bundle(bundle);
        } else
        {
            k = new Bundle();
        }
        if (o == null)
        {
            o = ka.d();
        }
    }

    public static GraphRequest a(AccessToken accesstoken, c c1)
    {
        return new GraphRequest(accesstoken, "me", null, null, new b(c1) {

            final c a;

            public void a(p p1)
            {
                if (a != null)
                {
                    a.a(p1.b(), p1);
                }
            }

            
            {
                a = c1;
                super();
            }
        });
    }

    public static GraphRequest a(AccessToken accesstoken, String s1, b b1)
    {
        return new GraphRequest(accesstoken, s1, null, null, b1);
    }

    public static GraphRequest a(AccessToken accesstoken, String s1, JSONObject jsonobject, b b1)
    {
        accesstoken = new GraphRequest(accesstoken, s1, null, q.b, b1);
        accesstoken.a(jsonobject);
        return accesstoken;
    }

    public static p a(GraphRequest graphrequest)
    {
        graphrequest = a(new GraphRequest[] {
            graphrequest
        });
        if (graphrequest == null || graphrequest.size() != 1)
        {
            throw new h("invalid state: expected a single response");
        } else
        {
            return (p)graphrequest.get(0);
        }
    }

    private String a(String s1)
    {
        android.net.Uri.Builder builder;
label0:
        {
            builder = (new android.net.Uri.Builder()).encodedPath(s1);
label1:
            do
            {
                String s2;
                for (Iterator iterator = k.keySet().iterator(); iterator.hasNext(); builder.appendQueryParameter(s2, f(s1).toString()))
                {
                    s2 = (String)iterator.next();
                    Object obj = k.get(s2);
                    s1 = ((String) (obj));
                    if (obj == null)
                    {
                        s1 = "";
                    }
                    if (!e(s1))
                    {
                        continue label1;
                    }
                }

                break label0;
            } while (e != q.a);
            throw new IllegalArgumentException(String.format(Locale.US, "Unsupported parameter type for GET request: %s", new Object[] {
                s1.getClass().getSimpleName()
            }));
        }
        return builder.toString();
    }

    public static HttpURLConnection a(o o1)
    {
        d(o1);
        Object obj;
        if (o1.size() != 1)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        obj = new URL(o1.a(0).l());
_L1:
        try
        {
            obj = a(((URL) (obj)));
            a(o1, ((HttpURLConnection) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (o o1)
        {
            throw new h("could not construct request body", o1);
        }
        // Misplaced declaration of an exception variable
        catch (o o1)
        {
            throw new h("could not construct request body", o1);
        }
        return ((HttpURLConnection) (obj));
        try
        {
            obj = new URL(ka.b());
        }
        // Misplaced declaration of an exception variable
        catch (o o1)
        {
            throw new h("could not construct URL for request", o1);
        }
          goto _L1
    }

    private static HttpURLConnection a(URL url)
        throws IOException
    {
        url = (HttpURLConnection)HttpInstrumentation.openConnection(url.openConnection());
        url.setRequestProperty("User-Agent", p());
        url.setRequestProperty("Accept-Language", Locale.getDefault().toString());
        url.setChunkedStreamingMode(0);
        return url;
    }

    public static List a(HttpURLConnection httpurlconnection, o o1)
    {
        List list = com.facebook.p.a(httpurlconnection, o1);
        kb.a(httpurlconnection);
        int i1 = o1.size();
        if (i1 != list.size())
        {
            throw new h(String.format(Locale.US, "Received %d responses while expecting %d", new Object[] {
                Integer.valueOf(list.size()), Integer.valueOf(i1)
            }));
        } else
        {
            a(o1, list);
            com.facebook.b.a().d();
            return list;
        }
    }

    public static List a(Collection collection)
    {
        return b(new o(collection));
    }

    public static transient List a(GraphRequest agraphrequest[])
    {
        kc.a(agraphrequest, "requests");
        return a(((Collection) (Arrays.asList(agraphrequest))));
    }

    private static void a(Bundle bundle, f f1, GraphRequest graphrequest)
        throws IOException
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
            if (e(obj))
            {
                f1.a(s1, obj, graphrequest);
            }
        } while (true);
    }

    private static void a(f f1, Collection collection, Map map)
        throws JSONException, IOException
    {
        JSONArray jsonarray = new JSONArray();
        for (Iterator iterator = collection.iterator(); iterator.hasNext(); ((GraphRequest)iterator.next()).a(jsonarray, map)) { }
        f1.a("batch", jsonarray, collection);
    }

    private static void a(o o1, jv jv1, int i1, URL url, OutputStream outputstream, boolean flag)
        throws IOException, JSONException
    {
        outputstream = new f(outputstream, jv1, flag);
        if (i1 == 1)
        {
            o1 = o1.a(0);
            HashMap hashmap = new HashMap();
            Iterator iterator = ((GraphRequest) (o1)).k.keySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s1 = (String)iterator.next();
                Object obj = ((GraphRequest) (o1)).k.get(s1);
                if (d(obj))
                {
                    hashmap.put(s1, new a(o1, obj));
                }
            } while (true);
            if (jv1 != null)
            {
                jv1.c("  Parameters:\n");
            }
            a(((GraphRequest) (o1)).k, ((f) (outputstream)), ((GraphRequest) (o1)));
            if (jv1 != null)
            {
                jv1.c("  Attachments:\n");
            }
            a(((Map) (hashmap)), ((f) (outputstream)));
            if (((GraphRequest) (o1)).g != null)
            {
                a(((GraphRequest) (o1)).g, url.getPath(), ((d) (outputstream)));
            }
            return;
        }
        url = g(o1);
        if (kb.a(url))
        {
            throw new h("App ID was not specified at the request or Settings.");
        }
        outputstream.a("batch_app_id", url);
        url = new HashMap();
        a(((f) (outputstream)), ((Collection) (o1)), ((Map) (url)));
        if (jv1 != null)
        {
            jv1.c("  Attachments:\n");
        }
        a(((Map) (url)), ((f) (outputstream)));
    }

    static final void a(o o1, HttpURLConnection httpurlconnection)
        throws IOException, JSONException
    {
        jv jv1;
        URL url;
        int j1;
        boolean flag1;
        jv1 = new jv(s.a, "Request");
        j1 = o1.size();
        flag1 = f(o1);
        q q1;
        boolean flag;
        if (j1 == 1)
        {
            q1 = o1.a(0).e;
        } else
        {
            q1 = q.b;
        }
        httpurlconnection.setRequestMethod(q1.name());
        a(httpurlconnection, flag1);
        url = httpurlconnection.getURL();
        jv1.c("Request:\n");
        jv1.a("Id", o1.b());
        jv1.a("URL", url);
        jv1.a("Method", httpurlconnection.getRequestMethod());
        jv1.a("User-Agent", httpurlconnection.getRequestProperty("User-Agent"));
        jv1.a("Content-Type", httpurlconnection.getRequestProperty("Content-Type"));
        httpurlconnection.setConnectTimeout(o1.a());
        httpurlconnection.setReadTimeout(o1.a());
        if (q1 == q.b)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            jv1.a();
            return;
        }
        httpurlconnection.setDoOutput(true);
        Object obj1 = new BufferedOutputStream(httpurlconnection.getOutputStream());
        Object obj;
        httpurlconnection = ((HttpURLConnection) (obj1));
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_219;
        }
        obj = obj1;
        httpurlconnection = new GZIPOutputStream(((OutputStream) (obj1)));
        obj = httpurlconnection;
        if (!e(o1))
        {
            break MISSING_BLOCK_LABEL_283;
        }
        obj = httpurlconnection;
        obj1 = new v(o1.c());
        obj = httpurlconnection;
        a(o1, null, j1, url, ((OutputStream) (obj1)), flag1);
        obj = httpurlconnection;
        int i1 = ((v) (obj1)).a();
        obj = httpurlconnection;
        httpurlconnection = new w(httpurlconnection, o1, ((v) (obj1)).b(), i1);
        a(o1, jv1, j1, url, ((OutputStream) (httpurlconnection)), flag1);
        if (httpurlconnection != null)
        {
            httpurlconnection.close();
        }
        jv1.a();
        return;
        o1;
        obj = null;
_L2:
        if (obj != null)
        {
            ((OutputStream) (obj)).close();
        }
        throw o1;
        o1;
        continue; /* Loop/switch isn't completed */
        o1;
        obj = httpurlconnection;
        if (true) goto _L2; else goto _L1
_L1:
    }

    static void a(o o1, List list)
    {
label0:
        {
            int j1 = o1.size();
            ArrayList arraylist = new ArrayList();
            for (int i1 = 0; i1 < j1; i1++)
            {
                GraphRequest graphrequest = o1.a(i1);
                if (graphrequest.l != null)
                {
                    arraylist.add(new Pair(graphrequest.l, list.get(i1)));
                }
            }

            if (arraylist.size() > 0)
            {
                list = new Runnable(arraylist, o1) {

                    final ArrayList a;
                    final o b;

                    public void run()
                    {
                        Pair pair;
                        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((b)pair.first).a((p)pair.second))
                        {
                            pair = (Pair)iterator.next();
                        }

                        for (Iterator iterator1 = b.e().iterator(); iterator1.hasNext(); ((o.a)iterator1.next()).a(b)) { }
                    }

            
            {
                a = arraylist;
                b = o1;
                super();
            }
                };
                o1 = o1.c();
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

    private static void a(String s1, Object obj, d d1, boolean flag)
        throws IOException
    {
        Object obj1 = obj.getClass();
        if (!org/json/JSONObject.isAssignableFrom(((Class) (obj1)))) goto _L2; else goto _L1
_L1:
        obj = (JSONObject)obj;
        if (!flag) goto _L4; else goto _L3
_L3:
        String s2;
        for (obj1 = ((JSONObject) (obj)).keys(); ((Iterator) (obj1)).hasNext(); a(String.format("%s[%s]", new Object[] {
    s1, s2
}), ((JSONObject) (obj)).opt(s2), d1, flag))
        {
            s2 = (String)((Iterator) (obj1)).next();
        }

          goto _L5
_L4:
        if (!((JSONObject) (obj)).has("id")) goto _L7; else goto _L6
_L6:
        a(s1, ((JSONObject) (obj)).optString("id"), d1, flag);
_L5:
        return;
_L7:
        if (((JSONObject) (obj)).has("url"))
        {
            a(s1, ((JSONObject) (obj)).optString("url"), d1, flag);
            return;
        }
        if (((JSONObject) (obj)).has("fbsdk:create_object"))
        {
            if (!(obj instanceof JSONObject))
            {
                obj = ((JSONObject) (obj)).toString();
            } else
            {
                obj = JSONObjectInstrumentation.toString((JSONObject)obj);
            }
            a(s1, obj, d1, flag);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (!org/json/JSONArray.isAssignableFrom(((Class) (obj1))))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (JSONArray)obj;
        int j1 = ((JSONArray) (obj)).length();
        int i1 = 0;
        while (i1 < j1) 
        {
            a(String.format(Locale.ROOT, "%s[%d]", new Object[] {
                s1, Integer.valueOf(i1)
            }), ((JSONArray) (obj)).opt(i1), d1, flag);
            i1++;
        }
        if (true) goto _L5; else goto _L8
_L8:
        if (java/lang/String.isAssignableFrom(((Class) (obj1))) || java/lang/Number.isAssignableFrom(((Class) (obj1))) || java/lang/Boolean.isAssignableFrom(((Class) (obj1))))
        {
            d1.a(s1, obj.toString());
            return;
        }
        if (java/util/Date.isAssignableFrom(((Class) (obj1))))
        {
            obj = (Date)obj;
            d1.a(s1, (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US)).format(((Date) (obj))));
            return;
        }
        if (true) goto _L5; else goto _L9
_L9:
    }

    private static void a(HttpURLConnection httpurlconnection, boolean flag)
    {
        if (flag)
        {
            httpurlconnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpurlconnection.setRequestProperty("Content-Encoding", "gzip");
            return;
        } else
        {
            httpurlconnection.setRequestProperty("Content-Type", o());
            return;
        }
    }

    private static void a(Map map, f f1)
        throws IOException
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
            if (d(a1.b()))
            {
                f1.a(s1, a1.b(), a1.a());
            }
        } while (true);
    }

    private void a(JSONArray jsonarray, Map map)
        throws JSONException, IOException
    {
        JSONObject jsonobject = new JSONObject();
        if (h != null)
        {
            jsonobject.put("name", h);
            jsonobject.put("omit_response_on_success", j);
        }
        if (i != null)
        {
            jsonobject.put("depends_on", i);
        }
        String s1 = k();
        jsonobject.put("relative_url", s1);
        jsonobject.put("method", e);
        if (d != null)
        {
            jv.a(d.b());
        }
        ArrayList arraylist = new ArrayList();
        Iterator iterator = k.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (String)iterator.next();
            obj = k.get(((String) (obj)));
            if (d(obj))
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
        if (g != null)
        {
            map = new ArrayList();
            a(g, s1, new d(map) {

                final ArrayList a;
                final GraphRequest b;

                public void a(String s3, String s4)
                    throws IOException
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

    private static void a(JSONObject jsonobject, String s1, d d1)
        throws IOException
    {
        int i1;
        if (b(s1))
        {
            i1 = s1.indexOf(":");
            int j1 = s1.indexOf("?");
            String s2;
            Object obj;
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
            s2 = (String)s1.next();
            obj = jsonobject.opt(s2);
            boolean flag;
            if (i1 && s2.equalsIgnoreCase("image"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            a(s2, obj, d1, flag);
        }
    }

    public static n b(Collection collection)
    {
        return c(new o(collection));
    }

    public static transient n b(GraphRequest agraphrequest[])
    {
        kc.a(agraphrequest, "requests");
        return b(((Collection) (Arrays.asList(agraphrequest))));
    }

    public static List b(o o1)
    {
        kc.c(o1, "requests");
        HttpURLConnection httpurlconnection;
        try
        {
            httpurlconnection = a(o1);
        }
        catch (Exception exception)
        {
            List list = com.facebook.p.a(o1.d(), null, new h(exception));
            a(o1, list);
            return list;
        }
        return a(httpurlconnection, o1);
    }

    static final boolean b(GraphRequest graphrequest)
    {
        String s1 = graphrequest.d();
        if (kb.a(s1))
        {
            return true;
        }
        graphrequest = s1;
        if (s1.startsWith("v"))
        {
            graphrequest = s1.substring(1);
        }
        graphrequest = graphrequest.split("\\.");
        boolean flag;
        if (graphrequest.length >= 2 && Integer.parseInt(graphrequest[0]) > 2 || Integer.parseInt(graphrequest[0]) >= 2 && Integer.parseInt(graphrequest[1]) >= 4)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag;
    }

    static boolean b(Object obj)
    {
        return e(obj);
    }

    private static boolean b(String s1)
    {
        Matcher matcher = c.matcher(s1);
        if (matcher.matches())
        {
            s1 = matcher.group(1);
        }
        return s1.startsWith("me/") || s1.startsWith("/me/");
    }

    public static n c(o o1)
    {
        kc.c(o1, "requests");
        o1 = new n(o1);
        o1.a();
        return o1;
    }

    static String c(Object obj)
    {
        return f(obj);
    }

    static final void d(o o1)
    {
        o1 = o1.iterator();
        do
        {
            if (!o1.hasNext())
            {
                break;
            }
            GraphRequest graphrequest = (GraphRequest)o1.next();
            if (q.a.equals(graphrequest.c()) && b(graphrequest))
            {
                Bundle bundle = graphrequest.e();
                if (!bundle.containsKey("fields") || kb.a(bundle.getString("fields")))
                {
                    jv.a(s.f, 5, "Request", "starting with Graph API v2.4, GET requests for /%s should contain an explicit \"fields\" parameter.", new Object[] {
                        graphrequest.b()
                    });
                }
            }
        } while (true);
    }

    private static boolean d(Object obj)
    {
        return (obj instanceof Bitmap) || (obj instanceof byte[]) || (obj instanceof Uri) || (obj instanceof ParcelFileDescriptor) || (obj instanceof ParcelableResourceWithMimeType);
    }

    private static boolean e(o o1)
    {
        for (Iterator iterator = o1.e().iterator(); iterator.hasNext();)
        {
            if ((o.a)iterator.next() instanceof o.b)
            {
                return true;
            }
        }

        for (o1 = o1.iterator(); o1.hasNext();)
        {
            if (((GraphRequest)o1.next()).g() instanceof e)
            {
                return true;
            }
        }

        return false;
    }

    private static boolean e(Object obj)
    {
        return (obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Number) || (obj instanceof Date);
    }

    private static String f(Object obj)
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

    private static boolean f(o o1)
    {
        o1 = o1.iterator();
label0:
        do
        {
            if (o1.hasNext())
            {
                GraphRequest graphrequest = (GraphRequest)o1.next();
                Iterator iterator = graphrequest.k.keySet().iterator();
                String s1;
                do
                {
                    if (!iterator.hasNext())
                    {
                        continue label0;
                    }
                    s1 = (String)iterator.next();
                } while (!d(graphrequest.k.get(s1)));
                break;
            } else
            {
                return true;
            }
        } while (true);
        return false;
    }

    private static String g(o o1)
    {
        if (!kb.a(o1.f()))
        {
            return o1.f();
        }
        for (o1 = o1.iterator(); o1.hasNext();)
        {
            Object obj = ((GraphRequest)o1.next()).d;
            if (obj != null)
            {
                obj = ((AccessToken) (obj)).h();
                if (obj != null)
                {
                    return ((String) (obj));
                }
            }
        }

        if (!kb.a(b))
        {
            return b;
        } else
        {
            return com.facebook.k.i();
        }
    }

    private void m()
    {
        if (d == null) goto _L2; else goto _L1
_L1:
        if (!k.containsKey("access_token"))
        {
            String s1 = d.b();
            jv.a(s1);
            k.putString("access_token", s1);
        }
_L8:
        k.putString("sdk", "android");
        k.putString("format", "json");
        if (!com.facebook.k.a(s.h)) goto _L4; else goto _L3
_L3:
        k.putString("debug", "info");
_L6:
        return;
_L2:
        if (!p && !k.containsKey("access_token"))
        {
            String s2 = com.facebook.k.i();
            String s3 = com.facebook.k.k();
            if (!kb.a(s2) && !kb.a(s3))
            {
                s2 = (new StringBuilder()).append(s2).append("|").append(s3).toString();
                k.putString("access_token", s2);
            } else
            {
                Log.d(a, "Warning: Request without access token missing application ID or client token.");
            }
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (!com.facebook.k.a(s.g)) goto _L6; else goto _L5
_L5:
        k.putString("debug", "warning");
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private String n()
    {
        if (c.matcher(f).matches())
        {
            return f;
        } else
        {
            return String.format("%s/%s", new Object[] {
                o, f
            });
        }
    }

    private static String o()
    {
        return String.format("multipart/form-data; boundary=%s", new Object[] {
            "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f"
        });
    }

    private static String p()
    {
        if (q == null)
        {
            q = String.format("%s.%s", new Object[] {
                "FBAndroidSDK", "4.5.0"
            });
            String s1 = ju.a();
            if (!kb.a(s1))
            {
                q = String.format(Locale.ROOT, "%s/%s", new Object[] {
                    q, s1
                });
            }
        }
        return q;
    }

    public final JSONObject a()
    {
        return g;
    }

    public final void a(Bundle bundle)
    {
        k = bundle;
    }

    public final void a(b b1)
    {
        if (com.facebook.k.a(s.h) || com.facebook.k.a(s.g))
        {
            l = new b(b1) {

                final b a;
                final GraphRequest b;

                public void a(p p1)
                {
                    Object obj = p1.b();
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
                            s s2;
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
                            if (!kb.a(((String) (obj1))))
                            {
                                s1 = (new StringBuilder()).append(((String) (obj))).append(" Link: ").append(((String) (obj1))).toString();
                            }
                            jv.a(s2, GraphRequest.a, s1);
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
            l = b1;
            return;
        }
    }

    public final void a(q q1)
    {
        if (m != null && q1 != q.a)
        {
            throw new h("Can't change HTTP method on request with overridden URL.");
        }
        if (q1 == null)
        {
            q1 = q.a;
        }
        e = q1;
    }

    public final void a(Object obj)
    {
        n = obj;
    }

    public final void a(JSONObject jsonobject)
    {
        g = jsonobject;
    }

    public final void a(boolean flag)
    {
        p = flag;
    }

    public final String b()
    {
        return f;
    }

    public final q c()
    {
        return e;
    }

    public final String d()
    {
        return o;
    }

    public final Bundle e()
    {
        return k;
    }

    public final AccessToken f()
    {
        return d;
    }

    public final b g()
    {
        return l;
    }

    public final Object h()
    {
        return n;
    }

    public final p i()
    {
        return a(this);
    }

    public final n j()
    {
        return b(new GraphRequest[] {
            this
        });
    }

    final String k()
    {
        if (m != null)
        {
            throw new h("Can't override URL for a batch request");
        } else
        {
            String s1 = n();
            m();
            return a(s1);
        }
    }

    final String l()
    {
        if (m != null)
        {
            return m.toString();
        }
        String s1;
        if (c() == q.b && f != null && f.endsWith("/videos"))
        {
            s1 = ka.c();
        } else
        {
            s1 = ka.b();
        }
        s1 = String.format("%s/%s", new Object[] {
            s1, n()
        });
        m();
        return a(s1);
    }

    public String toString()
    {
        StringBuilder stringbuilder = (new StringBuilder()).append("{Request: ").append(" accessToken: ");
        Object obj;
        if (d == null)
        {
            obj = "null";
        } else
        {
            obj = d;
        }
        return stringbuilder.append(obj).append(", graphPath: ").append(f).append(", graphObject: ").append(g).append(", httpMethod: ").append(e).append(", parameters: ").append(k).append("}").toString();
    }

}
