// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.instamag.activity.library.view.LibraryExpandableListView;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import java.util.Comparator;

public class bdn
    implements Comparator
{

    final LibraryExpandableListView a;

    public bdn(LibraryExpandableListView libraryexpandablelistview)
    {
        a = libraryexpandablelistview;
        super();
    }

    public int compare(Object obj, Object obj1)
    {
        boolean flag = false;
        byte byte0 = flag;
        if (obj instanceof TPhotoComposeInfo)
        {
            byte0 = flag;
            if (obj1 instanceof TPhotoComposeInfo)
            {
                obj = (TPhotoComposeInfo)obj;
                obj1 = (TPhotoComposeInfo)obj1;
                if (((TPhotoComposeInfo) (obj)).height > ((TPhotoComposeInfo) (obj1)).height)
                {
                    byte0 = -1;
                } else
                {
                    byte0 = flag;
                    if (((TPhotoComposeInfo) (obj)).height < ((TPhotoComposeInfo) (obj1)).height)
                    {
                        return 1;
                    }
                }
            }
        }
        return byte0;
    }
}
