// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.app.Activity;
import android.text.TextUtils;
import com.bitstrips.imoji.manager.FloaterServiceManager;
import com.bitstrips.imoji.manager.TemplatesManager;
import com.bitstrips.imoji.models.AvatarInfo;
import com.bitstrips.imoji.ui.adapters.ImojiPagerAdapter;
import com.bitstrips.imoji.util.PreferenceUtils;
import com.bitstrips.outfitbuilder.services.OBAssetsPreloaderIntentService;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.bitstrips.imoji.ui:
//            ImojiBrowserActivity, ImojisPreloader, IntentCreatorService

class val.savingAvatarAtTimeOfCall
    implements Callback
{

    final ImojiBrowserActivity this$0;
    final boolean val$savingAvatarAtTimeOfCall;
    final Activity val$self;

    public void failure(RetrofitError retrofiterror)
    {
        retrofiterror = preferenceUtils.getString(0x7f06002a, null);
        if ("b4m".equals("production") && TextUtils.isEmpty(retrofiterror))
        {
            logout();
        } else
        if (retrofiterror != null)
        {
            if (ImojiBrowserActivity.access$800(ImojiBrowserActivity.this))
            {
                floaterServiceManager.startFloaterService();
            }
            imojisPreloader.load();
            return;
        }
    }

    public void success(AvatarInfo avatarinfo, Response response)
    {
        response = preferenceUtils.getString(0x7f06002a, null);
        avatarinfo.saveToPreferences(preferenceUtils);
        if (TextUtils.isEmpty(avatarinfo.getId()))
        {
            intentCreatorService.goToLoginActivity(val$self);
        } else
        {
            if (!avatarinfo.getIsDressed() && !val$savingAvatarAtTimeOfCall)
            {
                ImojiBrowserActivity.access$700(ImojiBrowserActivity.this);
                return;
            }
            if (avatarinfo.getId() != null)
            {
                com.bitstrips.outfitbuilder.models.OBAvatarData obavatardata = AvatarInfo.getAvatarDataFromPreferences(preferenceUtils);
                OBAssetsPreloaderIntentService.startActionFetchAvatarDependentAssets(getApplicationContext(), obavatardata, templatesManager.getCatalogForData(obavatardata));
            }
            if (response == null || !response.equals(avatarinfo.getId()) || !response.equals(imojisPreloader.getLastPreloadedAvatarId()))
            {
                templatesManager.resetAllImojisCachedImageUrl();
                if (ImojiBrowserActivity.access$800(ImojiBrowserActivity.this))
                {
                    floaterServiceManager.restartFloaterService();
                }
                if (response != null)
                {
                    imojisPreloader.load();
                }
                if (!isPaused && !isFinishing())
                {
                    imojiPagerAdapter.notifyDataSetChanged();
                    return;
                }
            }
        }
    }

    public volatile void success(Object obj, Response response)
    {
        success((AvatarInfo)obj, response);
    }

    er()
    {
        this$0 = final_imojibrowseractivity;
        val$self = activity;
        val$savingAvatarAtTimeOfCall = Z.this;
        super();
    }
}
