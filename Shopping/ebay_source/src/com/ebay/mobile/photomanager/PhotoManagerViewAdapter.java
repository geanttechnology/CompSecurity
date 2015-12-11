// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.photomanager;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.ebay.common.net.api.eps.GetImage;
import com.ebay.common.util.ImageCache;
import com.ebay.nautilus.kernel.NautilusKernel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.photomanager:
//            PictureUrl

public final class PhotoManagerViewAdapter extends BaseAdapter
{
    private class GridItem
        implements Comparable
    {

        boolean enabled;
        boolean isAddButton;
        boolean isStockPhoto;
        int orderDisplay;
        final PhotoManagerViewAdapter this$0;
        String thumbUrl;
        String url;

        public int compareTo(GridItem griditem)
        {
            if (griditem.isAddButton)
            {
                return -1;
            }
            return !griditem.isStockPhoto ? 0 : 1;
        }

        public volatile int compareTo(Object obj)
        {
            return compareTo((GridItem)obj);
        }

        GridItem()
        {
            this$0 = PhotoManagerViewAdapter.this;
            super();
            isAddButton = false;
            isStockPhoto = false;
            enabled = true;
            orderDisplay = 0;
        }

        GridItem(PictureUrl pictureurl)
        {
            this$0 = PhotoManagerViewAdapter.this;
            super();
            isAddButton = false;
            isStockPhoto = false;
            enabled = true;
            orderDisplay = 0;
            url = pictureurl.url;
            enabled = pictureurl.enabled;
            isStockPhoto = pictureurl.stockPhoto;
            thumbUrl = GetImage.convertUrl(url, com.ebay.common.net.api.eps.GetImage.Size.D400x400);
        }

        GridItem(String s)
        {
            this$0 = PhotoManagerViewAdapter.this;
            super();
            isAddButton = false;
            isStockPhoto = false;
            enabled = true;
            orderDisplay = 0;
            url = s;
            thumbUrl = GetImage.convertUrl(s, com.ebay.common.net.api.eps.GetImage.Size.D400x400);
        }
    }

    public static final class ViewCache
    {

        public final TextView caption;
        public final TextView free;
        public final ImageView image;
        public final ImageView lock;
        public final TextView numberText;

        public ViewCache(View view)
        {
            image = (ImageView)view.findViewById(0x7f1004b3);
            numberText = (TextView)view.findViewById(0x7f1004b4);
            lock = (ImageView)view.findViewById(0x7f1004b5);
            caption = (TextView)view.findViewById(0x7f1004b6);
            free = (TextView)view.findViewById(0x7f1004b7);
        }
    }


    private final Context context;
    private final int gridSquareSize;
    private final ImageCache imageCache;
    private final LayoutInflater inflater;
    private final List items = new ArrayList();
    private final int maxPhotos;
    private int maxPhotosFree;
    private boolean modified;

    public PhotoManagerViewAdapter(Activity activity, List list, int i, int j)
    {
        modified = false;
        maxPhotosFree = 0;
        context = activity;
        int k = i;
        if (i < 0)
        {
            k = 0;
        }
        maxPhotos = k;
        maxPhotosFree = j;
        inflater = (LayoutInflater)context.getSystemService("layout_inflater");
        gridSquareSize = (int)TypedValue.applyDimension(1, 148F, context.getResources().getDisplayMetrics());
        imageCache = new ImageCache(activity);
        for (activity = list.iterator(); activity.hasNext(); items.add(new GridItem(list)))
        {
            list = (PictureUrl)activity.next();
        }

        activity = new GridItem();
        activity.isAddButton = true;
        items.add(activity);
        notifyDataSetChanged();
    }

    private int adjustPosition(int i)
    {
        int j = i;
        if (isStockHidden())
        {
            j = i;
            if (i + 1 < items.size())
            {
                j = i + 1;
            }
        }
        return j;
    }

    private boolean isStockHidden()
    {
        boolean flag;
        if (getStockPhotoUrl() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        Iterator iterator = items.iterator();
        GridItem griditem;
        do
        {
            if (!iterator.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            griditem = (GridItem)iterator.next();
        } while (griditem.isStockPhoto || griditem.isAddButton);
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }

    protected void addAfterUpload(String s)
    {
        modified = true;
        s = new GridItem(s);
        items.add(s);
        notifyDataSetChanged();
    }

    public int getCount()
    {
        if (items.size() == 1 && ((GridItem)items.get(0)).isStockPhoto)
        {
            return Math.min(1, maxPhotos);
        }
        if (items.size() == 2 && ((GridItem)items.get(0)).isStockPhoto && ((GridItem)items.get(0)).isAddButton)
        {
            return Math.min(2, maxPhotos);
        }
        if (items.size() > 2 && ((GridItem)items.get(0)).isStockPhoto)
        {
            return Math.min(items.size() - 1, maxPhotos);
        } else
        {
            return Math.min(items.size(), maxPhotos);
        }
    }

    public GridItem getItem(int i)
    {
        return (GridItem)items.get(adjustPosition(i));
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public long getItemId(int i)
    {
        return (long)adjustPosition(i);
    }

    public String getStockPhotoUrl()
    {
        for (Iterator iterator = items.iterator(); iterator.hasNext();)
        {
            GridItem griditem = (GridItem)iterator.next();
            if (griditem.isStockPhoto)
            {
                return griditem.url;
            }
        }

        return null;
    }

    public ArrayList getUrls()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = items.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            GridItem griditem = (GridItem)iterator.next();
            if (!griditem.isAddButton)
            {
                arraylist.add(new PictureUrl(griditem.url, true, griditem.isStockPhoto));
            }
        } while (true);
        return arraylist;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        boolean flag = false;
        GridItem griditem;
        if (view == null)
        {
            viewgroup = inflater.inflate(0x7f03019e, null);
            viewgroup.setLayoutParams(new android.widget.AbsListView.LayoutParams(gridSquareSize, gridSquareSize));
            view = new ViewCache(viewgroup);
            viewgroup.setTag(view);
        } else
        {
            viewgroup = view;
            view = (ViewCache)viewgroup.getTag();
        }
        griditem = getItem(i);
        if (griditem.isAddButton)
        {
            ((ViewCache) (view)).image.setScaleType(android.widget.ImageView.ScaleType.CENTER);
            imageCache.setImage(((ViewCache) (view)).image, null);
            ((ViewCache) (view)).image.setImageResource(0x7f0202a1);
            ((ViewCache) (view)).numberText.setVisibility(8);
            ((ViewCache) (view)).lock.setVisibility(8);
            ((ViewCache) (view)).caption.setVisibility(8);
            ((ViewCache) (view)).free.setVisibility(0);
            if (maxPhotosFree > 0)
            {
                if (maxPhotosFree == 1)
                {
                    ((ViewCache) (view)).free.setText(context.getResources().getString(0x7f070785));
                    return viewgroup;
                } else
                {
                    ((ViewCache) (view)).free.setText(context.getResources().getString(0x7f070786, new Object[] {
                        Integer.valueOf(maxPhotosFree)
                    }));
                    return viewgroup;
                }
            } else
            {
                ((ViewCache) (view)).free.setText(context.getResources().getString(0x7f070618));
                return viewgroup;
            }
        }
        ImageView imageview;
        if (griditem.isStockPhoto)
        {
            ((ViewCache) (view)).numberText.setVisibility(8);
            ((ViewCache) (view)).caption.setText(context.getString(0x7f070782));
            ((ViewCache) (view)).caption.setBackgroundColor(context.getResources().getColor(0x7f0d001c));
            ((ViewCache) (view)).caption.setVisibility(0);
        } else
        {
            ((ViewCache) (view)).numberText.setText((new StringBuilder()).append("").append(griditem.orderDisplay).toString());
            ((ViewCache) (view)).numberText.setVisibility(0);
            if (griditem.orderDisplay == 1)
            {
                ((ViewCache) (view)).caption.setText(context.getString(0x7f070781));
                ((ViewCache) (view)).caption.setBackgroundColor(context.getResources().getColor(0x7f0d001e));
                ((ViewCache) (view)).caption.setVisibility(0);
            } else
            {
                ((ViewCache) (view)).caption.setVisibility(8);
            }
        }
        imageview = ((ViewCache) (view)).lock;
        i = ((flag) ? 1 : 0);
        if (griditem.enabled)
        {
            i = 8;
        }
        imageview.setVisibility(i);
        ((ViewCache) (view)).image.setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
        imageCache.setImage(((ViewCache) (view)).image, griditem.thumbUrl);
        ((ViewCache) (view)).free.setVisibility(8);
        return viewgroup;
    }

    boolean hasSelfHostedPhotos()
    {
        GridItem griditem;
        Iterator iterator = items.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_96;
            }
            griditem = (GridItem)iterator.next();
        } while (TextUtils.isEmpty(griditem.url) || griditem.isStockPhoto);
        if (!NautilusKernel.isQaMode()) goto _L2; else goto _L1
_L1:
        if (Uri.parse(griditem.url).getHost().endsWith(".ebayimg.qa.ebay.com")) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if (!Uri.parse(griditem.url).getHost().endsWith(".ebayimg.com")) goto _L3; else goto _L5
_L5:
        return false;
        return false;
    }

    public boolean isAddButton(int i)
    {
        return getItem(i).isAddButton;
    }

    public boolean isPossibleDragOrDropLocation(int i)
    {
        GridItem griditem = getItem(i);
        return !griditem.isAddButton && !griditem.isStockPhoto && griditem.enabled;
    }

    public boolean isRemovable(int i)
    {
        GridItem griditem = getItem(i);
        return !griditem.isAddButton && griditem.enabled;
    }

    public boolean modified()
    {
        return modified;
    }

    void move(int i, int j)
    {
        if (i == j)
        {
            return;
        } else
        {
            modified = true;
            i = adjustPosition(i);
            j = adjustPosition(j);
            GridItem griditem = (GridItem)items.get(i);
            items.remove(i);
            items.add(j, griditem);
            notifyDataSetChanged();
            return;
        }
    }

    public void notifyDataSetChanged()
    {
        Collections.sort(items);
        int i = 1;
        Iterator iterator = items.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            GridItem griditem = (GridItem)iterator.next();
            if (!griditem.isStockPhoto)
            {
                griditem.orderDisplay = i;
                i++;
            }
        } while (true);
        super.notifyDataSetChanged();
    }

    void remove(int i)
    {
        modified = true;
        i = adjustPosition(i);
        if (i >= 0 && i < items.size())
        {
            items.remove(i);
            notifyDataSetChanged();
        }
    }

    public void resetModified()
    {
        modified = false;
    }
}
