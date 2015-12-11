// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.mShop.AmazonAlertDialog;
import com.amazon.mShop.util.Util;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItActivity, ViewItPhotoCaptureView, ViewItSlidingDrawerView, ViewItMetricHelper

public class ViewItDialogHelper
{
    public static final class DialogType extends Enum
    {

        private static final DialogType $VALUES[];
        public static final DialogType ERROR_FLOW_SERVER;
        public static final DialogType ERROR_MSHOP_SERVER;
        public static final DialogType ERROR_NETWORK;
        public static final DialogType ERROR_NO_MATCHED_ITEM;
        public static final DialogType ERROR_NO_OBJECT_FOUND;
        public static final DialogType ERROR_PAUSE;
        public static final DialogType ERROR_UNAUTHORIZED;
        public static final DialogType ERROR_UNKNOWN;
        public static final DialogType PUBLIC_DATA_MATRIX_INFO;

        public static DialogType valueOf(String s)
        {
            return (DialogType)Enum.valueOf(com/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType, s);
        }

        public static DialogType[] values()
        {
            return (DialogType[])$VALUES.clone();
        }

        static 
        {
            ERROR_NETWORK = new DialogType("ERROR_NETWORK", 0);
            ERROR_UNAUTHORIZED = new DialogType("ERROR_UNAUTHORIZED", 1);
            ERROR_FLOW_SERVER = new DialogType("ERROR_FLOW_SERVER", 2);
            ERROR_MSHOP_SERVER = new DialogType("ERROR_MSHOP_SERVER", 3);
            ERROR_NO_MATCHED_ITEM = new DialogType("ERROR_NO_MATCHED_ITEM", 4);
            ERROR_NO_OBJECT_FOUND = new DialogType("ERROR_NO_OBJECT_FOUND", 5);
            ERROR_PAUSE = new DialogType("ERROR_PAUSE", 6);
            ERROR_UNKNOWN = new DialogType("ERROR_UNKNOWN", 7);
            PUBLIC_DATA_MATRIX_INFO = new DialogType("PUBLIC_DATA_MATRIX_INFO", 8);
            $VALUES = (new DialogType[] {
                ERROR_NETWORK, ERROR_UNAUTHORIZED, ERROR_FLOW_SERVER, ERROR_MSHOP_SERVER, ERROR_NO_MATCHED_ITEM, ERROR_NO_OBJECT_FOUND, ERROR_PAUSE, ERROR_UNKNOWN, PUBLIC_DATA_MATRIX_INFO
            });
        }

        private DialogType(String s, int i)
        {
            super(s, i);
        }
    }


    private ViewItActivity mActivity;
    private LinearLayout mErrorDialog;
    private int mErrorDialogBottomMargin;
    private TextView mErrorDialogMessage;
    private TextView mErrorDialogTitle;
    private Handler mHandler;
    private boolean mHasNoObjectFoundErrorShowed;
    private int mNoObjectFoundErrorHappenedTimes;
    private String mPauseDialogMessage;
    private String mPauseDialogTitle;
    private AmazonAlertDialog mPublicDataMatrixInfoDialog;
    private ViewItSlidingDrawerView mSlidingDrawer;
    private AmazonAlertDialog mStillNoObjectFoundDialog;
    private ViewItMetricHelper mViewItMetricHelper;

    public ViewItDialogHelper(ViewItActivity viewitactivity, ViewItPhotoCaptureView viewitphotocaptureview)
    {
        mErrorDialogBottomMargin = 0;
        mNoObjectFoundErrorHappenedTimes = 0;
        mHasNoObjectFoundErrorShowed = false;
        mPauseDialogTitle = null;
        mPauseDialogMessage = null;
        mHandler = new Handler() {

            final ViewItDialogHelper this$0;

            public void handleMessage(Message message)
            {
                switch (message.what)
                {
                default:
                    if (isStillNoObjectFoundDialogShowing())
                    {
                        mErrorDialog.setVisibility(8);
                        return;
                    } else
                    {
                        dimissErrorWindow();
                        return;
                    }

                case 3: // '\003'
                    clearErrorWindow();
                    mActivity.finish();
                    return;

                case 4: // '\004'
                    showPauseDialog();
                    return;

                case 5: // '\005'
                    mActivity.stopScanning();
                    return;
                }
            }

            
            {
                this$0 = ViewItDialogHelper.this;
                super();
            }
        };
        mActivity = viewitactivity;
        mViewItMetricHelper = mActivity.getViewItMetricHelper();
        mSlidingDrawer = viewitphotocaptureview.getViewItSlidingDrawerView();
        mErrorDialog = (LinearLayout)viewitphotocaptureview.findViewById(com.amazon.mShop.android.lib.R.id.view_it_error_dialog_box);
        mErrorDialogTitle = (TextView)viewitphotocaptureview.findViewById(com.amazon.mShop.android.lib.R.id.view_it_error_dialog_title);
        mErrorDialogMessage = (TextView)viewitphotocaptureview.findViewById(com.amazon.mShop.android.lib.R.id.view_it_error_dialog_message);
    }

    private void clearPendingMessages()
    {
        mHandler.removeMessages(1);
        mHandler.removeMessages(2);
        mHandler.removeMessages(0x7fffffff);
        mHandler.removeMessages(4);
        mHandler.removeMessages(3);
        mHandler.removeMessages(5);
    }

    private void dimissErrorWindow()
    {
        mErrorDialog.setVisibility(8);
        clearPendingMessages();
    }

    private void dismissPublicDataMatrixInfoDialog()
    {
        if (mPublicDataMatrixInfoDialog != null && mPublicDataMatrixInfoDialog.isShowing())
        {
            mPublicDataMatrixInfoDialog.dismiss();
            mPublicDataMatrixInfoDialog = null;
        }
    }

    private void dismissStillNoObjectFoundDialog()
    {
        if (mStillNoObjectFoundDialog != null && mStillNoObjectFoundDialog.isShowing())
        {
            mStillNoObjectFoundDialog.dismiss();
            mStillNoObjectFoundDialog = null;
        }
    }

    private void showErrorDialog(String s, String s1)
    {
        if (mErrorDialogBottomMargin != -mSlidingDrawer.getBottomOffset() / 2)
        {
            mErrorDialogBottomMargin = -mSlidingDrawer.getBottomOffset() / 2;
            android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)mErrorDialog.getLayoutParams();
            layoutparams.bottomMargin = mErrorDialogBottomMargin;
            mErrorDialog.setLayoutParams(layoutparams);
        }
        mErrorDialog.setVisibility(0);
        if (!Util.isEmpty(s))
        {
            mErrorDialogTitle.setVisibility(0);
            mErrorDialogTitle.setText(s);
        } else
        {
            mErrorDialogTitle.setVisibility(8);
        }
        if (!Util.isEmpty(s1))
        {
            mErrorDialogMessage.setVisibility(0);
            mErrorDialogMessage.setText(s1);
            return;
        } else
        {
            mErrorDialogMessage.setVisibility(8);
            return;
        }
    }

    private void showPauseDialog()
    {
        mViewItMetricHelper.logCountMetricsPerSession("messages-per-session-idle", 1);
        dismissStillNoObjectFoundDialog();
        dismissPublicDataMatrixInfoDialog();
        if (Util.isEmpty(mPauseDialogTitle))
        {
            mPauseDialogTitle = mActivity.getResources().getString(com.amazon.mShop.android.lib.R.string.view_it_error_pause_dialog_title);
        }
        if (Util.isEmpty(mPauseDialogMessage))
        {
            mPauseDialogMessage = mActivity.getResources().getString(com.amazon.mShop.android.lib.R.string.view_it_error_pause_dialog_message);
        }
        showErrorDialog(mPauseDialogTitle, mPauseDialogMessage);
        mHandler.removeMessages(3);
        mHandler.sendMessageDelayed(mHandler.obtainMessage(3), 30000L);
        mViewItMetricHelper.cancelFlowTimeToSuccessObserver();
    }

    private void showPublicDataMatrixInfoDialog()
    {
        String s = mActivity.getResources().getString(com.amazon.mShop.android.lib.R.string.view_it_public_data_matrix_info_dialog_message);
        mHandler.sendMessageDelayed(mHandler.obtainMessage(4), 0x15f90L);
        mPublicDataMatrixInfoDialog = (new com.amazon.mShop.AmazonAlertDialog.Builder(mActivity)).create();
        mPublicDataMatrixInfoDialog.show();
        mPublicDataMatrixInfoDialog.getWindow().setContentView(com.amazon.mShop.android.lib.R.layout.view_it_info_no_title_dialog);
        mPublicDataMatrixInfoDialog.setCancelable(true);
        mPublicDataMatrixInfoDialog.setCanceledOnTouchOutside(false);
        mPublicDataMatrixInfoDialog.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final ViewItDialogHelper this$0;

            public void onCancel(DialogInterface dialoginterface)
            {
                dismissPublicDataMatrixInfoDialog();
                clearErrorWindow();
            }

            
            {
                this$0 = ViewItDialogHelper.this;
                super();
            }
        });
        Button button = (Button)mPublicDataMatrixInfoDialog.findViewById(com.amazon.mShop.android.lib.R.id.view_it_info_dialog_ok);
        ((TextView)mPublicDataMatrixInfoDialog.findViewById(com.amazon.mShop.android.lib.R.id.view_it_info_dialog_message)).setText(s);
        button.setOnClickListener(new android.view.View.OnClickListener() {

            final ViewItDialogHelper this$0;

            public void onClick(View view)
            {
                dismissPublicDataMatrixInfoDialog();
                clearErrorWindow();
            }

            
            {
                this$0 = ViewItDialogHelper.this;
                super();
            }
        });
    }

    private void showStillNoObjectFoundDialog()
    {
        String s = mActivity.getResources().getString(com.amazon.mShop.android.lib.R.string.view_it_error_still_no_object_found_title);
        String s1 = mActivity.getResources().getString(com.amazon.mShop.android.lib.R.string.view_it_error_still_no_object_found_message);
        mHandler.sendMessageDelayed(mHandler.obtainMessage(4), 0x15f90L);
        mStillNoObjectFoundDialog = (new com.amazon.mShop.AmazonAlertDialog.Builder(mActivity)).create();
        mStillNoObjectFoundDialog.show();
        mStillNoObjectFoundDialog.getWindow().setContentView(com.amazon.mShop.android.lib.R.layout.view_it_error_dialog_still_not_found);
        mStillNoObjectFoundDialog.setCancelable(true);
        mStillNoObjectFoundDialog.setCanceledOnTouchOutside(false);
        mStillNoObjectFoundDialog.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final ViewItDialogHelper this$0;

            public void onCancel(DialogInterface dialoginterface)
            {
                dismissStillNoObjectFoundDialog();
                clearErrorWindow();
            }

            
            {
                this$0 = ViewItDialogHelper.this;
                super();
            }
        });
        Button button = (Button)mStillNoObjectFoundDialog.findViewById(com.amazon.mShop.android.lib.R.id.view_it_error_dialog_ok);
        TextView textview = (TextView)mStillNoObjectFoundDialog.findViewById(com.amazon.mShop.android.lib.R.id.view_it_error_dialog_title);
        TextView textview1 = (TextView)mStillNoObjectFoundDialog.findViewById(com.amazon.mShop.android.lib.R.id.view_it_error_dialog_message);
        textview.setText(s);
        textview1.setText(s1);
        button.setOnClickListener(new android.view.View.OnClickListener() {

            final ViewItDialogHelper this$0;

            public void onClick(View view)
            {
                dismissStillNoObjectFoundDialog();
                clearErrorWindow();
            }

            
            {
                this$0 = ViewItDialogHelper.this;
                super();
            }
        });
    }

    public void canclePendingStopScanningMessage()
    {
        mHandler.removeMessages(5);
    }

    public void clearErrorWindow()
    {
        dimissErrorWindow();
        dismissStillNoObjectFoundDialog();
        dismissPublicDataMatrixInfoDialog();
        mNoObjectFoundErrorHappenedTimes = 0;
    }

    public boolean isPauseDialogShowing()
    {
        return mErrorDialog.getVisibility() == 0 && !Util.isEmpty(mPauseDialogMessage) && mPauseDialogMessage.equals(mErrorDialogMessage.getText());
    }

    public boolean isStillNoObjectFoundDialogShowing()
    {
        return mStillNoObjectFoundDialog != null && mStillNoObjectFoundDialog.isShowing();
    }

    public boolean isStillPublicDataMatrixInfoDialogShowing()
    {
        return mPublicDataMatrixInfoDialog != null && mPublicDataMatrixInfoDialog.isShowing();
    }

    public void sendStopScanningMessageDelayed()
    {
        mHandler.removeMessages(5);
        mHandler.sendMessageDelayed(mHandler.obtainMessage(5), 0x15f90L);
    }

    public void showDialog(String s, String s1, DialogType dialogtype)
    {
        if (mSlidingDrawer.isMoving() || isStillNoObjectFoundDialogShowing() || isPauseDialogShowing() || isStillPublicDataMatrixInfoDialogShowing()) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        i = 0x7fffffff;
        j = 3000;
        static class _cls6
        {

            static final int $SwitchMap$com$amazon$mShop$search$viewit$ViewItDialogHelper$DialogType[];

            static 
            {
                $SwitchMap$com$amazon$mShop$search$viewit$ViewItDialogHelper$DialogType = new int[DialogType.values().length];
                try
                {
                    $SwitchMap$com$amazon$mShop$search$viewit$ViewItDialogHelper$DialogType[DialogType.ERROR_NETWORK.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$search$viewit$ViewItDialogHelper$DialogType[DialogType.ERROR_NO_OBJECT_FOUND.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$search$viewit$ViewItDialogHelper$DialogType[DialogType.PUBLIC_DATA_MATRIX_INFO.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$search$viewit$ViewItDialogHelper$DialogType[DialogType.ERROR_NO_MATCHED_ITEM.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$search$viewit$ViewItDialogHelper$DialogType[DialogType.ERROR_UNAUTHORIZED.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$search$viewit$ViewItDialogHelper$DialogType[DialogType.ERROR_FLOW_SERVER.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$search$viewit$ViewItDialogHelper$DialogType[DialogType.ERROR_UNKNOWN.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls6..SwitchMap.com.amazon.mShop.search.viewit.ViewItDialogHelper.DialogType[dialogtype.ordinal()];
        JVM INSTR tableswitch 1 4: default 80
    //                   1 127
    //                   2 144
    //                   3 245
    //                   4 250;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        mViewItMetricHelper.logCountMetricsPerSession("messages-per-session-error", 1);
_L10:
        showErrorDialog(s, s1);
        mHandler.removeMessages(i);
        mHandler.sendMessageDelayed(mHandler.obtainMessage(i), j);
_L2:
        return;
_L4:
        i = 1;
        mViewItMetricHelper.logCountMetricsPerSession("messages-per-session-error", 1);
        continue; /* Loop/switch isn't completed */
_L5:
        mNoObjectFoundErrorHappenedTimes = mNoObjectFoundErrorHappenedTimes + 1;
        if (mNoObjectFoundErrorHappenedTimes == 2)
        {
            mNoObjectFoundErrorHappenedTimes = 0;
            showStillNoObjectFoundDialog();
            mViewItMetricHelper.logCountMetricsPerSession("messages-per-session-stuck", 1);
            return;
        }
        if (mHasNoObjectFoundErrorShowed) goto _L2; else goto _L8
_L8:
        mHasNoObjectFoundErrorShowed = true;
        s = mActivity.getResources().getString(com.amazon.mShop.android.lib.R.string.view_it_error_no_object_found_title);
        s1 = mActivity.getResources().getString(com.amazon.mShop.android.lib.R.string.view_it_error_no_object_found_message);
        i = 2;
        j = 4000;
        mViewItMetricHelper.logCountMetricsPerSession("messages-per-session-stuck", 1);
        continue; /* Loop/switch isn't completed */
_L6:
        showPublicDataMatrixInfoDialog();
        return;
_L7:
        mViewItMetricHelper.logCountMetricsPerSession("messages-per-session-nomatches", 1);
        if (true) goto _L10; else goto _L9
_L9:
    }






}
