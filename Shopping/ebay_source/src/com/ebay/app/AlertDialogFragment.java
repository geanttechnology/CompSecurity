// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.app;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import com.ebay.mobile.ui_stuff.Util;

// Referenced classes of package com.ebay.app:
//            DialogFragmentCallback

public class AlertDialogFragment extends DialogFragment
{
    public static class Builder
    {

        private final Fields fields = new Fields();
        private int messageId;
        private int negativeButtonTextId;
        private int positiveButtonTextId;
        private int titleId;

        public AlertDialogFragment createFromActivity(int i)
        {
            return createFromFragment(i, null);
        }

        public AlertDialogFragment createFromFragment(int i, Fragment fragment)
        {
            return createFromFragment(i, fragment, null);
        }

        public AlertDialogFragment createFromFragment(int i, Fragment fragment, Bundle bundle)
        {
            AlertDialogFragment alertdialogfragment = new AlertDialogFragment();
            Bundle bundle1 = bundle;
            if (bundle == null)
            {
                bundle1 = new Bundle();
            }
            bundle1.putCharSequence("title", fields.title);
            bundle1.putCharSequence("message", fields.message);
            bundle1.putCharSequence("positiveButtonText", fields.positiveButtonText);
            bundle1.putCharSequence("negativeButtonText", fields.negativeButtonText);
            bundle1.putInt("titleId", titleId);
            bundle1.putInt("messageId", messageId);
            bundle1.putInt("positiveButtonTextId", positiveButtonTextId);
            bundle1.putInt("negativeButtonTextId", negativeButtonTextId);
            bundle1.putCharSequenceArray("items", fields.items);
            bundle1.putBooleanArray("checkedItems", fields.checkedItems);
            bundle1.putBoolean("messageAsWebview", fields.messageAsWebview);
            bundle1.putBoolean("retainInstance", fields.retainInstance);
            bundle1.putBoolean("linksClickable", fields.linksClickable);
            alertdialogfragment.setArguments(bundle1);
            alertdialogfragment.setTargetFragment(fragment, i);
            return alertdialogfragment;
        }

        public Builder setItems(String as[])
        {
            fields.items = as;
            return this;
        }

        public Builder setLinksClickable(boolean flag)
        {
            fields.linksClickable = flag;
            return this;
        }

        public Builder setMessage(int i)
        {
            messageId = i;
            fields.message = null;
            return this;
        }

        public Builder setMessage(CharSequence charsequence)
        {
            fields.message = charsequence;
            return this;
        }

        public Builder setMessageAsWebview(boolean flag)
        {
            fields.messageAsWebview = flag;
            return this;
        }

        public Builder setMultiChoiceItems(String as[], boolean aflag[])
        {
            fields.items = as;
            fields.checkedItems = aflag;
            return this;
        }

        public Builder setNegativeButton(int i)
        {
            negativeButtonTextId = i;
            fields.negativeButtonText = null;
            return this;
        }

        public Builder setNegativeButton(CharSequence charsequence)
        {
            fields.negativeButtonText = charsequence;
            return this;
        }

        public Builder setPositiveButton(int i)
        {
            positiveButtonTextId = i;
            fields.positiveButtonText = null;
            return this;
        }

        public Builder setPositiveButton(CharSequence charsequence)
        {
            fields.positiveButtonText = charsequence;
            return this;
        }

        public Builder setRetainInstance(boolean flag)
        {
            fields.retainInstance = flag;
            return this;
        }

        public Builder setTitle(int i)
        {
            titleId = i;
            fields.title = null;
            return this;
        }

        public Builder setTitle(CharSequence charsequence)
        {
            fields.title = charsequence;
            return this;
        }

        public Builder()
        {
            titleId = -1;
            messageId = -1;
            positiveButtonTextId = -1;
            negativeButtonTextId = -1;
        }
    }

    private static class Fields
    {

        private boolean checkedItems[];
        private CharSequence items[];
        public boolean linksClickable;
        private CharSequence message;
        private boolean messageAsWebview;
        private CharSequence negativeButtonText;
        private CharSequence positiveButtonText;
        public boolean retainInstance;
        private CharSequence title;



/*
        static CharSequence access$102(Fields fields1, CharSequence charsequence)
        {
            fields1.title = charsequence;
            return charsequence;
        }

*/



/*
        static CharSequence access$202(Fields fields1, CharSequence charsequence)
        {
            fields1.message = charsequence;
            return charsequence;
        }

*/



/*
        static CharSequence access$302(Fields fields1, CharSequence charsequence)
        {
            fields1.positiveButtonText = charsequence;
            return charsequence;
        }

*/



/*
        static CharSequence access$402(Fields fields1, CharSequence charsequence)
        {
            fields1.negativeButtonText = charsequence;
            return charsequence;
        }

*/



/*
        static boolean access$502(Fields fields1, boolean flag)
        {
            fields1.messageAsWebview = flag;
            return flag;
        }

*/



/*
        static CharSequence[] access$602(Fields fields1, CharSequence acharsequence[])
        {
            fields1.items = acharsequence;
            return acharsequence;
        }

*/



/*
        static boolean[] access$702(Fields fields1, boolean aflag[])
        {
            fields1.checkedItems = aflag;
            return aflag;
        }

*/

        private Fields()
        {
            retainInstance = true;
        }

    }


    private static final String CHECKED_ITEMS = "checkedItems";
    private static final String ITEMS = "items";
    private static final String LINKS_CLICKABLE = "linksClickable";
    private static final String MESSAGE = "message";
    private static final String MESSAGE_AS_WEBVIEW = "messageAsWebview";
    private static final String MESSAGE_ID = "messageId";
    private static final String NEGATIVE_BUTTON_TEXT = "negativeButtonText";
    private static final String NEGATIVE_BUTTON_TEXT_ID = "negativeButtonTextId";
    private static final String POSITIVE_BUTTON_TEXT = "positiveButtonText";
    private static final String POSITIVE_BUTTON_TEXT_ID = "positiveButtonTextId";
    private static final String RETAIN_INSTANCE = "retainInstance";
    private static final String TITLE = "title";
    private static final String TITLE_ID = "titleId";
    private final Fields fields = new Fields();

    public AlertDialogFragment()
    {
    }

    public boolean[] getCheckedItems()
    {
        return fields.checkedItems;
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        if (getTargetFragment() != null && (getTargetFragment() instanceof DialogFragmentCallback))
        {
            ((DialogFragmentCallback)getTargetFragment()).onDialogFragmentResult(this, getTargetRequestCode(), 3);
        } else
        if (getActivity() instanceof DialogFragmentCallback)
        {
            ((DialogFragmentCallback)getActivity()).onDialogFragmentResult(this, getTargetRequestCode(), 3);
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getArguments();
        boolean flag;
        if (bundle != null && bundle.getBoolean("retainInstance"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setRetainInstance(flag);
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        fields.title = getArguments().getCharSequence("title");
        fields.message = getArguments().getCharSequence("message");
        fields.positiveButtonText = getArguments().getCharSequence("positiveButtonText");
        fields.negativeButtonText = getArguments().getCharSequence("negativeButtonText");
        fields.messageAsWebview = getArguments().getBoolean("messageAsWebview");
        fields.items = getArguments().getStringArray("items");
        fields.checkedItems = getArguments().getBooleanArray("checkedItems");
        fields.linksClickable = getArguments().getBoolean("linksClickable");
        if (TextUtils.isEmpty(fields.title))
        {
            int i = getArguments().getInt("titleId", -1);
            if (-1 != i)
            {
                fields.title = getString(i);
            }
        }
        if (TextUtils.isEmpty(fields.message) && -1 != getArguments().getInt("messageId", -1))
        {
            fields.message = getString(getArguments().getInt("messageId"));
        }
        if (TextUtils.isEmpty(fields.positiveButtonText) && -1 != getArguments().getInt("positiveButtonTextId", -1))
        {
            fields.positiveButtonText = getString(getArguments().getInt("positiveButtonTextId"));
        }
        if (TextUtils.isEmpty(fields.negativeButtonText) && -1 != getArguments().getInt("negativeButtonTextId", -1))
        {
            fields.negativeButtonText = getString(getArguments().getInt("negativeButtonTextId"));
        }
        bundle = new android.support.v7.app.AlertDialog.Builder(getActivity());
        bundle.setTitle(fields.title);
        if (fields.messageAsWebview && fields.message != null)
        {
            WebView webview = (WebView)Util.setFilterTouchesWhenObscured(new WebView(getActivity()));
            webview.loadDataWithBaseURL(null, fields.message.toString(), "text/html", "utf-8", "about:blank");
            webview.setWebViewClient(new WebViewClient() {

                final AlertDialogFragment this$0;

                public boolean shouldOverrideUrlLoading(WebView webview1, String s)
                {
                    if (!TextUtils.isEmpty(s))
                    {
                        webview1 = new Intent("android.intent.action.VIEW", Uri.parse(s));
                        startActivity(webview1);
                    }
                    return true;
                }

            
            {
                this$0 = AlertDialogFragment.this;
                super();
            }
            });
            bundle.setView(webview);
        } else
        {
            bundle.setMessage(fields.message);
        }
        if (!TextUtils.isEmpty(fields.positiveButtonText))
        {
            bundle.setPositiveButton(fields.positiveButtonText, new android.content.DialogInterface.OnClickListener() {

                final AlertDialogFragment this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    if (getTargetFragment() == null || !(getTargetFragment() instanceof DialogFragmentCallback)) goto _L2; else goto _L1
_L1:
                    ((DialogFragmentCallback)getTargetFragment()).onDialogFragmentResult(AlertDialogFragment.this, getTargetRequestCode(), 1);
_L4:
                    dialoginterface.dismiss();
                    return;
_L2:
                    if (getActivity() instanceof DialogFragmentCallback)
                    {
                        ((DialogFragmentCallback)getActivity()).onDialogFragmentResult(AlertDialogFragment.this, getTargetRequestCode(), 1);
                    }
                    if (true) goto _L4; else goto _L3
_L3:
                }

            
            {
                this$0 = AlertDialogFragment.this;
                super();
            }
            });
        }
        if (!TextUtils.isEmpty(fields.negativeButtonText))
        {
            bundle.setNegativeButton(fields.negativeButtonText, new android.content.DialogInterface.OnClickListener() {

                final AlertDialogFragment this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    if (getTargetFragment() == null || !(getTargetFragment() instanceof DialogFragmentCallback)) goto _L2; else goto _L1
_L1:
                    ((DialogFragmentCallback)getTargetFragment()).onDialogFragmentResult(AlertDialogFragment.this, getTargetRequestCode(), 2);
_L4:
                    dialoginterface.dismiss();
                    return;
_L2:
                    if (getActivity() instanceof DialogFragmentCallback)
                    {
                        ((DialogFragmentCallback)getActivity()).onDialogFragmentResult(AlertDialogFragment.this, getTargetRequestCode(), 2);
                    }
                    if (true) goto _L4; else goto _L3
_L3:
                }

            
            {
                this$0 = AlertDialogFragment.this;
                super();
            }
            });
        }
        if (fields.checkedItems != null)
        {
            bundle.setMultiChoiceItems(fields.items, fields.checkedItems, new android.content.DialogInterface.OnMultiChoiceClickListener() {

                final AlertDialogFragment this$0;

                public void onClick(DialogInterface dialoginterface, int j, boolean flag)
                {
                    fields.checkedItems[j] = flag;
                }

            
            {
                this$0 = AlertDialogFragment.this;
                super();
            }
            });
        }
        if (fields.checkedItems == null && fields.items != null)
        {
            bundle.setItems(fields.items, new android.content.DialogInterface.OnClickListener() {

                final AlertDialogFragment this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    if (getTargetFragment() == null || !(getTargetFragment() instanceof DialogFragmentCallback)) goto _L2; else goto _L1
_L1:
                    ((DialogFragmentCallback)getTargetFragment()).onDialogFragmentResult(AlertDialogFragment.this, getTargetRequestCode(), j);
_L4:
                    dialoginterface.dismiss();
                    return;
_L2:
                    if (getActivity() instanceof DialogFragmentCallback)
                    {
                        ((DialogFragmentCallback)getActivity()).onDialogFragmentResult(AlertDialogFragment.this, getTargetRequestCode(), j);
                    }
                    if (true) goto _L4; else goto _L3
_L3:
                }

            
            {
                this$0 = AlertDialogFragment.this;
                super();
            }
            });
        }
        return bundle.create();
    }

    public void onStart()
    {
        super.onStart();
        if (fields.linksClickable && getView() != null)
        {
            TextView textview = (TextView)getView().findViewById(0x102000b);
            if (textview != null)
            {
                textview.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
    }

}
