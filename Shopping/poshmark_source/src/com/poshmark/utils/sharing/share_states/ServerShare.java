// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.sharing.share_states;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.poshmark.application.PMApplication;
import com.poshmark.data_model.models.Brand;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.PMNotificationListener;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.fragments.PMFragment;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.utils.ShareManager;
import com.poshmark.utils.sharing.PMShareContent;
import com.poshmark.utils.sharing.ShareContentHelper;
import com.poshmark.utils.sharing.StateCompletionListener;
import java.util.UUID;

// Referenced classes of package com.poshmark.utils.sharing.share_states:
//            ShareState

public class ServerShare extends ShareState
    implements PMNotificationListener
{

    public static UUID id = UUID.randomUUID();
    PMApiResponseHandler apiResponseHandler;

    public ServerShare(StateCompletionListener statecompletionlistener, ShareManager sharemanager)
    {
        super(statecompletionlistener, sharemanager);
        apiResponseHandler = new PMApiResponseHandler() {

            final ServerShare this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
                if (!pmapiresponse.hasError())
                {
                    shareManager.getFragment().getParentActivity().popTopFragment();
                    shareManager.getFragment().showAutoHideProgressDialogWithMessage(PMApplication.getContext().getString(0x7f060259), new com.poshmark.ui.customviews.PMProgressDialog.ProgressDialogAutoDismissListener() {

                        final _cls1 this$1;

                        public void dialogDismissed()
                        {
                            deRegisterListeners();
                            listener.stateCompleted();
                            shareManager.getFragment().getParentActivity().popTopFragment();
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    });
                    return;
                } else
                {
                    shareManager.trackShareFailedEvent();
                    shareManager.getFragment().showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.SHARE_LISTING, ShareContentHelper.getSharingErrorString(shareManager.getShareMode())));
                    return;
                }
            }

            
            {
                this$0 = ServerShare.this;
                super();
            }
        };
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.MESSAGE_EDITOR_ACTION_COMPLETE", this);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.MESSAGE_EDITOR_ACTION_CANCELLED", this);
    }

    private void deRegisterListeners()
    {
        PMNotificationManager.getNotificationManager().unregisterAllEvents(this);
    }

    private void fireShare()
    {
        PMShareContent pmsharecontent = shareManager.getShareContent();
        if (shareManager.getFragment().getParentActivity().isActivityInForeground())
        {
            shareManager.getFragment().showProgressDialogWithMessage(PMApplication.getContext().getString(0x7f06025d));
        }
        static class _cls2
        {

            static final int $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[];

            static 
            {
                $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE = new int[com.poshmark.utils.ShareManager.SHARE_MODE.values().length];
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_LISTING.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_BRAND.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_SHOWROOM.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_INVITE_FRIENDS.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_CLOSET.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_PARTY.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls2..SwitchMap.com.poshmark.utils.ShareManager.SHARE_MODE[shareManager.getShareMode().ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            PMApi.shareListingToExternalService(pmsharecontent.getId(), shareManager.getExternalShareCode(), shareManager.getShareContent().getFinalSharingMessage(), apiResponseHandler);
            return;

        case 2: // '\002'
            PMApi.shareBrandToExternalService(pmsharecontent.getBrand().canonical_name, shareManager.getExternalShareCode(), shareManager.getShareContent().getFinalSharingMessage(), apiResponseHandler);
            return;

        case 3: // '\003'
            PMApi.shareShowroom(pmsharecontent.getId(), shareManager.getExternalShareCode(), shareManager.getShareContent().getFinalSharingMessage(), apiResponseHandler);
            return;

        case 4: // '\004'
            PMApi.inviteFriends(null, shareManager.getShareContent().getFinalSharingMessage(), shareManager.getExternalShareCode(), apiResponseHandler);
            return;

        case 5: // '\005'
            PMApi.shareCloset(pmsharecontent.getId(), shareManager.getExternalShareCode(), shareManager.getShareContent().getFinalSharingMessage(), apiResponseHandler);
            return;

        case 6: // '\006'
            PMApi.shareEvent(pmsharecontent.getId(), shareManager.getExternalShareCode(), shareManager.getShareContent().getFinalSharingMessage(), apiResponseHandler);
            break;
        }
    }

    public void executeState()
    {
        shareManager.getUserMessage();
    }

    public UUID getId()
    {
        return id;
    }

    public void handleNotification(Intent intent)
    {
        if (intent.getAction().equals("com.poshmark.intents.MESSAGE_EDITOR_ACTION_COMPLETE"))
        {
            intent = intent.getExtras();
            if (intent != null)
            {
                intent = intent.getBundle("RESULT");
                if (intent != null)
                {
                    shareManager.getShareContent().addFinalSharingMessage(intent.getString("MESSAGE", ""));
                    fireShare();
                }
            }
        } else
        if (intent.getAction().equals("com.poshmark.intents.MESSAGE_EDITOR_ACTION_CANCELLED"))
        {
            deRegisterListeners();
            listener.stateFailed();
            return;
        }
    }


}
