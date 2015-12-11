// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.dash.mpd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import shared_presage.com.google.android.exoplayer.util.Assertions;

// Referenced classes of package shared_presage.com.google.android.exoplayer.dash.mpd:
//            MediaPresentationDescriptionParser, ContentProtection

protected static final class 
    implements Comparator
{

    private ArrayList adaptationSetProtections;
    private ArrayList currentRepresentationProtections;
    private ArrayList representationProtections;
    private boolean representationProtectionsSet;

    private void maybeAddContentProtection(List list, ContentProtection contentprotection)
    {
        if (!list.contains(contentprotection))
        {
            int i = 0;
            while (i < list.size()) 
            {
                boolean flag;
                if (!((ContentProtection)list.get(i)).schemeUriId.equals(contentprotection.schemeUriId))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                Assertions.checkState(flag);
                i++;
            }
            list.add(contentprotection);
        }
    }

    public final void addAdaptationSetProtection(ContentProtection contentprotection)
    {
        if (adaptationSetProtections == null)
        {
            adaptationSetProtections = new ArrayList();
        }
        maybeAddContentProtection(adaptationSetProtections, contentprotection);
    }

    public final void addRepresentationProtection(ContentProtection contentprotection)
    {
        if (currentRepresentationProtections == null)
        {
            currentRepresentationProtections = new ArrayList();
        }
        maybeAddContentProtection(currentRepresentationProtections, contentprotection);
    }

    public final ArrayList build()
    {
        if (adaptationSetProtections == null)
        {
            return representationProtections;
        }
        if (representationProtections == null)
        {
            return adaptationSetProtections;
        }
        for (int i = 0; i < representationProtections.size(); i++)
        {
            maybeAddContentProtection(adaptationSetProtections, (ContentProtection)representationProtections.get(i));
        }

        return adaptationSetProtections;
    }

    public final volatile int compare(Object obj, Object obj1)
    {
        return compare((ContentProtection)obj, (ContentProtection)obj1);
    }

    public final int compare(ContentProtection contentprotection, ContentProtection contentprotection1)
    {
        return contentprotection.schemeUriId.compareTo(contentprotection1.schemeUriId);
    }

    public final void endRepresentation()
    {
        boolean flag = true;
        if (!representationProtectionsSet)
        {
            if (currentRepresentationProtections != null)
            {
                Collections.sort(currentRepresentationProtections, this);
            }
            representationProtections = currentRepresentationProtections;
            representationProtectionsSet = true;
        } else
        if (currentRepresentationProtections == null)
        {
            if (representationProtections != null)
            {
                flag = false;
            }
            Assertions.checkState(flag);
        } else
        {
            Collections.sort(currentRepresentationProtections, this);
            Assertions.checkState(currentRepresentationProtections.equals(representationProtections));
        }
        currentRepresentationProtections = null;
    }

    protected ()
    {
    }
}
