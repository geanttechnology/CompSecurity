// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.widget;


// Referenced classes of package it.sephiroth.android.library.widget:
//            AbsHListView

class this._cls0
    implements Runnable
{

    final AbsHListView this$0;

    public void run()
    {
        if (mCachingStarted)
        {
            AbsHListView abshlistview = AbsHListView.this;
            mCachingActive = false;
            abshlistview.mCachingStarted = false;
            AbsHListView.access$2000(AbsHListView.this, false);
            if ((getPersistentDrawingCache() & 2) == 0)
            {
                AbsHListView.access$2100(AbsHListView.this, false);
            }
            if (!isAlwaysDrawnWithCacheEnabled())
            {
                invalidate();
            }
        }
    }

    ()
    {
        this$0 = AbsHListView.this;
        super();
    }
}
