// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Message;
import com.fotoable.fotoproedit.activity.font.FontTextLabelInfo;
import java.util.HashMap;

class akh
    implements Runnable
{

    final FontTextLabelInfo a;
    final ama b;
    final int c;
    final akf d;

    akh(akf akf1, FontTextLabelInfo fonttextlabelinfo, ama ama, int i)
    {
        d = akf1;
        a = fonttextlabelinfo;
        b = ama;
        c = i;
        super();
    }

    public void run()
    {
        android.graphics.Bitmap bitmap = akf.a(d, a, b);
        Message message = akf.a(d).obtainMessage();
        HashMap hashmap = new HashMap();
        hashmap.put("bitmap", bitmap);
        hashmap.put("position", Integer.valueOf(c));
        message.obj = hashmap;
        akf.a(d).sendMessage(message);
        akf.a(d, c, bitmap);
    }
}
