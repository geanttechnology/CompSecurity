// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.ExpandableListView;
import com.fotoable.sketch.view.TTieZhiLibraryView;

public class axm
    implements android.widget.ExpandableListView.OnGroupClickListener
{

    final TTieZhiLibraryView a;

    public axm(TTieZhiLibraryView ttiezhilibraryview)
    {
        a = ttiezhilibraryview;
        super();
    }

    public boolean onGroupClick(ExpandableListView expandablelistview, View view, int i, long l)
    {
        return true;
    }
}
