// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class EbayScrollView extends ScrollView
{
    public static interface OnScrollChangedListener
    {

        public abstract void onScrollChanged(EbayScrollView ebayscrollview, int i, int j, int k, int l);
    }


    private List listeners;

    public EbayScrollView(Context context)
    {
        super(context);
    }

    public EbayScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public EbayScrollView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public void addOnScrollViewListener(OnScrollChangedListener onscrollchangedlistener)
    {
        if (listeners == null)
        {
            listeners = new ArrayList();
        }
        if (onscrollchangedlistener != null)
        {
            listeners.add(onscrollchangedlistener);
        }
    }

    public List getListeners()
    {
        if (listeners == null)
        {
            return null;
        } else
        {
            return Collections.unmodifiableList(listeners);
        }
    }

    public boolean isListening(OnScrollChangedListener onscrollchangedlistener)
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            flag = flag1;
            if (listeners == null)
            {
                break label0;
            }
            Iterator iterator = listeners.iterator();
            do
            {
                flag = flag1;
                if (!iterator.hasNext())
                {
                    break label0;
                }
            } while ((OnScrollChangedListener)iterator.next() != onscrollchangedlistener);
            flag = true;
        }
        return flag;
    }

    public void onScrollChanged(int i, int j, int k, int l)
    {
        if (listeners != null)
        {
            Iterator iterator = listeners.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                OnScrollChangedListener onscrollchangedlistener = (OnScrollChangedListener)iterator.next();
                if (onscrollchangedlistener != null)
                {
                    onscrollchangedlistener.onScrollChanged(this, i, j, k, l);
                }
            } while (true);
        }
        super.onScrollChanged(i, j, k, l);
    }

    public void removeOnScrollViewListener(OnScrollChangedListener onscrollchangedlistener)
    {
        if (listeners != null)
        {
            listeners.remove(onscrollchangedlistener);
        }
    }

    public void setOnScrollViewListener(OnScrollChangedListener onscrollchangedlistener)
    {
        if (listeners == null)
        {
            listeners = new ArrayList();
        } else
        {
            listeners.clear();
        }
        if (onscrollchangedlistener != null)
        {
            listeners.add(onscrollchangedlistener);
        }
    }
}
