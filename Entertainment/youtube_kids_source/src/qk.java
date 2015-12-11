// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.ConditionVariable;

final class qk
    implements Runnable
{

    private qj a;

    qk(qj qj1, qi qi1)
    {
        a = qj1;
        super();
    }

    public final void run()
    {
        Object obj;
        qj qj1;
        Object obj1;
        Object obj2;
        btu btu1 = null;
        qj1 = a;
        obj = qj1.d;
        b.b();
        obj1 = (new StringBuilder("id")).append(" = ? AND account").append(" = ? AND gaia_id");
        byte abyte0[];
        byte abyte1[];
        dlb dlb1;
        int i;
        if (qj1.a.b.d() != null)
        {
            ((StringBuilder) (obj1)).append(" = ?");
            obj = new String[3];
            obj[0] = qj1.a.c;
            obj[1] = qj1.a.b.c();
            obj[2] = qj1.a.b.d();
        } else
        {
            ((StringBuilder) (obj1)).append(" IS NULL");
            obj = new String[2];
            obj[0] = qj1.a.c;
            obj[1] = qj1.a.b.c();
        }
        obj1 = qj1.d.a.getReadableDatabase().query("identity", qr.a, ((StringBuilder) (obj1)).toString(), ((String []) (obj)), null, null, null, null);
        obj2 = qv.a;
        if (!((Cursor) (obj1)).moveToNext()) goto _L2; else goto _L1
_L1:
        i = ((Cursor) (obj1)).getColumnIndexOrThrow("profile_account_name_proto");
        if (((Cursor) (obj1)).isNull(i)) goto _L4; else goto _L3
_L3:
        abyte1 = ((Cursor) (obj1)).getBlob(i);
        obj = ((Cursor) (obj1)).getBlob(((Cursor) (obj1)).getColumnIndexOrThrow("profile_account_photo_thumbnails_proto"));
        abyte0 = ((Cursor) (obj1)).getBlob(((Cursor) (obj1)).getColumnIndexOrThrow("profile_mobile_banner_thumbnails_proto"));
        obj2 = qj1.a.b.c();
        dlb1 = (dlb)eun.a(new dlb(), abyte1);
        if (obj == null) goto _L6; else goto _L5
_L5:
        obj = new btu((dzp)eun.a(new dzp(), ((byte []) (obj))));
_L14:
        if (abyte0 == null)
        {
            break MISSING_BLOCK_LABEL_297;
        }
        btu1 = new btu((dzp)eun.a(new dzp(), abyte0));
        qj1.c = new qv(((String) (obj2)), dlb1, ((btu) (obj)), btu1);
        ((Cursor) (obj1)).close();
_L9:
        a.b.open();
        return;
_L4:
        int j = ((Cursor) (obj1)).getColumnIndexOrThrow("profile_display_name");
        if (((Cursor) (obj1)).isNull(j)) goto _L8; else goto _L7
_L7:
        qj1.c = new qv(((Cursor) (obj1)).getString(j), ((Cursor) (obj1)).getString(((Cursor) (obj1)).getColumnIndexOrThrow("profile_display_email")), bja.a(((Cursor) (obj1)), ((Cursor) (obj1)).getColumnIndexOrThrow("profile_thumbnail_uri")));
        ((Cursor) (obj1)).close();
          goto _L9
_L2:
        StringBuilder stringbuilder;
        obj = qj1.d;
        b.b();
        stringbuilder = (new StringBuilder("id")).append(" IS NULL AND account").append(" = ? AND gaia_id");
        if (qj1.a.b.d() == null) goto _L11; else goto _L10
_L10:
        stringbuilder.append(" = ?");
        obj = new String[2];
        obj[0] = qj1.a.b.c();
        obj[1] = qj1.a.b.d();
_L12:
        qj1.d.a.getWritableDatabase().delete("identity", stringbuilder.toString(), ((String []) (obj)));
_L8:
        qj1.c = ((qv) (obj2));
        ((Cursor) (obj1)).close();
          goto _L9
_L11:
        stringbuilder.append(" IS NULL");
        obj = new String[1];
        obj[0] = qj1.a.b.c();
          goto _L12
        obj;
        bmo.a("Error parsing profile data", ((Throwable) (obj)));
        ((Cursor) (obj1)).close();
          goto _L9
        obj;
        ((Cursor) (obj1)).close();
        throw obj;
_L6:
        obj = null;
        if (true) goto _L14; else goto _L13
_L13:
    }
}
