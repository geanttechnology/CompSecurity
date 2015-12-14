// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.ftue;

import android.view.View;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.thor.albums.CreateAlbumHelper;
import com.amazon.gallery.thor.app.ThorGalleryApplication;

// Referenced classes of package com.amazon.gallery.framework.kindle.ftue:
//            NoAlbumsFragment

class this._cls0
    implements android.view.r
{

    final NoAlbumsFragment this$0;

    public void onClick(View view)
    {
        view = new ComponentProfiler((Profiler)ThorGalleryApplication.getBean(Keys.PROFILER), "AlbumsMetrics");
        (new CreateAlbumHelper((BeanAwareActivity)getActivity(), view)).execute();
    }

    A()
    {
        this$0 = NoAlbumsFragment.this;
        super();
    }
}
