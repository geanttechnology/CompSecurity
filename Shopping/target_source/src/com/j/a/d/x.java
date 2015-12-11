// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.d;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.ListView;
import com.j.a.c.e;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.j.a.d:
//            ai, c, b, ac, 
//            e

class x
    implements android.content.DialogInterface.OnClickListener
{

    final int a;
    final ai b;

    x(ai ai1, int i)
    {
        b = ai1;
        a = i;
        super();
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        String s1 = ((JSONObject)b.a.f().opt(a)).optString("name");
        Object obj = b.a.b(s1);
        String s = b.b.a.a.c.getListView().getItemAtPosition(i).toString();
        dialoginterface = b.a.a(((JSONObject) (obj)), s);
        com.j.a.d.e e1 = com.j.a.d.e.e();
        obj = ((JSONObject) (obj)).optString("_id");
        if (s.equals("baseline"))
        {
            dialoginterface = s;
        } else
        {
            dialoginterface = dialoginterface.optString("_id");
        }
        e1.a(((String) (obj)), dialoginterface, s, s1);
    }
}
