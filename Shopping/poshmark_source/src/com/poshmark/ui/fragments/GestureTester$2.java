// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Intent;
import android.view.View;
import com.poshmark.ui.customviews.GestureView;

// Referenced classes of package com.poshmark.ui.fragments:
//            GestureTester

class this._cls0
    implements android.view.ener
{

    final GestureTester this$0;

    public void onClick(View view)
    {
        if (!isNextClicked)
        {
            isNextClicked = true;
            view = croppable_view.getCroppedImage();
            Intent intent = new Intent();
            intent.setData(view);
            finishActivityWithResult(-1, intent);
        }
    }

    ()
    {
        this$0 = GestureTester.this;
        super();
    }
}
