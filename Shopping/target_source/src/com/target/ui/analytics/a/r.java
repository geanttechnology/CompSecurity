// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import android.support.v4.f.a;
import com.target.ui.vlc.model.VlcPositionInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.target.ui.analytics.a:
//            c, q

public class r extends c
{

    private static final String COORDINATE_SEPARATOR = ",";
    private static final String EVENT_SEPARATOR = "|";
    private final List mPositions;

    private r(List list)
    {
        mPositions = new ArrayList(list.size());
        mPositions.addAll(list);
    }

    public static r a(List list)
    {
        return new r(list);
    }

    private String b(List list)
    {
        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = list.iterator();
        int j = 0;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            VlcPositionInfo vlcpositioninfo = (VlcPositionInfo)iterator.next();
            int k = j + 1;
            stringbuilder.append(vlcpositioninfo.d());
            j = k;
            if (k != list.size())
            {
                stringbuilder.append("|");
                j = k;
            }
        } while (true);
        return stringbuilder.toString();
    }

    private String c(List list)
    {
        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = list.iterator();
        int j = 0;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            VlcPositionInfo vlcpositioninfo = (VlcPositionInfo)iterator.next();
            int k = j + 1;
            stringbuilder.append(vlcpositioninfo.g());
            j = k;
            if (k != list.size())
            {
                stringbuilder.append("|");
                j = k;
            }
        } while (true);
        return stringbuilder.toString();
    }

    private String d(List list)
    {
        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = list.iterator();
        int j = 0;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            VlcPositionInfo vlcpositioninfo = (VlcPositionInfo)iterator.next();
            int k = j + 1;
            stringbuilder.append(vlcpositioninfo.f());
            j = k;
            if (k != list.size())
            {
                stringbuilder.append("|");
                j = k;
            }
        } while (true);
        return stringbuilder.toString();
    }

    private String e(List list)
    {
        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = list.iterator();
        int j = 0;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            VlcPositionInfo vlcpositioninfo = (VlcPositionInfo)iterator.next();
            int k = j + 1;
            stringbuilder.append(vlcpositioninfo.a());
            stringbuilder.append(",");
            stringbuilder.append(vlcpositioninfo.b());
            j = k;
            if (k != list.size())
            {
                stringbuilder.append("|");
                j = k;
            }
        } while (true);
        return stringbuilder.toString();
    }

    protected Map b()
    {
        a a1 = new a();
        a1.put("events", "VLCrequest");
        a1.put("floorId", c(mPositions));
        a1.put("VLCangle", b(mPositions));
        a1.put("VLCtimeStamp", d(mPositions));
        a1.put("VLCXandY", e(mPositions));
        return a1;
    }

    protected List d()
    {
        return Collections.emptyList();
    }

    protected q i()
    {
        return q.VlcPositionUpdate;
    }
}
