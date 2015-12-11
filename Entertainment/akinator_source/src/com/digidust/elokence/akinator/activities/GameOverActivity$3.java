// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import com.digidust.elokence.akinator.factories.AkLog;
import com.digidust.elokence.akinator.factories.AkSessionFactory;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import java.util.HashSet;
import java.util.Iterator;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            GameOverActivity

class this._cls0
    implements FacebookCallback
{

    final GameOverActivity this$0;

    public void onCancel()
    {
        AkLog.d("GameOverActivity", "cancel");
    }

    public void onError(FacebookException facebookexception)
    {
        AkLog.e("GameOverActivity", facebookexception.toString());
    }

    public void onSuccess(com.facebook.share.widget.esult esult)
    {
        AkLog.d("GameOverActivity", "ok");
        String s;
        for (esult = GameOverActivity.access$000(GameOverActivity.this).iterator(); esult.hasNext(); AkSessionFactory.sharedInstance().addFacebookIdForRequest(s))
        {
            s = (String)esult.next();
        }

    }

    public volatile void onSuccess(Object obj)
    {
        onSuccess((com.facebook.share.widget.esult)obj);
    }

    ()
    {
        this$0 = GameOverActivity.this;
        super();
    }
}
