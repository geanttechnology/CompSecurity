// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.media;

import android.support.v4.media.VolumeProviderCompat;

// Referenced classes of package android.support.v7.media:
//            MediaRouter

class this._cls1 extends VolumeProviderCompat
{

    final _cls1.val.volume this$1;

    public void onAdjustVolume(final int direction)
    {
        this._mth1(_fld0)._mth0(new Runnable() {

            final MediaRouter.GlobalMediaRouter.MediaSessionRecord._cls1 this$2;
            final int val$direction;

            public void run()
            {
                if (MediaRouter.GlobalMediaRouter.access$1200(this$0) != null)
                {
                    MediaRouter.GlobalMediaRouter.access$1200(this$0).requestUpdateVolume(direction);
                }
            }

            
            {
                this$2 = MediaRouter.GlobalMediaRouter.MediaSessionRecord._cls1.this;
                direction = i;
                super();
            }
        });
    }

    public void onSetVolumeTo(final int volume)
    {
        _cls2.val.direction(_fld0)._mth0(new Runnable() {

            final MediaRouter.GlobalMediaRouter.MediaSessionRecord._cls1 this$2;
            final int val$volume;

            public void run()
            {
                if (MediaRouter.GlobalMediaRouter.access$1200(this$0) != null)
                {
                    MediaRouter.GlobalMediaRouter.access$1200(this$0).requestSetVolume(volume);
                }
            }

            
            {
                this$2 = MediaRouter.GlobalMediaRouter.MediaSessionRecord._cls1.this;
                volume = i;
                super();
            }
        });
    }

    _cls2.val.direction(int i, int j, int k)
    {
        this$1 = this._cls1.this;
        super(i, j, k);
    }
}
