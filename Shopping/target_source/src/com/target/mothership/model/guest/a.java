// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest;

import com.google.a.a.e;
import com.target.mothership.common.params.AddressParams;
import com.target.mothership.common.tender.PaymentTender;
import com.target.mothership.model.common.GuestAddress;
import com.target.mothership.model.guest.handler.d;
import com.target.mothership.model.guest.handler.f;
import com.target.mothership.model.guest.handler.h;
import com.target.mothership.model.guest.handler.i;
import com.target.mothership.model.guest.handler.k;
import com.target.mothership.model.guest.handler.p;
import com.target.mothership.model.guest.handler.q;
import com.target.mothership.model.guest.handler.r;
import com.target.mothership.model.guest.handler.s;
import com.target.mothership.model.guest.handler.t;
import com.target.mothership.model.guest.handler.u;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.services.apigee.f.a.c;
import com.target.mothership.services.apigee.f.a.g;
import com.target.mothership.services.apigee.f.a.j;
import com.target.mothership.services.apigee.f.a.l;
import com.target.mothership.services.apigee.f.c.b;
import com.target.mothership.services.x;
import java.util.HashSet;
import java.util.Iterator;

// Referenced classes of package com.target.mothership.model.guest:
//            GuestDataSource, b

class com.target.mothership.model.guest.a extends GuestDataSource
{
    private final class a extends com.target.mothership.model.h
    {

        private com.target.mothership.model.h postCallback;
        final com.target.mothership.model.guest.a this$0;

        static com.target.mothership.model.h a(a a1)
        {
            return a1.postCallback;
        }

        public String a()
        {
            return postCallback.a();
        }

        public void a(Guest guest)
        {
            com.target.mothership.model.guest.a.b(com.target.mothership.model.guest.a.this, guest);
            com.target.mothership.model.guest.a.a(com.target.mothership.model.guest.a.this, guest, new com.target.mothership.model.h() {

                final a this$1;

                public void a(Guest guest)
                {
                    a.a(a.this).a(guest);
                }

                public void a(x x1)
                {
                    a.a(a.this).a(x1);
                }

                public volatile void a(Object obj)
                {
                    a((Guest)obj);
                }

                public void b(Object obj)
                {
                    a((x)obj);
                }

            
            {
                this$1 = a.this;
                super();
            }
            });
        }

        public void a(x x1)
        {
            com.target.mothership.model.guest.a.this.b(postCallback);
        }

        public volatile void a(Object obj)
        {
            a((Guest)obj);
        }

        public void b(Object obj)
        {
            a((x)obj);
        }

        a(com.target.mothership.model.h h1)
        {
            this$0 = com.target.mothership.model.guest.a.this;
            super();
            postCallback = h1;
        }
    }

    private final class b extends com.target.mothership.model.h
    {

        private com.target.mothership.model.h mReceiver;
        final com.target.mothership.model.guest.a this$0;

        static com.target.mothership.model.h a(b b1)
        {
            return b1.mReceiver;
        }

        public String a()
        {
            return mReceiver.a();
        }

        public void a(Guest guest)
        {
            com.target.mothership.model.guest.a.a(com.target.mothership.model.guest.a.this, guest, new com.target.mothership.model.h() {

                final b this$1;

                public void a(Guest guest)
                {
                    b.a(b.this).a(guest);
                }

                public void a(x x1)
                {
                    b.a(b.this).a(x1);
                }

                public volatile void a(Object obj)
                {
                    a((Guest)obj);
                }

                public void b(Object obj)
                {
                    a((x)obj);
                }

            
            {
                this$1 = b.this;
                super();
            }
            });
        }

        public void a(x x1)
        {
            mReceiver.a(x1);
        }

        public volatile void a(Object obj)
        {
            a((Guest)obj);
        }

        public void b(Object obj)
        {
            a((x)obj);
        }

        public b(com.target.mothership.model.h h1)
        {
            this$0 = com.target.mothership.model.guest.a.this;
            super();
            mReceiver = h1;
        }
    }

    private final class c extends com.target.mothership.model.d
    {

        private com.target.mothership.model.d postCallback;
        final com.target.mothership.model.guest.a this$0;

        static com.target.mothership.model.d a(c c1)
        {
            return c1.postCallback;
        }

        public String a()
        {
            return postCallback.a();
        }

        public void a(Guest guest)
        {
            com.target.mothership.model.guest.a.b(com.target.mothership.model.guest.a.this, guest);
            com.target.mothership.model.guest.a.a(com.target.mothership.model.guest.a.this, guest, new com.target.mothership.model.h() {

                final c this$1;

                public void a(Guest guest)
                {
                    c.a(c.this).a(guest);
                }

                public void a(x x1)
                {
                }

                public volatile void a(Object obj)
                {
                    a((Guest)obj);
                }

                public void b(Object obj)
                {
                    a((x)obj);
                }

            
            {
                this$1 = c.this;
                super();
            }
            });
        }

        public void a(com.target.mothership.model.guest.interfaces.a.c c1)
        {
            postCallback.b(c1);
        }

        public volatile void a(Object obj)
        {
            a((Guest)obj);
        }

        public void b(Object obj)
        {
            a((com.target.mothership.model.guest.interfaces.a.c)obj);
        }

        c(com.target.mothership.model.d d1)
        {
            this$0 = com.target.mothership.model.guest.a.this;
            super();
            postCallback = d1;
        }
    }

    private final class d extends com.target.mothership.model.h
    {

        private com.target.mothership.model.h mPostCallback;
        final com.target.mothership.model.guest.a this$0;

        public String a()
        {
            return mPostCallback.a();
        }

        public void a(Guest guest)
        {
            if (com.target.mothership.model.guest.a.a(com.target.mothership.model.guest.a.this, guest))
            {
                guest = com.google.a.a.e.b(guest);
            } else
            {
                guest = com.google.a.a.e.e();
            }
            mPostCallback.a(guest);
        }

        public void a(x x1)
        {
            mPostCallback.a(x1);
        }

        public volatile void a(Object obj)
        {
            a((Guest)obj);
        }

        public void b(Object obj)
        {
            a((x)obj);
        }

        d(com.target.mothership.model.h h1)
        {
            this$0 = com.target.mothership.model.guest.a.this;
            super();
            mPostCallback = h1;
        }
    }

    private final class e extends com.target.mothership.model.h
    {

        private final String accountName;
        private final String password;
        private com.target.mothership.model.d postCallback;
        final com.target.mothership.model.guest.a this$0;

        static com.target.mothership.model.d a(e e1)
        {
            return e1.postCallback;
        }

        static String b(e e1)
        {
            return e1.accountName;
        }

        static String c(e e1)
        {
            return e1.password;
        }

        public String a()
        {
            return postCallback.a();
        }

        public void a(Guest guest)
        {
            if (com.target.mothership.model.guest.a.a(com.target.mothership.model.guest.a.this, guest) && guest.isAnonymous())
            {
                com.target.mothership.model.guest.a.this.b(guest, accountName, password, guest. new com.target.mothership.model.d() {

                    final e this$1;
                    final Guest val$cachedSession;

                    public void a(Guest guest)
                    {
                        e.a(e.this).a(guest);
                    }

                    public void a(com.target.mothership.model.guest.interfaces.a.c c1)
                    {
                        static class _cls2
                        {

                            static final int $SwitchMap$com$target$mothership$model$guest$interfaces$error$AuthFailure$AuthFailureReason[];

                            static 
                            {
                                $SwitchMap$com$target$mothership$model$guest$interfaces$error$AuthFailure$AuthFailureReason = new int[com.target.mothership.model.guest.interfaces.a.c.a.values().length];
                                try
                                {
                                    $SwitchMap$com$target$mothership$model$guest$interfaces$error$AuthFailure$AuthFailureReason[com.target.mothership.model.guest.interfaces.a.c.a.ERR_ACCOUNT_LOCKED.ordinal()] = 1;
                                }
                                catch (NoSuchFieldError nosuchfielderror7) { }
                                try
                                {
                                    $SwitchMap$com$target$mothership$model$guest$interfaces$error$AuthFailure$AuthFailureReason[com.target.mothership.model.guest.interfaces.a.c.a.ERR_INVALID_ACCOUNT_OR_PASSWORD.ordinal()] = 2;
                                }
                                catch (NoSuchFieldError nosuchfielderror6) { }
                                try
                                {
                                    $SwitchMap$com$target$mothership$model$guest$interfaces$error$AuthFailure$AuthFailureReason[com.target.mothership.model.guest.interfaces.a.c.a.ERR_INVALID_EMAIL.ordinal()] = 3;
                                }
                                catch (NoSuchFieldError nosuchfielderror5) { }
                                try
                                {
                                    $SwitchMap$com$target$mothership$model$guest$interfaces$error$AuthFailure$AuthFailureReason[com.target.mothership.model.guest.interfaces.a.c.a.ERR_REQUIRED_FIELD_PASSWORD.ordinal()] = 4;
                                }
                                catch (NoSuchFieldError nosuchfielderror4) { }
                                try
                                {
                                    $SwitchMap$com$target$mothership$model$guest$interfaces$error$AuthFailure$AuthFailureReason[com.target.mothership.model.guest.interfaces.a.c.a.ERR_REQUIRED_FIELD_EMAIL.ordinal()] = 5;
                                }
                                catch (NoSuchFieldError nosuchfielderror3) { }
                                try
                                {
                                    $SwitchMap$com$target$mothership$model$guest$interfaces$error$AuthFailure$AuthFailureReason[com.target.mothership.model.guest.interfaces.a.c.a.ERR_TOKEN_EXPIRED.ordinal()] = 6;
                                }
                                catch (NoSuchFieldError nosuchfielderror2) { }
                                try
                                {
                                    $SwitchMap$com$target$mothership$model$guest$interfaces$error$AuthFailure$AuthFailureReason[com.target.mothership.model.guest.interfaces.a.c.a.ERR_ACCOUNT_IN_USE.ordinal()] = 7;
                                }
                                catch (NoSuchFieldError nosuchfielderror1) { }
                                try
                                {
                                    $SwitchMap$com$target$mothership$model$guest$interfaces$error$AuthFailure$AuthFailureReason[com.target.mothership.model.guest.interfaces.a.c.a.ERR_UNKNOWN.ordinal()] = 8;
                                }
                                catch (NoSuchFieldError nosuchfielderror)
                                {
                                    return;
                                }
                            }
                        }

                        switch (_cls2..SwitchMap.com.target.mothership.model.guest.interfaces.error.AuthFailure.AuthFailureReason[((com.target.mothership.model.guest.interfaces.a.c.a)c1.e()).ordinal()])
                        {
                        default:
                            com.target.mothership.model.guest.a.a(_fld0).clearGuest(cachedSession, new com.target.mothership.model.h() {

                                final e._cls1 this$2;

                                public void a(x x1)
                                {
                                    com.target.mothership.model.guest.a.a(_fld0, com.target.mothership.model.guest.e.b(_fld1), com.target.mothership.model.guest.e.c(_fld1), e.a(_fld1));
                                }

                                public volatile void a(Object obj)
                                {
                                    a((Void)obj);
                                }

                                public void a(Void void1)
                                {
                                    com.target.mothership.model.guest.a.a(_fld0, com.target.mothership.model.guest.e.b(_fld1), com.target.mothership.model.guest.e.c(_fld1), e.a(_fld1));
                                }

                                public void b(Object obj)
                                {
                                    a((x)obj);
                                }

            
            {
                this$2 = e._cls1.this;
                super();
            }
                            });
                            return;

                        case 1: // '\001'
                        case 2: // '\002'
                        case 3: // '\003'
                        case 4: // '\004'
                        case 5: // '\005'
                            e.a(e.this).b(c1);
                            break;
                        }
                    }

                    public volatile void a(Object obj)
                    {
                        a((Guest)obj);
                    }

                    public void b(Object obj)
                    {
                        a((com.target.mothership.model.guest.interfaces.a.c)obj);
                    }

            
            {
                this$1 = final_e1;
                cachedSession = Guest.this;
                super();
            }
                });
                return;
            } else
            {
                com.target.mothership.model.guest.a.a(com.target.mothership.model.guest.a.this, accountName, password, postCallback);
                return;
            }
        }

        public void a(x x1)
        {
            com.target.mothership.model.guest.a.a(com.target.mothership.model.guest.a.this, accountName, password, postCallback);
        }

        public volatile void a(Object obj)
        {
            a((Guest)obj);
        }

        public void b(Object obj)
        {
            a((x)obj);
        }

        public e(String s1, String s2, com.target.mothership.model.d d1)
        {
            this$0 = com.target.mothership.model.guest.a.this;
            super();
            postCallback = d1;
            accountName = s1;
            password = s2;
        }
    }

    private final class f extends com.target.mothership.model.h
    {

        private com.target.mothership.model.h mCallback;
        final com.target.mothership.model.guest.a this$0;

        public String a()
        {
            return mCallback.a();
        }

        public void a(Guest guest)
        {
            if (com.target.mothership.model.guest.a.a(com.target.mothership.model.guest.a.this, guest))
            {
                if (com.target.mothership.util.j.a(guest))
                {
                    d d1 = new d(mCallback);
                    com.target.mothership.model.guest.a.this.a(guest, d1);
                    return;
                }
                guest = com.google.a.a.e.b(guest);
            } else
            {
                guest = com.google.a.a.e.e();
            }
            mCallback.a(guest);
        }

        public void a(x x1)
        {
            mCallback.a(x1);
        }

        public volatile void a(Object obj)
        {
            a((Guest)obj);
        }

        public void b(Object obj)
        {
            a((x)obj);
        }

        f(com.target.mothership.model.h h1)
        {
            this$0 = com.target.mothership.model.guest.a.this;
            super();
            mCallback = h1;
        }
    }


    public static final String TAG = com/target/mothership/model/guest/b.getSimpleName();
    private com.target.mothership.services.apigee.f.c.a mAccountServices;
    private com.target.mothership.cache.guest.a mGuestAccessor;
    private com.target.mothership.services.apigee.i.c.a mOrdersV1Services;
    private com.target.mothership.services.apigee.j.c.a mOrdersV2Services;
    private com.target.mothership.services.apigee.f.c.b mPaymentServices;

    public com.target.mothership.model.guest.a()
    {
        mAccountServices = new com.target.mothership.services.apigee.f.c.a();
        mPaymentServices = new com.target.mothership.services.apigee.f.c.b();
        mOrdersV1Services = new com.target.mothership.services.apigee.i.c.a();
        mOrdersV2Services = new com.target.mothership.services.apigee.j.c.a();
        mGuestAccessor = new com.target.mothership.cache.guest.a();
    }

    static com.target.mothership.cache.guest.a a(com.target.mothership.model.guest.a a1)
    {
        return a1.mGuestAccessor;
    }

    static void a(com.target.mothership.model.guest.a a1, Guest guest, com.target.mothership.model.h h1)
    {
        a1.f(guest, h1);
    }

    static void a(com.target.mothership.model.guest.a a1, String s1, String s2, com.target.mothership.model.d d1)
    {
        a1.b(s1, s2, d1);
    }

    private void a(Guest guest)
    {
        guest = com.google.a.a.e.b(guest);
        for (Iterator iterator = sGuestChangeListeners.iterator(); iterator.hasNext(); ((b.a)iterator.next()).onGuestChanged(guest)) { }
    }

    static boolean a(com.target.mothership.model.guest.a a1, Guest guest)
    {
        return a1.b(guest);
    }

    static void b(com.target.mothership.model.guest.a a1, Guest guest)
    {
        a1.a(guest);
    }

    private void b(String s1, String s2, com.target.mothership.model.d d1)
    {
        d1 = new com.target.mothership.model.e(new k(d1));
        s1 = new g(s1, s2);
        mAccountServices.a(s1, d1);
    }

    private boolean b(Guest guest)
    {
        return guest != null && guest.getAccessToken() != null;
    }

    private void c(Guest guest, com.target.mothership.model.h h1)
    {
        h1 = new com.target.mothership.model.e(new r(new b(h1), guest));
        guest = new com.target.mothership.services.apigee.f.a.c(guest.getRefreshToken());
        mAccountServices.a(guest, h1);
    }

    private void d(Guest guest, com.target.mothership.model.h h1)
    {
        e(guest, new a(h1));
    }

    private void e(Guest guest, com.target.mothership.model.h h1)
    {
        h1 = new com.target.mothership.model.e(new com.target.mothership.model.guest.handler.b(new b(h1)));
        mAccountServices.a(guest.getAccessToken(), h1);
    }

    private void f(Guest guest, com.target.mothership.model.h h1)
    {
        mGuestAccessor.writeGuest(guest, h1);
    }

    public void a(Guest guest, int i1, com.target.mothership.model.d d1)
    {
        d1 = new com.target.mothership.model.e(new i(d1));
        mOrdersV1Services.a(guest.getAccessToken(), i1, d1);
    }

    public void a(Guest guest, AddressParams addressparams, boolean flag, com.target.mothership.model.d d1)
    {
        addressparams = (new com.target.mothership.model.guest.b.a()).a(addressparams);
        addressparams.b(flag);
        d1 = new com.target.mothership.model.e(new com.target.mothership.model.guest.handler.d(d1));
        mAccountServices.a(guest.getAccessToken(), addressparams, d1);
    }

    public void a(Guest guest, com.target.mothership.common.params.b b1, com.target.mothership.model.d d1)
    {
        b1 = new com.target.mothership.services.apigee.f.a.b(b1);
        d1 = new com.target.mothership.model.e(new q(d1));
        mPaymentServices.a(guest.getAccessToken(), b1, d1);
    }

    public void a(Guest guest, PaymentTender paymenttender, com.target.mothership.model.d d1)
    {
        d1 = new com.target.mothership.model.e(new s(d1));
        mPaymentServices.a(guest.getAccessToken(), paymenttender.a(), com.target.mothership.common.tender.c.PAYMENT_CARD.toString(), d1);
    }

    public void a(Guest guest, PaymentTender paymenttender, boolean flag, AddressParams addressparams, com.target.mothership.model.d d1)
    {
        d1 = new com.target.mothership.model.e(new u(d1));
        addressparams = new l(flag, addressparams);
        mPaymentServices.a(guest.getAccessToken(), paymenttender.a(), addressparams, d1);
    }

    public void a(Guest guest, GuestAddress guestaddress, AddressParams addressparams, boolean flag, com.target.mothership.model.d d1)
    {
        if (guestaddress.a() == null)
        {
            throw new IllegalArgumentException("The given GuestAddress has no address id");
        } else
        {
            addressparams = (new com.target.mothership.model.guest.b.a()).a(addressparams);
            addressparams.b(flag);
            d1 = new com.target.mothership.model.e(new t(d1));
            mAccountServices.a(guest.getAccessToken(), guestaddress.a(), addressparams, d1);
            return;
        }
    }

    public void a(Guest guest, GuestAddress guestaddress, com.target.mothership.model.d d1)
    {
        d1 = new com.target.mothership.model.e(new com.target.mothership.model.guest.handler.e(d1));
        mAccountServices.a(guest.getAccessToken(), guestaddress.a(), d1);
    }

    public void a(Guest guest, com.target.mothership.model.d d1)
    {
        d1 = new com.target.mothership.model.e(new com.target.mothership.model.guest.handler.f(d1));
        mAccountServices.c(guest.getAccessToken(), d1);
    }

    public void a(Guest guest, com.target.mothership.model.h h1)
    {
        if (guest.isAnonymous())
        {
            d(guest, h1);
            return;
        } else
        {
            c(guest, h1);
            return;
        }
    }

    public void a(Guest guest, String s1, com.target.mothership.model.d d1)
    {
        d1 = new com.target.mothership.model.e(new h(d1));
        mOrdersV2Services.a(guest.getAccessToken(), s1, d1);
    }

    public void a(Guest guest, String s1, String s2, com.target.mothership.model.d d1)
    {
        s1 = new com.target.mothership.services.apigee.f.a.a(s1, s2);
        s2 = new com.target.mothership.model.e(new com.target.mothership.model.guest.handler.a(d1));
        mPaymentServices.a(guest.getAccessToken(), s1, s2);
    }

    public void a(com.target.mothership.model.h h1)
    {
        h1 = new f(h1);
        mGuestAccessor.readGuest(h1);
    }

    public void a(String s1, com.target.mothership.model.h h1)
    {
        s1 = new com.target.mothership.services.apigee.f.a.i(s1);
        h1 = new com.target.mothership.model.e(new p(h1));
        mAccountServices.a(s1, h1);
    }

    public void a(String s1, String s2, com.target.mothership.model.d d1)
    {
        s1 = new e(s1, s2, new c(d1));
        mGuestAccessor.readGuest(s1);
    }

    public void a(String s1, String s2, String s3, String s4, String s5, String s6, boolean flag, 
            com.target.mothership.model.d d1)
    {
        s1 = new com.target.mothership.services.apigee.f.a.e(s1, s2, s3, s4, s5, s6, flag);
        s2 = new com.target.mothership.model.e(new com.target.mothership.model.guest.handler.c(d1));
        mAccountServices.a(s1, s2);
    }

    public void b(Guest guest, com.target.mothership.model.d d1)
    {
        d1 = new com.target.mothership.model.e(new com.target.mothership.model.guest.handler.g(d1));
        mPaymentServices.a(guest.getAccessToken(), d1);
    }

    public void b(final Guest guest, final com.target.mothership.model.h callback)
    {
        callback = new com.target.mothership.model.e(new com.target.mothership.model.g(new com.target.mothership.model.h() {

            final com.target.mothership.model.guest.a this$0;
            final com.target.mothership.model.h val$callback;
            final Guest val$guest;

            public void a(x x1)
            {
                com.target.mothership.model.guest.a.a(com.target.mothership.model.guest.a.this).clearGuest(guest, callback);
            }

            public volatile void a(Object obj)
            {
                a((Void)obj);
            }

            public void a(Void void1)
            {
                com.target.mothership.model.guest.a.a(com.target.mothership.model.guest.a.this).clearGuest(guest, callback);
            }

            public void b(Object obj)
            {
                a((x)obj);
            }

            
            {
                this$0 = com.target.mothership.model.guest.a.this;
                guest = guest1;
                callback = h1;
                super();
            }
        }));
        mAccountServices.b(guest.getAccessToken(), callback);
    }

    public void b(Guest guest, String s1, String s2, com.target.mothership.model.d d1)
    {
        d1 = new com.target.mothership.model.e(new k(d1));
        s1 = new g(s1, s2);
        mAccountServices.a(guest.getAccessToken(), s1, d1);
    }

    public void b(com.target.mothership.model.h h1)
    {
        h1 = new com.target.mothership.model.e(new com.target.mothership.model.guest.handler.b(new b(h1)));
        mAccountServices.a(h1);
    }

    public void c(Guest guest, com.target.mothership.model.d d1)
    {
        d1 = new com.target.mothership.model.e(new com.target.mothership.model.guest.handler.j(d1));
        mPaymentServices.b(guest.getAccessToken(), d1);
    }

}
