// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.wantu.ResourceOnlineLibrary.compose.manage.ManageOnlineLibActivity;

public class bhx
    implements android.view.View.OnClickListener
{

    final ManageOnlineLibActivity a;

    public bhx(ManageOnlineLibActivity manageonlinelibactivity)
    {
        a = manageonlinelibactivity;
        super();
    }

    public void onClick(View view)
    {
        a.backBtnClicked(view);
    }
}
