// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.videogenerator;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.youtube.YouTubeUploadActivity;

// Referenced classes of package com.socialin.android.videogenerator:
//            SaveAndShareDialogHandler

public final class a
    implements android.view.ndShareDialogHandler._cls5
{

    private Context a;
    private SaveAndShareDialogHandler b;

    public final void onClick(View view)
    {
        view = new Intent(a, com/socialin/android/youtube/YouTubeUploadActivity);
        view.putExtra("android.intent.extra.SUBJECT", a.getString(0x7f08040c));
        view.putExtra("android.intent.extra.TEXT", a.getString(0x7f080486));
        view.putExtra("fileUri", b.i);
        a.startActivity(view);
        AnalyticUtils.getInstance(a).track((new com.socialin.android.apiv3.events.oEvent(b.r, b.t)).setDest("youtube").setType(diaType.getType(diaType.MPG)));
    }

    public diaType(SaveAndShareDialogHandler saveandsharedialoghandler, Context context)
    {
        b = saveandsharedialoghandler;
        a = context;
        super();
    }
}
