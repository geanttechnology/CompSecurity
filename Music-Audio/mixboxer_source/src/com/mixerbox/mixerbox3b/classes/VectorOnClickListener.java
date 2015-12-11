// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.classes;

import android.content.Context;
import android.view.View;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.mixerbox.mixerbox3b.classes:
//            VectorOnClickHandle

public class VectorOnClickListener
    implements android.view.View.OnClickListener
{

    Context ctx;
    JSONObject j;
    JSONObject jMain;
    JSONObject jfkkk;
    String type;

    public VectorOnClickListener(Context context, JSONObject jsonobject, JSONObject jsonobject1, JSONObject jsonobject2)
    {
        ctx = context;
        j = jsonobject;
        jfkkk = jsonobject2;
        jMain = jsonobject1;
        try
        {
            if (!j.isNull("type"))
            {
                type = j.getString("type");
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
    }

    public void onClick(View view)
    {
        VectorOnClickHandle.onClick(ctx, j, jfkkk, jMain, view);
    }
}
