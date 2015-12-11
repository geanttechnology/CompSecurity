// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.classes.PlaylistItem;
import com.mixerbox.mixerbox3b.classes.SongItem;
import com.mixerbox.mixerbox3b.fragments.SongFragment;
import java.util.ArrayList;

// Referenced classes of package com.mixerbox.mixerbox3b.utils:
//            MixerBoxUtils

class frag extends AsyncTask
{

    Context ctx;
    SongFragment frag;
    boolean hasToGoBack;
    int playIndex;
    boolean shouldCancel;
    int type;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient Void doInBackground(String as[])
    {
        if (as[0] == null)
        {
            shouldCancel = true;
            return null;
        } else
        {
            new ArrayList();
            as = new ArrayList(MixerBoxUtils.getSongArray(as[0], frag));
            ((MainPage)ctx).arraySong = new ArrayList(as);
            shouldCancel = false;
            return null;
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
        if (!shouldCancel) goto _L2; else goto _L1
_L1:
        MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f080049), 1);
_L4:
        return;
_L2:
        if (type != 1)
        {
            break; /* Loop/switch isn't completed */
        }
        class _cls1
            implements Runnable
        {

            final MixerBoxUtils.LoadSongTask this$0;

            public void run()
            {
                frag.loadContent();
            }

            _cls1()
            {
                this$0 = MixerBoxUtils.LoadSongTask.this;
                super();
            }
        }

        ((Activity)ctx).runOnUiThread(new _cls1());
        if (((MainPage)ctx).playingPlaylist != null && ((MainPage)ctx).playingPlaylist.getPlaylistId().equals(frag.currentPlaylist.getPlaylistId()))
        {
            ((MainPage)ctx).arrayPlayingSong = new ArrayList(((MainPage)ctx).arraySong);
        }
_L5:
        if (playIndex >= 0 && ((MainPage)ctx).arraySong.size() != 0)
        {
            ((MainPage)ctx).arrayPlayingSong = new ArrayList(((MainPage)ctx).arraySong);
            ((MainPage)ctx).playingSong = (SongItem)((MainPage)ctx).arrayPlayingSong.get(0);
            ((MainPage)ctx).playingPlaylist = frag.currentPlaylist;
            ((MainPage)ctx).playingSongIndex = 0;
            class _cls3
                implements Runnable
            {

                final MixerBoxUtils.LoadSongTask this$0;

                public void run()
                {
                    ((MainPage)ctx).playMusic(true);
                }

            _cls3()
            {
                this$0 = MixerBoxUtils.LoadSongTask.this;
                super();
            }
            }

            ((Activity)ctx).runOnUiThread(new _cls3());
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        class _cls2
            implements Runnable
        {

            final MixerBoxUtils.LoadSongTask this$0;

            public void run()
            {
                frag.loadContent();
            }

            _cls2()
            {
                this$0 = MixerBoxUtils.LoadSongTask.this;
                super();
            }
        }

        ((Activity)ctx).runOnUiThread(new _cls2());
        if (((MainPage)ctx).playingPlaylist != null && ((MainPage)ctx).playingPlaylist.getPlaylistId().equals(frag.currentPlaylist.getPlaylistId()))
        {
            ((MainPage)ctx).arrayPlayingSong = new ArrayList(((MainPage)ctx).arraySong);
        }
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
    }

    protected transient void onProgressUpdate(Integer ainteger[])
    {
        super.onProgressUpdate(ainteger);
    }

    protected volatile void onProgressUpdate(Object aobj[])
    {
        onProgressUpdate((Integer[])aobj);
    }

    public _cls2(Context context, boolean flag, int i, int j, SongFragment songfragment)
    {
        ctx = context;
        hasToGoBack = flag;
        type = i;
        playIndex = j;
        shouldCancel = false;
        frag = songfragment;
    }
}
