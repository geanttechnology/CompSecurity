// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.utils;

import android.content.Context;
import android.database.Cursor;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.classes.MixerBoxAsyncHttpResponseHandler;
import com.mixerbox.mixerbox3b.classes.SongItem;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.mixerbox.mixerbox3b.utils:
//            MixerBoxSQLite, MixerBoxUtils, MixerBoxClient

final class ttpResponseHandler extends MixerBoxAsyncHttpResponseHandler
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
        cursor = ((MainPage)val$ctx).DB.getSong(val$dbPid);
        i = cursor.getCount();
        cursor.moveToFirst();
        i2 = 0;
        while (i2 < i) 
        {
            if (cursor.getInt(6) == 3)
            {
                SongItem songitem = new SongItem("", cursor.getString(2), cursor.getString(3), cursor.getString(4), i2, 3, cursor.getString(7));
                MixerBoxUtils.addSong(val$ctx, p, songitem, false, "");
            } else
            {
                s = (new StringBuilder()).append(s).append("&list%5B").append(i2).append("%5D=").append(cursor.getString(4)).toString();
            }
            cursor.moveToNext();
            i2++;
        }
        cursor.close();
        i2 = Integer.valueOf(val$i1).intValue();
        class _cls1 extends AsyncHttpResponseHandler
        {

            final MixerBoxUtils._cls6 this$0;
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
                this$0 = MixerBoxUtils._cls6.this;
                p = s;
                i2 = i;
                super();
            }
        }

        MixerBoxClient.get(MixerBoxClient.getBatchAddUrl(p, s), null, new _cls1());
    }

    _cls1(int i)
    {
        val$ctx = context1;
        val$dbPid = s;
        val$i1 = i;
        super(final_context);
    }
}
