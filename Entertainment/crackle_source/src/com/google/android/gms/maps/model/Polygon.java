// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.eg;
import com.google.android.gms.maps.model.internal.e;
import java.util.List;

// Referenced classes of package com.google.android.gms.maps.model:
//            RuntimeRemoteException

public final class Polygon
{

    private final e CU;

    public Polygon(e e1)
    {
        CU = (e)eg.f(e1);
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof Polygon))
        {
            return false;
        }
        boolean flag;
        try
        {
            flag = CU.a(((Polygon)obj).CU);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeRemoteException(((RemoteException) (obj)));
        }
        return flag;
    }

    public int getFillColor()
    {
        int i;
        try
        {
            i = CU.getFillColor();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return i;
    }

    public List getHoles()
    {
        List list;
        try
        {
            list = CU.getHoles();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return list;
    }

    public String getId()
    {
        String s;
        try
        {
            s = CU.getId();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return s;
    }

    public List getPoints()
    {
        List list;
        try
        {
            list = CU.getPoints();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return list;
    }

    public int getStrokeColor()
    {
        int i;
        try
        {
            i = CU.getStrokeColor();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return i;
    }

    public float getStrokeWidth()
    {
        float f;
        try
        {
            f = CU.getStrokeWidth();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return f;
    }

    public float getZIndex()
    {
        float f;
        try
        {
            f = CU.getZIndex();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return f;
    }

    public int hashCode()
    {
        int i;
        try
        {
            i = CU.hashCodeRemote();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return i;
    }

    public boolean isGeodesic()
    {
        boolean flag;
        try
        {
            flag = CU.isGeodesic();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }

    public boolean isVisible()
    {
        boolean flag;
        try
        {
            flag = CU.isVisible();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }

    public void remove()
    {
        try
        {
            CU.remove();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public void setFillColor(int i)
    {
        try
        {
            CU.setFillColor(i);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public void setGeodesic(boolean flag)
    {
        try
        {
            CU.setGeodesic(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public void setHoles(List list)
    {
        try
        {
            CU.setHoles(list);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            throw new RuntimeRemoteException(list);
        }
    }

    public void setPoints(List list)
    {
        try
        {
            CU.setPoints(list);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            throw new RuntimeRemoteException(list);
        }
    }

    public void setStrokeColor(int i)
    {
        try
        {
            CU.setStrokeColor(i);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public void setStrokeWidth(float f)
    {
        try
        {
            CU.setStrokeWidth(f);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public void setVisible(boolean flag)
    {
        try
        {
            CU.setVisible(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public void setZIndex(float f)
    {
        try
        {
            CU.setZIndex(f);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }
}
