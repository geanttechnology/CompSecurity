// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle;

import android.os.Bundle;
import com.cyberlink.beautycircle.model.BCTileImage;
import com.facebook.widget.FacebookDialog;
import com.perfectcorp.utility.e;

// Referenced classes of package com.cyberlink.beautycircle:
//            BaseFbActivity

class a
    implements com.facebook.widget.llback
{

    final BaseFbActivity a;

    public void onComplete(com.facebook.widget.ndingCall ndingcall, Bundle bundle)
    {
        if (FacebookDialog.getNativeDialogDidComplete(bundle))
        {
            if (FacebookDialog.getNativeDialogCompletionGesture(bundle) == null || "cancel".equals(FacebookDialog.getNativeDialogCompletionGesture(bundle)))
            {
                e.b(new Object[] {
                    "FB dialog cancel"
                });
                a.t();
            } else
            {
                ndingcall = FacebookDialog.getNativeDialogPostId(bundle);
                e.b(new Object[] {
                    (new StringBuilder()).append("FB post id :").append(ndingcall).toString()
                });
                if (a.n != null)
                {
                    BCTileImage.a(a.n);
                }
                a.s();
            }
        } else
        {
            e.b(new Object[] {
                "FB dialog cancel"
            });
            a.t();
        }
        a.n = null;
    }

    public void onError(com.facebook.widget.ndingCall ndingcall, Exception exception, Bundle bundle)
    {
        e.e(new Object[] {
            exception
        });
        a.n = null;
    }

    ll(BaseFbActivity basefbactivity)
    {
        a = basefbactivity;
        super();
    }
}
