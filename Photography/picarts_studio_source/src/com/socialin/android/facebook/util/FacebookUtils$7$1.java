// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook.util;

import android.app.Activity;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.socialin.android.facebook.p;
import com.socialin.android.util.Utils;

// Referenced classes of package com.socialin.android.facebook.util:
//            FacebookUtils

final class a
    implements com.facebook.ack
{

    private  a;

    public final void onCompleted(GraphResponse graphresponse)
    {
label0:
        {
            if (graphresponse != null)
            {
                if (graphresponse.getError() != null)
                {
                    break label0;
                }
                Utils.a(a.a, a.a.getString(0x7f0805e9), 1);
            }
            return;
        }
        Utils.a(a.a, graphresponse.getError().getErrorUserMessage(), 1);
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/socialin/android/facebook/util/FacebookUtils$7

/* anonymous class */
    final class FacebookUtils._cls7
        implements p
    {

        final Activity a;
        private String b;

        public final void a()
        {
            Bundle bundle = new Bundle();
            bundle.putString("message", b);
            bundle.putString("link", a.getString(0x7f08091c));
            (new GraphRequest(AccessToken.getCurrentAccessToken(), "me/feed", bundle, HttpMethod.POST, new FacebookUtils._cls7._cls1(this))).executeAsync();
        }

            
            {
                b = s;
                a = activity;
                super();
            }
    }

}
