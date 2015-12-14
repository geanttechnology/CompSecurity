// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw.dialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.picsart.studio.DrawingGalleryActivity;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.dialog.d;
import com.socialin.android.photo.collage.SelectCollageBgActivity;
import com.socialin.android.photo.picsinphoto.StudioActivity;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.photo.draw.dialog:
//            SelectCanvasSizeDialog

public final class b extends d
{

    public String a;

    public b()
    {
        setStyle(1, 0x7f0c0181);
    }

    static String a(b b1)
    {
        return b1.a;
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
            i = 0;
            break;

        case 2: // '\002'
        case 3: // '\003'
            break;

        case 4: // '\004'
            break MISSING_BLOCK_LABEL_170;
        }
_L1:
        if (i != 0)
        {
            i = 0x7f0300b4;
        } else
        {
            i = 0x7f0300b5;
        }
        layoutinflater = layoutinflater.inflate(i, viewgroup, false);
        m.b(layoutinflater).setText(getActivity().getResources().getString(0x7f0802bb));
        viewgroup = new android.view.View.OnClickListener() {

            private b a;

            public final void onClick(View view)
            {
                view.getId();
                JVM INSTR tableswitch 2131755990 2131755993: default 36
            //                           2131755990 37
            //                           2131755991 114
            //                           2131755992 172
            //                           2131755993 251;
                   goto _L1 _L2 _L3 _L4 _L5
_L1:
                return;
_L2:
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.MainMenuDrawItemClickEvent(b.a(a), "blank"));
                view = (StudioActivity)a.getActivity();
                if (!view.isFinishing())
                {
                    AnalyticUtils.getInstance(view).trackLocalAction("start:draw_simple");
                    SelectCanvasSizeDialog.a(new com.socialin.android.photo.picsinphoto.StudioActivity._cls6(view)).show(view.getFragmentManager(), "select.canvas.size.dialog");
                    return;
                }
                  goto _L1
_L3:
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.MainMenuDrawItemClickEvent(b.a(a), "photo"));
                view = (StudioActivity)a.getActivity();
                AnalyticUtils.getInstance(view).trackLocalAction("start:draw_on_photo");
                view.a(107, "draw");
                return;
_L4:
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.MainMenuDrawItemClickEvent(b.a(a), "background"));
                view = (StudioActivity)a.getActivity();
                AnalyticUtils.getInstance(view).trackLocalAction("start:draw_bg");
                Intent intent = new Intent(view, com/socialin/android/photo/collage/SelectCollageBgActivity);
                intent.putExtra("extra.mode", com.socialin.android.photo.collage.SelectCollageBgActivity.Mode.DRAWING);
                view.startActivityForResult(intent, 1012);
                return;
_L5:
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.MainMenuDrawItemClickEvent(b.a(a), "draft"));
                view = (StudioActivity)a.getActivity();
                view.startActivityForResult(new Intent(view, com/picsart/studio/DrawingGalleryActivity), 0);
                return;
            }

            
            {
                a = b.this;
                super();
            }
        };
        layoutinflater.findViewById(0x7f1003d6).setOnClickListener(viewgroup);
        layoutinflater.findViewById(0x7f1003d7).setOnClickListener(viewgroup);
        layoutinflater.findViewById(0x7f1003d8).setOnClickListener(viewgroup);
        layoutinflater.findViewById(0x7f1003d9).setOnClickListener(viewgroup);
        layoutinflater.findViewById(0x7f1003d6).setOnLongClickListener(new android.view.View.OnLongClickListener() {

            private b a;

            public final boolean onLongClick(View view)
            {
                view = SelectCanvasSizeDialog.a(a.getActivity());
                ((StudioActivity)a.getActivity()).a(((Point) (view)).x, ((Point) (view)).y);
                return true;
            }

            
            {
                a = b.this;
                super();
            }
        });
        return layoutinflater;
        i = 1;
          goto _L1
    }
}
