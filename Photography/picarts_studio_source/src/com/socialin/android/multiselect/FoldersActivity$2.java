// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.multiselect;

import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;

// Referenced classes of package com.socialin.android.multiselect:
//            FoldersActivity

final class a
    implements android.app.erCallbacks
{

    private FoldersActivity a;

    public final Loader onCreateLoader(int i, Bundle bundle)
    {
        return FoldersActivity.a(a, i);
    }

    public final void onLoadFinished(Loader loader, Object obj)
    {
        loader = (Cursor)obj;
        FoldersActivity.a(a, loader);
    }

    public final void onLoaderReset(Loader loader)
    {
    }

    (FoldersActivity foldersactivity)
    {
        a = foldersactivity;
        super();
    }
}
