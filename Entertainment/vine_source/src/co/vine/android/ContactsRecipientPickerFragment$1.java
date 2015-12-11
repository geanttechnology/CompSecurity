// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import co.vine.android.api.VineRecipient;

// Referenced classes of package co.vine.android:
//            OnContactEntryClickedListener, ContactsRecipientPickerFragment, ContactEntry

class t> extends OnContactEntryClickedListener
{

    final ContactsRecipientPickerFragment this$0;

    protected void onContactEntryClicked(ContactEntry contactentry, VineRecipient vinerecipient, int i, String s)
    {
        ContactsRecipientPickerFragment.access$200(ContactsRecipientPickerFragment.this, contactentry, vinerecipient, i, s);
    }

    ()
    {
        this$0 = ContactsRecipientPickerFragment.this;
        super();
    }
}
