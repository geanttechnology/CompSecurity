// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applift.playads.delegate;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import com.applift.playads.PlayAdsActivity;
import com.applift.playads.api.PlayAdsType;
import com.applift.playads.http.image.CountingListener;
import com.applift.playads.http.image.ImageFetcher;
import com.applift.playads.model.Promo;
import com.applift.playads.model.PromoData;
import com.applift.playads.model.settings.Settings;
import com.applift.playads.util.ImgUrlUtil;
import com.applift.playads.util.Res;
import com.applift.playads.util.WebRedirector;
import java.util.Arrays;
import org.droidparts.util.ui.ViewUtils;

// Referenced classes of package com.applift.playads.delegate:
//            PlayAdsWorker, CoverFlowDelegate, GameListDelegate, ScratchScreenDelegate, 
//            SlotMachineDelegate, MemoryGameDelegate, InterstitialDelegate, VideoDelegate

public abstract class AbstractDelegate
    implements android.view.View.OnClickListener
{

    protected final PlayAdsActivity act;
    protected View closeBtn;
    protected View contentView;
    protected final CountingListener countingListener = new CountingListener(new _cls1());
    protected final Handler handler = new Handler();
    protected final ImageFetcher imageFetcher;
    protected final ImgUrlUtil imgUrlUtil;
    protected final Settings settings;
    private WebRedirector webRedirector;

    public AbstractDelegate(PlayAdsActivity playadsactivity, Settings settings1)
    {
        act = playadsactivity;
        settings = settings1;
        imgUrlUtil = new ImgUrlUtil(playadsactivity, settings1);
        imageFetcher = new ImageFetcher(playadsactivity);
    }

    public static void cancel()
    {
        PlayAdsWorker.cancel();
    }

    private void cancelWebRedirect()
    {
        if (webRedirector != null)
        {
            webRedirector.cancel();
            webRedirector = null;
        }
    }

    public static AbstractDelegate get(PlayAdsActivity playadsactivity, PlayAdsType playadstype, Settings settings1, PromoData promodata)
    {
    /* anonymous class not found */
    class _anm2 {}

        switch (_cls2..SwitchMap.com.applift.playads.api.PlayAdsType[playadstype.ordinal()])
        {
        default:
            throw new IllegalArgumentException(playadstype.toString());

        case 1: // '\001'
            return new CoverFlowDelegate(playadsactivity, settings1, Arrays.asList(promodata.promos));

        case 2: // '\002'
            return new GameListDelegate(playadsactivity, settings1, Arrays.asList(promodata.promos));

        case 3: // '\003'
            return new ScratchScreenDelegate(playadsactivity, settings1, promodata.promos[0]);

        case 4: // '\004'
            return new SlotMachineDelegate(playadsactivity, settings1, Arrays.asList(promodata.promos));

        case 5: // '\005'
            return new MemoryGameDelegate(playadsactivity, settings1, Arrays.asList(promodata.promos));

        case 6: // '\006'
            return new InterstitialDelegate(playadsactivity, settings1, promodata.promos[0]);

        case 7: // '\007'
            return new VideoDelegate(playadsactivity, settings1, promodata.promos[0]);
        }
    }

    protected final View findViewById(String s)
    {
        return Res.findViewById(contentView, s);
    }

    protected abstract String getContentLayoutName();

    public View getContentView()
    {
        return contentView;
    }

    public abstract PlayAdsType getType();

    public void onActivityFinish()
    {
        cancelWebRedirect();
        PlayAdsWorker.notifyOnClosed(getType());
    }

    public void onClick(View view)
    {
        if (view == closeBtn)
        {
            act.finish();
        }
    }

    public void onCreate()
    {
        act.showLoading(true);
        contentView = LayoutInflater.from(act).inflate(Res.layoutId(act, getContentLayoutName()), null);
        ViewUtils.setInvisible(true, new View[] {
            contentView
        });
        closeBtn = findViewById("btn_close");
        closeBtn.setOnClickListener(this);
        act.setContentView(contentView);
    }

    protected void onLoadingDone()
    {
        ViewUtils.setInvisible(false, new View[] {
            contentView
        });
        act.showLoading(false);
    }

    public void onPause()
    {
    }

    public void onResume()
    {
    }

    public void onRotate()
    {
        countingListener.reset();
    }

    protected final void showInPlayStore(Promo promo)
    {
        cancelWebRedirect();
        webRedirector = new WebRedirector(act, promo.getLink(), promo.getDirectLink());
        if (settings.backgroundRedirectEnabled)
        {
            webRedirector.doBackgroundRedirect();
        } else
        {
            webRedirector.doBrowserRedirect();
        }
        PlayAdsWorker.notifyOnTapped(getType(), promo);
    }

    /* member class not found */
    class _cls1 {}

}
