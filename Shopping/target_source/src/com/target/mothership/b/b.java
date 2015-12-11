// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.b;

import android.content.Context;
import android.content.res.AssetManager;
import com.target.mothership.services.y;
import com.target.mothership.util.n;
import java.io.IOException;

// Referenced classes of package com.target.mothership.b:
//            c

public class b
    implements c
{

    public static final String TAG = com/target/mothership/b/b.getSimpleName();
    private AssetManager mAssetManager;
    private String mFileName;

    public b(Context context)
    {
        mAssetManager = context.getAssets();
    }

    private String b(String s)
    {
        try
        {
            s = n.a(mAssetManager.open(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return "";
        }
        return s;
    }

    public y a()
    {
        String s;
        if (mFileName == null)
        {
            s = "";
        } else
        {
            s = mFileName;
            mFileName = null;
            s = b(s);
        }
        return new y(s.getBytes());
    }

    public void a(String s)
    {
        mFileName = s;
    }

}
