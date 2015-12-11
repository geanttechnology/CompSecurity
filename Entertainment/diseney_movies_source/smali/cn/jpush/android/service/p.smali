.class public final Lcn/jpush/android/service/p;
.super Ljava/lang/Object;


# static fields
.field private static final a:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final b:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static c:J

.field private static final z:[Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 12

    const/16 v0, 0x8

    new-array v3, v0, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v1, "7}?\"i\u0015}t)t\u0010|&le\rw1l+B"

    const/4 v0, -0x1

    move-object v4, v3

    :goto_0
    invoke-virtual {v1}, Ljava/lang/String;->toCharArray()[C

    move-result-object v1

    array-length v5, v1

    const/4 v6, 0x0

    const/4 v7, 0x1

    if-gt v5, v7, :cond_2

    :cond_0
    move-object v7, v1

    move v8, v6

    move v11, v5

    move-object v5, v1

    move v1, v11

    :goto_1
    aget-char v10, v5, v6

    rem-int/lit8 v9, v8, 0x5

    packed-switch v9, :pswitch_data_0

    const/4 v9, 0x6

    :goto_2
    xor-int/2addr v9, v10

    int-to-char v9, v9

    aput-char v9, v5, v6

    add-int/lit8 v6, v8, 0x1

    if-nez v1, :cond_1

    move-object v5, v7

    move v8, v6

    move v6, v1

    goto :goto_1

    :cond_1
    move v5, v1

    move-object v1, v7

    :cond_2
    if-gt v5, v6, :cond_0

    new-instance v5, Ljava/lang/String;

    invoke-direct {v5, v1}, Ljava/lang/String;-><init>([C)V

    invoke-virtual {v5}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v1

    packed-switch v0, :pswitch_data_1

    aput-object v1, v3, v2

    const/4 v2, 0x1

    const-string v1, "7}?\"i\u0015}t>c\u0012|&8&\u0001|0)&O3"

    const/4 v0, 0x0

    move-object v3, v4

    goto :goto_0

    :pswitch_0
    aput-object v1, v3, v2

    const/4 v2, 0x2

    const-string v1, "\u0010~\""

    const/4 v0, 0x1

    move-object v3, v4

    goto :goto_0

    :pswitch_1
    aput-object v1, v3, v2

    const/4 v2, 0x3

    const-string v1, "\u0003c$%b"

    const/4 v0, 0x2

    move-object v3, v4

    goto :goto_0

    :pswitch_2
    aput-object v1, v3, v2

    const/4 v2, 0x4

    const-string v1, "\u0003c$\u0013g\u0006w\u000b>k\u0014"

    const/4 v0, 0x3

    move-object v3, v4

    goto :goto_0

    :pswitch_3
    aput-object v1, v3, v2

    const/4 v2, 0x5

    const-string v1, "\u0016j$)"

    const/4 v0, 0x4

    move-object v3, v4

    goto :goto_0

    :pswitch_4
    aput-object v1, v3, v2

    const/4 v2, 0x6

    const-string v1, "\u0003p %i\u000c"

    const/4 v0, 0x5

    move-object v3, v4

    goto :goto_0

    :pswitch_5
    aput-object v1, v3, v2

    const/4 v2, 0x7

    const-string v1, "\u0003w0"

    const/4 v0, 0x6

    move-object v3, v4

    goto :goto_0

    :pswitch_6
    aput-object v1, v3, v2

    sput-object v4, Lcn/jpush/android/service/p;->z:[Ljava/lang/String;

    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    sput-object v3, Lcn/jpush/android/service/p;->a:Ljava/util/HashMap;

    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v1, "-X"

    const/4 v0, -0x1

    :goto_3
    invoke-virtual {v1}, Ljava/lang/String;->toCharArray()[C

    move-result-object v1

    array-length v4, v1

    const/4 v5, 0x0

    const/4 v6, 0x1

    if-gt v4, v6, :cond_5

    :cond_3
    move-object v6, v1

    move v7, v5

    move v11, v4

    move-object v4, v1

    move v1, v11

    :goto_4
    aget-char v9, v4, v5

    rem-int/lit8 v8, v7, 0x5

    packed-switch v8, :pswitch_data_2

    const/4 v8, 0x6

    :goto_5
    xor-int/2addr v8, v9

    int-to-char v8, v8

    aput-char v8, v4, v5

    add-int/lit8 v5, v7, 0x1

    if-nez v1, :cond_4

    move-object v4, v6

    move v7, v5

    move v5, v1

    goto :goto_4

    :pswitch_7
    const/16 v9, 0x62

    goto/16 :goto_2

    :pswitch_8
    const/16 v9, 0x13

    goto/16 :goto_2

    :pswitch_9
    const/16 v9, 0x54

    goto/16 :goto_2

    :pswitch_a
    const/16 v9, 0x4c

    goto/16 :goto_2

    :pswitch_b
    const/16 v8, 0x62

    goto :goto_5

    :pswitch_c
    const/16 v8, 0x13

    goto :goto_5

    :pswitch_d
    const/16 v8, 0x54

    goto :goto_5

    :pswitch_e
    const/16 v8, 0x4c

    goto :goto_5

    :cond_4
    move v4, v1

    move-object v1, v6

    :cond_5
    if-gt v4, v5, :cond_3

    new-instance v4, Ljava/lang/String;

    invoke-direct {v4, v1}, Ljava/lang/String;-><init>([C)V

    invoke-virtual {v4}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v1

    packed-switch v0, :pswitch_data_3

    invoke-virtual {v3, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v3, Lcn/jpush/android/service/p;->a:Ljava/util/HashMap;

    const/16 v0, -0x3e9

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v1, "\'k7)c\u0006369`\u0004v&lu\u000bi1b&2\u007f1-u\u000737#h\u0016r78&\u0011f$<i\u0010gz"

    const/4 v0, 0x0

    goto :goto_3

    :pswitch_f
    invoke-virtual {v3, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v3, Lcn/jpush/android/service/p;->a:Ljava/util/HashMap;

    const/16 v0, -0x3e8

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v1, "!|:\"c\u0001g=#hBu5%j\u0007wzlV\u000ev5?cBp<)e\t3-#s\u001037#h\u000cv78o\r}t-h\u00063&)r\u0010jt g\u0016v&m"

    const/4 v0, 0x1

    goto :goto_3

    :pswitch_10
    invoke-virtual {v3, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v3, Lcn/jpush/android/service/p;->a:Ljava/util/HashMap;

    const/16 v0, -0x3e6

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v1, "1v:(o\u000ctt*g\u000b\u007f1(&\rat8o\u000fv;9rL3\u0004 c\u0003`1lT\u0007g&5&\u000er )tC"

    const/4 v0, 0x2

    goto :goto_3

    :pswitch_11
    invoke-virtual {v3, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v3, Lcn/jpush/android/service/p;->a:Ljava/util/HashMap;

    const/16 v0, -0x3e5

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v1, "0v7)o\u0014z:+&\u0004r= c\u00063;>&\u0016z9)i\u0017gzlV\u000ev5?cBA18t\u001b38-r\u0007au"

    const/4 v0, 0x3

    goto/16 :goto_3

    :pswitch_12
    invoke-virtual {v3, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v3, Lcn/jpush/android/service/p;->a:Ljava/util/HashMap;

    const/16 v0, -0x3e4

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v1, "!|:\"c\u0001g=#hBz\'le\u000e|\')bL3\u0004 c\u0003`1lT\u0007g&5&\u000er )tC"

    const/4 v0, 0x4

    goto/16 :goto_3

    :pswitch_13
    invoke-virtual {v3, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v3, Lcn/jpush/android/service/p;->a:Ljava/util/HashMap;

    const/16 v0, -0x3e2

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v1, "0v\'<i\u000c`1lr\u000b~1#s\u0016=t\u001cj\u0007r\')&0v >\u007fB\u007f58c\u00102"

    const/4 v0, 0x5

    goto/16 :goto_3

    :pswitch_14
    invoke-virtual {v3, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v3, Lcn/jpush/android/service/p;->a:Ljava/util/HashMap;

    const/16 v0, -0x3e1

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v1, "+}\"-j\u000bwt?i\u0001x18(BC8)g\u0011vt\u001ec\u0016a-lj\u0003g1>\'"

    const/4 v0, 0x6

    goto/16 :goto_3

    :pswitch_15
    invoke-virtual {v3, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v3, Lcn/jpush/android/service/p;->a:Ljava/util/HashMap;

    const/16 v0, 0xb

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v1, "$r= c\u00063 #&\u0010v3%u\u0016v&m"

    const/4 v0, 0x7

    goto/16 :goto_3

    :pswitch_16
    invoke-virtual {v3, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v3, Lcn/jpush/android/service/p;->a:Ljava/util/HashMap;

    const/16 v0, 0x3ed

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v1, ";|!>&\u0003c$\u0007c\u001b35\"bBr:(t\rz0lv\u0003p?-a\u00073:-k\u000735>cB};8&\u000fr /n\u0007wzlV\u000ev5?cBw;9d\u000evt/n\u0007p?lr\nv9lg\u0001p;>b\u000b}3lr\r3\u0015<v\u000ez7-r\u000b|:l\u007f\rft/t\u0007r )bB|:lV\ra -jL"

    const/16 v0, 0x8

    goto/16 :goto_3

    :pswitch_17
    invoke-virtual {v3, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v3, Lcn/jpush/android/service/p;->a:Ljava/util/HashMap;

    const/16 v0, 0x3ee

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v1, ";|!lg\u000cw&#o\u00063$-e\tr3)&\u000cr9)&\u000b`t\"i\u0016314o\u0011gxlV\u000ev5?cBa1+o\u0011g1>&\u001b|!>&\u0012r7-m\u0005vt\"g\u000fvt%hBC;>r\u0003\u007fz"

    const/16 v0, 0x9

    goto/16 :goto_3

    :pswitch_18
    invoke-virtual {v3, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v3, Lcn/jpush/android/service/p;->a:Ljava/util/HashMap;

    const/16 v0, 0x3ef

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v1, "+}\"-j\u000bwt\u0005k\u0007zxlT\u0007t=?r\u0007at-a\u0003z:b"

    const/16 v0, 0xa

    goto/16 :goto_3

    :pswitch_19
    invoke-virtual {v3, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    sput-object v3, Lcn/jpush/android/service/p;->b:Ljava/util/HashMap;

    const/16 v0, 0x3e3

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v1, "/v\'?g\u0005vt\u0006U-]t<g\u0010`=\"aB`!/e\u0007v0"

    const/16 v0, 0xb

    goto/16 :goto_3

    :pswitch_1a
    invoke-virtual {v3, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v3, Lcn/jpush/android/service/p;->b:Ljava/util/HashMap;

    const/16 v0, 0x3e4

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v1, "/v\'?g\u0005vt\u0006U-]t<g\u0010`=\"aBu5%j\u0007w"

    const/16 v0, 0xc

    goto/16 :goto_3

    :pswitch_1b
    invoke-virtual {v3, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v3, Lcn/jpush/android/service/p;->b:Ljava/util/HashMap;

    const/16 v0, 0x3e5

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v1, "/v\'?g\u0005vt-j\u0010v5(\u007fBa1/c\u000be1(*Bt=:cBf$"

    const/16 v0, 0xd

    goto/16 :goto_3

    :pswitch_1c
    invoke-virtual {v3, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v3, Lcn/jpush/android/service/p;->b:Ljava/util/HashMap;

    const/16 v0, 0x3e6

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v1, "/v\'?g\u0005vt-j\u0010v5(\u007fBa1/c\u000be1(*B` %j\u000e3$>i\u0001v\'?"

    const/16 v0, 0xe

    goto/16 :goto_3

    :pswitch_1d
    invoke-virtual {v3, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v3, Lcn/jpush/android/service/p;->b:Ljava/util/HashMap;

    const/16 v0, 0x3e8

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v1, "7`1>&\u0001\u007f=/m\u0007wt-h\u00063;<c\u000cv0lr\nvt\u0001c\u0011`5+c"

    const/16 v0, 0xf

    goto/16 :goto_3

    :pswitch_1e
    invoke-virtual {v3, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v3, Lcn/jpush/android/service/p;->b:Ljava/util/HashMap;

    const/16 v0, 0x3e9

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v1, "/v\'?g\u0005vt(i\u0015}8#g\u00063\'9e\u0001v1("

    const/16 v0, 0x10

    goto/16 :goto_3

    :pswitch_1f
    invoke-virtual {v3, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v3, Lcn/jpush/android/service/p;->b:Ljava/util/HashMap;

    const/16 v0, 0x3ea

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v1, "/v\'?g\u0005vt>c\u0001v=:c\u00063\'9e\u0001v1("

    const/16 v0, 0x11

    goto/16 :goto_3

    :pswitch_20
    invoke-virtual {v3, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v3, Lcn/jpush/android/service/p;->b:Ljava/util/HashMap;

    const/16 v0, 0x3eb

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v1, "/v\'?g\u0005vt?o\u000ev:/cBw;;h\u000e|5(&\u0011f7/c\u0007w"

    const/16 v0, 0x12

    goto/16 :goto_3

    :pswitch_21
    invoke-virtual {v3, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v3, Lcn/jpush/android/service/p;->b:Ljava/util/HashMap;

    const/16 v0, 0x3ec

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v1, "4z0)iB`= c\u000cp1lb\rd: g\rwt?s\u0001p1)b"

    const/16 v0, 0x13

    goto/16 :goto_3

    :pswitch_22
    invoke-virtual {v3, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v3, Lcn/jpush/android/service/p;->b:Ljava/util/HashMap;

    const/16 v0, 0x3ed

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v1, "7`1>&\u0001\u007f=/m\u0007wt:o\u0006v;lg\u000cwt&s\u000fc1(&\u0016|t9t\u000e3\u0019)u\u0011r3)&Jq&#q\u0011v&e"

    const/16 v0, 0x14

    goto/16 :goto_3

    :pswitch_23
    invoke-virtual {v3, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v3, Lcn/jpush/android/service/p;->b:Ljava/util/HashMap;

    const/16 v0, 0x3f0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v1, "4z0)iBz\'l`\ra7)&\u0001\u007f;?c\u0006365&\u0017`1>"

    const/16 v0, 0x15

    goto/16 :goto_3

    :pswitch_24
    invoke-virtual {v3, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v3, Lcn/jpush/android/service/p;->b:Ljava/util/HashMap;

    const/16 v0, 0x3ef

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v1, "7`1>&\u0001\u007f=/m\u0007wtkI)4"

    const/16 v0, 0x16

    goto/16 :goto_3

    :pswitch_25
    invoke-virtual {v3, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v3, Lcn/jpush/android/service/p;->b:Ljava/util/HashMap;

    const/16 v0, 0x3ee

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v1, "7`1>&\u0001\u007f=/m\u0007wtkE\u0003}7)jE"

    const/16 v0, 0x17

    goto/16 :goto_3

    :pswitch_26
    invoke-virtual {v3, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v3, Lcn/jpush/android/service/p;->b:Ljava/util/HashMap;

    const/16 v0, 0x3f3

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v1, "&|#\"j\rr0l`\u0003z8)b"

    const/16 v0, 0x18

    goto/16 :goto_3

    :pswitch_27
    invoke-virtual {v3, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v3, Lcn/jpush/android/service/p;->b:Ljava/util/HashMap;

    const/16 v0, 0x3f4

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v1, "7`1>&\u0001\u007f=/m\u0007wt8iBw;;h\u000e|5(&\u0003t5%h"

    const/16 v0, 0x19

    goto/16 :goto_3

    :pswitch_28
    invoke-virtual {v3, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v3, Lcn/jpush/android/service/p;->b:Ljava/util/HashMap;

    const/16 v0, 0x3f5

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v1, "6{1l`\u000b\u007f1lg\u000ea1-b\u001b314o\u0011gt-h\u00063\'-k\u00073\'%|\u0007=t\u0008i\u000c4 lb\rd: i\u0003wt-a\u0003z:b"

    const/16 v0, 0x1a

    goto/16 :goto_3

    :pswitch_29
    invoke-virtual {v3, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v3, Lcn/jpush/android/service/p;->b:Ljava/util/HashMap;

    const/16 v0, 0x44c

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v1, "+}\"-j\u000bwt<g\u0010r9li\u00103!\"c\u001ac1/r\u0007wt>c\u0011f88("

    const/16 v0, 0x1b

    goto/16 :goto_3

    :pswitch_2a
    invoke-virtual {v3, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v3, Lcn/jpush/android/service/p;->b:Ljava/util/HashMap;

    const/16 v0, 0x3f6

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v1, "$r= c\u00063 #&\u0012a1 i\u0003wt>c\u0013f=>c\u00063&)u\rf&/c"

    const/16 v0, 0x1c

    goto/16 :goto_3

    :pswitch_2b
    invoke-virtual {v3, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v3, Lcn/jpush/android/service/p;->b:Ljava/util/HashMap;

    const/16 v0, 0x3f7

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v1, "7`1>&\u0001\u007f=/m\u0007wt%h\u0011g5 jBr8)t\u00163;\"&\u0011g58s\u001136-tBr28c\u001030#q\u000c\u007f;-b\u000b}3l`\u000b}=?n\u0007wz"

    const/16 v0, 0x1d

    goto/16 :goto_3

    :pswitch_2c
    invoke-virtual {v3, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v3, Lcn/jpush/android/service/p;->b:Ljava/util/HashMap;

    const/16 v0, 0x3f8

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v1, "7`1>&\u0001\u007f=/m\u0007wt8n\u00073#)d\u0014z1;!\u00113!>j"

    const/16 v0, 0x1e

    goto/16 :goto_3

    :pswitch_2d
    invoke-virtual {v3, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v3, Lcn/jpush/android/service/p;->b:Ljava/util/HashMap;

    const/16 v0, 0x3f9

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v1, "7`1>&\u0001\u007f=/m\u0007wt/g\u000e\u007ft-e\u0016z;\""

    const/16 v0, 0x1f

    goto/16 :goto_3

    :pswitch_2e
    invoke-virtual {v3, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v3, Lcn/jpush/android/service/p;->b:Ljava/util/HashMap;

    const/16 v0, 0x3fa

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v1, "6{1lK\u0007`\'-a\u00073\'$i\u00153=\"&\u0016{1lu\u0016r 9uBq5>"

    const/16 v0, 0x20

    goto/16 :goto_3

    :pswitch_2f
    invoke-virtual {v3, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v3, Lcn/jpush/android/service/p;->b:Ljava/util/HashMap;

    const/16 v0, 0x3fb

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v1, "!\u007f=/mBr$<j\u000b` lg\u000cwt?n\rdt8n\u00073\u0019)u\u0011r3)"

    const/16 v0, 0x21

    goto/16 :goto_3

    :pswitch_30
    invoke-virtual {v3, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v3, Lcn/jpush/android/service/p;->b:Ljava/util/HashMap;

    const/16 v0, 0x3fc

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v1, "&|#\"&\u000b~5+cBu5%j\u0007w"

    const/16 v0, 0x22

    goto/16 :goto_3

    :pswitch_31
    invoke-virtual {v3, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v3, Lcn/jpush/android/service/p;->b:Ljava/util/HashMap;

    const/16 v0, 0x3fd

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v1, "&|#\"&\ng9 &\u0004r= c\u0006"

    const/16 v0, 0x23

    goto/16 :goto_3

    :pswitch_32
    invoke-virtual {v3, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v3, Lcn/jpush/android/service/p;->b:Ljava/util/HashMap;

    const/16 v0, 0x3fe

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v1, "&|#\"&/v\'?g\u0005vt*g\u000b\u007f1("

    const/16 v0, 0x24

    goto/16 :goto_3

    :pswitch_33
    invoke-virtual {v3, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v3, Lcn/jpush/android/service/p;->b:Ljava/util/HashMap;

    const/16 v0, 0x406

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v1, "&z\'/g\u0010wt8n\u000739)u\u0011r3)&\u0000v7-s\u0011vt%rBz\'lh\rgt%hBg<)&\u0012f\'$&\u0016z9)"

    const/16 v0, 0x25

    goto/16 :goto_3

    :pswitch_34
    invoke-virtual {v3, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v3, Lcn/jpush/android/service/p;->b:Ljava/util/HashMap;

    const/16 v0, 0x407

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v1, "1g;<&\u0012f\'$&\u0011v&:o\u0001v"

    const/16 v0, 0x26

    goto/16 :goto_3

    :pswitch_35
    invoke-virtual {v3, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v3, Lcn/jpush/android/service/p;->b:Ljava/util/HashMap;

    const/16 v0, 0x408

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v1, "0v\'9k\u00073$9u\n3\')t\u0014z7)"

    const/16 v0, 0x27

    goto/16 :goto_3

    :pswitch_36
    invoke-virtual {v3, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-wide/16 v0, 0x0

    sput-wide v0, Lcn/jpush/android/service/p;->c:J

    return-void

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_7
        :pswitch_8
        :pswitch_9
        :pswitch_a
    .end packed-switch

    :pswitch_data_1
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
    .end packed-switch

    :pswitch_data_2
    .packed-switch 0x0
        :pswitch_b
        :pswitch_c
        :pswitch_d
        :pswitch_e
    .end packed-switch

    :pswitch_data_3
    .packed-switch 0x0
        :pswitch_f
        :pswitch_10
        :pswitch_11
        :pswitch_12
        :pswitch_13
        :pswitch_14
        :pswitch_15
        :pswitch_16
        :pswitch_17
        :pswitch_18
        :pswitch_19
        :pswitch_1a
        :pswitch_1b
        :pswitch_1c
        :pswitch_1d
        :pswitch_1e
        :pswitch_1f
        :pswitch_20
        :pswitch_21
        :pswitch_22
        :pswitch_23
        :pswitch_24
        :pswitch_25
        :pswitch_26
        :pswitch_27
        :pswitch_28
        :pswitch_29
        :pswitch_2a
        :pswitch_2b
        :pswitch_2c
        :pswitch_2d
        :pswitch_2e
        :pswitch_2f
        :pswitch_30
        :pswitch_31
        :pswitch_32
        :pswitch_33
        :pswitch_34
        :pswitch_35
        :pswitch_36
    .end packed-switch
.end method

.method public static a(I)Ljava/lang/String;
    .locals 3

    sget-object v0, Lcn/jpush/android/service/p;->a:Ljava/util/HashMap;

    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/service/p;->z:[Ljava/lang/String;

    const/4 v2, 0x0

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_0
    sget-object v0, Lcn/jpush/android/service/p;->a:Ljava/util/HashMap;

    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    goto :goto_0
.end method

.method public static a(Ljava/lang/String;)Lorg/json/JSONObject;
    .locals 5

    const/4 v0, 0x0

    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    :goto_0
    return-object v0

    :cond_0
    :try_start_0
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    sget-object v2, Lcn/jpush/android/service/p;->z:[Ljava/lang/String;

    const/4 v3, 0x6

    aget-object v2, v2, v3

    sget-object v3, Lcn/jpush/android/service/p;->z:[Ljava/lang/String;

    const/4 v4, 0x7

    aget-object v3, v3, v4

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    sget-object v2, Lcn/jpush/android/service/p;->z:[Ljava/lang/String;

    const/4 v3, 0x3

    aget-object v2, v2, v3

    invoke-virtual {v1, v2, p0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    sget-object v2, Lcn/jpush/android/service/p;->z:[Ljava/lang/String;

    const/4 v3, 0x5

    aget-object v2, v2, v3

    sget-object v3, Lcn/jpush/android/service/p;->z:[Ljava/lang/String;

    const/4 v4, 0x4

    aget-object v3, v3, v4

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-object v0, v1

    goto :goto_0

    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method public static b(I)Ljava/lang/String;
    .locals 3

    sget-object v0, Lcn/jpush/android/service/p;->b:Ljava/util/HashMap;

    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/service/p;->z:[Ljava/lang/String;

    const/4 v2, 0x1

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    const-string v0, ""

    :goto_0
    return-object v0

    :cond_0
    sget-object v0, Lcn/jpush/android/service/p;->b:Ljava/util/HashMap;

    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    goto :goto_0
.end method

.method public static b(Ljava/lang/String;)Lorg/json/JSONObject;
    .locals 5

    const/4 v0, 0x0

    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    :goto_0
    return-object v0

    :cond_0
    :try_start_0
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    sget-object v2, Lcn/jpush/android/service/p;->z:[Ljava/lang/String;

    const/4 v3, 0x6

    aget-object v2, v2, v3

    sget-object v3, Lcn/jpush/android/service/p;->z:[Ljava/lang/String;

    const/4 v4, 0x2

    aget-object v3, v3, v4

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    sget-object v2, Lcn/jpush/android/service/p;->z:[Ljava/lang/String;

    const/4 v3, 0x3

    aget-object v2, v2, v3

    invoke-virtual {v1, v2, p0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    sget-object v2, Lcn/jpush/android/service/p;->z:[Ljava/lang/String;

    const/4 v3, 0x5

    aget-object v2, v2, v3

    sget-object v3, Lcn/jpush/android/service/p;->z:[Ljava/lang/String;

    const/4 v4, 0x4

    aget-object v3, v3, v4

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-object v0, v1

    goto :goto_0

    :catch_0
    move-exception v1

    goto :goto_0
.end method
