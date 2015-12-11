// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

// Referenced classes of package com.wishabi.flipp.app:
//            dl, fs, ft

public final class fr extends dl
{

    private VideoView a;
    private ProgressBar c;
    private TextView d;
    private MediaController e;
    private String f;
    private String g;

    public fr()
    {
    }

    public static Bundle a(String s, String s1)
    {
        Bundle bundle = new Bundle();
        bundle.putString("SAVE_STATE_TITLE_KEY", s);
        bundle.putString("SAVE_STATE_URL_KEY", s1);
        return bundle;
    }

    static ProgressBar a(fr fr1)
    {
        return fr1.c;
    }

    public static fr a(Bundle bundle)
    {
        fr fr1 = new fr();
        fr1.setArguments(bundle);
        return fr1;
    }

    static TextView b(fr fr1)
    {
        return fr1.d;
    }

    static MediaController c(fr fr1)
    {
        return fr1.e;
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle == null)
        {
            bundle = getArguments();
        }
        if (bundle != null)
        {
            f = bundle.getString("SAVE_STATE_TITLE_KEY");
            g = bundle.getString("SAVE_STATE_URL_KEY");
        }
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        android.app.Activity activity = getActivity();
        if (activity == null)
        {
            return super.onCreateView(layoutinflater, viewgroup, bundle);
        }
        View view = layoutinflater.inflate(0x7f030055, viewgroup, false);
        if (view == null)
        {
            return super.onCreateView(layoutinflater, viewgroup, bundle);
        } else
        {
            a = (VideoView)view.findViewById(0x7f0b0148);
            c = (ProgressBar)view.findViewById(0x7f0b0149);
            d = (TextView)view.findViewById(0x7f0b014a);
            e = new MediaController(activity);
            a.setMediaController(e);
            a.setOnPreparedListener(new fs(this));
            view.setOnTouchListener(new ft(this));
            return view;
        }
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("SAVE_STATE_TITLE_KEY", f);
        bundle.putString("SAVE_STATE_URL_KEY", g);
    }

    public final void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        a.setVideoURI(Uri.parse(g));
        a.start();
        b(f);
    }
}
