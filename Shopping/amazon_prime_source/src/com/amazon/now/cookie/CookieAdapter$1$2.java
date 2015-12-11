// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.cookie;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import com.amazon.retailsearch.android.ui.UIUtils;

// Referenced classes of package com.amazon.now.cookie:
//            CookieAdapter

class val.layout
    implements android.content.ClickListener
{

    final val.layout this$1;
    final View val$layout;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        UIUtils.closeSoftKeyboard(val$layout);
        dialoginterface.dismiss();
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$layout = View.this;
        super();
    }

    // Unreferenced inner class com/amazon/now/cookie/CookieAdapter$1

/* anonymous class */
    class CookieAdapter._cls1
        implements android.view.View.OnClickListener
    {

        final CookieAdapter this$0;

        public void onClick(final View layout)
        {
            layout = LayoutInflater.from(CookieAdapter.access$000(CookieAdapter.this)).inflate(0x7f030006, null, false);
            final EditText cookieEditKey = (EditText)layout.findViewById(0x7f0e003f);
            final EditText cookieEditValue = (EditText)layout.findViewById(0x7f0e0040);
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(CookieAdapter.access$000(CookieAdapter.this));
            builder.setPositiveButton(0x7f0700ab, new CookieAdapter._cls1._cls1());
            builder.setNeutralButton(0x7f0700a1, layout. new CookieAdapter._cls1._cls2());
            builder.setView(layout);
            builder.setCancelable(true);
            builder.create().show();
        }

            
            {
                this$0 = CookieAdapter.this;
                super();
            }

        // Unreferenced inner class com/amazon/now/cookie/CookieAdapter$1$1

/* anonymous class */
        class CookieAdapter._cls1._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final CookieAdapter._cls1 this$1;
            final EditText val$cookieEditKey;
            final EditText val$cookieEditValue;
            final View val$layout;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                CookieAdapter.access$100(this$0, cookieEditKey.getText().toString(), cookieEditValue.getText().toString());
                UIUtils.closeSoftKeyboard(layout);
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = CookieAdapter._cls1.this;
                        cookieEditKey = edittext;
                        cookieEditValue = edittext1;
                        layout = view;
                        super();
                    }
        }

    }

}
