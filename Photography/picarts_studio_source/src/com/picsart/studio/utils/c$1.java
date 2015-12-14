// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

// Referenced classes of package com.picsart.studio.utils:
//            c

final class a
    implements android.view..OnClickListener
{

    private Context a;

    public final void onClick(View view)
    {
        view = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
        ((Activity)a).startActivityForResult(view, 11);
    }

    ener(Context context)
    {
        a = context;
        super();
    }
}
