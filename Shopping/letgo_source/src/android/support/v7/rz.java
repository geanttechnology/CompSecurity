// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.formats.zza;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.internal.formats.zzf;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzn;
import com.google.android.gms.common.internal.x;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package android.support.v7:
//            te, ub, tt, ua, 
//            mq, oh, ol, nn, 
//            nj, mr, sa, sb, 
//            tp, sc, uc, mc, 
//            ud, ox, ul, vk, 
//            ll, vq

public class rz
    implements Callable
{
    public static interface a
    {

        public abstract com.google.android.gms.ads.internal.formats.zzh.zza a(rz rz1, JSONObject jsonobject)
            throws JSONException, InterruptedException, ExecutionException;
    }

    class b
    {

        public ox a;
        final rz b;

        b()
        {
            b = rz.this;
            super();
        }
    }


    private static final long a;
    private final Context b;
    private final tt c;
    private final zzn d;
    private final mc e;
    private final mr f;
    private final Object g = new Object();
    private final te.a h;
    private boolean i;
    private int j;
    private List k;

    public rz(Context context, zzn zzn1, mr mr1, tt tt1, mc mc, te.a a1)
    {
        b = context;
        d = zzn1;
        c = tt1;
        f = mr1;
        h = a1;
        e = mc;
        i = false;
        j = -2;
        k = null;
    }

    private te a(com.google.android.gms.ads.internal.formats.zzh.zza zza)
    {
        Object obj = g;
        obj;
        JVM INSTR monitorenter ;
        int i1 = j;
        int l;
        l = i1;
        if (zza != null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        l = i1;
        if (j == -2)
        {
            l = 0;
        }
        obj;
        JVM INSTR monitorexit ;
        if (l != -2)
        {
            zza = null;
        }
        return new te(h.a.zzDy, null, h.b.zzyw, l, h.b.zzyx, k, h.b.orientation, h.b.zzyA, h.a.zzDB, false, null, null, null, null, null, 0L, h.d, h.b.zzDW, h.f, h.g, h.b.zzEc, h.h, zza, h.a.zzDO);
        zza;
        obj;
        JVM INSTR monitorexit ;
        throw zza;
    }

    private ud a(JSONObject jsonobject, boolean flag, boolean flag1)
        throws JSONException
    {
        if (flag)
        {
            jsonobject = jsonobject.getString("url");
        } else
        {
            jsonobject = jsonobject.optString("url");
        }
        if (TextUtils.isEmpty(jsonobject))
        {
            a(0, flag);
            return new ub(null);
        }
        if (flag1)
        {
            return new ub(new zzc(null, Uri.parse(jsonobject)));
        } else
        {
            return c.a(jsonobject, new tt.a(flag, jsonobject) {

                final boolean a;
                final String b;
                final rz c;

                public zzc a()
                {
                    c.a(2, a);
                    return null;
                }

                public zzc a(InputStream inputstream)
                {
                    try
                    {
                        inputstream = vq.a(inputstream);
                    }
                    // Misplaced declaration of an exception variable
                    catch (InputStream inputstream)
                    {
                        inputstream = null;
                    }
                    if (inputstream == null)
                    {
                        c.a(2, a);
                        return null;
                    }
                    inputstream = BitmapFactory.decodeByteArray(inputstream, 0, inputstream.length);
                    if (inputstream == null)
                    {
                        c.a(2, a);
                        return null;
                    } else
                    {
                        return new zzc(new BitmapDrawable(Resources.getSystem(), inputstream), Uri.parse(b));
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
                c = rz.this;
                a = flag;
                b = s;
                super();
            }
            });
        }
    }

    private com.google.android.gms.ads.internal.formats.zzh.zza a(mq mq1, a a1, JSONObject jsonobject)
        throws ExecutionException, InterruptedException, JSONException
    {
        if (b())
        {
            return null;
        }
        List list = b(jsonobject.getJSONObject("tracking_urls_and_actions"), "impression_tracking_urls");
        if (list == null)
        {
            list = null;
        } else
        {
            list = Arrays.asList(list);
        }
        k = list;
        a1 = a1.a(this, jsonobject);
        if (a1 == null)
        {
            zzb.e("Failed to retrieve ad assets.");
            return null;
        } else
        {
            a1.zza(new zzh(b, d, mq1, e, jsonobject, a1, h.a.zzqb));
            return a1;
        }
    }

    static zzn a(rz rz1)
    {
        return rz1.d;
    }

    private Integer a(JSONObject jsonobject, String s)
    {
        int l;
        try
        {
            jsonobject = jsonobject.getJSONObject(s);
            l = Color.rgb(jsonobject.getInt("r"), jsonobject.getInt("g"), jsonobject.getInt("b"));
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return null;
        }
        return Integer.valueOf(l);
    }

    private JSONObject a(mq mq1)
        throws TimeoutException, JSONException
    {
        if (b())
        {
            return null;
        } else
        {
            ua ua1 = new ua();
            b b1 = new b();
            ox ox = new ox(mq1, b1, ua1) {

                final mq a;
                final b b;
                final ua c;
                final rz d;

                public void zza(ul ul, Map map)
                {
                    a.b("/nativeAdPreProcess", b.a);
                    try
                    {
                        ul = (String)map.get("success");
                        if (!TextUtils.isEmpty(ul))
                        {
                            c.b((new JSONObject(ul)).getJSONArray("ads").getJSONObject(0));
                            return;
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (ul ul)
                    {
                        zzb.zzb("Malformed native JSON response.", ul);
                    }
                    d.a(0);
                    x.a(d.b(), "Unable to set the ad state error!");
                    c.b(null);
                }

            
            {
                d = rz.this;
                a = mq1;
                b = b1;
                c = ua1;
                super();
            }
            };
            b1.a = ox;
            mq1.a("/nativeAdPreProcess", ox);
            mq1.a("google.afma.nativeAds.preProcessJsonGmsg", new JSONObject(h.b.body));
            return (JSONObject)ua1.get(a, TimeUnit.MILLISECONDS);
        }
    }

    private void a(oh oh1, String s)
    {
        ol ol1;
        try
        {
            ol1 = d.zzr(oh1.getCustomTemplateId());
        }
        // Misplaced declaration of an exception variable
        catch (oh oh1)
        {
            zzb.zzd((new StringBuilder()).append("Failed to call onCustomClick for asset ").append(s).append(".").toString(), oh1);
            return;
        }
        if (ol1 == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        ol1.a(oh1, s);
    }

    static void a(rz rz1, oh oh1, String s)
    {
        rz1.a(oh1, s);
    }

    private void a(com.google.android.gms.ads.internal.formats.zzh.zza zza, mq mq1)
    {
        if (!(zza instanceof zzf))
        {
            return;
        } else
        {
            Object obj = (zzf)zza;
            zza = new b();
            obj = new ox(((zzf) (obj))) {

                final zzf a;
                final rz b;

                public void zza(ul ul, Map map)
                {
                    ul = (String)map.get("asset");
                    rz.a(b, a, ul);
                }

            
            {
                b = rz.this;
                a = zzf1;
                super();
            }
            };
            zza.a = ((ox) (obj));
            mq1.a("/nativeAdCustomClick", ((ox) (obj)));
            return;
        }
    }

    private String[] b(JSONObject jsonobject, String s)
        throws JSONException
    {
        jsonobject = jsonobject.optJSONArray(s);
        if (jsonobject == null)
        {
            return null;
        }
        s = new String[jsonobject.length()];
        for (int l = 0; l < jsonobject.length(); l++)
        {
            s[l] = jsonobject.getString(l);
        }

        return s;
    }

    private mq c()
        throws CancellationException, ExecutionException, InterruptedException, TimeoutException
    {
        if (b())
        {
            return null;
        }
        String s = (String)nn.Z.c();
        Object obj;
        if (h.b.zzAT.indexOf("https") == 0)
        {
            obj = "https:";
        } else
        {
            obj = "http:";
        }
        obj = (new StringBuilder()).append(((String) (obj))).append(s).toString();
        obj = (mq)f.a(b, h.a.zzqb, ((String) (obj)), e).get(a, TimeUnit.MILLISECONDS);
        ((mq) (obj)).a(d, d, d, d, false, null, null, null, null);
        return ((mq) (obj));
    }

    protected a a(JSONObject jsonobject)
        throws JSONException, TimeoutException
    {
        if (b())
        {
            return null;
        }
        String s = jsonobject.getString("template_id");
        boolean flag;
        boolean flag1;
        if (h.a.zzqt != null)
        {
            flag = h.a.zzqt.zzwn;
        } else
        {
            flag = false;
        }
        if (h.a.zzqt != null)
        {
            flag1 = h.a.zzqt.zzwp;
        } else
        {
            flag1 = false;
        }
        if ("2".equals(s))
        {
            return new sa(flag, flag1);
        }
        if ("1".equals(s))
        {
            return new sb(flag, flag1);
        }
        if ("3".equals(s))
        {
            String s1 = jsonobject.getString("custom_template_id");
            ua ua1 = new ua();
            tp.a.post(new Runnable(ua1, s1) {

                final ua a;
                final String b;
                final rz c;

                public void run()
                {
                    a.b(rz.a(c).zzbq().get(b));
                }

            
            {
                c = rz.this;
                a = ua1;
                b = s;
                super();
            }
            });
            if (ua1.get(a, TimeUnit.MILLISECONDS) != null)
            {
                return new sc(flag);
            }
            zzb.e((new StringBuilder()).append("No handler for custom template: ").append(jsonobject.getString("custom_template_id")).toString());
        } else
        {
            a(0);
        }
        return null;
    }

    public te a()
    {
        Object obj;
        obj = c();
        Object obj2 = a(((mq) (obj)));
        obj2 = a(((mq) (obj)), a(((JSONObject) (obj2))), ((JSONObject) (obj2)));
        a(((com.google.android.gms.ads.internal.formats.zzh.zza) (obj2)), ((mq) (obj)));
        obj = a(((com.google.android.gms.ads.internal.formats.zzh.zza) (obj2)));
        return ((te) (obj));
        Object obj1;
        obj1;
        zzb.zzd("Malformed native JSON response.", ((Throwable) (obj1)));
_L2:
        if (!i)
        {
            a(0);
        }
        return a(((com.google.android.gms.ads.internal.formats.zzh.zza) (null)));
        obj1;
        zzb.zzd("Timeout when loading native ad.", ((Throwable) (obj1)));
        continue; /* Loop/switch isn't completed */
        obj1;
        continue; /* Loop/switch isn't completed */
        obj1;
        continue; /* Loop/switch isn't completed */
        obj1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public ud a(JSONObject jsonobject, String s, boolean flag, boolean flag1)
        throws JSONException
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
        return a(((JSONObject) (s)), flag, flag1);
    }

    public List a(JSONObject jsonobject, String s, boolean flag, boolean flag1, boolean flag2)
        throws JSONException
    {
        ArrayList arraylist;
        if (flag)
        {
            jsonobject = jsonobject.getJSONArray(s);
        } else
        {
            jsonobject = jsonobject.optJSONArray(s);
        }
        arraylist = new ArrayList();
        if (jsonobject == null || jsonobject.length() == 0)
        {
            a(0, flag);
            return arraylist;
        }
        int l;
        int i1;
        if (flag2)
        {
            l = jsonobject.length();
        } else
        {
            l = 1;
        }
        for (i1 = 0; i1 < l; i1++)
        {
            JSONObject jsonobject1 = jsonobject.getJSONObject(i1);
            s = jsonobject1;
            if (jsonobject1 == null)
            {
                s = new JSONObject();
            }
            arraylist.add(a(((JSONObject) (s)), flag, flag1));
        }

        return arraylist;
    }

    public Future a(JSONObject jsonobject, String s, boolean flag)
        throws JSONException
    {
        s = jsonobject.getJSONObject(s);
        boolean flag1 = s.optBoolean("require", true);
        jsonobject = s;
        if (s == null)
        {
            jsonobject = new JSONObject();
        }
        return a(jsonobject, flag1, flag);
    }

    public void a(int l)
    {
        synchronized (g)
        {
            i = true;
            j = l;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(int l, boolean flag)
    {
        if (flag)
        {
            a(l);
        }
    }

    public ud b(JSONObject jsonobject)
        throws JSONException
    {
        jsonobject = jsonobject.optJSONObject("attribution");
        if (jsonobject == null)
        {
            return new ub(null);
        } else
        {
            String s = jsonobject.optString("text");
            int l = jsonobject.optInt("text_size", -1);
            Integer integer = a(jsonobject, "text_color");
            Integer integer1 = a(jsonobject, "bg_color");
            return uc.a(a(jsonobject, "image", false, false), new uc.a(s, integer1, integer, l) {

                final String a;
                final Integer b;
                final Integer c;
                final int d;
                final rz e;

                public zza a(zzc zzc1)
                {
                    if (zzc1 == null) goto _L2; else goto _L1
_L1:
                    if (!TextUtils.isEmpty(a)) goto _L3; else goto _L2
_L3:
                    String s1;
                    Drawable drawable;
                    Integer integer2;
                    Integer integer3;
                    s1 = a;
                    drawable = (Drawable)ll.a(zzc1.zzdr());
                    integer2 = b;
                    integer3 = c;
                    if (d <= 0) goto _L5; else goto _L4
_L4:
                    zzc1 = Integer.valueOf(d);
_L6:
                    zzc1 = new zza(s1, drawable, integer2, integer3, zzc1);
                    break MISSING_BLOCK_LABEL_94;
                    zzc1;
                    zzb.zzb("Could not get attribution icon", zzc1);
                    return null;
_L5:
                    zzc1 = null;
                    if (true) goto _L6; else goto _L2
_L2:
                    zzc1 = null;
                    return zzc1;
                }

                public Object a(Object obj)
                {
                    return a((zzc)obj);
                }

            
            {
                e = rz.this;
                a = s;
                b = integer;
                c = integer1;
                d = l;
                super();
            }
            });
        }
    }

    public boolean b()
    {
        boolean flag;
        synchronized (g)
        {
            flag = i;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Object call()
        throws Exception
    {
        return a();
    }

    static 
    {
        a = TimeUnit.SECONDS.toMillis(60L);
    }
}
