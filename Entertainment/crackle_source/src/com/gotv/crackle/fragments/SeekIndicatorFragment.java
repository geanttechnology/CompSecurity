// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Formatter;
import java.util.Locale;

public class SeekIndicatorFragment extends Fragment
{

    private StringBuilder mFormatBuilder;
    private Formatter mFormatter;
    private TextView mTimeText;

    public SeekIndicatorFragment()
    {
    }

    private void blink()
    {
        (new Thread(new Runnable() {

            final SeekIndicatorFragment this$0;
            final Handler val$handler;

            public void run()
            {
                long l = 500;
                try
                {
                    Thread.sleep(l);
                }
                catch (Exception exception) { }
                handler.post(new Runnable() {

                    final _cls1 this$1;

                    public void run()
                    {
                        if (mTimeText.getVisibility() == 0)
                        {
                            mTimeText.setVisibility(4);
                        } else
                        {
                            mTimeText.setVisibility(0);
                        }
                        blink();
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
            }

            
            {
                this$0 = SeekIndicatorFragment.this;
                handler = handler1;
                super();
            }
        })).start();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        mFormatBuilder = new StringBuilder();
        mFormatter = new Formatter(mFormatBuilder, Locale.getDefault());
        layoutinflater = layoutinflater.inflate(0x7f03006a, null);
        mTimeText = (TextView)layoutinflater.findViewById(0x7f0a0164);
        blink();
        return layoutinflater;
    }

    public void setTime(int i)
    {
        int k = i / 1000;
        i = k % 60;
        int j = (k / 60) % 60;
        k /= 3600;
        mFormatBuilder.setLength(0);
        String s;
        if (k > 0)
        {
            s = mFormatter.format("%d:%02d:%02d", new Object[] {
                Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i)
            }).toString();
        } else
        {
            s = mFormatter.format("%02d:%02d", new Object[] {
                Integer.valueOf(j), Integer.valueOf(i)
            }).toString();
        }
        mTimeText.setText((new StringBuilder()).append(" ").append(s).toString());
    }


}
