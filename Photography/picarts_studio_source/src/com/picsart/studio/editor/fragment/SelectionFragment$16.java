// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import com.socialin.android.photo.select.SelectionDrawController;
import com.socialin.android.photo.select.j;
import com.socialin.android.util.Utils;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            SelectionFragment

final class a
    implements android.widget.ectedListener
{

    private SelectionFragment a;

    public final void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        byte byte0 = 10;
        i;
        JVM INSTR tableswitch 0 5: default 44
    //                   0 166
    //                   1 148
    //                   2 130
    //                   3 112
    //                   4 94
    //                   5 77;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        i = byte0;
_L9:
        adapterview = SelectionFragment.p(a).q;
        view = a.getActivity();
        adapterview.a(Utils.a(i, view));
        return;
_L7:
        SelectionFragment.M(a).setImageResource(0x7f020255);
        i = 5;
        continue; /* Loop/switch isn't completed */
_L6:
        SelectionFragment.M(a).setImageResource(0x7f020255);
        i = 8;
        continue; /* Loop/switch isn't completed */
_L5:
        SelectionFragment.M(a).setImageResource(0x7f020256);
        i = 15;
        continue; /* Loop/switch isn't completed */
_L4:
        SelectionFragment.M(a).setImageResource(0x7f02025b);
        i = 20;
        continue; /* Loop/switch isn't completed */
_L3:
        SelectionFragment.M(a).setImageResource(0x7f020257);
        i = 25;
        continue; /* Loop/switch isn't completed */
_L2:
        SelectionFragment.M(a).setImageResource(0x7f020258);
        i = 30;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public final void onNothingSelected(AdapterView adapterview)
    {
    }

    r(SelectionFragment selectionfragment)
    {
        a = selectionfragment;
        super();
    }
}
