// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.widget;

import android.widget.ArrayAdapter;
import com.amazon.gallery.thor.app.authentication.AospPreferences;

// Referenced classes of package com.amazon.gallery.framework.kindle.widget:
//            DebugPopup

class this._cls0
    implements bugCallback
{

    final DebugPopup this$0;

    public void run(String s, Object obj)
    {
        s = new ArrayAdapter(context, 0x1090003);
        s.add((new StringBuilder()).append("Device uuid: ").append((new AospPreferences(context)).getDeviceUUID()).toString());
        (new android.support.v7.app.uilder(context)).setAdapter(s, null).show();
    }

    es()
    {
        this$0 = DebugPopup.this;
        super();
    }
}
