// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Filter;
import android.widget.Filterable;
import java.lang.ref.WeakReference;

// Referenced classes of package co.vine.android.widget:
//            PopupEditText

private static class mListenerRef extends Handler
{

    private Filterable mFilterable;
    private final WeakReference mListenerRef;
    private istener mOnFilterListener;

    public void handleMessage(Message message)
    {
        android.widget.Handler handler = (android.widget.Handler)mListenerRef.get();
        if (mFilterable != null && handler != null)
        {
            CharSequence charsequence = (CharSequence)message.obj;
            mFilterable.getFilter().filter(charsequence, handler);
            if (message.arg1 == 1 && mOnFilterListener != null)
            {
                mOnFilterListener.onFiltering(charsequence);
            }
        }
    }

    public void setFilterable(Filterable filterable)
    {
        mFilterable = filterable;
    }

    public void setOnFilterListener(istener istener)
    {
        mOnFilterListener = istener;
    }

    public istener(Looper looper, android.widget.Handler handler)
    {
        super(looper);
        mListenerRef = new WeakReference(handler);
    }
}
