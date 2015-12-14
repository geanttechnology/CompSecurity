// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.ftue;

import android.widget.EditText;

// Referenced classes of package com.amazon.gallery.thor.ftue:
//            DesktopScreen

class this._cls0
    implements Runnable
{

    final DesktopScreen this$0;

    public void run()
    {
        if (DesktopScreen.access$700(DesktopScreen.this) == null && DesktopScreen.access$800(DesktopScreen.this) != null)
        {
            DesktopScreen.access$800(DesktopScreen.this).setText("");
        }
        DesktopScreen.access$900(DesktopScreen.this);
    }

    ()
    {
        this$0 = DesktopScreen.this;
        super();
    }
}
