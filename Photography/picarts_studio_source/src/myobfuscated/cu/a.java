// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cu;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.pinterest.pinit.b;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.d;
import io.branch.referral.g;
import io.branch.referral.m;
import java.io.File;

public class a
{

    private final String a = myobfuscated/cu/a.getSimpleName();
    private final String b;
    private b c;

    public a(Context context)
    {
        c = new b() {

            private a a;

            public final void a()
            {
                super.a();
                d.a(a.a(a), "PinItListener.onStart");
            }

            public final void a(Exception exception)
            {
                super.a(exception);
                d.b(a.a(a), "PinItListener.onException", exception);
            }

            public final void a(boolean flag)
            {
                super.a(flag);
                d.a(a.a(a), "PinItListener.onComplete");
            }

            
            {
                a = a.this;
                super();
            }
        };
        b = context.getString(0x7f080954);
    }

    static String a(a a1)
    {
        return a1.a;
    }

    static void a(a a1, Context context, String s, ImageItem imageitem, String s1)
    {
        Uri uri = null;
        if (!TextUtils.isEmpty(s))
        {
            uri = Uri.fromFile(new File(s));
        }
        s = uri;
_L1:
        String s2;
        com.pinterest.pinit.a a2;
        if (imageitem != null)
        {
            s2 = imageitem.getUrl();
        } else
        {
            s2 = "";
        }
        com.pinterest.pinit.a.e = a1.b;
        com.pinterest.pinit.a.a = d.b;
        a2 = new com.pinterest.pinit.a();
        if (!TextUtils.isEmpty(s2))
        {
            a2.a(s2);
        } else
        if (s != null)
        {
            a2.a(s);
        }
        if (imageitem != null)
        {
            a2.b = imageitem.getSecondUrl();
        }
        a2.c = s1;
        a2.d = a1.c;
        a2.a(context);
        return;
        s;
        d.b(a1.a, "pintIt: get URI from file path", s);
        s = null;
          goto _L1
    }

    // Unreferenced inner class myobfuscated/cu/a$1

/* anonymous class */
    public final class _cls1
        implements g
    {

        private Activity a;
        private String b;
        private ImageItem c;
        private String d;
        private a e;

        public final void a(String s, m m)
        {
            a.a(e, a, b, c, (new StringBuilder()).append(d).append(s).toString());
        }

            public 
            {
                e = a.this;
                a = activity;
                b = s;
                c = imageitem;
                d = s1;
                super();
            }
    }

}
