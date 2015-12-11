// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package roboguice.config;

import com.google.inject.HierarchyTraversalFilter;
import roboguice.RoboGuice;

public class RoboGuiceHierarchyTraversalFilter extends HierarchyTraversalFilter
{

    private static final String ANDROID_PACKAGE = "android";
    protected static final String ROBOGUICE_PACKAGE = roboguice/RoboGuice.getPackage().getName();
    private boolean isInRoboGuicePackage;

    public RoboGuiceHierarchyTraversalFilter()
    {
        isInRoboGuicePackage = false;
    }

    public boolean isWorthScanning(Class class1)
    {
        if (class1 != null && class1 != java/lang/Object)
        {
            if (!(class1 = class1.getName()).startsWith("android"))
            {
                if (class1.startsWith(ROBOGUICE_PACKAGE))
                {
                    isInRoboGuicePackage = true;
                } else
                if (isInRoboGuicePackage)
                {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public void reset()
    {
        super.reset();
        isInRoboGuicePackage = false;
    }

}
