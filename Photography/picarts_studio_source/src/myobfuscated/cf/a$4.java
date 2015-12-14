// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cf;

import android.view.View;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.brushlib.brush.Brush;
import com.socialin.android.brushlib.brush.BrushHistory;
import com.socialin.android.photo.draw.dialog.SelectBrushDialog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package myobfuscated.cf:
//            a

final class it>
    implements android.view..OnClickListener
{

    private a a;

    public final void onClick(View view)
    {
        view = a.F;
        int i = a.z;
        ((SelectBrushDialog) (view)).b.resetBrushParams(i, ((SelectBrushDialog) (view)).c);
        view.a(i);
        JSONArray jsonarray = new JSONArray();
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("name", "");
            jsonobject.put("value", "-1");
            jsonarray.put(jsonobject);
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
        }
        AnalyticUtils.getInstance(view).track(new com.socialin.android.apiv3.events.tsFactory.DrawingBrushSettingsChangedEvent(((SelectBrushDialog) (view)).f, ((SelectBrushDialog) (view)).e, ((SelectBrushDialog) (view)).d, jsonarray, ((SelectBrushDialog) (view)).a.e(), ((SelectBrushDialog) (view)).c, true));
    }

    on(a a1)
    {
        a = a1;
        super();
    }
}
