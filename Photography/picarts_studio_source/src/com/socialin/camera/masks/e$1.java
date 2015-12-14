// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.camera.masks;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

// Referenced classes of package com.socialin.camera.masks:
//            e

final class a
    implements android.view..OnClickListener
{

    private Activity a;

    public final void onClick(View view)
    {
        a.startActivity(new Intent("android.settings.WIFI_SETTINGS"));
    }

    ner(Activity activity)
    {
        a = activity;
        super();
    }
}
