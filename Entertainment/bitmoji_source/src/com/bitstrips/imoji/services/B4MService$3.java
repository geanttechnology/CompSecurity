// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.services;

import com.android.volley.toolbox.StringRequest;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.bitstrips.imoji.services:
//            B4MService

class init> extends StringRequest
{

    final B4MService this$0;

    public Map getHeaders()
    {
        HashMap hashmap = new HashMap();
        hashmap.put(B4MService.access$200(B4MService.this), B4MService.access$300(B4MService.this));
        return hashmap;
    }

    (int i, String s, com.android.volley.ener ener, com.android.volley.rListener rlistener)
    {
        this$0 = B4MService.this;
        super(i, s, ener, rlistener);
    }
}
