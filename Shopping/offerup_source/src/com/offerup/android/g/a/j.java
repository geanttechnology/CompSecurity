// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.a;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.offerup.android.dto.Item;

// Referenced classes of package com.offerup.android.g.a:
//            h

public final class j extends h
{

    private TextView b;

    public j()
    {
    }

    public static j a()
    {
        return new j();
    }

    protected final void a(Item item)
    {
        int i = item.getCondition();
        if (b == null) goto _L2; else goto _L1
_L1:
        TextView textview = b;
        i;
        JVM INSTR lookupswitch 6: default 76
    //                   0: 104
    //                   20: 117
    //                   40: 130
    //                   60: 143
    //                   80: 156
    //                   100: 169;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L3:
        item = getResources().getString(0x7f090127);
_L11:
        textview.setText(String.format("Condition: %s", new Object[] {
            item
        }));
_L2:
        return;
_L4:
        item = getResources().getString(0x7f090123);
        continue; /* Loop/switch isn't completed */
_L5:
        item = getResources().getString(0x7f090124);
        continue; /* Loop/switch isn't completed */
_L6:
        item = getResources().getString(0x7f090125);
        continue; /* Loop/switch isn't completed */
_L7:
        item = getResources().getString(0x7f090126);
        continue; /* Loop/switch isn't completed */
_L8:
        item = getResources().getString(0x7f090127);
        continue; /* Loop/switch isn't completed */
_L9:
        item = getResources().getString(0x7f090128);
        if (true) goto _L11; else goto _L10
_L10:
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(0x7f040089, viewgroup, false);
        b = (TextView)layoutinflater.findViewById(0x7f100203);
        return layoutinflater;
    }
}
