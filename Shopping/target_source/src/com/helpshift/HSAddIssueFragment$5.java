// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import com.helpshift.i.b;
import com.helpshift.k.a;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.helpshift:
//            HSAddIssueFragment, l, s, o, 
//            k

class a extends Handler
{

    final HSAddIssueFragment a;

    public void handleMessage(Message message)
    {
        message = (JSONObject)((HashMap)message.obj).get("response");
        com.helpshift.HSAddIssueFragment.a(a, message.getString("id"));
        JSONArray jsonarray = new JSONArray();
        jsonarray.put(message);
        HSAddIssueFragment.c(a).b(message.getString("created_at"), com.helpshift.HSAddIssueFragment.b(a).B());
        HSAddIssueFragment.c(a).a(jsonarray, com.helpshift.HSAddIssueFragment.b(a).B());
        com.helpshift.HSAddIssueFragment.b(a).h(HSAddIssueFragment.d(a));
        com.helpshift.HSAddIssueFragment.b(a).i(HSAddIssueFragment.e(a));
        HSAddIssueFragment.c(a).h("", com.helpshift.HSAddIssueFragment.b(a).B());
        HSAddIssueFragment.c(a).i("", com.helpshift.HSAddIssueFragment.b(a).A());
        message = HSAddIssueFragment.f(a).getText().toString().trim();
        HSAddIssueFragment.f(a).setText("");
        com.helpshift.o.a("p");
        if (TextUtils.isEmpty(HSAddIssueFragment.g(a)))
        {
            break MISSING_BLOCK_LABEL_367;
        }
        HSAddIssueFragment.c(a).n(HSAddIssueFragment.h(a));
        com.helpshift.HSAddIssueFragment.a(a, b.a(HSAddIssueFragment.c(a), HSAddIssueFragment.h(a), HSAddIssueFragment.g(a), true));
        HSAddIssueFragment.l(a).b(HSAddIssueFragment.i(a), HSAddIssueFragment.j(a), com.helpshift.HSAddIssueFragment.b(a).B(), HSAddIssueFragment.h(a), "", "sc", HSAddIssueFragment.k(a).g, HSAddIssueFragment.k(a).h);
_L2:
        com.helpshift.HSAddIssueFragment.b(a).u();
        if (HSAddIssueFragment.n(a) != null)
        {
            HSAddIssueFragment.n(a).a(message);
            return;
        }
        break MISSING_BLOCK_LABEL_389;
        HSAddIssueFragment.m(a);
        if (true) goto _L2; else goto _L1
_L1:
        message;
        Log.d("HelpShiftDebug", message.toString(), message);
    }

    (HSAddIssueFragment hsaddissuefragment)
    {
        a = hsaddissuefragment;
        super();
    }
}
