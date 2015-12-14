// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.link.model;

import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import java.util.Iterator;
import java.util.List;
import qu;

public class TPhotoLinkComposeInfo extends TPhotoComposeInfo
{

    public List bodyInfoArray;
    public qu footerInfo;
    public qu headerInfo;
    public boolean isLinkInfo;

    public TPhotoLinkComposeInfo()
    {
        isLinkInfo = true;
    }

    public boolean hasMultiColumns()
    {
label0:
        {
            if (headerInfo != null && headerInfo.a())
            {
                return true;
            }
            if (footerInfo != null && footerInfo.a())
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
            } while (!((qu)iterator.next()).a());
            return true;
        }
        return false;
    }
}
