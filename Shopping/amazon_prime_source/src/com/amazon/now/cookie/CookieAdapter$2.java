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

class val.cookie
    implements android.view.ener
{

    final CookieAdapter this$0;
    final Pair val$cookie;

    public void onClick(final View layout)
    {
        layout = LayoutInflater.from(CookieAdapter.access$000(CookieAdapter.this)).inflate(0x7f030006, null, false);
        final EditText cookieEditKey = (EditText)layout.findViewById(0x7f0e003f);
        final EditText cookieEditValue = (EditText)layout.findViewById(0x7f0e0040);
        cookieEditKey.setText((CharSequence)val$cookie.first);
        cookieEditValue.setText((CharSequence)val$cookie.second);
        android.app.der der = new android.app.der(CookieAdapter.access$000(CookieAdapter.this));
        der.setPositiveButton(0x7f0700ab, new android.content.DialogInterface.OnClickListener() {

            final CookieAdapter._cls2 this$1;
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
                this$1 = CookieAdapter._cls2.this;
                cookieEditKey = edittext;
                cookieEditValue = edittext1;
                layout = view;
                super();
            }
        });
        der.setNeutralButton(0x7f0700a1, new android.content.DialogInterface.OnClickListener() {

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
        });
        der.setNegativeButton(0x7f0700a5, new android.content.DialogInterface.OnClickListener() {

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
        });
        der.setView(layout);
        der.setCancelable(true);
        der.create().show();
    }

    _cls3.val.layout()
    {
        this$0 = final_cookieadapter;
        val$cookie = Pair.this;
        super();
    }
}
