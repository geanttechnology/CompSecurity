// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.aviary.android.feather.common.tracking.AviaryTracker;
import com.aviary.android.feather.common.utils.ApiHelper;
import com.aviary.android.feather.common.utils.os.AviaryAsyncTask;
import com.aviary.android.feather.headless.moa.Moa;
import com.aviary.android.feather.library.content.ToolEntry;
import com.aviary.android.feather.library.filters.EnhanceFilter;
import com.aviary.android.feather.library.filters.ToolLoaderFactory;
import com.aviary.android.feather.library.services.IAviaryController;
import com.aviary.android.feather.library.utils.BitmapUtils;
import com.aviary.android.feather.library.vo.EditToolResultVO;
import com.aviary.android.feather.library.vo.ToolActionVO;
import com.aviary.android.feather.sdk.widget.AviaryHighlightImageButton;
import java.util.HashMap;
import org.json.JSONException;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            AbstractOptionPanel

public class EnhanceEffectPanel extends AbstractOptionPanel
    implements com.aviary.android.feather.sdk.widget.AviaryHighlightImageButton.OnCheckedChangeListener
{
    class GenerateResultTask extends AviaryAsyncTask
    {

        ProgressDialog mProgress;
        final EnhanceEffectPanel this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            mLogger.info("GenerateResultTask::doInBackground", new Object[] {
                Boolean.valueOf(mIsRendering)
            });
            while (mIsRendering) ;
            return null;
        }

        protected volatile void doPostExecute(Object obj)
        {
            doPostExecute((Void)obj);
        }

        protected void doPostExecute(Void void1)
        {
            mLogger.info("GenerateResultTask::doPostExecute");
            if (getContext().getBaseActivity().isFinishing())
            {
                return;
            }
            if (mProgress.isShowing())
            {
                mProgress.dismiss();
            }
            onComplete(mPreview);
        }

        protected void doPreExecute()
        {
            mProgress.setTitle(getContext().getBaseContext().getString(com.aviary.android.feather.sdk.R.string.feather_loading_title));
            mProgress.setMessage(getContext().getBaseContext().getString(com.aviary.android.feather.sdk.R.string.feather_effect_loading_message));
            mProgress.setIndeterminate(true);
            mProgress.setCancelable(false);
            mProgress.show();
        }

        GenerateResultTask()
        {
            this$0 = EnhanceEffectPanel.this;
            super();
            mProgress = new ProgressDialog(getContext().getBaseContext());
        }
    }

    class RenderTask extends AviaryAsyncTask
    {

        String mError;
        volatile EnhanceFilter renderFilter;
        final EnhanceEffectPanel this$0;

        protected transient Bitmap doInBackground(com.aviary.android.feather.library.filters.EnhanceFilter.Types atypes[])
        {
            if (isCancelled())
            {
                atypes = null;
            } else
            {
                com.aviary.android.feather.library.filters.EnhanceFilter.Types types = atypes[0];
                renderFilter.setType(types);
                try
                {
                    atypes = renderFilter.execute(mBitmap, mPreview, 1, 1);
                    mEditResult.setActionList(renderFilter.getActions());
                    mEditResult.setToolAction(new ToolActionVO(types.name()));
                }
                // Misplaced declaration of an exception variable
                catch (com.aviary.android.feather.library.filters.EnhanceFilter.Types atypes[])
                {
                    atypes.printStackTrace();
                    mError = atypes.getMessage();
                    return null;
                }
                if (isCancelled())
                {
                    return null;
                }
            }
            return atypes;
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((com.aviary.android.feather.library.filters.EnhanceFilter.Types[])aobj);
        }

        protected void doPostExecute(Bitmap bitmap)
        {
            if (isActive()) goto _L2; else goto _L1
_L1:
            return;
_L2:
            onProgressEnd();
            if (isCancelled()) goto _L1; else goto _L3
_L3:
            if (bitmap == null) goto _L5; else goto _L4
_L4:
            Moa.notifyPixelsChanged(mPreview);
            onPreviewChanged(mPreview, false, true);
_L7:
            mIsRendering = false;
            mCurrentTask = null;
            return;
_L5:
            if (mError != null)
            {
                onGenericError(mError, 0x104000a, null);
            }
            if (true) goto _L7; else goto _L6
_L6:
        }

        protected volatile void doPostExecute(Object obj)
        {
            doPostExecute((Bitmap)obj);
        }

        protected void doPreExecute()
        {
            onProgressStart();
        }

        protected void onCancelled()
        {
            renderFilter.stop();
            super.onCancelled();
        }

        public RenderTask()
        {
            this$0 = EnhanceEffectPanel.this;
            super();
            renderFilter = (EnhanceFilter)ToolLoaderFactory.get(mFilterType);
            mError = null;
        }
    }


    boolean enableFastPreview;
    private AviaryHighlightImageButton mButton1;
    private AviaryHighlightImageButton mButton2;
    private AviaryHighlightImageButton mButton3;
    private AviaryHighlightImageButton mCurrent;
    private RenderTask mCurrentTask;
    private com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools mFilterType;
    volatile boolean mIsRendering;

    public EnhanceEffectPanel(IAviaryController iaviarycontroller, ToolEntry toolentry, com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools tools)
    {
        super(iaviarycontroller, toolentry);
        mIsRendering = false;
        enableFastPreview = false;
        mFilterType = tools;
    }

    private void buttonClick(String s, boolean flag)
    {
        com.aviary.android.feather.library.filters.EnhanceFilter.Types types;
        mLogger.info("buttonClick: %s, %b", new Object[] {
            s, Boolean.valueOf(flag)
        });
        types = com.aviary.android.feather.library.filters.EnhanceFilter.Types.HiDef;
        killCurrentTask();
        if (!"enhance_hi_def".equals(s)) goto _L2; else goto _L1
_L1:
        types = com.aviary.android.feather.library.filters.EnhanceFilter.Types.HiDef;
_L8:
        if (flag) goto _L4; else goto _L3
_L3:
        BitmapUtils.copy(mBitmap, mPreview);
        onPreviewChanged(mPreview, false, true);
        mEditResult.setActionList(null);
        mEditResult.setToolAction(null);
        mTrackingAttributes.clear();
        setIsChanged(false);
_L6:
        return;
_L2:
        if ("enhance_illuminate".equals(s))
        {
            types = com.aviary.android.feather.library.filters.EnhanceFilter.Types.Illuminate;
        } else
        if ("enhance_color_fix".equals(s))
        {
            types = com.aviary.android.feather.library.filters.EnhanceFilter.Types.ColorFix;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        setIsChanged(true);
        if (types == null) goto _L6; else goto _L5
_L5:
        mIsRendering = true;
        mCurrentTask = new RenderTask();
        mCurrentTask.execute(new com.aviary.android.feather.library.filters.EnhanceFilter.Types[] {
            types
        });
        mTrackingAttributes.put("name", types.name());
        getContext().getTracker().tagEvent("enhance: option_selected", new String[] {
            "name", types.name()
        });
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void killCurrentTask()
    {
        if (mCurrentTask != null)
        {
            synchronized (mCurrentTask)
            {
                mCurrentTask.cancel(true);
                mCurrentTask.renderFilter.stop();
                onProgressEnd();
            }
            mIsRendering = false;
            mCurrentTask = null;
        }
        return;
        exception;
        rendertask;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected ViewGroup generateOptionView(LayoutInflater layoutinflater, ViewGroup viewgroup)
    {
        return (ViewGroup)layoutinflater.inflate(com.aviary.android.feather.sdk.R.layout.aviary_panel_enhance, viewgroup, false);
    }

    public boolean isRendering()
    {
        return mIsRendering;
    }

    public void onActivate()
    {
        super.onActivate();
        mPreview = BitmapUtils.copy(mBitmap, android.graphics.Bitmap.Config.ARGB_8888);
        enableFastPreview = ApiHelper.fastPreviewEnabled();
        if (hasOptions())
        {
            String s = getOptions().getString("quick-stringValue");
            mLogger.log("stringValue: %s", new Object[] {
                s
            });
            if (s != null)
            {
                AviaryHighlightImageButton aviaryhighlightimagebutton = (AviaryHighlightImageButton)getOptionView().findViewWithTag(s);
                if (aviaryhighlightimagebutton != null)
                {
                    mLogger.log("button found: %s", new Object[] {
                        aviaryhighlightimagebutton
                    });
                    aviaryhighlightimagebutton.setChecked(true);
                    buttonClick(s, true);
                }
            }
        }
    }

    public boolean onBackPressed()
    {
        killCurrentTask();
        return super.onBackPressed();
    }

    public void onBitmapReplaced(Bitmap bitmap)
    {
        super.onBitmapReplaced(bitmap);
        if (isActive())
        {
            mButton1.setChecked(false);
            mButton2.setChecked(false);
            mButton3.setChecked(false);
        }
    }

    public boolean onCancel()
    {
        killCurrentTask();
        return super.onCancel();
    }

    public void onCancelled()
    {
        killCurrentTask();
        mIsRendering = false;
        super.onCancelled();
    }

    public void onCheckedChanged(AviaryHighlightImageButton aviaryhighlightimagebutton, boolean flag, boolean flag1)
    {
        mLogger.info("onCheckedChanged: %b, fromUser: %b", new Object[] {
            Boolean.valueOf(flag), Boolean.valueOf(flag1)
        });
        if (mCurrent != null && !aviaryhighlightimagebutton.equals(mCurrent))
        {
            mCurrent.setChecked(false);
        }
        mCurrent = aviaryhighlightimagebutton;
        if (!isActive() || !isEnabled() || !flag1)
        {
            return;
        } else
        {
            buttonClick((String)aviaryhighlightimagebutton.getTag(), flag);
            return;
        }
    }

    public void onCreate(Bitmap bitmap, Bundle bundle)
    {
        super.onCreate(bitmap, bundle);
        bitmap = getOptionView();
        mButton1 = (AviaryHighlightImageButton)bitmap.findViewById(com.aviary.android.feather.sdk.R.id.button1);
        mButton1.setOnCheckedChangeListener(this);
        if (mButton1.isChecked())
        {
            mCurrent = mButton1;
        }
        mButton2 = (AviaryHighlightImageButton)bitmap.findViewById(com.aviary.android.feather.sdk.R.id.button2);
        mButton2.setOnCheckedChangeListener(this);
        if (mButton2.isChecked())
        {
            mCurrent = mButton2;
        }
        mButton3 = (AviaryHighlightImageButton)bitmap.findViewById(com.aviary.android.feather.sdk.R.id.button3);
        mButton3.setOnCheckedChangeListener(this);
        if (mButton3.isChecked())
        {
            mCurrent = mButton3;
        }
    }

    public void onDeactivate()
    {
        super.onDeactivate();
        mButton1.setOnCheckedChangeListener(null);
        mButton2.setOnCheckedChangeListener(null);
        mButton3.setOnCheckedChangeListener(null);
    }

    protected void onGenerateResult()
    {
        if (mIsRendering)
        {
            (new GenerateResultTask()).execute(new Void[0]);
            return;
        } else
        {
            onComplete(mPreview);
            return;
        }
    }

    protected void onProgressEnd()
    {
        if (!enableFastPreview)
        {
            onProgressModalEnd();
            return;
        } else
        {
            super.onProgressEnd();
            return;
        }
    }

    protected void onProgressStart()
    {
        if (!enableFastPreview)
        {
            onProgressModalStart();
            return;
        } else
        {
            super.onProgressStart();
            return;
        }
    }

    public volatile void setEnabled(boolean flag)
    {
        super.setEnabled(flag);
    }



/*
    static RenderTask access$102(EnhanceEffectPanel enhanceeffectpanel, RenderTask rendertask)
    {
        enhanceeffectpanel.mCurrentTask = rendertask;
        return rendertask;
    }

*/
}
