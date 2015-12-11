// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.ebay.common.Preferences;
import com.ebay.common.model.ItemTransaction;
import com.ebay.common.model.OrderShippingInfo;
import com.ebay.common.net.api.trading.LeaveFeedbackParameters;
import com.ebay.common.util.EbayErrorUtil;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.mobile.Item;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.AreYouSureDialogActivity;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.common.eBayRating;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.ImageDataManager;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.ShippingCostsShippingOption;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.util.List;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewBaseActivity, ItemViewCommonProgressAndError, ViewItemDataManager, ViewItemViewData, 
//            ViewItemShippingInfo

public class ItemViewLeaveFeedbackActivity extends ItemViewBaseActivity
    implements TextWatcher, android.view.View.OnClickListener, android.view.View.OnFocusChangeListener, android.view.View.OnKeyListener, android.widget.TextView.OnEditorActionListener
{

    private static final int ACTIVITY_REQUEST_QUERY_NEGATIVE = 11;
    private static final int ACTIVITY_REQUEST_QUERY_NEUTRAL = 10;
    private static final int ACTIVITY_WARNING = 12;
    private static final int MAX_MESSAGE_LENGTH = 80;
    private static final String PARAM_RATING_COMMUNICATION = "communication";
    private static final String PARAM_RATING_DESCRIPTION = "description";
    private static final String PARAM_RATING_SHIPCOST = "shipCost";
    private static final String PARAM_RATING_SHIPSPEED = "shipSpeed";
    private static final String PARAM_TEXT_COMMENT = "comment";
    private static final String PARAM_TYPE = "type";
    private EditText commentEditText;
    private eBayRating communicationRating;
    private boolean defaultFiveStarShippingCostRating;
    private eBayRating descriptionRating;
    private RadioButton eddAffirm;
    private boolean eddAsked;
    private RadioButton eddDeny;
    private TextView eddQuestion;
    private boolean fiveStarShippingCostRatingImmutable;
    private Button leaveFeedbackButton;
    private RadioButton negativeButton;
    private RadioButton neutralButton;
    private RadioButton positiveButton;
    private RadioGroup radioGroup;
    private Button retryButton;
    private Bundle savedInstanceState;
    private boolean seller;
    private eBayRating shippingCostRating;
    private eBayRating shippingSpeedRating;
    private String target;
    private ViewItemDataManager viewItemDataManager;

    public ItemViewLeaveFeedbackActivity()
    {
    }

    public static void StartActivity(Activity activity, ViewItemViewData viewitemviewdata, int i)
    {
        Intent intent = new Intent(activity, com/ebay/mobile/viewitem/ItemViewLeaveFeedbackActivity);
        intent.putExtra("view_item_view_data", viewitemviewdata);
        activity.startActivityForResult(intent, i);
    }

    private void createUI()
    {
        commentEditText = (EditText)findViewById(0x7f10036b);
        Object obj1 = MyApp.getPrefs();
        Object obj;
        boolean flag;
        if (seller)
        {
            obj = "lastFeedbackLeftAsSeller";
        } else
        {
            obj = "lastFeedbackLeftAsBuyer";
        }
        obj = ((Preferences) (obj1)).getUserPref(((String) (obj)), "");
        commentEditText.setText(((CharSequence) (obj)));
        commentEditText.setOnKeyListener(this);
        commentEditText.setOnEditorActionListener(this);
        commentEditText.addTextChangedListener(this);
        shippingSpeedRating = (eBayRating)findViewById(0x7f100367);
        shippingSpeedRating.setOnClickListener(this);
        shippingCostRating = (eBayRating)findViewById(0x7f10036a);
        shippingCostRating.setOnClickListener(this);
        shippingCostRating.setDefaultFiveStarRating(defaultFiveStarShippingCostRating, fiveStarShippingCostRatingImmutable);
        descriptionRating = (eBayRating)findViewById(0x7f100361);
        descriptionRating.setOnClickListener(this);
        communicationRating = (eBayRating)findViewById(0x7f100364);
        communicationRating.setOnClickListener(this);
        leaveFeedbackButton = (Button)setupView(0x7f10036d);
        obj1 = leaveFeedbackButton;
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((Button) (obj1)).setEnabled(flag);
        negativeButton = (RadioButton)setupView(0x7f100359);
        neutralButton = (RadioButton)setupView(0x7f100358);
        positiveButton = (RadioButton)setupView(0x7f100357);
        positiveButton.setButtonDrawable(0x7f0202a7);
        neutralButton.setButtonDrawable(0x7f02028a);
        negativeButton.setButtonDrawable(0x7f02028a);
        radioGroup = (RadioGroup)findViewById(0x7f100356);
        radioGroup.check(radioGroup.findViewById(0x7f100357).getId());
        retryButton = (Button)setupView(0x7f10013f);
        eddAffirm = (RadioButton)setupView(0x7f10035d);
        eddDeny = (RadioButton)setupView(0x7f10035e);
        eddQuestion = (TextView)findViewById(0x7f10035b);
        obj = DeviceConfiguration.getAsync();
        if (!seller && ((DeviceConfiguration) (obj)).get(com.ebay.mobile.dcs.Dcs.Connect.B.eddQuestion))
        {
            setEddQuestionText();
        } else
        {
            eddAsked = false;
        }
        if (seller)
        {
            radioGroup.setVisibility(8);
            findViewById(0x7f10035f).setVisibility(8);
            findViewById(0x7f100362).setVisibility(8);
            findViewById(0x7f100365).setVisibility(8);
            findViewById(0x7f100368).setVisibility(8);
        }
        setTitle(getString(0x7f0705d9, new Object[] {
            target
        }));
        ((TextView)findViewById(0x7f10036c)).setText(getResources().getQuantityString(0x7f080011, 80, new Object[] {
            Integer.valueOf(80)
        }));
        headerStart(0x7f03012f);
        ItemViewCommonProgressAndError.showLayouts(this, ItemViewCommonProgressAndError.LayoutState.NORMAL);
        findViewById(0x7f100016).setVisibility(0);
    }

    private void doLeaveFeedback(int i)
    {
        Object obj1;
        float f1 = 0.0F;
        ItemViewCommonProgressAndError.showLayouts(this, ItemViewCommonProgressAndError.LayoutState.TRANSLUCENT_PROGRESS);
        obj1 = commentEditText.getText().toString();
        Object obj = obj1;
        if (80 < ((String) (obj1)).length())
        {
            obj = ((String) (obj1)).substring(0, 80);
        }
        Preferences preferences = MyApp.getPrefs();
        if (seller)
        {
            obj1 = "lastFeedbackLeftAsSeller";
        } else
        {
            obj1 = "lastFeedbackLeftAsBuyer";
        }
        preferences.setUserPref(((String) (obj)), ((String) (obj1)));
        obj1 = new LeaveFeedbackParameters();
        obj1.itemId = item.id;
        obj1.transactionId = String.valueOf(item.transactionId);
        obj1.targetUser = target;
        obj1.originator = MyApp.getPrefs().getCurrentUser();
        if (!eddAsked)
        {
            obj1.eddType = "EddQuestionWasNotAsked";
        } else
        if (eddAffirm.isChecked())
        {
            obj1.eddType = "BuyerIndicatedItemArrivedWithinEDDRange";
        } else
        if (eddDeny.isChecked())
        {
            obj1.eddType = "BuyerIndicatedItemNotArrivedWithinEDDRange";
        } else
        {
            obj1.eddType = "BuyerDidntProvideAnswer";
        }
        i;
        JVM INSTR tableswitch 2131755863 2131755865: default 168
    //                   2131755863 357
    //                   2131755864 368
    //                   2131755865 379;
           goto _L1 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L4:
        break MISSING_BLOCK_LABEL_379;
_L5:
        obj1.comment = ((String) (obj));
        obj1.descriptionRating = (int)descriptionRating.getValue();
        obj1.communicationRating = (int)communicationRating.getValue();
        float f;
        if (shippingSpeedRating != null)
        {
            f = shippingSpeedRating.getValue();
        } else
        {
            f = 0.0F;
        }
        obj1.shipSpeedRating = (int)f;
        f = f1;
        if (shippingCostRating != null)
        {
            f = shippingCostRating.getValue();
        }
        obj1.shipCostRating = (int)f;
        (new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION)).send(this);
        obj = EbayApiUtil.getTradingApi(this, MyApp.getPrefs().getAuthentication());
        if (viewItemDataManager != null)
        {
            viewItemDataManager.leaveFeedback(((com.ebay.nautilus.domain.net.api.trading.EbayTradingApi) (obj)), ((LeaveFeedbackParameters) (obj1)));
        }
        return;
_L2:
        obj1.feedbackType = "Positive";
          goto _L5
_L3:
        obj1.feedbackType = "Neutral";
          goto _L5
        obj1.feedbackType = "Negative";
          goto _L5
    }

    private void enableLeaveFeedback()
    {
        boolean flag;
        if (commentEditText.getText().toString().trim().length() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        leaveFeedbackButton.setEnabled(flag);
    }

    private void setEddQuestionText()
    {
        String s;
        Object obj;
label0:
        {
            s = getString(0x7f0703a0);
            if (item != null && item.iTransaction != null && item.iTransaction.orderShippingInfo != null)
            {
                obj = item.iTransaction.orderShippingInfo.estimatedMaxDeliveryDate;
                if (obj != null)
                {
                    break label0;
                }
            }
            return;
        }
        obj = DateFormat.getDateInstance().format(((java.util.Date) (obj)));
        eddQuestion.setText(String.format(s, new Object[] {
            obj
        }));
        findViewById(0x7f10035a).setVisibility(0);
        eddAsked = true;
    }

    private void setRadioGroup(int i)
    {
        if (i == negativeButton.getId())
        {
            negativeButton.setButtonDrawable(getResources().getDrawable(0x7f02027f));
            neutralButton.setButtonDrawable(getResources().getDrawable(0x7f02028a));
            positiveButton.setButtonDrawable(getResources().getDrawable(0x7f02028a));
            radioGroup.check(i);
        } else
        {
            if (i == neutralButton.getId())
            {
                negativeButton.setButtonDrawable(getResources().getDrawable(0x7f02028a));
                neutralButton.setButtonDrawable(getResources().getDrawable(0x7f020281));
                positiveButton.setButtonDrawable(getResources().getDrawable(0x7f02028a));
                radioGroup.check(i);
                return;
            }
            if (i == positiveButton.getId())
            {
                negativeButton.setButtonDrawable(getResources().getDrawable(0x7f02028a));
                neutralButton.setButtonDrawable(getResources().getDrawable(0x7f02028a));
                positiveButton.setButtonDrawable(getResources().getDrawable(0x7f0202a7));
                radioGroup.check(i);
                return;
            }
        }
    }

    private View setupView(int i)
    {
        View view = findViewById(i);
        view.setOnClickListener(this);
        view.setOnFocusChangeListener(this);
        return view;
    }

    private void updateFocusOnRadioButtons(View view, boolean flag)
    {
        boolean aflag[][] = (boolean[][])Array.newInstance(Boolean.TYPE, new int[] {
            3, 2
        });
        aflag[0][0] = false;
        aflag[0][1] = false;
        aflag[1][0] = false;
        aflag[1][1] = false;
        aflag[2][0] = false;
        aflag[2][1] = false;
        int i;
        int j;
        int k;
        if (radioGroup.getCheckedRadioButtonId() == negativeButton.getId())
        {
            aflag[0][0] = true;
        } else
        if (radioGroup.getCheckedRadioButtonId() == neutralButton.getId())
        {
            aflag[1][0] = true;
        } else
        {
            aflag[2][0] = true;
        }
        if (view.getId() == negativeButton.getId())
        {
            aflag[0][1] = flag;
        }
        if (view.getId() == neutralButton.getId())
        {
            aflag[1][1] = flag;
        }
        if (view.getId() == positiveButton.getId())
        {
            aflag[2][1] = flag;
        }
        if (!aflag[0][0] && !aflag[0][1])
        {
            i = 0x7f02028a;
        } else
        if (aflag[0][0] && !aflag[0][1])
        {
            i = 0x7f02027f;
        } else
        if (!aflag[0][0] && aflag[0][1])
        {
            i = 0x7f020289;
        } else
        {
            i = 0x7f02027e;
        }
        if (!aflag[1][0] && !aflag[1][1])
        {
            j = 0x7f02028a;
        } else
        if (aflag[1][0] && !aflag[1][1])
        {
            j = 0x7f020281;
        } else
        if (!aflag[1][0] && aflag[1][1])
        {
            j = 0x7f020289;
        } else
        {
            j = 0x7f020280;
        }
        if (!aflag[2][0] && !aflag[2][1])
        {
            k = 0x7f02028a;
        } else
        if (aflag[2][0] && !aflag[2][1])
        {
            k = 0x7f0202a7;
        } else
        if (!aflag[2][0] && aflag[2][1])
        {
            k = 0x7f020289;
        } else
        {
            k = 0x7f0202a6;
        }
        negativeButton.setButtonDrawable(i);
        neutralButton.setButtonDrawable(j);
        positiveButton.setButtonDrawable(k);
    }

    public void afterTextChanged(Editable editable)
    {
        int i = 80 - editable.toString().length();
        ((TextView)findViewById(0x7f10036c)).setText(getResources().getQuantityString(0x7f080011, i, new Object[] {
            Integer.valueOf(i)
        }));
        enableLeaveFeedback();
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public String getTrackingEventName()
    {
        return "LeaveFeedback";
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        i;
        JVM INSTR tableswitch 10 11: default 24
    //                   10 25
    //                   11 37;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        if (j == -1)
        {
            doLeaveFeedback(0x7f100358);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (j == -1)
        {
            doLeaveFeedback(0x7f100359);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void onClick(View view)
    {
        setRadioGroup(view.getId());
        if (view.getId() != negativeButton.getId()) goto _L2; else goto _L1
_L1:
        AreYouSureDialogActivity.StartActivity(this, "", getString(0x7f070187), 12, false, com.ebay.mobile.activities.AreYouSureDialogActivity.DEFAULT_BUTTONS.OK);
_L4:
        return;
_L2:
        if (view.getId() == neutralButton.getId())
        {
            AreYouSureDialogActivity.StartActivity(this, "", getString(0x7f070187), 12, false, com.ebay.mobile.activities.AreYouSureDialogActivity.DEFAULT_BUTTONS.OK);
            return;
        }
        if (view.getId() == positiveButton.getId()) goto _L4; else goto _L3
_L3:
        int i;
        if (view.getId() != leaveFeedbackButton.getId())
        {
            continue; /* Loop/switch isn't completed */
        }
        if (seller)
        {
            doLeaveFeedback(0x7f100357);
            return;
        }
        i = radioGroup.getCheckedRadioButtonId();
        if (i == radioGroup.findViewById(0x7f100359).getId())
        {
            AreYouSureDialogActivity.StartActivity(this, "", getString(0x7f070176), 11, false, com.ebay.mobile.activities.AreYouSureDialogActivity.DEFAULT_BUTTONS.OK_CANCEL);
            return;
        }
        if (i == radioGroup.findViewById(0x7f100358).getId())
        {
            AreYouSureDialogActivity.StartActivity(this, "", getString(0x7f070177), 10, false, com.ebay.mobile.activities.AreYouSureDialogActivity.DEFAULT_BUTTONS.OK_CANCEL);
            return;
        }
        if (i != radioGroup.findViewById(0x7f100357).getId()) goto _L4; else goto _L5
_L5:
        doLeaveFeedback(i);
        return;
        if (view.getId() != retryButton.getId()) goto _L4; else goto _L6
_L6:
        ItemViewCommonProgressAndError.showLayouts(this, ItemViewCommonProgressAndError.LayoutState.NORMAL);
        doLeaveFeedback(radioGroup.getCheckedRadioButtonId());
        return;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030151);
        savedInstanceState = bundle;
        viewData = (ViewItemViewData)getIntent().getParcelableExtra("view_item_view_data");
        initDataManagers();
    }

    public void onDataChanged(ViewItemDataManager viewitemdatamanager, Content content, ViewItemDataManager.ActionHandled actionhandled, boolean flag)
    {
        if (!isFinishing()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        static class _cls1
        {

            static final int $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[];

            static 
            {
                $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled = new int[ViewItemDataManager.ActionHandled.values().length];
                try
                {
                    $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ViewItemDataManager.ActionHandled.INITIAL_LOAD.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ViewItemDataManager.ActionHandled.FEEDBACK_LEFT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        super.onDataChanged(viewitemdatamanager, content, actionhandled, flag);
        if (content.getStatus().hasError())
        {
            break; /* Loop/switch isn't completed */
        }
        switch (_cls1..SwitchMap.com.ebay.mobile.viewitem.ViewItemDataManager.ActionHandled[actionhandled.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            seller = item.isSeller;
            if (seller)
            {
                viewitemdatamanager = item.iTransaction.buyerUserId;
            } else
            {
                viewitemdatamanager = item.sellerUserId;
            }
            target = viewitemdatamanager;
            defaultFiveStarShippingCostRating = false;
            fiveStarShippingCostRatingImmutable = true;
            if (!seller)
            {
                if (item.iTransaction != null && item.iTransaction.selectedShippingOption != null && item.iTransaction.selectedShippingOption.shippingServiceCost != null && (new CurrencyAmount(item.iTransaction.selectedShippingOption.shippingServiceCost)).isZero())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                defaultFiveStarShippingCostRating = flag;
                if (defaultFiveStarShippingCostRating && "NotPaid".equals(item.paidStatus) && item.shippingInfo.orderedOptions != null && item.shippingInfo.orderedOptions.size() > 1)
                {
                    fiveStarShippingCostRatingImmutable = false;
                }
            }
            createUI();
            if (savedInstanceState != null)
            {
                setRadioGroup(savedInstanceState.getInt("type"));
                communicationRating.setValue(savedInstanceState.getInt("communication"));
                shippingSpeedRating.setValue(savedInstanceState.getInt("shipSpeed"));
                shippingCostRating.setValue(savedInstanceState.getInt("shipCost"));
                descriptionRating.setValue(savedInstanceState.getInt("description"));
                commentEditText.setText(savedInstanceState.getString("comment"));
                return;
            }
            break;

        case 2: // '\002'
            setResult(-1);
            finish();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (MyApp.getPrefs().isSignedIn() && EbayErrorUtil.userNotLoggedIn(content.getStatus().getMessages()))
        {
            EbayErrorHandler.handleResultStatus(this, actionhandled.ordinal(), content.getStatus());
        }
        switch (_cls1..SwitchMap.com.ebay.mobile.viewitem.ViewItemDataManager.ActionHandled[actionhandled.ordinal()])
        {
        default:
            showMessage(0, content.getStatus());
            return;

        case 2: // '\002'
            ItemViewCommonProgressAndError.showLayouts(this, ItemViewCommonProgressAndError.updateLayoutForLoaderError(this, content.getStatus()));
            break;
        }
        return;
    }

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        enableLeaveFeedback();
        if (5 == i)
        {
            Util.hideSoftInput(this, commentEditText);
        }
        return false;
    }

    public void onFocusChange(View view, boolean flag)
    {
        updateFocusOnRadioButtons(view, flag);
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        viewItemDataManager = (ViewItemDataManager)datamanagercontainer.initialize(viewData.keyParams, this);
        viewItemDataManager.loadData(this, viewData);
    }

    public boolean onKey(View view, int i, KeyEvent keyevent)
    {
        enableLeaveFeedback();
        if (view.getId() == commentEditText.getId() && Util.IsTabOrReturnOrKnob(i, keyevent))
        {
            Util.hideSoftInput(this, commentEditText);
            return true;
        } else
        {
            return false;
        }
    }

    public void onLoadImageComplete(ImageDataManager imagedatamanager, Content content)
    {
        while (isFinishing() || content == null) 
        {
            return;
        }
        headerSetThumbnail(((com.ebay.nautilus.domain.content.dm.ImageDataManager.ImageInfo)content.getData()).image);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (radioGroup != null)
        {
            bundle.putInt("type", radioGroup.getCheckedRadioButtonId());
        }
        if (communicationRating != null)
        {
            bundle.putInt("communication", (int)communicationRating.getValue());
        }
        if (shippingSpeedRating != null)
        {
            bundle.putInt("shipSpeed", (int)shippingSpeedRating.getValue());
        }
        if (shippingCostRating != null)
        {
            bundle.putInt("shipCost", (int)shippingCostRating.getValue());
        }
        if (descriptionRating != null)
        {
            bundle.putInt("description", (int)descriptionRating.getValue());
        }
        if (commentEditText != null)
        {
            bundle.putString("comment", commentEditText.getText().toString());
        }
        savedInstanceState = bundle;
    }

    protected void onStop()
    {
        if (commentEditText != null)
        {
            Util.hideSoftInput(this, commentEditText);
        }
        super.onStop();
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }
}
