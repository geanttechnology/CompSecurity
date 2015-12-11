// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.CursorAdapter;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.drawable.RecyclableBitmapDrawable;
import co.vine.android.provider.VineDatabaseHelper;
import co.vine.android.util.image.ImageKey;
import co.vine.android.util.image.UrlImage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// Referenced classes of package co.vine.android:
//            BaseCursorListFragment, ChannelsListActivity

public class ChannelsListFragment extends BaseCursorListFragment
    implements android.view.View.OnClickListener
{
    private class ChannelViewHolder
    {

        public long channelId;
        public ImageView channelImage;
        public ImageKey channelImageKey;
        public TextView channelTitle;
        final ChannelsListFragment this$0;

        public ChannelViewHolder(View view)
        {
            this$0 = ChannelsListFragment.this;
            super();
            channelImage = (ImageView)view.findViewById(0x7f0a0077);
            channelTitle = (TextView)view.findViewById(0x7f0a0078);
        }
    }

    private class ChannelsAdapter extends CursorAdapter
    {

        private final ArrayList mViewHolders = new ArrayList();
        final ChannelsListFragment this$0;

        private void setChannelImage(ChannelViewHolder channelviewholder, Bitmap bitmap)
        {
            if (bitmap != null)
            {
                channelviewholder.channelImage.setImageDrawable(new RecyclableBitmapDrawable(mContext.getResources(), bitmap));
                return;
            } else
            {
                channelviewholder.channelImage.setImageBitmap(null);
                channelviewholder.channelImage.setBackgroundColor(mContext.getResources().getColor(0x7f09007f));
                return;
            }
        }

        public void bindView(View view, Context context, Cursor cursor)
        {
            context = (ChannelViewHolder)view.getTag();
            ((ChannelViewHolder) (context)).channelTitle.setText(cursor.getString(2));
            context.channelId = cursor.getLong(1);
            if (((ChannelViewHolder) (context)).channelId == mSelectedChannel)
            {
                view.setBackgroundColor(getResources().getColor(0x7f090055));
            } else
            {
                view.setBackgroundColor(getResources().getColor(0x7f090083));
            }
            if (getResources().getDisplayMetrics().densityDpi < 240)
            {
                view = cursor.getString(8);
            } else
            {
                view = cursor.getString(9);
            }
            if (!TextUtils.isEmpty(view))
            {
                view = new ImageKey(view);
                context.channelImageKey = view;
                setChannelImage(context, mAppController.getPhotoBitmap(view));
                return;
            } else
            {
                setChannelImage(context, null);
                return;
            }
        }

        public View newView(Context context, Cursor cursor, ViewGroup viewgroup)
        {
            context = LayoutInflater.from(context).inflate(0x7f030023, viewgroup, false);
            cursor = new ChannelViewHolder(context);
            mViewHolders.add(new WeakReference(cursor));
            context.setTag(cursor);
            return context;
        }

        public void setChannelImages(HashMap hashmap)
        {
            this;
            JVM INSTR monitorenter ;
            Object obj;
            Iterator iterator;
            obj = new ArrayList();
            iterator = mViewHolders.iterator();
_L1:
            ChannelViewHolder channelviewholder;
            Object obj1;
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_109;
            }
            obj1 = (WeakReference)iterator.next();
            channelviewholder = (ChannelViewHolder)((WeakReference) (obj1)).get();
            if (channelviewholder != null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            ((ArrayList) (obj)).add(obj1);
              goto _L1
            hashmap;
            throw hashmap;
            obj1 = (UrlImage)hashmap.get(channelviewholder.channelImageKey);
            if (obj1 == null) goto _L1; else goto _L2
_L2:
            if (!((UrlImage) (obj1)).isValid()) goto _L1; else goto _L3
_L3:
            setChannelImage(channelviewholder, ((UrlImage) (obj1)).bitmap);
              goto _L1
            for (hashmap = ((ArrayList) (obj)).iterator(); hashmap.hasNext(); mViewHolders.remove(obj))
            {
                obj = (WeakReference)hashmap.next();
            }

            this;
            JVM INSTR monitorexit ;
        }

        public ChannelsAdapter(Context context, AppController appcontroller, int i)
        {
            this$0 = ChannelsListFragment.this;
            super(context, null, i);
            mAppController = appcontroller;
        }
    }

    public class ChannelsListSessionListener extends AppSessionListener
    {

        final ChannelsListFragment this$0;

        public void onPhotoImageLoaded(HashMap hashmap)
        {
            ((ChannelsAdapter)mCursorAdapter).setChannelImages(hashmap);
        }

        public ChannelsListSessionListener()
        {
            this$0 = ChannelsListFragment.this;
            super();
        }
    }


    public static final String ARG_SELECTED_CHANNEL = "selected_channel";
    private ChannelsListActivity mCallback;
    private VineDatabaseHelper mDbHelper;
    private boolean mFetched;
    private long mSelectedChannel;

    public ChannelsListFragment()
    {
    }

    private void fetchContent(int i)
    {
        if (hasPendingRequest(i))
        {
            return;
        }
        i;
        JVM INSTR tableswitch 1 2: default 32
    //                   1 59
    //                   2 54;
           goto _L1 _L2 _L3
_L1:
        int j = 1;
_L5:
        addRequest(mAppController.fetchChannels(j), i);
        mFetched = true;
        return;
_L3:
        j = 2;
        continue; /* Loop/switch isn't completed */
_L2:
        j = 3;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (mCursorAdapter == null)
        {
            mCursorAdapter = new ChannelsAdapter(getActivity(), mAppController, 0);
        }
        bundle = mListView;
        bundle.setBackgroundColor(getResources().getColor(0x7f090026));
        bundle.setAdapter(mCursorAdapter);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        mCallback = (ChannelsListActivity)activity;
        mDbHelper = VineDatabaseHelper.getDatabaseHelper(activity);
    }

    public void onClick(View view)
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mAppSessionListener = new ChannelsListSessionListener();
        mSelectedChannel = getArguments().getLong("selected_channel");
    }

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        return new CursorLoader(getActivity(), co.vine.android.provider.Vine.Channels.CONTENT_URI, co.vine.android.provider.VineDatabaseSQL.ChannelsQuery.PROJECTION, null, null, null);
    }

    public void onListItemClick(ListView listview, View view, int i, long l)
    {
        listview = mCursorAdapter.getCursor();
        if (listview != null && listview.moveToPosition(i))
        {
            l = listview.getLong(1);
            listview = listview.getString(2);
            mCallback.onChannelSelected(l, listview);
            mDbHelper.markChannelLastUsedTimestamp(l);
        }
    }

    public void onLoadFinished(Loader loader, Cursor cursor)
    {
label0:
        {
            super.onLoadFinished(loader, cursor);
            if (mFetched)
            {
                hideProgress(3);
                if (!mCursorAdapter.isEmpty())
                {
                    break label0;
                }
                showSadface(true);
            }
            return;
        }
        showSadface(false);
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (Cursor)obj);
    }

    public void onResume()
    {
        super.onResume();
        if (mCursorAdapter.getCursor() == null)
        {
            initLoader();
        }
        if (!mFetched)
        {
            fetchContent(3);
        }
    }

    protected void onScrollLastItem(Cursor cursor)
    {
        if (mRefreshable && cursor.getInt(7) == 0)
        {
            fetchContent(1);
        }
    }

}
