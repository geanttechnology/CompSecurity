// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.instamag.activity.library.fragment.NewMagLibraryFragment;
import com.instamag.activity.library.view.LibraryExpandableListView;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;

public class bci
    implements bdz
{

    final NewMagLibraryFragment a;

    public bci(NewMagLibraryFragment newmaglibraryfragment)
    {
        a = newmaglibraryfragment;
        super();
    }

    public void a(TPhotoComposeInfo tphotocomposeinfo)
    {
        NewMagLibraryFragment.a(a, tphotocomposeinfo);
    }

    public void a(TPhotoComposeInfo tphotocomposeinfo, float f)
    {
    }

    public void b(TPhotoComposeInfo tphotocomposeinfo)
    {
    }

    public void c(TPhotoComposeInfo tphotocomposeinfo)
    {
        NewMagLibraryFragment.a(a, true);
    }

    public void d(TPhotoComposeInfo tphotocomposeinfo)
    {
    }

    public void e(TPhotoComposeInfo tphotocomposeinfo)
    {
        a.a.reloadDataWithInfo(tphotocomposeinfo);
        NewMagLibraryFragment.a(a, true);
    }
}
