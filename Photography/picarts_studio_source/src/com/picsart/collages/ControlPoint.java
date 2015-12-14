// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.collages;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.picsart.collages:
//            ControlItem

public class ControlPoint
    implements Serializable
{

    public ArrayList controlItems;

    public ControlPoint()
    {
        controlItems = new ArrayList();
    }

    public ControlPoint(String s)
    {
        controlItems = new ArrayList();
        s = s.split(" ");
        for (int i = 0; i < s.length; i++)
        {
            String as[] = s[i].split(",");
            ControlItem controlitem = new ControlItem();
            controlitem.cellIndex = Integer.parseInt(as[0]);
            controlitem.verticeIndex = Integer.parseInt(as[1]);
            controlitem.rule = as[2];
            controlItems.add(controlitem);
        }

    }

    public void rotateControlPointLeft(int i)
    {
        Iterator iterator = controlItems.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ControlItem controlitem = (ControlItem)iterator.next();
            controlitem.verticeIndex = controlitem.verticeIndex - 1;
            if (controlitem.verticeIndex < 0)
            {
                controlitem.verticeIndex = i - 1;
            }
        } while (true);
    }

    public void rotateControlPointRight(int i)
    {
        for (Iterator iterator = controlItems.iterator(); iterator.hasNext();)
        {
            ControlItem controlitem = (ControlItem)iterator.next();
            controlitem.verticeIndex = (controlitem.verticeIndex + 1) % i;
        }

    }
}
