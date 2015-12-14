// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.activity.link.model;

import bio;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import java.util.Iterator;
import java.util.List;

public class TPhotoLinkComposeInfo extends TPhotoComposeInfo
{

    public List bodyInfoArray;
    public bio footerInfo;
    public bio headerInfo;
    public boolean isLinkInfo;

    public TPhotoLinkComposeInfo()
    {
        isLinkInfo = true;
    }

    public boolean hasMultiColumns()
    {
label0:
        {
            if (headerInfo != null && headerInfo.b())
            {
                return true;
            }
            if (footerInfo != null && footerInfo.b())
            {
                return true;
            }
            if (bodyInfoArray == null || bodyInfoArray.size() <= 0)
            {
                break label0;
            }
            Iterator iterator = bodyInfoArray.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
            } while (!((bio)iterator.next()).b());
            return true;
        }
        return false;
    }
}
