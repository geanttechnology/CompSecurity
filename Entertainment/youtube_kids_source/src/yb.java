// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.AsyncTask;
import com.google.android.apps.youtube.kids.ui.ScrollAwareHorizontalListView;
import java.util.List;

final class yb extends AsyncTask
{

    private xz a;

    yb(xz xz1)
    {
        a = xz1;
        super();
    }

    protected final Object doInBackground(Object aobj[])
    {
        Object obj = ((String[])aobj)[0];
        aobj = new adr(a.getApplicationContext());
        obj = (new aek(((android.database.sqlite.SQLiteOpenHelper) (aobj)))).getAllRecordingsForVideo(((String) (obj)));
        ((adr) (aobj)).close();
        return obj;
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (List)obj;
        xz.a(a).a(new ads(a.getApplicationContext(), a));
        ((ads)((eyz) (xz.a(a))).c).updateRecordings(((List) (obj)));
    }
}
