// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.picsart.studio.editor.Camera;
import com.picsart.studio.editor.f;
import com.picsart.studio.editor.g;
import com.picsart.studio.editor.gizmo.Gizmo;
import com.picsart.studio.editor.item.BrushEditableItem;
import com.picsart.studio.editor.item.Item;
import com.picsart.studio.editor.item.TransformingItem;
import com.picsart.studio.editor.item.d;
import com.picsart.studio.editor.utils.UserSavedState;
import com.socialin.android.util.Geom;
import com.socialin.android.util.c;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import myobfuscated.bq.a;
import myobfuscated.bq.b;

// Referenced classes of package com.picsart.studio.editor.view:
//            EditorView, g, h

public class ItemEditorView extends EditorView
{

    private float A;
    private final d B;
    protected List i;
    protected Item j;
    public boolean k;
    public boolean l;
    private Gizmo m;
    private f n;
    private Item o;
    private MotionEvent p;
    private Set q;
    private Set r;
    private PointF s;
    private float t;
    private boolean u;
    private a v;
    private com.socialin.android.colorpicker.c w;
    private boolean x;
    private Bitmap y;
    private float z;

    public ItemEditorView(Context context)
    {
        this(context, null);
    }

    public ItemEditorView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ItemEditorView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        k = false;
        l = false;
        x = false;
        B = new d() {

            private ItemEditorView a;

            public final void a(Item item)
            {
                com.picsart.studio.editor.view.ItemEditorView.a(a, item);
            }

            
            {
                a = ItemEditorView.this;
                super();
            }
        };
        i = new LinkedList();
        s = new PointF();
        t = getResources().getDimension(0x7f0b00ea);
        z = getResources().getDimension(0x7f0b00de);
        A = getResources().getDimension(0x7f0b00df);
        q = new HashSet(1);
        r = new HashSet(1);
        a(new com.picsart.studio.editor.view.g() {

            private ItemEditorView a;

            public final void a()
            {
                com.picsart.studio.editor.view.ItemEditorView.a(a);
                a.invalidate();
            }

            public final void a(Item item)
            {
                com.picsart.studio.editor.view.ItemEditorView.a(a);
                a.invalidate();
            }

            
            {
                a = ItemEditorView.this;
                super();
            }
        });
        a(new h() {

            private ItemEditorView a;

            public final void a(Item item)
            {
                a.invalidate();
            }

            
            {
                a = ItemEditorView.this;
                super();
            }
        });
        setSinglePointerGestureEnabled(false);
        v = new a(getResources(), new b() {

            private ItemEditorView a;

            public final int a(int j1, int k1)
            {
                return com.picsart.studio.editor.view.ItemEditorView.b(a).getPixel(Math.min(Math.max(j1 / 2, 0), com.picsart.studio.editor.view.ItemEditorView.b(a).getWidth() - 1), Math.min(Math.max(k1 / 2, 0), com.picsart.studio.editor.view.ItemEditorView.b(a).getHeight() - 1));
            }

            
            {
                a = ItemEditorView.this;
                super();
            }
        });
    }

    private Item a(float f1, float f2)
    {
        Object obj = null;
        int i1 = i.size() - 1;
        Item item;
label0:
        do
        {
label1:
            {
                item = obj;
                if (i1 >= 0)
                {
                    item = (Item)i.get(i1);
                    if (!item.k || !item.a(c, f1, f2))
                    {
                        break label1;
                    }
                }
                if (item == null)
                {
                    for (i1 = i.size() - 1; i1 >= 0; i1--)
                    {
                        Item item1 = (Item)i.get(i1);
                        if (!item1.k || !(item1 instanceof TransformingItem))
                        {
                            continue;
                        }
                        TransformingItem transformingitem = (TransformingItem)item1;
                        if (transformingitem.b(c) > z || transformingitem.b(c) > z)
                        {
                            continue;
                        }
                        float f3 = A;
                        float f4 = c.e;
                        if (Geom.b(transformingitem.r().a(), transformingitem.r().b(), f1, f2) <= f3 * f4)
                        {
                            return item1;
                        }
                    }

                }
                break label0;
            }
            i1--;
        } while (true);
        return item;
    }

    static void a(ItemEditorView itemeditorview)
    {
        itemeditorview.u = false;
        Iterator iterator = itemeditorview.i.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (((Item)iterator.next()).n() != 1)
            {
                continue;
            }
            itemeditorview.u = true;
            break;
        } while (true);
    }

    static void a(ItemEditorView itemeditorview, Item item)
    {
        for (itemeditorview = itemeditorview.q.iterator(); itemeditorview.hasNext(); ((com.picsart.studio.editor.view.g)itemeditorview.next()).a(item)) { }
    }

    static Bitmap b(ItemEditorView itemeditorview)
    {
        return itemeditorview.y;
    }

    private void b(Canvas canvas)
    {
        for (int i1 = 0; i1 < i.size(); i1++)
        {
            Item item = (Item)i.get(i1);
            if (!item.k)
            {
                continue;
            }
            if (k && i1 == i.size() - 1)
            {
                b.setColor(0xffff0000);
                b.setAlpha(70);
                if (e != null)
                {
                    canvas.drawRect(0.0F, 0.0F, e.getWidth(), e.getHeight(), b);
                }
            }
            if (!l && !x || !item.equals(j))
            {
                item.a(canvas);
            }
        }

    }

    static boolean c(ItemEditorView itemeditorview)
    {
        return itemeditorview.k;
    }

    private void j()
    {
        for (Iterator iterator = q.iterator(); iterator.hasNext(); ((com.picsart.studio.editor.view.g)iterator.next()).a()) { }
    }

    protected final void a(Canvas canvas)
    {
        if (e == null) goto _L2; else goto _L1
_L1:
        Iterator iterator;
        c.b(canvas);
        canvas.clipRect(0, 0, e.getWidth(), e.getHeight());
        canvas.save();
        canvas.scale((float)e.getWidth() / (float)f.getWidth(), (float)e.getHeight() / (float)f.getHeight());
        canvas.drawBitmap(f, 0.0F, 0.0F, a);
        canvas.restore();
        iterator = i.iterator();
_L6:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        if (((Item)iterator.next()).n() != 6) goto _L6; else goto _L5
_L5:
        boolean flag = true;
_L8:
        if (flag)
        {
            canvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null, 31);
            b(canvas);
            canvas.restore();
            canvas.save(2);
            canvas.clipRect(0.0F, 0.0F, getWidth(), getHeight(), android.graphics.Region.Op.DIFFERENCE);
            b(canvas);
            canvas.restore();
        } else
        {
            b(canvas);
        }
        canvas.restore();
        if (!x && l)
        {
            v.a(canvas);
        }
        if (m != null && !k && !l && !x)
        {
            m.a(canvas, c);
        }
_L2:
        return;
_L4:
        flag = false;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public final void a(Item item)
    {
        item.n = B;
        i.add(item);
        j();
    }

    public final void a(com.picsart.studio.editor.view.g g1)
    {
        q.add(g1);
    }

    public final void a(h h1)
    {
        r.add(h1);
    }

    protected final boolean d()
    {
        return o == null && (n == null || !n.b);
    }

    public final void e()
    {
        x = true;
        y = com.socialin.android.util.c.a(getWidth() / 2, getHeight() / 2, android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(y);
        canvas.scale(0.5F, 0.5F);
        draw(canvas);
        x = false;
        l = true;
        v.a(y.getWidth(), y.getHeight());
        v.a = y.getPixel(y.getWidth() / 2, y.getHeight() / 2);
    }

    public final Bitmap f()
    {
        if (e != null)
        {
            Bitmap bitmap = e.copy(android.graphics.Bitmap.Config.ARGB_8888, true);
            b(new Canvas(bitmap));
            return bitmap;
        } else
        {
            return null;
        }
    }

    public final List g()
    {
        return Collections.unmodifiableList(i);
    }

    public final Item h()
    {
        return j;
    }

    public final void i()
    {
        if (j != null)
        {
            Item item = j;
            if (j == item)
            {
                setSelectedItem(null);
            }
            item.n = null;
            i.remove(item);
            j();
        }
    }

    protected void onDraw(Canvas canvas)
    {
        if (u)
        {
            canvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null, 31);
            a(canvas);
            canvas.restore();
            return;
        } else
        {
            super.onDraw(canvas);
            return;
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        SavedState savedstate = (SavedState)parcelable;
        super.onRestoreInstanceState(((UserSavedState) (savedstate)).a);
        i = com.picsart.studio.editor.view.SavedState.a(savedstate);
        Iterator iterator;
        if (com.picsart.studio.editor.view.SavedState.b(savedstate) < 0)
        {
            parcelable = null;
        } else
        {
            parcelable = (Item)i.get(com.picsart.studio.editor.view.SavedState.b(savedstate));
        }
        for (iterator = i.iterator(); iterator.hasNext();)
        {
            ((Item)iterator.next()).n = B;
        }

        setBrushMode(com.picsart.studio.editor.view.SavedState.c(savedstate));
        setSelectedItem(parcelable);
    }

    protected Parcelable onSaveInstanceState()
    {
        return new SavedState(super.onSaveInstanceState(), this);
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        super.onSizeChanged(i1, j1, k1, l1);
        if (i1 != 0 && j1 != 0 && l)
        {
            e();
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        float f1;
        float f2;
        super.onTouchEvent(motionevent);
        f1 = motionevent.getX();
        f2 = motionevent.getY();
        if (!l) goto _L2; else goto _L1
_L1:
        if (motionevent.getActionMasked() == 1)
        {
            w.a(v.a);
            y.recycle();
            l = false;
        } else
        {
            v.a(motionevent.getActionMasked(), f1, f2);
        }
        invalidate();
_L4:
        return true;
_L2:
        if (o == null)
        {
            break; /* Loop/switch isn't completed */
        }
        switch (motionevent.getActionMasked())
        {
        case 3: // '\003'
        case 4: // '\004'
        default:
            return true;

        case 1: // '\001'
            if (motionevent.getEventTime() - motionevent.getDownTime() <= 500L && !k)
            {
                setSelectedItem(o);
                n = m.a(motionevent, c, false);
                o = null;
            } else
            if (k)
            {
                BrushEditableItem brusheditableitem = (BrushEditableItem)j;
                motionevent.getX();
                motionevent.getY();
                brusheditableitem.d();
            }
            // fall through

        case 5: // '\005'
            p.recycle();
            o = null;
            return true;

        case 2: // '\002'
            if (Geom.b(f1, f2, p.getX(), p.getY()) >= t && !k)
            {
                setSelectedItem(o);
                m.a(p, c, true);
                n = m.a(motionevent, c, false);
                o = null;
                p.recycle();
                return true;
            }
            break;
        }
        if (k)
        {
            s.set(motionevent.getX(), motionevent.getY());
            motionevent = c;
            PointF pointf = s;
            motionevent.a(pointf, pointf);
            ((BrushEditableItem)j).a(s.x, s.y);
            invalidate();
            return true;
        }
        if (true) goto _L4; else goto _L3
_L3:
        s.set(f1, f2);
        Object obj = c;
        PointF pointf1 = s;
        ((Camera) (obj)).a(pointf1, pointf1);
        if (m == null || k)
        {
            break; /* Loop/switch isn't completed */
        }
        n = m.a(motionevent, c, false);
        if (n.a)
        {
            continue; /* Loop/switch isn't completed */
        }
        setSelectedItem(null);
        n = null;
        switch (motionevent.getActionMasked())
        {
        default:
            return true;

        case 0: // '\0'
            obj = a(s.x, s.y);
            break;
        }
        if (obj != null)
        {
            o = ((Item) (obj));
            p = MotionEvent.obtain(motionevent);
            return true;
        }
        continue; /* Loop/switch isn't completed */
        if (n.b) goto _L4; else goto _L5
_L5:
        Item item;
        switch (motionevent.getActionMasked())
        {
        default:
            return true;

        case 0: // '\0'
            item = a(s.x, s.y);
            break;
        }
        if (item != null)
        {
            o = item;
            p = MotionEvent.obtain(motionevent);
            return true;
        }
        if (true) goto _L4; else goto _L6
_L6:
        switch (motionevent.getActionMasked())
        {
        case 1: // '\001'
        default:
            return true;

        case 2: // '\002'
            continue; /* Loop/switch isn't completed */

        case 0: // '\0'
            if (k)
            {
                s.set(motionevent.getX(), motionevent.getY());
                Camera camera = c;
                PointF pointf2 = s;
                camera.a(pointf2, pointf2);
                ((BrushEditableItem)j).a(s.x, s.y, c.e);
                o = j;
                p = MotionEvent.obtain(motionevent);
            }
            Item item1 = a(s.x, s.y);
            if (item1 != null)
            {
                o = item1;
                p = MotionEvent.obtain(motionevent);
                return true;
            }
            break;
        }
        continue; /* Loop/switch isn't completed */
        if (j == null || !k) goto _L4; else goto _L7
_L7:
        BrushEditableItem brusheditableitem1 = (BrushEditableItem)j;
        motionevent.getX();
        motionevent.getY();
        brusheditableitem1.d();
        return true;
        if (true) goto _L4; else goto _L8
_L8:
    }

    public void setBrushMode(boolean flag)
    {
        boolean flag1;
        if (!flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        setBrushMode(flag, flag1);
    }

    public void setBrushMode(boolean flag, boolean flag1)
    {
        byte byte0;
        if (flag1)
        {
            byte0 = 2;
        } else
        {
            byte0 = 1;
        }
        setLayerType(byte0, null);
        k = flag;
    }

    public void setColorSelectedListener(com.socialin.android.colorpicker.c c1)
    {
        w = c1;
    }

    public void setEyeDropperActive(boolean flag)
    {
        l = flag;
        if (!l && y != null && !y.isRecycled())
        {
            y.recycle();
        }
    }

    public void setSelectedItem(Item item)
    {
        boolean flag;
        if (item != j)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        j = item;
        if (j == null)
        {
            m = null;
        } else
        {
            i.remove(j);
            i.add(j);
            m = j.a(getResources());
        }
        if (flag)
        {
            for (item = r.iterator(); item.hasNext(); ((h)item.next()).a(j)) { }
        }
    }

    private class SavedState extends UserSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public final Object createFromParcel(Parcel parcel)
            {
                return new SavedState(parcel);
            }

            public final volatile Object[] newArray(int i1)
            {
                return new SavedState[i1];
            }

        };
        private List b;
        private int c;
        private boolean d;

        static List a(SavedState savedstate)
        {
            return savedstate.b;
        }

        static int b(SavedState savedstate)
        {
            return savedstate.c;
        }

        static boolean c(SavedState savedstate)
        {
            return savedstate.d;
        }

        public void writeToParcel(Parcel parcel, int i1)
        {
            super.writeToParcel(parcel, i1);
            parcel.writeParcelableArray((Parcelable[])b.toArray(new Item[b.size()]), i1);
            parcel.writeInt(c);
            if (d)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            parcel.writeInt(i1);
        }


        public SavedState(Parcel parcel)
        {
            super(parcel);
            Parcelable aparcelable[] = parcel.readParcelableArray(com/picsart/studio/editor/item/Item.getClassLoader());
            boolean flag;
            if (aparcelable == null || aparcelable.length == 0)
            {
                b = new ArrayList();
            } else
            {
                b = new ArrayList(aparcelable.length);
                int j1 = aparcelable.length;
                int i1 = 0;
                while (i1 < j1) 
                {
                    Parcelable parcelable = aparcelable[i1];
                    b.add((Item)parcelable);
                    i1++;
                }
            }
            c = parcel.readInt();
            if (parcel.readInt() == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            d = flag;
        }

        public SavedState(Parcelable parcelable, ItemEditorView itemeditorview)
        {
            super(parcelable);
            b = itemeditorview.i;
            c = itemeditorview.i.indexOf(itemeditorview.j);
            d = com.picsart.studio.editor.view.ItemEditorView.c(itemeditorview);
        }
    }

}
