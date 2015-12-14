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
    implements p
{

    final Activity a;
    private String b;

    public final void a()
    {
        Bundle bundle = new Bundle();
        bundle.putString("message", b);
        bundle.putString("link", a.getString(0x7f08091c));
        (new GraphRequest(AccessToken.getCurrentAccessToken(), "me/feed", bundle, HttpMethod.POST, new com.facebook.GraphRequest.Callback() {

            private FacebookUtils._cls7 a;

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

            
            {
                a = FacebookUtils._cls7.this;
                super();
            }
        })).executeAsync();
    }

    _cls1.a(String s, Activity activity)
    {
        b = s;
        a = activity;
        super();
    }
}
