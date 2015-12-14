// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.servers;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.preference.PreferenceManager;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.util.SparseArray;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import my.googlemusic.play.application.App;
import my.googlemusic.play.databases.DatabaseHelper;
import my.googlemusic.play.interfaces.Database;
import my.googlemusic.play.interfaces.DatabaseCallback;
import my.googlemusic.play.interfaces.LikeHitCallback;
import my.googlemusic.play.interfaces.SearchCallback;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.internet.Connection;
import my.googlemusic.play.internet.RequestCreator;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.model.Album;
import my.googlemusic.play.model.Artist;
import my.googlemusic.play.model.Comment;
import my.googlemusic.play.model.Song;
import my.googlemusic.play.model.User;
import my.googlemusic.play.utils.TinyDB;
import my.googlemusic.play.utils.encryption.CryptLib;
import my.googlemusic.play.utils.toast.Toast;
import my.googlemusic.play.utils.toast.ToastCreator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package my.googlemusic.play.servers:
//            LinkBuilder

public class ServerHelper
    implements Server
{

    static final boolean $assertionsDisabled;
    public static final int COMMENT = 1;
    private static final String ENCRYPTION_KEY = "9FwoqrxUVP2A9kkCnLdQv24xDrmQNCox";
    public static final int FAVORITE = 3;
    public static final int FOLLOW = 4;
    private static final int ID_ADD_FRIEND = 37;
    private static final int ID_ALBUM_URL = 78;
    private static final int ID_BADGE_EDIT = 71;
    private static final int ID_COMMENT_REPORT = 20;
    private static final int ID_DELETE_COMMENT = 23;
    private static final int ID_DOWNLOAD_REMOVE = 35;
    private static final int ID_DOWNLOAD_SONG = 3;
    private static final int ID_DO_HIT = 49;
    private static final int ID_EDIT_USER = 53;
    private static final int ID_FAVORITE = 19;
    private static final int ID_FAVORITE_REMOVE = 21;
    private static final int ID_FORGOT_PASSWORD = 52;
    private static final int ID_GET_ALBUM = 1;
    private static final int ID_GET_ALBUMS = 67;
    private static final int ID_GET_BADGE = 64;
    private static final int ID_GET_BADGE_LIST = 63;
    private static final int ID_GET_COMMENTS = 24;
    private static final int ID_GET_FEATURE = 4;
    private static final int ID_GET_FEED = 39;
    private static final int ID_GET_IMAGE = 8;
    private static final int ID_GET_JUST_ADDED = 5;
    private static final int ID_GET_NOTIFICATION = 57;
    private static final int ID_GET_PREMIUM = 54;
    private static final int ID_GET_PROFILE = 43;
    private static final int ID_GET_PROFILE_FEED = 44;
    private static final int ID_GET_REPLAYS = 46;
    private static final int ID_GET_SEARCH = 6;
    private static final int ID_GET_SINGLES = 12;
    private static final int ID_GET_SONGS_LIST = 11;
    private static final int ID_GET_UPCOMING = 9;
    private static final int ID_GET_USER_IMAGE = 61;
    private static final int ID_GET_VERSION = 68;
    private static final int ID_GET_VIDEO_IMAGE = 30;
    private static final int ID_GET_VIDEO_LIST = 28;
    private static final int ID_GET_VIDEO_STREAM = 29;
    private static final int ID_LIKE = 10;
    private static final int ID_LOGIN = 50;
    private static final int ID_PREMIUM_GET_PASS = 56;
    private static final int ID_PREMIUM_SEND_PASS = 55;
    private static final int ID_PRE_DOWNLOAD_SONG = 36;
    private static final int ID_PROFILE_ARTIST_IMAGE = 75;
    private static final int ID_PROFILE_FAVORITES = 74;
    private static final int ID_PROFILE_FOLLOWERS = 41;
    private static final int ID_PROFILE_FOLLOWING = 42;
    private static final int ID_PROMO_CODE = 70;
    private static final int ID_RADIO = 33;
    private static final int ID_RECOMMENDED_USER = 48;
    private static final int ID_REGISTER = 51;
    private static final int ID_REGISTER_GOOGLE = 62;
    private static final int ID_REMOVE_FRIEND = 38;
    private static final int ID_REQUEST_STORE = 76;
    private static final int ID_SEARCH_USER = 47;
    private static final int ID_SEND_COMMENT = 22;
    private static final int ID_SET_NOTIFICATION = 58;
    private static final int ID_SONG_VOTE = 45;
    private static final int ID_STREAMING_SONG = 2;
    private static final int ID_UPLOAD_IMAGE_USER = 60;
    public static final int INSTAGRAM = 6;
    private static final String LAST_DATE = "1447694467473";
    public static final int LIKE = 2;
    public static final String QUALITY_500x500 = "500x500.jpg";
    public static final int REPLY = 5;
    private static final String URL_SERVER_MAIN = "http://107.161.177.131:8000/?version=6&phonetype=1";
    private static final String URL_SERVER_SECONDARY = "http://184.171.253.139:8001/?version=6&phonetype=1";
    private static ServerHelper instance;
    public static final String searchAlbumUrl = "http://api.mymixtapez.vuziqsrv.com/Api/Album2/Search2?";
    public static final String searchArtistUrl = "http://api.mymixtapez.vuziqsrv.com/Api/Artist/Search?";
    public static final String searchTrackUrl = "http://api.mymixtapez.vuziqsrv.com/Api/Sound/Search2?";
    private Context context;
    private Database database;
    private Handler handler;
    private String hitListPreferenceName;
    private SparseArray links;
    private Handler mainHandler;
    private Runnable mainRunnable;

    private ServerHelper(Context context1)
    {
        hitListPreferenceName = "songIdList";
        HandlerThread handlerthread = new HandlerThread("server");
        handlerthread.start();
        android.os.Looper looper = handlerthread.getLooper();
        if (!$assertionsDisabled && looper == null)
        {
            throw new AssertionError();
        } else
        {
            handler = new Handler(handlerthread.getLooper());
            links = new SparseArray();
            context = context1.getApplicationContext();
            database = DatabaseHelper.with(context1);
            mainHandler = new Handler(context1.getMainLooper());
            database.open();
            LinkBuilder.with(this);
            return;
        }
    }

    private void addAlbum(Album album)
    {
        try
        {
            database.addAlbum(album.getId(), album.getName(), album.getArtist().getId(), album.getHits(), album.getLikes(), album.getCommentsCount(), album.isBiggerFeatures(), album.isBiggerJustAdded(), album.isBiggerSingles(), album.isRestricted(), 0L, album.getLink(), album.isHidden(), album.isFeature(), album.isJustAdded(), album.isSingle(), album.getFeatureOrder(), album.getSingleOrder(), album.isActive(), album.isDeleted(), album.isDownload());
            getAlbum(album.getId());
            System.out.println();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Album album)
        {
            album.printStackTrace();
        }
    }

    private void addArtist(Artist artist)
    {
        try
        {
            database.addArtist(artist.getId(), artist.getName(), artist.getTwitter(), artist.getInstagram(), artist.getDescription());
            database.getArtist(artist.getId());
            System.out.println();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Artist artist)
        {
            artist.printStackTrace();
        }
    }

    private void addSong(Song song, long l)
    {
        try
        {
            database.addSong(song.getId(), song.getName(), l, song.isBit96(), song.isBit160(), song.getHits(), song.isActive());
            database.getSong(song.getId());
            System.out.println();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Song song)
        {
            song.printStackTrace();
        }
    }

    private void addSongsToDownload(List list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            Song song = (Song)list.get(i);
            Album album = song.getAlbum();
            addArtist(song.getAlbum().getArtist());
            addAlbum(album);
            addSong(song, album.getId());
        }

    }

    private void checkLastDabbSong()
    {
        String s = App.getPreferences().getString("dabb_song", null);
        if (s != null)
        {
            (new File(s)).delete();
        }
    }

    private File getMusicDirectory(String s, String s1, String s2)
    {
        if (!"mounted".equals(Environment.getExternalStorageState()))
        {
            s1 = null;
        } else
        {
            s2 = new File(Environment.getExternalStoragePublicDirectory("My Mixtapez"), (new StringBuilder()).append(s1).append(" - ").append(s2).toString());
            s1 = s2;
            if (!s2.exists())
            {
                s1 = s2;
                if (s2.mkdirs())
                {
                    Log.d("Music", (new StringBuilder()).append("Diretorio criado para musica ").append(s).toString());
                    return s2;
                }
            }
        }
        return s1;
    }

    private String[] getWebPlayerInfo(String s)
    {
        String as[] = new String[2];
        String as1[] = s.split(System.getProperty("line.separator"));
        int j = as1.length;
        int i = 0;
        do
        {
label0:
            {
                s = as;
                if (i < j)
                {
                    s = as1[i];
                    if (!s.contains("name=\"androidMymixtpz\""))
                    {
                        break label0;
                    }
                    s = s.substring(s.indexOf("{") + 1, s.indexOf("}")).split(";");
                }
                return s;
            }
            i++;
        } while (true);
    }

    private void onCallback(my.googlemusic.play.interfaces.Server.Callback callback, int i)
    {
        mainHandler.post(new _cls62(callback, i));
    }

    private void onCallback(my.googlemusic.play.interfaces.Server.Callback callback, Object obj)
    {
        mainHandler.post(new _cls61(obj, callback));
    }

    private void onDatabaseCallback(DatabaseCallback databasecallback, Object obj)
    {
        mainHandler.post(new _cls60(databasecallback, obj));
    }

    private void populateDatabase(my.googlemusic.play.interfaces.Server.Callback callback)
    {
        Object obj;
        Object obj1;
        Object obj4;
        SharedPreferences sharedpreferences;
        sharedpreferences = PreferenceManager.getDefaultSharedPreferences(context);
        obj1 = sharedpreferences.getString("lastDate", "1447694467473");
        obj = obj1;
        obj4 = new File(context.getFilesDir(), "database.txt");
        obj1 = Connection.with(context).request(getLink(67)).addParam("Date", obj1).addParam("phonetype", Integer.valueOf(1)).into(((File) (obj4))).get();
        if (!((Response) (obj1)).isSuccessful()) goto _L2; else goto _L1
_L1:
        Object obj2;
        Object obj3;
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        BufferedReader bufferedreader = new BufferedReader(new FileReader(((File) (obj4))));
        int i = 0;
_L4:
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        if (bufferedreader.readLine() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        bufferedreader = new BufferedReader(new FileReader(((File) (obj4))));
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        database.beginTransaction();
        float f = 0.0F;
_L21:
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        obj4 = bufferedreader.readLine();
        if (obj4 == null) goto _L6; else goto _L5
_L5:
        f++;
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        String as[] = ((String) (obj4)).split("\t");
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        System.out.printf((new StringBuilder()).append("").append(Long.parseLong(as[0])).append(" -  total ").append(as.length).toString(), new Object[0]);
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        database.editArtist(Long.parseLong(as[4]), as[2], as[3], as[28], as[29]);
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        Database database1 = database;
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        long l2 = Long.parseLong(as[0]);
        String s;
        s = as[1];
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        long l3 = Long.parseLong(as[4]);
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        int j;
        long l;
        long l1;
        long l4;
        long l5;
        long l6;
        long l7;
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        boolean flag6;
        boolean flag7;
        if (as[5].equals(""))
        {
            obj4 = "0";
        } else
        {
            obj4 = as[5];
        }
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        l4 = Long.parseLong(((String) (obj4)));
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        if (as[6].equals(""))
        {
            obj4 = "0";
        } else
        {
            obj4 = as[6];
        }
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        l5 = Long.parseLong(((String) (obj4)));
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        l6 = Long.parseLong(as[18]);
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        flag = as[9].toLowerCase().equals("true");
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        flag1 = as[10].toLowerCase().equals("true");
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        flag2 = as[11].toLowerCase().equals("true");
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        flag3 = as[21].toLowerCase().equals("true");
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        l7 = Long.parseLong(as[19]);
        obj4 = as[22];
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        flag4 = as[17].toLowerCase().equals("true");
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        flag5 = as[8].toLowerCase().equals("true");
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        flag6 = as[17].toLowerCase().equals("true");
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        flag7 = as[15].toLowerCase().equals("true");
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        if (!as[7].toLowerCase().equals("null")) goto _L8; else goto _L7
_L7:
        l = -1L;
_L14:
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        if (!as[20].toLowerCase().equals("null")) goto _L10; else goto _L9
_L9:
        l1 = -1L;
_L15:
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        database1.editAlbum(l2, s, l3, l4, l5, l6, flag, flag1, flag2, flag3, l7, ((String) (obj4)), flag4, flag5, flag6, flag7, l, l1, as[16].toLowerCase().equals("true"), as[27].toLowerCase().equals("true"), as[26].toLowerCase().equals("true"));
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        database.deleteRelated(Long.parseLong(as[0]));
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        if (as[30].equals("null")) goto _L12; else goto _L11
_L11:
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        obj4 = as[30].split("\\|");
        j = 0;
_L13:
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        if (j >= obj4.length)
        {
            break; /* Loop/switch isn't completed */
        }
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        database.editArtist(Long.parseLong(obj4[j]), obj4[j + 1], obj4[j + 2], obj4[j + 3], obj4[j + 4]);
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        database.addRelated(Long.parseLong(as[0]), Long.parseLong(obj4[j]), true);
        j += 5;
        if (true) goto _L13; else goto _L12
_L8:
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        l = Long.parseLong(as[7]);
          goto _L14
_L10:
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        l1 = Long.parseLong(as[20]);
          goto _L15
_L12:
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        database.addRelated(Long.parseLong(as[0]), Long.parseLong(as[4]), false);
        j = 31;
_L17:
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        if (j >= as.length)
        {
            break; /* Loop/switch isn't completed */
        }
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        database.editSong(Long.parseLong(as[j]), as[j + 1], Long.parseLong(as[0]), as[j + 3].toLowerCase().equals("true"), as[j + 5].toLowerCase().equals("true"), Long.parseLong(as[j + 4]), as[j + 6].toLowerCase().equals("true"));
        j += 7;
        if (true) goto _L17; else goto _L16
_L6:
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        System.out.println((new StringBuilder()).append("app: my.googlemusic.play  ################# ").append(i).append(" Albums updated!!!").toString());
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        database.setTransactionSuccessful();
        try
        {
            database.endTransaction();
            obj1 = sharedpreferences.edit();
            ((android.content.SharedPreferences.Editor) (obj1)).putString("lastDate", obj.toString());
            ((android.content.SharedPreferences.Editor) (obj1)).apply();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            ((Exception) (obj1)).printStackTrace();
        }
_L18:
        onCallback(callback, obj);
        return;
        obj3;
        obj = obj2;
        obj2 = new Response(5, "Database text file not found.");
        obj1 = obj2;
        ((FileNotFoundException) (obj3)).printStackTrace();
        database.endTransaction();
        obj = sharedpreferences.edit();
        ((android.content.SharedPreferences.Editor) (obj)).putString("lastDate", obj2.toString());
        ((android.content.SharedPreferences.Editor) (obj)).apply();
        obj = obj2;
          goto _L18
        obj;
        ((Exception) (obj)).printStackTrace();
        obj = obj2;
          goto _L18
        obj4;
        obj = obj3;
        obj2 = new Response(4, "Database text file not found.");
        obj1 = obj2;
        ((IOException) (obj4)).printStackTrace();
        database.endTransaction();
        obj = sharedpreferences.edit();
        ((android.content.SharedPreferences.Editor) (obj)).putString("lastDate", obj2.toString());
        ((android.content.SharedPreferences.Editor) (obj)).apply();
        obj = obj2;
          goto _L18
        obj;
        ((Exception) (obj)).printStackTrace();
        obj = obj2;
          goto _L18
        callback;
_L19:
        try
        {
            database.endTransaction();
            obj = sharedpreferences.edit();
            ((android.content.SharedPreferences.Editor) (obj)).putString("lastDate", obj1.toString());
            ((android.content.SharedPreferences.Editor) (obj)).apply();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
        }
        throw callback;
_L2:
        obj = obj1;
          goto _L18
        callback;
        obj1 = obj;
          goto _L19
_L16:
        obj = as[23];
        if (true) goto _L21; else goto _L20
_L20:
    }

    private void synchronizeDownloads()
    {
        Object obj;
        File afile[];
        obj = PreferenceManager.getDefaultSharedPreferences(context);
        if (((SharedPreferences) (obj)).getBoolean("syncDownloads", false) || !"mounted".equals(Environment.getExternalStorageState()))
        {
            break MISSING_BLOCK_LABEL_515;
        }
        Toast.with(context).message("Exporting downloads from /my_music/ to /My Mixtapez/").show();
        afile = Environment.getExternalStoragePublicDirectory("my_music").listFiles();
        if (afile == null) goto _L2; else goto _L1
_L1:
        int i;
        int k;
        k = afile.length;
        i = 0;
_L3:
        File afile2[];
        if (i >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        File file = afile[i];
        if (!file.isDirectory())
        {
            break MISSING_BLOCK_LABEL_269;
        }
        afile2 = file.listFiles(new _cls5());
        int i1;
        database.beginTransaction();
        i1 = afile2.length;
        int j;
        File afile1[];
        File file1;
        Object obj1;
        Object obj2;
        int l;
        for (j = 0; j >= i1; j++)
        {
            break MISSING_BLOCK_LABEL_251;
        }

        obj1 = afile2[j];
        obj2 = database.getSong(((File) (obj1)).getName().replace(".mp3", ""), ((File) (obj1)).getParentFile().getName());
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_516;
        }
        obj2 = new File(getMusicDirectory(((Song) (obj2))), (new StringBuilder()).append(((Song) (obj2)).getName()).append(".mp3").toString());
        if (((File) (obj1)).renameTo(((File) (obj2))))
        {
            System.out.println((new StringBuilder()).append("M\372sica exportada para: ").append(((File) (obj2)).getAbsolutePath()).toString());
        }
        break MISSING_BLOCK_LABEL_516;
        database.setTransactionSuccessful();
        database.endTransaction();
        i++;
        if (true) goto _L3; else goto _L2
        obj;
        database.endTransaction();
        throw obj;
_L2:
        afile1 = Environment.getExternalStoragePublicDirectory("My Mixtapez").listFiles();
        if (afile1 == null) goto _L5; else goto _L4
_L4:
        l = afile1.length;
        i = 0;
_L6:
        if (i >= l)
        {
            break; /* Loop/switch isn't completed */
        }
        file1 = afile1[i];
        if (!file1.isDirectory())
        {
            break MISSING_BLOCK_LABEL_470;
        }
        file1 = file1.listFiles(new _cls6());
        database.beginTransaction();
        i1 = file1.length;
        for (j = 0; j >= i1; j++)
        {
            break MISSING_BLOCK_LABEL_452;
        }

        obj1 = file1[j];
        obj1 = database.getSong(((File) (obj1)).getName().replace(".mp3", ""), ((File) (obj1)).getParentFile().getName().split(" - ")[0]);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_525;
        }
        if (!database.isDownloaded(((Song) (obj1)).getId()))
        {
            database.addDownloads(((Song) (obj1)).getId());
        }
        break MISSING_BLOCK_LABEL_525;
        database.setTransactionSuccessful();
        database.endTransaction();
        i++;
        if (true) goto _L6; else goto _L5
        obj;
        database.endTransaction();
        throw obj;
_L5:
        obj = ((SharedPreferences) (obj)).edit();
        ((android.content.SharedPreferences.Editor) (obj)).putBoolean("syncDownloads", true);
        ((android.content.SharedPreferences.Editor) (obj)).apply();
    }

    public static ServerHelper with(Context context1)
    {
        if (!(context1 instanceof App))
        {
            return null;
        }
        if (instance == null)
        {
            instance = new ServerHelper(context1);
        }
        return instance;
    }

    public void addComment(Comment comment, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        Object obj = Connection.with(context).request(getLink(22)).addParam("text", comment.getMessage().replace("#", "%23").replace("&", "%26")).addParam("idUser", Long.valueOf(comment.getUser().getId())).addParam("idAlbum", Long.valueOf(comment.getAlbumId())).get();
        comment = new ArrayList();
        if (((Response) (obj)).isSuccessful())
        {
            try
            {
                obj = (new JSONObject(((Response) (obj)).getContent())).getJSONObject("Response");
                comment.add(Long.valueOf(((JSONObject) (obj)).getLong("Id")));
                comment.add(Long.valueOf(((JSONObject) (obj)).getLong("CommentId")));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                comment = new Response(8, ((JSONException) (obj)).getMessage());
                ((JSONException) (obj)).printStackTrace();
            }
        } else
        {
            comment = ((Comment) (obj));
        }
        onCallback(callback, comment);
    }

    public void addDownload(List list, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls31(list, callback));
    }

    public void addDownload(Song song, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        ArrayList arraylist = new ArrayList(1);
        arraylist.add(song);
        addDownload(((List) (arraylist)), callback);
    }

    public void addFavorite(Song song, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls30(song, callback));
    }

    public void addFriend(long l, long l1, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls44(l, l1, callback));
    }

    public void addHit(long l, long l1)
    {
        handler.post(new _cls51(l, l1));
    }

    public void addLike(long l, long l1, int i, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls52(l, l1, i, callback));
    }

    public void addReply(Comment comment, long l, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        Object obj = Connection.with(context).request(getLink(22)).addParam("idUser", Long.valueOf(comment.getUser().getId())).addParam("text", comment.getMessage()).addParam("idReply", Long.valueOf(l)).addParam("idAlbum", Long.valueOf(comment.getAlbumId())).get();
        comment = new ArrayList();
        if (((Response) (obj)).isSuccessful())
        {
            try
            {
                obj = (new JSONObject(((Response) (obj)).getContent())).getJSONObject("Response");
                comment.add(Long.valueOf(((JSONObject) (obj)).getLong("Id")));
                comment.add(Long.valueOf(((JSONObject) (obj)).getLong("CommentId")));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                comment = new Response(8, ((JSONException) (obj)).getMessage());
                ((JSONException) (obj)).printStackTrace();
            }
        } else
        {
            comment = ((Comment) (obj));
        }
        onCallback(callback, comment);
    }

    public void addSongInHitList(long l)
    {
        if (context == null)
        {
            throw new NullPointerException("Server context == null in 'addSongInHitList()'");
        } else
        {
            TinyDB tinydb = TinyDB.getInstance(context);
            ArrayList arraylist = tinydb.getListInt(hitListPreferenceName);
            ArrayList arraylist1 = new ArrayList();
            arraylist1.addAll(arraylist);
            arraylist1.add(Integer.valueOf((int)l));
            tinydb.putListInt(hitListPreferenceName, arraylist1);
            return;
        }
    }

    public void changeBadge(int i)
    {
        database.editBadge(i);
    }

    public void changeBio(String s, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls16(s, callback));
    }

    public void changeEmail(String s, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls13(s, callback));
    }

    public void changeInstagram(String s, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls15(s, callback));
    }

    public void changeName(String s, String s1, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls11(s, s1, callback));
    }

    public void changePassword(String s, String s1, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls14(s, s1, callback));
    }

    public void changeUsername(String s, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls12(s, callback));
    }

    public void clearSongHitPreferences()
    {
        Object obj = Calendar.getInstance();
        System.out.println((new StringBuilder()).append("Current time => ").append(((Calendar) (obj)).getTime()).toString());
        obj = (new SimpleDateFormat("yyyy-MM-dd")).format(((Calendar) (obj)).getTime());
        String s = TinyDB.getInstance(context).getString("hitDate");
        if (s != null && !s.equals(""))
        {
            if (!s.equals(obj))
            {
                TinyDB.getInstance(context).putString("hitDate", ((String) (obj)));
                TinyDB.getInstance(context).putListInt(hitListPreferenceName, new ArrayList());
            }
            return;
        } else
        {
            TinyDB.getInstance(context).putString("hitDate", ((String) (obj)));
            return;
        }
    }

    public void createAccount(String s, String s1, String s2, String s3, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls10(s, s1, s2, s3, callback));
    }

    public long decryptAlbumId(String s, String s1)
    {
        String s2 = "-1";
        s = (new CryptLib()).decrypt(s, CryptLib.SHA256("9FwoqrxUVP2A9kkCnLdQv24xDrmQNCox", 31), s1);
        s2 = s;
        try
        {
            System.out.println((new StringBuilder()).append("decrypted text=").append(s).toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            s = s2;
        }
        return (long)Integer.parseInt(s);
    }

    public void deleteAlbum(Album album, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls34(album, callback));
    }

    public void deleteComment(Comment comment, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls36(comment, callback));
    }

    public void deleteDownload(Song song, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls33(song, callback));
    }

    public void deleteFavorite(Song song, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls32(song, callback));
    }

    public void deleteReply(Comment comment, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls35(comment, callback));
    }

    public void downloadDabbSong(Song song, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        File file = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/MyMixtapez/").append(song.getAlbum().getArtist().getName()).append("-").append(song.getName()).append(".mp3").toString().replaceAll("\\s+", ""));
        if (!file.exists())
        {
            checkLastDabbSong();
            handler.post(new _cls59(song, file, callback));
            return;
        } else
        {
            onCallback(callback, file);
            return;
        }
    }

    public void enterPromoCode(long l, String s, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls57(l, s, callback));
    }

    public Album getAlbum(long l)
    {
        return database.getAlbum(l);
    }

    public void getAlbum(long l, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls23(l, callback));
    }

    public void getAlbumFromServer(long l, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls22(l, callback));
    }

    public String getAlbumUrl(int i, String s)
    {
        return (new StringBuilder()).append((String)links.get(78)).append(File.separator).append(i).append("/imageVersion/").append(s).toString();
    }

    public List getAlbumsArtist(Artist artist)
    {
        return database.getAlbumsArtist(artist, 0);
    }

    public List getAlbumsArtist(Artist artist, int i)
    {
        return database.getAlbumsArtist(artist, i);
    }

    public List getAlbumsRelated(Artist artist)
    {
        return database.getAlbumsRelated(artist, 0);
    }

    public List getAlbumsRelated(Artist artist, int i)
    {
        return database.getAlbumsRelated(artist, i);
    }

    public List getArtistSongs(long l)
    {
        return database.getArtistSongs(l);
    }

    public void getArtistsFeatured(long l, DatabaseCallback databasecallback)
    {
        onDatabaseCallback(databasecallback, database.getArtistsFeatured(l));
    }

    public void getBadgeList(long l, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls55(l, callback));
    }

    public void getComments(Album album, int i, String s, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls28(album, i, s, callback));
    }

    public Song getDownload(long l)
    {
        return database.getDownload(l);
    }

    public int getDownloadQuality()
    {
        switch (getUser().getDownloadQuality())
        {
        case 1: // '\001'
        case 2: // '\002'
        case 4: // '\004'
        default:
            return 0;

        case 0: // '\0'
            return 2;

        case 3: // '\003'
            return 1;

        case 5: // '\005'
            return 0;
        }
    }

    public List getDownloads()
    {
        return database.getDownloads();
    }

    public List getFavorites()
    {
        return database.getFavorites();
    }

    public List getFeatures()
    {
        return database.getFeatures();
    }

    public void getFeaturesFromServer(my.googlemusic.play.interfaces.Server.ServerCallback servercallback)
    {
    /* block-local class not found */
    class LoadFeatureTask {}

        (new LoadFeatureTask(servercallback)).execute(new Void[0]);
    }

    public void getFeed(long l, int i, String s, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls39(l, i, s, callback));
    }

    public void getFollowers(long l, long l1, int i, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls42(l, l1, i, callback));
    }

    public void getFollowing(long l, long l1, int i, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls43(l, l1, i, callback));
    }

    public List getJustAdded()
    {
        return database.getJustAdded();
    }

    public List getJustAdded(long l)
    {
        return database.getJustAdded(l);
    }

    public void getJustAddedFromServer(my.googlemusic.play.interfaces.Server.ServerCallback servercallback)
    {
    /* block-local class not found */
    class LoadJustAddedTask {}

        (new LoadJustAddedTask(servercallback)).execute(new Void[0]);
    }

    public void getLikeHits(LikeHitCallback likehitcallback, long l)
    {
    /* block-local class not found */
    class LoadLikeHitsTask {}

        (new LoadLikeHitsTask(likehitcallback)).execute(new Long[] {
            Long.valueOf(l)
        });
    }

    public String getLink(int i)
    {
        if (links != null && links.size() != 0) goto _L2; else goto _L1
_L1:
        Object obj = Connection.with(context).request("http://107.161.177.131:8000/?version=6&phonetype=1").get();
        if (!((Response) (obj)).isSuccessful()) goto _L2; else goto _L3
_L3:
        Object obj1;
        obj1 = (new JSONObject(((Response) (obj)).getContent())).getJSONObject("Config");
        obj = ((JSONObject) (obj1)).getJSONArray("LinkServerList");
        obj1 = ((JSONObject) (obj1)).getJSONArray("LinkUserList");
        int j = 0;
_L5:
        if (j >= ((JSONArray) (obj)).length())
        {
            break; /* Loop/switch isn't completed */
        }
        JSONObject jsonobject1 = ((JSONArray) (obj)).getJSONObject(j);
        links.put(jsonobject1.getInt("Id"), jsonobject1.getString("Url"));
        j++;
        if (true) goto _L5; else goto _L4
_L8:
        if (j >= ((JSONArray) (obj1)).length()) goto _L2; else goto _L6
_L6:
        JSONObject jsonobject = ((JSONArray) (obj1)).getJSONObject(j);
        links.put(jsonobject.getInt("Id"), jsonobject.getString("Url"));
        j++;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        exception.printStackTrace();
_L2:
        return (String)links.get(i);
_L4:
        j = 0;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public String getLinkAlbumImage()
    {
        if (getLink(78) == null)
        {
            return "http://";
        } else
        {
            return getLink(8);
        }
    }

    public String getLinkAlbumImage(long l, long l1, String s)
    {
        if (getLink(78) == null)
        {
            return "http://";
        } else
        {
            return (new StringBuilder()).append(getLink(78)).append(File.separator).append(l).append(File.separator).append(l1).append(File.separator).append(s).toString();
        }
    }

    public String getLinkArtistImage(long l)
    {
        if (getLink(75) == null)
        {
            return "http://";
        } else
        {
            return (new StringBuilder()).append(getLink(75)).append("?idArtist=").append(l).append("&phoneType=1").toString();
        }
    }

    public String getLinkBadge(long l, int i)
    {
        System.out.println((new StringBuilder()).append(getLink(64)).append("?idUser=").append(l).append("&idBadge=").append(i).append("&phoneType=1").toString());
        if (getLink(64) == null)
        {
            return "http://";
        } else
        {
            return (new StringBuilder()).append(getLink(64)).append("?idUser=").append(l).append("&idBadge=").append(i).append("&phoneType=1").toString();
        }
    }

    public String getLinkDownloadSong()
    {
        if (getLink(3) == null)
        {
            return "http://";
        } else
        {
            return getLink(3);
        }
    }

    public String getLinkStreamingSong()
    {
        if (getLink(2) == null)
        {
            return "";
        } else
        {
            return getLink(2);
        }
    }

    public String getLinkUserImage(long l)
    {
        if (getLink(61) == null)
        {
            return "http://";
        } else
        {
            return (new StringBuilder()).append(getLink(61)).append("?idUser=").append(l).append("&phoneType=1").toString();
        }
    }

    public String getLinkVideoImage()
    {
        if (getLink(30) == null)
        {
            return "http://";
        } else
        {
            return getLink(30);
        }
    }

    public String getLinkVideoStream()
    {
        if (getLink(29) == null)
        {
            return "http://";
        } else
        {
            return getLink(29);
        }
    }

    public List getMoreFromArtist(String s)
    {
        return database.getMoreFromArtist(s);
    }

    public File getMusicDirectory(Song song)
    {
        File file;
        if (!"mounted".equals(Environment.getExternalStorageState()))
        {
            file = null;
        } else
        {
            File file1 = new File(Environment.getExternalStoragePublicDirectory("My Mixtapez"), (new StringBuilder()).append(song.getAlbum().getName()).append(" - ").append(song.getAlbum().getArtist().getName()).toString());
            file = file1;
            if (!file1.exists())
            {
                file = file1;
                if (file1.mkdirs())
                {
                    Log.d("Music", (new StringBuilder()).append("Diretorio criado para musica ").append(song.getName()).toString());
                    return file1;
                }
            }
        }
        return file;
    }

    public void getPremiumPass(my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls20(callback));
    }

    public void getProfile(long l, long l1, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls38(l, l1, callback));
    }

    public void getProfileFavorites(long l, int i, int j, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls40(l, i, j, callback));
    }

    public void getProfileFeed(long l, int i, String s, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls41(l, i, s, callback));
    }

    public List getRadio()
    {
        return database.getRadio();
    }

    public void getRealAlbumId(String s, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls58(s, callback));
    }

    public void getRecommendedUser(my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls27(callback));
    }

    public void getReply(long l, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls29(l, callback));
    }

    public List getSearchAlbum(String s, int i)
    {
        return database.getSearchAlbum(s, i);
    }

    public List getSearchArtist(String s, int i)
    {
        return database.getSearchArtist(s, i);
    }

    public List getSearchSong(String s, int i)
    {
        return database.getSearchSong(s, i);
    }

    public void getSearchUser(String s, int i, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        mainRunnable = new _cls26(s, i, callback);
        handler.post(mainRunnable);
    }

    public List getSingles()
    {
        return database.getSingles();
    }

    public void getSinglesFromServer(my.googlemusic.play.interfaces.Server.ServerCallback servercallback)
    {
    /* block-local class not found */
    class LoadSinglesTask {}

        (new LoadSinglesTask(servercallback)).execute(new Void[0]);
    }

    public Song getSong(long l)
    {
        return database.getSong(l);
    }

    public String getSongPath(Song song)
    {
        if (!isDownloaded(song))
        {
            return song.getUrl();
        }
        File file = getMusicDirectory(song);
        if ((new File(file, (new StringBuilder()).append(song.getName()).append(".mp3").toString())).exists())
        {
            return (new StringBuilder()).append(file).append("/").append(song.getName()).append(".mp3").toString();
        } else
        {
            return song.getUrl();
        }
    }

    public List getSongs(List list)
    {
        return database.getSongs(list);
    }

    public List getSongs(Album album)
    {
        return database.getSongs(album);
    }

    public int getStreamQuality()
    {
        switch (getUser().getStreamQuality())
        {
        case 1: // '\001'
        case 2: // '\002'
        case 4: // '\004'
        default:
            return 0;

        case 0: // '\0'
            return 2;

        case 3: // '\003'
            return 1;

        case 5: // '\005'
            return 0;
        }
    }

    public void getTargetSpot(my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls53(callback));
    }

    public void getUpcoming(my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls24(callback));
    }

    public User getUser()
    {
        return database.getUser();
    }

    public void getVideos(my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls25(callback));
    }

    public boolean hasSongHit(long l)
    {
        return TinyDB.getInstance(context).getListInt(hitListPreferenceName).contains(Integer.valueOf((int)l));
    }

    public File isDownloadFinished(String s, String s1, String s2)
    {
        return new File(getMusicDirectory(s, s1, s2), (new StringBuilder()).append(s).append(".mp3").toString());
    }

    public boolean isDownloadFinished(Song song)
    {
        return (new File(getMusicDirectory(song), (new StringBuilder()).append(song.getName()).append(".mp3").toString())).exists();
    }

    public boolean isDownloaded(long l)
    {
        return database.isDownloaded(l);
    }

    public boolean isDownloaded(Song song)
    {
        return database.isDownloaded(song.getId());
    }

    public boolean isEmptyLinks()
    {
        return links != null && links.size() == 0;
    }

    public boolean isFavorited(Song song)
    {
        return database.isFavorited(song.getId());
    }

    public boolean isLogged()
    {
        return database.isLogged();
    }

    public boolean isStreaming(long l)
    {
        return database.isStreaming(l);
    }

    public void loadMoreJustAdded(my.googlemusic.play.interfaces.Server.ServerCallback servercallback, long l, int i)
    {
    /* block-local class not found */
    class LoadMoreJustAddedTask {}

        (new LoadMoreJustAddedTask(servercallback)).execute(new Object[] {
            Long.valueOf(l), Integer.valueOf(i)
        });
    }

    public void login(String s, String s1, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls7(s, s1, callback));
    }

    public void loginGoogle(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls8(s2, s1, s5, s6, s3, callback));
    }

    public void loginSkip()
    {
        database.login(User.newSkipInstance());
    }

    public void logout()
    {
        if (!getUser().isSkip())
        {
            String s = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
            removeNotification(getUser().getId(), s);
        }
        android.content.SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putBoolean("syncDownloads", false);
        editor.apply();
        database.deleteFavorites();
        database.deleteDownloads();
        database.logout();
    }

    public void moveFile(String s, String s1, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        byte abyte0[];
        int i;
        try
        {
            s = new FileInputStream(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            continue; /* Loop/switch isn't completed */
        }
        try
        {
_L4:
            s1 = new FileOutputStream(s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            continue; /* Loop/switch isn't completed */
        }
        abyte0 = new byte[1024];
_L3:
        i = s.read(abyte0);
        if (i == -1) goto _L2; else goto _L1
_L1:
        s1.write(abyte0, 0, i);
          goto _L3
        s;
_L7:
        Log.e("tag", s.getMessage());
        s = "Something went wrong. Try again.";
_L5:
        onCallback(callback, s);
        return;
_L2:
        s.close();
        s1.flush();
        s1.close();
        s = "Saved on gallery";
        if (true) goto _L5; else goto _L4
        s;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void recoverPassword(String s, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls9(s, callback));
    }

    public void registerNotification(long l, String s, String s1, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls47(l, s, s1, callback));
    }

    public void removeFriend(long l, long l1, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls45(l, l1, callback));
    }

    public void removeNotification(long l, String s)
    {
        handler.post(new _cls48(l, s));
    }

    public void replyComment(Comment comment, my.googlemusic.play.interfaces.Server.Callback callback)
    {
    }

    public void reportComment(Comment comment, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls37(comment, callback));
    }

    public void requestStore(my.googlemusic.play.interfaces.Server.Callback callback, long l)
    {
        handler.post(new _cls46(l, callback));
    }

    public void searchAlbum(SearchCallback searchcallback, String s, int i, int j)
    {
    /* block-local class not found */
    class SearchAlbumTask {}

        (new SearchAlbumTask(searchcallback)).execute(new Object[] {
            s, Integer.valueOf(i), Integer.valueOf(j)
        });
    }

    public void searchArtist(SearchCallback searchcallback, String s, int i, int j)
    {
    /* block-local class not found */
    class SearchArtistTask {}

        (new SearchArtistTask(searchcallback)).execute(new Object[] {
            s, Integer.valueOf(i), Integer.valueOf(j)
        });
    }

    public void searchSong(SearchCallback searchcallback, String s, int i, int j)
    {
    /* block-local class not found */
    class SearchSongTask {}

        (new SearchSongTask(searchcallback)).execute(new Object[] {
            s, Integer.valueOf(i), Integer.valueOf(j)
        });
    }

    public void sendBroadcast(String s)
    {
        Intent intent = new Intent("MIXTAPEZ BROADCAST");
        intent.putExtra("EXTRAS", s);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public void sendPremiumPass(String s, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls21(s, callback));
    }

    public void sendSongVote(long l)
    {
        handler.post(new _cls50(l));
    }

    public void setBadge(long l, int i, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls56(l, i, callback));
    }

    public void setDownloadQuality(int i)
    {
        database.editDownloadQuality(i);
    }

    public void setRateUs(boolean flag)
    {
        database.editUserRateUs(flag);
    }

    public void setRingtoner(Song song, Context context1, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls54(song, context1, callback));
    }

    public void setStreamQuality(int i)
    {
        database.editStreamQuality(i);
    }

    public void stopThread()
    {
        Log.d("THREAD", "CallBack Canceled");
        if (mainRunnable != null)
        {
            handler.removeCallbacks(mainRunnable);
        }
    }

    public void tempSearchArtist(SearchCallback searchcallback, String s, int i, int j)
    {
    /* block-local class not found */
    class TempSearchArtistTask {}

        (new TempSearchArtistTask(searchcallback)).execute(new Object[] {
            s, Integer.valueOf(i), Integer.valueOf(j)
        });
    }

    public void updateDatabase(my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls2(callback));
    }

    public void updateLinks(my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls1(callback));
    }

    public void updatePlayLists(my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls4(callback));
    }

    public void updateRadio(my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls3(callback));
    }

    public void upgradePremium(long l)
    {
        handler.post(new _cls18(l));
    }

    public void upgradePremium(long l, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls19(l, callback));
    }

    public void uploadImageUser(Bitmap bitmap, my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls17(bitmap, callback));
    }

    public void verifyDownloadsFiles()
    {
        Iterator iterator = getDownloads().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Song song = (Song)iterator.next();
            if (!(new File(getMusicDirectory(song), (new StringBuilder()).append(song.getName()).append(".mp3").toString())).exists())
            {
                database.deleteDownload(song.getId());
            }
        } while (true);
    }

    public void verifyVersion(my.googlemusic.play.interfaces.Server.Callback callback)
    {
        handler.post(new _cls49(callback));
    }

    static 
    {
        boolean flag;
        if (!my/googlemusic/play/servers/ServerHelper.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }











    // Unreferenced inner class my/googlemusic/play/servers/ServerHelper$AddAlbumsToDatabaseTask
    /* block-local class not found */
    class AddAlbumsToDatabaseTask {}


    // Unreferenced inner class my/googlemusic/play/servers/ServerHelper$OnProgressListener
    /* block-local class not found */
    class OnProgressListener {}


    /* member class not found */
    class _cls62 {}


    /* member class not found */
    class _cls61 {}


    /* member class not found */
    class _cls60 {}


    /* member class not found */
    class _cls5 {}


    /* member class not found */
    class _cls6 {}


    /* member class not found */
    class _cls31 {}


    /* member class not found */
    class _cls30 {}


    /* member class not found */
    class _cls44 {}


    /* member class not found */
    class _cls51 {}


    /* member class not found */
    class _cls52 {}


    /* member class not found */
    class _cls16 {}


    /* member class not found */
    class _cls13 {}


    /* member class not found */
    class _cls15 {}


    /* member class not found */
    class _cls11 {}


    /* member class not found */
    class _cls14 {}


    /* member class not found */
    class _cls12 {}


    /* member class not found */
    class _cls10 {}


    /* member class not found */
    class _cls34 {}


    /* member class not found */
    class _cls36 {}


    /* member class not found */
    class _cls33 {}


    /* member class not found */
    class _cls32 {}


    /* member class not found */
    class _cls35 {}


    /* member class not found */
    class _cls59 {}


    /* member class not found */
    class _cls57 {}


    /* member class not found */
    class _cls23 {}


    /* member class not found */
    class _cls22 {}


    /* member class not found */
    class _cls55 {}


    /* member class not found */
    class _cls28 {}


    /* member class not found */
    class _cls39 {}


    /* member class not found */
    class _cls42 {}


    /* member class not found */
    class _cls43 {}


    /* member class not found */
    class _cls20 {}


    /* member class not found */
    class _cls38 {}


    /* member class not found */
    class _cls40 {}


    /* member class not found */
    class _cls41 {}


    /* member class not found */
    class _cls58 {}


    /* member class not found */
    class _cls27 {}


    /* member class not found */
    class _cls29 {}


    /* member class not found */
    class _cls26 {}


    /* member class not found */
    class _cls53 {}


    /* member class not found */
    class _cls24 {}


    /* member class not found */
    class _cls25 {}


    /* member class not found */
    class _cls7 {}


    /* member class not found */
    class _cls8 {}


    /* member class not found */
    class _cls9 {}


    /* member class not found */
    class _cls47 {}


    /* member class not found */
    class _cls45 {}


    /* member class not found */
    class _cls48 {}


    /* member class not found */
    class _cls37 {}


    /* member class not found */
    class _cls46 {}


    /* member class not found */
    class _cls21 {}


    /* member class not found */
    class _cls50 {}


    /* member class not found */
    class _cls56 {}


    /* member class not found */
    class _cls54 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls18 {}


    /* member class not found */
    class _cls19 {}


    /* member class not found */
    class _cls17 {}


    /* member class not found */
    class _cls49 {}

}
