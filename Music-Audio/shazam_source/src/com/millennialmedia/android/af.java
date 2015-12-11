// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.net.Uri;
import android.text.TextUtils;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.millennialmedia.android:
//            i, s, j, k, 
//            l, m, n, o, 
//            p, q, al, ao, 
//            ai, ad, aj, an

final class af
    implements Runnable
{

    String a;
    private WeakReference b;
    private String c;
    private String d;
    private Map e;

    af(ao ao1, String s1)
    {
        b = new WeakReference(ao1);
        ao1 = Uri.parse(s1).getHost().split("\\.");
        if (ao1.length != 2)
        {
            return;
        }
        int j1;
        c = ao1[0];
        a = ao1[1];
        e = new HashMap();
        ao1 = s1.substring(s1.indexOf('?') + 1).split("&");
        j1 = ao1.length;
        int i1 = 0;
_L2:
        if (i1 >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        String as[] = ao1[i1].split("=");
        if (as.length >= 2)
        {
            e.put(Uri.decode(as[0]), Uri.decode(as[1]));
            if (as[0].equalsIgnoreCase("callback"))
            {
                d = Uri.decode(as[1]);
            }
        }
        i1++;
        if (true) goto _L2; else goto _L1
        ao1;
        al.a("MMCommand", String.format("Exception while executing javascript call %s ", new Object[] {
            s1
        }), ao1);
        ao1.printStackTrace();
_L1:
    }

    static String a(af af1)
    {
        return af1.a;
    }

    static String b(af af1)
    {
        return af1.d;
    }

    public final void run()
    {
        ao ao1 = null;
        if (c == null) goto _L2; else goto _L1
_L1:
        Object obj = a;
        if (obj == null) goto _L2; else goto _L3
_L3:
        ao ao2 = (ao)b.get();
        if (ao2 == null) goto _L5; else goto _L4
_L4:
        obj = c;
        if (obj == null) goto _L7; else goto _L6
_L6:
        if (!"MMBanner".equals(obj)) goto _L9; else goto _L8
_L8:
        obj = s.a();
_L13:
        if (obj == null) goto _L11; else goto _L10
_L10:
        Object obj1;
        Map map;
        boolean flag;
        try
        {
            ((ai) (obj)).b(ao2.getContext());
            ((ai) (obj)).a(ao2);
            map = e;
            if (ao2.getParent() == null)
            {
                break MISSING_BLOCK_LABEL_610;
            }
            flag = (ViewGroup)ao2.getParent() instanceof ad;
            break MISSING_BLOCK_LABEL_598;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        finally
        {
            if (!TextUtils.isEmpty(d))
            {
                ao ao3 = (ao)b.get();
                if (ao3 != null)
                {
                    obj = ao1;
                    if (true)
                    {
                        obj = aj.b(a);
                    }
                    if (((aj) (obj)).b == null)
                    {
                        obj.b = a;
                    }
                    if (((aj) (obj)).a == null)
                    {
                        obj.a = c.replaceFirst("Bridge", "");
                    }
                    an.a(new _cls1(ao3, ((aj) (obj))));
                }
            }
            throw obj1;
        }
          goto _L12
_L16:
        map.put("PROPERTY_BANNER_TYPE", obj1);
        map.put("PROPERTY_STATE", ao2.c);
        map.put("PROPERTY_EXPANDING", String.valueOf(ao2.a));
        obj = ((ai) (obj)).a(a, e);
_L15:
        if (!TextUtils.isEmpty(d))
        {
            ao1 = (ao)b.get();
            if (ao1 != null)
            {
                obj1 = obj;
                if (obj == null)
                {
                    obj1 = aj.b(a);
                }
                if (((aj) (obj1)).b == null)
                {
                    obj1.b = a;
                }
                if (((aj) (obj1)).a == null)
                {
                    obj1.a = c.replaceFirst("Bridge", "");
                }
                an.a(new Runnable(ao1, ((aj) (obj1))) {

                    final ao a;
                    final aj b;
                    final af c;

                    public final void run()
                    {
                        if (af.a(c).equals("expandWithProperties"))
                        {
                            a.b = true;
                        }
                        String s1 = String.format("javascript:%s(%s);", new Object[] {
                            af.b(c), b.a()
                        });
                        a.loadUrl(s1);
                    }

            
            {
                c = af.this;
                a = ao1;
                b = aj1;
                super();
            }
                });
            }
        }
        return;
_L9:
label0:
        {
            if (!"MMCachedVideo".equals(obj))
            {
                break label0;
            }
            obj = s.b();
        }
          goto _L13
label1:
        {
            if (!"MMCalendar".equals(obj))
            {
                break label1;
            }
            obj = s.c();
        }
          goto _L13
label2:
        {
            if (!"MMDevice".equals(obj))
            {
                break label2;
            }
            obj = s.d();
        }
          goto _L13
label3:
        {
            if (!"MMInlineVideo".equals(obj))
            {
                break label3;
            }
            obj = s.e();
        }
          goto _L13
label4:
        {
            if (!"MMInterstitial".equals(obj))
            {
                break label4;
            }
            obj = s.f();
        }
          goto _L13
label5:
        {
            if (!"MMMedia".equals(obj))
            {
                break label5;
            }
            obj = s.g();
        }
          goto _L13
label6:
        {
            if (!"MMNotification".equals(obj))
            {
                break label6;
            }
            obj = s.h();
        }
          goto _L13
        if (!"MMSpeechkit".equals(obj)) goto _L7; else goto _L14
_L14:
        obj = s.i();
          goto _L13
_L11:
        obj = aj.b((new StringBuilder("Service: ")).append(c).append(" does not exist.").toString());
          goto _L15
_L12:
        al.a("MMCommand", (new StringBuilder("Exception while executing javascript call ")).append(a).toString(), ((Throwable) (obj)));
        obj = aj.b((new StringBuilder("Unexpected exception, ")).append(obj.getClass().getName()).append(" received.").toString());
          goto _L15
_L2:
        obj = aj.b("The service or service method was not defined.");
          goto _L15
_L7:
        obj = null;
          goto _L13
_L5:
        obj = null;
          goto _L15
_L17:
        if (flag)
        {
            obj1 = "true";
        } else
        {
            obj1 = "false";
        }
          goto _L16
        flag = false;
          goto _L17
    }

    static 
    {
        s.a(new i());
        s.a(new j());
        s.a(new k());
        s.a(new l());
        s.a(new m());
        s.a(new n());
        s.a(new o());
        s.a(new p());
        s.a(new q());
    }
}
