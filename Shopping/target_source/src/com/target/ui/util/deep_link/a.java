// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.deep_link;

import android.app.Activity;
import android.net.Uri;
import io.branch.referral.d;
import io.branch.referral.f;
import org.json.JSONException;
import org.json.JSONObject;

public class com.target.ui.util.deep_link.a
{
    public static interface a
    {

        public abstract void a(Uri uri);

        public abstract void a(f f);

        public abstract void a(JSONException jsonexception);
    }


    public static boolean a(Uri uri, d d1, Activity activity, a a1)
    {
        return d1.a(new io.branch.referral.d.e(a1) {

            final a val$deepLinkHandler;

            public void a(JSONObject jsonobject, f f)
            {
                if (f != null)
                {
                    deepLinkHandler.a(f);
                } else
                if (jsonobject != null && jsonobject.has("tgtlink"))
                {
                    try
                    {
                        jsonobject = jsonobject.getString("tgtlink");
                        deepLinkHandler.a(Uri.parse(jsonobject));
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (JSONObject jsonobject)
                    {
                        deepLinkHandler.a(jsonobject);
                    }
                    return;
                }
            }

            
            {
                deepLinkHandler = a1;
                super();
            }
        }, uri, activity);
    }
}
