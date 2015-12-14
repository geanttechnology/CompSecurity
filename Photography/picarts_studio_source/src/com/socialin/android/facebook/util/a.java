// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook.util;

import com.facebook.GraphResponse;
import com.socialin.android.util.aj;

public class a
{

    public aj a;
    public com.facebook.GraphRequest.Callback b;

    public a()
    {
        b = new com.facebook.GraphRequest.Callback() {

            private a a;

            public final void onCompleted(GraphResponse graphresponse)
            {
label0:
                {
                    org.json.JSONObject jsonobject;
                    if (graphresponse != null)
                    {
                        jsonobject = graphresponse.getJSONObject();
                    } else
                    {
                        jsonobject = null;
                    }
                    if (a.a(a) != null)
                    {
                        if (jsonobject != null && graphresponse.getError() == null)
                        {
                            break label0;
                        }
                        a.a(a).b();
                    }
                    return;
                }
                a.a(a).a();
            }

            
            {
                a = a.this;
                super();
            }
        };
    }

    static aj a(a a1)
    {
        return a1.a;
    }

    static 
    {
        (new StringBuilder()).append(com/socialin/android/facebook/util/a.getSimpleName()).append(" - ");
    }
}
