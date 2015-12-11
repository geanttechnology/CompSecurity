// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// Referenced classes of package co.vine.android:
//            SortContactsTask, InboxFragment, ContactEntry

private class <init> extends SortContactsTask
{

    final InboxFragment this$0;

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((ArrayList)obj);
    }

    protected void onPostExecute(ArrayList arraylist)
    {
        InboxFragment.access$902(InboxFragment.this, null);
        InboxFragment.access$1002(InboxFragment.this, new HashMap());
        ContactEntry contactentry;
        for (Iterator iterator = arraylist.iterator(); iterator.hasNext(); InboxFragment.access$1000(InboxFragment.this).put(Long.valueOf(contactentry.contactId), contactentry))
        {
            contactentry = (ContactEntry)iterator.next();
        }

        InboxFragment.access$1102(InboxFragment.this, arraylist);
        InboxFragment.access$1200(InboxFragment.this);
    }

    private ()
    {
        this$0 = InboxFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
