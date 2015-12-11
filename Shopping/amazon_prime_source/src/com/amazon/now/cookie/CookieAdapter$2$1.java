// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.cookie;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Pair;
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
    final EditText val$cookieEditKey;
    final EditText val$cookieEditValue;
    final View val$layout;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        CookieAdapter.access$100(_fld0, val$cookieEditKey.getText().toString(), val$cookieEditValue.getText().toString());
        UIUtils.closeSoftKeyboard(val$layout);
        dialoginterface.dismiss();
    }

    l.cookie()
    {
        this$1 = final_cookie;
        val$cookieEditKey = edittext;
        val$cookieEditValue = edittext1;
        val$layout = View.this;
        super();
    }

    // Unreferenced inner class com/amazon/now/cookie/CookieAdapter$2

/* anonymous class */
    class CookieAdapter._cls2
        implements android.view.View.OnClickListener
    {

        final CookieAdapter this$0;
        final Pair val$cookie;

        public void onClick(final View layout)
        {
            layout = LayoutInflater.from(CookieAdapter.access$000(CookieAdapter.this)).inflate(0x7f030006, null, false);
            final EditText cookieEditKey = (EditText)layout.findViewById(0x7f0e003f);
            final EditText cookieEditValue = (EditText)layout.findViewById(0x7f0e0040);
            cookieEditKey.setText((CharSequence)cookie.first);
            cookieEditValue.setText((CharSequence)cookie.second);
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(CookieAdapter.access$000(CookieAdapter.this));
            builder.setPositiveButton(0x7f0700ab, layout. new CookieAdapter._cls2._cls1());
            builder.setNeutralButton(0x7f0700a1, new CookieAdapter._cls2._cls2());
            builder.setNegativeButton(0x7f0700a5, new CookieAdapter._cls2._cls3());
            builder.setView(layout);
            builder.setCancelable(true);
            builder.create().show();
        }

            
            {
                this$0 = final_cookieadapter;
                cookie = Pair.this;
                super();
            }

        // Unreferenced inner class com/amazon/now/cookie/CookieAdapter$2$2

/* anonymous class */
        class CookieAdapter._cls2._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final CookieAdapter._cls2 this$1;
            final View val$layout;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                UIUtils.closeSoftKeyboard(layout);
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = CookieAdapter._cls2.this;
                        layout = view;
                        super();
                    }
        }


        // Unreferenced inner class com/amazon/now/cookie/CookieAdapter$2$3

/* anonymous class */
        class CookieAdapter._cls2._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final CookieAdapter._cls2 this$1;
            final View val$layout;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                CookieAdapter.access$200(this$0, (String)cookie.first);
                UIUtils.closeSoftKeyboard(layout);
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = CookieAdapter._cls2.this;
                        layout = view;
                        super();
                    }
        }

    }

}
