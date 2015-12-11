// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.classes;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import org.json.JSONObject;

// Referenced classes of package com.mixerbox.mixerbox3b.classes:
//            VectorOnClickListener, DJInfoVectorItem

class er extends VectorOnClickListener
{

    final DJInfoVectorItem this$0;
    final TextView val$tvFollow;

    public void onClick(View view)
    {
        if (!val$tvFollow.getText().toString().equals(ctx.getResources().getString(0x7f08014c))) goto _L2; else goto _L1
_L1:
        if (android.os.NT < 16) goto _L4; else goto _L3
_L3:
        val$tvFollow.setBackground(ctx.getResources().getDrawable(0x7f02011f));
_L5:
        val$tvFollow.setTextColor(ctx.getResources().getColor(0x7f06001d));
_L7:
        super.onClick(view);
        return;
_L4:
        val$tvFollow.setBackgroundDrawable(ctx.getResources().getDrawable(0x7f02011f));
          goto _L5
_L2:
        if (!val$tvFollow.getText().toString().equals(ctx.getResources().getString(0x7f08014d))) goto _L7; else goto _L6
_L6:
        if (android.os.NT < 16)
        {
            break MISSING_BLOCK_LABEL_179;
        }
        val$tvFollow.setBackground(ctx.getResources().getDrawable(0x7f020120));
_L8:
        val$tvFollow.setTextColor(ctx.getResources().getColor(0x7f060018));
          goto _L7
        val$tvFollow.setBackgroundDrawable(ctx.getResources().getDrawable(0x7f020120));
          goto _L8
        Exception exception;
        exception;
          goto _L7
    }

    er(JSONObject jsonobject, JSONObject jsonobject1, JSONObject jsonobject2, TextView textview)
    {
        this$0 = final_djinfovectoritem;
        val$tvFollow = textview;
        super(Context.this, jsonobject, jsonobject1, jsonobject2);
    }
}
