// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.v;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.load.e;

// Referenced classes of package myobfuscated.v:
//            ae, af

public final class aq
    implements ae
{

    private final ae a;
    private final Resources b;

    public aq(Context context, ae ae1)
    {
        this(context.getResources(), ae1);
    }

    private aq(Resources resources, ae ae1)
    {
        b = resources;
        a = ae1;
    }

    private Uri a(Integer integer)
    {
        Uri uri;
        try
        {
            uri = Uri.parse((new StringBuilder("android.resource://")).append(b.getResourcePackageName(integer.intValue())).append('/').append(b.getResourceTypeName(integer.intValue())).append('/').append(b.getResourceEntryName(integer.intValue())).toString());
        }
        catch (android.content.res.Resources.NotFoundException notfoundexception)
        {
            if (Log.isLoggable("ResourceLoader", 5))
            {
                Log.w("ResourceLoader", (new StringBuilder("Received invalid resource id: ")).append(integer).toString(), notfoundexception);
            }
            return null;
        }
        return uri;
    }

    public final af buildLoadData(Object obj, int i, int j, e e)
    {
        obj = a((Integer)obj);
        if (obj == null)
        {
            return null;
        } else
        {
            return a.buildLoadData(obj, i, j, e);
        }
    }

    public final volatile boolean handles(Object obj)
    {
        return true;
    }
}
