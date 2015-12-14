// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.instamag.activity.compose.MagComposeLinkFragement;
import com.wantu.activity.link.model.TMetaInfo;
import java.util.Comparator;

public class baz
    implements Comparator
{

    final MagComposeLinkFragement a;

    public baz(MagComposeLinkFragement magcomposelinkfragement)
    {
        a = magcomposelinkfragement;
        super();
    }

    public int compare(Object obj, Object obj1)
    {
        boolean flag = false;
        int i = ((flag) ? 1 : 0);
        if (obj instanceof bin)
        {
            i = ((flag) ? 1 : 0);
            if (obj1 instanceof bin)
            {
                obj = (bin)obj;
                obj1 = (bin)obj1;
                obj = ((bin) (obj)).b;
                obj1 = ((bin) (obj1)).b;
                i = ((flag) ? 1 : 0);
                if (obj != null)
                {
                    i = ((flag) ? 1 : 0);
                    if (obj1 != null)
                    {
                        if (((TMetaInfo) (obj)).getWidth() > ((TMetaInfo) (obj1)).getHeight())
                        {
                            i = 1;
                        } else
                        {
                            i = ((flag) ? 1 : 0);
                            if (((TMetaInfo) (obj)).getWidth() < ((TMetaInfo) (obj1)).getHeight())
                            {
                                return -1;
                            }
                        }
                    }
                }
            }
        }
        return i;
    }
}
