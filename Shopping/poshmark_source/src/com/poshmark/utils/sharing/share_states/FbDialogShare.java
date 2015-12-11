// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.sharing.share_states;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import com.poshmark.notifications.PMNotificationListener;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.utils.ShareManager;
import com.poshmark.utils.sharing.PMShareContent;
import com.poshmark.utils.sharing.StateCompletionListener;
import java.util.UUID;

// Referenced classes of package com.poshmark.utils.sharing.share_states:
//            ShareState

public class FbDialogShare extends ShareState
    implements PMNotificationListener
{

    public static UUID id = UUID.randomUUID();
    CallbackManager callbackManager;
    FacebookCallback fbDialogCallback;

    public FbDialogShare(StateCompletionListener statecompletionlistener, ShareManager sharemanager)
    {
        super(statecompletionlistener, sharemanager);
        fbDialogCallback = new FacebookCallback() {

            final FbDialogShare this$0;

            public void onCancel()
            {
                PMNotificationManager.getNotificationManager().unregisterAllEvents(FbDialogShare.this);
                shareManager.trackExternalShareOnPM(ShareManager.EXTERNAL_SHARE_STATE_CANCELLED);
                listener.stateCompleted();
            }

            public void onError(FacebookException facebookexception)
            {
                PMNotificationManager.getNotificationManager().unregisterAllEvents(FbDialogShare.this);
                listener.stateCompleted();
            }

            public void onSuccess(com.facebook.share.Sharer.Result result)
            {
                PMNotificationManager.getNotificationManager().unregisterAllEvents(FbDialogShare.this);
                shareManager.trackExternalShareOnPM(ShareManager.EXTERNAL_SHARE_STATE_SUCCESS);
                listener.stateCompleted();
            }

            public volatile void onSuccess(Object obj)
            {
                onSuccess((com.facebook.share.Sharer.Result)obj);
            }

            
            {
                this$0 = FbDialogShare.this;
                super();
            }
        };
        callbackManager = com.facebook.CallbackManager.Factory.create();
    }

    public void executeState()
    {
        Object obj = shareManager.getShareContent();
        String s = ((PMShareContent) (obj)).getShareTitle();
        String s1 = ((PMShareContent) (obj)).getShareDescription();
        String s2 = ((PMShareContent) (obj)).getShareUrl();
        ((PMShareContent) (obj)).getShareMessage();
        ((PMShareContent) (obj)).getPlaceHolderString();
        ((PMShareContent) (obj)).getSubject();
        ((PMShareContent) (obj)).getBody();
        obj = new ShareDialog(shareManager.getFragment());
        ((ShareDialog) (obj)).registerCallback(callbackManager, fbDialogCallback);
        if (ShareDialog.canShow(com/facebook/share/model/ShareLinkContent))
        {
            PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.FBDIALOG_SHARE_RESULTS", this);
            ((ShareDialog) (obj)).show(((com.facebook.share.model.ShareLinkContent.Builder)(new com.facebook.share.model.ShareLinkContent.Builder()).setContentTitle(s).setContentDescription(s1).setContentUrl(Uri.parse(s2))).build());
            shareManager.trackExternalShareOnPM(ShareManager.EXTERNAL_SHARE_STATE_INITIALED);
        }
    }

    public UUID getId()
    {
        return id;
    }

    public void handleNotification(Intent intent)
    {
        if (intent.getAction().equals("com.poshmark.intents.FBDIALOG_SHARE_RESULTS"))
        {
            intent = intent.getExtras();
            if (intent != null)
            {
                intent = intent.getBundle("RESULT");
                if (intent != null)
                {
                    int i = intent.getInt("REQUEST_CODE");
                    int j = intent.getInt("RESULT_CODE");
                    Intent intent1 = new Intent();
                    intent1.putExtras(intent);
                    callbackManager.onActivityResult(i, j, intent1);
                }
            }
        }
    }

}
