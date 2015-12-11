// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus;

import android.app.PendingIntent;
import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.internal.eg;
import com.google.android.gms.internal.hq;
import com.google.android.gms.internal.ht;

// Referenced classes of package com.google.android.gms.plus:
//            PlusOneButton, PlusOneDummyView

public final class PlusOneButtonWithPopup extends ViewGroup
{

    private View DB;
    private int DC;
    private android.view.View.OnClickListener DH;
    private String iH;
    private String jG;
    private int mSize;

    public PlusOneButtonWithPopup(Context context)
    {
        this(context, null);
    }

    public PlusOneButtonWithPopup(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mSize = PlusOneButton.getSize(context, attributeset);
        DC = PlusOneButton.getAnnotation(context, attributeset);
        DB = new PlusOneDummyView(context, mSize);
        addView(DB);
    }

    private int c(int i, int j)
    {
        int k = android.view.View.MeasureSpec.getMode(i);
        switch (k)
        {
        default:
            return i;

        case -2147483648: 
        case 1073741824: 
            return android.view.View.MeasureSpec.makeMeasureSpec(android.view.View.MeasureSpec.getSize(i) - j, k);
        }
    }

    private void eL()
    {
        if (DB != null)
        {
            removeView(DB);
        }
        DB = ht.a(getContext(), mSize, DC, iH, jG);
        if (DH != null)
        {
            setOnClickListener(DH);
        }
        addView(DB);
    }

    private hq eM()
        throws RemoteException
    {
        hq hq1 = com.google.android.gms.internal.hq.a.aw((IBinder)DB.getTag());
        if (hq1 == null)
        {
            if (Log.isLoggable("PlusOneButtonWithPopup", 5))
            {
                Log.w("PlusOneButtonWithPopup", "Failed to get PlusOneDelegate");
            }
            throw new RemoteException();
        } else
        {
            return hq1;
        }
    }

    public void cancelClick()
    {
        if (DB == null)
        {
            break MISSING_BLOCK_LABEL_16;
        }
        eM().cancelClick();
        return;
        RemoteException remoteexception;
        remoteexception;
    }

    public PendingIntent getResolution()
    {
        if (DB == null)
        {
            break MISSING_BLOCK_LABEL_20;
        }
        PendingIntent pendingintent = eM().getResolution();
        return pendingintent;
        RemoteException remoteexception;
        remoteexception;
        return null;
    }

    public void initialize(String s, String s1)
    {
        eg.b(s, "Url must not be null");
        iH = s;
        jG = s1;
        eL();
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        DB.layout(getPaddingLeft(), getPaddingTop(), k - i - getPaddingRight(), l - j - getPaddingBottom());
    }

    protected void onMeasure(int i, int j)
    {
        int k = getPaddingLeft() + getPaddingRight();
        int l = getPaddingTop() + getPaddingBottom();
        DB.measure(c(i, k), c(j, l));
        setMeasuredDimension(k + DB.getMeasuredWidth(), l + DB.getMeasuredHeight());
    }

    public void reinitialize()
    {
        if (DB == null)
        {
            break MISSING_BLOCK_LABEL_16;
        }
        eM().reinitialize();
        return;
        RemoteException remoteexception;
        remoteexception;
    }

    public void setAnnotation(int i)
    {
        DC = i;
        eL();
    }

    public void setOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        DH = onclicklistener;
        DB.setOnClickListener(onclicklistener);
    }

    public void setSize(int i)
    {
        mSize = i;
        eL();
    }
}
