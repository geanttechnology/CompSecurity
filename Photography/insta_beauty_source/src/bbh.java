// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.instamag.activity.compose.MainOnlineLibActivity;

public class bbh
    implements android.view.View.OnClickListener
{

    final MainOnlineLibActivity a;

    public bbh(MainOnlineLibActivity mainonlinelibactivity)
    {
        a = mainonlinelibactivity;
        super();
    }

    public void onClick(View view)
    {
        a.backBtnClicked(view);
    }
}
