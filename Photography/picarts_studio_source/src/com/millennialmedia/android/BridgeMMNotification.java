// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Vibrator;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Callable;

// Referenced classes of package com.millennialmedia.android:
//            MMJSObject, MMJSResponse, MMWebView

class BridgeMMNotification extends MMJSObject
    implements android.content.DialogInterface.OnClickListener
{

    private String a;
    private String d;
    private int e;

    BridgeMMNotification()
    {
        a = "alert";
        d = "vibrate";
    }

    static int a(BridgeMMNotification bridgemmnotification)
    {
        return bridgemmnotification.e;
    }

    final MMJSResponse a(String s, Map map)
    {
        MMJSResponse mmjsresponse = null;
        if (a.equals(s))
        {
            mmjsresponse = alert(map);
        } else
        if (d.equals(s))
        {
            return vibrate(map);
        }
        return mmjsresponse;
    }

    public MMJSResponse alert(Map map)
    {
        this;
        JVM INSTR monitorenter ;
        map = a(new Callable(map) {

            private Map a;
            private BridgeMMNotification b;

            public MMJSResponse call()
            {
                Object obj = (MMWebView)b.c.get();
                if (obj != null)
                {
                    Object obj1 = ((MMWebView) (obj)).h();
                    obj = a;
                    if (obj1 != null)
                    {
                        if (!((Activity) (obj1)).isFinishing())
                        {
                            obj1 = (new android.app.AlertDialog.Builder(((Context) (obj1)))).create();
                            if (((Map) (obj)).containsKey("title"))
                            {
                                ((AlertDialog) (obj1)).setTitle((CharSequence)((Map) (obj)).get("title"));
                            }
                            if (((Map) (obj)).containsKey("message"))
                            {
                                ((AlertDialog) (obj1)).setMessage((CharSequence)((Map) (obj)).get("message"));
                            }
                            if (((Map) (obj)).containsKey("cancelButton"))
                            {
                                ((AlertDialog) (obj1)).setButton(-2, (CharSequence)((Map) (obj)).get("cancelButton"), b);
                            }
                            if (((Map) (obj)).containsKey("buttons"))
                            {
                                String as[] = ((String)((Map) (obj)).get("buttons")).split(",");
                                if (as.length > 0)
                                {
                                    ((AlertDialog) (obj1)).setButton(-3, as[0], b);
                                }
                                if (as.length > 1)
                                {
                                    ((AlertDialog) (obj1)).setButton(-1, as[1], b);
                                }
                            }
                            ((AlertDialog) (obj1)).show();
                        }
                        as = new MMJSResponse();
                        as.c = 1;
                        as.d = Integer.valueOf(BridgeMMNotification.a(b));
                        return as;
                    }
                }
                return null;
            }

            public volatile Object call()
            {
                return call();
            }

            
            {
                b = BridgeMMNotification.this;
                a = map;
                super();
            }
        });
        this;
        JVM INSTR monitorexit ;
        return map;
        map;
        throw map;
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        this;
        JVM INSTR monitorenter ;
        if (i != -2)
        {
            break MISSING_BLOCK_LABEL_13;
        }
        e = 0;
        if (i != -3)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        e = 1;
        if (i != -1)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        e = 2;
        dialoginterface.cancel();
        notify();
        this;
        JVM INSTR monitorexit ;
        return;
        dialoginterface;
        throw dialoginterface;
    }

    public MMJSResponse vibrate(Map map)
    {
        Context context = (Context)b.get();
        long l;
        if (map.containsKey("duration"))
        {
            l = (long)((double)Float.parseFloat((String)map.get("duration")) * 1000D);
        } else
        {
            l = 0L;
        }
        if (context != null && l > 0L)
        {
            if (context.getPackageManager().checkPermission("android.permission.VIBRATE", context.getPackageName()) == 0)
            {
                ((Vibrator)context.getSystemService("vibrator")).vibrate(l);
                return MMJSResponse.a((new StringBuilder("Vibrating for ")).append(l).toString());
            } else
            {
                return MMJSResponse.b("The required permissions to vibrate are not set.");
            }
        } else
        {
            return null;
        }
    }
}
