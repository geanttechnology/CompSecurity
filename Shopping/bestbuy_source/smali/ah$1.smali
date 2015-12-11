.class final Lah$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lac;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lah;
.end annotation


# instance fields
.field private synthetic a:Lah;


# direct methods
.method constructor <init>(Lah;)V
    .locals 0

    .prologue
    .line 35
    iput-object p1, p0, Lah$1;->a:Lah;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final synthetic a(Ljava/lang/Object;)V
    .locals 2

    .prologue
    .line 35
    check-cast p1, Lad;

    sget-object v0, Lah$2;->a:[I

    invoke-virtual {p1}, Lad;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    :goto_0
    return-void

    :pswitch_0
    iget-object v0, p0, Lah$1;->a:Lah;

    invoke-static {v0}, Lah;->b(Lah;)Ljava/util/concurrent/ScheduledExecutorService;

    move-result-object v0

    iget-object v1, p0, Lah$1;->a:Lah;

    invoke-static {v1}, Lah;->a(Lah;)Ljava/lang/Runnable;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/concurrent/ScheduledExecutorService;->execute(Ljava/lang/Runnable;)V

    goto :goto_0

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_0
    .end packed-switch
.end method
