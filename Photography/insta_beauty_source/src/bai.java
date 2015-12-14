// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.instamag.activity.compose.MagComposeFragement;

public class bai extends Handler
{

    final MagComposeFragement a;

    public bai(MagComposeFragement magcomposefragement)
    {
        a = magcomposefragement;
        super();
    }

    public void handleMessage(Message message)
    {
        MagComposeFragement.access$000(a).setVisibility(4);
    }
}
