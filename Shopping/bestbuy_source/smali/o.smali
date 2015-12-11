.class final Lo;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private final a:Lah;

.field private final b:Lbg;

.field private final c:Lg;


# direct methods
.method constructor <init>(Lah;Lbg;Lg;)V
    .locals 0

    .prologue
    .line 464
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 465
    iput-object p1, p0, Lo;->a:Lah;

    .line 466
    iput-object p2, p0, Lo;->b:Lbg;

    .line 467
    iput-object p3, p0, Lo;->c:Lg;

    .line 468
    return-void
.end method


# virtual methods
.method public final run()V
    .locals 1

    .prologue
    .line 472
    const-string v0, "Running metrics flusher to remove stale metrics from memory."

    invoke-static {v0}, Lbc;->a(Ljava/lang/String;)V

    .line 474
    iget-object v0, p0, Lo;->b:Lbg;

    invoke-virtual {v0}, Lbg;->a()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lo;->c:Lg;

    invoke-virtual {v0}, Lg;->c()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 475
    :cond_0
    iget-object v0, p0, Lo;->c:Lg;

    invoke-virtual {v0}, Lg;->d()V

    .line 476
    iget-object v0, p0, Lo;->a:Lah;

    invoke-virtual {v0}, Lah;->a()V

    .line 478
    :cond_1
    return-void
.end method
