// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.activity;

import com.amazon.gallery.framework.kindle.ftue.ContactInfoListener;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.http.senna.model.ContactInfo;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.amazon.gallery.framework.kindle.activity:
//            FTUEFragmentActivity

class this._cls0
    implements com.amazon.gallery.framework.network.andler
{

    final FTUEFragmentActivity this$0;

    public void onFailure(TerminalException terminalexception)
    {
    }

    public void onSuccess(ContactInfo contactinfo)
    {
        for (Iterator iterator = contactInfoListeners.iterator(); iterator.hasNext(); ((ContactInfoListener)iterator.next()).setContactInfo(contactinfo)) { }
    }

    public volatile void onSuccess(Object obj)
    {
        onSuccess((ContactInfo)obj);
    }

    I()
    {
        this$0 = FTUEFragmentActivity.this;
        super();
    }
}
