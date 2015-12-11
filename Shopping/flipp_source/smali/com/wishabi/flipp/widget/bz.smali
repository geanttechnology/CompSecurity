.class final Lcom/wishabi/flipp/widget/bz;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/wishabi/flipp/widget/eb;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/widget/bw;

.field private final b:Landroid/content/Context;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/widget/bw;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 413
    iput-object p1, p0, Lcom/wishabi/flipp/widget/bz;->a:Lcom/wishabi/flipp/widget/bw;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 414
    iput-object p2, p0, Lcom/wishabi/flipp/widget/bz;->b:Landroid/content/Context;

    .line 415
    return-void
.end method


# virtual methods
.method public final a()I
    .locals 1

    .prologue
    .line 423
    invoke-static {}, Lcom/wishabi/flipp/widget/bw;->a()I

    move-result v0

    return v0
.end method

.method public final a(Landroid/view/ViewGroup;I)Landroid/view/View;
    .locals 1

    .prologue
    .line 418
    const/4 v0, 0x0

    return-object v0
.end method

.method public final a(I)Ljava/lang/String;
    .locals 2

    .prologue
    .line 434
    packed-switch p1, :pswitch_data_0

    .line 442
    const/4 v0, 0x0

    :goto_0
    return-object v0

    .line 436
    :pswitch_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bz;->b:Landroid/content/Context;

    const v1, 0x7f0e00b8

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 438
    :pswitch_1
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bz;->b:Landroid/content/Context;

    const v1, 0x7f0e00b7

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 440
    :pswitch_2
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bz;->b:Landroid/content/Context;

    const v1, 0x7f0e00b9

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 434
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public final b()Z
    .locals 1

    .prologue
    .line 428
    const/4 v0, 0x1

    return v0
.end method

.method public final c()I
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 447
    sget-object v1, Lcom/wishabi/flipp/widget/bx;->a:[I

    iget-object v2, p0, Lcom/wishabi/flipp/widget/bz;->a:Lcom/wishabi/flipp/widget/bw;

    invoke-static {v2}, Lcom/wishabi/flipp/widget/bw;->a(Lcom/wishabi/flipp/widget/bw;)Lcom/wishabi/flipp/widget/cb;

    move-result-object v2

    invoke-virtual {v2}, Lcom/wishabi/flipp/widget/cb;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 455
    :goto_0
    :pswitch_0
    return v0

    .line 451
    :pswitch_1
    const/4 v0, 0x1

    goto :goto_0

    .line 453
    :pswitch_2
    const/4 v0, 0x2

    goto :goto_0

    .line 447
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
