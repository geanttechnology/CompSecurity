// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import com.jumio.netverify.sdk.core.vo.Country;
import com.jumio.netverify.sdk.core.vo.DocumentType;
import java.util.List;

interface kg
{

    public abstract boolean a();

    public abstract boolean a(Country country, DocumentType documenttype);

    public abstract void b();

    public abstract boolean b(Country country, DocumentType documenttype);

    public abstract List c(Country country, DocumentType documenttype);
}
