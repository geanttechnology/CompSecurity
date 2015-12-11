// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.facebook.Session;
import com.mixerbox.mixerbox3b.utils.MixerBoxConstants;
import com.mixerbox.mixerbox3b.utils.MixerBoxSharedPreferences;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;
import java.util.ArrayList;
import java.util.Locale;

// Referenced classes of package com.mixerbox.mixerbox3b:
//            MixerBox, Onboarding, MainPage

class s extends Handler
{

    public void handleMessage(Message message)
    {
        super.handleMessage(message);
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            break;
        }
        if (MixerBox.count < 0)
        {
            MixerBox.access$200();
            MixerBox.mp3ArtistId = new ArrayList();
            message = MixerBoxUtils.loadJSONFromAsset(MixerBox.ctx, "artists.json").toLowerCase(Locale.ENGLISH);
            for (int i = 0; i < MixerBox.mp3Artist.size(); i++)
            {
                if (message.contains((CharSequence)MixerBox.mp3Artist.get(i)))
                {
                    MixerBox.mp3ArtistId.add(MixerBox.mp3Artist.get(i));
                }
            }

            if (MixerBox.bundle == null)
            {
                MixerBox.bundle = new Bundle();
            }
            MixerBox.bundle.putStringArrayList("fav_artists", MixerBox.mp3ArtistId);
            message = new Intent(MixerBox.ctx, com/mixerbox/mixerbox3b/Onboarding);
            message.putExtras(MixerBox.bundle);
            MixerBox.ctx.startActivity(message);
            ((Activity)MixerBox.ctx).finish();
            return;
        }
        if (MixerBox.loginFlag)
        {
            if (MixerBox.bundle == null)
            {
                MixerBox.bundle = new Bundle();
            }
            MixerBoxSharedPreferences.putFacebookToken(MixerBox.ctx, Session.getActiveSession().getAccessToken());
            MixerBoxUtils.toastMsg(MixerBox.ctx, MixerBox.ctx.getResources().getString(0x7f080074), 1);
            MixerBoxUtils.laterLoginInit(MixerBox.ctx, Session.getActiveSession(), MixerBox.bundle);
            return;
        }
        MixerBoxConstants.shouldOnCreate = true;
        if (MixerBox.bundle == null)
        {
            MixerBox.bundle = new Bundle();
        }
        MixerBox.bundle.putBoolean("isLogIn", false);
        message = new Intent();
        message.putExtras(MixerBox.bundle);
        message.setClass(MixerBox.ctx, com/mixerbox/mixerbox3b/MainPage);
        MixerBox.ctx.startActivity(message);
        ((Activity)MixerBox.ctx).finish();
    }

    s()
    {
    }
}
