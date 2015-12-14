// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.videogenerator;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.socialin.android.activity.SaveToSdCardDialogActivity;
import com.socialin.android.apiv3.util.AnalyticUtils;
import myobfuscated.cv.c;

// Referenced classes of package com.socialin.android.videogenerator:
//            SaveAndShareDialogHandler

final class a
    implements android.view.ndShareDialogHandler._cls1
{

    private Activity a;
    private SaveAndShareDialogHandler b;

    public final void onClick(View view)
    {
        if (!a.isFinishing())
        {
            Intent intent = new Intent(a, com/socialin/android/activity/SaveToSdCardDialogActivity);
            c.a(intent, a);
            intent.setData(Uri.parse(b.i));
            Object obj = a.getString(0x7f0808fb);
            view = ((View) (obj));
            if (TextUtils.isEmpty(((CharSequence) (obj))))
            {
                view = a.getString(0x7f0808fb);
            }
            intent.putExtra("isReturnResult", b.q);
            intent.putExtra("subFolderName", view);
            intent.putExtra("gifPath", b.l);
            intent.putExtra("vidPath", b.k);
            intent.putExtra("videoMP4", b.h);
            if (b.p != null)
            {
                intent.putExtra("imageUrl", b.p);
            }
            obj = AnalyticUtils.getInstance(a);
            com.socialin.android.apiv3.events.oEvent oevent = (new com.socialin.android.apiv3.events.oEvent(b.r, b.t)).setDest("gallery");
            if (b.l)
            {
                view = diaType.GIF;
            } else
            {
                view = diaType.MPG;
            }
            ((AnalyticUtils) (obj)).track(oevent.setType(diaType.getType(view)));
            a.startActivityForResult(intent, 92);
        }
    }

    diaType(SaveAndShareDialogHandler saveandsharedialoghandler, Activity activity)
    {
        b = saveandsharedialoghandler;
        a = activity;
        super();
    }
}
