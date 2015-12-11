// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.processor;

import io.realm.processor.javawriter.JavaWriter;
import java.io.IOException;
import java.util.List;

// Referenced classes of package io.realm.processor:
//            RealmProxyMediatorGenerator

class this._cls0
    implements oxySwitchStatement
{

    final RealmProxyMediatorGenerator this$0;

    public void emitStatement(int i, JavaWriter javawriter)
        throws IOException
    {
        javawriter.emitStatement("return %s.getTableName()", new Object[] {
            RealmProxyMediatorGenerator.access$000(RealmProxyMediatorGenerator.this).get(i)
        });
    }

    oxySwitchStatement()
    {
        this$0 = RealmProxyMediatorGenerator.this;
        super();
    }
}
