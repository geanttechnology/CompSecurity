// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import com.bestbuy.android.api.lib.models.registry.RegistryWishList;
import com.bestbuy.android.bbyobjects.BBYTextView;
import java.util.ArrayList;
import java.util.List;

public class de extends ArrayAdapter
{

    public List a;
    Activity b;
    private LayoutInflater c;

    public de(Activity activity, int i, ArrayList arraylist)
    {
        super(activity, i);
        b = activity;
        a = arraylist;
        if (activity != null)
        {
            c = LayoutInflater.from(activity);
        }
    }

    public int a(RegistryWishList registrywishlist)
    {
        return a.indexOf(registrywishlist);
    }

    public int getCount()
    {
        return a.size();
    }

    public long getItemId(int i)
    {
        return 1L;
    }

    public int getItemViewType(int i)
    {
        return i != a.size() ? 0 : 1;
    }

    public int getPosition(Object obj)
    {
        return a((RegistryWishList)obj);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        String s;
        RegistryWishList registrywishlist;
        if (view == null)
        {
            view = c.inflate(0x7f03006d, viewgroup, false);
            viewgroup = new df();
            viewgroup.a = (BBYTextView)view.findViewById(0x7f0c0186);
            viewgroup.b = (BBYTextView)view.findViewById(0x7f0c0185);
            viewgroup.c = (ImageView)view.findViewById(0x7f0c0184);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (df)view.getTag();
        }
        if (a == null) goto _L2; else goto _L1
_L1:
        registrywishlist = (RegistryWishList)a.get(i);
        if (registrywishlist == null) goto _L2; else goto _L3
_L3:
        BBYTextView bbytextview = ((df) (viewgroup)).b;
        if (registrywishlist.getShortDescription().length() > 25)
        {
            s = (new StringBuilder()).append(registrywishlist.getShortDescription().substring(0, 24)).append("...").toString();
        } else
        {
            s = registrywishlist.getShortDescription();
        }
        bbytextview.setText(s);
        if (!registrywishlist.getPrivacySetting().equals("public")) goto _L5; else goto _L4
_L4:
        ((df) (viewgroup)).a.setText("Public List");
_L7:
        s = registrywishlist.getType();
        if (!s.equalsIgnoreCase("null"))
        {
            break; /* Loop/switch isn't completed */
        }
        ((df) (viewgroup)).c.setImageResource(0);
_L2:
        return view;
_L5:
        if (registrywishlist.getPrivacySetting().equals("private"))
        {
            ((df) (viewgroup)).a.setText("Private List");
        }
        if (true) goto _L7; else goto _L6
_L6:
        if (s.equalsIgnoreCase("backtoschoollists"))
        {
            ((df) (viewgroup)).c.setImageResource(0x7f020017);
            return view;
        }
        if (s.equalsIgnoreCase("holidaylists"))
        {
            ((df) (viewgroup)).c.setImageResource(0x7f0200e4);
            return view;
        }
        if (s.equalsIgnoreCase("graduationlists"))
        {
            ((df) (viewgroup)).c.setImageResource(0x7f0200df);
            return view;
        }
        if (s.equalsIgnoreCase("anniversarylists"))
        {
            ((df) (viewgroup)).c.setImageResource(0x7f02000c);
            return view;
        }
        if (s.equalsIgnoreCase("weddinglists"))
        {
            ((df) (viewgroup)).c.setImageResource(0x7f0201b7);
            return view;
        }
        if (s.equalsIgnoreCase("birthdaylists"))
        {
            ((df) (viewgroup)).c.setImageResource(0x7f020044);
            return view;
        }
        if (s.equalsIgnoreCase("movinglists"))
        {
            ((df) (viewgroup)).c.setImageResource(0x7f02011a);
            return view;
        } else
        {
            ((df) (viewgroup)).c.setImageResource(0x7f0200ab);
            return view;
        }
    }

    public int getViewTypeCount()
    {
        return 2;
    }
}
