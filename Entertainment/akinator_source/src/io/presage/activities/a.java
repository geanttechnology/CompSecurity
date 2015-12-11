// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.activities;

import io.presage.activities.handlers.AddShortcutActionHandler;
import io.presage.activities.handlers.LaunchActivityFormatHandler;
import io.presage.activities.handlers.LegacyActivityHandler;
import java.util.HashMap;

// Referenced classes of package io.presage.activities:
//            PresageActivity

final class a extends HashMap
{

    a()
    {
        put(PresageActivity.a, io/presage/activities/handlers/LegacyActivityHandler);
        put("add_shortcut_action", io/presage/activities/handlers/AddShortcutActionHandler);
        put("launch_activity", io/presage/activities/handlers/LaunchActivityFormatHandler);
    }
}
