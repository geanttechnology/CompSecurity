// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.shell.widget;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.shell.widget:
//            CompositeArrayAdapter

public static abstract class _indexOfItemToTriggerLoad
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
        _indexOfItemToTriggerLoad _lindexofitemtotriggerload;
        int i1;
        _lindexofitemtotriggerload = (_sections)_sections.get(k);
        i1 = _lindexofitemtotriggerload._sections();
        if (i1 != 0) goto _L5; else goto _L4
_L4:
        j = i;
        if (_emptyResource == 0) goto _L7; else goto _L6
_L6:
        j = i;
        if (_headerResource == 0) goto _L7; else goto _L8
_L8:
        if (_lindexofitemtotriggerload.e != null) goto _L5; else goto _L9
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
            if (_lindexofitemtotriggerload.e != null)
            {
                j = i;
                if (_headerResource != 0)
                {
                    j = i + 1;
                }
            }
            if (i1 != 0 || _lindexofitemtotriggerload.aded == 0)
            {
                break label0;
            }
            j++;
        }
          goto _L7
        i = j + i1;
        if (_lindexofitemtotriggerload.d())
        {
            break MISSING_BLOCK_LABEL_209;
        }
        _indexOfListToLoadMore = k;
        if (_lindexofitemtotriggerload.eOffset >= 0)
        {
            _indexOfItemToTriggerLoad = i - _lindexofitemtotriggerload.eOffset;
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
            if (_lindexofitemtotriggerload.e())
            {
                j = i + 1;
            }
        }
          goto _L7
    }

    public final void add(e e)
    {
        this;
        JVM INSTR monitorenter ;
        _sections.add(e);
        recalculate();
        this;
        JVM INSTR monitorexit ;
        return;
        e;
        throw e;
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
            recalculate recalculate1 = (_indexOfItemToTriggerLoad)_sections.get(_indexOfListToLoadMore);
            if (recalculate1.eOffset >= 0)
            {
                onRequestMore(recalculate1, _indexOfListToLoadMore, recalculate1.aded + 1);
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
        _headerResource _lheaderresource;
        int i1;
        _lheaderresource = (_sections)_sections.get(k);
        i1 = _lheaderresource._sections();
        if (i1 != 0) goto _L4; else goto _L3
_L3:
        i = j;
        if (_emptyResource == 0) goto _L6; else goto _L5
_L5:
        i = j;
        if (_headerResource == 0) goto _L6; else goto _L7
_L7:
        if (_lheaderresource.e != null) goto _L4; else goto _L8
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
            if (_lheaderresource.e != null)
            {
                i = j;
                if (_headerResource != 0)
                {
                    if (j == 0)
                    {
                        return _lheaderresource.e;
                    }
                    i = j - 1;
                }
            }
            if (i1 != 0 || _lheaderresource.aded == 0)
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
            return _lheaderresource.aded.get(i);
        }
        j = i - i1;
        if (!_lheaderresource.d() && _loadingResource != 0)
        {
            return Integer.valueOf(k);
        }
        i = j;
        if (!_lheaderresource.e()) goto _L6; else goto _L10
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
            _moreResource _lmoreresource;
            int j;
label0:
            {
                if (iterator.hasNext())
                {
                    _lmoreresource = (_sections)iterator.next();
                    int k = _lmoreresource._sections();
                    if (k == 0 && (_emptyResource == 0 || _headerResource == 0 || _lmoreresource.e == null))
                    {
                        continue;
                    }
                    j = i;
                    if (_lmoreresource.e != null)
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
                    if (k == 0 && _lmoreresource.aded != 0)
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
                    if (_lmoreresource.d() || _loadingResource == 0)
                    {
                        break label0;
                    }
                }
                return 4;
            }
            i = j;
            if (_lmoreresource.e())
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

    public final _moreResource getList(int i)
    {
        return (_moreResource)_sections.get(i);
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
        _sections _lsections;
        int i1;
        _lsections = (_sections)_sections.get(k);
        i1 = _lsections._sections();
        if (i1 != 0) goto _L4; else goto _L3
_L3:
        i = j;
        if (_emptyResource == 0) goto _L6; else goto _L5
_L5:
        i = j;
        if (_headerResource == 0) goto _L6; else goto _L7
_L7:
        if (_lsections.e != null) goto _L4; else goto _L8
_L8:
        i = j;
_L6:
        k++;
        j = i;
          goto _L9
_L4:
        i = j;
        if (_lsections.e == null) goto _L11; else goto _L10
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
        if (i1 != 0 || _lsections.aded == 0)
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
        if (!_lsections.d()) goto _L13; else goto _L17
_L17:
        i = j;
        if (!_lsections.e()) goto _L6; else goto _L18
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

    public final _moreResource getSectionByType(int i)
    {
        for (Iterator iterator = _sections.iterator(); iterator.hasNext();)
        {
            _moreResource _lmoreresource = (_sections)iterator.next();
            if (_lmoreresource.e == i)
            {
                return _lmoreresource;
            }
        }

        return null;
    }

    public final e getSectionFromItemPosition(int i)
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

    public final void insert(recalculate recalculate1, int i)
    {
        this;
        JVM INSTR monitorenter ;
        _sections.add(i, recalculate1);
        recalculate();
        this;
        JVM INSTR monitorexit ;
        return;
        recalculate1;
        throw recalculate1;
    }

    public final boolean isEmpty()
    {
        for (Iterator iterator = _sections.iterator(); iterator.hasNext();)
        {
            if (((_sections)iterator.next()).ems > 0)
            {
                return false;
            }
        }

        return true;
    }

    protected abstract void onRequestMore(ems ems, int i, int j);

    public final void remove(ems ems)
    {
        this;
        JVM INSTR monitorenter ;
        _sections.remove(ems);
        recalculate();
        this;
        JVM INSTR monitorexit ;
        return;
        ems;
        throw ems;
    }

    public final void setEmptyViewResource(int i)
    {
        _emptyResource = i;
    }

    public final void setHeaderViewResource(int i)
    {
        _headerResource = i;
    }

    public final void setList(int i, _headerResource _pheaderresource)
    {
        this;
        JVM INSTR monitorenter ;
        _sections.set(i, _pheaderresource);
        recalculate();
        this;
        JVM INSTR monitorexit ;
        return;
        _pheaderresource;
        throw _pheaderresource;
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

    public I()
    {
        _indexOfItemToTriggerLoad = 0x7fffffff;
    }
}
