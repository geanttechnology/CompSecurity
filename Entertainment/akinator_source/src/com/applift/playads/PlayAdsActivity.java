// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applift.playads;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.Window;
import com.applift.playads.api.PlayAdsType;
import com.applift.playads.delegate.AbstractDelegate;
import com.applift.playads.model.PromoData;
import com.applift.playads.model.settings.Settings;
import com.applift.playads.test.Event;
import com.applift.playads.test.EventLogger;
import com.applift.playads.ui.dialog.LoadingDialog;

public final class PlayAdsActivity extends Activity
    implements android.content.DialogInterface.OnCancelListener
{
    static class IntentData
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

        IntentData(Intent intent1)
        {
            intent = intent1;
        }
    }


    AbstractDelegate _flddelegate;
    LoadingDialog loadingDialog;

    public PlayAdsActivity()
    {
    }

    public static Intent getFinishIntent(Context context, boolean flag)
    {
        return IntentData.getFinishIntent(context, flag);
    }

    public static Intent getShowLoadingIntent(Context context, boolean flag, boolean flag1)
    {
        return IntentData.getChangeLoadingIntent(context, flag, flag1);
    }

    public static Intent getShowPromosIntent(Context context, boolean flag, PlayAdsType playadstype, Settings settings, PromoData promodata)
    {
        return IntentData.getShowPromosIntent(context, flag, playadstype, settings, promodata);
    }

    private void initFromIntentData(IntentData intentdata, boolean flag)
    {
        if (!intentdata.isContentIntent()) goto _L2; else goto _L1
_L1:
        if (!flag) goto _L4; else goto _L3
_L3:
        if (_flddelegate == null || _flddelegate.getType() != intentdata.getType())
        {
            _flddelegate = AbstractDelegate.get(this, intentdata.getType(), intentdata.getSettings(), intentdata.getPromoData());
        }
        _flddelegate.onCreate();
_L6:
        return;
_L4:
        _flddelegate.onRotate();
        return;
_L2:
        if (intentdata.isLoadingIntent())
        {
            showLoading(intentdata.isShowLoading());
            return;
        }
        if (intentdata.isFinishIntent())
        {
            finish();
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void tryToWakeUp()
    {
        Object obj = (PowerManager)getSystemService("power");
        try
        {
            obj = ((PowerManager) (obj)).newWakeLock(0x1000000a, "PlayAds");
            ((android.os.PowerManager.WakeLock) (obj)).acquire();
            ((android.os.PowerManager.WakeLock) (obj)).release();
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void finish()
    {
        super.finish();
        if (_flddelegate != null)
        {
            _flddelegate.onActivityFinish();
        } else
        {
            AbstractDelegate.cancel();
        }
        overridePendingTransition(0, 0);
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        finish();
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        EventLogger.logEvent(Event.SCREEN_ROTATED);
        initFromIntentData(new IntentData(getIntent()), false);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        tryToWakeUp();
        loadingDialog = new LoadingDialog(this, this);
        requestWindowFeature(1);
        getWindow().addFlags(128);
        bundle = new IntentData(getIntent());
        if (bundle.isFullScreen())
        {
            getWindow().addFlags(1024);
        }
        initFromIntentData(bundle, true);
    }

    public void onDestroy()
    {
        super.onDestroy();
        loadingDialog.dismiss();
    }

    protected void onNewIntent(Intent intent)
    {
        IntentData intentdata = new IntentData(intent);
        if (intentdata.isContentIntent())
        {
            setIntent(intent);
        }
        initFromIntentData(intentdata, true);
    }

    protected void onPause()
    {
        super.onPause();
        if (_flddelegate != null)
        {
            _flddelegate.onPause();
        }
    }

    protected void onResume()
    {
        super.onResume();
        if (_flddelegate != null)
        {
            _flddelegate.onResume();
        }
    }

    protected void onUserLeaveHint()
    {
        finish();
    }

    public void showLoading(boolean flag)
    {
        if (flag)
        {
            loadingDialog.show();
            return;
        } else
        {
            loadingDialog.hide();
            return;
        }
    }
}
