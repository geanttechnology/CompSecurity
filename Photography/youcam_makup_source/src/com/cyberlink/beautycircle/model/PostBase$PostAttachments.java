// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model;

import com.perfectcorp.model.Model;
import java.util.ArrayList;
import java.util.Iterator;

public class looks extends Model
{

    public ArrayList files;
    public ArrayList looks;

    public boolean b()
    {
        return c() != null;
    }

    public le c()
    {
        if (files == null)
        {
            return null;
        }
        for (Iterator iterator = files.iterator(); iterator.hasNext();)
        {
            le le = (le)iterator.next();
            if (le.fileType.equals("Photo"))
            {
                return le;
            }
        }

        return null;
    }

    public le d()
    {
        le le = null;
        Object obj = null;
        if (files == null)
        {
            le = obj;
        } else
        {
            Iterator iterator = files.iterator();
            le le2 = null;
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                le le3 = (le)iterator.next();
                if (le3 != null && le3.fileType != null)
                {
                    if (le3.fileType.equals("PostCoverOri"))
                    {
                        return le3;
                    }
                    le le1 = le2;
                    if (le2 == null)
                    {
                        le1 = le2;
                        if (le3.fileType.equals("PostCover"))
                        {
                            le1 = le3;
                        }
                    }
                    if (le == null && le3.fileType.equals("Photo"))
                    {
                        le = le3;
                    }
                    le2 = le1;
                }
            } while (true);
            if (le2 != null)
            {
                return le2;
            }
        }
        return le;
    }

    public le()
    {
        files = null;
        looks = null;
    }
}
