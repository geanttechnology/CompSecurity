// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import co.vine.android.api.VineRecipient;
import co.vine.android.client.AppController;

// Referenced classes of package co.vine.android:
//            OnContactEntryClickedListener, InboxFragment, ContactEntry

class ickedListener extends OnContactEntryClickedListener
{

    final InboxFragment this$0;

    protected void onContactEntryClicked(ContactEntry contactentry, VineRecipient vinerecipient, int i, String s)
    {
        if (mWaitingToStartId == -1L)
        {
            mWaitingToStartId = vinerecipient.contactId;
            mAppController.fetchConversationRowIdFromSingleRecipient(vinerecipient, 1);
        }
    }

    t()
    {
        this$0 = InboxFragment.this;
        super();
    }
}
