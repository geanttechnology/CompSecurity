// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.ui;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.amazon.gallery.foundation.utils.apilevel.Api;

// Referenced classes of package com.amazon.gallery.framework.kindle.ui:
//            Indicator

public class LoadingSpinner extends Indicator
{

    private final ViewGroup layout;
    private final TextView loadingSpinnerTextView;
    private boolean showing;

    public LoadingSpinner(ViewGroup viewgroup)
    {
        showing = false;
        layout = viewgroup;
        loadingSpinnerTextView = (TextView)viewgroup.findViewById(0x7f0c0113);
        setSpinnerColor(layout.getResources().getColor(0x7f090004));
        hide();
    }

    private void hide()
    {
        showing = false;
        layout.setVisibility(8);
    }

    private void show()
    {
        showing = true;
        layout.setVisibility(0);
    }

    public TextView getTextView()
    {
        return loadingSpinnerTextView;
    }

    public View getView()
    {
        return layout;
    }

    public void setSpinnerColor(int i)
    {
        ProgressBar progressbar = (ProgressBar)layout.findViewById(0x7f0c0112);
        if (Api.isAtLeastLollipop())
        {
            progressbar.getIndeterminateDrawable().setTint(i);
            return;
        } else
        {
            progressbar.getIndeterminateDrawable().setColorFilter(i, android.graphics.PorterDuff.Mode.SRC_ATOP);
            return;
        }
    }

    public void showSpinner(boolean flag)
    {
        if (isEnabled())
        {
            if (flag && !showing)
            {
                show();
                return;
            }
            if (!flag && showing)
            {
                hide();
                return;
            }
        }
    }
}
