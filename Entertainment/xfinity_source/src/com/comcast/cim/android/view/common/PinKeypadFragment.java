// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.comcast.cim.cmasl.android.util.view.widget.NumericKeypad;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PinKeypadFragment extends DialogFragment
    implements com.comcast.cim.cmasl.android.util.view.widget.NumericKeypad.KeyPressedListener
{
    public static interface PinValidationCompletedListener
    {

        public abstract void onPinValidationComplete(boolean flag);
    }

    public static interface PinValidator
    {

        public abstract void validatePin(String s, PinValidationCompletedListener pinvalidationcompletedlistener);
    }


    private static final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/android/view/common/PinKeypadFragment);
    private NumericKeypad numericKeypad;
    private android.content.DialogInterface.OnCancelListener onCancelListener;
    private android.content.DialogInterface.OnDismissListener onDismissListener;
    private TextView pinBoxes[];
    private String pinBuffer;
    private TextView pinStatus;
    private PinValidator pinValidator;

    public PinKeypadFragment()
    {
        pinBuffer = "";
    }

    private void clearBuffer()
    {
        pinBuffer = "";
        refreshPinBoxesState();
    }

    private boolean isDialogActive()
    {
        return getDialog() != null && getDialog().isShowing();
    }

    private void showCheckingMessage()
    {
        pinStatus.setText(getResources().getString(com.comcast.cim.android.R.string.checking_pin));
    }

    private void showError()
    {
        pinStatus.setText(getResources().getString(com.comcast.cim.android.R.string.incorrect_pin));
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        if (onCancelListener != null)
        {
            onCancelListener.onCancel(dialoginterface);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (pinValidator == null)
        {
            LOG.warn("Must supply pinValidator");
            dismiss();
            return;
        } else
        {
            setStyle(0, com.comcast.cim.android.R.style.xfinity_remote_filter_dialog);
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(com.comcast.cim.android.R.layout.pin_keypad, viewgroup, false);
        LOG.debug("onCreateView");
        numericKeypad = (NumericKeypad)layoutinflater.findViewById(com.comcast.cim.android.R.id.keypad);
        numericKeypad.setKeyPressedListener(this);
        pinBoxes = (new TextView[] {
            (TextView)layoutinflater.findViewById(com.comcast.cim.android.R.id.pinBoxOne), (TextView)layoutinflater.findViewById(com.comcast.cim.android.R.id.pinBoxTwo), (TextView)layoutinflater.findViewById(com.comcast.cim.android.R.id.pinBoxThree), (TextView)layoutinflater.findViewById(com.comcast.cim.android.R.id.pinBoxFour)
        });
        refreshPinBoxesState();
        pinStatus = (TextView)layoutinflater.findViewById(com.comcast.cim.android.R.id.pinStatus);
        return layoutinflater;
    }

    public void onDismiss(DialogInterface dialoginterface)
    {
        super.onDismiss(dialoginterface);
        if (onDismissListener != null)
        {
            onDismissListener.onDismiss(dialoginterface);
        }
    }

    public void onKeyPressed(String s)
    {
        if (pinStatus.getText().length() > 0)
        {
            pinStatus.setText(null);
        }
        if (s == null) goto _L2; else goto _L1
_L1:
        if (pinBuffer.length() < 4)
        {
            pinBuffer = (new StringBuilder()).append(pinBuffer).append(s).toString();
        }
_L4:
        refreshPinBoxesState();
        if (pinBuffer.length() == 4)
        {
            numericKeypad.setEnabled(false);
            getView().postDelayed(new Runnable() {

                final PinKeypadFragment this$0;

                public void run()
                {
                    if (!isDialogActive())
                    {
                        return;
                    } else
                    {
                        showCheckingMessage();
                        pinValidator.validatePin(pinBuffer, new PinValidationCompletedListener() {

                            final _cls1 this$1;

                            public void onPinValidationComplete(boolean flag)
                            {
label0:
                                {
                                    if (isDialogActive())
                                    {
                                        if (!flag)
                                        {
                                            break label0;
                                        }
                                        dismiss();
                                    }
                                    return;
                                }
                                numericKeypad.setEnabled(true);
                                showError();
                                clearBuffer();
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
                this$0 = PinKeypadFragment.this;
                super();
            }
            }, 150L);
        }
        return;
_L2:
        if (pinBuffer.length() > 0)
        {
            pinBuffer = pinBuffer.substring(0, pinBuffer.length() - 1);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void refreshPinBoxesState()
    {
        int i = 0;
        while (i < pinBoxes.length) 
        {
            TextView textview = pinBoxes[i];
            String s;
            if (i < pinBuffer.length())
            {
                s = "*";
            } else
            {
                s = "";
            }
            textview.setText(s);
            i++;
        }
    }

    public void setOnCancelListener(android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        onCancelListener = oncancellistener;
    }

    public void setOnDismissListener(android.content.DialogInterface.OnDismissListener ondismisslistener)
    {
        onDismissListener = ondismisslistener;
    }

    public void setPinValidator(PinValidator pinvalidator)
    {
        pinValidator = pinvalidator;
    }








}
