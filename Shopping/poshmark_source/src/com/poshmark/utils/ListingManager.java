// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.appevents.AppEventsLogger;
import com.google.gson.Gson;
import com.google.gson.internal.StringMap;
import com.mobileapptracker.MobileAppTracker;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplication;
import com.poshmark.config.NewRelicWrapper;
import com.poshmark.data_model.ID;
import com.poshmark.data_model.models.NewListing;
import com.poshmark.data_model.models.PMErrorType;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiError;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.ListingNotificationManager;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.customviews.PMEditListingImageSelectorView;
import com.poshmark.ui.fragments.ListingValidationPageFragment;
import com.poshmark.ui.fragments.PMFragment;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.webcommands.WebCommandsManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.singular.sdk.Singular;

// Referenced classes of package com.poshmark.utils:
//            StringUtils, NewRelicCustomInteractions

public class ListingManager
{

    public static final int CREATE_LISTING = 101;
    public static final int LISTING_CREATED = 102;
    boolean bIsNewListing;
    boolean bShareOnFacebook;
    boolean bShareOnPinterest;
    boolean bShareOnTumblr;
    boolean bShareOnTwitter;
    PMFragment callingFragment;
    int currentSentImageIndex;
    List eventIds;
    List imageList;
    String listingId;
    NewListing newListing;
    ID newListingId;

    public ListingManager()
    {
        bIsNewListing = false;
        bShareOnTwitter = false;
        bShareOnTumblr = false;
        bShareOnFacebook = false;
        bShareOnPinterest = false;
        eventIds = new ArrayList();
    }

    private String getCommaSeparatedEventIdsForShare()
    {
        String s = "";
        int i = 0;
        while (i < eventIds.size()) 
        {
            if (i == 0)
            {
                s = (new StringBuilder()).append(s).append((String)eventIds.get(i)).toString();
            } else
            {
                s = (new StringBuilder()).append(s).append(", ").append((String)eventIds.get(i)).toString();
            }
            i++;
        }
        return s;
    }

    private String getCommaSeparatedExternalServiceIdsForShare()
    {
        ArrayList arraylist = new ArrayList();
        if (bShareOnTumblr)
        {
            arraylist.add("tm");
        }
        if (bShareOnFacebook)
        {
            arraylist.add("fb");
        }
        if (bShareOnTwitter)
        {
            arraylist.add("tw");
        }
        if (bShareOnPinterest)
        {
            arraylist.add("pn");
        }
        return StringUtils.join(arraylist, ",");
    }

    private String getRetryMessageForError(PMApiError pmapierror)
    {
        if (bIsNewListing)
        {
            pmapierror = (new ActionErrorContext(pmapierror, com.poshmark.ui.model.ActionErrorContext.ActionContext.POST_LISTING, callingFragment.getString(0x7f0600e4))).message;
        } else
        {
            pmapierror = (new ActionErrorContext(pmapierror, com.poshmark.ui.model.ActionErrorContext.ActionContext.UPDATE_LISTING, callingFragment.getString(0x7f0600e5))).message;
        }
        return String.format(callingFragment.getString(0x7f06022f), new Object[] {
            pmapierror
        });
    }

    private void loadInvalidListingMappPage(PMApiResponse pmapiresponse)
    {
        Object obj = pmapiresponse.responseString;
        obj = new Gson();
        pmapiresponse = pmapiresponse.responseString;
        if (!(obj instanceof Gson))
        {
            pmapiresponse = ((PMApiResponse) (((Gson) (obj)).fromJson(pmapiresponse, java/util/HashMap)));
        } else
        {
            pmapiresponse = ((PMApiResponse) (GsonInstrumentation.fromJson((Gson)obj, pmapiresponse, java/util/HashMap)));
        }
        pmapiresponse = (StringMap)((HashMap)pmapiresponse).get("error");
        if (pmapiresponse != null)
        {
            String s = StringUtils.toJson(pmapiresponse);
            if (bIsNewListing)
            {
                pmapiresponse = "create";
            } else
            {
                pmapiresponse = "edit";
            }
            obj = (new StringBuilder()).append("(").append(WebCommandsManager.JAVASCRIPT_NULL).append(")").toString();
            if (newListing.getWebCommandInfo().length() > 0)
            {
                obj = newListing.getWebCommandInfo();
            }
            pmapiresponse = String.format("/mapp/post_validation/error?post_id=%s&flow_type=%s&params=%s&web_command_info=%s", new Object[] {
                newListingId.id, pmapiresponse, s, obj
            });
            obj = new Bundle();
            ((Bundle) (obj)).putString("URL", (new StringBuilder()).append("https://www.poshmark.com").append(pmapiresponse).toString());
            ((Bundle) (obj)).putBoolean("SHOW_REFRESH", true);
            ((PMActivity)callingFragment.getActivity()).launchFragmentForResult(((Bundle) (obj)), com/poshmark/ui/fragments/ListingValidationPageFragment, newListing, callingFragment, 2);
        }
    }

    private void postNewListing()
    {
        NewRelicWrapper.startCustomInteraction(NewRelicCustomInteractions.CREATE_LISTING);
        PMEditListingImageSelectorView pmeditlistingimageselectorview = (PMEditListingImageSelectorView)imageList.get(currentSentImageIndex);
        callingFragment.showProgressDialogWithMessage(callingFragment.getResources().getString(0x7f060176));
        PMApi.postNewListing(pmeditlistingimageselectorview.getFileUri().getPath(), newListing, new PMApiResponseHandler() {

            final ListingManager this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
label0:
                {
                    if (callingFragment.isAdded())
                    {
                        callingFragment.hideProgressDialog();
                        if (pmapiresponse.hasError())
                        {
                            break label0;
                        }
                        newListingId = (ID)pmapiresponse.data;
                        listingId = newListingId.id;
                        pmapiresponse = ListingManager.this;
                        pmapiresponse.currentSentImageIndex = ((ListingManager) (pmapiresponse)).currentSentImageIndex + 1;
                        resumeUpload();
                    }
                    return;
                }
                presentRetryAlert(getRetryMessageForError(pmapiresponse.apiError));
            }

            
            {
                this$0 = ListingManager.this;
                super();
            }
        });
    }

    private void postNewListingNextImage()
    {
        PMEditListingImageSelectorView pmeditlistingimageselectorview;
        if (currentSentImageIndex < imageList.size())
        {
            pmeditlistingimageselectorview = (PMEditListingImageSelectorView)imageList.get(currentSentImageIndex);
        } else
        {
            pmeditlistingimageselectorview = null;
        }
        if (pmeditlistingimageselectorview != null && pmeditlistingimageselectorview.isImageSet())
        {
            callingFragment.showProgressDialogWithMessage(String.format(callingFragment.getResources().getString(0x7f060177), new Object[] {
                Integer.valueOf(currentSentImageIndex + 1)
            }));
            PMApi.postImageToListing(pmeditlistingimageselectorview.getFileUri().getPath(), newListingId.id, new PMApiResponseHandler() {

                final ListingManager this$0;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
label0:
                    {
                        if (callingFragment.isAdded())
                        {
                            callingFragment.hideProgressDialog();
                            if (pmapiresponse.hasError())
                            {
                                break label0;
                            }
                            pmapiresponse = ListingManager.this;
                            pmapiresponse.currentSentImageIndex = ((ListingManager) (pmapiresponse)).currentSentImageIndex + 1;
                            resumeUpload();
                        }
                        return;
                    }
                    presentRetryAlert(getRetryMessageForError(pmapiresponse.apiError));
                }

            
            {
                this$0 = ListingManager.this;
                super();
            }
            });
        }
    }

    private void presentRetryAlert(String s)
    {
        callingFragment.showConfirmationMessage(callingFragment.getString(0x7f0600d0), s, callingFragment.getString(0x7f06022e), callingFragment.getString(0x7f06006d), new android.content.DialogInterface.OnClickListener() {

            final ListingManager this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                if (i == -1)
                {
                    resumeUpload();
                    return;
                } else
                {
                    currentSentImageIndex = 0;
                    return;
                }
            }

            
            {
                this$0 = ListingManager.this;
                super();
            }
        });
    }

    private void publishNewListing()
    {
        callingFragment.showProgressDialogWithMessage(callingFragment.getResources().getString(0x7f060220));
        String s = getCommaSeparatedExternalServiceIdsForShare();
        String s1 = getCommaSeparatedEventIdsForShare();
        PMApi.publishListing(newListingId.id, s, s1, new PMApiResponseHandler() {

            final ListingManager this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
label0:
                {
                    NewRelicWrapper.stopCustomInteraction(NewRelicCustomInteractions.CREATE_LISTING);
                    if (callingFragment.isAdded())
                    {
                        callingFragment.hideProgressDialog();
                        if (pmapiresponse.hasError())
                        {
                            break label0;
                        }
                        Analytics.getInstance().trackEvent("new_listing_screen", "listing", "new_listing_complete", null);
                        pmapiresponse = PMApplication.getHasOffersObject();
                        if (pmapiresponse != null)
                        {
                            pmapiresponse.measureAction("listing");
                        }
                        Singular.trackEvent("listing");
                        AppEventsLogger.newLogger(PMApplication.getContext()).logEvent("listing");
                        ListingNotificationManager.getListingNotificationManager().fireNewListingCreatedMessage();
                        callingFragment.finishActivityWithResult(102, null);
                    }
                    return;
                }
                if (pmapiresponse.apiError.pmErrorType == PMErrorType.INVALID_LISTING)
                {
                    loadInvalidListingMappPage(pmapiresponse);
                    return;
                }
                if (pmapiresponse.apiError.pmErrorType == PMErrorType.BRAND_CHANGE_LIMIT_EXCEEDED)
                {
                    String s2 = PMApplication.getContext().getString(0x7f0600d0);
                    callingFragment.showAlertMessage(s2, pmapiresponse.apiError.getUserMessage());
                    return;
                } else
                {
                    presentRetryAlert(getRetryMessageForError(pmapiresponse.apiError));
                    return;
                }
            }

            
            {
                this$0 = ListingManager.this;
                super();
            }
        });
    }

    private void resumeUpload()
    {
        if (bIsNewListing)
        {
            if (currentSentImageIndex == 0)
            {
                postNewListing();
                return;
            }
            PMEditListingImageSelectorView pmeditlistingimageselectorview;
            if (currentSentImageIndex < imageList.size())
            {
                pmeditlistingimageselectorview = (PMEditListingImageSelectorView)imageList.get(currentSentImageIndex);
            } else
            {
                pmeditlistingimageselectorview = null;
            }
            if (pmeditlistingimageselectorview != null && pmeditlistingimageselectorview.isImageSet())
            {
                postNewListingNextImage();
                return;
            } else
            {
                publishNewListing();
                return;
            }
        } else
        {
            updateListing();
            return;
        }
    }

    private void shareListing()
    {
        String s = getCommaSeparatedExternalServiceIdsForShare();
        String s1 = getCommaSeparatedEventIdsForShare();
        PMApi.shareListing(listingId, s, s1, null, null);
        s = (new StringBuilder()).append(newListingId).append("/").append(newListing.getTitle()).toString();
        if (bShareOnFacebook)
        {
            Analytics.getInstance().trackEvent("listing_confirmation_screen", "listing", "share_listing_facebook", s);
        }
        if (bShareOnTwitter)
        {
            Analytics.getInstance().trackEvent("listing_confirmation_screen", "listing", "share_listing_twitter", s);
        }
        if (bShareOnTumblr)
        {
            Analytics.getInstance().trackEvent("listing_confirmation_screen", "listing", "share_listing_tumblr", s);
        }
        if (bShareOnPinterest)
        {
            Analytics.getInstance().trackEvent("listing_confirmation_screen", "listing", "share_listing_pinterest", s);
        }
    }

    private boolean shouldShareListing()
    {
        while (eventIds != null && eventIds.size() > 0 || bShareOnTwitter || bShareOnFacebook || bShareOnTumblr || bShareOnPinterest) 
        {
            return true;
        }
        return false;
    }

    private void updateListing()
    {
        HashMap hashmap = new HashMap();
        int j = imageList.size();
        int i = 0;
        while (i < j) 
        {
            PMEditListingImageSelectorView pmeditlistingimageselectorview = (PMEditListingImageSelectorView)imageList.get(i);
            new String();
            String s;
            if (i == 0)
            {
                s = "cover_shot";
            } else
            {
                s = (new StringBuilder()).append("picture").append(Integer.toString(i)).toString();
            }
            if (pmeditlistingimageselectorview.isImageSet())
            {
                if (pmeditlistingimageselectorview.getImageUrl() != null)
                {
                    newListing.setKeyValuePair(s, pmeditlistingimageselectorview.getImageId());
                } else
                {
                    hashmap.put(s, pmeditlistingimageselectorview.getFileUri().getPath());
                }
            }
            i++;
        }
        callingFragment.showProgressDialogWithMessage(callingFragment.getResources().getString(0x7f0602b5));
        PMApi.postUpdateListing(listingId, newListing, hashmap, new PMApiResponseHandler() {

            final ListingManager this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
label0:
                {
                    if (callingFragment.isAdded())
                    {
                        callingFragment.hideProgressDialog();
                        if (pmapiresponse.hasError())
                        {
                            break label0;
                        }
                        Analytics.getInstance().trackEvent("new_listing_screen", "listing", "edit_listing_complete", null);
                        ListingNotificationManager.getListingNotificationManager().fireListingEditedMessage(listingId);
                        if (shouldShareListing())
                        {
                            shareListing();
                        }
                        callingFragment.finishActivityWithResult(-1, null);
                    }
                    return;
                }
                presentRetryAlert(getRetryMessageForError(pmapiresponse.apiError));
            }

            
            {
                this$0 = ListingManager.this;
                super();
            }
        });
    }

    public void addEventId(String s)
    {
        if (!eventIds.contains(s))
        {
            eventIds.add(s);
        }
    }

    public NewListing getNewListing()
    {
        return newListing;
    }

    public void handleValidationResult(Bundle bundle)
    {
        if (bundle.getBoolean("FINISH_LISTING"))
        {
            if (shouldShareListing())
            {
                shareListing();
            }
            callingFragment.finishActivityWithResult(-1, null);
        }
    }

    public void postListing(PMFragment pmfragment)
    {
        callingFragment = pmfragment;
        if (bIsNewListing)
        {
            currentSentImageIndex = 0;
            resumeUpload();
            return;
        } else
        {
            updateListing();
            return;
        }
    }

    public void removeEventId(String s)
    {
        if (eventIds.contains(s))
        {
            eventIds.remove(s);
        }
    }

    public void setFacebookShareFlag(boolean flag)
    {
        bShareOnFacebook = flag;
    }

    public void setImageList(List list)
    {
        imageList = list;
    }

    public void setListingDetails(NewListing newlisting, String s)
    {
        newListing = newlisting;
        listingId = s;
    }

    public void setListingFlag(boolean flag)
    {
        bIsNewListing = flag;
    }

    public void setPinterestShareFlag(boolean flag)
    {
        bShareOnPinterest = flag;
    }

    public void setTumblrShareFlag(boolean flag)
    {
        bShareOnTumblr = flag;
    }

    public void setTwitterShareFlag(boolean flag)
    {
        bShareOnTwitter = flag;
    }






}
