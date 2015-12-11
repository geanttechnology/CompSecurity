// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.app.Activity;
import com.bitstrips.imoji.analytics.Category;
import com.bitstrips.imoji.manager.TemplatesManager;
import com.bitstrips.imoji.models.Imoji;
import com.bitstrips.imoji.ui.tasks.GetImojiImageTask;
import java.io.File;
import java.util.List;

// Referenced classes of package com.bitstrips.imoji.ui:
//            ImojiBrowserActivity, ImageLoader

class  extends GetImojiImageTask
{

    final ImojiBrowserActivity this$0;

    protected void onPostExecute(File file)
    {
        Category category = Category.getCategoryFromString((String)imoji.getSupertags().get(0));
        ImojiBrowserActivity.access$300(ImojiBrowserActivity.this, file, imoji, category);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((File)obj);
    }

    (Activity activity, ImageLoader imageloader, TemplatesManager templatesmanager)
    {
        this$0 = ImojiBrowserActivity.this;
        super(activity, imageloader, templatesmanager);
    }
}
