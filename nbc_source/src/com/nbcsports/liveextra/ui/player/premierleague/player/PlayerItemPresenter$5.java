// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nbcsports.liveextra.ui.player.premierleague.player;

import android.databinding.ObservableField;
import rx.Subscriber;
import timber.log.Timber;

// Referenced classes of package com.nbcsports.liveextra.ui.player.premierleague.player:
//            PlayerItemPresenter, PlayerSeasonStatsViewModel

class this._cls0 extends Subscriber
{

    final PlayerItemPresenter this$0;

    public void onCompleted()
    {
    }

    public void onError(Throwable throwable)
    {
        Timber.d(throwable, "", new Object[0]);
    }

    public void onNext(PlayerSeasonStatsViewModel playerseasonstatsviewmodel)
    {
        if (!hasBinder() || playerseasonstatsviewmodel == null)
        {
            return;
        } else
        {
            ((sBinder)PlayerItemPresenter.access$800(PlayerItemPresenter.this)).season.set(playerseasonstatsviewmodel);
            return;
        }
    }

    public volatile void onNext(Object obj)
    {
        onNext((PlayerSeasonStatsViewModel)obj);
    }

    odel()
    {
        this$0 = PlayerItemPresenter.this;
        super();
    }
}
