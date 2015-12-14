// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker;

import android.os.AsyncTask;
import com.cyberlink.youcammakeup.activity.LibraryPickerActivityForIntent;
import com.cyberlink.youcammakeup.pages.librarypicker.albumpage.AlbumView;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker:
//            LibraryViewFragment

class a extends AsyncTask
{

    int a;
    final LibraryViewFragment b;

    protected transient Void a(Void avoid[])
    {
        avoid = (LibraryPickerActivityForIntent)b.getActivity();
_L2:
        if (avoid.q() || a >= 100)
        {
            break; /* Loop/switch isn't completed */
        }
        m.e("widgetpool.LibraryViewFragment", (new StringBuilder()).append("Wait !activity.IsSampleReady(), count=").append(a).toString());
        Thread.sleep(50L);
        a = a + 1;
        if (true) goto _L2; else goto _L1
        avoid;
        m.e("widgetpool.LibraryViewFragment", (new StringBuilder()).append("e=").append(avoid.toString()).toString());
_L1:
        return null;
    }

    protected void a(Void void1)
    {
        m.b("widgetpool.LibraryViewFragment", "Sample is ready, do init adapter");
        LibraryViewFragment.a(b).a(b.getActivity());
        LibraryViewFragment.a(b).a();
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Void)obj);
    }

    (LibraryViewFragment libraryviewfragment)
    {
        b = libraryviewfragment;
        super();
        a = 0;
    }
}
