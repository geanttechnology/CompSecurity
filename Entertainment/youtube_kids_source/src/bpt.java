// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.HashMap;

final class bpt extends HashMap
{

    bpt()
    {
        put("TYPE_IMPRESSION", Integer.valueOf(1));
        put("TYPE_EXPAND", Integer.valueOf(2));
        put("TYPE_COLLAPSE", Integer.valueOf(3));
        put("TYPE_DISMISS", Integer.valueOf(4));
        put("TYPE_HEADLINE_CLICK", Integer.valueOf(5));
        put("TYPE_ACTION", Integer.valueOf(6));
    }
}
