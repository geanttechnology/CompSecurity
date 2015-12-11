// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.text.TextUtils;
import android.util.SparseArray;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.flurry.android:
//            gj, gl, fd, cy

final class fi
    implements gj
{

    private static final SparseArray gP;
    private static final String p = com/flurry/android/fi.getSimpleName();

    fi()
    {
    }

    public final boolean a(Context context, gl gl1)
    {
        if (gl1 != null) goto _L2; else goto _L1
_L1:
        boolean flag3 = false;
_L4:
        return flag3;
_L2:
        String s;
        Object obj;
        boolean flag2;
        s = gl1.O();
        if (TextUtils.isEmpty(s))
        {
            return false;
        }
        obj = gl1.bJ();
        if (obj == null)
        {
            return false;
        }
        gl1 = context.getPackageManager();
        context = context.getPackageName();
        obj = ((List) (obj)).iterator();
        flag2 = true;
_L5:
        flag3 = flag2;
        if (!((Iterator) (obj)).hasNext()) goto _L4; else goto _L3
_L3:
        ActivityInfo activityinfo;
        Object obj1;
        boolean flag;
        activityinfo = (ActivityInfo)((Iterator) (obj)).next();
        if (TextUtils.isEmpty(s) || gl1 == null || TextUtils.isEmpty(context) || activityinfo == null || TextUtils.isEmpty(activityinfo.name))
        {
            flag = false;
        } else
        {
label0:
            {
                obj1 = fd.a(gl1, new ComponentName(context, activityinfo.name));
                if (obj1 != null)
                {
                    break label0;
                }
                cy.d(p, (new StringBuilder()).append(s).append(": package=\"").append(context).append("\": AndroidManifest.xml should include activity node with android:name=\"").append(activityinfo.name).append("\"").toString());
                flag = false;
            }
        }
_L7:
        if (!flag)
        {
            flag2 = false;
        }
          goto _L5
        boolean flag1;
        int i;
        int j;
        int k;
        (new StringBuilder()).append(s).append(": package=\"").append(context).append("\": AndroidManifest.xml has activity node with android:name=\"").append(activityinfo.name).append("\"").toString();
        j = activityinfo.configChanges;
        if (j == 0)
        {
            break MISSING_BLOCK_LABEL_481;
        }
        k = fd.a(((ActivityInfo) (obj1)));
        obj1 = gP;
        flag1 = true;
        i = 0;
_L8:
        flag = flag1;
        if (i >= ((SparseArray) (obj1)).size()) goto _L7; else goto _L6
_L6:
        int l = ((SparseArray) (obj1)).keyAt(i);
        flag = flag1;
        if ((l & j) != 0)
        {
            if ((l & k) == 0)
            {
                cy.d(p, (new StringBuilder()).append(s).append(": package=\"").append(context).append("\": AndroidManifest.xml activity node with android:name=\"").append(activityinfo.name).append("\" should include android:configChanges value=\"").append((String)((SparseArray) (obj1)).valueAt(i)).append("\"").toString());
                flag = false;
            } else
            {
                (new StringBuilder()).append(s).append(": package=\"").append(context).append("\": AndroidManifest.xml activity node with ").append("android:name=\"").append(activityinfo.name).append("\" has android:configChanges value=\"").append((String)((SparseArray) (obj1)).valueAt(i)).append("\"").toString();
                flag = flag1;
            }
        }
        i++;
        flag1 = flag;
          goto _L8
        flag = true;
          goto _L7
    }

    static 
    {
        SparseArray sparsearray = new SparseArray();
        sparsearray.append(1, "mcc");
        sparsearray.append(2, "mnc");
        sparsearray.append(4, "locale");
        sparsearray.append(8, "touchscreen");
        sparsearray.append(16, "keyboard");
        sparsearray.append(32, "keyboardHidden");
        sparsearray.append(64, "navigation");
        sparsearray.append(128, "orientation");
        sparsearray.append(256, "screenLayout");
        sparsearray.append(512, "uiMode");
        sparsearray.append(1024, "screenSize");
        sparsearray.append(2048, "smallestScreenSize");
        gP = sparsearray;
    }
}
