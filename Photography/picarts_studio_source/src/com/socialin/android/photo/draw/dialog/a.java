// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw.dialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.picsart.collages.SelectCollageActivity;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.dialog.d;
import com.socialin.android.photo.collage.SelectCollageBgActivity;
import com.socialin.android.photo.picsinphoto.StudioActivity;
import myobfuscated.f.m;

public final class a extends d
{

    public String a;

    public a()
    {
        setStyle(1, 0x7f0c0181);
    }

    static String a(a a1)
    {
        return a1.a;
    }

    public final void onCancel(DialogInterface dialoginterface)
    {
        super.onCancel(dialoginterface);
        if (getActivity() != null)
        {
            getActivity().finish();
        }
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        int i;
        int j;
        j = 1;
        if (getResources().getConfiguration().orientation == 2)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        switch (getResources().getConfiguration().screenLayout & 0xf)
        {
        default:
            j = 0;
            break;

        case 2: // '\002'
            break MISSING_BLOCK_LABEL_147;

        case 3: // '\003'
        case 4: // '\004'
            break;
        }
_L1:
        if (j != 0)
        {
            i = 0x7f03006c;
        } else
        {
            i = 0x7f03006d;
        }
        layoutinflater = layoutinflater.inflate(i, viewgroup, false);
        m.b(layoutinflater).setText(getActivity().getResources().getString(0x7f0802a5));
        viewgroup = new android.view.View.OnClickListener() {

            private a a;

            public final void onClick(View view)
            {
                switch (view.getId())
                {
                default:
                    return;

                case 2131755666: 
                    AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.MainMenuCollageItemClickEvent(a.a(a), "grid"));
                    view = (StudioActivity)a.getActivity();
                    String s = a.a(a);
                    AnalyticUtils.getInstance(view).trackLocalAction("start:collage_grid");
                    Intent intent = new Intent(view, com/picsart/collages/SelectCollageActivity);
                    intent.putExtra("readFrom", "custom_template_square.json");
                    intent.putExtra("session_id", s);
                    view.startActivityForResult(intent, 1013);
                    return;

                case 2131755667: 
                    AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.MainMenuCollageItemClickEvent(a.a(a), "frame"));
                    ((StudioActivity)a.getActivity()).a();
                    return;

                case 2131755668: 
                    AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.MainMenuCollageItemClickEvent(a.a(a), "background"));
                    break;
                }
                view = (StudioActivity)a.getActivity();
                AnalyticUtils.getInstance(view).trackLocalAction("start:collage_bg");
                view.startActivityForResult(new Intent(view, com/socialin/android/photo/collage/SelectCollageBgActivity), 109);
            }

            
            {
                a = a.this;
                super();
            }
        };
        layoutinflater.findViewById(0x7f100292).setOnClickListener(viewgroup);
        layoutinflater.findViewById(0x7f100293).setOnClickListener(viewgroup);
        layoutinflater.findViewById(0x7f100294).setOnClickListener(viewgroup);
        return layoutinflater;
        j = i;
          goto _L1
    }
}
