// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm.listingdraft;

import android.util.SparseArray;
import com.ebay.nautilus.domain.EbaySite;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.content.dm.listingdraft:
//            ConditionDefinitionLoadTask

private final class <init> extends com.ebay.nautilus.kernel.util.adTask.RootElement
{

    final ConditionDefinitionLoadTask this$0;

    public com.ebay.nautilus.kernel.util.adTask.RootElement get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if (!"Help".equals(s1)) goto _L2; else goto _L1
_L1:
        Object obj;
        int i;
        int j;
        int k;
        obj = attributes.getValue("ID").split("_");
        k = -1;
        j = -1;
        i = -1;
        if (obj.length != 3) goto _L4; else goto _L3
_L3:
        k = ConditionDefinitionLoadTask.access$100(ConditionDefinitionLoadTask.this, obj[0]);
        j = Integer.parseInt(obj[1]);
        i = Integer.parseInt(obj[2]);
_L6:
        if (k == ConditionDefinitionLoadTask.access$200(ConditionDefinitionLoadTask.this).idInt && j == ConditionDefinitionLoadTask.access$300(ConditionDefinitionLoadTask.this))
        {
            obj = attributes.getValue("Content");
            ConditionDefinitionLoadTask.access$400(ConditionDefinitionLoadTask.this).put(i, obj);
        }
_L2:
        return super.adTask(s, s1, s2, attributes);
_L4:
        if (obj.length == 4)
        {
            k = ConditionDefinitionLoadTask.access$100(ConditionDefinitionLoadTask.this, (new StringBuilder()).append(obj[0]).append(obj[1]).toString());
            j = Integer.parseInt(obj[2]);
            i = Integer.parseInt(obj[3]);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private ()
    {
        this$0 = ConditionDefinitionLoadTask.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
