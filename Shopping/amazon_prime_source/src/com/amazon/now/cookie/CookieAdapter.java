// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.cookie;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.amazon.now.util.AppUtils;
import com.amazon.retailsearch.android.ui.UIUtils;
import java.util.ArrayList;
import java.util.List;

public class CookieAdapter extends ArrayAdapter
{

    private final Context mContext;
    private List mCookies;
    private final String mDomain = AppUtils.getServiceDomain();

    public CookieAdapter(Context context)
    {
        super(context, 0);
        mContext = context;
        mCookies = getCookies();
        super.addAll(mCookies);
    }

    private void addCookie(String s, String s1)
    {
        CookieManager.getInstance().setCookie(mDomain, String.format("%s=%s", new Object[] {
            s, s1
        }));
        recreate();
    }

    private void deleteCookie(String s)
    {
        CookieManager.getInstance().setCookie(mDomain, String.format("%s=", new Object[] {
            s
        }));
        recreate();
    }

    private List getCookies()
    {
        String as[] = CookieManager.getInstance().getCookie(mDomain).split(";");
        ArrayList arraylist = new ArrayList();
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            String as1[] = as[i].split("=");
            if (as1.length == 2)
            {
                arraylist.add(new Pair(as1[0], as1[1]));
            }
        }

        arraylist.add(null);
        return arraylist;
    }

    private void recreate()
    {
        clear();
        mCookies = getCookies();
        addAll(mCookies);
        notifyDataSetChanged();
    }

    public View getView(int i, final View cookie, ViewGroup viewgroup)
    {
        cookie = (Pair)mCookies.get(i);
        if (cookie == null)
        {
            cookie = LayoutInflater.from(mContext).inflate(0x7f030005, viewgroup, false);
            ((Button)cookie.findViewById(0x7f0e003e)).setOnClickListener(new android.view.View.OnClickListener() {

                final CookieAdapter this$0;

                public void onClick(View view)
                {
                    view = LayoutInflater.from(mContext).inflate(0x7f030006, null, false);
                    final EditText cookieEditKey = (EditText)view.findViewById(0x7f0e003f);
                    final EditText cookieEditValue = (EditText)view.findViewById(0x7f0e0040);
                    android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(mContext);
                    builder.setPositiveButton(0x7f0700ab, view. new android.content.DialogInterface.OnClickListener() {

                        final _cls1 this$1;
                        final EditText val$cookieEditKey;
                        final EditText val$cookieEditValue;
                        final View val$layout;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            addCookie(cookieEditKey.getText().toString(), cookieEditValue.getText().toString());
                            UIUtils.closeSoftKeyboard(layout);
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = final__pcls1;
                cookieEditKey = edittext;
                cookieEditValue = edittext1;
                layout = View.this;
                super();
            }
                    });
                    builder.setNeutralButton(0x7f0700a1, view. new android.content.DialogInterface.OnClickListener() {

                        final _cls1 this$1;
                        final View val$layout;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            UIUtils.closeSoftKeyboard(layout);
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = final__pcls1;
                layout = View.this;
                super();
            }
                    });
                    builder.setView(view);
                    builder.setCancelable(true);
                    builder.create().show();
                }

            
            {
                this$0 = CookieAdapter.this;
                super();
            }
            });
            return cookie;
        } else
        {
            viewgroup = LayoutInflater.from(mContext).inflate(0x7f030007, viewgroup, false);
            TextView textview = (TextView)viewgroup.findViewById(0x7f0e0041);
            TextView textview1 = (TextView)viewgroup.findViewById(0x7f0e0042);
            textview.setText((CharSequence)((Pair) (cookie)).first);
            textview1.setText(Uri.decode((String)((Pair) (cookie)).second));
            viewgroup.setOnClickListener(new android.view.View.OnClickListener() {

                final CookieAdapter this$0;
                final Pair val$cookie;

                public void onClick(View view)
                {
                    view = LayoutInflater.from(mContext).inflate(0x7f030006, null, false);
                    final EditText cookieEditKey = (EditText)view.findViewById(0x7f0e003f);
                    final EditText cookieEditValue = (EditText)view.findViewById(0x7f0e0040);
                    cookieEditKey.setText((CharSequence)cookie.first);
                    cookieEditValue.setText((CharSequence)cookie.second);
                    android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(mContext);
                    builder.setPositiveButton(0x7f0700ab, view. new android.content.DialogInterface.OnClickListener() {

                        final _cls2 this$1;
                        final EditText val$cookieEditKey;
                        final EditText val$cookieEditValue;
                        final View val$layout;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            addCookie(cookieEditKey.getText().toString(), cookieEditValue.getText().toString());
                            UIUtils.closeSoftKeyboard(layout);
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = final__pcls2;
                cookieEditKey = edittext;
                cookieEditValue = edittext1;
                layout = View.this;
                super();
            }
                    });
                    builder.setNeutralButton(0x7f0700a1, view. new android.content.DialogInterface.OnClickListener() {

                        final _cls2 this$1;
                        final View val$layout;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            UIUtils.closeSoftKeyboard(layout);
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = final__pcls2;
                layout = View.this;
                super();
            }
                    });
                    builder.setNegativeButton(0x7f0700a5, view. new android.content.DialogInterface.OnClickListener() {

                        final _cls2 this$1;
                        final View val$layout;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            deleteCookie((String)cookie.first);
                            UIUtils.closeSoftKeyboard(layout);
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = final__pcls2;
                layout = View.this;
                super();
            }
                    });
                    builder.setView(view);
                    builder.setCancelable(true);
                    builder.create().show();
                }

            
            {
                this$0 = CookieAdapter.this;
                cookie = pair;
                super();
            }
            });
            return viewgroup;
        }
    }



}
