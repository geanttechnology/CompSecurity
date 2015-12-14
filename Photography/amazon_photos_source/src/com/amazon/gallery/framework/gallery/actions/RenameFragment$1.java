// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.amazon.gallery.foundation.utils.async.BlockingSpinnerDialog;
import com.amazon.gallery.framework.model.tags.Tag;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            RenameFragment

class val.tagToRename
    implements android.content.nClickListener
{

    final RenameFragment this$0;
    final EditText val$editTextView;
    final Tag val$tagToRename;

    public void onClick(final DialogInterface context, int i)
    {
        context = getActivity();
        final String newName = val$editTextView.getText().toString();
        if (newName.length() == 0)
        {
            Toast.makeText(context, context.getString(0x7f0e012d), 0).show();
            return;
        } else
        {
            final String oldName = val$tagToRename.getLabel();
            val$tagToRename.setLabel(newName);
            BlockingSpinnerDialog blockingspinnerdialog = new BlockingSpinnerDialog(context, RenameFragment.access$000(RenameFragment.this, val$tagToRename), context.getString(0x7f0e012f));
            blockingspinnerdialog.setPostExecuteTask(new Runnable() {

                final RenameFragment._cls1 this$1;
                final Activity val$context;
                final String val$newName;
                final String val$oldName;

                public void run()
                {
                    if (RenameFragment.access$100(this$0))
                    {
                        Snackbar snackbar = Snackbar.make(context.findViewById(0x7f0c0122), context.getString(0x7f0e0130, new Object[] {
                            newName
                        }), 0);
                        snackbar.setAction(0x7f0e01fc, new android.view.View.OnClickListener() {

                            final _cls1 this$2;

                            public void onClick(View view)
                            {
                                RenameFragment.access$102(this$0, false);
                                tagToRename.setLabel(oldName);
                                view = new BlockingSpinnerDialog(context, RenameFragment.access$000(this$0, tagToRename), context.getString(0x7f0e012f));
                                view.setPostExecuteTask(RenameFragment.access$200(this$0, context));
                                view.execute(new Void[0]);
                            }

            
            {
                this$2 = _cls1.this;
                super();
            }
                        });
                        snackbar.show();
                        return;
                    } else
                    {
                        Snackbar.make(context.findViewById(0x7f0c0122), context.getString(0x7f0e012e, new Object[] {
                            oldName, newName
                        }), 0).show();
                        return;
                    }
                }

            
            {
                this$1 = RenameFragment._cls1.this;
                context = activity;
                newName = s;
                oldName = s1;
                super();
            }
            });
            blockingspinnerdialog.execute(new Void[0]);
            return;
        }
    }

    _cls1.val.oldName()
    {
        this$0 = final_renamefragment;
        val$editTextView = edittext;
        val$tagToRename = Tag.this;
        super();
    }
}
