// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import co.vine.android.api.VineRecipient;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

// Referenced classes of package co.vine.android:
//            BaseRecipientPickerFragment, ContactsPickerAdapter, ContactEntry, OnContactEntryClickedListener, 
//            SortContactsTask

public class ContactsRecipientPickerFragment extends BaseRecipientPickerFragment
{
    private class FilterRunnable
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

        public FilterRunnable(String s)
        {
            this$0 = ContactsRecipientPickerFragment.this;
            super();
            mQuery = s;
        }
    }

    protected static final class RecipientContactsQuery
    {

        public static final int INDEX_CONTACT_ID = 0;
        public static final int INDEX_DISPLAY_NAME_ALTERNATE = 2;
        public static final int INDEX_DISPLAY_NAME_PRIMARY = 1;
        public static final int INDEX_MIMETYPE = 3;
        public static final int INDEX_VALUE = 4;

        protected RecipientContactsQuery()
        {
        }
    }

    private class SortRecpientContactsTask extends SortContactsTask
    {

        private int mId;
        final ContactsRecipientPickerFragment this$0;

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((ArrayList)obj);
        }

        protected void onPostExecute(ArrayList arraylist)
        {
            mActiveAdapter.clear();
            mActiveAdapter.addAll(arraylist);
            mListView.setAdapter(mActiveAdapter);
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
                    mContactEntryMap.put(Long.valueOf(((ContactEntry) (cursor)).contactId), cursor);
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
                    ContactEntry contactentry = (ContactEntry)mContactEntryMap.get(Long.valueOf(cursor.getLong(0)));
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

        public SortRecpientContactsTask(int i)
        {
            this$0 = ContactsRecipientPickerFragment.this;
            super();
            mId = i;
        }
    }


    public static final int FLAG_EMAIL = 1;
    public static final int FLAG_PHONE = 2;
    public static final int LOADER_ID_FILTER_CONTACTS = 1;
    private ContactsPickerAdapter mActiveAdapter;
    private ContactsPickerAdapter mArrayAdapter;
    private HashMap mContactEntryMap;
    private ContactsPickerAdapter mFilterAdapter;
    private AsyncTask mFilterTask;
    private final OnContactEntryClickedListener mListener = new OnContactEntryClickedListener() {

        final ContactsRecipientPickerFragment this$0;

        protected void onContactEntryClicked(ContactEntry contactentry, VineRecipient vinerecipient, int i, String s)
        {
            ContactsRecipientPickerFragment.this.onContactEntryClicked(contactentry, vinerecipient, i, s);
        }

            
            {
                this$0 = ContactsRecipientPickerFragment.this;
                super();
            }
    };

    public ContactsRecipientPickerFragment()
    {
    }

    private void onContactEntryClicked(ContactEntry contactentry, VineRecipient vinerecipient, int i, String s)
    {
        if (!isRecipientSelected(vinerecipient))
        {
            addRecipient(vinerecipient);
            if (mActiveAdapter != null)
            {
                mActiveAdapter.onRecipientItemAdded(contactentry, i, s);
            }
            return;
        } else
        {
            removeRecipient(vinerecipient);
            onRecipientItemRemoved(vinerecipient);
            return;
        }
    }

    protected void handleFocus()
    {
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        mProjection = ContactEntry.sProjection;
        mSelection = "mimetype=? OR mimetype=?";
        mSelArgs = ContactEntry.sSelectionArgs;
        mSortOrder = "contact_id ASC ";
        if (mArrayAdapter == null)
        {
            mArrayAdapter = new ContactsPickerAdapter(this);
        }
        if (mFilterAdapter == null)
        {
            mFilterAdapter = new ContactsPickerAdapter(this);
        }
        mContactEntryMap = new HashMap();
        mListView.setChoiceMode(0);
        initLoader();
    }

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        switch (i)
        {
        default:
            bundle = ContactEntry.sUri;
            return new CursorLoader(getActivity(), bundle, mProjection, mSelection, mSelArgs, mSortOrder);

        case 1: // '\001'
            bundle = bundle.getString("filter", "");
            break;
        }
        bundle = Uri.withAppendedPath(android.provider.ContactsContract.Contacts.CONTENT_FILTER_URI, Uri.encode(bundle));
        return new CursorLoader(getActivity(), bundle, new String[] {
            "_id"
        }, null, null, null);
    }

    public void onGetFriendsTypeAheadComplete(String s, ArrayList arraylist)
    {
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (view.isActivated())
        {
            view.setActivated(false);
        } else
        if (l > 0L)
        {
            mListener.onClick(this, (ContactEntry)mContactEntryMap.get(Long.valueOf(l)));
            return;
        }
    }

    public void onLoadFinished(Loader loader, Cursor cursor)
    {
        int i = loader.getId();
        switch (i)
        {
        default:
            mActiveAdapter = mArrayAdapter;
            (new SortRecpientContactsTask(i)).execute(new Cursor[] {
                cursor
            });
            return;

        case 1: // '\001'
            break;
        }
        if (mFilterTask != null)
        {
            mFilterTask.cancel(true);
        }
        mActiveAdapter = mFilterAdapter;
        mFilterTask = (new SortRecpientContactsTask(i)).execute(new Cursor[] {
            cursor
        });
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (Cursor)obj);
    }

    public void onRecipientItemRemoved(VineRecipient vinerecipient)
    {
        if (mActiveAdapter != null)
        {
            ContactEntry contactentry = (ContactEntry)mContactEntryMap.get(Long.valueOf(vinerecipient.contactId));
            if (contactentry != null)
            {
                byte byte0 = 2;
                if ("email".equals(vinerecipient.key))
                {
                    byte0 = 1;
                }
                mActiveAdapter.onRecipientItemRemoved(contactentry, byte0, vinerecipient.value);
            }
        }
    }

    protected void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        super.onTextChanged(charsequence, i, j, k);
        charsequence = charsequence.toString();
        if (!TextUtils.isEmpty(charsequence))
        {
            mHandler.postDelayed(new FilterRunnable(charsequence), 150L);
            return;
        }
        if (mArrayAdapter != null)
        {
            mActiveAdapter = mArrayAdapter;
            mListView.setAdapter(mActiveAdapter);
            return;
        } else
        {
            getLoaderManager().restartLoader(0, null, this);
            return;
        }
    }



}
