// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.animation.Animator;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.EditorProject;
import com.picsart.studio.editor.Tool;
import com.picsart.studio.editor.activity.EditorActivity;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.history.RasterAction;
import com.picsart.studio.editor.view.StickerEditorView;
import com.socialin.android.photo.view.StickerPreviewView;
import com.socialin.android.util.ag;
import com.socialin.android.util.ai;
import com.socialin.android.util.ak;
import com.socialin.android.util.c;
import com.socialin.android.util.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import myobfuscated.f.m;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            i

public final class x extends i
{

    private static final List c;
    private int d;
    private StickerEditorView e;
    private View f;
    private SeekBar i;
    private SeekBar j;
    private SeekBar k;
    private TextView l;
    private TextView m;
    private TextView n;
    private StickerPreviewView o;
    private Spinner p;

    public x()
    {
        d = 1;
    }

    static int a(x x1, int i1)
    {
        x1.d = i1;
        return i1;
    }

    static StickerEditorView a(x x1)
    {
        return x1.e;
    }

    private void a(Bundle bundle)
    {
        int i1 = 0;
        int j1 = bundle.getInt("stickerIndex");
        bundle = com.socialin.android.util.c.a(ak.a(getActivity()).b(j1), null, ak.a);
        j1 = ak.a(getActivity()).c(j1);
        e.setStickerBitmap(bundle);
        e.setStickerBlendingMode(j1);
        e.setStickerHue(0);
        e.setStickerOpacity(255);
        i.setProgress(e.j);
        j.setProgress(Math.round(e.l * 100F - 1.0F));
        k.setProgress(e.i);
        o.setBitmap(e.m);
        o.setOpacity(e.j);
        o.setHue(e.i);
        if (e.j >= 0)
        {
            i1 = e.j;
        }
        l.setText((new StringBuilder(": ")).append(i1).toString());
        i.setProgress(i1);
        i1 = Math.round(e.l * 100F - 1.0F);
        m.setText((new StringBuilder(" ")).append(i1 + 1).append("%").toString());
        j.setProgress(i1);
        i1 = e.i;
        n.setText((new StringBuilder(" ")).append(i1).toString());
        k.setProgress(i1);
        i1 = c.indexOf(Integer.valueOf(e.k));
        p.setSelection(i1);
    }

    static StickerPreviewView b(x x1)
    {
        return x1.o;
    }

    static TextView c(x x1)
    {
        return x1.l;
    }

    static TextView d(x x1)
    {
        return x1.m;
    }

    static TextView e(x x1)
    {
        return x1.n;
    }

    static int f(x x1)
    {
        return x1.d;
    }

    static View g(x x1)
    {
        return x1.f;
    }

    static List i()
    {
        return c;
    }

    public final void a(Bitmap bitmap)
    {
        super.a(bitmap);
        if (e != null)
        {
            e.setImage(bitmap);
        }
    }

    public final Tool e()
    {
        return Tool.STICKER;
    }

    public final void onActivityResult(int i1, int j1, Intent intent)
    {
        com.picsart.studio.editor.activity.EditorActivity.RequestCode requestcode;
        super.onActivityResult(i1, j1, intent);
        requestcode = com.picsart.studio.editor.activity.EditorActivity.RequestCode.fromInt(i1);
        if (requestcode == null) goto _L2; else goto _L1
_L1:
        final class _cls2
        {

            static final int a[];

            static 
            {
                a = new int[com.picsart.studio.editor.activity.EditorActivity.RequestCode.values().length];
                try
                {
                    a[com.picsart.studio.editor.activity.EditorActivity.RequestCode.SELECT_STICKER.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
            }
        }

        _cls2.a[requestcode.ordinal()];
        JVM INSTR tableswitch 1 1: default 44
    //                   1 45;
           goto _L2 _L3
_L2:
        return;
_L3:
        if (j1 == -1)
        {
            a(intent.getExtras());
            return;
        }
        if (e.m != null)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (i1 == 0)
        {
            g.a(this);
            return;
        }
        if (true) goto _L2; else goto _L4
_L4:
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f03011c, viewgroup, false);
    }

    public final void onResume()
    {
        super.onResume();
        int i1;
        if (e.j < 0)
        {
            i1 = 0;
        } else
        {
            i1 = e.j;
        }
        l.setText((new StringBuilder(": ")).append(i1).toString());
        i1 = e.i;
        n.setText((new StringBuilder(" ")).append(i1).toString());
    }

    public final void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        e = (StickerEditorView)view.findViewById(0x7f1001c2);
        e.setImage(h);
        f = view.findViewById(0x7f10061d);
        i = (SeekBar)view.findViewById(0x7f100623);
        i.setOnSeekBarChangeListener(new ai() {

            private x a;

            public final void onProgressChanged(SeekBar seekbar, int j1, boolean flag)
            {
                x.a(a).setStickerOpacity(j1);
                x.b(a).setOpacity(j1);
                com.picsart.studio.editor.fragment.x.c(a).setText((new StringBuilder(": ")).append(j1).toString());
                x.a(a).invalidate();
            }

            public final void onStartTrackingTouch(SeekBar seekbar)
            {
                x.a(a).n = true;
                x.a(a).invalidate();
            }

            public final void onStopTrackingTouch(SeekBar seekbar)
            {
                x.a(a).n = false;
                x.a(a).invalidate();
            }

            
            {
                a = x.this;
                super();
            }
        });
        j = (SeekBar)view.findViewById(0x7f100621);
        j.setOnSeekBarChangeListener(new ai() {

            private x a;

            public final void onProgressChanged(SeekBar seekbar, int j1, boolean flag)
            {
                x.a(a).setStickerScale((float)(j1 + 1) / 100F);
                com.picsart.studio.editor.fragment.x.d(a).setText((new StringBuilder(" ")).append(j1 + 1).append("%").toString());
                x.a(a).invalidate();
            }

            public final void onStartTrackingTouch(SeekBar seekbar)
            {
                x.a(a).n = true;
                x.a(a).invalidate();
            }

            public final void onStopTrackingTouch(SeekBar seekbar)
            {
                x.a(a).n = false;
                x.a(a).invalidate();
            }

            
            {
                a = x.this;
                super();
            }
        });
        k = (SeekBar)view.findViewById(0x7f100625);
        k.setOnSeekBarChangeListener(new ai() {

            private x a;

            public final void onProgressChanged(SeekBar seekbar, int j1, boolean flag)
            {
                x.a(a).setStickerHue(j1);
                x.b(a).setHue(j1);
                com.picsart.studio.editor.fragment.x.e(a).setText((new StringBuilder(" ")).append(j1).toString());
                x.a(a).invalidate();
            }

            public final void onStartTrackingTouch(SeekBar seekbar)
            {
                x.a(a).n = true;
                x.a(a).invalidate();
            }

            public final void onStopTrackingTouch(SeekBar seekbar)
            {
                x.a(a).n = false;
                x.a(a).invalidate();
            }

            
            {
                a = x.this;
                super();
            }
        });
        o = (StickerPreviewView)view.findViewById(0x7f10061f);
        view.findViewById(0x7f1003a3).setOnClickListener(new android.view.View.OnClickListener() {

            private x a;

            public final void onClick(View view1)
            {
                x.a(a).e();
            }

            
            {
                a = x.this;
                super();
            }
        });
        view.findViewById(0x7f100626).setOnClickListener(new android.view.View.OnClickListener() {

            final x a;

            public final void onClick(View view1)
            {
                if (x.f(a) == 1)
                {
                    x.a(a, 4);
                    x.g(a).animate().alpha(0.0F).setListener(new ag(this) {

                        private _cls6 a;

                        public final void onAnimationEnd(Animator animator)
                        {
                            super.onAnimationEnd(animator);
                            x.g(a.a).setVisibility(8);
                            x.a(a.a, 3);
                        }

            
            {
                a = _pcls6;
                super();
            }
                    });
                } else
                if (x.f(a) == 3)
                {
                    x.a(a, 2);
                    x.g(a).setVisibility(0);
                    x.g(a).animate().alpha(1.0F).setListener(new ag(this) {

                        private _cls6 a;

                        public final void onAnimationEnd(Animator animator)
                        {
                            super.onAnimationEnd(animator);
                            x.a(a.a, 1);
                        }

            
            {
                a = _pcls6;
                super();
            }
                    });
                    return;
                }
            }

            
            {
                a = x.this;
                super();
            }
        });
        view.findViewById(0x7f100627).setOnClickListener(new android.view.View.OnClickListener() {

            private x a;

            public final void onClick(View view1)
            {
                ((EditorActivity)a.getActivity()).a(a);
            }

            
            {
                a = x.this;
                super();
            }
        });
        view.findViewById(0x7f100550).setOnClickListener(new android.view.View.OnClickListener() {

            private x a;

            public final void onClick(View view1)
            {
                com.picsart.studio.editor.e.a().e.d("sticker");
                view1 = x.a(a).f();
                if (view1 != null)
                {
                    a.g.a(a, view1, RasterAction.create(view1, com.picsart.studio.editor.e.a().d.getHistoryDataDirectory()));
                }
            }

            
            {
                a = x.this;
                super();
            }
        });
        view.findViewById(0x7f10054f).setOnClickListener(new android.view.View.OnClickListener() {

            private x a;

            public final void onClick(View view1)
            {
                a.g.a(a);
            }

            
            {
                a = x.this;
                super();
            }
        });
        Object obj = new ArrayList();
        int i1;
        for (Iterator iterator = c.iterator(); iterator.hasNext(); ((List) (obj)).add(d.a.get(i1)))
        {
            i1 = ((Integer)iterator.next()).intValue();
        }

        p = (Spinner)view.findViewById(0x7f10061e);
        obj = new ArrayAdapter(getActivity(), 0x1090008, ((List) (obj)));
        ((ArrayAdapter) (obj)).setDropDownViewResource(0x7f03024f);
        p.setAdapter(((android.widget.SpinnerAdapter) (obj)));
        p.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {

            private x a;

            public final void onItemSelected(AdapterView adapterview, View view1, int j1, long l1)
            {
                x.a(a).setStickerBlendingMode(((Integer)x.i().get(j1)).intValue());
            }

            public final void onNothingSelected(AdapterView adapterview)
            {
            }

            
            {
                a = x.this;
                super();
            }
        });
        l = (TextView)view.findViewById(0x7f100622);
        m = (TextView)view.findViewById(0x7f100620);
        n = (TextView)view.findViewById(0x7f100624);
        if (getArguments() != null && bundle == null)
        {
            a(getArguments());
        }
    }

    static 
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(Integer.valueOf(-1));
        arraylist.add(Integer.valueOf(0));
        arraylist.add(Integer.valueOf(4));
        if (myobfuscated.f.m.i())
        {
            arraylist.add(Integer.valueOf(2));
        }
        if (myobfuscated.f.m.j())
        {
            arraylist.add(Integer.valueOf(5));
        }
        c = arraylist;
    }
}
