// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model;

import android.content.SharedPreferences;
import android.net.Uri;
import com.cyberlink.beautycircle.Globals;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.beautycircle.model:
//            BCTileImage, Post

final class a extends j
{

    final ArrayList a;

    protected volatile Object a(Object obj)
    {
        return a((Void)obj);
    }

    protected Void a(Void void1)
    {
        Iterator iterator;
        void1 = new BCTileImage();
        void1.imageList = new ArrayList();
        iterator = a.iterator();
_L4:
        Uri uri;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        uri = BCTileImage.c((Post)iterator.next());
        if (uri != null) goto _L2; else goto _L1
_L1:
        try
        {
            e.b(new Object[] {
                "Can't find photo."
            });
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            void1.printStackTrace();
        }
_L5:
        return null;
_L2:
        ((BCTileImage) (void1)).imageList.add(uri.toString());
        if (((BCTileImage) (void1)).imageList.size() <= 5) goto _L4; else goto _L3
_L3:
        Globals.D().edit().putString("KEY_BC_TILE_IAMGE_FROM_DISCOVER", void1.toString()).commit();
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
    }

    (ArrayList arraylist)
    {
        a = arraylist;
        super();
    }
}
