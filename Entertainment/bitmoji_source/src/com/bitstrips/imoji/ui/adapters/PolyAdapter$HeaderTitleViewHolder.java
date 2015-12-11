// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife;

// Referenced classes of package com.bitstrips.imoji.ui.adapters:
//            PolyAdapter

public static class  extends android.support.v7.widget.older
    implements 
{

    TextView mHeaderTitle;
    mHeaderTitle mItem;

    public void setBackground(String s)
    {
    }

    public void setImage(String s)
    {
    }

    public void setItem( )
    {
        mItem = ;
    }

    public void setTitle(String s)
    {
        byte byte0;
        mHeaderTitle.setText(s);
        s = s.toLowerCase();
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 3: default 52
    //                   -1960890269: 109
    //                   -934918565: 81
    //                   -393940263: 95;
           goto _L1 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        break MISSING_BLOCK_LABEL_109;
_L5:
        switch (byte0)
        {
        default:
            return;

        case 0: // '\0'
            mHeaderTitle.setBackgroundColor(mHeaderTitle.getContext().getResources().getColor(0x7f090075));
            return;

        case 1: // '\001'
            mHeaderTitle.setBackgroundColor(mHeaderTitle.getContext().getResources().getColor(0x7f09006a));
            return;

        case 2: // '\002'
            mHeaderTitle.setBackgroundColor(mHeaderTitle.getContext().getResources().getColor(0x7f090074));
            break;
        }
        break MISSING_BLOCK_LABEL_191;
_L3:
        if (s.equals("recent"))
        {
            byte0 = 0;
        }
          goto _L5
_L4:
        if (s.equals("popular"))
        {
            byte0 = 1;
        }
          goto _L5
        if (s.equals("theme packs"))
        {
            byte0 = 2;
        }
          goto _L5
    }

    public (View view)
    {
        super(view);
        ButterKnife.bind(this, view);
    }
}
