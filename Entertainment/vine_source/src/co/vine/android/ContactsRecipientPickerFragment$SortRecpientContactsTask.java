// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.database.Cursor;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

// Referenced classes of package co.vine.android:
//            SortContactsTask, ContactsRecipientPickerFragment, ContactsPickerAdapter, ContactEntry

private class mId extends SortContactsTask
{

    private int mId;
    final ContactsRecipientPickerFragment this$0;

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((ArrayList)obj);
    }

    protected void onPostExecute(ArrayList arraylist)
    {
        ContactsRecipientPickerFragment.access$100(ContactsRecipientPickerFragment.this).clear();
        ContactsRecipientPickerFragment.access$100(ContactsRecipientPickerFragment.this).addAll(arraylist);
        mListView.setAdapter(ContactsRecipientPickerFragment.access$100(ContactsRecipientPickerFragment.this));
    }

    protected ArrayList prepareEntries(Cursor cursor)
    {
        if (mId == 0)
        {
            ArrayList arraylist = super.prepareEntries(cursor);
            Iterator iterator = arraylist.iterator();
            do
            {
                cursor = arraylist;
                if (!iterator.hasNext())
                {
                    break;
                }
                cursor = (ContactEntry)iterator.next();
                ContactsRecipientPickerFragment.access$000(ContactsRecipientPickerFragment.this).put(Long.valueOf(((ContactEntry) (cursor)).contactId), cursor);
            } while (true);
        } else
        {
            ArrayList arraylist1 = new ArrayList();
            do
            {
                if (!cursor.moveToNext())
                {
                    break;
                }
                ContactEntry contactentry = (ContactEntry)ContactsRecipientPickerFragment.access$000(ContactsRecipientPickerFragment.this).get(Long.valueOf(cursor.getLong(0)));
                if (contactentry != null)
                {
                    arraylist1.add(contactentry);
                }
            } while (true);
            Collections.sort(arraylist1);
            cursor = arraylist1;
        }
        return cursor;
    }

    public (int i)
    {
        this$0 = ContactsRecipientPickerFragment.this;
        super();
        mId = i;
    }
}
