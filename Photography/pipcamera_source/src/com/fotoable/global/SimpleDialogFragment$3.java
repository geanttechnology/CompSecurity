// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.global;

import android.widget.RelativeLayout;

// Referenced classes of package com.fotoable.global:
//            SimpleDialogFragment

class a
    implements Runnable
{

    final SimpleDialogFragment a;

    public void run()
    {
        a.d.setVisibility(0);
    }

    (SimpleDialogFragment simpledialogfragment)
    {
        a = simpledialogfragment;
        super();
    }
}
