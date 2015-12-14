// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.videogenerator;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.picsart.studio.mp4encoder.MP4Writer;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.apiv3.model.ViewerUser;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.dialog.g;
import com.socialin.android.util.ModernAsyncTask;
import java.io.File;

// Referenced classes of package com.socialin.android.videogenerator:
//            SaveAndShareDialogHandler

final class c extends ModernAsyncTask
{

    private g a;
    private Bundle b;
    private Intent c;
    private a d;

    protected final Object doInBackground(Object aobj[])
    {
        if (d.d.l)
        {
            aobj = MP4Writer.initWithParams(b);
            for (int i = 0; i < 2; i++)
            {
                File file = new File(((MP4Writer) (aobj)).getOutputAbsolutePath());
                if (file.exists())
                {
                    file.delete();
                }
                ((MP4Writer) (aobj)).createGifMovie();
            }

        }
        c.setPackage("com.instagram.android");
        c.putExtra("android.intent.extra.STREAM", Uri.parse((new StringBuilder("file://")).append(d.d).toString()));
        c.setType(d.d);
        c.putExtra("android.intent.extra.SUBJECT", d.d.getString(0x7f0808af));
        Object obj = c;
        aobj = d.d;
        Object obj1 = d.d;
        if (((SaveAndShareDialogHandler) (aobj)).n == null || ((SaveAndShareDialogHandler) (aobj)).n.user == null)
        {
            aobj = ((Context) (obj1)).getString(0x7f0802ff).toLowerCase();
        } else
        {
            aobj = (new StringBuilder("@")).append(((SaveAndShareDialogHandler) (aobj)).n.user.username).toString();
        }
        ((Intent) (obj)).putExtra("android.intent.extra.TEXT", ((Context) (obj1)).getString(0x7f08040d, new Object[] {
            aobj
        }));
        obj = AnalyticUtils.getInstance(d.d);
        obj1 = (new com.socialin.android.apiv3.events.vent(d.d.r, d.d.t)).setDest("instagram");
        if (d.d.l)
        {
            aobj = aType.GIF;
        } else
        {
            aobj = aType.MPG;
        }
        ((AnalyticUtils) (obj)).track(((com.socialin.android.apiv3.events.vent) (obj1)).setType(aType.getType(((aType) (aobj)))));
        return null;
    }

    protected final void onPostExecute(Object obj)
    {
        super.onPostExecute((Void)obj);
        if (a.isShowing())
        {
            a.dismiss();
        }
        d.d.startActivity(c);
    }

    protected final void onPreExecute()
    {
        super.onPreExecute();
        a.show();
    }

    aType(aType atype, g g1, Bundle bundle, Intent intent)
    {
        d = atype;
        a = g1;
        b = bundle;
        c = intent;
        super();
    }

    // Unreferenced inner class com/socialin/android/videogenerator/SaveAndShareDialogHandler$3

/* anonymous class */
    final class SaveAndShareDialogHandler._cls3
        implements android.view.View.OnClickListener
    {

        final Context a;
        final String b;
        final String c;
        final SaveAndShareDialogHandler d;

        public final void onClick(View view)
        {
            view = new g(a);
            Intent intent = new Intent("android.intent.action.SEND");
            (new SaveAndShareDialogHandler._cls3._cls1(this, view, d.s.getExtras(), intent)).execute(new Void[0]);
        }

            
            {
                d = saveandsharedialoghandler;
                a = context;
                b = s;
                c = s1;
                super();
            }
    }

}
