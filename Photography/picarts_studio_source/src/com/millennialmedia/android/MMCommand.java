// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.net.Uri;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.millennialmedia.android:
//            BridgeMMBanner, ComponentRegistry, BridgeMMCachedVideo, BridgeMMCalendar, 
//            BridgeMMDevice, BridgeMMInlineVideo, BridgeMMInterstitial, BridgeMMMedia, 
//            BridgeMMNotification, BridgeMMSpeechkit, MMLog, MMWebView, 
//            MMJSObject, MMJSResponse, MMSDK

class MMCommand
    implements Runnable
{

    String a;
    private WeakReference b;
    private String c;
    private String d;
    private Map e;

    MMCommand(MMWebView mmwebview, String s)
    {
        b = new WeakReference(mmwebview);
        mmwebview = Uri.parse(s).getHost().split("\\.");
        if (mmwebview.length != 2)
        {
            return;
        }
        int j;
        c = mmwebview[0];
        a = mmwebview[1];
        e = new HashMap();
        mmwebview = s.substring(s.indexOf('?') + 1).split("&");
        j = mmwebview.length;
        int i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        String as[] = mmwebview[i].split("=");
        if (as.length >= 2)
        {
            e.put(Uri.decode(as[0]), Uri.decode(as[1]));
            if (as[0].equalsIgnoreCase("callback"))
            {
                d = Uri.decode(as[1]);
            }
        }
        i++;
        if (true) goto _L2; else goto _L1
        mmwebview;
        MMLog.a("MMCommand", String.format("Exception while executing javascript call %s ", new Object[] {
            s
        }), mmwebview);
        mmwebview.printStackTrace();
_L1:
    }

    static String a(MMCommand mmcommand)
    {
        return mmcommand.a;
    }

    static String b(MMCommand mmcommand)
    {
        return mmcommand.d;
    }

    public void run()
    {
        MMWebView mmwebview = null;
        if (c == null) goto _L2; else goto _L1
_L1:
        Object obj = a;
        if (obj == null) goto _L2; else goto _L3
_L3:
        MMWebView mmwebview1 = (MMWebView)b.get();
        if (mmwebview1 == null)
        {
            break MISSING_BLOCK_LABEL_580;
        }
        obj = c;
        if (obj == null) goto _L5; else goto _L4
_L4:
        if (!"MMBanner".equals(obj)) goto _L7; else goto _L6
_L6:
        obj = ComponentRegistry.a();
_L10:
        if (obj == null) goto _L9; else goto _L8
_L8:
        Map map;
        ((MMJSObject) (obj)).b(mmwebview1.getContext());
        ((MMJSObject) (obj)).a(mmwebview1);
        map = e;
        Object obj1;
        if (mmwebview1.e())
        {
            obj1 = "true";
        } else
        {
            obj1 = "false";
        }
        map.put("PROPERTY_BANNER_TYPE", obj1);
        map.put("PROPERTY_STATE", mmwebview1.c);
        map.put("PROPERTY_EXPANDING", String.valueOf(mmwebview1.a));
        obj = ((MMJSObject) (obj)).a(a, e);
_L12:
        if (!TextUtils.isEmpty(d))
        {
            mmwebview = (MMWebView)b.get();
            if (mmwebview != null)
            {
                obj1 = obj;
                if (obj == null)
                {
                    obj1 = MMJSResponse.b(a);
                }
                if (((MMJSResponse) (obj1)).b == null)
                {
                    obj1.b = a;
                }
                if (((MMJSResponse) (obj1)).a == null)
                {
                    obj1.a = c.replaceFirst("Bridge", "");
                }
                MMSDK.a(new Runnable(mmwebview, ((MMJSResponse) (obj1))) {

                    private MMWebView a;
                    private MMJSResponse b;
                    private MMCommand c;

                    public void run()
                    {
                        if (MMCommand.a(c).equals("expandWithProperties"))
                        {
                            a.b = true;
                        }
                        String s = String.format("javascript:%s(%s);", new Object[] {
                            MMCommand.b(c), b.c()
                        });
                        a.loadUrl(s);
                    }

            
            {
                c = MMCommand.this;
                a = mmwebview;
                b = mmjsresponse;
                super();
            }
                });
            }
        }
        return;
_L7:
label0:
        {
            if (!"MMCachedVideo".equals(obj))
            {
                break label0;
            }
            obj = ComponentRegistry.b();
        }
          goto _L10
label1:
        {
            if (!"MMCalendar".equals(obj))
            {
                break label1;
            }
            obj = ComponentRegistry.c();
        }
          goto _L10
label2:
        {
            if (!"MMDevice".equals(obj))
            {
                break label2;
            }
            obj = ComponentRegistry.d();
        }
          goto _L10
label3:
        {
            if (!"MMInlineVideo".equals(obj))
            {
                break label3;
            }
            obj = ComponentRegistry.e();
        }
          goto _L10
label4:
        {
            if (!"MMInterstitial".equals(obj))
            {
                break label4;
            }
            obj = ComponentRegistry.f();
        }
          goto _L10
label5:
        {
            if (!"MMMedia".equals(obj))
            {
                break label5;
            }
            obj = ComponentRegistry.g();
        }
          goto _L10
label6:
        {
            if (!"MMNotification".equals(obj))
            {
                break label6;
            }
            obj = ComponentRegistry.h();
        }
          goto _L10
        if (!"MMSpeechkit".equals(obj)) goto _L5; else goto _L11
_L11:
        obj = ComponentRegistry.i();
          goto _L10
_L9:
        obj = MMJSResponse.b((new StringBuilder("Service: ")).append(c).append(" does not exist.").toString());
          goto _L12
        obj;
        MMLog.a("MMCommand", (new StringBuilder("Exception while executing javascript call ")).append(a).toString(), ((Throwable) (obj)));
        obj = MMJSResponse.b((new StringBuilder("Unexpected exception, ")).append(obj.getClass().getName()).append(" received.").toString());
          goto _L12
_L2:
        obj = MMJSResponse.b("The service or service method was not defined.");
          goto _L12
        obj1;
        if (!TextUtils.isEmpty(d))
        {
            MMWebView mmwebview2 = (MMWebView)b.get();
            if (mmwebview2 != null)
            {
                obj = mmwebview;
                if (true)
                {
                    obj = MMJSResponse.b(a);
                }
                if (((MMJSResponse) (obj)).b == null)
                {
                    obj.b = a;
                }
                if (((MMJSResponse) (obj)).a == null)
                {
                    obj.a = c.replaceFirst("Bridge", "");
                }
                MMSDK.a(new _cls1(mmwebview2, ((MMJSResponse) (obj))));
            }
        }
        throw obj1;
_L5:
        obj = null;
          goto _L10
        obj = null;
          goto _L12
    }

    static 
    {
        ComponentRegistry.a(new BridgeMMBanner());
        ComponentRegistry.a(new BridgeMMCachedVideo());
        ComponentRegistry.a(new BridgeMMCalendar());
        ComponentRegistry.a(new BridgeMMDevice());
        ComponentRegistry.a(new BridgeMMInlineVideo());
        ComponentRegistry.a(new BridgeMMInterstitial());
        ComponentRegistry.a(new BridgeMMMedia());
        ComponentRegistry.a(new BridgeMMNotification());
        ComponentRegistry.a(new BridgeMMSpeechkit());
    }
}
