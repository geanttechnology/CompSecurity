// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.boldchat.visitor.api.FormField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.boldchat.sdk:
//            BoldChatFormView

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        for (Iterator iterator = BoldChatFormView.access$800(_fld0).keySet().iterator(); iterator.hasNext();)
        {
            FormField formfield = (FormField)iterator.next();
            Iterator iterator2 = ((ArrayList)BoldChatFormView.access$800(_fld0).get(formfield)).iterator();
            while (iterator2.hasNext()) 
            {
                View view = (View)iterator2.next();
                if (view != null)
                {
                    BoldChatFormView.access$900(_fld0, view, formfield);
                }
            }
        }

        for (Iterator iterator1 = BoldChatFormView.access$1000(_fld0).iterator(); iterator1.hasNext(); ((is._cls0)iterator1.next()).fyDataSetChanged()) { }
        if (BoldChatFormView.access$1100(_fld0) != null && BoldChatFormView.access$1200(_fld0) != null)
        {
            CharSequence charsequence = BoldChatFormView.access$1300(_fld0, BoldChatFormView.access$1100(_fld0));
            if (charsequence != null)
            {
                BoldChatFormView.access$1200(_fld0).setText(charsequence);
            }
        }
        if (BoldChatFormView.access$1400(_fld0) != null && BoldChatFormView.access$1500(_fld0) != null)
        {
            CharSequence charsequence1 = BoldChatFormView.access$1300(_fld0, BoldChatFormView.access$1400(_fld0));
            if (charsequence1 != null)
            {
                BoldChatFormView.access$1500(_fld0).setText(charsequence1);
            }
        }
    }

    _cls9()
    {
        this$1 = this._cls1.this;
        super();
    }
}
