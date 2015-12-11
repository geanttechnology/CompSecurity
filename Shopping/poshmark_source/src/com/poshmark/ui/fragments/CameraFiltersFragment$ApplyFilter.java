// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.poshmark.image_processing.ImageEffects;
import com.poshmark.ui.customviews.PMListingImageView;

// Referenced classes of package com.poshmark.ui.fragments:
//            CameraFiltersFragment

private class <init> extends AsyncTask
    implements TraceFieldInterface
{

    public Trace _nr_trace;
    final CameraFiltersFragment this$0;

    public void _nr_setTrace(Trace trace)
    {
        try
        {
            _nr_trace = trace;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Trace trace)
        {
            return;
        }
    }

    protected transient Drawable doInBackground(String as[])
    {
        Object obj;
        _nr_trace _lnr_trace;
        obj = null;
        _lnr_trace = alueOf(as[0]);
        if (_lnr_trace != ILTER_TYPE_MODERN) goto _L2; else goto _L1
_L1:
        as = ImageEffects.applyOverlay(ImageEffects.adjustImage(ImageEffects.balanceColor(CameraFiltersFragment.access$300(CameraFiltersFragment.this), 1.0D, 1.0D, 1.3999999999999999D), 1.0F, 1.0F, 1.2F), "overlay_vignette_border_black_thick");
_L4:
        return new BitmapDrawable(getResources(), as);
_L2:
        if (_lnr_trace == ILTER_TYPE_VINTAGE)
        {
            as = ImageEffects.applyOverlay(ImageEffects.blendColor(ImageEffects.adjustImage(CameraFiltersFragment.access$300(CameraFiltersFragment.this), 1.0F, 1.0F, 1.2F), Color.argb(255, 247, 218, 174), android.graphics.lyFilter.this._fld0), "overlay_vignette_warm_border_black_thick");
        } else
        if (_lnr_trace == ILTER_TYPE_RETRO)
        {
            as = ImageEffects.applyOverlay(ImageEffects.balanceColor(CameraFiltersFragment.access$300(CameraFiltersFragment.this), 1.3999999999999999D, 1.3D, 1.0D), "overlay_border_black_thick");
        } else
        if (_lnr_trace == ILTER_TYPE_CHIC)
        {
            as = ImageEffects.applyOverlay(ImageEffects.applyOverlay(ImageEffects.adjustImage(ImageEffects.balanceColor(CameraFiltersFragment.access$300(CameraFiltersFragment.this), 1.2D, 1.0D, 0.69999999999999996D), 1.2F, 1.0F, 0.7F), "overlay_effect_lightleak"), "overlay_border_black_thick");
        } else
        if (_lnr_trace == ILTER_TYPE_STREET)
        {
            as = ImageEffects.applyOverlay(ImageEffects.adjustImage(CameraFiltersFragment.access$300(CameraFiltersFragment.this), 1.5F, 1.0F, 1.4F), "overlay_border_white_thick");
        } else
        {
            as = obj;
            if (_lnr_trace == ILTER_TYPE_CLASSIC)
            {
                as = ImageEffects.convertImageToGrayScale(CameraFiltersFragment.access$300(CameraFiltersFragment.this));
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        TraceMachine.enterMethod(_nr_trace, "CameraFiltersFragment$ApplyFilter#doInBackground", null);
_L1:
        aobj = doInBackground((String[])aobj);
        TraceMachine.exitMethod();
        TraceMachine.unloadTraceContext(this);
        return ((Object) (aobj));
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "CameraFiltersFragment$ApplyFilter#doInBackground", null);
          goto _L1
    }

    protected void onPostExecute(Drawable drawable)
    {
        filteredDrawable = drawable;
        imageView.setImageDrawable(filteredDrawable);
        hideProgressDialog();
    }

    protected volatile void onPostExecute(Object obj)
    {
        TraceMachine.enterMethod(_nr_trace, "CameraFiltersFragment$ApplyFilter#onPostExecute", null);
_L1:
        onPostExecute((Drawable)obj);
        TraceMachine.exitMethod();
        return;
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "CameraFiltersFragment$ApplyFilter#onPostExecute", null);
          goto _L1
    }

    protected void onPreExecute()
    {
        showProgressDialogWithMessage(getString(0x7f06009a));
    }

    private A()
    {
        this$0 = CameraFiltersFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
