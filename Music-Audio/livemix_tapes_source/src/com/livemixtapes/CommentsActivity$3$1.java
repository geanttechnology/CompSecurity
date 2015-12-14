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

class this._cls1
    implements android.content.ckListener
{

    final s this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/livemixtapes/CommentsActivity$3

/* anonymous class */
    class CommentsActivity._cls3
        implements android.view.View.OnClickListener
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
                (new android.app.AlertDialog.Builder(CommentsActivity.this)).setTitle("Login").setMessage("Please login to post a comment").setPositiveButton("OK", new CommentsActivity._cls3._cls1()).setIcon(0x1080027).show();
                return;
            } else
            {
                (new CommentsActivity.PostComment(CommentsActivity.this, null)).execute(new String[] {
                    view
                });
                return;
            }
        }

            
            {
                this$0 = CommentsActivity.this;
                super();
            }
    }

}
