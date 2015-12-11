// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.shell.widget;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class CompositeArrayAdapter extends BaseAdapter
{
    private final class Helper extends SectionManager
    {

        final CompositeArrayAdapter this$0;

        protected void onRequestMore(Section section, int i, int j)
        {
            _requestMoreListener.onRequestMore(CompositeArrayAdapter.this, section, i, j);
        }

        private Helper()
        {
            this$0 = CompositeArrayAdapter.this;
            super();
        }

    }

    public static interface OnRequestMoreListener
    {

        public abstract void onRequestMore(CompositeArrayAdapter compositearrayadapter, Section section, int i, int j);
    }

    public static final class Section
    {

        public final List list;
        public final String listName;
        public final int listType;
        public final int loadMoreOffset;
        public final int loadedItems;
        public final int maxItemsToShow;
        public final int pagesLoaded;
        public final int totalItems;

        public final boolean isFilled()
        {
            boolean flag1 = true;
            boolean flag;
            if (pagesLoaded == 0)
            {
                flag = false;
            } else
            {
                flag = flag1;
                if (loadMoreOffset >= 0)
                {
                    flag = flag1;
                    if (list.size() < maxItemsToShow)
                    {
                        flag = flag1;
                        if (size() < totalItems)
                        {
                            return false;
                        }
                    }
                }
            }
            return flag;
        }

        public final boolean showMore()
        {
            return totalItems > maxItemsToShow && size() >= maxItemsToShow;
        }

        public final int size()
        {
            int i;
            int j;
            if (list != null)
            {
                i = list.size();
            } else
            {
                i = 0;
            }
            j = i;
            if (i > maxItemsToShow)
            {
                j = maxItemsToShow;
            }
            return j;
        }

        public Section(int i, String s, List list1, int j, int k, int l, int i1, 
                int j1)
        {
            listType = i;
            listName = s;
            list = list1;
            totalItems = j;
            loadedItems = k;
            i = l;
            if (l < 0)
            {
                i = 0x7fffffff;
            }
            maxItemsToShow = i;
            pagesLoaded = i1;
            loadMoreOffset = j1;
        }
    }

    public static abstract class SectionManager
    {

        private int _count;
        private int _emptyResource;
        private int _headerResource;
        private int _indexOfItemToTriggerLoad;
        private int _indexOfListToLoadMore;
        private int _loadingResource;
        private int _moreResource;
        private List _sections;

        private void recalculate()
        {
            int i;
            int j;
            j = 0;
            i = 0;
            _indexOfListToLoadMore = 0;
            _indexOfItemToTriggerLoad = 0x7fffffff;
            if (_sections.isEmpty()) goto _L2; else goto _L1
_L1:
            int k;
            int l;
            l = _sections.size();
            k = 0;
_L10:
            j = i;
            if (k >= l) goto _L2; else goto _L3
_L3:
            Section section;
            int i1;
            section = (Section)_sections.get(k);
            i1 = section.size();
            if (i1 != 0) goto _L5; else goto _L4
_L4:
            j = i;
            if (_emptyResource == 0) goto _L7; else goto _L6
_L6:
            j = i;
            if (_headerResource == 0) goto _L7; else goto _L8
_L8:
            if (section.listName != null) goto _L5; else goto _L9
_L9:
            j = i;
_L7:
            k++;
            i = j;
              goto _L10
_L5:
label0:
            {
                j = i;
                if (section.listName != null)
                {
                    j = i;
                    if (_headerResource != 0)
                    {
                        j = i + 1;
                    }
                }
                if (i1 != 0 || section.pagesLoaded == 0)
                {
                    break label0;
                }
                j++;
            }
              goto _L7
            i = j + i1;
            if (section.isFilled())
            {
                break MISSING_BLOCK_LABEL_209;
            }
            _indexOfListToLoadMore = k;
            if (section.loadMoreOffset >= 0)
            {
                _indexOfItemToTriggerLoad = i - section.loadMoreOffset;
            }
            j = i;
            if (_loadingResource != 0)
            {
                j = i + 1;
            }
_L2:
            _count = j;
            return;
            j = i;
            if (_moreResource != 0)
            {
                j = i;
                if (section.showMore())
                {
                    j = i + 1;
                }
            }
              goto _L7
        }

        public final void add(Section section)
        {
            this;
            JVM INSTR monitorenter ;
            _sections.add(section);
            recalculate();
            this;
            JVM INSTR monitorexit ;
            return;
            section;
            throw section;
        }

        public final void addAll(Collection collection)
        {
            this;
            JVM INSTR monitorenter ;
            _sections.addAll(collection);
            recalculate();
            this;
            JVM INSTR monitorexit ;
            return;
            collection;
            throw collection;
        }

        public final void checkIfLoadIsNeeded(int i)
        {
            if (i >= _indexOfItemToTriggerLoad)
            {
                _indexOfItemToTriggerLoad = 0x7fffffff;
                Section section = (Section)_sections.get(_indexOfListToLoadMore);
                if (section.loadMoreOffset >= 0)
                {
                    onRequestMore(section, _indexOfListToLoadMore, section.pagesLoaded + 1);
                }
            }
        }

        public final void clear()
        {
            this;
            JVM INSTR monitorenter ;
            _sections.clear();
            recalculate();
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public final int getCount()
        {
            return _count;
        }

        public final int getEmptyViewResource()
        {
            return _emptyResource;
        }

        public final int getHeaderViewResource()
        {
            return _headerResource;
        }

        public final Object getItem(int i)
        {
            int j;
            int k;
            int l;
            l = _sections.size();
            k = 0;
            j = i;
_L9:
            if (k >= l) goto _L2; else goto _L1
_L1:
            Section section;
            int i1;
            section = (Section)_sections.get(k);
            i1 = section.size();
            if (i1 != 0) goto _L4; else goto _L3
_L3:
            i = j;
            if (_emptyResource == 0) goto _L6; else goto _L5
_L5:
            i = j;
            if (_headerResource == 0) goto _L6; else goto _L7
_L7:
            if (section.listName != null) goto _L4; else goto _L8
_L8:
            i = j;
_L6:
            k++;
            j = i;
              goto _L9
_L4:
label0:
            {
                i = j;
                if (section.listName != null)
                {
                    i = j;
                    if (_headerResource != 0)
                    {
                        if (j == 0)
                        {
                            return section.listName;
                        }
                        i = j - 1;
                    }
                }
                if (i1 != 0 || section.pagesLoaded == 0)
                {
                    break label0;
                }
                if (i == 0)
                {
                    return Integer.valueOf(k);
                }
                i--;
            }
              goto _L6
            if (i < i1)
            {
                return section.list.get(i);
            }
            j = i - i1;
            if (!section.isFilled() && _loadingResource != 0)
            {
                return Integer.valueOf(k);
            }
            i = j;
            if (!section.showMore()) goto _L6; else goto _L10
_L10:
            i = j;
            if (_moreResource == 0) goto _L6; else goto _L11
_L11:
            if (j == 0)
            {
                return Integer.valueOf(k);
            }
            break MISSING_BLOCK_LABEL_219;
_L2:
            return null;
            i = j - 1;
              goto _L6
        }

        public final int getItemViewType(int i)
        {
            Iterator iterator = _sections.iterator();
            do
            {
                Section section;
                int j;
label0:
                {
                    if (iterator.hasNext())
                    {
                        section = (Section)iterator.next();
                        int k = section.size();
                        if (k == 0 && (_emptyResource == 0 || _headerResource == 0 || section.listName == null))
                        {
                            continue;
                        }
                        j = i;
                        if (section.listName != null)
                        {
                            j = i;
                            if (_headerResource != 0)
                            {
                                if (i == 0)
                                {
                                    return 1;
                                }
                                j = i - 1;
                            }
                        }
                        if (k == 0 && section.pagesLoaded != 0)
                        {
                            if (j == 0)
                            {
                                return 2;
                            }
                            i = j - 1;
                            continue;
                        }
                        if (j < k)
                        {
                            return 0;
                        }
                        j -= k;
                        if (section.isFilled() || _loadingResource == 0)
                        {
                            break label0;
                        }
                    }
                    return 4;
                }
                i = j;
                if (section.showMore())
                {
                    i = j;
                    if (_moreResource != 0)
                    {
                        if (j == 0)
                        {
                            return 3;
                        }
                        i = j - 1;
                    }
                }
            } while (true);
        }

        public final Section getList(int i)
        {
            return (Section)_sections.get(i);
        }

        public final int getListCount()
        {
            return _sections.size();
        }

        public final int getListIndexFromItemPosition(int i)
        {
            int j;
            int k;
            int l;
            l = _sections.size();
            k = 0;
            j = i;
_L9:
            if (k >= l) goto _L2; else goto _L1
_L1:
            Section section;
            int i1;
            section = (Section)_sections.get(k);
            i1 = section.size();
            if (i1 != 0) goto _L4; else goto _L3
_L3:
            i = j;
            if (_emptyResource == 0) goto _L6; else goto _L5
_L5:
            i = j;
            if (_headerResource == 0) goto _L6; else goto _L7
_L7:
            if (section.listName != null) goto _L4; else goto _L8
_L8:
            i = j;
_L6:
            k++;
            j = i;
              goto _L9
_L4:
            i = j;
            if (section.listName == null) goto _L11; else goto _L10
_L10:
            i = j;
            if (_headerResource == 0) goto _L11; else goto _L12
_L12:
            if (j != 0) goto _L14; else goto _L13
_L13:
            return k;
_L14:
            i = j - 1;
_L11:
            if (i1 != 0 || section.pagesLoaded == 0)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (i == 0) goto _L13; else goto _L15
_L15:
            i--;
              goto _L6
            if (i < i1) goto _L13; else goto _L16
_L16:
            j = i - i1;
            if (!section.isFilled()) goto _L13; else goto _L17
_L17:
            i = j;
            if (!section.showMore()) goto _L6; else goto _L18
_L18:
            i = j;
            if (_moreResource == 0) goto _L6; else goto _L19
_L19:
            if (j == 0)
            {
                return k;
            }
            break MISSING_BLOCK_LABEL_184;
_L2:
            return 0;
            i = j - 1;
              goto _L6
        }

        public final int getLoadingViewResource()
        {
            return _loadingResource;
        }

        public final int getMoreViewResource()
        {
            return _moreResource;
        }

        public final Section getSectionByType(int i)
        {
            for (Iterator iterator = _sections.iterator(); iterator.hasNext();)
            {
                Section section = (Section)iterator.next();
                if (section.listType == i)
                {
                    return section;
                }
            }

            return null;
        }

        public final Section getSectionFromItemPosition(int i)
        {
            return getList(getListIndexFromItemPosition(i));
        }

        public final void init(List list)
        {
            this;
            JVM INSTR monitorenter ;
            _sections = list;
            recalculate();
            this;
            JVM INSTR monitorexit ;
            return;
            list;
            throw list;
        }

        public final void insert(Section section, int i)
        {
            this;
            JVM INSTR monitorenter ;
            _sections.add(i, section);
            recalculate();
            this;
            JVM INSTR monitorexit ;
            return;
            section;
            throw section;
        }

        public final boolean isEmpty()
        {
            for (Iterator iterator = _sections.iterator(); iterator.hasNext();)
            {
                if (((Section)iterator.next()).totalItems > 0)
                {
                    return false;
                }
            }

            return true;
        }

        protected abstract void onRequestMore(Section section, int i, int j);

        public final void remove(Section section)
        {
            this;
            JVM INSTR monitorenter ;
            _sections.remove(section);
            recalculate();
            this;
            JVM INSTR monitorexit ;
            return;
            section;
            throw section;
        }

        public final void setEmptyViewResource(int i)
        {
            _emptyResource = i;
        }

        public final void setHeaderViewResource(int i)
        {
            _headerResource = i;
        }

        public final void setList(int i, Section section)
        {
            this;
            JVM INSTR monitorenter ;
            _sections.set(i, section);
            recalculate();
            this;
            JVM INSTR monitorexit ;
            return;
            section;
            throw section;
        }

        public final void setLoadingViewResource(int i)
        {
            _loadingResource = i;
        }

        public final void setMoreViewResource(int i)
        {
            _moreResource = i;
        }

        public final void sort(Comparator comparator)
        {
            this;
            JVM INSTR monitorenter ;
            Collections.sort(_sections, comparator);
            recalculate();
            this;
            JVM INSTR monitorexit ;
            return;
            comparator;
            throw comparator;
        }

        public SectionManager()
        {
            _indexOfItemToTriggerLoad = 0x7fffffff;
        }
    }


    public static final int VIEW_TYPE_EMPTY = 2;
    public static final int VIEW_TYPE_HEADER = 1;
    public static final int VIEW_TYPE_ITEM = 0;
    public static final int VIEW_TYPE_LOADING = 4;
    public static final int VIEW_TYPE_MORE = 3;
    private final Context _context;
    private int _dropDownResource;
    private final int _fieldId;
    private final Helper _helper;
    private final LayoutInflater _inflater;
    private boolean _notifyOnChange;
    private OnRequestMoreListener _requestMoreListener;
    private int _resource;

    public CompositeArrayAdapter(Context context, int i)
    {
        this(context, i, 0, ((List) (new ArrayList())));
    }

    public CompositeArrayAdapter(Context context, int i, int j)
    {
        this(context, i, j, ((List) (new ArrayList())));
    }

    public CompositeArrayAdapter(Context context, int i, int j, List list)
    {
        _helper = new Helper();
        _notifyOnChange = true;
        _context = context;
        _inflater = (LayoutInflater)context.getSystemService("layout_inflater");
        _dropDownResource = i;
        _resource = i;
        _fieldId = j;
        _helper.init(list);
    }

    public CompositeArrayAdapter(Context context, int i, int j, Section asection[])
    {
        this(context, i, j, Arrays.asList(asection));
    }

    public CompositeArrayAdapter(Context context, int i, List list)
    {
        this(context, i, 0, list);
    }

    public CompositeArrayAdapter(Context context, int i, Section asection[])
    {
        this(context, i, 0, Arrays.asList(asection));
    }

    private View createViewFromResource(int i, View view, ViewGroup viewgroup, int j)
    {
        int k;
        if (_requestMoreListener != null)
        {
            _helper.checkIfLoadIsNeeded(i);
        }
        k = getItemViewType(i);
        if (view != null) goto _L2; else goto _L1
_L1:
        k;
        JVM INSTR tableswitch 0 4: default 64
    //                   0 66
    //                   1 131
    //                   2 151
    //                   3 171
    //                   4 191;
           goto _L3 _L4 _L5 _L6 _L7 _L8
_L8:
        break MISSING_BLOCK_LABEL_191;
_L3:
        return null;
_L4:
        view = _inflater.inflate(j, viewgroup, false);
_L2:
        viewgroup = ((ViewGroup) (getItem(i)));
        switch (k)
        {
        default:
            return view;

        case 0: // '\0'
            setupView(i, viewgroup, view);
            return view;

        case 1: // '\001'
            setupHeaderView(i, (CharSequence)viewgroup, view);
            return view;

        case 2: // '\002'
            setupEmptyView(i, ((Integer)viewgroup).intValue(), view);
            return view;

        case 3: // '\003'
            setupMoreView(i, ((Integer)viewgroup).intValue(), view);
            return view;

        case 4: // '\004'
            setupLoadingView(i, ((Integer)viewgroup).intValue(), view);
            break;
        }
        break MISSING_BLOCK_LABEL_274;
_L5:
        view = _inflater.inflate(_helper.getHeaderViewResource(), viewgroup, false);
          goto _L2
_L6:
        view = _inflater.inflate(_helper.getEmptyViewResource(), viewgroup, false);
          goto _L2
_L7:
        view = _inflater.inflate(_helper.getMoreViewResource(), viewgroup, false);
          goto _L2
        view = _inflater.inflate(_helper.getLoadingViewResource(), viewgroup, false);
        view.setVisibility(0);
          goto _L2
        return view;
    }

    public void add(Section section)
    {
        _helper.add(section);
        if (_notifyOnChange)
        {
            notifyDataSetChanged();
        }
    }

    public void addAll(Collection collection)
    {
        _helper.addAll(collection);
        if (_notifyOnChange)
        {
            notifyDataSetChanged();
        }
    }

    public boolean areAllItemsEnabled()
    {
        return false;
    }

    public void clear()
    {
        _helper.clear();
        if (_notifyOnChange)
        {
            notifyDataSetChanged();
        }
    }

    public Context getContext()
    {
        return _context;
    }

    public int getCount()
    {
        return _helper.getCount();
    }

    public View getDropDownView(int i, View view, ViewGroup viewgroup)
    {
        return createViewFromResource(i, view, viewgroup, _dropDownResource);
    }

    public Object getItem(int i)
    {
        return _helper.getItem(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public int getItemViewType(int i)
    {
        return _helper.getItemViewType(i);
    }

    public Section getList(int i)
    {
        return _helper.getList(i);
    }

    public int getListCount()
    {
        return _helper.getListCount();
    }

    public int getListIndexFromItemPosition(int i)
    {
        return _helper.getListIndexFromItemPosition(i);
    }

    public Section getSectionByType(int i)
    {
        return _helper.getSectionByType(i);
    }

    public Section getSectionFromItemPosition(int i)
    {
        return _helper.getSectionFromItemPosition(i);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        return createViewFromResource(i, view, viewgroup, _resource);
    }

    public int getViewTypeCount()
    {
        return 5;
    }

    public void insert(Section section, int i)
    {
        _helper.insert(section, i);
        if (_notifyOnChange)
        {
            notifyDataSetChanged();
        }
    }

    public boolean isEmpty()
    {
        return _helper.isEmpty();
    }

    public boolean isEnabled(int i)
    {
        switch (getItemViewType(i))
        {
        case 1: // '\001'
        case 2: // '\002'
        default:
            return false;

        case 0: // '\0'
        case 3: // '\003'
            return true;
        }
    }

    public final Section newSection(int i, String s, List list, int j, int k, int l, int i1)
    {
        int j1;
        if (list == null)
        {
            j1 = 0;
        } else
        {
            j1 = list.size();
        }
        return new Section(i, s, list, j, j1, k, l, i1);
    }

    public final Section newSection(int i, String s, List list, int j, int k, int l, int i1, 
            int j1)
    {
        return new Section(i, s, list, j, k, l, i1, j1);
    }

    public void notifyDataSetChanged()
    {
        super.notifyDataSetChanged();
        _notifyOnChange = true;
    }

    public void remove(Section section)
    {
        _helper.remove(section);
        if (_notifyOnChange)
        {
            notifyDataSetChanged();
        }
    }

    public void setDropDownViewResource(int i)
    {
        _dropDownResource = i;
    }

    public void setEmptyViewResource(int i)
    {
        _helper.setEmptyViewResource(i);
    }

    public void setHeaderViewResource(int i)
    {
        _helper.setHeaderViewResource(i);
    }

    public void setList(int i, Section section)
    {
        _helper.setList(i, section);
        if (_notifyOnChange)
        {
            notifyDataSetChanged();
        }
    }

    public void setLoadingViewResource(int i)
    {
        _helper.setLoadingViewResource(i);
    }

    public void setMoreViewResource(int i)
    {
        _helper.setMoreViewResource(i);
    }

    public void setNotifyOnChange(boolean flag)
    {
        _notifyOnChange = flag;
    }

    public void setOnRequestMoreListener(OnRequestMoreListener onrequestmorelistener)
    {
        _requestMoreListener = onrequestmorelistener;
    }

    protected void setupEmptyView(int i, int j, View view)
    {
    }

    protected void setupHeaderView(int i, CharSequence charsequence, View view)
    {
        if (!(view instanceof TextView))
        {
            break MISSING_BLOCK_LABEL_18;
        }
        view = (TextView)view;
_L1:
        view.setText(charsequence);
        return;
        try
        {
            view = (TextView)view.findViewById(0x1020014);
        }
        // Misplaced declaration of an exception variable
        catch (CharSequence charsequence)
        {
            Log.e("CompositeArrayAdapter", "You must supply a resource with ID android.R.id.text1 for a TextView");
            throw new IllegalStateException("CompositeArrayAdapter requires the resource ID android.R.id.text1 to be a TextView", charsequence);
        }
          goto _L1
    }

    protected void setupLoadingView(int i, int j, View view)
    {
    }

    protected void setupMoreView(int i, int j, View view)
    {
    }

    protected void setupView(int i, Object obj, View view)
    {
        if (_fieldId != 0)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        view = (TextView)view;
_L1:
        if (obj instanceof CharSequence)
        {
            view.setText((CharSequence)obj);
            return;
        } else
        {
            view.setText(obj.toString());
            return;
        }
        try
        {
            view = (TextView)view.findViewById(_fieldId);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.e("CompositeArrayAdapter", "You must supply a resource ID for a TextView");
            throw new IllegalStateException("CompositeArrayAdapter requires the resource ID to be a TextView", ((Throwable) (obj)));
        }
          goto _L1
    }

    public void sort(Comparator comparator)
    {
        _helper.sort(comparator);
        if (_notifyOnChange)
        {
            notifyDataSetChanged();
        }
    }

}
