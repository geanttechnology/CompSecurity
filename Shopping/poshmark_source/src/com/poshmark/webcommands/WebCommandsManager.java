// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.webcommands;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.config.Env;
import com.poshmark.config.EnvConfig;
import com.poshmark.controllers.GlobalDbController;
import com.poshmark.controllers.GlobalPartiesController;
import com.poshmark.data_model.models.ListingDetails;
import com.poshmark.data_model.models.PMOfferInfo;
import com.poshmark.data_model.models.PartyEvent;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.ListingNotificationManager;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.fragments.AllPartiesFragment;
import com.poshmark.ui.fragments.BrandFragment;
import com.poshmark.ui.fragments.BrandsMetaItemListViewFragment;
import com.poshmark.ui.fragments.CameraPreviewFragment;
import com.poshmark.ui.fragments.CheckoutConfirmationFragment_Offers;
import com.poshmark.ui.fragments.ClosetFragment;
import com.poshmark.ui.fragments.EditProfileFormFragment;
import com.poshmark.ui.fragments.FindFriendsFragment;
import com.poshmark.ui.fragments.FindPeopleFragment;
import com.poshmark.ui.fragments.ListingDetailsFragment;
import com.poshmark.ui.fragments.ListingEditorFragment;
import com.poshmark.ui.fragments.ListingValidationPageFragment;
import com.poshmark.ui.fragments.MappPageFragment;
import com.poshmark.ui.fragments.MyLikesFragment;
import com.poshmark.ui.fragments.PMFragment;
import com.poshmark.ui.fragments.PartyFragment;
import com.poshmark.ui.fragments.PartyInviteFragment;
import com.poshmark.ui.fragments.ShareFragment;
import com.poshmark.ui.fragments.SharingSettingsFragment;
import com.poshmark.ui.fragments.ShowroomFragment;
import com.poshmark.ui.fragments.UserListFragment;
import com.poshmark.ui.fragments.UserSharesFragment;
import com.poshmark.ui.fragments.ViewBundleFragment;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.utils.AndroidContacts;
import com.poshmark.utils.DeepLinkLaunchInfo;
import com.poshmark.utils.DeepLinkUtils;
import com.poshmark.utils.OfferFlowHandler;
import com.poshmark.utils.UIThreadTask;
import com.poshmark.utils.meta_data.BrandsMetaItemPickerInfo;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.poshmark.webcommands:
//            WebCommand, CompleteOfferHandler, StartListingFlowCompletionHandler, TakePictureCompletionHandler, 
//            CommandCompletionHandler

public class WebCommandsManager
{

    public static String JAVASCRIPT_NULL = "null";
    MappPageFragment fragment;
    PMActivity parentActivity;
    Map pendingCommands;

    public WebCommandsManager(PMActivity pmactivity, MappPageFragment mapppagefragment)
    {
        pendingCommands = new HashMap();
        parentActivity = pmactivity;
        fragment = mapppagefragment;
    }

    private void alertForWebView(final WebCommand command)
    {
        UIThreadTask uithreadtask = new UIThreadTask(parentActivity);
        uithreadtask.setCallback(new com.poshmark.utils.UIThreadTask.Callback() {

            final WebCommandsManager this$0;
            final WebCommand val$command;

            public void runOnUIThread(Object obj)
            {
                String s2;
                String s3;
label0:
                {
                    s2 = Uri.decode((String)command.parameters.get("title"));
                    s3 = Uri.decode((String)command.parameters.get("message"));
                    String s = (String)command.parameters.get("cancelButtonTitle");
                    if (s != null)
                    {
                        obj = s;
                        if (s.length() != 0)
                        {
                            break label0;
                        }
                    }
                    obj = parentActivity.getString(0x7f0601e1);
                }
                String s1 = (String)command.parameters.get("okButtonTitle");
                String s4 = (String)command.parameters.get("alertOkCallbackMethodName");
                String s5 = (String)command.parameters.get("alertCancelCallbackMethodName");
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(parentActivity);
                builder.setTitle(s2);
                builder.setMessage(s3);
                builder.setCancelable(false);
                if (s1 != null && s1.length() > 0)
                {
                    builder.setPositiveButton(s1, s4. new android.content.DialogInterface.OnClickListener() {

                        final _cls2 this$1;
                        final String val$okCallback;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            fragment.fireJSCallback((new StringBuilder()).append(okCallback).append("()").toString());
                        }

            
            {
                this$1 = final__pcls2;
                okCallback = String.this;
                super();
            }
                    });
                }
                if (((String) (obj)).length() > 0)
                {
                    builder.setNegativeButton(((CharSequence) (obj)), s5. new android.content.DialogInterface.OnClickListener() {

                        final _cls2 this$1;
                        final String val$cancelCallback;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            fragment.fireJSCallback((new StringBuilder()).append(cancelCallback).append("()").toString());
                        }

            
            {
                this$1 = final__pcls2;
                cancelCallback = String.this;
                super();
            }
                    });
                }
                builder.create().show();
            }

            
            {
                this$0 = WebCommandsManager.this;
                command = webcommand;
                super();
            }
        });
        uithreadtask.execute(command);
    }

    private void cancelListing(WebCommand webcommand)
    {
        if (fragment.getClass() == com/poshmark/ui/fragments/ListingValidationPageFragment)
        {
            ((ListingValidationPageFragment)fragment).cancelListing(webcommand);
        }
    }

    private void checkoutOffer(final WebCommand command)
    {
        final String offerId = (String)command.parameters.get("offer");
        if (offerId != null)
        {
            pendingCommands.put(Integer.valueOf(command.commandHashCode()), command);
            addCompletionHandlerToCommand(command, new CompleteOfferHandler());
            UIThreadTask uithreadtask = new UIThreadTask(parentActivity);
            uithreadtask.setCallback(new com.poshmark.utils.UIThreadTask.Callback() {

                final WebCommandsManager this$0;
                final WebCommand val$command;
                final String val$offerId;

                public void runOnUIThread(Object obj)
                {
                    fragment.showProgressDialogWithMessage(fragment.getString(0x7f060191));
                    PMApi.getOffer(offerId, null, new PMApiResponseHandler() {

                        final _cls12 this$1;

                        public void handleResponse(PMApiResponse pmapiresponse)
                        {
label0:
                            {
                                if (fragment.isAdded())
                                {
                                    fragment.hideProgressDialog();
                                    if (pmapiresponse.hasError())
                                    {
                                        break label0;
                                    }
                                    pmapiresponse = new OfferFlowHandler(fragment, (PMOfferInfo)pmapiresponse.data);
                                    Bundle bundle = new Bundle();
                                    bundle.putInt("CHECKOUT_FORM_MODE", com.poshmark.ui.fragments.CheckoutFormFragment.CHECKOUT_FORM_MODES.CHECKOUT_FORM_MODE_CC_AND_SHIPPING_ADDRESS.ordinal());
                                    parentActivity.launchFragmentInNewActivityForResult(bundle, com/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers, pmapiresponse, fragment, command.commandHashCode());
                                }
                                return;
                            }
                            pmapiresponse = new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.SUBMIT_ORDER, fragment.getString(0x7f0600f4), com.poshmark.ui.model.ActionErrorContext.Severity.HIGH);
                            fragment.showAlertMessage(fragment.getString(0x7f0600d0), ((ActionErrorContext) (pmapiresponse)).message, new android.content.DialogInterface.OnDismissListener() {

                                final _cls1 this$2;

                                public void onDismiss(DialogInterface dialoginterface)
                                {
                                    fragment.reload();
                                }

            
            {
                this$2 = _cls1.this;
                super();
            }
                            });
                        }

            
            {
                this$1 = _cls12.this;
                super();
            }
                    });
                }

            
            {
                this$0 = WebCommandsManager.this;
                offerId = s;
                command = webcommand;
                super();
            }
            });
            uithreadtask.execute(command);
        }
    }

    private void closeNPages(final WebCommand command)
    {
        final int pageCount = Integer.valueOf((String)command.parameters.get("n")).intValue();
        int i = parentActivity.getFragmentStackCount();
        if (pageCount == i)
        {
            parentActivity.finish();
        } else
        if (pageCount < i)
        {
            UIThreadTask uithreadtask = new UIThreadTask(parentActivity);
            uithreadtask.setCallback(new com.poshmark.utils.UIThreadTask.Callback() {

                final WebCommandsManager this$0;
                final WebCommand val$command;
                final int val$pageCount;

                public void runOnUIThread(Object obj)
                {
                    parentActivity.popTopNFragments(pageCount, true);
                    obj = getCurrentVisibleMappPageFragment();
                    if (obj != null && command.parameters.containsKey("callbackMethod"))
                    {
                        ((MappPageFragment) (obj)).fireJSCallback((String)command.parameters.get("callbackMethod"));
                    }
                }

            
            {
                this$0 = WebCommandsManager.this;
                pageCount = i;
                command = webcommand;
                super();
            }
            });
            uithreadtask.execute(command);
            return;
        }
    }

    private boolean closeTillPage(String s)
    {
        int j = parentActivity.getFragmentStackCount();
        boolean flag1 = false;
        int i = 0;
        boolean flag3 = false;
        FragmentManager fragmentmanager = parentActivity.getSupportFragmentManager();
        do
        {
label0:
            {
                boolean flag = flag1;
                if (j > 0)
                {
                    Object obj = (PMFragment)fragmentmanager.findFragmentByTag(Integer.toString(j));
                    if (obj == null || !(obj instanceof MappPageFragment))
                    {
                        break label0;
                    }
                    obj = ((MappPageFragment)obj).getPageName();
                    if (obj == null || !((String) (obj)).equalsIgnoreCase(s))
                    {
                        break label0;
                    }
                    flag = true;
                }
                boolean flag2 = flag3;
                if (flag)
                {
                    flag2 = flag3;
                    if (i > 0)
                    {
                        parentActivity.popTopNFragments(i, true);
                        flag2 = true;
                    }
                }
                return flag2;
            }
            i++;
            j--;
        } while (true);
    }

    private void closeTillPageAndPushWebView(final WebCommand command)
    {
        final String pageName = (String)command.parameters.get("pageName");
        UIThreadTask uithreadtask = new UIThreadTask(parentActivity);
        uithreadtask.setCallback(new com.poshmark.utils.UIThreadTask.Callback() {

            final WebCommandsManager this$0;
            final WebCommand val$command;
            final String val$pageName;

            public void runOnUIThread(Object obj)
            {
                if (closeTillPage(pageName))
                {
                    pushWebView(command);
                }
            }

            
            {
                this$0 = WebCommandsManager.this;
                pageName = s;
                command = webcommand;
                super();
            }
        });
        uithreadtask.execute(command);
    }

    private void closeTillPageAndRefresh(WebCommand webcommand)
    {
        final String pageName = (String)webcommand.parameters.get("pageName");
        UIThreadTask uithreadtask = new UIThreadTask(parentActivity);
        uithreadtask.setCallback(new com.poshmark.utils.UIThreadTask.Callback() {

            final WebCommandsManager this$0;
            final String val$pageName;

            public void runOnUIThread(Object obj)
            {
                closeTillPage(pageName);
                obj = parentActivity.getVisibleFragment();
                if (obj != null && (obj instanceof MappPageFragment))
                {
                    ((MappPageFragment)obj).reload();
                }
            }

            
            {
                this$0 = WebCommandsManager.this;
                pageName = s;
                super();
            }
        });
        uithreadtask.execute(webcommand);
    }

    private void closeWebView(WebCommand webcommand)
    {
        parentActivity.finish();
    }

    private void dismissModal(WebCommand webcommand)
    {
        closeWebView(webcommand);
    }

    private void editListing(final WebCommand command)
    {
        UIThreadTask uithreadtask = new UIThreadTask(parentActivity);
        uithreadtask.setCallback(new com.poshmark.utils.UIThreadTask.Callback() {

            final WebCommandsManager this$0;
            final WebCommand val$command;

            public void runOnUIThread(Object obj)
            {
                obj = (String)command.parameters.get("id");
                if (obj != null)
                {
                    fragment.showProgressDialogWithMessage("Loading...");
                    PMApi.getListingDetails(((String) (obj)), ((_cls1) (obj)). new PMApiResponseHandler() {

                        final _cls14 this$1;
                        final String val$id;

                        public void handleResponse(PMApiResponse pmapiresponse)
                        {
label0:
                            {
                                fragment.hideProgressDialog();
                                if (!pmapiresponse.hasError())
                                {
                                    pmapiresponse = (ListingDetails)pmapiresponse.data;
                                    Object obj = pmapiresponse.getUserId();
                                    com.poshmark.data_model.models.inner_models.Inventory.ListingStatus listingstatus = pmapiresponse.getListingStatus();
                                    if (!((String) (obj)).equals(PMApplicationSession.GetPMSession().getUserId()) || listingstatus == com.poshmark.data_model.models.inner_models.Inventory.ListingStatus.SOLD)
                                    {
                                        break label0;
                                    }
                                    obj = new Bundle();
                                    ((Bundle) (obj)).putBoolean("NEW_LISTING", false);
                                    ((Bundle) (obj)).putString("ID", id);
                                    parentActivity.launchFragmentInNewActivity(((Bundle) (obj)), com/poshmark/ui/fragments/ListingEditorFragment, pmapiresponse);
                                }
                                return;
                            }
                            fragment.showAlertMessage("", "Cannot edit Listing");
                        }

            
            {
                this$1 = final__pcls14;
                id = String.this;
                super();
            }
                    });
                }
            }

            
            {
                this$0 = WebCommandsManager.this;
                command = webcommand;
                super();
            }
        });
        uithreadtask.execute(command);
    }

    private void editMyProfile(WebCommand webcommand)
    {
        webcommand = new Bundle();
        webcommand.putInt("MODE", com.poshmark.ui.fragments.EditProfileFormFragment.PROFILE_MODE.PROFILE_MODE_EDIT.ordinal());
        parentActivity.launchFragmentInNewActivity(webcommand, com/poshmark/ui/fragments/EditProfileFormFragment, null);
    }

    private void executeAPI(WebCommand webcommand)
    {
    }

    private void findPeople(WebCommand webcommand)
    {
        parentActivity.launchFragmentInNewActivity(null, com/poshmark/ui/fragments/FindPeopleFragment, null);
    }

    private void finishedListing(WebCommand webcommand)
    {
        if (fragment.getClass() == com/poshmark/ui/fragments/ListingValidationPageFragment)
        {
            ((ListingValidationPageFragment)fragment).finishedListing(webcommand);
        }
    }

    private void getContacts(final WebCommand command)
    {
        if (!command.parameters.containsKey("callback"))
        {
            command.parameters.put("callback", "pmapp_fetched_contacts");
        }
        final String contactsJson = (new AndroidContacts()).getAllPhoneContacts();
        if (fragment instanceof MappPageFragment)
        {
            UIThreadTask uithreadtask = new UIThreadTask(parentActivity);
            uithreadtask.setCallback(new com.poshmark.utils.UIThreadTask.Callback() {

                final WebCommandsManager this$0;
                final WebCommand val$command;
                final String val$contactsJson;

                public void runOnUIThread(Object obj)
                {
                    fragment.fireJSCallback((new StringBuilder()).append((String)command.parameters.get("callback")).append("(").append(contactsJson).append(",").append(WebCommandsManager.JAVASCRIPT_NULL).append(")").toString());
                }

            
            {
                this$0 = WebCommandsManager.this;
                command = webcommand;
                contactsJson = s;
                super();
            }
            });
            uithreadtask.execute(command);
        }
    }

    private MappPageFragment getCurrentVisibleMappPageFragment()
    {
        PMFragment pmfragment = parentActivity.getVisibleFragment();
        if (pmfragment != null && (pmfragment instanceof MappPageFragment))
        {
            return (MappPageFragment)pmfragment;
        } else
        {
            return null;
        }
    }

    private void gotoNews(WebCommand webcommand)
    {
    }

    private void gotoPartiesList(WebCommand webcommand)
    {
        parentActivity.launchFragmentInNewActivity(null, com/poshmark/ui/fragments/AllPartiesFragment, null);
    }

    private void gotoShareSettings(WebCommand webcommand)
    {
        Bundle bundle = new Bundle();
        bundle.putString("ext_service_id", (String)webcommand.parameters.get("ext_service_id"));
        parentActivity.launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/SharingSettingsFragment, null);
    }

    private void handleDeepLink(WebCommand webcommand)
    {
        webcommand = (String)webcommand.parameters.get("url");
        try
        {
            webcommand = URLDecoder.decode(webcommand, "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (WebCommand webcommand)
        {
            return;
        }
        if (webcommand == null)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        webcommand = Uri.parse(webcommand);
        if (!DeepLinkUtils.isValidDeepLink(webcommand))
        {
            break MISSING_BLOCK_LABEL_87;
        }
        webcommand = DeepLinkUtils.getDeepLinkLaunchInfo(webcommand);
        if (webcommand == null)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        if (PMApplicationSession.GetPMSession().isLoggedIn() && ((DeepLinkLaunchInfo) (webcommand)).fragmentClass != null)
        {
            fragment.getParentActivity().launchFragmentInNewActivity(((DeepLinkLaunchInfo) (webcommand)).bundle, ((DeepLinkLaunchInfo) (webcommand)).fragmentClass, ((DeepLinkLaunchInfo) (webcommand)).data);
        }
    }

    private void hideHUDForWebView(WebCommand webcommand)
    {
        webcommand = new UIThreadTask(parentActivity);
        webcommand.setCallback(new com.poshmark.utils.UIThreadTask.Callback() {

            final WebCommandsManager this$0;

            public void runOnUIThread(Object obj)
            {
                fragment.hideProgressDialog();
            }

            
            {
                this$0 = WebCommandsManager.this;
                super();
            }
        });
        webcommand.execute(null);
    }

    private void loadEventDetails(WebCommand webcommand)
    {
        Bundle bundle;
label0:
        {
            bundle = new Bundle();
            webcommand = (String)webcommand.parameters.get("event");
            bundle.putString("ID", webcommand);
            if (GlobalPartiesController.getGlobalPartiesController().isModelPopulated())
            {
                webcommand = GlobalPartiesController.getGlobalPartiesController().getParty(webcommand);
                if (!webcommand.isFutureEvent())
                {
                    break label0;
                }
                parentActivity.launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/PartyInviteFragment, webcommand);
            }
            return;
        }
        parentActivity.launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/PartyFragment, null);
    }

    private void loadPostDetails(WebCommand webcommand)
    {
        Bundle bundle = new Bundle();
        bundle.putString("ID", (String)webcommand.parameters.get("post"));
        if (webcommand.parameters.containsKey("banner"))
        {
            bundle.putString("banner_json", (String)webcommand.parameters.get("banner"));
        }
        parentActivity.launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/ListingDetailsFragment, null);
    }

    private void loadPurchaseOrderDetails(WebCommand webcommand)
    {
        webcommand = (new StringBuilder()).append("https://www.poshmark.com/mapp/purchases/").append((String)webcommand.parameters.get("order")).append("?pageName=ORDER_DETAILS&pageType=new").toString();
        fragment.launchWebView(webcommand, "order_details_screen");
    }

    private void loadSoldOrderDetails(WebCommand webcommand)
    {
        webcommand = (new StringBuilder()).append("https://www.poshmark.com/mapp/sales/").append((String)webcommand.parameters.get("order")).append("?pageName=ORDER_DETAILS&pageType=new").toString();
        fragment.launchWebView(webcommand, "order_details_screen");
    }

    private void loadUserProfile(WebCommand webcommand)
    {
        Bundle bundle = new Bundle();
        bundle.putString("NAME", (String)webcommand.parameters.get("users"));
        parentActivity.launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/ClosetFragment, null);
    }

    private void loadUserSharedListings(WebCommand webcommand)
    {
        webcommand = (String)webcommand.parameters.get("user");
        if (webcommand != null)
        {
            Bundle bundle = new Bundle();
            bundle.putString("NAME", webcommand);
            parentActivity.launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/UserSharesFragment, null);
        }
    }

    private void openURL(WebCommand webcommand)
    {
        webcommand = (String)webcommand.parameters.get("url");
        String s = URLDecoder.decode(webcommand, "UTF-8");
        webcommand = s;
_L2:
        Object obj = webcommand;
        if (!webcommand.toLowerCase().startsWith("http://"))
        {
            obj = webcommand;
            if (!webcommand.toLowerCase().startsWith("https://"))
            {
                obj = (new StringBuilder()).append("http://").append(webcommand).toString();
            }
        }
        webcommand = Uri.parse(((String) (obj)));
        if (webcommand != null)
        {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(webcommand);
            fragment.startActivity(intent);
        }
        return;
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private WebCommand parseCommand(String s)
    {
        Log.d("WebCommand", s);
        WebCommand webcommand = new WebCommand();
        s = Uri.parse(s);
        Object obj = s.getEncodedAuthority();
        String s1 = s.getEncodedPath();
        Object obj1 = s.getQueryParameterNames();
        webcommand.parameters = new HashMap();
        String s2;
        String s3;
        for (obj1 = ((Set) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); webcommand.parameters.put(s2, s3))
        {
            s2 = (String)((Iterator) (obj1)).next();
            s3 = s.getQueryParameter(s2);
        }

        webcommand.commandName = ((String) (obj)).substring(((String) (obj)).indexOf(".") + 1);
        s = s1.split("/");
        obj = new HashMap();
        int i = 1;
        while (i < s.length) 
        {
            if (i + 1 >= s.length)
            {
                ((Map) (obj)).put(s[i], "");
            } else
            {
                ((Map) (obj)).put(s[i], s[i + 1]);
            }
            i += 2;
        }
        webcommand.parameters.putAll(((Map) (obj)));
        return webcommand;
    }

    private void postNotification(WebCommand webcommand)
    {
        String s = (String)webcommand.parameters.get("name");
        if (s != null && s.equalsIgnoreCase("OfferStatusUpdated"))
        {
            final String listingId = (String)webcommand.parameters.get("post_id");
            if (listingId != null)
            {
                UIThreadTask uithreadtask = new UIThreadTask(parentActivity);
                uithreadtask.setCallback(new com.poshmark.utils.UIThreadTask.Callback() {

                    final WebCommandsManager this$0;
                    final String val$listingId;

                    public void runOnUIThread(Object obj)
                    {
                        ListingNotificationManager.getListingNotificationManager().fireListingEditedMessage(listingId);
                    }

            
            {
                this$0 = WebCommandsManager.this;
                listingId = s;
                super();
            }
                });
                uithreadtask.execute(webcommand);
            }
        }
    }

    private void presentModalWebView(WebCommand webcommand)
    {
        pushWebView(webcommand);
    }

    private void pushWebBrowser(WebCommand webcommand)
    {
        pushWebView(webcommand);
    }

    private void pushWebView(WebCommand webcommand)
    {
        MappPageFragment mapppagefragment = getCurrentVisibleMappPageFragment();
        if (mapppagefragment != null)
        {
            String s1 = Uri.decode((String)webcommand.parameters.get("url"));
            if (s1 != null)
            {
                String s = s1;
                if (!s1.contains("http"))
                {
                    if (s1.startsWith("/"))
                    {
                        s = (new StringBuilder()).append("https://www.poshmark.com").append(s1).toString();
                    } else
                    {
                        mapppagefragment.getUrlAuthority();
                        s = mapppagefragment.getUrlPath();
                        String s2 = mapppagefragment.getLastPathSegment();
                        s = (new StringBuilder()).append("https://www.poshmark.com").append(s.replace(s2, s1)).toString();
                    }
                }
                s1 = Uri.decode((String)webcommand.parameters.get("viewForAnalytics"));
                webcommand = s1;
                if (s1 == null)
                {
                    webcommand = "mapp_screen";
                }
                mapppagefragment.launchWebView(s, webcommand);
            }
        }
    }

    private void removeLeftNavButton(WebCommand webcommand)
    {
    }

    private void removePendingCommand(int i)
    {
        if (pendingCommands.containsKey(Integer.valueOf(i)))
        {
            pendingCommands.remove(Integer.valueOf(i));
        }
    }

    private void removeRightNavButton(WebCommand webcommand)
    {
        removePendingCommand(((Integer)fragment.getNextActionButton().getTag()).intValue());
        webcommand = new UIThreadTask(parentActivity);
        webcommand.setCallback(new com.poshmark.utils.UIThreadTask.Callback() {

            final WebCommandsManager this$0;

            public void runOnUIThread(Object obj)
            {
                fragment.hideAllActionButtons(true);
            }

            
            {
                this$0 = WebCommandsManager.this;
                super();
            }
        });
        webcommand.execute(null);
    }

    private void setNavLeftButton(WebCommand webcommand)
    {
    }

    private void setNavRightButton(WebCommand webcommand)
    {
        if (fragment instanceof MappPageFragment)
        {
            fragment.addActionBarButtonCommand(webcommand);
        }
        UIThreadTask uithreadtask = new UIThreadTask(parentActivity);
        uithreadtask.setCallback(new com.poshmark.utils.UIThreadTask.Callback() {

            final WebCommandsManager this$0;

            public void runOnUIThread(Object obj)
            {
                fragment.hideAllActionButtons(true);
                obj = (WebCommand)obj;
                Button button = fragment.getNextActionButton();
                String s = (String)((WebCommand) (obj)).parameters.get("title");
                if (s != null)
                {
                    button.setText(s);
                }
                button.setTag(obj);
                button.setOnClickListener(new android.view.View.OnClickListener() {

                    final _cls4 this$1;

                    public void onClick(View view)
                    {
                        ((WebCommand)(WebCommand)view.getTag()).handleCommandResults(fragment, null);
                    }

            
            {
                this$1 = _cls4.this;
                super();
            }
                });
            }

            
            {
                this$0 = WebCommandsManager.this;
                super();
            }
        });
        uithreadtask.execute(webcommand);
        webcommand.setCommandCompletionHandler(new CommandCompletionHandler() {

            final WebCommandsManager this$0;

            public void handleCommandResults(MappPageFragment mapppagefragment, WebCommand webcommand1, Intent intent)
            {
                if (mapppagefragment instanceof MappPageFragment)
                {
                    mapppagefragment.fireJSCallback((String)webcommand1.parameters.get("callbackMethod"));
                }
            }

            
            {
                this$0 = WebCommandsManager.this;
                super();
            }
        });
    }

    private void setTitle(WebCommand webcommand)
    {
        fragment.setTitle(Uri.decode((String)webcommand.parameters.get("title")));
    }

    private void showBrandPicker(WebCommand webcommand)
    {
        webcommand = new BrandsMetaItemPickerInfo();
        ((BrandsMetaItemPickerInfo) (webcommand)).allItems.addAll(GlobalDbController.getGlobalDbController().getAllBrands());
        Bundle bundle = new Bundle();
        bundle.putBoolean("SHOW_ALL", false);
        bundle.putInt("META_ITEM_MODE", com.poshmark.ui.fragments.MetaItemListViewFragment.META_ITEM_MODES.BRAND_MODE.ordinal());
        bundle.putBoolean("SEARCH_ENABLED", true);
        parentActivity.launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/BrandsMetaItemListViewFragment, webcommand);
    }

    private void showBundle(WebCommand webcommand)
    {
        Bundle bundle = new Bundle();
        bundle.putString("ID", (String)webcommand.parameters.get("USERS"));
        parentActivity.launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/ViewBundleFragment, null);
    }

    private void showDiscoveredClosets(WebCommand webcommand)
    {
        webcommand = (String)webcommand.parameters.get("user_id");
        if (webcommand != null)
        {
            Bundle bundle = new Bundle();
            bundle.putString("MODE", com.poshmark.ui.fragments.UserListFragment.USER_LIST_MODE.CLOSETS_SHARED_FIRST.name());
            bundle.putString("ID", webcommand);
            parentActivity.launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/UserListFragment, null);
        }
    }

    private void showFBDialog(WebCommand webcommand)
    {
    }

    private void showHUDForWebView(WebCommand webcommand)
    {
        final String message = Uri.decode((String)webcommand.parameters.get("message"));
        webcommand = Uri.decode((String)webcommand.parameters.get("should_disable_navbar"));
        final boolean disableNavigation;
        if (webcommand != null)
        {
            disableNavigation = Boolean.getBoolean(webcommand);
        } else
        {
            disableNavigation = false;
        }
        webcommand = new UIThreadTask(parentActivity);
        webcommand.setCallback(new com.poshmark.utils.UIThreadTask.Callback() {

            final WebCommandsManager this$0;
            final boolean val$disableNavigation;
            final String val$message;

            public void runOnUIThread(Object obj)
            {
                fragment.showProgressDialogWithMessage(message, disableNavigation);
            }

            
            {
                this$0 = WebCommandsManager.this;
                message = s;
                disableNavigation = flag;
                super();
            }
        });
        webcommand.execute(null);
    }

    private void showJustInListingsOfBrand(WebCommand webcommand)
    {
        webcommand = (String)webcommand.parameters.get("Brand");
        webcommand = GlobalDbController.getGlobalDbController().getBrandCanonicalName(Uri.decode(webcommand));
        Bundle bundle = new Bundle();
        bundle.putString("ID", webcommand);
        bundle.putString("MODE", com.poshmark.ui.fragments.BrandFragment.MODE.JUST_IN.toString());
        parentActivity.launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/BrandFragment, null);
    }

    private void showListingsOfBrand(WebCommand webcommand)
    {
        webcommand = (String)webcommand.parameters.get("Brand");
        webcommand = GlobalDbController.getGlobalDbController().getBrandCanonicalName(Uri.decode(webcommand));
        Bundle bundle = new Bundle();
        bundle.putString("ID", webcommand);
        parentActivity.launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/BrandFragment, null);
    }

    private void showMyBundles(WebCommand webcommand)
    {
        webcommand = new Bundle();
        webcommand.putString("MODE", com.poshmark.ui.fragments.MyLikesFragment.MODE.BUNDLES.name());
        parentActivity.launchFragmentInNewActivity(webcommand, com/poshmark/ui/fragments/MyLikesFragment, null);
    }

    private void showMyLikes(WebCommand webcommand)
    {
        parentActivity.launchFragmentInNewActivity(null, com/poshmark/ui/fragments/MyLikesFragment, null);
    }

    private void showNewClosets(WebCommand webcommand)
    {
        Bundle bundle = new Bundle();
        webcommand = (String)webcommand.parameters.get("type");
        if (webcommand != null)
        {
            if (webcommand.equalsIgnoreCase("newly_opened"))
            {
                bundle.putString("MODE", com.poshmark.ui.fragments.UserListFragment.USER_LIST_MODE.NEWLY_OPENED_CLOSETS.name());
            } else
            if (webcommand.equalsIgnoreCase("newly_joined"))
            {
                bundle.putString("MODE", com.poshmark.ui.fragments.UserListFragment.USER_LIST_MODE.NEWLY_JOINED_CLOSETS.name());
            } else
            {
                bundle.putString("MODE", com.poshmark.ui.fragments.UserListFragment.USER_LIST_MODE.NEWLY_OPENED_CLOSETS.name());
            }
        } else
        {
            bundle.putString("MODE", com.poshmark.ui.fragments.UserListFragment.USER_LIST_MODE.NEWLY_OPENED_CLOSETS.name());
        }
        bundle.putString("ID", PMApplicationSession.GetPMSession().getUserId());
        parentActivity.launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/UserListFragment, null);
    }

    private void showOnRampFollowingController(WebCommand webcommand)
    {
        parentActivity.launchFragment(null, com/poshmark/ui/fragments/FindFriendsFragment, null);
    }

    private void showShowroom(WebCommand webcommand)
    {
        webcommand = (String)webcommand.parameters.get("showroomid");
        if (webcommand != null)
        {
            Bundle bundle = new Bundle();
            bundle.putString("ID", webcommand);
            parentActivity.launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/ShowroomFragment, null);
        }
    }

    private void showSuccessHUDForWebView(WebCommand webcommand)
    {
        webcommand = Uri.decode((String)webcommand.parameters.get("message"));
        fragment.showAutoHideSuccessMessage(webcommand);
    }

    private void signOut(WebCommand webcommand)
    {
        final int viewCount = parentActivity.getFragmentStackCount();
        webcommand = new UIThreadTask(parentActivity);
        webcommand.setCallback(new com.poshmark.utils.UIThreadTask.Callback() {

            final WebCommandsManager this$0;
            final int val$viewCount;

            public void runOnUIThread(Object obj)
            {
                if (viewCount > 1)
                {
                    parentActivity.popTopNFragments(viewCount - 1, true);
                }
                parentActivity.onBackPressed();
                PMApi.logout(null);
                PMNotificationManager.fireNotification("com.poshmark.intents.INITIATE_LOGOUT");
            }

            
            {
                this$0 = WebCommandsManager.this;
                viewCount = i;
                super();
            }
        });
        webcommand.execute(null);
    }

    private void startInviteFriendsFlow(WebCommand webcommand)
    {
        webcommand = new Bundle();
        webcommand.putString("MODE", com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_INVITE_FRIENDS.name());
        parentActivity.launchFragmentInNewActivity(webcommand, com/poshmark/ui/fragments/ShareFragment, null);
    }

    private void startListingFlow(WebCommand webcommand)
    {
        pendingCommands.put(Integer.valueOf(webcommand.commandHashCode()), webcommand);
        addCompletionHandlerToCommand(webcommand, new StartListingFlowCompletionHandler());
        webcommand = new Bundle();
        webcommand.putBoolean("NEW_LISTING", true);
        parentActivity.launchFragmentInNewActivity(webcommand, com/poshmark/ui/fragments/ListingEditorFragment, null);
    }

    private void takePicture(WebCommand webcommand)
    {
        pendingCommands.put(Integer.valueOf(webcommand.commandHashCode()), webcommand);
        addCompletionHandlerToCommand(webcommand, new TakePictureCompletionHandler());
        Bundle bundle = new Bundle();
        bundle.putInt("CREATION_MODE", CameraPreviewFragment.CREATE_COVERSHOT);
        parentActivity.launchFragmentInNewActivityForResult(bundle, com/poshmark/ui/fragments/CameraPreviewFragment, null, fragment, webcommand.commandHashCode());
    }

    private void trackAnalyticsEvent(WebCommand webcommand)
    {
        String s = (String)webcommand.parameters.get("Event");
        String s1 = (String)webcommand.parameters.get("Category");
        webcommand = (String)webcommand.parameters.get("Labels");
        String s2 = fragment.getViewNameForAnalytics();
        if (s1 != null && s != null)
        {
            Analytics.getInstance().trackEvent(s2, s1, s, webcommand);
        }
    }

    private void updatePoshPartyReminderSettings(WebCommand webcommand)
    {
        GlobalPartiesController.getGlobalPartiesController().forceRefreshOfEventData();
    }

    public void addCommandToPendingList()
    {
    }

    public void addCompletionHandlerToCommand(WebCommand webcommand, CommandCompletionHandler commandcompletionhandler)
    {
        webcommand.setCommandCompletionHandler(commandcompletionhandler);
    }

    public void fireCommand(WebCommand webcommand)
    {
        try
        {
            getClass().getDeclaredMethod(webcommand.commandName, new Class[] {
                webcommand.getClass()
            }).invoke(this, new Object[] {
                webcommand
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (WebCommand webcommand)
        {
            if (EnvConfig.ENV == Env.STAGE)
            {
                fragment.showAlertMessage("Command Error", (new StringBuilder()).append("command not implemented:").append(webcommand.getMessage()).toString());
            }
            webcommand.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (WebCommand webcommand)
        {
            webcommand.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (WebCommand webcommand)
        {
            webcommand.printStackTrace();
        }
    }

    public Map getPendingCommands()
    {
        return pendingCommands;
    }

    public void handleCommandResult(int i, int j, Intent intent)
    {
        if (j == -1)
        {
            if (pendingCommands.containsKey(Integer.valueOf(i)))
            {
                WebCommand webcommand = (WebCommand)pendingCommands.get(Integer.valueOf(i));
                pendingCommands.remove(Integer.valueOf(i));
                webcommand.handleCommandResults(fragment, intent);
            }
        } else
        if (j == 0 && pendingCommands.containsKey(Integer.valueOf(i)))
        {
            pendingCommands.remove(Integer.valueOf(i));
            return;
        }
    }

    public void launchWebCommand(String s)
    {
        fireCommand(parseCommand(s));
    }

    public void reAttachHandlersToPendingCommands()
    {
        Iterator iterator = pendingCommands.values().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            WebCommand webcommand = (WebCommand)iterator.next();
            if (webcommand.handlerType == CommandCompletionHandler.HandlerType.SIMPLE_CALLBACK)
            {
                Log.d("PM Callback", "simple");
            } else
            if (webcommand.handlerType == CommandCompletionHandler.HandlerType.PICTURE)
            {
                addCompletionHandlerToCommand(webcommand, new TakePictureCompletionHandler());
                Log.d("PM Callback", "picture");
            }
        } while (true);
    }

    public void setParentWebView(MappPageFragment mapppagefragment)
    {
        fragment = mapppagefragment;
        parentActivity = (PMActivity)mapppagefragment.getActivity();
    }

    public void setPendingCommandsMap(Map map)
    {
        pendingCommands = map;
    }




}
