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

class val.oldName
    implements Runnable
{

    final val.newName this$1;
    final Activity val$context;
    final String val$newName;
    final String val$oldName;

    public void run()
    {
        if (RenameFragment.access$100(_fld0))
        {
            Snackbar snackbar = Snackbar.make(val$context.findViewById(0x7f0c0122), val$context.getString(0x7f0e0130, new Object[] {
                val$newName
            }), 0);
            snackbar.setAction(0x7f0e01fc, new android.view.View.OnClickListener() {

                final RenameFragment._cls1._cls1 this$2;

                public void onClick(View view)
                {
                    RenameFragment.access$102(this$0, false);
                    tagToRename.setLabel(oldName);
                    view = new BlockingSpinnerDialog(context, RenameFragment.access$000(this$0, tagToRename), context.getString(0x7f0e012f));
                    view.setPostExecuteTask(RenameFragment.access$200(this$0, context));
                    view.execute(new Void[0]);
                }

            
            {
                this$2 = RenameFragment._cls1._cls1.this;
                super();
            }
            });
            snackbar.show();
            return;
        } else
        {
            Snackbar.make(val$context.findViewById(0x7f0c0122), val$context.getString(0x7f0e012e, new Object[] {
                val$oldName, val$newName
            }), 0).show();
            return;
        }
    }

    l.tagToRename()
    {
        this$1 = final_tagtorename;
        val$context = activity;
        val$newName = s;
        val$oldName = String.this;
        super();
    }

    // Unreferenced inner class com/amazon/gallery/framework/gallery/actions/RenameFragment$1

/* anonymous class */
    class RenameFragment._cls1
        implements android.content.DialogInterface.OnClickListener
    {

        final RenameFragment this$0;
        final EditText val$editTextView;
        final Tag val$tagToRename;

        public void onClick(final DialogInterface context, int i)
        {
            context = getActivity();
            final String newName = editTextView.getText().toString();
            if (newName.length() == 0)
            {
                Toast.makeText(context, context.getString(0x7f0e012d), 0).show();
                return;
            } else
            {
                String s = tagToRename.getLabel();
                tagToRename.setLabel(newName);
                BlockingSpinnerDialog blockingspinnerdialog = new BlockingSpinnerDialog(context, RenameFragment.access$000(RenameFragment.this, tagToRename), context.getString(0x7f0e012f));
                blockingspinnerdialog.setPostExecuteTask(s. new RenameFragment._cls1._cls1());
                blockingspinnerdialog.execute(new Void[0]);
                return;
            }
        }

            
            {
                this$0 = final_renamefragment;
                editTextView = edittext;
                tagToRename = Tag.this;
                super();
            }
    }

}
