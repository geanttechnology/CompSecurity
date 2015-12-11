// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.boldchat.sdk.utils.FloatLabelLayout;
import com.boldchat.visitor.api.Chat;
import com.boldchat.visitor.api.FormField;
import com.boldchat.visitor.api.FormFieldOption;
import com.boldchat.visitor.api.LanguageChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.boldchat.sdk:
//            BoldChatFormView, BoldChatSession

private class mLanguage
    implements android.widget.r, LanguageChangeListener
{

    String mLanguage;
    final BoldChatFormView this$0;

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        if (i != 0)
        {
            adapterview = (FormFieldOption)adapterview.getItemAtPosition(i);
            if (mLanguage == null || !mLanguage.equals(adapterview.getValue()))
            {
                BoldChatFormView.access$300(BoldChatFormView.this).changeLanguage(adapterview.getValue(), this);
            }
        }
    }

    public void onLanguageChange(String s)
    {
        mLanguage = s;
        BoldChatSession.runMain(new Runnable() {

            final BoldChatFormView.LanguageChanger this$1;

            public void run()
            {
                for (Iterator iterator = BoldChatFormView.access$800(this$0).keySet().iterator(); iterator.hasNext();)
                {
                    FormField formfield = (FormField)iterator.next();
                    Iterator iterator2 = ((ArrayList)BoldChatFormView.access$800(this$0).get(formfield)).iterator();
                    while (iterator2.hasNext()) 
                    {
                        View view = (View)iterator2.next();
                        if (view != null)
                        {
                            BoldChatFormView.access$900(this$0, view, formfield);
                        }
                    }
                }

                for (Iterator iterator1 = BoldChatFormView.access$1000(this$0).iterator(); iterator1.hasNext(); ((BoldChatFormView.SelectAdapter)iterator1.next()).notifyDataSetChanged()) { }
                if (BoldChatFormView.access$1100(this$0) != null && BoldChatFormView.access$1200(this$0) != null)
                {
                    CharSequence charsequence = BoldChatFormView.access$1300(this$0, BoldChatFormView.access$1100(this$0));
                    if (charsequence != null)
                    {
                        BoldChatFormView.access$1200(this$0).setText(charsequence);
                    }
                }
                if (BoldChatFormView.access$1400(this$0) != null && BoldChatFormView.access$1500(this$0) != null)
                {
                    CharSequence charsequence1 = BoldChatFormView.access$1300(this$0, BoldChatFormView.access$1400(this$0));
                    if (charsequence1 != null)
                    {
                        BoldChatFormView.access$1500(this$0).setText(charsequence1);
                    }
                }
            }

            
            {
                this$1 = BoldChatFormView.LanguageChanger.this;
                super();
            }
        }, BoldChatFormView.access$500(BoldChatFormView.this));
    }

    public void onLanguageChangeFailed(final String message)
    {
        BoldChatSession.runMain(new Runnable() {

            final BoldChatFormView.LanguageChanger this$1;
            final String val$message;

            public void run()
            {
                Toast.makeText(BoldChatFormView.access$500(this$0), message, 0).show();
            }

            
            {
                this$1 = BoldChatFormView.LanguageChanger.this;
                message = s;
                super();
            }
        }, BoldChatFormView.access$500(BoldChatFormView.this));
    }

    public void onNothingSelected(AdapterView adapterview)
    {
    }

    public _cls2.val.message(String s, FloatLabelLayout floatlabellayout)
    {
        this$0 = BoldChatFormView.this;
        super();
        mLanguage = s;
    }
}
