// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzx;

public final class SignInButton extends FrameLayout
    implements android.view.View.OnClickListener
{

    public static final int COLOR_DARK = 0;
    public static final int COLOR_LIGHT = 1;
    public static final int SIZE_ICON_ONLY = 2;
    public static final int SIZE_STANDARD = 0;
    public static final int SIZE_WIDE = 1;
    private int mColor;
    private int mSize;
    private View zzaat;
    private android.view.View.OnClickListener zzaau;

    public SignInButton(Context context)
    {
        this(context, null);
    }

    public SignInButton(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public SignInButton(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        zzaau = null;
        setStyle(0, 0);
    }

    private static Button zza(Context context, int i, int j)
    {
        zzab zzab1 = new zzab(context);
        zzab1.zza(context.getResources(), i, j);
        return zzab1;
    }

    private void zzai(Context context)
    {
        if (zzaat != null)
        {
            removeView(zzaat);
        }
        try
        {
            zzaat = zzaa.zzb(context, mSize, mColor);
        }
        catch (com.google.android.gms.dynamic.zzg.zza zza1)
        {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            zzaat = zza(context, mSize, mColor);
        }
        addView(zzaat);
        zzaat.setEnabled(isEnabled());
        zzaat.setOnClickListener(this);
    }

    public final void onClick(View view)
    {
        if (zzaau != null && view == zzaat)
        {
            zzaau.onClick(this);
        }
    }

    public final void setColorScheme(int i)
    {
        setStyle(mSize, i);
    }

    public final void setEnabled(boolean flag)
    {
        super.setEnabled(flag);
        zzaat.setEnabled(flag);
    }

    public final void setOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        zzaau = onclicklistener;
        if (zzaat != null)
        {
            zzaat.setOnClickListener(this);
        }
    }

    public final void setSize(int i)
    {
        setStyle(i, mColor);
    }

    public final void setStyle(int i, int j)
    {
        boolean flag;
        if (i >= 0 && i < 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Unknown button size %d", new Object[] {
            Integer.valueOf(i)
        });
        if (j >= 0 && j < 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Unknown color scheme %s", new Object[] {
            Integer.valueOf(j)
        });
        mSize = i;
        mColor = j;
        zzai(getContext());
    }
}
