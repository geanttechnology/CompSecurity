// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.app.ProgressDialog;
import android.util.Log;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.livemixtapes:
//            MixtapeList, console, JsonToMap

class cHttpCallback extends cHttpCallback
{

    final MixtapeList this$0;
    private final ProgressDialog val$dialog;

    protected void always()
    {
        if (val$dialog != null)
        {
            val$dialog.dismiss();
        }
    }

    protected void exception(Exception exception1)
    {
        console.log(new Object[] {
            exception1
        });
    }

    protected void success(String s, String s1, int i)
    {
        console.log(new Object[] {
            s, s1, Integer.valueOf(i)
        });
        try
        {
            s = (ArrayList)JsonToMap.toList((JSONArray)(new JSONObject(s)).get("mixtapes"));
            if (s.size() > 0)
            {
                mixtapeList.addAll(s);
                adapter.notifyDataSetChanged();
            }
            Log.d("Nithin", s.toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    xtapeListAdapter()
    {
        this$0 = final_mixtapelist;
        val$dialog = ProgressDialog.this;
        super();
    }
}
