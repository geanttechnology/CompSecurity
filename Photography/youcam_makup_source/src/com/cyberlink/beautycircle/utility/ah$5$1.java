// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.net.Uri;
import com.cyberlink.beautycircle.Globals;
import com.perfectcorp.utility.ImageUtils;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.openapi.StatusesAPI;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            ai, ah

class a
    implements RequestListener
{

    final n a;

    public void onComplete(String s)
    {
        e.b(new Object[] {
            s
        });
        if (a.a != null)
        {
            a.a.a();
        }
    }

    public void onWeiboException(WeiboException weiboexception)
    {
        String s;
        if (weiboexception != null && weiboexception.toString() != null)
        {
            s = weiboexception.toString();
        } else
        {
            s = "Unknow error";
        }
        e.b(new Object[] {
            s
        });
        if (a.a != null)
        {
            a.a.a(weiboexception);
        }
    }

    n(n n)
    {
        a = n;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/utility/ah$5

/* anonymous class */
    class ah._cls5 extends j
    {

        final Oauth2AccessToken a;
        final Uri b;
        final String c;
        final ai d;
        final ah e;

        protected volatile Object a(Object obj)
        {
            return a((Void)obj);
        }

        protected Void a(Void void1)
        {
            StatusesAPI statusesapi = new StatusesAPI(ah.b(e), ah.a, a);
            android.graphics.Bitmap bitmap = ImageUtils.a(Globals.n(), b);
            try
            {
                void1 = URLEncoder.encode(c, "UTF-8");
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                void1.printStackTrace();
                Globals.b("Encode content failed.");
                void1 = null;
            }
            if (void1 != null)
            {
                statusesapi.upload(void1, bitmap, "", "", new ah._cls5._cls1(this));
            } else
            if (d != null)
            {
                d.a(new WeiboException("Encode url failed"));
                return null;
            }
            return null;
        }

            
            {
                e = ah1;
                a = oauth2accesstoken;
                b = uri;
                c = s;
                d = ai1;
                super();
            }
    }

}
