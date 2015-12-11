// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FilterQueryProvider;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplication;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.data_model.adapters.UserInteractionsAdapter;
import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.data_model.models.ListingSocial;
import com.poshmark.data_model.models.PMData;
import com.poshmark.data_model.models.PMErrorType;
import com.poshmark.data_model.models.UserInteractions;
import com.poshmark.data_model.models.inner_models.Comment;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiError;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.ListingNotificationManager;
import com.poshmark.ui.customviews.MultiWordAutoCompleteView;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.utils.FBDPAHelper;
import com.poshmark.utils.MetricsTrackingUtils;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment

public class CommentFragment extends PMFragment
{

    UserInteractionsAdapter adapter;
    UserInteractions interactionsData;
    ListingSocial listingDetails;
    String listingId;
    String replyToUserHandle;
    MultiWordAutoCompleteView textView;

    public CommentFragment()
    {
    }

    private void postComment()
    {
        String s = textView.getText().toString().trim();
        if (s.length() <= 0)
        {
            showAlertMessage("", getString(0x7f060030));
            return;
        } else
        {
            showProgressDialogWithMessage(getResources().getString(0x7f060217));
            String s1 = MetricsTrackingUtils.getTrackingJson(getActivity(), "cmt");
            PMApi.postComment(listingId, s, s1, new PMApiResponseHandler() {

                final CommentFragment this$0;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
label0:
                    {
                        if (isAdded())
                        {
                            hideProgressDialog();
                            if (pmapiresponse.hasError())
                            {
                                break label0;
                            }
                            FBDPAHelper.trackComment(listingDetails);
                            Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "comment", null);
                            pmapiresponse = (Comment)pmapiresponse.data;
                            ListingNotificationManager.getListingNotificationManager().fireListingCommentMessage(listingId, pmapiresponse);
                            finishActivity();
                        }
                        return;
                    }
                    String s2 = PMApplication.getContext().getString(0x7f0600d2);
                    if (pmapiresponse.apiError.pmErrorType == PMErrorType.INSUFFICIENT_PRIVILEGES_ERROR)
                    {
                        s2 = "";
                        if (listingDetails != null)
                        {
                            s2 = listingDetails.getUserName();
                        }
                        s2 = String.format(PMApplication.getContext().getString(0x7f0600d1), new Object[] {
                            s2
                        });
                        pmapiresponse = new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.ADD_COMMENT, null, com.poshmark.ui.model.ActionErrorContext.Severity.HIGH, null, s2);
                    } else
                    {
                        pmapiresponse = new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.ADD_COMMENT, s2, com.poshmark.ui.model.ActionErrorContext.Severity.HIGH);
                    }
                    showError(pmapiresponse);
                }

            
            {
                this$0 = CommentFragment.this;
                super();
            }
            });
            return;
        }
    }

    private void setupActionBarNextActionButton()
    {
        Button button = getNextActionButton();
        if (button == null)
        {
            return;
        } else
        {
            button.setText(getString(0x7f060216).toUpperCase());
            button.setOnClickListener(new android.view.View.OnClickListener() {

                final CommentFragment this$0;

                public void onClick(View view)
                {
                    postComment();
                }

            
            {
                this$0 = CommentFragment.this;
                super();
            }
            });
            return;
        }
    }

    private void updateAutoCompleteView()
    {
        adapter.setFilterQueryProvider(new FilterQueryProvider() {

            final CommentFragment this$0;

            public Cursor runQuery(CharSequence charsequence)
            {
                Object obj1 = null;
                Object obj = obj1;
                if (charsequence != null)
                {
                    obj = charsequence.toString();
                    charsequence = ((CharSequence) (obj));
                    if (((String) (obj)).indexOf(" ") != -1)
                    {
                        int i = ((String) (obj)).lastIndexOf(" ");
                        charsequence = ((CharSequence) (obj));
                        if (i != ((String) (obj)).length() - 1)
                        {
                            obj = ((String) (obj)).substring(i + 1).trim();
                            charsequence = ((CharSequence) (obj));
                            if (((String) (obj)).length() < 2);
                        }
                    }
                    obj = obj1;
                    if (charsequence.length() > 1)
                    {
                        obj = obj1;
                        if (charsequence.toString().startsWith("@"))
                        {
                            obj = adapter.getCursor();
                            if (obj != null)
                            {
                                ((Cursor) (obj)).close();
                            }
                            obj = new CustomMatrixCursor(new String[] {
                                PMData.ID_COL, PMData.DATA_COL
                            });
                            interactionsData.fillFilteredCursor(((CustomMatrixCursor) (obj)), charsequence.substring(1));
                        }
                    }
                }
                return ((Cursor) (obj));
            }

            
            {
                this$0 = CommentFragment.this;
                super();
            }
        });
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (interactionsData == null)
        {
            PMApi.getUserInteractionsList(PMApplicationSession.GetPMSession().getUserId(), new PMApiResponseHandler() {

                final CommentFragment this$0;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
                    if (isAdded() && !pmapiresponse.hasError())
                    {
                        interactionsData = (UserInteractions)pmapiresponse.data;
                        interactionsData.addContextualData(listingDetails);
                        updateAutoCompleteView();
                    }
                }

            
            {
                this$0 = CommentFragment.this;
                super();
            }
            });
        } else
        {
            updateAutoCompleteView();
        }
        textView.setAdapter(adapter);
        textView.setThreshold(2);
        textView.setSeparator(" ");
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        listingId = getArguments().getString("ID");
        replyToUserHandle = getArguments().getString("REPLY_TO_HANDLE");
        listingDetails = (ListingSocial)getFragmentDataOfType(com/poshmark/data_model/models/ListingSocial);
        adapter = new UserInteractionsAdapter(getActivity(), null, 0x80000000);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(0x7f030032, viewgroup, false);
        textView = (MultiWordAutoCompleteView)layoutinflater.findViewById(0x7f0c00dd);
        if (replyToUserHandle != null)
        {
            textView.setText((new StringBuilder()).append(replyToUserHandle).append(" ").toString());
        }
        textView.requestFocus();
        getActivity().getWindow().setSoftInputMode(4);
        return layoutinflater;
    }

    public void setViewNameForAnalytics()
    {
        viewNameForAnalytics = "add_comment_screen";
    }

    public void setupActionBar()
    {
        super.setupActionBar();
        setTitle(0x7f06008d);
        setupActionBarNextActionButton();
    }


}
