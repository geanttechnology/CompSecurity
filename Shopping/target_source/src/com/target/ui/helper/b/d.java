// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.b;

import com.google.a.a.e;
import com.target.mothership.model.cart.interfaces.AddToCart;
import com.target.mothership.model.cart.interfaces.SaveForLaterProduct;
import com.target.mothership.model.cart.interfaces.a.l;
import com.target.mothership.model.cart.interfaces.a.z;
import com.target.mothership.model.common.a.j;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.services.o;
import com.target.ui.helper.a;
import com.target.ui.helper.c;
import com.target.ui.service.b;
import java.util.Collections;
import java.util.List;

public class d extends com.target.ui.helper.a
{
    public static interface a
        extends c
    {

        public abstract void a(com.target.mothership.model.cart.interfaces.a.b b1);

        public abstract void a(l l1);

        public abstract void a(z z);

        public abstract void a(List list);

        public abstract void j();

        public abstract void k();

        public abstract void l();
    }


    private final b mCartDataService = com.target.ui.service.b.a();
    private final String mRequestTag = String.valueOf(hashCode());

    public d()
    {
    }

    static String a(d d1)
    {
        return d1.mRequestTag;
    }

    static boolean a(d d1, int i, c c1, j j, Guest guest, o o)
    {
        return d1.a(i, c1, j, guest, o);
    }

    static boolean b(d d1, int i, c c1, j j, Guest guest, o o)
    {
        return d1.a(i, c1, j, guest, o);
    }

    static boolean c(d d1, int i, c c1, j j, Guest guest, o o)
    {
        return d1.a(i, c1, j, guest, o);
    }

    public void a(final Guest guest, SaveForLaterProduct saveforlaterproduct, final a listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.l();
            return;
        } else
        {
            listener = new com.target.mothership.model.d() {

                final d this$0;
                final Guest val$guest;
                final a val$listener;

                public String a()
                {
                    return com.target.ui.helper.b.d.a(d.this);
                }

                public void a(AddToCart addtocart)
                {
                    listener.k();
                }

                public void a(com.target.mothership.model.cart.interfaces.a.b b1)
                {
                    if (com.target.ui.helper.b.d.a(d.this, 0, listener, b1.e(), guest, (o)c().d()))
                    {
                        return;
                    } else
                    {
                        listener.a(b1);
                        return;
                    }
                }

                public volatile void a(Object obj)
                {
                    a((AddToCart)obj);
                }

                public void b(Object obj)
                {
                    a((com.target.mothership.model.cart.interfaces.a.b)obj);
                }

            
            {
                this$0 = d.this;
                listener = a1;
                guest = guest1;
                super();
            }
            };
            mCartDataService.a(guest, saveforlaterproduct, listener);
            return;
        }
    }

    public void a(final Guest guest, final a listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.l();
            return;
        } else
        {
            listener = new com.target.mothership.model.d() {

                final d this$0;
                final Guest val$guest;
                final a val$listener;

                public String a()
                {
                    return com.target.ui.helper.b.d.a(d.this);
                }

                public void a(l l1)
                {
                    if (com.target.ui.helper.b.d.c(d.this, 60, listener, l1.e(), guest, (o)c().d()))
                    {
                        return;
                    }
                    static class _cls4
                    {

                        static final int $SwitchMap$com$target$mothership$model$cart$interfaces$error$GetSavedForLaterListFailure$GetSavedForLaterListFailureReason[];

                        static 
                        {
                            $SwitchMap$com$target$mothership$model$cart$interfaces$error$GetSavedForLaterListFailure$GetSavedForLaterListFailureReason = new int[com.target.mothership.model.cart.interfaces.a.l.a.values().length];
                            try
                            {
                                $SwitchMap$com$target$mothership$model$cart$interfaces$error$GetSavedForLaterListFailure$GetSavedForLaterListFailureReason[com.target.mothership.model.cart.interfaces.a.l.a.ERR_SAVED_FOR_LATER_LIST_EMPTY.ordinal()] = 1;
                            }
                            catch (NoSuchFieldError nosuchfielderror) { }
                        }
                    }

                    switch (_cls4..SwitchMap.com.target.mothership.model.cart.interfaces.error.GetSavedForLaterListFailure.GetSavedForLaterListFailureReason[((com.target.mothership.model.cart.interfaces.a.l.a)l1.e()).ordinal()])
                    {
                    default:
                        listener.a(l1);
                        return;

                    case 1: // '\001'
                        listener.a(Collections.emptyList());
                        break;
                    }
                }

                public volatile void a(Object obj)
                {
                    a((List)obj);
                }

                public void a(List list)
                {
                    listener.a(list);
                }

                public void b(Object obj)
                {
                    a((l)obj);
                }

            
            {
                this$0 = d.this;
                listener = a1;
                guest = guest1;
                super();
            }
            };
            mCartDataService.b(guest, listener);
            return;
        }
    }

    public void b(final Guest guest, SaveForLaterProduct saveforlaterproduct, final a listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.l();
            return;
        } else
        {
            listener = new com.target.mothership.model.d() {

                final d this$0;
                final Guest val$guest;
                final a val$listener;

                public String a()
                {
                    return com.target.ui.helper.b.d.a(d.this);
                }

                public void a(z z1)
                {
                    if (com.target.ui.helper.b.d.b(d.this, 0, listener, z1.e(), guest, (o)c().d()))
                    {
                        return;
                    } else
                    {
                        listener.a(z1);
                        return;
                    }
                }

                public volatile void a(Object obj)
                {
                    a((Void)obj);
                }

                public void a(Void void1)
                {
                    listener.j();
                }

                public void b(Object obj)
                {
                    a((z)obj);
                }

            
            {
                this$0 = d.this;
                listener = a1;
                guest = guest1;
                super();
            }
            };
            mCartDataService.b(guest, saveforlaterproduct, listener);
            return;
        }
    }
}
