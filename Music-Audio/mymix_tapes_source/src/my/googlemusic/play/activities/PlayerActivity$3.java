// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import my.googlemusic.play.utils.animations.AnimationInfo;

// Referenced classes of package my.googlemusic.play.activities:
//            PlayerActivity

class this._cls0
    implements Runnable
{

    final PlayerActivity this$0;

    public void run()
    {
        AnimationInfo.animationInfo(PlayerActivity.access$1000(PlayerActivity.this).infoPlays, PlayerActivity.access$1000(PlayerActivity.this).infoLikes, PlayerActivity.access$1000(PlayerActivity.this).infoComments, PlayerActivity.access$1000(PlayerActivity.this).info);
    }

    fo()
    {
        this$0 = PlayerActivity.this;
        super();
    }
}
