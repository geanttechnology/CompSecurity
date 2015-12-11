// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Messenger;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AutoCompleteTextView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.SubMenu;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.widget.WebDialog;
import com.flurry.android.FlurryAgent;
import com.google.android.gms.ads.AdView;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.mixerbox.mixerbox3b.adapters.SongAdapter;
import com.mixerbox.mixerbox3b.classes.DividerVectorItem;
import com.mixerbox.mixerbox3b.classes.DrawView;
import com.mixerbox.mixerbox3b.classes.EmptyVectorItem;
import com.mixerbox.mixerbox3b.classes.MixerBoxAsyncHttpResponseHandler;
import com.mixerbox.mixerbox3b.classes.MyFocusableWebView;
import com.mixerbox.mixerbox3b.classes.PlaylistItem;
import com.mixerbox.mixerbox3b.classes.SongItem;
import com.mixerbox.mixerbox3b.dialogs.AlertDialogFactory;
import com.mixerbox.mixerbox3b.dialogs.CreatePlaylistDialog;
import com.mixerbox.mixerbox3b.dialogs.RemoveDialog;
import com.mixerbox.mixerbox3b.dialogs.RenamePlaylistDialog;
import com.mixerbox.mixerbox3b.fragments.DJsFragment;
import com.mixerbox.mixerbox3b.fragments.DiscoverFragment;
import com.mixerbox.mixerbox3b.fragments.MP3Fragment;
import com.mixerbox.mixerbox3b.fragments.NewsfeedFragment;
import com.mixerbox.mixerbox3b.fragments.PlaylistsFragment;
import com.mixerbox.mixerbox3b.fragments.SettingsFragment;
import com.mixerbox.mixerbox3b.fragments.SignUpFragment;
import com.mixerbox.mixerbox3b.fragments.SongFragment;
import com.mixerbox.mixerbox3b.fragments.SortFragment;
import com.mixerbox.mixerbox3b.fragments.VectorFragment;
import com.mixerbox.mixerbox3b.fragments.WebFragment;
import com.mixerbox.mixerbox3b.services.EarphoneReceiver;
import com.mixerbox.mixerbox3b.services.LocalNotificationReceiver;
import com.mixerbox.mixerbox3b.services.MyReceiver;
import com.mixerbox.mixerbox3b.services.MyService;
import com.mixerbox.mixerbox3b.services.PlayerReceiver;
import com.mixerbox.mixerbox3b.services.PlayerService;
import com.mixerbox.mixerbox3b.services.RemoteControlReceiver;
import com.mixerbox.mixerbox3b.services.SleepReceiver;
import com.mixerbox.mixerbox3b.services.WindowPlayerService;
import com.mixerbox.mixerbox3b.utils.ActionBarSettings;
import com.mixerbox.mixerbox3b.utils.MixerBoxClient;
import com.mixerbox.mixerbox3b.utils.MixerBoxConstants;
import com.mixerbox.mixerbox3b.utils.MixerBoxSQLite;
import com.mixerbox.mixerbox3b.utils.MixerBoxSharedPreferences;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Stack;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.mixerbox.mixerbox3b:
//            MixerBox

public class MainPage extends SherlockFragmentActivity
{

    private static final int Msg_What_Page_reload = 2;
    private static final int Msg_What_Timer_finish = 1;
    static int PLAYER_REPEAT = 0;
    static boolean PLAYER_SHUFFLE = false;
    private static final int REAUTH_ACTIVITY_CODE = 100;
    static Bundle bundle;
    static boolean defaultPortrait;
    static boolean isPageLoaded;
    static int playerType = 0;
    public static Stack stackCurrentFragmentId;
    public MixerBoxSQLite DB;
    int JS_Player_H;
    int JS_Player_H_F;
    int JS_Player_W;
    int JS_Player_W_F;
    List PERMISSIONS;
    int SCREEN_STATE;
    final String SOME_ACTION = "PlayerBroadcastReceiver";
    AdView adView;
    android.media.AudioManager.OnAudioFocusChangeListener afChangeListener;
    AudioManager am;
    public List arrayDJs;
    public ArrayList arrayLocalNotificationList;
    public ArrayList arrayMP3;
    public ArrayList arrayMyPlaylists;
    public ArrayList arrayMySubsPlaylists;
    public List arrayNewsfeed;
    public ArrayList arrayPlayingSong;
    public ArrayList arraySong;
    public List arraySystemList;
    com.mixerbox.mixerbox3b.services.WindowPlayerService.MyBinder binder;
    ImageButton btnAdd;
    RelativeLayout btnDJs;
    RelativeLayout btnDiscover;
    ImageButton btnExpand;
    ImageButton btnFullScreen;
    RelativeLayout btnNewsfeed;
    ImageButton btnPlay;
    RelativeLayout btnPlaylists;
    ImageButton btnQuality;
    RelativeLayout btnSettings;
    ImageButton btnShare;
    private com.facebook.Session.StatusCallback callback;
    public boolean canPlay;
    public boolean canSetLocalNotification;
    boolean canUpdateSeekbar;
    private ServiceConnection conn;
    int curOri;
    public int currentFragment;
    int currentTime;
    public Dialog dialogDevice;
    EarphoneReceiver earphoneReceiver;
    int errorCount;
    public DJsFragment fragmentDJs;
    DiscoverFragment fragmentDiscover;
    FragmentManager fragmentManager;
    NewsfeedFragment fragmentNewsfeed;
    public PlaylistsFragment fragmentPlaylists;
    public SettingsFragment fragmentSettings;
    public SignUpFragment fragmentSignUp;
    public DrawView guideView;
    final Handler handler = new _cls15();
    public boolean hasSetCanAuto;
    boolean hasSetLocalNotification;
    boolean isBackground;
    boolean isForeground;
    public boolean isLogIn;
    boolean isReady;
    ImageView ivSoundCloud;
    ImageView ivWebViewCover;
    LinearLayout llBottomtab;
    private MyHandler mHandlerTime;
    PhoneStateListener mPhoneStateListener;
    PlayerReceiver mReceiver;
    ActionBarSherlock mSherlock;
    public Menu menu;
    Messenger messenger;
    public ArrayList myPlaylists;
    private MusicIntentReceiver myReceiver;
    public ArrayList mySubscriptions;
    ArrayList name;
    public NotificationManager nm;
    String oriVideoId;
    int playerHeight;
    public PlaylistItem playingPlaylist;
    public SongItem playingSong;
    public int playingSongIndex;
    int preOri;
    MyReceiver r;
    private Runnable rCheckHistory;
    Runnable rLocalNotificationList;
    Runnable rSendInitInfo;
    int resetTime;
    RelativeLayout rlHint;
    RelativeLayout rlPanelBottom;
    LinearLayout rlPanelPopup;
    RelativeLayout rlPanelTop;
    public RelativeLayout rlVideoPlayer;
    SeekBar seekbar;
    boolean shouldChangeBackToWebView;
    boolean shouldCheckNotificationBtn;
    public boolean shouldCloseApp;
    public boolean shouldLogin;
    int shouldPlay;
    public boolean shouldPlayAfterReady;
    boolean shouldResetTime;
    public boolean shouldSendNoti;
    int shuffleCount;
    int shuffleIndexArray[];
    SleepReceiver sr;
    public Stack stack;
    public TextView tvNoInternet;
    TextView tvNoNet;
    TextView tvSwitch;
    TextView tvTimeStart;
    private UiLifecycleHelper uiHelper;
    public int videoState;
    public WebView wv;

    public MainPage()
    {
        errorCount = 0;
        mSherlock = ActionBarSherlock.wrap(this);
        DB = null;
        hasSetLocalNotification = false;
        canSetLocalNotification = true;
        isBackground = false;
        PERMISSIONS = Arrays.asList(new String[] {
            "publish_actions"
        });
        callback = new _cls1();
        binder = null;
        conn = new _cls14();
        messenger = new Messenger(handler);
        mPhoneStateListener = new _cls29();
        afChangeListener = new _cls30();
        shouldCheckNotificationBtn = true;
        rCheckHistory = new _cls36();
        shouldChangeBackToWebView = false;
        rLocalNotificationList = new _cls48();
        resetTime = 0;
        shouldResetTime = false;
        oriVideoId = "";
        rSendInitInfo = new _cls50();
    }

    private ArrayList autocomplete(String s)
    {
        Object obj1 = new ArrayList();
        Object obj = "";
        StringBuilder stringbuilder;
        char ac[];
        int i;
        int j;
        try
        {
            s = URLEncoder.encode(s, "utf8");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s = ((String) (obj));
        }
        obj = (new StringBuilder()).append(Locale.getDefault().getLanguage()).append("-").append(Locale.getDefault().getCountry().toLowerCase(Locale.getDefault())).toString();
        s = (new StringBuilder()).append("http://suggestqueries.google.com/complete/search?ds=yt&client=android&hl=").append(((String) (obj))).append("&oe=UTF-8&q=").append(s).toString();
        obj = null;
        stringbuilder = new StringBuilder();
        s = (HttpURLConnection)(new URL(s)).openConnection();
        obj = new InputStreamReader(s.getInputStream());
        ac = new char[1024];
_L3:
        i = ((InputStreamReader) (obj)).read(ac);
        if (i == -1) goto _L2; else goto _L1
_L1:
        stringbuilder.append(ac, 0, i);
          goto _L3
        obj;
_L13:
        if (s != null)
        {
            s.disconnect();
        }
_L9:
        s = new JSONArray(stringbuilder.toString());
        i = 0;
_L10:
        if (i >= s.length()) goto _L5; else goto _L4
_L4:
        if (!(s.get(i) instanceof JSONArray)) goto _L7; else goto _L6
_L6:
        obj = s.getJSONArray(i);
        j = 0;
_L8:
        if (j >= ((JSONArray) (obj)).length())
        {
            break; /* Loop/switch isn't completed */
        }
        if (((JSONArray) (obj)).getString(j).length() > 0)
        {
            ((ArrayList) (obj1)).add(((JSONArray) (obj)).getString(j));
        }
        j++;
        if (true) goto _L8; else goto _L7
_L2:
        if (s != null)
        {
            s.disconnect();
        }
          goto _L9
        obj1;
        s = ((String) (obj));
        obj = obj1;
_L11:
        if (s != null)
        {
            s.disconnect();
        }
        throw obj;
_L7:
        i++;
          goto _L10
        s;
_L5:
        return ((ArrayList) (obj1));
        obj;
          goto _L11
        s;
        s = null;
        if (true) goto _L13; else goto _L12
_L12:
    }

    private void closeDB()
    {
        DB.close();
    }

    private void genShuffleIndexArray()
    {
        boolean flag = false;
        if (arrayPlayingSong.size() != 0)
        {
            shuffleIndexArray = new int[arrayPlayingSong.size()];
            for (int i = 0; i < arrayPlayingSong.size(); i++)
            {
                shuffleIndexArray[i] = i;
            }

            Random random = new Random();
            int j = ((flag) ? 1 : 0);
            while (j < arrayPlayingSong.size()) 
            {
                int k = random.nextInt(j + 1);
                int l = shuffleIndexArray[k];
                shuffleIndexArray[k] = shuffleIndexArray[j];
                shuffleIndexArray[j] = l;
                j++;
            }
        }
    }

    private String getMP3Thumbnail(String s)
    {
        String s1 = "";
        Uri uri = ContentUris.withAppendedId(Uri.parse("content://media/external/audio/albumart"), Long.valueOf(s).longValue());
        ContentResolver contentresolver = getContentResolver();
        s = s1;
        try
        {
            if (contentresolver.openInputStream(uri) != null)
            {
                s = uri.toString();
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return "";
        }
        return s;
    }

    private int getShuffleIndex(int i)
    {
        if (arrayPlayingSong == null || arrayPlayingSong.size() == 0)
        {
            return -1;
        }
        if (shuffleIndexArray == null || i >= arrayPlayingSong.size() || shuffleCount >= arrayPlayingSong.size() || i >= shuffleIndexArray.length)
        {
            genShuffleIndexArray();
            shuffleCount = 0;
        }
        if (shuffleIndexArray.length != arrayPlayingSong.size())
        {
            genShuffleIndexArray();
            shuffleCount = 0;
        }
        if (shuffleIndexArray[i] >= arrayPlayingSong.size())
        {
            genShuffleIndexArray();
            shuffleCount = 0;
        }
        shuffleCount = shuffleCount + 1;
        return shuffleIndexArray[i];
    }

    private void onSessionStateChange(Session session, SessionState sessionstate, Exception exception)
    {
        if (session != null && session.isOpened())
        {
            sessionstate.equals(SessionState.OPENED_TOKEN_UPDATED);
        }
    }

    private void openDB()
    {
        boolean flag2 = true;
        Object obj1 = getDatabasePath("mixerboxdb.db");
        Object obj;
        Exception exception;
        Object obj2;
        boolean flag;
        boolean flag1;
        if (!((File) (obj1)).exists())
        {
            flag = false;
        } else
        {
            flag = true;
        }
        DB = new MixerBoxSQLite(this);
        if (flag)
        {
            break MISSING_BLOCK_LABEL_379;
        }
        (new Thread(rSendInitInfo)).start();
        obj = getPackageManager().getInstalledApplications(128).iterator();
        flag = false;
        flag1 = false;
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            ApplicationInfo applicationinfo = (ApplicationInfo)((Iterator) (obj)).next();
            if (applicationinfo.packageName.equals("com.mixerbox.mixerbox2"))
            {
                flag1 = true;
            }
            if (applicationinfo.packageName.equals("com.mixerbox.mixerbox2b"))
            {
                flag = true;
            }
        } while (true);
        if (flag1 || flag)
        {
            shouldLogin = true;
            MixerBoxClient.get("http://bit.ly/MB3AndroidHasMB2MB2b", null, new AsyncHttpResponseHandler());
        }
        obj2 = Environment.getExternalStorageDirectory();
        if (!((File) (obj2)).canWrite())
        {
            break MISSING_BLOCK_LABEL_379;
        }
        obj = new File(((File) (obj2)), "//Download/mixerboxdb.db");
        if (!((File) (obj)).exists()) goto _L2; else goto _L1
_L1:
        flag = flag2;
_L3:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_379;
        }
        try
        {
            DB.close();
            obj2 = (new FileInputStream(((File) (obj)))).getChannel();
            obj1 = (new FileOutputStream(((File) (obj1)))).getChannel();
            ((FileChannel) (obj1)).transferFrom(((java.nio.channels.ReadableByteChannel) (obj2)), 0L, ((FileChannel) (obj2)).size());
            ((FileChannel) (obj2)).close();
            ((FileChannel) (obj1)).close();
            DB = new MixerBoxSQLite(this);
            ((File) (obj)).delete();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            MixerBoxUtils.logMsg(exception.toString());
        }
        break MISSING_BLOCK_LABEL_340;
_L2:
        obj = new File(((File) (obj2)), "//Download/mixerbox2b0db.db");
        if (!((File) (obj)).exists())
        {
            break MISSING_BLOCK_LABEL_295;
        }
        shouldLogin = false;
        flag = flag2;
          goto _L3
        obj = new File(((File) (obj2)), "//Download/mixerbox2b1db.db");
        if (!((File) (obj)).exists())
        {
            break MISSING_BLOCK_LABEL_326;
        }
        shouldLogin = true;
        flag = flag2;
          goto _L3
        flag = false;
          goto _L3
        MixerBoxClient.get("http://bit.ly/MB3AndroidImportFail", null, new AsyncHttpResponseHandler());
        MixerBoxClient.get(MixerBoxClient.getExportFailUrl(), null, new MixerBoxAsyncHttpResponseHandler(this));
        return;
    }

    private void requestPublishPermissions(Session session)
    {
        if (session != null)
        {
            session.requestNewPublishPermissions((new com.facebook.Session.NewPermissionsRequest(this, PERMISSIONS)).setRequestCode(100));
        }
    }

    private void setWebViewTouchListener()
    {
        wv.setOnTouchListener(new _cls39());
    }

    private void showPlayerGuide()
    {
        if (!MixerBoxSharedPreferences.getTipFirstPlay(this))
        {
            setOnboardingGuide(12, new boolean[0]);
        } else
        {
            if (!MixerBoxSharedPreferences.getTipSecondPlay(this))
            {
                setOnboardingGuide(13, new boolean[0]);
                return;
            }
            if (!MixerBoxSharedPreferences.getTipThirdPlay(this))
            {
                setOnboardingGuide(14, new boolean[0]);
                return;
            }
        }
    }

    private static Animation slideAnim(int i, float f, float f1, float f2, float f3)
    {
        TranslateAnimation translateanimation = new TranslateAnimation(1, f, 1, f1, 1, f2, 1, f3);
        translateanimation.setDuration(i);
        return translateanimation;
    }

    public boolean addLocalNotificationList(String s, String s1, String s2, String s3, String s4, String s5)
    {
        if (arrayLocalNotificationList.size() >= 9)
        {
            return true;
        }
        s1 = new PlaylistItem(s, s1, s5, s2, s4, "", s3, 2, true);
        if (!DB.getHasPushed(s) && !mySubscriptions.contains(s))
        {
            for (int i = 0; i < arrayLocalNotificationList.size(); i++)
            {
                if (((PlaylistItem)arrayLocalNotificationList.get(i)).getPlaylistId().equals(s))
                {
                    return false;
                }
            }

            arrayLocalNotificationList.add(s1);
            return true;
        } else
        {
            return false;
        }
    }

    public void backToPreviousFragment()
    {
        Object obj = fragmentManager.beginTransaction();
        android.widget.RelativeLayout.LayoutParams layoutparams;
        if (!stack.isEmpty())
        {
            if (((Fragment)stack.lastElement()).getClass().getSimpleName().equals("VectorFragment") || ((Fragment)stack.lastElement()).getClass().getSimpleName().equals("SongFragment") || ((Fragment)stack.lastElement()).getClass().getSimpleName().equals("MP3Fragment") || ((Fragment)stack.lastElement()).getClass().getSimpleName().equals("WebFragment"))
            {
                ((FragmentTransaction) (obj)).remove((Fragment)stack.pop());
            } else
            {
                ((FragmentTransaction) (obj)).hide((Fragment)stack.pop());
            }
            stackCurrentFragmentId.pop();
            currentFragment = ((Integer)stackCurrentFragmentId.lastElement()).intValue();
        }
        if (!stack.isEmpty())
        {
            ((FragmentTransaction) (obj)).show((Fragment)stack.lastElement());
        }
        if (stack.size() == 1)
        {
            ActionBarSettings.changeToNormalActionBar(this);
        }
        ((FragmentTransaction) (obj)).commit();
        if (!stackCurrentFragmentId.isEmpty())
        {
            ActionBarSettings.setActionBarItems(menu, ((Integer)stackCurrentFragmentId.lastElement()).intValue(), this);
        }
        if (((Fragment)stack.lastElement()).getClass().getSimpleName().equals("SongFragment") && (((SongFragment)stack.lastElement()).adapter == null || ((SongFragment)stack.lastElement()).adapter.array == null))
        {
            ActionBarSettings.hideOption(menu, 11);
        }
        obj = (FrameLayout)findViewById(0x7f0700d0);
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        if (((Fragment)stack.lastElement()).getClass().getSimpleName().equals("WebFragment"))
        {
            llBottomtab.setVisibility(8);
            layoutparams.addRule(3, 0x7f0700b6);
            layoutparams.addRule(2, 0x7f0700cf);
            ((FrameLayout) (obj)).setLayoutParams(layoutparams);
            return;
        } else
        {
            llBottomtab.setVisibility(0);
            layoutparams.addRule(2, 0x7f0700d1);
            layoutparams.addRule(3, 0x7f0700b6);
            ((FrameLayout) (obj)).setLayoutParams(layoutparams);
            return;
        }
    }

    public void changeQuality(boolean flag)
    {
        if (!flag)
        {
            btnQuality.setImageDrawable(getResources().getDrawable(0x7f02010d));
            wv.loadUrl((new StringBuilder()).append("javascript:setQuality(").append(JS_Player_W_F).append(",false)").toString());
            MixerBoxSharedPreferences.putHighQuality(this, false);
            return;
        } else
        {
            btnQuality.setImageDrawable(getResources().getDrawable(0x7f0200dd));
            wv.loadUrl((new StringBuilder()).append("javascript:setQuality(").append(JS_Player_W_F).append(",true)").toString());
            MixerBoxSharedPreferences.putHighQuality(this, true);
            return;
        }
    }

    void changeToMediaPlayer(boolean flag)
    {
        shouldChangeBackToWebView = true;
        if (playingSong != null && flag)
        {
            oriVideoId = playingSong.getSongYtId();
        }
        if (playingSong != null && !flag && binder != null)
        {
            binder.playMusic(playingSong.getSongYtId());
            (new Thread(rCheckHistory)).start();
            sendNotification();
        }
    }

    public void checkBundle()
    {
        if (bundle == null || bundle.getInt("tab", 0) == 0) goto _L2; else goto _L1
_L1:
        int i;
        FlurryAgent.logEvent("action:press_notification");
        i = bundle.getInt("tab");
        if (i != 1) goto _L4; else goto _L3
_L3:
        setPlaylists(false);
_L17:
        if (bundle.getString("playlistId", "").length() <= 0) goto _L6; else goto _L5
_L5:
        final String pid;
        SongFragment songfragment;
        pid = new PlaylistItem(bundle.getString("playlistId", ""), bundle.getString("playlistName", ""), bundle.getString("artistId", ""), bundle.getString("artist", ""), bundle.getString("itemCount", ""), "", bundle.getString("url"), 3, false);
        arraySong.clear();
        songfragment = setSong(pid.getPlaylistId());
        songfragment.currentPlaylist = pid;
        if (bundle.getInt("play", 0) == 1) goto _L8; else goto _L7
_L7:
        if (bundle.getInt("play", 0) != -1) goto _L10; else goto _L9
_L9:
        MixerBoxUtils.loadSong(this, pid.getPlaylistId(), false, 1, -1, songfragment);
_L12:
        if (bundle.getBoolean("subscribe", false))
        {
            subscribePlaylist(pid, true);
        }
_L6:
        return;
_L4:
        if (i == 2)
        {
            setNewsfeed();
            continue; /* Loop/switch isn't completed */
        }
        if (i != 3)
        {
            if (i == 4)
            {
                setDJs(1);
                continue; /* Loop/switch isn't completed */
            }
            if (i == 5)
            {
                setSettings();
                continue; /* Loop/switch isn't completed */
            }
        }
        setDiscover(new boolean[0]);
        continue; /* Loop/switch isn't completed */
_L10:
        if (rlVideoPlayer.getVisibility() != 0) goto _L8; else goto _L11
_L11:
        MixerBoxUtils.loadSong(this, pid.getPlaylistId(), false, 1, -1, songfragment);
          goto _L12
_L8:
        MixerBoxUtils.loadSong(this, pid.getPlaylistId(), false, 1, 0, songfragment);
          goto _L12
_L2:
        if (bundle == null || bundle.getString("data", "").length() <= 0) goto _L6; else goto _L13
_L13:
        String s = bundle.getString("data");
        pid = s;
        if (s.endsWith("/"))
        {
            pid = (String)s.subSequence(0, s.length() - 1);
        }
        pid = pid.split("/");
        if (pid.length != 5)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (pid[3].equals("list"))
        {
            pid = pid[4];
            MixerBoxClient.get(MixerBoxClient.getVectorUrl(pid, 0, "playlist"), null, new _cls11(pid));
            return;
        }
        if (!pid[3].equals("user")) goto _L6; else goto _L14
_L14:
        return;
        if (pid.length != 6 || !pid[3].equals("music")) goto _L6; else goto _L15
_L15:
        if (pid[4].equals("0"))
        {
            String s1 = pid[5];
            MixerBoxClient.get((new StringBuilder()).append("http://gdata.youtube.com/feeds/api/videos/").append(pid[5]).append("?alt=json&v=2").toString(), null, new _cls12(s1));
            return;
        }
        String s2 = pid[5];
        pid = pid[4];
        MixerBoxClient.get(MixerBoxClient.getVectorUrl(pid, 0, "playlist"), null, new _cls13(s2));
        return;
        if (true) goto _L17; else goto _L16
_L16:
    }

    public void checkButton()
    {
        if (MyService.mediaPlayer != null && MyService.mediaPlayer.isPlaying())
        {
            btnPlay.setImageDrawable(getResources().getDrawable(0x7f0200ed));
        }
    }

    public void checkMP3CountAndLoad()
    {
        int i;
        try
        {
            Cursor cursor = getContentResolver().query(android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, new String[0], "is_music != 0", null, null);
            i = cursor.getCount();
            cursor.close();
        }
        catch (Exception exception)
        {
            return;
        }
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        loadMP3(i);
        return;
        arrayMP3 = null;
        return;
    }

    public void closePlayer()
    {
        shouldSendNoti = false;
        if (playerType == 2 && !hasSetCanAuto)
        {
            rlHint.setVisibility(8);
        }
        wv.loadUrl("javascript:pauseVideo()");
        Animation animation = slideAnim(800, 0.0F, 0.0F, 0.0F, -1F);
        animation.setAnimationListener(new _cls40());
        rlVideoPlayer.startAnimation(animation);
        stopPlayer();
    }

    public void handleAnnounce()
    {
        (new AsyncHttpClient()).get((new StringBuilder()).append("https://graph.facebook.com/me/permissions?access_token=").append(MixerBoxSharedPreferences.getFacebookToken(this)).toString(), null, new _cls37(this));
    }

    public void loadMP3(int i)
    {
        arrayMP3 = new ArrayList();
        arrayMP3.add(new PlaylistItem("PLAYLISTMP3ID", getResources().getString(0x7f080128), "", "", String.valueOf(i), "0", "", 8, false));
    }

    public void musicPlayPause()
    {
        if (playingSong != null && (playingSong.getSongSource() == 3 || playingSong.getSongSource() == 2))
        {
            if (MyService.mediaPlayer != null)
            {
                if (MyService.mediaPlayer.isPlaying())
                {
                    MyService.mediaPlayer.pause();
                    btnPlay.setImageDrawable(getResources().getDrawable(0x7f0200ef));
                } else
                {
                    MyService.mediaPlayer.start();
                    btnPlay.setImageDrawable(getResources().getDrawable(0x7f0200ed));
                }
            }
            sendNotification();
        } else
        {
            if (shouldChangeBackToWebView && binder != null && isBackground)
            {
                if (binder.getIsPlaying())
                {
                    binder.pauseMusic();
                } else
                {
                    binder.playMusic();
                }
                sendNotification();
                return;
            }
            if (videoState == 1)
            {
                wv.loadUrl("javascript:pauseVideo()");
                btnPlay.setImageDrawable(getResources().getDrawable(0x7f0200ef));
                return;
            }
            if (videoState == 2)
            {
                am.requestAudioFocus(afChangeListener, 3, 1);
                wv.loadUrl("javascript:playVideo()");
                btnPlay.setImageDrawable(getResources().getDrawable(0x7f0200ed));
                mHandlerTime.sendEmptyMessageDelayed(1, 4000L);
                return;
            }
        }
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        uiHelper.onActivityResult(i, j, intent);
        Session.getActiveSession().onActivityResult(this, i, j, intent);
        switch (i)
        {
        default:
            return;

        case 100: // 'd'
            (new AsyncHttpClient()).get((new StringBuilder()).append("https://graph.facebook.com/me/permissions?access_token=").append(MixerBoxSharedPreferences.getFacebookToken(this)).toString(), null, new _cls38(this));
            break;
        }
    }

    public void onBackPressed()
    {
        if (guideView != null && guideView.isShown())
        {
            guideView.performClick();
            return;
        }
        if (SCREEN_STATE == 2)
        {
            setUnFullScreen(true);
            return;
        }
        if (stack.size() > 1)
        {
            backToPreviousFragment();
            return;
        }
        if (rlVideoPlayer.getVisibility() == 0)
        {
            if (MixerBoxSharedPreferences.getEnableBackgroundPlay(this))
            {
                changeToMediaPlayer(true);
            }
            moveTaskToBack(true);
        } else
        {
            wv.loadUrl("about:blank");
            finish();
        }
        FlurryAgent.onEndSession(this);
    }

    public void onCreate(Bundle bundle1)
    {
        super.onCreate(null);
        MixerBoxUtils.logMsg((new StringBuilder()).append("EXECUTION TIME = ").append(System.nanoTime()).toString());
        requestWindowFeature(5L);
        ActionBarSettings.initActionBar(this);
        setContentView(0x7f030040);
        bundle = getIntent().getExtras();
        if (!MixerBoxConstants.shouldOnCreate || bundle == null || !bundle.containsKey("isLogIn"))
        {
            Intent intent = new Intent(this, com/mixerbox/mixerbox3b/MixerBox);
            if (bundle != null)
            {
                intent.putExtras(bundle);
            }
            intent.addFlags(0x4000000);
            startActivity(intent);
        }
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        MixerBoxConstants.shouldOnCreate = false;
        isForeground = true;
        uiHelper = new UiLifecycleHelper(this, callback);
        uiHelper.onCreate(bundle1);
        bundle1 = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageOnLoading(0x7f020071).showImageForEmptyUri(0x7f020071).showImageOnFail(0x7f020071).cacheOnDisc(true).build();
        bundle1 = (new com.nostra13.universalimageloader.core.ImageLoaderConfiguration.Builder(getApplicationContext())).defaultDisplayImageOptions(bundle1).build();
        ImageLoader.getInstance().init(bundle1);
        Object obj;
        MyFocusableWebView myfocusablewebview;
        int i;
        try
        {
            isLogIn = bundle.getBoolean("isLogIn");
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle1)
        {
            bundle1 = new Intent(this, com/mixerbox/mixerbox3b/MixerBox);
            bundle1.addFlags(0x4000000);
            startActivity(bundle1);
        }
        llBottomtab = (LinearLayout)findViewById(0x7f0700d1);
        adView = (AdView)findViewById(0x7f0700cf);
        if (MixerBoxSharedPreferences.getShouldShowAd(this))
        {
            bundle1 = (new com.google.android.gms.ads.AdRequest.Builder()).build();
            adView.loadAd(bundle1);
        } else
        {
            removeAds();
        }
        ((TelephonyManager)getSystemService("phone")).listen(mPhoneStateListener, 32);
        am = (AudioManager)getSystemService("audio");
        defaultPortrait = true;
        i = ((WindowManager)getSystemService("window")).getDefaultDisplay().getRotation();
        bundle1 = getWindowManager();
        if (android.os.Build.VERSION.SDK_INT >= 13)
        {
            DisplayMetrics displaymetrics = new DisplayMetrics();
            bundle1.getDefaultDisplay().getMetrics(displaymetrics);
            JS_Player_H_F = displaymetrics.heightPixels;
            JS_Player_W_F = displaymetrics.widthPixels;
        } else
        {
            bundle1 = bundle1.getDefaultDisplay();
            JS_Player_H_F = bundle1.getHeight();
            JS_Player_W_F = bundle1.getWidth();
        }
        if (JS_Player_W_F > JS_Player_H_F && i != 0)
        {
            defaultPortrait = true;
        } else
        if (JS_Player_W_F > JS_Player_H_F && i == 0)
        {
            defaultPortrait = false;
        } else
        if (JS_Player_W_F < JS_Player_H_F && i == 0)
        {
            defaultPortrait = true;
        } else
        if (JS_Player_W_F < JS_Player_H_F && i != 0)
        {
            defaultPortrait = false;
        }
        if (JS_Player_W_F > JS_Player_H_F)
        {
            i = 0;
        } else
        {
            i = 1;
        }
        if (JS_Player_H_F > JS_Player_W_F)
        {
            int j = JS_Player_H_F;
            JS_Player_H_F = JS_Player_W_F;
            JS_Player_W_F = j;
        }
        nm = (NotificationManager)getSystemService("notification");
        stopPlayer();
        if (!Build.FINGERPRINT.equals(MixerBoxSharedPreferences.getMobileBuildNumber(this)))
        {
            MixerBoxSharedPreferences.putPlayerType(this, 0);
            playerType = 0;
            MixerBoxSharedPreferences.putMobileBuildNumber(this, Build.FINGERPRINT);
        }
        setVideoPlayer();
        shouldLogin = false;
        openDB();
        if (shouldLogin)
        {
            canPlay = false;
        } else
        {
            canPlay = true;
        }
        if (i != 0 || android.provider.Settings.System.getInt(getContentResolver(), "accelerometer_rotation", 0) != 1)
        {
            setRequestedOrientation(7);
        } else
        {
            setRequestedOrientation(6);
        }
        bundle1 = ((ConnectivityManager)getSystemService("connectivity")).getActiveNetworkInfo();
        obj = new HashMap();
        if (bundle1 != null && bundle1.isConnected())
        {
            if (bundle1.getType() == 1)
            {
                ((Map) (obj)).put("status", "wifi");
            } else
            if (bundle1.getType() == 0)
            {
                ((Map) (obj)).put("status", "mobile");
            } else
            {
                ((Map) (obj)).put("status", "unknown");
            }
        } else
        {
            ((Map) (obj)).put("status", "notConnected");
        }
        FlurryAgent.logEvent("status:network_status", ((Map) (obj)));
        shuffleCount = 0x3b9ac9ff;
        shouldCloseApp = false;
        shouldSendNoti = false;
        hasSetCanAuto = false;
        shouldPlay = 0;
        isReady = false;
        isPageLoaded = false;
        shouldPlayAfterReady = false;
        errorCount = 0;
        canUpdateSeekbar = true;
        arraySystemList = new ArrayList();
        arrayNewsfeed = new ArrayList();
        arraySong = new ArrayList();
        arrayDJs = new ArrayList();
        mySubscriptions = new ArrayList();
        myPlaylists = new ArrayList();
        arrayLocalNotificationList = new ArrayList();
        arrayMyPlaylists = new ArrayList();
        arrayMySubsPlaylists = new ArrayList();
        btnPlaylists = (RelativeLayout)findViewById(0x7f0700d3);
        btnNewsfeed = (RelativeLayout)findViewById(0x7f0700d7);
        btnDiscover = (RelativeLayout)findViewById(0x7f0700da);
        btnDJs = (RelativeLayout)findViewById(0x7f0700de);
        btnSettings = (RelativeLayout)findViewById(0x7f0700e1);
        tvNoInternet = (TextView)findViewById(0x7f0700d2);
        stack = new Stack();
        stackCurrentFragmentId = new Stack();
        fragmentManager = getSupportFragmentManager();
        if (isLogIn)
        {
            MixerBoxUtils.saveAuthLoginInfo(this);
        }
        fragmentPlaylists = new PlaylistsFragment();
        fragmentNewsfeed = new NewsfeedFragment();
        fragmentDiscover = new DiscoverFragment();
        fragmentDJs = new DJsFragment();
        fragmentSettings = new SettingsFragment();
        fragmentSignUp = new SignUpFragment();
        setSignUp();
        if (shouldLogin || !MixerBoxClient.isConnectingToInternet(this) || MixerBoxSharedPreferences.getOnboardingFinish(this)) goto _L2; else goto _L1
_L1:
        if (!isLogIn)
        {
            parseDBMyPlaylists();
            parseDefaultSubsPlaylists();
        }
        setPlaylists(false);
        name = onboardingSubscribeArtists();
        if (name.size() <= 0) goto _L4; else goto _L3
_L3:
        onboardingPlayMusic();
        ((ImageView)findViewById(0x7f0700dd)).setVisibility(0);
        setOnboardingGuide(1, new boolean[0]);
_L8:
        btnPlaylists.setOnClickListener(new _cls2());
        btnNewsfeed.setOnClickListener(new _cls3());
        btnDiscover.setOnClickListener(new _cls4());
        btnDJs.setOnClickListener(new _cls5());
        btnSettings.setOnClickListener(new _cls6());
        preOri = -1;
        (new _cls7(this, 2)).enable();
        bundle1 = new IntentFilter("PlayerBroadcastReceiver");
        mReceiver = new PlayerReceiver();
        registerReceiver(mReceiver, bundle1);
        bundle1 = new IntentFilter("SleepService");
        sr = new SleepReceiver();
        registerReceiver(sr, bundle1);
        myReceiver = new MusicIntentReceiver(null);
        bundle1 = new IntentFilter("android.intent.action.HEADSET_PLUG");
        registerReceiver(myReceiver, bundle1);
        earphoneReceiver = new EarphoneReceiver();
        registerReceiver(earphoneReceiver, new IntentFilter("Earphone"));
        am.registerMediaButtonEventReceiver(new ComponentName(this, com/mixerbox/mixerbox3b/services/RemoteControlReceiver));
        bundle1 = new IntentFilter("MyService");
        r = new MyReceiver();
        registerReceiver(r, bundle1);
        if (!MixerBoxSharedPreferences.getHasRated(this) && MixerBoxSharedPreferences.getOpenTimeCount(this) % 20 == 19)
        {
            AlertDialogFactory.AskRateAlertDialog(this).show();
            MixerBoxSharedPreferences.putHasRated(this, true);
        }
        if (MixerBoxSharedPreferences.getOpenTimeCount(this) <= 2 || MixerBoxSharedPreferences.getLastAd(this).equals(""))
        {
            break MISSING_BLOCK_LABEL_1537;
        }
        bundle1 = new JSONObject(MixerBoxSharedPreferences.getLastAd(this));
        if (!bundle1.equals("") && !bundle1.getString("id").equals(MixerBoxSharedPreferences.getPreviousAdId(this)) && bundle1.getBoolean("open"))
        {
            MixerBoxSharedPreferences.putPreviousAdId(this, bundle1.getString("id"));
            obj = new android.app.AlertDialog.Builder(this);
            myfocusablewebview = new MyFocusableWebView(this);
            myfocusablewebview.getSettings().setJavaScriptEnabled(true);
            myfocusablewebview.setWebChromeClient(new WebChromeClient());
            myfocusablewebview.loadUrl(bundle1.getString("link"));
            myfocusablewebview.setWebViewClient(new _cls8());
            ((android.app.AlertDialog.Builder) (obj)).setView(myfocusablewebview);
            ((android.app.AlertDialog.Builder) (obj)).setNegativeButton(getResources().getString(0x7f08007e), new _cls9());
            ((android.app.AlertDialog.Builder) (obj)).show().getWindow().setSoftInputMode(16);
        }
        return;
_L4:
        FlurryAgent.logEvent("action:no_auto_subscription");
        MixerBoxSharedPreferences.putOnboardingFinish(this, true);
        ((ImageView)findViewById(0x7f0700d6)).setVisibility(0);
_L6:
        setDiscover(new boolean[0]);
        continue; /* Loop/switch isn't completed */
_L2:
        if (isLogIn)
        {
            if (bundle != null && bundle.getInt("tab", 0) != 0)
            {
                checkBundle();
            } else
            {
                if (!MixerBoxSharedPreferences.getTipFirstDiscover(this))
                {
                    continue; /* Loop/switch isn't completed */
                }
                setNewsfeed();
            }
            continue; /* Loop/switch isn't completed */
        }
        parseDBMyPlaylists();
        parseDefaultSubsPlaylists();
        if (bundle != null && bundle.getInt("tab", 0) != 0)
        {
            checkBundle();
            continue; /* Loop/switch isn't completed */
        }
        MixerBoxSharedPreferences.getOpenTimeCount(this);
        if (true) goto _L6; else goto _L5
_L5:
        bundle1;
        bundle1.printStackTrace();
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public boolean onCreateOptionsMenu(Menu menu1)
    {
        menu = menu1;
        ActionBarSettings.ctx = this;
        View view = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f030017, null);
        view.setFocusable(true);
        final AutoCompleteTextView textView = (AutoCompleteTextView)view.findViewById(0x7f070049);
        ImageView imageview = (ImageView)view.findViewById(0x7f07004a);
        textView.setThreshold(1);
        textView.setAdapter(new MixerBoxSearchAutoCompleteAdapter(this, 0x109000a));
        String s = getResources().getText(0x7f08013e).toString();
        SpannableString spannablestring = new SpannableString(s);
        spannablestring.setSpan(new RelativeSizeSpan(0.7F), 0, s.length(), 33);
        textView.setHint(spannablestring);
        textView.setOnItemClickListener(new _cls43());
        imageview.setOnClickListener(new _cls44());
        textView.setOnEditorActionListener(new _cls45());
        textView = menu1.addSubMenu(0, 2, 2, getResources().getString(0x7f0800e0));
        textView.add(0, 6, 6, getResources().getString(0x7f080064));
        textView.add(0, 7, 7, getResources().getString(0x7f080071));
        textView.add(0, 8, 8, getResources().getString(0x7f0800e1));
        textView.add(0, 10, 10, getResources().getString(0x7f080093));
        textView.add(0, 12, 12, getResources().getString(0x7f080053));
        textView.add(0, 11, 11, getResources().getString(0x7f080100));
        textView.getItem().setShowAsAction(6);
        menu1.add(0, 999, 999, getResources().getString(0x7f08008e)).setIcon(0x7f020100).setActionView(view).setShowAsAction(9);
        menu1.add(0, 1, 1, getResources().getString(0x7f080067)).setIcon(0x7f0200e8).setShowAsAction(1);
        menu1.add(0, 3, 3, getResources().getString(0x7f080070)).setIcon(0x7f0200de).setShowAsAction(1);
        menu1.add(0, 13, 13, getResources().getString(0x7f0800e9)).setShowAsAction(6);
        if (!isLogIn)
        {
            ActionBarSettings.hideOption(menu1, 1);
        }
        ActionBarSettings.hideOption(menu1, 2);
        ActionBarSettings.hideOption(menu1, 3);
        ActionBarSettings.hideOption(menu1, 7);
        ActionBarSettings.hideOption(menu1, 8);
        ActionBarSettings.hideOption(menu1, 13);
        menu1.findItem(999).setOnActionExpandListener(new _cls46());
        return true;
    }

    public void onDestroy()
    {
        try
        {
            if (bundle != null && bundle.containsKey("isLogIn") && !hasSetLocalNotification && canSetLocalNotification)
            {
                MixerBoxUtils.logMsg("SET LOCAL NOTIFICATION");
                hasSetLocalNotification = true;
                setLocalNotification();
            }
        }
        catch (Exception exception1) { }
        MixerBoxUtils.logMsg("ON DESTROY");
        uiHelper.onDestroy();
        wv.loadUrl("about:blank");
        isForeground = false;
        if (guideView != null && guideView.isShown())
        {
            guideView.performClick();
        }
        ((AlarmManager)getSystemService("alarm")).cancel(PendingIntent.getBroadcast(this, 0, new Intent("SleepService"), 0));
        unregisterReceiver(mReceiver);
        unregisterReceiver(sr);
        unregisterReceiver(myReceiver);
        unregisterReceiver(earphoneReceiver);
        unregisterReceiver(r);
        am.unregisterMediaButtonEventReceiver(new ComponentName(this, com/mixerbox/mixerbox3b/services/RemoteControlReceiver));
        stopPlayer();
        closeDB();
        ImageLoader.getInstance().clearDiscCache();
        adView.destroy();
        if (binder != null)
        {
            unbindService(conn);
        }
        binder = null;
        try
        {
            if (videoState != 1 && videoState != 3 && bundle != null && bundle.containsKey("isLogIn") && !hasSetLocalNotification && canSetLocalNotification)
            {
                MixerBoxUtils.logMsg("SET LOCAL NOTIFICATION");
                hasSetLocalNotification = true;
                setLocalNotification();
            }
        }
        catch (Exception exception) { }
        super.onDestroy();
    }

    protected void onNewIntent(Intent intent)
    {
        MixerBoxUtils.logMsg("ON NEW INTENT");
        super.onNewIntent(intent);
        setIntent(intent);
        Bundle bundle1;
        try
        {
            bundle1 = new Bundle();
            if (bundle != null)
            {
                bundle1 = new Bundle(bundle);
            }
            intent = intent.getExtras();
            bundle = intent;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            intent = new Intent(this, com/mixerbox/mixerbox3b/MixerBox);
            intent.addFlags(0x4000000);
            startActivity(intent);
            return;
        }
        if (intent == null)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        if (!bundle.containsKey("isLogIn") && bundle1.containsKey("isLogIn"))
        {
            bundle.putBoolean("isLogIn", bundle1.getBoolean("isLogIn"));
        }
        checkBundle();
        return;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        boolean flag;
        boolean flag1;
        flag1 = true;
        flag = flag1;
        menuitem.getItemId();
        JVM INSTR lookupswitch 12: default 120
    //                   1: 174
    //                   2: 374
    //                   3: 417
    //                   6: 429
    //                   7: 127
    //                   8: 459
    //                   10: 569
    //                   11: 800
    //                   12: 536
    //                   13: 828
    //                   999: 151
    //                   16908332: 130;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13
_L1:
        flag = super.onOptionsItemSelected(menuitem);
_L6:
        return flag;
_L13:
        flag = flag1;
        if (stack.size() <= 1) goto _L6; else goto _L14
_L14:
        backToPreviousFragment();
        return true;
_L12:
        ((AutoCompleteTextView)menuitem.getActionView().findViewById(0x7f070049)).setText("");
        return true;
_L2:
        String s3 = getResources().getString(0x7f08010f);
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(2);
        String s = (new StringBuilder()).append(i + 1).append("").toString();
        menuitem = s;
        if (s.length() == 1)
        {
            menuitem = (new StringBuilder()).append("0").append(s).toString();
        }
        i = calendar.get(5);
        String s2 = (new StringBuilder()).append(i).append("").toString();
        s = s2;
        if (s2.length() == 1)
        {
            s = (new StringBuilder()).append("0").append(s2).toString();
        }
        (new CreatePlaylistDialog(this, 1, (new StringBuilder()).append(s3).append(" (").append(calendar.get(1)).append(menuitem).append(s).append(")").toString())).show();
        return true;
_L3:
        menuitem = new HashMap();
        menuitem.put("id", ((SongFragment)stack.lastElement()).currentPlaylist.getPlaylistId());
        FlurryAgent.logEvent("action:playlist_edit", menuitem);
        return true;
_L4:
        FlurryAgent.logEvent("action:invite_friends");
        sendRequestDialog();
        return true;
_L5:
        (new RenamePlaylistDialog(this, ((SongFragment)stack.lastElement()).currentPlaylist.getPlaylistId())).show();
        return true;
_L7:
        if (isLogIn)
        {
            MixerBoxUtils.unsubsPlaylist(this, ((SongFragment)stack.lastElement()).currentPlaylist.getPlaylistId());
            return true;
        } else
        {
            DB.deletePlaylist(((SongFragment)stack.lastElement()).currentPlaylist.getPlaylistId());
            MixerBoxUtils.toastMsg(this, getResources().getString(0x7f0800e9), 1);
            fragmentPlaylists.loadContent();
            return true;
        }
_L10:
        (new RemoveDialog(this, 1, ((SongFragment)stack.lastElement()).currentPlaylist.getPlaylistId(), null, 0)).show();
        return true;
_L8:
        menuitem = ((SongFragment)stack.lastElement()).currentPlaylist.getPlaylistName();
        String s1 = ((SongFragment)stack.lastElement()).currentPlaylist.getPlaylistId();
        Object obj = new HashMap();
        ((Map) (obj)).put("id", s1);
        FlurryAgent.logEvent("action:share_playlist", ((Map) (obj)));
        s1 = (new StringBuilder()).append("http://www.mixerbox.com/list/").append(s1).toString();
        obj = (new StringBuilder()).append(getResources().getString(0x7f0800ba)).append(getResources().getString(0x7f0800b8)).toString();
        String s4 = getResources().getString(0x7f0800b9);
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.SUBJECT", (new StringBuilder()).append(((String) (obj))).append(menuitem).append(s4).toString());
        intent.putExtra("android.intent.extra.TEXT", (new StringBuilder()).append(((String) (obj))).append(menuitem).append(s4).append(s1).toString());
        startActivity(Intent.createChooser(intent, null));
        return true;
_L9:
        setReorder();
        flag = flag1;
        if (MixerBoxSharedPreferences.getTipFirstReorder(this)) goto _L6; else goto _L15
_L15:
        AlertDialogFactory.TipFirstReorderAlertDialog(this).show();
        MixerBoxSharedPreferences.putTipFirstReorder(this);
        return true;
_L11:
        menuitem = ((SortFragment)stack.lastElement()).array;
        if (!isLogIn)
        {
            DB.reorderMyPlaylist(((SortFragment)stack.lastElement()).pid, ((SortFragment)stack.lastElement()).array);
            backToPreviousFragment();
            ((SongFragment)stack.lastElement()).adapter.array = menuitem;
            ((SongFragment)stack.lastElement()).adapter.notifyDataSetChanged();
            MixerBoxUtils.toastMsg(this, getResources().getString(0x7f0800e9), 1);
            return true;
        }
        RequestParams requestparams = new RequestParams();
        for (int j = menuitem.size() - 1; j >= 0; j--)
        {
            requestparams.put((new StringBuilder()).append("music[").append(menuitem.size() - j - 1).append("]").toString(), ((SongItem)menuitem.get(j)).getSongId());
        }

        MixerBoxClient.post(MixerBoxClient.reorderUrl(((SortFragment)stack.lastElement()).pid), requestparams, new _cls47(this));
        backToPreviousFragment();
        ((SongFragment)stack.lastElement()).adapter.array = menuitem;
        ((SongFragment)stack.lastElement()).adapter.notifyDataSetChanged();
        return true;
    }

    public void onPause()
    {
        uiHelper.onPause();
        adView.pause();
        isForeground = false;
        MixerBoxUtils.logMsg("ON PAUSE");
        super.onPause();
    }

    protected void onRestart()
    {
        super.onRestart();
        MixerBoxUtils.logMsg("ON RESTART");
    }

    protected void onResume()
    {
label0:
        {
            super.onResume();
            isForeground = true;
            MixerBoxUtils.logMsg("ON RESUME");
            uiHelper.onResume();
            adView.resume();
            nm.cancel(12321);
            hasSetLocalNotification = false;
            if (shouldChangeBackToWebView && MixerBoxSharedPreferences.getEnableBackgroundPlay(this))
            {
                shouldChangeBackToWebView = false;
                if (playingSong == null || playingSong.getSongSource() != 3 && playingSong.getSongSource() != 2)
                {
                    break label0;
                }
                resetTime = 0;
                shouldResetTime = false;
            }
            return;
        }
        boolean flag;
        if (binder != null)
        {
            flag = binder.getIsPlaying();
            resetTime = binder.getCurrentTime();
        } else
        {
            flag = false;
        }
        shouldResetTime = true;
        binder.pauseMusic();
        if (playingSong != null && !playingSong.getSongYtId().equals(oriVideoId))
        {
            playMusic(false);
            return;
        }
        if (flag)
        {
            playMusic(false);
            return;
        } else
        {
            shouldResetTime = false;
            resetTime = 0;
            return;
        }
    }

    public void onSaveInstanceState(Bundle bundle1)
    {
        super.onSaveInstanceState(bundle1);
        uiHelper.onSaveInstanceState(bundle1);
    }

    protected void onStart()
    {
        super.onStart();
        isForeground = true;
        MixerBoxUtils.logMsg("ON START");
        FlurryAgent.onStartSession(this, "Z8QPYZT3PBG8R6ZNSDXQ");
    }

    protected void onStop()
    {
        try
        {
            if ((MyService.mediaPlayer == null || !MyService.mediaPlayer.isPlaying()) && videoState != 1 && videoState != 3 && bundle != null && bundle.containsKey("isLogIn") && !hasSetLocalNotification && canSetLocalNotification)
            {
                MixerBoxUtils.logMsg("SET LOCAL NOTIFICATION");
                hasSetLocalNotification = true;
                setLocalNotification();
            }
        }
        catch (Exception exception) { }
        MixerBoxUtils.logMsg("ON STOP");
        isForeground = false;
        FlurryAgent.onEndSession(this);
        super.onStop();
    }

    protected void onUserLeaveHint()
    {
        MixerBoxUtils.logMsg("onUserLeaveHint");
        if (rlVideoPlayer.getVisibility() == 0 && MixerBoxSharedPreferences.getEnableBackgroundPlay(this))
        {
            changeToMediaPlayer(true);
        }
        super.onUserLeaveHint();
    }

    public void onboardingPlayMusic()
    {
        if (playerType != 2 || hasSetCanAuto) goto _L2; else goto _L1
_L1:
        rlHint.setVisibility(0);
        wv.setOnTouchListener(null);
        rlPanelTop.setVisibility(8);
        rlPanelBottom.setVisibility(8);
        rlPanelPopup.setVisibility(8);
_L4:
        if (rlVideoPlayer.getVisibility() == 8)
        {
            runOnUiThread(new _cls32());
        }
        if (arrayMySubsPlaylists.size() > 0)
        {
            ((AudioManager)getSystemService("audio")).setStreamVolume(3, 1, 0);
            playMusicWithoutShowingPage((PlaylistItem)arrayMySubsPlaylists.get(0));
        }
        return;
_L2:
        if (playerType == 0)
        {
            tvSwitch.setVisibility(0);
            wv.setOnTouchListener(null);
            rlPanelTop.setVisibility(8);
            rlPanelBottom.setVisibility(8);
            rlPanelPopup.setVisibility(8);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public ArrayList onboardingSubscribeArtists()
    {
        ArrayList arraylist = new ArrayList();
        if (getIntent().getExtras() == null || getIntent().getExtras().getStringArrayList("fav_artists") == null) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        String s;
        JSONArray jsonarray;
        obj = MixerBoxUtils.loadJSONFromAsset(this, "artists.json");
        s = ((String) (obj)).toLowerCase(Locale.ENGLISH);
        jsonarray = new JSONArray();
        obj1 = new ArrayList();
        JSONArray jsonarray1;
        jsonarray1 = new JSONArray(((String) (obj)));
        obj = getIntent().getExtras().getStringArrayList("fav_artists");
        int i = 0;
_L5:
        if (i >= ((ArrayList) (obj)).size())
        {
            break MISSING_BLOCK_LABEL_233;
        }
        if (!s.contains((CharSequence)((ArrayList) (obj)).get(i))) goto _L4; else goto _L3
_L3:
        int j = 0;
_L6:
        if (j < jsonarray1.length())
        {
            obj1 = jsonarray1.getJSONObject(j);
            if (((JSONObject) (obj1)).isNull("artistName") || ((JSONObject) (obj1)).isNull("representativePlaylist") || ((JSONObject) (obj1)).getJSONObject("representativePlaylist").isNull("size") || !((JSONObject) (obj1)).getString("artistName").toLowerCase(Locale.ENGLISH).equals(((ArrayList) (obj)).get(i)))
            {
                break MISSING_BLOCK_LABEL_224;
            }
            jsonarray.put(((JSONObject) (obj1)).getJSONObject("representativePlaylist"));
        }
_L4:
        i++;
          goto _L5
        j++;
          goto _L6
_L10:
        i = 0;
_L8:
        if (i >= jsonarray.length())
        {
            break; /* Loop/switch isn't completed */
        }
        boolean flag;
        obj1 = jsonarray.getJSONObject(i);
        if (((JSONObject) (obj1)).isNull("ref") || ((JSONObject) (obj1)).isNull("title") || ((JSONObject) (obj1)).isNull("owner") || ((JSONObject) (obj1)).isNull("size") || ((JSONObject) (obj1)).isNull("thumbnailHQ"))
        {
            break MISSING_BLOCK_LABEL_318;
        }
        flag = ((JSONObject) (obj1)).isNull("ownerId");
        JSONException jsonexception;
        if (!flag)
        {
            try
            {
                subscribePlaylist(new PlaylistItem(((JSONObject) (obj1)).getString("ref"), ((JSONObject) (obj1)).getString("title"), ((JSONObject) (obj1)).getString("ownerId"), ((JSONObject) (obj1)).getString("owner"), ((JSONObject) (obj1)).getString("size"), "", ((JSONObject) (obj1)).getString("thumbnailHQ"), 2, true), false);
                arraylist.add(((JSONObject) (obj1)).getString("owner"));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                ((JSONException) (obj1)).printStackTrace();
            }
        }
        i++;
        if (true) goto _L8; else goto _L7
_L7:
        break; /* Loop/switch isn't completed */
        jsonexception;
        obj = obj1;
        obj1 = jsonexception;
_L11:
        ((JSONException) (obj1)).printStackTrace();
        if (true) goto _L10; else goto _L9
_L9:
        if (!getIntent().getExtras().containsKey("hasPickedArtist"))
        {
            obj1 = new HashMap();
            ((Map) (obj1)).put("artists", (new StringBuilder()).append("").append(((ArrayList) (obj)).size()).toString());
            ((Map) (obj1)).put("playlists", (new StringBuilder()).append("").append(jsonarray.length()).toString());
            FlurryAgent.logEvent("action:local_artist_auto_subscribe", ((Map) (obj1)));
        }
        (new Thread(rLocalNotificationList)).start();
_L2:
        fragmentPlaylists.loadContent();
        return arraylist;
        obj1;
          goto _L11
    }

    public void parseDBMyPlaylists()
    {
        Object obj;
        int j;
        if (arrayMyPlaylists != null)
        {
            arrayMyPlaylists.clear();
        } else
        {
            arrayMyPlaylists = new ArrayList();
        }
        if (myPlaylists != null)
        {
            myPlaylists.clear();
        } else
        {
            myPlaylists = new ArrayList();
        }
        arrayMyPlaylists.add(new PlaylistItem("-999", getResources().getString(0x7f0800a1), "", "", "0", "", "", 0, false));
        obj = DB.getMyPlaylist();
        j = ((Cursor) (obj)).getCount();
        ((Cursor) (obj)).moveToLast();
        for (int i = 0; i < j; i++)
        {
            int k = DB.getSongCount(((Cursor) (obj)).getString(0));
            String s = DB.getPlaylistCover(((Cursor) (obj)).getString(0));
            arrayMyPlaylists.add(new PlaylistItem(((Cursor) (obj)).getString(0), ((Cursor) (obj)).getString(2), ((Cursor) (obj)).getString(3), ((Cursor) (obj)).getString(4), String.valueOf(k), ((Cursor) (obj)).getString(6), s, ((Cursor) (obj)).getInt(8), false));
            myPlaylists.add(((Cursor) (obj)).getString(0));
            ((Cursor) (obj)).moveToPrevious();
        }

        ((Cursor) (obj)).close();
        obj = (new StringBuilder()).append("http://i.ytimg.com/vi/").append(DB.getLastHistory()).append("/mqdefault.jpg").toString();
        arrayMyPlaylists.add(new PlaylistItem("PLAYLISTHISTORYID", getResources().getString(0x7f080111), "", "", (new StringBuilder()).append("").append(DB.getSongCount("PLAYLISTHISTORYID")).toString(), "", ((String) (obj)), 6, false));
        checkMP3CountAndLoad();
    }

    public void parseDefaultSubsPlaylists()
    {
        String s;
        JSONArray jsonarray;
        JSONObject jsonobject;
        int i;
        if (arrayMySubsPlaylists != null)
        {
            arrayMySubsPlaylists.clear();
        } else
        {
            arrayMySubsPlaylists = new ArrayList();
        }
        if (mySubscriptions != null)
        {
            mySubscriptions.clear();
        } else
        {
            mySubscriptions = new ArrayList();
        }
        if (DB.getPlaylistCount() != 0) goto _L2; else goto _L1
_L1:
        jsonarray = (new JSONObject(getResources().getString(0x7f080154))).getJSONArray("array");
        i = 0;
_L5:
        if (i >= jsonarray.length())
        {
            break MISSING_BLOCK_LABEL_275;
        }
        jsonobject = jsonarray.getJSONObject(i);
        if (!jsonobject.has("cover"))
        {
            break MISSING_BLOCK_LABEL_263;
        }
        s = jsonobject.getString("cover");
_L3:
        arrayMySubsPlaylists.add(new PlaylistItem(jsonobject.getString("_id"), jsonobject.getString("name"), jsonobject.getString("owner"), jsonobject.getString("ownerName"), jsonobject.getString("itemCount"), jsonobject.getString("subsCnt"), s, 2, false));
        mySubscriptions.add(jsonobject.getString("_id"));
        DB.addPlaylist(jsonobject.getString("_id"), jsonobject.getString("name"), jsonobject.getString("owner"), jsonobject.getString("ownerName"), jsonobject.getString("itemCount"), jsonobject.getString("subsCnt"), s, 2, false);
        i++;
        continue; /* Loop/switch isn't completed */
        s = "";
          goto _L3
        JSONException jsonexception;
        jsonexception;
        jsonexception.printStackTrace();
        return;
_L2:
        Cursor cursor = DB.getPlaylist();
        int k = cursor.getCount();
        cursor.moveToLast();
        for (int j = 0; j < k; j++)
        {
            boolean flag = false;
            if (cursor.getInt(9) == 1)
            {
                flag = true;
            }
            arrayMySubsPlaylists.add(new PlaylistItem(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getInt(8), flag));
            mySubscriptions.add(cursor.getString(1));
            cursor.moveToPrevious();
        }

        cursor.close();
        return;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void playLocalMusic()
    {
        if (playerType == 0)
        {
            tvSwitch.setVisibility(8);
            setWebViewTouchListener();
        }
        shouldCheckNotificationBtn = true;
        am.requestAudioFocus(afChangeListener, 3, 1);
        btnPlay.setImageDrawable(getResources().getDrawable(0x7f0200ed));
        ((TextView)findViewById(0x7f0700be)).setText(playingSong.getSongName());
        btnQuality.setVisibility(4);
        btnAdd.setVisibility(4);
        btnShare.setVisibility(4);
        if (rlVideoPlayer.getVisibility() == 8)
        {
            runOnUiThread(new _cls34());
        }
        mHandlerTime.removeMessages(1);
        mHandlerTime.sendEmptyMessageDelayed(1, 4000L);
        shouldSendNoti = true;
        sendNotification();
        if (playingSong.getSongId() != null && playingPlaylist != null && playingPlaylist.getPlaylistType() == 8)
        {
            ivWebViewCover.setVisibility(0);
            ivWebViewCover.setPadding(0, 0, 0, 0);
            int i = playerHeight / 8;
            Object obj = getMP3Thumbnail(playingSong.getSongId());
            if (((String) (obj)).length() > 0)
            {
                android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
                ivWebViewCover.setLayoutParams(layoutparams);
                ImageLoader.getInstance().displayImage(((String) (obj)), ivWebViewCover);
            } else
            {
                ivWebViewCover.setImageResource(0x7f02011d);
                ivWebViewCover.setPadding(i * 3, i * 3, i * 3, i * 3);
            }
            ivSoundCloud.setVisibility(8);
            Exception exception;
            if (MyService.mediaPlayer != null)
            {
                try
                {
                    MyService.mediaPlayer.pause();
                }
                catch (Exception exception2) { }
            }
            setSongTime(Integer.valueOf(playingSong.getSongTime()).intValue());
            if (MyService.mediaPlayer != null)
            {
                MyService.mediaPlayer.reset();
            }
            if (MyService.mediaPlayer != null)
            {
                MyService.mediaPlayer.release();
            }
            MyService.mediaPlayer = null;
            MyService.mediaPlayer = new MediaPlayer();
            try
            {
                MyService.mediaPlayer.setDataSource(playingSong.getSongYtId());
                startService(new Intent(this, com/mixerbox/mixerbox3b/services/MyService));
            }
            catch (Exception exception1) { }
            obj = new HashMap();
            ((Map) (obj)).put("source", "mp3");
            FlurryAgent.logEvent("action:videos_played", ((Map) (obj)));
        } else
        if (playingSong.getSongSource() == 3)
        {
            ivWebViewCover.setVisibility(0);
            ivWebViewCover.setPadding(0, 0, 0, 0);
            ivWebViewCover.setImageResource(0x7f02011d);
            if (playingSong.getSongThumbnail().length() > 0)
            {
                obj = new android.widget.RelativeLayout.LayoutParams(-1, -1);
                ivWebViewCover.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
                ImageLoader.getInstance().displayImage(playingSong.getSongThumbnail(), ivWebViewCover);
                ivWebViewCover.setPadding(0, 0, 0, 0);
            } else
            {
                i = playerHeight / 8;
                ivWebViewCover.setPadding(i * 3, i * 3, i * 3, i * 3);
            }
            ivSoundCloud.setVisibility(0);
            if (MyService.mediaPlayer != null)
            {
                try
                {
                    MyService.mediaPlayer.pause();
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            }
            setSongTime(Integer.valueOf(playingSong.getSongTime()).intValue());
            if (MyService.mediaPlayer != null)
            {
                MyService.mediaPlayer.reset();
            }
            if (MyService.mediaPlayer != null)
            {
                MyService.mediaPlayer.release();
            }
            MyService.mediaPlayer = null;
            MyService.mediaPlayer = new MediaPlayer();
            try
            {
                obj = (new StringBuilder()).append("https://api.soundcloud.com/tracks/").append(playingSong.getSongYtId()).append("/stream?client_id=").append(MixerBoxConstants.SOUNDCLOUD_ID).toString();
                MyService.mediaPlayer.setDataSource(((String) (obj)));
                startService(new Intent(this, com/mixerbox/mixerbox3b/services/MyService));
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
            obj = new HashMap();
            ((Map) (obj)).put("source", "soundcloud");
            FlurryAgent.logEvent("action:videos_played", ((Map) (obj)));
            if (getRequestedOrientation() == 6 && SCREEN_STATE == 1)
            {
                setFullScreen();
            }
            (new Thread(rCheckHistory)).start();
            return;
        }
    }

    public void playMusic(boolean flag)
    {
        if (!canPlay)
        {
            return;
        }
        if (playingSong != null && (playingSong.getSongSource() == 3 || playingSong.getSongSource() == 2))
        {
            wv.loadUrl("javascript:pauseVideo()");
            playLocalMusic();
            return;
        }
        if (playingSong != null && shouldChangeBackToWebView)
        {
            isBackground = true;
            changeToMediaPlayer(false);
            wv.loadUrl("javascript:pauseVideo()");
            return;
        }
        isBackground = false;
        if (MyService.mediaPlayer != null)
        {
            MyService.mediaPlayer.pause();
        }
        if (MyService.mediaPlayer != null)
        {
            MyService.mediaPlayer.reset();
        }
        if (MyService.mediaPlayer != null)
        {
            MyService.mediaPlayer.release();
        }
        MyService.mediaPlayer = null;
        MyService.mediaPlayer = new MediaPlayer();
        ivSoundCloud.setVisibility(8);
        if (!MixerBoxClient.isConnectingToInternet(this))
        {
            stopPlayer();
            return;
        }
        if (tvNoInternet.getVisibility() == 0)
        {
            tvNoInternet.setVisibility(8);
        }
        if (playingSong == null || playingSong.getSongYtId() == null)
        {
            MixerBoxUtils.toastMsg(this, getResources().getString(0x7f080049), 1);
            return;
        }
        if (!isPageLoaded)
        {
            shouldPlayAfterReady = true;
            mHandlerTime.removeMessages(2);
            mHandlerTime.sendEmptyMessageDelayed(2, 5000L);
            return;
        }
        if (!isReady)
        {
            MixerBoxUtils.toastMsg(this, getResources().getString(0x7f080074), 1);
            shouldPlayAfterReady = true;
            return;
        }
        if (errorCount > arrayPlayingSong.size() + 2)
        {
            errorCount = 0;
            return;
        }
        if (getRequestedOrientation() == 6 && SCREEN_STATE == 1)
        {
            setFullScreen();
        }
        mHandlerTime.removeMessages(1);
        mHandlerTime.sendEmptyMessageDelayed(1, 4000L);
        if (flag)
        {
            showPlayerGuide();
        }
        ivWebViewCover.setVisibility(8);
        btnQuality.setVisibility(0);
        btnAdd.setVisibility(0);
        btnShare.setVisibility(0);
        shouldPlayAfterReady = false;
        shouldSendNoti = true;
        sendNotification();
        HashMap hashmap = new HashMap();
        hashmap.put("f", playingSong.getSongYtId());
        hashmap.put("source", "youtube");
        FlurryAgent.logEvent("action:videos_played", hashmap);
        am.requestAudioFocus(afChangeListener, 3, 1);
        currentTime = 0;
        if (playerType == 2 && !hasSetCanAuto)
        {
            rlHint.setVisibility(0);
            wv.setOnTouchListener(null);
            rlPanelTop.setVisibility(8);
            rlPanelBottom.setVisibility(8);
            rlPanelPopup.setVisibility(8);
        } else
        if (playerType == 0)
        {
            tvSwitch.setVisibility(0);
            wv.setOnTouchListener(null);
            rlPanelTop.setVisibility(8);
            rlPanelBottom.setVisibility(8);
            rlPanelPopup.setVisibility(8);
        }
        btnPlay.setImageDrawable(getResources().getDrawable(0x7f0200ed));
        ((TextView)findViewById(0x7f0700be)).setText(playingSong.getSongName());
        ((TextView)findViewById(0x7f0700cb)).setText(MixerBoxUtils.getSongTime(playingSong.getSongTime()));
        if (rlVideoPlayer.getVisibility() == 8)
        {
            runOnUiThread(new _cls35());
        }
        try
        {
            seekbar.setMax(Integer.valueOf(playingSong.getSongTime()).intValue());
        }
        catch (Exception exception)
        {
            seekbar.setMax(600);
        }
        wv.loadUrl((new StringBuilder()).append("javascript:loadVideoById('").append(playingSong.getSongYtId()).append("',0)").toString());
        (new Thread(rCheckHistory)).start();
    }

    void playMusicWithoutShowingPage(PlaylistItem playlistitem)
    {
        MixerBoxClient.get(MixerBoxClient.getSongUrl(playlistitem.getPlaylistId()), null, new _cls33(playlistitem));
    }

    public void playNextSong()
    {
        if (arrayPlayingSong != null)
        {
            if (PLAYER_REPEAT != 1)
            {
                continue;
            }
            if (arrayPlayingSong.size() != 0)
            {
                playingSongIndex = (playingSongIndex + 1) % arrayPlayingSong.size();
                if (PLAYER_SHUFFLE)
                {
                    int i = getShuffleIndex(playingSongIndex);
                    if (i != -1)
                    {
                        int j = arrayPlayingSong.size();
                        playingSong = (SongItem)arrayPlayingSong.get(i % j);
                        playMusic(false);
                        return;
                    }
                } else
                {
                    playingSong = (SongItem)arrayPlayingSong.get(playingSongIndex);
                    playMusic(false);
                    return;
                }
            }
        }
        do
        {
            return;
        } while (arrayPlayingSong.size() == 0);
        if (playingSongIndex >= arrayPlayingSong.size() || playingSongIndex < 0)
        {
            playingSongIndex = 0;
        }
        playingSong = (SongItem)arrayPlayingSong.get(playingSongIndex);
        playMusic(false);
    }

    public void playPreviousSong()
    {
        if (arrayPlayingSong != null)
        {
            if (PLAYER_REPEAT != 1)
            {
                continue;
            }
            playingSongIndex = playingSongIndex - 1;
            if (arrayPlayingSong.size() != 0)
            {
                if (playingSongIndex < 0)
                {
                    playingSongIndex = arrayPlayingSong.size() - 1;
                }
                if (playingSongIndex >= arrayPlayingSong.size())
                {
                    playingSongIndex = 0;
                }
                if (PLAYER_SHUFFLE)
                {
                    int i = getShuffleIndex(playingSongIndex);
                    if (i != -1)
                    {
                        int j = arrayPlayingSong.size();
                        playingSong = (SongItem)arrayPlayingSong.get(i % j);
                        playMusic(false);
                        return;
                    }
                } else
                {
                    playingSong = (SongItem)arrayPlayingSong.get(playingSongIndex);
                    playMusic(false);
                    return;
                }
            }
        }
        do
        {
            return;
        } while (arrayPlayingSong.size() == 0);
        if (playingSongIndex >= arrayPlayingSong.size() || playingSongIndex < 0)
        {
            playingSongIndex = 0;
        }
        playingSong = (SongItem)arrayPlayingSong.get(playingSongIndex);
        playMusic(false);
    }

    public void removeAds()
    {
        adView.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, 3));
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        layoutparams.setMargins(0, 0, 0, 0);
        layoutparams.addRule(12);
        llBottomtab.setLayoutParams(layoutparams);
    }

    void sendNotification()
    {
        boolean flag;
        flag = true;
        if (rlVideoPlayer.getVisibility() == 8 || shouldCloseApp || !shouldSendNoti)
        {
            stopPlayer();
            return;
        }
        if (playingSong == null || playingSong.getSongSource() != 3 && playingSong.getSongSource() != 2) goto _L2; else goto _L1
_L1:
        final boolean b;
        b = flag;
        if (MyService.mediaPlayer != null)
        {
            if (MyService.mediaPlayer.isPlaying())
            {
                b = flag;
            } else
            {
                b = false;
            }
        }
_L4:
        (new Thread(new _cls31())).start();
        return;
_L2:
        if (shouldChangeBackToWebView && binder != null && isBackground)
        {
            b = flag;
            if (!binder.getIsPlaying())
            {
                b = false;
            }
        } else
        {
            b = flag;
            if (shouldPlay != 1)
            {
                b = false;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void sendRequestDialog()
    {
        Bundle bundle1 = new Bundle();
        bundle1.putString("message", getResources().getString(0x7f080080));
        ((com.facebook.widget.WebDialog.RequestsDialogBuilder)(new com.facebook.widget.WebDialog.RequestsDialogBuilder(this, Session.getActiveSession(), bundle1)).setOnCompleteListener(new _cls49())).build().show();
    }

    void setBottomTabBackground()
    {
        btnPlaylists.setBackgroundResource(0x7f02007a);
        btnNewsfeed.setBackgroundResource(0x7f02007a);
        btnDiscover.setBackgroundResource(0x7f02007a);
        btnDJs.setBackgroundResource(0x7f02007a);
        btnSettings.setBackgroundResource(0x7f02007a);
        ((TextView)btnPlaylists.findViewById(0x7f0700d5)).setTextColor(getResources().getColor(0x7f06001b));
        ((ImageView)btnPlaylists.findViewById(0x7f0700d4)).setImageResource(0x7f0200f1);
        ((TextView)btnNewsfeed.findViewById(0x7f0700d9)).setTextColor(getResources().getColor(0x7f06001b));
        ((ImageView)btnNewsfeed.findViewById(0x7f0700d8)).setImageResource(0x7f0200e9);
        ((TextView)btnDiscover.findViewById(0x7f0700dc)).setTextColor(getResources().getColor(0x7f06001b));
        ((ImageView)btnDiscover.findViewById(0x7f0700db)).setImageResource(0x7f020101);
        ((TextView)btnDJs.findViewById(0x7f0700e0)).setTextColor(getResources().getColor(0x7f06001b));
        ((ImageView)btnDJs.findViewById(0x7f0700df)).setImageResource(0x7f0200d6);
        ((TextView)btnSettings.findViewById(0x7f0700e3)).setTextColor(getResources().getColor(0x7f06001b));
        ((ImageView)btnSettings.findViewById(0x7f0700e2)).setImageResource(0x7f020106);
    }

    public void setDJs(int i)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("tab", "navFriends");
        FlurryAgent.logEvent("action:main_tab_nav", hashmap);
        currentFragment = 2;
        if (isLogIn)
        {
            setFragment(fragmentDJs, false);
            if ((arrayDJs == null || arrayDJs.isEmpty()) && i == 1 || fragmentDJs.lv != null && fragmentDJs.lv.getChildCount() == 0)
            {
                try
                {
                    arrayDJs.add(new DividerVectorItem(new JSONObject("{\"type\":\"divider\",\"title\":\"\"}"), this));
                    fragmentDJs.loadContent();
                }
                catch (Exception exception1) { }
                if (fragmentDJs.lv != null)
                {
                    fragmentDJs.lv.setRefreshing();
                }
                try
                {
                    MixerBoxUtils.getDJs(this);
                }
                catch (Exception exception) { }
            }
        } else
        {
            setSignUp();
        }
        btnDJs.setBackgroundResource(0x7f02007c);
        ((TextView)btnDJs.findViewById(0x7f0700e0)).setTextColor(getResources().getColor(0x7f060018));
        ((ImageView)btnDJs.findViewById(0x7f0700df)).setImageResource(0x7f0200d7);
    }

    public transient void setDiscover(boolean aflag[])
    {
        if (arraySystemList != null && arraySystemList.size() == 0)
        {
            arraySystemList.add(new EmptyVectorItem());
        }
        Object obj = (ImageView)findViewById(0x7f0700dd);
        if (((ImageView) (obj)).getVisibility() == 0)
        {
            ((ImageView) (obj)).setVisibility(8);
            ((ImageView)findViewById(0x7f0700e4)).setVisibility(0);
        }
        obj = new HashMap();
        ((Map) (obj)).put("tab", "navSearch");
        FlurryAgent.logEvent("action:main_tab_nav", ((Map) (obj)));
        currentFragment = 1;
        if (arraySystemList == null || arraySystemList.size() <= 1)
        {
            MixerBoxClient.get(MixerBoxClient.getSystemListUrl(this, (new StringBuilder()).append(Locale.getDefault().getLanguage()).append("-").append(Locale.getDefault().getCountry().toLowerCase(Locale.getDefault())).toString()), null, new _cls42(aflag));
        }
        setFragment(fragmentDiscover, false);
        btnDiscover.setBackgroundResource(0x7f02007c);
        ((TextView)btnDiscover.findViewById(0x7f0700dc)).setTextColor(getResources().getColor(0x7f060018));
        ((ImageView)btnDiscover.findViewById(0x7f0700db)).setImageResource(0x7f020102);
    }

    public void setFragment(Fragment fragment, boolean flag)
    {
        Object obj = (FrameLayout)findViewById(0x7f0700d0);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        if (fragment.getClass().getSimpleName().equals("WebFragment"))
        {
            llBottomtab.setVisibility(8);
            layoutparams.addRule(3, 0x7f0700b6);
            ((FrameLayout) (obj)).setLayoutParams(layoutparams);
        } else
        {
            llBottomtab.setVisibility(0);
            layoutparams.addRule(2, 0x7f0700d1);
            layoutparams.addRule(3, 0x7f0700b6);
            ((FrameLayout) (obj)).setLayoutParams(layoutparams);
        }
        obj = fragmentManager.beginTransaction();
        if (!stack.empty())
        {
            ((FragmentTransaction) (obj)).hide((Fragment)stack.lastElement());
        }
        if (!flag)
        {
            stack.clear();
            stackCurrentFragmentId.clear();
            ActionBarSettings.changeToNormalActionBar(this);
            setBottomTabBackground();
        } else
        {
            ActionBarSettings.changeToBackActionBar(this);
        }
        fragmentManager.executePendingTransactions();
        if (fragment.isAdded())
        {
            ((FragmentTransaction) (obj)).show(fragment);
        } else
        {
            ((FragmentTransaction) (obj)).add(0x7f0700d0, fragment);
        }
        ((FragmentTransaction) (obj)).commit();
        fragmentManager.executePendingTransactions();
        stack.add(fragment);
        stackCurrentFragmentId.add(Integer.valueOf(currentFragment));
        if (menu != null)
        {
            ActionBarSettings.setActionBarItems(menu, ((Integer)stackCurrentFragmentId.lastElement()).intValue(), this);
        }
    }

    void setFullScreen()
    {
        if (guideView != null && guideView.isShown())
        {
            guideView.performClick();
            return;
        }
        setRequestedOrientation(6);
        adView.setVisibility(8);
        btnFullScreen.setImageDrawable(getResources().getDrawable(0x7f02010f));
        SCREEN_STATE = 2;
        Object obj;
        if (android.os.Build.VERSION.SDK_INT < 16)
        {
            getWindow().setFlags(1024, 1024);
        } else
        {
            getWindow().getDecorView().setSystemUiVisibility(4);
        }
        obj = (FrameLayout)findViewById(0x7f0700d0);
        getSupportActionBar().hide();
        llBottomtab.setVisibility(8);
        ((FrameLayout) (obj)).setVisibility(8);
        obj = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        rlVideoPlayer.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        showPopupMenu();
        wv.loadUrl((new StringBuilder()).append("javascript:setScreenSize(").append(JS_Player_W_F).append(",").append(JS_Player_H_F).append(")").toString());
    }

    public void setLocalNotification()
    {
        if (MixerBoxSharedPreferences.getShouldSendLocalNotification(this))
        {
            Calendar calendar = Calendar.getInstance();
            AlarmManager alarmmanager = (AlarmManager)getSystemService("alarm");
            Bundle bundle1 = new Bundle();
            Intent intent = new Intent(this, com/mixerbox/mixerbox3b/services/LocalNotificationReceiver);
            String as[];
            String as1[];
            String as2[];
            int i;
            int j;
            if (!MixerBoxSharedPreferences.getHasSetLocalNotification(this))
            {
                MixerBoxSharedPreferences.putHasSetLocalNotification(this, true);
                i = 0;
            } else
            {
                i = 2;
            }
            as = getResources().getStringArray(0x7f0d0001);
            as1 = getResources().getStringArray(0x7f0d0000);
            as2 = getResources().getStringArray(0x7f0d0002);
            j = i;
            while (j < 9) 
            {
                calendar.setTimeInMillis(System.currentTimeMillis());
                bundle1.putInt("serviceId", MixerBoxConstants.LOCAL_NOTIFICATION_ID[j]);
                calendar.set(12, calendar.get(12) + MixerBoxConstants.LOCAL_NOTIFICATION_TIME[j]);
                bundle1.putBoolean("sound", false);
                PendingIntent pendingintent;
                if (arrayLocalNotificationList.size() > j - i)
                {
                    bundle1.putInt("type", 0);
                    bundle1.putString("artist", ((PlaylistItem)arrayLocalNotificationList.get(j - i)).getPlaylistOwnerName());
                    bundle1.putString("playlistName", ((PlaylistItem)arrayLocalNotificationList.get(j - i)).getPlaylistName());
                    bundle1.putString("playlistId", ((PlaylistItem)arrayLocalNotificationList.get(j - i)).getPlaylistId());
                    bundle1.putString("artistId", ((PlaylistItem)arrayLocalNotificationList.get(j - i)).getPlaylistOwnerId());
                    bundle1.putString("itemCount", ((PlaylistItem)arrayLocalNotificationList.get(j - i)).getPlaylistItemCount());
                    bundle1.putString("url", ((PlaylistItem)arrayLocalNotificationList.get(j - i)).getPlaylistCover());
                    bundle1.putInt("tab", 2);
                } else
                {
                    bundle1.putInt("type", 1);
                    bundle1.putString("smallTitle", as1[j]);
                    bundle1.putString("smallContext", as[j]);
                    bundle1.putString("context", as2[j]);
                    bundle1.putInt("tab", MixerBoxConstants.LOCAL_NOTIFICATION_TAB[j]);
                }
                intent.replaceExtras(bundle1);
                pendingintent = PendingIntent.getBroadcast(this, MixerBoxConstants.LOCAL_NOTIFICATION_ID[j], intent, 0x8000000);
                alarmmanager.set(1, calendar.getTimeInMillis(), pendingintent);
                j++;
            }
        }
    }

    public void setLocalNotificationList()
    {
        int j1;
        j1 = 0;
        break MISSING_BLOCK_LABEL_3;
_L2:
        ArrayList arraylist;
        int ai[];
        int k;
        do
        {
            return;
        } while (arrayMySubsPlaylists == null || arrayMySubsPlaylists.size() == 0 || arrayLocalNotificationList.size() >= 9 || !MixerBoxSharedPreferences.getShouldSendLocalNotification(this));
        arraylist = new ArrayList(arrayMySubsPlaylists);
        ai = new int[arraylist.size()];
        for (int i = 0; i < arraylist.size(); i++)
        {
            ai[i] = i;
        }

        Random random = new Random();
        for (int j = 0; j < arraylist.size(); j++)
        {
            int l = random.nextInt(j + 1);
            int k1 = ai[l];
            ai[l] = ai[j];
            ai[j] = k1;
        }

        k = 0;
_L5:
        if (j1 >= arraylist.size()) goto _L2; else goto _L1
_L1:
        int i1;
        i1 = k;
        if (ai[j1] >= arraylist.size())
        {
            break; /* Loop/switch isn't completed */
        }
        i1 = k;
        if (ai[j1] < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        i1 = k;
        if (!((PlaylistItem)arraylist.get(ai[j1])).getIsAlbum())
        {
            break; /* Loop/switch isn't completed */
        }
        i1 = k + 1;
        MixerBoxUtils.getArtistAlbums(this, ((PlaylistItem)arraylist.get(ai[j1])).getPlaylistOwnerId());
        if (i1 > 10) goto _L2; else goto _L3
_L3:
        if (arrayLocalNotificationList.size() >= 9) goto _L2; else goto _L4
_L4:
        j1++;
        k = i1;
          goto _L5
    }

    public void setMP3()
    {
        currentFragment = 14;
        MP3Fragment mp3fragment = new MP3Fragment();
        setFragment(mp3fragment, true);
        mp3fragment.loadContent();
    }

    void setNewsfeed()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("tab", "navNewsFeed");
        FlurryAgent.logEvent("action:main_tab_nav", hashmap);
        currentFragment = 12;
        setFragment(fragmentNewsfeed, false);
        btnNewsfeed.setBackgroundResource(0x7f02007c);
        ((TextView)btnNewsfeed.findViewById(0x7f0700d9)).setTextColor(getResources().getColor(0x7f060018));
        ((ImageView)btnNewsfeed.findViewById(0x7f0700d8)).setImageResource(0x7f0200ea);
        if (arrayNewsfeed.size() <= 5)
        {
            arrayNewsfeed.clear();
            arrayNewsfeed.add(new EmptyVectorItem());
        }
        if (arrayNewsfeed.size() > 1)
        {
            break MISSING_BLOCK_LABEL_402;
        }
        Object obj = DB.getLastPushed();
        if (obj != null)
        {
            try
            {
                obj = new JSONObject((new StringBuilder()).append("{margin: true,type: \"general\",views: {header: {mainText: \"").append(getResources().getString(0x7f080112)).append("\"},main: {mainLink: {type: \"playlist\",ref: \"").append(((PlaylistItem) (obj)).getPlaylistId()).append("\",title: \"").append(((PlaylistItem) (obj)).getPlaylistName()).append("\",owner: \"").append(((PlaylistItem) (obj)).getPlaylistOwnerName()).append("\",size: \"").append(((PlaylistItem) (obj)).getPlaylistItemCount()).append("\",thumbnail: \"").append(((PlaylistItem) (obj)).getPlaylistCover()).append("\",thumbnailHQ: \"").append(((PlaylistItem) (obj)).getPlaylistCover()).append("\",ownerId: \"\"},mainText: \"").append(((PlaylistItem) (obj)).getPlaylistName()).append("\",subText: \"").append(((PlaylistItem) (obj)).getPlaylistOwnerName()).append("\",sideText: \"").append(((PlaylistItem) (obj)).getPlaylistItemCount()).append("\",thumbnail: {style: \"square\",url: \"").append(((PlaylistItem) (obj)).getPlaylistCover()).append("\"}},footer: {bgColor: true,links: [{type: \"button\",title: \"").append(getResources().getString(0x7f0800e7)).append("\",action: \"subscribe\",switch: {type: \"button\",title: \"").append(getResources().getString(0x7f0800e8)).append("\",action: \"unsubscribe\"}},{type: \"dummy\"},{type: \"dummy\"}]}}}").toString());
                MixerBoxUtils.addMyItemToArray(arrayNewsfeed, ((JSONObject) (obj)), this, 0, 0);
            }
            catch (Exception exception)
            {
                MixerBoxUtils.logMsg(exception.toString());
            }
        }
        MixerBoxClient.get(MixerBoxClient.getNewsfeedUrl(this, 0), null, new _cls41(this));
    }

    public transient boolean setOnboardingGuide(int i, boolean aflag[])
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = MixerBoxClient.isConnectingToInternet(this);
        if (flag) goto _L2; else goto _L1
_L1:
        flag = false;
_L42:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        Object obj;
        final WindowManager windowManager;
        windowManager = (WindowManager)getSystemService("window");
        obj = getWindowManager();
        if (android.os.Build.VERSION.SDK_INT < 13) goto _L4; else goto _L3
_L3:
        int j1;
        int k1;
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((WindowManager) (obj)).getDefaultDisplay().getMetrics(displaymetrics);
        k1 = displaymetrics.heightPixels;
        j1 = displaymetrics.widthPixels;
_L6:
        if (guideView != null && guideView.isShown())
        {
            flag = false;
            continue; /* Loop/switch isn't completed */
        }
        break; /* Loop/switch isn't completed */
_L4:
        obj = ((WindowManager) (obj)).getDefaultDisplay();
        k1 = ((Display) (obj)).getHeight();
        j1 = ((Display) (obj)).getWidth();
        if (true) goto _L6; else goto _L5
_L38:
        TypedValue typedvalue = new TypedValue();
        if (!getTheme().resolveAttribute(0x10102eb, typedvalue, true)) goto _L8; else goto _L7
_L7:
        int i1 = TypedValue.complexToDimensionPixelSize(typedvalue.data, getResources().getDisplayMetrics());
_L37:
        if (i != 1) goto _L10; else goto _L9
_L9:
        if (name != null && name.size() != 0) goto _L12; else goto _L11
_L17:
        int l1;
        if (l1 == 0) goto _L14; else goto _L13
_L13:
        int l = (int)((double)(76F * getResources().getDisplayMetrics().density) * 1.25D);
        l1 = (int)((double)l * 0.80000000000000004D);
        int k = JS_Player_H + l + i1;
        i1 = l1;
_L18:
        int j;
        if (j != 1) goto _L16; else goto _L15
_L15:
        aflag = (new StringBuilder()).append(getResources().getString(0x7f08012c)).append(String.format((new StringBuilder()).append("\n").append(getResources().getString(0x7f080136)).toString(), new Object[] {
            Integer.valueOf(arrayMySubsPlaylists.size()), obj
        })).toString();
        j = i1;
_L19:
        guideView = new DrawView(this, j1, k1, j, k, l, i, aflag);
        guideView.invalidate();
        aflag = new android.view.WindowManager.LayoutParams(j1, k1, 2003, 8, -3);
        aflag.x = 0;
        aflag.y = 0;
        windowManager.addView(guideView, aflag);
        guideView.setOnClickListener(new _cls10());
        flag = true;
        continue; /* Loop/switch isn't completed */
_L12:
        if (name.size() != 1)
        {
            break MISSING_BLOCK_LABEL_463;
        }
        obj = (String)name.get(0);
        j = 1;
        aflag = "";
          goto _L17
        obj = (String)name.get(0);
        aflag = (String)name.get(1);
        j = 2;
          goto _L17
_L14:
        l = (int)((double)(76F * getResources().getDisplayMetrics().density) * 1.25D);
        k = (int)((double)l * 0.80000000000000004D);
        l1 = l + i1;
        i1 = k;
        k = l1;
          goto _L18
_L16:
        if (j != 2)
        {
            break MISSING_BLOCK_LABEL_2498;
        }
        aflag = (new StringBuilder()).append(getResources().getString(0x7f08012c)).append(String.format((new StringBuilder()).append("\n").append(getResources().getString(0x7f080137)).toString(), new Object[] {
            Integer.valueOf(arrayMySubsPlaylists.size()), obj, aflag
        })).toString();
        j = i1;
          goto _L19
_L10:
        if (i != 2)
        {
            break MISSING_BLOCK_LABEL_771;
        }
        if (l1 == 0)
        {
            break MISSING_BLOCK_LABEL_716;
        }
        j = (int)((double)llBottomtab.getHeight() * 0.90000000000000002D);
        l = (int)((double)(JS_Player_H_F / 5) * 0.59999999999999998D);
        k = JS_Player_W_F - j;
        j = (int)((double)(JS_Player_H_F / 5) * 1.5D);
_L20:
        aflag = getResources().getString(0x7f080138);
          goto _L19
        j = (int)((double)llBottomtab.getHeight() * 0.90000000000000002D);
        l = (int)((double)(JS_Player_W_F / 5) * 0.59999999999999998D);
        k = JS_Player_H_F - j;
        j = (int)((double)(JS_Player_W_F / 5) * 1.5D);
          goto _L20
        if (i != 3)
        {
            break MISSING_BLOCK_LABEL_907;
        }
        if (l1 == 0) goto _L22; else goto _L21
_L21:
        int i2;
        l1 = (int)((double)JS_Player_H_F * 0.28000000000000003D);
        i2 = (int)((double)JS_Player_H_F * 0.25D);
        i1 = l1 + i1;
        j = i2;
        k = i1;
        l = l1;
        if (rlVideoPlayer.getVisibility() != 0)
        {
            break MISSING_BLOCK_LABEL_851;
        }
        k = i1 + JS_Player_H;
        l = l1;
        j = i2;
_L23:
        aflag = getResources().getString(0x7f080139);
          goto _L19
_L22:
        l = (int)((double)(76F * getResources().getDisplayMetrics().density) * 1.25D);
        j = (int)((double)l * 0.80000000000000004D);
        k = l + i1;
          goto _L23
        if (i != 4)
        {
            break MISSING_BLOCK_LABEL_1030;
        }
        if (l1 == 0) goto _L25; else goto _L24
_L24:
        l = (int)((double)i1 * 0.59999999999999998D);
        k = i1 / 2;
        j = (int)((double)JS_Player_H_F - (double)i1 * 1.5D - (double)(13F * getResources().getDisplayMetrics().density));
_L26:
        aflag = getResources().getString(0x7f08013a);
          goto _L19
_L25:
        l = (int)((double)i1 * 0.80000000000000004D);
        k = i1 / 2;
        j = (int)((double)JS_Player_W_F - (double)i1 * 1.5D - (double)(21F * getResources().getDisplayMetrics().density));
          goto _L26
        if (i != 5)
        {
            break MISSING_BLOCK_LABEL_1186;
        }
        if (l1 == 0)
        {
            break MISSING_BLOCK_LABEL_1138;
        }
        l1 = JS_Player_H_F / 6;
        i2 = (int)((float)i1 + 22F * getResources().getDisplayMetrics().density);
        i1 = (int)((double)(JS_Player_H_F / 6) * 0.80000000000000004D);
        j = l1;
        k = i2;
        l = i1;
        if (rlVideoPlayer.getVisibility() != 0)
        {
            break MISSING_BLOCK_LABEL_1124;
        }
        k = i2 + JS_Player_H;
        l = i1;
        j = l1;
_L27:
        aflag = getResources().getString(0x7f08013b);
          goto _L19
        j = JS_Player_W_F / 6;
        k = (int)((float)i1 + 22F * getResources().getDisplayMetrics().density);
        l = (int)((double)(JS_Player_W_F / 6) * 0.80000000000000004D);
          goto _L27
        if (i != 6)
        {
            break MISSING_BLOCK_LABEL_1343;
        }
        if (l1 == 0)
        {
            break MISSING_BLOCK_LABEL_1295;
        }
        l1 = JS_Player_H_F / 6;
        i2 = (int)((float)i1 + 22F * getResources().getDisplayMetrics().density);
        i1 = (int)((double)(JS_Player_H_F / 6) * 0.80000000000000004D);
        j = l1;
        k = i2;
        l = i1;
        if (rlVideoPlayer.getVisibility() != 0)
        {
            break MISSING_BLOCK_LABEL_1281;
        }
        k = i2 + JS_Player_H;
        l = i1;
        j = l1;
_L28:
        aflag = getResources().getString(0x7f08013c);
          goto _L19
        j = JS_Player_W_F / 6;
        k = (int)((float)i1 + 22F * getResources().getDisplayMetrics().density);
        l = (int)((double)(JS_Player_W_F / 6) * 0.80000000000000004D);
          goto _L28
        if (i != 7)
        {
            break MISSING_BLOCK_LABEL_1475;
        }
        if (l1 == 0)
        {
            break MISSING_BLOCK_LABEL_1420;
        }
        j = (int)((double)llBottomtab.getHeight() * 0.90000000000000002D);
        l = (int)((double)(JS_Player_H_F / 5) * 0.59999999999999998D);
        k = JS_Player_W_F - j;
        j = (int)((double)(JS_Player_H_F / 5) * 0.5D);
_L29:
        aflag = getResources().getString(0x7f08013d);
          goto _L19
        j = (int)((double)llBottomtab.getHeight() * 0.90000000000000002D);
        l = (int)((double)(JS_Player_W_F / 5) * 0.59999999999999998D);
        k = JS_Player_H_F - j;
        j = (int)((double)(JS_Player_W_F / 5) * 0.5D);
          goto _L29
        if (i != 8)
        {
            break MISSING_BLOCK_LABEL_1525;
        }
        j = (int)((double)i1 * 1.8D);
        k = (int)((double)i1 * 0.5D);
        l = (int)((double)i1 * 0.69999999999999996D);
        aflag = getResources().getString(0x7f08013e);
          goto _L19
        if (i != 9)
        {
            break MISSING_BLOCK_LABEL_1744;
        }
        if (l1 == 0)
        {
            break MISSING_BLOCK_LABEL_1665;
        }
        l1 = (int)((float)JS_Player_H_F - 19F * getResources().getDisplayMetrics().density);
        i2 = (int)(15F * getResources().getDisplayMetrics().scaledDensity + 90F * getResources().getDisplayMetrics().density + (float)i1);
        i1 = (int)(25F * getResources().getDisplayMetrics().density);
        j = l1;
        k = i2;
        l = i1;
        if (rlVideoPlayer.getVisibility() != 0)
        {
            break MISSING_BLOCK_LABEL_1651;
        }
        k = i2 + JS_Player_H;
        l = i1;
        j = l1;
_L30:
        aflag = getResources().getString(0x7f08013f);
          goto _L19
        j = (int)((float)JS_Player_W_F - 19F * getResources().getDisplayMetrics().density);
        k = (int)(15F * getResources().getDisplayMetrics().scaledDensity + 90F * getResources().getDisplayMetrics().density + (float)i1);
        l = (int)(25F * getResources().getDisplayMetrics().density);
          goto _L30
        if (i != 10)
        {
            break MISSING_BLOCK_LABEL_2101;
        }
        if (l1 == 0) goto _L32; else goto _L31
_L31:
        l1 = (int)((float)JS_Player_H_F - 17F * getResources().getDisplayMetrics().density);
        j = (int)(18F * getResources().getDisplayMetrics().scaledDensity + 75F * getResources().getDisplayMetrics().density + (float)i1);
        i2 = (int)(30F * getResources().getDisplayMetrics().density);
        i1 = j;
        if (rlVideoPlayer.getVisibility() == 0)
        {
            i1 = j + JS_Player_H;
        }
        j = l1;
        k = i1;
        l = i2;
        if (aflag == null)
        {
            break MISSING_BLOCK_LABEL_1931;
        }
        j = l1;
        k = i1;
        l = i2;
        if (!aflag[0])
        {
            break MISSING_BLOCK_LABEL_1931;
        }
        k = i1 + (int)(18F * getResources().getDisplayMetrics().scaledDensity + 100F * getResources().getDisplayMetrics().density);
        l = i2;
        j = l1;
_L34:
        aflag = getResources().getString(0x7f080140);
          goto _L19
_L32:
        l1 = (int)((float)JS_Player_W_F - 17F * getResources().getDisplayMetrics().density);
        i2 = (int)(18F * getResources().getDisplayMetrics().scaledDensity + 75F * getResources().getDisplayMetrics().density + (float)i1);
        i1 = (int)(30F * getResources().getDisplayMetrics().density);
        j = l1;
        k = i2;
        l = i1;
        if (aflag == null) goto _L34; else goto _L33
_L33:
        j = l1;
        k = i2;
        l = i1;
        if (!aflag[0]) goto _L34; else goto _L35
_L35:
        k = i2 + (int)(15F * getResources().getDisplayMetrics().scaledDensity + 100F * getResources().getDisplayMetrics().density);
        j = l1;
        l = i1;
          goto _L34
        if (i != 12)
        {
            break MISSING_BLOCK_LABEL_2209;
        }
        if (l1 == 0)
        {
            break MISSING_BLOCK_LABEL_2509;
        }
        mHandlerTime.removeMessages(1);
        rlPanelTop.setVisibility(0);
        rlPanelPopup.setVisibility(8);
        rlPanelBottom.setVisibility(0);
        btnExpand.setImageDrawable(getResources().getDrawable(0x7f0200db));
        l = (int)(17F * getResources().getDisplayMetrics().density);
        j = JS_Player_H_F - l;
        k = i1 + l;
        aflag = getResources().getString(0x7f080141);
          goto _L19
        if (i != 13)
        {
            break MISSING_BLOCK_LABEL_2321;
        }
        if (l1 == 0)
        {
            break MISSING_BLOCK_LABEL_2515;
        }
        mHandlerTime.removeMessages(1);
        rlPanelTop.setVisibility(0);
        rlPanelPopup.setVisibility(0);
        rlPanelBottom.setVisibility(0);
        btnExpand.setImageDrawable(getResources().getDrawable(0x7f0200d3));
        l = JS_Player_H_F / 10;
        j = JS_Player_H_F / 2;
        k = (int)((float)i1 + 52F * getResources().getDisplayMetrics().density);
        aflag = getResources().getString(0x7f080142);
          goto _L19
        aflag = ((boolean []) (obj));
        if (i != 14) goto _L19; else goto _L36
_L36:
        if (l1 == 0)
        {
            break MISSING_BLOCK_LABEL_2435;
        }
        mHandlerTime.removeMessages(1);
        rlPanelTop.setVisibility(0);
        rlPanelPopup.setVisibility(0);
        rlPanelBottom.setVisibility(0);
        btnExpand.setImageDrawable(getResources().getDrawable(0x7f0200d3));
        l = JS_Player_H_F / 6;
        j = JS_Player_H_F / 5;
        k = (int)((float)i1 + 52F * getResources().getDisplayMetrics().density);
        aflag = getResources().getString(0x7f080143);
          goto _L19
        flag = false;
        continue; /* Loop/switch isn't completed */
        aflag;
        throw aflag;
_L8:
        i1 = 0;
          goto _L37
_L40:
        l1 = 1;
          goto _L38
_L5:
        j = 0;
        k = 0;
        l = 0;
        obj = "";
        if (j1 <= k1) goto _L40; else goto _L39
_L39:
        l1 = 0;
          goto _L38
_L11:
        j = 0;
        obj = "";
        aflag = "";
          goto _L17
        aflag = "";
        j = i1;
          goto _L19
        flag = false;
        continue; /* Loop/switch isn't completed */
        flag = false;
        if (true) goto _L42; else goto _L41
_L41:
    }

    public void setPlaylists(boolean flag)
    {
        Object obj = (ImageView)findViewById(0x7f0700d6);
        if (((ImageView) (obj)).getVisibility() == 0)
        {
            ((ImageView)findViewById(0x7f0700e4)).setVisibility(0);
            ((ImageView) (obj)).setVisibility(8);
        }
        obj = new HashMap();
        ((Map) (obj)).put("tab", "navPlaylists");
        FlurryAgent.logEvent("action:main_tab_nav", ((Map) (obj)));
        currentFragment = 0;
        fragmentPlaylists.loadContent();
        setFragment(fragmentPlaylists, flag);
        if (!flag)
        {
            btnPlaylists.setBackgroundResource(0x7f02007c);
            ((TextView)btnPlaylists.findViewById(0x7f0700d5)).setTextColor(getResources().getColor(0x7f060018));
            ((ImageView)btnPlaylists.findViewById(0x7f0700d4)).setImageResource(0x7f0200f3);
        }
        if (MixerBoxSharedPreferences.getOnboardingFinish(this) && !MixerBoxSharedPreferences.getTipSecondPlaylist(this))
        {
            if (menu != null)
            {
                MenuItem menuitem = menu.findItem(999);
                if (menuitem != null && menuitem.isActionViewExpanded())
                {
                    menuitem.collapseActionView();
                }
            }
            setOnboardingGuide(4, new boolean[0]);
        }
    }

    public void setReorder()
    {
        SortFragment sortfragment = new SortFragment();
        try
        {
            sortfragment.ctx = this;
            sortfragment.pid = ((SongFragment)stack.lastElement()).currentPlaylist.getPlaylistId();
            sortfragment.array = ((SongFragment)stack.lastElement()).adapter.array;
            sortfragment.setListAdapter();
        }
        catch (Exception exception)
        {
            MixerBoxUtils.toastMsg(this, getResources().getString(0x7f080048), 0);
            return;
        }
        currentFragment = 11;
        setFragment(sortfragment, true);
        FlurryAgent.logEvent("action:rearrange");
    }

    void setSettings()
    {
        Object obj = (ImageView)findViewById(0x7f0700e4);
        if (((ImageView) (obj)).getVisibility() == 0)
        {
            ((ImageView) (obj)).setVisibility(8);
        }
        obj = new HashMap();
        ((Map) (obj)).put("tab", "navSettings");
        FlurryAgent.logEvent("action:main_tab_nav", ((Map) (obj)));
        currentFragment = 3;
        setFragment(fragmentSettings, false);
        try
        {
            fragmentSettings.loadContent();
        }
        catch (Exception exception) { }
        btnSettings.setBackgroundResource(0x7f02007c);
        ((TextView)btnSettings.findViewById(0x7f0700e3)).setTextColor(getResources().getColor(0x7f060018));
        ((ImageView)btnSettings.findViewById(0x7f0700e2)).setImageResource(0x7f020107);
    }

    void setSignUp()
    {
        setFragment(fragmentSignUp, false);
    }

    public SongFragment setSong(String s)
    {
        SongFragment songfragment = new SongFragment();
        FlurryAgent.logEvent("page:playlist");
        if (myPlaylists.contains(s))
        {
            currentFragment = 4;
        } else
        if (mySubscriptions.contains(s))
        {
            currentFragment = 5;
        } else
        {
            currentFragment = 7;
        }
        setFragment(songfragment, true);
        if (!s.equals("PLAYLISTHISTORYID") && !myPlaylists.contains(s) && !mySubscriptions.contains(s) && !s.equals("PLAYLISTMP3ID") && !s.equals("PLAYLISTMP3PLAYLISTID") && !s.equals("PLAYLISTMP3ALBUMID") && !s.equals("PLAYLISTMP3ARTISTID") && !MixerBoxSharedPreferences.getTipFirstOthersPlaylist(this))
        {
            setOnboardingGuide(6, new boolean[0]);
        }
        return songfragment;
    }

    public void setSongTime(int i)
    {
        ((TextView)findViewById(0x7f0700cb)).setText(MixerBoxUtils.getSongTime(String.valueOf(i)));
        try
        {
            seekbar.setMax(i);
            return;
        }
        catch (Exception exception)
        {
            seekbar.setMax(600);
        }
    }

    void setUnFullScreen(boolean flag)
    {
        if (flag)
        {
            setRequestedOrientation(1);
        }
        adView.setVisibility(0);
        btnFullScreen.setImageDrawable(getResources().getDrawable(0x7f0200dc));
        SCREEN_STATE = 1;
        Object obj;
        if (android.os.Build.VERSION.SDK_INT < 16)
        {
            getWindow().clearFlags(1024);
        } else
        {
            getWindow().getDecorView().setSystemUiVisibility(0);
        }
        wv.loadUrl((new StringBuilder()).append("javascript:setScreenSize(").append(JS_Player_W).append(",").append(JS_Player_H).append(")").toString());
        obj = (FrameLayout)findViewById(0x7f0700d0);
        if (currentFragment != 8 && currentFragment != 9)
        {
            llBottomtab.setVisibility(0);
        }
        ((FrameLayout) (obj)).setVisibility(0);
        obj = new android.widget.RelativeLayout.LayoutParams(-1, playerHeight);
        rlVideoPlayer.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        getSupportActionBar().show();
    }

    public VectorFragment setVector(String s, String s1, int i, String s2)
    {
        currentFragment = 10;
        VectorFragment vectorfragment = new VectorFragment();
        vectorfragment.vectorId = s;
        vectorfragment.vectorType = s1;
        vectorfragment.vectorPageType = i;
        vectorfragment.title = s2;
        setFragment(vectorfragment, true);
        s1 = new HashMap();
        s1.put("vectorId", s);
        FlurryAgent.logEvent("page:vector", s1);
        return vectorfragment;
    }

    public void setVideoPlayer()
    {
        if (binder == null && MixerBoxSharedPreferences.getEnableBackgroundPlay(this))
        {
            Intent intent = new Intent(this, com/mixerbox/mixerbox3b/services/WindowPlayerService);
            intent.putExtra("messenger", messenger);
            bindService(intent, conn, 1);
        }
        final Object btnRepeat;
        WebSettings websettings;
        MyJavaScriptInterface myjavascriptinterface;
        int i;
        int j;
        if (JS_Player_H_F > JS_Player_W_F)
        {
            i = JS_Player_H_F;
            j = JS_Player_W_F;
        } else
        {
            i = JS_Player_W_F;
            j = JS_Player_H_F;
        }
        if (i > 1500)
        {
            playerHeight = i / 5;
        } else
        {
            playerHeight = 220;
        }
        tvSwitch = (TextView)findViewById(0x7f0700cd);
        tvNoNet = (TextView)findViewById(0x7f0700ce);
        rlHint = (RelativeLayout)findViewById(0x7f0700e5);
        rlPanelPopup = (LinearLayout)findViewById(0x7f0700bf);
        rlPanelTop = (RelativeLayout)findViewById(0x7f0700bb);
        rlPanelBottom = (RelativeLayout)findViewById(0x7f0700c5);
        rlVideoPlayer = (RelativeLayout)findViewById(0x7f0700b6);
        btnRepeat = new android.widget.RelativeLayout.LayoutParams(-1, playerHeight);
        rlVideoPlayer.setLayoutParams(((android.view.ViewGroup.LayoutParams) (btnRepeat)));
        wv = (WebView)findViewById(0x7f0700b7);
        ivWebViewCover = (ImageView)findViewById(0x7f0700b8);
        ivSoundCloud = (ImageView)findViewById(0x7f0700b9);
        i = MixerBoxSharedPreferences.getPlayerType(this);
        playerType = i;
        if (i == 0)
        {
            if (android.os.Build.VERSION.SDK_INT >= 17)
            {
                MixerBoxSharedPreferences.putPlayerType(this, 1);
                playerType = 1;
            } else
            {
                tvSwitch.setVisibility(0);
            }
        }
        if (playerType == 2)
        {
            btnRepeat = "http://static.mixerbox.com/yt_android.min.b.v7.html";
            rlPanelTop.setVisibility(8);
            rlPanelBottom.setVisibility(8);
            setWebViewTouchListener();
        } else
        {
            btnRepeat = "http://static.mixerbox.com/yt_android.min.a.v7.html";
            setWebViewTouchListener();
        }
        tvSwitch.setOnClickListener(new _cls16());
        websettings = wv.getSettings();
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            websettings.setMediaPlaybackRequiresUserGesture(false);
        }
        websettings.setJavaScriptEnabled(true);
        myjavascriptinterface = new MyJavaScriptInterface(this);
        wv.addJavascriptInterface(myjavascriptinterface, "AndroidFunction");
        websettings.setDomStorageEnabled(true);
        websettings.setDatabaseEnabled(true);
        if (android.os.Build.VERSION.SDK_INT < 18)
        {
            websettings.setPluginState(android.webkit.WebSettings.PluginState.ON);
        }
        websettings.setCacheMode(2);
        wv.loadUrl(((String) (btnRepeat)));
        wv.setWebViewClient(new WebViewClient());
        wv.setWebChromeClient(new WebChromeClient());
        wv.setPadding(0, 0, 0, 0);
        wv.getSettings().setLoadWithOverviewMode(true);
        wv.getSettings().setUseWideViewPort(true);
        wv.setVerticalScrollBarEnabled(false);
        wv.setHorizontalScrollBarEnabled(false);
        videoState = -1;
        PLAYER_REPEAT = 1;
        PLAYER_SHUFFLE = false;
        mHandlerTime = new MyHandler();
        SCREEN_STATE = 1;
        JS_Player_H = playerHeight;
        JS_Player_W = (int)(((double)playerHeight * 16D) / 9D);
        if (j < JS_Player_W)
        {
            JS_Player_W = j;
        }
        wv.loadUrl((new StringBuilder()).append("javascript:setScreenSize(").append(JS_Player_W).append(",").append(JS_Player_H).append(")").toString());
        btnExpand = (ImageButton)findViewById(0x7f0700bd);
        btnExpand.setOnClickListener(new _cls17());
        ((ImageButton)findViewById(0x7f0700bc)).setOnClickListener(new _cls18());
        btnPlay = (ImageButton)findViewById(0x7f0700c7);
        seekbar = (SeekBar)findViewById(0x7f0700cc);
        btnPlay.setOnClickListener(new _cls19());
        ((ImageButton)findViewById(0x7f0700c8)).setOnClickListener(new _cls20());
        ((ImageButton)findViewById(0x7f0700c6)).setOnClickListener(new _cls21());
        btnAdd = (ImageButton)findViewById(0x7f0700c3);
        btnAdd.setOnClickListener(new _cls22());
        btnRepeat = (ImageButton)findViewById(0x7f0700c1);
        ((ImageButton) (btnRepeat)).setOnClickListener(new _cls23());
        btnRepeat = (ImageButton)findViewById(0x7f0700c0);
        ((ImageButton) (btnRepeat)).setOnClickListener(new _cls24());
        btnFullScreen = (ImageButton)findViewById(0x7f0700c9);
        btnFullScreen.setOnClickListener(new _cls25());
        btnQuality = (ImageButton)findViewById(0x7f0700c2);
        if (MixerBoxSharedPreferences.getHighQuality(this))
        {
            btnQuality.setImageDrawable(getResources().getDrawable(0x7f0200dd));
        } else
        {
            btnQuality.setImageDrawable(getResources().getDrawable(0x7f02010d));
        }
        btnQuality.setOnClickListener(new _cls26());
        btnShare = (ImageButton)findViewById(0x7f0700c4);
        btnShare.setOnClickListener(new _cls27());
        tvTimeStart = (TextView)findViewById(0x7f0700ca);
        seekbar.setOnSeekBarChangeListener(new _cls28());
    }

    public void setWeb(String s)
    {
        currentFragment = 13;
        setFragment(WebFragment.newInstance(s), true);
    }

    public void showPopupMenu()
    {
        mHandlerTime.removeMessages(1);
        mHandlerTime.sendEmptyMessageDelayed(1, 4000L);
        rlPanelTop.setVisibility(0);
        rlPanelBottom.setVisibility(0);
        rlPanelPopup.setVisibility(0);
        btnExpand.setImageDrawable(getResources().getDrawable(0x7f0200d3));
    }

    public void stopPlayer()
    {
        if (binder != null)
        {
            binder.pauseMusic();
        }
        if (MyService.mediaPlayer != null)
        {
            MyService.mediaPlayer.pause();
        }
        if (MyService.mediaPlayer != null)
        {
            MyService.mediaPlayer.reset();
        }
        if (MyService.mediaPlayer != null)
        {
            MyService.mediaPlayer.release();
        }
        MyService.mediaPlayer = null;
        MyService.mediaPlayer = new MediaPlayer();
        stopService(new Intent(this, com/mixerbox/mixerbox3b/services/PlayerService));
        stopService(new Intent(this, com/mixerbox/mixerbox3b/services/WindowPlayerService));
        stopService(new Intent(this, com/mixerbox/mixerbox3b/services/MyService));
        try
        {
            nm.cancel(16);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void subscribePlaylist(PlaylistItem playlistitem, boolean flag)
    {
        if (isLogIn)
        {
            MixerBoxUtils.subsPlaylist(this, playlistitem.getPlaylistId(), flag);
        } else
        {
            DB.addPlaylist(playlistitem.getPlaylistId(), playlistitem.getPlaylistName(), playlistitem.getPlaylistOwnerId(), playlistitem.getPlaylistOwnerName(), playlistitem.getPlaylistItemCount(), playlistitem.getPlaylistSubsCount(), playlistitem.getPlaylistCover(), 2, playlistitem.getIsAlbum());
            arrayMySubsPlaylists.add(new PlaylistItem(playlistitem.getPlaylistId(), playlistitem.getPlaylistName(), playlistitem.getPlaylistOwnerId(), playlistitem.getPlaylistOwnerName(), playlistitem.getPlaylistItemCount(), playlistitem.getPlaylistSubsCount(), playlistitem.getPlaylistCover(), 2, playlistitem.getIsAlbum()));
            mySubscriptions.add(playlistitem.getPlaylistId());
            if (flag)
            {
                MixerBoxUtils.toastMsg(this, getResources().getString(0x7f0800e9), 1);
                (new Thread(rLocalNotificationList)).start();
                fragmentPlaylists.loadContent();
                if (!MixerBoxSharedPreferences.getTipFirstSubscribe(this))
                {
                    setOnboardingGuide(7, new boolean[0]);
                    return;
                }
            }
        }
    }

    public void updateTime(int i)
    {
        currentTime = i;
        if (seekbar.getMax() >= i && canUpdateSeekbar)
        {
            seekbar.setProgress(i);
        }
        if (canUpdateSeekbar)
        {
            tvTimeStart.setText(MixerBoxUtils.getSongTime(String.valueOf(i)));
        }
        if (rlPanelTop.getVisibility() == 8)
        {
            rlPanelPopup.setVisibility(8);
        }
        if (shouldCheckNotificationBtn && (i == 1 || i == 2) && playingSong != null && (playingSong.getSongSource() == 3 || playingSong.getSongSource() == 2))
        {
            shouldCheckNotificationBtn = false;
            sendNotification();
        }
    }










    private class _cls1
        implements com.facebook.Session.StatusCallback
    {

        final MainPage this$0;

        public void call(Session session, SessionState sessionstate, Exception exception)
        {
            onSessionStateChange(session, sessionstate, exception);
        }

        _cls1()
        {
            this$0 = MainPage.this;
            super();
        }
    }


    private class _cls14
        implements ServiceConnection
    {

        final MainPage this$0;

        public void onServiceConnected(ComponentName componentname, IBinder ibinder)
        {
            binder = (com.mixerbox.mixerbox3b.services.WindowPlayerService.MyBinder)ibinder;
        }

        public void onServiceDisconnected(ComponentName componentname)
        {
            binder = null;
        }

        _cls14()
        {
            this$0 = MainPage.this;
            super();
        }
    }


    private class _cls15 extends Handler
    {

        final MainPage this$0;

        public void handleMessage(Message message)
        {
            playNextSong();
        }

        _cls15()
        {
            this$0 = MainPage.this;
            super();
        }
    }


    private class _cls29 extends PhoneStateListener
    {

        protected boolean mWasPlayingWhenCalled;
        final MainPage this$0;

        public void onCallStateChanged(int i, String s)
        {
            if (rlVideoPlayer.getVisibility() == 8)
            {
                return;
            }
            if (i != 1) goto _L2; else goto _L1
_L1:
            if (videoState == 1 || videoState == 3)
            {
                wv.loadUrl("javascript:pauseVideo()");
                btnPlay.setImageDrawable(getResources().getDrawable(0x7f0200ef));
                mWasPlayingWhenCalled = true;
            }
_L4:
            super.onCallStateChanged(i, s);
            return;
_L2:
            if (i == 0 && mWasPlayingWhenCalled)
            {
                btnPlay.setImageDrawable(getResources().getDrawable(0x7f0200ed));
                mHandlerTime.sendEmptyMessageDelayed(1, 4000L);
                mWasPlayingWhenCalled = false;
                wv.loadUrl("javascript:playVideo()");
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        _cls29()
        {
            this$0 = MainPage.this;
            super();
            mWasPlayingWhenCalled = false;
        }
    }


    private class _cls30
        implements android.media.AudioManager.OnAudioFocusChangeListener
    {

        final MainPage this$0;

        public void onAudioFocusChange(int i)
        {
            if (i != -2 && i != 1 && i == -1)
            {
                am.abandonAudioFocus(afChangeListener);
            }
        }

        _cls30()
        {
            this$0 = MainPage.this;
            super();
        }
    }


    private class _cls36
        implements Runnable
    {

        final MainPage this$0;

        public void run()
        {
            try
            {
                DB.checkHistory(playingSong.getSongYtId());
                DB.addSong("PLAYLISTHISTORYID", playingSong.getSongName(), playingSong.getSongTime(), playingSong.getSongYtId(), playingSong.getSongOrder(), playingSong.getSongSource(), playingSong.getSongThumbnail());
                if (DB.getSongCount("PLAYLISTHISTORYID") > 100)
                {
                    DB.deleteHistory();
                }
                return;
            }
            catch (Exception exception)
            {
                return;
            }
        }

        _cls36()
        {
            this$0 = MainPage.this;
            super();
        }
    }


    private class _cls48
        implements Runnable
    {

        final MainPage this$0;

        public void run()
        {
            try
            {
                setLocalNotificationList();
                return;
            }
            catch (Exception exception)
            {
                return;
            }
        }

        _cls48()
        {
            this$0 = MainPage.this;
            super();
        }
    }


    private class _cls50
        implements Runnable
    {

        final MainPage this$0;

        public void run()
        {
            FlurryAgent.logEvent("action:mb3_first_launch");
            int i = MixerBoxSharedPreferences.getUserType(MainPage.this);
            if (i == 1)
            {
                FlurryAgent.logEvent("status:v307_push_local");
                MixerBoxClient.get("http://bit.ly/androidv307_launch_local", null, new AsyncHttpResponseHandler());
            } else
            {
                if (i == 2)
                {
                    FlurryAgent.logEvent("status:v307_push_server");
                    MixerBoxClient.get("http://bit.ly/androidv307_launch_server", null, new AsyncHttpResponseHandler());
                    return;
                }
                if (i == 3)
                {
                    FlurryAgent.logEvent("status:v307_push_local_and_server");
                    MixerBoxClient.get("http://bit.ly/androidv307_launch_local_and_server", null, new AsyncHttpResponseHandler());
                    return;
                }
                if (i == 4)
                {
                    FlurryAgent.logEvent("status:v307_push_neither");
                    MixerBoxClient.get("http://bit.ly/androidv307_launch_neither", null, new AsyncHttpResponseHandler());
                    return;
                }
            }
        }

        _cls50()
        {
            this$0 = MainPage.this;
            super();
        }
    }


    private class _cls39
        implements android.view.View.OnTouchListener
    {

        final MainPage this$0;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            if (motionevent.getAction() != 1)
            {
                return true;
            }
            if (videoState == 1)
            {
                mHandlerTime.removeMessages(1);
                mHandlerTime.sendEmptyMessageDelayed(1, 4000L);
            }
            if (rlPanelTop.getVisibility() == 8)
            {
                if (SCREEN_STATE == 2)
                {
                    rlPanelPopup.setVisibility(0);
                    rlPanelPopup.startAnimation(MainPage.slideAnim(300, 0.0F, 0.0F, -1F, 0.0F));
                    btnExpand.setImageDrawable(getResources().getDrawable(0x7f0200d3));
                } else
                {
                    rlPanelPopup.setVisibility(8);
                    btnExpand.setImageDrawable(getResources().getDrawable(0x7f0200db));
                }
                rlPanelTop.setVisibility(0);
                rlPanelTop.startAnimation(MainPage.slideAnim(300, 0.0F, 0.0F, -1F, 0.0F));
                rlPanelBottom.setVisibility(0);
                rlPanelBottom.startAnimation(MainPage.slideAnim(300, 0.0F, 0.0F, 1.0F, 0.0F));
                return true;
            } else
            {
                rlPanelPopup.setVisibility(8);
                btnExpand.setImageDrawable(getResources().getDrawable(0x7f0200db));
                view = MainPage.slideAnim(300, 0.0F, 0.0F, 0.0F, -1F);
                class _cls1
                    implements android.view.animation.Animation.AnimationListener
                {

                    final _cls39 this$1;

                    public void onAnimationEnd(Animation animation)
                    {
                        rlPanelTop.setVisibility(8);
                    }

                    public void onAnimationRepeat(Animation animation)
                    {
                    }

                    public void onAnimationStart(Animation animation)
                    {
                    }

                _cls1()
                {
                    this$1 = _cls39.this;
                    super();
                }
                }

                view.setAnimationListener(new _cls1());
                rlPanelTop.startAnimation(view);
                view = MainPage.slideAnim(300, 0.0F, 0.0F, 0.0F, 1.0F);
                class _cls2
                    implements android.view.animation.Animation.AnimationListener
                {

                    final _cls39 this$1;

                    public void onAnimationEnd(Animation animation)
                    {
                        rlPanelBottom.setVisibility(8);
                    }

                    public void onAnimationRepeat(Animation animation)
                    {
                    }

                    public void onAnimationStart(Animation animation)
                    {
                    }

                _cls2()
                {
                    this$1 = _cls39.this;
                    super();
                }
                }

                view.setAnimationListener(new _cls2());
                rlPanelBottom.startAnimation(view);
                return true;
            }
        }

        _cls39()
        {
            this$0 = MainPage.this;
            super();
        }
    }


    private class _cls11 extends MixerBoxAsyncHttpResponseHandler
    {

        final MainPage this$0;
        final String val$pid;

        public void onSuccess(String s)
        {
            super.onSuccess(s);
            if (s == null)
            {
                break MISSING_BLOCK_LABEL_144;
            }
            SongFragment songfragment;
            s = (new JSONObject(s)).getJSONObject("getVector");
            s = new PlaylistItem(pid, s.getString("name"), s.getString("owner"), s.getString("ownerName"), "", s.getString("subsCnt"), MainPage.bundle.getString("url"), 3, false);
            arraySong.clear();
            songfragment = setSong(s.getPlaylistId());
            songfragment.currentPlaylist = s;
            if (rlVideoPlayer.getVisibility() == 0)
            {
                MixerBoxUtils.loadSong(MainPage.this, pid, false, 1, -1, songfragment);
                return;
            }
            try
            {
                MixerBoxUtils.loadSong(MainPage.this, pid, false, 1, 0, songfragment);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }

        _cls11(String s)
        {
            this$0 = MainPage.this;
            pid = s;
            super(final_context);
        }
    }


    private class _cls12 extends MixerBoxAsyncHttpResponseHandler
    {

        final MainPage this$0;
        final String val$yid;

        public void onSuccess(String s)
        {
            super.onSuccess(s);
            if (s == null)
            {
                break MISSING_BLOCK_LABEL_153;
            }
            Object obj = (new JSONObject(s)).getJSONObject("entry").getJSONObject("media$group");
            s = ((JSONObject) (obj)).getJSONObject("media$title").getString("$t");
            obj = ((JSONObject) (obj)).getJSONObject("yt$duration").getString("seconds");
            String s1 = (new StringBuilder()).append("http://i.ytimg.com/vi/").append(yid).append("/mqdefault.jpg").toString();
            s = new SongItem("", s, ((String) (obj)), yid, 0, 1, s1);
            obj = new ArrayList();
            ((ArrayList) (obj)).add(s);
            arrayPlayingSong = ((ArrayList) (obj));
            playingSong = s;
            playingPlaylist = null;
            playingSongIndex = 0;
            playMusic(true);
            return;
            s;
        }

        _cls12(String s)
        {
            this$0 = MainPage.this;
            yid = s;
            super(final_context);
        }
    }


    private class _cls13 extends MixerBoxAsyncHttpResponseHandler
    {

        final MainPage this$0;
        final String val$mid;
        final String val$pid;

        public void onSuccess(String s)
        {
            super.onSuccess(s);
            if (s == null) goto _L2; else goto _L1
_L1:
            int i;
            Object obj;
            try
            {
                obj = (new JSONObject(s)).getJSONObject("getVector");
                s = new PlaylistItem(pid, ((JSONObject) (obj)).getString("name"), ((JSONObject) (obj)).getString("owner"), ((JSONObject) (obj)).getString("ownerName"), "", ((JSONObject) (obj)).getString("subsCnt"), MainPage.bundle.getString("url"), 3, false);
                obj = ((JSONObject) (obj)).getJSONArray("items");
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return;
            }
            i = 0;
_L8:
            if (i >= ((JSONArray) (obj)).length()) goto _L4; else goto _L3
_L3:
            if (!((JSONArray) (obj)).getJSONObject(i).getString("_id").equals(mid)) goto _L6; else goto _L5
_L5:
            arraySong.clear();
            obj = setSong(s.getPlaylistId());
            obj.currentPlaylist = s;
            if (rlVideoPlayer.getVisibility() == 0)
            {
                MixerBoxUtils.loadSong(MainPage.this, pid, false, 1, -1, ((SongFragment) (obj)));
                return;
            }
            MixerBoxUtils.loadSong(MainPage.this, pid, false, 1, i, ((SongFragment) (obj)));
            return;
_L4:
            i = 0;
              goto _L5
_L2:
            return;
_L6:
            i++;
            if (true) goto _L8; else goto _L7
_L7:
        }

        _cls13(String s1)
        {
            this$0 = MainPage.this;
            pid = s;
            mid = s1;
            super(final_context);
        }
    }


    private class _cls40
        implements android.view.animation.Animation.AnimationListener
    {

        final MainPage this$0;

        public void onAnimationEnd(Animation animation)
        {
            rlVideoPlayer.setVisibility(8);
        }

        public void onAnimationRepeat(Animation animation)
        {
        }

        public void onAnimationStart(Animation animation)
        {
            rlPanelTop.setVisibility(8);
            rlPanelBottom.setVisibility(8);
            rlPanelPopup.setVisibility(8);
        }

        _cls40()
        {
            this$0 = MainPage.this;
            super();
        }
    }


    private class _cls37 extends MixerBoxAsyncHttpResponseHandler
    {

        final MainPage this$0;

        public void onFailure(Throwable throwable, String s)
        {
            super.onFailure(throwable, s);
            MixerBoxUtils.logMsg(s);
        }

        public void onSuccess(String s)
        {
            super.onSuccess(s);
            MixerBoxUtils.logMsg(s);
            try
            {
                s = new JSONObject(s);
                if (s.isNull("data"))
                {
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return;
            }
            s = s.getJSONArray("data");
            if (s.isNull(0))
            {
                break MISSING_BLOCK_LABEL_152;
            }
            s = s.getJSONObject(0);
            if (s.isNull("publish_actions"))
            {
                requestPublishPermissions(Session.getActiveSession());
                return;
            }
            if (s.getInt("publish_actions") == 1)
            {
                if (!MixerBoxSharedPreferences.getPostFB(MainPage.this))
                {
                    MixerBoxSharedPreferences.putPostFB(MainPage.this, true);
                }
                if (fragmentSettings.isAdded())
                {
                    fragmentSettings.shouldOpenConfirmDialog = false;
                    fragmentSettings.checkbox.setChecked(true);
                    return;
                }
                break MISSING_BLOCK_LABEL_152;
            }
            requestPublishPermissions(Session.getActiveSession());
        }

        _cls37(Context context)
        {
            this$0 = MainPage.this;
            super(context);
        }
    }


    private class MyHandler extends Handler
    {

        WeakReference mActivity;

        public void handleMessage(Message message)
        {
            MainPage mainpage;
            mainpage = (MainPage)mActivity.get();
            super.handleMessage(message);
            message.what;
            JVM INSTR tableswitch 1 2: default 44
        //                       1 56
        //                       2 45;
               goto _L1 _L2 _L3
_L1:
            return;
_L3:
            if (!MainPage.isPageLoaded)
            {
                mainpage.setVideoPlayer();
                return;
            }
            continue; /* Loop/switch isn't completed */
_L2:
            if (mainpage.rlPanelTop.getVisibility() == 0)
            {
                mainpage.rlPanelPopup.setVisibility(8);
                mainpage.btnExpand.setImageDrawable(mainpage.btnExpand.getContext().getResources().getDrawable(0x7f0200db));
                message = MainPage.slideAnim(300, 0.0F, 0.0F, 0.0F, -1F);
                class _cls1
                    implements android.view.animation.Animation.AnimationListener
                {

                    final MyHandler this$0;
                    final MainPage val$theActivity;

                    public void onAnimationEnd(Animation animation)
                    {
                        theActivity.rlPanelTop.setVisibility(8);
                    }

                    public void onAnimationRepeat(Animation animation)
                    {
                    }

                    public void onAnimationStart(Animation animation)
                    {
                    }


// JavaClassFileOutputException: Invalid index accessing method local variables table of <init>
                }

                message.setAnimationListener(mainpage. new _cls1());
                mainpage.rlPanelTop.startAnimation(message);
                message = MainPage.slideAnim(300, 0.0F, 0.0F, 0.0F, 1.0F);
                class _cls2
                    implements android.view.animation.Animation.AnimationListener
                {

                    final MyHandler this$0;
                    final MainPage val$theActivity;

                    public void onAnimationEnd(Animation animation)
                    {
                        theActivity.rlPanelBottom.setVisibility(8);
                    }

                    public void onAnimationRepeat(Animation animation)
                    {
                    }

                    public void onAnimationStart(Animation animation)
                    {
                    }


// JavaClassFileOutputException: Invalid index accessing method local variables table of <init>
                }

                message.setAnimationListener(mainpage. new _cls2());
                mainpage.rlPanelBottom.startAnimation(message);
                return;
            }
            if (true) goto _L1; else goto _L4
_L4:
        }

        MyHandler()
        {
            mActivity = new WeakReference(MainPage.this);
        }
    }


    private class _cls38 extends MixerBoxAsyncHttpResponseHandler
    {

        final MainPage this$0;

        public void onFailure(Throwable throwable, String s)
        {
            super.onFailure(throwable, s);
            MixerBoxUtils.logMsg(s);
        }

        public void onSuccess(String s)
        {
            super.onSuccess(s);
            MixerBoxUtils.logMsg(s);
            try
            {
                s = new JSONObject(s);
                if (s.isNull("data"))
                {
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return;
            }
            s = s.getJSONArray("data");
            if (s.isNull(0))
            {
                break MISSING_BLOCK_LABEL_217;
            }
            s = s.getJSONObject(0);
            if (s.isNull("publish_actions"))
            {
                MixerBoxSharedPreferences.putPostFB(MainPage.this, false);
                if (fragmentSettings.isAdded())
                {
                    fragmentSettings.checkbox.setChecked(false);
                    return;
                }
                break MISSING_BLOCK_LABEL_217;
            }
            if (s.getInt("publish_actions") == 1)
            {
                MixerBoxSharedPreferences.putPostFB(MainPage.this, true);
                if (fragmentSettings.isAdded())
                {
                    fragmentSettings.shouldOpenConfirmDialog = false;
                    fragmentSettings.checkbox.setChecked(true);
                }
                s = new HashMap();
                s.put("on", "1");
                FlurryAgent.logEvent("action:set_publish_activity", s);
                return;
            }
            MixerBoxSharedPreferences.putPostFB(MainPage.this, false);
            if (fragmentSettings.isAdded())
            {
                fragmentSettings.checkbox.setChecked(false);
            }
        }

        _cls38(Context context)
        {
            this$0 = MainPage.this;
            super(context);
        }
    }


    private class _cls2
        implements android.view.View.OnClickListener
    {

        final MainPage this$0;

        public void onClick(View view)
        {
            setPlaylists(false);
        }

        _cls2()
        {
            this$0 = MainPage.this;
            super();
        }
    }


    private class _cls3
        implements android.view.View.OnClickListener
    {

        final MainPage this$0;

        public void onClick(View view)
        {
            setNewsfeed();
        }

        _cls3()
        {
            this$0 = MainPage.this;
            super();
        }
    }


    private class _cls4
        implements android.view.View.OnClickListener
    {

        final MainPage this$0;

        public void onClick(View view)
        {
            setDiscover(new boolean[0]);
        }

        _cls4()
        {
            this$0 = MainPage.this;
            super();
        }
    }


    private class _cls5
        implements android.view.View.OnClickListener
    {

        final MainPage this$0;

        public void onClick(View view)
        {
            setDJs(1);
        }

        _cls5()
        {
            this$0 = MainPage.this;
            super();
        }
    }


    private class _cls6
        implements android.view.View.OnClickListener
    {

        final MainPage this$0;

        public void onClick(View view)
        {
            setSettings();
        }

        _cls6()
        {
            this$0 = MainPage.this;
            super();
        }
    }


    private class _cls7 extends OrientationEventListener
    {

        final MainPage this$0;

        public void onOrientationChanged(int i)
        {
            if (i != -1 && isForeground)
            {
                if (i >= 0 && i <= 45 || i >= 315 || i >= 135 && i <= 225)
                {
                    curOri = 1;
                } else
                {
                    curOri = 0;
                }
                if (!MainPage.defaultPortrait)
                {
                    if (curOri == 1)
                    {
                        curOri = 0;
                    } else
                    {
                        curOri = 1;
                    }
                }
                if (preOri == -1)
                {
                    preOri = curOri;
                    return;
                }
                if (preOri == -1 || preOri != curOri)
                {
                    preOri = curOri;
                    if (guideView != null && guideView.isShown() && android.provider.Settings.System.getInt(getContentResolver(), "accelerometer_rotation", 0) == 1)
                    {
                        guideView.performClick();
                    }
                    if (curOri == 1 && SCREEN_STATE == 2)
                    {
                        setUnFullScreen(true);
                        return;
                    }
                    if (curOri == 1)
                    {
                        setRequestedOrientation(7);
                        return;
                    }
                    if (curOri == 0 && android.provider.Settings.System.getInt(getContentResolver(), "accelerometer_rotation", 0) == 1 && rlVideoPlayer.getVisibility() == 0)
                    {
                        setFullScreen();
                        return;
                    }
                    if (curOri == 0 && android.provider.Settings.System.getInt(getContentResolver(), "accelerometer_rotation", 0) == 1)
                    {
                        setRequestedOrientation(6);
                        return;
                    }
                }
            }
        }

        _cls7(Context context, int i)
        {
            this$0 = MainPage.this;
            super(context, i);
        }
    }


    private class MusicIntentReceiver extends BroadcastReceiver
    {

        final MainPage this$0;

        public void onReceive(Context context, Intent intent)
        {
            if (!intent.getAction().equals("android.intent.action.HEADSET_PLUG")) goto _L2; else goto _L1
_L1:
            intent.getIntExtra("state", -1);
            JVM INSTR tableswitch 0 0: default 36
        //                       0 37;
               goto _L2 _L3
_L2:
            return;
_L3:
            if (videoState == 1)
            {
                wv.loadUrl("javascript:pauseVideo()");
                btnPlay.setImageDrawable(getResources().getDrawable(0x7f0200ef));
                return;
            }
            if (MyService.mediaPlayer != null && MyService.mediaPlayer.isPlaying())
            {
                MyService.mediaPlayer.pause();
                btnPlay.setImageDrawable(getResources().getDrawable(0x7f0200ef));
                return;
            }
            if (true) goto _L2; else goto _L4
_L4:
        }

        private MusicIntentReceiver()
        {
            this$0 = MainPage.this;
            super();
        }

        MusicIntentReceiver(_cls1 _pcls1)
        {
            this();
        }
    }


    private class _cls8 extends WebViewClient
    {

        final MainPage this$0;

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            if (s.contains("fb://") || s.contains("://play.google.com/store/apps/details?id="))
            {
                webview = new Intent("android.intent.action.VIEW");
                webview.setData(Uri.parse(s));
                startActivity(webview);
                return true;
            }
            if (s.startsWith("mailto:"))
            {
                webview = MailTo.parse(s);
                s = new Intent("android.intent.action.SEND");
                s.putExtra("android.intent.extra.EMAIL", new String[] {
                    webview.getTo()
                });
                s.setType("message/rfc822");
                startActivity(s);
                return true;
            } else
            {
                return super.shouldOverrideUrlLoading(webview, s);
            }
        }

        _cls8()
        {
            this$0 = MainPage.this;
            super();
        }
    }


    private class _cls9
        implements android.content.DialogInterface.OnClickListener
    {

        final MainPage this$0;

        public void onClick(DialogInterface dialoginterface, int i)
        {
        }

        _cls9()
        {
            this$0 = MainPage.this;
            super();
        }
    }


    private class MixerBoxSearchAutoCompleteAdapter extends ArrayAdapter
        implements Filterable
    {

        private ArrayList img;
        private ArrayList resultList;
        final MainPage this$0;

        public int getCount()
        {
            if (resultList != null)
            {
                return resultList.size();
            } else
            {
                return 0;
            }
        }

        public Filter getFilter()
        {
            class _cls1 extends Filter
            {

                final MixerBoxSearchAutoCompleteAdapter this$1;

                protected android.widget.Filter.FilterResults performFiltering(CharSequence charsequence)
                {
                    android.widget.Filter.FilterResults filterresults;
                    ArrayList arraylist;
                    String as[];
                    String as1[];
                    int i;
                    boolean flag;
                    flag = false;
                    filterresults = new android.widget.Filter.FilterResults();
                    if (charsequence == null)
                    {
                        break MISSING_BLOCK_LABEL_317;
                    }
                    img = new ArrayList();
                    arraylist = new ArrayList();
                    as = MixerBoxConstants.ARTISTS;
                    as1 = MixerBoxConstants.ARTIST_THUMBNAIL;
                    i = 0;
_L5:
                    if (i >= as.length) goto _L2; else goto _L1
_L1:
                    if (!as[i].toLowerCase(Locale.ENGLISH).startsWith(charsequence.toString().toLowerCase())) goto _L4; else goto _L3
_L3:
                    arraylist.add(as[i]);
                    img.add(as1[i]);
_L6:
                    i++;
                      goto _L5
_L4:
                    String as2[];
                    int k;
                    as2 = as[i].split(" ");
                    k = 0;
_L7:
                    if (k < as2.length)
                    {
label0:
                        {
                            if (!as2[k].toLowerCase(Locale.ENGLISH).startsWith(charsequence.toString().toLowerCase()))
                            {
                                break label0;
                            }
                            arraylist.add(as[i]);
                            img.add(as1[i]);
                        }
                    }
                      goto _L6
                    k++;
                      goto _L7
_L2:
                    new ArrayList();
                    ArrayList arraylist1 = autocomplete(charsequence.toString());
                    for (int j = ((flag) ? 1 : 0); j < arraylist1.size(); j++)
                    {
                        arraylist.add(arraylist1.get(j));
                        img.add("");
                    }

                    if (arraylist.size() == 0)
                    {
                        arraylist.add(charsequence.toString());
                        img.add("");
                    }
                    filterresults.values = arraylist;
                    filterresults.count = arraylist.size();
                    return filterresults;
                      goto _L6
                }

                protected void publishResults(CharSequence charsequence, final android.widget.Filter.FilterResults results)
                {
                    class _cls1
                        implements Runnable
                    {

                        final _cls1 this$2;
                        final android.widget.Filter.FilterResults val$results;

                        public void run()
                        {
                            resultList = (ArrayList)results.values;
                            if (results != null && results.count > 0)
                            {
                                notifyDataSetChanged();
                                return;
                            } else
                            {
                                notifyDataSetInvalidated();
                                return;
                            }
                        }

                            _cls1()
                            {
                                this$2 = _cls1.this;
                                results = filterresults;
                                super();
                            }
                    }

                    runOnUiThread(new _cls1());
                }

                _cls1()
                {
                    this$1 = MixerBoxSearchAutoCompleteAdapter.this;
                    super();
                }
            }

            return new _cls1();
        }

        public volatile Object getItem(int i)
        {
            return getItem(i);
        }

        public String getItem(int i)
        {
            if (resultList != null && resultList.size() > i)
            {
                return (String)resultList.get(i);
            } else
            {
                return "";
            }
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            class ViewHolder
            {

                public ImageView iv;
                final MixerBoxSearchAutoCompleteAdapter this$1;
                public TextView tv;

                private ViewHolder()
                {
                    this$1 = MixerBoxSearchAutoCompleteAdapter.this;
                    super();
                }

                ViewHolder(_cls1 _pcls1)
                {
                    this();
                }
            }

            if (view == null)
            {
                view = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f03004e, null);
                viewgroup = new ViewHolder(null);
                viewgroup.tv = (TextView)view.findViewById(0x7f070102);
                viewgroup.iv = (ImageView)view.findViewById(0x7f070100);
                view.setTag(viewgroup);
            } else
            {
                viewgroup = (ViewHolder)view.getTag();
            }
            if (img.size() <= i || ((String)img.get(i)).length() != 0)
            {
                break MISSING_BLOCK_LABEL_126;
            }
            ((ViewHolder) (viewgroup)).tv.setText(getItem(i));
            ((ViewHolder) (viewgroup)).iv.setVisibility(8);
            return view;
            if (img.size() <= i)
            {
                break MISSING_BLOCK_LABEL_212;
            }
            ((ViewHolder) (viewgroup)).iv.setVisibility(0);
            ((ViewHolder) (viewgroup)).tv.setText(getItem(i));
            com.nostra13.universalimageloader.core.DisplayImageOptions displayimageoptions = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).cacheInMemory(true).cacheOnDisc(true).displayer(new CircleBitmapDisplayer()).build();
            ImageLoader.getInstance().displayImage((String)img.get(i), ((ViewHolder) (viewgroup)).iv, displayimageoptions);
            return view;
            try
            {
                ((ViewHolder) (viewgroup)).iv.setVisibility(8);
                ((ViewHolder) (viewgroup)).tv.setText(getItem(i));
            }
            // Misplaced declaration of an exception variable
            catch (ViewGroup viewgroup)
            {
                return view;
            }
            return view;
        }


/*
        static ArrayList access$1102(MixerBoxSearchAutoCompleteAdapter mixerboxsearchautocompleteadapter, ArrayList arraylist)
        {
            mixerboxsearchautocompleteadapter.resultList = arraylist;
            return arraylist;
        }

*/



/*
        static ArrayList access$902(MixerBoxSearchAutoCompleteAdapter mixerboxsearchautocompleteadapter, ArrayList arraylist)
        {
            mixerboxsearchautocompleteadapter.img = arraylist;
            return arraylist;
        }

*/

        public MixerBoxSearchAutoCompleteAdapter(Context context, int i)
        {
            this$0 = MainPage.this;
            super(context, i);
            resultList = new ArrayList();
        }
    }


    private class _cls43
        implements android.widget.AdapterView.OnItemClickListener
    {

        final MainPage this$0;
        final AutoCompleteTextView val$textView;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            textView.onEditorAction(3);
        }

        _cls43()
        {
            this$0 = MainPage.this;
            textView = autocompletetextview;
            super();
        }
    }


    private class _cls44
        implements android.view.View.OnClickListener
    {

        final MainPage this$0;
        final AutoCompleteTextView val$textView;

        public void onClick(View view)
        {
            textView.setText("");
        }

        _cls44()
        {
            this$0 = MainPage.this;
            textView = autocompletetextview;
            super();
        }
    }


    private class _cls45
        implements android.widget.TextView.OnEditorActionListener
    {

        final MainPage this$0;

        public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
        {
label0:
            {
                if (i == 3)
                {
                    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(textview.getWindowToken(), 0);
                    if (MixerBoxClient.isConnectingToInternet(MainPage.this))
                    {
                        break label0;
                    }
                    AlertDialogFactory.NoNetworkAlertDialog(MainPage.this).show();
                }
                return false;
            }
            textview = textview.getText().toString();
            keyevent = new HashMap();
            keyevent.put("query", textview);
            FlurryAgent.logEvent("action:search", keyevent);
            setDiscover(new boolean[] {
                false
            });
            keyevent = setVector("VECTORIDSEARCH", "vector", 2, "");
            MixerBoxUtils.setSearch(MainPage.this, textview, keyevent);
            return false;
        }

        _cls45()
        {
            this$0 = MainPage.this;
            super();
        }
    }


    private class _cls46
        implements com.actionbarsherlock.view.MenuItem.OnActionExpandListener
    {

        final MainPage this$0;

        public boolean onMenuItemActionCollapse(MenuItem menuitem)
        {
            return true;
        }

        public boolean onMenuItemActionExpand(MenuItem menuitem)
        {
            menuitem.getActionView().requestFocus();
            ((InputMethodManager)getSystemService("input_method")).toggleSoftInput(0, 2);
            return true;
        }

        _cls46()
        {
            this$0 = MainPage.this;
            super();
        }
    }


    private class _cls47 extends MixerBoxAsyncHttpResponseHandler
    {

        final MainPage this$0;

        public void onFailure(Throwable throwable, String s)
        {
            super.onFailure(throwable, s);
            MixerBoxUtils.toastMsg(MainPage.this, getResources().getString(0x7f080049), 1);
        }

        public void onSuccess(String s)
        {
            super.onSuccess(s);
            if (s == null || s.length() <= 0)
            {
                break MISSING_BLOCK_LABEL_109;
            }
            s = new JSONObject(s);
            if (s.isNull("changePlaylist") || s.getJSONObject("changePlaylist").isNull("status"))
            {
                break MISSING_BLOCK_LABEL_109;
            }
            if (s.getJSONObject("changePlaylist").getBoolean("status"))
            {
                MixerBoxUtils.toastMsg(MainPage.this, getResources().getString(0x7f0800e9), 1);
                return;
            }
            try
            {
                MixerBoxUtils.toastMsg(MainPage.this, getResources().getString(0x7f080049), 1);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
        }

        _cls47(Context context)
        {
            this$0 = MainPage.this;
            super(context);
        }
    }


    private class _cls32
        implements Runnable
    {

        final MainPage this$0;

        public void run()
        {
            rlVideoPlayer.setVisibility(0);
            rlPanelTop.setVisibility(0);
            rlPanelBottom.setVisibility(0);
            Animation animation = MainPage.slideAnim(800, 0.0F, 0.0F, -1F, 0.0F);
            class _cls1
                implements android.view.animation.Animation.AnimationListener
            {

                final _cls32 this$1;

                public void onAnimationEnd(Animation animation1)
                {
                    if (getRequestedOrientation() == 6 && SCREEN_STATE == 1)
                    {
                        setFullScreen();
                    }
                }

                public void onAnimationRepeat(Animation animation1)
                {
                }

                public void onAnimationStart(Animation animation1)
                {
                }

                _cls1()
                {
                    this$1 = _cls32.this;
                    super();
                }
            }

            animation.setAnimationListener(new _cls1());
            rlVideoPlayer.startAnimation(animation);
        }

        _cls32()
        {
            this$0 = MainPage.this;
            super();
        }
    }


    private class _cls34
        implements Runnable
    {

        final MainPage this$0;

        public void run()
        {
            rlVideoPlayer.setVisibility(0);
            rlPanelTop.setVisibility(0);
            rlPanelBottom.setVisibility(0);
            Animation animation = MainPage.slideAnim(800, 0.0F, 0.0F, -1F, 0.0F);
            class _cls1
                implements android.view.animation.Animation.AnimationListener
            {

                final _cls34 this$1;

                public void onAnimationEnd(Animation animation1)
                {
                    if (getRequestedOrientation() == 6 && SCREEN_STATE == 1)
                    {
                        setFullScreen();
                    }
                }

                public void onAnimationRepeat(Animation animation1)
                {
                }

                public void onAnimationStart(Animation animation1)
                {
                }

                _cls1()
                {
                    this$1 = _cls34.this;
                    super();
                }
            }

            animation.setAnimationListener(new _cls1());
            rlVideoPlayer.startAnimation(animation);
        }

        _cls34()
        {
            this$0 = MainPage.this;
            super();
        }
    }


    private class _cls35
        implements Runnable
    {

        final MainPage this$0;

        public void run()
        {
            rlVideoPlayer.setVisibility(0);
            rlPanelTop.setVisibility(0);
            rlPanelBottom.setVisibility(0);
            Animation animation = MainPage.slideAnim(800, 0.0F, 0.0F, -1F, 0.0F);
            class _cls1
                implements android.view.animation.Animation.AnimationListener
            {

                final _cls35 this$1;

                public void onAnimationEnd(Animation animation1)
                {
                    if (getRequestedOrientation() == 6 && SCREEN_STATE == 1)
                    {
                        setFullScreen();
                    }
                }

                public void onAnimationRepeat(Animation animation1)
                {
                }

                public void onAnimationStart(Animation animation1)
                {
                }

                _cls1()
                {
                    this$1 = _cls35.this;
                    super();
                }
            }

            animation.setAnimationListener(new _cls1());
            rlVideoPlayer.startAnimation(animation);
        }

        _cls35()
        {
            this$0 = MainPage.this;
            super();
        }
    }


    private class _cls33 extends MixerBoxAsyncHttpResponseHandler
    {

        final MainPage this$0;
        final PlaylistItem val$p;

        public void onSuccess(String s)
        {
            super.onSuccess(s);
            new ArrayList();
            s = new ArrayList(MixerBoxUtils.getSongArray(s, null));
            if (s.size() == 0)
            {
                return;
            } else
            {
                arrayPlayingSong = new ArrayList(s);
                playingSong = (SongItem)arrayPlayingSong.get(0);
                playingPlaylist = p;
                playingSongIndex = 0;
                playMusic(false);
                return;
            }
        }

        _cls33(PlaylistItem playlistitem)
        {
            this$0 = MainPage.this;
            p = playlistitem;
            super(final_context);
        }
    }


    private class _cls31
        implements Runnable
    {

        final MainPage this$0;
        final boolean val$b;

        public void run()
        {
            String s;
            Object obj;
            obj = null;
            s = "";
            if (playingSong.getSongSource() != 2) goto _L2; else goto _L1
_L1:
            s = getMP3Thumbnail(playingSong.getSongId());
_L4:
            Intent intent = new Intent(MainPage.this, com/mixerbox/mixerbox3b/services/PlayerService);
            String s1 = "";
            if (playingSong.getSongName() != null)
            {
                s1 = playingSong.getSongName();
            }
            intent.putExtra("song_name", s1);
            intent.putExtra("bitmap", ((android.os.Parcelable) (obj)));
            intent.putExtra("song_source", playingSong.getSongSource());
            intent.putExtra("url", s);
            intent.putExtra("is_playing", b);
            startService(intent);
            return;
_L2:
            if (playingSong.getSongSource() != 1)
            {
                break; /* Loop/switch isn't completed */
            }
            s = (new StringBuilder()).append("http://i.ytimg.com/vi/").append(playingSong.getSongYtId()).append("/mqdefault.jpg").toString();
_L6:
            obj = MixerBoxUtils.getBitmapFromURL(s);
            if (true) goto _L4; else goto _L3
_L3:
            if (playingSong.getSongSource() != 3) goto _L6; else goto _L5
_L5:
            s = playingSong.getSongThumbnail();
              goto _L6
        }

        _cls31()
        {
            this$0 = MainPage.this;
            b = flag;
            super();
        }
    }


    private class _cls49
        implements com.facebook.widget.WebDialog.OnCompleteListener
    {

        final MainPage this$0;

        public void onComplete(Bundle bundle1, FacebookException facebookexception)
        {
        }

        _cls49()
        {
            this$0 = MainPage.this;
            super();
        }
    }


    private class _cls42 extends MixerBoxAsyncHttpResponseHandler
    {

        final MainPage this$0;
        final boolean val$b[];

        public void onFailure(Throwable throwable, String s)
        {
            super.onFailure(throwable, s);
            fragmentDiscover.loadContent();
        }

        public void onSuccess(String s)
        {
            super.onSuccess(s);
            if (s != null) goto _L2; else goto _L1
_L1:
            return;
_L2:
            arraySystemList.clear();
            s = (new JSONObject(s)).getJSONObject("searchPage").getJSONArray("items");
            int i = 0;
_L4:
            if (i >= s.length())
            {
                break; /* Loop/switch isn't completed */
            }
            JSONObject jsonobject = s.getJSONObject(i);
            MixerBoxUtils.addMyItemToArray(arraySystemList, jsonobject, MainPage.this, i, s.length() - i - 1);
            i++;
            if (true) goto _L4; else goto _L3
            s;
            s.printStackTrace();
_L3:
            fragmentDiscover.loadContent();
            boolean flag1 = true;
            boolean flag = flag1;
            if (b != null)
            {
                flag = flag1;
                if (b.length > 0)
                {
                    flag = b[0];
                }
            }
            if (!MixerBoxSharedPreferences.getTipFirstDiscover(MainPage.this) && flag)
            {
                setOnboardingGuide(3, new boolean[0]);
                return;
            }
            if (true) goto _L1; else goto _L5
_L5:
        }

        _cls42(boolean aflag[])
        {
            this$0 = MainPage.this;
            b = aflag;
            super(final_context);
        }
    }


    private class _cls41 extends MixerBoxAsyncHttpResponseHandler
    {

        final MainPage this$0;

        public void onFailure(Throwable throwable, String s)
        {
            super.onFailure(throwable, s);
            fragmentNewsfeed.lvNewsfeed.onRefreshComplete();
            fragmentNewsfeed.loadContent();
        }

        public void onSuccess(String s)
        {
            super.onSuccess(s);
            if (s != null) goto _L2; else goto _L1
_L1:
            fragmentNewsfeed.lvNewsfeed.onRefreshComplete();
            fragmentNewsfeed.loadContent();
_L6:
            return;
_L2:
            s = (new JSONObject(s)).getJSONObject("newsPage").getJSONArray("items");
            int i = 0;
_L4:
            if (i >= s.length())
            {
                break; /* Loop/switch isn't completed */
            }
            JSONObject jsonobject = s.getJSONObject(i);
            MixerBoxUtils.addMyItemToArray(arrayNewsfeed, jsonobject, MainPage.this, i, s.length() - i - 1);
            i++;
            if (true) goto _L4; else goto _L3
            s;
            s.printStackTrace();
_L3:
            fragmentNewsfeed.adapter.notifyDataSetChanged();
            fragmentNewsfeed.lvNewsfeed.onRefreshComplete();
            fragmentNewsfeed.loadContent();
            fragmentNewsfeed.canScroll = true;
            if (!MixerBoxSharedPreferences.getTipFirstNewsfeed(MainPage.this))
            {
                setOnboardingGuide(2, new boolean[0]);
                return;
            }
            if (true) goto _L6; else goto _L5
_L5:
        }

        _cls41(Context context)
        {
            this$0 = MainPage.this;
            super(context);
        }
    }


    private class _cls10
        implements android.view.View.OnClickListener
    {

        final MainPage this$0;
        final WindowManager val$windowManager;

        public void onClick(View view)
        {
            if (guideView.t != 1) goto _L2; else goto _L1
_L1:
            MixerBoxSharedPreferences.putOnboardingFinish(MainPage.this, true);
_L4:
            if (guideView != null && guideView.isShown())
            {
                windowManager.removeView(guideView);
            }
            return;
_L2:
            if (guideView.t == 2)
            {
                MixerBoxSharedPreferences.putTipFirstNewsfeed(MainPage.this, true);
            } else
            if (guideView.t == 3)
            {
                MixerBoxSharedPreferences.putTipFirstDiscover(MainPage.this, true);
            } else
            if (guideView.t == 4)
            {
                MixerBoxSharedPreferences.putTipSecondPlaylist(MainPage.this, true);
            } else
            if (guideView.t == 5)
            {
                MixerBoxSharedPreferences.putTipFirstEmptyPlaylist(MainPage.this, true);
            } else
            if (guideView.t == 6)
            {
                MixerBoxSharedPreferences.putTipFirstOthersPlaylist(MainPage.this, true);
            } else
            if (guideView.t == 7)
            {
                MixerBoxSharedPreferences.putTipFirstSubscribe(MainPage.this, true);
            } else
            if (guideView.t == 8)
            {
                MixerBoxSharedPreferences.putTipFirstAddMusic(MainPage.this, true);
            } else
            if (guideView.t == 9)
            {
                MixerBoxSharedPreferences.putTipFirstNonEmptyPlaylist(MainPage.this, true);
            } else
            if (guideView.t == 10)
            {
                MixerBoxSharedPreferences.putTipFirstSearch(MainPage.this, true);
            } else
            if (guideView.t == 11)
            {
                MixerBoxSharedPreferences.putTipFirstArtist(MainPage.this, true);
            } else
            if (guideView.t == 12)
            {
                MixerBoxSharedPreferences.putTipFirstPlay(MainPage.this, true);
                mHandlerTime.sendEmptyMessageDelayed(1, 4000L);
            } else
            if (guideView.t == 13)
            {
                MixerBoxSharedPreferences.putTipSecondPlay(MainPage.this);
                mHandlerTime.sendEmptyMessageDelayed(1, 4000L);
            } else
            if (guideView.t == 14)
            {
                MixerBoxSharedPreferences.putTipThirdPlay(MainPage.this, true);
                mHandlerTime.sendEmptyMessageDelayed(1, 4000L);
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        _cls10()
        {
            this$0 = MainPage.this;
            windowManager = windowmanager;
            super();
        }
    }


    private class _cls16
        implements android.view.View.OnClickListener
    {

        final MainPage this$0;

        public void onClick(View view)
        {
            isReady = false;
            MainPage.isPageLoaded = false;
            rlPanelTop.setVisibility(8);
            rlPanelBottom.setVisibility(8);
            wv.loadUrl("http://static.mixerbox.com/yt_android.min.b.v7.html");
            tvSwitch.setVisibility(8);
            wv.setOnTouchListener(null);
        }

        _cls16()
        {
            this$0 = MainPage.this;
            super();
        }
    }


    private class MyJavaScriptInterface
    {

        Context ctx;
        final MainPage this$0;

        public void log(String s)
        {
            MixerBoxUtils.logMsg((new StringBuilder()).append("FROM JS: ").append(s).toString());
        }

        public void onPageLoaded()
        {
            MainPage.isPageLoaded = true;
            class _cls6
                implements Runnable
            {

                final MyJavaScriptInterface this$1;

                public void run()
                {
                    wv.loadUrl((new StringBuilder()).append("javascript:setQuality(").append(JS_Player_W_F).append(",").append(MixerBoxSharedPreferences.getHighQuality(_fld0)).append(")").toString());
                    if (shouldPlayAfterReady)
                    {
                        shouldPlayAfterReady = false;
                        playMusic(false);
                    }
                }

                _cls6()
                {
                    this$1 = MyJavaScriptInterface.this;
                    super();
                }
            }

            ((Activity)ctx).runOnUiThread(new _cls6());
        }

        public void onReady()
        {
            class _cls4
                implements Runnable
            {

                final MyJavaScriptInterface this$1;

                public void run()
                {
                    isReady = true;
                    if (shouldPlayAfterReady)
                    {
                        shouldPlayAfterReady = false;
                        playMusic(false);
                    }
                    if (SCREEN_STATE == 1)
                    {
                        wv.loadUrl((new StringBuilder()).append("javascript:setScreenSize(").append(JS_Player_W).append(",").append(JS_Player_H).append(")").toString());
                        return;
                    } else
                    {
                        wv.loadUrl((new StringBuilder()).append("javascript:setScreenSize(").append(JS_Player_W_F).append(",").append(JS_Player_H_F).append(")").toString());
                        return;
                    }
                }

                _cls4()
                {
                    this$1 = MyJavaScriptInterface.this;
                    super();
                }
            }

            ((Activity)ctx).runOnUiThread(new _cls4());
        }

        public void onReadyV2()
        {
            class _cls5
                implements Runnable
            {

                final MyJavaScriptInterface this$1;

                public void run()
                {
                    isReady = true;
                    if (SCREEN_STATE == 1)
                    {
                        wv.loadUrl((new StringBuilder()).append("javascript:setScreenSize(").append(JS_Player_W).append(",").append(JS_Player_H).append(")").toString());
                    } else
                    {
                        wv.loadUrl((new StringBuilder()).append("javascript:setScreenSize(").append(JS_Player_W_F).append(",").append(JS_Player_H_F).append(")").toString());
                    }
                    if (MainPage.playerType == 0)
                    {
                        rlHint.setVisibility(0);
                        MainPage.playerType = 2;
                        MixerBoxSharedPreferences.putPlayerType(_fld0, 2);
                        playMusic(false);
                    } else
                    if (shouldPlayAfterReady)
                    {
                        shouldPlayAfterReady = false;
                        playMusic(false);
                        return;
                    }
                }

                _cls5()
                {
                    this$1 = MyJavaScriptInterface.this;
                    super();
                }
            }

            ((Activity)ctx).runOnUiThread(new _cls5());
        }

        public void onShouldPlayChange(final int flag)
        {
            class _cls9
                implements Runnable
            {

                final MyJavaScriptInterface this$1;
                final int val$flag;

                public void run()
                {
                    shouldPlay = flag;
                    if (shouldPlay == 1)
                    {
                        btnPlay.setImageDrawable(getResources().getDrawable(0x7f0200ed));
                    } else
                    {
                        btnPlay.setImageDrawable(getResources().getDrawable(0x7f0200ef));
                    }
                    sendNotification();
                }

                _cls9()
                {
                    this$1 = MyJavaScriptInterface.this;
                    flag = i;
                    super();
                }
            }

            ((Activity)ctx).runOnUiThread(new _cls9());
        }

        public void onStateChanged(final int s)
        {
            class _cls8
                implements Runnable
            {

                final MyJavaScriptInterface this$1;
                final int val$s;

                public void run()
                {
                    if (!shouldCloseApp)
                    {
                        videoState = s;
                        if (videoState == 1)
                        {
                            errorCount = 0;
                        }
                        if (!MixerBoxClient.isConnectingToInternet(_fld0))
                        {
                            tvNoNet.setVisibility(0);
                            stopPlayer();
                            return;
                        }
                        if (videoState == 1 && tvNoNet.getVisibility() == 0)
                        {
                            tvNoNet.setVisibility(8);
                            playMusic(false);
                        }
                        if (MainPage.playerType == 2 && !hasSetCanAuto && videoState == 1)
                        {
                            hasSetCanAuto = true;
                            rlHint.setVisibility(8);
                            setWebViewTouchListener();
                        }
                        if (tvSwitch.getVisibility() == 0 && videoState == 1)
                        {
                            tvSwitch.setVisibility(8);
                            MixerBoxSharedPreferences.putPlayerType(_fld0, 1);
                            MainPage.playerType = 1;
                            setWebViewTouchListener();
                        }
                        if (videoState == 1 && shouldResetTime)
                        {
                            shouldResetTime = false;
                            wv.loadUrl((new StringBuilder()).append("javascript:seekTo(").append(resetTime).append(")").toString());
                            resetTime = 0;
                            return;
                        }
                    }
                }

                _cls8()
                {
                    this$1 = MyJavaScriptInterface.this;
                    s = i;
                    super();
                }
            }

            ((Activity)ctx).runOnUiThread(new _cls8());
        }

        public void playMediaPlayer()
        {
            class _cls10
                implements Runnable
            {

                final MyJavaScriptInterface this$1;

                public void run()
                {
                }

                _cls10()
                {
                    this$1 = MyJavaScriptInterface.this;
                    super();
                }
            }

            ((Activity)ctx).runOnUiThread(new _cls10());
        }

        public void playNext()
        {
            class _cls2
                implements Runnable
            {

                final MyJavaScriptInterface this$1;

                public void run()
                {
                    if (!MixerBoxClient.isConnectingToInternet(_fld0))
                    {
                        stopPlayer();
                        return;
                    } else
                    {
                        playNextSong();
                        return;
                    }
                }

                _cls2()
                {
                    this$1 = MyJavaScriptInterface.this;
                    super();
                }
            }

            ((Activity)ctx).runOnUiThread(new _cls2());
        }

        public void postFBAction()
        {
            class _cls3
                implements Runnable
            {

                final MyJavaScriptInterface this$1;

                public void run()
                {
                    if (playingPlaylist != null && playingSong != null && playingPlaylist.getPlaylistId().equals("PLAYLISTHISTORYID"))
                    {
                        MixerBoxUtils.sendCohortListening(_fld0, "", "0", playingSong.getSongYtId());
                    } else
                    if (playingPlaylist != null && playingSong != null && playingSong.getSongId() != null && playingPlaylist.getPlaylistId() != null)
                    {
                        MixerBoxUtils.sendCohortListening(_fld0, playingSong.getSongId(), playingPlaylist.getPlaylistId(), "");
                    } else
                    if (playingSong != null && playingSong.getSongYtId() != null)
                    {
                        MixerBoxUtils.sendCohortListening(_fld0, "", "0", playingSong.getSongYtId());
                    }
                    if (isLogIn) goto _L2; else goto _L1
_L1:
                    return;
_L2:
                    int i;
                    i = MixerBoxSharedPreferences.getPlaySongCount(_fld0) + 1;
                    if (MixerBoxSharedPreferences.getPostFB(_fld0))
                    {
                        break; /* Loop/switch isn't completed */
                    }
                    MixerBoxSharedPreferences.putPlaySongCount(_fld0, i);
                    if (i == 5 || i % 50 == 0)
                    {
                        AlertDialogFactory.AskPostAlertDialog(_fld0).show();
                        return;
                    }
                    if (true) goto _L1; else goto _L3
_L3:
                    class _cls1 extends MixerBoxAsyncHttpResponseHandler
                    {

                        final _cls3 this$2;

                        public void onFailure(Throwable throwable, String s1)
                        {
                            super.onFailure(throwable, s1);
                            if (s1 != null)
                            {
                                MixerBoxUtils.logMsg(s1);
                                try
                                {
                                    throwable = new JSONObject(s1);
                                    if (!throwable.isNull("error") && throwable.getJSONObject("error").getString("code").equals("200"))
                                    {
                                        MixerBoxSharedPreferences.putPostFB(_fld0, false);
                                        if (fragmentSettings.isAdded())
                                        {
                                            fragmentSettings.checkbox.setChecked(false);
                                            return;
                                        }
                                    }
                                }
                                // Misplaced declaration of an exception variable
                                catch (Throwable throwable)
                                {
                                    throwable.printStackTrace();
                                    return;
                                }
                            }
                        }

                        public void onSuccess(String s1)
                        {
                            super.onSuccess(s1);
                            MixerBoxUtils.logMsg(s1);
                        }

                            _cls1(Context context)
                            {
                                this$2 = _cls3.this;
                                super(context);
                            }
                    }

                    String s;
                    if (i == 5)
                    {
                        FlurryAgent.logEvent("action:played_05_videos");
                    } else
                    if (i == 10)
                    {
                        FlurryAgent.logEvent("action:played_10_videos");
                    } else
                    if (i == 20)
                    {
                        FlurryAgent.logEvent("action:played_20_videos");
                    } else
                    if (i == 50)
                    {
                        FlurryAgent.logEvent("action:played_50_videos");
                    }
                    if (playingPlaylist == null)
                    {
                        s = (new StringBuilder()).append("http://www.mixerbox.com/music/0/").append(playingSong.getSongYtId()).toString();
                    } else
                    if (playingPlaylist.getPlaylistId().equals("PLAYLISTHISTORYID"))
                    {
                        s = (new StringBuilder()).append("http://www.mixerbox.com/music/0/").append(playingSong.getSongYtId()).toString();
                    } else
                    {
                        s = (new StringBuilder()).append("http://www.mixerbox.com/music/").append(playingPlaylist.getPlaylistId()).append("/").append(playingSong.getSongId()).toString();
                    }
                    (new AsyncHttpClient()).post((new StringBuilder()).append("https://graph.facebook.com/").append(MixerBoxSharedPreferences.getFacebookId(_fld0)).append("/mixerbox:play?music_video=").append(s).append("&access_token=").append(MixerBoxSharedPreferences.getFacebookToken(_fld0)).toString(), null, new _cls1(_fld0));
                    return;
                }

                _cls3()
                {
                    this$1 = MyJavaScriptInterface.this;
                    super();
                }
            }

            ((Activity)ctx).runOnUiThread(new _cls3());
        }

        public void sendError()
        {
            class _cls7
                implements Runnable
            {

                final MyJavaScriptInterface this$1;

                public void run()
                {
                    MainPage mainpage = _fld0;
                    mainpage.errorCount = mainpage.errorCount + 1;
                    MixerBoxUtils.logMsg((new StringBuilder()).append("errorCount = ").append(errorCount).toString());
                    FlurryAgent.logEvent("status:youtube_player_error");
                    if (arrayPlayingSong == null || errorCount > arrayPlayingSong.size() + 2)
                    {
                        closePlayer();
                        MixerBoxUtils.toastMsg(_fld0, getResources().getString(0x7f08005a), 1);
                    }
                }

                _cls7()
                {
                    this$1 = MyJavaScriptInterface.this;
                    super();
                }
            }

            ((Activity)ctx).runOnUiThread(new _cls7());
        }

        public void showTime(final String time)
        {
            class _cls1
                implements Runnable
            {

                final MyJavaScriptInterface this$1;
                final String val$time;

                public void run()
                {
                    if ((playingSong == null || playingSong.getSongSource() != 3 && playingSong.getSongSource() != 2) && time != null && !time.equals("undefined"))
                    {
                        currentTime = (int)Math.round(Double.valueOf(time).doubleValue());
                        if (canUpdateSeekbar)
                        {
                            seekbar.setProgress((int)Math.round(Double.valueOf(time).doubleValue()));
                            tvTimeStart.setText(MixerBoxUtils.getSongTime(String.valueOf((int)Math.round(Double.valueOf(time).doubleValue()))));
                        }
                        if (rlPanelTop.getVisibility() == 8)
                        {
                            rlPanelPopup.setVisibility(8);
                            return;
                        }
                    }
                }

                _cls1()
                {
                    this$1 = MyJavaScriptInterface.this;
                    time = s;
                    super();
                }
            }

            ((Activity)ctx).runOnUiThread(new _cls1());
        }

        MyJavaScriptInterface(Context context)
        {
            this$0 = MainPage.this;
            super();
            ctx = context;
        }
    }


    private class _cls17
        implements android.view.View.OnClickListener
    {

        final MainPage this$0;

        public void onClick(View view)
        {
            if (videoState == 1)
            {
                mHandlerTime.removeMessages(1);
                mHandlerTime.sendEmptyMessageDelayed(1, 4000L);
            }
            if (rlPanelPopup.getVisibility() == 8)
            {
                rlPanelPopup.setVisibility(0);
                btnExpand.setImageDrawable(getResources().getDrawable(0x7f0200d3));
                return;
            } else
            {
                rlPanelPopup.setVisibility(8);
                btnExpand.setImageDrawable(getResources().getDrawable(0x7f0200db));
                return;
            }
        }

        _cls17()
        {
            this$0 = MainPage.this;
            super();
        }
    }


    private class _cls18
        implements android.view.View.OnClickListener
    {

        final MainPage this$0;

        public void onClick(View view)
        {
            shouldSendNoti = false;
            if (SCREEN_STATE == 2)
            {
                setUnFullScreen(false);
            }
            closePlayer();
        }

        _cls18()
        {
            this$0 = MainPage.this;
            super();
        }
    }


    private class _cls19
        implements android.view.View.OnClickListener
    {

        final MainPage this$0;

        public void onClick(View view)
        {
            musicPlayPause();
        }

        _cls19()
        {
            this$0 = MainPage.this;
            super();
        }
    }


    private class _cls20
        implements android.view.View.OnClickListener
    {

        final MainPage this$0;

        public void onClick(View view)
        {
            if (MainPage.PLAYER_REPEAT == 2 && arrayPlayingSong.size() > 0)
            {
                playingSongIndex = (playingSongIndex + 1) % arrayPlayingSong.size();
            }
            playNextSong();
        }

        _cls20()
        {
            this$0 = MainPage.this;
            super();
        }
    }


    private class _cls21
        implements android.view.View.OnClickListener
    {

        final MainPage this$0;

        public void onClick(View view)
        {
            if (currentTime >= 5)
            {
                wv.loadUrl("javascript:seekTo(0)");
                return;
            }
            if (MainPage.PLAYER_REPEAT == 2 && arrayPlayingSong.size() > 0)
            {
                view = MainPage.this;
                view.playingSongIndex = ((MainPage) (view)).playingSongIndex - 1;
                if (playingSongIndex == -1)
                {
                    playingSongIndex = arrayPlayingSong.size() - 1;
                }
            }
            playPreviousSong();
        }

        _cls21()
        {
            this$0 = MainPage.this;
            super();
        }
    }


    private class _cls22
        implements android.view.View.OnClickListener
    {

        final MainPage this$0;

        public void onClick(View view)
        {
            (new AddToPlaylistDialog(MainPage.this, playingSong)).show().getWindow().setSoftInputMode(16);
        }

        _cls22()
        {
            this$0 = MainPage.this;
            super();
        }
    }


    private class _cls23
        implements android.view.View.OnClickListener
    {

        final MainPage this$0;
        final ImageButton val$btnRepeat;

        public void onClick(View view)
        {
            MixerBoxUtils.logMsg((new StringBuilder()).append("CHANGE REPEAT MODE: ").append(MainPage.PLAYER_REPEAT).toString());
            mHandlerTime.removeMessages(1);
            mHandlerTime.sendEmptyMessageDelayed(1, 4000L);
            if (MainPage.PLAYER_REPEAT == 1)
            {
                MainPage.PLAYER_REPEAT = 2;
                btnRepeat.setImageDrawable(getResources().getDrawable(0x7f0200fe));
                MixerBoxUtils.toastMsg(MainPage.this, getResources().getString(0x7f08008b), 0);
                return;
            } else
            {
                MainPage.PLAYER_REPEAT = 1;
                btnRepeat.setImageDrawable(getResources().getDrawable(0x7f0200fd));
                MixerBoxUtils.toastMsg(MainPage.this, getResources().getString(0x7f08008a), 0);
                return;
            }
        }

        _cls23()
        {
            this$0 = MainPage.this;
            btnRepeat = imagebutton;
            super();
        }
    }


    private class _cls24
        implements android.view.View.OnClickListener
    {

        final MainPage this$0;
        final ImageButton val$btnShuffle;

        public void onClick(View view)
        {
            mHandlerTime.removeMessages(1);
            mHandlerTime.sendEmptyMessageDelayed(1, 4000L);
            if (MainPage.PLAYER_SHUFFLE)
            {
                MainPage.PLAYER_SHUFFLE = false;
                btnShuffle.setImageDrawable(getResources().getDrawable(0x7f020109));
                MixerBoxUtils.toastMsg(MainPage.this, getResources().getString(0x7f080094), 0);
                return;
            } else
            {
                shuffleCount = 0;
                genShuffleIndexArray();
                MainPage.PLAYER_SHUFFLE = true;
                btnShuffle.setImageDrawable(getResources().getDrawable(0x7f02010a));
                view = Toast.makeText(MainPage.this, getResources().getString(0x7f080095), 0);
                view.setGravity(16, 0, 0);
                view.show();
                return;
            }
        }

        _cls24()
        {
            this$0 = MainPage.this;
            btnShuffle = imagebutton;
            super();
        }
    }


    private class _cls25
        implements android.view.View.OnClickListener
    {

        final MainPage this$0;

        public void onClick(View view)
        {
            if (SCREEN_STATE != 2)
            {
                setFullScreen();
                return;
            } else
            {
                setUnFullScreen(false);
                return;
            }
        }

        _cls25()
        {
            this$0 = MainPage.this;
            super();
        }
    }


    private class _cls26
        implements android.view.View.OnClickListener
    {

        final MainPage this$0;

        public void onClick(View view)
        {
            boolean flag1 = true;
            mHandlerTime.removeMessages(1);
            mHandlerTime.sendEmptyMessageDelayed(1, 4000L);
            boolean flag2 = MixerBoxSharedPreferences.getHighQuality(MainPage.this);
            boolean flag;
            if (flag2)
            {
                view = new HashMap();
                view.put("from", "player");
                view.put("hd", "0");
                FlurryAgent.logEvent("action:set_hd", view);
                MixerBoxUtils.toastMsg(MainPage.this, (new StringBuilder()).append(getResources().getString(0x7f0800ed)).append(" ").append(getResources().getString(0x7f08007c)).toString(), 0);
            } else
            {
                view = new HashMap();
                view.put("from", "player");
                view.put("hd", "1");
                FlurryAgent.logEvent("action:set_hd", view);
                MixerBoxUtils.toastMsg(MainPage.this, (new StringBuilder()).append(getResources().getString(0x7f0800ed)).append(" ").append(getResources().getString(0x7f08007d)).toString(), 0);
            }
            if (fragmentSettings.isAdded())
            {
                view = fragmentSettings.cbHD;
                if (!flag2)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                view.setChecked(flag);
            }
            view = MainPage.this;
            if (!flag2)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            view.changeQuality(flag);
        }

        _cls26()
        {
            this$0 = MainPage.this;
            super();
        }
    }


    private class _cls27
        implements android.view.View.OnClickListener
    {

        final MainPage this$0;

        public void onClick(View view)
        {
            String s;
            String s1;
            Intent intent;
            if (playingPlaylist == null || playingPlaylist.getPlaylistType() == 5)
            {
                view = (new StringBuilder()).append("http://www.mixerbox.com/music/0/").append(playingSong.getSongYtId()).toString();
            } else
            {
                view = (new StringBuilder()).append("http://www.mixerbox.com/music/").append(playingPlaylist.getPlaylistId()).append("/").append(playingSong.getSongId()).toString();
            }
            s = (new StringBuilder()).append(getResources().getString(0x7f0800ba)).append(getResources().getString(0x7f0800b8)).toString();
            s1 = getResources().getString(0x7f0800b9);
            intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.SUBJECT", (new StringBuilder()).append(s).append(playingSong.getSongName()).append(s1).toString());
            intent.putExtra("android.intent.extra.TEXT", (new StringBuilder()).append(s).append(playingSong.getSongName()).append(s1).append(view).toString());
            startActivity(Intent.createChooser(intent, null));
        }

        _cls27()
        {
            this$0 = MainPage.this;
            super();
        }
    }


    private class _cls28
        implements android.widget.SeekBar.OnSeekBarChangeListener
    {

        int state;
        final MainPage this$0;

        public void onProgressChanged(SeekBar seekbar1, int i, boolean flag)
        {
            tvTimeStart.setText(MixerBoxUtils.getSongTime(String.valueOf((int)Math.round(Double.valueOf(i).doubleValue()))));
        }

        public void onStartTrackingTouch(SeekBar seekbar1)
        {
            mHandlerTime.removeMessages(1);
            canUpdateSeekbar = false;
            if (playingSong != null && (playingSong.getSongSource() == 3 || playingSong.getSongSource() == 2))
            {
                if (MyService.mediaPlayer.isPlaying())
                {
                    state = 1;
                }
                MyService.mediaPlayer.pause();
            }
        }

        public void onStopTrackingTouch(SeekBar seekbar1)
        {
            mHandlerTime.sendEmptyMessageDelayed(1, 4000L);
            canUpdateSeekbar = true;
            if (playingSong != null && playingSong.getSongSource() == 3 || playingPlaylist != null && playingPlaylist.getPlaylistType() == 8)
            {
                if (MyService.mediaPlayer != null)
                {
                    MyService.mediaPlayer.seekTo(seekbar1.getProgress() * 1000);
                    if (state == 1)
                    {
                        MyService.mediaPlayer.start();
                    }
                }
                return;
            } else
            {
                wv.loadUrl((new StringBuilder()).append("javascript:seekTo(").append(seekbar1.getProgress()).append(")").toString());
                return;
            }
        }

        _cls28()
        {
            this$0 = MainPage.this;
            super();
            state = 0;
        }
    }

}
