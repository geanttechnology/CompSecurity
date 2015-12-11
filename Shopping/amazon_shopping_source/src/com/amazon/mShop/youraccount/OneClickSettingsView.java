// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.youraccount;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.AmazonAlertDialog;
import com.amazon.mShop.InfoView;
import com.amazon.mShop.TaskCallbackFactory;
import com.amazon.mShop.TitleProvider;
import com.amazon.mShop.control.account.OneClickController;
import com.amazon.mShop.home.GatewayActivity;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.ui.resources.AddressFormat;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.AmazonErrorUtils;
import com.amazon.mShop.util.ConfigUtils;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.OneClickConfigResponse;
import java.util.List;

// Referenced classes of package com.amazon.mShop.youraccount:
//            ShippingPaymentMethodView

public class OneClickSettingsView extends ScrollView
    implements TitleProvider, com.amazon.mShop.control.account.OneClickController.OneClickSubscriber
{

    private final AmazonActivity amazonActivity;
    private OneClickController controller;
    private final EditText deviceNameEdit;
    private final TextView digitalOneClickExplanation;
    private final CompoundButton oneClickOnOffButton;
    private final ViewGroup oneClickOnOffContainer;
    private final LinearLayout oneClickSettingWholeRow;
    private final TextView shippingAndPaymentsView;
    private final boolean swapView;
    private final TaskCallbackFactory taskCallback;
    private boolean viewDisplayed;

    public OneClickSettingsView(final AmazonActivity amazonActivity, boolean flag)
    {
        super(amazonActivity);
        this.amazonActivity = amazonActivity;
        swapView = flag;
        addView((ViewGroup)LayoutInflater.from(getContext()).inflate(com.amazon.mShop.android.lib.R.layout.oneclick_settings, null));
        controller = new OneClickController(this);
        taskCallback = new TaskCallbackFactory(amazonActivity);
        if (!controller.hasServiceCallRunning())
        {
            controller.doGetOneClickConfig(taskCallback.getTaskCallback(controller, com.amazon.mShop.android.lib.R.string.one_click_settings_loading));
        }
        oneClickOnOffContainer = (ViewGroup)findViewById(com.amazon.mShop.android.lib.R.id.oneclick_settings_toggle_container);
        oneClickSettingWholeRow = (LinearLayout)findViewById(com.amazon.mShop.android.lib.R.id.oneclick_settings_whole_row);
        oneClickSettingWholeRow.setOnClickListener(new android.view.View.OnClickListener() {

            final OneClickSettingsView this$0;

            public void onClick(View view)
            {
                view = OneClickSettingsView.this;
                boolean flag1;
                if (!controller.isOneClickStatusEnabled())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                view.setOneClickSetting(flag1);
            }

            
            {
                this$0 = OneClickSettingsView.this;
                super();
            }
        });
        oneClickOnOffButton = (CompoundButton)findViewById(com.amazon.mShop.android.lib.R.id.oneclick_settings_toggle_button);
        oneClickOnOffButton.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final OneClickSettingsView this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag1)
            {
                if (flag1 != controller.isOneClickStatusEnabled())
                {
                    setOneClickSetting(flag1);
                    if (!flag1 && ConfigUtils.isDigitalContentEnabled())
                    {
                        (new com.amazon.mShop.AmazonAlertDialog.Builder(getContext())).setTitle(com.amazon.mShop.android.lib.R.string.one_click_settings_pop_up_title).setMessage(com.amazon.mShop.android.lib.R.string.one_click_settings_pop_up_message).setNeutralButton(com.amazon.mShop.android.lib.R.string.alert_ok_button, null).create().show();
                    }
                }
            }

            
            {
                this$0 = OneClickSettingsView.this;
                super();
            }
        });
        digitalOneClickExplanation = (TextView)findViewById(com.amazon.mShop.android.lib.R.id.digital_oneclick_explanation);
        if (ConfigUtils.isDigitalContentEnabled())
        {
            digitalOneClickExplanation.setVisibility(0);
        } else
        {
            digitalOneClickExplanation.setVisibility(8);
        }
        deviceNameEdit = (EditText)findViewById(com.amazon.mShop.android.lib.R.id.oneclick_settings_device_name);
        shippingAndPaymentsView = (TextView)findViewById(com.amazon.mShop.android.lib.R.id.oneclick_settings_shipping_and_payments_data);
        shippingAndPaymentsView.setOnClickListener(new android.view.View.OnClickListener() {

            final OneClickSettingsView this$0;
            final AmazonActivity val$amazonActivity;

            public void onClick(View view)
            {
                if (!controller.isDeviceNameSet())
                {
                    controller.setDeviceName(deviceNameEdit.getText().toString());
                }
                if (!controller.hasServiceCallRunning())
                {
                    controller.doGetOneClickAddresses(taskCallback.getPopViewTaskCallback(controller, amazonActivity, com.amazon.mShop.android.lib.R.string.one_click_settings_loading_shipping_addresses));
                }
            }

            
            {
                this$0 = OneClickSettingsView.this;
                amazonActivity = amazonactivity;
                super();
            }
        });
        ((Button)findViewById(com.amazon.mShop.android.lib.R.id.oneclick_settings_about_button)).setOnClickListener(new android.view.View.OnClickListener() {

            final OneClickSettingsView this$0;

            public void onClick(View view)
            {
                performAboutOneClick();
            }

            
            {
                this$0 = OneClickSettingsView.this;
                super();
            }
        });
    }

    public OneClickSettingsView(final AmazonActivity amazonActivity, boolean flag, boolean flag1)
    {
        this(amazonActivity, flag);
        if (flag1)
        {
            Button button = (Button)findViewById(com.amazon.mShop.android.lib.R.id.continue_button);
            button.setOnClickListener(new android.view.View.OnClickListener() {

                final OneClickSettingsView this$0;
                final AmazonActivity val$amazonActivity;

                public void onClick(View view)
                {
                    ActivityUtils.startHomeActivity(amazonActivity);
                }

            
            {
                this$0 = OneClickSettingsView.this;
                amazonActivity = amazonactivity;
                super();
            }
            });
            button.setVisibility(0);
        }
    }

    private void performAboutOneClick()
    {
        InfoView infoview = new InfoView(amazonActivity, com.amazon.mShop.android.lib.R.string.one_click_settings_about_title, com.amazon.mShop.android.lib.R.string.one_click_settings_about_text);
        amazonActivity.pushView(infoview);
    }

    private void setOneClickSetting(boolean flag)
    {
        if (!controller.hasServiceCallRunning())
        {
            if (!controller.isDeviceNameSet())
            {
                controller.setDeviceName(deviceNameEdit.getText().toString());
            }
            Object obj;
            TaskCallbackFactory taskcallbackfactory;
            OneClickController oneclickcontroller;
            AmazonActivity amazonactivity;
            int i;
            if (flag)
            {
                obj = "1clk_on";
            } else
            {
                obj = "1clk_off";
            }
            RefMarkerObserver.logRefMarker(((String) (obj)));
            obj = controller;
            taskcallbackfactory = taskCallback;
            oneclickcontroller = controller;
            amazonactivity = amazonActivity;
            if (flag)
            {
                i = com.amazon.mShop.android.lib.R.string.one_click_settings_turning_on;
            } else
            {
                i = com.amazon.mShop.android.lib.R.string.one_click_settings_turning_off;
            }
            ((OneClickController) (obj)).doSetOneClickEnabled(flag, taskcallbackfactory.getPopViewTaskCallback(oneclickcontroller, amazonactivity, i));
        }
    }

    private void showSettingsViewIfNotDisplayed()
    {
        if (!viewDisplayed)
        {
            if (swapView && !(amazonActivity instanceof GatewayActivity))
            {
                amazonActivity.swapView(this);
            } else
            {
                amazonActivity.pushView(this);
            }
            viewDisplayed = true;
        }
    }

    private void updateUI()
    {
        Object obj = controller.getOneClickConfigResponse();
        if (obj == null)
        {
            Log.e("Amazon.OnceClickSettingsView.updateUI", "oneClickConfig is null");
            if (viewDisplayed)
            {
                amazonActivity.popView();
            }
            return;
        }
        com.amazon.rio.j2me.client.services.mShop.Address address;
        com.amazon.rio.j2me.client.services.mShop.PaymentMethod paymentmethod;
        if (controller.isDeviceNameSet())
        {
            deviceNameEdit.setText(controller.getDeviceName());
            deviceNameEdit.setEnabled(false);
            deviceNameEdit.setFocusable(false);
            deviceNameEdit.setFocusableInTouchMode(false);
            deviceNameEdit.setBackgroundColor(amazonActivity.getResources().getColor(com.amazon.mShop.android.lib.R.color.background_default));
        } else
        {
            deviceNameEdit.setText(OneClickController.getDefaultDeviceName());
            deviceNameEdit.setEnabled(true);
            deviceNameEdit.setBackgroundDrawable(amazonActivity.getResources().getDrawable(com.amazon.mShop.android.lib.R.drawable.edit_text));
        }
        address = ((OneClickConfigResponse) (obj)).getAddress();
        paymentmethod = ((OneClickConfigResponse) (obj)).getPaymentMethod();
        if (address == null)
        {
            if (controller.isOneClickStatusEnabled())
            {
                oneClickOnOffContainer.setVisibility(0);
                oneClickOnOffButton.setChecked(controller.isOneClickStatusEnabled());
            } else
            {
                oneClickOnOffContainer.setVisibility(8);
            }
            shippingAndPaymentsView.setEnabled(true);
            shippingAndPaymentsView.setFocusable(true);
            shippingAndPaymentsView.setClickable(true);
            shippingAndPaymentsView.setText(com.amazon.mShop.android.lib.R.string.one_click_settings_shipping_and_payments_empty);
            shippingAndPaymentsView.setTextColor(amazonActivity.getResources().getColor(com.amazon.mShop.android.lib.R.color.error_text));
        } else
        {
            oneClickOnOffContainer.setVisibility(0);
            oneClickOnOffButton.setChecked(controller.isOneClickStatusEnabled());
            shippingAndPaymentsView.setEnabled(((OneClickConfigResponse) (obj)).getOneClickStatus());
            shippingAndPaymentsView.setFocusable(((OneClickConfigResponse) (obj)).getOneClickStatus());
            shippingAndPaymentsView.setClickable(((OneClickConfigResponse) (obj)).getOneClickStatus());
            obj = AddressFormat.formatOneClickAddress(address, paymentmethod);
            shippingAndPaymentsView.setText(((CharSequence) (obj)));
            shippingAndPaymentsView.setTextColor(amazonActivity.getResources().getColor(com.amazon.mShop.android.lib.R.color.gray_text));
        }
        showSettingsViewIfNotDisplayed();
    }

    public volatile CharSequence getTitle()
    {
        return getTitle();
    }

    public String getTitle()
    {
        return getContext().getString(com.amazon.mShop.android.lib.R.string.one_click_settings_title);
    }

    public void onError(Exception exception, ServiceCall servicecall)
    {
        Log.e("Amazon.OnceClickSettingsView.onError", exception.toString());
        exception.printStackTrace();
        showSettingsViewIfNotDisplayed();
        com.amazon.mShop.error.AmazonErrorBox.AmazonErrorBoxActionListener amazonerrorboxactionlistener = new com.amazon.mShop.error.AmazonErrorBox.AmazonErrorBoxActionListener() {

            final OneClickSettingsView this$0;
            final String val$errorMethod;

            public void onActionButtonClick(int i)
            {
                if (controller.hasServiceCallRunning())
                {
                    controller.cancel();
                }
                if ("enable_one_click_v1".equals(errorMethod))
                {
                    setOneClickSetting(true);
                } else
                {
                    if ("disable_one_click_v1".equals(errorMethod))
                    {
                        setOneClickSetting(false);
                        return;
                    }
                    if ("get_one_click_addresses_v21".equals(errorMethod))
                    {
                        controller.doGetOneClickAddresses(taskCallback.getPopViewTaskCallback(controller, amazonActivity, com.amazon.mShop.android.lib.R.string.one_click_settings_loading_shipping_addresses));
                        return;
                    }
                    if ("get_one_click_config_v21".equals(errorMethod))
                    {
                        controller.doGetOneClickConfig(taskCallback.getTaskCallback(controller, com.amazon.mShop.android.lib.R.string.one_click_settings_loading));
                        return;
                    }
                    if ("set_one_click_config_v21".equals(errorMethod))
                    {
                        controller.doSetOneClickConfig(taskCallback.getPopViewTaskCallback(controller, amazonActivity, com.amazon.mShop.android.lib.R.string.one_click_settings_saving_shipping_payment_method));
                        return;
                    }
                }
            }

            
            {
                this$0 = OneClickSettingsView.this;
                errorMethod = s;
                super();
            }
        };
        AmazonActivity amazonactivity = amazonActivity;
        if (viewDisplayed)
        {
            servicecall = this;
        } else
        {
            servicecall = amazonActivity.getCurrentView();
        }
        AmazonErrorUtils.reportMShopServerError(amazonactivity, amazonerrorboxactionlistener, servicecall, exception);
    }

    public void onReceiveOneClickAddresses(List list)
    {
        amazonActivity.pushView(new ShippingPaymentMethodView(amazonActivity, controller.getSelectedOneClickAddress(), list, controller));
    }

    public void onReceiveOneClickConfig(OneClickConfigResponse oneclickconfigresponse)
    {
        updateUI();
    }

    public void onRequiresUserLogin(com.amazon.mShop.model.auth.UserSubscriber.Callback callback)
    {
        amazonActivity.authenticateUser(callback, new com.amazon.mShop.model.auth.UserSubscriber.Callback() {

            final OneClickSettingsView this$0;

            public void userCancelledSignIn()
            {
            }

            public void userSuccessfullySignedIn()
            {
            }

            
            {
                this$0 = OneClickSettingsView.this;
                super();
            }
        });
    }

    public void onSaveOneClickStatus(boolean flag)
    {
        updateUI();
    }






}
