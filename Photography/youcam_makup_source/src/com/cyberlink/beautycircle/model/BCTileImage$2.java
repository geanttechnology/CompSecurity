// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model;

import android.content.SharedPreferences;
import android.net.Uri;
import com.cyberlink.beautycircle.Globals;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.model:
//            BCTileImage, Post

final class a extends j
{

    final Post a;

    protected volatile Object a(Object obj)
    {
        return a((Void)obj);
    }

    protected Void a(Void void1)
    {
        String s;
        SharedPreferences sharedpreferences;
        int i;
        try
        {
            void1 = BCTileImage.c(a);
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            void1.printStackTrace();
            return null;
        }
        if (void1 != null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        e.b(new Object[] {
            "Can't find photo."
        });
        return null;
        s = void1.toString();
        sharedpreferences = Globals.D();
        void1 = sharedpreferences.getString("KEY_BC_TILE_IMAGE", "");
        if (!void1.isEmpty())
        {
            break MISSING_BLOCK_LABEL_132;
        }
        void1 = new BCTileImage();
_L1:
        if (((BCTileImage) (void1)).imageList == null || !((BCTileImage) (void1)).imageList.contains(s))
        {
            break MISSING_BLOCK_LABEL_145;
        }
        i = ((BCTileImage) (void1)).imageList.indexOf(s);
        ((BCTileImage) (void1)).imageList.remove(i);
        sharedpreferences.edit().putString("KEY_BC_TILE_IMAGE", void1.toString()).commit();
        return null;
        void1 = (BCTileImage)Model.a(com/cyberlink/beautycircle/model/BCTileImage, void1);
          goto _L1
        return null;
    }

    (Post post)
    {
        a = post;
        super();
    }
}
