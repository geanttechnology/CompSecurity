// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.common;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.comcast.cim.android.view.common.CALDialogFragment;
import com.comcast.cim.android.view.common.CancellingClickListener;
import com.comcast.cim.android.view.common.errorformatter.CimHttpErrorTitleBuilder;
import com.comcast.cim.cmasl.android.util.system.AndroidDevice;
import com.comcast.cim.cmasl.http.exceptions.CimHttpException;
import com.comcast.cim.container.PlayerContainer;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStream;
import com.xfinity.playerlib.model.dibic.DibicProgram;
import java.util.ArrayList;
import java.util.List;

public class UpsellDialog extends CALDialogFragment
{
    public static final class UpsellType extends Enum
    {

        private static final UpsellType $VALUES[];
        public static final UpsellType DOWNLOAD;
        public static final UpsellType PLAYBACK;
        public static final UpsellType PLAY_DOWNLOADED;
        public static final UpsellType PLAY_FROM_HISTORY;
        public static final UpsellType PLAY_FROM_PLAYER;
        private int descriptionResId;

        public static UpsellType valueOf(String s)
        {
            return (UpsellType)Enum.valueOf(com/xfinity/playerlib/view/common/UpsellDialog$UpsellType, s);
        }

        public static UpsellType[] values()
        {
            return (UpsellType[])$VALUES.clone();
        }

        public int getDescriptionResId()
        {
            return descriptionResId;
        }

        static 
        {
            PLAYBACK = new UpsellType("PLAYBACK", 0, com.xfinity.playerlib.R.string.subscription_required_playback);
            DOWNLOAD = new UpsellType("DOWNLOAD", 1, com.xfinity.playerlib.R.string.subscription_required_download);
            PLAY_DOWNLOADED = new UpsellType("PLAY_DOWNLOADED", 2, com.xfinity.playerlib.R.string.subscription_invalid_msg);
            PLAY_FROM_HISTORY = new UpsellType("PLAY_FROM_HISTORY", 3, com.xfinity.playerlib.R.string.subscription_invalid_msg);
            PLAY_FROM_PLAYER = new UpsellType("PLAY_FROM_PLAYER", 4, com.xfinity.playerlib.R.string.player_platform_error_msg_subscription_required);
            $VALUES = (new UpsellType[] {
                PLAYBACK, DOWNLOAD, PLAY_DOWNLOADED, PLAY_FROM_HISTORY, PLAY_FROM_PLAYER
            });
        }

        private UpsellType(String s, int i, int j)
        {
            super(s, i);
            descriptionResId = j;
        }
    }


    private static final CimHttpErrorTitleBuilder TITLE_BUILDER = new CimHttpErrorTitleBuilder();
    private AndroidDevice androidDevice;

    public UpsellDialog()
    {
        androidDevice = PlayerContainer.getInstance().getAndroidDevice();
    }

    private Uri getUpsellUri()
    {
        String s;
        int i;
        int j;
        s = getArguments().getString("providerCode");
        j = com.xfinity.playerlib.R.string.url_upsell_default;
        i = j;
        if (s == null) goto _L2; else goto _L1
_L1:
        if (!s.equals("d")) goto _L4; else goto _L3
_L3:
        i = com.xfinity.playerlib.R.string.url_upsell_hbo;
_L2:
        return Uri.parse(getResources().getString(i));
_L4:
        if (s.equals("f"))
        {
            i = com.xfinity.playerlib.R.string.url_upsell_starz;
        } else
        if (s.equals("g"))
        {
            i = com.xfinity.playerlib.R.string.url_upsell_cinemax;
        } else
        if (s.equals("e"))
        {
            i = com.xfinity.playerlib.R.string.url_upsell_showtime;
        } else
        if (s.equals("j") || s.equals("k"))
        {
            i = com.xfinity.playerlib.R.string.url_upsell_mi_cine;
        } else
        if (s.equals("ab"))
        {
            i = com.xfinity.playerlib.R.string.url_upsell_bollywood;
        } else
        if (s.equals("ai"))
        {
            i = com.xfinity.playerlib.R.string.url_upsell_tmc;
        } else
        if (s.equals("h"))
        {
            i = com.xfinity.playerlib.R.string.url_upsell_encore;
        } else
        if (s.equals("bh"))
        {
            i = com.xfinity.playerlib.R.string.url_upsell_vutopia;
        } else
        {
            i = j;
            if (s.equals("cj"))
            {
                i = com.xfinity.playerlib.R.string.url_upsell_streampix;
            }
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public static UpsellDialog newInstance(Bundle bundle)
    {
        bundle.putString("tag", "inputPromptDlg");
        UpsellDialog upselldialog = new UpsellDialog();
        upselldialog.setArguments(bundle);
        return upselldialog;
    }

    public static UpsellDialog newInstance(UpsellType upselltype, VideoFacade videofacade)
    {
        Bundle bundle = new Bundle();
        bundle.putString("providerCode", videofacade.getProviderCode());
        bundle.putSerializable("upsellType", upselltype);
        return newInstance(bundle);
    }

    public static UpsellDialog newInstance(UpsellType upselltype, VideoFacade videofacade, Throwable throwable)
    {
        Bundle bundle = new Bundle();
        bundle.putString("providerCode", videofacade.getProviderCode());
        bundle.putSerializable("upsellType", upselltype);
        if (throwable instanceof CimHttpException)
        {
            bundle.putString("titleSuffix", TITLE_BUILDER.getTitleSuffixForThrowable((CimHttpException)throwable));
        }
        return newInstance(bundle);
    }

    public static UpsellDialog newInstance(UpsellType upselltype, HalLiveStream hallivestream)
    {
        Bundle bundle = new Bundle();
        bundle.putString("providerCode", (String)hallivestream.getProviderCodes().get(0));
        bundle.putSerializable("upsellType", upselltype);
        return newInstance(bundle);
    }

    public static UpsellDialog newInstance(UpsellType upselltype, DibicProgram dibicprogram)
    {
        Bundle bundle = new Bundle();
        bundle.putString("providerCode", (String)dibicprogram.getProviderCodes().get(0));
        bundle.putSerializable("upsellType", upselltype);
        return newInstance(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        Bundle bundle2 = getArguments();
        Bundle bundle1 = new Bundle();
        UpsellType upselltype = (UpsellType)bundle2.getSerializable("upsellType");
        String s1 = getResources().getString(com.xfinity.playerlib.R.string.subscription_needed);
        String s = s1;
        if (bundle2.getString("titleSuffix") != null)
        {
            s = (new StringBuilder()).append(s1).append(bundle2.getString("titleSuffix")).toString();
        }
        bundle1.putString("title", s);
        bundle1.putString("description", getResources().getString(upselltype.getDescriptionResId()));
        addArguments(bundle1);
        buttonList = new ArrayList();
        if (androidDevice.isKindleOrFromAmazonStore())
        {
            s = getString(com.xfinity.playerlib.R.string.dlg_btn_ok);
        } else
        {
            buttonList.add(new com.comcast.cim.android.view.common.CALDialogFragment.CDFButton(getResources().getString(com.xfinity.playerlib.R.string.order_now), new android.content.DialogInterface.OnClickListener() {

                final UpsellDialog this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent("android.intent.action.VIEW", getUpsellUri());
                    getActivity().startActivity(dialoginterface);
                }

            
            {
                this$0 = UpsellDialog.this;
                super();
            }
            }));
            s = getString(com.xfinity.playerlib.R.string.dlg_btn_cancel);
        }
        buttonList.add(new com.comcast.cim.android.view.common.CALDialogFragment.CDFButton(s, new CancellingClickListener()));
        return super.onCreateView(layoutinflater, viewgroup, bundle);
    }


}
