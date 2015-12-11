// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.shopapp.voice.search.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import com.amazon.shopapp.voice.metrics.VoiceSearchMetricsRecorder;
import com.amazon.shopapp.voice.module.KeyboardModeListener;
import com.amazon.shopapp.voice.module.VoiceContext;
import com.amazon.shopapp.voice.module.VoiceInitSettings;
import com.amazon.shopapp.voice.module.VoiceSearchActionListener;
import com.amazon.shopapp.voice.search.VoiceResult;
import com.amazon.shopapp.voice.search.VoiceSearchController;
import java.util.List;

// Referenced classes of package com.amazon.shopapp.voice.search.ui:
//            SpeechPanel, VSModalButton, ViewUtil, WaveformView

public class VoiceSearchDialog
    implements android.view.View.OnClickListener
{
    public static final class DialogState extends Enum
    {

        private static final DialogState $VALUES[];
        public static final DialogState DISAMBIGUATION;
        public static final DialogState INVALID_TIME;
        public static final DialogState LOADING;
        public static final DialogState LOW_CONFIDENCE;
        public static final DialogState NEGATIVE_RESULT;
        public static final DialogState NETWORK_ERROR;
        public static final DialogState NONE;
        public static final DialogState NO_SPEECH;
        public static final DialogState PROCESSING;
        public static final DialogState SEARCH;

        public static DialogState valueOf(String s)
        {
            return (DialogState)Enum.valueOf(com/amazon/shopapp/voice/search/ui/VoiceSearchDialog$DialogState, s);
        }

        public static DialogState[] values()
        {
            return (DialogState[])$VALUES.clone();
        }

        static 
        {
            NONE = new DialogState("NONE", 0);
            LOADING = new DialogState("LOADING", 1);
            SEARCH = new DialogState("SEARCH", 2);
            PROCESSING = new DialogState("PROCESSING", 3);
            DISAMBIGUATION = new DialogState("DISAMBIGUATION", 4);
            LOW_CONFIDENCE = new DialogState("LOW_CONFIDENCE", 5);
            NO_SPEECH = new DialogState("NO_SPEECH", 6);
            NEGATIVE_RESULT = new DialogState("NEGATIVE_RESULT", 7);
            NETWORK_ERROR = new DialogState("NETWORK_ERROR", 8);
            INVALID_TIME = new DialogState("INVALID_TIME", 9);
            $VALUES = (new DialogState[] {
                NONE, LOADING, SEARCH, PROCESSING, DISAMBIGUATION, LOW_CONFIDENCE, NO_SPEECH, NEGATIVE_RESULT, NETWORK_ERROR, INVALID_TIME
            });
        }

        private DialogState(String s, int i)
        {
            super(s, i);
        }
    }


    private static final int MAX_INTERPRETATIONS = 100;
    private static final String TAG = com/amazon/shopapp/voice/search/ui/VoiceSearchDialog.getSimpleName();
    private View mContainer;
    private ImageView mIcon;
    private View mSpeakBar;
    private DialogState mState;
    private TextSwitcher mTitle;
    private final VoiceSearchController mVoiceSearchController;
    private WaveformView mWaveform;

    public VoiceSearchDialog(VoiceSearchController voicesearchcontroller)
    {
        mState = DialogState.NONE;
        mVoiceSearchController = voicesearchcontroller;
    }

    private void closeDialog()
    {
        try
        {
            if (VoiceContext.isDebug())
            {
                Log.d(TAG, "closeDialog");
            }
            mState = DialogState.NONE;
            mWaveform = null;
            tryDismiss();
            return;
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Error", exception);
        }
    }

    private void closeDialogAndSearch(String s, String s1, String s2, int i)
    {
        try
        {
            if (VoiceContext.isDebug())
            {
                Log.d(TAG, "closeDialogAndSearch");
            }
            closeDialog();
            VoiceContext.getSettings().getVoiceSearchListener().search(mVoiceSearchController.getActivity(), s, s1, s2, i, null, null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e(TAG, "Error", s);
        }
    }

    private Dialog getDialog()
    {
        if (mVoiceSearchController.getPanel() != null)
        {
            return mVoiceSearchController.getPanel().getDialog();
        } else
        {
            return null;
        }
    }

    private VoiceSearchMetricsRecorder getMetricsRecorder()
    {
        return mVoiceSearchController.getMetricsRecorder();
    }

    private void initRescueButtons()
    {
        Object obj;
        VSModalButton vsmodalbutton;
        try
        {
            obj = getDialog();
            vsmodalbutton = (VSModalButton)((Dialog) (obj)).findViewById(com.amazon.shopapp.voice.R.id.vs_retry_btn);
        }
        catch (Throwable throwable)
        {
            Log.e(TAG, "Error", throwable);
            return;
        }
        if (vsmodalbutton == null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        vsmodalbutton.setOnClickListener(this);
        obj = (VSModalButton)((Dialog) (obj)).findViewById(com.amazon.shopapp.voice.R.id.vs_type_btn);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        ((VSModalButton) (obj)).setOnClickListener(this);
    }

    private static void openKeyboardSearch(Activity activity, int i)
    {
        if (i <= 0)
        {
            try
            {
                VoiceContext.getSettings().getKeyboardModeListener().search(activity);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Activity activity)
            {
                Log.e(TAG, "Error", activity);
            }
            break MISSING_BLOCK_LABEL_49;
        }
        (new Handler()).post(new Runnable(activity, i) {

            final Activity val$activity;
            final int val$count;

            public void run()
            {
                try
                {
                    VoiceSearchDialog.openKeyboardSearch(activity, count - 1);
                    return;
                }
                catch (Exception exception)
                {
                    Log.e(VoiceSearchDialog.TAG, "Error", exception);
                }
            }

            
            {
                activity = activity1;
                count = i;
                super();
            }
        });
        return;
    }

    private boolean requireDialog()
    {
        if (getDialog() == null)
        {
            Log.e(TAG, "Dialog is null");
            return false;
        } else
        {
            return true;
        }
    }

    private View showPanel(Dialog dialog, int i, int j)
    {
        if (dialog == null)
        {
            Object obj;
            int k;
            int l;
            try
            {
                Log.e(TAG, "Dialog is null");
            }
            // Misplaced declaration of an exception variable
            catch (Dialog dialog)
            {
                Log.e(TAG, "Error", dialog);
                return null;
            }
            return null;
        }
        dialog.setContentView(com.amazon.shopapp.voice.R.layout.vs_dialog);
        mContainer = dialog.findViewById(com.amazon.shopapp.voice.R.id.vs_dialog);
        obj = dialog.findViewById(com.amazon.shopapp.voice.R.id.vs_inner_dialog);
        k = VoiceContext.getSettings().getMinDialogWidth();
        l = (int)(ViewUtil.dipToPixels(k, dialog.getContext().getResources()) + 0.5F);
        ((View) (obj)).setMinimumWidth(l);
        if (VoiceContext.isDebug())
        {
            Log.d(TAG, (new StringBuilder()).append("Dialog minimum width: dips: ").append(k).append(", pixels: ").append(l).toString());
        }
        obj = (ImageView)dialog.findViewById(com.amazon.shopapp.voice.R.id.vs_close_btn);
        ((ImageView) (obj)).setOnClickListener(this);
        if (!VoiceContext.getSettings().isCircularCloseButton())
        {
            break MISSING_BLOCK_LABEL_383;
        }
        k = com.amazon.shopapp.voice.R.drawable.vs_close_reversed;
_L6:
        ((ImageView) (obj)).setImageResource(k);
        obj = (ViewGroup)dialog.findViewById(com.amazon.shopapp.voice.R.id.vs_dialog_content);
        dialog.getLayoutInflater().inflate(i, ((ViewGroup) (obj)), true);
        if (!VoiceContext.isDebug() || dialog.getWindow() == null || dialog.getWindow().getDecorView() == null || dialog.getWindow().getDecorView().getRootView() == null) goto _L2; else goto _L1
_L1:
        obj = dialog.getWindow().getDecorView().getRootView();
        Log.d(TAG, (new StringBuilder()).append("Root view: ").append(obj).append(", width: ").append(((View) (obj)).getWidth()).append(", height: ").append(((View) (obj)).getHeight()).toString());
        if (!(obj instanceof ViewGroup)) goto _L2; else goto _L3
_L3:
        obj = (ViewGroup)obj;
        if (((ViewGroup) (obj)).getChildCount() <= 0) goto _L2; else goto _L4
_L4:
        obj = ((ViewGroup) (obj)).getChildAt(0);
        if (obj == null) goto _L2; else goto _L5
_L5:
        Log.d(TAG, (new StringBuilder()).append("Child view: ").append(obj).append(", width: ").append(((View) (obj)).getWidth()).append(", height: ").append(((View) (obj)).getHeight()).toString());
_L2:
        return dialog.findViewById(j);
        k = com.amazon.shopapp.voice.R.drawable.vs_close_btn;
          goto _L6
    }

    private void tryDismiss()
    {
        try
        {
            mVoiceSearchController.getPanel().dismiss();
            return;
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Error", exception);
        }
    }

    public void closeDialogAndSearch(String s, VoiceResult voiceresult, int i)
    {
        if (VoiceContext.isDebug())
        {
            Log.d(TAG, "closeDialogAndSearch");
        }
        while (voiceresult != null) 
        {
            try
            {
                closeDialogAndSearch(s, voiceresult.getAsrRequestId(), voiceresult.getUtteranceId(), i);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.e(TAG, "Error", s);
            }
            return;
        }
        return;
    }

    public DialogState getState()
    {
        return mState;
    }

    public boolean isSearching()
    {
        return getDialog() != null && (mState == DialogState.LOADING || mState == DialogState.SEARCH || mState == DialogState.PROCESSING);
    }

    public void onClick(View view)
    {
        if (mState == DialogState.NONE)
        {
            break MISSING_BLOCK_LABEL_167;
        }
        if (view == null)
        {
            return;
        }
        int i;
        i = view.getId();
        if (i == com.amazon.shopapp.voice.R.id.vs_dialog)
        {
            if (mState == DialogState.SEARCH)
            {
                mVoiceSearchController.stopSpeechRecognition();
                mVoiceSearchController.onFinishedSpeaking();
                getMetricsRecorder().recordManualEndpoint();
                return;
            }
            break MISSING_BLOCK_LABEL_167;
        }
        try
        {
            if (i == com.amazon.shopapp.voice.R.id.vs_close_btn)
            {
                mVoiceSearchController.cancel();
                closeDialog();
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            Log.e(TAG, "Error", view);
            return;
        }
        if (i == com.amazon.shopapp.voice.R.id.vs_retry_btn || i == com.amazon.shopapp.voice.R.id.vs_disambig_retry_btn)
        {
            getMetricsRecorder().recordTryAgain(mState);
            showLoading();
            mVoiceSearchController.prepareSpeechRecognition();
            return;
        }
        if (i == com.amazon.shopapp.voice.R.id.vs_type_btn || i == com.amazon.shopapp.voice.R.id.vs_time_type_btn)
        {
            getMetricsRecorder().recordTypeYourSearch(mState);
            closeDialog();
            openKeyboardSearch(mVoiceSearchController.getActivity(), 2);
        }
    }

    public void onConfigurationChanged(Activity activity, Dialog dialog, Configuration configuration)
    {
        try
        {
            if (VoiceContext.isDebug())
            {
                Log.d(TAG, "onConfigurationChanged");
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            Log.e(TAG, "Error", activity);
        }
    }

    public Dialog onCreateDialog(Activity activity, Bundle bundle)
    {
        try
        {
            if (VoiceContext.isDebug())
            {
                Log.d(TAG, "onCreateDialog");
            }
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            Log.e(TAG, "Error", activity);
            return null;
        }
        if (activity != null)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        Log.e(TAG, "Activity is null");
        return null;
        activity = new Dialog(activity, com.amazon.shopapp.voice.R.style.VSDialog);
        bundle = activity.getWindow();
        if (bundle != null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        Log.e(TAG, "Window is null");
_L1:
        activity.setCanceledOnTouchOutside(true);
        showPanel(activity, com.amazon.shopapp.voice.R.layout.vs_speak, com.amazon.shopapp.voice.R.id.vs_speak);
        return activity;
        bundle.setLayout(-2, -2);
        bundle.setWindowAnimations(com.amazon.shopapp.voice.R.style.VSDialogAnimation);
        bundle.setBackgroundDrawable(new ColorDrawable(0));
          goto _L1
    }

    public void onPause()
    {
        try
        {
            if (VoiceContext.isDebug())
            {
                Log.d(TAG, "onPause");
            }
            mState = DialogState.NONE;
            mWaveform = null;
            mVoiceSearchController.cancel();
            closeDialog();
            return;
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Error", exception);
        }
    }

    public void onStart()
    {
        try
        {
            if (VoiceContext.isDebug())
            {
                Log.d(TAG, "onStart");
            }
            getMetricsRecorder().recordStartVoiceSearchDialog(mVoiceSearchController.getActivity(), mVoiceSearchController.isSuggestionsFlow());
            mVoiceSearchController.reset();
            showLoading();
            mVoiceSearchController.prepareSpeechRecognition();
            return;
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Error", exception);
        }
    }

    public void onVolumeChanged(float f)
    {
        try
        {
            if (mState != DialogState.SEARCH)
            {
                return;
            }
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Error", exception);
            return;
        }
        if (mWaveform == null)
        {
            Log.e(TAG, "mWaveform is null");
            return;
        }
        mWaveform.setVoiceLevel(f);
        return;
    }

    public void showDisambiguation(final VoiceResult voiceResult)
    {
        if (VoiceContext.isDebug())
        {
            Log.d(TAG, "showDisambiguation");
        }
        if (!requireDialog())
        {
            return;
        }
        if (!isSearching() || voiceResult == null)
        {
            try
            {
                Log.e(TAG, (new StringBuilder()).append("Invalid state in showDisambiguation: ").append(mState).toString());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (final VoiceResult voiceResult)
            {
                Log.e(TAG, "Error", voiceResult);
            }
            return;
        }
        java.util.ArrayList arraylist = voiceResult.getInterpretations();
        if (arraylist == null)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        if (!arraylist.isEmpty())
        {
            break MISSING_BLOCK_LABEL_107;
        }
        Log.e(TAG, "No interpretations found");
        return;
        Dialog dialog;
        ViewGroup viewgroup;
        mState = DialogState.DISAMBIGUATION;
        dialog = getDialog();
        showPanel(dialog, com.amazon.shopapp.voice.R.layout.vs_disambig, com.amazon.shopapp.voice.R.id.vs_disambig);
        viewgroup = (ViewGroup)dialog.findViewById(com.amazon.shopapp.voice.R.id.vs_interp_box);
        final int idx = 0;
_L2:
        if (idx >= 100)
        {
            break; /* Loop/switch isn't completed */
        }
        if (idx >= arraylist.size())
        {
            break; /* Loop/switch isn't completed */
        }
        if (idx <= 0)
        {
            break MISSING_BLOCK_LABEL_242;
        }
        View view;
        int j;
        view = new View(dialog.getContext());
        view.setBackgroundResource(com.amazon.shopapp.voice.R.color.vs_interp_divider);
        j = (int)(ViewUtil.dipToPixels(1, dialog.getContext().getResources()) + 0.5F);
        int i;
        i = j;
        if (j < 1)
        {
            i = 1;
        }
        view.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, i));
        viewgroup.addView(view);
        dialog.getLayoutInflater().inflate(com.amazon.shopapp.voice.R.layout.vs_interp, viewgroup, true);
        View view1 = viewgroup.getChildAt(viewgroup.getChildCount() - 1);
        TextView textview = (TextView)view1.findViewById(com.amazon.shopapp.voice.R.id.vs_interp_text);
        final String text = (String)arraylist.get(idx);
        textview.setText((CharSequence)arraylist.get(idx));
        view1.setOnClickListener(new android.view.View.OnClickListener() {

            final VoiceSearchDialog this$0;
            final int val$idx;
            final String val$text;
            final VoiceResult val$voiceResult;

            public void onClick(View view2)
            {
                try
                {
                    closeDialogAndSearch(text, voiceResult, idx);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view2)
                {
                    Log.e(VoiceSearchDialog.TAG, "Error", view2);
                }
            }

            
            {
                this$0 = VoiceSearchDialog.this;
                text = s;
                voiceResult = voiceresult;
                idx = i;
                super();
            }
        });
        idx++;
        if (true) goto _L2; else goto _L1
_L1:
        ((VSModalButton)getDialog().findViewById(com.amazon.shopapp.voice.R.id.vs_disambig_retry_btn)).setOnClickListener(this);
        return;
    }

    public void showInactiveMicrophone()
    {
        if (VoiceContext.isDebug())
        {
            Log.d(TAG, "showInactiveMicrophone");
        }
        if (!isSearching() || mIcon == null)
        {
            Log.e(TAG, (new StringBuilder()).append("Invalid state in showInactiveMicrophone: ").append(mState).toString());
            return;
        }
        try
        {
            mIcon.setImageResource(com.amazon.shopapp.voice.R.drawable.vs_ic_modal_microphone_off);
            return;
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Error", exception);
        }
        return;
    }

    public void showListeningMicrophone()
    {
        if (VoiceContext.isDebug())
        {
            Log.d(TAG, "showListeningMicrophone");
        }
        if (!isSearching() || mIcon == null)
        {
            Log.e(TAG, (new StringBuilder()).append("Invalid state in showListeningMicrophone: ").append(mState).toString());
            return;
        }
        try
        {
            mIcon.setImageResource(com.amazon.shopapp.voice.R.drawable.vs_ic_modal_microphone_listening);
            return;
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Error", exception);
        }
        return;
    }

    public void showLoading()
    {
        if (VoiceContext.isDebug())
        {
            Log.d(TAG, "showLoading");
        }
        if (!requireDialog())
        {
            return;
        }
        try
        {
            mState = DialogState.LOADING;
            getMetricsRecorder().recordVoiceSearch();
            mVoiceSearchController.clearPlayedSounds();
            showPanel(getDialog(), com.amazon.shopapp.voice.R.layout.vs_speak, com.amazon.shopapp.voice.R.id.vs_speak);
            mContainer.setOnClickListener(this);
            mIcon = (ImageView)getDialog().findViewById(com.amazon.shopapp.voice.R.id.vs_dialog_icon);
            showInactiveMicrophone();
            mTitle = (TextSwitcher)getDialog().findViewById(com.amazon.shopapp.voice.R.id.vs_dialog_title_switcher);
            mTitle.setFactory(new android.widget.ViewSwitcher.ViewFactory() {

                final VoiceSearchDialog this$0;

                public View makeView()
                {
                    TextView textview;
                    try
                    {
                        textview = (TextView)LayoutInflater.from(mTitle.getContext()).inflate(com.amazon.shopapp.voice.R.layout.vs_dialog_title, null);
                        textview.setSingleLine();
                        textview.setEllipsize(android.text.TextUtils.TruncateAt.END);
                    }
                    catch (Throwable throwable)
                    {
                        Log.e(VoiceSearchDialog.TAG, "Error", throwable);
                        return null;
                    }
                    return textview;
                }

            
            {
                this$0 = VoiceSearchDialog.this;
                super();
            }
            });
            mTitle.setInAnimation(AnimationUtils.loadAnimation(mTitle.getContext(), com.amazon.shopapp.voice.R.anim.vs_title_fade_in));
            mTitle.setOutAnimation(AnimationUtils.loadAnimation(mTitle.getContext(), com.amazon.shopapp.voice.R.anim.vs_title_fade_out));
            mTitle.setCurrentText(mTitle.getContext().getString(com.amazon.shopapp.voice.R.string.vs_loading));
            mWaveform = (WaveformView)getDialog().findViewById(com.amazon.shopapp.voice.R.id.vs_waveform);
            mWaveform.stopAnimation();
            mWaveform.setVisibility(8);
            mSpeakBar = getDialog().findViewById(com.amazon.shopapp.voice.R.id.vs_speak_bar);
            mSpeakBar.setVisibility(0);
            return;
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Error", exception);
        }
        return;
    }

    public void showLowConfidence()
    {
        try
        {
            if (VoiceContext.isDebug())
            {
                Log.d(TAG, "showLowConfidence");
            }
            if (!requireDialog())
            {
                return;
            }
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Error", exception);
            return;
        }
        if (!isSearching())
        {
            Log.e(TAG, (new StringBuilder()).append("Invalid state in showLowConfidence: ").append(mState).toString());
            return;
        }
        mState = DialogState.LOW_CONFIDENCE;
        showPanel(getDialog(), com.amazon.shopapp.voice.R.layout.vs_low_confidence, com.amazon.shopapp.voice.R.id.vs_low_confidence);
        initRescueButtons();
        return;
    }

    public void showNegativeResult()
    {
        try
        {
            if (VoiceContext.isDebug())
            {
                Log.d(TAG, "showNegativeResult");
            }
            if (!requireDialog())
            {
                return;
            }
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Error", exception);
            return;
        }
        if (!isSearching())
        {
            Log.e(TAG, (new StringBuilder()).append("Invalid state in showNegativeResult: ").append(mState).toString());
            return;
        }
        mState = DialogState.NEGATIVE_RESULT;
        showPanel(getDialog(), com.amazon.shopapp.voice.R.layout.vs_negative_result, com.amazon.shopapp.voice.R.id.vs_negative_result);
        initRescueButtons();
        return;
    }

    public void showNetworkError()
    {
        try
        {
            if (VoiceContext.isDebug())
            {
                Log.d(TAG, "showNetworkError");
            }
            if (!requireDialog())
            {
                return;
            }
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Error", exception);
            return;
        }
        if (!isSearching())
        {
            Log.e(TAG, (new StringBuilder()).append("Invalid state in showNetworkError: ").append(mState).toString());
            return;
        }
        mState = DialogState.NETWORK_ERROR;
        showPanel(getDialog(), com.amazon.shopapp.voice.R.layout.vs_network_error, com.amazon.shopapp.voice.R.id.vs_network_error);
        initRescueButtons();
        return;
    }

    public void showNoSpeech()
    {
        try
        {
            if (VoiceContext.isDebug())
            {
                Log.d(TAG, "showNoSpeech");
            }
            if (!requireDialog())
            {
                return;
            }
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Error", exception);
            return;
        }
        if (!isSearching())
        {
            Log.e(TAG, (new StringBuilder()).append("Invalid state in showNoSpeech: ").append(mState).toString());
            return;
        }
        mState = DialogState.NO_SPEECH;
        showPanel(getDialog(), com.amazon.shopapp.voice.R.layout.vs_no_speech, com.amazon.shopapp.voice.R.id.vs_no_speech);
        initRescueButtons();
        return;
    }

    public void showProcessing()
    {
        try
        {
            if (VoiceContext.isDebug())
            {
                Log.d(TAG, "showProcessing");
            }
            if (!requireDialog())
            {
                return;
            }
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Error", exception);
            return;
        }
        if (mState != DialogState.SEARCH || mIcon == null || mTitle == null || mWaveform == null || mSpeakBar == null)
        {
            Log.e(TAG, (new StringBuilder()).append("Invalid state in showProcessing: ").append(mState).toString());
            return;
        }
        mState = DialogState.PROCESSING;
        showInactiveMicrophone();
        mTitle.setText(mTitle.getContext().getString(com.amazon.shopapp.voice.R.string.vs_searching));
        mWaveform.stopAnimation();
        mWaveform.setVisibility(8);
        mSpeakBar.setVisibility(0);
        return;
    }

    public void showRecordingMicrophone()
    {
        if (VoiceContext.isDebug())
        {
            Log.d(TAG, "showRecordingMicrophone");
        }
        if (!isSearching() || mIcon == null)
        {
            Log.e(TAG, (new StringBuilder()).append("Invalid state in showRecordingMicrophone: ").append(mState).toString());
            return;
        }
        try
        {
            mIcon.setImageResource(com.amazon.shopapp.voice.R.drawable.vs_ic_modal_microphone_glow);
            return;
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Error", exception);
        }
        return;
    }

    public void showSearch()
    {
        try
        {
            if (VoiceContext.isDebug())
            {
                Log.d(TAG, "showSearch");
            }
            if (!requireDialog())
            {
                return;
            }
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Error", exception);
            return;
        }
        if (mState != DialogState.LOADING || mIcon == null || mTitle == null || mWaveform == null || mSpeakBar == null)
        {
            Log.e(TAG, (new StringBuilder()).append("Invalid state in showSearch: ").append(mState).toString());
            return;
        }
        mState = DialogState.SEARCH;
        showListeningMicrophone();
        mTitle.setText(mTitle.getContext().getString(com.amazon.shopapp.voice.R.string.vs_what_are_you_searching));
        mWaveform.startAnimation();
        mWaveform.setVisibility(0);
        mSpeakBar.setVisibility(8);
        return;
    }

    public void showTimeError()
    {
        try
        {
            if (VoiceContext.isDebug())
            {
                Log.d(TAG, "showTimeError");
            }
            if (!requireDialog())
            {
                return;
            }
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Error", exception);
            return;
        }
        if (!isSearching())
        {
            Log.e(TAG, (new StringBuilder()).append("Invalid state in showTimeError: ").append(mState).toString());
            return;
        }
        mState = DialogState.INVALID_TIME;
        showPanel(getDialog(), com.amazon.shopapp.voice.R.layout.vs_time_error, com.amazon.shopapp.voice.R.id.vs_time_error);
        ((VSModalButton)getDialog().findViewById(com.amazon.shopapp.voice.R.id.vs_time_type_btn)).setOnClickListener(this);
        return;
    }

    public void startWaveformAnimation()
    {
        if (VoiceContext.isDebug())
        {
            Log.d(TAG, "startWaveformAnimation");
        }
        if (!isSearching() || mWaveform == null)
        {
            Log.e(TAG, (new StringBuilder()).append("Invalid state in startWaveformAnimation: ").append(mState).toString());
            return;
        }
        try
        {
            mWaveform.startAnimation();
            return;
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Error", exception);
        }
        return;
    }

    public void stopWaveformAnimation()
    {
        if (VoiceContext.isDebug())
        {
            Log.d(TAG, "stopWaveformAnimation");
        }
        if (!isSearching() || mWaveform == null)
        {
            Log.e(TAG, (new StringBuilder()).append("Invalid state in stopWaveformAnimation: ").append(mState).toString());
            return;
        }
        try
        {
            mWaveform.stopAnimation();
            return;
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Error", exception);
        }
        return;
    }




}
