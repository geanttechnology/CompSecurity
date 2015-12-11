// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import com.groupon.activity.BusinessDetailPage;
import com.groupon.http.Http;
import com.groupon.network.HttpResponseException;
import com.groupon.view.SpinnerButton;
import java.util.ArrayList;
import java.util.Arrays;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            BusinessShareTipFragment

class this._cls0
    implements android.view.gment._cls1
{

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

                final BusinessShareTipFragment._cls1 this$1;

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
                this$1 = BusinessShareTipFragment._cls1.this;
                super(context, class1, s);
            }
            }).method("POST").nvps(view.toArray()).execute();
            return;
        }
    }

    _cls1.this._cls1()
    {
        this$0 = BusinessShareTipFragment.this;
        super();
    }
}
