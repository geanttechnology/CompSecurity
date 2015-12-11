// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.services;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import com.bitstrips.imoji.InjectorApplication;
import com.bitstrips.imoji.api.BitstripsService;
import com.bitstrips.imoji.models.AvatarInfo;
import com.bitstrips.imoji.models.JSONStringPayload;
import com.bitstrips.imoji.util.PreferenceUtils;
import com.bitstrips.outfitbuilder.models.OBAvatarData;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class OutfitSaverService extends Service
{

    private static final String TAG = com/bitstrips/imoji/services/OutfitSaverService.getCanonicalName();
    BitstripsService bitstripsService;
    private BroadcastReceiver mMessageReceiver;
    PreferenceUtils preferenceUtils;

    public OutfitSaverService()
    {
        mMessageReceiver = new BroadcastReceiver() {

            final OutfitSaverService this$0;

            public void onReceive(Context context, Intent intent)
            {
                int i = intent.getIntExtra("OutfitIDExtra", 0);
                saveOutfit(i);
            }

            
            {
                this$0 = OutfitSaverService.this;
                super();
            }
        };
    }

    private void sendErrorMessage()
    {
        (new Intent("com.bitstrips.outfitbuilder.save-outfit-response")).putExtra("com.bitstrips.outfitbuilder.saveOutfitResponseCode", 1);
        LocalBroadcastManager.getInstance(this);
    }

    private void sendSuccessMessage(AvatarInfo avatarinfo)
    {
        avatarinfo = new Intent("com.bitstrips.outfitbuilder.save-outfit-response");
        avatarinfo.putExtra("com.bitstrips.outfitbuilder.saveOutfitResponseCode", 0);
        LocalBroadcastManager.getInstance(this).sendBroadcast(avatarinfo);
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onCreate()
    {
        super.onCreate();
        ((InjectorApplication)getApplication()).inject(this);
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver, new IntentFilter("com.bitstrips.outfitbuilder.save-outfit-request"));
    }

    public void onDestroy()
    {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mMessageReceiver);
    }

    public void saveOutfit(int i)
    {
        String s = preferenceUtils.getString(0x7f06003a, "");
        String s1 = getString(0x7f060017);
        String s2 = AvatarInfo.getAvatarDataFromPreferences(preferenceUtils).getSaveAvatarPayload(i);
        Callback callback = new Callback() {

            final OutfitSaverService this$0;

            public void failure(RetrofitError retrofiterror)
            {
                sendErrorMessage();
            }

            public void success(AvatarInfo avatarinfo, Response response)
            {
                avatarinfo.saveToPreferences(preferenceUtils);
                sendSuccessMessage(avatarinfo);
            }

            public volatile void success(Object obj, Response response)
            {
                success((AvatarInfo)obj, response);
            }

            
            {
                this$0 = OutfitSaverService.this;
                super();
            }
        };
        bitstripsService.saveAvatar(s, s1, new JSONStringPayload(s2), callback);
    }



}
