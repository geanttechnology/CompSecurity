// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.service.wearable;

import com.google.android.gms.wearable.k;
import com.google.android.gms.wearable.p;
import com.shazam.android.analytics.TaggingOrigin;
import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.android.service.unsubmitted.d;
import com.shazam.android.service.unsubmitted.i;
import com.shazam.android.service.unsubmitted.j;
import com.shazam.i.b.g.b;
import com.shazam.i.j.a;
import com.shazam.j.c;
import com.shazam.model.Tag;
import com.shazam.model.account.UserStateDecider;
import com.shazam.model.analytics.BeaconEventKey;
import com.shazam.model.analytics.event.DefinedEventParameterKey;
import com.shazam.model.wearable.AudioSignature;
import java.util.UUID;
import java.util.concurrent.ExecutorService;

public class ShazamWearableService extends p
{

    private final com.shazam.j.b a = com.shazam.i.j.a.b();
    private final ExecutorService b = com.shazam.i.o.a.a();
    private final EventAnalytics c = com.shazam.i.b.g.b.a.a();
    private final com.shazam.android.service.tagging.b d;
    private final i e = com.shazam.i.b.an.c.a.a();
    private final com.shazam.android.wearcom.a f = com.shazam.i.b.an.b.a();
    private final UserStateDecider g = com.shazam.i.k.a.b.a();

    public ShazamWearableService()
    {
        d = com.shazam.i.b.an.b.a.a(com.shazam.i.b.g.b.c(), TaggingOrigin.WEARABLE);
    }

    static i a(ShazamWearableService shazamwearableservice)
    {
        return shazamwearableservice.e;
    }

    static com.shazam.android.service.tagging.b b(ShazamWearableService shazamwearableservice)
    {
        return shazamwearableservice.d;
    }

    public final void a(k k1)
    {
        String s;
        Object obj;
        super.a(k1);
        s = k1.c();
        obj = k1.a();
        if (!"/recognition".equals(obj))
        {
            break MISSING_BLOCK_LABEL_112;
        }
        k1 = (AudioSignature)a.a(new String(k1.b()), com/shazam/model/wearable/AudioSignature);
        obj = new Tag();
        obj.requestId = UUID.randomUUID().toString();
        obj.timestamp = ((AudioSignature) (k1)).timestamp;
        obj.sig = ((AudioSignature) (k1)).sig;
        k1 = new Runnable(s, ((Tag) (obj))) {

            final String a;
            final Tag b;
            final ShazamWearableService c;

            public final void run()
            {
                Object obj1 = a;
                obj1 = new d(new j[] {
                    com.shazam.i.b.an.c.b.b(), com.shazam.i.b.an.c.b.a(), new com.shazam.android.service.unsubmitted.c(com.shazam.i.b.c.a(), ((String) (obj1)))
                });
                com.shazam.android.service.wearable.ShazamWearableService.b(c).a(b, ((j) (obj1)), com.shazam.android.service.wearable.ShazamWearableService.a(c));
            }

            
            {
                c = ShazamWearableService.this;
                a = s;
                b = tag;
                super();
            }
        };
        b.execute(k1);
_L1:
        return;
        if ("/startTagging".equals(obj))
        {
            if (g.d())
            {
                k1 = f;
                obj = new com.shazam.android.wearcom.a.b.a();
                obj.a = "/noConfig";
                obj.d = s;
                k1.a(((com.shazam.android.wearcom.a.b.a) (obj)).a());
                return;
            }
        } else
        {
            if ("/lyrics".equals(obj))
            {
                k1 = com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.SCREEN_NAME, "lyricplay").putNotEmptyOrNullParameter(DefinedEventParameterKey.TIME_SPENT, new String(k1.b())).putNotEmptyOrNullParameter(DefinedEventParameterKey.ORIGIN, "wear").build();
                k1 = com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(BeaconEventKey.PAGE_VIEW).withParameters(k1).build();
                c.logEvent(k1);
                return;
            }
            if ("/openSignUp".equals(obj))
            {
                com.shazam.android.activities.b.b.b(getApplicationContext());
                return;
            }
        }
          goto _L1
        k1;
    }
}
