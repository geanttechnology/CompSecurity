// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.widget.TextView;

// Referenced classes of package com.aio.downloader.activity:
//            FloatCleanerMaster

class this._cls0
    implements com.aio.downloader.views.geListener
{

    final FloatCleanerMaster this$0;

    public void OnAngelChanged(int i)
    {
        SpannableString spannablestring = new SpannableString((new StringBuilder(String.valueOf((i * 100) / 360))).append("%").toString());
        spannablestring.setSpan(new AbsoluteSizeSpan(35), spannablestring.length() - 1, spannablestring.length(), 33);
        FloatCleanerMaster.access$0(FloatCleanerMaster.this).setText(spannablestring);
    }

    istener()
    {
        this$0 = FloatCleanerMaster.this;
        super();
    }
}
