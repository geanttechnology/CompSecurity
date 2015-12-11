// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.google.android.gms.internal.fh;
import com.google.android.gms.internal.fj;
import com.google.android.gms.internal.gu;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aar
    implements Callable
{

    private final Context a;
    private final abw b;
    private final ahi c;
    private final st d;
    private final Object e = new Object();
    private final abe f;
    private boolean g;
    private int h;
    private List i;

    public aar(Context context, ahi ahi, st st1, abw abw1, abe abe1)
    {
        a = context;
        c = ahi;
        b = abw1;
        d = st1;
        f = abe1;
        g = false;
        h = -2;
        i = null;
    }

    private abd a(ut ut1)
    {
        Object obj = e;
        obj;
        JVM INSTR monitorenter ;
        int k = h;
        int j;
        j = k;
        if (ut1 != null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        j = k;
        if (h == -2)
        {
            j = 0;
        }
        obj;
        JVM INSTR monitorexit ;
        if (j != -2)
        {
            ut1 = null;
        }
        return new abd(f.a.c, null, f.b.d, j, f.b.f, i, f.b.l, f.b.k, f.a.i, false, null, null, null, null, null, 0L, f.d, f.b.g, f.f, f.g, f.b.o, f.h, ut1);
        ut1;
        obj;
        JVM INSTR monitorexit ;
        throw ut1;
    }

    private JSONObject a(sr sr1)
    {
        if (b())
        {
            return null;
        } else
        {
            abs abs1 = new abs();
            sr1.a("/nativeAdPreProcess", new vd(sr1, abs1) {

                final sr a;
                final abs b;
                final aar c;

                public void a(gu gu, Map map)
                {
                    a.b("/nativeAdPreProcess");
                    try
                    {
                        gu = (String)map.get("success");
                        if (!TextUtils.isEmpty(gu))
                        {
                            b.a((new JSONObject(gu)).getJSONArray("ads").getJSONObject(0));
                            return;
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (gu gu)
                    {
                        acb.b("Malformed native JSON response.", gu);
                    }
                    c.a(0);
                    ady.a(c.b(), "Unable to set the ad state error!");
                    b.a(null);
                }

            
            {
                c = aar.this;
                a = sr1;
                b = abs1;
                super();
            }
            });
            sr1.a("google.afma.nativeAds.preProcessJsonGmsg", new JSONObject(f.b.c));
            return (JSONObject)abs1.get();
        }
    }

    private ut a(sr sr1, aas aas1, JSONObject jsonobject)
    {
        if (b())
        {
            return null;
        }
        List list = a(jsonobject.getJSONObject("tracking_urls_and_actions"), "impression_tracking_urls");
        if (list == null)
        {
            list = null;
        } else
        {
            list = Arrays.asList(list);
        }
        i = list;
        aas1 = aas1.a(this, jsonobject);
        if (aas1 == null)
        {
            acb.b("Failed to retrieve ad assets.");
            return null;
        } else
        {
            aas1.a(new us(c, sr1, jsonobject));
            return aas1;
        }
    }

    private String[] a(JSONObject jsonobject, String s)
    {
        jsonobject = jsonobject.optJSONArray(s);
        if (jsonobject == null)
        {
            return null;
        }
        s = new String[jsonobject.length()];
        for (int j = 0; j < jsonobject.length(); j++)
        {
            s[j] = jsonobject.getString(j);
        }

        return s;
    }

    private sr c()
    {
        if (b())
        {
            return null;
        } else
        {
            sr sr1 = (sr)d.a(a, f.a.k, "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/native_ads.html").get();
            sr1.a(c, c, c, c, false, c);
            return sr1;
        }
    }

    protected aas a(JSONObject jsonobject)
    {
        if (b())
        {
            return null;
        }
        jsonobject = jsonobject.getString("template_id");
        if ("2".equals(jsonobject))
        {
            return new aat();
        }
        if ("1".equals(jsonobject))
        {
            return new aau();
        } else
        {
            a(0);
            return null;
        }
    }

    public abd a()
    {
        Object obj;
        obj = c();
        JSONObject jsonobject = a(((sr) (obj)));
        obj = a(a(((sr) (obj)), a(jsonobject), jsonobject));
        return ((abd) (obj));
        Object obj1;
        obj1;
        acb.d("Malformed native JSON response.", ((Throwable) (obj1)));
_L2:
        if (!g)
        {
            a(0);
        }
        return a(((ut) (null)));
        obj1;
        acb.d("Timeout when loading native ad.", ((Throwable) (obj1)));
        continue; /* Loop/switch isn't completed */
        obj1;
        continue; /* Loop/switch isn't completed */
        obj1;
        continue; /* Loop/switch isn't completed */
        obj1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public Future a(JSONObject jsonobject, String s, boolean flag)
    {
        if (flag)
        {
            jsonobject = jsonobject.getJSONObject(s);
        } else
        {
            jsonobject = jsonobject.optJSONObject(s);
        }
        s = jsonobject;
        if (jsonobject == null)
        {
            s = new JSONObject();
        }
        if (flag)
        {
            jsonobject = s.getString("url");
        } else
        {
            jsonobject = s.optString("url");
        }
        if (TextUtils.isEmpty(jsonobject))
        {
            a(0, flag);
            return new abt(null);
        } else
        {
            return b.a(jsonobject, new abx(flag) {

                final boolean a;
                final aar b;

                public Drawable a()
                {
                    b.a(2, a);
                    return null;
                }

                public Drawable a(InputStream inputstream)
                {
                    try
                    {
                        inputstream = aeh.a(inputstream);
                    }
                    // Misplaced declaration of an exception variable
                    catch (InputStream inputstream)
                    {
                        inputstream = null;
                    }
                    if (inputstream == null)
                    {
                        b.a(2, a);
                        return null;
                    }
                    inputstream = BitmapFactory.decodeByteArray(inputstream, 0, inputstream.length);
                    if (inputstream == null)
                    {
                        b.a(2, a);
                        return null;
                    } else
                    {
                        return new BitmapDrawable(Resources.getSystem(), inputstream);
                    }
                }

                public Object b()
                {
                    return a();
                }

                public Object b(InputStream inputstream)
                {
                    return a(inputstream);
                }

            
            {
                b = aar.this;
                a = flag;
                super();
            }
            });
        }
    }

    public void a(int j)
    {
        synchronized (e)
        {
            g = true;
            h = j;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(int j, boolean flag)
    {
        if (flag)
        {
            a(j);
        }
    }

    public boolean b()
    {
        boolean flag;
        synchronized (e)
        {
            flag = g;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Object call()
    {
        return a();
    }
}
