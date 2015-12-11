// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.search;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.target.ui.view.a;

// Referenced classes of package com.target.ui.view.search:
//            SearchHistoryHeader

static class clearBtn extends a
{

    final Button clearBtn;
    final TextView title;

    (View view)
    {
        super(view);
        title = (TextView)view.findViewById(0x7f1005a0);
        clearBtn = (Button)view.findViewById(0x7f1005a1);
    }
}
