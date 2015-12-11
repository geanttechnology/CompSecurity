// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities.posting;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.abtnprojects.ambatana.models.ProductInserted;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities.posting:
//            ProductNewActivity

class a extends Handler
{

    final ProductNewActivity a;

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            super.handleMessage(message);
            return;

        case 3: // '\003'
            a.c(message.arg1);
            return;

        case 4: // '\004'
            message = message.getData();
            break;
        }
        if (message != null && message.containsKey("productInserted"))
        {
            message = ProductInserted.fromJSON(message.getString("productInserted"));
            a.a(message);
            return;
        } else
        {
            a.a(null);
            return;
        }
    }

    (ProductNewActivity productnewactivity)
    {
        a = productnewactivity;
        super();
    }
}
