// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.aviary;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.foundation.utils.di.BeanFactory;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.sqlite.mediastore.MediaStoreHelper;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.action.EditMediaItemAction;
import java.io.File;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.amazon.gallery.thor.aviary:
//            ThorLaunchAviary

public class LaunchAviaryWrapperActivity extends BeanAwareActivity
{

    private static final String TAG = com/amazon/gallery/thor/aviary/LaunchAviaryWrapperActivity.getName();
    private MediaStoreHelper mediaStoreHelper;

    public LaunchAviaryWrapperActivity()
    {
        super(new BeanFactory() {

        });
    }

    protected File getFileFromContentUri(Uri uri)
    {
        Cursor cursor;
        Object obj;
        cursor = null;
        obj = null;
        Cursor cursor1 = getContentResolver().query(uri, new String[] {
            "_data"
        }, null, null, null);
        uri = obj;
        cursor = cursor1;
        if (!cursor1.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_68;
        }
        cursor = cursor1;
        uri = new File(cursor1.getString(cursor1.getColumnIndex("_data")));
        if (cursor1 != null && !cursor1.isClosed())
        {
            cursor1.close();
        }
        return uri;
        uri;
        if (cursor != null && !cursor.isClosed())
        {
            cursor.close();
        }
        throw uri;
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (i == 7 && j == -1)
        {
            if (StringUtils.equals(getIntent().getScheme(), "content"))
            {
                Object obj = intent.getData();
                if (obj == null)
                {
                    GLogger.w(TAG, "Result came back as OK but there was not data set - setting result to cancelled", new Object[0]);
                    setResult(0);
                } else
                {
                    obj = new File(((Uri) (obj)).getPath());
                    intent.setData(mediaStoreHelper.addEditedImageToMediaStore(this, getIntent().getData(), ((File) (obj))));
                    setResult(j, intent);
                }
            } else
            {
                GLogger.d(TAG, "Scheme was not set to content -> not returning mediastore uri", new Object[0]);
                setResult(j);
            }
        } else
        {
            GLogger.w(TAG, "Different request code came back - setting to cancelled", new Object[] {
                Integer.valueOf(i)
            });
            setResult(j);
        }
        finish();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mediaStoreHelper = (MediaStoreHelper)getApplicationBeanFactory().getBean(Keys.MEDIA_STORE_HELPER);
        ThorLaunchAviary thorlaunchaviary = new ThorLaunchAviary(this);
        Uri uri = getIntent().getData();
        if (StringUtils.equals(uri.getScheme(), "content"))
        {
            bundle = getFileFromContentUri(uri);
        } else
        {
            bundle = new File(uri.getPath());
        }
        if (bundle != null)
        {
            thorlaunchaviary.launch(this, uri, new File(bundle.getParentFile(), EditMediaItemAction.getEditedName(bundle.getName())), 7);
        }
    }

}
