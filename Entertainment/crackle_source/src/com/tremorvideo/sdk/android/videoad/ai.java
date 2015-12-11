// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.app.Dialog;
import android.content.Context;
import android.view.KeyEvent;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            ad, aj, ak

public class ai extends Dialog
{

    public ai(Context context)
    {
        super(context);
    }

    public static ai a(Context context)
    {
        int i = ad.q();
        if (i < 5)
        {
            return new ai(context);
        }
        if (i < 7)
        {
            return new aj(context);
        } else
        {
            return new ak(context);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 84)
        {
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }
}
