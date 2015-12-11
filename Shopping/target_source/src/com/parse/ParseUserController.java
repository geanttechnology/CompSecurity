// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.j;
import java.util.Map;

// Referenced classes of package com.parse:
//            ParseOperationSet

interface ParseUserController
{

    public abstract j getUserAsync(String s);

    public abstract j logInAsync(ParseUser.State state, ParseOperationSet parseoperationset);

    public abstract j logInAsync(String s, String s1);

    public abstract j logInAsync(String s, Map map);

    public abstract j requestPasswordResetAsync(String s);

    public abstract j signUpAsync(ParseObject.State state, ParseOperationSet parseoperationset, String s);
}
