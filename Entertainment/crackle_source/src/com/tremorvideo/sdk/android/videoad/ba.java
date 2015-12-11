// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tremorvideo.a.a;
import com.tremorvideo.a.b;
import com.tremorvideo.a.c;
import java.util.Dictionary;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            aw, an, ad

public class ba
{

    private static b a;

    static b a()
    {
        return a;
    }

    static b a(b b1)
    {
        a = b1;
        return b1;
    }

    public static void a(Activity activity, aw aw, com.tremorvideo.a.b.a a1)
    {
        b b1 = new b("231434140219582");
        a = b1;
        aw = new com.tremorvideo.a.b.a(activity, b1, a1, aw) {

            final Activity a;
            final b b;
            final com.tremorvideo.a.b.a c;
            final aw d;

            public void a()
            {
                com.tremorvideo.sdk.android.videoad.ba.a(a, b);
                c.a();
                com.tremorvideo.sdk.android.videoad.ba.a(null);
            }

            public void a(Bundle bundle)
            {
                an an1 = com.tremorvideo.sdk.android.videoad.an.a(a);
                an1.setIndeterminate(true);
                an1.setMessage("Please Wait...");
                an1.setCancelable(false);
                an1.show();
                (new Thread(new Runnable(this, an1, bundle) {

                    final an a;
                    final Bundle b;
                    final _cls1 c;

                    public void run()
                    {
                        Dictionary dictionary = c.d.f();
                        Bundle bundle = new Bundle();
                        if (dictionary.get("link") != null)
                        {
                            bundle.putString("link", (String)dictionary.get("link"));
                        }
                        if (dictionary.get("description") != null)
                        {
                            bundle.putString("description", (String)dictionary.get("description"));
                        }
                        if (dictionary.get("name") != null)
                        {
                            bundle.putString("name", (String)dictionary.get("name"));
                        }
                        if (dictionary.get("message") != null)
                        {
                            bundle.putString("message", (String)dictionary.get("message"));
                        }
                        if (dictionary.get("image") != null)
                        {
                            bundle.putString("picture", (String)dictionary.get("image"));
                        }
                        if (dictionary.get("video") != null)
                        {
                            bundle.putString("source", (String)dictionary.get("video"));
                        }
                        bundle.putSerializable("access_token", c.b.b());
                        c.b.a("feed", bundle, "POST");
                        boolean flag;
                        boolean flag1;
                        flag1 = true;
                        flag = true;
                        c.b.a(c.a);
_L1:
                        Exception exception;
                        a.dismiss();
                        if (flag)
                        {
                            c.c.a(b);
                        } else
                        {
                            c.c.a(new c("A connection error occured."));
                        }
                        com.tremorvideo.sdk.android.videoad.ba.a(null);
                        return;
                        exception;
                        flag = false;
_L2:
                        com.tremorvideo.sdk.android.videoad.ad.a(exception);
                          goto _L1
                        exception;
                        flag = flag1;
                          goto _L2
                    }

            
            {
                c = _pcls1;
                a = an1;
                b = bundle;
                super();
            }
                })).start();
            }

            public void a(a a2)
            {
                if (com.tremorvideo.sdk.android.videoad.ba.a() != null)
                {
                    com.tremorvideo.sdk.android.videoad.ba.a(a, b);
                    c.a(a2);
                    com.tremorvideo.sdk.android.videoad.ba.a(null);
                }
            }

            public void a(c c1)
            {
                com.tremorvideo.sdk.android.videoad.ba.a(a, b);
                c.a(c1);
                com.tremorvideo.sdk.android.videoad.ba.a(null);
            }

            
            {
                a = activity;
                b = b1;
                c = a1;
                d = aw;
                super();
            }
        };
        b1.a(activity, new String[] {
            "publish_stream"
        }, -1, aw);
    }

    static void a(Context context, b b1)
    {
        b(context, b1);
    }

    private static void b(Context context, b b1)
    {
        (new Thread(new Runnable(b1, context) {

            final b a;
            final Context b;

            public void run()
            {
                try
                {
                    a.a(b);
                    return;
                }
                catch (Exception exception)
                {
                    com.tremorvideo.sdk.android.videoad.ad.a(exception);
                }
            }

            
            {
                a = b1;
                b = context;
                super();
            }
        })).start();
    }
}
