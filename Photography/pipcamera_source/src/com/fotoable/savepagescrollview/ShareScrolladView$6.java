// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.savepagescrollview;

import android.view.View;
import ny;

// Referenced classes of package com.fotoable.savepagescrollview:
//            ShareScrolladView

class a
    implements android.view.
{

    final ShareScrolladView a;

    public void onClick(View view)
    {
        if (ShareScrolladView.access$000(a) != view)
        {
            if (ShareScrolladView.access$000(a) != null)
            {
                ShareScrolladView.access$000(a).setSelected(false);
            }
            ShareScrolladView.access$002(a, view);
        }
        view.setSelected(true);
        if (ShareScrolladView.access$100(a) != null)
        {
            ShareScrolladView.access$100(a).a((String)view.getTag(), a);
        }
    }

    _cls9(ShareScrolladView sharescrolladview)
    {
        a = sharescrolladview;
        super();
    }
}
