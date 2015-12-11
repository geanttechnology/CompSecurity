// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.ebay.mobile.notifications.ItemCache;

// Referenced classes of package com.ebay.mobile.search:
//            SaveSearchDialogFragment

class this._cls1
    implements TextWatcher
{

    final is._cls0 this$1;

    public void afterTextChanged(Editable editable)
    {
        SaveSearchDialogFragment.access$400(_fld0, editable.toString());
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    l.dialog()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/ebay/mobile/search/SaveSearchDialogFragment$1

/* anonymous class */
    class SaveSearchDialogFragment._cls1
        implements android.content.DialogInterface.OnShowListener
    {

        final SaveSearchDialogFragment this$0;
        final AlertDialog val$dialog;

        public void onShow(DialogInterface dialoginterface)
        {
            SaveSearchDialogFragment.access$002(SaveSearchDialogFragment.this, dialog.getButton(-1));
            dialoginterface = SaveSearchDialogFragment.access$000(SaveSearchDialogFragment.this);
            boolean flag;
            if (SaveSearchDialogFragment.access$100(SaveSearchDialogFragment.this).isSearchListReady() && !TextUtils.isEmpty(SaveSearchDialogFragment.access$200(SaveSearchDialogFragment.this).getText().toString()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            dialoginterface.setEnabled(flag);
            SaveSearchDialogFragment.access$000(SaveSearchDialogFragment.this).setOnClickListener(new SaveSearchDialogFragment._cls1._cls1());
            dialog.getButton(-2).setOnClickListener(new SaveSearchDialogFragment._cls1._cls2());
            SaveSearchDialogFragment.access$200(SaveSearchDialogFragment.this).addTextChangedListener(new SaveSearchDialogFragment._cls1._cls3());
        }

            
            {
                this$0 = final_savesearchdialogfragment;
                dialog = AlertDialog.this;
                super();
            }

        // Unreferenced inner class com/ebay/mobile/search/SaveSearchDialogFragment$1$1

/* anonymous class */
        class SaveSearchDialogFragment._cls1._cls1
            implements android.view.View.OnClickListener
        {

            final SaveSearchDialogFragment._cls1 this$1;

            public void onClick(View view)
            {
                SaveSearchDialogFragment.access$300(this$0);
            }

                    
                    {
                        this$1 = SaveSearchDialogFragment._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/ebay/mobile/search/SaveSearchDialogFragment$1$2

/* anonymous class */
        class SaveSearchDialogFragment._cls1._cls2
            implements android.view.View.OnClickListener
        {

            final SaveSearchDialogFragment._cls1 this$1;

            public void onClick(View view)
            {
                dialog.dismiss();
            }

                    
                    {
                        this$1 = SaveSearchDialogFragment._cls1.this;
                        super();
                    }
        }

    }

}
