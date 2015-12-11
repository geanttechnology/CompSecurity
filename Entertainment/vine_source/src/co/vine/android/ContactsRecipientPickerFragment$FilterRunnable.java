// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.os.Bundle;
import android.support.v4.app.LoaderManager;

// Referenced classes of package co.vine.android:
//            ContactsRecipientPickerFragment

private class mQuery
    implements Runnable
{

    private String mQuery;
    final ContactsRecipientPickerFragment this$0;

    public void run()
    {
        Bundle bundle = new Bundle();
        bundle.putString("filter", mQuery);
        getLoaderManager().restartLoader(1, bundle, ContactsRecipientPickerFragment.this);
    }

    public (String s)
    {
        this$0 = ContactsRecipientPickerFragment.this;
        super();
        mQuery = s;
    }
}
