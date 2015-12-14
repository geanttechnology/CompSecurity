// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.clipart;

import android.app.Activity;
import android.view.View;
import com.picsart.studio.editor.item.BrushEditableItem;
import com.socialin.android.util.Utils;

// Referenced classes of package com.socialin.android.photo.clipart:
//            a

final class a
    implements android.view..OnClickListener
{

    private View a;
    private a b;

    public final void onClick(View view)
    {
        int ai[] = b.a;
        for (int i = 0; i < 5; i++)
        {
            int j = ai[i];
            a.findViewById(j).setBackgroundResource(0x7f0f0038);
        }

        com.socialin.android.photo.clipart.a.a(b).g = Utils.a(com.socialin.android.photo.clipart.a.a(((Integer)view.getTag()).intValue()), b.getActivity().getApplicationContext());
        view.setBackgroundResource(0x7f0205a1);
    }

    tableItem(a a1, View view)
    {
        b = a1;
        a = view;
        super();
    }
}
