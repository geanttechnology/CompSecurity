// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.text.format.Formatter;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.data.messaging.TagAutoSaveChangedEvent;
import com.amazon.gallery.framework.gallery.widget.holder.ItemViewHolder;
import com.amazon.gallery.framework.model.Persistable;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagProperty;
import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import com.bumptech.glide.GenericRequestBuilder;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget:
//            GridItemViewFactory, FolderSettingsViewHolder, AbstractCoverViewFactory

public class FolderSettingsViewFactory extends GridItemViewFactory
{
    private static class FolderListViewFactory extends AbstractCoverViewFactory
    {

        public volatile ItemViewHolder createViewHolder(Persistable persistable, View view)
        {
            return createViewHolder((Tag)persistable, view);
        }

        public ItemViewHolder createViewHolder(Tag tag, View view)
        {
            return new FolderSettingsViewHolder(tag, view);
        }

        protected FolderListViewFactory()
        {
            super(0x7f03008d);
        }
    }

    private static class TagSizeInfo
    {

        private final int mediaItemCount;
        private final long tagSizeInBytes;

        public int getMediaItemCount()
        {
            return mediaItemCount;
        }

        public long getTagSizeInBytes()
        {
            return tagSizeInBytes;
        }

        public TagSizeInfo(int i, long l)
        {
            mediaItemCount = i;
            tagSizeInBytes = l;
        }
    }


    private static final String TAG = com/amazon/gallery/framework/gallery/widget/FolderSettingsViewFactory.getName();
    private String formatStringPlural;
    private String formatStringSingular;
    private int lockedStyle;
    private final MediaItemDao mediaItemDao;
    private int regularStyle;
    private final TagDao tagDao;
    private Map tagSizeInfoMap;

    public FolderSettingsViewFactory(Context context, TagDao tagdao, MediaItemDao mediaitemdao)
    {
        super(context, new FolderListViewFactory(), mediaitemdao);
        tagDao = tagdao;
        mediaItemDao = mediaitemdao;
        tagSizeInfoMap = new HashMap();
    }

    private String getSubtitleText(TagSizeInfo tagsizeinfo)
    {
        String s;
        if (tagsizeinfo.getMediaItemCount() == 1)
        {
            s = formatStringSingular;
        } else
        {
            s = formatStringPlural;
        }
        return String.format(s, new Object[] {
            Formatter.formatShortFileSize(context, tagsizeinfo.getTagSizeInBytes()), Integer.valueOf(tagsizeinfo.getMediaItemCount())
        });
    }

    private void hookUpListener(FolderSettingsViewHolder foldersettingsviewholder, final Tag tag)
    {
        foldersettingsviewholder.checkbox.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final FolderSettingsViewFactory this$0;
            final Tag val$tag;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (flag != tag.hasProperty(TagProperty.AUTO_SAVE))
                {
                    compoundbutton = new TagAutoSaveChangedEvent();
                    if (flag)
                    {
                        tag.setProperty(TagProperty.AUTO_SAVE);
                    } else
                    {
                        tag.setProperty(TagProperty.NO_AUTO_SAVE);
                        compoundbutton.setPostRunnable(new Runnable() {

                            final _cls1 this$1;

                            public void run()
                            {
                                tagDao.removeTemporarySyncStates(tag, true, true, true);
                            }

            
            {
                this$1 = _cls1.this;
                super();
            }
                        });
                    }
                    tagDao.save(tag, true);
                    GlobalMessagingBus.post(compoundbutton);
                }
            }

            
            {
                this$0 = FolderSettingsViewFactory.this;
                tag = tag1;
                super();
            }
        });
        if (tag.getLocalMetaField("locked") != null)
        {
            foldersettingsviewholder.textView.setTextAppearance(context, lockedStyle);
            return;
        } else
        {
            foldersettingsviewholder.textView.setTextAppearance(context, regularStyle);
            return;
        }
    }

    public volatile View getView(int i, Persistable persistable, View view)
    {
        return getView(i, (Tag)persistable, view);
    }

    public View getView(int i, final Tag tag, final View finalHolder)
    {
        FolderSettingsViewHolder foldersettingsviewholder = null;
        if (finalHolder != null)
        {
            FolderSettingsViewHolder foldersettingsviewholder1 = (FolderSettingsViewHolder)finalHolder.getTag();
            foldersettingsviewholder = foldersettingsviewholder1;
            if (!sameItem((Tag)foldersettingsviewholder1.getItem(), tag))
            {
                hookUpListener(foldersettingsviewholder1, tag);
                foldersettingsviewholder = foldersettingsviewholder1;
            }
        }
        View view = super.getView(i, tag, finalHolder);
        finalHolder = foldersettingsviewholder;
        if (foldersettingsviewholder == null)
        {
            finalHolder = (FolderSettingsViewHolder)view.getTag();
            finalHolder.subtitleText = (TextView)view.findViewById(0x7f0c014c);
            finalHolder.checkbox = (CheckBox)view.findViewById(0x7f0c014a);
            hookUpListener(finalHolder, tag);
        }
        if (tagSizeInfoMap.containsKey(tag.getObjectId()))
        {
            String s = getSubtitleText((TagSizeInfo)tagSizeInfoMap.get(tag.getObjectId()));
            ((FolderSettingsViewHolder) (finalHolder)).subtitleText.setText(s);
        } else
        {
            ((FolderSettingsViewHolder) (finalHolder)).subtitleText.setText("");
        }
        (new AsyncTask() {

            final FolderSettingsViewFactory this$0;
            final FolderSettingsViewHolder val$finalHolder;
            final Tag val$tag;

            protected transient TagSizeInfo doInBackground(Void avoid[])
            {
                return new TagSizeInfo(mediaItemDao.getMediaItemCount(tag), mediaItemDao.getMediaItemSizeForTag(tag));
            }

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected void onPostExecute(TagSizeInfo tagsizeinfo)
            {
                if (BuildFlavors.isDebug() && tagsizeinfo == null)
                {
                    GLogger.ex(FolderSettingsViewFactory.TAG, "TagSizeInfo is null, expected non-null value", new InvalidParameterException());
                    return;
                } else
                {
                    finalHolder.subtitleText.setText(getSubtitleText(tagsizeinfo));
                    tagSizeInfoMap.put(tag.getObjectId(), tagsizeinfo);
                    return;
                }
            }

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((TagSizeInfo)obj);
            }

            
            {
                this$0 = FolderSettingsViewFactory.this;
                tag = tag1;
                finalHolder = foldersettingsviewholder;
                super();
            }
        }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        ((FolderSettingsViewHolder) (finalHolder)).checkbox.setChecked(tag.hasProperty(TagProperty.AUTO_SAVE));
        return view;
    }

    public volatile View getView(int i, Object obj, View view)
    {
        return getView(i, (Tag)obj, view);
    }

    public volatile void overrideSizeToGlideBuilder(int i, Persistable persistable, GenericRequestBuilder genericrequestbuilder)
    {
        overrideSizeToGlideBuilder(i, (Tag)persistable, genericrequestbuilder);
    }

    public void overrideSizeToGlideBuilder(int i, Tag tag, GenericRequestBuilder genericrequestbuilder)
    {
        genericrequestbuilder.override(128, 128);
    }

    public void setContext(Context context)
    {
        super.setContext(context);
        formatStringPlural = context.getResources().getString(0x7f0e00e0);
        formatStringSingular = context.getResources().getString(0x7f0e00e1);
    }

    public void setLockedStyle(int i)
    {
        lockedStyle = i;
    }

    public void setRegularStyle(int i)
    {
        regularStyle = i;
    }






}
