// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.groupon.view:
//            MapSlice

class this._cls0
    implements android.view.kListener
{

    final MapSlice this$0;

    public void onClick(View view)
    {
        onPhoneContainerClicked();
        try
        {
            view = ((TextView)view).getText().toString();
            getContext().startActivity(Intent.createChooser(new Intent("android.intent.action.DIAL", Uri.parse(String.format("tel:%s", new Object[] {
                view
            }))), MapSlice.access$000(MapSlice.this)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return;
        }
    }

    tener()
    {
        this$0 = MapSlice.this;
        super();
    }
}
