// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Intent;
import com.wantu.ResourceOnlineLibrary.activity.MainResourceActivity;
import com.wantu.model.res.pip.TDFSceneInfo;
import com.wantu.piprender.ESceneMode;
import java.util.ArrayList;

public class un
    implements tt
{

    MainResourceActivity a;
    private ESceneMode b;

    public un(MainResourceActivity mainresourceactivity)
    {
        a = mainresourceactivity;
    }

    public ESceneMode a()
    {
        return b;
    }

    public void a(float f, Object obj)
    {
    }

    public void a(int i, Object obj)
    {
        a.e();
    }

    public void a(Object obj)
    {
    }

    public void a(tu tu)
    {
    }

    public void a(tu tu, int i)
    {
        a.e();
    }

    public void a(tu tu, ArrayList arraylist)
    {
        a.e();
    }

    public void b(Object obj)
    {
        if (obj instanceof TDFSceneInfo)
        {
            b = ((TDFSceneInfo)obj).getMode();
            obj = new Intent();
            ((Intent) (obj)).setType("image/*");
            ((Intent) (obj)).setAction("android.intent.action.GET_CONTENT");
            a.startActivityForResult(((Intent) (obj)), 3021);
            return;
        } else
        {
            a.e();
            return;
        }
    }

    public void b(tu tu, int i)
    {
    }
}
