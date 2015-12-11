// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.customviews.PMEditText;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.user.UserInfo;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment

public class ChangePasswordFragment extends PMFragment
{

    boolean isPasswordSet;
    private PMEditText newPassword;
    private PMEditText newPasswordCopy;
    private PMEditText originalPassword;

    public ChangePasswordFragment()
    {
        isPasswordSet = true;
    }

    private void checkIfPasswordIsSet()
    {
        showProgressDialogWithMessage(getString(0x7f060190));
        PMApi.checkIfPasswordSet(new PMApiResponseHandler() {

            final ChangePasswordFragment this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
                if (isAdded())
                {
                    hideProgressDialog();
                    if (!pmapiresponse.hasError())
                    {
                        pmapiresponse = (com.poshmark.user.UserInfoDetails.PasswordStatus)pmapiresponse.data;
                        isPasswordSet = ((com.poshmark.user.UserInfoDetails.PasswordStatus) (pmapiresponse)).password_set;
                        updateView();
                    }
                }
            }

            
            {
                this$0 = ChangePasswordFragment.this;
                super();
            }
        });
    }

    private boolean isFormValid()
    {
        String s;
        boolean flag;
        flag = true;
        String s1 = new String();
        s = s1;
        if (!originalPassword.isValid())
        {
            s = s1;
            if (isPasswordSet)
            {
                s = (new StringBuilder()).append(s1).append(originalPassword.getValidatorString(true)).toString();
            }
        }
        if (newPassword.isValid()) goto _L2; else goto _L1
_L1:
        String s2 = (new StringBuilder()).append(s).append("\n").append(newPassword.getValidatorString()).toString();
_L4:
        if (!s2.isEmpty())
        {
            showAlertMessage(getResources().getString(0x7f060148), s2);
            flag = false;
        }
        return flag;
_L2:
        s2 = s;
        if (!newPassword.getText().toString().equals(newPasswordCopy.getText().toString()))
        {
            s2 = (new StringBuilder()).append(s).append("\n").append(getString(0x7f0601c2)).toString();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void setupNextActionButton()
    {
        Button button = getNextActionButton();
        if (button == null)
        {
            return;
        } else
        {
            button.setText(getString(0x7f0600bf).toUpperCase());
            button.setOnClickListener(new android.view.View.OnClickListener() {

                final ChangePasswordFragment this$0;

                public void onClick(View view)
                {
                    hideKeyboard();
                    if (isFormValid())
                    {
                        showProgressDialogWithMessage(getString(0x7f0602b5));
                        view = originalPassword.getText().toString();
                        PMApi.postNewPassword(newPassword.getText().toString(), view, new PMApiResponseHandler() {

                            final _cls2 this$1;

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
                                        pmapiresponse = (UserInfo)pmapiresponse.data;
                                        PMApplicationSession.GetPMSession().saveSession(pmapiresponse);
                                        getActivity().onBackPressed();
                                    }
                                    return;
                                }
                                showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.UPDATE_PASSWORD, getString(0x7f0600ff)));
                            }

            
            {
                this$1 = _cls2.this;
                super();
            }
                        });
                    }
                }

            
            {
                this$0 = ChangePasswordFragment.this;
                super();
            }
            });
            return;
        }
    }

    private void setupViews()
    {
        View view = getView();
        originalPassword = (PMEditText)view.findViewById(0x7f0c009e);
        originalPassword.setTypeface(Typeface.DEFAULT);
        originalPassword.setTransformationMethod(new PasswordTransformationMethod());
        originalPassword.setVisibility(8);
        newPassword = (PMEditText)view.findViewById(0x7f0c009f);
        newPassword.setTypeface(Typeface.DEFAULT);
        newPassword.setTransformationMethod(new PasswordTransformationMethod());
        newPasswordCopy = (PMEditText)view.findViewById(0x7f0c00a0);
        newPasswordCopy.setTypeface(Typeface.DEFAULT);
        newPasswordCopy.setTransformationMethod(new PasswordTransformationMethod());
    }

    private void updateView()
    {
        if (isPasswordSet)
        {
            originalPassword = (PMEditText)getView().findViewById(0x7f0c009e);
            originalPassword.setVisibility(0);
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        setTitle(0x7f060077);
        checkIfPasswordIsSet();
        setupViews();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        return layoutinflater.inflate(0x7f030021, viewgroup, false);
    }

    public void setViewNameForAnalytics()
    {
        viewNameForAnalytics = "change_password_screen";
    }

    public void setupActionBar()
    {
        super.setupActionBar();
        setupNextActionButton();
    }




}
