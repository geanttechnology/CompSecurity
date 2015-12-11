// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.Session;
import com.flurry.android.FlurryAgent;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.mixerbox.mixerbox3b.LoginBridge;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.classes.DJInfoVectorItem;
import com.mixerbox.mixerbox3b.classes.DJVectorItem;
import com.mixerbox.mixerbox3b.classes.DividerVectorItem;
import com.mixerbox.mixerbox3b.classes.EmptyVectorItem;
import com.mixerbox.mixerbox3b.classes.GeneralVectorItem;
import com.mixerbox.mixerbox3b.classes.MoreVectorItem;
import com.mixerbox.mixerbox3b.classes.MusicVectorItem;
import com.mixerbox.mixerbox3b.classes.PlaylistItem;
import com.mixerbox.mixerbox3b.classes.PlaylistVectorItem;
import com.mixerbox.mixerbox3b.classes.SongItem;
import com.mixerbox.mixerbox3b.classes.VectorOnClickListener;
import com.mixerbox.mixerbox3b.classes.VectorVectorItem;
import com.mixerbox.mixerbox3b.dialogs.AddToPlaylistDialog;
import com.mixerbox.mixerbox3b.dialogs.RemoveDialog;
import com.mixerbox.mixerbox3b.fragments.PlaylistsFragment;
import com.mixerbox.mixerbox3b.fragments.SongFragment;
import com.mixerbox.mixerbox3b.fragments.VectorFragment;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Stack;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.mixerbox.mixerbox3b.utils:
//            MixerBoxClient, MixerBoxSharedPreferences, MixerBoxSQLite

public class MixerBoxUtils
{

    static Bundle bundle;
    static int retryCount = 0;
    static Toast toast = null;

    public MixerBoxUtils()
    {
    }

    public static void addMyItemToArray(List list, JSONObject jsonobject, Context context, int i, int j)
    {
        try
        {
            if (jsonobject.getString("type").equals("divider"))
            {
                list.add(new DividerVectorItem(jsonobject, context));
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            list.add(new EmptyVectorItem());
            return;
        }
        if (jsonobject.getString("type").equals("dj"))
        {
            list.add(new DJVectorItem(context, jsonobject));
            return;
        }
        if (jsonobject.getString("type").equals("more"))
        {
            list.add(new MoreVectorItem(context, jsonobject));
            return;
        }
        if (jsonobject.getString("type").equals("music"))
        {
            list.add(new MusicVectorItem(context, jsonobject, i, j));
            return;
        }
        if (jsonobject.getString("type").equals("playlist"))
        {
            list.add(new PlaylistVectorItem(context, jsonobject));
            return;
        }
        if (jsonobject.getString("type").equals("vector"))
        {
            list.add(new VectorVectorItem(jsonobject));
            return;
        }
        if (jsonobject.getString("type").equals("general"))
        {
            list.add(new GeneralVectorItem(context, jsonobject));
            return;
        }
        if (jsonobject.getString("type").equals("dj_info"))
        {
            list.add(new DJInfoVectorItem(context, jsonobject));
            return;
        }
        list.add(new EmptyVectorItem());
        return;
    }

    public static void addSong(final Context final_context, final String pid, SongItem songitem, final boolean shouldToast, final String pname)
    {
        MixerBoxClient.get(MixerBoxClient.addSongUrl(pid, songitem), null, new _cls14(songitem));
    }

    public static void addSongToNewPlaylist(final Context final_context, String s, final SongItem song)
    {
        MixerBoxClient.get(MixerBoxClient.createPlaylistUrl(s), null, new _cls19(s));
    }

    public static void createPlaylist(final Context final_context, String s)
    {
        MixerBoxClient.get(MixerBoxClient.createPlaylistUrl(s), null, new _cls18(s));
    }

    public static void createPopupMenu(final Context ctx, View view, final SongItem currentSong, final String currentPlaylistId, final int k)
    {
        view = new PopupMenu(ctx, view);
        if (MixerBoxSharedPreferences.getDefaultAddedPlaylistId(ctx).length() > 0)
        {
            String s = MixerBoxSharedPreferences.getDefaultAddedPlaylistId(ctx);
            String s1 = MixerBoxSharedPreferences.getDefaultAddedPlaylistName(ctx);
            if (((MainPage)ctx).myPlaylists.contains(s))
            {
                view.getMenu().add(0, 0, 0, String.format(ctx.getResources().getString(0x7f08014e), new Object[] {
                    s1
                }));
            } else
            {
                MixerBoxSharedPreferences.putDefaultAddedPlaylist(ctx, "", "");
            }
        }
        view.getMenu().add(0, 1, 1, ctx.getResources().getString(0x7f080061));
        if (((MainPage)ctx).currentFragment != 8 && currentSong.getSongSource() != 3 && !currentPlaylistId.equals("PLAYLISTHISTORYID"))
        {
            view.getMenu().add(0, 2, 2, ctx.getResources().getString(0x7f080093));
        }
        if (((MainPage)ctx).myPlaylists.contains(currentPlaylistId) && ((MainPage)ctx).currentFragment != 8 && ((MainPage)ctx).currentFragment != 9 || currentPlaylistId.equals("PLAYLISTHISTORYID"))
        {
            view.getMenu().add(0, 3, 3, ctx.getResources().getString(0x7f080055));
        }
        view.setOnMenuItemClickListener(new _cls25());
        view.show();
    }

    static void finishFetchInitData(Context context)
    {
        Intent intent = new Intent();
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        bundle.putBoolean("isLogIn", true);
        intent.putExtras(bundle);
        intent.setClass(context, com/mixerbox/mixerbox3b/LoginBridge);
        context.startActivity(intent);
        ((Activity)context).finish();
    }

    public static void getArtistAlbums(final Context final_context, String s)
    {
        if (((MainPage)final_context).arrayLocalNotificationList.size() >= 9)
        {
            return;
        } else
        {
            MixerBoxClient.get(MixerBoxClient.getArtistAlbumUrl(s), null, new _cls22(final_context));
            return;
        }
    }

    public static void getAuthLoginInfo(final Context final_context, Session session)
    {
        MixerBoxClient.get(MixerBoxClient.getAuthLoginUrl(MixerBoxSharedPreferences.getUUID(final_context), session.getAccessToken()), null, new _cls1(session));
    }

    public static Bitmap getBitmapFromURL(String s)
    {
        Bitmap bitmap;
        try
        {
            s = (HttpURLConnection)(new URL(s)).openConnection();
            s.setDoInput(true);
            s.connect();
            s = s.getInputStream();
            BufferedInputStream bufferedinputstream = new BufferedInputStream(s);
            bitmap = BitmapFactory.decodeStream(bufferedinputstream);
            bufferedinputstream.close();
            s.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return bitmap;
    }

    public static void getDJs(final Context final_context)
    {
        MixerBoxClient.get(MixerBoxClient.getDJsUrl(final_context, (new StringBuilder()).append(Locale.getDefault().getLanguage()).append("-").append(Locale.getDefault().getCountry().toLowerCase(Locale.getDefault())).toString()), null, new _cls7(final_context));
    }

    public static void getFollower(final Context final_context, String s, final VectorFragment f)
    {
        MixerBoxClient.get(MixerBoxClient.getFollowerUrl(s), null, new _cls12(final_context));
    }

    public static PlaylistItem getPlaylistItem(JSONObject jsonobject, String s, int i)
    {
        String s1;
        String s2;
        String s3;
        String s4;
        String s5;
        Boolean boolean1;
        String s10;
        s1 = "";
        s2 = "";
        s3 = "";
        s4 = "";
        s5 = "";
        s10 = "";
        boolean1 = Boolean.valueOf(false);
        if (jsonobject == null) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        String s6;
        String s7;
        String s8;
        String s9;
        String s11;
        obj = s1;
        obj1 = s1;
        s6 = s2;
        s7 = s3;
        s8 = s4;
        s9 = s5;
        s11 = s10;
        if (!jsonobject.has("_id"))
        {
            break MISSING_BLOCK_LABEL_140;
        }
        obj = s1;
        obj1 = s1;
        s6 = s2;
        s7 = s3;
        s8 = s4;
        s9 = s5;
        s11 = s10;
        if (jsonobject.isNull("_id"))
        {
            break MISSING_BLOCK_LABEL_140;
        }
        obj1 = s1;
        s6 = s2;
        s7 = s3;
        s8 = s4;
        s9 = s5;
        s11 = s10;
        obj = jsonobject.getString("_id");
        s1 = s2;
        obj1 = obj;
        s6 = s2;
        s7 = s3;
        s8 = s4;
        s9 = s5;
        s11 = s10;
        if (!jsonobject.has("name"))
        {
            break MISSING_BLOCK_LABEL_246;
        }
        s1 = s2;
        obj1 = obj;
        s6 = s2;
        s7 = s3;
        s8 = s4;
        s9 = s5;
        s11 = s10;
        if (jsonobject.isNull("name"))
        {
            break MISSING_BLOCK_LABEL_246;
        }
        obj1 = obj;
        s6 = s2;
        s7 = s3;
        s8 = s4;
        s9 = s5;
        s11 = s10;
        s1 = jsonobject.getString("name");
        s2 = s3;
        obj1 = obj;
        s6 = s1;
        s7 = s3;
        s8 = s4;
        s9 = s5;
        s11 = s10;
        if (!jsonobject.has("owner"))
        {
            break MISSING_BLOCK_LABEL_352;
        }
        s2 = s3;
        obj1 = obj;
        s6 = s1;
        s7 = s3;
        s8 = s4;
        s9 = s5;
        s11 = s10;
        if (jsonobject.isNull("owner"))
        {
            break MISSING_BLOCK_LABEL_352;
        }
        obj1 = obj;
        s6 = s1;
        s7 = s3;
        s8 = s4;
        s9 = s5;
        s11 = s10;
        s2 = jsonobject.getString("owner");
        s3 = s4;
        obj1 = obj;
        s6 = s1;
        s7 = s2;
        s8 = s4;
        s9 = s5;
        s11 = s10;
        if (!jsonobject.has("ownerName"))
        {
            break MISSING_BLOCK_LABEL_458;
        }
        s3 = s4;
        obj1 = obj;
        s6 = s1;
        s7 = s2;
        s8 = s4;
        s9 = s5;
        s11 = s10;
        if (jsonobject.isNull("ownerName"))
        {
            break MISSING_BLOCK_LABEL_458;
        }
        obj1 = obj;
        s6 = s1;
        s7 = s2;
        s8 = s4;
        s9 = s5;
        s11 = s10;
        s3 = jsonobject.getString("ownerName");
        s4 = s5;
        obj1 = obj;
        s6 = s1;
        s7 = s2;
        s8 = s3;
        s9 = s5;
        s11 = s10;
        if (!jsonobject.has("itemCount"))
        {
            break MISSING_BLOCK_LABEL_564;
        }
        s4 = s5;
        obj1 = obj;
        s6 = s1;
        s7 = s2;
        s8 = s3;
        s9 = s5;
        s11 = s10;
        if (jsonobject.isNull("itemCount"))
        {
            break MISSING_BLOCK_LABEL_564;
        }
        obj1 = obj;
        s6 = s1;
        s7 = s2;
        s8 = s3;
        s9 = s5;
        s11 = s10;
        s4 = jsonobject.getString("itemCount");
        s5 = s10;
        obj1 = obj;
        s6 = s1;
        s7 = s2;
        s8 = s3;
        s9 = s4;
        s11 = s10;
        if (!jsonobject.has("subsCnt"))
        {
            break MISSING_BLOCK_LABEL_670;
        }
        s5 = s10;
        obj1 = obj;
        s6 = s1;
        s7 = s2;
        s8 = s3;
        s9 = s4;
        s11 = s10;
        if (jsonobject.isNull("subsCnt"))
        {
            break MISSING_BLOCK_LABEL_670;
        }
        obj1 = obj;
        s6 = s1;
        s7 = s2;
        s8 = s3;
        s9 = s4;
        s11 = s10;
        s5 = jsonobject.getString("subsCnt");
        obj1 = obj;
        s6 = s1;
        s7 = s2;
        s8 = s3;
        s9 = s4;
        s11 = s5;
        if (!jsonobject.has(s))
        {
            break MISSING_BLOCK_LABEL_765;
        }
        obj1 = obj;
        s6 = s1;
        s7 = s2;
        s8 = s3;
        s9 = s4;
        s11 = s5;
        if (jsonobject.isNull(s))
        {
            break MISSING_BLOCK_LABEL_765;
        }
        obj1 = obj;
        s6 = s1;
        s7 = s2;
        s8 = s3;
        s9 = s4;
        s11 = s5;
        s10 = jsonobject.getString(s);
        s = s10;
        obj1 = boolean1;
        boolean flag;
        if (jsonobject.isNull("isAlbum"))
        {
            break MISSING_BLOCK_LABEL_795;
        }
        flag = jsonobject.getBoolean("isAlbum");
        obj1 = Boolean.valueOf(flag);
        jsonobject = ((JSONObject) (obj1));
_L5:
        return new PlaylistItem(((String) (obj)), s1, s2, s3, s4, s5, s, i, jsonobject.booleanValue());
        jsonobject;
        s5 = s11;
        s4 = s9;
        s3 = s8;
        s2 = s7;
        s1 = s6;
        obj = obj1;
_L3:
        jsonobject.printStackTrace();
        jsonobject = boolean1;
        continue; /* Loop/switch isn't completed */
        jsonobject;
        if (true) goto _L3; else goto _L2
_L2:
        jsonobject = boolean1;
        obj = s1;
        s1 = s2;
        s2 = s3;
        s3 = s4;
        s4 = s5;
        s5 = s10;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static ArrayList getSongArray(String s, SongFragment songfragment)
    {
        ArrayList arraylist;
        arraylist = new ArrayList();
        if (s == null)
        {
            return arraylist;
        }
        s = new JSONObject(s);
        if (s.isNull("getVector"))
        {
            return arraylist;
        }
        s = s.getJSONObject("getVector");
        if (s.isNull("items"))
        {
            return arraylist;
        }
        JSONArray jsonarray;
        int i;
        jsonarray = s.getJSONArray("items");
        i = jsonarray.length() - 1;
_L8:
        if (i < 0) goto _L2; else goto _L1
_L1:
        if (!jsonarray.isNull(i)) goto _L4; else goto _L3
_L3:
        arraylist.add(new SongItem("", "", "", "", i, 1, ""));
          goto _L5
_L4:
        arraylist.add(getSongItem(jsonarray.getJSONObject(i), i));
          goto _L5
_L6:
        return arraylist;
_L2:
        if (!s.isNull("subsCnt") && songfragment != null)
        {
            try
            {
                songfragment.currentPlaylist.putSubsCount(s.getString("subsCnt"));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
        i--;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static SongItem getSongItem(JSONObject jsonobject, int i)
    {
        String s1;
        String s3;
        String s4;
        String s5;
        Object obj;
        String s6;
        String s7;
        String s8;
        String s12;
        int j;
        j = 1;
        s1 = "";
        s3 = "";
        s8 = "0";
        s12 = "";
        s6 = "";
        s4 = s3;
        s5 = s8;
        obj = s1;
        s7 = s6;
        if (jsonobject.isNull("source")) goto _L2; else goto _L1
_L1:
        s4 = s3;
        s5 = s8;
        obj = s1;
        s7 = s6;
        if (!jsonobject.getString("source").equals("soundcloud")) goto _L2; else goto _L3
_L3:
        String s;
        s = s1;
        s4 = s3;
        s5 = s8;
        obj = s1;
        s7 = s6;
        if (!jsonobject.has("_id"))
        {
            break MISSING_BLOCK_LABEL_156;
        }
        s = s1;
        s4 = s3;
        s5 = s8;
        obj = s1;
        s7 = s6;
        if (jsonobject.isNull("_id"))
        {
            break MISSING_BLOCK_LABEL_156;
        }
        s4 = s3;
        s5 = s8;
        obj = s1;
        s7 = s6;
        s = jsonobject.getString("_id");
        String s2;
        s2 = s6;
        s4 = s3;
        s5 = s8;
        obj = s;
        s7 = s6;
        if (!jsonobject.has("thumbnail"))
        {
            break MISSING_BLOCK_LABEL_238;
        }
        s2 = s6;
        s4 = s3;
        s5 = s8;
        obj = s;
        s7 = s6;
        if (jsonobject.isNull("thumbnail"))
        {
            break MISSING_BLOCK_LABEL_238;
        }
        s4 = s3;
        s5 = s8;
        obj = s;
        s7 = s6;
        s2 = jsonobject.getString("thumbnail");
        s1 = s3;
        s4 = s3;
        s5 = s8;
        obj = s;
        s7 = s2;
        if (!jsonobject.has("title"))
        {
            break MISSING_BLOCK_LABEL_317;
        }
        s1 = s3;
        s4 = s3;
        s5 = s8;
        obj = s;
        s7 = s2;
        if (jsonobject.isNull("title"))
        {
            break MISSING_BLOCK_LABEL_317;
        }
        s4 = s3;
        s5 = s8;
        obj = s;
        s7 = s2;
        s1 = jsonobject.getString("title");
        s3 = s8;
        s4 = s1;
        s5 = s8;
        obj = s;
        s7 = s2;
        if (!jsonobject.has("duration"))
        {
            break MISSING_BLOCK_LABEL_396;
        }
        s3 = s8;
        s4 = s1;
        s5 = s8;
        obj = s;
        s7 = s2;
        if (jsonobject.isNull("duration"))
        {
            break MISSING_BLOCK_LABEL_396;
        }
        s4 = s1;
        s5 = s8;
        obj = s;
        s7 = s2;
        s3 = jsonobject.getString("duration");
        String s9;
        String s10;
        String s11;
        s4 = s1;
        s5 = s3;
        obj = s;
        s7 = s2;
        s10 = s1;
        s9 = s3;
        s11 = s;
        s8 = s2;
        if (!jsonobject.has("trackId")) goto _L5; else goto _L4
_L4:
        s4 = s1;
        s5 = s3;
        obj = s;
        s7 = s2;
        s10 = s1;
        s9 = s3;
        s11 = s;
        s8 = s2;
        if (jsonobject.isNull("trackId")) goto _L5; else goto _L6
_L6:
        s4 = s1;
        s5 = s3;
        obj = s;
        s7 = s2;
        s6 = jsonobject.getString("trackId");
        s4 = s6;
_L12:
        boolean flag = jsonobject.isNull("source");
        if (!flag) goto _L8; else goto _L7
_L7:
        j = 1;
        jsonobject = s4;
_L9:
        return new SongItem(s, s1, s3, jsonobject, i, j, s2);
_L2:
        s = s1;
        s4 = s3;
        s5 = s8;
        obj = s1;
        s7 = s6;
        if (!jsonobject.has("_id"))
        {
            break MISSING_BLOCK_LABEL_614;
        }
        s = s1;
        s4 = s3;
        s5 = s8;
        obj = s1;
        s7 = s6;
        if (jsonobject.isNull("_id"))
        {
            break MISSING_BLOCK_LABEL_614;
        }
        s4 = s3;
        s5 = s8;
        obj = s1;
        s7 = s6;
        s = jsonobject.getString("_id");
        s1 = s3;
        s4 = s3;
        s5 = s8;
        obj = s;
        s7 = s6;
        if (!jsonobject.has("tt"))
        {
            break MISSING_BLOCK_LABEL_693;
        }
        s1 = s3;
        s4 = s3;
        s5 = s8;
        obj = s;
        s7 = s6;
        if (jsonobject.isNull("tt"))
        {
            break MISSING_BLOCK_LABEL_693;
        }
        s4 = s3;
        s5 = s8;
        obj = s;
        s7 = s6;
        s1 = jsonobject.getString("tt");
        s2 = s8;
        s4 = s1;
        s5 = s8;
        obj = s;
        s7 = s6;
        if (!jsonobject.has("tm"))
        {
            break MISSING_BLOCK_LABEL_772;
        }
        s2 = s8;
        s4 = s1;
        s5 = s8;
        obj = s;
        s7 = s6;
        if (jsonobject.isNull("tm"))
        {
            break MISSING_BLOCK_LABEL_772;
        }
        s4 = s1;
        s5 = s8;
        obj = s;
        s7 = s6;
        s2 = jsonobject.getString("tm");
        s4 = s1;
        s5 = s2;
        obj = s;
        s7 = s6;
        s10 = s1;
        s9 = s2;
        s11 = s;
        s8 = s6;
        if (!jsonobject.has("f"))
        {
            break; /* Loop/switch isn't completed */
        }
        s4 = s1;
        s5 = s2;
        obj = s;
        s7 = s6;
        s10 = s1;
        s9 = s2;
        s11 = s;
        s8 = s6;
        if (jsonobject.isNull("f"))
        {
            break; /* Loop/switch isn't completed */
        }
        s4 = s1;
        s5 = s2;
        obj = s;
        s7 = s6;
        s3 = jsonobject.getString("f");
        s4 = s3;
        s3 = s2;
        s2 = s6;
        continue; /* Loop/switch isn't completed */
_L8:
        if (jsonobject.getString("source").equals("youtube"))
        {
            j = 1;
            jsonobject = s4;
            continue; /* Loop/switch isn't completed */
        }
        flag = jsonobject.getString("source").equals("soundcloud");
        if (flag)
        {
            j = 3;
        }
        jsonobject = s4;
        continue; /* Loop/switch isn't completed */
        jsonobject;
        s = ((String) (obj));
        obj = jsonobject;
        s2 = s7;
        jsonobject = s12;
        s3 = s5;
        s1 = s4;
_L10:
        ((JSONException) (obj)).printStackTrace();
        j = 1;
        if (true) goto _L9; else goto _L5
        obj;
        jsonobject = s4;
          goto _L10
_L5:
        s = s11;
        s1 = s10;
        s3 = s9;
        s4 = s12;
        s2 = s8;
        if (true) goto _L12; else goto _L11
_L11:
    }

    public static String getSongTime(String s)
    {
        int i;
        try
        {
            i = Integer.valueOf(s).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return "0:00";
        }
        if (i >= 3600)
        {
            if ((i % 3600) / 60 < 10)
            {
                s = (new StringBuilder()).append(i / 3600).append(":0").append((i % 3600) / 60).toString();
            } else
            {
                s = (new StringBuilder()).append(i / 3600).append(":").append((i % 3600) / 60).toString();
            }
        } else
        if (i / 60 < 10)
        {
            s = (new StringBuilder()).append("0").append(i / 60).toString();
        } else
        {
            s = (new StringBuilder()).append(i / 60).append("").toString();
        }
        if (i % 60 < 10)
        {
            return (new StringBuilder()).append(s).append(":0").append(i % 60).toString();
        } else
        {
            return (new StringBuilder()).append(s).append(":").append(i % 60).toString();
        }
    }

    public static void getSubsInfo(final Context final_context, String s, final VectorFragment f)
    {
        MixerBoxClient.get(MixerBoxClient.getSubsInfoUrl(s), null, new _cls11(final_context));
    }

    public static void getVector(final Context final_context, String s, final VectorFragment f, final String type, final String title)
    {
        MixerBoxClient.get(MixerBoxClient.getVectorUrl(s, 0, type), null, new _cls8(final_context));
    }

    public static void laterLoginInit(Context context, Session session, Bundle bundle1)
    {
        bundle = bundle1;
        getAuthLoginInfo(context, session);
    }

    public static void loadDBSong(Context context, String s, boolean flag, SongFragment songfragment)
    {
        ((MainPage)context).arraySong = new ArrayList();
        s = ((MainPage)context).DB.getSong(s);
        int j = s.getCount();
        s.moveToLast();
        for (int i = 0; i < j; i++)
        {
            ((MainPage)context).arraySong.add(new SongItem(s.getString(0), s.getString(2), s.getString(3), s.getString(4), i, s.getInt(6), s.getString(7)));
            s.moveToPrevious();
        }

        s.close();
        if (songfragment != null)
        {
            songfragment.loadContent();
        }
        if (!flag || ((MainPage)context).arraySong.size() == 0)
        {
            return;
        }
        ((MainPage)context).arrayPlayingSong = new ArrayList(((MainPage)context).arraySong);
        ((MainPage)context).playingSong = (SongItem)((MainPage)context).arrayPlayingSong.get(0);
        if (songfragment != null)
        {
            ((MainPage)context).playingPlaylist = ((SongFragment)((MainPage)context).stack.lastElement()).currentPlaylist;
        } else
        if (((MainPage)context).arrayMyPlaylists.size() > 1)
        {
            ((MainPage)context).playingPlaylist = (PlaylistItem)((MainPage)context).arrayMyPlaylists.get(1);
        } else
        {
            ((MainPage)context).playingPlaylist = null;
        }
        ((MainPage)context).playingSongIndex = 0;
        ((MainPage)context).playMusic(true);
    }

    public static String loadJSONFromAsset(Context context, String s)
    {
        try
        {
            context = context.getAssets().open(s);
            s = new byte[context.available()];
            context.read(s);
            context.close();
            context = new String(s, "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return null;
        }
        return context;
    }

    public static void loadMP3Song(Context context, boolean flag, SongFragment songfragment, String s, Uri uri)
    {
        ((MainPage)context).arraySong = new ArrayList();
        s = context.getContentResolver().query(uri, new String[] {
            "album_id", "title", "duration", "_data", "artist"
        }, s, null, null);
        int j = s.getCount();
        if (j <= 0) goto _L2; else goto _L1
_L1:
        s.moveToFirst();
        int i = 0;
_L3:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        ((MainPage)context).arraySong.add(new SongItem(s.getString(0), (new StringBuilder()).append(s.getString(4)).append(" - ").append(s.getString(1)).toString(), String.valueOf(Integer.valueOf(s.getString(2)).intValue() / 1000), s.getString(3), i, 2, ""));
        s.moveToNext();
        i++;
        if (true) goto _L3; else goto _L2
_L2:
        if (s != null)
        {
            s.close();
        }
_L5:
        if (songfragment != null)
        {
            songfragment.loadContent();
        }
        if (!flag || ((MainPage)context).arraySong.size() == 0)
        {
            return;
        }
        break; /* Loop/switch isn't completed */
        s;
        s = null;
_L8:
        if (s != null)
        {
            s.close();
        }
        if (true) goto _L5; else goto _L4
        context;
        s = null;
_L7:
        if (s != null)
        {
            s.close();
        }
        throw context;
_L4:
        ((MainPage)context).arrayPlayingSong = new ArrayList(((MainPage)context).arraySong);
        ((MainPage)context).playingSong = (SongItem)((MainPage)context).arrayPlayingSong.get(0);
        if (songfragment != null)
        {
            ((MainPage)context).playingPlaylist = ((SongFragment)((MainPage)context).stack.lastElement()).currentPlaylist;
        } else
        {
            ((MainPage)context).playingPlaylist = null;
        }
        ((MainPage)context).playingSongIndex = 0;
        ((MainPage)context).playMusic(false);
        return;
        context;
        if (true) goto _L7; else goto _L6
_L6:
        uri;
          goto _L8
    }

    public static void loadSong(final Context final_context, String s, final boolean hasToGoBack, final int type, final int playIndex, SongFragment songfragment)
    {
        MixerBoxClient.get(MixerBoxClient.getSongUrl(s), null, new _cls13(songfragment));
    }

    public static void logMsg(String s)
    {
    }

    public static SpannableString makeLinkSpan(CharSequence charsequence, VectorOnClickListener vectoronclicklistener, Context context)
    {
        SpannableString spannablestring = new SpannableString(charsequence);
        spannablestring.setSpan(new StyleSpan(1), 0, charsequence.length(), 33);
        spannablestring.setSpan(new ClickableString(vectoronclicklistener), 0, charsequence.length(), 33);
        spannablestring.setSpan(new NoUnderlineSpan(), 0, charsequence.length(), 33);
        spannablestring.setSpan(new ForegroundColorSpan(context.getResources().getColor(0x7f060019)), 0, charsequence.length(), 33);
        return spannablestring;
    }

    public static void makeLinksFocusable(TextView textview)
    {
        android.text.method.MovementMethod movementmethod = textview.getMovementMethod();
        if ((movementmethod == null || !(movementmethod instanceof LinkMovementMethod)) && textview.getLinksClickable())
        {
            textview.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public static void parseDBMyPlaylists(final Context final_context)
    {
        if (((MainPage)final_context).isLogIn)
        {
            Cursor cursor = ((MainPage)final_context).DB.getMyPlaylist();
            int i = cursor.getCount();
            cursor.moveToLast();
            for (i--; i >= 0; i--)
            {
                int j = Integer.valueOf(i).intValue();
                final String dbPid = cursor.getString(0);
                MixerBoxClient.get(MixerBoxClient.createPlaylistUrl(cursor.getString(2)), null, new _cls6(j));
                cursor.moveToPrevious();
            }

            cursor.close();
            reloadMyPlaylist(final_context, false);
        }
    }

    public static void parseDBMySubs(final Context final_context)
    {
        if (((MainPage)final_context).isLogIn)
        {
            Cursor cursor = ((MainPage)final_context).DB.getShouldAddPlaylist();
            int i = cursor.getCount();
            cursor.moveToLast();
            for (i--; i >= 0; i--)
            {
                final int i1 = Integer.valueOf(i).intValue();
                ((MainPage)final_context).mySubscriptions.add(cursor.getString(1));
                boolean flag = false;
                if (cursor.getInt(9) == 1)
                {
                    flag = true;
                }
                ((MainPage)final_context).arrayMySubsPlaylists.add(new PlaylistItem(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getInt(8), flag));
                final String pid = cursor.getString(1);
                MixerBoxClient.get(MixerBoxClient.subsPlaylistUrl(pid), null, new _cls5(final_context));
                cursor.moveToPrevious();
            }

            cursor.close();
            reloadMySubsPlaylist(final_context, false, false);
        }
    }

    private static void parseMyPlaylist(Context context, String s, boolean flag)
    {
        String s1;
        if (s != null)
        {
            MixerBoxSharedPreferences.putAuthLoginResponse(context, s);
            ((MainPage)context).myPlaylists = new ArrayList();
            s = (new JSONObject(s)).getJSONObject("authLoginV2").getJSONObject("data");
            ArrayList arraylist = new ArrayList();
            JSONArray jsonarray = s.getJSONArray("playlists");
            int i;
            if (android.os.Build.VERSION.SDK_INT >= 15)
            {
                s = "coverhq";
            } else
            {
                s = "cover";
            }
            i = jsonarray.length() - 1;
            while (i >= 0) 
            {
                if (jsonarray.isNull(i))
                {
                    arraylist.add(new PlaylistItem("", "", "", "", "", "", "", 0, false));
                } else
                {
                    JSONObject jsonobject = jsonarray.getJSONObject(i);
                    arraylist.add(getPlaylistItem(jsonobject, s, 1));
                    ((MainPage)context).myPlaylists.add(jsonobject.getString("_id"));
                }
                i--;
            }
            ((MainPage)context).arrayMyPlaylists = new ArrayList(arraylist);
        } else
        {
            ((MainPage)context).arrayMyPlaylists = new ArrayList();
        }
        s = "";
        s1 = (new StringBuilder()).append("http://i.ytimg.com/vi/").append(((MainPage)context).DB.getLastHistory()).append("/mqdefault.jpg").toString();
        s = s1;
_L6:
        ((MainPage)context).arrayMyPlaylists.add(new PlaylistItem("PLAYLISTHISTORYID", ((MainPage)context).getResources().getString(0x7f080111), "", "", (new StringBuilder()).append("").append(((MainPage)context).DB.getSongCount("PLAYLISTHISTORYID")).toString(), "", s, 6, false));
        ((MainPage)context).checkMP3CountAndLoad();
        if (!flag) goto _L2; else goto _L1
_L1:
        ((MainPage)context).setPlaylists(false);
        if (((MainPage)context).fragmentPlaylists.lv != null)
        {
            ((MainPage)context).fragmentPlaylists.lv.onRefreshComplete();
        }
_L4:
        return;
_L2:
        if (((MainPage)context).fragmentPlaylists == null || ((MainPage)context).currentFragment != 0 && ((MainPage)context).currentFragment != 5 && ((MainPage)context).currentFragment != 4) goto _L4; else goto _L3
_L3:
        ((MainPage)context).fragmentPlaylists.loadContent();
        return;
        Exception exception;
        exception;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private static void parseMySubsPlaylist(final Context ctx, String s, boolean flag, boolean flag1)
    {
        if (s != null)
        {
            MixerBoxSharedPreferences.putAuthLoginResponse(ctx, s);
            s = (new JSONObject(s)).getJSONObject("authLoginV2").getJSONObject("data");
            if (flag1)
            {
                ((MainPage)ctx).arrayMySubsPlaylists = new ArrayList();
                ((MainPage)ctx).mySubscriptions.clear();
            }
            JSONArray jsonarray = s.getJSONArray("subs_playlists");
            int i;
            if (android.os.Build.VERSION.SDK_INT >= 15)
            {
                s = "coverhq";
            } else
            {
                s = "cover";
            }
            for (i = jsonarray.length() - 1; i >= 0; i--)
            {
                JSONObject jsonobject = jsonarray.getJSONObject(i);
                ((MainPage)ctx).arrayMySubsPlaylists.add(getPlaylistItem(jsonobject, s, 2));
                ((MainPage)ctx).mySubscriptions.add(jsonobject.getString("_id"));
            }

            (new Thread(new _cls4())).start();
        } else
        {
            ((MainPage)ctx).arrayMySubsPlaylists = new ArrayList();
        }
        if (flag)
        {
            if (((MainPage)ctx).fragmentPlaylists.lv != null)
            {
                ((MainPage)ctx).fragmentPlaylists.lv.onRefreshComplete();
            }
            ((MainPage)ctx).setPlaylists(false);
        } else
        if (((MainPage)ctx).fragmentPlaylists != null)
        {
            ((MainPage)ctx).fragmentPlaylists.loadContent();
            return;
        }
    }

    public static void performSongAction(Context context, int i, SongItem songitem, String s, int j)
    {
        switch (i)
        {
        default:
            return;

        case 0: // '\0'
            s = MixerBoxSharedPreferences.getDefaultAddedPlaylistId(context);
            String s1 = MixerBoxSharedPreferences.getDefaultAddedPlaylistName(context);
            if (((MainPage)context).isLogIn)
            {
                addSong(context, s, songitem, true, s1);
                return;
            } else
            {
                FlurryAgent.logEvent("action:music_add_local");
                ((MainPage)context).DB.addSong(s, songitem.getSongName(), songitem.getSongTime(), songitem.getSongYtId(), songitem.getSongOrder(), songitem.getSongSource(), songitem.getSongThumbnail());
                toastMsg(context, context.getResources().getString(0x7f080077), 1);
                ((MainPage)context).fragmentPlaylists.loadContent();
                return;
            }

        case 1: // '\001'
            (new AddToPlaylistDialog(context, songitem)).show().getWindow().setSoftInputMode(16);
            return;

        case 2: // '\002'
            Object obj = new HashMap();
            ((Map) (obj)).put("f", songitem.getSongYtId());
            ((Map) (obj)).put("id", songitem.getSongId());
            ((Map) (obj)).put("playlist", s);
            ((Map) (obj)).put("t", "yt");
            FlurryAgent.logEvent("action:music_share", ((Map) (obj)));
            String s2;
            Intent intent;
            if (((SongFragment)((MainPage)context).stack.lastElement()).currentPlaylist.getPlaylistType() == 6)
            {
                s = (new StringBuilder()).append("http://www.mixerbox.com/music/0/").append(songitem.getSongYtId()).toString();
            } else
            if (((SongFragment)((MainPage)context).stack.lastElement()).currentPlaylist.getPlaylistType() != 5)
            {
                s = (new StringBuilder()).append("http://www.mixerbox.com/music/").append(s).append("/").append(songitem.getSongId()).toString();
            } else
            {
                s = (new StringBuilder()).append("http://www.mixerbox.com/music/0/").append(songitem.getSongYtId()).toString();
            }
            obj = (new StringBuilder()).append(context.getResources().getString(0x7f0800ba)).append(context.getResources().getString(0x7f0800b8)).toString();
            s2 = context.getResources().getString(0x7f0800b9);
            intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.SUBJECT", (new StringBuilder()).append(((String) (obj))).append(songitem.getSongName()).append(s2).toString());
            intent.putExtra("android.intent.extra.TEXT", (new StringBuilder()).append(((String) (obj))).append(songitem.getSongName()).append(s2).append(s).toString());
            context.startActivity(Intent.createChooser(intent, null));
            return;

        case 3: // '\003'
            (new RemoveDialog(context, 2, s, songitem, j)).show();
            return;
        }
    }

    public static void reloadMyPlaylist(final Context final_context, boolean flag)
    {
        MixerBoxClient.get(MixerBoxClient.getAuthLoginUrl(MixerBoxSharedPreferences.getUUID(final_context), MixerBoxSharedPreferences.getFacebookToken(final_context)), null, new _cls2(flag));
    }

    public static void reloadMySubsPlaylist(final Context final_context, final boolean hasToShowMyPlaylist, boolean flag)
    {
        MixerBoxClient.get(MixerBoxClient.getAuthLoginUrl(MixerBoxSharedPreferences.getUUID(final_context), MixerBoxSharedPreferences.getFacebookToken(final_context)), null, new _cls3(flag));
    }

    public static void removePlaylist(final Context final_context, String s)
    {
        MixerBoxClient.get(MixerBoxClient.removePlaylistUrl(s), null, new _cls16(s));
    }

    public static void removeSong(final Context final_context, final String pid, SongItem songitem, int i)
    {
        MixerBoxClient.get(MixerBoxClient.removeSongUrl(pid, songitem, i), null, new _cls15(songitem));
    }

    public static void renamePlaylist(final Context final_context, final String pid, String s)
    {
        MixerBoxClient.get(MixerBoxClient.renamePlaylistUrl(pid, s), null, new _cls17(s));
    }

    public static void saveAuthLoginInfo(Context context)
    {
        String s8 = MixerBoxSharedPreferences.getAuthLoginResponse(context);
        Object obj = (new JSONObject(s8)).getJSONObject("authLoginV2").getJSONObject("data");
        String s;
        String s1;
        String s2;
        String s3;
        String s4;
        String s5;
        String s6;
        String s7;
        s = "";
        s1 = "";
        s2 = "";
        s7 = "";
        s6 = s7;
        s3 = s2;
        s4 = s1;
        s5 = s;
        if (!((JSONObject) (obj)).has("user"))
        {
            break MISSING_BLOCK_LABEL_279;
        }
        s6 = s7;
        s3 = s2;
        s4 = s1;
        s5 = s;
        JSONObject jsonobject;
        if (((JSONObject) (obj)).isNull("user"))
        {
            break MISSING_BLOCK_LABEL_279;
        }
        jsonobject = ((JSONObject) (obj)).getJSONObject("user");
        obj = s;
        if (!jsonobject.has("_id"))
        {
            break MISSING_BLOCK_LABEL_134;
        }
        obj = s;
        if (!jsonobject.isNull("_id"))
        {
            obj = jsonobject.getString("_id");
        }
        s = s1;
        if (!jsonobject.has("locale"))
        {
            break MISSING_BLOCK_LABEL_169;
        }
        s = s1;
        if (!jsonobject.isNull("locale"))
        {
            s = jsonobject.getString("locale");
        }
        s1 = s2;
        if (!jsonobject.has("name"))
        {
            break MISSING_BLOCK_LABEL_206;
        }
        s1 = s2;
        if (!jsonobject.isNull("name"))
        {
            s1 = jsonobject.getString("name");
        }
        s6 = s7;
        s3 = s1;
        s4 = s;
        s5 = ((String) (obj));
        if (!jsonobject.has("fb"))
        {
            break MISSING_BLOCK_LABEL_279;
        }
        s6 = s7;
        s3 = s1;
        s4 = s;
        s5 = ((String) (obj));
        if (jsonobject.isNull("fb"))
        {
            break MISSING_BLOCK_LABEL_279;
        }
        s6 = jsonobject.getJSONObject("fb").getString("id");
        s5 = ((String) (obj));
        s4 = s;
        s3 = s1;
        MixerBoxSharedPreferences.putAuthLoginInfo(context, s5, s3, s4, s6);
        ((MainPage)context).mySubscriptions = new ArrayList();
        ((MainPage)context).arrayMySubsPlaylists = new ArrayList();
        ((MainPage)context).myPlaylists = new ArrayList();
        ((MainPage)context).arrayMyPlaylists = new ArrayList();
        if (!MixerBoxSharedPreferences.getHasAddFromDB(context))
        {
            parseDBMyPlaylists(context);
            parseDBMySubs(context);
            MixerBoxSharedPreferences.putHasAddFromDB(context);
            return;
        }
        try
        {
            parseMyPlaylist(context, s8, false);
            parseMySubsPlaylist(context, s8, false, true);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
        return;
    }

    public static void sendCohortListening(Context context, String s, String s1, String s2)
    {
        MixerBoxClient.get(MixerBoxClient.getCohortListeningUrl(MixerBoxSharedPreferences.getUUID(context), s, s1, s2), null, new _cls24());
    }

    public static void sendCohortRegister(Context context, String s)
    {
        String s3 = (new StringBuilder()).append(Locale.getDefault().getLanguage()).append("-").append(Locale.getDefault().getCountry().toLowerCase(Locale.getDefault())).toString();
        MixerBoxSharedPreferences.putLocale(context, s3);
        String s2 = MixerBoxSharedPreferences.getUUID(context);
        String s1 = s2;
        if (s2.equals(""))
        {
            s1 = ((TelephonyManager)context.getSystemService("phone")).getDeviceId();
            PackageInfo packageinfo;
            if (s1 != null)
            {
                s1 = s1.replaceAll(" ", "");
                MixerBoxSharedPreferences.putUUID(context, s1);
            } else
            {
                s1 = UUID.randomUUID().toString();
                Calendar calendar = Calendar.getInstance();
                s1 = (new StringBuilder()).append(s1).append(String.valueOf(calendar.getTimeInMillis())).toString().replaceAll(" ", "");
                MixerBoxSharedPreferences.putUUID(context, s1);
            }
        }
        try
        {
            packageinfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            MixerBoxClient.get(MixerBoxClient.getCohortRegisterUrl(context, s1, s3, s, (new StringBuilder()).append(packageinfo.versionCode).append("").toString()), null, new _cls23());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }

    public static void setSearch(final Context final_context, String s, final VectorFragment f)
    {
        MixerBoxClient.get(MixerBoxClient.getSearchUrl("", s, 0), null, new _cls9(final_context));
    }

    public static void setSearchCategory(final Context final_context, String s, final VectorFragment f, String s1)
    {
        MixerBoxClient.get(MixerBoxClient.getSearchUrl(s1, s, 0), null, new _cls10(final_context));
    }

    public static void subsPlaylist(final Context final_context, final String pid, final boolean shouldToast)
    {
        MixerBoxClient.get(MixerBoxClient.subsPlaylistUrl(pid), null, new _cls20(final_context));
    }

    public static void toastMsg(Context context, String s, int i)
    {
        if (toast != null)
        {
            toast.cancel();
        }
        context = Toast.makeText(context, s, i);
        toast = context;
        context.setGravity(16, 0, 0);
        toast.show();
    }

    public static void unsubsPlaylist(final Context final_context, final String pid)
    {
        MixerBoxClient.get(MixerBoxClient.unsubsPlaylistUrl(pid), null, new _cls21(final_context));
    }




    private class _cls14 extends MixerBoxAsyncHttpResponseHandler
    {

        final Context val$ctx;
        final String val$pid;
        final String val$pname;
        final boolean val$shouldToast;
        final SongItem val$song;

        public final void onFailure(Throwable throwable, String s)
        {
            super.onFailure(throwable, s);
            if (shouldToast)
            {
                MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f080049), 1);
            }
        }

        public final void onSuccess(String s)
        {
            super.onSuccess(s);
            if (pname.length() > 0)
            {
                MixerBoxSharedPreferences.putDefaultAddedPlaylist(ctx, pid, pname);
            }
            if (shouldToast)
            {
                MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f080077), 1);
                s = new HashMap();
                s.put("f", song.getSongYtId());
                s.put("playlist", pid);
                s.put("t", "yt");
                FlurryAgent.logEvent("action:music_add", s);
                MixerBoxUtils.reloadMyPlaylist(ctx, false);
            }
        }

        _cls14(SongItem songitem)
        {
            pname = s;
            ctx = context1;
            pid = s1;
            shouldToast = flag;
            song = songitem;
            super(final_context);
        }
    }


    private class _cls19 extends MixerBoxAsyncHttpResponseHandler
    {

        final Context val$ctx;
        final String val$name;
        final SongItem val$song;

        public final void onSuccess(String s)
        {
            super.onSuccess(s);
            FlurryAgent.logEvent("action:playlist_create");
            String s1 = "";
            try
            {
                s = (new JSONObject(s)).getString("mChangePlaylist");
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                s = s1;
            }
            MixerBoxUtils.addSong(ctx, s, song, true, name);
        }

        _cls19(String s)
        {
            ctx = context1;
            song = songitem;
            name = s;
            super(final_context);
        }
    }


    private class _cls18 extends MixerBoxAsyncHttpResponseHandler
    {

        final Context val$ctx;
        final String val$name;

        public final void onFailure(Throwable throwable, String s)
        {
            super.onFailure(throwable, s);
            MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f080049), 1);
        }

        public final void onSuccess(String s)
        {
            super.onSuccess(s);
            MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f080081), 1);
            FlurryAgent.logEvent("action:playlist_create");
            Object obj = "";
            SongFragment songfragment;
            try
            {
                s = (new JSONObject(s)).getString("mChangePlaylist");
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                s = ((String) (obj));
            }
            ((MainPage)ctx).arraySong.clear();
            obj = new PlaylistItem(s, name, "", "", "0", "0", "", 1, false);
            ((MainPage)ctx).arrayMyPlaylists.add(obj);
            ((MainPage)ctx).myPlaylists.add(s);
            songfragment = ((MainPage)ctx).setSong(s);
            songfragment.currentPlaylist = ((PlaylistItem) (obj));
            MixerBoxUtils.loadSong(ctx, s, false, 1, -1, songfragment);
            MixerBoxUtils.reloadMyPlaylist(ctx, false);
            if (((MainPage)ctx).fragmentPlaylists.lv != null)
            {
                ((MainPage)ctx).fragmentPlaylists.lv.onRefreshComplete();
            }
        }

        _cls18(String s)
        {
            ctx = context1;
            name = s;
            super(final_context);
        }
    }


    private class _cls25
        implements android.widget.PopupMenu.OnMenuItemClickListener
    {

        final Context val$ctx;
        final String val$currentPlaylistId;
        final SongItem val$currentSong;
        final int val$k;

        public final boolean onMenuItemClick(MenuItem menuitem)
        {
            MixerBoxUtils.performSongAction(ctx, menuitem.getItemId(), currentSong, currentPlaylistId, k);
            return true;
        }

        _cls25()
        {
            ctx = context;
            currentSong = songitem;
            currentPlaylistId = s;
            k = i;
            super();
        }
    }


    private class _cls22 extends MixerBoxAsyncHttpResponseHandler
    {

        final Context val$ctx;

        public final void onSuccess(String s)
        {
            super.onSuccess(s);
            break MISSING_BLOCK_LABEL_5;
_L2:
            do
            {
                return;
            } while (((MainPage)ctx).arrayLocalNotificationList.size() >= 9 || s == null);
            s = (new JSONObject(s)).getJSONObject("getVector");
            if (s.isNull("isArtist") || !s.getBoolean("isArtist")) goto _L2; else goto _L1
_L1:
            JSONArray jsonarray = s.getJSONArray("items");
            int i = 0;
_L5:
            if (i >= jsonarray.length()) goto _L2; else goto _L3
_L3:
            String s1;
            String s2;
            String s3;
            String s4;
            String s5;
            JSONObject jsonobject;
            if (!jsonarray.getJSONObject(i).getString("type").equals("playlist") || !jsonarray.getJSONObject(i).getBoolean("isAlbum"))
            {
                break; /* Loop/switch isn't completed */
            }
            jsonobject = jsonarray.getJSONObject(i);
            s1 = jsonobject.getString("ref");
            s2 = jsonobject.getString("owner");
            s3 = jsonobject.getString("title");
            s4 = jsonobject.getString("thumbnailHQ");
            s5 = jsonobject.getString("size");
            s = "";
            boolean flag;
            try
            {
                if (!jsonobject.isNull("ownerId"))
                {
                    s = jsonobject.getString("ownerId");
                }
                flag = ((MainPage)ctx).addLocalNotificationList(s1, s3, s2, s4, s5, s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return;
            }
            if (flag) goto _L2; else goto _L4
_L4:
            i++;
              goto _L5
        }

        _cls22(Context context1)
        {
            ctx = context1;
            super(final_context);
        }
    }


    private class _cls1 extends MixerBoxAsyncHttpResponseHandler
    {

        final Context val$ctx;
        final Session val$session;

        public final void onFailure(Throwable throwable, String s)
        {
            super.onFailure(throwable, s);
            if (!MixerBoxClient.isConnectingToInternet(ctx))
            {
                throwable = new Intent();
                s = new Bundle();
                s.putBoolean("isLogIn", true);
                throwable.putExtras(s);
                throwable.setClass(ctx, com/mixerbox/mixerbox3b/LoginBridge);
                ctx.startActivity(throwable);
                ((Activity)ctx).finish();
                return;
            }
            if (MixerBoxUtils.retryCount > 0)
            {
                MixerBoxUtils.retryCount = 0;
                MixerBoxUtils.toastMsg(ctx, (new StringBuilder()).append(ctx.getResources().getString(0x7f08005e)).append(" ").append(ctx.getResources().getString(0x7f080049)).toString(), 1);
                return;
            } else
            {
                MixerBoxUtils.retryCount++;
                MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f08004a), 1);
                MixerBoxUtils.getAuthLoginInfo(ctx, session);
                return;
            }
        }

        public final void onSuccess(String s)
        {
            super.onSuccess(s);
            FlurryAgent.logEvent("action:logged_in");
            MixerBoxSharedPreferences.putAuthLoginResponse(ctx, s);
            MixerBoxUtils.finishFetchInitData(ctx);
        }

        _cls1(Session session1)
        {
            ctx = context1;
            session = session1;
            super(final_context);
        }
    }


    private class _cls7 extends MixerBoxAsyncHttpResponseHandler
    {

        final Context val$ctx;

        public final void onFailure(Throwable throwable, String s)
        {
            super.onFailure(throwable, s);
            ((MainPage)ctx).fragmentDJs.lv.onRefreshComplete();
        }

        public final void onSuccess(String s)
        {
            super.onSuccess(s);
            if (s == null)
            {
                ((MainPage)ctx).arrayDJs = new ArrayList();
                ((MainPage)ctx).fragmentDJs.loadContent();
                ((MainPage)ctx).fragmentDJs.lv.onRefreshComplete();
                return;
            }
            s = (new JSONObject(s)).getJSONObject("getMyFollowing").getJSONArray("items");
            ((MainPage)ctx).arrayDJs = new ArrayList();
            int i = 0;
_L2:
            if (i < s.length())
            {
                if (!s.isNull(i))
                {
                    JSONObject jsonobject = s.getJSONObject(i);
                    MixerBoxUtils.addMyItemToArray(((MainPage)ctx).arrayDJs, jsonobject, ctx, i, s.length() - i - 1);
                }
                break MISSING_BLOCK_LABEL_182;
            } else
            {
                try
                {
                    ((MainPage)ctx).fragmentDJs.loadContent();
                    ((MainPage)ctx).fragmentDJs.lv.onRefreshComplete();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    s.printStackTrace();
                }
                return;
            }
            i++;
            if (true) goto _L2; else goto _L1
_L1:
        }

        _cls7(Context context1)
        {
            ctx = context1;
            super(final_context);
        }
    }


    private class _cls12 extends MixerBoxAsyncHttpResponseHandler
    {

        final Context val$ctx;
        final VectorFragment val$f;

        public final void onSuccess(String s)
        {
            super.onSuccess(s);
            f.array = new ArrayList();
            s = (new JSONObject(s)).getJSONObject("followInfoV2").getJSONArray("items");
            int i = 0;
_L2:
            if (i >= s.length())
            {
                break; /* Loop/switch isn't completed */
            }
            JSONObject jsonobject = s.getJSONObject(i);
            MixerBoxUtils.addMyItemToArray(f.array, jsonobject, ctx, i, s.length() - i - 1);
            i++;
            if (true) goto _L2; else goto _L1
            s;
            s.printStackTrace();
_L1:
            f.setContent();
            return;
        }

        _cls12(Context context1)
        {
            f = vectorfragment;
            ctx = context1;
            super(final_context);
        }
    }


    private class _cls11 extends MixerBoxAsyncHttpResponseHandler
    {

        final Context val$ctx;
        final VectorFragment val$f;

        public final void onSuccess(String s)
        {
            super.onSuccess(s);
            f.array = new ArrayList();
            if (s == null) goto _L2; else goto _L1
_L1:
            s = (new JSONObject(s)).getJSONObject("subsInfoV2").getJSONArray("items");
            int i = 0;
_L4:
            if (i >= s.length())
            {
                break; /* Loop/switch isn't completed */
            }
            JSONObject jsonobject = s.getJSONObject(i);
            MixerBoxUtils.addMyItemToArray(f.array, jsonobject, ctx, i, s.length() - i - 1);
            i++;
            if (true) goto _L4; else goto _L3
            s;
            s.printStackTrace();
_L3:
            f.setContent();
            return;
_L2:
            MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f080048), 1);
            if (true) goto _L3; else goto _L5
_L5:
        }

        _cls11(Context context1)
        {
            f = vectorfragment;
            ctx = context1;
            super(final_context);
        }
    }


    private class _cls8 extends MixerBoxAsyncHttpResponseHandler
    {

        final Context val$ctx;
        final VectorFragment val$f;
        final String val$title;
        final String val$type;

        public final void onSuccess(String s)
        {
            int i;
            i = 0;
            super.onSuccess(s);
            f.array = new ArrayList();
            if (s == null) goto _L2; else goto _L1
_L1:
            JSONArray jsonarray;
            JSONObject jsonobject;
            s = (new JSONObject(s)).getJSONObject("getVector");
            jsonarray = s.getJSONArray("items");
            if (!jsonarray.getJSONObject(0).isNull("type") && !jsonarray.getJSONObject(0).getString("type").equals("divider") && !type.equals("dj"))
            {
                f.array.add(new DividerVectorItem(new JSONObject((new StringBuilder()).append("{\"type\":\"divider\",\"title\":\"").append(title).append("\"}").toString()), ctx));
            }
            jsonobject = new JSONObject();
            jsonobject.put("type", "dj_info");
            int k = 0;
_L13:
            if (k >= jsonarray.length()) goto _L4; else goto _L3
_L3:
            JSONObject jsonobject1 = jsonarray.getJSONObject(k);
            int j = i;
            if (!type.equals("dj")) goto _L6; else goto _L5
_L5:
            j = i;
            if (k > 2) goto _L6; else goto _L7
_L7:
            if (k >= 2) goto _L9; else goto _L8
_L8:
            jsonobject.put((new StringBuilder()).append("").append(k).toString(), jsonobject1);
              goto _L10
_L9:
            MixerBoxUtils.addMyItemToArray(f.array, jsonobject, ctx, k, jsonarray.length() - 1);
            j = 1;
_L6:
            MixerBoxUtils.addMyItemToArray(f.array, jsonobject1, ctx, k, jsonarray.length() - k - 1 - j);
            i = j;
              goto _L10
_L11:
            f.setContent();
            f.canScroll = true;
            return;
_L4:
            if (s == null)
            {
                continue; /* Loop/switch isn't completed */
            }
            try
            {
                if (!s.isNull("isArtist"))
                {
                    s.getBoolean("isArtist");
                }
                continue; /* Loop/switch isn't completed */
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
            if (true) goto _L11; else goto _L2
_L2:
            MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f080048), 1);
            if (true) goto _L11; else goto _L10
_L10:
            k++;
            if (true) goto _L13; else goto _L12
_L12:
        }

        _cls8(Context context1)
        {
            f = vectorfragment;
            type = s;
            title = s1;
            ctx = context1;
            super(final_context);
        }
    }


    private class _cls13 extends MixerBoxAsyncHttpResponseHandler
    {

        final Context val$ctx;
        final SongFragment val$f;
        final boolean val$hasToGoBack;
        final int val$playIndex;
        final int val$type;

        public final void onSuccess(String s)
        {
            super.onSuccess(s);
            (new LoadSongTask(ctx, hasToGoBack, type, playIndex, f)).execute(new String[] {
                s
            });
        }

        _cls13(SongFragment songfragment)
        {
            ctx = context1;
            hasToGoBack = flag;
            type = i;
            playIndex = j;
            f = songfragment;
            super(final_context);
        }

        private class LoadSongTask extends AsyncTask
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

                    final LoadSongTask this$0;

                    public void run()
                    {
                        frag.loadContent();
                    }

                    _cls1()
                    {
                        this$0 = LoadSongTask.this;
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

                        final LoadSongTask this$0;

                        public void run()
                        {
                            ((MainPage)ctx).playMusic(true);
                        }

                    _cls3()
                    {
                        this$0 = LoadSongTask.this;
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

                    final LoadSongTask this$0;

                    public void run()
                    {
                        frag.loadContent();
                    }

                    _cls2()
                    {
                        this$0 = LoadSongTask.this;
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

            public LoadSongTask(Context context, boolean flag, int i, int j, SongFragment songfragment)
            {
                ctx = context;
                hasToGoBack = flag;
                type = i;
                playIndex = j;
                shouldCancel = false;
                frag = songfragment;
            }
        }

    }


    private class ClickableString extends ClickableSpan
    {

        private VectorOnClickListener mListener;

        public void onClick(View view)
        {
            mListener.onClick(view);
        }

        public ClickableString(VectorOnClickListener vectoronclicklistener)
        {
            mListener = vectoronclicklistener;
        }
    }


    private class NoUnderlineSpan extends UnderlineSpan
    {

        public void updateDrawState(TextPaint textpaint)
        {
            textpaint.setUnderlineText(false);
        }

        public NoUnderlineSpan()
        {
        }
    }


    private class _cls6 extends MixerBoxAsyncHttpResponseHandler
    {

        final Context val$ctx;
        final String val$dbPid;
        final int val$i1;

        public final void onSuccess(String s)
        {
            super.onSuccess(s);
            final String p;
            Cursor cursor;
            final int i2;
            int i;
            try
            {
                p = (new JSONObject(s)).getString("mChangePlaylist");
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                p = "";
            }
            s = "";
            cursor = ((MainPage)ctx).DB.getSong(dbPid);
            i = cursor.getCount();
            cursor.moveToFirst();
            i2 = 0;
            while (i2 < i) 
            {
                if (cursor.getInt(6) == 3)
                {
                    SongItem songitem = new SongItem("", cursor.getString(2), cursor.getString(3), cursor.getString(4), i2, 3, cursor.getString(7));
                    MixerBoxUtils.addSong(ctx, p, songitem, false, "");
                } else
                {
                    s = (new StringBuilder()).append(s).append("&list%5B").append(i2).append("%5D=").append(cursor.getString(4)).toString();
                }
                cursor.moveToNext();
                i2++;
            }
            cursor.close();
            i2 = Integer.valueOf(i1).intValue();
            class _cls1 extends AsyncHttpResponseHandler
            {

                final _cls6 this$0;
                final int val$i2;
                final String val$p;

                public void onFailure(Throwable throwable, String s1)
                {
                    MixerBoxUtils.logMsg((new StringBuilder()).append("FAILURE ").append(throwable.toString()).append(" / ").append(s1).toString());
                    ((MainPage)ctx).myPlaylists.add(p);
                    if (i2 <= 2)
                    {
                        MixerBoxUtils.reloadMyPlaylist(ctx, false);
                    }
                }

                public void onSuccess(String s1)
                {
                    ((MainPage)ctx).myPlaylists.add(p);
                    if (i2 <= 2)
                    {
                        MixerBoxUtils.reloadMyPlaylist(ctx, false);
                    }
                }

                _cls1()
                {
                    this$0 = _cls6.this;
                    p = s;
                    i2 = i;
                    super();
                }
            }

            MixerBoxClient.get(MixerBoxClient.getBatchAddUrl(p, s), null, new _cls1());
        }

        _cls6(int i)
        {
            ctx = context1;
            dbPid = s;
            i1 = i;
            super(final_context);
        }
    }


    private class _cls5 extends MixerBoxAsyncHttpResponseHandler
    {

        final Context val$ctx;
        final int val$i1;
        final String val$pid;

        public final void onFailure(Throwable throwable, String s)
        {
            super.onFailure(throwable, s);
            if (i1 <= 1)
            {
                MixerBoxUtils.reloadMySubsPlaylist(ctx, false, true);
            }
        }

        public final void onSuccess(String s)
        {
            super.onSuccess(s);
            s = new HashMap();
            s.put("id", pid);
            s.put("sub", "1");
            FlurryAgent.logEvent("action:subscribe", s);
            if (i1 <= 1)
            {
                MixerBoxUtils.reloadMySubsPlaylist(ctx, false, true);
            }
        }

        _cls5(Context context1)
        {
            pid = s;
            i1 = i;
            ctx = context1;
            super(final_context);
        }
    }


    private class _cls4
        implements Runnable
    {

        final Context val$ctx;

        public final void run()
        {
            ((MainPage)ctx).setLocalNotificationList();
        }

        _cls4()
        {
            ctx = context;
            super();
        }
    }


    private class _cls2 extends MixerBoxAsyncHttpResponseHandler
    {

        final Context val$ctx;
        final boolean val$hasToShowMyPlaylist;

        public final void onSuccess(String s)
        {
            super.onSuccess(s);
            try
            {
                MixerBoxUtils.parseMyPlaylist(ctx, s, hasToShowMyPlaylist);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
        }

        _cls2(boolean flag)
        {
            ctx = context1;
            hasToShowMyPlaylist = flag;
            super(final_context);
        }
    }


    private class _cls3 extends MixerBoxAsyncHttpResponseHandler
    {

        final Context val$ctx;
        final boolean val$hasToClear;
        final boolean val$hasToShowMyPlaylist;

        public final void onSuccess(String s)
        {
            super.onSuccess(s);
            try
            {
                MixerBoxUtils.parseMySubsPlaylist(ctx, s, hasToShowMyPlaylist, hasToClear);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
        }

        _cls3(boolean flag1)
        {
            ctx = context1;
            hasToShowMyPlaylist = flag;
            hasToClear = flag1;
            super(final_context);
        }
    }


    private class _cls16 extends MixerBoxAsyncHttpResponseHandler
    {

        final Context val$ctx;
        final String val$pid;

        public final void onFailure(Throwable throwable, String s)
        {
            super.onFailure(throwable, s);
            MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f080049), 1);
        }

        public final void onSuccess(String s)
        {
            super.onSuccess(s);
            MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f080082), 1);
            s = new HashMap();
            s.put("id", pid);
            FlurryAgent.logEvent("action:playlist_delete", s);
            MixerBoxUtils.reloadMyPlaylist(ctx, true);
        }

        _cls16(String s)
        {
            ctx = context1;
            pid = s;
            super(final_context);
        }
    }


    private class _cls15 extends MixerBoxAsyncHttpResponseHandler
    {

        final Context val$ctx;
        final String val$pid;
        final SongItem val$song;

        public final void onFailure(Throwable throwable, String s)
        {
            super.onFailure(throwable, s);
            MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f080049), 1);
        }

        public final void onSuccess(String s)
        {
            boolean flag1;
            flag1 = true;
            super.onSuccess(s);
            if (s == null) goto _L2; else goto _L1
_L1:
            s = new JSONObject(s);
            boolean flag = flag1;
            if (s.isNull("mChangePlaylist"))
            {
                break MISSING_BLOCK_LABEL_62;
            }
            flag = flag1;
            if (!s.getJSONObject("mChangePlaylist").isNull("status"))
            {
                flag = s.getJSONObject("mChangePlaylist").getBoolean("status");
            }
            if (!flag) goto _L4; else goto _L3
_L3:
            int i;
            if (!((Fragment)((MainPage)ctx).stack.lastElement()).getClass().getSimpleName().equals("SongFragment") || !((SongFragment)((MainPage)ctx).stack.lastElement()).currentPlaylist.getPlaylistId().equals(pid))
            {
                break MISSING_BLOCK_LABEL_212;
            }
            i = ((SongFragment)((MainPage)ctx).stack.lastElement()).adapter.array.indexOf(song);
            if (i == -1)
            {
                break MISSING_BLOCK_LABEL_212;
            }
            ((SongFragment)((MainPage)ctx).stack.lastElement()).adapter.array.remove(i);
            ((SongFragment)((MainPage)ctx).stack.lastElement()).adapter.notifyDataSetChanged();
            MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f080078), 1);
            s = new HashMap();
            s.put("f", song.getSongYtId());
            s.put("id", song.getSongId());
            s.put("playlist", pid);
            s.put("t", "yt");
            FlurryAgent.logEvent("action:music_del", s);
_L2:
            MixerBoxUtils.reloadMyPlaylist(ctx, false);
            return;
_L4:
            try
            {
                MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f080049), 1);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
            if (true) goto _L2; else goto _L5
_L5:
        }

        _cls15(SongItem songitem)
        {
            ctx = context1;
            pid = s;
            song = songitem;
            super(final_context);
        }
    }


    private class _cls17 extends MixerBoxAsyncHttpResponseHandler
    {

        final Context val$ctx;
        final String val$n;
        final String val$pid;

        public final void onFailure(Throwable throwable, String s)
        {
            super.onFailure(throwable, s);
            MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f080049), 1);
        }

        public final void onSuccess(String s)
        {
            super.onSuccess(s);
            MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f080084), 1);
            s = new HashMap();
            s.put("id", pid);
            FlurryAgent.logEvent("action:playlist_change_title", s);
            if (((Fragment)((MainPage)ctx).stack.lastElement()).getClass().getSimpleName().equals("SongFragment"))
            {
                ((SongFragment)((MainPage)ctx).stack.lastElement()).currentPlaylist.getPlaylistId().equals(pid);
                ((SongFragment)((MainPage)ctx).stack.lastElement()).currentPlaylist.renamePlaylist(n);
            }
            MixerBoxUtils.reloadMyPlaylist(ctx, false);
        }

        _cls17(String s1)
        {
            ctx = context1;
            pid = s;
            n = s1;
            super(final_context);
        }
    }


    private class _cls24 extends AsyncHttpResponseHandler
    {

        public final void onFailure(Throwable throwable, String s)
        {
            MixerBoxUtils.logMsg((new StringBuilder()).append("Cohort: ").append(throwable.toString()).append(" / ").append(s).toString());
        }

        public final void onSuccess(String s)
        {
            MixerBoxUtils.logMsg((new StringBuilder()).append("Cohort +  / ").append(s).toString());
        }

        _cls24()
        {
        }
    }


    private class _cls23 extends AsyncHttpResponseHandler
    {

        public final void onFailure(Throwable throwable, String s)
        {
            MixerBoxUtils.logMsg((new StringBuilder()).append("Cohort + ").append(throwable.toString()).append(" / ").append(s).toString());
        }

        public final void onSuccess(String s)
        {
            MixerBoxUtils.logMsg((new StringBuilder()).append("Cohort +  / ").append(s).toString());
        }

        _cls23()
        {
        }
    }


    private class _cls9 extends MixerBoxAsyncHttpResponseHandler
    {

        final Context val$ctx;
        final VectorFragment val$f;

        public final void onSuccess(String s)
        {
            super.onSuccess(s);
            f.array = new ArrayList();
            if (s == null) goto _L2; else goto _L1
_L1:
            boolean flag;
            JSONObject jsonobject;
            int i;
            try
            {
                s = (new JSONObject(s)).getJSONObject("searchVideo").getJSONArray("items");
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                flag = false;
                continue; /* Loop/switch isn't completed */
            }
            i = 0;
            if (i >= s.length())
            {
                break; /* Loop/switch isn't completed */
            }
            jsonobject = s.getJSONObject(i);
            MixerBoxUtils.addMyItemToArray(f.array, jsonobject, ctx, i, s.length() - i - 1);
            i++;
            if (true) goto _L4; else goto _L3
_L4:
            break MISSING_BLOCK_LABEL_44;
_L3:
            if (s.length() < 2 || s.getJSONObject(1).isNull("isArtist")) goto _L6; else goto _L5
_L5:
            flag = s.getJSONObject(1).getBoolean("isArtist");
            if (!flag) goto _L6; else goto _L7
_L7:
            flag = true;
_L9:
            f.setContent();
            if (!MixerBoxSharedPreferences.getTipFirstSearch(ctx))
            {
                ((MainPage)ctx).setOnboardingGuide(10, new boolean[] {
                    flag
                });
            }
            return;
_L2:
            MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f080048), 1);
            flag = false;
            continue; /* Loop/switch isn't completed */
_L6:
            flag = false;
            if (true) goto _L9; else goto _L8
_L8:
        }

        _cls9(Context context1)
        {
            f = vectorfragment;
            ctx = context1;
            super(final_context);
        }
    }


    private class _cls10 extends MixerBoxAsyncHttpResponseHandler
    {

        final Context val$ctx;
        final VectorFragment val$f;

        public final void onSuccess(String s)
        {
            super.onSuccess(s);
            f.array = new ArrayList();
            if (s == null) goto _L2; else goto _L1
_L1:
            s = (new JSONObject(s)).getJSONObject("searchVideo").getJSONArray("items");
            int i = 0;
_L4:
            if (i >= s.length())
            {
                break; /* Loop/switch isn't completed */
            }
            JSONObject jsonobject = s.getJSONObject(i);
            MixerBoxUtils.addMyItemToArray(f.array, jsonobject, ctx, i, s.length() - i - 1);
            i++;
            if (true) goto _L4; else goto _L3
            s;
            s.printStackTrace();
_L3:
            f.setContent();
            f.canScroll = true;
            return;
_L2:
            MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f080048), 1);
            if (true) goto _L3; else goto _L5
_L5:
        }

        _cls10(Context context1)
        {
            f = vectorfragment;
            ctx = context1;
            super(final_context);
        }
    }


    private class _cls20 extends MixerBoxAsyncHttpResponseHandler
    {

        final Context val$ctx;
        final String val$pid;
        final boolean val$shouldToast;

        public final void onFailure(Throwable throwable, String s)
        {
            super.onFailure(throwable, s);
            MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f080049), 1);
        }

        public final void onSuccess(String s)
        {
            super.onSuccess(s);
            s = new HashMap();
            s.put("id", pid);
            s.put("sub", "1");
            FlurryAgent.logEvent("action:subscribe", s);
            if (shouldToast)
            {
                MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f0800e9), 1);
                MixerBoxUtils.reloadMySubsPlaylist(ctx, false, true);
                if (!MixerBoxSharedPreferences.getTipFirstSubscribe(ctx))
                {
                    ((MainPage)ctx).setOnboardingGuide(7, new boolean[0]);
                }
            }
        }

        _cls20(Context context1)
        {
            pid = s;
            shouldToast = flag;
            ctx = context1;
            super(final_context);
        }
    }


    private class _cls21 extends MixerBoxAsyncHttpResponseHandler
    {

        final Context val$ctx;
        final String val$pid;

        public final void onFailure(Throwable throwable, String s)
        {
            super.onFailure(throwable, s);
            MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f080049), 1);
        }

        public final void onSuccess(String s)
        {
            super.onSuccess(s);
            s = new HashMap();
            s.put("id", pid);
            s.put("sub", "0");
            FlurryAgent.logEvent("action:subscribe", s);
            MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f0800e9), 1);
            int i = 0;
            do
            {
label0:
                {
                    if (i < ((MainPage)ctx).arrayMySubsPlaylists.size())
                    {
                        if (!((PlaylistItem)((MainPage)ctx).arrayMySubsPlaylists.get(i)).getPlaylistId().equals(pid))
                        {
                            break label0;
                        }
                        ((MainPage)ctx).arrayMySubsPlaylists.remove(i);
                        ((MainPage)ctx).mySubscriptions.remove(pid);
                        ((MainPage)ctx).fragmentPlaylists.loadContent();
                    }
                    return;
                }
                i++;
            } while (true);
        }

        _cls21(Context context1)
        {
            pid = s;
            ctx = context1;
            super(final_context);
        }
    }

}
