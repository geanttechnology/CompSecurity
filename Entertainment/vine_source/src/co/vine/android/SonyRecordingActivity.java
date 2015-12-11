// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import co.vine.android.util.CrashUtil;
import com.sonymobile.camera.addon.capturingmode.CapturingModeSelector;

// Referenced classes of package co.vine.android:
//            AbstractRecordingActivity, SonyRecordingFragment, RecordingFragment, VineLoggingException

public class SonyRecordingActivity extends AbstractRecordingActivity
{

    private CapturingModeSelector mSonyCapturingModeSelector;
    private int mSonyFilterColor;
    private String mSonyModeName;
    private ImageView mSonyModeSelectorButton;

    public SonyRecordingActivity()
    {
    }

    private void onHideSonyOverlay()
    {
        View view = findViewById(0x7f0a01be);
        View view1 = findViewById(0x7f0a01bb);
        View view2 = findViewById(0x7f0a00b2);
        if (view != null)
        {
            view.setVisibility(0);
        }
        if (view1 != null)
        {
            view1.setVisibility(0);
        }
        if (view2 != null)
        {
            view2.setVisibility(0);
        }
    }

    private void onShowSonyOverlay()
    {
        View view = findViewById(0x7f0a01be);
        View view1 = findViewById(0x7f0a01bb);
        View view2 = findViewById(0x7f0a00b2);
        if (view != null)
        {
            view.setVisibility(4);
        }
        if (view1 != null)
        {
            view1.setVisibility(4);
        }
        if (view2 != null)
        {
            view2.setVisibility(4);
        }
    }

    private void showSonyOverlay()
    {
        mSonyCapturingModeSelector.open(mSonyModeName);
        mSonyModeSelectorButton.setVisibility(4);
        mSonyModeSelectorButton.clearColorFilter();
        onShowSonyOverlay();
    }

    protected RecordingFragment createRecordingFragment()
    {
        return new SonyRecordingFragment();
    }

    public boolean isFromSony()
    {
        return true;
    }

    public void onBackPressed()
    {
        if (mSonyCapturingModeSelector != null && mSonyCapturingModeSelector.isOpened())
        {
            mSonyCapturingModeSelector.close();
            mSonyModeSelectorButton.setVisibility(0);
            onHideSonyOverlay();
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getResources();
        mSonyFilterColor = bundle.getColor(0x7f090084);
        mSonyModeName = bundle.getString(0x7f0e004e);
    }

    protected void onDestroy()
    {
        if (mSonyModeSelectorButton != null)
        {
            mSonyModeSelectorButton.setOnClickListener(null);
            mSonyModeSelectorButton.setOnTouchListener(null);
        }
        super.onDestroy();
    }

    public void onDialogDone(DialogInterface dialoginterface, int i, int j)
    {
        switch (i)
        {
        default:
            super.onDialogDone(dialoginterface, i, j);
            return;

        case 0: // '\0'
            switch (j)
            {
            default:
                if (currentlyHoldsRecordingFragment())
                {
                    ((RecordingFragment)mCurrentFragment).saveSession();
                }
                showSonyOverlay();
                return;

            case -3: 
            case -2: 
                break;
            }
            break;
        }
        if (currentlyHoldsRecordingFragment())
        {
            ((RecordingFragment)mCurrentFragment).setDiscardChangesOnStop();
        }
        discardUpload();
        showSonyOverlay();
    }

    protected void onPause()
    {
        if (mSonyCapturingModeSelector != null)
        {
            mSonyCapturingModeSelector.release();
            mSonyCapturingModeSelector = null;
        }
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        setupSonyOverlay();
    }

    public void setupSonyOverlay()
    {
        ViewGroup viewgroup = (ViewGroup)findViewById(0x7f0a01cd);
        mSonyModeSelectorButton = (ImageView)findViewById(0x7f0a01cb);
        if (mSonyModeSelectorButton == null || viewgroup == null)
        {
            return;
        }
        mSonyModeSelectorButton.setVisibility(0);
        mSonyModeSelectorButton.setOnClickListener(new android.view.View.OnClickListener() {

            final SonyRecordingActivity this$0;

            public void onClick(View view)
            {
                boolean flag;
label0:
                {
                    if (mSonyCapturingModeSelector != null)
                    {
                        view = (RecordingFragment)mCurrentFragment;
                        if (view != null)
                        {
                            flag = view.isEditing();
                            if (flag || view.isSessionModified())
                            {
                                break label0;
                            }
                            view.setDiscardChangesOnStop();
                            showSonyOverlay();
                        }
                    }
                    return;
                }
                if (flag && !view.isEditingDirty())
                {
                    view.discardEditing();
                    showSonyOverlay();
                    return;
                } else
                {
                    showUnSavedChangesDialog(0, view);
                    return;
                }
            }

            
            {
                this$0 = SonyRecordingActivity.this;
                super();
            }
        });
        mSonyModeSelectorButton.setOnTouchListener(new android.view.View.OnTouchListener() {

            final SonyRecordingActivity this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                mSonyModeSelectorButton.onTouchEvent(motionevent);
                if (mSonyModeSelectorButton.isPressed())
                {
                    mSonyModeSelectorButton.setColorFilter(mSonyFilterColor);
                } else
                {
                    mSonyModeSelectorButton.clearColorFilter();
                }
                return true;
            }

            
            {
                this$0 = SonyRecordingActivity.this;
                super();
            }
        });
        try
        {
            mSonyCapturingModeSelector = new CapturingModeSelector(this, viewgroup);
        }
        catch (NoClassDefFoundError noclassdeffounderror)
        {
            CrashUtil.logException(new VineLoggingException("Unable to create Sony Capture Mode selector."));
        }
        if (mSonyCapturingModeSelector != null)
        {
            mSonyCapturingModeSelector.setOnModeSelectListener(new com.sonymobile.camera.addon.capturingmode.CapturingModeSelector.OnModeSelectListener() {

                final SonyRecordingActivity this$0;

                public void onModeSelect(String s)
                {
                    if (mSonyCapturingModeSelector != null)
                    {
                        mSonyCapturingModeSelector.close();
                    }
                    finish();
                }

            
            {
                this$0 = SonyRecordingActivity.this;
                super();
            }
            });
            mSonyCapturingModeSelector.setOnModeFinishListener(new com.sonymobile.camera.addon.capturingmode.CapturingModeSelector.OnModeFinishListener() {

                final SonyRecordingActivity this$0;

                public void onModeFinish()
                {
                    if (mSonyCapturingModeSelector != null)
                    {
                        mSonyCapturingModeSelector.close();
                        mSonyModeSelectorButton.setVisibility(0);
                    }
                }

            
            {
                this$0 = SonyRecordingActivity.this;
                super();
            }
            });
            mSonyModeSelectorButton.setVisibility(0);
            return;
        } else
        {
            mSonyModeSelectorButton.setVisibility(8);
            return;
        }
    }




}
