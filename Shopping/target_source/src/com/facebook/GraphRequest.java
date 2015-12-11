// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.facebook.internal.h;
import com.facebook.internal.j;
import com.facebook.internal.n;
import com.facebook.internal.o;
import com.facebook.internal.p;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
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
//            o, f, n, m, 
//            b, q, t, u, 
//            AccessToken, l, i, w

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
            b = parcel.readParcelable(com.facebook.i.f().getClassLoader());
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

        public abstract void a(com.facebook.n n1);
    }

    public static interface c
    {

        public abstract void a(JSONObject jsonobject, com.facebook.n n1);
    }

    private static interface d
    {

        public abstract void a(String s, String s1)
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
        private final j b;
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

        public void a(String s, Bitmap bitmap)
            throws IOException
        {
            a(s, s, "image/png");
            bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, a);
            b("", new Object[0]);
            a();
            if (b != null)
            {
                b.a((new StringBuilder()).append("    ").append(s).toString(), "<Image>");
            }
        }

        public void a(String s, Uri uri, String s1)
            throws IOException
        {
            String s2 = s1;
            if (s1 == null)
            {
                s2 = "content/unknown";
            }
            a(s, s, s2);
            s1 = com.facebook.i.f().getContentResolver().openInputStream(uri);
            int i1;
            if (a instanceof t)
            {
                long l1 = com.facebook.internal.o.a(uri);
                ((t)a).a(l1);
                i1 = 0;
            } else
            {
                i1 = com.facebook.internal.o.a(s1, a) + 0;
            }
            b("", new Object[0]);
            a();
            if (b != null)
            {
                b.a((new StringBuilder()).append("    ").append(s).toString(), String.format(Locale.ROOT, "<Data: %d>", new Object[] {
                    Integer.valueOf(i1)
                }));
            }
        }

        public void a(String s, ParcelFileDescriptor parcelfiledescriptor, String s1)
            throws IOException
        {
            String s2 = s1;
            if (s1 == null)
            {
                s2 = "content/unknown";
            }
            a(s, s, s2);
            int i1;
            if (a instanceof t)
            {
                ((t)a).a(parcelfiledescriptor.getStatSize());
                i1 = 0;
            } else
            {
                i1 = com.facebook.internal.o.a(new android.os.ParcelFileDescriptor.AutoCloseInputStream(parcelfiledescriptor), a) + 0;
            }
            b("", new Object[0]);
            a();
            if (b != null)
            {
                b.a((new StringBuilder()).append("    ").append(s).toString(), String.format(Locale.ROOT, "<Data: %d>", new Object[] {
                    Integer.valueOf(i1)
                }));
            }
        }

        public void a(String s, Object obj, GraphRequest graphrequest)
            throws IOException
        {
            if (a instanceof w)
            {
                ((w)a).a(graphrequest);
            }
            if (GraphRequest.b(obj))
            {
                a(s, GraphRequest.c(obj));
                return;
            }
            if (obj instanceof Bitmap)
            {
                a(s, (Bitmap)obj);
                return;
            }
            if (obj instanceof byte[])
            {
                a(s, (byte[])(byte[])obj);
                return;
            }
            if (obj instanceof Uri)
            {
                a(s, (Uri)obj, ((String) (null)));
                return;
            }
            if (obj instanceof ParcelFileDescriptor)
            {
                a(s, (ParcelFileDescriptor)obj, ((String) (null)));
                return;
            }
            if (obj instanceof ParcelableResourceWithMimeType)
            {
                graphrequest = (ParcelableResourceWithMimeType)obj;
                obj = graphrequest.b();
                graphrequest = graphrequest.a();
                if (obj instanceof ParcelFileDescriptor)
                {
                    a(s, (ParcelFileDescriptor)obj, ((String) (graphrequest)));
                    return;
                }
                if (obj instanceof Uri)
                {
                    a(s, (Uri)obj, ((String) (graphrequest)));
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

        public void a(String s, String s1)
            throws IOException
        {
            a(s, ((String) (null)), ((String) (null)));
            b("%s", new Object[] {
                s1
            });
            a();
            if (b != null)
            {
                b.a((new StringBuilder()).append("    ").append(s).toString(), s1);
            }
        }

        public void a(String s, String s1, String s2)
            throws IOException
        {
            if (!d)
            {
                a("Content-Disposition: form-data; name=\"%s\"", new Object[] {
                    s
                });
                if (s1 != null)
                {
                    a("; filename=\"%s\"", new Object[] {
                        s1
                    });
                }
                b("", new Object[0]);
                if (s2 != null)
                {
                    b("%s: %s", new Object[] {
                        "Content-Type", s2
                    });
                }
                b("", new Object[0]);
                return;
            } else
            {
                a.write(String.format("%s=", new Object[] {
                    s
                }).getBytes());
                return;
            }
        }

        public void a(String s, JSONArray jsonarray, Collection collection)
            throws IOException, JSONException
        {
            if (!(a instanceof w))
            {
                if (!(jsonarray instanceof JSONArray))
                {
                    jsonarray = jsonarray.toString();
                } else
                {
                    jsonarray = JSONArrayInstrumentation.toString((JSONArray)jsonarray);
                }
                a(s, ((String) (jsonarray)));
            } else
            {
                w w1 = (w)a;
                a(s, ((String) (null)), ((String) (null)));
                a("[", new Object[0]);
                Iterator iterator = collection.iterator();
                int i1 = 0;
                while (iterator.hasNext()) 
                {
                    collection = (GraphRequest)iterator.next();
                    JSONObject jsonobject = jsonarray.getJSONObject(i1);
                    w1.a(collection);
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
                    String s1 = (new StringBuilder()).append("    ").append(s).toString();
                    if (!(jsonarray instanceof JSONArray))
                    {
                        s = jsonarray.toString();
                    } else
                    {
                        s = JSONArrayInstrumentation.toString((JSONArray)jsonarray);
                    }
                    collection.a(s1, s);
                    return;
                }
            }
        }

        public void a(String s, byte abyte0[])
            throws IOException
        {
            a(s, s, "content/unknown");
            a.write(abyte0);
            b("", new Object[0]);
            a();
            if (b != null)
            {
                b.a((new StringBuilder()).append("    ").append(s).toString(), String.format(Locale.ROOT, "<Data: %d>", new Object[] {
                    Integer.valueOf(abyte0.length)
                }));
            }
        }

        public transient void a(String s, Object aobj[])
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
                a.write(String.format(s, aobj).getBytes());
                return;
            } else
            {
                a.write(URLEncoder.encode(String.format(Locale.US, s, aobj), "UTF-8").getBytes());
                return;
            }
        }

        public transient void b(String s, Object aobj[])
            throws IOException
        {
            a(s, aobj);
            if (!d)
            {
                a("\r\n", new Object[0]);
            }
        }

        public f(OutputStream outputstream, j j1, boolean flag)
        {
            c = true;
            d = false;
            a = outputstream;
            b = j1;
            d = flag;
        }
    }


    public static final String a = com/facebook/GraphRequest.getSimpleName();
    private static String b;
    private static Pattern c = Pattern.compile("^/?v\\d+\\.\\d+/(.*)");
    private static volatile String q;
    private AccessToken d;
    private com.facebook.o e;
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

    public GraphRequest(AccessToken accesstoken, String s, Bundle bundle, com.facebook.o o1, b b1)
    {
        this(accesstoken, s, bundle, o1, b1, null);
    }

    public GraphRequest(AccessToken accesstoken, String s, Bundle bundle, com.facebook.o o1, b b1, String s1)
    {
        j = true;
        p = false;
        d = accesstoken;
        f = s;
        o = s1;
        a(b1);
        a(o1);
        if (bundle != null)
        {
            k = new Bundle(bundle);
        } else
        {
            k = new Bundle();
        }
        if (o == null)
        {
            o = com.facebook.internal.n.d();
        }
    }

    public static GraphRequest a(AccessToken accesstoken, String s, b b1)
    {
        return new GraphRequest(accesstoken, s, null, null, b1);
    }

    public static GraphRequest a(AccessToken accesstoken, String s, JSONObject jsonobject, b b1)
    {
        accesstoken = new GraphRequest(accesstoken, s, null, o.b, b1);
        accesstoken.a(jsonobject);
        return accesstoken;
    }

    public static com.facebook.n a(GraphRequest graphrequest)
    {
        graphrequest = a(new GraphRequest[] {
            graphrequest
        });
        if (graphrequest == null || graphrequest.size() != 1)
        {
            throw new com.facebook.f("invalid state: expected a single response");
        } else
        {
            return (com.facebook.n)graphrequest.get(0);
        }
    }

    private String a(String s)
    {
        android.net.Uri.Builder builder;
label0:
        {
            builder = (new android.net.Uri.Builder()).encodedPath(s);
label1:
            do
            {
                String s1;
                for (Iterator iterator = k.keySet().iterator(); iterator.hasNext(); builder.appendQueryParameter(s1, f(s).toString()))
                {
                    s1 = (String)iterator.next();
                    Object obj = k.get(s1);
                    s = ((String) (obj));
                    if (obj == null)
                    {
                        s = "";
                    }
                    if (!e(s))
                    {
                        continue label1;
                    }
                }

                break label0;
            } while (e != o.a);
            throw new IllegalArgumentException(String.format(Locale.US, "Unsupported parameter type for GET request: %s", new Object[] {
                s.getClass().getSimpleName()
            }));
        }
        return builder.toString();
    }

    public static HttpURLConnection a(m m1)
    {
        d(m1);
        Object obj;
        if (m1.size() != 1)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        obj = new URL(m1.a(0).l());
_L1:
        try
        {
            obj = a(((URL) (obj)));
            a(m1, ((HttpURLConnection) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (m m1)
        {
            throw new com.facebook.f("could not construct request body", m1);
        }
        // Misplaced declaration of an exception variable
        catch (m m1)
        {
            throw new com.facebook.f("could not construct request body", m1);
        }
        return ((HttpURLConnection) (obj));
        try
        {
            obj = new URL(com.facebook.internal.n.b());
        }
        // Misplaced declaration of an exception variable
        catch (m m1)
        {
            throw new com.facebook.f("could not construct URL for request", m1);
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

    public static List a(HttpURLConnection httpurlconnection, m m1)
    {
        List list = com.facebook.n.a(httpurlconnection, m1);
        com.facebook.internal.o.a(httpurlconnection);
        int i1 = m1.size();
        if (i1 != list.size())
        {
            throw new com.facebook.f(String.format(Locale.US, "Received %d responses while expecting %d", new Object[] {
                Integer.valueOf(list.size()), Integer.valueOf(i1)
            }));
        } else
        {
            a(m1, list);
            com.facebook.b.a().d();
            return list;
        }
    }

    public static List a(Collection collection)
    {
        return b(new m(collection));
    }

    public static transient List a(GraphRequest agraphrequest[])
    {
        com.facebook.internal.p.a(agraphrequest, "requests");
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
            String s = (String)iterator.next();
            Object obj = bundle.get(s);
            if (e(obj))
            {
                f1.a(s, obj, graphrequest);
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

    private static void a(m m1, j j1, int i1, URL url, OutputStream outputstream, boolean flag)
        throws IOException, JSONException
    {
        outputstream = new f(outputstream, j1, flag);
        if (i1 == 1)
        {
            m1 = m1.a(0);
            HashMap hashmap = new HashMap();
            Iterator iterator = ((GraphRequest) (m1)).k.keySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s = (String)iterator.next();
                Object obj = ((GraphRequest) (m1)).k.get(s);
                if (d(obj))
                {
                    hashmap.put(s, new a(m1, obj));
                }
            } while (true);
            if (j1 != null)
            {
                j1.c("  Parameters:\n");
            }
            a(((GraphRequest) (m1)).k, ((f) (outputstream)), ((GraphRequest) (m1)));
            if (j1 != null)
            {
                j1.c("  Attachments:\n");
            }
            a(((Map) (hashmap)), ((f) (outputstream)));
            if (((GraphRequest) (m1)).g != null)
            {
                a(((GraphRequest) (m1)).g, url.getPath(), ((d) (outputstream)));
            }
            return;
        }
        url = g(m1);
        if (com.facebook.internal.o.a(url))
        {
            throw new com.facebook.f("App ID was not specified at the request or Settings.");
        }
        outputstream.a("batch_app_id", url);
        url = new HashMap();
        a(((f) (outputstream)), ((Collection) (m1)), ((Map) (url)));
        if (j1 != null)
        {
            j1.c("  Attachments:\n");
        }
        a(((Map) (url)), ((f) (outputstream)));
    }

    static final void a(m m1, HttpURLConnection httpurlconnection)
        throws IOException, JSONException
    {
        j j1;
        URL url;
        int k1;
        boolean flag1;
        j1 = new j(q.a, "Request");
        k1 = m1.size();
        flag1 = f(m1);
        com.facebook.o o1;
        boolean flag;
        if (k1 == 1)
        {
            o1 = m1.a(0).e;
        } else
        {
            o1 = o.b;
        }
        httpurlconnection.setRequestMethod(o1.name());
        a(httpurlconnection, flag1);
        url = httpurlconnection.getURL();
        j1.c("Request:\n");
        j1.a("Id", m1.b());
        j1.a("URL", url);
        j1.a("Method", httpurlconnection.getRequestMethod());
        j1.a("User-Agent", httpurlconnection.getRequestProperty("User-Agent"));
        j1.a("Content-Type", httpurlconnection.getRequestProperty("Content-Type"));
        httpurlconnection.setConnectTimeout(m1.a());
        httpurlconnection.setReadTimeout(m1.a());
        if (o1 == o.b)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            j1.a();
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
        if (!e(m1))
        {
            break MISSING_BLOCK_LABEL_283;
        }
        obj = httpurlconnection;
        obj1 = new t(m1.c());
        obj = httpurlconnection;
        a(m1, null, k1, url, ((OutputStream) (obj1)), flag1);
        obj = httpurlconnection;
        int i1 = ((t) (obj1)).a();
        obj = httpurlconnection;
        httpurlconnection = new u(httpurlconnection, m1, ((t) (obj1)).b(), i1);
        a(m1, j1, k1, url, ((OutputStream) (httpurlconnection)), flag1);
        if (httpurlconnection != null)
        {
            httpurlconnection.close();
        }
        j1.a();
        return;
        m1;
        obj = null;
_L2:
        if (obj != null)
        {
            ((OutputStream) (obj)).close();
        }
        throw m1;
        m1;
        continue; /* Loop/switch isn't completed */
        m1;
        obj = httpurlconnection;
        if (true) goto _L2; else goto _L1
_L1:
    }

    static void a(m m1, List list)
    {
label0:
        {
            int j1 = m1.size();
            ArrayList arraylist = new ArrayList();
            for (int i1 = 0; i1 < j1; i1++)
            {
                GraphRequest graphrequest = m1.a(i1);
                if (graphrequest.l != null)
                {
                    arraylist.add(new Pair(graphrequest.l, list.get(i1)));
                }
            }

            if (arraylist.size() > 0)
            {
                list = new Runnable(arraylist, m1) {

                    final ArrayList a;
                    final m b;

                    public void run()
                    {
                        Pair pair;
                        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((b)pair.first).a((com.facebook.n)pair.second))
                        {
                            pair = (Pair)iterator.next();
                        }

                        for (Iterator iterator1 = b.e().iterator(); iterator1.hasNext(); ((m.a)iterator1.next()).a(b)) { }
                    }

            
            {
                a = arraylist;
                b = m1;
                super();
            }
                };
                m1 = m1.c();
                if (m1 != null)
                {
                    break label0;
                }
                list.run();
            }
            return;
        }
        m1.post(list);
    }

    private static void a(String s, Object obj, d d1, boolean flag)
        throws IOException
    {
        Object obj1 = obj.getClass();
        if (!org/json/JSONObject.isAssignableFrom(((Class) (obj1)))) goto _L2; else goto _L1
_L1:
        obj = (JSONObject)obj;
        if (!flag) goto _L4; else goto _L3
_L3:
        String s1;
        for (obj1 = ((JSONObject) (obj)).keys(); ((Iterator) (obj1)).hasNext(); a(String.format("%s[%s]", new Object[] {
    s, s1
}), ((JSONObject) (obj)).opt(s1), d1, flag))
        {
            s1 = (String)((Iterator) (obj1)).next();
        }

          goto _L5
_L4:
        if (!((JSONObject) (obj)).has("id")) goto _L7; else goto _L6
_L6:
        a(s, ((JSONObject) (obj)).optString("id"), d1, flag);
_L5:
        return;
_L7:
        if (((JSONObject) (obj)).has("url"))
        {
            a(s, ((JSONObject) (obj)).optString("url"), d1, flag);
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
            a(s, obj, d1, flag);
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
                s, Integer.valueOf(i1)
            }), ((JSONArray) (obj)).opt(i1), d1, flag);
            i1++;
        }
        if (true) goto _L5; else goto _L8
_L8:
        if (java/lang/String.isAssignableFrom(((Class) (obj1))) || java/lang/Number.isAssignableFrom(((Class) (obj1))) || java/lang/Boolean.isAssignableFrom(((Class) (obj1))))
        {
            d1.a(s, obj.toString());
            return;
        }
        if (java/util/Date.isAssignableFrom(((Class) (obj1))))
        {
            obj = (Date)obj;
            d1.a(s, (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US)).format(((Date) (obj))));
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
            String s = (String)iterator.next();
            a a1 = (a)map.get(s);
            if (d(a1.b()))
            {
                f1.a(s, a1.b(), a1.a());
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
        String s = k();
        jsonobject.put("relative_url", s);
        jsonobject.put("method", e);
        if (d != null)
        {
            com.facebook.internal.j.a(d.b());
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
                String s1 = String.format(Locale.ROOT, "%s%d", new Object[] {
                    "file", Integer.valueOf(map.size())
                });
                arraylist.add(s1);
                map.put(s1, new a(this, obj));
            }
        } while (true);
        if (!arraylist.isEmpty())
        {
            jsonobject.put("attached_files", TextUtils.join(",", arraylist));
        }
        if (g != null)
        {
            map = new ArrayList();
            a(g, s, new d(map) {

                final ArrayList a;
                final GraphRequest b;

                public void a(String s2, String s3)
                    throws IOException
                {
                    a.add(String.format(Locale.US, "%s=%s", new Object[] {
                        s2, URLEncoder.encode(s3, "UTF-8")
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

    private static void a(JSONObject jsonobject, String s, d d1)
        throws IOException
    {
        int i1;
        if (b(s))
        {
            i1 = s.indexOf(":");
            int j1 = s.indexOf("?");
            String s1;
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
        s = jsonobject.keys();
        while (s.hasNext()) 
        {
            s1 = (String)s.next();
            obj = jsonobject.opt(s1);
            boolean flag;
            if (i1 && s1.equalsIgnoreCase("image"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            a(s1, obj, d1, flag);
        }
    }

    public static l b(Collection collection)
    {
        return c(new m(collection));
    }

    public static transient l b(GraphRequest agraphrequest[])
    {
        com.facebook.internal.p.a(agraphrequest, "requests");
        return b(((Collection) (Arrays.asList(agraphrequest))));
    }

    public static List b(m m1)
    {
        com.facebook.internal.p.c(m1, "requests");
        HttpURLConnection httpurlconnection;
        try
        {
            httpurlconnection = a(m1);
        }
        catch (Exception exception)
        {
            List list = com.facebook.n.a(m1.d(), null, new com.facebook.f(exception));
            a(m1, list);
            return list;
        }
        return a(httpurlconnection, m1);
    }

    static final boolean b(GraphRequest graphrequest)
    {
        String s = graphrequest.d();
        if (com.facebook.internal.o.a(s))
        {
            return true;
        }
        graphrequest = s;
        if (s.startsWith("v"))
        {
            graphrequest = s.substring(1);
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

    private static boolean b(String s)
    {
        Matcher matcher = c.matcher(s);
        if (matcher.matches())
        {
            s = matcher.group(1);
        }
        return s.startsWith("me/") || s.startsWith("/me/");
    }

    public static l c(m m1)
    {
        com.facebook.internal.p.c(m1, "requests");
        m1 = new l(m1);
        java.util.concurrent.Executor executor = com.facebook.i.d();
        if (!(m1 instanceof AsyncTask))
        {
            m1.executeOnExecutor(executor, null);
            return m1;
        } else
        {
            AsyncTaskInstrumentation.executeOnExecutor((AsyncTask)m1, executor, null);
            return m1;
        }
    }

    static String c(Object obj)
    {
        return f(obj);
    }

    static final void d(m m1)
    {
        m1 = m1.iterator();
        do
        {
            if (!m1.hasNext())
            {
                break;
            }
            GraphRequest graphrequest = (GraphRequest)m1.next();
            if (o.a.equals(graphrequest.c()) && b(graphrequest))
            {
                Bundle bundle = graphrequest.e();
                if (!bundle.containsKey("fields") || com.facebook.internal.o.a(bundle.getString("fields")))
                {
                    com.facebook.internal.j.a(q.f, 5, "Request", "starting with Graph API v2.4, GET requests for /%s should contain an explicit \"fields\" parameter.", new Object[] {
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

    private static boolean e(m m1)
    {
        for (Iterator iterator = m1.e().iterator(); iterator.hasNext();)
        {
            if ((m.a)iterator.next() instanceof m.b)
            {
                return true;
            }
        }

        for (m1 = m1.iterator(); m1.hasNext();)
        {
            if (((GraphRequest)m1.next()).g() instanceof e)
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

    private static boolean f(m m1)
    {
        m1 = m1.iterator();
label0:
        do
        {
            if (m1.hasNext())
            {
                GraphRequest graphrequest = (GraphRequest)m1.next();
                Iterator iterator = graphrequest.k.keySet().iterator();
                String s;
                do
                {
                    if (!iterator.hasNext())
                    {
                        continue label0;
                    }
                    s = (String)iterator.next();
                } while (!d(graphrequest.k.get(s)));
                break;
            } else
            {
                return true;
            }
        } while (true);
        return false;
    }

    private static String g(m m1)
    {
        if (!com.facebook.internal.o.a(m1.f()))
        {
            return m1.f();
        }
        for (m1 = m1.iterator(); m1.hasNext();)
        {
            Object obj = ((GraphRequest)m1.next()).d;
            if (obj != null)
            {
                obj = ((AccessToken) (obj)).h();
                if (obj != null)
                {
                    return ((String) (obj));
                }
            }
        }

        if (!com.facebook.internal.o.a(b))
        {
            return b;
        } else
        {
            return com.facebook.i.i();
        }
    }

    private void m()
    {
        if (d == null) goto _L2; else goto _L1
_L1:
        if (!k.containsKey("access_token"))
        {
            String s = d.b();
            com.facebook.internal.j.a(s);
            k.putString("access_token", s);
        }
_L8:
        k.putString("sdk", "android");
        k.putString("format", "json");
        if (!com.facebook.i.a(com.facebook.q.h)) goto _L4; else goto _L3
_L3:
        k.putString("debug", "info");
_L6:
        return;
_L2:
        if (!p && !k.containsKey("access_token"))
        {
            String s1 = com.facebook.i.i();
            String s2 = com.facebook.i.j();
            if (!com.facebook.internal.o.a(s1) && !com.facebook.internal.o.a(s2))
            {
                s1 = (new StringBuilder()).append(s1).append("|").append(s2).toString();
                k.putString("access_token", s1);
            } else
            {
                Log.d(a, "Warning: Request without access token missing application ID or client token.");
            }
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (!com.facebook.i.a(q.g)) goto _L6; else goto _L5
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
                "FBAndroidSDK", "4.7.0"
            });
            String s = com.facebook.internal.h.a();
            if (!com.facebook.internal.o.a(s))
            {
                q = String.format(Locale.ROOT, "%s/%s", new Object[] {
                    q, s
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
        if (com.facebook.i.a(com.facebook.q.h) || com.facebook.i.a(q.g))
        {
            l = new b(b1) {

                final b a;
                final GraphRequest b;

                public void a(com.facebook.n n1)
                {
                    Object obj = n1.b();
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
                            String s;
                            q q1;
                            if (obj1 != null)
                            {
                                obj = ((JSONObject) (obj1)).optString("message");
                            } else
                            {
                                obj = null;
                            }
                            if (obj1 != null)
                            {
                                s = ((JSONObject) (obj1)).optString("type");
                            } else
                            {
                                s = null;
                            }
                            if (obj1 != null)
                            {
                                obj1 = ((JSONObject) (obj1)).optString("link");
                            } else
                            {
                                obj1 = null;
                            }
                            if (obj == null || s == null)
                            {
                                continue;
                            }
                            q1 = com.facebook.q.h;
                            if (s.equals("warning"))
                            {
                                q1 = q.g;
                            }
                            s = ((String) (obj));
                            if (!com.facebook.internal.o.a(((String) (obj1))))
                            {
                                s = (new StringBuilder()).append(((String) (obj))).append(" Link: ").append(((String) (obj1))).toString();
                            }
                            com.facebook.internal.j.a(q1, GraphRequest.a, s);
                            i1++;
                        }
                    }
                    if (a != null)
                    {
                        a.a(n1);
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

    public final void a(com.facebook.o o1)
    {
        if (m != null && o1 != o.a)
        {
            throw new com.facebook.f("Can't change HTTP method on request with overridden URL.");
        }
        if (o1 == null)
        {
            o1 = o.a;
        }
        e = o1;
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

    public final com.facebook.o c()
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

    public final com.facebook.n i()
    {
        return a(this);
    }

    public final l j()
    {
        return b(new GraphRequest[] {
            this
        });
    }

    final String k()
    {
        if (m != null)
        {
            throw new com.facebook.f("Can't override URL for a batch request");
        } else
        {
            String s = n();
            m();
            return a(s);
        }
    }

    final String l()
    {
        if (m != null)
        {
            return m.toString();
        }
        String s;
        if (c() == o.b && f != null && f.endsWith("/videos"))
        {
            s = com.facebook.internal.n.c();
        } else
        {
            s = com.facebook.internal.n.b();
        }
        s = String.format("%s/%s", new Object[] {
            s, n()
        });
        m();
        return a(s);
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


    // Unreferenced inner class com/facebook/GraphRequest$1

/* anonymous class */
    static final class _cls1
        implements b
    {

        final c a;

        public void a(com.facebook.n n1)
        {
            if (a != null)
            {
                a.a(n1.b(), n1);
            }
        }
    }

}
