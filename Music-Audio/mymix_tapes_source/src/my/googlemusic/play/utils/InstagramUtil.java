// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.ClipboardManager;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.List;
import my.googlemusic.play.application.App;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.internet.Connection;
import my.googlemusic.play.model.Album;
import my.googlemusic.play.model.Song;
import my.googlemusic.play.model.User;
import my.googlemusic.play.utils.appbar.AppBar;
import my.googlemusic.play.utils.toast.Toast;
import my.googlemusic.play.utils.toast.ToastCreator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class InstagramUtil
{

    public static final int SHARE_INSTAGRAM = 3;
    Activity mActivity;
    AppBar mAppBar;
    String mMessage;
    Server mServer;
    Song mSong;
    String mUrlImage;
    String mVideo;

    public InstagramUtil(Activity activity, Song song, AppBar appbar, String s)
    {
        mActivity = activity;
        mSong = song;
        mUrlImage = mSong.getAlbum().getImage();
        mAppBar = appbar;
        mVideo = s;
        mServer = ((App)mActivity.getApplication()).getServer();
    }

    private void copyToClipboard(String s)
    {
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            Activity activity = mActivity;
            Activity activity2 = mActivity;
            ((ClipboardManager)activity.getSystemService("clipboard")).setText(s);
            return;
        } else
        {
            Activity activity1 = mActivity;
            Activity activity3 = mActivity;
            ((android.content.ClipboardManager)activity1.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("share_body", s));
            return;
        }
    }

    private void createInstagramShareDialog(String s)
    {
        copyToClipboard(s);
        Object obj = new android.app.AlertDialog.Builder(new ContextThemeWrapper(mActivity, 0x7f0800e7));
        View view = LayoutInflater.from(mActivity).inflate(0x7f030052, null, false);
        s = (TextView)view.findViewById(0x7f0d01ce);
        ((android.app.AlertDialog.Builder) (obj)).setView(view);
        obj = ((android.app.AlertDialog.Builder) (obj)).create();
        ((Dialog) (obj)).show();
        ((Dialog) (obj)).setOnKeyListener(new _cls2(((Dialog) (obj))));
        s.setOnClickListener(new _cls3(((Dialog) (obj))));
    }

    private void generateImage()
    {
        File file = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/shared_instagram/").toString());
        if (!file.exists())
        {
            file.mkdir();
        }
        Object obj;
        FileOutputStream fileoutputstream;
        try
        {
            obj = getInputStream(mUrlImage);
        }
        catch (MalformedURLException malformedurlexception)
        {
            malformedurlexception.printStackTrace();
            return;
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            filenotfoundexception.printStackTrace();
            return;
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            return;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_163;
        }
        obj = setOverlay(Bitmap.createScaledBitmap(BitmapFactory.decodeStream(((InputStream) (obj))), 500, 500, true), Bitmap.createScaledBitmap(BitmapFactory.decodeResource(mActivity.getResources(), 0x7f020190), 500, 500, true));
        fileoutputstream = new FileOutputStream((new StringBuilder()).append(file).append("/").append("shared.png").toString());
        ((Bitmap) (obj)).compress(android.graphics.Bitmap.CompressFormat.PNG, 100, fileoutputstream);
        shareImage(Uri.fromFile(new File(file, "shared.png")));
        fileoutputstream.flush();
        fileoutputstream.close();
    }

    private Uri generateVideoThumbnail()
    {
        Object obj;
        Object obj1;
        Object obj2;
        File file;
        file = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/shared_instagram/").toString());
        if (!file.exists())
        {
            file.mkdir();
        }
        obj1 = null;
        obj2 = null;
        obj = obj1;
        Bitmap bitmap = ThumbnailUtils.createVideoThumbnail(mVideo, 1);
        obj = obj1;
        obj1 = new FileOutputStream((new StringBuilder()).append(file).append("/").append("shared.png").toString());
        bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, ((java.io.OutputStream) (obj1)));
        obj = Uri.fromFile(new File(file, "shared.png"));
        if (obj1 != null)
        {
            try
            {
                ((FileOutputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                ((IOException) (obj1)).printStackTrace();
            }
        }
        return ((Uri) (obj));
        obj;
        obj1 = obj2;
        obj2 = obj;
_L4:
        obj = obj1;
        ((FileNotFoundException) (obj2)).printStackTrace();
        if (obj1 != null)
        {
            try
            {
                ((FileOutputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
            }
        }
        return null;
        obj1;
_L2:
        if (obj != null)
        {
            try
            {
                ((FileOutputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
            }
        }
        throw obj1;
        obj2;
        obj = obj1;
        obj1 = obj2;
        if (true) goto _L2; else goto _L1
_L1:
        obj2;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private InputStream getInputStream(String s)
    {
        DefaultHttpClient defaulthttpclient = new DefaultHttpClient();
        s = new HttpGet(s);
        try
        {
            s = defaulthttpclient.execute(s);
            if (s.getStatusLine().getStatusCode() == 200)
            {
                return s.getEntity().getContent();
            }
            Log.e("log_tag", "I didn't  get the response!");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        return null;
    }

    private Bitmap setOverlay(Bitmap bitmap, Bitmap bitmap1)
    {
        Bitmap bitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Paint paint = new Paint();
        paint.setAlpha(1000);
        Canvas canvas = new Canvas(bitmap2);
        canvas.drawBitmap(bitmap, 0.0F, 0.0F, paint);
        canvas.drawBitmap(bitmap1, 0.0F, 0.0F, null);
        return bitmap2;
    }

    private void shareImage(Uri uri)
    {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("image/*");
        intent.setPackage("com.instagram.android");
        List list = mActivity.getPackageManager().queryIntentActivities(intent, 0);
        if (list != null && list.size() > 0)
        {
            intent.putExtra("android.intent.extra.STREAM", uri);
            intent.putExtra("android.intent.extra.TEXT", mMessage);
            mActivity.startActivityForResult(Intent.createChooser(intent, "Share to"), 999);
            return;
        } else
        {
            Toast.with(mActivity).message("Instagram not found").show();
            return;
        }
    }

    private void shareVideo()
    {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("video/*");
        intent.setPackage("com.instagram.android");
        Uri uri = Uri.fromFile(new File(mVideo));
        mActivity.startActivity(Intent.createChooser(intent, "Share to"));
        List list = mActivity.getPackageManager().queryIntentActivities(intent, 0);
        if (list != null && list.size() > 0)
        {
            intent.putExtra("android.intent.extra.STREAM", uri);
            intent.putExtra("android.intent.extra.TEXT", mMessage);
            mActivity.startActivityForResult(Intent.createChooser(intent, "Share to"), 999);
            return;
        } else
        {
            Toast.with(mActivity).message("Instagram not found").show();
            return;
        }
    }

    private void start()
    {
        HandlerThread handlerthread = new HandlerThread("Instagram Thread");
        handlerthread.start();
        (new Handler(handlerthread.getLooper())).post(new _cls4());
    }

    public void shareInstagram()
    {
        if (!Connection.with(mActivity).isConnected())
        {
            return;
        } else
        {
            mServer.addLike(mSong.getAlbum().getId(), mServer.getUser().getId(), 3, new _cls1());
            return;
        }
    }





    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls1 {}

}
