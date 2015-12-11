// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.wishabi.flipp.content.FormattedString;

// Referenced classes of package com.wishabi.flipp.app:
//            dp, fo

public final class fn extends dp
{

    private FormattedString b;
    private int c;
    private int d;

    public fn()
    {
    }

    public static fn a(FormattedString formattedstring, int i, int j)
    {
        Bundle bundle = new Bundle();
        bundle.putParcelable("SAVE_STATE_DESCRIPTION_KEY", formattedstring);
        bundle.putInt("SAVE_STATE_IMAGE_ID_KEY", i);
        bundle.putInt("SAVE_STATE_BACKGROUND_RES_ID_KEY", j);
        formattedstring = new fn();
        formattedstring.setArguments(bundle);
        return formattedstring;
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Bundle bundle1 = bundle;
        if (bundle == null)
        {
            bundle1 = getArguments();
        }
        if (bundle1 == null)
        {
            b = null;
            c = 0;
            d = 0;
            return;
        } else
        {
            b = (FormattedString)bundle1.getParcelable("SAVE_STATE_DESCRIPTION_KEY");
            c = bundle1.getInt("SAVE_STATE_IMAGE_ID_KEY");
            d = bundle1.getInt("SAVE_STATE_BACKGROUND_RES_ID_KEY");
            return;
        }
    }

    public final Dialog onCreateDialog(Bundle bundle)
    {
        bundle = super.onCreateDialog(bundle);
        bundle.getWindow().requestFeature(1);
        if (d != 0)
        {
            bundle.getWindow().setBackgroundDrawableResource(d);
        }
        return bundle;
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        if (getActivity() != null)
        {
            if ((layoutinflater = layoutinflater.inflate(0x7f030054, viewgroup, false)) != null)
            {
                viewgroup = (TextView)layoutinflater.findViewById(0x7f0b0146);
                if (b != null)
                {
                    viewgroup.setText(b.a());
                }
                viewgroup = (ImageView)layoutinflater.findViewById(0x7f0b0145);
                if (c != 0)
                {
                    viewgroup.setImageResource(c);
                }
                ((TextView)layoutinflater.findViewById(0x7f0b0147)).setOnClickListener(new fo(this));
                return layoutinflater;
            }
        }
        return null;
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("SAVE_STATE_DESCRIPTION_KEY", b);
        bundle.putInt("SAVE_STATE_IMAGE_ID_KEY", c);
        bundle.putInt("SAVE_STATE_BACKGROUND_RES_ID_KEY", d);
    }
}
