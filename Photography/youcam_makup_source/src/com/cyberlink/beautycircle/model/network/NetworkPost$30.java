// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import android.net.Uri;
import com.cyberlink.beautycircle.model.BCTileImage;
import com.cyberlink.beautycircle.model.PostPhoto;
import com.perfectcorp.utility.j;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkPost, d

final class  extends j
{

    protected BCTileImage a(String s)
    {
        Object obj = null;
        d d1 = new d(com/cyberlink/beautycircle/model/PostPhoto, s);
        s = obj;
        if (d1 != null)
        {
            s = obj;
            if (d1.b != null)
            {
                s = obj;
                if (d1.b.size() > 0)
                {
                    s = new BCTileImage();
                    s.imageList = new ArrayList();
                    Iterator iterator = d1.b.iterator();
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        PostPhoto postphoto = (PostPhoto)iterator.next();
                        if (postphoto != null)
                        {
                            ((BCTileImage) (s)).imageList.add(postphoto.originalUrl.toString());
                        }
                    } while (true);
                }
            }
        }
        return s;
    }

    protected volatile Object a(Object obj)
    {
        return a((String)obj);
    }

    ()
    {
    }
}
