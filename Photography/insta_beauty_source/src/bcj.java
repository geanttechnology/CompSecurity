// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.instamag.activity.library.fragment.NewMagLibraryFragment;

public class bcj extends BroadcastReceiver
{

    final NewMagLibraryFragment a;

    public bcj(NewMagLibraryFragment newmaglibraryfragment)
    {
        a = newmaglibraryfragment;
        super();
    }

    public void onReceive(Context context, Intent intent)
    {
        context = intent.getAction();
        if (context != null && context.equalsIgnoreCase("ACTION_MAG_MATERIAL_SHARETOWECHAT"))
        {
            boolean flag = intent.getBooleanExtra("sharesucceed", false);
            intent.getIntExtra("shareInfoId", 0);
            if (flag)
            {
                context = intent.getStringExtra("shareInfoStyleId");
                if (context != null && context.length() > 0 && !context.equalsIgnoreCase("0"))
                {
                    aqx.a(context);
                }
            }
        }
    }
}
