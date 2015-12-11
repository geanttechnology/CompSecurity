// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import com.jumio.netswipe.sdk.enums.ErrorCase;

public interface cd
{

    public abstract ErrorCase a(com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName fieldname, StringBuilder stringbuilder, boolean flag, long l);

    public abstract void a(boolean flag);

    public abstract void a(boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4, boolean flag5);

    public abstract void b(ErrorCase errorcase);
}
