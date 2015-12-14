// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.customad;

import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import com.crashlytics.android.Crashlytics;

class this._cls1 extends Handler
{

    final this._cls1 this$1;

    public void handleMessage(Message message)
    {
        super.handleMessage(message);
        try
        {
            if (message.what == 1 && cess._mth000(this._cls1.this) != null)
            {
                message = BitmapFactory.decodeByteArray(cess._mth000(this._cls1.this), 0, cess._mth000(this._cls1.this).length);
                cess._mth100(this._cls1.this).setImageBitmap(message);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            Crashlytics.logException(message);
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
