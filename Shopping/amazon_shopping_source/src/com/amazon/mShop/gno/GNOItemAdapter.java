// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.collect.BiMap;
import com.amazon.mShop.platform.Platform;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;

// Referenced classes of package com.amazon.mShop.gno:
//            GNODrawerItem, GNODrawer, GNODrawerItemBase, GNODrawerFakeExpandCollapseLayout, 
//            GNODrawerItemHideable, GNODrawerItemAppstoreHeader

public class GNOItemAdapter extends BaseAdapter
    implements Iterable
{
    private static final class DividerType extends Enum
    {

        private static final DividerType $VALUES[];
        public static final DividerType DIVIDER;
        public static final DividerType SUB_DIVIDER;
        private int mValue;

        public static DividerType valueOf(String s)
        {
            return (DividerType)Enum.valueOf(com/amazon/mShop/gno/GNOItemAdapter$DividerType, s);
        }

        public static DividerType[] values()
        {
            return (DividerType[])$VALUES.clone();
        }

        static 
        {
            DIVIDER = new DividerType("DIVIDER", 0, 0);
            SUB_DIVIDER = new DividerType("SUB_DIVIDER", 1, 1);
            $VALUES = (new DividerType[] {
                DIVIDER, SUB_DIVIDER
            });
        }


        private DividerType(String s, int i, int j)
        {
            super(s, i);
            mValue = j;
        }
    }

    private class DividerViewHolder
    {

        View dividerLine;
        final GNOItemAdapter this$0;

        private DividerViewHolder()
        {
            this$0 = GNOItemAdapter.this;
            super();
        }

    }

    private class FakeExpandCollapseDrawerItem extends GNODrawerItemBase
    {

        private Runnable mEndActionRunnable;
        private boolean mIsExpanding;
        private boolean mShouldShowExpandingArea;
        final GNOItemAdapter this$0;

        public String getId()
        {
            return "GNOItemAdapter.FakeExpandCollapseItem";
        }

        public GNODrawerItem.Type getType()
        {
            return GNODrawerItem.Type.FAKE_GROUP_ANIMATION;
        }

        public View getView(View view, ViewGroup viewgroup)
        {
            Object obj;
            if (view == null)
            {
                view = new GNODrawerFakeExpandCollapseLayout(viewgroup.getContext());
            } else
            {
                view = (GNODrawerFakeExpandCollapseLayout)view;
            }
            obj = getItem(mExpandedGroupId);
            viewgroup = new ArrayList();
            obj = ((GNODrawerItem) (obj)).getChildren().iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                GNODrawerItem gnodraweritem = (GNODrawerItem)((Iterator) (obj)).next();
                if (!(gnodraweritem instanceof GNODrawerItemHideable) || !((HideableItem)gnodraweritem).isHidden())
                {
                    viewgroup.add(gnodraweritem);
                }
            } while (true);
            view.setItems(viewgroup);
            view.startExpandCollapseAnimation(mIsExpanding, mShouldShowExpandingArea, new Runnable() {

                final FakeExpandCollapseDrawerItem this$1;

                public void run()
                {
                    mIsAnimating = false;
                    if (!mIsExpanding)
                    {
                        mExpandedGroupId = null;
                    }
                    updateVisibleItems();
                    if (mEndActionRunnable != null)
                    {
                        mEndActionRunnable.run();
                    }
                }

            
            {
                this$1 = FakeExpandCollapseDrawerItem.this;
                super();
            }
            });
            return view;
        }

        public void setAnimationType(boolean flag, boolean flag1, Runnable runnable)
        {
            mIsExpanding = flag;
            mShouldShowExpandingArea = flag1;
            mEndActionRunnable = runnable;
        }



        public FakeExpandCollapseDrawerItem()
        {
            this$0 = GNOItemAdapter.this;
            super();
        }
    }

    public static interface HideableItem
    {

        public abstract Callable getIsHiddenCallable();

        public abstract boolean isHidden();
    }


    private String mCoins;
    private final Map mDrawerItems;
    private String mExpandedGroupId;
    private FakeExpandCollapseDrawerItem mFakeExpandCollapseItem;
    private volatile boolean mIsAnimating;
    private final Map mItemTypes;
    private final BiMap mVisibleItems;

    public GNOItemAdapter()
    {
        this(((Collection) (new ArrayList())));
    }

    public GNOItemAdapter(Collection collection)
    {
        mCoins = "DISABLED";
        mDrawerItems = new LinkedHashMap();
        mVisibleItems = new BiMap();
        mItemTypes = buildItemTypes();
        setItems(collection);
    }

    private void addItems(Collection collection)
    {
        GNODrawerItem gnodraweritem;
        for (collection = collection.iterator(); collection.hasNext(); addItems(gnodraweritem.getChildren()))
        {
            gnodraweritem = (GNODrawerItem)collection.next();
            mDrawerItems.put(gnodraweritem.getId(), gnodraweritem);
        }

    }

    private static Map buildItemTypes()
    {
        HashMap hashmap = new HashMap();
        GNODrawerItem.Type atype[] = GNODrawerItem.Type.values();
        int j = atype.length;
        for (int i = 0; i < j; i++)
        {
            hashmap.put(atype[i], Integer.valueOf(hashmap.size()));
        }

        return hashmap;
    }

    private void collectVisibleItems()
    {
        mVisibleItems.clear();
        Iterator iterator1 = mDrawerItems.values().iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            GNODrawerItem gnodraweritem = (GNODrawerItem)iterator1.next();
            if (!(gnodraweritem instanceof HideableItem) || !((HideableItem)gnodraweritem).isHidden())
            {
                GNODrawerItem gnodraweritem1 = gnodraweritem.getParent();
                if (gnodraweritem1 == null || !mIsAnimating && gnodraweritem1.getId().equals(mExpandedGroupId))
                {
                    mVisibleItems.put(Integer.valueOf(mVisibleItems.size()), gnodraweritem.getId());
                }
                if (mIsAnimating && gnodraweritem.getId().equals(mExpandedGroupId))
                {
                    mVisibleItems.put(Integer.valueOf(mVisibleItems.size()), "GNOItemAdapter.FakeExpandCollapseItem");
                }
            }
        } while (true);
    }

    public static int getAdapterPosition(int i)
    {
        return i / 2;
    }

    private View getDivider(int i, View view, ViewGroup viewgroup)
    {
        GNODrawerItem gnodraweritem;
        GNODrawerItem gnodraweritem1;
        if (view != null)
        {
            View view1 = view;
            viewgroup = (DividerViewHolder)view.getTag();
            view = view1;
        } else
        {
            int j;
            if (getDividerType(i) == DividerType.SUB_DIVIDER)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            view = LayoutInflater.from(viewgroup.getContext());
            if (j != 0)
            {
                j = com.amazon.mShop.android.lib.R.layout.gno_drawer_sub_item_divider;
            } else
            {
                j = com.amazon.mShop.android.lib.R.layout.gno_drawer_item_divider;
            }
            view = view.inflate(j, viewgroup, false);
            viewgroup = new DividerViewHolder();
            viewgroup.dividerLine = view.findViewById(com.amazon.mShop.android.lib.R.id.gno_drawer_item_divider);
            view.setTag(viewgroup);
        }
        gnodraweritem = getItem(i);
        gnodraweritem1 = getItem(i - 2);
        if (gnodraweritem1 != null && gnodraweritem1.allowDividers() && gnodraweritem != null && gnodraweritem.allowDividers())
        {
            ((DividerViewHolder) (viewgroup)).dividerLine.setVisibility(0);
            return view;
        } else
        {
            ((DividerViewHolder) (viewgroup)).dividerLine.setVisibility(8);
            return view;
        }
    }

    private DividerType getDividerType(int i)
    {
        if (i > 0)
        {
            GNODrawerItem gnodraweritem = getItem(i - 2);
            if (getItem(i).getParent() != null && gnodraweritem.getParent() != null)
            {
                return DividerType.SUB_DIVIDER;
            }
        }
        return DividerType.DIVIDER;
    }

    public static int getListViewPosition(int i)
    {
        return i * 2 + 1;
    }

    private boolean isDivider(int i)
    {
        return i % 2 == 0;
    }

    private void setupFakeExpandCollapseAnimation(boolean flag, boolean flag1, Runnable runnable)
    {
        if (mFakeExpandCollapseItem == null)
        {
            mFakeExpandCollapseItem = new FakeExpandCollapseDrawerItem();
        }
        mFakeExpandCollapseItem.setAnimationType(flag, flag1, runnable);
    }

    public void clearItems()
    {
        mVisibleItems.clear();
        mDrawerItems.clear();
    }

    public void collapseExpandedGroup()
    {
        collapseExpandedGroup(false);
    }

    public void collapseExpandedGroup(boolean flag)
    {
        if (flag)
        {
            mIsAnimating = true;
            setupFakeExpandCollapseAnimation(false, false, null);
        } else
        {
            mExpandedGroupId = null;
        }
        updateVisibleItems();
    }

    public boolean collapseGroup(String s, boolean flag)
    {
        if (s.equals(mExpandedGroupId))
        {
            collapseExpandedGroup(flag);
            return true;
        } else
        {
            return false;
        }
    }

    public boolean contains(String s)
    {
        return mDrawerItems.containsKey(s);
    }

    public Callable createAppstoreCoinTabCallable()
    {
        return new Callable() {

            final GNOItemAdapter this$0;

            public Boolean call()
                throws Exception
            {
                return Boolean.valueOf("DISABLED".equals(mCoins));
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = GNOItemAdapter.this;
                super();
            }
        };
    }

    public boolean expandGroup(String s)
    {
        return expandGroup(s, false);
    }

    public boolean expandGroup(final String activity, boolean flag)
    {
        if (contains(activity))
        {
            mExpandedGroupId = activity;
            activity = AmazonActivity.getTopMostBaseActivity();
            if (flag)
            {
                mIsAnimating = true;
                final boolean shouldShowExpandingArea;
                if (activity != null && activity.getGNODrawer().isLastVisibleItem(mExpandedGroupId))
                {
                    shouldShowExpandingArea = true;
                    activity.getGNODrawer().getListView().setTranscriptMode(1);
                } else
                {
                    shouldShowExpandingArea = false;
                }
                setupFakeExpandCollapseAnimation(true, shouldShowExpandingArea, new Runnable() {

                    final GNOItemAdapter this$0;
                    final AmazonActivity val$activity;
                    final boolean val$shouldShowExpandingArea;

                    public void run()
                    {
                        if (shouldShowExpandingArea)
                        {
                            activity.getGNODrawer().getListView().setTranscriptMode(0);
                        }
                    }

            
            {
                this$0 = GNOItemAdapter.this;
                shouldShowExpandingArea = flag;
                activity = amazonactivity;
                super();
            }
                });
            }
            updateVisibleItems();
            if (flag)
            {
                com.amazon.mShop.platform.Platform.Factory.getInstance().runOnUiThread(new Runnable() {

                    final GNOItemAdapter this$0;
                    final AmazonActivity val$activity;

                    public void run()
                    {
                        GNODrawer gnodrawer = activity.getGNODrawer();
                        if (!gnodrawer.isItemDisplayed(mExpandedGroupId))
                        {
                            gnodrawer.scrollItemToTop(mExpandedGroupId);
                        }
                    }

            
            {
                this$0 = GNOItemAdapter.this;
                activity = amazonactivity;
                super();
            }
                });
            }
            return true;
        } else
        {
            return false;
        }
    }

    public String getCoinValue()
    {
        return mCoins;
    }

    public int getCount()
    {
        return mVisibleItems.size() * 2;
    }

    public GNODrawerItem getItem(int i)
    {
        String s = (String)mVisibleItems.get(Integer.valueOf(getAdapterPosition(i)));
        if ("GNOItemAdapter.FakeExpandCollapseItem".equals(s))
        {
            return mFakeExpandCollapseItem;
        } else
        {
            return (GNODrawerItem)mDrawerItems.get(s);
        }
    }

    public GNODrawerItem getItem(String s)
    {
        return (GNODrawerItem)mDrawerItems.get(s);
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public int getItemViewType(int i)
    {
        if (isDivider(i))
        {
            return mItemTypes.size() + getDividerType(i).mValue;
        } else
        {
            return ((Integer)mItemTypes.get(getItem(i).getType())).intValue();
        }
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (isDivider(i))
        {
            return getDivider(i, view, viewgroup);
        } else
        {
            return getItem(i).getView(view, viewgroup);
        }
    }

    public int getViewTypeCount()
    {
        return GNODrawerItem.Type.values().length + DividerType.values().length;
    }

    public int getVisibleItemPosition(String s)
    {
        s = (Integer)mVisibleItems.inverse().get(s);
        if (s == null)
        {
            return -1;
        } else
        {
            return s.intValue();
        }
    }

    public boolean isEmpty()
    {
        return mDrawerItems.isEmpty();
    }

    public boolean isGroupExpanded(String s)
    {
        return s.equals(mExpandedGroupId);
    }

    public Iterator iterator()
    {
        return mDrawerItems.values().iterator();
    }

    public void setAppstoreCoinsCount(String s)
    {
        mCoins = s;
        if ("0".equals(s))
        {
            mCoins = "DISABLED";
        }
        com.amazon.mShop.platform.Platform.Factory.getInstance().runOnUiThread(new Runnable() {

            final GNOItemAdapter this$0;

            public void run()
            {
                if ((GNODrawerItemAppstoreHeader)getItem("mshop:appstore") != null)
                {
                    GNODrawerItemHideable gnodraweritemhideable = (GNODrawerItemHideable)getItem("mshop:appstore/coins");
                    if (gnodraweritemhideable != null)
                    {
                        gnodraweritemhideable.setIsHiddenCallable(createAppstoreCoinTabCallable());
                    }
                    collectVisibleItems();
                    notifyDataSetChanged();
                }
            }

            
            {
                this$0 = GNOItemAdapter.this;
                super();
            }
        });
    }

    public void setItems(final Collection items)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().runOnUiThread(new Runnable() {

            final GNOItemAdapter this$0;
            final Collection val$items;

            public void run()
            {
                mDrawerItems.clear();
                addItems(items);
                collectVisibleItems();
                notifyDataSetChanged();
            }

            
            {
                this$0 = GNOItemAdapter.this;
                items = collection;
                super();
            }
        });
    }

    public void updateVisibleItems()
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().runOnUiThread(new Runnable() {

            final GNOItemAdapter this$0;

            public void run()
            {
                collectVisibleItems();
                notifyDataSetChanged();
            }

            
            {
                this$0 = GNOItemAdapter.this;
                super();
            }
        });
    }






/*
    static String access$402(GNOItemAdapter gnoitemadapter, String s)
    {
        gnoitemadapter.mExpandedGroupId = s;
        return s;
    }

*/


/*
    static boolean access$602(GNOItemAdapter gnoitemadapter, boolean flag)
    {
        gnoitemadapter.mIsAnimating = flag;
        return flag;
    }

*/

}
