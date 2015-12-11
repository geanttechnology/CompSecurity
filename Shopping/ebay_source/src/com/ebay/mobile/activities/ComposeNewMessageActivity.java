// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.ebay.app.AlertDialogFragment;
import com.ebay.app.DialogFragmentCallback;
import com.ebay.app.ModalProgressFragment;
import com.ebay.common.Preferences;
import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.common.net.api.trading.AddMemberMessageAAQNetLoader;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.myebay.ComposeNewMessageFragment;
import com.ebay.mobile.ui_stuff.UserNotifications;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.dm.MessageFolderContentsDataManager;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.net.EbayResponseError;
import com.ebay.nautilus.domain.net.api.experimentation.Treatment;
import com.ebay.nautilus.shell.app.FwLoaderManager;
import com.ebay.nautilus.shell.content.FwLoader;
import com.ebay.nautilus.shell.content.FwNetLoader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.ebay.mobile.activities:
//            BaseActivity, SignInModalActivity

public class ComposeNewMessageActivity extends BaseActivity
    implements android.content.DialogInterface.OnCancelListener, DialogFragmentCallback, com.ebay.mobile.myebay.ComposeNewMessageFragment.ComposeMessageObserver
{
    public static class MemberMessageRequestParams extends BaseDataMapped
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public MemberMessageRequestParams createFromParcel(Parcel parcel)
            {
                return (MemberMessageRequestParams)DataMapperFactory.readParcelJson(parcel, com/ebay/mobile/activities/ComposeNewMessageActivity$MemberMessageRequestParams);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public MemberMessageRequestParams[] newArray(int i)
            {
                return new MemberMessageRequestParams[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        private String body;
        private boolean isBuyerMessage;
        private Long itemId;
        private String parentMessageId;
        private ArrayList pictureUrls;
        private com.ebay.nautilus.domain.net.api.trading.AddMemberMessageAAQRequest.QuestionType questionType;
        private String recipient;
        private String subject;
        private MemberMessageTrackingInfo trackingData;

        public String getBody()
        {
            return body;
        }

        public Long getItemId()
        {
            return itemId;
        }

        public String getParentMessageId()
        {
            return parentMessageId;
        }

        public ArrayList getPictureUrls()
        {
            return pictureUrls;
        }

        public com.ebay.nautilus.domain.net.api.trading.AddMemberMessageAAQRequest.QuestionType getQuestionType()
        {
            return questionType;
        }

        public String getRecipient()
        {
            return recipient;
        }

        public String getSubject()
        {
            return subject;
        }

        public MemberMessageTrackingInfo getTrackingData()
        {
            return trackingData;
        }

        public boolean isBuyerMessage()
        {
            return isBuyerMessage;
        }

        public MemberMessageRequestParams setBody(String s)
        {
            body = s;
            return this;
        }

        public void setBuyerMessage(boolean flag)
        {
            isBuyerMessage = flag;
        }

        public void setItemId(Long long1)
        {
            itemId = long1;
        }

        public MemberMessageRequestParams setParentMessageId(String s)
        {
            parentMessageId = s;
            return this;
        }

        public MemberMessageRequestParams setPictureUrls(ArrayList arraylist)
        {
            pictureUrls = arraylist;
            return this;
        }

        public MemberMessageRequestParams setQuestionType(com.ebay.nautilus.domain.net.api.trading.AddMemberMessageAAQRequest.QuestionType questiontype)
        {
            questionType = questiontype;
            return this;
        }

        public void setRecipient(String s)
        {
            recipient = s;
        }

        public MemberMessageRequestParams setSubject(String s)
        {
            subject = s;
            return this;
        }

        public MemberMessageRequestParams setTrackingData(MemberMessageTrackingInfo membermessagetrackinginfo)
        {
            trackingData = membermessagetrackinginfo;
            return this;
        }










        private MemberMessageRequestParams()
        {
        }

        public MemberMessageRequestParams(Long long1, String s, String s1, String s2, boolean flag)
        {
            itemId = long1;
            recipient = s1;
            body = s2;
            questionType = com.ebay.nautilus.domain.net.api.trading.AddMemberMessageAAQRequest.QuestionType.General;
            isBuyerMessage = flag;
        }
    }

    public static final class MemberMessageTagValues extends Enum
    {

        private static final MemberMessageTagValues $VALUES[];
        public static final MemberMessageTagValues BUYER_ASK_QUESTION;
        public static final MemberMessageTagValues PAYMENT_REMINDER;
        public static final MemberMessageTagValues SELLER_REPLY;

        public static MemberMessageTagValues valueOf(String s)
        {
            return (MemberMessageTagValues)Enum.valueOf(com/ebay/mobile/activities/ComposeNewMessageActivity$MemberMessageTagValues, s);
        }

        public static MemberMessageTagValues[] values()
        {
            return (MemberMessageTagValues[])$VALUES.clone();
        }

        static 
        {
            BUYER_ASK_QUESTION = new MemberMessageTagValues("BUYER_ASK_QUESTION", 0);
            SELLER_REPLY = new MemberMessageTagValues("SELLER_REPLY", 1);
            PAYMENT_REMINDER = new MemberMessageTagValues("PAYMENT_REMINDER", 2);
            $VALUES = (new MemberMessageTagValues[] {
                BUYER_ASK_QUESTION, SELLER_REPLY, PAYMENT_REMINDER
            });
        }

        private MemberMessageTagValues(String s, int i)
        {
            super(s, i);
        }
    }

    public static class MemberMessageTrackingInfo extends BaseDataMapped
        implements Parcelable
    {

        public static android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public MemberMessageTrackingInfo createFromParcel(Parcel parcel)
            {
                return (MemberMessageTrackingInfo)DataMapperFactory.readParcelJson(parcel, com/ebay/mobile/activities/ComposeNewMessageActivity$MemberMessageTrackingInfo);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public MemberMessageTrackingInfo[] newArray(int i)
            {
                return new MemberMessageTrackingInfo[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        private String askSellerExperimentState;
        private String currentPrice;
        private Map messageTagInfo;
        private String primaryCategoryId;
        private SourceIdentification sid;
        private String siteId;

        public String getAskSellerExperimentState()
        {
            return askSellerExperimentState;
        }

        public String getCurrentPrice()
        {
            return currentPrice;
        }

        public Map getMessageTag()
        {
            return messageTagInfo;
        }

        public String getPrimaryCategoryId()
        {
            return primaryCategoryId;
        }

        public SourceIdentification getSid()
        {
            return sid;
        }

        public String getSiteId()
        {
            return siteId;
        }

        public MemberMessageTrackingInfo setAskSellerExperimentState(String s)
        {
            askSellerExperimentState = s;
            return this;
        }

        public void setCurrentPrice(String s)
        {
            currentPrice = s;
        }

        public void setMessageTag(Map map)
        {
            messageTagInfo = map;
        }

        public void setPrimaryCategoryId(String s)
        {
            primaryCategoryId = s;
        }

        public void setSid(SourceIdentification sourceidentification)
        {
            sid = sourceidentification;
        }

        public void setSiteId(String s)
        {
            siteId = s;
        }



        public MemberMessageTrackingInfo()
        {
        }

        public MemberMessageTrackingInfo(String s, String s1, String s2)
        {
            currentPrice = s;
            siteId = s1;
            primaryCategoryId = s2;
        }
    }


    private static final int ACTIVITY_REQUEST_SIGN_IN_BEFORE_ACTION = 2;
    private static final int LOADER_ID_ADD_MESSAGE = 1;
    private static final int MESSAGE_CANCEL_REQUEST_DIALOG = 4;
    private static final int MESSAGE_SEND_ERROR_DIALOG = 3;
    private static final String PARAM_MESSAGE_HIDE_PHOTO_LAYOUT = "message_hide_photo_layout";
    private static final String PARAM_MESSAGE_REQUEST_PARAM = "message_request_param";
    private static final String PARAM_MESSAGE_SUBJECT = "message_subject";
    private static final String PARAM_MESSAGE_TEXT = "param_input";
    private static final String PARAM_MESSAGE_TYPE = "message_type";
    private static final String TAG_COMPOSE_FRAGMENT = "compose_fragment";
    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("ComposeNewMessageAct", 4, "Compose New Message Activity");
    private ComposeNewMessageFragment composeNewMessageFragment;
    private boolean isCustomMessage;
    private boolean isHideAddPhotos;
    private boolean isTablet;
    private MemberMessageRequestParams requestParams;
    private boolean shouldEnableSend;

    public ComposeNewMessageActivity()
    {
        shouldEnableSend = false;
        isCustomMessage = false;
        isHideAddPhotos = false;
        isTablet = false;
    }

    public static void StartActivity(Activity activity, int i, boolean flag, MemberMessageRequestParams membermessagerequestparams)
    {
        Intent intent = new Intent(activity, com/ebay/mobile/activities/ComposeNewMessageActivity);
        intent.putExtra("message_request_param", membermessagerequestparams);
        intent.putExtra("message_type", flag);
        activity.startActivityForResult(intent, i);
    }

    public static void StartActivity(Activity activity, MemberMessageRequestParams membermessagerequestparams)
    {
        StartActivity(activity, -1, false, membermessagerequestparams);
    }

    public static void StartActivity(Fragment fragment, int i, boolean flag, MemberMessageRequestParams membermessagerequestparams)
    {
        StartActivity(fragment, i, flag, false, membermessagerequestparams);
    }

    public static void StartActivity(Fragment fragment, int i, boolean flag, boolean flag1, MemberMessageRequestParams membermessagerequestparams)
    {
        Intent intent = new Intent(fragment.getActivity(), com/ebay/mobile/activities/ComposeNewMessageActivity);
        intent.putExtra("message_request_param", membermessagerequestparams);
        intent.putExtra("message_type", flag);
        intent.putExtra("message_hide_photo_layout", flag1);
        fragment.startActivityForResult(intent, i);
    }

    public static String getInput(Intent intent)
    {
        if (intent != null)
        {
            return intent.getStringExtra("param_input");
        } else
        {
            return "";
        }
    }

    public static ArrayList getPictureUrls(Intent intent)
    {
        if (intent != null)
        {
            return intent.getStringArrayListExtra("photourls");
        } else
        {
            return new ArrayList();
        }
    }

    public static String getSubject(Intent intent)
    {
        if (intent != null)
        {
            return intent.getStringExtra("message_subject");
        } else
        {
            return "";
        }
    }

    private void initiateSend()
    {
label0:
        {
            if (composeNewMessageFragment != null)
            {
                requestParams.setBody(composeNewMessageFragment.getMessage()).setSubject(composeNewMessageFragment.getSubject()).setPictureUrls(composeNewMessageFragment.getPhotoUrls()).setQuestionType(composeNewMessageFragment.getSubjectType());
                UserNotifications.showToast(this, getString(0x7f070109), false, true);
                if (!requestParams.isBuyerMessage)
                {
                    break label0;
                }
                sendBuyerMessage(requestParams);
            }
            return;
        }
        sendSellerMessage(requestParams);
    }

    private void sendBuyerMessage(MemberMessageRequestParams membermessagerequestparams)
    {
        Authentication authentication = MyApp.getPrefs().getAuthentication();
        if (authentication == null)
        {
            startActivityForResult(SignInModalActivity.getIntentForSignIn("M2M", this), 2);
        } else
        if (authentication.user.equals(membermessagerequestparams.recipient))
        {
            if (logger.isLoggable)
            {
                logger.log("sendBuyerMessage: sending a buyer message to ourself;");
                return;
            }
        } else
        {
            trackM2MEvent(membermessagerequestparams);
            membermessagerequestparams = new AddMemberMessageAAQNetLoader(getEbayContext(), EbayApiUtil.getTradingApi(this, authentication), membermessagerequestparams.questionType, membermessagerequestparams.isBuyerMessage, membermessagerequestparams.itemId, membermessagerequestparams.recipient, membermessagerequestparams.subject, membermessagerequestparams.body, membermessagerequestparams.pictureUrls, membermessagerequestparams.parentMessageId);
            getFwLoaderManager().start(1, membermessagerequestparams, false);
            return;
        }
    }

    private void sendSellerMessage(MemberMessageRequestParams membermessagerequestparams)
    {
        Authentication authentication = MyApp.getPrefs().getAuthentication();
        if (authentication == null)
        {
            startActivityForResult(SignInModalActivity.getIntentForSignIn("M2M", this), 77);
        } else
        {
            trackM2MEvent(membermessagerequestparams);
            if (authentication.user.equals(membermessagerequestparams.recipient))
            {
                if (logger.isLoggable)
                {
                    logger.log("sendSellerMessage: sending a seller message to ourself;");
                    return;
                }
            } else
            {
                membermessagerequestparams = new AddMemberMessageAAQNetLoader(getEbayContext(), EbayApiUtil.getTradingApi(this, authentication), membermessagerequestparams.questionType, membermessagerequestparams.isBuyerMessage, membermessagerequestparams.itemId, membermessagerequestparams.recipient, membermessagerequestparams.subject, membermessagerequestparams.body, membermessagerequestparams.pictureUrls, membermessagerequestparams.parentMessageId);
                getFwLoaderManager().start(1, membermessagerequestparams, true);
                return;
            }
        }
    }

    private void showDialog(String s, String s1, String s2, int i)
    {
        showDialog(null, s, s1, s2, i);
    }

    private void showDialog(String s, String s1, String s2, String s3, int i)
    {
        com.ebay.app.AlertDialogFragment.Builder builder = new com.ebay.app.AlertDialogFragment.Builder();
        builder.setMessage(s1);
        builder.setPositiveButton(s2);
        if (s != null)
        {
            builder.setTitle(s);
        }
        if (s3 != null)
        {
            builder.setNegativeButton(s3);
        }
        builder.createFromActivity(i).show(getFragmentManager(), null);
    }

    private void showProgress(boolean flag)
    {
        if (flag)
        {
            ModalProgressFragment.show(getFragmentManager(), this);
            return;
        } else
        {
            ModalProgressFragment.hide(getFragmentManager());
            return;
        }
    }

    private void trackM2MEvent(MemberMessageRequestParams membermessagerequestparams)
    {
        if (membermessagerequestparams.getTrackingData() != null)
        {
            MemberMessageTrackingInfo membermessagetrackinginfo = membermessagerequestparams.getTrackingData();
            TrackingData trackingdata = new TrackingData("M2M", TrackingType.EVENT);
            Object obj;
            boolean flag;
            if (membermessagetrackinginfo.getMessageTag() != null)
            {
                obj = membermessagetrackinginfo.getMessageTag().entrySet();
            } else
            {
                obj = new HashSet();
            }
            flag = false;
            obj = ((Set) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj)).next();
                trackingdata.addKeyValuePair((String)entry.getKey(), String.valueOf(((MemberMessageTagValues)entry.getValue()).ordinal()));
                if (entry.getValue() == MemberMessageTagValues.BUYER_ASK_QUESTION)
                {
                    flag = true;
                }
            } while (true);
            if (flag)
            {
                trackingdata.addKeyValuePair("itm", String.valueOf(membermessagerequestparams.getItemId()));
                trackingdata.addKeyValuePair("shipsiteid", (new StringBuilder()).append("").append(EbaySite.getInstanceFromId(membermessagetrackinginfo.getSiteId()).idInt).toString());
                trackingdata.addKeyValuePair("curprice", (new StringBuilder()).append("").append(Double.parseDouble(membermessagetrackinginfo.getCurrentPrice())).toString());
                trackingdata.addKeyValuePair("leaf", (new StringBuilder()).append("").append(membermessagetrackinginfo.getPrimaryCategoryId()).toString());
            }
            membermessagerequestparams = membermessagetrackinginfo.askSellerExperimentState;
            if (!TextUtils.isEmpty(membermessagerequestparams))
            {
                membermessagerequestparams = Treatment.fromString(membermessagerequestparams);
                if (membermessagerequestparams != null)
                {
                    trackingdata.addExperimentEventTargetTags(membermessagerequestparams);
                }
            }
            membermessagerequestparams = membermessagetrackinginfo.getSid();
            if (membermessagerequestparams != null)
            {
                trackingdata.addSourceIdentification(membermessagerequestparams);
            }
            trackingdata.send(this);
        } else
        if (logger.isLoggable)
        {
            logger.log("M2M message: Tracking data is missing");
            return;
        }
    }

    private void updateSentMessageFolder()
    {
        Object obj = new com.ebay.nautilus.domain.content.dm.MessageFolderContentsDataManager.KeyParams(1L);
        obj = (MessageFolderContentsDataManager)MessageFolderContentsDataManager.getIfExists(getEbayContext(), ((com.ebay.nautilus.domain.content.DataManager.DataManagerKeyParams) (obj)));
        if (obj != null)
        {
            ((MessageFolderContentsDataManager) (obj)).reloadData();
        }
    }

    protected void createUI()
    {
        Object obj = requestParams.body;
        String s = requestParams.subject;
        composeNewMessageFragment = (ComposeNewMessageFragment)getFragmentManager().findFragmentByTag("compose.fragment");
        if (composeNewMessageFragment == null)
        {
            composeNewMessageFragment = ComposeNewMessageFragment.newInstance(((String) (obj)), s, requestParams.recipient, isCustomMessage, isHideAddPhotos);
            obj = getFragmentManager().beginTransaction();
            ((FragmentTransaction) (obj)).add(0x7f10014b, composeNewMessageFragment, "compose_fragment");
            ((FragmentTransaction) (obj)).commit();
        }
        shouldEnableSend = isCustomMessage;
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        i;
        JVM INSTR tableswitch 2 2: default 28
    //                   2 29;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (j == -1)
        {
            initiateSend();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onBackPressed()
    {
        if (composeNewMessageFragment != null && composeNewMessageFragment.isMessageEdited())
        {
            onCancelClicked();
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        dialoginterface = getFwLoaderManager().getRunningLoader(1);
        if (dialoginterface != null)
        {
            dialoginterface.cancel(true);
        }
    }

    public void onCancelClicked()
    {
        if (composeNewMessageFragment != null && composeNewMessageFragment.isMessageEdited())
        {
            showDialog(getString(0x7f07060c), getString(0x7f070738), getString(0x7f0701cc), 4);
            return;
        } else
        {
            finish();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        isTablet = getResources().getBoolean(0x7f0b0006);
        if (!isTablet)
        {
            setTheme(0x7f0a002b);
        }
        super.onCreate(bundle);
        setContentView(0x7f03007f);
        Intent intent = getIntent();
        requestParams = (MemberMessageRequestParams)intent.getParcelableExtra("message_request_param");
        isCustomMessage = intent.getBooleanExtra("message_type", false);
        isHideAddPhotos = intent.getBooleanExtra("message_hide_photo_layout", false);
        if (bundle == null)
        {
            createUI();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f110001, menu);
        return true;
    }

    protected void onDestroy()
    {
        super.onDestroy();
        showProgress(false);
    }

    public void onDialogFragmentResult(DialogFragment dialogfragment, int i, int j)
    {
        i;
        JVM INSTR tableswitch 3 4: default 24
    //                   3 35
    //                   4 25;
           goto _L1 _L2 _L3
_L1:
        return;
_L3:
        if (j == 1)
        {
            finish();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (j == 1)
        {
            dialogfragment.dismiss();
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void onEnableSendButton(boolean flag)
    {
        shouldEnableSend = flag;
        invalidateOptionsMenu();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        int i = menuitem.getItemId();
        if (i == 0x7f1009e7)
        {
            initiateSend();
            return true;
        }
        if (i == 0x7f100814)
        {
            onCancelClicked();
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        menu.findItem(0x7f1009e7).setEnabled(shouldEnableSend);
        return true;
    }

    public void onRegisterFragment(ComposeNewMessageFragment composenewmessagefragment)
    {
        if (composeNewMessageFragment == null)
        {
            composeNewMessageFragment = composenewmessagefragment;
        }
    }

    public void onSendClicked()
    {
        initiateSend();
    }

    protected void onTaskComplete(int i, FwLoader fwloader)
    {
        if (!isFinishing())
        {
            showProgress(false);
            if ((fwloader instanceof FwNetLoader) && !((FwNetLoader)fwloader).isError() && i == 1)
            {
                UserNotifications.showToast(this, getString(0x7f070617), false, true);
                updateSentMessageFolder();
                setResult(-1);
                finish();
                return;
            }
            if (fwloader instanceof EbaySimpleNetLoader)
            {
                fwloader = (EbaySimpleNetLoader)fwloader;
                if (Util.checkForIAFTokenError(fwloader))
                {
                    MyApp.signOutForIafTokenFailure(this);
                    return;
                }
                if (!Util.hasNetwork() && i == 1)
                {
                    showNetworkErrorToast();
                    return;
                }
                fwloader = fwloader.getServiceErrorsAndWarnings();
                Object obj;
                if (fwloader != null && fwloader.size() > 0)
                {
                    fwloader = ((EbayResponseError)fwloader.get(0)).longMessage;
                } else
                {
                    fwloader = null;
                }
                obj = fwloader;
                if (fwloader == null)
                {
                    obj = getString(0x7f070635);
                }
                showDialog(getString(0x7f070629), ((String) (obj)), getString(0x7f070738), null, 3);
                return;
            }
        }
    }

    protected void onTaskStarted(int i, FwLoader fwloader)
    {
        super.onTaskStarted(i, fwloader);
        if (i == 1)
        {
            showProgress(true);
        }
    }

}
