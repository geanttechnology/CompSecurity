// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.classes;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.flurry.android.FlurryAgent;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.dialogs.AddToPlaylistDialog;
import com.mixerbox.mixerbox3b.dialogs.AlertDialogFactory;
import com.mixerbox.mixerbox3b.dialogs.LoginDialog;
import com.mixerbox.mixerbox3b.fragments.PlaylistsFragment;
import com.mixerbox.mixerbox3b.fragments.SongFragment;
import com.mixerbox.mixerbox3b.utils.MixerBoxClient;
import com.mixerbox.mixerbox3b.utils.MixerBoxSQLite;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.mixerbox.mixerbox3b.classes:
//            PlaylistItem, SongItem, VectorOnClickListener

public class VectorOnClickHandle
{

    public VectorOnClickHandle()
    {
    }

    public static void onClick(final Context final_context, final JSONObject b, final JSONObject b, final JSONObject id, final View v)
    {
        final Object id;
        int i;
        boolean flag;
        id = null;
        flag = true;
        i = 1;
        if (MixerBoxClient.isConnectingToInternet(final_context)) goto _L2; else goto _L1
_L1:
        AlertDialogFactory.NoNetworkAlertDialog((Activity)final_context).show();
_L4:
        return;
_L2:
        if (id != null)
        {
            try
            {
                if (b.isNull("ref") && !id.isNull("ref"))
                {
                    b.put("ref", id.getString("ref"));
                }
                if (b.isNull("owner") && !id.isNull("owner"))
                {
                    b.put("owner", id.getString("owner"));
                }
                if (b.isNull("size") && !id.isNull("size"))
                {
                    b.put("size", id.getString("size"));
                }
                if (b.isNull("thumbnail") && !id.isNull("thumbnail"))
                {
                    b.put("thumbnail", id.getString("thumbnail"));
                }
                if (b.isNull("thumbnailHQ") && !id.isNull("thumbnailHQ"))
                {
                    b.put("thumbnailHQ", id.getString("thumbnailHQ"));
                }
                if (b.isNull("title") && !id.isNull("title"))
                {
                    b.put("title", id.getString("title"));
                }
                if (b.isNull("_id") && !id.isNull("_id"))
                {
                    b.put("_id", id.getString("_id"));
                }
                if (b.isNull("f") && !id.isNull("f"))
                {
                    b.put("f", id.getString("f"));
                }
                if (b.isNull("tm") && !id.isNull("tm"))
                {
                    b.put("tm", id.getString("tm"));
                }
                if (b.isNull("tt") && !id.isNull("tt"))
                {
                    b.put("tt", id.getString("tt"));
                }
                if (!b.isNull("title") && !id.isNull("title"))
                {
                    b.put("ptitle", id.getString("title"));
                }
            }
            catch (JSONException jsonexception)
            {
                jsonexception.printStackTrace();
            }
        }
        try
        {
            if (!b.isNull("type"))
            {
                id = b.getString("type");
            }
        }
        // Misplaced declaration of an exception variable
        catch (final Context final_context)
        {
            final_context.printStackTrace();
            return;
        }
        if (id == null) goto _L4; else goto _L3
_L3:
        MixerBoxUtils.logMsg("ON CLICK LISTENER");
        if (((String) (id)).equals("web"))
        {
            b = new HashMap();
            b.put("url", b.getString("ref"));
            FlurryAgent.logEvent("page:web", b);
            ((MainPage)final_context).setWeb(b.getString("ref"));
            return;
        }
        if (((String) (id)).equals("vector") || ((String) (id)).equals("more"))
        {
            b = ((MainPage)final_context).setVector(b.getString("ref"), "vector", 0, b.getString("title"));
            MixerBoxUtils.getVector(final_context, b.getString("ref"), b, "vector", b.getString("title"));
            return;
        }
        if (!((String) (id)).equals("dj"))
        {
            break MISSING_BLOCK_LABEL_667;
        }
        if (!b.isNull("pageTitle"))
        {
            break MISSING_BLOCK_LABEL_622;
        }
        b = ((MainPage)final_context).setVector(b.getString("ref"), "dj", 0, b.getString("title"));
        MixerBoxUtils.getVector(final_context, b.getString("ref"), b, "dj", b.getString("title"));
_L6:
        final_context = new HashMap();
        final_context.put("id", b.getString("ref"));
        FlurryAgent.logEvent("page:user", final_context);
        return;
        b = ((MainPage)final_context).setVector(b.getString("ref"), "dj", 0, b.getString("pageTitle"));
        MixerBoxUtils.getVector(final_context, b.getString("ref"), b, "dj", b.getString("pageTitle"));
        if (true) goto _L6; else goto _L5
_L5:
        if (!((String) (id)).equals("playlist")) goto _L8; else goto _L7
_L7:
        if (b.isNull("ref")) goto _L10; else goto _L9
_L9:
        id = "0";
        b = "";
        v = "";
        id = "";
        if (!b.isNull("size"))
        {
            id = b.getString("size");
        }
        if (!b.isNull("owner"))
        {
            b = b.getString("owner");
        }
        if (!b.isNull("ownerName"))
        {
            b = b.getString("ownerName");
        }
        if (!b.isNull("thumbnail"))
        {
            v = b.getString("thumbnail");
        }
        if (!b.isNull("ownerId"))
        {
            id = b.getString("ownerId");
        }
        if (b.isNull("isAlbum")) goto _L12; else goto _L11
_L11:
        Object obj = Boolean.valueOf(b.getBoolean("isAlbum"));
_L132:
        b = new PlaylistItem(b.getString("ref"), b.getString("title"), ((String) (id)), b, id, "0", v, 3, ((Boolean) (obj)).booleanValue());
_L15:
        ((MainPage)final_context).arraySong.clear();
        b = ((MainPage)final_context).setSong(b.getPlaylistId());
        b.currentPlaylist = b;
        MixerBoxUtils.loadSong(final_context, b.getPlaylistId(), false, 1, -1, b);
        return;
_L10:
        b = "0";
        id = "";
        v = "";
        id = "";
        if (!b.isNull("itemCount"))
        {
            b = b.getString("itemCount");
        }
        if (!b.isNull("ownerName"))
        {
            id = b.getString("ownerName");
        }
        if (!b.isNull("cover"))
        {
            v = b.getString("cover");
        }
        if (!b.isNull("owner"))
        {
            id = b.getString("owner");
        }
        if (b.isNull("isAlbum")) goto _L14; else goto _L13
_L13:
        obj = Boolean.valueOf(b.getBoolean("isAlbum"));
_L131:
        b = new PlaylistItem(b.getString("_id"), b.getString("name"), ((String) (id)), id, b, "0", v, 3, ((Boolean) (obj)).booleanValue());
          goto _L15
_L8:
        if (!((String) (id)).equals("music")) goto _L17; else goto _L16
_L16:
        b = "";
        id = "";
        v = "";
        id = "";
        obj = "";
        if (!b.isNull("f"))
        {
            b = b.getString("f");
        }
        if (b.isNull("tm")) goto _L19; else goto _L18
_L18:
        id = b.getString("tm");
_L25:
        if (b.isNull("tt")) goto _L21; else goto _L20
_L20:
        v = b.getString("tt");
_L27:
        if (!b.isNull("_id"))
        {
            id = b.getString("_id");
        }
        if (!b.isNull("thumbnail"))
        {
            obj = b.getString("thumbnail");
        }
        if (!b.isNull("source")) goto _L23; else goto _L22
_L22:
        b = b;
_L28:
        b = new SongItem(((String) (id)), v, id, b, 0, i, ((String) (obj)));
        b = new ArrayList();
        b.add(b);
        ((MainPage)final_context).arrayPlayingSong = b;
        ((MainPage)final_context).playingSong = b;
        ((MainPage)final_context).playingPlaylist = null;
        ((MainPage)final_context).playingSongIndex = 0;
        ((MainPage)final_context).playMusic(true);
        return;
_L19:
        if (b.isNull("duration")) goto _L25; else goto _L24
_L24:
        id = b.getString("duration");
          goto _L25
_L21:
        if (b.isNull("title")) goto _L27; else goto _L26
_L26:
        v = b.getString("title");
          goto _L27
_L23:
        if (!b.getString("source").equals("youtube"))
        {
            break MISSING_BLOCK_LABEL_1267;
        }
        b = b;
          goto _L28
        if (!b.getString("source").equals("soundcloud")) goto _L30; else goto _L29
_L29:
        b = b.getString("trackId");
        i = 3;
          goto _L28
_L17:
        if (((String) (id)).equals("followInfo"))
        {
            b = ((MainPage)final_context).setVector(b.getString("ref"), ((String) (id)), 0, "");
            MixerBoxUtils.getVector(final_context, b.getString("ref"), b, ((String) (id)), b.getString("title"));
            return;
        }
        if (!((String) (id)).equals("button")) goto _L4; else goto _L31
_L31:
        if (b.isNull("action"))
        {
            MixerBoxUtils.toastMsg(final_context, final_context.getResources().getString(0x7f080103), 0);
            return;
        }
        if (!b.getString("action").equals("follow") && !b.getString("action").equals("unfollow")) goto _L33; else goto _L32
_L32:
        if (!((MainPage)final_context).isLogIn)
        {
            (new LoginDialog((MainPage)final_context, 9)).show();
            return;
        }
        obj = new JSONObject(b.toString());
        if (!b.isNull("switch"))
        {
            obj = b.getJSONObject("switch");
        }
        if (((JSONObject) (obj)).isNull("title")) goto _L35; else goto _L34
_L34:
        id = ((JSONObject) (obj)).getString("title");
_L133:
        final String id = ((TextView)v).getText().toString();
        if (!id.equals(b.getString("title"))) goto _L37; else goto _L36
_L36:
        ((TextView)v).setText(((JSONObject) (obj)).getString("title"));
        id = b.getString("ref");
        if (!b.getString("action").equals("follow")) goto _L39; else goto _L38
_L38:
        b = "true";
        id = MixerBoxClient.followUrl(((String) (id)));
_L40:
        MixerBoxClient.get(id, null, new _cls1(b));
        return;
_L39:
        b = "false";
        id = MixerBoxClient.unfollowUrl(((String) (id)));
          goto _L40
_L37:
        if (!id.equals(((JSONObject) (obj)).getString("title")))
        {
            continue; /* Loop/switch isn't completed */
        }
        ((TextView)v).setText(b.getString("title"));
        id = ((JSONObject) (obj)).getString("ref");
        if (!((JSONObject) (obj)).getString("action").equals("follow")) goto _L42; else goto _L41
_L41:
        b = MixerBoxClient.followUrl(id);
        b = "true";
_L44:
        MixerBoxClient.get(b, null, new _cls2(((String) (id))));
        return;
_L42:
        b = MixerBoxClient.unfollowUrl(id);
        b = "false";
        if (true) goto _L44; else goto _L43
_L43:
        if (b == null) goto _L4; else goto _L45
_L45:
        ((TextView)v).setText("");
        if (b.isNull("object1")) goto _L47; else goto _L46
_L46:
        if (!b.equals(b.getJSONObject("object1"))) goto _L49; else goto _L48
_L48:
        id = b.getJSONObject("object1").getJSONObject("switch");
        b.remove("obj1IsSwitch");
        b.put("obj1IsSwitch", true);
        id = MixerBoxUtils.makeLinkSpan(b.getJSONObject("object1").getJSONObject("switch").getString("title"), new VectorOnClickListener(final_context, ((JSONObject) (id)), id, b), final_context);
        ((TextView)v).append(((CharSequence) (id)));
        MixerBoxUtils.makeLinksFocusable((TextView)v);
        id = b.getJSONObject("object1").getString("ref");
        if (!b.getJSONObject("object1").getString("action").equals("follow")) goto _L51; else goto _L50
_L50:
        id = MixerBoxClient.followUrl(id);
        obj = "true";
_L55:
        MixerBoxClient.get(((String) (id)), null, new _cls3(((String) (obj))));
_L60:
        ((TextView)v).append(" ");
_L47:
        if (!b.isNull("mainText"))
        {
            ((TextView)v).append(b.getString("mainText"));
        }
        if (b.isNull("object2")) goto _L4; else goto _L52
_L52:
        ((TextView)v).append(" ");
        if (!b.equals(b.getJSONObject("object2")))
        {
            break MISSING_BLOCK_LABEL_2473;
        }
        b = b.getJSONObject("object2").getJSONObject("switch");
        b.remove("obj2IsSwitch");
        b.put("obj2IsSwitch", true);
        b = MixerBoxUtils.makeLinkSpan(b.getJSONObject("object2").getJSONObject("switch").getString("title"), new VectorOnClickListener(final_context, b, id, b), final_context);
        ((TextView)v).append(b);
        MixerBoxUtils.makeLinksFocusable((TextView)v);
        id = b.getJSONObject("object2").getString("ref");
        if (!b.getJSONObject("object2").getString("action").equals("follow")) goto _L54; else goto _L53
_L53:
        b = MixerBoxClient.followUrl(id);
        b = "true";
_L63:
        MixerBoxClient.get(b, null, new _cls5(b));
        return;
_L51:
        id = MixerBoxClient.unfollowUrl(id);
        obj = "false";
          goto _L55
_L49:
        if (b.getJSONObject("object1").isNull("switch") || !b.equals(b.getJSONObject("object1").getJSONObject("switch"))) goto _L57; else goto _L56
_L56:
        id = b.getJSONObject("object1");
        b.remove("obj1IsSwitch");
        b.put("obj1IsSwitch", false);
        id = MixerBoxUtils.makeLinkSpan(b.getJSONObject("object1").getString("title"), new VectorOnClickListener(final_context, ((JSONObject) (id)), id, b), final_context);
        ((TextView)v).append(((CharSequence) (id)));
        MixerBoxUtils.makeLinksFocusable((TextView)v);
        id = b.getJSONObject("object1").getJSONObject("switch").getString("ref");
        if (!b.getJSONObject("object1").getJSONObject("switch").getString("action").equals("follow")) goto _L59; else goto _L58
_L58:
        id = MixerBoxClient.followUrl(id);
        obj = "true";
_L61:
        MixerBoxClient.get(((String) (id)), null, new _cls4(((String) (obj))));
          goto _L60
_L59:
        id = MixerBoxClient.unfollowUrl(id);
        obj = "false";
          goto _L61
_L57:
        if (b.isNull("obj1IsSwitch")) goto _L60; else goto _L62
_L62:
        if (!b.getBoolean("obj1IsSwitch"))
        {
            break MISSING_BLOCK_LABEL_2401;
        }
        id = b.getJSONObject("object1").getJSONObject("switch");
        id = MixerBoxUtils.makeLinkSpan(b.getJSONObject("object1").getJSONObject("switch").getString("title"), new VectorOnClickListener(final_context, ((JSONObject) (id)), id, b), final_context);
        ((TextView)v).append(((CharSequence) (id)));
        MixerBoxUtils.makeLinksFocusable((TextView)v);
          goto _L60
        id = b.getJSONObject("object1");
        id = MixerBoxUtils.makeLinkSpan(b.getJSONObject("object1").getString("title"), new VectorOnClickListener(final_context, ((JSONObject) (id)), id, b), final_context);
        ((TextView)v).append(((CharSequence) (id)));
        MixerBoxUtils.makeLinksFocusable((TextView)v);
          goto _L60
_L54:
        b = MixerBoxClient.unfollowUrl(id);
        b = "false";
          goto _L63
        if (b.getJSONObject("object2").isNull("switch") || !b.equals(b.getJSONObject("object2").getJSONObject("switch")))
        {
            continue; /* Loop/switch isn't completed */
        }
        b = b.getJSONObject("object2");
        b.remove("obj2IsSwitch");
        b.put("obj2IsSwitch", false);
        b = MixerBoxUtils.makeLinkSpan(b.getJSONObject("object2").getString("title"), new VectorOnClickListener(final_context, b, id, b), final_context);
        ((TextView)v).append(b);
        MixerBoxUtils.makeLinksFocusable((TextView)v);
        id = b.getJSONObject("object2").getJSONObject("switch").getString("ref");
        if (!b.getJSONObject("object2").getJSONObject("switch").getString("action").equals("follow")) goto _L65; else goto _L64
_L64:
        b = MixerBoxClient.followUrl(id);
        b = "true";
_L67:
        MixerBoxClient.get(b, null, new _cls6(b));
        return;
_L65:
        b = MixerBoxClient.unfollowUrl(id);
        b = "false";
        if (true) goto _L67; else goto _L66
_L66:
        if (b.isNull("obj2IsSwitch")) goto _L4; else goto _L68
_L68:
        if (b.getBoolean("obj2IsSwitch"))
        {
            b = b.getJSONObject("object2").getJSONObject("switch");
            final_context = MixerBoxUtils.makeLinkSpan(b.getJSONObject("object2").getJSONObject("switch").getString("title"), new VectorOnClickListener(final_context, b, id, b), final_context);
            ((TextView)v).append(final_context);
            MixerBoxUtils.makeLinksFocusable((TextView)v);
            return;
        }
        b = b.getJSONObject("object2");
        final_context = MixerBoxUtils.makeLinkSpan(b.getJSONObject("object2").getString("title"), new VectorOnClickListener(final_context, b, id, b), final_context);
        ((TextView)v).append(final_context);
        MixerBoxUtils.makeLinksFocusable((TextView)v);
        return;
_L33:
        if (!b.getString("action").equals("subscribe") && !b.getString("action").equals("unsubscribe")) goto _L70; else goto _L69
_L69:
        id = new JSONObject(b.toString());
        if (!b.isNull("switch"))
        {
            id = b.getJSONObject("switch");
        }
        if (((JSONObject) (id)).isNull("title"))
        {
            break MISSING_BLOCK_LABEL_5925;
        }
        obj = ((JSONObject) (id)).getString("title");
_L134:
        id = ((TextView)v).getText().toString();
        if (!id.equals(b.getString("title"))) goto _L72; else goto _L71
_L71:
        ((TextView)v).setText(((CharSequence) (obj)));
        if (!b.getString("action").equals("subscribe")) goto _L74; else goto _L73
_L73:
        if (b.isNull("isAlbum")) goto _L76; else goto _L75
_L75:
        b = Boolean.valueOf(b.getBoolean("isAlbum"));
_L130:
        b = new PlaylistItem(b.getString("ref"), b.getString("ptitle"), "", b.getString("owner"), b.getString("size"), "", b.getString("thumbnail"), 3, b.booleanValue());
        ((MainPage)final_context).subscribePlaylist(b, true);
        return;
_L74:
        if (((MainPage)final_context).isLogIn)
        {
            MixerBoxUtils.unsubsPlaylist((MainPage)final_context, b.getString("ref"));
            return;
        }
        ((MainPage)final_context).DB.deletePlaylist(b.getString("ref"));
        ((MainPage)final_context).mySubscriptions.remove(b.getString("ref"));
        ((MainPage)final_context).fragmentPlaylists.loadContent();
        return;
_L72:
        if (!id.equals(obj))
        {
            continue; /* Loop/switch isn't completed */
        }
        ((TextView)v).setText(b.getString("title"));
        if (!((JSONObject) (id)).getString("action").equals("subscribe")) goto _L78; else goto _L77
_L77:
        if (b.isNull("isAlbum")) goto _L80; else goto _L79
_L79:
        b = Boolean.valueOf(b.getBoolean("isAlbum"));
_L129:
        b = new PlaylistItem(b.getString("ref"), b.getString("ptitle"), "", b.getString("owner"), b.getString("size"), "", b.getString("thumbnail"), 3, b.booleanValue());
        ((MainPage)final_context).subscribePlaylist(b, true);
        return;
_L78:
        if (((MainPage)final_context).isLogIn)
        {
            MixerBoxUtils.unsubsPlaylist((MainPage)final_context, b.getString("ref"));
            return;
        }
        ((MainPage)final_context).DB.deletePlaylist(b.getString("ref"));
        ((MainPage)final_context).mySubscriptions.remove(b.getString("ref"));
        ((MainPage)final_context).fragmentPlaylists.loadContent();
        return;
        if (b == null) goto _L4; else goto _L81
_L81:
        ((TextView)v).setText("");
        if (b.isNull("object1")) goto _L83; else goto _L82
_L82:
        if (!b.equals(b.getJSONObject("object1"))) goto _L85; else goto _L84
_L84:
        id = b.getJSONObject("object1").getJSONObject("switch");
        b.remove("obj1IsSwitch");
        b.put("obj1IsSwitch", true);
        id = MixerBoxUtils.makeLinkSpan(b.getJSONObject("object1").getJSONObject("switch").getString("title"), new VectorOnClickListener(final_context, ((JSONObject) (id)), id, b), final_context);
        ((TextView)v).append(((CharSequence) (id)));
        MixerBoxUtils.makeLinksFocusable((TextView)v);
        if (!b.getJSONObject("object1").getString("action").equals("subscribe")) goto _L87; else goto _L86
_L86:
        if (b.isNull("isAlbum")) goto _L89; else goto _L88
_L88:
        id = Boolean.valueOf(b.getBoolean("isAlbum"));
_L128:
        id = new PlaylistItem(b.getString("ref"), b.getString("ptitle"), "", b.getString("owner"), b.getString("size"), "", b.getString("thumbnail"), 3, ((Boolean) (id)).booleanValue());
        ((MainPage)final_context).subscribePlaylist(((PlaylistItem) (id)), true);
_L97:
        ((TextView)v).append(" ");
_L83:
        if (!b.isNull("mainText"))
        {
            ((TextView)v).append(b.getString("mainText"));
        }
        if (b.isNull("object2")) goto _L4; else goto _L90
_L90:
        ((TextView)v).append(" ");
        if (!b.equals(b.getJSONObject("object2"))) goto _L92; else goto _L91
_L91:
        id = b.getJSONObject("object2").getJSONObject("switch");
        b.remove("obj2IsSwitch");
        b.put("obj2IsSwitch", true);
        id = MixerBoxUtils.makeLinkSpan(b.getJSONObject("object2").getJSONObject("switch").getString("title"), new VectorOnClickListener(final_context, ((JSONObject) (id)), id, b), final_context);
        ((TextView)v).append(id);
        MixerBoxUtils.makeLinksFocusable((TextView)v);
        if (!b.getJSONObject("object2").getString("action").equals("subscribe")) goto _L94; else goto _L93
_L93:
        if (b.isNull("isAlbum")) goto _L96; else goto _L95
_L95:
        b = Boolean.valueOf(b.getBoolean("isAlbum"));
_L126:
        b = new PlaylistItem(b.getString("ref"), b.getString("ptitle"), "", b.getString("owner"), b.getString("size"), "", b.getString("thumbnail"), 3, b.booleanValue());
        ((MainPage)final_context).subscribePlaylist(b, true);
        return;
_L87:
label0:
        {
            if (!((MainPage)final_context).isLogIn)
            {
                break label0;
            }
            MixerBoxUtils.unsubsPlaylist((MainPage)final_context, b.getString("ref"));
        }
          goto _L97
        ((MainPage)final_context).DB.deletePlaylist(b.getString("ref"));
        ((MainPage)final_context).mySubscriptions.remove(b.getString("ref"));
        ((MainPage)final_context).fragmentPlaylists.loadContent();
          goto _L97
_L85:
        if (b.getJSONObject("object1").isNull("switch") || !b.equals(b.getJSONObject("object1").getJSONObject("switch"))) goto _L99; else goto _L98
_L98:
        id = b.getJSONObject("object1");
        b.remove("obj1IsSwitch");
        b.put("obj1IsSwitch", false);
        id = MixerBoxUtils.makeLinkSpan(b.getJSONObject("object1").getString("title"), new VectorOnClickListener(final_context, ((JSONObject) (id)), id, b), final_context);
        ((TextView)v).append(((CharSequence) (id)));
        MixerBoxUtils.makeLinksFocusable((TextView)v);
        if (!b.getJSONObject("object1").getJSONObject("switch").getString("action").equals("subscribe")) goto _L101; else goto _L100
_L100:
        if (b.isNull("isAlbum")) goto _L103; else goto _L102
_L102:
        id = Boolean.valueOf(b.getBoolean("isAlbum"));
_L127:
        id = new PlaylistItem(b.getString("ref"), b.getString("ptitle"), "", b.getString("owner"), b.getString("size"), "", b.getString("thumbnail"), 3, ((Boolean) (id)).booleanValue());
        ((MainPage)final_context).subscribePlaylist(((PlaylistItem) (id)), true);
          goto _L97
_L101:
label1:
        {
            if (!((MainPage)final_context).isLogIn)
            {
                break label1;
            }
            MixerBoxUtils.unsubsPlaylist((MainPage)final_context, b.getString("ref"));
        }
          goto _L97
        ((MainPage)final_context).DB.deletePlaylist(b.getString("ref"));
        ((MainPage)final_context).mySubscriptions.remove(b.getString("ref"));
        ((MainPage)final_context).fragmentPlaylists.loadContent();
          goto _L97
_L99:
        if (b.isNull("obj1IsSwitch")) goto _L97; else goto _L104
_L104:
        if (!b.getBoolean("obj1IsSwitch"))
        {
            break MISSING_BLOCK_LABEL_4198;
        }
        id = b.getJSONObject("object1").getJSONObject("switch");
        id = MixerBoxUtils.makeLinkSpan(b.getJSONObject("object1").getJSONObject("switch").getString("title"), new VectorOnClickListener(final_context, ((JSONObject) (id)), id, b), final_context);
        ((TextView)v).append(((CharSequence) (id)));
        MixerBoxUtils.makeLinksFocusable((TextView)v);
          goto _L97
        id = b.getJSONObject("object1");
        id = MixerBoxUtils.makeLinkSpan(b.getJSONObject("object1").getString("title"), new VectorOnClickListener(final_context, ((JSONObject) (id)), id, b), final_context);
        ((TextView)v).append(((CharSequence) (id)));
        MixerBoxUtils.makeLinksFocusable((TextView)v);
          goto _L97
_L94:
        if (((MainPage)final_context).isLogIn)
        {
            MixerBoxUtils.unsubsPlaylist((MainPage)final_context, b.getString("ref"));
            return;
        }
        ((MainPage)final_context).DB.deletePlaylist(b.getString("ref"));
        ((MainPage)final_context).mySubscriptions.remove(b.getString("ref"));
        ((MainPage)final_context).fragmentPlaylists.loadContent();
        return;
_L92:
        if (b.getJSONObject("object2").isNull("switch") || !b.equals(b.getJSONObject("object2").getJSONObject("switch")))
        {
            continue; /* Loop/switch isn't completed */
        }
        id = b.getJSONObject("object2");
        b.remove("obj2IsSwitch");
        b.put("obj2IsSwitch", false);
        id = MixerBoxUtils.makeLinkSpan(b.getJSONObject("object2").getString("title"), new VectorOnClickListener(final_context, ((JSONObject) (id)), id, b), final_context);
        ((TextView)v).append(id);
        MixerBoxUtils.makeLinksFocusable((TextView)v);
        if (!b.getJSONObject("object2").getJSONObject("switch").getString("action").equals("subscribe")) goto _L106; else goto _L105
_L105:
        if (b.isNull("isAlbum")) goto _L108; else goto _L107
_L107:
        b = Boolean.valueOf(b.getBoolean("isAlbum"));
_L125:
        b = new PlaylistItem(b.getString("ref"), b.getString("ptitle"), "", b.getString("owner"), b.getString("size"), "", b.getString("thumbnail"), 3, b.booleanValue());
        ((MainPage)final_context).subscribePlaylist(b, true);
        return;
_L106:
        if (((MainPage)final_context).isLogIn)
        {
            MixerBoxUtils.unsubsPlaylist((MainPage)final_context, b.getString("ref"));
            return;
        }
        ((MainPage)final_context).DB.deletePlaylist(b.getString("ref"));
        ((MainPage)final_context).mySubscriptions.remove(b.getString("ref"));
        ((MainPage)final_context).fragmentPlaylists.loadContent();
        return;
        if (b.isNull("obj2IsSwitch")) goto _L4; else goto _L109
_L109:
        if (b.getBoolean("obj2IsSwitch"))
        {
            b = b.getJSONObject("object2").getJSONObject("switch");
            final_context = MixerBoxUtils.makeLinkSpan(b.getJSONObject("object2").getJSONObject("switch").getString("title"), new VectorOnClickListener(final_context, b, id, b), final_context);
            ((TextView)v).append(final_context);
            MixerBoxUtils.makeLinksFocusable((TextView)v);
            return;
        }
        b = b.getJSONObject("object2");
        final_context = MixerBoxUtils.makeLinkSpan(b.getJSONObject("object2").getString("title"), new VectorOnClickListener(final_context, b, id, b), final_context);
        ((TextView)v).append(final_context);
        MixerBoxUtils.makeLinksFocusable((TextView)v);
        return;
_L70:
        if (b.getString("action").equals("shareMusic"))
        {
            b = (new StringBuilder()).append("http://www.mixerbox.com/music/0/").append(b.getString("f")).toString();
            id = (new StringBuilder()).append(final_context.getResources().getString(0x7f0800ba)).append(final_context.getResources().getString(0x7f0800b8)).toString();
            v = final_context.getResources().getString(0x7f0800b9);
            id = new Intent("android.intent.action.SEND");
            ((Intent) (id)).setType("text/plain");
            ((Intent) (id)).putExtra("android.intent.extra.SUBJECT", (new StringBuilder()).append(id).append(b.getString("tt")).append(v).toString());
            ((Intent) (id)).putExtra("android.intent.extra.TEXT", (new StringBuilder()).append(id).append(b.getString("tt")).append(v).append(b).toString());
            final_context.startActivity(Intent.createChooser(((Intent) (id)), null));
            final_context = new HashMap();
            final_context.put("f", b.getString("f"));
            if (!b.isNull("_id"))
            {
                final_context.put("id", b.getString("_id"));
            }
            final_context.put("playlist", "");
            final_context.put("t", "yt");
            FlurryAgent.logEvent("action:music_share", final_context);
            return;
        }
        if (b.getString("action").equals("sharePlaylist"))
        {
            b = new HashMap();
            b.put("id", b.getString("ref"));
            FlurryAgent.logEvent("action:share_playlist", b);
            b = (new StringBuilder()).append("http://www.mixerbox.com/list/").append(b.getString("ref")).toString();
            id = (new StringBuilder()).append(final_context.getResources().getString(0x7f0800ba)).append(final_context.getResources().getString(0x7f0800b8)).toString();
            v = final_context.getResources().getString(0x7f0800b9);
            id = new Intent("android.intent.action.SEND");
            ((Intent) (id)).setType("text/plain");
            ((Intent) (id)).putExtra("android.intent.extra.SUBJECT", (new StringBuilder()).append(id).append(b.getString("ptitle")).append(v).toString());
            ((Intent) (id)).putExtra("android.intent.extra.TEXT", (new StringBuilder()).append(id).append(b.getString("ptitle")).append(v).append(b).toString());
            final_context.startActivity(Intent.createChooser(((Intent) (id)), null));
            return;
        }
        if (!b.getString("action").equals("addMusic")) goto _L111; else goto _L110
_L110:
        b = "";
        id = "";
        v = "";
        id = "";
        obj = "";
        if (!b.isNull("f"))
        {
            b = b.getString("f");
        }
        if (b.isNull("tm")) goto _L113; else goto _L112
_L112:
        id = b.getString("tm");
_L119:
        if (b.isNull("tt")) goto _L115; else goto _L114
_L114:
        v = b.getString("tt");
_L121:
        if (!b.isNull("_id"))
        {
            id = b.getString("_id");
        }
        if (!b.isNull("source")) goto _L117; else goto _L116
_L116:
        b = b;
        b = ((JSONObject) (obj));
        i = ((flag) ? 1 : 0);
_L122:
        (new AddToPlaylistDialog(final_context, new SongItem(((String) (id)), v, id, b, 0, i, b))).show().getWindow().setSoftInputMode(16);
        return;
_L113:
        if (b.isNull("duration")) goto _L119; else goto _L118
_L118:
        id = b.getString("duration");
          goto _L119
_L115:
        if (b.isNull("title")) goto _L121; else goto _L120
_L120:
        v = b.getString("title");
          goto _L121
_L117:
        if (!b.getString("source").equals("youtube"))
        {
            break MISSING_BLOCK_LABEL_5474;
        }
        b = b;
        i = ((flag) ? 1 : 0);
        b = ((JSONObject) (obj));
          goto _L122
        if (!b.getString("source").equals("soundcloud"))
        {
            break MISSING_BLOCK_LABEL_5827;
        }
        b = b.getString("trackId");
        if (b.isNull("thumbnail")) goto _L124; else goto _L123
_L123:
        obj = b.getString("thumbnail");
        i = 3;
        b = b;
        b = ((JSONObject) (obj));
          goto _L122
_L111:
        if (!b.getString("action").equals("more"))
        {
            break MISSING_BLOCK_LABEL_5677;
        }
        if (!b.isNull("pageType") && b.getString("pageType").equals("dj"))
        {
            b = ((MainPage)final_context).setVector(b.getString("ref"), "dj", 0, b.getString("pageTitle"));
            MixerBoxUtils.getVector(final_context, b.getString("ref"), b, "dj", b.getString("pageTitle"));
            final_context = new HashMap();
            final_context.put("id", b.getString("ref"));
            FlurryAgent.logEvent("page:user", final_context);
            return;
        }
        b = ((MainPage)final_context).setVector(b.getString("ref"), "vector", 0, b.getString("pageTitle"));
        MixerBoxUtils.getVector(final_context, b.getString("ref"), b, "vector", b.getString("pageTitle"));
        return;
        if (!b.getString("action").equals("api"))
        {
            break MISSING_BLOCK_LABEL_5801;
        }
        b = b.getJSONObject("apiInfo");
        if (b.getString("funcName").equals("searchVideo") && b.getString("method").equals("GET"))
        {
            b = b.getJSONObject("arguments");
            b = ((MainPage)final_context).setVector("VECTORIDSEARCH", b.getString("category"), 3, b.getString("q"));
            MixerBoxUtils.setSearchCategory(final_context, b.getString("q"), b, b.getString("category"));
            return;
        }
        MixerBoxUtils.toastMsg(final_context, final_context.getResources().getString(0x7f080103), 0);
        return;
        MixerBoxUtils.toastMsg(final_context, final_context.getResources().getString(0x7f080103), 0);
        return;
_L124:
        i = 3;
        b = b;
        b = ((JSONObject) (obj));
          goto _L122
        b = b;
        i = ((flag) ? 1 : 0);
        b = ((JSONObject) (obj));
          goto _L122
_L108:
        b = Boolean.valueOf(false);
          goto _L125
_L96:
        b = Boolean.valueOf(false);
          goto _L126
_L103:
        id = Boolean.valueOf(false);
          goto _L127
_L89:
        id = Boolean.valueOf(false);
          goto _L128
_L80:
        b = Boolean.valueOf(false);
          goto _L129
_L76:
        b = Boolean.valueOf(false);
          goto _L130
_L30:
        b = b;
          goto _L28
_L14:
        obj = Boolean.valueOf(false);
          goto _L131
_L12:
        obj = Boolean.valueOf(false);
          goto _L132
_L35:
        id = "";
          goto _L133
        obj = "";
          goto _L134
    }

    private class _cls1 extends MixerBoxAsyncHttpResponseHandler
    {

        final String val$b;
        final String val$id;
        final JSONObject val$j;
        final View val$v;

        public final void onFailure(Throwable throwable, String s)
        {
            super.onFailure(throwable, s);
            try
            {
                ((TextView)v).setText(j.getString("title"));
            }
            // Misplaced declaration of an exception variable
            catch (Throwable throwable)
            {
                throwable.printStackTrace();
            }
            MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f080049), 0);
        }

        public final void onSuccess(String s)
        {
            super.onSuccess(s);
            if (((MainPage)ctx).fragmentDJs != null && ((MainPage)ctx).fragmentDJs.isAdded())
            {
                if (b.equals("true"))
                {
                    MixerBoxUtils.getDJs(ctx);
                } else
                {
                    int i = 0;
                    while (i < ((MainPage)ctx).arrayDJs.size()) 
                    {
                        try
                        {
                            if (((MyItem)((MainPage)ctx).arrayDJs.get(i)).getMyJSONObject().get("ref").equals(id))
                            {
                                ((MainPage)ctx).arrayDJs.remove(i);
                                ((MainPage)ctx).fragmentDJs.adapter.notifyDataSetChanged();
                            }
                        }
                        // Misplaced declaration of an exception variable
                        catch (String s) { }
                        i++;
                    }
                }
            }
            MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f0800e9), 0);
            s = new HashMap();
            s.put("dj_id", id);
            s.put("follow", b);
            FlurryAgent.logEvent("action:follow", s);
        }

        _cls1(JSONObject jsonobject)
        {
            b = s;
            id = s1;
            v = view;
            j = jsonobject;
            super(final_context);
        }
    }


    private class _cls2 extends MixerBoxAsyncHttpResponseHandler
    {

        final String val$b;
        final String val$id;
        final String val$s;
        final View val$v;

        public final void onFailure(Throwable throwable, String s1)
        {
            super.onFailure(throwable, s1);
            ((TextView)v).setText(s);
            MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f080049), 0);
        }

        public final void onSuccess(String s1)
        {
            super.onSuccess(s1);
            if (((MainPage)ctx).fragmentDJs != null && ((MainPage)ctx).fragmentDJs.isAdded())
            {
                MixerBoxUtils.getDJs(ctx);
            }
            MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f0800e9), 0);
            s1 = new HashMap();
            s1.put("dj_id", id);
            s1.put("follow", b);
            FlurryAgent.logEvent("action:follow", s1);
        }

        _cls2(String s3)
        {
            id = s1;
            b = s2;
            v = view;
            s = s3;
            super(final_context);
        }
    }


    private class _cls3 extends MixerBoxAsyncHttpResponseHandler
    {

        final String val$b;
        final String val$id;

        public final void onFailure(Throwable throwable, String s)
        {
            super.onFailure(throwable, s);
            MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f080049), 0);
        }

        public final void onSuccess(String s)
        {
            super.onSuccess(s);
            if (((MainPage)ctx).fragmentDJs != null && ((MainPage)ctx).fragmentDJs.isAdded())
            {
                MixerBoxUtils.getDJs(ctx);
            }
            MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f0800e9), 0);
            s = new HashMap();
            s.put("dj_id", id);
            s.put("follow", b);
            FlurryAgent.logEvent("action:follow", s);
        }

        _cls3(String s1)
        {
            id = s;
            b = s1;
            super(final_context);
        }
    }


    private class _cls5 extends MixerBoxAsyncHttpResponseHandler
    {

        final String val$b;
        final String val$id;

        public final void onFailure(Throwable throwable, String s)
        {
            super.onFailure(throwable, s);
            MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f080049), 0);
        }

        public final void onSuccess(String s)
        {
            super.onSuccess(s);
            if (((MainPage)ctx).fragmentDJs != null && ((MainPage)ctx).fragmentDJs.isAdded())
            {
                MixerBoxUtils.getDJs(ctx);
            }
            MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f0800e9), 0);
            s = new HashMap();
            s.put("dj_id", id);
            s.put("follow", b);
            FlurryAgent.logEvent("action:follow", s);
        }

        _cls5(String s1)
        {
            id = s;
            b = s1;
            super(final_context);
        }
    }


    private class _cls4 extends MixerBoxAsyncHttpResponseHandler
    {

        final String val$b;
        final String val$id;

        public final void onFailure(Throwable throwable, String s)
        {
            super.onFailure(throwable, s);
            MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f080049), 0);
        }

        public final void onSuccess(String s)
        {
            super.onSuccess(s);
            if (((MainPage)ctx).fragmentDJs != null && ((MainPage)ctx).fragmentDJs.isAdded())
            {
                MixerBoxUtils.getDJs(ctx);
            }
            MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f0800e9), 0);
            s = new HashMap();
            s.put("dj_id", id);
            s.put("follow", b);
            FlurryAgent.logEvent("action:follow", s);
        }

        _cls4(String s1)
        {
            id = s;
            b = s1;
            super(final_context);
        }
    }


    private class _cls6 extends MixerBoxAsyncHttpResponseHandler
    {

        final String val$b;
        final String val$id;

        public final void onFailure(Throwable throwable, String s)
        {
            super.onFailure(throwable, s);
            MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f080049), 0);
        }

        public final void onSuccess(String s)
        {
            super.onSuccess(s);
            if (((MainPage)ctx).fragmentDJs != null && ((MainPage)ctx).fragmentDJs.isAdded())
            {
                MixerBoxUtils.getDJs(ctx);
            }
            MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f0800e9), 0);
            s = new HashMap();
            s.put("dj_id", id);
            s.put("follow", b);
            FlurryAgent.logEvent("action:follow", s);
        }

        _cls6(String s1)
        {
            id = s;
            b = s1;
            super(final_context);
        }
    }

}
