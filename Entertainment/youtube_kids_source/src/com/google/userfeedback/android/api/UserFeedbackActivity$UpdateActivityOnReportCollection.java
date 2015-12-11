// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import java.util.List;

// Referenced classes of package com.google.userfeedback.android.api:
//            UserFeedbackActivity, UserFeedback, UserFeedbackReport, UserFeedbackSpec

class mPreviewButton extends AsyncTask
{

    private Spinner mAccountSpinner;
    private Context mContext;
    private Button mPreviewButton;
    final UserFeedbackActivity this$0;

    private void updatePreviewButton()
    {
        mPreviewButton.setEnabled(true);
    }

    private void updateSpinner()
    {
        int k = 0;
        mAccountSpinner.setEnabled(true);
        String as[];
        String s;
        String s1;
        String as1[];
        int i;
        int j;
        int l;
        try
        {
            as = (String[])UserFeedbackActivity.access$400(UserFeedbackActivity.this).getReport().accounts.toArray(new String[0]);
        }
        catch (NullPointerException nullpointerexception)
        {
            nullpointerexception = new String[0];
        }
        as1 = new String[as.length + 1];
        as1[0] = mContext.getString(mContext);
        s = "";
        s1 = UserFeedbackActivity.access$400(UserFeedbackActivity.this).getSpec().getSelectedAccount();
        l = as.length;
        i = 0;
        j = 0;
        for (; i < l; i++)
        {
            String s2 = as[i];
            j++;
            as1[j] = s2;
            if (s2.equals(s1))
            {
                k = j;
                s = s1;
            }
        }

        ArrayAdapter arrayadapter = new ArrayAdapter(mContext, mContext, as1);
        arrayadapter.setDropDownViewResource(0x1090009);
        mAccountSpinner.setAdapter(arrayadapter);
        mAccountSpinner.setSelection(k);
        UserFeedbackActivity.access$400(UserFeedbackActivity.this).getReport().chosenAccount = s;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        if (!UserFeedbackActivity.access$400(UserFeedbackActivity.this).isReportReady())
        {
            UserFeedbackActivity.access$400(UserFeedbackActivity.this).blockOnReportConstruction();
        }
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        updateSpinner();
        updatePreviewButton();
    }

    protected void onPreExecute()
    {
        mPreviewButton.setEnabled(false);
        mAccountSpinner.setEnabled(false);
    }

    public (Context context, Spinner spinner, Button button)
    {
        this$0 = UserFeedbackActivity.this;
        super();
        mContext = context;
        mAccountSpinner = spinner;
        mPreviewButton = button;
    }
}
