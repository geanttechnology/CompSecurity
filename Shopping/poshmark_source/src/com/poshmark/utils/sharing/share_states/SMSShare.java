// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.sharing.share_states;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import com.poshmark.ui.fragments.PMFragment;
import com.poshmark.utils.ShareManager;
import com.poshmark.utils.sharing.PMShareContent;
import com.poshmark.utils.sharing.StateCompletionListener;
import java.util.UUID;

// Referenced classes of package com.poshmark.utils.sharing.share_states:
//            ShareState

public class SMSShare extends ShareState
{

    public static UUID id = UUID.randomUUID();

    public SMSShare(StateCompletionListener statecompletionlistener, ShareManager sharemanager)
    {
        super(statecompletionlistener, sharemanager);
    }

    public void executeState()
    {
        Object obj = shareManager.getShareContent();
        String s = ((PMShareContent) (obj)).getShareMessage();
        obj = ((PMShareContent) (obj)).getBody();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("sms:"));
        intent.putExtra("sms_body", s);
        intent.putExtra("android.intent.extra.SUBJECT", s);
        intent.putExtra("android.intent.extra.TEXT", Html.fromHtml((new StringBuilder()).append(((String) (obj))).toString()));
        try
        {
            shareManager.getFragment().startActivityForResult(intent, 14);
        }
        catch (ActivityNotFoundException activitynotfoundexception) { }
        shareManager.trackShareEvent();
        shareManager.trackExternalShareOnPM(ShareManager.EXTERNAL_SHARE_STATE_INITIALED);
    }

    public UUID getId()
    {
        return id;
    }

}
