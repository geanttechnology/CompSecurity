// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.view.callbacks;

import android.view.View;
import com.groupon.db.models.Business;

public interface BusinessCardCallback
{

    public abstract void onBusinessCardBound(Business business);

    public abstract void onBusinessCardClicked(View view, Business business);
}
