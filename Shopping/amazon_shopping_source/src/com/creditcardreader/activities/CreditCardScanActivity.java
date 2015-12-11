// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.creditcardreader.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Vibrator;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
import com.a9.cameralibrary.A9CameraPreview;
import com.a9.cameralibrary.CameraErrorReason;
import com.a9.creditcardreaderlibrary.CreditCardReaderActivity;
import com.a9.creditcardreaderlibrary.CreditCardResult;
import com.a9.vs.mobile.library.impl.jni.Orientation;
import com.creditcardreader.camera.CreditCardCameraPreview;
import com.creditcardreader.metrics.CreditCardMetricsRecorder;
import com.creditcardreader.utils.CreditCardUtils;
import java.util.List;

public class CreditCardScanActivity extends CreditCardReaderActivity
{

    private boolean mAligned;
    private CreditCardCameraPreview mCameraPreview;
    private boolean mCancelExit;
    private boolean mDialogShown;
    private boolean mForegroundExit;
    private Handler mHandler;
    private CreditCardMetricsRecorder mMetricsRecorder;
    private boolean mPromising;
    private Thread mScanningThread;
    private long mTimeOfLastAlign;
    private long mTimeToScan;
    private Vibrator mVibrator;
    private Handler m_handler;

    public CreditCardScanActivity()
    {
        m_handler = new Handler(Looper.getMainLooper()) {

            final CreditCardScanActivity this$0;

            public void handleMessage(Message message)
            {
                switch (message.what)
                {
                default:
                    return;

                case 1: // '\001'
                    checkForFocus();
                    break;
                }
                m_handler.sendMessageDelayed(m_handler.obtainMessage(1), 3000L);
            }

            
            {
                this$0 = CreditCardScanActivity.this;
                super(looper);
            }
        };
    }

    private void checkForFocus()
    {
        triggerFocus();
    }

    private void setHelpButton()
    {
        ImageButton imagebutton = (ImageButton)findViewById(com.creditcardreader.R.id.cc_scan_help_button);
        imagebutton.setOnClickListener(new android.view.View.OnClickListener() {

            final CreditCardScanActivity this$0;

            public void onClick(View view)
            {
                mMetricsRecorder.recordHelp();
                view = new Intent("android.intent.action.VIEW", Uri.parse(getString(com.creditcardreader.R.string.cc_scan_help_page_us)));
                startActivity(view);
            }

            
            {
                this$0 = CreditCardScanActivity.this;
                super();
            }
        });
        imagebutton.setVisibility(0);
    }

    private void setRescan()
    {
        mMetricsRecorder.recordRescan();
        mTimeToScan = 15000L;
        mCameraPreview.startPreview();
        mDialogShown = false;
    }

    private void setTorchButton()
    {
        if (supportsFlash())
        {
            final ImageButton torchButton = (ImageButton)findViewById(com.creditcardreader.R.id.cc_scan_torch_button);
            torchButton.setImageResource(com.creditcardreader.R.drawable.cc_scan_flash);
            torchButton.setOnClickListener(new android.view.View.OnClickListener() {

                boolean flashOn;
                final CreditCardScanActivity this$0;
                final ImageButton val$torchButton;

                public void onClick(View view)
                {
                    if (flashOn)
                    {
                        flashOn = false;
                        torchButton.setImageResource(com.creditcardreader.R.drawable.cc_scan_flash);
                        handleTorchOff();
                        return;
                    } else
                    {
                        flashOn = true;
                        torchButton.setImageResource(com.creditcardreader.R.drawable.cc_scan_flash_on);
                        handleTorchOn();
                        return;
                    }
                }

            
            {
                this$0 = CreditCardScanActivity.this;
                torchButton = imagebutton;
                super();
                flashOn = false;
            }
            });
            torchButton.setVisibility(0);
        }
    }

    private void showUnreadableDialog()
    {
        mMetricsRecorder.recordTimeout();
        mDialogShown = true;
        mHandler.post(new Runnable() {

            final CreditCardScanActivity this$0;

            public void run()
            {
                mCameraPreview.resetOverlay();
                mCameraPreview.stopPreview();
                Object obj = new android.app.AlertDialog.Builder(CreditCardScanActivity.this);
                ((android.app.AlertDialog.Builder) (obj)).setMessage(getResources().getString(com.creditcardreader.R.string.cc_scan_trouble));
                ((android.app.AlertDialog.Builder) (obj)).setPositiveButton(getResources().getString(com.creditcardreader.R.string.cc_scan_rescan), new android.content.DialogInterface.OnClickListener() {

                    final _cls9 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        setRescan();
                    }

            
            {
                this$1 = _cls9.this;
                super();
            }
                });
                ((android.app.AlertDialog.Builder) (obj)).setNegativeButton(getResources().getString(com.creditcardreader.R.string.cc_scan_manual), new android.content.DialogInterface.OnClickListener() {

                    final _cls9 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        mForegroundExit = true;
                        mCancelExit = false;
                        mMetricsRecorder.recordTimeoutCancel();
                        mHandler.post(new Runnable() {

                            final _cls2 this$2;

                            public void run()
                            {
                                setResult(0, new Intent());
                                finish();
                            }

            
            {
                this$2 = _cls2.this;
                super();
            }
                        });
                    }

            
            {
                this$1 = _cls9.this;
                super();
            }
                });
                obj = ((android.app.AlertDialog.Builder) (obj)).create();
                ((AlertDialog) (obj)).setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

                    final _cls9 this$1;

                    public void onCancel(DialogInterface dialoginterface)
                    {
                        setRescan();
                    }

            
            {
                this$1 = _cls9.this;
                super();
            }
                });
                ((AlertDialog) (obj)).show();
                ((TextView)((AlertDialog) (obj)).findViewById(0x102000b)).setGravity(17);
            }

            
            {
                this$0 = CreditCardScanActivity.this;
                super();
            }
        });
    }

    private boolean wasAlignedRecently()
    {
        return System.currentTimeMillis() - mTimeOfLastAlign <= 2000L;
    }

    protected void didDetectGoodEdges(final List edges)
    {
        if (!wasAlignedRecently())
        {
            if (mScanningThread != null)
            {
                mScanningThread.interrupt();
                mScanningThread = null;
                didStableCardRecognition();
            }
            mHandler.post(new Runnable() {

                final CreditCardScanActivity this$0;
                final List val$edges;

                public void run()
                {
                    mCameraPreview.setEdges(edges);
                }

            
            {
                this$0 = CreditCardScanActivity.this;
                edges = list;
                super();
            }
            });
        }
        if (edges.size() == 4)
        {
            mTimeOfLastAlign = System.currentTimeMillis();
        }
    }

    protected void didPromisingCardRecognition()
    {
        if (!mPromising)
        {
            mPromising = true;
            mMetricsRecorder.recordPromising();
        }
    }

    protected void didRecognizeCreditCard(final CreditCardResult result)
    {
        if (!mAligned)
        {
            mMetricsRecorder.recordAlign();
            mAligned = true;
        }
        mMetricsRecorder.recordSuccess(result);
        mVibrator.vibrate(250L);
        mHandler.post(new Runnable() {

            final CreditCardScanActivity this$0;

            public void run()
            {
                mCameraPreview.showSuccess();
            }

            
            {
                this$0 = CreditCardScanActivity.this;
                super();
            }
        });
        mHandler.postDelayed(new Runnable() {

            final CreditCardScanActivity this$0;
            final CreditCardResult val$result;

            public void run()
            {
                mForegroundExit = true;
                mCancelExit = false;
                setResult(-1, CreditCardUtils.createSuccessIntent(result));
                finish();
            }

            
            {
                this$0 = CreditCardScanActivity.this;
                result = creditcardresult;
                super();
            }
        }, 1500L);
    }

    protected void didStableCardRecognition()
    {
        if (!mAligned)
        {
            mMetricsRecorder.recordAlign();
            mAligned = true;
        }
        if (mScanningThread == null)
        {
            mScanningThread = new Thread(new Runnable() {

                final CreditCardScanActivity this$0;

                public void run()
                {
                    try
                    {
                        Thread.sleep(mTimeToScan);
                        if (mCameraPreview.isScanning() && !mDialogShown)
                        {
                            showUnreadableDialog();
                        }
                        return;
                    }
                    catch (InterruptedException interruptedexception)
                    {
                        return;
                    }
                }

            
            {
                this$0 = CreditCardScanActivity.this;
                super();
            }
            });
            mScanningThread.start();
        }
    }

    protected int getCameraViewHeight()
    {
        DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        if (getScreenOrientation() == 0 || getScreenOrientation() == 8)
        {
            return Math.min(displaymetrics.widthPixels, displaymetrics.heightPixels);
        } else
        {
            return Math.max(displaymetrics.widthPixels, displaymetrics.heightPixels);
        }
    }

    protected int getCameraViewWidth()
    {
        DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        if (getScreenOrientation() == 0 || getScreenOrientation() == 8)
        {
            return Math.max(displaymetrics.widthPixels, displaymetrics.heightPixels);
        } else
        {
            return Math.min(displaymetrics.widthPixels, displaymetrics.heightPixels);
        }
    }

    protected Orientation getCreditCardOrientation()
    {
        switch (getWindowManager().getDefaultDisplay().getRotation())
        {
        case 2: // '\002'
        default:
            return Orientation.PORTRAIT;

        case 0: // '\0'
            return Orientation.PORTRAIT;

        case 1: // '\001'
            return Orientation.LANDSCAPE_LEFT;

        case 3: // '\003'
            return Orientation.LANDSCAPE_RIGHT;
        }
    }

    protected String getMarketPlace()
    {
        return "1";
    }

    public int getScreenOrientation()
    {
        switch (getWindowManager().getDefaultDisplay().getRotation())
        {
        case 0: // '\0'
        case 2: // '\002'
        default:
            return 1;

        case 1: // '\001'
            return 0;

        case 3: // '\003'
            return 8;
        }
    }

    protected void handleCameraError(CameraErrorReason cameraerrorreason, String s)
    {
        mCancelExit = false;
        mMetricsRecorder.recordCameraError();
        setResult(0, (new Intent()).putExtra("CANNOT_OPEN_CAMERA", true));
        finish();
    }

    protected void initCardDetectionRegion(final List bounds)
    {
        mHandler.post(new Runnable() {

            final CreditCardScanActivity this$0;
            final List val$bounds;

            public void run()
            {
                mCameraPreview.setBounds(bounds);
            }

            
            {
                this$0 = CreditCardScanActivity.this;
                bounds = list;
                super();
            }
        });
    }

    protected void initLayout()
    {
        setContentView(com.creditcardreader.R.layout.credit_card_scan);
    }

    public A9CameraPreview newCameraPreview()
    {
        setCameraPreview(new CreditCardCameraPreview(this, this));
        mCameraPreview = (CreditCardCameraPreview)getCameraPreview();
        return getCameraPreview();
    }

    public void onBackPressed()
    {
        mForegroundExit = true;
        super.onBackPressed();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(com.creditcardreader.R.layout.credit_card_scan);
        CreditCardUtils.setResources(getResources());
        mHandler = new Handler();
        mVibrator = (Vibrator)getSystemService("vibrator");
        mTimeToScan = 5000L;
        mAligned = false;
        mPromising = false;
        mMetricsRecorder = new CreditCardMetricsRecorder(this);
        mMetricsRecorder.recordSession();
        setHelpButton();
        setTorchButton();
    }

    protected void onDestroy()
    {
        if (mCancelExit)
        {
            if (mForegroundExit)
            {
                mMetricsRecorder.recordCancel();
            } else
            {
                mMetricsRecorder.recordCancelOnBackground();
            }
        }
        mMetricsRecorder.recordMetric();
        super.onDestroy();
    }

    protected void onPause()
    {
        if (mScanningThread != null)
        {
            mScanningThread.interrupt();
            mScanningThread = null;
        }
        mCameraPreview.blacken();
        mCameraPreview.resetOverlay();
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        mForegroundExit = false;
        mCancelExit = true;
        m_handler.sendMessageDelayed(m_handler.obtainMessage(1), 500L);
    }








/*
    static boolean access$302(CreditCardScanActivity creditcardscanactivity, boolean flag)
    {
        creditcardscanactivity.mForegroundExit = flag;
        return flag;
    }

*/


/*
    static boolean access$402(CreditCardScanActivity creditcardscanactivity, boolean flag)
    {
        creditcardscanactivity.mCancelExit = flag;
        return flag;
    }

*/





}
