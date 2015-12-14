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
import com.socialin.android.share.SaveExportActivity;
import java.io.File;
import myobfuscated.f.m;

public final class a extends d
{

    public ProgressBar a;
    protected Button b;
    protected android.view.View.OnClickListener c;
    private String d;
    private TextView e;
    private View f;
    private Button g;
    private String h;
    private ProjectVideoGenerator.GifOptions i;

    public a()
    {
    }

    public static transient a a()
    {
        a a1 = new a();
        a1.setArguments(new Bundle());
        return a1;
    }

    static String a(a a1)
    {
        return a1.d;
    }

    public final void a(ProjectVideoGenerator.GifOptions gifoptions)
    {
        i = gifoptions;
        e.setText(0x7f08037e);
        g.setVisibility(0);
        b.setText(0x7f080311);
        b.setOnClickListener(new android.view.View.OnClickListener() {

            private a a;

            public final void onClick(View view)
            {
                a.dismiss();
            }

            
            {
                a = a.this;
                super();
            }
        });
        g.setOnClickListener(new android.view.View.OnClickListener(gifoptions) {

            private ProjectVideoGenerator.GifOptions a;
            private a b;

            public final void onClick(View view)
            {
                view = new Intent();
                view.setAction("android.intent.action.VIEW");
                view.setDataAndType(Uri.fromFile(new File(a.getOutputPath())), "image/gif");
                b.startActivity(view);
            }

            
            {
                b = a.this;
                a = gifoptions;
                super();
            }
        });
        f.setVisibility(0);
        f.setOnClickListener(new android.view.View.OnClickListener(gifoptions) {

            private ProjectVideoGenerator.GifOptions a;
            private a b;

            public final void onClick(View view)
            {
                android.app.Activity activity = b.getActivity();
                if (a.a(b) != null && a.a(b).contains("SaveExport"))
                {
                    view = com/socialin/android/share/SaveExportActivity;
                } else
                {
                    view = com/socialin/android/exporter/SaveAndShareActivity;
                }
                view = new Intent(activity, view);
                view.putExtra("gifPath", a.getOutputPath());
                view.putExtra("videoAndGif", true);
                view.putExtra("gifDelay", a.getDelay() / 100D);
                view.putExtra("gifDir", a.getOutputDir());
                view.putExtra("gifName", a.getOutputName());
                view.putExtra("draw_export_video_uid", a.getmUid());
                if (android.os.Build.VERSION.SDK_INT >= 18)
                {
                    view.putExtra("gifVideoPath", a.setupGifToVideoPathAndGet());
                }
                b.startActivity(view);
            }

            
            {
                b = a.this;
                a = gifoptions;
                super();
            }
        });
    }

    public final void a(String s, android.view.View.OnClickListener onclicklistener)
    {
        c = onclicklistener;
        h = s;
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
        layoutinflater = layoutinflater.inflate(0x7f03012a, viewgroup, false);
        m.b(layoutinflater).setText(0x7f08037a);
        a = (ProgressBar)layoutinflater.findViewById(0x7f1003fd);
        e = (TextView)layoutinflater.findViewById(0x7f1003fc);
        b = (Button)layoutinflater.findViewById(0x7f100380);
        g = (Button)layoutinflater.findViewById(0x7f100648);
        f = layoutinflater.findViewById(0x7f100647);
        b.setOnClickListener(c);
        b.setText(h);
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
            ProjectVideoGenerator.GifOptions gifoptions = (ProjectVideoGenerator.GifOptions)getArguments().getSerializable("MODEL");
            if (gifoptions != null)
            {
                a(gifoptions);
            }
        }
        getDialog().setOnKeyListener(new android.content.DialogInterface.OnKeyListener() {

            private a a;

            public final boolean onKey(DialogInterface dialoginterface, int j, KeyEvent keyevent)
            {
                if (j == 4)
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
                a = a.this;
                super();
            }
        });
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (i != null)
        {
            bundle.putSerializable("gifOptions", i);
            bundle.putString("gifPath", i.getOutputPath());
            bundle.putDouble("gifDelay", i.getDelay());
            bundle.putInt("gifQual", i.getQuality());
            if (android.os.Build.VERSION.SDK_INT >= 18)
            {
                bundle.putString("vidgifPath", i.setupGifToVideoPathAndGet());
            }
        }
        if (d != null)
        {
            bundle.putString("sendingClass", d);
        }
    }

    public final void onViewStateRestored(Bundle bundle)
    {
        super.onViewStateRestored(bundle);
        if (bundle != null)
        {
            i = new ProjectVideoGenerator.GifOptions(bundle.getDouble("gifDelay"), bundle.getInt("gifQual"), bundle.getString("gifPath"));
            a(i);
            d = bundle.getString("sendingClass", null);
        }
    }
}
