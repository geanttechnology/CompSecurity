.class final Lcom/a/b/at;
.super Landroid/os/Handler;
.source "SourceFile"


# instance fields
.field private final a:Lcom/a/b/as;


# direct methods
.method public constructor <init>(Landroid/os/Looper;Lcom/a/b/as;)V
    .locals 0

    .prologue
    .line 116
    invoke-direct {p0, p1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 117
    iput-object p2, p0, Lcom/a/b/at;->a:Lcom/a/b/as;

    .line 118
    return-void
.end method


# virtual methods
.method public final handleMessage(Landroid/os/Message;)V
    .locals 6

    .prologue
    const-wide/16 v4, 0x1

    .line 121
    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_0

    .line 135
    sget-object v0, Lcom/a/b/ad;->a:Landroid/os/Handler;

    new-instance v1, Lcom/a/b/au;

    invoke-direct {v1, p0, p1}, Lcom/a/b/au;-><init>(Lcom/a/b/at;Landroid/os/Message;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 141
    :goto_0
    return-void

    .line 123
    :pswitch_0
    iget-object v0, p0, Lcom/a/b/at;->a:Lcom/a/b/as;

    iget-wide v2, v0, Lcom/a/b/as;->d:J

    add-long/2addr v2, v4

    iput-wide v2, v0, Lcom/a/b/as;->d:J

    goto :goto_0

    .line 126
    :pswitch_1
    iget-object v0, p0, Lcom/a/b/at;->a:Lcom/a/b/as;

    iget-wide v2, v0, Lcom/a/b/as;->e:J

    add-long/2addr v2, v4

    iput-wide v2, v0, Lcom/a/b/as;->e:J

    goto :goto_0

    .line 129
    :pswitch_2
    iget-object v0, p0, Lcom/a/b/at;->a:Lcom/a/b/as;

    iget v1, p1, Landroid/os/Message;->arg1:I

    int-to-long v2, v1

    iget v1, v0, Lcom/a/b/as;->j:I

    add-int/lit8 v1, v1, 0x1

    iput v1, v0, Lcom/a/b/as;->j:I

    iget-wide v4, v0, Lcom/a/b/as;->f:J

    add-long/2addr v2, v4

    iput-wide v2, v0, Lcom/a/b/as;->f:J

    iget v1, v0, Lcom/a/b/as;->j:I

    iget-wide v2, v0, Lcom/a/b/as;->f:J

    int-to-long v4, v1

    div-long/2addr v2, v4

    iput-wide v2, v0, Lcom/a/b/as;->h:J

    goto :goto_0

    .line 132
    :pswitch_3
    iget-object v0, p0, Lcom/a/b/at;->a:Lcom/a/b/as;

    iget v1, p1, Landroid/os/Message;->arg1:I

    int-to-long v2, v1

    iget v1, v0, Lcom/a/b/as;->k:I

    add-int/lit8 v1, v1, 0x1

    iput v1, v0, Lcom/a/b/as;->k:I

    iget-wide v4, v0, Lcom/a/b/as;->g:J

    add-long/2addr v2, v4

    iput-wide v2, v0, Lcom/a/b/as;->g:J

    iget v1, v0, Lcom/a/b/as;->j:I

    iget-wide v2, v0, Lcom/a/b/as;->g:J

    int-to-long v4, v1

    div-long/2addr v2, v4

    iput-wide v2, v0, Lcom/a/b/as;->i:J

    goto :goto_0

    .line 121
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method
