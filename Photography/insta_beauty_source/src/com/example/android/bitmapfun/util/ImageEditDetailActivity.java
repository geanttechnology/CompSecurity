// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.example.android.bitmapfun.util;

import android.content.Intent;
import android.net.Uri;

// Referenced classes of package com.example.android.bitmapfun.util:
//            ImageDetailActivity

public abstract class ImageEditDetailActivity extends ImageDetailActivity
{

    public ImageEditDetailActivity()
    {
    }

    protected abstract void a(Uri uri);

    public void onActivityResult(int i, int j, Intent intent)
    {
        if (j != -1) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR tableswitch 168 168: default 24
    //                   168 25;
           goto _L2 _L3
_L2:
        return;
_L3:
        a(intent.getData());
        return;
    }
}
