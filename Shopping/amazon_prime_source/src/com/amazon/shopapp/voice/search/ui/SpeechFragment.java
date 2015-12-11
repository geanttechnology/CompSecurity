// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.shopapp.voice.search.ui;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import com.amazon.shopapp.voice.search.VoiceSearchController;

// Referenced classes of package com.amazon.shopapp.voice.search.ui:
//            SpeechPanel, VoiceSearchDialog

public class SpeechFragment extends DialogFragment
    implements SpeechPanel
{

    private static final String TAG = com/amazon/shopapp/voice/search/ui/SpeechFragment.getSimpleName();
    private VoiceSearchController mVoiceSearchController;

    public SpeechFragment()
    {
    }

    public static SpeechFragment newInstance(boolean flag)
    {
        SpeechFragment speechfragment = new SpeechFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("suggestionsFlow", flag);
        speechfragment.setArguments(bundle);
        return speechfragment;
    }

    public VoiceSearchController getVoiceSearchController()
    {
        return mVoiceSearchController;
    }

    public boolean isActive()
    {
        return isAdded() && !isRemoving();
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        try
        {
            super.onConfigurationChanged(configuration);
            mVoiceSearchController.getVoiceSearchDialog().onConfigurationChanged(getActivity(), getDialog(), configuration);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Configuration configuration)
        {
            Log.e(TAG, "Error", configuration);
        }
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        try
        {
            boolean flag = getArguments().getBoolean("suggestionsFlow");
            mVoiceSearchController = new VoiceSearchController(getActivity(), this, flag);
            bundle = mVoiceSearchController.getVoiceSearchDialog().onCreateDialog(getActivity(), bundle);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            Log.e(TAG, "Error", bundle);
            return null;
        }
        return bundle;
    }

    public void onDestroyView()
    {
        try
        {
            if (getDialog() != null && getRetainInstance())
            {
                getDialog().setDismissMessage(null);
            }
            super.onDestroyView();
            return;
        }
        catch (Throwable throwable)
        {
            Log.e(TAG, "Error", throwable);
        }
    }

    public void onPause()
    {
        try
        {
            super.onPause();
            mVoiceSearchController.getVoiceSearchDialog().onPause();
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
            super.onStart();
            mVoiceSearchController.getVoiceSearchDialog().onStart();
            return;
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Error", exception);
        }
    }

}
