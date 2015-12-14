// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.app.Activity;
import android.os.AsyncTask;
import android.preference.Preference;
import com.amazon.gallery.foundation.utils.di.BeanAwareApplication;
import com.amazon.gallery.foundation.utils.di.BeanFactory;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.data.messaging.TagAutoSaveChangedEvent;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.model.media.MediaType;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            SettingsFragment

class this._cls2 extends AsyncTask
{

    final States this$2;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        boolean flag1 = true;
        avoid = tagDao;
        boolean flag;
        if (!autoUploadEnabledForPhotos)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (autoUploadEnabledForVideos)
        {
            flag1 = false;
        }
        avoid.removeTemporarySyncStates(flag, flag1);
        return null;
    }

    PreferenceChangeListener()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/amazon/gallery/framework/kindle/fragment/SettingsFragment$1

/* anonymous class */
    class SettingsFragment._cls1 extends SettingsFragment.SwitchPreferenceChangeListener
    {

        final SettingsFragment this$0;

        protected boolean switchPreferenceChanged(Preference preference, boolean flag)
        {
            final boolean autoUploadEnabledForPhotos = flag;
            TagAutoSaveChangedEvent tagautosavechangedevent;
            final TagDao tagDao;
            boolean flag1;
            if (preference.getKey().equals("auto_upload_photos_key"))
            {
                flag1 = autoUploadEnabledForPhotos | SettingsFragment.access$100(SettingsFragment.this);
                SettingsFragment.access$200(getActivity().getApplication(), SettingsFragment.AutoSaveSource.Settings, MediaType.PHOTO, flag);
            } else
            {
                flag1 = autoUploadEnabledForPhotos;
                if (preference.getKey().equals("auto_upload_videos_key"))
                {
                    flag1 = autoUploadEnabledForPhotos | SettingsFragment.access$300(SettingsFragment.this);
                    SettingsFragment.access$200(getActivity().getApplication(), SettingsFragment.AutoSaveSource.Settings, MediaType.VIDEO, flag);
                }
            }
            tagautosavechangedevent = new TagAutoSaveChangedEvent();
            tagDao = (TagDao)((BeanAwareApplication)getActivity().getApplication()).getBeanFactory().getBean(Keys.TAG_DAO);
            if (preference.getKey().equals("auto_upload_photos_key"))
            {
                autoUploadEnabledForPhotos = flag;
            } else
            {
                autoUploadEnabledForPhotos = SettingsFragment.access$300(SettingsFragment.this);
            }
            if (!preference.getKey().equals("auto_upload_videos_key"))
            {
                flag = SettingsFragment.access$100(SettingsFragment.this);
            }
            tagautosavechangedevent.setPostRunnable(flag. new SettingsFragment._cls1._cls1());
            GlobalMessagingBus.post(tagautosavechangedevent);
            SettingsFragment.access$400(SettingsFragment.this, flag1);
            return true;
        }

            
            {
                this$0 = SettingsFragment.this;
                super(SettingsFragment.this);
            }
    }


    // Unreferenced inner class com/amazon/gallery/framework/kindle/fragment/SettingsFragment$1$1

/* anonymous class */
    class SettingsFragment._cls1._cls1
        implements Runnable
    {

        final SettingsFragment._cls1 this$1;
        final boolean val$autoUploadEnabledForPhotos;
        final boolean val$autoUploadEnabledForVideos;
        final TagDao val$tagDao;

        public void run()
        {
            (new SettingsFragment._cls1._cls1._cls1()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }

            
            {
                this$1 = final__pcls1;
                tagDao = tagdao;
                autoUploadEnabledForPhotos = flag;
                autoUploadEnabledForVideos = Z.this;
                super();
            }
    }

}
