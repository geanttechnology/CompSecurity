// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.h;
import com.google.android.gms.wearable.n;
import com.shazam.c.p;
import com.shazam.i.b.ah.f.e;
import com.shazam.i.b.n.b;
import com.shazam.i.j.a;
import com.shazam.j.c;
import com.shazam.k.s;
import com.shazam.model.Tag;
import com.shazam.model.Track;
import com.shazam.model.configuration.WearConfiguration;
import com.shazam.model.lyrics.DynamicLyricsData;
import com.shazam.model.wearable.RecognitionResult;
import java.io.ByteArrayOutputStream;
import java.util.List;

public class WearableTagMatchedReceiver extends BroadcastReceiver
{
    private final class a
        implements com.shazam.android.aa.c
    {

        final WearableTagMatchedReceiver a;
        private final String b;

        public final void a(Bitmap bitmap)
        {
            com.shazam.android.receiver.WearableTagMatchedReceiver.a(a, b, bitmap);
        }

        public a(String s1)
        {
            a = WearableTagMatchedReceiver.this;
            super();
            b = s1;
        }
    }


    private final s a = com.shazam.i.b.ah.f.e.a();
    private final com.shazam.b.a.a b = new p();
    private final WearConfiguration c = com.shazam.i.b.n.b.I();
    private final com.shazam.j.b d = com.shazam.i.j.a.b();
    private final com.shazam.android.wearcom.a e = com.shazam.i.b.an.b.a();
    private final com.shazam.android.aa.b f = com.shazam.i.b.aa.b.a();

    public WearableTagMatchedReceiver()
    {
    }

    static void a(WearableTagMatchedReceiver wearabletagmatchedreceiver, String s1, Bitmap bitmap)
    {
        Object obj = new ByteArrayOutputStream();
        bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, ((java.io.OutputStream) (obj)));
        bitmap = Asset.a(((ByteArrayOutputStream) (obj)).toByteArray());
        obj = new n(PutDataRequest.a("/image"));
        ((n) (obj)).a.a("coverArt", bitmap);
        ((n) (obj)).a.a("coverArtUrl", s1);
        s1 = ((n) (obj)).a();
        wearabletagmatchedreceiver = wearabletagmatchedreceiver.e;
        bitmap = new com.shazam.android.wearcom.a.a.a();
        bitmap.a = s1;
        wearabletagmatchedreceiver.a(new com.shazam.android.wearcom.a.a(bitmap, (byte)0));
    }

    public void onReceive(Context context, Intent intent)
    {
        Object obj = a.c();
        if (((List) (obj)).isEmpty())
        {
            return;
        }
        context = intent.getStringExtra("nodeId");
        try
        {
            obj = (Tag)((List) (obj)).get(0);
            Object obj1 = ((Tag) (obj)).track;
            intent = com.shazam.model.details.UriIdentifiedTag.Builder.a();
            intent.tag = ((Tag) (obj));
            Object obj2 = intent.b();
            intent = ((Tag) (obj)).b();
            com.shazam.model.wearable.RecognitionResult.Builder builder = com.shazam.model.wearable.RecognitionResult.Builder.a();
            builder.artistName = ((Track) (obj1)).artistName;
            builder.trackTitle = ((Track) (obj1)).title;
            builder.coverArt = ((Tag) (obj)).b();
            if (c.a())
            {
                builder.dynamicLyricsData = (DynamicLyricsData)b.a(obj2);
            }
            obj = d.a(new RecognitionResult(builder, null));
            obj1 = e;
            obj2 = new com.shazam.android.wearcom.a.b.a();
            obj2.a = "match";
            obj2.b = ((String) (obj));
            obj2.d = context;
            ((com.shazam.android.wearcom.a) (obj1)).a(((com.shazam.android.wearcom.a.b.a) (obj2)).a());
            f.a(intent, new a(intent));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }
}
