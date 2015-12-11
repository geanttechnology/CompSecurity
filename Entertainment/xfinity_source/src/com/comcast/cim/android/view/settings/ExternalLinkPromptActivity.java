// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.settings;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import com.comcast.cim.android.view.common.BaseActivity;
import com.comcast.cim.android.view.common.CALDialogFragment;
import java.util.ArrayList;
import java.util.List;

public class ExternalLinkPromptActivity extends BaseActivity
{

    public ExternalLinkPromptActivity()
    {
    }

    protected void onCreate(final Bundle url)
    {
        super.onCreate(url);
        url = getIntent().getExtras().getString("url");
        Object obj1 = getIntent().getExtras().getString("title");
        Object obj = new Bundle();
        ((Bundle) (obj)).putString("title", ((String) (obj1)));
        ((Bundle) (obj)).putString("description", getString(com.comcast.cim.android.R.string.alert_launch_another_application));
        obj1 = CALDialogFragment.newInstance("inputPromptDlg");
        ((CALDialogFragment) (obj1)).addArguments(((Bundle) (obj)));
        obj = new ArrayList();
        ((List) (obj)).add(new com.comcast.cim.android.view.common.CALDialogFragment.CDFButton(getString(com.comcast.cim.android.R.string.dlg_btn_ok), new android.content.DialogInterface.OnClickListener() {

            final ExternalLinkPromptActivity this$0;
            final String val$url;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                dialoginterface = new Intent("android.intent.action.VIEW", Uri.parse(url));
                startActivity(dialoginterface);
                finish();
            }

            
            {
                this$0 = ExternalLinkPromptActivity.this;
                url = s;
                super();
            }
        }));
        ((List) (obj)).add(new com.comcast.cim.android.view.common.CALDialogFragment.CDFButton(getResources().getString(com.comcast.cim.android.R.string.dlg_btn_cancel), new android.content.DialogInterface.OnClickListener() {

            final ExternalLinkPromptActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.cancel();
            }

            
            {
                this$0 = ExternalLinkPromptActivity.this;
                super();
            }
        }));
        ((CALDialogFragment) (obj1)).setButtonList(((List) (obj)));
        ((CALDialogFragment) (obj1)).setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final ExternalLinkPromptActivity this$0;

            public void onCancel(DialogInterface dialoginterface)
            {
                finish();
            }

            
            {
                this$0 = ExternalLinkPromptActivity.this;
                super();
            }
        });
        ((CALDialogFragment) (obj1)).show(getFragmentManager(), "caldialogfragment");
    }
}
