// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.i.h;

import android.content.Intent;
import b.a.b.e;
import b.a.b.l;
import b.a.c;
import b.a.c.b;
import com.google.b.f;
import com.google.b.g;
import com.shazam.android.web.bridge.command.ShWebCommand;
import com.shazam.android.web.bridge.command.ShWebCommandDeserializer;
import com.shazam.android.web.bridge.command.ShWebCommandSerializer;
import com.shazam.android.web.bridge.command.ShWebCommandType;
import com.shazam.h.k;
import com.shazam.h.r;
import com.shazam.model.news.FeedCard;
import com.shazam.serialization.AmpAccountDeserializer;
import com.shazam.serialization.AmpAccountSerializer;
import com.shazam.serialization.AmpSocialDeserializer;
import com.shazam.serialization.AmpSocialSerializer;
import com.shazam.serialization.FeedCardTypeSelector;
import com.shazam.server.legacy.orbitconfig.Type;
import com.shazam.server.legacy.orbitconfig.json.LegacyJsonConfig;
import com.shazam.server.response.actions.ActionType;
import com.shazam.server.response.config.AmpAccount;
import com.shazam.server.response.config.AmpSocial;
import com.shazam.server.response.explore.Level;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
{

    private static final f a;
    private static final g b;

    public static f a()
    {
        return a;
    }

    static 
    {
        Object obj = new c();
        Object obj1 = new FeedCardTypeSelector();
        ((c) (obj)).a(com/shazam/model/news/FeedCard).b = ((b.a.e) (obj1));
        obj1 = new g();
        if (((c) (obj)).f)
        {
            b b1 = new b(new e(((c) (obj)).c));
            ((c) (obj)).a(java/lang/Object).a().add(b1);
        }
        Class class1;
        for (Iterator iterator = ((c) (obj)).b.iterator(); iterator.hasNext(); ((g) (obj1)).a(new b.a.b.g((b.a.a)((c) (obj)).a.get(class1))))
        {
            class1 = (Class)iterator.next();
        }

        if (((c) (obj)).d != null)
        {
            ((g) (obj1)).a(java/util/Date, ((c) (obj)).d.a(((c) (obj)).e));
        }
        ((g) (obj1)).a(new l());
        obj = ((g) (obj1)).a(android/content/Intent, new com.shazam.android.x.b()).a(android/content/Intent, new com.shazam.android.x.a()).a(com/shazam/server/response/actions/ActionType, new com.shazam.server.response.actions.ActionType.Serializer()).a(com/shazam/server/response/actions/ActionType, new com.shazam.server.response.actions.ActionType.Deserializer()).a(com/shazam/model/ActionType, new com.shazam.model.ActionType.Serializer()).a(com/shazam/model/ActionType, new com.shazam.model.ActionType.Deserializer()).a(com/shazam/server/response/config/AmpAccount, new AmpAccountSerializer()).a(com/shazam/server/response/config/AmpAccount, new AmpAccountDeserializer()).a(com/shazam/server/response/config/AmpSocial, new AmpSocialSerializer()).a(com/shazam/server/response/config/AmpSocial, new AmpSocialDeserializer()).a(com/shazam/server/response/explore/Level, new com.shazam.server.response.explore.Level.Serializer()).a(com/shazam/server/response/explore/Level, new com.shazam.server.response.explore.Level.Deserializer()).a(com/shazam/server/legacy/orbitconfig/Type, new com.shazam.server.legacy.orbitconfig.Type.Deserializer()).a(com/shazam/android/web/bridge/command/ShWebCommandType, new com.shazam.android.web.bridge.command.ShWebCommandType.Serializer()).a(com/shazam/android/web/bridge/command/ShWebCommandType, new com.shazam.android.web.bridge.command.ShWebCommandType.Deserializer()).a(com/shazam/android/web/bridge/command/ShWebCommand, new ShWebCommandSerializer()).a(com/shazam/android/web/bridge/command/ShWebCommand, new ShWebCommandDeserializer()).a(com/shazam/android/web/bridge/command/data/IsIntentSupportedResponseData$Status, new com.shazam.android.web.bridge.command.data.IsIntentSupportedResponseData.Status.Serializer()).a(com/shazam/android/web/bridge/command/data/IsIntentSupportedResponseData$Status, new com.shazam.android.web.bridge.command.data.IsIntentSupportedResponseData.Status.Deserializer()).a(com/shazam/android/web/bridge/command/data/NewWebViewData$ViewType, new com.shazam.android.web.bridge.command.data.NewWebViewData.ViewType.Serializer()).a(com/shazam/android/web/bridge/command/data/NewWebViewData$ViewType, new com.shazam.android.web.bridge.command.data.NewWebViewData.ViewType.Deserializer()).a(com/shazam/server/legacy/orbitconfig/json/LegacyJsonConfig, new com.shazam.server.legacy.orbitconfig.json.LegacyJsonConfig.Deserializer()).a(com/shazam/android/web/bridge/command/data/ScrollToCommandData$Position, new com.shazam.android.web.bridge.command.data.ScrollToCommandData.Position.Deserializer());
        b = ((g) (obj));
        ((g) (obj)).a(com/shazam/h/k, new com.shazam.h.k.b());
        ((g) (obj)).a(com/shazam/h/k, new com.shazam.h.k.a());
        ((g) (obj)).a(com/shazam/h/r, new com.shazam.h.r.b());
        ((g) (obj)).a(com/shazam/h/r, new com.shazam.h.r.a());
        com.shazam.h.b.a.a = true;
        a = b.a();
    }
}
