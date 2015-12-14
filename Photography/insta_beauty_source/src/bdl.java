// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.ExpandableListView;
import com.instamag.activity.library.view.LibraryExpandableListView;

public class bdl
    implements android.widget.ExpandableListView.OnGroupClickListener
{

    final LibraryExpandableListView a;

    public bdl(LibraryExpandableListView libraryexpandablelistview)
    {
        a = libraryexpandablelistview;
        super();
    }

    public boolean onGroupClick(ExpandableListView expandablelistview, View view, int i, long l)
    {
        return true;
    }
}
