// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import com.groupon.activity.BusinessDetailPage;
import com.groupon.http.Http;
import com.groupon.network.HttpResponseException;
import com.groupon.view.SpinnerButton;
import java.util.ArrayList;
import java.util.Arrays;
import roboguice.util.Strings;

public class BusinessShareTipFragment extends DialogFragment
{

    Button cancelButton;
    SpinnerButton submitButton;
    EditText tipInput;

    public BusinessShareTipFragment()
    {
    }

    protected void dismissKeyboard()
    {
        ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(tipInput.getWindowToken(), 0);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        submitButton.setOnClickListener(new android.view.View.OnClickListener() {

            final BusinessShareTipFragment this$0;

            public void onClick(View view)
            {
                String s = ((BusinessDetailPage)getActivity()).getBusinessId();
                String s1 = tipInput.getText().toString().trim();
                if (Strings.isEmpty(tipInput))
                {
                    tipInput.setError(getString(0x7f0803dc));
                    return;
                } else
                {
                    submitButton.startSpinning();
                    view = new ArrayList();
                    view.addAll(Arrays.asList(new String[] {
                        "text", s1
                    }));
                    s = String.format("https:/businesses/%1$s/tips", new Object[] {
                        s
                    });
                    (new Http(getActivity(), java/lang/Void, s) {

                        final _cls1 this$1;

                        protected void onException(Exception exception)
                        {
                            submitButton.stopSpinning();
                            int i;
                            if (exception instanceof HttpResponseException)
                            {
                                i = ((HttpResponseException)exception).getStatusCode();
                            } else
                            {
                                i = 900;
                            }
                            if (i == 404)
                            {
                                tipInput.setError(getString(0x7f0801a0));
                                return;
                            }
                            if (i == 401)
                            {
                                tipInput.setError(getString(0x7f080163));
                                return;
                            } else
                            {
                                super.onException(exception);
                                return;
                            }
                        }

                        protected volatile void onSuccess(Object obj)
                            throws Exception
                        {
                            onSuccess((Void)obj);
                        }

                        protected void onSuccess(Void void1)
                            throws Exception
                        {
                            submitButton.stopSpinning();
                            dismiss();
                            dismissKeyboard();
                        }

            
            {
                this$1 = _cls1.this;
                super(context, class1, s);
            }
                    }).method("POST").nvps(view.toArray()).execute();
                    return;
                }
            }

            
            {
                this$0 = BusinessShareTipFragment.this;
                super();
            }
        });
        cancelButton.setOnClickListener(new android.view.View.OnClickListener() {

            final BusinessShareTipFragment this$0;

            public void onClick(View view)
            {
                dismissKeyboard();
                dismiss();
            }

            
            {
                this$0 = BusinessShareTipFragment.this;
                super();
            }
        });
        getDialog().getWindow().setSoftInputMode(4);
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        bundle = super.onCreateDialog(bundle);
        bundle.getWindow().requestFeature(1);
        return bundle;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f03004f, viewgroup, false);
    }
}
