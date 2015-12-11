// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.location.Location;

// Referenced classes of package android.support.v7:
//            fw, dz, ee, ajx, 
//            ed

public class fy extends fw
{

    public fy(Context context)
    {
        super(context);
    }

    protected void a(Location location)
    {
        super.a(location);
        if (location != null)
        {
            dz.a().a(new ee(location));
            return;
        } else
        {
            dz.a().a(new ed());
            return;
        }
    }

    protected void onPostExecute(Object obj)
    {
        a((Location)obj);
    }
}
