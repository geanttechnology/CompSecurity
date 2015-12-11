// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.scan;

import android.content.Context;
import android.hardware.Camera;
import b.a.a.b.c;
import com.target.ui.util.ai;

// Referenced classes of package com.target.ui.fragment.scan:
//            BaseScanFragment

protected class this._cls0 extends c
{

    final BaseScanFragment this$0;

    public void onPreviewFrame(byte abyte0[], Camera camera)
    {
        if (abyte0 == null)
        {
            if (!com.target.ui.fragment.scan.BaseScanFragment.c(BaseScanFragment.this))
            {
                BaseScanFragment.a(BaseScanFragment.this, true);
                ai.a(getActivity(), 0x7f0903e1);
            }
            return;
        } else
        {
            BaseScanFragment.a(BaseScanFragment.this, false);
            super.onPreviewFrame(abyte0, camera);
            return;
        }
    }

    public (Context context)
    {
        this$0 = BaseScanFragment.this;
        super(context);
    }
}
