// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.annotation.view;

import java.lang.annotation.Annotation;

// Referenced classes of package net.tsz.afinal.annotation.view:
//            Select

public interface ViewInject
    extends Annotation
{

    public abstract String click();

    public abstract int id();

    public abstract String itemClick();

    public abstract String itemLongClick();

    public abstract String longClick();

    public abstract Select select();
}
