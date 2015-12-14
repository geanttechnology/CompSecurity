// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.cms;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import java.io.File;

// Referenced classes of package com.amazon.gallery.framework.kindle.cms:
//            CMSAsyncTaskRunner

public class CMSImageStore
{

    private static final android.graphics.Bitmap.CompressFormat COMPRESS_FORMAT;
    private static final File FILE_DEV_NULL = new File("/dev/null");
    private static final String TAG = com/amazon/gallery/framework/kindle/cms/CMSImageStore.getName();
    private int cmsFullFrameHeight;
    private Rect cmsFullFrameRect;
    private int cmsFullFrameWidth;
    private int cmsFullImageLeftRightPadding;
    private int cmsFullImageTextSize;
    private int cmsFullImageTopBottomPadding;
    private Rect cmsFullInnerImageRect;
    private Rect cmsFullTextBgRect;
    private Rect cmsFullTextRect;
    private int cmsThumbFrameHeight;
    private Rect cmsThumbFrameRect;
    private int cmsThumbFrameWidth;
    private Rect cmsThumbInnerImageRect;
    private File storeFolder;
    private CMSAsyncTaskRunner taskRunner;

    public CMSImageStore()
    {
    }

    private void ensureFolderExists(File file)
    {
        if (!file.exists())
        {
            file.mkdir();
        } else
        if (!file.isDirectory())
        {
            file.delete();
            file.mkdir();
            return;
        }
    }

    private void ensureFolderPermissions(File file)
    {
        file.setExecutable(true, false);
        file.setReadable(true, true);
        file.setWritable(true, true);
    }

    public void initWithContext(Context context)
    {
        Resources resources = context.getResources();
        cmsFullFrameWidth = (int)resources.getDimension(0x7f0a000f);
        cmsFullFrameHeight = (int)resources.getDimension(0x7f0a000e);
        cmsThumbFrameWidth = (int)resources.getDimension(0x7f0a0021);
        cmsThumbFrameHeight = (int)resources.getDimension(0x7f0a0020);
        cmsFullImageTextSize = (int)resources.getDimension(0x7f0a0010);
        cmsFullImageTopBottomPadding = (int)resources.getDimension(0x7f0a0012);
        cmsFullImageLeftRightPadding = (int)resources.getDimension(0x7f0a0011);
        int i = (int)resources.getDimension(0x7f0a0016);
        int j = (int)resources.getDimension(0x7f0a0014);
        int k = (int)resources.getDimension(0x7f0a0013);
        int l = (int)resources.getDimension(0x7f0a0015);
        int i1 = (int)resources.getDimension(0x7f0a001f);
        int j1 = (int)resources.getDimension(0x7f0a001d);
        int k1 = (int)resources.getDimension(0x7f0a001c);
        int l1 = (int)resources.getDimension(0x7f0a001e);
        cmsFullFrameRect = new Rect(0, 0, cmsFullFrameWidth, cmsFullFrameHeight);
        cmsThumbFrameRect = new Rect(0, 0, cmsThumbFrameWidth, cmsThumbFrameHeight);
        cmsFullInnerImageRect = new Rect(j, i, l, k);
        cmsThumbInnerImageRect = new Rect(j1, i1, l1, k1);
        cmsFullTextBgRect = new Rect(cmsFullInnerImageRect.left, cmsFullInnerImageRect.bottom - (cmsFullImageTopBottomPadding * 2 + cmsFullImageTextSize), cmsFullInnerImageRect.right, cmsFullInnerImageRect.bottom);
        cmsFullTextRect = new Rect(cmsFullTextBgRect.left + cmsFullImageLeftRightPadding, cmsFullTextBgRect.top + cmsFullImageTopBottomPadding, cmsFullTextBgRect.right - cmsFullImageLeftRightPadding, cmsFullTextBgRect.bottom - cmsFullImageTopBottomPadding);
        storeFolder = new File(context.getFilesDir(), "cmsimages");
        ensureFolderExists(storeFolder);
        ensureFolderPermissions(storeFolder);
    }

    public void setAsyncTaskRunner(CMSAsyncTaskRunner cmsasynctaskrunner)
    {
        taskRunner = cmsasynctaskrunner;
    }

    static 
    {
        COMPRESS_FORMAT = android.graphics.Bitmap.CompressFormat.PNG;
    }
}
