// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;

// Referenced classes of package com.ebay.mobile.myebay:
//            ComposeNewMessageFragment

class this._cls0
    implements TextWatcher
{

    final ComposeNewMessageFragment this$0;

    public void afterTextChanged(Editable editable)
    {
        if (ComposeNewMessageFragment.access$000(ComposeNewMessageFragment.this) != null)
        {
            (new Handler()).postDelayed(new Runnable() {

                final ComposeNewMessageFragment._cls1 this$1;

                public void run()
                {
                    ComposeNewMessageFragment.access$000(this$0).onEnableSendButton(ComposeNewMessageFragment.access$100(this$0));
                }

            
            {
                this$1 = ComposeNewMessageFragment._cls1.this;
                super();
            }
            }, 1L);
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        if (ComposeNewMessageFragment.access$200(ComposeNewMessageFragment.this).length() != k)
        {
            ComposeNewMessageFragment.access$302(ComposeNewMessageFragment.this, true);
        }
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    _cls1.this._cls1()
    {
        this$0 = ComposeNewMessageFragment.this;
        super();
    }
}
