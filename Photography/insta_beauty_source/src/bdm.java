// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.instamag.activity.library.view.LibraryExpandableListView;
import java.util.Comparator;

public class bdm
    implements Comparator
{

    final LibraryExpandableListView a;

    public bdm(LibraryExpandableListView libraryexpandablelistview)
    {
        a = libraryexpandablelistview;
        super();
    }

    public int compare(Object obj, Object obj1)
    {
        int j = 0x7fffffff;
        if ((obj instanceof String) && (obj1 instanceof String))
        {
            obj = (String)obj;
            obj1 = (String)obj1;
            int i;
            if (((String) (obj)).equalsIgnoreCase("S"))
            {
                i = 0x7fffffff;
            } else
            {
                i = Integer.valueOf(((String) (obj))).intValue();
            }
            if (!((String) (obj1)).equalsIgnoreCase("S"))
            {
                j = Integer.valueOf(((String) (obj1))).intValue();
            }
            if (i > j)
            {
                return 1;
            }
            return i != j ? -1 : 0;
        } else
        {
            return 0;
        }
    }
}
