// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import android.app.Dialog;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.flurry.android.FlurryAgent;
import com.mixerbox.mixerbox3b.dialogs.AlertDialogFactory;
import com.mixerbox.mixerbox3b.utils.MixerBoxClient;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.mixerbox.mixerbox3b:
//            MainPage

class this._cls0
    implements android.widget.ditorActionListener
{

    final MainPage this$0;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
label0:
        {
            if (i == 3)
            {
                ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(textview.getWindowToken(), 0);
                if (MixerBoxClient.isConnectingToInternet(MainPage.this))
                {
                    break label0;
                }
                AlertDialogFactory.NoNetworkAlertDialog(MainPage.this).show();
            }
            return false;
        }
        textview = textview.getText().toString();
        keyevent = new HashMap();
        keyevent.put("query", textview);
        FlurryAgent.logEvent("action:search", keyevent);
        setDiscover(new boolean[] {
            false
        });
        keyevent = setVector("VECTORIDSEARCH", "vector", 2, "");
        MixerBoxUtils.setSearch(MainPage.this, textview, keyevent);
        return false;
    }

    oxUtils()
    {
        this$0 = MainPage.this;
        super();
    }
}
