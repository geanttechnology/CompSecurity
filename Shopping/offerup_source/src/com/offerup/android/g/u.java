// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.t;
import android.support.v4.b.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.b.a.a.g;
import com.b.a.a.j;
import com.offerup.android.dto.Rating;
import com.offerup.android.dto.UserProfileModel;
import com.offerup.android.utils.l;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Target;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.g:
//            v, w

public final class u extends Fragment
    implements Target
{

    private ImageView a;
    private ImageView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private RatingBar f;
    private TextView g;
    private View h;
    private w i;
    private UserProfileModel j;
    private boolean k;
    private ProgressDialog l;

    public u()
    {
        i = null;
    }

    static w a(u u1)
    {
        return u1.i;
    }

    private void a()
    {
        if (j != null)
        {
            int i1;
            if (j.getId() == com.b.a.a.j.a().n())
            {
                if (j.isUsingDefaultAvatar())
                {
                    LayerDrawable layerdrawable = new LayerDrawable(new Drawable[] {
                        android.support.v4.b.a.a(getActivity().getApplicationContext(), 0x7f0201b9), android.support.v4.b.a.a(getActivity().getApplicationContext(), 0x7f0201ba)
                    });
                    b.setImageDrawable(layerdrawable);
                    h.setVisibility(8);
                } else
                {
                    l = ProgressDialog.show(getActivity(), "", getString(0x7f0901b1));
                    l l1 = new l(android.support.v4.b.a.b(getActivity().getApplicationContext(), 0x7f0e00f7));
                    Picasso.with(getActivity().getApplicationContext()).load(j.getProfilePictureUrl()).transform(l1).into(this);
                    h.setVisibility(0);
                }
                b.setOnClickListener(new v(this));
            } else
            {
                l = ProgressDialog.show(getActivity(), "", getString(0x7f0901b1));
                l l2 = new l(android.support.v4.b.a.b(getActivity().getApplicationContext(), 0x7f0e00f7));
                Picasso.with(getActivity().getApplicationContext()).load(j.getProfilePictureUrl()).transform(l2).into(this);
                h.setVisibility(8);
            }
            if (StringUtils.isNotEmpty(j.getBackgroundPictureUrl()))
            {
                Picasso.with(getActivity().getApplicationContext()).load(j.getBackgroundPictureUrl()).into(a);
            }
            if (StringUtils.isNotEmpty(j.getName()))
            {
                c.setText(j.getName());
            }
            if (j.getJoinedDate() != null)
            {
                d.setText(String.format(getString(0x7f090217), new Object[] {
                    (new StringBuilder()).append(j.getJoinedDate().a("MMMM", Locale.ENGLISH)).append(" ").append(j.getJoinedDate().b()).toString()
                }));
            }
            if (StringUtils.isNotEmpty(j.getLocationName()))
            {
                g.setText(j.getLocationName());
            }
            f.setRating(j.getRating().getAverage());
            i1 = j.getRating().getCount();
            if (i1 == 1)
            {
                e.setText(String.format("%d Rating", new Object[] {
                    Integer.valueOf(i1)
                }));
            } else
            {
                e.setText(String.format("%d Ratings", new Object[] {
                    Integer.valueOf(i1)
                }));
            }
            k = false;
            return;
        } else
        {
            com.b.a.a.g.a(this, new Throwable("Unable to update UI with null model"));
            return;
        }
    }

    public final void a(UserProfileModel userprofilemodel)
    {
        j = userprofilemodel;
        if (j != null && isResumed())
        {
            k = true;
            a();
        }
    }

    public final void onAttach(Context context)
    {
        super.onAttach(context);
        try
        {
            i = (w)getActivity();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new ClassCastException((new StringBuilder()).append(getActivity().toString()).append(" must implement ProfileHeaderFragmentListener").toString());
        }
    }

    public final void onBitmapFailed(Drawable drawable)
    {
    }

    public final void onBitmapLoaded(Bitmap bitmap, com.squareup.picasso.Picasso.LoadedFrom loadedfrom)
    {
        if (l != null && l.isShowing())
        {
            l.dismiss();
        }
        bitmap = new LayerDrawable(new Drawable[] {
            new BitmapDrawable(getResources(), bitmap), android.support.v4.b.a.a(getActivity().getApplicationContext(), 0x7f0201ba)
        });
        b.setImageDrawable(bitmap);
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f04009a, viewgroup, false);
        a = (ImageView)layoutinflater.findViewById(0x7f10026a);
        b = (ImageView)layoutinflater.findViewById(0x7f10026c);
        h = layoutinflater.findViewById(0x7f10026d);
        c = (TextView)layoutinflater.findViewById(0x7f10026e);
        d = (TextView)layoutinflater.findViewById(0x7f10026f);
        e = (TextView)layoutinflater.findViewById(0x7f10021b);
        f = (RatingBar)layoutinflater.findViewById(0x7f10021a);
        g = (TextView)layoutinflater.findViewById(0x7f10026b);
        return layoutinflater;
    }

    public final void onDestroyView()
    {
        super.onDestroyView();
        unregisterForContextMenu(b);
    }

    public final void onDetach()
    {
        i = null;
        super.onDetach();
    }

    public final void onPrepareLoad(Drawable drawable)
    {
    }

    public final void onResume()
    {
        super.onResume();
        if (!k && j != null)
        {
            a();
        }
    }
}
