// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.user.symban;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.ebay.common.util.ImageCache;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.widget.SwipeDismissListViewTouchListener;
import com.ebay.mobile.widget.UserThumbnail;
import com.ebay.nautilus.domain.data.SymbanNotification;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;

public class SymbanAdapter extends ArrayAdapter
{
    public static interface OnItemDismissedListener
    {

        public abstract void onItemDismissed(SymbanNotification symbannotification);

        public abstract void onItemUnDismissed(SymbanNotification symbannotification);

        public abstract void onNoItemsDismissed();
    }

    private class SymbanDismissListener
        implements com.ebay.mobile.widget.SwipeDismissListViewTouchListener.DismissCallbacks
    {

        final SymbanAdapter this$0;

        public boolean canDismiss(int i)
        {
            return true;
        }

        public void onDismiss(ListView listview, int i)
        {
            if (i < getCount())
            {
                listview = (SymbanNotification)getItem(i);
            } else
            {
                listview = null;
            }
            if (listview != null)
            {
                String s = listview.getNotificationId();
                if (!dismissItems.contains(s))
                {
                    dismissItems.add(s);
                    if (itemDismissedListener != null)
                    {
                        itemDismissedListener.onItemDismissed(listview);
                    }
                }
            }
        }

        public void onUndismiss(ListView listview, int i)
        {
            if (i < getCount())
            {
                listview = (SymbanNotification)getItem(i);
            } else
            {
                listview = null;
            }
            if (listview != null)
            {
                String s = listview.getNotificationId();
                if (dismissItems.contains(s))
                {
                    removeFromDismissList(listview);
                }
            }
        }

        private SymbanDismissListener()
        {
            this$0 = SymbanAdapter.this;
            super();
        }

    }

    private class ViewHolder
    {

        final TextView body;
        final ImageView image;
        final View row;
        final SymbanAdapter this$0;
        final TextView title;

        ViewHolder(View view)
        {
            this$0 = SymbanAdapter.this;
            super();
            row = view.findViewById(0x7f100827);
            image = (ImageView)view.findViewById(0x7f10005b);
            title = (TextView)view.findViewById(0x7f10005f);
            body = (TextView)view.findViewById(0x7f1000f8);
        }
    }


    public static final int ITEM_VIEW_TYPE_LISTING = 0;
    public static final int ITEM_VIEW_TYPE_MESSAGE = 1;
    public static final int ITEM_VIEW_TYPE_TOTAL_COUNT = 2;
    private static final String STATE_DISMISS_ITEMS = "state_dismiss_items";
    private static int defaultUiGroupColor;
    private static final EnumMap uiGroupColors = new EnumMap(com/ebay/nautilus/domain/data/SymbanNotification$UiGroupEnum);
    protected HashSet dismissItems;
    private final ImageCache imageCache;
    protected OnItemDismissedListener itemDismissedListener;
    private final int newBackgroundColor;
    private final int oldBackgroundColor;
    private SwipeDismissListViewTouchListener swipeDismissListener;

    public SymbanAdapter(Activity activity, List list)
    {
        super(activity, 0x7f030266, list);
        itemDismissedListener = null;
        dismissItems = new HashSet();
        list = new TypedValue();
        android.content.res.Resources.Theme theme = activity.getTheme();
        Resources resources = activity.getResources();
        if (!theme.resolveAttribute(0x7f010058, list, true))
        {
            list.resourceId = 0x7f0d00ae;
        }
        oldBackgroundColor = resources.getColor(((TypedValue) (list)).resourceId);
        newBackgroundColor = resources.getColor(0x7f0d00ad);
        imageCache = new ImageCache(activity, MyApp.getDeviceConfiguration().getGalleryImageHost());
        initColors(resources);
    }

    private void dismiss(View view)
    {
        view.animate().translationX(view.getWidth()).alpha(0.0F).setDuration(0L);
    }

    public static int getItemViewType(com.ebay.nautilus.domain.data.SymbanNotification.ActionEnum actionenum, com.ebay.nautilus.domain.data.SymbanNotification.MdnsNameEnum mdnsnameenum, String s, String s1)
    {
        if (!com.ebay.nautilus.domain.data.SymbanNotification.MdnsNameEnum.SHOPCARTITM.equals(mdnsnameenum))
        {
            if (com.ebay.nautilus.domain.data.SymbanNotification.ActionEnum.VIEW_MESSAGE.equals(actionenum))
            {
                return 1;
            }
            if (s1 == null || !com.ebay.nautilus.domain.data.SymbanNotification.ActionEnum.VIEW_ITEM.equals(actionenum) && !com.ebay.nautilus.domain.data.SymbanNotification.ActionEnum.PAY_NOW.equals(actionenum) && !com.ebay.nautilus.domain.data.SymbanNotification.ActionEnum.REVIEW_OFFER.equals(actionenum) && !com.ebay.nautilus.domain.data.SymbanNotification.ActionEnum.BUY_NOW.equals(actionenum) && !com.ebay.nautilus.domain.data.SymbanNotification.ActionEnum.VIEW_ORDER.equals(actionenum) && !com.ebay.nautilus.domain.data.SymbanNotification.ActionEnum.SHIP_ITEM.equals(actionenum))
            {
                if (s != null)
                {
                    return 1;
                }
                if (s1 == null)
                {
                    return -1;
                }
            }
        }
        return 0;
    }

    public static int getItemViewType(SymbanNotification symbannotification)
    {
        if (symbannotification != null)
        {
            return getItemViewType(symbannotification.getAction(), symbannotification.getMdnsName(), symbannotification.getMessageId(), symbannotification.getListingId());
        } else
        {
            return -1;
        }
    }

    private String getNotificationId(int i)
    {
        SymbanNotification symbannotification = (SymbanNotification)getItem(i);
        if (symbannotification != null)
        {
            return symbannotification.getNotificationId();
        } else
        {
            return null;
        }
    }

    private void initColors(Resources resources)
    {
        uiGroupColors.put(com.ebay.nautilus.domain.data.SymbanNotification.UiGroupEnum.UI_1, Integer.valueOf(resources.getColor(0x7f0d00f0)));
        uiGroupColors.put(com.ebay.nautilus.domain.data.SymbanNotification.UiGroupEnum.UI_2, Integer.valueOf(resources.getColor(0x7f0d00ee)));
        uiGroupColors.put(com.ebay.nautilus.domain.data.SymbanNotification.UiGroupEnum.UI_3, Integer.valueOf(resources.getColor(0x7f0d00e7)));
        uiGroupColors.put(com.ebay.nautilus.domain.data.SymbanNotification.UiGroupEnum.UI_4, Integer.valueOf(resources.getColor(0x7f0d00e3)));
        uiGroupColors.put(com.ebay.nautilus.domain.data.SymbanNotification.UiGroupEnum.UI_5, Integer.valueOf(resources.getColor(0x7f0d00dd)));
        uiGroupColors.put(com.ebay.nautilus.domain.data.SymbanNotification.UiGroupEnum.UI_6, Integer.valueOf(resources.getColor(0x7f0d00ef)));
        defaultUiGroupColor = ((Integer)uiGroupColors.get(com.ebay.nautilus.domain.data.SymbanNotification.UiGroupEnum.UI_5)).intValue();
    }

    private void setupReadStatus(ViewHolder viewholder, SymbanNotification symbannotification)
    {
        if (symbannotification.isNew())
        {
            viewholder.row.setBackgroundColor(newBackgroundColor);
            viewholder.title.setTypeface(null, 1);
            viewholder.body.setTypeface(null, 1);
            return;
        } else
        {
            viewholder.row.setBackgroundColor(oldBackgroundColor);
            viewholder.title.setTypeface(null, 0);
            viewholder.body.setTypeface(null, 0);
            return;
        }
    }

    private void setupTitle(ViewHolder viewholder, com.ebay.nautilus.domain.data.SymbanNotification.UiGroupEnum uigroupenum)
    {
        Integer integer = (Integer)uiGroupColors.get(uigroupenum);
        uigroupenum = integer;
        if (integer == null)
        {
            uigroupenum = Integer.valueOf(defaultUiGroupColor);
        }
        viewholder.title.setTextColor(uigroupenum.intValue());
    }

    private void undismiss(View view)
    {
        view.animate().translationX(0.0F).alpha(1.0F).setDuration(0L);
    }

    public List getDismissedItems()
    {
        ArrayList arraylist = new ArrayList();
        int j = getCount();
        for (int i = 0; i < j; i++)
        {
            SymbanNotification symbannotification = (SymbanNotification)getItem(i);
            if (dismissItems.contains(symbannotification.getNotificationId()))
            {
                arraylist.add(symbannotification);
            }
        }

        return arraylist;
    }

    public int getItemViewType(int i)
    {
        return getItemViewType((SymbanNotification)getItem(i));
    }

    public int getNewItemBackgroundColor()
    {
        return newBackgroundColor;
    }

    public int getOldItemBackgroundColor()
    {
        return oldBackgroundColor;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        Object obj;
label0:
        {
            int j = getItemViewType(i);
            SymbanNotification symbannotification = (SymbanNotification)getItem(i);
            if (view == null)
            {
                if (j == 1)
                {
                    i = 0x7f030267;
                } else
                {
                    i = 0x7f030266;
                }
                view = LayoutInflater.from(getContext()).inflate(i, viewgroup, false);
                viewgroup = new ViewHolder(view);
                view.setTag(viewgroup);
            } else
            {
                obj = view;
                viewgroup = (ViewHolder)view.getTag();
                view = ((View) (obj));
            }
            i = 0;
            if (j == 0)
            {
                setupTitle(viewgroup, symbannotification.getUiGroup());
                i = 0x7f0201f5;
            } else
            if (j == 1)
            {
                i = 0x7f020241;
            } else
            if (com.ebay.nautilus.domain.data.SymbanNotification.MdnsNameEnum.UCI.equals(symbannotification.getMdnsName()))
            {
                i = 0x7f0201f5;
            } else
            {
                view = null;
            }
            if (view != null)
            {
                ((ViewHolder) (viewgroup)).body.setText(symbannotification.getContent());
                ((ViewHolder) (viewgroup)).title.setText(symbannotification.getTitle());
                setupReadStatus(viewgroup, symbannotification);
                if (dismissItems.contains(symbannotification.getNotificationId()))
                {
                    dismiss(((ViewHolder) (viewgroup)).row);
                } else
                {
                    undismiss(((ViewHolder) (viewgroup)).row);
                }
                obj = symbannotification.getImageUrl();
                if (!TextUtils.isEmpty(((CharSequence) (obj))))
                {
                    break label0;
                }
                if (((ViewHolder) (viewgroup)).image instanceof UserThumbnail)
                {
                    ((UserThumbnail)((ViewHolder) (viewgroup)).image).postImageResource(i);
                } else
                {
                    ((ViewHolder) (viewgroup)).image.setImageResource(i);
                }
                ImageCache.forgetView(((ViewHolder) (viewgroup)).image);
            }
            return view;
        }
        imageCache.setImage(((ViewHolder) (viewgroup)).image, ((String) (obj)), i);
        return view;
    }

    public int getViewTypeCount()
    {
        return 2;
    }

    public boolean isItemDismissed(int i)
    {
        String s = getNotificationId(i);
        if (TextUtils.isEmpty(s))
        {
            return false;
        } else
        {
            return dismissItems.contains(s);
        }
    }

    public void onRestoreInstanceState(Bundle bundle)
    {
label0:
        {
            dismissItems = new HashSet(bundle.getStringArrayList("state_dismiss_items"));
            if (itemDismissedListener != null)
            {
                if (!dismissItems.isEmpty())
                {
                    break label0;
                }
                itemDismissedListener.onNoItemsDismissed();
            }
            return;
        }
        itemDismissedListener.onItemDismissed(null);
    }

    public Parcelable onSaveInstanceState()
    {
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("state_dismiss_items", new ArrayList(dismissItems));
        return bundle;
    }

    public void remove(SymbanNotification symbannotification)
    {
        removeFromDismissList(symbannotification);
        super.remove(symbannotification);
    }

    public volatile void remove(Object obj)
    {
        remove((SymbanNotification)obj);
    }

    protected void removeFromDismissList(SymbanNotification symbannotification)
    {
        String s = symbannotification.getNotificationId();
        dismissItems.remove(s);
        if (itemDismissedListener != null)
        {
            itemDismissedListener.onItemUnDismissed(symbannotification);
            if (dismissItems.isEmpty())
            {
                itemDismissedListener.onNoItemsDismissed();
            }
        }
    }

    public void setOnItemDismissedListener(OnItemDismissedListener onitemdismissedlistener)
    {
        itemDismissedListener = onitemdismissedlistener;
    }

    public SwipeDismissListViewTouchListener setupDismissListener(ListView listview)
    {
        swipeDismissListener = new SwipeDismissListViewTouchListener(listview, new SymbanDismissListener());
        swipeDismissListener.setSwipeableViewId(0x7f100827);
        listview.setOnTouchListener(swipeDismissListener);
        return swipeDismissListener;
    }

}
