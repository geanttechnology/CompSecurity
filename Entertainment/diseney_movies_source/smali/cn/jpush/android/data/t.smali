.class final Lcn/jpush/android/data/t;
.super Ljava/lang/Thread;


# static fields
.field private static final z:[Ljava/lang/String;


# instance fields
.field final synthetic a:Landroid/content/Context;

.field final synthetic b:Lcn/jpush/android/data/s;

.field final synthetic c:Lcn/jpush/android/data/s;


# direct methods
.method static constructor <clinit>()V
    .locals 14

    const/4 v2, 0x1

    const/4 v1, 0x0

    const/4 v0, 0x3

    new-array v4, v0, [Ljava/lang/String;

    const-string v3, "0;\'1Z\u000066,N_u7\'A\u000b:5\'\n\u0016=->\nE8--OExb"

    const/4 v0, -0x1

    move-object v5, v4

    move-object v6, v4

    move v4, v1

    :goto_0
    invoke-virtual {v3}, Ljava/lang/String;->toCharArray()[C

    move-result-object v3

    array-length v7, v3

    if-gt v7, v2, :cond_2

    move v8, v1

    :cond_0
    move-object v9, v3

    move v10, v8

    move v13, v7

    move-object v7, v3

    move v3, v13

    :goto_1
    aget-char v12, v7, v8

    rem-int/lit8 v11, v10, 0x5

    packed-switch v11, :pswitch_data_0

    const/16 v11, 0x2a

    :goto_2
    xor-int/2addr v11, v12

    int-to-char v11, v11

    aput-char v11, v7, v8

    add-int/lit8 v8, v10, 0x1

    if-nez v3, :cond_1

    move-object v7, v9

    move v10, v8

    move v8, v3

    goto :goto_1

    :cond_1
    move v7, v3

    move-object v3, v9

    :goto_3
    if-gt v7, v8, :cond_0

    new-instance v7, Ljava/lang/String;

    invoke-direct {v7, v3}, Ljava/lang/String;-><init>([C)V

    invoke-virtual {v7}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v3

    packed-switch v0, :pswitch_data_1

    aput-object v3, v5, v4

    const-string v0, "K=6$F"

    move-object v3, v0

    move v4, v2

    move-object v5, v6

    move v0, v1

    goto :goto_0

    :pswitch_0
    aput-object v3, v5, v4

    const/4 v3, 0x2

    const-string v0, "\u0003<.,\u0010Jz"

    move v4, v3

    move-object v5, v6

    move-object v3, v0

    move v0, v2

    goto :goto_0

    :pswitch_1
    aput-object v3, v5, v4

    sput-object v6, Lcn/jpush/android/data/t;->z:[Ljava/lang/String;

    return-void

    :pswitch_2
    const/16 v11, 0x65

    goto :goto_2

    :pswitch_3
    const/16 v11, 0x55

    goto :goto_2

    :pswitch_4
    const/16 v11, 0x42

    goto :goto_2

    :pswitch_5
    const/16 v11, 0x49

    goto :goto_2

    :cond_2
    move v8, v1

    goto :goto_3

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
    .end packed-switch

    :pswitch_data_1
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method constructor <init>(Lcn/jpush/android/data/s;Landroid/content/Context;Lcn/jpush/android/data/s;)V
    .locals 0

    iput-object p1, p0, Lcn/jpush/android/data/t;->c:Lcn/jpush/android/data/s;

    iput-object p2, p0, Lcn/jpush/android/data/t;->a:Landroid/content/Context;

    iput-object p3, p0, Lcn/jpush/android/data/t;->b:Lcn/jpush/android/data/s;

    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 11

    const/4 v10, 0x2

    const/16 v9, 0x3f6

    const/16 v8, 0x3e3

    const/4 v1, 0x1

    const/4 v2, 0x0

    iget-object v0, p0, Lcn/jpush/android/data/t;->c:Lcn/jpush/android/data/s;

    iget v0, v0, Lcn/jpush/android/data/s;->W:I

    if-ne v0, v1, :cond_2

    iget-object v0, p0, Lcn/jpush/android/data/t;->c:Lcn/jpush/android/data/s;

    iget-object v0, v0, Lcn/jpush/android/data/s;->c:Ljava/lang/String;

    iget-object v3, p0, Lcn/jpush/android/data/t;->a:Landroid/content/Context;

    invoke-static {v0, v8, v3}, Lcn/jpush/android/service/ServiceInterface;->a(Ljava/lang/String;ILandroid/content/Context;)V

    iget-object v0, p0, Lcn/jpush/android/data/t;->a:Landroid/content/Context;

    iget-object v3, p0, Lcn/jpush/android/data/t;->c:Lcn/jpush/android/data/s;

    invoke-static {v0, v3}, Lcn/jpush/android/api/m;->a(Landroid/content/Context;Lcn/jpush/android/data/d;)V

    :cond_0
    :goto_0
    iget-object v0, p0, Lcn/jpush/android/data/t;->b:Lcn/jpush/android/data/s;

    iget-object v4, v0, Lcn/jpush/android/data/s;->c:Ljava/lang/String;

    iget-object v0, p0, Lcn/jpush/android/data/t;->b:Lcn/jpush/android/data/s;

    iget-object v5, v0, Lcn/jpush/android/data/s;->a:Ljava/lang/String;

    iget-object v0, p0, Lcn/jpush/android/data/t;->c:Lcn/jpush/android/data/s;

    iget-boolean v0, v0, Lcn/jpush/android/data/s;->X:Z

    if-nez v0, :cond_4

    iget-object v0, p0, Lcn/jpush/android/data/t;->a:Landroid/content/Context;

    invoke-static {v4, v8, v0}, Lcn/jpush/android/service/ServiceInterface;->a(Ljava/lang/String;ILandroid/content/Context;)V

    iget-object v0, p0, Lcn/jpush/android/data/t;->a:Landroid/content/Context;

    iget-object v1, p0, Lcn/jpush/android/data/t;->b:Lcn/jpush/android/data/s;

    invoke-static {v0, v1}, Lcn/jpush/android/api/m;->a(Landroid/content/Context;Lcn/jpush/android/data/d;)V

    :cond_1
    :goto_1
    return-void

    :cond_2
    iget-object v0, p0, Lcn/jpush/android/data/t;->c:Lcn/jpush/android/data/s;

    iget v0, v0, Lcn/jpush/android/data/s;->W:I

    if-ne v0, v10, :cond_3

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    iget-object v0, p0, Lcn/jpush/android/data/t;->a:Landroid/content/Context;

    iget-object v3, p0, Lcn/jpush/android/data/t;->b:Lcn/jpush/android/data/s;

    invoke-static {v0, v3}, Lcn/jpush/android/api/q;->a(Landroid/content/Context;Lcn/jpush/android/data/d;)V

    goto :goto_0

    :cond_3
    iget-object v0, p0, Lcn/jpush/android/data/t;->c:Lcn/jpush/android/data/s;

    iget-object v0, v0, Lcn/jpush/android/data/s;->S:Ljava/lang/String;

    const-string v3, "0"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lcn/jpush/android/data/t;->c:Lcn/jpush/android/data/s;

    iget-object v0, v0, Lcn/jpush/android/data/s;->S:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-gt v0, v1, :cond_1

    iget-object v0, p0, Lcn/jpush/android/data/t;->c:Lcn/jpush/android/data/s;

    iget v0, v0, Lcn/jpush/android/data/s;->W:I

    if-eqz v0, :cond_0

    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/data/t;->z:[Ljava/lang/String;

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lcn/jpush/android/data/t;->c:Lcn/jpush/android/data/s;

    iget v1, v1, Lcn/jpush/android/data/s;->W:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    goto :goto_1

    :cond_4
    invoke-static {v5}, Lcn/jpush/android/data/p;->a(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_5

    const/16 v0, 0x3e4

    iget-object v1, p0, Lcn/jpush/android/data/t;->a:Landroid/content/Context;

    invoke-static {v4, v0, v1}, Lcn/jpush/android/service/ServiceInterface;->a(Ljava/lang/String;ILandroid/content/Context;)V

    goto :goto_1

    :cond_5
    const/4 v0, 0x0

    move v3, v2

    :goto_2
    const/4 v6, 0x4

    if-ge v3, v6, :cond_b

    const/4 v0, 0x5

    const-wide/16 v6, 0x1388

    invoke-static {v5, v0, v6, v7}, Lcn/jpush/android/util/n;->a(Ljava/lang/String;IJ)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcn/jpush/android/util/n;->a(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_6

    move-object v3, v0

    move v0, v1

    :goto_3
    if-nez v0, :cond_7

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    iget-object v0, p0, Lcn/jpush/android/data/t;->a:Landroid/content/Context;

    invoke-static {v4, v9, v0}, Lcn/jpush/android/service/ServiceInterface;->a(Ljava/lang/String;ILandroid/content/Context;)V

    const/16 v0, 0x3fd

    iget-object v1, p0, Lcn/jpush/android/data/t;->a:Landroid/content/Context;

    invoke-static {v1, v5}, Lcn/jpush/android/util/a;->b(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcn/jpush/android/data/t;->a:Landroid/content/Context;

    invoke-static {v4, v0, v1, v2}, Lcn/jpush/android/service/ServiceInterface;->a(Ljava/lang/String;ILjava/lang/String;Landroid/content/Context;)V

    goto :goto_1

    :cond_6
    add-int/lit8 v3, v3, 0x1

    goto :goto_2

    :cond_7
    const-string v0, "/"

    invoke-virtual {v5, v0}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    invoke-virtual {v5, v2, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lcn/jpush/android/data/t;->b:Lcn/jpush/android/data/s;

    iget-object v2, v2, Lcn/jpush/android/data/s;->Y:Ljava/util/ArrayList;

    iget-object v5, p0, Lcn/jpush/android/data/t;->a:Landroid/content/Context;

    iget-object v6, p0, Lcn/jpush/android/data/t;->b:Lcn/jpush/android/data/s;

    invoke-virtual {v6}, Lcn/jpush/android/data/s;->f()Z

    move-result v6

    invoke-static {v2, v5, v0, v4, v6}, Lcn/jpush/android/data/d;->a(Ljava/util/ArrayList;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)Z

    move-result v0

    iget-object v2, p0, Lcn/jpush/android/data/t;->c:Lcn/jpush/android/data/s;

    iget-boolean v2, v2, Lcn/jpush/android/data/s;->q:Z

    if-eqz v2, :cond_8

    if-nez v0, :cond_8

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    iget-object v0, p0, Lcn/jpush/android/data/t;->a:Landroid/content/Context;

    invoke-static {v4, v9, v0}, Lcn/jpush/android/service/ServiceInterface;->a(Ljava/lang/String;ILandroid/content/Context;)V

    goto/16 :goto_1

    :cond_8
    iget-object v0, p0, Lcn/jpush/android/data/t;->b:Lcn/jpush/android/data/s;

    invoke-virtual {v0}, Lcn/jpush/android/data/s;->f()Z

    move-result v0

    if-eqz v0, :cond_9

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcn/jpush/android/data/t;->a:Landroid/content/Context;

    invoke-static {v2, v4}, Lcn/jpush/android/util/k;->b(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v2, Lcn/jpush/android/data/t;->z:[Ljava/lang/String;

    aget-object v1, v2, v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    :goto_4
    iget-object v1, p0, Lcn/jpush/android/data/t;->a:Landroid/content/Context;

    invoke-static {v0, v3, v1}, Lcn/jpush/android/util/m;->a(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_a

    iget-object v1, p0, Lcn/jpush/android/data/t;->b:Lcn/jpush/android/data/s;

    new-instance v2, Ljava/lang/StringBuilder;

    sget-object v3, Lcn/jpush/android/data/t;->z:[Ljava/lang/String;

    aget-object v3, v3, v10

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Lcn/jpush/android/data/s;->ab:Ljava/lang/String;

    iget-object v0, p0, Lcn/jpush/android/data/t;->a:Landroid/content/Context;

    invoke-static {v4, v8, v0}, Lcn/jpush/android/service/ServiceInterface;->a(Ljava/lang/String;ILandroid/content/Context;)V

    iget-object v0, p0, Lcn/jpush/android/data/t;->c:Lcn/jpush/android/data/s;

    iget v0, v0, Lcn/jpush/android/data/s;->W:I

    if-nez v0, :cond_1

    iget-object v0, p0, Lcn/jpush/android/data/t;->a:Landroid/content/Context;

    iget-object v1, p0, Lcn/jpush/android/data/t;->b:Lcn/jpush/android/data/s;

    invoke-static {v0, v1}, Lcn/jpush/android/api/m;->a(Landroid/content/Context;Lcn/jpush/android/data/d;)V

    goto/16 :goto_1

    :cond_9
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcn/jpush/android/data/t;->a:Landroid/content/Context;

    invoke-static {v1, v4}, Lcn/jpush/android/util/k;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_4

    :cond_a
    iget-object v0, p0, Lcn/jpush/android/data/t;->a:Landroid/content/Context;

    invoke-static {v4, v9, v0}, Lcn/jpush/android/service/ServiceInterface;->a(Ljava/lang/String;ILandroid/content/Context;)V

    goto/16 :goto_1

    :cond_b
    move-object v3, v0

    move v0, v2

    goto/16 :goto_3
.end method
