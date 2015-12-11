// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.view.util;

import android.app.Activity;
import android.app.Dialog;
import android.os.Parcelable;

// Referenced classes of package com.ebay.common.view.util:
//            DialogManager

public static interface 
    extends Parcelable
{

    public abstract Dialog create(DialogManager dialogmanager, Activity activity);
}
