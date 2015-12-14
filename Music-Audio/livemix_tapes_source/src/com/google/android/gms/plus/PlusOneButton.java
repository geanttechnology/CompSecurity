// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.zzae;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.plus.internal.zzg;

public final class PlusOneButton extends FrameLayout
{
    protected class DefaultOnPlusOneClickListener
        implements android.view.View.OnClickListener, OnPlusOneClickListener
    {

        private final OnPlusOneClickListener zzaLk;
        final PlusOneButton zzaLl;

        public void onClick(View view)
        {
            view = (Intent)PlusOneButton.zza(zzaLl).getTag();
            if (zzaLk != null)
            {
                zzaLk.onPlusOneClick(view);
                return;
            } else
            {
                onPlusOneClick(view);
                return;
            }
        }

        public void onPlusOneClick(Intent intent)
        {
            Context context = zzaLl.getContext();
            if ((context instanceof Activity) && intent != null)
            {
                ((Activity)context).startActivityForResult(intent, PlusOneButton.zzb(zzaLl));
            }
        }

        public DefaultOnPlusOneClickListener(OnPlusOneClickListener onplusoneclicklistener)
        {
            zzaLl = PlusOneButton.this;
            super();
            zzaLk = onplusoneclicklistener;
        }
    }

    public static interface OnPlusOneClickListener
    {

        public abstract void onPlusOneClick(Intent intent);
    }


    public static final int ANNOTATION_BUBBLE = 1;
    public static final int ANNOTATION_INLINE = 2;
    public static final int ANNOTATION_NONE = 0;
    public static final int DEFAULT_ACTIVITY_REQUEST_CODE = -1;
    public static final int SIZE_MEDIUM = 1;
    public static final int SIZE_SMALL = 0;
    public static final int SIZE_STANDARD = 3;
    public static final int SIZE_TALL = 2;
    private int mSize;
    private String zzF;
    private View zzaLg;
    private int zzaLh;
    private int zzaLi;
    private OnPlusOneClickListener zzaLj;

    public PlusOneButton(Context context)
    {
        this(context, null);
    }

    public PlusOneButton(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mSize = getSize(context, attributeset);
        zzaLh = getAnnotation(context, attributeset);
        zzaLi = -1;
        zzah(getContext());
        if (!isInEditMode());
    }

    protected static int getAnnotation(Context context, AttributeSet attributeset)
    {
        byte byte0 = 0;
        context = zzae.zza("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "annotation", context, attributeset, true, false, "PlusOneButton");
        if ("INLINE".equalsIgnoreCase(context))
        {
            byte0 = 2;
        } else
        if (!"NONE".equalsIgnoreCase(context))
        {
            return 1;
        }
        return byte0;
    }

    protected static int getSize(Context context, AttributeSet attributeset)
    {
        context = zzae.zza("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "size", context, attributeset, true, false, "PlusOneButton");
        if ("SMALL".equalsIgnoreCase(context))
        {
            return 0;
        }
        if ("MEDIUM".equalsIgnoreCase(context))
        {
            return 1;
        }
        return !"TALL".equalsIgnoreCase(context) ? 3 : 2;
    }

    static View zza(PlusOneButton plusonebutton)
    {
        return plusonebutton.zzaLg;
    }

    private void zzah(Context context)
    {
        if (zzaLg != null)
        {
            removeView(zzaLg);
        }
        zzaLg = zzg.zza(context, mSize, zzaLh, zzF, zzaLi);
        setOnPlusOneClickListener(zzaLj);
        addView(zzaLg);
    }

    static int zzb(PlusOneButton plusonebutton)
    {
        return plusonebutton.zzaLi;
    }

    public void initialize(String s, int i)
    {
        zzx.zza(getContext() instanceof Activity, "To use this method, the PlusOneButton must be placed in an Activity. Use initialize(String, OnPlusOneClickListener).");
        zzF = s;
        zzaLi = i;
        zzah(getContext());
    }

    public void initialize(String s, OnPlusOneClickListener onplusoneclicklistener)
    {
        zzF = s;
        zzaLi = 0;
        zzah(getContext());
        setOnPlusOneClickListener(onplusoneclicklistener);
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        zzaLg.layout(0, 0, k - i, l - j);
    }

    protected void onMeasure(int i, int j)
    {
        View view = zzaLg;
        measureChild(view, i, j);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void plusOneClick()
    {
        zzaLg.performClick();
    }

    public void setAnnotation(int i)
    {
        zzaLh = i;
        zzah(getContext());
    }

    public void setIntent(Intent intent)
    {
        zzaLg.setTag(intent);
    }

    public void setOnPlusOneClickListener(OnPlusOneClickListener onplusoneclicklistener)
    {
        zzaLj = onplusoneclicklistener;
        zzaLg.setOnClickListener(new DefaultOnPlusOneClickListener(onplusoneclicklistener));
    }

    public void setSize(int i)
    {
        mSize = i;
        zzah(getContext());
    }
}
