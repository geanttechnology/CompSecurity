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
        if (!void1.isEmpty()) goto _L2; else goto _L1
_L1:
        void1 = new BCTileImage();
_L3:
        if (((BCTileImage) (void1)).imageList == null)
        {
            void1.imageList = new ArrayList();
        }
        if (((BCTileImage) (void1)).imageList.contains(s))
        {
            break MISSING_BLOCK_LABEL_195;
        }
        if (((BCTileImage) (void1)).imageList.size() == 4)
        {
            ((BCTileImage) (void1)).imageList.remove(0);
        }
        ((BCTileImage) (void1)).imageList.add(s);
        e.b(new Object[] {
            (new StringBuilder()).append("Add photo :").append(s).toString()
        });
_L4:
        sharedpreferences.edit().putString("KEY_BC_TILE_IMAGE", void1.toString()).commit();
        return null;
_L2:
        void1 = (BCTileImage)Model.a(com/cyberlink/beautycircle/model/BCTileImage, void1);
          goto _L3
        e.b(new Object[] {
            "The photo already is in image list."
        });
          goto _L4
    }

    (Post post)
    {
        a = post;
        super();
    }
}
