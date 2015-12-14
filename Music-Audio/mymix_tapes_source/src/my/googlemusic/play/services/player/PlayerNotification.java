// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.services.player;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Target;
import my.googlemusic.play.activities.PlayerActivity;
import my.googlemusic.play.activities.RadioActivity;
import my.googlemusic.play.model.Album;
import my.googlemusic.play.model.Artist;
import my.googlemusic.play.model.Song;

public class PlayerNotification
{

    public static final String ACTION_NEXT = "my.googlemusic.play.services.player.PlayerNotification.ACTION_NEXT";
    public static final String ACTION_PLAY_PAUSE = "my.googlemusic.play.services.player.PlayerNotification.ACTION_PLAY_OR_PAUSE";
    public static final String ACTION_PREVIOUS = "my.googlemusic.play.services.player.PlayerNotification.ACTION_PREVIOUS";
    public static final String ACTION_STOP = "my.googlemusic.play.services.player.PlayerNotification.ACTION_STOP";
    private Context mContext;
    private boolean mEnabled;
    private int mIdNotification;
    private NotificationManager mNotifiManager;
    private android.support.v4.app.NotificationCompat.Builder mNotification;
    private boolean mRadio;
    private RemoteViews mRemoteView;
    private RemoteViews mRemoteViewBig;
    private Song mSong;
    public Target mTarget;

    public PlayerNotification(Context context)
    {
        mTarget = new _cls1();
        mContext = context;
        mIdNotification = 0x1b669;
        mNotifiManager = (NotificationManager)mContext.getSystemService("notification");
    }

    private void addActionToRemoveView(String s, int i)
    {
        s = new Intent(s);
        s = PendingIntent.getService(mContext, 0, s, 0x10000000);
        mRemoteView.setOnClickPendingIntent(i, s);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            mRemoteViewBig.setOnClickPendingIntent(i, s);
        }
    }

    private void updateNotification()
    {
        Notification notification = mNotification.build();
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            notification.contentView = mRemoteView;
        }
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            notification.bigContentView = mRemoteViewBig;
        }
        mNotifiManager.notify(mIdNotification, notification);
        setEnabled(true);
    }

    public Notification create(boolean flag)
    {
        mRadio = flag;
        mRemoteView = new RemoteViews(mContext.getPackageName(), 0x7f03008f);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            mRemoteViewBig = new RemoteViews(mContext.getPackageName(), 0x7f030090);
        }
        addActionToRemoveView("my.googlemusic.play.services.player.PlayerNotification.ACTION_STOP", 0x7f0d0308);
        addActionToRemoveView("my.googlemusic.play.services.player.PlayerNotification.ACTION_PLAY_OR_PAUSE", 0x7f0d030a);
        addActionToRemoveView("my.googlemusic.play.services.player.PlayerNotification.ACTION_NEXT", 0x7f0d0309);
        if (!flag)
        {
            addActionToRemoveView("my.googlemusic.play.services.player.PlayerNotification.ACTION_PREVIOUS", 0x7f0d030c);
        }
        Context context = mContext;
        Object obj;
        if (flag)
        {
            obj = my/googlemusic/play/activities/RadioActivity;
        } else
        {
            obj = my/googlemusic/play/activities/PlayerActivity;
        }
        obj = new Intent(context, ((Class) (obj)));
        ((Intent) (obj)).addFlags(0x4000000);
        ((Intent) (obj)).addFlags(0x10000000);
        obj = PendingIntent.getActivity(mContext, 0, ((Intent) (obj)), 0x10000000);
        mRemoteView.setOnClickPendingIntent(0x7f0d0306, ((PendingIntent) (obj)));
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            mRemoteViewBig.setOnClickPendingIntent(0x7f0d0306, ((PendingIntent) (obj)));
        }
        mNotification = (new android.support.v4.app.NotificationCompat.Builder(mContext)).setSmallIcon(0x7f02014d).setContentIntent(((PendingIntent) (obj))).setContentTitle("My Mixtapez").setContentText("NOW PLAYING").setWhen(System.currentTimeMillis());
        return mNotification.build();
    }

    public int getId()
    {
        return mIdNotification;
    }

    public boolean isEnabled()
    {
        return mEnabled;
    }

    public boolean isVisible()
    {
        return mRemoteView != null;
    }

    public void remove()
    {
        mSong = null;
        mRemoteView = null;
        mRemoteViewBig = null;
    }

    public void setEnabled(boolean flag)
    {
        mEnabled = flag;
    }

    public void update(Song song)
    {
        mRemoteView.setTextViewText(0x7f0d030d, song.getName());
        mRemoteView.setTextViewText(0x7f0d030e, song.getAlbum().getArtist().getName());
        mRemoteView.setViewVisibility(0x7f0d030b, 0);
        mRemoteView.setViewVisibility(0x7f0d030a, 4);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            mRemoteViewBig.setTextViewText(0x7f0d030d, song.getName());
            mRemoteViewBig.setTextViewText(0x7f0d030e, song.getAlbum().getArtist().getName());
            mRemoteViewBig.setViewVisibility(0x7f0d030b, 0);
            mRemoteViewBig.setViewVisibility(0x7f0d030a, 4);
            if (mRadio)
            {
                mRemoteViewBig.setViewVisibility(0x7f0d030c, 4);
            }
        }
        if (mSong == null || !mSong.getAlbum().getImage().equals(song.getAlbum().getImage()))
        {
            Picasso.with(mContext).load(song.getAlbum().getImage()).skipMemoryCache().into(mTarget);
        }
        mSong = song;
        updateNotification();
    }

    public void updateState(PlayerManager.State state)
    {
    /* anonymous class not found */
    class _anm2 {}

        switch (_cls2..SwitchMap.my.googlemusic.play.services.player.PlayerManager.State[state.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            mRemoteView.setImageViewResource(0x7f0d030a, 0x7f02012d);
            mRemoteView.setViewVisibility(0x7f0d0308, 0);
            mRemoteView.setViewVisibility(0x7f0d0309, 4);
            mRemoteView.setViewVisibility(0x7f0d030c, 8);
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                mRemoteViewBig.setImageViewResource(0x7f0d030a, 0x7f02012d);
            }
            updateNotification();
            return;

        case 2: // '\002'
            mRemoteView.setImageViewResource(0x7f0d030a, 0x7f02012c);
            mRemoteView.setViewVisibility(0x7f0d0308, 4);
            mRemoteView.setViewVisibility(0x7f0d0309, 0);
            mRemoteView.setViewVisibility(0x7f0d030c, 0);
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                mRemoteViewBig.setImageViewResource(0x7f0d030a, 0x7f02012c);
            }
            updateNotification();
            return;

        case 3: // '\003'
            mRemoteView.setViewVisibility(0x7f0d030a, 0);
            mRemoteView.setViewVisibility(0x7f0d030b, 4);
            mRemoteView.setViewVisibility(0x7f0d0308, 4);
            mRemoteView.setViewVisibility(0x7f0d0309, 0);
            mRemoteView.setViewVisibility(0x7f0d030c, 0);
            mRemoteView.setImageViewResource(0x7f0d030a, 0x7f02012c);
            break;
        }
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            mRemoteViewBig.setViewVisibility(0x7f0d030a, 0);
            mRemoteViewBig.setViewVisibility(0x7f0d030b, 4);
            mRemoteViewBig.setImageViewResource(0x7f0d030a, 0x7f02012c);
        }
        updateNotification();
    }





    /* member class not found */
    class _cls1 {}

}
