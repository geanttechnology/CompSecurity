// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import com.poshmark.analytics.Analytics;
import com.poshmark.data_model.models.ListingDetails;
import com.poshmark.data_model.models.inner_models.Comment;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import java.util.List;

// Referenced classes of package com.poshmark.ui.fragments:
//            ListingDetailsFragment

class this._cls0
    implements android.widget.ckListener
{

    final ListingDetailsFragment this$0;

    public boolean onItemLongClick(final AdapterView comment, View view, final int commentIndex, long l)
    {
        commentIndex = ((Integer)view.getTag()).intValue();
        comment = listingDetails.getComments();
        if (comment != null && comment.size() > commentIndex)
        {
            comment = (Comment)comment.get(commentIndex);
            view = ((Comment) (comment)).creator_display_handle;
            String s = ((Comment) (comment)).comment;
            showConfirmationMessage("Delete Comment!!", (new StringBuilder()).append("Are you sure you want to delete this comment by @").append(view).append(":\n").append(s).toString(), new android.content.DialogInterface.OnClickListener() {

                final ListingDetailsFragment._cls1 this$1;
                final Comment val$comment;
                final int val$commentIndex;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    if (i == -1)
                    {
                        Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "delete_listing_comment", listingId);
                        showProgressDialogWithMessage("Deleting Comment...");
                        PMApi.deleteComment(listingId, comment.id, new PMApiResponseHandler() {

                            final _cls1 this$2;

                            public void handleResponse(PMApiResponse pmapiresponse)
                            {
                                hideProgressDialog();
                                if (!pmapiresponse.hasError())
                                {
                                    listingDetails.deleteComment(commentIndex);
                                    ListingDetailsFragment.access$000(this$0);
                                }
                            }

            
            {
                this$2 = _cls1.this;
                super();
            }
                        });
                    }
                }

            
            {
                this$1 = ListingDetailsFragment._cls1.this;
                comment = comment1;
                commentIndex = i;
                super();
            }
            });
        }
        return true;
    }

    _cls1.val.commentIndex()
    {
        this$0 = ListingDetailsFragment.this;
        super();
    }
}
