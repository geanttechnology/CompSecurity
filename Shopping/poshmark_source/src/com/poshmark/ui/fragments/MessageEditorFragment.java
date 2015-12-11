// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.customviews.PMEditText;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment

public class MessageEditorFragment extends PMFragment
{

    String defaultString;
    private PMEditText messageEditor;
    String placeholderString;

    public MessageEditorFragment()
    {
    }

    public boolean handleBack()
    {
        PMNotificationManager.fireNotification("com.poshmark.intents.MESSAGE_EDITOR_ACTION_CANCELLED", null);
        return false;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        setTitle(getString(0x7f060034));
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        placeholderString = getArguments().getString("PLACEHOLDER", "");
        defaultString = getArguments().getString("MESSAGE", "");
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(0x7f030081, viewgroup, false);
        messageEditor = (PMEditText)layoutinflater.findViewById(0x7f0c0203);
        messageEditor.setHint(placeholderString);
        messageEditor.setText(defaultString);
        messageEditor.requestFocus();
        showKeyboard();
        return layoutinflater;
    }

    public void setViewNameForAnalytics()
    {
        viewNameForAnalytics = getArguments().getString("ANALYTICS_PAGE_NAME", "multiline_input_screen");
    }

    public void setupActionBar()
    {
        super.setupActionBar();
        setNextActionButton(getString(0x7f0600bf), new android.view.View.OnClickListener() {

            final MessageEditorFragment this$0;

            public void onClick(View view)
            {
                hideKeyboard();
                view = new Bundle();
                PMFragment pmfragment;
                if (messageEditor.getText().toString().length() > 0)
                {
                    view.putString("MESSAGE", messageEditor.getText().toString());
                } else
                {
                    view.putString("MESSAGE", "");
                }
                pmfragment = (PMFragment)getTargetFragment();
                if (pmfragment != null)
                {
                    pmfragment.onFragmentResult(view, getTargetRequestCode());
                } else
                {
                    Intent intent = new Intent();
                    intent.putExtras(view);
                    getActivity().setResult(-1, intent);
                }
                PMNotificationManager.fireNotification("com.poshmark.intents.MESSAGE_EDITOR_ACTION_COMPLETE", view);
            }

            
            {
                this$0 = MessageEditorFragment.this;
                super();
            }
        });
    }

}
