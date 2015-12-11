// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.g;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.target.ui.adapter.b.e;
import com.target.ui.model.scan.ScanResultItem;
import com.target.ui.util.al;
import java.util.List;

public class com.target.ui.adapter.g.a extends e
{
    private static class a
    {

        private final TextView lookupErrorTextView;
        private final TextView productTextView;
        private final View progressBar;
        private final TextView retryNoConnectionTextView;
        private final TextView scanResultTextView;

        static TextView a(a a1)
        {
            return a1.scanResultTextView;
        }

        static TextView b(a a1)
        {
            return a1.productTextView;
        }

        static TextView c(a a1)
        {
            return a1.lookupErrorTextView;
        }

        static TextView d(a a1)
        {
            return a1.retryNoConnectionTextView;
        }

        static View e(a a1)
        {
            return a1.progressBar;
        }

        public a(View view)
        {
            productTextView = (TextView)view.findViewById(0x7f100597);
            scanResultTextView = (TextView)view.findViewById(0x7f100596);
            progressBar = view.findViewById(0x7f100598);
            lookupErrorTextView = (TextView)view.findViewById(0x7f100599);
            retryNoConnectionTextView = (TextView)view.findViewById(0x7f10059a);
        }
    }


    private int mAttentionColor;

    public com.target.ui.adapter.g.a(Context context, List list)
    {
        super(context, list);
        setNotifyOnChange(false);
        mAttentionColor = getContext().getResources().getColor(0x7f0f00e9);
    }

    private int a()
    {
        return 0x7f0301e6;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        ScanResultItem scanresultitem = (ScanResultItem)getItem(i);
        static class _cls1
        {

            static final int $SwitchMap$com$target$ui$model$scan$ScanResultItem$ScanStatus[];

            static 
            {
                $SwitchMap$com$target$ui$model$scan$ScanResultItem$ScanStatus = new int[com.target.ui.model.scan.ScanResultItem.a.values().length];
                try
                {
                    $SwitchMap$com$target$ui$model$scan$ScanResultItem$ScanStatus[com.target.ui.model.scan.ScanResultItem.a.UPC_RESULT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$target$ui$model$scan$ScanResultItem$ScanStatus[com.target.ui.model.scan.ScanResultItem.a.PRODUCT_RESULT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$ui$model$scan$ScanResultItem$ScanStatus[com.target.ui.model.scan.ScanResultItem.a.CONNECTION_ISSUE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$ui$model$scan$ScanResultItem$ScanStatus[com.target.ui.model.scan.ScanResultItem.a.PRODUCT_NOT_FOUND.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$model$scan$ScanResultItem$ScanStatus[com.target.ui.model.scan.ScanResultItem.a.NO_RESULT.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        if (view == null)
        {
            view = mInflater.inflate(a(), viewgroup, false);
            viewgroup = new a(view);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (a)view.getTag();
        }
        a.a(viewgroup).setText(scanresultitem.a());
        a.b(viewgroup).setText(scanresultitem.b());
        switch (_cls1..SwitchMap.com.target.ui.model.scan.ScanResultItem.ScanStatus[scanresultitem.c().ordinal()])
        {
        default:
            return view;

        case 1: // '\001'
            al.a(new View[] {
                a.b(viewgroup), a.c(viewgroup), a.d(viewgroup)
            });
            al.b(new View[] {
                a.a(viewgroup), com.target.ui.adapter.g.a.e(viewgroup)
            });
            return view;

        case 2: // '\002'
            al.a(new View[] {
                a.a(viewgroup), a.c(viewgroup), a.d(viewgroup), com.target.ui.adapter.g.a.e(viewgroup)
            });
            al.b(a.b(viewgroup));
            return view;

        case 3: // '\003'
            i = getContext().getResources().getColor(0x7f0f00f6);
            a.a(viewgroup).setTextColor(i);
            al.a(new View[] {
                a.b(viewgroup), a.c(viewgroup), com.target.ui.adapter.g.a.e(viewgroup)
            });
            al.b(new View[] {
                a.a(viewgroup), a.d(viewgroup)
            });
            return view;

        case 4: // '\004'
            a.a(viewgroup).setTextColor(mAttentionColor);
            break;
        }
        al.a(new View[] {
            a.b(viewgroup), a.d(viewgroup), com.target.ui.adapter.g.a.e(viewgroup)
        });
        al.b(new View[] {
            a.a(viewgroup), a.c(viewgroup)
        });
        return view;
    }

    public boolean isEnabled(int i)
    {
        return false;
    }
}
