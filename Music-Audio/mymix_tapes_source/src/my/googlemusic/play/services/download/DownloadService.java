// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.services.download;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.io.File;
import java.util.List;
import my.googlemusic.play.activities.LoginActivity;
import my.googlemusic.play.application.App;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.internet.Connection;
import my.googlemusic.play.internet.RequestCreator;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.model.Album;
import my.googlemusic.play.model.Artist;
import my.googlemusic.play.model.Song;
import my.googlemusic.play.model.User;
import my.googlemusic.play.utils.media.MediaUtils;
import my.googlemusic.play.utils.notification.Notification;
import my.googlemusic.play.utils.notification.NotificationCreator;

public class DownloadService extends Service
{

    private static final int ID_NOTIFICATION = 100;
    private List mDownloadList;
    private boolean mRunning;
    private Server mServer;

    public DownloadService()
    {
    }

    private void downloadSong(Song song)
    {
        Notification.with(this).load(100).icon(0x7f02014c).title("Downloading mixtapez").text((new StringBuilder()).append(song.getName()).append(" - ").append(song.getAlbum().getArtist().getName()).toString()).autoCancel(true).intent(PendingIntent.getActivity(this, 0, new Intent(this, my/googlemusic/play/activities/LoginActivity), 0x10000000)).show();
        File file = new File(mServer.getMusicDirectory(song), (new StringBuilder()).append(song.getName()).append(".mp3").toString());
        if (Connection.with(getApplicationContext()).request(mServer.getLinkDownloadSong()).addParam("idUser", Long.valueOf(mServer.getUser().getId())).addParam("idSong", Long.valueOf(song.getId())).addParam("quality", Integer.valueOf(mServer.getUser().getDownloadQuality())).addParam("idAlbum", Long.valueOf(song.getAlbum().getId())).into(file).progress(new my.googlemusic.play.internet.RequestCreator.OnProgressListener() {

        final DownloadService this$0;

        public void onProgress(int i)
        {
            Notification.with(DownloadService.this).load(100).info((new StringBuilder()).append(i).append("%").toString()).show();
        }

            
            {
                this$0 = DownloadService.this;
                super();
            }
    }).get().isSuccessful())
        {
            MediaUtils.scanFile(this, file.getPath());
            mServer.sendBroadcast("DOWNLOAD FINISHED");
            Notification.with(this).load(100).text("Download complete.").show();
        }
    }

    private void initData()
    {
        this;
        JVM INSTR monitorenter ;
        (new Thread(new Runnable() {

            final DownloadService this$0;

            public void run()
            {
                mDownloadList = mServer.getDownloads();
                if (!mRunning)
                {
                    initDownloadService();
                }
            }

            
            {
                this$0 = DownloadService.this;
                super();
            }
        })).start();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void initDownloadService()
    {
        this;
        JVM INSTR monitorenter ;
        (new Thread(new Runnable() {

            final DownloadService this$0;

            public void run()
            {
                mRunning = true;
                do
                {
                    if (mDownloadList.isEmpty())
                    {
                        break;
                    }
                    Song song = (Song)mDownloadList.remove(0);
                    if (!mServer.isDownloadFinished(song))
                    {
                        downloadSong(song);
                    }
                } while (true);
                mServer.sendBroadcast("DOWNLOAD COMPLETED");
                Notification.with(DownloadService.this).cancel(100);
                mRunning = false;
                stopSelf();
            }

            
            {
                this$0 = DownloadService.this;
                super();
            }
        })).start();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onCreate()
    {
        super.onCreate();
        if ((App)getApplication() != null)
        {
            mServer = ((App)getApplication()).getServer();
            return;
        } else
        {
            stopSelf();
            return;
        }
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        initData();
        return super.onStartCommand(intent, i, j);
    }



/*
    static List access$002(DownloadService downloadservice, List list)
    {
        downloadservice.mDownloadList = list;
        return list;
    }

*/




/*
    static boolean access$202(DownloadService downloadservice, boolean flag)
    {
        downloadservice.mRunning = flag;
        return flag;
    }

*/


}
