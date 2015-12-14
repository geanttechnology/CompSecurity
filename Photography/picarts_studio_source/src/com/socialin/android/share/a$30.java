// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.share;

import android.widget.PopupWindow;

// Referenced classes of package com.socialin.android.share:
//            a

final class a
    implements Runnable
{

    private a a;

    public final void run()
    {
        try
        {
            com.socialin.android.share.a.r(a).dismiss();
            return;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            return;
        }
    }

    on(a a1)
    {
        a = a1;
        super();
    }
}
