// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.sharing.share_states;

import android.content.Context;
import com.poshmark.application.PMApplication;
import com.poshmark.data_model.models.Brand;
import com.poshmark.data_model.models.BrandShareMessageContainer;
import com.poshmark.data_model.models.ListingSummary;
import com.poshmark.data_model.models.inner_models.ShortUrl;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.fragments.PMFragment;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.user.UserInfoDetails;
import com.poshmark.utils.ShareManager;
import com.poshmark.utils.sharing.PMShareContent;
import com.poshmark.utils.sharing.StateCompletionListener;
import java.util.UUID;

// Referenced classes of package com.poshmark.utils.sharing.share_states:
//            ShareState

public class GetLocalContent extends ShareState
{

    public static UUID id = UUID.randomUUID();

    public GetLocalContent(StateCompletionListener statecompletionlistener, ShareManager sharemanager)
    {
        super(statecompletionlistener, sharemanager);
    }

    public void executeState()
    {
        com.poshmark.utils.ShareManager.SHARE_TYPE share_type = shareManager.getShareType();
        com.poshmark.utils.ShareManager.SHARE_MODE share_mode = shareManager.getShareMode();
        boolean flag;
        if (shareManager.getFragment() != null && shareManager.getFragment().isAdded())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (share_mode == com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_LISTING)
        {
            if (share_type == com.poshmark.utils.ShareManager.SHARE_TYPE.TM_SHARE || share_type == com.poshmark.utils.ShareManager.SHARE_TYPE.TW_SHARE)
            {
                final ListingSummary listingItem = shareManager.getShareContent().getListing();
                if (listingItem.getShortURL() == null || listingItem.getShortURL().length() == 0)
                {
                    if (flag)
                    {
                        shareManager.getFragment().showProgressDialogWithMessage(PMApplication.getContext().getString(0x7f06025d));
                    }
                    PMApi.getTinyUrlForListing(listingItem.getIdAsString(), new PMApiResponseHandler() {

                        final GetLocalContent this$0;
                        final ListingSummary val$listingItem;

                        public void handleResponse(PMApiResponse pmapiresponse)
                        {
                            shareManager.getFragment().hideProgressDialog();
                            if (!pmapiresponse.hasError())
                            {
                                listingItem.setShortURL(((ShortUrl)pmapiresponse.data).short_url);
                                listener.stateCompleted();
                                return;
                            } else
                            {
                                shareManager.getFragment().showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.SHARE_LISTING_TWITTER), new com.poshmark.ui.customviews.PMProgressDialog.ProgressDialogAutoDismissListener() {

                                    final _cls1 this$1;

                                    public void dialogDismissed()
                                    {
                                        listener.stateFailed();
                                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                                });
                                return;
                            }
                        }

            
            {
                this$0 = GetLocalContent.this;
                listingItem = listingsummary;
                super();
            }
                    });
                    return;
                } else
                {
                    listener.stateCompleted();
                    return;
                }
            } else
            {
                listener.stateCompleted();
                return;
            }
        }
        if (share_mode == com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_CLOSET)
        {
            String s = shareManager.getShareContent().getClosetShortUrl();
            if (s == null || s.length() == 0)
            {
                if (flag)
                {
                    shareManager.getFragment().showProgressDialogWithMessage(PMApplication.getContext().getString(0x7f06025d));
                }
                PMApi.getTinyURLForUser(shareManager.getShareContent().getUser().getPMUserId(), new PMApiResponseHandler() {

                    final GetLocalContent this$0;

                    public void handleResponse(PMApiResponse pmapiresponse)
                    {
                        shareManager.getFragment().hideProgressDialog();
                        if (!pmapiresponse.hasError())
                        {
                            shareManager.getShareContent().setclosetShortUrl(((ShortUrl)pmapiresponse.data).short_url);
                            listener.stateCompleted();
                            return;
                        } else
                        {
                            shareManager.getFragment().showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.SHARE_LISTING_TWITTER), new com.poshmark.ui.customviews.PMProgressDialog.ProgressDialogAutoDismissListener() {

                                final _cls2 this$1;

                                public void dialogDismissed()
                                {
                                    listener.stateFailed();
                                }

            
            {
                this$1 = _cls2.this;
                super();
            }
                            });
                            return;
                        }
                    }

            
            {
                this$0 = GetLocalContent.this;
                super();
            }
                });
                return;
            } else
            {
                listener.stateCompleted();
                return;
            }
        }
        if (share_mode == com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_BRAND || share_mode == com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_BRAND_JUSTIN)
        {
            shareManager.getFragment().showProgressDialogWithMessage(PMApplication.getContext().getString(0x7f060190));
            PMApi.getBrandShareMessages(shareManager.getShareContent().getBrand().canonical_name, new PMApiResponseHandler() {

                final GetLocalContent this$0;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
                    if (!pmapiresponse.hasError())
                    {
                        shareManager.getShareContent().setBrandShareMessages(((BrandShareMessageContainer)pmapiresponse.data).getBrandShareMessages());
                        shareManager.getFragment().hideProgressDialog();
                        listener.stateCompleted();
                        return;
                    } else
                    {
                        shareManager.getFragment().showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.SHARE_LISTING_TWITTER), new com.poshmark.ui.customviews.PMProgressDialog.ProgressDialogAutoDismissListener() {

                            final _cls3 this$1;

                            public void dialogDismissed()
                            {
                                listener.stateFailed();
                            }

            
            {
                this$1 = _cls3.this;
                super();
            }
                        });
                        return;
                    }
                }

            
            {
                this$0 = GetLocalContent.this;
                super();
            }
            });
            return;
        } else
        {
            listener.stateCompleted();
            return;
        }
    }

    public UUID getId()
    {
        return id;
    }

}
