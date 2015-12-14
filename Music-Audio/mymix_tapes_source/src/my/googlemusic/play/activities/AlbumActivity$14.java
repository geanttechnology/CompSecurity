// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.widget.ImageButton;
import my.googlemusic.play.utils.animations.AnimationFAB;

// Referenced classes of package my.googlemusic.play.activities:
//            AlbumActivity

class this._cls0
    implements Runnable
{

    final AlbumActivity this$0;

    public void run()
    {
        buttonFAB.setVisibility(0);
        AnimationFAB.buttonFadeInCenter(buttonFAB, 300);
    }

    B()
    {
        this$0 = AlbumActivity.this;
        super();
    }
}
