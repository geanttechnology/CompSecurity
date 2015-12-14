// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.widget.RadioGroup;
import com.picsart.studio.editor.view.RGBConvertView;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            g

final class a
    implements android.widget.oGroup.OnCheckedChangeListener
{

    private g a;

    public final void onCheckedChanged(RadioGroup radiogroup, int i)
    {
        if (g.b(a) == null)
        {
            return;
        }
        if (i != 0x7f10034d) goto _L2; else goto _L1
_L1:
        g.b(a).setDrawChannel(0);
_L4:
        g.b(a).invalidate();
        return;
_L2:
        if (i == 0x7f10034e)
        {
            g.b(a).setDrawChannel(1);
        } else
        if (i == 0x7f10034f)
        {
            g.b(a).setDrawChannel(2);
        } else
        if (i == 0x7f10034c)
        {
            g.b(a).setDrawChannel(3);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    rtView(g g1)
    {
        a = g1;
        super();
    }
}
