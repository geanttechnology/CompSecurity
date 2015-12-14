// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.videogenerator;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.socialin.android.dialog.d;
import com.socialin.android.exporter.SaveAndShareActivity;
import java.io.File;
import myobfuscated.f.m;

public final class f extends d
{

    public ProgressBar a;
    protected Button b;
    protected android.view.View.OnClickListener c;
    private TextView d;
    private View e;
    private Button f;
    private String g;
    private ProjectVideoGenerator.VideoOptions h;

    public f()
    {
    }

    public static transient f a()
    {
        f f1 = new f();
        f1.setArguments(new Bundle());
        return f1;
    }

    public final void a(ProjectVideoGenerator.VideoOptions videooptions)
    {
        h = videooptions;
        d.setText(0x7f08066d);
        f.setVisibility(0);
        b.setText(0x7f080311);
        b.setOnClickListener(new android.view.View.OnClickListener() {

            private f a;

            public final void onClick(View view)
            {
                a.dismiss();
            }

            
            {
                a = f.this;
                super();
            }
        });
        f.setOnClickListener(new android.view.View.OnClickListener(videooptions) {

            private ProjectVideoGenerator.VideoOptions a;
            private f b;

            public final void onClick(View view)
            {
                view = new Intent();
                view.setAction("android.intent.action.VIEW");
                view.setDataAndType(Uri.fromFile(new File(a.getOutputPath())), "video/*");
                b.startActivity(view);
            }

            
            {
                b = f.this;
                a = videooptions;
                super();
            }
        });
        e.setVisibility(0);
        e.setOnClickListener(new android.view.View.OnClickListener(videooptions) {

            private ProjectVideoGenerator.VideoOptions a;
            private f b;

            public final void onClick(View view)
            {
                view = new Intent(b.getActivity(), com/socialin/android/exporter/SaveAndShareActivity);
                view.putExtra("vidPath", a.getOutputPath());
                view.putExtra("videoAndGif", true);
                view.putExtra("vidDur", a.getDuration());
                view.putExtra("draw_export_video_uid", a.getmUid());
                if (a.getFormat() == ProjectVideoGenerator.VideoFormat.mp4)
                {
                    view.putExtra("videoMP4", true);
                }
                b.startActivity(view);
            }

            
            {
                b = f.this;
                a = videooptions;
                super();
            }
        });
    }

    public final void a(String s, android.view.View.OnClickListener onclicklistener)
    {
        c = onclicklistener;
        g = s;
    }

    public final void onCreate(Bundle bundle)
    {
        setRetainInstance(true);
        super.onCreate(bundle);
        setStyle(0, 0x7f0c0181);
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        getDialog().setCanceledOnTouchOutside(true);
        layoutinflater = layoutinflater.inflate(0x7f030268, viewgroup, false);
        m.b(layoutinflater).setText(0x7f08066a);
        a = (ProgressBar)layoutinflater.findViewById(0x7f1003fd);
        d = (TextView)layoutinflater.findViewById(0x7f1003fc);
        b = (Button)layoutinflater.findViewById(0x7f100380);
        f = (Button)layoutinflater.findViewById(0x7f100648);
        e = layoutinflater.findViewById(0x7f100647);
        if (c == null)
        {
            c = new android.view.View.OnClickListener() {

                private f a;

                public final void onClick(View view)
                {
                    a.dismiss();
                }

            
            {
                a = f.this;
                super();
            }
            };
        }
        b.setOnClickListener(c);
        b.setText(g);
        return layoutinflater;
    }

    public final void onDestroyView()
    {
        if (getDialog() != null && getRetainInstance())
        {
            getDialog().setDismissMessage(null);
        }
        super.onDestroyView();
    }

    public final void onDismiss(DialogInterface dialoginterface)
    {
        super.onDismiss(dialoginterface);
    }

    public final void onResume()
    {
        super.onResume();
        if (getArguments() != null && getArguments().getSerializable("MODEL") != null)
        {
            ProjectVideoGenerator.VideoOptions videooptions = (ProjectVideoGenerator.VideoOptions)getArguments().getSerializable("MODEL");
            if (videooptions != null)
            {
                a(videooptions);
            }
        }
        getDialog().setOnKeyListener(new android.content.DialogInterface.OnKeyListener() {

            private f a;

            public final boolean onKey(DialogInterface dialoginterface, int i, KeyEvent keyevent)
            {
                if (i == 4)
                {
                    if (a.c != null)
                    {
                        a.c.onClick(a.b);
                    }
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                a = f.this;
                super();
            }
        });
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        if (h != null)
        {
            bundle.putString("vidPath", h.getOutputPath());
            bundle.putInt("vidDur", h.getDuration());
            bundle.putFloat("vidQual", h.getQuality());
        }
        super.onSaveInstanceState(bundle);
    }

    public final void onViewStateRestored(Bundle bundle)
    {
        super.onViewStateRestored(bundle);
        if (bundle != null)
        {
            h = new ProjectVideoGenerator.VideoOptions(0, bundle.getFloat("vidQual"), bundle.getInt("vidDur"), bundle.getString("vidPath"), null, null, null);
            a(h);
        }
    }
}
