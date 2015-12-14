// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            s

final class a
    implements android.view..OnClickListener
{

    private s a;

    private void a(boolean flag)
    {
        CompoundButton compoundbutton = (CompoundButton)s.a(a).findViewById(0x7f10018d);
        CompoundButton compoundbutton1 = (CompoundButton)s.a(a).findViewById(0x7f10018e);
        if (compoundbutton != null && compoundbutton1 != null)
        {
            boolean flag1;
            if (!flag)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            compoundbutton.setChecked(flag1);
            compoundbutton1.setChecked(flag);
        }
    }

    public final void onClick(View view)
    {
        int i = view.getId();
        if (i == 0x7f10018b)
        {
            s.b(a);
        } else
        {
            if (i == 0x7f100136)
            {
                s.c(a);
                return;
            }
            if (i == 0x7f10018c)
            {
                s.d(a);
                return;
            }
            if (i == 0x7f10018e)
            {
                a(true);
                s.a(a, com.picsart.effectnew.BrushNew.BrushDrawMode.ERASE);
                return;
            }
            if (i == 0x7f10018d)
            {
                a(false);
                s.a(a, com.picsart.effectnew.BrushNew.BrushDrawMode.DRAW);
                return;
            }
        }
    }

    hDrawMode(s s1)
    {
        a = s1;
        super();
    }
}
