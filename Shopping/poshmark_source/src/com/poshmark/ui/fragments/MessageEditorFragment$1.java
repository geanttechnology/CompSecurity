// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.customviews.PMEditText;

// Referenced classes of package com.poshmark.ui.fragments:
//            MessageEditorFragment, PMFragment

class this._cls0
    implements android.view.orFragment._cls1
{

    final MessageEditorFragment this$0;

    public void onClick(View view)
    {
        hideKeyboard();
        view = new Bundle();
        PMFragment pmfragment;
        if (MessageEditorFragment.access$000(MessageEditorFragment.this).getText().toString().length() > 0)
        {
            view.putString("MESSAGE", MessageEditorFragment.access$000(MessageEditorFragment.this).getText().toString());
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

    ()
    {
        this$0 = MessageEditorFragment.this;
        super();
    }
}
