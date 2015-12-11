// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.helpshift.h.e;
import com.helpshift.i.b;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.helpshift:
//            HSAddIssueFragment, o, l

class a extends Handler
{

    final HSAddIssueFragment a;

    public void handleMessage(Message message)
    {
        message = (JSONObject)((HashMap)message.obj).get("response");
        try
        {
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("type", "url");
            jsonobject.put("body", message.getJSONObject("meta").getJSONArray("attachments").getJSONObject(0).getString("url"));
            jsonobject.put("id", HSAddIssueFragment.h(a));
            o.a("m", jsonobject);
            if (HSAddIssueFragment.n(a) != null)
            {
                HSAddIssueFragment.n(a).a("User sent a screenshot");
            }
            b.a(a.getActivity(), com.helpshift.HSAddIssueFragment.b(a), HSAddIssueFragment.g(a), message.getJSONObject("meta").getString("refers"), 0);
        }
        catch (IOException ioexception)
        {
            Log.d("HelpShiftDebug", "Saving uploaded screenshot", ioexception);
        }
        catch (JSONException jsonexception)
        {
            Log.d("HelpShiftDebug", "uploadSuccessHandler", jsonexception);
        }
        try
        {
            message = message.getJSONObject("meta").getString("refers");
            if (!TextUtils.isEmpty(message))
            {
                e.f(message);
            }
            com.helpshift.HSAddIssueFragment.b(a).c(HSAddIssueFragment.p(a), HSAddIssueFragment.p(a));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            Log.d("HelpShiftDebug", "uploadSuccessHandler", message);
        }
    }

    (HSAddIssueFragment hsaddissuefragment)
    {
        a = hsaddissuefragment;
        super();
    }
}
