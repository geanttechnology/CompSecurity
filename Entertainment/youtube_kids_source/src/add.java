// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Dialog;
import android.widget.ArrayAdapter;
import java.util.List;

final class add
    implements bhv
{

    private adc a;

    add(adc adc1)
    {
        a = adc1;
        super();
    }

    public final void a(Object obj, Exception exception)
    {
        bmd.a(a.a.getContext(), 0x7f0b0117, 0);
    }

    public final void a(Object obj, Object obj1)
    {
        obj1 = (List)obj1;
        Object obj2 = a.a;
        obj = ((act) (obj2)).a;
        obj2 = new acv(((act) (obj2)));
        b.b(obj2, "listener cannot be null");
        ((sv) (obj)).a();
        obj1 = new ArrayAdapter(((sv) (obj)).a, 0x1090011, ((List) (obj1)));
        obj2 = new sw(((sv) (obj)), ((ArrayAdapter) (obj1)), ((sx) (obj2)));
        obj.b = (new blz(((sv) (obj)).a)).setTitle(0x7f0b0116).setSingleChoiceItems(((android.widget.ListAdapter) (obj1)), 0, ((android.content.DialogInterface.OnClickListener) (obj2))).create();
        ((sv) (obj)).b.show();
    }
}
