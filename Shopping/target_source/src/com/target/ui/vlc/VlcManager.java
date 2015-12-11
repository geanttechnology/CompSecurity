// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.vlc;

import android.content.Context;
import com.target.ui.util.q;
import com.target.ui.vlc.model.VlcPositionInfo;
import com.target.ui.vlc.service.c;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

// Referenced classes of package com.target.ui.vlc:
//            c, d

public class VlcManager
    implements com.target.ui.vlc.c, com.target.ui.vlc.service.c.a
{

    private static String TAG = com/target/ui/vlc/VlcManager.getSimpleName();
    private Context mContext;
    private boolean mServiceConnected;
    private boolean mVlcEnabled;
    private final CopyOnWriteArrayList mVlcListeners = new CopyOnWriteArrayList();
    private c mVlcServiceConnection;

    public VlcManager(Context context)
    {
        mServiceConnected = false;
        mVlcEnabled = false;
        mContext = context;
    }

    public void a()
    {
        s();
        if (mVlcServiceConnection == null)
        {
            return;
        } else
        {
            mVlcServiceConnection.a(mContext);
            mVlcListeners.clear();
            return;
        }
    }

    public void a(com.target.ui.vlc.c c1)
    {
        mVlcListeners.add(c1);
        if (mVlcEnabled)
        {
            c1.q();
        }
    }

    public void a(d d1)
    {
        if (mServiceConnected)
        {
            try
            {
                mVlcEnabled = false;
                mVlcServiceConnection.a(d1);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (d d1)
            {
                com.target.ui.util.q.a(TAG, "Vlc service not connected");
            }
            return;
        } else
        {
            mVlcServiceConnection = new c(d1, this, this);
            mVlcServiceConnection.a(mContext, true);
            return;
        }
    }

    public void a(VlcPositionInfo vlcpositioninfo)
    {
        for (Iterator iterator = mVlcListeners.iterator(); iterator.hasNext(); ((com.target.ui.vlc.c)iterator.next()).a(vlcpositioninfo)) { }
    }

    public void b(com.target.ui.vlc.c c1)
    {
        mVlcListeners.remove(c1);
    }

    public boolean b()
    {
        return mServiceConnected;
    }

    public boolean c()
    {
        return mVlcEnabled;
    }

    public void d()
    {
        mServiceConnected = true;
    }

    public void e()
    {
        mServiceConnected = false;
    }

    public void p()
    {
        for (Iterator iterator = mVlcListeners.iterator(); iterator.hasNext(); ((com.target.ui.vlc.c)iterator.next()).p()) { }
    }

    public void q()
    {
        mVlcEnabled = true;
        for (Iterator iterator = mVlcListeners.iterator(); iterator.hasNext(); ((com.target.ui.vlc.c)iterator.next()).q()) { }
    }

    public void r()
    {
        mVlcEnabled = false;
        for (Iterator iterator = mVlcListeners.iterator(); iterator.hasNext(); ((com.target.ui.vlc.c)iterator.next()).r()) { }
    }

    public void s()
    {
        mVlcEnabled = false;
        for (Iterator iterator = mVlcListeners.iterator(); iterator.hasNext(); ((com.target.ui.vlc.c)iterator.next()).s()) { }
    }

}
