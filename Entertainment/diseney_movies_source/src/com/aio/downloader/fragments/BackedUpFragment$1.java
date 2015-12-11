// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.os.Handler;
import android.os.Message;
import android.widget.LinearLayout;
import android.widget.ListView;
import java.util.List;

// Referenced classes of package com.aio.downloader.fragments:
//            BackedUpFragment

class this._cls0 extends Handler
{

    final BackedUpFragment this$0;

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 0: // '\0'
            BackedUpFragment.access$0(BackedUpFragment.this, new sicListAdapter(BackedUpFragment.this));
            BackedUpFragment.access$1(BackedUpFragment.this).setAdapter(BackedUpFragment.access$2(BackedUpFragment.this));
            return;

        case 100: // 'd'
            break;
        }
        if (BackedUpFragment.access$3(BackedUpFragment.this).size() == 0)
        {
            BackedUpFragment.access$4(BackedUpFragment.this).setVisibility(0);
            return;
        } else
        {
            BackedUpFragment.access$4(BackedUpFragment.this).setVisibility(8);
            return;
        }
    }

    sicListAdapter()
    {
        this$0 = BackedUpFragment.this;
        super();
    }
}
