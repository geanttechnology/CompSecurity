// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.EditText;
import android.widget.Toast;
import com.amazon.mShop.net.CookieBridge;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.amazon.mShop.util:
//            DebugUtil, Util

static final class val.context
    implements android.content.ace.OnClickListener
{

    final Context val$context;
    final EditText val$edit;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = val$edit.getText().toString();
        boolean flag = Pattern.compile((new StringBuilder()).append("[A-Z_0-9]+:[CT][0-9]*").append("(&").append("[A-Z_0-9]+:[CT][0-9]*").append(")*").toString()).matcher(dialoginterface).find();
        if (!Util.isEmpty(dialoginterface) && !flag)
        {
            Toast.makeText(val$context, com.amazon.mShop.android.lib._web_lab_invalid, 1).show();
            return;
        } else
        {
            CookieBridge.setCookie(val$context, false, "experiment", (new StringBuilder()).append("\"").append(dialoginterface).append("\"").toString());
            CookieBridge.setCookie(val$context, false, "session-id", "");
            CookieBridge.setCookie(val$context, false, "ubid-main", "");
            DebugUtil.access$000(val$context);
            return;
        }
    }

    ing(EditText edittext, Context context1)
    {
        val$edit = edittext;
        val$context = context1;
        super();
    }
}
