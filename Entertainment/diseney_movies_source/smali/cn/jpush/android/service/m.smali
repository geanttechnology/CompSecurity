.class final Lcn/jpush/android/service/m;
.super Landroid/os/Handler;


# static fields
.field private static final z:[Ljava/lang/String;


# instance fields
.field final synthetic a:Lcn/jpush/android/service/PushService;


# direct methods
.method static constructor <clinit>()V
    .locals 15

    const/4 v3, 0x2

    const/4 v2, 0x1

    const/4 v1, 0x0

    const/4 v0, 0x4

    new-array v5, v0, [Ljava/lang/String;

    const-string v4, "u4\u0000\u0010\u001dE9\u0011\r\t\u001az\u0010\u0006\u0005A4\u0001\u0004\u0008Dz\u0008\u001b\n\u0000wE"

    const/4 v0, -0x1

    move-object v6, v5

    move-object v7, v5

    move v5, v1

    :goto_0
    invoke-virtual {v4}, Ljava/lang/String;->toCharArray()[C

    move-result-object v4

    array-length v8, v4

    if-gt v8, v2, :cond_2

    move v9, v1

    :cond_0
    move-object v10, v4

    move v11, v9

    move v14, v8

    move-object v8, v4

    move v4, v14

    :goto_1
    aget-char v13, v8, v9

    rem-int/lit8 v12, v11, 0x5

    packed-switch v12, :pswitch_data_0

    const/16 v12, 0x6d

    :goto_2
    xor-int/2addr v12, v13

    int-to-char v12, v12

    aput-char v12, v8, v9

    add-int/lit8 v9, v11, 0x1

    if-nez v4, :cond_1

    move-object v8, v10

    move v11, v9

    move v9, v4

    goto :goto_1

    :cond_1
    move v8, v4

    move-object v4, v10

    :goto_3
    if-gt v8, v9, :cond_0

    new-instance v8, Ljava/lang/String;

    invoke-direct {v8, v4}, Ljava/lang/String;-><init>([C)V

    invoke-virtual {v8}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v4

    packed-switch v0, :pswitch_data_1

    aput-object v4, v6, v5

    const-string v0, "W2\u0004\u001cM\u001dz"

    move-object v4, v0

    move v5, v2

    move-object v6, v7

    move v0, v1

    goto :goto_0

    :pswitch_0
    aput-object v4, v6, v5

    const-string v0, "t;\u0002)\u0001I;\u0016H\u000cC1E\u000e\u000cI6\u0000\u000cC\u0000)\u0000\u0019$DzXH"

    move-object v4, v0

    move v5, v3

    move-object v6, v7

    move v0, v2

    goto :goto_0

    :pswitch_1
    aput-object v4, v6, v5

    const/4 v4, 0x3

    const-string v0, "C4K\u0002\u001dU)\rF\u000cN>\u0017\u0007\u0004Dt\u000c\u0006\u0019E4\u0011F.o\u0014+-.t\u0013*&"

    move v5, v4

    move-object v6, v7

    move-object v4, v0

    move v0, v3

    goto :goto_0

    :pswitch_2
    aput-object v4, v6, v5

    sput-object v7, Lcn/jpush/android/service/m;->z:[Ljava/lang/String;

    return-void

    :pswitch_3
    const/16 v12, 0x20

    goto :goto_2

    :pswitch_4
    const/16 v12, 0x5a

    goto :goto_2

    :pswitch_5
    const/16 v12, 0x65

    goto :goto_2

    :pswitch_6
    const/16 v12, 0x68

    goto :goto_2

    :cond_2
    move v9, v1

    goto :goto_3

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
    .end packed-switch

    :pswitch_data_1
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method constructor <init>(Lcn/jpush/android/service/PushService;)V
    .locals 0

    iput-object p1, p0, Lcn/jpush/android/service/m;->a:Lcn/jpush/android/service/PushService;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public final handleMessage(Landroid/os/Message;)V
    .locals 5

    const/4 v4, 0x1

    const/4 v1, 0x0

    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_0

    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/m;->z:[Ljava/lang/String;

    aget-object v1, v2, v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v1, p1, Landroid/os/Message;->what:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->b()V

    :cond_0
    :goto_0
    return-void

    :pswitch_0
    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    iget-object v0, p0, Lcn/jpush/android/service/m;->a:Lcn/jpush/android/service/PushService;

    invoke-static {v0}, Lcn/jpush/android/service/PushService;->c(Lcn/jpush/android/service/PushService;)V

    iget-object v0, p0, Lcn/jpush/android/service/m;->a:Lcn/jpush/android/service/PushService;

    invoke-virtual {v0}, Lcn/jpush/android/service/PushService;->stopSelf()V

    iget-object v0, p0, Lcn/jpush/android/service/m;->a:Lcn/jpush/android/service/PushService;

    sget-object v2, Lcn/jpush/android/service/m;->z:[Ljava/lang/String;

    const/4 v3, 0x3

    aget-object v2, v2, v3

    invoke-virtual {v0, v1, v2}, Lcn/jpush/android/service/PushService;->a(ILjava/lang/String;)V

    goto :goto_0

    :pswitch_1
    iget-object v0, p0, Lcn/jpush/android/service/m;->a:Lcn/jpush/android/service/PushService;

    invoke-virtual {v0}, Lcn/jpush/android/service/PushService;->stopSelf()V

    goto :goto_0

    :pswitch_2
    iget-object v0, p0, Lcn/jpush/android/service/m;->a:Lcn/jpush/android/service/PushService;

    invoke-static {v0}, Lcn/jpush/android/service/PushService;->d(Lcn/jpush/android/service/PushService;)Lcn/jpush/android/service/n;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcn/jpush/android/service/m;->a:Lcn/jpush/android/service/PushService;

    invoke-static {v0}, Lcn/jpush/android/service/PushService;->d(Lcn/jpush/android/service/PushService;)Lcn/jpush/android/service/n;

    move-result-object v0

    invoke-virtual {v0}, Lcn/jpush/android/service/n;->isAlive()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcn/jpush/android/service/m;->a:Lcn/jpush/android/service/PushService;

    invoke-static {v0}, Lcn/jpush/android/service/PushService;->e(Lcn/jpush/android/service/PushService;)V

    goto :goto_0

    :pswitch_3
    iget-object v0, p0, Lcn/jpush/android/service/m;->a:Lcn/jpush/android/service/PushService;

    invoke-static {v0, v4}, Lcn/jpush/android/service/PushService;->b(Lcn/jpush/android/service/PushService;Z)V

    goto :goto_0

    :pswitch_4
    iget-object v0, p0, Lcn/jpush/android/service/m;->a:Lcn/jpush/android/service/PushService;

    invoke-static {v0, v1}, Lcn/jpush/android/service/PushService;->b(Lcn/jpush/android/service/PushService;Z)V

    goto :goto_0

    :pswitch_5
    invoke-static {}, Lcn/jpush/android/util/x;->f()V

    iget-object v0, p0, Lcn/jpush/android/service/m;->a:Lcn/jpush/android/service/PushService;

    invoke-static {v0}, Lcn/jpush/android/service/PushService;->f(Lcn/jpush/android/service/PushService;)V

    goto :goto_0

    :pswitch_6
    :try_start_0
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    :goto_1
    iget-object v1, p0, Lcn/jpush/android/service/m;->a:Lcn/jpush/android/service/PushService;

    invoke-static {v1, v0}, Lcn/jpush/android/service/PushService;->c(Lcn/jpush/android/service/PushService;I)Z

    move-result v1

    if-eqz v1, :cond_0

    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/m;->z:[Ljava/lang/String;

    const/4 v3, 0x2

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/service/m;->z:[Ljava/lang/String;

    aget-object v1, v1, v4

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p1, Landroid/os/Message;->what:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->f()V

    iget-object v0, p0, Lcn/jpush/android/service/m;->a:Lcn/jpush/android/service/PushService;

    invoke-static {v0}, Lcn/jpush/android/service/PushService;->f(Lcn/jpush/android/service/PushService;)V

    goto/16 :goto_0

    :catch_0
    move-exception v0

    move v0, v1

    goto :goto_1

    :pswitch_7
    :try_start_1
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    move-result v1

    :goto_2
    if-eqz v1, :cond_0

    invoke-static {v1}, Lcn/jpush/android/service/ServiceInterface;->a(I)Lcn/jpush/android/api/b;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v2, v0, Lcn/jpush/android/api/b;->c:Lcn/jpush/android/api/TagAliasCallback;

    if-eqz v2, :cond_1

    sget v3, Lcn/jpush/android/api/d;->b:I

    iget-object v4, v0, Lcn/jpush/android/api/b;->a:Ljava/lang/String;

    iget-object v0, v0, Lcn/jpush/android/api/b;->b:Ljava/util/Set;

    invoke-interface {v2, v3, v4, v0}, Lcn/jpush/android/api/TagAliasCallback;->gotResult(ILjava/lang/String;Ljava/util/Set;)V

    :cond_1
    invoke-static {v1}, Lcn/jpush/android/service/ServiceInterface;->b(I)V

    goto/16 :goto_0

    :catch_1
    move-exception v0

    goto :goto_2

    nop

    :pswitch_data_0
    .packed-switch 0x3e9
        :pswitch_0
        :pswitch_2
        :pswitch_1
        :pswitch_3
        :pswitch_4
        :pswitch_7
        :pswitch_5
        :pswitch_6
    .end packed-switch
.end method
