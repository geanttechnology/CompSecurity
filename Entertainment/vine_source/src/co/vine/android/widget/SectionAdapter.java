// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import co.vine.android.util.CrashUtil;

// Referenced classes of package co.vine.android.widget:
//            PinnedHeaderAdapter

public class SectionAdapter extends BaseAdapter
    implements PinnedHeaderAdapter
{
    class AdapterDataSetObserver extends DataSetObserver
    {

        final SectionAdapter this$0;

        public void onChanged()
        {
            if (mNotifyOnChange)
            {
                notifyDataSetChanged();
            }
        }

        public void onInvalidated()
        {
            notifyDataSetInvalidated();
        }

        AdapterDataSetObserver()
        {
            this$0 = SectionAdapter.this;
            super();
        }
    }


    public static final int TYPE_CARDROW = 0;
    public static final int TYPE_NORMAL = 1;
    private static final int VIEW_TYPE_SECTION = 0;
    private final BaseAdapter mAdapters[];
    private final boolean mCardHeaders[];
    private final AdapterDataSetObserver mDataSetObserver;
    private final int mDefaultType;
    boolean mNotifyOnChange;
    private PinnedHeaderAdapter mPinnedHeaderAdapter;
    private final int mSectionLayout;
    private final int mStringResIds[];
    private final int mTypes[];

    public SectionAdapter(int ai[], int ai1[], BaseAdapter abaseadapter[])
    {
        this(null, ai, ai1, abaseadapter, 0x7f03008e, 0);
    }

    public SectionAdapter(BaseAdapter abaseadapter[])
    {
        this(null, null, null, abaseadapter, 0x7f03008e, 0);
    }

    public SectionAdapter(BaseAdapter abaseadapter[], int i)
    {
        this(null, null, null, abaseadapter, 0x7f03008e, i);
    }

    public SectionAdapter(boolean aflag[], int ai[], int ai1[], BaseAdapter abaseadapter[], int i, int j)
    {
        mNotifyOnChange = true;
        mCardHeaders = aflag;
        mStringResIds = ai1;
        mAdapters = abaseadapter;
        mSectionLayout = i;
        mTypes = ai;
        mDefaultType = j;
        mDataSetObserver = new AdapterDataSetObserver();
        j = abaseadapter.length;
        for (i = 0; i < j; i++)
        {
            aflag = abaseadapter[i];
            aflag.registerDataSetObserver(mDataSetObserver);
            if (aflag instanceof PinnedHeaderAdapter)
            {
                mPinnedHeaderAdapter = (PinnedHeaderAdapter)aflag;
            }
        }

    }

    private int getAdapterCount(BaseAdapter baseadapter)
    {
        int i;
        try
        {
            i = baseadapter.getCount();
        }
        // Misplaced declaration of an exception variable
        catch (BaseAdapter baseadapter)
        {
            CrashUtil.logException(baseadapter);
            return 0;
        }
        return i;
    }

    private boolean hasDivider(int i)
    {
        return mStringResIds != null && mStringResIds[i] > 0;
    }

    public boolean areAllItemsEnabled()
    {
        boolean flag1 = false;
        int j = mAdapters.length;
        int i = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i < j)
                {
                    if (!hasDivider(i))
                    {
                        break label0;
                    }
                    flag = true;
                }
                return !flag && super.areAllItemsEnabled();
            }
            i++;
        } while (true);
    }

    public int getAdapterIndex(int i)
    {
        int k = 0;
        BaseAdapter abaseadapter[] = mAdapters;
        int j1 = abaseadapter.length;
        int j = 0;
        do
        {
label0:
            {
                if (j < j1)
                {
                    int i1 = getAdapterCount(abaseadapter[j]);
                    int l = i1;
                    if (hasDivider(k))
                    {
                        l = i1 + 1;
                    }
                    if (i >= l)
                    {
                        break label0;
                    }
                }
                return k;
            }
            k++;
            j++;
        } while (true);
    }

    protected View getAdapterView(BaseAdapter baseadapter, int i, int j, int k, View view, ViewGroup viewgroup)
    {
        if (mTypes != null)
        {
            i = mTypes[j];
        } else
        {
            i = mDefaultType;
        }
        return baseadapter.getView(k, view, viewgroup);
    }

    public int getCount()
    {
        int l = 0;
        int k = 0;
        BaseAdapter abaseadapter[] = mAdapters;
        int i1 = abaseadapter.length;
        for (int j = 0; j < i1;)
        {
            int j1 = getAdapterCount(abaseadapter[j]);
            int i = l;
            if (j1 > 0)
            {
                l += j1;
                i = l;
                if (hasDivider(k))
                {
                    i = l + 1;
                }
            }
            k++;
            j++;
            l = i;
        }

        return l;
    }

    public AdapterDataSetObserver getDataSetObserver()
    {
        return mDataSetObserver;
    }

    public Object getItem(int i)
    {
        int j = 0;
        BaseAdapter abaseadapter[] = mAdapters;
        int j1 = abaseadapter.length;
        boolean flag = false;
        int k = i;
        i = ((flag) ? 1 : 0);
        do
        {
            int l;
label0:
            {
label1:
                {
                    BaseAdapter baseadapter;
                    int i1;
label2:
                    {
label3:
                        {
                            if (i < j1)
                            {
                                baseadapter = abaseadapter[i];
                                i1 = getAdapterCount(baseadapter);
                                l = k;
                                if (i1 <= 0)
                                {
                                    break label0;
                                }
                                if (!hasDivider(j))
                                {
                                    break label2;
                                }
                                i1++;
                                if (k != 0)
                                {
                                    break label3;
                                }
                            }
                            return null;
                        }
                        l = i1;
                        if (k < i1)
                        {
                            return baseadapter.getItem(k - 1);
                        }
                        break label1;
                    }
                    l = i1;
                    if (k < i1)
                    {
                        return baseadapter.getItem(k);
                    }
                }
                l = k - l;
            }
            j++;
            i++;
            k = l;
        } while (true);
    }

    public long getItemId(int i)
    {
        int j = 0;
        BaseAdapter abaseadapter[] = mAdapters;
        int j1 = abaseadapter.length;
        boolean flag = false;
        int k = i;
        i = ((flag) ? 1 : 0);
        do
        {
            int l;
label0:
            {
label1:
                {
                    BaseAdapter baseadapter;
                    int i1;
label2:
                    {
label3:
                        {
                            if (i < j1)
                            {
                                baseadapter = abaseadapter[i];
                                i1 = getAdapterCount(baseadapter);
                                l = k;
                                if (i1 <= 0)
                                {
                                    break label0;
                                }
                                if (!hasDivider(j))
                                {
                                    break label2;
                                }
                                i1++;
                                if (k != 0)
                                {
                                    break label3;
                                }
                            }
                            return 0L;
                        }
                        l = i1;
                        if (k < i1)
                        {
                            return baseadapter.getItemId(k - 1);
                        }
                        break label1;
                    }
                    l = i1;
                    if (k < i1)
                    {
                        return baseadapter.getItemId(k);
                    }
                }
                l = k - l;
            }
            j++;
            i++;
            k = l;
        } while (true);
    }

    public int getItemViewType(int i)
    {
        int k = 1;
        int j = 0;
        BaseAdapter abaseadapter[] = mAdapters;
        int k1 = abaseadapter.length;
        boolean flag = false;
        int l = i;
        for (i = ((flag) ? 1 : 0); i < k1;)
        {
            BaseAdapter baseadapter = abaseadapter[i];
            int j1 = getAdapterCount(baseadapter);
            int i1 = l;
            if (j1 > 0)
            {
                if (hasDivider(j))
                {
                    j1++;
                    if (l == 0)
                    {
                        return 0;
                    }
                    i1 = j1;
                    if (l < j1)
                    {
                        return baseadapter.getItemViewType(l - 1) + k;
                    }
                } else
                {
                    i1 = j1;
                    if (l < j1)
                    {
                        return baseadapter.getItemViewType(l) + k;
                    }
                }
                i1 = l - i1;
            }
            k += baseadapter.getViewTypeCount();
            j++;
            i++;
            l = i1;
        }

        return super.getItemViewType(l);
    }

    public int getMyAdapterIndex(BaseAdapter baseadapter)
    {
        int j = 0;
        BaseAdapter abaseadapter[] = mAdapters;
        int k = abaseadapter.length;
        int i = 0;
        do
        {
            if (i >= k || abaseadapter[i] == baseadapter)
            {
                return j;
            }
            j++;
            i++;
        } while (true);
    }

    public int getNumberOfAdapters()
    {
        if (mAdapters != null)
        {
            return mAdapters.length;
        } else
        {
            return 0;
        }
    }

    public int getPinnedHeaderHeight()
    {
        if (mPinnedHeaderAdapter != null)
        {
            return mPinnedHeaderAdapter.getPinnedHeaderHeight();
        } else
        {
            return 0;
        }
    }

    public PinnedHeaderAdapter.PinnedHeaderStatus getPinnedHeaderStatus(int i)
    {
        if (mPinnedHeaderAdapter != null)
        {
            return mPinnedHeaderAdapter.getPinnedHeaderStatus(i);
        } else
        {
            return null;
        }
    }

    public View getPinnedHeaderView(View view)
    {
        if (mPinnedHeaderAdapter != null)
        {
            return mPinnedHeaderAdapter.getPinnedHeaderView(view);
        } else
        {
            return null;
        }
    }

    public int getPositionOffset(int i)
    {
        int k = 0;
        for (int j = 0; j < i; j++)
        {
            k += mAdapters[j].getCount();
        }

        return k;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        LayoutInflater layoutinflater = LayoutInflater.from(viewgroup.getContext());
        int j = 0;
        int k = 0;
        BaseAdapter abaseadapter[] = mAdapters;
        int l1 = abaseadapter.length;
        boolean flag = false;
        int l = i;
        for (i = ((flag) ? 1 : 0); i < l1;)
        {
            BaseAdapter baseadapter = abaseadapter[i];
            int k1 = getAdapterCount(baseadapter);
            int j1 = k;
            int i1 = l;
            if (k1 > 0)
            {
                if (hasDivider(j))
                {
                    j1 = k1 + 1;
                    if (l == 0)
                    {
                        View view1 = view;
                        if (view == null)
                        {
                            view1 = layoutinflater.inflate(mSectionLayout, viewgroup, false);
                            view1.setTag(view1.findViewById(0x7f0a0128));
                        }
                        view = mStringResIds;
                        i = view[j % view.length];
                        if (i == 0)
                        {
                            ((TextView)view1.getTag()).setText(null);
                        } else
                        {
                            ((TextView)view1.getTag()).setText(i);
                        }
                        return view1;
                    }
                    i1 = j1;
                    if (l < j1)
                    {
                        return getAdapterView(baseadapter, k, j, l - 1, view, viewgroup);
                    }
                } else
                {
                    i1 = k1;
                    if (l < k1)
                    {
                        return getAdapterView(baseadapter, k, j, l, view, viewgroup);
                    }
                }
                i1 = l - i1;
                j1 = k + 1;
            }
            j++;
            i++;
            k = j1;
            l = i1;
        }

        return view;
    }

    public int getViewTypeCount()
    {
        int j = 0;
        BaseAdapter abaseadapter[] = mAdapters;
        int k = abaseadapter.length;
        for (int i = 0; i < k; i++)
        {
            j += abaseadapter[i].getViewTypeCount();
        }

        return j + 1;
    }

    public boolean isEnabled(int i)
    {
        int j = 0;
        BaseAdapter abaseadapter[] = mAdapters;
        int j1 = abaseadapter.length;
        boolean flag = false;
        int k = i;
        for (i = ((flag) ? 1 : 0); i < j1;)
        {
            BaseAdapter baseadapter = abaseadapter[i];
            int i1 = getAdapterCount(baseadapter);
            int l = k;
            if (i1 > 0)
            {
                if (hasDivider(j))
                {
                    i1++;
                    if (k == 0)
                    {
                        return false;
                    }
                    l = i1;
                    if (k < i1)
                    {
                        return baseadapter.isEnabled(k - 1);
                    }
                } else
                {
                    l = i1;
                    if (k < i1)
                    {
                        return baseadapter.isEnabled(k);
                    }
                }
                l = k - l;
            }
            j++;
            i++;
            k = l;
        }

        return super.isEnabled(k);
    }

    public void layoutPinnedHeader(View view, int i, int j, int k, int l)
    {
        mPinnedHeaderAdapter.layoutPinnedHeader(view, i, j, k, l);
    }

    public void notifyDataSetChanged()
    {
        super.notifyDataSetChanged();
        mNotifyOnChange = true;
    }

    public void release()
    {
        BaseAdapter abaseadapter[] = mAdapters;
        int j = abaseadapter.length;
        for (int i = 0; i < j; i++)
        {
            abaseadapter[i].unregisterDataSetObserver(mDataSetObserver);
        }

    }
}
