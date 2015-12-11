// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.history;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.amazon.mShop.ItemView;
import com.amazon.mShop.ObjectSubscriberAdapter;
import com.amazon.mShop.details.ItemViewUtils;
import com.amazon.mShop.net.LRUCache;
import com.amazon.mShop.ui.DrawableFactory;
import com.amazon.mShop.util.ImageUtil;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.mShop.BasicProductInfo;
import com.amazon.rio.j2me.client.services.mShop.SearchResult;
import java.text.SimpleDateFormat;
import java.util.Date;

// Referenced classes of package com.amazon.mShop.history:
//            ObjectDeletingObserver

public class HistoryItemView extends ItemView
{

    private int mIndex;
    private ViewGroup mItemRowGroup;
    private ImageView mItemRowImage;
    private String mItemTitle;
    private ObjectDeletingObserver mObserver;
    private ViewGroup mUndoGroup;

    public HistoryItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    protected void dispatchSetPressed(boolean flag)
    {
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        mItemRowGroup = (ViewGroup)findViewById(com.amazon.mShop.android.lib.R.id.history_item_group);
        mUndoGroup = (ViewGroup)findViewById(com.amazon.mShop.android.lib.R.id.history_undo_group);
        mItemRowImage = (ImageView)findViewById(com.amazon.mShop.android.lib.R.id.item_row_image);
        ((Button)findViewById(com.amazon.mShop.android.lib.R.id.history_delete_button)).setOnClickListener(new android.view.View.OnClickListener() {

            final HistoryItemView this$0;

            public void onClick(View view)
            {
                showUndoGroup();
                if (mObserver != null)
                {
                    mObserver.deleteObjectInIndex(mIndex);
                }
            }

            
            {
                this$0 = HistoryItemView.this;
                super();
            }
        });
        ((Button)findViewById(com.amazon.mShop.android.lib.R.id.history_undo_button)).setOnClickListener(new android.view.View.OnClickListener() {

            final HistoryItemView this$0;

            public void onClick(View view)
            {
                showItemGroup();
                if (mObserver != null)
                {
                    mObserver.undoDelete(mIndex);
                }
            }

            
            {
                this$0 = HistoryItemView.this;
                super();
            }
        });
    }

    public void setObjectIndex(int i)
    {
        mIndex = i;
    }

    public void setObserver(ObjectDeletingObserver objectdeletingobserver)
    {
        mObserver = objectdeletingobserver;
    }

    protected void showItemGroup()
    {
        mItemRowGroup.setVisibility(0);
        mUndoGroup.setVisibility(8);
    }

    protected void showUndoGroup()
    {
        ((TextView)mUndoGroup.findViewById(com.amazon.mShop.android.lib.R.id.history_removed_item)).setText(getResources().getString(com.amazon.mShop.android.lib.R.string.history_item_was_removed, new Object[] {
            mItemTitle
        }));
        mItemRowGroup.setVisibility(8);
        mUndoGroup.setVisibility(0);
    }

    public void update(ObjectSubscriberAdapter objectsubscriberadapter, Object obj, byte abyte0[], int i)
    {
        objectsubscriberadapter = (SearchResult)obj;
        com.amazon.rio.j2me.client.services.mShop.BasicOfferListing basicofferlisting = objectsubscriberadapter.getBasicOffer();
        BasicProductInfo basicproductinfo = objectsubscriberadapter.getBasicProduct();
        if (basicproductinfo != null)
        {
            setImageRequester(obj);
            String s = ImageUtil.getImageUrl(basicproductinfo.getImageUrl(), getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.item_row_height));
            obj = (Bitmap)LRUCache.getValue(s, android/graphics/Bitmap);
            objectsubscriberadapter = null;
            if (obj != null)
            {
                objectsubscriberadapter = new com.amazon.mShop.net.BitmapFetcher.BitmapFetcherParams(s, null);
                objectsubscriberadapter = DrawableFactory.getInstance().createDrawable(getResources(), ((Bitmap) (obj)), objectsubscriberadapter);
            }
            ItemViewUtils.updateImageWithDrawable(objectsubscriberadapter, mItemRowImage);
            if (objectsubscriberadapter == null && abyte0 == null && !Util.isEmpty(basicproductinfo.getImageUrl()))
            {
                getImageFromBackground(basicproductinfo.getImageUrl());
            }
            mItemTitle = basicproductinfo.getTitle();
            updateItemView(i, basicofferlisting, basicproductinfo);
            if (getTag() != null)
            {
                objectsubscriberadapter = (TextView)findViewById(com.amazon.mShop.android.lib.R.id.history_viewed_time);
                obj = (Date)getTag();
                objectsubscriberadapter.setText((new SimpleDateFormat(getResources().getString(com.amazon.mShop.android.lib.R.string.history_time_format))).format(((Date) (obj))));
                return;
            }
        }
    }


}
