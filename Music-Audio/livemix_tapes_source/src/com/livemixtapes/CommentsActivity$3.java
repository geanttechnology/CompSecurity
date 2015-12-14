// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.content.DialogInterface;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

// Referenced classes of package com.livemixtapes:
//            CommentsActivity, User

class this._cls0
    implements android.view.r
{

    final CommentsActivity this$0;

    public void onClick(View view)
    {
        view = commentsEditText.getText().toString();
        if (view.length() == 0)
        {
            return;
        }
        if (User.getAuth().length() == 0)
        {
            (new android.app.(CommentsActivity.this)).setTitle("Login").setMessage("Please login to post a comment").setPositiveButton("OK", new android.content.DialogInterface.OnClickListener() {

                final CommentsActivity._cls3 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = CommentsActivity._cls3.this;
                super();
            }
            }).setIcon(0x1080027).show();
            return;
        } else
        {
            (new stComment(CommentsActivity.this, null)).execute(new String[] {
                view
            });
            return;
        }
    }

    _cls1.this._cls1()
    {
        this$0 = CommentsActivity.this;
        super();
    }
}
