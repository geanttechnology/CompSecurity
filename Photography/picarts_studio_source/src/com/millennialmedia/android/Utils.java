// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.android:
//            MMLog

class Utils
{

    Utils()
    {
    }

    static JSONObject a(View view)
    {
        JSONObject jsonobject = new JSONObject();
        if (view == null)
        {
            MMLog.e("Utils", "Unable to calculate view dimensions for null view");
        } else
        {
            DisplayMetrics displaymetrics = view.getContext().getResources().getDisplayMetrics();
            if (displaymetrics != null)
            {
                int ai[] = new int[2];
                view.getLocationInWindow(ai);
                try
                {
                    jsonobject.put("x", (int)((float)ai[0] / displaymetrics.density));
                    jsonobject.put("y", (int)((float)ai[1] / displaymetrics.density));
                    jsonobject.put("width", (int)((float)view.getWidth() / displaymetrics.density));
                    jsonobject.put("height", (int)((float)view.getHeight() / displaymetrics.density));
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    MMLog.a("Utils", "Unable to build view dimensions", view);
                    return jsonobject;
                }
                return jsonobject;
            }
        }
        return jsonobject;
    }
}
