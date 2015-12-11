// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.renderers.vast.model;

import java.util.ArrayList;
import java.util.Iterator;
import tv.freewheel.hybrid.ad.interfaces.IConstants;
import tv.freewheel.hybrid.ad.interfaces.ISlot;

// Referenced classes of package tv.freewheel.hybrid.renderers.vast.model:
//            IVastValidation, AbstractCreativeRendition, CompanionAds, Companion

abstract class AbstractCreativeRenditionCollection
    implements IVastValidation
{

    AbstractCreativeRenditionCollection()
    {
    }

    protected ArrayList searchAll(ArrayList arraylist, ISlot islot, IConstants iconstants)
    {
        ArrayList arraylist1 = new ArrayList();
        if (arraylist != null && !arraylist.isEmpty())
        {
            arraylist = arraylist.iterator();
            while (arraylist.hasNext()) 
            {
                AbstractCreativeRendition abstractcreativerendition = (AbstractCreativeRendition)arraylist.next();
                if (abstractcreativerendition.isValid(islot, iconstants))
                {
                    if (this instanceof CompanionAds)
                    {
                        if (((Companion)abstractcreativerendition).isValidCompanion(islot, iconstants))
                        {
                            arraylist1.add(abstractcreativerendition);
                        }
                    } else
                    {
                        arraylist1.add(abstractcreativerendition);
                    }
                }
            }
        }
        return arraylist1;
    }

    protected boolean validate(ArrayList arraylist, ISlot islot, IConstants iconstants)
    {
        if (arraylist != null && !arraylist.isEmpty())
        {
            arraylist = arraylist.iterator();
            while (arraylist.hasNext()) 
            {
                if (((IVastValidation)arraylist.next()).isValid(islot, iconstants))
                {
                    return true;
                }
            }
        }
        return false;
    }
}
