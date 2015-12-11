// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applift.playads;

import android.content.Context;
import android.content.Intent;
import com.applift.playads.api.PlayAdsType;
import com.applift.playads.model.PromoData;
import com.applift.playads.model.settings.Settings;

// Referenced classes of package com.applift.playads:
//            PlayAdsActivity

static class intent
{

    private static final String CONTENT_INTENT = "intent_content";
    private static final String EXTRA_FULL_SCREEN = "full_screen";
    private static final String EXTRA_PROMO_DATA = "promo_data";
    private static final String EXTRA_SETTINGS = "settings";
    private static final String EXTRA_SHOW_LOADING = "show_loading";
    private static final String EXTRA_TYPE = "type";
    private static final String FINISH_INTENT = "intent_finish";
    private static final String INTENT_TYPE = "intent_type";
    private static final int LAUNCH_FLAGS = 0x34800000;
    private static final String LOADING_INTENT = "intent_loading";
    private final Intent intent;

    static Intent getChangeLoadingIntent(Context context, boolean flag, boolean flag1)
    {
        context = getIntent(context, "intent_loading", flag);
        context.putExtra("show_loading", flag1);
        return context;
    }

    static Intent getFinishIntent(Context context, boolean flag)
    {
        return getIntent(context, "intent_finish", flag);
    }

    private static Intent getIntent(Context context, String s, boolean flag)
    {
        context = new Intent(context, com/applift/playads/PlayAdsActivity);
        context.setFlags(0x34800000);
        context.putExtra("intent_type", s);
        context.putExtra("full_screen", flag);
        return context;
    }

    static Intent getShowPromosIntent(Context context, boolean flag, PlayAdsType playadstype, Settings settings, PromoData promodata)
    {
        context = getIntent(context, "intent_content", flag);
        context.putExtra("type", playadstype);
        context.putExtra("settings", settings);
        context.putExtra("promo_data", promodata);
        return context;
    }

    PromoData getPromoData()
    {
        return (PromoData)intent.getSerializableExtra("promo_data");
    }

    Settings getSettings()
    {
        return (Settings)intent.getSerializableExtra("settings");
    }

    PlayAdsType getType()
    {
        return (PlayAdsType)intent.getSerializableExtra("type");
    }

    boolean isContentIntent()
    {
        return "intent_content".equals(intent.getStringExtra("intent_type"));
    }

    boolean isFinishIntent()
    {
        return "intent_finish".equals(intent.getStringExtra("intent_type"));
    }

    boolean isFullScreen()
    {
        return intent.getBooleanExtra("full_screen", false);
    }

    boolean isLoadingIntent()
    {
        return "intent_loading".equals(intent.getStringExtra("intent_type"));
    }

    boolean isShowLoading()
    {
        return intent.getBooleanExtra("show_loading", false);
    }

    (Intent intent1)
    {
        intent = intent1;
    }
}
