// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import com.cyberlink.beautycircle.model.CircleBasic;
import com.cyberlink.beautycircle.model.CircleType;
import com.cyberlink.beautycircle.model.network.NetworkCircle;
import com.cyberlink.beautycircle.model.network.d;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.perfectcorp.utility.j;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            ShareInActivity

class a extends j
{

    final String a;
    final ShareInActivity b;

    protected CircleBasic a(Void void1)
    {
        Object obj;
        Long long1;
        obj = null;
        long1 = AccountManager.c();
        if (a == null || long1 == null) goto _L2; else goto _L1
_L1:
        void1 = (d)NetworkCircle.a(long1.longValue(), long1.longValue()).d();
        if (void1 == null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        if (((d) (void1)).b != null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        a(0x80000003);
        return null;
        CircleType circletype = (CircleType)CircleType.a(a).d();
        if (circletype == null) goto _L4; else goto _L3
_L3:
        Object obj1 = circletype.id;
_L19:
        Iterator iterator = ((d) (void1)).b.iterator();
        void1 = null;
_L18:
        if (!iterator.hasNext()) goto _L6; else goto _L5
_L5:
        CircleBasic circlebasic = (CircleBasic)iterator.next();
        if (circlebasic == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (circlebasic.defaultType == null || !circlebasic.defaultType.equals(a)) goto _L8; else goto _L7
_L7:
        void1 = ((Void) (obj));
        obj = circlebasic;
          goto _L9
_L8:
        if (obj1 == null) goto _L11; else goto _L10
_L10:
        if (circlebasic.circleTypeId == null) goto _L11; else goto _L12
_L12:
        boolean flag = circlebasic.circleTypeId.equals(obj1);
        if (!flag) goto _L11; else goto _L13
_L13:
        obj = void1;
        void1 = circlebasic;
          goto _L9
_L6:
        if (void1 != null)
        {
            obj = void1;
        }
        if (obj != null || circletype == null) goto _L15; else goto _L14
_L14:
        void1 = (CircleBasic)((d)NetworkCircle.a(((com.cyberlink.beautycircle.model.network.eCircleResult)NetworkCircle.a(AccountManager.b(), circletype.circleTypeName, null, circletype.id, Boolean.valueOf(false)).d()).circleId, long1, long1).d()).b.get(0);
_L17:
        return void1;
        obj;
        void1 = null;
_L16:
        ((Exception) (obj)).printStackTrace();
        a(0x80000001);
        continue; /* Loop/switch isn't completed */
        obj;
        continue; /* Loop/switch isn't completed */
        obj1;
        void1 = ((Void) (obj));
        obj = obj1;
        if (true) goto _L16; else goto _L15
_L15:
        void1 = ((Void) (obj));
        continue; /* Loop/switch isn't completed */
_L11:
        Void void2 = void1;
        void1 = ((Void) (obj));
        obj = void2;
        break; /* Loop/switch isn't completed */
_L2:
        void1 = null;
        if (true) goto _L17; else goto _L9
_L9:
        Object obj2 = obj;
        obj = void1;
        void1 = ((Void) (obj2));
        if (true) goto _L18; else goto _L4
_L4:
        obj1 = null;
          goto _L19
    }

    protected volatile Object a(Object obj)
    {
        return a((Void)obj);
    }

    eResult(ShareInActivity shareinactivity, String s)
    {
        b = shareinactivity;
        a = s;
        super();
    }
}
