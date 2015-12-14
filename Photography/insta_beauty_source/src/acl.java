// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Intent;
import android.view.View;
import com.fotoable.fotobeauty.FileSystemActivity;
import com.fotoable.fotobeauty.StorePathActivity;

public class acl
    implements android.view.View.OnClickListener
{

    final StorePathActivity a;

    public acl(StorePathActivity storepathactivity)
    {
        a = storepathactivity;
        super();
    }

    public void onClick(View view)
    {
        view = new Intent(a, com/fotoable/fotobeauty/FileSystemActivity);
        a.startActivity(view);
    }
}
