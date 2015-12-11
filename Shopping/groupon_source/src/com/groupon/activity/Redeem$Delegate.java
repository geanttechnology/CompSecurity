// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.os.Bundle;
import java.util.Date;

// Referenced classes of package com.groupon.activity:
//            Redeem

public abstract class this._cls0
{

    final Redeem this$0;

    public abstract String getExpirationString(Date date, String s, Integer integer);

    public abstract String getGrouponString(String s);

    public abstract int getInstructionsAndHelpStringResource();

    public abstract String getRefNumberString(String s);

    public abstract String getSecurityCodeString(String s);

    public abstract void onClick();

    public abstract void onCreate(Bundle bundle);

    public abstract void refresh();

    public ()
    {
        this$0 = Redeem.this;
        super();
    }
}
