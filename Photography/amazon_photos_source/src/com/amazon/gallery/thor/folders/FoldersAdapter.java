// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.folders;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.AsyncTask;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.sqlite.SQLiteDaoUtil;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.gallery.cab.SelectionChecker;
import com.amazon.gallery.framework.kindle.recyclerview.TrackSelectionAdapter;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.mixtape.utils.IdUtils;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.amazon.gallery.thor.folders:
//            FolderPathLoader, FolderToAlbumMapper

public class FoldersAdapter extends TrackSelectionAdapter
{
    private static class BannerHolder extends android.support.v7.widget.RecyclerView.ViewHolder
    {

        public BannerHolder(View view)
        {
            super(view);
            ((TextView)view.findViewById(0x7f0c0152)).setText(0x7f0e01b8);
        }
    }

    private class GetFolderDataTask extends AsyncTask
    {

        final FoldersAdapter this$0;
        private final ViewHolder viewHolder;

        protected transient Pair doInBackground(Tag atag[])
        {
            atag = atag[0];
            ObjectID objectid = atag.getObjectId();
            int i = mediaItemDao.getMediaItemCount(atag);
            folderItemCountCache.put(objectid, Integer.valueOf(i));
            atag = IdUtils.objectIdToNodeId(objectid.getMostSignificantBits(), objectid.getLeastSignificantBits());
            if (!folderPathLoader.isPathAvailable(atag))
            {
                folderPathLoader.addFolder(atag);
            }
            return new Pair(Integer.valueOf(i), folderPathLoader.getPath(atag));
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Tag[])aobj);
        }

        protected void onPostExecute(Pair pair)
        {
            viewHolder.setItemCount(((Integer)pair.first).intValue());
            viewHolder.setFolderPath((String)pair.second);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Pair)obj);
        }

        public GetFolderDataTask(ViewHolder viewholder)
        {
            this$0 = FoldersAdapter.this;
            super();
            viewHolder = viewholder;
        }
    }

    public static class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder
    {

        public TextView countView;
        private AnimatorListenerAdapter hideAnimator;
        public ImageView iconSelectedBackground;
        public ImageView iconSelectedView;
        public ImageView iconView;
        public Button makeAlbumButton;
        public TextView pathView;
        private final String pluralString;
        private AnimatorListenerAdapter showAnimator;
        private final String singularString;
        public TextView titleView;

        public void setFolderPath(String s)
        {
            pathView.setText(s);
        }

        public void setItemCount(int i)
        {
            TextView textview = countView;
            String s;
            if (i > 1)
            {
                s = pluralString;
            } else
            {
                s = singularString;
            }
            textview.setText(String.format(s, new Object[] {
                Integer.valueOf(i)
            }));
        }

        public void setItemSelected(boolean flag)
        {
            if (flag)
            {
                iconSelectedView.setVisibility(0);
                iconView.setVisibility(8);
                return;
            } else
            {
                iconView.setVisibility(0);
                iconSelectedView.setVisibility(8);
                return;
            }
        }

        public void toggleSelectionMode(boolean flag, boolean flag1)
        {
            Button button = makeAlbumButton;
            byte byte0;
            if (flag || flag1)
            {
                byte0 = 4;
            } else
            {
                byte0 = 0;
            }
            button.setVisibility(byte0);
            if (flag && flag1)
            {
                itemView.setBackgroundColor(itemView.getResources().getColor(0x7f09007b));
            } else
            {
                itemView.setBackgroundColor(itemView.getResources().getColor(0x7f0900ab));
            }
            if (flag)
            {
                iconSelectedBackground.animate().scaleX(1.0F).scaleY(1.0F).setDuration(150L).setListener(showAnimator);
            } else
            if (iconSelectedBackground.getVisibility() == 0)
            {
                iconSelectedBackground.animate().scaleX(0.0F).scaleY(0.0F).setDuration(150L).setListener(hideAnimator);
                return;
            }
        }

        public ViewHolder(View view)
        {
            super(view);
            hideAnimator = new _cls1();
            showAnimator = new _cls2();
            Context context = view.getContext();
            singularString = context.getString(0x7f0e01be);
            pluralString = context.getString(0x7f0e01bd);
            iconView = (ImageView)view.findViewById(0x7f0c0143);
            iconSelectedView = (ImageView)view.findViewById(0x7f0c0144);
            iconSelectedBackground = (ImageView)view.findViewById(0x7f0c0142);
            titleView = (TextView)view.findViewById(0x7f0c0145);
            countView = (TextView)view.findViewById(0x7f0c0147);
            pathView = (TextView)view.findViewById(0x7f0c0148);
            makeAlbumButton = (Button)view.findViewById(0x7f0c0146);
        }
    }

    private static final class ViewType extends Enum
    {

        private static final ViewType $VALUES[];
        public static final ViewType BANNER;
        public static final ViewType ITEM;

        public static ViewType valueOf(String s)
        {
            return (ViewType)Enum.valueOf(com/amazon/gallery/thor/folders/FoldersAdapter$ViewType, s);
        }

        public static ViewType[] values()
        {
            return (ViewType[])$VALUES.clone();
        }

        static 
        {
            BANNER = new ViewType("BANNER", 0);
            ITEM = new ViewType("ITEM", 1);
            $VALUES = (new ViewType[] {
                BANNER, ITEM
            });
        }

        private ViewType(String s, int i)
        {
            super(s, i);
        }
    }


    private Cursor cursor;
    private Map folderItemCountCache;
    private FolderPathLoader folderPathLoader;
    private FolderToAlbumMapper folderToAlbumMapper;
    private final MediaItemDao mediaItemDao;
    private android.view.View.OnClickListener onButtonClickListener;
    private android.view.View.OnClickListener onClickListener;
    private android.view.View.OnLongClickListener onLongClickListener;
    private String pathPlaceholderString;
    private boolean selectedMode;
    private final SelectionChecker selectionChecker;
    private final TagDao tagDao;

    public FoldersAdapter(Context context, TagDao tagdao, MediaItemDao mediaitemdao, FolderToAlbumMapper foldertoalbummapper, SelectionChecker selectionchecker, String s)
    {
        selectedMode = false;
        tagDao = tagdao;
        mediaItemDao = mediaitemdao;
        folderToAlbumMapper = foldertoalbummapper;
        selectionChecker = selectionchecker;
        folderPathLoader = new FolderPathLoader(context, s);
        folderItemCountCache = new HashMap();
        pathPlaceholderString = context.getString(0x7f0e01bc);
    }

    private int getAdjustedPosition(int i)
    {
        return i - 1;
    }

    private int getFolderItemCount(ObjectID objectid)
    {
        if (folderItemCountCache.containsKey(objectid))
        {
            return ((Integer)folderItemCountCache.get(objectid)).intValue();
        } else
        {
            return 0;
        }
    }

    private String getFolderPath(ObjectID objectid)
    {
        objectid = IdUtils.objectIdToNodeId(objectid.getMostSignificantBits(), objectid.getLeastSignificantBits());
        if (folderPathLoader.isPathAvailable(objectid))
        {
            return folderPathLoader.getPath(objectid);
        } else
        {
            return pathPlaceholderString;
        }
    }

    public Tag getFolderForPosition(int i)
    {
        if (cursor == null || i < 0 || i > getItemCount())
        {
            throw new IllegalStateException("Trying to get item for invalid position");
        } else
        {
            cursor.moveToPosition(getAdjustedPosition(i));
            return SQLiteDaoUtil.itemFromCursor(cursor, tagDao);
        }
    }

    public int getItemCount()
    {
        if (cursor != null)
        {
            return cursor.getCount() + 1;
        } else
        {
            return 1;
        }
    }

    public int getItemViewType(int i)
    {
        if (i == 0)
        {
            return ViewType.BANNER.ordinal();
        } else
        {
            return ViewType.ITEM.ordinal();
        }
    }

    public void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        ViewHolder viewholder1;
        Tag tag;
        ObjectID objectid;
label0:
        {
            while (cursor == null || getItemViewType(i) != ViewType.ITEM.ordinal()) 
            {
                return;
            }
            viewholder1 = (ViewHolder)viewholder;
            cursor.moveToPosition(getAdjustedPosition(i));
            tag = SQLiteDaoUtil.itemFromCursor(cursor, tagDao);
            objectid = tag.getObjectId();
            boolean flag = folderToAlbumMapper.contains(objectid);
            viewholder1.toggleSelectionMode(selectedMode, flag);
            viewholder1.setItemSelected(selectionChecker.isSelected(tag));
            String s = tag.getLabel();
            if (s != null)
            {
                viewholder = s;
                if (!s.isEmpty())
                {
                    break label0;
                }
            }
            viewholder = viewholder1.titleView.getContext().getString(0x7f0e009a);
        }
        viewholder1.titleView.setText(viewholder);
        viewholder1.setItemCount(getFolderItemCount(objectid));
        viewholder1.setFolderPath(getFolderPath(objectid));
        (new GetFolderDataTask(viewholder1)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Tag[] {
            tag
        });
    }

    public android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        if (getItemViewType(i) == ViewType.BANNER.ordinal())
        {
            return new BannerHolder(LayoutInflater.from(viewgroup.getContext()).inflate(0x7f030091, viewgroup, false));
        } else
        {
            viewgroup = new ViewHolder(LayoutInflater.from(viewgroup.getContext()).inflate(0x7f03008c, viewgroup, false));
            ((ViewHolder) (viewgroup)).itemView.setOnClickListener(onClickListener);
            ((ViewHolder) (viewgroup)).itemView.setOnLongClickListener(onLongClickListener);
            ((ViewHolder) (viewgroup)).makeAlbumButton.setOnClickListener(onButtonClickListener);
            return viewgroup;
        }
    }

    public void setOnButtonClickListener(android.view.View.OnClickListener onclicklistener)
    {
        onButtonClickListener = onclicklistener;
    }

    public void setOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        onClickListener = onclicklistener;
    }

    public void setOnLongClickListener(android.view.View.OnLongClickListener onlongclicklistener)
    {
        onLongClickListener = onlongclicklistener;
    }

    public void setSelectedMode(boolean flag)
    {
        selectedMode = flag;
        notifyDataSetChanged();
    }

    public void updateCursor(Cursor cursor1)
    {
        cursor = cursor1;
        notifyDataSetChanged();
    }




    // Unreferenced inner class com/amazon/gallery/thor/folders/FoldersAdapter$ViewHolder$1

/* anonymous class */
    class ViewHolder._cls1 extends AnimatorListenerAdapter
    {

        final ViewHolder this$0;

        public void onAnimationEnd(Animator animator)
        {
            iconSelectedBackground.setVisibility(8);
        }

            
            {
                this$0 = ViewHolder.this;
                super();
            }
    }


    // Unreferenced inner class com/amazon/gallery/thor/folders/FoldersAdapter$ViewHolder$2

/* anonymous class */
    class ViewHolder._cls2 extends AnimatorListenerAdapter
    {

        final ViewHolder this$0;

        public void onAnimationStart(Animator animator)
        {
            iconSelectedBackground.setVisibility(0);
        }

            
            {
                this$0 = ViewHolder.this;
                super();
            }
    }

}
