// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.thisday;

import android.content.Context;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.http.senna.model.ContactInfo;

// Referenced classes of package com.amazon.gallery.thor.thisday:
//            ThisDayUtils, ThisDaySharedPrefsManager

static final class val.context
    implements com.amazon.gallery.framework.network..ResultHandler
{

    final Context val$context;

    public void onFailure(TerminalException terminalexception)
    {
    }

    public void onSuccess(ContactInfo contactinfo)
    {
        (new ThisDaySharedPrefsManager(val$context)).setCustomerEmailAddress(contactinfo.getEmail());
    }

    public volatile void onSuccess(Object obj)
    {
        onSuccess((ContactInfo)obj);
    }

    .model.ContactInfo(Context context1)
    {
        val$context = context1;
        super();
    }
}
