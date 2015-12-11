// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.media;

import android.support.v4.media.VolumeProviderCompat;

// Referenced classes of package android.support.v7.media:
//            MediaRouter

class val.volume
    implements Runnable
{

    final val.volume this$2;
    final int val$volume;

    public void run()
    {
        if (val.volume(_fld0) != null)
        {
            ._mth0(_fld0)._mth0(val$volume);
        }
    }

    is._cls1()
    {
        this$2 = final__pcls1;
        val$volume = I.this;
        super();
    }

    // Unreferenced inner class android/support/v7/media/MediaRouter$GlobalMediaRouter$MediaSessionRecord$1

/* anonymous class */
    class MediaRouter.GlobalMediaRouter.MediaSessionRecord._cls1 extends VolumeProviderCompat
    {

        final MediaRouter.GlobalMediaRouter.MediaSessionRecord this$1;

        public void onAdjustVolume(final int direction)
        {
            MediaRouter.GlobalMediaRouter.access$1300(this$0).post(new MediaRouter.GlobalMediaRouter.MediaSessionRecord._cls1._cls2());
        }

        public void onSetVolumeTo(int i)
        {
            MediaRouter.GlobalMediaRouter.access$1300(this$0).post(i. new MediaRouter.GlobalMediaRouter.MediaSessionRecord._cls1._cls1());
        }

            
            {
                this$1 = MediaRouter.GlobalMediaRouter.MediaSessionRecord.this;
                super(i, j, k);
            }

        // Unreferenced inner class android/support/v7/media/MediaRouter$GlobalMediaRouter$MediaSessionRecord$1$2

/* anonymous class */
        class MediaRouter.GlobalMediaRouter.MediaSessionRecord._cls1._cls2
            implements Runnable
        {

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
        }

    }

}
