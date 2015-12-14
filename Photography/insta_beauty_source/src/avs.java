// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.fotoable.sketch.activity.TTieZhiActivity;
import com.fotoable.sketch.view.TTieZhiMainLibraryView;

public class avs extends BroadcastReceiver
{

    final TTieZhiActivity a;

    public avs(TTieZhiActivity ttiezhiactivity)
    {
        a = ttiezhiactivity;
        super();
    }

    public void onReceive(Context context, Intent intent)
    {
        context = intent.getAction();
        if (context != null && context.equalsIgnoreCase("ACTION_MAG_MATERIAL_SHARETOWECHAT") && intent.getBooleanExtra("sharesucceed", false))
        {
            context = intent.getStringExtra("shareInfoStyleId");
            if (context != null && context.length() > 0 && !context.equalsIgnoreCase("0"))
            {
                aqx.a(context);
            }
            a.n.reload();
        }
    }
}
