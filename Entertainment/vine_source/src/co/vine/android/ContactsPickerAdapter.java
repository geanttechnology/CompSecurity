// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import co.vine.android.api.VineRecipient;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package co.vine.android:
//            ContactsRecipientPickerFragment, ContactEntry

public class ContactsPickerAdapter extends ArrayAdapter
{
    public static class ContactsPickerViewHolder
    {

        public long contactId;
        public View divider;
        public ImageView emailIndicator;
        public ImageView phoneIndicator;
        public int position;
        public TextView separator;
        public TextView username;

        public ContactsPickerViewHolder(View view)
        {
            emailIndicator = (ImageView)view.findViewById(0x7f0a0123);
            phoneIndicator = (ImageView)view.findViewById(0x7f0a0122);
            separator = (TextView)view.findViewById(0x7f0a01a8);
            username = (TextView)view.findViewById(0x7f0a0124);
            divider = view.findViewById(0x7f0a0060);
        }
    }


    private static final int STATE_REGULAR = 2;
    private static final int STATE_SECTIONED = 1;
    private static final int STATE_UNKNOWN = 0;
    private final ContactsRecipientPickerFragment mFragment;
    private int mRowHeaderStates[];
    private SparseArray mViewHolders;

    public ContactsPickerAdapter(ContactsRecipientPickerFragment contactsrecipientpickerfragment)
    {
        super(contactsrecipientpickerfragment.getActivity(), 0);
        mFragment = contactsrecipientpickerfragment;
        mViewHolders = new SparseArray();
    }

    private Integer getSelectionState(ContactEntry contactentry)
    {
        int i = 1;
        Object obj = contactentry.valueMimeMap.keySet();
        boolean flag1 = false;
        boolean flag = false;
        obj = ((Set) (obj)).iterator();
        boolean flag2;
        boolean flag3;
label0:
        do
        {
            do
            {
                flag2 = flag1;
                flag3 = flag;
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
                String s = (String)((Iterator) (obj)).next();
                int j = ((Integer)contactentry.valueMimeMap.get(s)).intValue();
                flag2 = flag1;
                if (!flag1)
                {
                    flag2 = flag1;
                    if (j == 1)
                    {
                        flag2 = mFragment.isRecipientSelected(VineRecipient.fromEmail(contactentry.displayName, -1L, s, 0L));
                    }
                }
                flag3 = flag;
                if (!flag)
                {
                    flag3 = flag;
                    if (j == 2)
                    {
                        flag3 = mFragment.isRecipientSelected(VineRecipient.fromPhone(contactentry.displayName, -1L, s, 0L));
                    }
                }
                flag1 = flag2;
                flag = flag3;
            } while (!flag2);
            flag1 = flag2;
            flag = flag3;
        } while (!flag3);
        int k;
        if (!flag2)
        {
            i = 0;
        }
        k = i;
        if (flag3)
        {
            k = i | 2;
        }
        return Integer.valueOf(k);
    }

    private void invalidateHolderSelectors(ContactEntry contactentry, ContactsPickerViewHolder contactspickerviewholder)
    {
        contactentry = getSelectionState(contactentry);
        int i;
        if (contactentry != null)
        {
            i = contactentry.intValue();
        } else
        {
            i = 0;
        }
        if ((i & 1) != 0)
        {
            contactspickerviewholder.emailIndicator.setSelected(true);
        } else
        {
            contactspickerviewholder.emailIndicator.setSelected(false);
        }
        if ((i & 2) != 0)
        {
            contactspickerviewholder.phoneIndicator.setSelected(true);
            return;
        } else
        {
            contactspickerviewholder.phoneIndicator.setSelected(false);
            return;
        }
    }

    public void addAll(Collection collection)
    {
        super.addAll(collection);
        mRowHeaderStates = new int[collection.size()];
    }

    public long getItemId(int i)
    {
        ContactEntry contactentry = (ContactEntry)getItem(i);
        if (contactentry != null)
        {
            return contactentry.contactId;
        } else
        {
            return 0L;
        }
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        byte byte0 = 8;
        ContactEntry contactentry;
        ImageView imageview;
        int j;
        int k;
        boolean flag;
        if (view == null)
        {
            view = LayoutInflater.from(getContext()).inflate(0x7f03007e, viewgroup, false);
            viewgroup = new ContactsPickerViewHolder(view);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ContactsPickerViewHolder)view.getTag();
        }
        mViewHolders.put(i, new WeakReference(viewgroup));
        contactentry = (ContactEntry)getItem(i);
        flag = showSeparator(i, contactentry);
        if ((contactentry.typeFlag & 1) != 0)
        {
            k = 1;
        } else
        {
            k = 0;
        }
        if ((contactentry.typeFlag & 2) != 0)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        ((ContactsPickerViewHolder) (viewgroup)).username.setText(contactentry.displayName);
        imageview = ((ContactsPickerViewHolder) (viewgroup)).emailIndicator;
        if (k != 0)
        {
            k = 0;
        } else
        {
            k = 8;
        }
        imageview.setVisibility(k);
        imageview = ((ContactsPickerViewHolder) (viewgroup)).phoneIndicator;
        if (j != 0)
        {
            j = 0;
        } else
        {
            j = 8;
        }
        imageview.setVisibility(j);
        viewgroup.contactId = contactentry.contactId;
        invalidateHolderSelectors(contactentry, viewgroup);
        if (flag)
        {
            ((ContactsPickerViewHolder) (viewgroup)).separator.setVisibility(0);
            if (contactentry.alternateName != null)
            {
                ((ContactsPickerViewHolder) (viewgroup)).separator.setText(new char[] {
                    contactentry.alternateName.toUpperCase().charAt(0)
                }, 0, 1);
            } else
            {
                ((ContactsPickerViewHolder) (viewgroup)).separator.setText(new char[] {
                    contactentry.displayName.toUpperCase().charAt(0)
                }, 0, 1);
            }
        } else
        {
            ((ContactsPickerViewHolder) (viewgroup)).separator.setVisibility(8);
        }
        if (i + 1 < getCount())
        {
            viewgroup = ((ContactsPickerViewHolder) (viewgroup)).divider;
            if (showSeparator(i + 1, (ContactEntry)getItem(i + 1)))
            {
                i = byte0;
            } else
            {
                i = 0;
            }
            viewgroup.setVisibility(i);
        }
        return view;
    }

    public void onRecipientItemAdded(ContactEntry contactentry, int i, String s)
    {
        s = new ArrayList();
        int k = mViewHolders.size();
        int j = 0;
        while (j < k) 
        {
            ContactsPickerViewHolder contactspickerviewholder = (ContactsPickerViewHolder)((WeakReference)mViewHolders.valueAt(j)).get();
            if (contactspickerviewholder == null)
            {
                s.add(Integer.valueOf(mViewHolders.keyAt(j)));
            } else
            if (contactspickerviewholder.contactId == contactentry.contactId)
            {
                if ((i & 1) != 0)
                {
                    contactspickerviewholder.emailIndicator.setSelected(true);
                } else
                if ((i & 2) != 0)
                {
                    contactspickerviewholder.phoneIndicator.setSelected(true);
                }
            }
            j++;
        }
        j = s.size();
        for (i = 0; i < j; i++)
        {
            mViewHolders.remove(((Integer)s.get(i)).intValue());
        }

    }

    public void onRecipientItemRemoved(ContactEntry contactentry, int i, String s)
    {
        s = new ArrayList();
        int j = mViewHolders.size();
        i = 0;
        while (i < j) 
        {
            ContactsPickerViewHolder contactspickerviewholder = (ContactsPickerViewHolder)((WeakReference)mViewHolders.valueAt(i)).get();
            if (contactspickerviewholder == null)
            {
                s.add(Integer.valueOf(mViewHolders.keyAt(i)));
            } else
            if (contactspickerviewholder.contactId == contactentry.contactId)
            {
                invalidateHolderSelectors(contactentry, contactspickerviewholder);
            }
            i++;
        }
        j = s.size();
        for (i = 0; i < j; i++)
        {
            mViewHolders.remove(((Integer)s.get(i)).intValue());
        }

    }

    public boolean showSeparator(int i, ContactEntry contactentry)
    {
        boolean flag = false;
        switch (mRowHeaderStates[i])
        {
        default:
            int j;
            if (i == 0)
            {
                flag = true;
            } else
            {
                ContactEntry contactentry1 = (ContactEntry)getItem(i - 1);
                if (contactentry1.alternateName != null && contactentry.alternateName != null)
                {
                    if (contactentry1.alternateName.toLowerCase().charAt(0) != contactentry.alternateName.toLowerCase().charAt(0))
                    {
                        flag = true;
                    }
                } else
                if (contactentry1.displayName.toLowerCase().charAt(0) != contactentry.displayName.toLowerCase().charAt(0))
                {
                    flag = true;
                }
            }
            contactentry = mRowHeaderStates;
            if (flag)
            {
                j = 1;
            } else
            {
                j = 2;
            }
            contactentry[i] = j;
            return flag;

        case 1: // '\001'
            return true;

        case 2: // '\002'
            return false;
        }
    }
}
