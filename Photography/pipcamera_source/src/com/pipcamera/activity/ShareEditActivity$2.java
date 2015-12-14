// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import android.view.inputmethod.InputMethodManager;
import java.util.TimerTask;

// Referenced classes of package com.pipcamera.activity:
//            ShareEditActivity

class a extends TimerTask
{

    final ShareEditActivity a;

    public void run()
    {
        ShareEditActivity shareeditactivity = a;
        ShareEditActivity shareeditactivity1 = a;
        ((InputMethodManager)shareeditactivity.getSystemService("input_method")).toggleSoftInput(0, 2);
    }

    (ShareEditActivity shareeditactivity)
    {
        a = shareeditactivity;
        super();
    }
}
