// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import android.view.View;
import com.wantu.ResourceOnlineLibrary.compose.manage.MagManageAdapter;
import com.wantu.model.res.TResInfo;

public class bhp
    implements android.view.View.OnClickListener
{

    final MagManageAdapter a;

    public bhp(MagManageAdapter magmanageadapter)
    {
        a = magmanageadapter;
        super();
    }

    public void onClick(View view)
    {
        Log.v("MagManageAdapter", "MagManageAdapter delete button clicked");
        view = (TResInfo)(TResInfo)view.getTag();
        Log.v("MagManageAdapter", (new StringBuilder()).append("MagManageAdapter delete button resid:").append(((TResInfo) (view)).resId).toString());
        if (MagManageAdapter.access$100(a) != null)
        {
            MagManageAdapter.access$100(a).a(view);
        }
    }
}
