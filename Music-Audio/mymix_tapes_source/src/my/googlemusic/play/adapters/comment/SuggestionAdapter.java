// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.adapters.comment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.List;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.model.User;
import my.googlemusic.play.utils.transformations.CropSquareTransformation;

public class SuggestionAdapter extends ArrayAdapter
{
    public static interface OnMentionListener
    {

        public abstract void onMention(User user);
    }


    int layoutResourceId;
    OnMentionListener listener;
    Context mContext;
    Server mServer;
    List suggestions;

    public SuggestionAdapter(Context context, Server server, int i, List list, OnMentionListener onmentionlistener)
    {
        super(context, i, list);
        layoutResourceId = i;
        mContext = context;
        mServer = server;
        suggestions = list;
        listener = onmentionlistener;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        View view1 = view;
        if (view == null)
        {
            View view2 = view;
    /* block-local class not found */
    class MentionListener {}

            ImageView imageview;
            TextView textview;
            TextView textview1;
            try
            {
                view1 = LayoutInflater.from(mContext).inflate(layoutResourceId, viewgroup, false);
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                view.printStackTrace();
                return view2;
            }
            // Misplaced declaration of an exception variable
            catch (ViewGroup viewgroup)
            {
                viewgroup.printStackTrace();
                return view;
            }
        }
        view2 = view1;
        view = view1;
        viewgroup = (User)suggestions.get(i);
        view2 = view1;
        view = view1;
        imageview = (ImageView)view1.findViewById(0x7f0d02a7);
        view2 = view1;
        view = view1;
        textview = (TextView)view1.findViewById(0x7f0d02a8);
        view2 = view1;
        view = view1;
        textview1 = (TextView)view1.findViewById(0x7f0d02a9);
        view2 = view1;
        view = view1;
        ((Button)view1.findViewById(0x7f0d02a6)).setOnClickListener(new MentionListener(viewgroup, listener));
        view2 = view1;
        view = view1;
        textview.setText(viewgroup.getName());
        view2 = view1;
        view = view1;
        textview1.setText(viewgroup.getUsername());
        view2 = view1;
        view = view1;
        Picasso.with(mContext).load(mServer.getLinkUserImage(viewgroup.getId())).placeholder(0x7f0201db).transform(new CropSquareTransformation()).into(imageview);
        return view1;
    }
}
