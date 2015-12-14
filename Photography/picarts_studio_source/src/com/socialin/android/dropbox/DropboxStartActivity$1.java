// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.dropbox;

import android.app.Activity;
import android.view.View;
import com.socialin.android.oauth2.a;
import com.socialin.android.util.Utils;
import myobfuscated.bt.c;

// Referenced classes of package com.socialin.android.dropbox:
//            DropboxStartActivity

final class a
    implements android.view.StartActivity._cls1
{

    private DropboxStartActivity a;

    public final void onClick(View view)
    {
        if (com.socialin.android.dropbox.DropboxStartActivity.a(a) != null)
        {
            view = com.socialin.android.dropbox.DropboxStartActivity.a(a);
            com.socialin.android.oauth2.a.a(((c) (view)).h);
            Utils.c(view.getActivity());
            if (view.getActivity() != null)
            {
                view.getActivity().finish();
            }
            return;
        } else
        {
            view = a.getSharedPreferences("DropboxPrefs", 0);
            Utils.c(a.getApplicationContext());
            com.socialin.android.oauth2.a.a(view);
            return;
        }
    }

    _cls9(DropboxStartActivity dropboxstartactivity)
    {
        a = dropboxstartactivity;
        super();
    }
}
