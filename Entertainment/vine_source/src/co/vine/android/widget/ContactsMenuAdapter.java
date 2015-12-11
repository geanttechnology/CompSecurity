// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import co.vine.android.ContactEntry;
import co.vine.android.util.Util;
import java.lang.ref.WeakReference;
import java.util.Collection;

public class ContactsMenuAdapter extends ArrayAdapter
{
    public static class ContactsPickerViewHolder
    {

        public long contactId;
        public View divider;
        public ImageView emailIndicator;
        public ImageView phoneIndicator;
        public int position;
        public View sectionIndicator;
        public TextView sectionSort;
        public TextView sectionTitle;
        public TextView username;

        public ContactsPickerViewHolder(Context context, View view)
        {
            emailIndicator = (ImageView)view.findViewById(0x7f0a0123);
            phoneIndicator = (ImageView)view.findViewById(0x7f0a0122);
            sectionIndicator = view.findViewById(0x7f0a0120);
            sectionTitle = (TextView)view.findViewById(0x7f0a01ab);
            sectionSort = (TextView)view.findViewById(0x7f0a01aa);
            username = (TextView)view.findViewById(0x7f0a0124);
            divider = view.findViewById(0x7f0a0060);
            Util.styleSectionHeader(context, sectionTitle, sectionSort);
        }
    }


    private static final int STATE_REGULAR = 2;
    private static final int STATE_SECTIONED = 1;
    private static final int STATE_UNKNOWN = 0;
    private int mRowHeaderStates[];
    private final SparseArray mViewHolders = new SparseArray();

    public ContactsMenuAdapter(Context context)
    {
        super(context, 0);
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
label0:
        {
            ContactEntry contactentry;
label1:
            {
label2:
                {
label3:
                    {
                        int j;
                        int k;
                        boolean flag1;
                        {
                            if (view == null || !(view.getTag() instanceof ContactsPickerViewHolder))
                            {
                                view = LayoutInflater.from(getContext()).inflate(0x7f030055, viewgroup, false);
                                viewgroup = new ContactsPickerViewHolder(getContext(), view);
                                view.setTag(viewgroup);
                            } else
                            {
                                viewgroup = (ContactsPickerViewHolder)view.getTag();
                            }
                            mViewHolders.put(i, new WeakReference(viewgroup));
                            contactentry = (ContactEntry)getItem(i);
                            switch (mRowHeaderStates[i])
                            {
                            default:
                                int ai[];
                                Object obj;
                                boolean flag;
                                if (i == 0)
                                {
                                    flag = true;
                                } else
                                if (!contactentry.isSameSection((ContactEntry)getItem(i - 1)))
                                {
                                    flag = true;
                                } else
                                {
                                    flag = false;
                                }
                                ai = mRowHeaderStates;
                                if (flag)
                                {
                                    j = 1;
                                } else
                                {
                                    j = 2;
                                }
                                ai[i] = j;
                                break;

                            case 1: // '\001'
                                break label3;

                            case 2: // '\002'
                                break label2;
                            }
                        }
                        if (i < getCount() - 1)
                        {
                            flag1 = contactentry.isSameSection((ContactEntry)getItem(i + 1));
                        } else
                        {
                            flag1 = true;
                        }
                        obj = ((ContactsPickerViewHolder) (viewgroup)).divider;
                        if (flag1)
                        {
                            j = 0;
                        } else
                        {
                            j = 8;
                        }
                        ((View) (obj)).setVisibility(j);
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
                        obj = ((ContactsPickerViewHolder) (viewgroup)).emailIndicator;
                        if (k != 0)
                        {
                            k = 0;
                        } else
                        {
                            k = 8;
                        }
                        ((ImageView) (obj)).setVisibility(k);
                        obj = ((ContactsPickerViewHolder) (viewgroup)).phoneIndicator;
                        if (j != 0)
                        {
                            j = 0;
                        } else
                        {
                            j = 8;
                        }
                        ((ImageView) (obj)).setVisibility(j);
                        viewgroup.contactId = contactentry.contactId;
                        if (i == 0)
                        {
                            ((ContactsPickerViewHolder) (viewgroup)).sectionTitle.setText(getContext().getString(0x7f0e008f));
                            ((ContactsPickerViewHolder) (viewgroup)).sectionTitle.setVisibility(0);
                        } else
                        {
                            ((ContactsPickerViewHolder) (viewgroup)).sectionTitle.setVisibility(8);
                        }
                        if (!flag)
                        {
                            break label0;
                        }
                        ((ContactsPickerViewHolder) (viewgroup)).sectionIndicator.setVisibility(0);
                        if (contactentry.alternateName != null)
                        {
                            ((ContactsPickerViewHolder) (viewgroup)).sectionSort.setText(new char[] {
                                contactentry.alternateName.toUpperCase().charAt(0)
                            }, 0, 1);
                            return view;
                        }
                        break label1;
                    }
                    flag = true;
                    break MISSING_BLOCK_LABEL_127;
                }
                flag = false;
                break MISSING_BLOCK_LABEL_127;
            }
            if (contactentry.displayName != null)
            {
                ((ContactsPickerViewHolder) (viewgroup)).sectionSort.setText(new char[] {
                    contactentry.displayName.toUpperCase().charAt(0)
                }, 0, 1);
                return view;
            } else
            {
                ((ContactsPickerViewHolder) (viewgroup)).sectionSort.setText(new char[] {
                    ' '
                }, 0, 1);
                return view;
            }
        }
        ((ContactsPickerViewHolder) (viewgroup)).sectionIndicator.setVisibility(8);
        return view;
    }
}
