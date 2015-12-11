// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.sharing.share_states;

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

public class EmailShare extends ShareState
{

    public static UUID id = UUID.randomUUID();

    public EmailShare(StateCompletionListener statecompletionlistener, ShareManager sharemanager)
    {
        super(statecompletionlistener, sharemanager);
    }

    public void executeState()
    {
        Object obj = shareManager.getShareContent();
        String s = ((PMShareContent) (obj)).getSubject();
        obj = ((PMShareContent) (obj)).getBody();
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", "", null));
        intent.putExtra("android.intent.extra.SUBJECT", s);
        intent.putExtra("android.intent.extra.TEXT", Html.fromHtml((new StringBuilder()).append(((String) (obj))).toString()));
        shareManager.getFragment().startActivityForResult(Intent.createChooser(intent, "Send email..."), 13);
        shareManager.trackShareEvent();
        shareManager.trackExternalShareOnPM(ShareManager.EXTERNAL_SHARE_STATE_INITIALED);
    }

    public UUID getId()
    {
        return id;
    }

}
