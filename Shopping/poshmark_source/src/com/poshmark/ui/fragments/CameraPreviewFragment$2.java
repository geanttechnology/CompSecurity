// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.poshmark.ui.fragments:
//            CameraPreviewFragment

class this._cls0
    implements android.view.ewFragment._cls2
{

    final CameraPreviewFragment this$0;

    public void onClick(View view)
    {
        view = new Intent("android.intent.action.GET_CONTENT", null);
        view.setType("image/*");
        startActivityForResult(view, PICK_IMAGE);
    }

    ()
    {
        this$0 = CameraPreviewFragment.this;
        super();
    }
}
