// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.ChangeList;
import com.amazon.gallery.framework.data.dao.SortClause;
import com.amazon.gallery.framework.data.dao.SortOrder;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.data.dao.tag.TagTagTypeObserver;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagProperty;
import com.amazon.gallery.framework.model.tags.TagType;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget:
//            ViewFactory

public class TagListAdapter extends BaseAdapter
{
    public static final class SortType extends Enum
    {

        private static final SortType $VALUES[];
        public static final SortType DATE_ASC;
        public static final SortType DATE_DESC;
        public static final SortType NAME_ASC;
        public static final SortType NAME_DESC;
        private final SortOrder sortOrder;

        public static SortType valueOf(String s)
        {
            return (SortType)Enum.valueOf(com/amazon/gallery/framework/gallery/widget/TagListAdapter$SortType, s);
        }

        public static SortType[] values()
        {
            return (SortType[])$VALUES.clone();
        }

        public SortOrder getSortOrder()
        {
            return sortOrder;
        }

        static 
        {
            NAME_ASC = new SortType("NAME_ASC", 0, new SortOrder("label", com.amazon.gallery.framework.data.dao.SortOrder.Order.NOCASE_ASC));
            NAME_DESC = new SortType("NAME_DESC", 1, new SortOrder("label", com.amazon.gallery.framework.data.dao.SortOrder.Order.NOCASE_DESC));
            DATE_ASC = new SortType("DATE_ASC", 2, new SortOrder(new SortClause[] {
                new SortClause("has_sort_date", com.amazon.gallery.framework.data.dao.SortOrder.Order.DESC), new SortClause("sort_date", com.amazon.gallery.framework.data.dao.SortOrder.Order.ASC), new SortClause("date_created", com.amazon.gallery.framework.data.dao.SortOrder.Order.ASC)
            }));
            DATE_DESC = new SortType("DATE_DESC", 3, new SortOrder(new SortClause[] {
                new SortClause("has_sort_date", com.amazon.gallery.framework.data.dao.SortOrder.Order.DESC), new SortClause("sort_date", com.amazon.gallery.framework.data.dao.SortOrder.Order.DESC), new SortClause("date_created", com.amazon.gallery.framework.data.dao.SortOrder.Order.DESC)
            }));
            $VALUES = (new SortType[] {
                NAME_ASC, NAME_DESC, DATE_ASC, DATE_DESC
            });
        }

        private SortType(String s, int i, SortOrder sortorder)
        {
            super(s, i);
            sortOrder = sortorder;
        }
    }


    private static final String TAG = com/amazon/gallery/framework/gallery/widget/TagListAdapter.getName();
    private final Handler handler = new Handler();
    private volatile TagProperty lastTagProperty;
    private final TagTagTypeObserver observer = new TagTagTypeObserver() {

        final TagListAdapter this$0;

        public void onTagsChanged(TagType tagtype, ChangeList changelist)
        {
            boolean flag1 = false;
            tagtype = changelist.getAllChangeLists().iterator();
            boolean flag;
            do
            {
                flag = flag1;
                if (!tagtype.hasNext())
                {
                    break;
                }
                if (!((Tag)tagtype.next()).hasProperty(lastTagProperty))
                {
                    continue;
                }
                flag = true;
                break;
            } while (true);
            if (flag)
            {
                tagtype = loadTags(lastTagProperty);
                if (isTagsChanged(tagtype))
                {
                    handler.post(tagtype. new Runnable() {

                        final _cls1 this$1;
                        final List val$newTags;

                        public void run()
                        {
                            setTags(newTags);
                        }

            
            {
                this$1 = final__pcls1;
                newTags = List.this;
                super();
            }
                    });
                }
            }
        }

            
            {
                this$0 = TagListAdapter.this;
                super();
            }
    };
    private SortType sortType;
    private TagDao tagDao;
    private Tag tagPositionZero;
    private TagType tagType;
    private List tags;
    private ViewFactory viewFactory;

    public TagListAdapter()
    {
        tags = Collections.emptyList();
        sortType = SortType.DATE_DESC;
    }

    private Tag getTag(int i)
    {
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_9;
        }
        return getZeroTag();
        Tag tag = (Tag)tags.get(i);
        return tag;
        IndexOutOfBoundsException indexoutofboundsexception;
        indexoutofboundsexception;
        return null;
    }

    private Tag getZeroTag()
    {
        if (tagPositionZero == null)
        {
            tagPositionZero = (Tag)tags.get(0);
        }
        return tagPositionZero;
    }

    private void resetZeroTag()
    {
        tagPositionZero = null;
    }

    public int getCount()
    {
        return tags.size();
    }

    public SortType getCurrentSortType()
    {
        return sortType;
    }

    public Object getItem(int i)
    {
        return getTag(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public List getTags()
    {
        return tags;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        viewgroup = getTag(i);
        return viewFactory.getView(i, viewgroup, view);
    }

    public void init(TagProperty tagproperty, TagType tagtype, List list)
    {
        lastTagProperty = tagproperty;
        if (list != null)
        {
            tags = list;
        } else
        {
            tags = Collections.emptyList();
        }
        resetZeroTag();
        if (tagType != null)
        {
            onDestroy();
        }
        tagType = tagtype;
        tagDao.registerObserver(observer, tagtype);
        notifyDataSetChanged();
    }

    protected boolean isTagsChanged(List list)
    {
        if (tags.size() == list.size())
        {
            Iterator iterator = tags.iterator();
            for (list = list.iterator(); iterator.hasNext() && list.hasNext();)
            {
                if (!((Tag)iterator.next()).visiblyEqual((Tag)list.next()))
                {
                    return true;
                }
            }

            return false;
        } else
        {
            return true;
        }
    }

    public List loadTags(TagProperty tagproperty)
    {
        Object obj;
        lastTagProperty = tagproperty;
        obj = null;
_L2:
        if (obj != null)
        {
            break; /* Loop/switch isn't completed */
        }
        List list = tagDao.getTagsByProperty(tagType, tagproperty, sortType.getSortOrder());
        obj = list;
        if (list.size() <= 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        list.get(0);
        obj = list;
        continue; /* Loop/switch isn't completed */
        obj;
        GLogger.i(TAG, ((IndexOutOfBoundsException) (obj)).getMessage(), new Object[0]);
        obj = null;
        if (true) goto _L2; else goto _L1
_L1:
        return ((List) (obj));
    }

    public void onDestroy()
    {
        if (tagType != null)
        {
            tagDao.unregisterObserver(observer, tagType);
        }
    }

    public void setSortType(SortType sorttype)
    {
        sortType = sorttype;
    }

    public void setTagDao(TagDao tagdao)
    {
        tagDao = tagdao;
    }

    public void setTags(List list)
    {
        tags = list;
        resetZeroTag();
        viewFactory.reset();
        notifyDataSetChanged();
    }

    public void setViewFactory(ViewFactory viewfactory)
    {
        viewFactory = viewfactory;
    }

    public List sort(SortType sorttype)
    {
        sortType = sorttype;
        return loadTags(lastTagProperty);
    }



}
