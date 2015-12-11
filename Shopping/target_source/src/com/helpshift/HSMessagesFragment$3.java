// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.helpshift:
//            HSMessagesFragment, o

class a
    implements android.view.
{

    final HSMessagesFragment a;

    public void onClick(View view)
    {
        view = HSMessagesFragment.l(a).getText().toString().trim();
        if (TextUtils.isEmpty(view))
        {
            break MISSING_BLOCK_LABEL_137;
        }
        HSMessagesFragment.l(a).setText("");
        HSMessagesFragment.a(a, HSMessagesFragment.q(a), HSMessagesFragment.r(a), HSMessagesFragment.b(a), view, "txt", "");
        if (HSMessagesFragment.n(a) != null)
        {
            HSMessagesFragment.n(a).a(view);
        }
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("type", "txt");
        jsonobject.put("body", view);
        jsonobject.put("id", HSMessagesFragment.b(a));
        o.a("m", jsonobject);
        return;
        view;
        Log.d("HelpShiftDebug", "JSONException", view);
        return;
    }

    (HSMessagesFragment hsmessagesfragment)
    {
        a = hsmessagesfragment;
        super();
    }
}
