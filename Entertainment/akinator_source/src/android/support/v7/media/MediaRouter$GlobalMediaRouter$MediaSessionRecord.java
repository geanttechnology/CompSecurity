// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.media;

import android.support.v4.media.VolumeProviderCompat;
import android.support.v4.media.session.MediaSessionCompat;

// Referenced classes of package android.support.v7.media:
//            MediaRouter

private final class mMsCompat
{

    private int mControlType;
    private int mMaxVolume;
    private final MediaSessionCompat mMsCompat;
    private VolumeProviderCompat mVpCompat;
    final mMsCompat this$0;

    public void clearVolumeHandling()
    {
        mMsCompat.setPlaybackToLocal(mMsCompat(this._cls0.this).ream);
        mVpCompat = null;
    }

    public void configureVolume(int i, int j, int k)
    {
        if (mVpCompat != null && i == mControlType && j == mMaxVolume)
        {
            mVpCompat.setCurrentVolume(k);
            return;
        } else
        {
            mVpCompat = new VolumeProviderCompat(i, j, k) {

                final MediaRouter.GlobalMediaRouter.MediaSessionRecord this$1;

                public void onAdjustVolume(int l)
                {
                    MediaRouter.GlobalMediaRouter.access$1300(this$0).post(l. new Runnable() {

                        final _cls1 this$2;
                        final int val$direction;

                        public void run()
                        {
                            if (MediaRouter.GlobalMediaRouter.access$1200(this$0) != null)
                            {
                                MediaRouter.GlobalMediaRouter.access$1200(this$0).requestUpdateVolume(direction);
                            }
                        }

            
            {
                this$2 = final__pcls1;
                direction = I.this;
                super();
            }
                    });
                }

                public void onSetVolumeTo(int l)
                {
                    MediaRouter.GlobalMediaRouter.access$1300(this$0).post(l. new Runnable() {

                        final _cls1 this$2;
                        final int val$volume;

                        public void run()
                        {
                            if (MediaRouter.GlobalMediaRouter.access$1200(this$0) != null)
                            {
                                MediaRouter.GlobalMediaRouter.access$1200(this$0).requestSetVolume(volume);
                            }
                        }

            
            {
                this$2 = final__pcls1;
                volume = I.this;
                super();
            }
                    });
                }

            
            {
                this$1 = MediaRouter.GlobalMediaRouter.MediaSessionRecord.this;
                super(i, j, k);
            }
            };
            mMsCompat.setPlaybackToRemote(mVpCompat);
            return;
        }
    }

    public android.support.v4.media.session.t getToken()
    {
        return mMsCompat.getSessionToken();
    }

    public _cls1.this._cls1(Object obj)
    {
        this$0 = this._cls0.this;
        super();
        mMsCompat = MediaSessionCompat.obtain(mMsCompat(mMsCompat.this), obj);
    }
}
