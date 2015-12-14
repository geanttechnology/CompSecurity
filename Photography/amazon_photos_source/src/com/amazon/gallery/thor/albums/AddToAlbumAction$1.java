// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import android.content.Context;
import com.amazon.gallery.foundation.utils.async.BlockingProgressDialog;
import com.amazon.gallery.framework.data.dao.SortOrder;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.model.tags.TagType;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.gallery.thor.albums:
//            AddToAlbumAction

class ProgressDialog extends BlockingProgressDialog
{

    final AddToAlbumAction this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient List doInBackground(Void avoid[])
    {
        return new ArrayList(AddToAlbumAction.access$000(AddToAlbumAction.this).getTagsByType(TagType.ALBUM, new SortOrder("label", com.amazon.gallery.framework.data.dao.ASE_ASC)));
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((List)obj);
    }

    protected void onPostExecute(List list)
    {
        super.onPostExecute(list);
        onAlbumsEnumerated(list);
    }

    der(Context context, int i, boolean flag)
    {
        this$0 = AddToAlbumAction.this;
        super(context, i, flag);
    }
}
