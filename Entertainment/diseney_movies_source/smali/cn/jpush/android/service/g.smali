.class public final Lcn/jpush/android/service/g;
.super Ljava/lang/Object;


# static fields
.field private static a:Lcn/jpush/android/service/g;

.field private static b:Ljava/util/concurrent/ExecutorService;

.field private static f:Lcn/jpush/android/data/i;

.field private static g:Lcn/jpush/android/data/k;

.field private static final z:[Ljava/lang/String;


# instance fields
.field private c:Landroid/os/Handler;

.field private d:Landroid/content/Context;

.field private e:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 12

    const/16 v0, 0xe

    new-array v3, v0, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v1, "(T6Z\u0007?\u0011\u0017Z\u0012;]\u0015Z\u00053W2V\u0010.X4[Q"

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

    const/16 v9, 0x71

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

    const-string v1, "\u0010a.F\u0019\u0016^8T\u001d\u0014^/\\\u00173R:A\u00185_\u0018P\u001f.T)"

    const/4 v0, 0x0

    move-object v3, v4

    goto :goto_0

    :pswitch_0
    aput-object v1, v3, v2

    const/4 v2, 0x2

    const-string v1, "(T6Z\u0007?\u00117Z\u0012;]{V\u001e/_/\u0015Kz"

    const/4 v0, 0x1

    move-object v3, v4

    goto :goto_0

    :pswitch_1
    aput-object v1, v3, v2

    const/4 v2, 0x3

    const-string v1, "*^(AQ>T7T\u0008?U{\u000fQ"

    const/4 v0, 0x2

    move-object v3, v4

    goto :goto_0

    :pswitch_2
    aput-object v1, v3, v2

    const/4 v2, 0x4

    const-string v1, ".C2R\u0016?C\u0017{:3]7e\u00035R>F\u0002`\u0011"

    const/4 v0, 0x3

    move-object v3, v4

    goto :goto_0

    :pswitch_3
    aput-object v1, v3, v2

    const/4 v2, 0x5

    const-string v1, "tA>G\u001c3B(\\\u001e4\u001f\u0011e$\ty\u0004x4\tb\u001ar4"

    const/4 v0, 0x4

    move-object v3, v4

    goto :goto_0

    :pswitch_4
    aput-object v1, v3, v2

    const/4 v2, 0x6

    const-string v1, "7T(F\u0010=T"

    const/4 v0, 0x5

    move-object v3, v4

    goto :goto_0

    :pswitch_5
    aput-object v1, v3, v2

    const/4 v2, 0x7

    const-string v1, "9_u_\u0001/B3\u001b\u00104U)Z\u0018>\u001f2[\u0005?_/\u001b?\u0015e\u0012s8\u0019p\u000f|>\u0014n\tp2\u001fx\rp5\u0005a\tz)\u0003"

    const/4 v0, 0x6

    move-object v3, v4

    goto :goto_0

    :pswitch_6
    aput-object v1, v3, v2

    const/16 v2, 0x8

    const-string v1, ")T5Q\u0014(x?"

    const/4 v0, 0x7

    move-object v3, v4

    goto :goto_0

    :pswitch_7
    aput-object v1, v3, v2

    const/16 v2, 0x9

    const-string v1, ";A+|\u0015"

    const/16 v0, 0x8

    move-object v3, v4

    goto :goto_0

    :pswitch_8
    aput-object v1, v3, v2

    const/16 v2, 0xa

    const-string v1, "4^/\\\u00173R:\\\u001e4n/L\u0001?"

    const/16 v0, 0x9

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_9
    aput-object v1, v3, v2

    const/16 v2, 0xb

    const-string v1, "9]>T\u0003zP7YQ6^8T\u001dz_4A\u0018<X8T\u00053^5\u0015"

    const/16 v0, 0xa

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_a
    aput-object v1, v3, v2

    const/16 v2, 0xc

    const-string v1, ";U?\u0015=5R:Y?5E2S\u00189P/\\\u001e4"

    const/16 v0, 0xb

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_b
    aput-object v1, v3, v2

    const/16 v2, 0xd

    const-string v1, "3_2AQ\u0016^8T\u001d\u0014^/\\\u00173R:A\u00185_{V\u0010)E{P\t*Ea"

    const/16 v0, 0xc

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_c
    aput-object v1, v3, v2

    sput-object v4, Lcn/jpush/android/service/g;->z:[Ljava/lang/String;

    const/4 v0, 0x0

    sput-object v0, Lcn/jpush/android/service/g;->a:Lcn/jpush/android/service/g;

    invoke-static {}, Ljava/util/concurrent/Executors;->newSingleThreadExecutor()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    sput-object v0, Lcn/jpush/android/service/g;->b:Ljava/util/concurrent/ExecutorService;

    const/4 v0, 0x0

    sput-object v0, Lcn/jpush/android/service/g;->f:Lcn/jpush/android/data/i;

    new-instance v0, Lcn/jpush/android/data/k;

    invoke-direct {v0}, Lcn/jpush/android/data/k;-><init>()V

    sput-object v0, Lcn/jpush/android/service/g;->g:Lcn/jpush/android/data/k;

    return-void

    :pswitch_d
    const/16 v9, 0x5a

    goto/16 :goto_2

    :pswitch_e
    const/16 v9, 0x31

    goto/16 :goto_2

    :pswitch_f
    const/16 v9, 0x5b

    goto/16 :goto_2

    :pswitch_10
    const/16 v9, 0x35

    goto/16 :goto_2

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_d
        :pswitch_e
        :pswitch_f
        :pswitch_10
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
        :pswitch_7
        :pswitch_8
        :pswitch_9
        :pswitch_a
        :pswitch_b
        :pswitch_c
    .end packed-switch
.end method

.method private constructor <init>(Landroid/content/Context;)V
    .locals 2

    const/4 v0, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcn/jpush/android/service/g;->c:Landroid/os/Handler;

    iput-object v0, p0, Lcn/jpush/android/service/g;->d:Landroid/content/Context;

    const-string v0, ""

    iput-object v0, p0, Lcn/jpush/android/service/g;->e:Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v0, p0, Lcn/jpush/android/service/g;->c:Landroid/os/Handler;

    iput-object p1, p0, Lcn/jpush/android/service/g;->d:Landroid/content/Context;

    iget-object v0, p0, Lcn/jpush/android/service/g;->d:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcn/jpush/android/service/g;->e:Ljava/lang/String;

    return-void
.end method

.method static synthetic a(Lcn/jpush/android/service/g;)Landroid/content/Context;
    .locals 1

    iget-object v0, p0, Lcn/jpush/android/service/g;->d:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic a()Lcn/jpush/android/data/i;
    .locals 1

    sget-object v0, Lcn/jpush/android/service/g;->f:Lcn/jpush/android/data/i;

    return-object v0
.end method

.method static synthetic a(Lcn/jpush/android/data/i;)Lcn/jpush/android/data/i;
    .locals 0

    sput-object p0, Lcn/jpush/android/service/g;->f:Lcn/jpush/android/data/i;

    return-object p0
.end method

.method public static a(Landroid/content/Context;)Lcn/jpush/android/service/g;
    .locals 1

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    sget-object v0, Lcn/jpush/android/service/g;->a:Lcn/jpush/android/service/g;

    if-nez v0, :cond_0

    new-instance v0, Lcn/jpush/android/service/g;

    invoke-direct {v0, p0}, Lcn/jpush/android/service/g;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcn/jpush/android/service/g;->a:Lcn/jpush/android/service/g;

    :cond_0
    sget-object v0, Lcn/jpush/android/service/g;->a:Lcn/jpush/android/service/g;

    return-object v0
.end method

.method private a(JJ)V
    .locals 4

    const-wide/16 v1, 0x0

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    cmp-long v0, p1, v1

    if-gez v0, :cond_1

    invoke-static {}, Lcn/jpush/android/util/x;->f()V

    :cond_0
    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Lcn/jpush/android/service/g;->c:Landroid/os/Handler;

    if-eqz v0, :cond_0

    new-instance v0, Lcn/jpush/android/service/i;

    invoke-direct {v0, p0, p1, p2}, Lcn/jpush/android/service/i;-><init>(Lcn/jpush/android/service/g;J)V

    cmp-long v1, p3, v1

    if-gtz v1, :cond_2

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    iget-object v1, p0, Lcn/jpush/android/service/g;->c:Landroid/os/Handler;

    invoke-virtual {v1, v0}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_0

    :cond_2
    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/g;->z:[Ljava/lang/String;

    const/4 v3, 0x3

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p3, p4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    iget-object v1, p0, Lcn/jpush/android/service/g;->c:Landroid/os/Handler;

    invoke-virtual {v1, v0, p3, p4}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_0
.end method

.method private a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 4

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    new-instance v0, Landroid/content/Intent;

    sget-object v1, Lcn/jpush/android/service/g;->z:[Ljava/lang/String;

    const/4 v2, 0x7

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    sget-object v1, Lcn/jpush/android/service/g;->z:[Ljava/lang/String;

    const/16 v2, 0x8

    aget-object v1, v1, v2

    invoke-virtual {v0, v1, p4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    sget-object v1, Lcn/jpush/android/service/g;->z:[Ljava/lang/String;

    const/16 v2, 0x9

    aget-object v1, v1, v2

    invoke-virtual {v0, v1, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    sget-object v1, Lcn/jpush/android/service/g;->z:[Ljava/lang/String;

    const/4 v2, 0x6

    aget-object v1, v1, v2

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    sget-object v1, Lcn/jpush/android/service/g;->z:[Ljava/lang/String;

    const/16 v2, 0xa

    aget-object v1, v1, v2

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    invoke-virtual {v0, p3}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Lcn/jpush/android/service/g;->z:[Ljava/lang/String;

    const/4 v3, 0x5

    aget-object v2, v2, v3

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->sendOrderedBroadcast(Landroid/content/Intent;Ljava/lang/String;)V

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    return-void
.end method

.method static synthetic a(Lcn/jpush/android/service/g;Landroid/content/Context;)V
    .locals 12

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    const/4 v1, 0x0

    :try_start_0
    sget-object v0, Lcn/jpush/android/service/g;->f:Lcn/jpush/android/data/i;

    if-nez v0, :cond_0

    new-instance v0, Lcn/jpush/android/data/i;

    invoke-direct {v0, p1}, Lcn/jpush/android/data/i;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcn/jpush/android/service/g;->f:Lcn/jpush/android/data/i;

    :cond_0
    sget-object v0, Lcn/jpush/android/service/g;->f:Lcn/jpush/android/data/i;

    invoke-virtual {v0}, Lcn/jpush/android/data/i;->a()V

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    sget-object v0, Lcn/jpush/android/service/g;->f:Lcn/jpush/android/data/i;

    const/4 v4, 0x1

    invoke-virtual {v0, v4, v2, v3}, Lcn/jpush/android/data/i;->a(IJ)Landroid/database/Cursor;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v11

    :try_start_1
    invoke-interface {v11}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_2

    :cond_1
    sget-object v0, Lcn/jpush/android/service/g;->f:Lcn/jpush/android/data/i;

    sget-object v0, Lcn/jpush/android/service/g;->g:Lcn/jpush/android/data/k;

    invoke-static {v11, v0}, Lcn/jpush/android/data/i;->a(Landroid/database/Cursor;Lcn/jpush/android/data/k;)V

    sget-object v0, Lcn/jpush/android/service/g;->g:Lcn/jpush/android/data/k;

    invoke-virtual {v0}, Lcn/jpush/android/data/k;->d()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcn/jpush/android/service/g;->e:Ljava/lang/String;

    const-string v2, ""

    invoke-direct {p0, p1, v0, v1, v2}, Lcn/jpush/android/service/g;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v0, Lcn/jpush/android/service/g;->f:Lcn/jpush/android/data/i;

    sget-object v1, Lcn/jpush/android/service/g;->g:Lcn/jpush/android/data/k;

    invoke-virtual {v1}, Lcn/jpush/android/data/k;->a()I

    move-result v1

    int-to-long v1, v1

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    sget-object v6, Lcn/jpush/android/service/g;->g:Lcn/jpush/android/data/k;

    invoke-virtual {v6}, Lcn/jpush/android/data/k;->d()Ljava/lang/String;

    move-result-object v6

    sget-object v7, Lcn/jpush/android/service/g;->g:Lcn/jpush/android/data/k;

    invoke-virtual {v7}, Lcn/jpush/android/data/k;->f()J

    move-result-wide v7

    sget-object v9, Lcn/jpush/android/service/g;->g:Lcn/jpush/android/data/k;

    invoke-virtual {v9}, Lcn/jpush/android/data/k;->e()J

    move-result-wide v9

    invoke-virtual/range {v0 .. v10}, Lcn/jpush/android/data/i;->b(JIIILjava/lang/String;JJ)Z

    invoke-interface {v11}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-nez v0, :cond_1

    :cond_2
    sget-object v0, Lcn/jpush/android/service/g;->f:Lcn/jpush/android/data/i;

    invoke-virtual {v0}, Lcn/jpush/android/data/i;->b()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    if-eqz v11, :cond_3

    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    :cond_3
    :goto_0
    return-void

    :catch_0
    move-exception v0

    :goto_1
    :try_start_2
    sget-object v2, Lcn/jpush/android/service/g;->z:[Ljava/lang/String;

    const/4 v3, 0x1

    aget-object v2, v2, v3

    new-instance v3, Ljava/lang/StringBuilder;

    sget-object v4, Lcn/jpush/android/service/g;->z:[Ljava/lang/String;

    const/4 v5, 0x4

    aget-object v4, v4, v5

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcn/jpush/android/util/x;->d(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    if-eqz v1, :cond_3

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    goto :goto_0

    :catchall_0
    move-exception v0

    move-object v11, v1

    :goto_2
    if-eqz v11, :cond_4

    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    :cond_4
    throw v0

    :catchall_1
    move-exception v0

    goto :goto_2

    :catchall_2
    move-exception v0

    move-object v11, v1

    goto :goto_2

    :catch_1
    move-exception v0

    move-object v1, v11

    goto :goto_1
.end method

.method static synthetic a(Lcn/jpush/android/service/g;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    invoke-direct {p0, p1, p2, p3, p4}, Lcn/jpush/android/service/g;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public static a(Landroid/content/Context;J)Z
    .locals 13

    const/4 v12, 0x1

    const/4 v2, 0x0

    sget-object v0, Lcn/jpush/android/service/g;->z:[Ljava/lang/String;

    aget-object v0, v0, v12

    sget-object v1, Lcn/jpush/android/service/g;->z:[Ljava/lang/String;

    aget-object v1, v1, v2

    invoke-static {v0, v1}, Lcn/jpush/android/util/x;->b(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v0, Lcn/jpush/android/service/g;->f:Lcn/jpush/android/data/i;

    if-nez v0, :cond_0

    new-instance v0, Lcn/jpush/android/data/i;

    invoke-direct {v0, p0}, Lcn/jpush/android/data/i;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcn/jpush/android/service/g;->f:Lcn/jpush/android/data/i;

    :cond_0
    const/4 v0, 0x0

    :try_start_0
    sget-object v1, Lcn/jpush/android/service/g;->f:Lcn/jpush/android/data/i;

    invoke-virtual {v1}, Lcn/jpush/android/data/i;->a()V

    sget-object v1, Lcn/jpush/android/service/g;->f:Lcn/jpush/android/data/i;

    const/4 v2, 0x0

    invoke-virtual {v1, p1, p2, v2}, Lcn/jpush/android/data/i;->a(JI)Landroid/database/Cursor;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v11

    :try_start_1
    sget-object v0, Lcn/jpush/android/service/g;->f:Lcn/jpush/android/data/i;

    sget-object v0, Lcn/jpush/android/service/g;->g:Lcn/jpush/android/data/k;

    invoke-static {v11, v0}, Lcn/jpush/android/data/i;->a(Landroid/database/Cursor;Lcn/jpush/android/data/k;)V

    sget-object v0, Lcn/jpush/android/service/g;->g:Lcn/jpush/android/data/k;

    invoke-virtual {v0}, Lcn/jpush/android/data/k;->b()I

    move-result v0

    if-lez v0, :cond_1

    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/service/g;->z:[Ljava/lang/String;

    const/4 v2, 0x2

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v1, Lcn/jpush/android/service/g;->g:Lcn/jpush/android/data/k;

    invoke-virtual {v1}, Lcn/jpush/android/data/k;->b()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    sget-object v0, Lcn/jpush/android/service/g;->f:Lcn/jpush/android/data/i;

    const/4 v3, 0x0

    const/4 v4, 0x1

    const/4 v5, 0x0

    sget-object v1, Lcn/jpush/android/service/g;->g:Lcn/jpush/android/data/k;

    invoke-virtual {v1}, Lcn/jpush/android/data/k;->d()Ljava/lang/String;

    move-result-object v6

    sget-object v1, Lcn/jpush/android/service/g;->g:Lcn/jpush/android/data/k;

    invoke-virtual {v1}, Lcn/jpush/android/data/k;->f()J

    move-result-wide v7

    sget-object v1, Lcn/jpush/android/service/g;->g:Lcn/jpush/android/data/k;

    invoke-virtual {v1}, Lcn/jpush/android/data/k;->e()J

    move-result-wide v9

    move-wide v1, p1

    invoke-virtual/range {v0 .. v10}, Lcn/jpush/android/data/i;->b(JIIILjava/lang/String;JJ)Z

    :cond_1
    sget-object v0, Lcn/jpush/android/service/g;->f:Lcn/jpush/android/data/i;

    invoke-virtual {v0}, Lcn/jpush/android/data/i;->b()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    if-eqz v11, :cond_2

    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    :cond_2
    :goto_0
    return v12

    :catch_0
    move-exception v1

    :goto_1
    if-eqz v0, :cond_2

    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    goto :goto_0

    :catchall_0
    move-exception v1

    move-object v11, v0

    move-object v0, v1

    :goto_2
    if-eqz v11, :cond_3

    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    :cond_3
    throw v0

    :catchall_1
    move-exception v0

    goto :goto_2

    :catch_1
    move-exception v0

    move-object v0, v11

    goto :goto_1
.end method

.method static synthetic b()Lcn/jpush/android/data/k;
    .locals 1

    sget-object v0, Lcn/jpush/android/service/g;->g:Lcn/jpush/android/data/k;

    return-object v0
.end method

.method static synthetic b(Lcn/jpush/android/service/g;)Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcn/jpush/android/service/g;->e:Ljava/lang/String;

    return-object v0
.end method

.method public static b(Landroid/content/Context;)V
    .locals 3

    sget-object v0, Lcn/jpush/android/service/g;->z:[Ljava/lang/String;

    const/4 v1, 0x1

    aget-object v0, v0, v1

    sget-object v1, Lcn/jpush/android/service/g;->z:[Ljava/lang/String;

    const/16 v2, 0xb

    aget-object v1, v1, v2

    invoke-static {v0, v1}, Lcn/jpush/android/util/x;->b(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v0, Lcn/jpush/android/service/g;->f:Lcn/jpush/android/data/i;

    if-nez v0, :cond_0

    new-instance v0, Lcn/jpush/android/data/i;

    invoke-direct {v0, p0}, Lcn/jpush/android/data/i;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcn/jpush/android/service/g;->f:Lcn/jpush/android/data/i;

    :cond_0
    sget-object v0, Lcn/jpush/android/service/g;->f:Lcn/jpush/android/data/i;

    invoke-virtual {v0}, Lcn/jpush/android/data/i;->a()V

    sget-object v0, Lcn/jpush/android/service/g;->f:Lcn/jpush/android/data/i;

    invoke-virtual {v0}, Lcn/jpush/android/data/i;->c()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    :cond_1
    sget-object v0, Lcn/jpush/android/service/g;->f:Lcn/jpush/android/data/i;

    invoke-virtual {v0}, Lcn/jpush/android/data/i;->b()V

    return-void
.end method


# virtual methods
.method public final a(Landroid/content/Context;Lcn/jpush/android/data/JPushLocalNotification;)Z
    .locals 14

    sget-object v0, Lcn/jpush/android/service/g;->z:[Ljava/lang/String;

    const/4 v1, 0x1

    aget-object v0, v0, v1

    sget-object v1, Lcn/jpush/android/service/g;->z:[Ljava/lang/String;

    const/16 v2, 0xc

    aget-object v1, v1, v2

    invoke-static {v0, v1}, Lcn/jpush/android/util/x;->b(Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v9

    invoke-virtual/range {p2 .. p2}, Lcn/jpush/android/data/JPushLocalNotification;->getBroadcastTime()J

    move-result-wide v0

    sub-long v12, v0, v9

    invoke-static {p1}, Lcn/jpush/android/service/ServiceInterface;->j(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    :cond_0
    sget-object v0, Lcn/jpush/android/service/g;->f:Lcn/jpush/android/data/i;

    if-nez v0, :cond_1

    new-instance v0, Lcn/jpush/android/data/i;

    invoke-direct {v0, p1}, Lcn/jpush/android/data/i;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcn/jpush/android/service/g;->f:Lcn/jpush/android/data/i;

    :cond_1
    const/4 v0, 0x0

    :try_start_0
    sget-object v1, Lcn/jpush/android/service/g;->f:Lcn/jpush/android/data/i;

    invoke-virtual {v1}, Lcn/jpush/android/data/i;->a()V

    sget-object v1, Lcn/jpush/android/service/g;->f:Lcn/jpush/android/data/i;

    invoke-virtual/range {p2 .. p2}, Lcn/jpush/android/data/JPushLocalNotification;->getNotificationId()J

    move-result-wide v2

    const/4 v4, 0x0

    invoke-virtual {v1, v2, v3, v4}, Lcn/jpush/android/data/i;->a(JI)Landroid/database/Cursor;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v11

    :try_start_1
    sget-object v0, Lcn/jpush/android/service/g;->f:Lcn/jpush/android/data/i;

    sget-object v0, Lcn/jpush/android/service/g;->g:Lcn/jpush/android/data/k;

    invoke-static {v11, v0}, Lcn/jpush/android/data/i;->a(Landroid/database/Cursor;Lcn/jpush/android/data/k;)V

    sget-object v0, Lcn/jpush/android/service/g;->g:Lcn/jpush/android/data/k;

    invoke-virtual {v0}, Lcn/jpush/android/data/k;->a()I

    move-result v0

    int-to-long v0, v0

    invoke-virtual/range {p2 .. p2}, Lcn/jpush/android/data/JPushLocalNotification;->getNotificationId()J

    move-result-wide v2

    cmp-long v0, v0, v2

    if-eqz v0, :cond_3

    sget-object v0, Lcn/jpush/android/service/g;->f:Lcn/jpush/android/data/i;

    invoke-virtual/range {p2 .. p2}, Lcn/jpush/android/data/JPushLocalNotification;->getNotificationId()J

    move-result-wide v1

    const/4 v3, 0x1

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {p2 .. p2}, Lcn/jpush/android/data/JPushLocalNotification;->toJSON()Ljava/lang/String;

    move-result-object v6

    invoke-virtual/range {p2 .. p2}, Lcn/jpush/android/data/JPushLocalNotification;->getBroadcastTime()J

    move-result-wide v7

    invoke-virtual/range {v0 .. v10}, Lcn/jpush/android/data/i;->a(JIIILjava/lang/String;JJ)J

    :goto_0
    sget-object v0, Lcn/jpush/android/service/g;->f:Lcn/jpush/android/data/i;

    invoke-virtual {v0}, Lcn/jpush/android/data/i;->b()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    if-eqz v11, :cond_2

    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    :cond_2
    :goto_1
    const-wide/32 v0, 0x493e0

    cmp-long v0, v12, v0

    if-gez v0, :cond_5

    invoke-virtual/range {p2 .. p2}, Lcn/jpush/android/data/JPushLocalNotification;->getNotificationId()J

    move-result-wide v0

    invoke-direct {p0, v0, v1, v12, v13}, Lcn/jpush/android/service/g;->a(JJ)V

    const/4 v0, 0x1

    :goto_2
    return v0

    :cond_3
    :try_start_2
    sget-object v0, Lcn/jpush/android/service/g;->f:Lcn/jpush/android/data/i;

    invoke-virtual/range {p2 .. p2}, Lcn/jpush/android/data/JPushLocalNotification;->getNotificationId()J

    move-result-wide v1

    const/4 v3, 0x1

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {p2 .. p2}, Lcn/jpush/android/data/JPushLocalNotification;->toJSON()Ljava/lang/String;

    move-result-object v6

    invoke-virtual/range {p2 .. p2}, Lcn/jpush/android/data/JPushLocalNotification;->getBroadcastTime()J

    move-result-wide v7

    invoke-virtual/range {v0 .. v10}, Lcn/jpush/android/data/i;->b(JIIILjava/lang/String;JJ)Z
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    goto :goto_0

    :catch_0
    move-exception v0

    move-object v0, v11

    :goto_3
    if-eqz v0, :cond_2

    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    goto :goto_1

    :catchall_0
    move-exception v1

    move-object v11, v0

    move-object v0, v1

    :goto_4
    if-eqz v11, :cond_4

    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    :cond_4
    throw v0

    :cond_5
    const/4 v0, 0x1

    goto :goto_2

    :catchall_1
    move-exception v0

    goto :goto_4

    :catch_1
    move-exception v1

    goto :goto_3
.end method

.method public final c(Landroid/content/Context;)V
    .locals 8

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    :try_start_0
    sget-object v0, Lcn/jpush/android/service/g;->f:Lcn/jpush/android/data/i;

    if-nez v0, :cond_0

    new-instance v0, Lcn/jpush/android/data/i;

    invoke-direct {v0, p1}, Lcn/jpush/android/data/i;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcn/jpush/android/service/g;->f:Lcn/jpush/android/data/i;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    :cond_0
    const/4 v0, 0x0

    :try_start_1
    sget-object v1, Lcn/jpush/android/service/g;->f:Lcn/jpush/android/data/i;

    invoke-virtual {v1}, Lcn/jpush/android/data/i;->a()V

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    sget-object v3, Lcn/jpush/android/service/g;->f:Lcn/jpush/android/data/i;

    const-wide/32 v4, 0x493e0

    invoke-virtual {v3, v1, v2, v4, v5}, Lcn/jpush/android/data/i;->a(JJ)Landroid/database/Cursor;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v0

    :try_start_2
    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v3

    if-eqz v3, :cond_2

    :cond_1
    sget-object v3, Lcn/jpush/android/service/g;->f:Lcn/jpush/android/data/i;

    sget-object v3, Lcn/jpush/android/service/g;->g:Lcn/jpush/android/data/k;

    invoke-static {v0, v3}, Lcn/jpush/android/data/i;->a(Landroid/database/Cursor;Lcn/jpush/android/data/k;)V

    sget-object v3, Lcn/jpush/android/service/g;->g:Lcn/jpush/android/data/k;

    invoke-virtual {v3}, Lcn/jpush/android/data/k;->a()I

    move-result v3

    int-to-long v3, v3

    sget-object v5, Lcn/jpush/android/service/g;->g:Lcn/jpush/android/data/k;

    invoke-virtual {v5}, Lcn/jpush/android/data/k;->f()J

    move-result-wide v5

    sub-long/2addr v5, v1

    invoke-direct {p0, v3, v4, v5, v6}, Lcn/jpush/android/service/g;->a(JJ)V

    invoke-interface {v0}, Landroid/database/Cursor;->moveToNext()Z

    move-result v3

    if-nez v3, :cond_1

    :cond_2
    sget-object v1, Lcn/jpush/android/service/g;->f:Lcn/jpush/android/data/i;

    invoke-virtual {v1}, Lcn/jpush/android/data/i;->b()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    if-eqz v0, :cond_3

    :try_start_3
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    :cond_3
    :goto_0
    return-void

    :catch_0
    move-exception v1

    if-eqz v0, :cond_3

    invoke-interface {v0}, Landroid/database/Cursor;->close()V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    goto :goto_0

    :catch_1
    move-exception v0

    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/g;->z:[Ljava/lang/String;

    const/16 v3, 0xd

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0

    :catchall_0
    move-exception v1

    move-object v7, v1

    move-object v1, v0

    move-object v0, v7

    :goto_1
    if-eqz v1, :cond_4

    :try_start_4
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_4
    throw v0
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_1

    :catchall_1
    move-exception v1

    move-object v7, v1

    move-object v1, v0

    move-object v0, v7

    goto :goto_1
.end method

.method public final d(Landroid/content/Context;)V
    .locals 2

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    sget-object v0, Lcn/jpush/android/service/g;->b:Ljava/util/concurrent/ExecutorService;

    new-instance v1, Lcn/jpush/android/service/h;

    invoke-direct {v1, p0, p1}, Lcn/jpush/android/service/h;-><init>(Lcn/jpush/android/service/g;Landroid/content/Context;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V

    return-void
.end method
