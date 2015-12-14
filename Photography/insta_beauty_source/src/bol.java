// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.wantu.setting.FileAdapter;

public class bol
    implements android.view.View.OnClickListener
{

    final int a;
    final FileAdapter b;

    public bol(FileAdapter fileadapter, int i)
    {
        b = fileadapter;
        a = i;
        super();
    }

    public void onClick(View view)
    {
        b.onSelectedBtnItemCall.a(a);
    }
}
