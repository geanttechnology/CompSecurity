// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.view.View;

// Referenced classes of package com.livemixtapes:
//            LazyAdapterTracks, Mixtape

class val.position
    implements android.view.
{

    final LazyAdapterTracks this$0;
    private final int val$position;

    public void onClick(View view)
    {
        try
        {
            mixTape.download(val$position);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return;
        }
    }

    ()
    {
        this$0 = final_lazyadaptertracks;
        val$position = I.this;
        super();
    }
}
