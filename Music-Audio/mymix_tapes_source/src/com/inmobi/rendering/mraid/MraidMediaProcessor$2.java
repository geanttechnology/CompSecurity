// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.rendering.mraid;

import android.view.KeyEvent;
import android.view.View;

// Referenced classes of package com.inmobi.rendering.mraid:
//            MraidMediaProcessor, g

class a
    implements android.view.iaProcessor._cls2
{

    final MraidMediaProcessor a;

    public boolean onKey(View view, int i, KeyEvent keyevent)
    {
        if (4 == i && keyevent.getAction() == 0)
        {
            MraidMediaProcessor.a(a).a(true);
            return true;
        } else
        {
            return false;
        }
    }

    (MraidMediaProcessor mraidmediaprocessor)
    {
        a = mraidmediaprocessor;
        super();
    }
}
