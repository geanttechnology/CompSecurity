// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.acf.module;


// Referenced classes of package com.amazon.client.framework.acf.module:
//            ApkAssetExpander

public static interface 
{

    public abstract void onAssetExpansionEnd(ApkAssetExpander apkassetexpander,  );

    public abstract void onAssetExpansionProgress(ApkAssetExpander apkassetexpander, int i, int j);

    public abstract void onAssetExpansionStart(ApkAssetExpander apkassetexpander);
}
