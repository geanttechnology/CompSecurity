// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.view:
//            MapSliceRedesign

class val.context
    implements android.view.r
{

    final MapSliceRedesign this$0;
    final Context val$context;

    public void onClick(View view)
    {
        try
        {
            view = ((TextView)view).getText().toString();
            getContext().startActivity(Intent.createChooser(new Intent("android.intent.action.DIAL", Uri.parse(String.format("tel:%s", new Object[] {
                view
            }))), val$context.getString(0x7f080083)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            Ln.d(view, "Formatting phone number failed", new Object[0]);
        }
    }

    ()
    {
        this$0 = final_mapsliceredesign;
        val$context = Context.this;
        super();
    }
}
