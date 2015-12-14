// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.widget.PopupWindow;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            r

final class a
    implements Runnable
{

    private r a;

    public final void run()
    {
        try
        {
            r.e(a).dismiss();
            return;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            return;
        }
    }

    (r r1)
    {
        a = r1;
        super();
    }
}
